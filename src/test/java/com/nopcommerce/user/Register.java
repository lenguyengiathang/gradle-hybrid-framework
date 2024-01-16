package com.nopcommerce.user;

import java.util.Random;

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

public class Register extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Thang";
		lastName = "Le";
		email = "thang.le" + generateRandomNumber() + "@email.com";
		password = "123456";

	}

	@Test
	public void TC_01_Register_With_Empty_Data() {

		registerPage = homePage.clickRegisterLink();

		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");

	}

	@Test
	public void TC_02_Register_With_Invalid_Email() {

		registerPage = homePage.clickRegisterLink();

		registerPage.sendKeysToFirstNameTextbox(firstName);
		registerPage.sendKeysToLastNameTextbox(lastName);
		registerPage.sendKeysToEmailTextbox("abc");
		registerPage.sendKeysToPasswordTextbox(password);
		registerPage.sendKeysToConfirmPasswordTextbox(password);
		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");

	}

	@Test
	public void TC_03_Register_With_Valid_Data() {

		registerPage = homePage.clickRegisterLink();

		registerPage.sendKeysToFirstNameTextbox(firstName);
		registerPage.sendKeysToLastNameTextbox(lastName);
		registerPage.sendKeysToEmailTextbox(email);
		registerPage.sendKeysToPasswordTextbox(password);
		registerPage.sendKeysToConfirmPasswordTextbox(password);
		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void TC_04_Register_With_Existing_Email() {

		registerPage = homePage.clickRegisterLink();

		registerPage.sendKeysToFirstNameTextbox(firstName);
		registerPage.sendKeysToLastNameTextbox(lastName);
		registerPage.sendKeysToEmailTextbox(email);
		registerPage.sendKeysToPasswordTextbox(password);
		registerPage.sendKeysToConfirmPasswordTextbox(password);
		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getExistingEmailErrorMessage(), "The specified email already exists");

	}

	@Test
	public void TC_05_Register_With_Password_Fewer_Than_6_Characters() {

		registerPage = homePage.clickRegisterLink();

		registerPage.sendKeysToFirstNameTextbox(firstName);
		registerPage.sendKeysToLastNameTextbox(lastName);
		registerPage.sendKeysToEmailTextbox(email);
		registerPage.sendKeysToPasswordTextbox("12345");
		registerPage.sendKeysToConfirmPasswordTextbox("12345");
		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorMessage(),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_With_Incorrect_Confirmation_Password() {

		registerPage = homePage.clickRegisterLink();

		registerPage.sendKeysToFirstNameTextbox(firstName);
		registerPage.sendKeysToLastNameTextbox(lastName);
		registerPage.sendKeysToEmailTextbox(email);
		registerPage.sendKeysToPasswordTextbox(password);
		registerPage.sendKeysToConfirmPasswordTextbox("abcdef");
		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(),
				"The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	private WebDriver driver;
	private String firstName, lastName, email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

}
