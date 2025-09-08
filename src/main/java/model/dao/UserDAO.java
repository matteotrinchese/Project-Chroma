package model.dao;

import model.dto.User;
import model.dto.enums.Role;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserDAO implements GenericDAO<User, Integer> {

    private static final String TABLE_NAME = "User";
    private final DataSource ds;

    public UserDAO(DataSource ds) {
        this.ds = Objects.requireNonNull(ds, "DataSource cannot be null.");
    }

    @Override
    public void doSave(User user) throws SQLException {
        String sql = "INSERT INTO" + TABLE_NAME + "(Username, Email, PasswordHash, Role, isActive) VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = ds.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getHashPassword());
            ps.setBoolean(4, user.isActive());

            ps.executeUpdate();
        }
    }

    @Override
    public void doUpdate(User user) throws SQLException {
        String sql = "UPDATE" + TABLE_NAME + "SET Username = ?, Email = ?, PasswordHash = ?, Role = ?, LastLogin = ?, isActive = ? WHERE ID = ?";

        try(Connection conn = ds.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getHashPassword());
            ps.setString(4, user.getRole().toString());
            ps.setTimestamp(5, user.getLastLogin());
            ps.setBoolean(6, user.isActive());
            ps.setInt(7, user.getID());

            ps.executeUpdate();
        }
    }

    @Override
    public void doDelete(Integer id) throws SQLException {
        String sql = "DELETE FROM" + TABLE_NAME + "WHERE ID = ?";

        try(Connection conn = ds.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public User findById(Integer id) throws SQLException {
        String sql = "SELECT * FROM" + TABLE_NAME + "WHERE ID = ?";
        User user = null;

        try(Connection conn = ds.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setID(rs.getInt("ID"));
                    user.setUsername(rs.getString("Username"));
                    user.setEmail(rs.getString("Email"));
                    user.setHashPassword(rs.getString("PasswordHash"));
                    user.setRole(Role.fromString(rs.getString("Role")));
                    user.setCreatedAt(rs.getTimestamp("CreatedAt"));
                    user.setLastLogin(rs.getTimestamp("LastLogin"));
                    user.setActive(rs.getBoolean("Active"));
                }
            }
        }

        return user;
    }

    @Override
    public Collection<User> findAll() throws SQLException {
        String sql = "SELECT * FROM" + TABLE_NAME;
        List<User> users = new ArrayList<>();

        try(Connection conn = ds.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getInt("ID"));
                user.setUsername(rs.getString("Username"));
                user.setEmail(rs.getString("Email"));
                user.setHashPassword(rs.getString("PasswordHash"));
                user.setRole(Role.fromString(rs.getString("Role")));
                user.setCreatedAt(rs.getTimestamp("CreatedAt"));
                user.setLastLogin(rs.getTimestamp("LastLogin"));
                user.setActive(rs.getBoolean("Active"));
                users.add(user);
            }
        }

        return users;
    }
}
