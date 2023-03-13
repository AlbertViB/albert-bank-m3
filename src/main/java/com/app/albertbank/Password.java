package com.app.albertbank;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {

    public String encryptedPassword;

    /**
     * Constructor for the Password object that encrypts the given password.
     *
     * @param password the password to be encrypted
     */
    public Password(String password) {
        this.encryptedPassword = encrypt(password);
    }

    /**
     * This method encrypts a password using SHA-256 hashing.
     *
     * @param password the password to be encrypted
     * @return the encrypted password as a hexadecimal string
     */
    public static String encrypt(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
