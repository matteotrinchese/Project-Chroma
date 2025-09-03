package model.dao;

import model.dto.User;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class UserDAO implements GenericDAO<User, Integer> {

    @Override
    public void doSave(User user) throws SQLException {

    }

    @Override
    public void doUpdate(User entity) throws SQLException {

    }

    @Override
    public void doDelete(Integer integer) throws SQLException {

    }

    @Override
    public User findById(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public Collection<User> findAll() throws SQLException {
        return List.of();
    }
}
