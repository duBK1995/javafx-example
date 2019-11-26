package com.dudv2.javafx.service;

import com.dudv2.javafx.model.Student;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final Student mockData = new Student("dudv2", "123");

    public boolean authenticate(String username, String password) {
        if (username.equals(mockData.getUsername()) && password.equals(mockData.getPassword())) {
            return true;
        }
        return false;
    }
}
