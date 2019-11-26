package com.dudv2.javafx.ui.login;

import com.dudv2.javafx.model.Student;
import com.dudv2.javafx.service.AuthService;
import com.dudv2.javafx.ui.register.RegisterController;
import com.dudv2.javafx.ui.utils.DialogUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.net.URL;
import java.util.ResourceBundle;


@Component
@FxmlView("/fxml/login.fxml")
@Slf4j
public class LoginController implements Initializable {
    private final AuthService authService;

    @Autowired
    private FxWeaver fxWeaver;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    private Scene scene;

    @Autowired
    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    public void login() {
        log.info("Start login with email={} and password={}", this.txtUsername.getText(), this.txtPassword.getText());
        if (!this.validateBeforeLogin() || this.getCredentialFromClient() == null) {
            return;
        }
        this.navigateToRegister();
    }

    private Student getCredentialFromClient() {
        String userName = this.txtUsername.getText();
        String password = this.txtPassword.getText();
        if (this.authService.authenticate(userName, password))
            return new Student(userName, password);
        DialogUtils.createError("Login fail", "The username or password is not correct.").showAndWait();
        return null;
    }

    private boolean validateBeforeLogin() {
        if (StringUtils.isEmpty(txtUsername.getText()) || StringUtils.isEmpty(txtPassword.getText())) {
            Alert alert = DialogUtils.createError("Login fail", "Username or password is not valid.");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    private void navigateToRegister() {
        Stage stage = (Stage) btnLogin.getScene().getWindow();

//        RegisterController registerController
        Scene scene = new Scene(this.fxWeaver.loadView(RegisterController.class));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Register Form");
        stage.show();
    }

    @FXML
    private void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            this.login();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        this.handleEventKeyEnterPress(this.btnLogin);
    }
}
