package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Search_AdvancedSearch extends BasePage {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String fakeEmail;

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

		fakeEmail = "thang.le" + generateRandomNumber() + "@email.com";

		clickElement(driver, "//a[@class='ico-register']");
		waitForElementVisible(driver, "//h1[text()='Register']");

		sendKeysToElement(driver, "//input[@id='FirstName']", "Thang");
		sendKeysToElement(driver, "//input[@id='LastName']", "Le");
		sendKeysToElement(driver, "//input[@id='Email']", fakeEmail);
		sendKeysToElement(driver, "//input[@id='Password']", "123456");
		sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		clickElement(driver, "//button[@id='register-button']");
		waitForElementVisible(driver, "//div[@class='result']");
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

		clickElement(driver, "//a[@class='ico-login']");
		waitForElementVisible(driver, "//h1[text()='Welcome, Please Sign In!']");
		sendKeysToElement(driver, "//input[@id='Email']", fakeEmail);
		sendKeysToElement(driver, "//input[@id='Password']", "123456");
		clickElement(driver, "//button[@class='button-1 login-button']");

		waitForElementVisible(driver, "//a[@class='ico-account']");
		clickElement(driver, "//a[text()='Search']");
		waitForElementVisible(driver, "//input[@id='q']");

	}

	@Test
	public void TC_01_Search_With_Empty_Data() {

		sendKeysToElement(driver, "//input[@id='q']", "");
		clickElement(driver, "//button[text()='Search']");

		waitForElementVisible(driver, "//div[@class='warning']");
		Assert.assertEquals(getElementText(driver, "//div[@class='warning']"),
				"Search term minimum length is 3 characters");

	}

	@Test
	public void TC_02_Search_With_Not_Existing_Data() {

		sendKeysToElement(driver, "//input[@id='q']", "MacBook Pro 2050");
		clickElement(driver, "//button[text()='Search']");

		waitForElementVisible(driver, "//div[@class='no-result']");
		Assert.assertEquals(getElementText(driver, "//div[@class='no-result']"),
				"No products were found that matched your criteria.");

	}

	@Test
	public void TC_03_Search_With_Partial_Product_Name() {

		sendKeysToElement(driver, "//input[@id='q']", "Lenovo");
		clickElement(driver, "//button[text()='Search']");

		waitForElementVisible(driver, "//a[contains(text(),'Lenovo')]");
		Assert.assertEquals(getElementsSize(driver, "//a[contains(text(),'Lenovo')]"), 2);

	}

	@Test
	public void TC_04_Search_With_Full_Product_Name() {

		sendKeysToElement(driver, "//input[@id='q']", "ThinkPad X1 Carbon");
		clickElement(driver, "//button[text()='Search']");

		waitForElementVisible(driver, "//a[contains(text(),'ThinkPad')]");
		Assert.assertEquals(getElementsSize(driver, "//a[contains(text(),'ThinkPad')]"), 1);

	}

	@Test
	public void TC_05_Advanced_Search_Parent_Categories() {

		sendKeysToElement(driver, "//input[@id='q']", "Apple MacBook Pro");
		checkDefaultCheckboxRadio(driver, "//input[@id='advs']");
		waitForElementVisible(driver, "//select[@id='cid']");
		selectItemDefaultDropdown(driver, "//select[@id='cid']", "Computers");
		clickElement(driver, "//button[text()='Search']");

		waitForElementVisible(driver, "//div[@class='no-result']");
		Assert.assertEquals(getElementText(driver, "//div[@class='no-result']"),
				"No products were found that matched your criteria.");

	}

	@Test
	public void TC_06_Advanced_Search_Sub_Categories() {

		sendKeysToElement(driver, "//input[@id='q']", "Apple MacBook Pro");
		checkDefaultCheckboxRadio(driver, "//input[@id='advs']");
		waitForElementVisible(driver, "//select[@id='cid']");
		selectItemDefaultDropdown(driver, "//select[@id='cid']", "Computers");
		checkDefaultCheckboxRadio(driver, "//input[@id='isc']");
		clickElement(driver, "//button[text()='Search']");

		waitForElementVisible(driver, "//a[text()='Apple MacBook Pro 13-inch']");

	}

	@Test
	public void TC_07_Advanced_Search_Incorrect_Manufacturer() {

	}

	@Test
	public void TC_08_Advanced_Search_Correct_Manufacturer() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

}
