package by.it.academy.epolyclinic.service;

import by.it.academy.epolyclinic.clinic.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUser(String login, String password);
}
