package com.example.userservices.service;

import com.example.userservices.entity.User;
import com.example.userservices.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;



@Service
@Slf4j

public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");

        return userRepository.save(user);

    }


    public User findUserById(Long userId) {
        log.info("Inside findById of UserService");

        return userRepository.findByUserId(userId);

    }

    public void deleteUserById(Long userId) {
        log.info("Inside deleteById of UserService");
        userRepository.deleteById(userId);
    }

    public List<User> getAllUsers() {
        log.info("Inside getAllUsers of UserService");
        return userRepository.findAll();
    }


    public User updateUserById(Long userId, User updatedUser) {
        log.info("Inside updateUserById of UserService");
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Update user fields with the values from updatedUser
            user.setDarkMode(updatedUser.getDarkMode());
            user.setUserLanguage(updatedUser.getUserLanguage());
            user.setUserStatus(updatedUser.getUserStatus());
            // You can update other fields similarly
            return userRepository.save(user);
        } else {
            return null; // or throw an exception if required
        }
    }



}
