package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;

public class DataTable extends BaseTest {

	HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

//	@Test
//	public void TC_01_Paging() {
//		homePage.openPagingByPageNumber("10");
//		Assert.assertTrue(homePage.isPageNumberActive("10"));
//	}
//
//	@Test
//	public void TC_02_Send_Keys_To_Header_Textbox() {
//		homePage.sendKeysToHeaderTextboxByLabel("Country", "Argentina");
//	}
//
//	@Test
//	public void TC_03_Get_Data_From_Table() {
//		homePage.getCellValueEachRowFromEachPage();
//	}

	@Test
	public void TC_04_Send_Keys_To_Textbox_Any_Row() {
		homePage.sendKeysToTextBoxAtRowNummber("Company", "2", "Ekino");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "2", "Malaysia");
		homePage.clickIconEndOfRow("1", "Insert Row Above");
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	private WebDriver driver;

}
