package com.app.albertbank;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class User {
    private final String nom;
    private final String email;
    private final Password password;
    private ArrayList<compteCorrent> comptes;

    /**
     * @param nom name of the user
     * @param email email of the user
     * @param password users password without being hashed
     */
    public User(String nom, String email, String password) {
        this.nom = nom;
        this.email = email;
        this.password = new Password(password);
        System.out.println("User created with name: " + nom + ", email: " + email + " and password: " + this.password.encryptedPassword); // TODO Remove this after testing
        insertUserIntoFile();
    }

    /**
     * This method adds a row into the users file
     */
    private void insertUserIntoFile() {
        try {
            try (FileWriter f = new FileWriter("users.txt", true)) {
                f.write(nom + "," + email + "," + password.encryptedPassword + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}