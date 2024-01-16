package com.jquery.uploadfile;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;

public class Upload_File extends BaseTest {

	String blue = "blue.png";
	String teal = "teal.png";

	String[] fileNames = { "blue.png", "teal.png" };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_Single_File() {
		homePage.uploadMultipleFiles(driver, blue);
		Assert.assertTrue(homePage.isFileLoadedByName(blue));
		homePage.clickStartButton();
		Assert.assertTrue(homePage.isFileLinkUploadedByName(blue));
		Assert.assertTrue(homePage.isFileImageUploadedByName(blue));
	}

	@Test
	public void Upload_Multiple_Files() {
		homePage.refreshCurrentPage(driver);
		homePage.uploadMultipleFiles(driver, fileNames);
		Assert.assertTrue(homePage.isFileLoadedByName(blue));
		Assert.assertTrue(homePage.isFileLoadedByName(teal));
		homePage.clickStartButton();
		Assert.assertTrue(homePage.isFileLinkUploadedByName(blue));
		Assert.assertTrue(homePage.isFileImageUploadedByName(blue));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(teal));
		Assert.assertTrue(homePage.isFileImageUploadedByName(teal));
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
	private HomePageObject homePage;
}
