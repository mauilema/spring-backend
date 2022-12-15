package com.example.springbackend.service;

import com.example.springbackend.model.User;
import com.example.springbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public static User saveUser(User user) {
        return UserRepository.saveUser(user);
    }

    public static User getUserById(int userId) {
        return UserRepository.getUserById(userId);
    }

    public static User updateUserById(int userId, User user) {
        return UserRepository.updateUserById(userId, user);
    }

    public User getUser() {
        return userRepository.getUser();
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
