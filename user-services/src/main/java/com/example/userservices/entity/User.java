package com.example.userservices.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long userId;
    private Boolean darkMode;
    private String userLanguage;
    private String userStatus;

    public Boolean getDarkMode() {
        return darkMode;
    }

}
