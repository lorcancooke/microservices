package com.example.userspreferences.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userdata {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long usersId;
    private String firstName;
    private String lastName;
    private String userName;
    private Long age;
    private String email;
    private String passwordHash;




}
