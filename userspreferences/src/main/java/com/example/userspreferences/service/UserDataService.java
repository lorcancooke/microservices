package com.example.userspreferences.service;

import com.example.userspreferences.entity.Userdata;
import com.example.userspreferences.repository.UserDataRepository;
import com.example.userspreferences.value.ResponseTemplateValueObject;
import com.example.userspreferences.value.UserPreferences;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


@Slf4j
@Service
public class UserDataService {
    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Userdata save(Userdata userdata) {
        return userDataRepository.save(userdata);


    }

    public ResponseTemplateValueObject getUserDatawithUserPreferences(long usersId) {
        log.info("Inside getUserDatawithUserPreferences of UserService");
        Optional<Userdata> userDataOptional = userDataRepository.findById(usersId);
        if (userDataOptional.isPresent()) {
            Userdata userData = userDataOptional.get();
            String preferencesServiceUrl = "http://USERSERVICES/userpreferences/{id}";
            UserPreferences userPreferences = null;
            try {
                userPreferences = restTemplate.getForObject(preferencesServiceUrl, UserPreferences.class, usersId);
                log.info("User Preferences fetched successfully for userID: {}", usersId);
            } catch (Exception e) {
                log.error("Error fetching user preferences for userID: {}, error: {}", usersId, e.getMessage());
            }

            ResponseTemplateValueObject responseTemplateValueObject = new ResponseTemplateValueObject();
            responseTemplateValueObject.setUserdata(userData);
            responseTemplateValueObject.setUserPreferences(userPreferences);
            return responseTemplateValueObject;
        } else {
            log.error("User data not found for userID: {}", usersId);
            return null;
        }
    }
}