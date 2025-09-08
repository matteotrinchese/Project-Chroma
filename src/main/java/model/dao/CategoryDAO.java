package model.dao;

import model.dto.Category;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CategoryDAO implements GenericDAO<Category, Integer> {

    private static final String TABLE_NAME = "Category";
    private final DataSource ds;

    public CategoryDAO(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public void doSave(Category entity) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + "(Name) VALUES (?)";

        try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, entity.getName());

            ps.executeUpdate();
        }
    }

    @Override
    public void doUpdate(Category entity) throws SQLException {
        String sql = "UPDATE " + TABLE_NAME + " SET Name = ? WHERE ID = ?";

        try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getID());
        }
    }

    @Override
    public void doDelete(Integer integer) throws SQLException {
        String  sql = "DELETE FROM " + TABLE_NAME + " WHERE ID = ?";

        try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, integer);
            ps.executeUpdate();
        }
    }

    @Override
    public Category findById(Integer integer) throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE ID = ?";
        Category category = null;

        try(Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, integer);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    category = new Category();
                    category.setID(rs.getInt("ID"));
                    category.setName(rs.getString("Name"));
                }
            }
        }

        return category;
    }

    @Override
    public Collection<Category> findAll() throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME;
        Collection<Category> categories = new ArrayList<>();

        try(Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                Category category = new Category();
                category.setID(rs.getInt("ID"));
                category.setName(rs.getString("Name"));
                categories.add(category);
            }
        }

        return categories;
    }
}
