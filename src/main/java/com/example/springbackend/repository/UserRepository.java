package com.example.springbackend.repository;

import com.example.springbackend.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    static List<User> userList = new ArrayList();

    public static User saveUser(User user) {
        user.setUserId(userList.size() + 1);
        userList.add(user);
        return user;
    }

    public static User getUserById(int userId) {
        for(User user:userList) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    public static User updateUserById(int userId, User user) {
        for (User u:userList) {
            if (u.getUserId() == userId) {
                u.setName(user.getName());
                u.setAddress(user.getAddress());
                u.setAge(user.getAge());
                return u;
            }
        }
        return null;
    }

    //double check this method.
    public static User deleteUser(int userId) {
        User deletedUser = null;
        for (User u:userList) {
            deletedUser = u;
            if (u.getUserId() == userId) {
                userList.remove(userId);
                return deletedUser;
            }
        }
        return deletedUser;
    }

    public User getUser() {
        User user = new User("Jose", "lvl 7 backend st", 27);
        return user;
    }

    public List<User> getAllUsers() {
        return userList;
    }
}
