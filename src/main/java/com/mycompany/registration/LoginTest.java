package com.mycompany.registration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testCheckUsername_Valid() {
        Login login = new Login();
        login.userName = "user_";
        assertTrue(login.checkUsername());
    }

    @Test
    public void testCheckUsername_Invalid() {
        Login login = new Login();
        login.userName = "username"; // no underscore and too long
        assertFalse(login.checkUsername());
    }

    @Test
    public void testCheckPasswordComplexity_Valid() {
        Login login = new Login();
        login.password = "Pass@123";
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexity_Invalid() {
        Login login = new Login();
        login.password = "password"; // no uppercase, digit, special char
        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    public void testCheckCellPhone_Valid() {
        Login login = new Login();
        login.cellPhone = "+271234567890";
        assertTrue(login.checkCellPhone());
    }

    @Test
    public void testCheckCellPhone_Invalid() {
        Login login = new Login();
        login.cellPhone = "0123456789"; // no international code
        assertFalse(login.checkCellPhone());
    }

    @Test
    public void testRegisterUser_Success() {
        Login login = new Login();
        login.userName = "usr_";
        login.password = "Pass@123";
        login.cellPhone = "+271234567890";

        String result = login.registerUser();

        assertTrue(result.contains("Username successfully captured"));
        assertTrue(result.contains("Password successfully captured"));
        assertTrue(result.contains("Cell phone number successfully added"));
    }

    @Test
    public void testLoginUser_Success() {
        Login login = new Login();
        login.userName = "usr_";
        login.password = "Pass@123";
        login.cellPhone = "+271234567890";

        login.enteredUserName = "usr_";
        login.enteredPassword = "Pass@123";
        login.enteredCell = "+271234567890";

        assertTrue(login.loginUser());
    }

    @Test
    public void testLoginUser_Fail() {
        Login login = new Login();
        login.userName = "usr_";
        login.password = "Pass@123";
        login.cellPhone = "+271234567890";

        login.enteredUserName = "wrong";
        login.enteredPassword = "wrong";
        login.enteredCell = "+271234567890";

        assertFalse(login.loginUser());
    }

    @Test
    public void testReturnLoginStatus_Success() {
        Login login = new Login();
        login.userName = "usr_";
        login.password = "Pass@123";
        login.cellPhone = "+271234567890";

        login.enteredUserName = "usr_";
        login.enteredPassword = "Pass@123";
        login.enteredCell = "+271234567890";

        String result = login.returnLoginStatus();
        assertTrue(result.contains("Successful login"));
    }

    @Test
    public void testReturnLoginStatus_Fail() {
        Login login = new Login();
        login.userName = "usr_";
        login.password = "Pass@123";
        login.cellPhone = "+271234567890";

        login.enteredUserName = "wrong";
        login.enteredPassword = "wrong";
        login.enteredCell = "+271234567890";

        String result = login.returnLoginStatus();
        assertTrue(result.contains("failed login"));
    }
}
