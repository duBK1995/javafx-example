package com.dudv2.javafx.ui.register;

import com.dudv2.javafx.model.Student;
import com.dudv2.javafx.service.WeatherService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;


@Component
@FxmlView("/fxml/register.fxml")
public class RegisterController implements Initializable {
    private WeatherService weatherService;

    @FXML
    private VBox vBox;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @Autowired
    public RegisterController(WeatherService weatherService) {

        this.weatherService = weatherService;
    }

    public void login(ActionEvent actionEvent) {
        System.out.println(getCredentialFromClient().toString());
    }

    private Student getCredentialFromClient() {
        String userName = this.txtUsername.getText();
        String password = this.txtPassword.getText();
        return new Student(userName, password);
    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        Stage stage = (Stage) this.vBox.getScene().getWindow();
//        stage.setTitle("Register Form");
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
