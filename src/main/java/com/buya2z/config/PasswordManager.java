package com.buya2z.config;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordManager {

    public static boolean authenticate(char[] attemptedPassword, byte[] encryptedPassword, byte[] salt) {
        boolean isValid = false;
        byte[] encryptedAttemptedPassword = getEncryptedPassword(attemptedPassword, salt);

        isValid = Arrays.equals(encryptedPassword, encryptedAttemptedPassword);
        clearBuffer(attemptedPassword, encryptedAttemptedPassword);
        return isValid;
    }

    private static void clearBuffer(char[] chars, byte[]... bytesArray) {
        clearCharArray(chars);
        for(byte[] b : bytesArray) {
            clearByteArray(b);
        }
    }

    public static byte[] getEncryptedPassword(char[] password, byte[] salt){
        byte[] encryptedPassword= null;
        String algorithm = "PBKDF2WithHmacSHA1";
        int derivedKeyLength = 160;
        int iterations = 20000;

        KeySpec spec = new PBEKeySpec(password, salt, iterations, derivedKeyLength);

        SecretKeyFactory f = null;
        try {
            f = SecretKeyFactory.getInstance(algorithm);
            encryptedPassword = f.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return encryptedPassword;
    }

    public static void clearByteArray(byte[] bytes) {
        Arrays.fill(bytes, (byte)0);
    }

    public static void clearCharArray(char[] chars) {
        Arrays.fill(chars, '\u0000');
    }

    public static byte[] generateSalt() {
        SecureRandom random = null;
        try {
            random = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte[] salt = new byte[8];
        random.nextBytes(salt);

        return salt;
    }
}