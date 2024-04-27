package com.example.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @GetMapping
    public String getData() {
        // Implement logic to retrieve data
        return "Some data from Service B";
    }
}
