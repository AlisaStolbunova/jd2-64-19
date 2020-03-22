package by.it.academy.service;


import by.it.academy.clinic.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserService {

    Optional<User> findUser(String login, String password);

    Optional<User> findUserById(Long id);

    Long createUser(String userName, String password);

}
