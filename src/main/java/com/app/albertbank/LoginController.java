package com.app.albertbank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    @FXML
    private Button register;

    /**
     * This method handles the action when the register button is clicked, redirecting the user to the registration page.
     *
     * @throws IOException if an input/output exception occurs when loading the register.fxml file
     */
    @FXML
    protected void registerButtonRedirect() throws IOException {
        System.out.println("Register button clicked"); // TODO Remove this after testing
        Scene scene = register.getScene();
        scene.setRoot(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register.fxml"))));
    }

}