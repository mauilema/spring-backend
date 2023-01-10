package com.example.springbackend.resource;

import com.example.springbackend.exception.RestrictedInfoException;
import com.example.springbackend.model.User;
import com.example.springbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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

    @GetMapping("/find")
    public List<User> getByAddress(@RequestParam(name = "address") String address) throws RestrictedInfoException {
        if (address.equalsIgnoreCase("area51")) {
            throw new RestrictedInfoException();
        }
        return userService.getByAddress(address);
    }

    @ExceptionHandler(RestrictedInfoException.class)
    public String restrictedInfoError(RestrictedInfoException ex) {
        return ex.getMessage();
    }

    @GetMapping("/find-by-id")
    public User getById(@RequestParam("userId") String userId) {
        return userService.getById(userId);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String noSuchElementError() {
        return "No such element found";
    }

    @PutMapping
    public User updateUserById(@RequestBody User user) {
        return userService.updateUserById(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam(name = "userId") String userId) {
        userService.deleteUser(userId);
    }

}
