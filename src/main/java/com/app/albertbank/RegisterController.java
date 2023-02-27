package com.app.albertbank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.Objects;

public class RegisterController {
    @FXML
    private Button goBack;

    @FXML
    private Label name;

    @FXML
    private Label email;

    @FXML
    private Label password;

    @FXML
    private Label confirmPassword;

    @FXML
    protected void goBackButtonRedirect() throws IOException {
        System.out.println("Go back button clicked"); // TODO Remove this after testing
        Scene scene = goBack.getScene();
        scene.setRoot(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginMain.fxml"))));
    }

}