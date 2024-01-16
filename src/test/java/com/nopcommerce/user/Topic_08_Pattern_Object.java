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

public class Topic_08_Pattern_Object extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Thang";
		lastName = "Le";
		userEmail = "thang.le" + generateRandomNumber() + "@email.com";
		userPassword = "123456";
	}

	@Test
	public void TC_01() {
		log.info("Login - Step 01 - Click 'Register' link");
		userRegisterPage = userHomePage.clickRegisterLink();

		log.info("Login - Step 02 - Fill in 'First Name' textbox with value '" + firstName + "'");
		userRegisterPage.sendKeysToTextboxByID(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, firstName, "FirstName");

		log.info("Login - Step 03 - Fill in 'Last Name' textbox with value '" + lastName + "'");
		userRegisterPage.sendKeysToTextboxByID(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, lastName, "LastName");

		log.info("Login - Step 04 - Fill in 'Email' textbox with value '" + userEmail + "'");
		userRegisterPage.sendKeysToTextboxByID(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, userEmail, "Email");

		log.info("Login - Step 05 - Fill in 'Password' textbox with value '" + userPassword + "'");
		userRegisterPage.sendKeysToTextboxByID(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, userPassword, "Password");

		log.info("Login - Step 06 - Fill in 'Confirm Password' textbox with value '" + userPassword + "'");
		userRegisterPage.sendKeysToTextboxByID(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, userPassword,
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
	private String firstName, lastName, userEmail, userPassword;
	private UserRegisterPageObject userRegisterPage;
	private UserHomePageObject userHomePage;

}
