package by.it.academy.dao;

import by.it.academy.clinic.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserDao extends DAO<User> {

    Optional<User> getByUserName(String userName) throws SQLException;
}
