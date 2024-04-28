package com.example.userspreferences.value;

import com.example.userspreferences.entity.Userdata;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseTemplateValueObject {

    private Userdata userdata;
    private UserPreferences userPreferences;

}
