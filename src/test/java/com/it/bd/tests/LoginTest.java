package com.it.bd.tests;

import com.it.bd.drivers.BaseDriver;
import com.it.bd.drivers.PageDriver;
import com.it.bd.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseDriver {
    @BeforeTest
    public void openUrl(){
        PageDriver.getCurrentDriver().manage().window().maximize();
        PageDriver.getCurrentDriver().get(url);
    }
    @Test (priority = 0)
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }
}
