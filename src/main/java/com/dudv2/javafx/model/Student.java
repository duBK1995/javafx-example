package com.dudv2.javafx.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private Long id;
    private String username;
    private String password;

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
