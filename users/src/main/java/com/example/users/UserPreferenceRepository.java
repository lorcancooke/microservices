package com.example.users;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long> {
    // Custom query methods can be defined here if needed
}
