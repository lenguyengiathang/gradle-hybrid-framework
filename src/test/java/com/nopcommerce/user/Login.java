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
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Login extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Thang";
		lastName = "Le";
		email = "thang.le" + generateRandomNumber() + "@email.com";
		password = "abcdef";

		userRegisterPage = userHomePage.clickRegisterLink();

		userRegisterPage.sendKeysToFirstNameTextbox(firstName);
		userRegisterPage.sendKeysToLastNameTextbox(lastName);
		userRegisterPage.sendKeysToEmailTextbox(email);
		userRegisterPage.sendKeysToPasswordTextbox(password);
		userRegisterPage.sendKeysToConfirmPasswordTextbox(password);

		userHomePage = userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

		userLoginPage = userHomePage.clickLoginLink();

	}

	@Test
	public void TC_01_Log_In_With_Empty_Data() {

		userLoginPage.clickLoginButton();

		Assert.assertEquals(userLoginPage.getEmailErrorMessage(), "Please enter your email");

	}

	@Test
	public void TC_02_Log_In_With_Invalid_Email() {

		userLoginPage = userHomePage.clickLoginLink();

		userLoginPage.loginAsUser("abc", "");

		Assert.assertEquals(userLoginPage.getEmailErrorMessage(), "Wrong email");

	}

	@Test
	public void TC_03_Log_In_With_Email_Not_Registered() {

		userLoginPage = userHomePage.clickLoginLink();

		userLoginPage.loginAsUser("abcxyz@email.com", password);

		Assert.assertEquals(userLoginPage.getLoginErrorMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void TC_04_Log_In_With_Registered_Email_Empty_Password() {

		userLoginPage = userHomePage.clickLoginLink();

		userLoginPage.loginAsUser(email, "");

		Assert.assertEquals(userLoginPage.getLoginErrorMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void TC_05_Log_In_With_Registered_Email_Incorrect_Password() {

		userLoginPage = userHomePage.clickLoginLink();

		userLoginPage.loginAsUser(email, "123456");

		Assert.assertEquals(userLoginPage.getLoginErrorMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void TC_06_Log_In_With_Valid_Data() {

		userLoginPage = userHomePage.clickLoginLink();

		userLoginPage.loginAsUser(email, password);

		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName, email, password;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserHomePageObject userHomePage;

}
