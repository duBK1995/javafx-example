package com.dudv2.javafx;

import com.dudv2.javafx.ui.login.LoginApp;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExampleApplication {

    public static void main(String[] args) {
        Application.launch(LoginApp.class, args);
    }
}
