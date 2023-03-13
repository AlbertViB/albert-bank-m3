package com.app.albertbank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;

public class RegisterController {
    @FXML
    private Button goBack;
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Text error;
    @FXML
    private Button register;

    /**
     * This method redirects the user back to the login page when the go back button is clicked.
     *
     * @throws IOException if an input/output exception occurs when loading the loginMain.fxml file
     */
    @FXML
    private void goBackButtonRedirect() throws IOException {
        System.out.println("Go back button clicked"); // TODO Remove this after testing
        Scene scene = goBack.getScene();
        scene.setRoot(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginMain.fxml"))));
    }

    /**
     * This method checks whether the password and confirm password fields have the same value.
     *
     * @return true if the password and confirm password fields have the same value, false otherwise
     */
    @FXML
    private boolean checkIfSamePasswords() {
        return password.getText().equals(confirmPassword.getText());
    }

    /**
     * This method checks if the inputs are valid and if they are, it creates a new user.
     *
     * @throws IOException if an input/output exception occurs when loading the registerSuccessful.fxml file
     */
    @FXML
    private void handleRegisterButton() throws IOException {
        if (checkRightInputs()) {
            new User(name.getText(), email.getText(), password.getText());
            Scene scene = register.getScene();
            scene.setRoot(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registerSuccessful.fxml"))));
        }
    }

    /**
     * This method checks if the inputs of the register form are correct or not
     *
     * @return if are there any errors
     */
    private boolean checkRightInputs() {
        error.setText("");
        // First we check if any of the inputs are void
        if (name.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty() || confirmPassword.getText().isEmpty()) {
            error.setText("Please fill in all the fields\n");
        }

        // Then we check if the passwords are the same
        if (!checkIfSamePasswords() && (!password.getText().isEmpty() || !confirmPassword.getText().isEmpty())) {
            error.setText(error.getText() + "The passwords are not the same\n");
        }

        // Check if the email has a valid format
        if (!email.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            error.setText(error.getText() + "The email is not valid\n");
        }

        return error.getText().isEmpty();
    }


}