package pageObjects.jQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.dataTable.HomePageUI;

public class HomePageObject extends BasePage {

	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void sendKeysToHeaderTextboxByLabel(String label, String text) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, label);
		sendKeysToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, text, label);
		pressKeyOnElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, label);
	}

	public boolean isPageNumberActive(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}

	public List<String> getCellValueEachRowFromEachPage() {
		int totalPages = getElementsSize(driver, HomePageUI.TOTAL_PAGINATION);

		List<String> values = new ArrayList<String>();

		for (int index = 1; index <= totalPages; index++) {
			clickElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, String.valueOf(index));
			sleepInSecond(1);

			List<WebElement> numberOfRows = getWebElements(driver, HomePageUI.NUMBER_OF_ROWS_EACH_PAGE);
			for (WebElement row : numberOfRows) {
				values.add(row.getText());
			}
		}
		return values;
	}

	public void sendKeysToTextBoxAtRowNummber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_ROW_AND_COLUMN_INDEX, rowNumber,
				String.valueOf(columnIndex));
		sendKeysToElement(driver, HomePageUI.TEXTBOX_BY_ROW_AND_COLUMN_INDEX, value, rowNumber,
				String.valueOf(columnIndex));
	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String textItem) {
		int columnIndex = getElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_ROW_AND_COLUMN_INDEX, rowNumber,
				String.valueOf(columnIndex));
		selectItemDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_ROW_AND_COLUMN_INDEX, textItem, rowNumber,
				String.valueOf(columnIndex));

	}

	public void clickIconEndOfRow(String rowNumber, String title) {
		waitForElementClickable(driver, HomePageUI.ICON_BY_ROW_NUMBER, rowNumber, title);
		clickElement(driver, HomePageUI.ICON_BY_ROW_NUMBER, rowNumber, title);
	}
}
