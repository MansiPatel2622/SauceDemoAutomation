package tests;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest {

    public static void main(String[] args) {

        testValidLogin();
        testInvalidLogin();
        testEmptyUsername();
        testEmptyPassword();
    }

    public static void testValidLogin() {

        BaseTest.setup();

        LoginPage login = new LoginPage(BaseTest.driver);

        login.login("standard_user", "secret_sauce");

        if (BaseTest.driver.getCurrentUrl().contains("inventory")) {
            System.out.println("PASS : Valid Login");
        } else {
            System.out.println("FAIL : Valid Login");
        }

        BaseTest.closeBrowser();
    }

    public static void testInvalidLogin() {

        BaseTest.setup();

        LoginPage login = new LoginPage(BaseTest.driver);

        login.login("wrong_user", "wrong_password");

        String error = BaseTest.driver.getPageSource();

        if (error.contains("Username and password do not match")) {
            System.out.println("PASS : Invalid Login");
        } else {
            System.out.println("FAIL : Invalid Login");
        }

        BaseTest.closeBrowser();
    }

    public static void testEmptyUsername() {

        BaseTest.setup();

        LoginPage login = new LoginPage(BaseTest.driver);

        login.login("", "secret_sauce");

        String error = BaseTest.driver.getPageSource();

        if (error.contains("Username is required")) {
            System.out.println("PASS : Empty Username");
        } else {
            System.out.println("FAIL : Empty Username");
        }

        BaseTest.closeBrowser();
    }

    public static void testEmptyPassword() {

        BaseTest.setup();

        LoginPage login = new LoginPage(BaseTest.driver);

        login.login("standard_user", "");

        String error = BaseTest.driver.getPageSource();

        if (error.contains("Password is required")) {
            System.out.println("PASS : Empty Password");
        } else {
            System.out.println("FAIL : Empty Password");
        }

        BaseTest.closeBrowser();
    }
}