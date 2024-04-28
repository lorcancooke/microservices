package com.example.userservices.service;

import com.example.userservices.entity.User;
import com.example.userservices.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        log.info("Inside saveUser of UserService");

        return userRepository.findByUserId(userId);

    }
}
