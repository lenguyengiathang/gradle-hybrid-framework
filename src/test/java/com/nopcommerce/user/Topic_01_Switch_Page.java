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
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserOrdersPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Topic_01_Switch_Page extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Thang";
		lastName = "Le";
		userEmail = "thang.le" + generateRandomNumber() + "@email.com";
		userPassword = "123456";

		userRegisterPage = userHomePage.clickRegisterLink();

		userRegisterPage.sendKeysToFirstNameTextbox(firstName);
		userRegisterPage.sendKeysToLastNameTextbox(lastName);
		userRegisterPage.sendKeysToEmailTextbox(userEmail);
		userRegisterPage.sendKeysToPasswordTextbox(userPassword);
		userRegisterPage.sendKeysToConfirmPasswordTextbox(userPassword);

		userHomePage = userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

		userLoginPage = userHomePage.clickLoginLink();
	}

	@Test
	public void Login() {
		userHomePage = userLoginPage.loginAsUser(userEmail, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		customerInfoPage = userHomePage.clickMyAccountLink();
	}

	@Test
	public void Switch_Page_Sidebar() {
		// Customer Info -> Orders
		ordersPage = (UserOrdersPageObject) customerInfoPage.openPagesAtMyAccountByName(driver, "Orders");
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
	private String firstName, lastName, userEmail, userPassword;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserHomePageObject userHomePage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserOrdersPageObject ordersPage;
}
