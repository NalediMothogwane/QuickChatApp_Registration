/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchatapp_registration;

import java.util.Scanner;

/**
 *
 * @author NALEDI
 */
public class QuickChatApp_Registration {
    // Store user details
    String storedUsername;
    String storedPassword;
    String firstName;
    String lastName;
    String storedCell;

    Scanner input = new Scanner(System.in);

    // Check username
    public boolean checkUserName(String username) { 
        if (username.contains("_") && username.length() <= 5) {
            System.out.println("Username looks good.");
            return true;
        } else {
            System.out.println("Username must contain an underscore and be no more than 5 characters.");
            return false;
        }
    }

    // Check password
    public boolean checkPasswordComplexity(String password) {
        boolean longEnough = password.length() >= 8;
        boolean hasCapital = false;
        boolean hasNumber = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            }
            if (Character.isDigit(c)) {
                hasNumber = true;
            }
        }

        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9 ].*");

        if (longEnough && hasCapital && hasNumber && hasSpecial) {
            System.out.println("Password accepted.");
            return true;
        } else {
            System.out.println("Password must be at least 8 characters, include a capital letter, a number, and a special character.");
            return false;
        }
    }

    // Check cell number
    public boolean checkCellPhoneNumber(String cell) { 
        if (cell.startsWith("+") && cell.length() >= 11) {
            System.out.println("Cell number accepted.");
            return true;
        } else {
            System.out.println("Cell number must start with + and include country code.");
            return false;
        }
    }

    // Registration
    public void registerUser() {
        System.out.println("\n--- Create Account ---");

        System.out.print("First Name: ");
        firstName = input.nextLine();

        System.out.print("Last Name: ");
        lastName = input.nextLine();

        System.out.print("Username: ");
        String username = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        System.out.print("Cell Phone (+country code): ");
        String cell = input.nextLine();

        if (checkUserName(username) && checkPasswordComplexity(password) && checkCellPhoneNumber(cell)) {
            storedUsername = username;
            storedPassword = password;
            storedCell = cell;
            System.out.println("Registration successful! Welcome, " + firstName + ".");
        } else {
            System.out.println("Registration failed. Please try again.");
        }
    }

    // Login
    public void loginUser() {
        if (storedUsername == null) {
            System.out.println("No account registered yet.");
            return;
        }

        System.out.println("\n--- Login ---");

        System.out.print("Username: ");
        String username = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        if (username.equals(storedUsername) && password.equals(storedPassword)) {
            System.out.println("Welcome back, " + firstName + " " + lastName + "!");
        } else {
            System.out.println("Incorrect login details.");
        }
    }

    // Main program
    public static void main(String[] args) {
        QuickChatApp_Registration app = new QuickChatApp_Registration();

        app.registerUser();
        app.loginUser();

        System.out.println("\nProgram finished.");
    }
}
