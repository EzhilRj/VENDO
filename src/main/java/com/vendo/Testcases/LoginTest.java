package com.vendo.Testcases;

import com.vendo.Pageobjects.Login_Page;
import com.vendo.Utilities.XLConfig;
import org.apache.commons.logging.Log;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import javax.validation.constraints.Null;
import java.awt.*;
import java.io.IOException;


public class LoginTest extends BaseClass {


	@Test
	public void TC_000_VerifyPageTitle() throws InterruptedException, IOException {
		PageFactory.initElements(driver,Login_Page.class);
		Login_Page.gettitle("Task Management System");
	}

	@Test
	public void TC_001_Verify_WithValidCredentials() throws InterruptedException, IOException {

		PageFactory.initElements(driver,Login_Page.class);
		Login_Page.SetCredentials(xlcon.getCellData(1,1),xlcon.getCellData(1,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.Homepageview("mainhome","TC_001_Verify_WithValidCredentials");

	}

	@Test
	public void TC_002_Verify_withCorrectUsername_WrongPassword() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.SetCredentials(xlcon.getCellData(2,1),xlcon.getCellData(2,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.ValidateWrongpassword("Invalid Password.","TC_002_Verify_withCorrectUsername_WrongPassword",2,3);

	}

	@Test
	public void TC_003_Verify_with_WrongUsername_CorrectPassword() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.SetCredentials(xlcon.getCellData(3,1),xlcon.getCellData(3,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.ValidateWrongusername("Invalid Username.","TC_003_Verify_with_WrongUsername_CorrectPassword",3,3);

	}

	@Test
	public void TC_004_Verify_with_InvalidCredentials() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.SetCredentials(xlcon.getCellData(4,1),xlcon.getCellData(4,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.ValidateWrongusername("Invalid Username.","TC_004_Verify_with_InvalidCredentials",4,3);

	}

	@Test
	public void TC_005_Verify_with_SpecialChar() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		xlcon.setCellValue(5,1,GetRandomSpecialCharacters(),excelfilepath);
		xlcon.setCellValue(5,2,GetRandomSpecialCharacters(),excelfilepath);
		Login_Page.SetCredentials(xlcon.getCellData(5,1),xlcon.getCellData(5,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.ValidateWrongusername("Invalid Username.","TC_005_Verify_with_SpecialChar",5,3);

	}

	@Test
	public void TC_006_Verify_with_NumericValues() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		xlcon.setCellValue(6,1,GetRandomNumber(),excelfilepath);
		xlcon.setCellValue(6,2,GetRandomNumber(),excelfilepath);
		Login_Page.SetCredentials(xlcon.getCellData(6,1),xlcon.getCellData(6,2));
		Thread.sleep(500);
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.ValidateWrongusername("Invalid Username.","TC_006_Verify_with_NumericValues",6,3);

	}

	@Test
	public void TC_007_Verify_with_Specialchar_and_Numeric() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		xlcon.setCellValue(7,1,GetRandomNumber()+GetRandomSpecialCharacters(),excelfilepath);
		xlcon.setCellValue(7,2,GetRandomNumber()+GetRandomSpecialCharacters(),excelfilepath);
		Login_Page.SetCredentials(xlcon.getCellData(7,1),xlcon.getCellData(7,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.ValidateWrongusername("Invalid Username.","TC_007_Verify_with_Specialchar_and_Numeric",7,3);

	}

	@Test
	public void TC_008_Verify_Page_Has_Refreshed() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.SetCredentials(xlcon.getCellData(8,1),xlcon.getCellData(8,2));
		Login_Page.Refresh("TC_008_Verify_Page_Has_Refreshed",8,3);

	}

	@Test
	public void TC_009_Verify_withNullValue() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.SetCredentials(xlcon.getCellData(9,1),xlcon.getCellData(9,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.ValidateNullValue("TC_009_Verify_withNullValue",9,3);

	}

	@Test
	public void TC_010_Verify_with_BlankUsername() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.SetCredentials(xlcon.getCellData(10,1),xlcon.getCellData(10,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.ValidateNullUsername("TC_010_Verify_with_BlankUsername",10,3);


	}

	@Test
	public void TC_011_Verify_with_BlankPassword() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.SetCredentials(xlcon.getCellData(11,1),xlcon.getCellData(11,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.ValidateNullValuePassword("TC_011_Verify_with_BlankPassword",11,3);

	}


	@Test
	public void TC_012_Verify_MaxLength_Username() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.MaxlengthValidate("uname",xlcon.getCellData(12,1),"","TC_012_Verify_MaxLength_Username",30,12,3);

	}

	@Test
	public void TC_013_Verify_MaxLength_Password() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.MaxlengthValidate("pword","",xlcon.getCellData(13,2)," TC_013_Verify_MaxLength_Password",30,13,3);

	}

	@Test
	public void TC_014_Verify_Specialchar_is_allowed_Passoword() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		xlcon.setCellValue(14,2,GetRandomSpecialCharacters(),excelfilepath);
		Login_Page.SpecialCharinPassword("TC_014_Verify_Specialchar_is_allowed_Passoword","",xlcon.getCellData(14,2),14,3);

	}

	@Test
	public void TC_015_Verify_Specialchar_in_Password() throws InterruptedException, IOException {

		PageFactory.initElements(driver,Login_Page.class);
		xlcon.setCellValue(15,2,GetRandomSpecialCharacters(),excelfilepath);
		Login_Page.SetCredentials(xlcon.getCellData(15,1),xlcon.getCellData(15,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.ValidateWrongpassword("Invalid Password.","TC_015_Verify_Specialchar_in_Password",15,3);

	}

	@Test
	public void TC_016_Verify_Specialchar_in_Username() throws InterruptedException, IOException {

		PageFactory.initElements(driver,Login_Page.class);
		xlcon.setCellValue(16,1,GetRandomSpecialCharacters(),excelfilepath);
		Login_Page.SetCredentials(xlcon.getCellData(16,1),xlcon.getCellData(16,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.ValidateWrongusername("Invalid Username.","TC_016_Verify_Specialchar_in_Username",16,3);


	}

	@Test
	public void TC_017_Verify_Numerics_in_Password() throws InterruptedException, IOException {

		PageFactory.initElements(driver,Login_Page.class);
		xlcon.setCellValue(17,2,GetRandomNumber(),excelfilepath);
		Login_Page.SetCredentials(xlcon.getCellData(17,1),xlcon.getCellData(17,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.ValidateWrongpassword("Invalid Password.","TC_017_Verify_Numerics_in_Password",17,3);

	}

	@Test
	public void TC_018_Verify_Numerics_in_Username() throws InterruptedException, IOException {

		PageFactory.initElements(driver,Login_Page.class);
		xlcon.setCellValue(18,1,GetRandomNumber(),excelfilepath);
		Login_Page.SetCredentials(xlcon.getCellData(18,1),xlcon.getCellData(18,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.ValidateWrongusername("Invalid Username.","TC_018_Verify_Numerics_in_Username",18,3);


	}
}