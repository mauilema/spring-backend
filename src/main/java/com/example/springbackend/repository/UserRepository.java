package com.example.springbackend.repository;

import com.example.springbackend.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    static List<User> userList = new ArrayList();

    public static User saveUser(User user) {
        userList.add(user);
        return user;
    }

    public User getUser() {
        User user = new User("Jose", "lvl 7 backend st", 27);
        return user;
    }
}
