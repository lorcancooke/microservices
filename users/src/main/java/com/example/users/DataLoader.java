package com.example.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final com.example.users.UserPreferenceRepository userPreferenceRepository;

    @Autowired
    public DataLoader(com.example.users.UserPreferenceRepository userPreferenceRepository) {
        this.userPreferenceRepository = userPreferenceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Load sample user preferences
        loadSampleUserPreferences();
    }

    public void loadSampleUserPreferences() {
        // Create and save sample user preferences
        UserPreference user1Preferences = new UserPreference(true, "English", "all");
        userPreferenceRepository.save(user1Preferences);

        UserPreference user2Preferences = new UserPreference(false, "Spanish", "closeFriends");
        userPreferenceRepository.save(user2Preferences);

        UserPreference user3Preferences = new UserPreference(true, "French", "off");
        userPreferenceRepository.save(user3Preferences);


        System.out.println("Sample user preferences loaded.");
    }
}
