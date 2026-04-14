/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.quickchatapp_registration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author NALEDI
 */
public class TestQuickChatApp_Registration {

    @Test
    public void testValidUsername() {
        QuickChatApp_Registration app = new QuickChatApp_Registration();
        assertTrue(app.checkUserName("nal_1"));
    }

    @Test
    public void testInvalidUsername_NoUnderscore() {
        QuickChatApp_Registration app = new QuickChatApp_Registration();
        assertFalse(app.checkUserName("nal12"));
    }

    @Test
    public void testInvalidUsername_TooLong() {
        QuickChatApp_Registration app = new QuickChatApp_Registration();
        assertFalse(app.checkUserName("nale_12"));
    }

    @Test
    public void testValidPassword() {
        QuickChatApp_Registration app = new QuickChatApp_Registration();
        assertTrue(app.checkPasswordComplexity("Passw0rd!"));
    }

    @Test
    public void testInvalidPassword_NoCapital() {
        QuickChatApp_Registration app = new QuickChatApp_Registration();
        assertFalse(app.checkPasswordComplexity("password1!"));
    }

    @Test
    public void testInvalidPassword_NoNumber() {
        QuickChatApp_Registration app = new QuickChatApp_Registration();
        assertFalse(app.checkPasswordComplexity("Password!"));
    }

    @Test
    public void testInvalidPassword_NoSpecialChar() {
        QuickChatApp_Registration app = new QuickChatApp_Registration();
        assertFalse(app.checkPasswordComplexity("Password1"));
    }

    @Test
    public void testValidCellNumber() {
        QuickChatApp_Registration app = new QuickChatApp_Registration();
        assertTrue(app.checkCellPhoneNumber("+27664601652"));
    }

    @Test
    public void testInvalidCellNumber_NoPlus() {
        QuickChatApp_Registration app = new QuickChatApp_Registration();
        assertFalse(app.checkCellPhoneNumber("0664601652"));
    }

    @Test
    public void testInvalidCellNumber_TooShort() {
        QuickChatApp_Registration app = new QuickChatApp_Registration();
        assertFalse(app.checkCellPhoneNumber("+27664"));
    }
}
