package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_Cookie extends BaseTest {

	@Parameters("browser")
	@BeforeTest(description = "Create new user for all classes")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Thang";
		lastName = "Le";
		userEmail = "thang.le" + generateRandomNumber() + "@email.com";
		userPassword = "123456";

		log.info("Pre-condition - Step 01 - Click 'Register' link");
		userRegisterPage = userHomePage.clickRegisterLink();

		log.info("Pre-condition - Step 02 - Fill in 'First Name' textbox with value '" + firstName + "'");
		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		log.info("Pre-condition - Step 03 - Fill in 'Last Name' textbox with value '" + lastName + "'");
		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		log.info("Pre-condition - Step 04 - Fill in 'Email' textbox with value '" + userEmail + "'");
		userRegisterPage.sendKeysToEmailTextbox(userEmail);

		log.info("Pre-condition - Step 05 - Fill in 'Password' textbox with value '" + userPassword + "'");
		userRegisterPage.sendKeysToPasswordTextbox(userPassword);

		log.info("Pre-condition - Step 06 - Fill in 'Confirm Password' textbox with value '" + userPassword + "'");
		userRegisterPage.sendKeysToConfirmPasswordTextbox(userPassword);

		log.info("Pre-condition - Step 07 - Click 'Register' button");
		userHomePage = userRegisterPage.clickRegisterButton();

		log.info("Pre-condition - Step 08 - Verify message 'Your registration complete' is displayed");
		verifyEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Pre-condition - Step 09 - Click 'Login' link");
		userLoginPage = userRegisterPage.clickLoginLink();

		log.info("Pre-condition - Step 10 - Fill in 'Email' textbox with value '" + userEmail + "'");
		userLoginPage.sendKeysToEmailTextbox(userEmail);

		log.info("Pre-condition - Step 11 - Fill in 'Password' textbox with value '" + userPassword + "'");
		userLoginPage.sendKeysToPasswordTextbox(userPassword);

		log.info("Pre-condition - Step 12 - Click 'Login' button");
		userLoginPage.clickLoginButton();

		loggedCookies = userHomePage.getCookies(driver);

		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName;
	private UserRegisterPageObject userRegisterPage;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	public static String userEmail, userPassword;
	public static Set<Cookie> loggedCookies;

}
