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

public class Topic_05_Extent_Report_V4 extends BaseTest {

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
		userRegisterPage = userHomePage.clickRegisterLink();

		userRegisterPage.sendKeysToFirstNameTextbox(firstName);

		userRegisterPage.sendKeysToLastNameTextbox(lastName);

		userRegisterPage.sendKeysToEmailTextbox(userEmail);

		userRegisterPage.sendKeysToPasswordTextbox(userPassword);

		userRegisterPage.sendKeysToConfirmPasswordTextbox(userPassword);

		userHomePage = userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed.");
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
