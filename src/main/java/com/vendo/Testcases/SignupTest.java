package com.vendo.Testcases;

import com.vendo.Pageobjects.Login_Page;
import com.vendo.Pageobjects.Signup_Page;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class SignupTest extends BaseClass {



    @Test
    public void SignupSheetSetter() throws IOException {

        sheetsetter("Signup");
    }

    @Test
    public void TC_001_VerifyRegistrationPageTitle() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Signup_Page.class);
        Signup_Page.signup();
        Signup_Page.gettitle(xlcon.getCellData(1,1),"TC_001_VerifyRegistrationPageTitle",1,3);

    }

    @Test
    public void TC_002_Verify_SpecialCharacters_allowed_in_Agencyname() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Signup_Page.class);
        xlcon.setCellValue(2,1,GetRandomSpecialCharacters(),filepath);
        Signup_Page.TextBoxValidation("TC_002_Verify_SpecialCharacters_allowed_in_Agencyname",xlcon.getCellData(2,1),2,3);

    }

    @Test
    public void TC_003_Verify_Numbers_allowed_in_Agencyname() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Signup_Page.class);
        xlcon.setCellValue(3,1,GetRandomNumber(),filepath);
        Signup_Page.TextBoxValidation("TC_003_Verify_Numbers_allowed_in_Agencyname",xlcon.getCellData(3,1),3,3);

    }

    @Test
    public void TC_004_Verify_ErrorMessage_is_showing_In_AgencyName() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Signup_Page.class);
        Signup_Page.SetAgencyName(xlcon.getCellData(4,1));
        Signup_Page.Agencyname.clear();
        Signup_Page.Validate(xlcon.getCellData(4,2),"TC_004_Verify_ErrorMessage_is_showing_In_AgencyName",4,3);

    }

    @Test
    public void TC_005_Verify_ExistingAgencyName_is_Allowed() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Signup_Page.class);
        Signup_Page.SetAgencyName(xlcon.getCellData(5,1));
        Login_Page.Validate(xlcon.getCellData(5,1),"TC_005_Verify_ExistingAgencyName_is_Allowed",5,3);


    }




}
