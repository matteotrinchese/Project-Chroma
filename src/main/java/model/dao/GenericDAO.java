package model.dao;

import java.sql.SQLException;
import java.util.Collection;

public interface GenericDAO<T, ID> {
    void doSave(T entity) throws SQLException;
    void doUpdate(T entity) throws SQLException;
    void doDelete(ID id) throws SQLException;
    T findById(ID id) throws SQLException;
    Collection<T> findAll() throws SQLException;
}
