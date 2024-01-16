package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Topic_02_Switch_Role extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Thang";
		lastName = "Le";
		userEmail = "thang.le" + generateRandomNumber() + "@email.com";
		userPassword = "123456";
		adminEmail = "admin@yourstore.com";
		adminPassword = "admin";

		userRegisterPage = userHomePage.clickRegisterLink();

		userRegisterPage.sendKeysToFirstNameTextbox(firstName);
		userRegisterPage.sendKeysToLastNameTextbox(lastName);
		userRegisterPage.sendKeysToEmailTextbox(userEmail);
		userRegisterPage.sendKeysToPasswordTextbox(userPassword);
		userRegisterPage.sendKeysToConfirmPasswordTextbox(userPassword);
		userRegisterPage.clickRegisterButton();

		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

		userHomePage = userRegisterPage.clickLogoutLink();

	}

	@Test
	public void Log_In_As_User() {
		userLoginPage = userHomePage.clickLoginLink();
		userHomePage = userLoginPage.loginAsUser(userEmail, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void Log_In_As_Admin() {
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
		dashBoardPage = PageGeneratorManager.getAdminDashboardPage(driver);
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
	private String firstName, lastName, userEmail, userPassword, adminEmail, adminPassword;
	private UserRegisterPageObject userRegisterPage;
	private UserLoginPageObject userLoginPage;
	private UserHomePageObject userHomePage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject dashBoardPage;

}
