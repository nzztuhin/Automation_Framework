package com.it.bd.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.it.bd.drivers.PageDriver;
import com.it.bd.utilities.CommonMethods;
import com.it.bd.utilities.GetScreenShot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;


public class LoginPage extends CommonMethods {
    ExtentTest test;
    public LoginPage(ExtentTest test){
        PageFactory.initElements(PageDriver.getCurrentDriver(),this);
        this.test = test;
    }
    @FindBys({
            @FindBy(xpath = "//input[@placeholder='Username']"),
            @FindBy(xpath = "//input[@name='username']")
    })
    WebElement userName;

    @FindBys({
            @FindBy(xpath = "//input[@placeholder='Password']"),
            @FindBy(xpath = "//input[@name='password']")
    })
    WebElement password;
    @FindBys({
            @FindBy(xpath = "//button[normalize-space()='Login']")
    })
    WebElement loginButton;

    public void login() throws InterruptedException, IOException {
        timeout();
        try {
            if(userName.isDisplayed()) {
                userName.sendKeys("Admin");
                timeout();
            }
        } catch (Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Username is not locateable.Please check the error message.</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "usernameLocator");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "usernameLocator.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue(userName.isDisplayed());
            PageDriver.getCurrentDriver().quit();
        }

        try {
            if(password.isDisplayed()) {
                password.sendKeys("admin123");
                timeout();
            }
        } catch (Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Password is not locateable.Please check the error message.</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "passwordLocator");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "passwordLocator.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue(password.isDisplayed());
            PageDriver.getCurrentDriver().quit();
        }

        try {
            if (loginButton.isDisplayed()) {
                loginButton.click();
                timeout(5000);
                test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>You have successfully logged in.</b></p>");
                String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "loginPass");
                String dest = System.getProperty("user.dir") + "\\screenshots\\" + "loginPass.png";
                test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            }
        } catch (Exception e) {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>Login Button is not locateable.Please check the error message.</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            @SuppressWarnings("unused")
            String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "loginButtonLocator");
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "loginButtonLocator.png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
            Assert.assertTrue(loginButton.isDisplayed());
            PageDriver.getCurrentDriver().quit();
        }
    }
}

