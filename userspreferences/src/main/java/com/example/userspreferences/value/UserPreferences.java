package com.example.userspreferences.value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserPreferences {

    public Long userId;
    private Boolean darkMode;
    private String userLanguage;
    private String userStatus;
}
