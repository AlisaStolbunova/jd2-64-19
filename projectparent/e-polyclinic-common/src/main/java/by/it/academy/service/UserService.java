package by.it.academy.service;


import by.it.academy.clinic.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUser(String login, String password);
}
