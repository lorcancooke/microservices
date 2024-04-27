package com.example.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-preferences")
public class UserController {

    private final UserPreferenceService userPreferenceService;

    @Autowired
    public UserController(UserPreferenceService userPreferenceService) {
        this.userPreferenceService = userPreferenceService;
    }

    // Endpoint to create a new user preference
    @PostMapping
    public ResponseEntity<UserPreference> createUserPreference(@RequestBody UserPreference userPreference) {
        UserPreference createdUserPreference = userPreferenceService.createUserPreference(userPreference);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserPreference);
    }

    // Endpoint to update an existing user preference
    @PutMapping("/{id}")
    public ResponseEntity<UserPreference> updateUserPreference(@PathVariable Long id, @RequestBody UserPreference userPreference) {
        UserPreference updatedUserPreference = userPreferenceService.updateUserPreference(id, userPreference);
        return ResponseEntity.ok(updatedUserPreference);
    }

    // Endpoint to delete a user preference
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserPreference(@PathVariable Long id) {
        userPreferenceService.deleteUserPreference(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint to retrieve all user preferences
    @GetMapping
    public ResponseEntity<List<UserPreference>> getAllUserPreferences() {
        List<UserPreference> userPreferences = userPreferenceService.getAllUserPreferences();
        return ResponseEntity.ok(userPreferences);
    }

    // Define additional API endpoints as needed...
}