package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Topic_06_Share_Data_A extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		emailAddress = Common_01_Register_End_User.userEmail;
		password = Common_01_Register_End_User.userPassword;

		userLoginPage = userHomePage.clickLoginLink();

		userLoginPage.sendKeysToEmailTextbox(emailAddress);
		userLoginPage.sendKeysToPasswordTextbox(password);
		userLoginPage.clickLoginButton();

	}

	@Test
	public void Search_01_Empty_Data() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String emailAddress, password;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;

}
