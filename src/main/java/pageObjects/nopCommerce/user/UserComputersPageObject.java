package pageObjects.nopCommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserComputersPageUI;

public class UserComputersPageObject extends BasePage {

	private WebDriver driver;

	public UserComputersPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickDesktopsLink() {
		waitForElementClickable(driver, UserComputersPageUI.DESKTOPS_LINK);
		clickElement(driver, UserComputersPageUI.DESKTOPS_LINK);
	}

	public void selectOptionSortByDropdown(WebDriver driver, String locator, String sortOption) {
		waitForElementClickable(driver, locator);
		selectItemDefaultDropdown(driver, locator, sortOption);
	}

	public boolean isDataSortedByNameAscending(WebDriver driver, String locator) {
		List<String> productList = new ArrayList<String>();
		List<WebElement> productListByName = getWebElements(driver, locator);

		for (WebElement product : productListByName) {
			productList.add(product.getText());
		}

		List<String> sortedProductList = new ArrayList<String>();

		for (String product : productList) {
			sortedProductList.add(product);
		}

		Collections.sort(sortedProductList);
		return productList.equals(sortedProductList);
	}

	public boolean isDataSortedByNameDescending(WebDriver driver, String locator) {
		List<String> productList = new ArrayList<String>();
		List<WebElement> productListByName = getWebElements(driver, locator);

		for (WebElement product : productListByName) {
			productList.add(product.getText());
		}

		List<String> sortedProductList = new ArrayList<String>();

		for (String product : productList) {
			sortedProductList.add(product);
		}

		Collections.reverse(sortedProductList);
		return productList.equals(sortedProductList);
	}

	public boolean isDataSortedByPriceAscending(WebDriver driver, String locator) {
		List<Float> productList = new ArrayList<Float>();
		List<WebElement> productListByName = getWebElements(driver, locator);

		for (WebElement product : productListByName) {
			productList.add(Float.parseFloat(product.getText().replace("$", "").trim()));
		}

		List<Float> sortedProductList = new ArrayList<Float>();

		for (Float product : productList) {
			sortedProductList.add(product);
		}

		Collections.sort(sortedProductList);
		return productList.equals(sortedProductList);
	}

	public boolean isDataSortedByPriceDescending(WebDriver driver, String locator) {
		List<Float> productList = new ArrayList<Float>();
		List<WebElement> productListByName = getWebElements(driver, locator);

		for (WebElement product : productListByName) {
			productList.add(Float.parseFloat(product.getText().replace("$", "").trim()));
		}

		List<Float> sortedProductList = new ArrayList<Float>();

		for (Float product : productList) {
			sortedProductList.add(product);
		}

		Collections.reverse(sortedProductList);
		return productList.equals(sortedProductList);
	}

}
