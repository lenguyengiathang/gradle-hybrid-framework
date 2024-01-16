package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {

	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Send keys to 'Emai' textbox with value = {0}")
	public void sendKeysToEmailTextbox(String email) {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_EMAIL_TEXTBOX);
		sendKeysToElement(driver, UserLoginPageUI.LOGIN_EMAIL_TEXTBOX, email);
	}

	@Step("Send keys to 'Password' textbox with value {0}")
	public void sendKeysToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, UserLoginPageUI.LOGIN_PASSWORD_TEXTBOX, password);
	}

	@Step("Click 'Login' button")
	public UserHomePageObject clickLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	@Step("Get email error message")
	public String getEmailErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.LOGIN_EMAIL_ERROR_MESSAGE);
	}

	@Step("Get login error message")
	public String getLoginErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.LOGIN_ERROR_MESSAGE);
	}

	@Step("Log in with email value = {0} and password value = {1}")
	public UserHomePageObject loginAsUser(String email, String password) {
		sendKeysToEmailTextbox(email);
		sendKeysToPasswordTextbox(password);
		return clickLoginButton();
	}

}
