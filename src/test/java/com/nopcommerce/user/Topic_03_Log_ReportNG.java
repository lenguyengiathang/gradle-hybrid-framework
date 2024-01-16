package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Topic_03_Log_ReportNG extends BaseTest {

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
	public void Register() {
		log.info("Login - Step 01 - Click 'Register' link");
		userRegisterPage = userHomePage.clickRegisterLink();

		log.info("Login - Step 02 - Fill in 'First Name' textbox with value '" + firstName + "'");
		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		log.info("Login - Step 03 - Fill in 'Last Name' textbox with value '" + lastName + "'");
		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		log.info("Login - Step 04 - Fill in 'Email' textbox with value '" + userEmail + "'");
		userRegisterPage.sendKeysToEmailTextbox(userEmail);

		log.info("Login - Step 05 - Fill in 'Password' textbox with value '" + userPassword + "'");
		userRegisterPage.sendKeysToPasswordTextbox(userPassword);

		log.info("Login - Step 06 - Fill in 'Confirm Password' textbox with value '" + userPassword + "'");
		userRegisterPage.sendKeysToConfirmPasswordTextbox(userPassword);

		log.info("Login - Step 07 - Click 'Register' button");
		userHomePage = userRegisterPage.clickRegisterButton();

		log.info("Login - Step 08 - Verify message 'Your registration complete' is displayed");
		verifyEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed..");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName, userEmail, userPassword;
	private UserRegisterPageObject userRegisterPage;
	private UserHomePageObject userHomePage;

}
