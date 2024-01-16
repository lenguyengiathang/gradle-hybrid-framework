package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageUIs.nopCommerce.user.BasePageUI;
import utilities.UserDataMapper;

public class Topic_11_Manage_Data_02 extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userData = UserDataMapper.getUserData();
		userEmail = userData.getEmail() + generateRandomNumber() + "@email.com";
	}

	@Test
	public void TC_01() {
		log.info("Login - Step 01 - Click 'Register' link");
		userRegisterPage = userHomePage.clickRegisterLink();

		log.info("Login - Step 02 - Fill in 'First Name' textbox with value '" + userData.getFirstName() + "'");
		userRegisterPage.sendKeysToTextboxByID(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, userData.getFirstName(),
				"FirstName");

		log.info("Login - Step 03 - Fill in 'Last Name' textbox with value '" + userData.getLastName() + "'");
		userRegisterPage.sendKeysToTextboxByID(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, userData.getLastName(),
				"LastName");

		log.info("Login - Step 04 - Fill in 'Email' textbox with value '" + userEmail + "'");
		userRegisterPage.sendKeysToTextboxByID(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, userEmail, "Email");

		log.info("Login - Step 05 - Fill in 'Password' textbox with value '" + userData.getPassword() + "'");
		userRegisterPage.sendKeysToTextboxByID(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, userData.getPassword(),
				"Password");

		log.info("Login - Step 06 - Fill in 'Confirm Password' textbox with value '" + userData.getPassword() + "'");
		userRegisterPage.sendKeysToTextboxByID(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, userData.getPassword(),
				"ConfirmPassword");

		log.info("Login - Step 07 - Click 'Register' button");
		userRegisterPage.clickButtonByText(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, "Register");
		PageGeneratorManager.getUserHomePage(driver);

		log.info("Login - Step 08 - Verify message 'Your registration complete' is displayed");
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private String userEmail;
	private UserRegisterPageObject userRegisterPage;
	private UserHomePageObject userHomePage;
	UserDataMapper userData;

}
