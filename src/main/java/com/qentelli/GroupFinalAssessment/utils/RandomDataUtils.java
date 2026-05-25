package com.qentelli.GroupFinalAssessment.utils;

import java.util.Random;

public class RandomDataUtils {

    // Generate random number
    public static int generateRandomNumber() {

        Random random = new Random();

        return random.nextInt(10000);
    }

    // Generate random username
    public static String generateUsername(
            String baseName) {

        return baseName
                +
                generateRandomNumber();
    }

    // Overloaded method
    public static String generateUsername() {

        return "user"
                +
                generateRandomNumber();
    }

    // Generate random email
    public static String generateEmail(
            String baseName) {

        return baseName
                +
                generateRandomNumber()
                +
                "@gmail.com";
    }

    // Overloaded email method
    public static String generateEmail() {

        return "user"
                +
                generateRandomNumber()
                +
                "@gmail.com";
    }

    // Generate random password
    public static String generatePassword() {

        return "Pass@"
                +
                generateRandomNumber();
    }

    // Generate random phone number
    public static String generatePhoneNumber() {

        Random random = new Random();

        return "9"
                + (100000000
                + random.nextInt(900000000));
    }
}