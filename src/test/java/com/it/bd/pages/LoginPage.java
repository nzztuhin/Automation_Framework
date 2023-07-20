package com.it.bd.pages;

import com.it.bd.drivers.PageDriver;
import com.it.bd.utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends CommonMethods {
    public LoginPage(){
        PageFactory.initElements(PageDriver.getCurrentDriver(),this);
    }
    @FindBys({
            @FindBy(xpath = "//input[@placeholder='Username']"),
            @FindBy(xpath = "//input[@name='username']")
    })
    WebElement username;

    @FindBys({
            @FindBy(xpath = "//input[@placeholder='Password']"),
            @FindBy(xpath = "//input[@name='password']")
    })
    WebElement password;
    @FindBys({
            @FindBy(xpath = "//button[normalize-space()='Login']")
    })
    WebElement loginButton;

    public void login() throws InterruptedException {
        timeout();
        try {
            if (username.isDisplayed()) {
                username.sendKeys("Admin");
                timeout();
            }
        } catch (Exception e){
            System.out.println(e);
        }
        try {
            if (password.isDisplayed()) {
                password.sendKeys("admin123");
                timeout();
            }
        } catch (Exception e){
            System.out.println(e);
        }
        try {
            if (loginButton.isDisplayed()) {
                loginButton.click();
                timeout(5000);
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}

