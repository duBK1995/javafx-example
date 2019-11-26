package com.dudv2.javafx.service;

import com.dudv2.javafx.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentService {
    private final Student mockData = new Student("dudv2", "123");

    private boolean authenticate(String username, String password) {
        if (username.equals(mockData.getUsername()) && password.equals(mockData.getPassword())) {
            return true;
        }
        return false;
    }
    
}
