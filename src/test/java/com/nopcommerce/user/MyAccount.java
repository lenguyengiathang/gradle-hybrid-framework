package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class MyAccount extends BasePage {

	@BeforeClass
	public void beforeClass() {

		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}

		BasePage.getBasePageObject();

		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");

		email = "thang.le" + generateRandomNumber() + "@email.com";
		newPassword = Integer.toString(generateRandomNumber()) + "0";

	}

	@Test
	public void TC_01_Update_Info() {

		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickElement(driver, "//a[@class='ico-register']");
		waitForElementVisible(driver, "//h1[text()='Register']");

		sendKeysToElement(driver, "//input[@id='FirstName']", "Thang");
		sendKeysToElement(driver, "//input[@id='LastName']", "Le");
		sendKeysToElement(driver, "//input[@id='Email']", email);
		sendKeysToElement(driver, "//input[@id='Password']", "123456");
		sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		clickElement(driver, "//button[@id='register-button']");
		waitForElementVisible(driver, "//div[@class='result']");
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
		clickElement(driver, "//a[@class='ico-login']");

		waitForElementVisible(driver, "//h1[text()='Welcome, Please Sign In!']");
		sendKeysToElement(driver, "//input[@id='Email']", email);
		sendKeysToElement(driver, "//input[@id='Password']", "123456");
		clickElement(driver, "//button[@class='button-1 login-button']");

		waitForElementVisible(driver, "//a[@class='ico-account']");
		clickElement(driver, "//a[@class='ico-account']");
		waitForElementVisible(driver, "//h1[text()='My account - Customer info']");

		checkDefaultCheckboxRadio(driver, "//input[@id='gender-female']");
		sendKeysToElement(driver, "//input[@id='FirstName']", "Automation");
		sendKeysToElement(driver, "//input[@id='LastName']", "FC");
		selectItemDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "1");
		selectItemDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "September");
		selectItemDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "1999");
		sendKeysToElement(driver, "//input[@id='Company']", "Company");
		clickElement(driver, "//button[@id='save-info-button']");

		waitForElementVisible(driver, "//div[@class='bar-notification success']/p");
		Assert.assertEquals(getElementText(driver, "//div[@class='bar-notification success']/p"),
				"The customer info has been updated successfully.");

	}

	@Test
	public void TC_02_Add_New_Address() {

		clickElement(driver, "//a[@href='/customer/addresses']");
		waitForElementVisible(driver, "//h1[text()='My account - Addresses']");

		clickElement(driver, "//button[@class='button-1 add-address-button']");
		waitForElementVisible(driver, "//h1[text()='My account - Add new address']");

		sendKeysToElement(driver, "//input[@id='Address_FirstName']", "Thang");
		sendKeysToElement(driver, "//input[@id='Address_LastName']", "Le");
		sendKeysToElement(driver, "//input[@id='Address_Email']", email);
		selectItemDefaultDropdown(driver, "//select[@id='Address_CountryId']", "Viet Nam");
		sendKeysToElement(driver, "//input[@id='Address_City']", "Ho Chi Minh");
		sendKeysToElement(driver, "//input[@id='Address_Address1']", "184 Le Dai Hanh");
		sendKeysToElement(driver, "//input[@id='Address_ZipPostalCode']", "70000");
		sendKeysToElement(driver, "//input[@id='Address_PhoneNumber']", "0123456789");
		clickElement(driver, "//button[@class='button-1 save-address-button']");

		waitForElementVisible(driver, "//div[@class='bar-notification success']/p");
		Assert.assertEquals(getElementText(driver, "//div[@class='bar-notification success']/p"),
				"The new address has been added successfully.");

	}

	@Test
	public void TC_03_Change_Password() {

		clickElement(driver, "//a[@href='/customer/changepassword']");
		waitForElementVisible(driver, "//h1[text()='My account - Change password']");

		sendKeysToElement(driver, "//input[@id='OldPassword']", "123456");
		sendKeysToElement(driver, "//input[@id='NewPassword']", newPassword);
		sendKeysToElement(driver, "//input[@id='ConfirmNewPassword']", newPassword);
		clickElement(driver, "//button[@class='button-1 change-password-button']");

		waitForElementVisible(driver, "//div[@class='bar-notification success']/p");
		Assert.assertEquals(getElementText(driver, "//div[@class='bar-notification success']/p"),
				"Password was changed");

		clickElement(driver, "//span[@class='close']");
		waitForElementVisible(driver, "//a[@class='ico-logout']");
		clickElement(driver, "//a[@class='ico-logout']");
		waitForElementVisible(driver, "//a[@class='ico-login']");
		clickElement(driver, "//a[@class='ico-login']");
		waitForElementVisible(driver, "//h1[text()='Welcome, Please Sign In!']");
		sendKeysToElement(driver, "//input[@id='Email']", email);
		sendKeysToElement(driver, "//input[@id='Password']", newPassword);
		clickElement(driver, "//button[@class='button-1 login-button']");
		waitForElementVisible(driver, "//a[@class='ico-account']");

	}

	@Test
	public void TC_04_Add_Product_Reviews() {

		hoverMouseOverElement(driver, "//a[@href='/computers']");
		waitForElementVisible(driver, "//div[@class='header-menu']/ul[1]/li[1]//a[@href='/desktops']");
		clickElement(driver, "//div[@class='header-menu']/ul[1]/li[1]//a[@href='/desktops']");
		waitForElementVisible(driver, "//h1[text()='Desktops']");

		String productName = getElementText(driver, "//div[@data-productid='1']//h2/a");
		clickElement(driver, "//div[@data-productid='1']");
		waitForElementVisible(driver, "//h1");
		Assert.assertEquals(getElementText(driver, "//h1"), productName);

		clickElement(driver, "//a[text()='Add your review']");
		waitForElementVisible(driver, "//h1");
		Assert.assertEquals(getElementText(driver, "//h1"), "Product reviews for Build your own computer");

		sendKeysToElement(driver, "//input[@id='AddProductReview_Title']", "Title");
		sendKeysToElement(driver, "//textarea[@id='AddProductReview_ReviewText']", "Good product");
		clickElement(driver, "//button[@class='button-1 write-product-review-button']");

		waitForElementVisible(driver, "//a[@class='ico-account']");
		clickElement(driver, "//a[@class='ico-account']");
		waitForElementVisible(driver, "//a[@class='ico-account']");
		clickElement(driver, "//a[@href='/customer/productreviews']");
		Assert.assertEquals(getElementText(driver, "//div[@class='product-review-item']//span[@class='user']"),
				"Product review for: Build your own computer");

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
	private String projectPath = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");
	private String email;
	private String newPassword;

}
