package com.spinny.qa.utils;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.spinny.qa.pages.GetUserOPTNumberPage;
import com.spinny.qa.testbase.TestBase;

public class UserFunctions {

	private WebDriver driver;
	private final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	public static PropertiesManager properties = PropertiesManager.getInstance();

	private final By LOGIN_USER_BTN = By.xpath("//li[@class='login-user']");
	private final By MOBILE_NUMBER_TEXTFIELD = By.xpath("//input[@id='login_number']");
	private final By GETOTP_NUMBER_BTN = By.xpath("//button[@type='submit' and text()='GET OTP']");
	private final By GETOTP_NUMBER_TEXTFIELD = By
			.xpath("//section[@class='returning-user-section']//div[@class='input-section']//input");
	private final By SUBMIT_BTN = By
			.xpath("//section[@class='returning-user-section']//div[@class='button-section']//button[1]");
	private final By LOGOUT_BUTTON = By.xpath(
			"//li[@class='login-user']//ul[@class='submenu user-submenu ng-scope']//li[@class='link logout']//a[text()='Logout']");
	private final By USERNAME = By
			.xpath("//li[@class='login-user']//li[@class='user-name']/child::a[text()='Welcome Dheera']");

	public UserFunctions(WebDriver driver) {
		this.driver = driver;
	}

	public String getUserName() {
		String str="";
		try {
			str=SeleniumUtils.waitForElementPresence(driver, USERNAME, WAIT_SECONDS).getText();
		} catch (Exception e) {
			throw e;
		}
		return str;
	}
	
	public void clickLoginUserButton() {
		SeleniumUtils.waitForElementPresence(driver, LOGIN_USER_BTN, WAIT_SECONDS).click();
	}

	public void enterUserMobileNumber(String userMobileNumber) {
		SeleniumUtils.waitForElementPresence(driver, MOBILE_NUMBER_TEXTFIELD, WAIT_SECONDS).sendKeys(userMobileNumber);
	}

	public void clickOnGETOTPNumberButton() {
		SeleniumUtils.waitForElementPresence(driver, GETOTP_NUMBER_BTN, WAIT_SECONDS).click();
	}

	public void enterUserGETOTPNumber(String userMobileNumber) {
		SeleniumUtils.waitForElementPresence(driver, GETOTP_NUMBER_TEXTFIELD, WAIT_SECONDS).sendKeys(userMobileNumber);
	}

	public void clickOnSubmitButton() {
		SeleniumUtils.waitForElementPresence(driver, SUBMIT_BTN, WAIT_SECONDS).click();
	}

	public boolean clickLogout() throws InterruptedException {
		boolean flag = false;
		String userNameValue="";
		try {
			SeleniumUtils.hoverElement(driver, LOGIN_USER_BTN);
			Thread.sleep(2000);
			//userNameValue = getUserName();
			if (driver.findElement(LOGOUT_BUTTON).isEnabled()) {
				SeleniumUtils.waitForElementVisibility(driver, LOGOUT_BUTTON, WAIT_SECONDS).click();
				flag = true;
				TestBase.logInfo(String.format(properties.getLogMessage("LogoutFromSpinnyPortalPassed")));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(properties.getLogMessage("LogoutFromSpinnyPortalFailed")));
			throw e;
		}
		return flag;
	}

	public String getLogoutText() throws Exception {
		try {
			return SeleniumUtils.waitForElementVisibility(driver, LOGOUT_BUTTON, WAIT_SECONDS).getText();
		} catch (Exception e) {
			throw e;
		}
	}

	// This method is used when userName and password are passed as parameters
	public boolean enterDetailsAndLoginUsingCredentials(String userNumber) throws Exception {
		GetUserOPTNumberPage obGetUserOPTNumber = new GetUserOPTNumberPage(driver);
		boolean flag = false;
		String userNameValue;
		String OPTNumber = "";
		ArrayList<String> windowTab;
		try {
			clickLoginUserButton();
			enterUserMobileNumber(userNumber);
			clickOnGETOTPNumberButton();
			windowTab = obGetUserOPTNumber.hitRedashDBURL();
			if (obGetUserOPTNumber.loginToRedashDB()) {
				OPTNumber = obGetUserOPTNumber.toGetOTPNumberFromRedashDB(userNumber);
				obGetUserOPTNumber.logOutFromRedashDB(userNumber);
				driver.switchTo().window(windowTab.get(0));
				enterUserGETOTPNumber(OPTNumber);
				clickOnSubmitButton();
				if (SeleniumUtils.waitForElementVisibility(driver, LOGIN_USER_BTN, WAIT_SECONDS).isDisplayed()) {
					SeleniumUtils.hoverElement(driver, LOGIN_USER_BTN);
					Thread.sleep(2000);
					userNameValue = getUserName();
					TestBase.logInfo(
							String.format(properties.getLogMessage("UserLoginSuccessfulPassed"), userNameValue));
					return flag = true;
				}
			}
		} catch (Exception e) {
			TestBase.logError(String.format(properties.getLogMessage("UserLoginFailed"), userNumber));
			throw e;
		}
		return flag;
	}

	/***
	 * This functions is used to logout from spinny.com portal
	 * 
	 * @throws Exception
	 */
	public void LogOut() throws Exception {
		try {
			clickLogout();
		} catch (Exception e) {
			throw e;
		}
	}
}
