package com.app.albertbank;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class User {
    private final String nom;
    private final String email;
    private final Password password;
    private ArrayList<compteCorrent> comptes;

    public User(String nom, String email, String password) {
        this.nom = nom;
        this.email = email;
        this.password = new Password(password);
        System.out.println("User created with name: " + nom + ", email: " + email + " and password: " + this.password.encryptedPassword); // TODO Remove this after testing
        insertUserIntoFile();
    }

    private void insertUserIntoFile() {
        try {
            try (FileWriter f = new FileWriter("users.txt", true)) {
                f.write(nom + "," + email + "," + password.encryptedPassword);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}