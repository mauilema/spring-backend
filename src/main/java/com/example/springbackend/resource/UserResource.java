package com.example.springbackend.resource;

import com.example.springbackend.model.User;
import com.example.springbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {
    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

//    @GetMapping("/user")
//    public User getUser(){return userService.getUser();}
//
//
//    @GetMapping("/user/{userId}")
//    public User getUserById(@PathVariable("userId") int userId) {
//        return UserService.getUserById(userId);
//    }
//
//    @PutMapping("/user/{userId}")
//    public User updateUserById(@PathVariable("userId") int userId, @RequestBody User user) {
//        return UserService.updateUserById(userId, user);
//    }
//
//    @DeleteMapping("/user")
//    public User deleteUser(@RequestParam(name = "userId") int userId) {
//        return UserService.deleteUser(userId);
//    }
}
