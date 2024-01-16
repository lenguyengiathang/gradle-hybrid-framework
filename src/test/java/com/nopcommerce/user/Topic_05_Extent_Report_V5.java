package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManagerV5;

public class Topic_05_Extent_Report_V5 extends BaseTest {

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
	public void Register(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Register");

		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 01 - Click 'Register' link");
		userRegisterPage = userHomePage.clickRegisterLink();

		ExtentTestManagerV5.getTest().log(Status.INFO,
				"Login - Step 02 - Fill in 'First Name' textbox with value '" + firstName + "'");
		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		ExtentTestManagerV5.getTest().log(Status.INFO,
				"Login - Step 03 - Fill in 'Last Name' textbox with value '" + lastName + "'");
		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		ExtentTestManagerV5.getTest().log(Status.INFO,
				"Login - Step 04 - Fill in 'Email' textbox with value '" + userEmail + "'");
		userRegisterPage.sendKeysToEmailTextbox(userEmail);

		ExtentTestManagerV5.getTest().log(Status.INFO,
				"Login - Step 05 - Fill in 'Password' textbox with value '" + userPassword + "'");
		userRegisterPage.sendKeysToPasswordTextbox(userPassword);

		ExtentTestManagerV5.getTest().log(Status.INFO,
				"Login - Step 06 - Fill in 'Confirm Password' textbox with value '" + userPassword + "'");
		userRegisterPage.sendKeysToConfirmPasswordTextbox(userPassword);

		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 07 - Click 'Register' button");
		userHomePage = userRegisterPage.clickRegisterButton();

		ExtentTestManagerV5.getTest().log(Status.INFO,
				"Login - Step 08 - Verify message 'Your registration complete' is displayed");
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed..");

		ExtentTestManagerV5.endTest();
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
