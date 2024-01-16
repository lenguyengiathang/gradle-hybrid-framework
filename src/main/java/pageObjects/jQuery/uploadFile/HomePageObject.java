package pageObjects.jQuery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage {

	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.LOADED_FILE_NAME, fileName);
		return isElementDisplayed(driver, HomePageUI.LOADED_FILE_NAME, fileName);
	}

	public void clickStartButton() {
		List<WebElement> numberOfButtons = getWebElements(driver, HomePageUI.START_BUTTON);

		for (WebElement button : numberOfButtons) {
			button.click();
			sleepInSecond(2);
		}

	}

	public boolean isFileLinkUploadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.UPLOADED_FILE_NAME_LINK, fileName);
		return isElementDisplayed(driver, HomePageUI.UPLOADED_FILE_NAME_LINK, fileName);
	}

	public boolean isFileImageUploadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.UPLOADED_FILE_NAME_IMAGE, fileName);
		return isImageLoaded(driver, HomePageUI.UPLOADED_FILE_NAME_IMAGE, fileName);
	}

}
