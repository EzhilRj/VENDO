package com.vendo.Testcases;

import com.vendo.Pageobjects.Login_Page;
import com.vendo.Utilities.XLConfig;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginTest extends BaseClass {

	@Test
	public void LoginSheetSetter() throws IOException {

		sheetsetter("Login");

	}

	@Test
	public void TC_000_VerifyPageTitle() throws InterruptedException, IOException {

		PageFactory.initElements(driver,Login_Page.class);
		Login_Page.gettitle(xlcon.getCellData(1,3),"TC_000_VerifyPageTitle",1,4);
	}

	@Test
	public void TC_001_Verify_WithValidCredentials() throws InterruptedException, IOException {

		PageFactory.initElements(driver,Login_Page.class);
		Login_Page.SetCredentials(xlcon.getCellData(2,1),xlcon.getCellData(2,2));
		Login_Page.Loginbutton();
		Thread.sleep(2000);
		Login_Page.Homepageview(xlcon.getCellData(2,3),"TC_001_Verify_WithValidCredentials",2,4);
	}

	@Test
	public void TC_002_Verify_withCorrectUsername_WrongPassword() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.SetCredentials(xlcon.getCellData(3,1),xlcon.getCellData(3,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.Validate(xlcon.getCellData(3,3),"TC_002_Verify_withCorrectUsername_WrongPassword",3,4);

	}

	@Test
	public void TC_003_Verify_with_WrongUsername_CorrectPassword() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.SetCredentials(xlcon.getCellData(4,1),xlcon.getCellData(4,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.Validate(xlcon.getCellData(4,3), "TC_003_Verify_with_WrongUsername_CorrectPassword",4,4);

	}

	@Test
	public void TC_004_Verify_with_InvalidCredentials() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.SetCredentials(xlcon.getCellData(5,1),xlcon.getCellData(5,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.Validate(xlcon.getCellData(5,3), "TC_004_Verify_with_InvalidCredentials",5,4);

	}

	@Test
	public void TC_005_Verify_with_SpecialChar() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		xlcon.setCellValue(6,1,GetRandomSpecialCharacters(),excelfilepath);
		xlcon.setCellValue(6,2,GetRandomSpecialCharacters(),excelfilepath);
		Login_Page.SetCredentials(xlcon.getCellData(6,1),xlcon.getCellData(6,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.Validate(xlcon.getCellData(6,3), "TC_005_Verify_with_SpecialChar",6,4);

	}

	@Test
	public void TC_006_Verify_with_NumericValues() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		xlcon.setCellValue(7,1,GetRandomNumber(),excelfilepath);
		xlcon.setCellValue(7,2,GetRandomNumber(),excelfilepath);
		Login_Page.SetCredentials(xlcon.getCellData(7,1),xlcon.getCellData(7,2));
		Thread.sleep(500);
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.Validate(xlcon.getCellData(7,3), "TC_006_Verify_with_NumericValues",7,4);

	}

	@Test
	public void TC_007_Verify_with_Specialchar_and_Numeric() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		xlcon.setCellValue(8,1,GetRandomNumber()+GetRandomSpecialCharacters(),excelfilepath);
		xlcon.setCellValue(8,2,GetRandomNumber()+GetRandomSpecialCharacters(),excelfilepath);
		Login_Page.SetCredentials(xlcon.getCellData(8,1),xlcon.getCellData(8,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.Validate(xlcon.getCellData(8,3), "TC_007_Verify_with_Specialchar_and_Numeric",8,4);

	}

	@Test
	public void TC_008_Verify_Page_Has_Refreshed() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.SetCredentials(xlcon.getCellData(9,1),"");
		Login_Page.Refresh(xlcon.getCellData(9,1),"TC_008_Verify_Page_Has_Refreshed",9,4);

	}

	@Test
	public void TC_009_Verify_withNullValue() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.SetCredentials(xlcon.getCellData(10,1),xlcon.getCellData(10,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.ValidateNullValue("TC_009_Verify_withNullValue", xlcon.getCellData(11,3), xlcon.getCellData(12,3),10,4);

	}

	@Test
	public void TC_010_Verify_with_BlankUsername() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.SetCredentials(xlcon.getCellData(11,1),xlcon.getCellData(11,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.Validate(xlcon.getCellData(11,3), "TC_010_Verify_with_BlankUsername",11,4);


	}

	@Test
	public void TC_011_Verify_with_BlankPassword() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.SetCredentials(xlcon.getCellData(12,1),xlcon.getCellData(12,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.ValidateNullValuePassword("TC_011_Verify_with_BlankPassword",12,4);

	}

	@Test
	public void TC_012_Verify_MaxLength_Username() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.MaxlengthValidate("uname",xlcon.getCellData(13,1),"","TC_012_Verify_MaxLength_Username",xlcon.getCellData(13,3),13,4);

	}

	@Test
	public void TC_013_Verify_MaxLength_Password() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		Login_Page.MaxlengthValidate("pword","",xlcon.getCellData(14,2)," TC_013_Verify_MaxLength_Password",xlcon.getCellData(14,3),14,4);

	}

	@Test
	public void TC_014_Verify_Specialchar_is_allowed_Passoword() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Login_Page.class);
		xlcon.setCellValue(15,2,GetRandomSpecialCharacters(),excelfilepath);
		Login_Page.SpecialCharinPassword("TC_014_Verify_Specialchar_is_allowed_Passoword","",xlcon.getCellData(15,2),15,4);

	}

	@Test
	public void TC_015_Verify_Specialchar_in_Password() throws InterruptedException, IOException {

		PageFactory.initElements(driver,Login_Page.class);
		xlcon.setCellValue(16,2,GetRandomSpecialCharacters(),excelfilepath);
		Login_Page.SetCredentials(xlcon.getCellData(16,1),xlcon.getCellData(16,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.Validate(xlcon.getCellData(16,3),"TC_015_Verify_Specialchar_in_Password",16,4);

	}

	@Test
	public void TC_016_Verify_Specialchar_in_Username() throws InterruptedException, IOException {

		PageFactory.initElements(driver,Login_Page.class);
		xlcon.setCellValue(17,1,GetRandomSpecialCharacters(),excelfilepath);
		Login_Page.SetCredentials(xlcon.getCellData(17,1),xlcon.getCellData(17,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.Validate(xlcon.getCellData(17,3),"TC_016_Verify_Specialchar_in_Username",17,4);


	}

	@Test
	public void TC_017_Verify_Numerics_in_Password() throws InterruptedException, IOException {

		PageFactory.initElements(driver,Login_Page.class);
		xlcon.setCellValue(18,2,GetRandomNumber(),excelfilepath);
		Login_Page.SetCredentials(xlcon.getCellData(18,1),xlcon.getCellData(18,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.Validate(xlcon.getCellData(18,3),"TC_017_Verify_Numerics_in_Password",18,4);

	}

	@Test
	public void TC_018_Verify_Numerics_in_Username() throws InterruptedException, IOException {

		PageFactory.initElements(driver,Login_Page.class);
		xlcon.setCellValue(19,1,GetRandomNumber(),excelfilepath);
		Login_Page.SetCredentials(xlcon.getCellData(19,1),xlcon.getCellData(19,2));
		Login_Page.Loginbutton();
		Thread.sleep(1000);
		Login_Page.Validate(xlcon.getCellData(19,3), "TC_018_Verify_Numerics_in_Username",19,4);


	}
}