package model.dao;

import model.dto.Address;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class AddressDAO implements GenericDAO<Address, Integer> {

    private static final String TABLE_NAME = "Address";
    private final DataSource ds;

    public AddressDAO(DataSource ds) {
        this.ds = Objects.requireNonNull(ds, "DataSource cannot be null.");;
    }

    @Override
    public void doSave(Address entity) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + "(UserID, Street, City, State, PostalCode, Country, Name, Surname, Phone, isDefault)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ds.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entity.getUserID());
            ps.setString(2, entity.getStreet());
            ps.setString(3, entity.getCity());
            ps.setString(4, entity.getState());
            ps.setString(5, entity.getPostalCode());
            ps.setString(6, entity.getCountry());
            ps.setString(7, entity.getName());
            ps.setString(8, entity.getSurname());
            ps.setString(9, entity.getPhone());
            ps.setBoolean(10, entity.isDefault());

            ps.executeUpdate();
        }
    }

    @Override
    public void doUpdate(Address entity) throws SQLException {
        String sql = "UPDATE" + TABLE_NAME + "SET UserID = ?, Street = ?, City = ?, State = ?, PostalCode = ?, Country = ?,"
                + "Name = ?, Surname = ?, Phone = ?, isDefault = ? WHERE ID = ?";

        try (Connection conn = ds.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entity.getUserID());
            ps.setString(2, entity.getStreet());
            ps.setString(3, entity.getCity());
            ps.setString(4, entity.getState());
            ps.setString(5, entity.getPostalCode());
            ps.setString(6, entity.getCountry());
            ps.setString(7, entity.getName());
            ps.setString(8, entity.getSurname());
            ps.setString(9, entity.getPhone());
            ps.setBoolean(10, entity.isDefault());
            ps.setInt(11, entity.getID());

            ps.executeUpdate();
        }
    }

    @Override
    public void doDelete(Integer id) throws SQLException {
        String sql = "DELETE FROM" + TABLE_NAME + "WHERE ID = ?";

        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public Address findById(Integer id) throws SQLException {
        String sql = "SELECT * FROM" + TABLE_NAME + "WHERE ID = ?";
        Address address = null;

        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    address = new Address();
                    address.setID(rs.getInt("ID"));
                    address.setUserID(rs.getInt("UserID"));
                    address.setStreet(rs.getString("Street"));
                    address.setCity(rs.getString("City"));
                    address.setState(rs.getString("State"));
                    address.setPostalCode(rs.getString("PostalCode"));
                    address.setCountry(rs.getString("Country"));
                    address.setName(rs.getString("Name"));
                    address.setSurname(rs.getString("Surname"));
                    address.setPhone(rs.getString("Phone"));
                    address.setDefault(rs.getBoolean("isDefault"));
                }
            }
        }

        return address;
    }

    @Override
    public Collection<Address> findAll() throws SQLException {
        String sql = "SELECT * FROM Address";
        List<Address> addresses = new ArrayList<>();

        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Address address = new Address();
                address.setID(rs.getInt("ID"));
                address.setUserID(rs.getInt("UserID"));
                address.setStreet(rs.getString("Street"));
                address.setCity(rs.getString("City"));
                address.setState(rs.getString("State"));
                address.setPostalCode(rs.getString("PostalCode"));
                address.setCountry(rs.getString("Country"));
                address.setName(rs.getString("Name"));
                address.setSurname(rs.getString("Surname"));
                address.setPhone(rs.getString("Phone"));
                address.setDefault(rs.getBoolean("isDefault"));
                addresses.add(address);
            }
        }

        return addresses;
    }

    /**
     * Retrieves all addresses associated with a specific user.
     * @param userId The ID of the user.
     * @return A collection of addresses for the given user.
     * @throws SQLException If a database access error occurs.
     */
    public Collection<Address> findByUserId(int userId) throws SQLException {
        String sql = "SELECT * FROM Address WHERE UserID = ?";
        List<Address> addresses = new ArrayList<>();

        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Address address = new Address();
                    address.setID(rs.getInt("ID"));
                    address.setUserID(rs.getInt("UserID"));
                    address.setStreet(rs.getString("Street"));
                    address.setCity(rs.getString("City"));
                    address.setState(rs.getString("State"));
                    address.setPostalCode(rs.getString("PostalCode"));
                    address.setCountry(rs.getString("Country"));
                    address.setName(rs.getString("Name"));
                    address.setSurname(rs.getString("Surname"));
                    address.setPhone(rs.getString("Phone"));
                    address.setDefault(rs.getBoolean("isDefault"));
                    addresses.add(address);
                }
            }
        }

        return addresses;
    }
}
