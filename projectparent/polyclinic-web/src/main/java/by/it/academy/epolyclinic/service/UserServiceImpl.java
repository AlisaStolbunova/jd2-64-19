package by.it.academy.epolyclinic.service;

import by.it.academy.epolyclinic.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl {

    private Map<String, User> users = new HashMap<>();

    private static final UserServiceImpl INSTANCE = new UserServiceImpl();

    public static ProductService getService() {
        return INSTANCE;
    }

    public UserServiceImpl(){
        users.put("admin", new User("admin", "123"));
    }

    public User getUser(String username, String password){
        User user = users.get(username);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        else
            return null;
    }
}
