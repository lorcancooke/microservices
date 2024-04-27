package com.example.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPreferenceService {

    private final com.example.users.UserPreferenceRepository userPreferenceRepository;

    @Autowired
    public UserPreferenceService(com.example.users.UserPreferenceRepository userPreferenceRepository) {
        this.userPreferenceRepository = userPreferenceRepository;
    }

    public List<com.example.users.UserPreference> getAllUserPreferences() {
        return userPreferenceRepository.findAll();
    }

    public com.example.users.UserPreference createUserPreference(com.example.users.UserPreference userPreference) {
        return userPreferenceRepository.save(userPreference);
    }

    public com.example.users.UserPreference updateUserPreference(Long id, com.example.users.UserPreference userPreference) {
        Optional<com.example.users.UserPreference> existingUserPreferenceOptional = userPreferenceRepository.findById(id);
        if (existingUserPreferenceOptional.isPresent()) {
            com.example.users.UserPreference existingUserPreference = existingUserPreferenceOptional.get();
            // Update existing user preference with new values
            existingUserPreference.setDarkMode(userPreference.isDarkMode());
            existingUserPreference.setLanguage(userPreference.getLanguage());
            existingUserPreference.setNotificationOption(userPreference.getNotificationOption());
            // Save the updated user preference
            return userPreferenceRepository.save(existingUserPreference);
        } else {
            // If user preference with given id does not exist, return null or throw exception
            return null;
        }
    }

    public void deleteUserPreference(Long id) {
        userPreferenceRepository.deleteById(id);
    }

    // Other service methods for CRUD operations...
}
