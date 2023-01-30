package com.vendo.Pageobjects;

import com.vendo.Testcases.BaseClass;
import org.apache.commons.logging.Log;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import static com.vendo.Utilities.XLConfig.style;


public class Login_Page extends BaseClass {

    @CacheLookup
    @FindBy(name = "username")
    public static WebElement Username;

    @CacheLookup
    @FindBy(name = "password")
    public static WebElement Password;

    @FindBy(xpath = "//*[@ng-click=\"login()\"]")
    public static WebElement Loginbutton;

    @FindBy(xpath = "//*[@aria-label=\"profile\"]")
    public static WebElement profile;

    @FindBy(xpath = "//*[@ng-click=\"logout()\"]")
    public static WebElement Logout;


    @FindBy(xpath = "//*[text()='Username is required.']")
    public static WebElement usernameReq;

    @FindBy(xpath = "//*[text()='Password is required.']")
    public static WebElement passwordReq;

    @FindBy(xpath = "//span[@class='ng-binding ng-scope']")
    public static WebElement Gotitbutton;


    //PageTitle Validation
    public static void gettitle(String Title,String Tc,int rownum, int cellnum) throws IOException {

        if(Title.equals(driver.getTitle())){

            System.out.println(Tc+"TestCase Passed");
            xlcon.setCellValue(rownum,cellnum,"TestCase Passed",excelfilepath);

            log.info(Tc+"TestCase Passed");
            Assert.assertTrue(true);
        }else {

            System.out.println(Tc+"TestCase Failed");
            xlcon.setCellValue(rownum,cellnum,"TestCase Failed",excelfilepath);
            log.error("TC_000_VerifyPageTitle TestCase Failed");
            Assert.assertTrue(false);

        }

    }


    public static void SetCredentials(String Uname,String pword){

        Username.sendKeys(Uname);
        log.info(Uname);
        Password.sendKeys(pword);
        log.info(pword);

    }

    public static void Loginbutton(){
        Loginbutton.click();
        log.info("Login Button is Clicked");
    }

    //VALIDATION FOR Login Function
    public static void Homepageview(String urlparam,String Tc, int Rownum, int Cellnum) throws IOException, InterruptedException {

        if(driver.getCurrentUrl().contains(urlparam)){
            Profile();
            Thread.sleep(600);
            logout();
            System.out.println(Tc+" TestCase Passed");
            log.info(Tc+" TestCase Passed");
            xlcon.setCellValue(Rownum,Cellnum,"TestCase passed",excelfilepath);
            Assert.assertTrue(true);

        }else {
            driver.navigate().refresh();
            System.out.println(Tc+" TestCase Failed");
            log.error(Tc+" TestCase Failed");
            xlcon.setCellValue(Rownum,Cellnum,"TestCase Failed",excelfilepath);
            Assert.assertTrue(false);
            Reporter.log(Tc+" TestCase Failed");
        }
    }

    public static void Profile(){

        profile.click();
        log.info("Profile is Clicked");

    }

    public static void logout(){

        Logout.click();
        log.info("Logout Button  is Clicked");

    }


    public static void Validate(String errmsg,String Tc, int rownum , int cellnum) throws IOException, InterruptedException {

        if(driver.getPageSource().contains(errmsg)){

            System.out.println(Tc+" TestCase Passed");
            log.info(Tc+" TestCase Passed");
            xlcon.setCellValue(rownum,cellnum,"TestCase Passed",excelfilepath);
            Assert.assertTrue(true);
            Thread.sleep(1000);
            Gotit();
            clearfields();

        }else {
            driver.navigate().refresh();
            System.out.println(Tc+" TestCase Failed");
            log.error(Tc+" TestCase Failed");
            xlcon.setCellValue(rownum,cellnum,"TestCase Failed",excelfilepath);
            Reporter.log(Tc+"TestCase Failed");
            Assert.assertTrue(false);
        }
    }

    public static void Gotit(){

        Gotitbutton.click();
        log.info("Got it Button is Clicked");
    }

    public  static void clearfields(){

        Username.clear();
        Password.clear();
        log.info("Username and Password Fields is Clear");
    }

    //VALIDATION for Page is Refreshed or Not
    public static void Refresh(String value,String Tc,int rownum,int cellnum) throws IOException, InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(1000);
        if(driver.getPageSource().contains(value)){

            driver.navigate().refresh();
            System.out.println(Tc+" Testcase failed");
            log.error(Tc+" TestCase failed");
            xlcon.setCellValue(rownum,cellnum,"TestCase Failed",excelfilepath);
            Assert.assertTrue(false);
            Reporter.log(Tc+" Testcase failed");
        }else{

            System.out.println(Tc+" TestCase Passed");
            log.info(Tc+" TestCase Passed");
            xlcon.setCellValue(rownum,cellnum,"TestCase Passed",excelfilepath);
            Assert.assertTrue(true);

        }

    }

    //Validation Method for NullValue in Username and Password TestCase
    public static void ValidateNullValue(String Tc, String err1,String err2 , int rownum,int cellnum) throws IOException {

        try{

            String source = driver.getPageSource();

            if(source.contains(err1) && source.contains(err2)){

                    System.out.println(Tc+"TestCase Passed");
                    log.info(Tc+"TestCase Passed");
                    xlcon.setCellValue(rownum,cellnum,"TestCase Passed",excelfilepath);
                    Assert.assertTrue(true);
                }

        }catch(NoSuchElementException | IOException e){

            e.getMessage();
            log.info(e.getMessage());
        }

        driver.navigate().refresh();
        System.out.println(Tc+"TestCase Failed");
        Reporter.log(Tc+"TestCase Failed");
        log.error(Tc+"TestCase Failed");
        xlcon.setCellValue(rownum,cellnum,"TestCase Failed",excelfilepath);
        Assert.assertFalse(true);
    }

    //Length Validations for Username & Password TestCases
    public static void MaxlengthValidate(String value,String Uname,String Pword,String Tc,String Size , int rownum , int cellnum) throws IOException {

        PageFactory.initElements(driver, Login_Page.class);

        if(value=="uname"){

            Login_Page.SetCredentials(Uname,Pword);
            String leng  = Login_Page.Username.getAttribute("value");
            String size = String.valueOf(leng.length());

            if(size==Size){
                System.out.println(Tc+" TestCase passed");
                log.info(Tc+" TestCase passed");
                xlcon.setCellValue(rownum,cellnum,"TestCase Passed",excelfilepath);
                Assert.assertTrue(true);
                Login_Page.Username.clear();
            }else{
                Login_Page.Username.clear();
                System.out.println(Tc+" TestCase Failed");
                log.error(Tc+" TestCase Failed");
                xlcon.setCellValue(rownum,cellnum,"TestCase Failed",excelfilepath);
                Assert.assertFalse(true);
            }
        } else if (value=="pword") {
            Login_Page.SetCredentials(Uname,Pword);
            String leng  = Login_Page.Password.getAttribute("value");
            String size = String.valueOf(leng.length());

            if(size==Size){
                System.out.println(Tc+"TestCase passed");
                log.info(Tc+"TestCase Passed");
                Assert.assertTrue(true);
                xlcon.setCellValue(rownum,cellnum,"TestCase Passed",excelfilepath);
                Login_Page.Password.clear();
            }else{
                System.out.println(Tc+"TestCase Failed");
                log.error(Tc+" TestCase Failed");
                xlcon.setCellValue(rownum,cellnum,"TestCase Failed",excelfilepath);
                Login_Page.Password.clear();
                Assert.assertFalse(true);

            }
        }
    }
    //Verify Special Characters is allowed in Password
    public static void SpecialCharinPassword(String Tc,String Uname ,String Pword,int rownnum, int cellnum) throws IOException {

        Login_Page.SetCredentials(Uname,Pword);
        if(Login_Page.Password.getText()!= null){

            System.out.println(Tc+" TestCase Passed");
            log.info(Tc+" TestCase Passed");
            xlcon.setCellValue(rownnum,cellnum,"TestCase Passed",excelfilepath);
            Assert.assertTrue(true);
        }else{

            driver.navigate().refresh();
            System.out.println(Tc+" TestCase Failed");
            log.error(Tc+"TestCase Failed");
            Reporter.log(Tc+" TestCase Failed");
            xlcon.setCellValue(rownnum,cellnum,"TestCase Failed",excelfilepath);
            Assert.assertTrue(false);
        }

    }

    //Validation Method for NullValuePassword TestCase
    public static void ValidateNullValuePassword(String Tc,int rownum,int cellnum) throws IOException {

        try{

            if(Login_Page.passwordReq.isDisplayed()){

                System.out.println(Tc+" TestCase passed");
                log.info(Tc+" TestCase passed");
                xlcon.setCellValue(rownum,cellnum,"TestCase Passed",excelfilepath);
                Assert.assertTrue(true);

            }

        }catch(NoSuchElementException e){

            e.getMessage();
            log.error(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver.navigate().refresh();
        System.out.println(Tc+" TestCase Failed");
        Reporter.log(Tc+" TestCase Failed");
        log.error(Tc+" TestCase Failed");
        xlcon.setCellValue(rownum,cellnum,"TestCase Failed",excelfilepath);
        Assert.assertTrue(false);

    }
}