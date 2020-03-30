package by.it.academy.service;


import by.it.academy.clinic.User;
import by.it.academy.dao.UserDao;
import by.it.academy.dao.impl.UserDaoImpl;
import by.it.academy.security.EncryptUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Optional;


public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final UserService INSTANCE = new UserServiceImpl();


    private final UserDao userDao = UserDaoImpl.getInstance();

    public static UserService getInstance() {
        return INSTANCE;
    }


    @Override
    public Optional<User> findUser(String login, String password) {
        try {
            Optional<User> userOption = userDao.getByUserName(login);
            if (userOption.isPresent()) {
                User user = userOption.get();
                String hash = EncryptUtils.getSHA256(password, user.getSalt());
                if (user.getPassword().equals(hash)) {
                    return Optional.of(user);
                }
            }
        } catch (SQLException e) {
            logger.error("Error find user by login and password " + login, e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        try {
            return userDao.read(id);
        } catch (SQLException e) {
            logger.error("Error find user by id: " + id, e);
        }
        return Optional.empty();
    }

    @Override
    public Long createUser(String userName, String password){
        Long count = 0L;
        try {
            String salt = EncryptUtils.generateSaltString();
            User user = new User(userName, EncryptUtils.getSHA256(password, salt), salt, 2);
            count = userDao.create(user);
        } catch (SQLException e) {
            logger.error("Error create user", e);
        }

        return count;
    }


}

