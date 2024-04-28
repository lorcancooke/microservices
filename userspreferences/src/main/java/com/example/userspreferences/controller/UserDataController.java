package com.example.userspreferences.controller;

import com.example.userspreferences.entity.Userdata;
import com.example.userspreferences.service.UserDataService;
import com.example.userspreferences.value.ResponseTemplateValueObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @PostMapping("/")
    public Userdata saveUser(@RequestBody Userdata userdata) {
        log.info("Inside saveUser of User Controller");
        return userDataService.save(userdata);
    }

    @GetMapping("/{id}")
    public ResponseTemplateValueObject getUserDatawithUserPreferences(@PathVariable("id") long usersId) {
        return userDataService.getUserDatawithUserPreferences(usersId);
    }

}
