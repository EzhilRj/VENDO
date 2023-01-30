package com.vendo.Pageobjects;

import com.vendo.Testcases.BaseClass;
import com.vendo.Utilities.XLConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Signup_Page extends BaseClass {

    @FindBy(xpath="//*[text()='Sign up']")
    public static WebElement Signupbutton;

    @FindBy(name="companyname")
    public static WebElement Agencyname;

    @FindBy(name="firstname")
    public static WebElement Firstname;

    @FindBy(name="lastname")
    public static WebElement Lastname;

    @FindBy(xpath="//*[@ng-model=\"contact.constitutionid\"]")
    public static WebElement Constitution;

    @FindBy(name="email")
    public static WebElement Email;

    @FindBy(xpath="//*[@ng-model=\"contact.contacttypeid\"]")
    public static WebElement contactType;

    @FindBy(name="contactno")
    public static WebElement ContactNO;

    @FindBy(name="telephoneno")
    public static WebElement Landline;

    @FindBy(name="gstno")
    public static WebElement GSTno;

    @FindBy(name="contactperson")
    public static WebElement AlternativeContactperson;

    @FindBy(name="contactpersonno")
    public static WebElement AlternativeContactno;

    @FindBy(xpath="//*[@ng-model=\"contact.nationalityid\"]")
    public static WebElement Nationality;

    @FindBy(xpath="//*[@ng-model=\"contact.countryid\"]")
    public static WebElement Country;

    @FindBy(xpath="//*[@ng-model=\"contact.stateid\"]")
    public static WebElement State;

    @FindBy(xpath="//*[@ng-model=\"contact.cityid\"]")
    public static WebElement City;

    @FindBy(xpath="//*[@ng-model=\"contact.areaid\"]")
    public static WebElement Area;

    @FindBy(xpath="//*[@ng-model=\"contact.address\"]")
    public static WebElement Address;

    @FindBy(name="username")
    public static WebElement username;

    @FindBy(name="password")
    public static WebElement password;

    @FindBy(name="aadharno")
    public static WebElement Aaadhar;

    @FindBy(name="panno")
    public static WebElement Pannumber;

    @FindBy(name="license")
    public static WebElement LicenseNo;

    @FindBy(xpath = "//*[@ng-model='ispan']")
    public static WebElement sliderbutton;

    @FindBy(xpath="//a[@onclick=\"document.getElementById('aadharicon').click(); return false;\"]//i[@class='zmdi zmdi-upload']")
    public static WebElement Aadharimg;

    @FindBy(xpath="//a[@onclick=\"document.getElementById('icon').click(); return false;\"]//i[@class='zmdi zmdi-upload']")
    public static WebElement PanImg;

    @FindBy(xpath="//a[@onclick=\"document.getElementById('gstimg').click(); return false;\"]//i[@class='zmdi zmdi-upload']")
    public static WebElement Gstimg;

    @FindBy(xpath="//*[text()='Terms & Conditions']")
    public static WebElement Termsconditions;

    @FindBy(xpath="//div[@class='md-container md-ink-ripple']")
    public static WebElement Termsconditionschkbox;

    @FindBy(xpath="//*[text()='Send OTP']")
    public static WebElement SendOTPButton;

    @FindBy(xpath="//*[text()='Cancel']")
    public static WebElement Cancelbutton;

    public static void signup(){

        Signup_Page.Signupbutton.click();
    }

    public static void SetAgencyName(String Agencyname){

        Signup_Page.Agencyname.sendKeys(Agencyname);
    }

    public static void SetFirstname(String Firstname){

        Signup_Page.Firstname.sendKeys(Firstname);
    }

    public static void SetLastname(String Lastname){

        Signup_Page.Lastname.sendKeys(Lastname);
    }

    public static void SetConstitution(String value){

        Select cons = new Select(Signup_Page.Constitution);
        cons.selectByValue(value);
    }

    public static void Setemail(String email){

        Signup_Page.Email.sendKeys(email);
    }

    public static void SetContactType(String value){

        Select contact = new Select(Signup_Page.contactType);
        contact.selectByValue(value);
    }

    public static void SetContactNo(String value){

        Select contact = new Select(Signup_Page.ContactNO);
        contact.selectByValue(value);
    }

    public static void SetLandline(String landline){

        Signup_Page.SetLandline(landline);
    }

    public static void SetGSTnum(String gstno){

        Signup_Page.GSTno.sendKeys(gstno);
    }

    public static void SetAlternativecontactPerson(String Alternativecp){

        Signup_Page.AlternativeContactperson.sendKeys(Alternativecp);
    }

    public static void SetAlternativecontactMobilenumber(String AlternativeMobileNo){

        Signup_Page.AlternativeContactno.sendKeys(AlternativeMobileNo);
    }

    public static void SetNationality(String value){

        Select nation = new Select(Signup_Page.Nationality);
        nation.selectByValue(value);
    }
    public static void SetCountry(String value){

        Select count = new Select(Signup_Page.Country);
        count.selectByValue(value);
    }
    public static void SetState(String value){

        Select state = new Select(Signup_Page.State);
        state.selectByValue(value);
    }
    public static void SetCity(String value){

        Select city = new Select(Signup_Page.City);
        city.selectByValue(value);
    }

    public static void SetArea(String value){

        Select area = new Select(Signup_Page.Area);
        area.selectByValue(value);
    }

    public static void SetAddres(String Address){
        Signup_Page.Address.sendKeys(Address);
    }

    public static void SetUserName(String UserName){
        Signup_Page.username.sendKeys(UserName);
    }

    public static void SetPassword(String Password){
        Signup_Page.password.sendKeys(Password);
    }

    public static void SetAadharNum(String AadharNum){
        Signup_Page.Aaadhar.sendKeys(AadharNum);
    }

    public static void SetPANNum(String PANNum){
        Signup_Page.Pannumber.sendKeys(PANNum);
    }

    public static void ImageUpload() throws InterruptedException, AWTException {
        Thread.sleep(800);
        Signup_Page.Aadharimg.click();
        Robot robot = new Robot();
        Thread.sleep(500);
        StringSelection image = new StringSelection("E:\\EzhilRaj\\Documents\\photo.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(image, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(100);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void SliderClick(){
        Signup_Page.sliderbutton.click();
    }

    public static void TermsandConditions(){

        Signup_Page.Termsconditions.click();
    }

    public static void TermsandConditionschkbx(){

        Signup_Page.Termsconditionschkbox.click();
    }

    public static void SendotpButton(){

        Signup_Page.SendOTPButton.click();
    }

    public static void CancelButton(){

        Signup_Page.Cancelbutton.click();
    }


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

    public static void TextBoxValidation(String Tc,String agencyname ,int rownnum, int cellnum) throws IOException {

        Signup_Page.Agencyname.sendKeys(agencyname);
        if(Signup_Page.Agencyname.getText()!= null){

            driver.navigate().refresh();
            System.out.println(Tc+" TestCase Failed");
            log.error(Tc+"TestCase Failed");
            Reporter.log(Tc+" TestCase Failed");
            xlcon.setCellValue(rownnum,cellnum,"TestCase Failed",excelfilepath);
            Assert.assertTrue(false);

        }else{

            System.out.println(Tc+" TestCase Passed");
            log.info(Tc+" TestCase Passed");
            xlcon.setCellValue(rownnum,cellnum,"TestCase Passed",excelfilepath);
            Assert.assertTrue(true);

        }


    }

    public static void Validate(String errmsg,String Tc, int rownum , int cellnum) throws IOException, InterruptedException {

        if(driver.getPageSource().contains(errmsg)){

            System.out.println(Tc+" TestCase Passed");
            log.info(Tc+" TestCase Passed");
            xlcon.setCellValue(rownum,cellnum,"TestCase Passed",excelfilepath);
            Assert.assertTrue(true);
            Thread.sleep(1000);

        }else {
            driver.navigate().refresh();
            System.out.println(Tc+" TestCase Failed");
            log.error(Tc+" TestCase Failed");
            xlcon.setCellValue(rownum,cellnum,"TestCase Failed",excelfilepath);
            Reporter.log(Tc+"TestCase Failed");
            Assert.assertTrue(false);
        }
    }

}
