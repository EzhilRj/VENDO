package com.vendo.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

    WebDriver driver;

    @FindBy(name = "username")
    public static WebElement username;

    @FindBy(name = "password")
    public static WebElement Password;

    @FindBy(xpath = "//*[@ng-click=\"login()\"]")
    public static WebElement Loginbutton;

    @FindBy(className = "mainhomeli")
    public static WebElement Homepage;

    @FindBy(xpath = "//*[@aria-label=\"profile\"]")
    public static WebElement profile;

    @FindBy(xpath = "//*[@ng-click=\"logout()\"]")
    public static WebElement Logout;

    @FindBy(xpath = "//*[text()='Invalid Password.']")
    public static WebElement wrongpassword;

    @FindBy(xpath = "//*[text()='Invalid Username.']")
    public static WebElement Wrongusername;

    @FindBy(xpath = "//*[text()='Username is required.']")
    public static WebElement usernameReq;

    @FindBy(xpath = "//*[text()='Password is required.']")
    public static WebElement passwordReq;

    @FindBy(xpath = "//span[@class='ng-binding ng-scope']")
    public static WebElement Gotitbutton;

    Login_Page(WebDriver d){

        driver=d;
        PageFactory.initElements(d,this);

    }









}
