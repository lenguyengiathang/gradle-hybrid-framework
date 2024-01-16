package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserComputersPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageUIs.nopCommerce.user.UserComputersPageUI;

public class Topic_09_Sort extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userComputersPage = userHomePage.clickComputersTab();
		userComputersPage.clickDesktopsLink();
	}

	@Test
	public void TC_01_Sort_By_Name_Asc() {
		userComputersPage.selectOptionSortByDropdown(driver, UserComputersPageUI.SORT_BY_DROPDOWN, "Name: A to Z");
		userComputersPage.isDataSortedByNameAscending(driver, UserComputersPageUI.PRODUCT_NAME);
		sleepInSecond(5);
	}

	@Test
	public void TC_02_Sort_By_Name_Des() {
		userComputersPage.selectOptionSortByDropdown(driver, UserComputersPageUI.SORT_BY_DROPDOWN, "Name: Z to A");
		userComputersPage.isDataSortedByNameDescending(driver, UserComputersPageUI.PRODUCT_NAME);
		sleepInSecond(5);
	}

	@Test
	public void TC_03_Sort_By_Price_Asc() {
		userComputersPage.selectOptionSortByDropdown(driver, UserComputersPageUI.SORT_BY_DROPDOWN,
				"Price: Low to High");
		userComputersPage.isDataSortedByNameAscending(driver, UserComputersPageUI.PRODUCT_PRICE);
		sleepInSecond(5);
	}

	@Test
	public void TC_04_Sort_By_Price_Des() {
		userComputersPage.selectOptionSortByDropdown(driver, UserComputersPageUI.SORT_BY_DROPDOWN,
				"Price: High to Low");
		userComputersPage.isDataSortedByNameAscending(driver, UserComputersPageUI.PRODUCT_PRICE);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserComputersPageObject userComputersPage;

}
