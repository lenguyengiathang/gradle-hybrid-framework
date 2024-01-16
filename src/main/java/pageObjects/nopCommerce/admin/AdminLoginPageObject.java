package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {

	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void sendKeysToEmailTextbox(String email) {
		waitForElementVisible(driver, AdminLoginPageUI.LOGIN_EMAIL_TEXTBOX);
		sendKeysToElement(driver, AdminLoginPageUI.LOGIN_EMAIL_TEXTBOX, email);
	}

	public void sendKeysToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.LOGIN_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, AdminLoginPageUI.LOGIN_PASSWORD_TEXTBOX, password);
	}

	public AdminDashboardPageObject clickLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public AdminDashboardPageObject loginAsAdmin(String email, String password) {
		sendKeysToEmailTextbox(email);
		sendKeysToPasswordTextbox(password);
		return clickLoginButton();
	}

}
