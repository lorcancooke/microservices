package com.example.userservices.controller;

import com.example.userservices.entity.User;
import com.example.userservices.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Slf4j

public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser method of UserController");
        return userService.saveUser(user);
    }


    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long userId) {
        log.info("Inside findUserById method of UserController");
        return userService.findUserById(userId);

    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long userId) {
        log.info("Inside deleteUserById method of UserController");
            userService.deleteUserById(userId);
        }
    @PutMapping("/{id}")
    public User updateUserById(@PathVariable("id") Long userId, @RequestBody User user) {
        log.info("Inside updateUserById method of UserController");
        return userService.updateUserById(userId, user);
    }
    @GetMapping("/")
    public List<User> getAllUsers() {
        log.info("Inside getAllUsers method of UserController");
        return userService.getAllUsers();
    }


    }