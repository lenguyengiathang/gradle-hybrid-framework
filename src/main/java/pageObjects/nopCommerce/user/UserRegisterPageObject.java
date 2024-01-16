package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {

	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click 'Register' button")
	public UserHomePageObject clickRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	@Step("Get First Name error message")
	public String getFirstNameErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	@Step("Get Last Name error message")
	public String getLastNameErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	@Step("Get Email error message")
	public String getEmailErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	@Step("Get Password error message")
	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	@Step("Get Confirm Password error message")
	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	@Step("Get Email error message")
	public void sendKeysToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	@Step("Send keys to 'Last Name' textbox with value = {0}")
	public void sendKeysToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	@Step("Send keys to 'Email' textbox with value = {0}")
	public void sendKeysToEmailTextbox(String email) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
	}

	@Step("Send keys to 'Password' textbox with value = {0}")
	public void sendKeysToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Send keys to 'Confirm Password' textbox with value = {0}")
	public void sendKeysToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	@Step("Get register success message")
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	@Step("Get existing email error message")
	public String getExistingEmailErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

	@Step("Click 'Logout' link")
	public UserHomePageObject clickLogoutLink() {
		waitForElementVisible(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	@Step("Click 'Login' link")
	public UserLoginPageObject clickLoginLink() {
		waitForElementVisible(driver, UserRegisterPageUI.LOGIN_LINK);
		clickElement(driver, UserRegisterPageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

}
