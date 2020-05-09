package com.recent.files;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.*;
import com.investaSolutions.utils.PropertiesManager;
import com.investaSolutions.utils.SeleniumUtils;

public class GetUserOPTNumberPage {

	private final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	public static PropertiesManager properties = PropertiesManager.getInstance();
	WebDriver driver;
	String redashurl = properties.getConfig("REDASH_URL");
	String email = properties.getConfig("REDASH_EMAIL");
	String pass = properties.getConfig("REDASH_PASSWORD");
	String selectQuery = properties.getConfig("SELECT_QUERY");
	String redshDBUserName = properties.getConfig("REDASHUSERNAME");	
	public final By REDASH_EMAIL = By.xpath("//input[@id='inputEmail']");
	public final By REDASH_PASSWORD = By.xpath("//input[@id='inputPassword']");
	public final By REDASH_LOGINBTN = By.xpath("//button[text()='Log In']");
	public final By CREATE_BTN = By.xpath("//button[@id='create-button']");
	public final By QUERY_BTN = By.xpath(
			"//div[@class='btn-group navbar-btn navbar-left btn__new hidden-xs dropdown open']//ul[@class='dropdown-menu']//li[1]");
	public final By EDITOR_TEXTBOX = By.xpath("//div[@id='brace-editor']//textarea[@class='ace_text-input']");
	public final By EXECUTE_BTN = By.xpath("//button[@data-test='ExecuteButton']");
	public final By OTPCODE_NUMBER = By
			.xpath("//div[@class='ant-table-body']//table//tbody[@class='ant-table-tbody']//tr[1]//td[2]//div");
	public final By CONTACT_NUMBER = By
			.xpath("//div[@class='ant-table-body']//table//tbody[@class='ant-table-tbody']//tr[1]//td[7]//div");
	public final By PROFILE_DROPDOWN = By.xpath("//li[@class='dropdown']");
	public final By LOGOUT_BTN = By.xpath("//ul[@class='dropdown-menu dropdown-menu--profile']//li[8]//a");

	public final By QUERY_LINK = By.xpath("//div[@class='col-sm-6']//a[text()='Queries']");
	public final By NEW_QUERY = By.xpath(
			"//div[@class='layout-with-sidebar m-l-15 m-r-15']//div[@class='layout-content']//table//tbody[@class='ant-table-tbody']//tr[3]//td[2]//a[1]");
	public final By REFRESH_BTN = By.xpath("//button[@title='Refresh Dataset']");

	private final By USERNAME_OF_REDASHDB = By
			.xpath("//li[@class='dropdown']//span[@class='dropdown--profile__username']");
	
	public GetUserOPTNumberPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement queryLink() {
		return SeleniumUtils.waitForElementClickable(driver, QUERY_LINK, WAIT_SECONDS);
	}

	public WebElement newQueryLink() {
		return SeleniumUtils.waitForElementClickable(driver, NEW_QUERY, WAIT_SECONDS);
	}

	public WebElement refreshButton() {
		return SeleniumUtils.waitForElementClickable(driver, REFRESH_BTN, WAIT_SECONDS);
	}

	public WebElement redashUserName() {
		return SeleniumUtils.waitForElementClickable(driver, REDASH_EMAIL, WAIT_SECONDS);
	}

	public WebElement redashUserPassword() {
		return SeleniumUtils.waitForElementClickable(driver, REDASH_PASSWORD, WAIT_SECONDS);
	}

	public WebElement LogInButtonOfRedash() {
		return SeleniumUtils.waitForElementPresence(driver, REDASH_LOGINBTN, WAIT_SECONDS);
	}

	public WebElement createButton() {
		return SeleniumUtils.waitForElementClickable(driver, CREATE_BTN, WAIT_SECONDS);
	}

	public WebElement queryButton() {
		return SeleniumUtils.waitForElementClickable(driver, QUERY_BTN, WAIT_SECONDS);
	}

	public WebElement executeButton() {
		return SeleniumUtils.waitForElementClickable(driver, EXECUTE_BTN, WAIT_SECONDS);
	}

	public String getUserContactNumber() {
		return SeleniumUtils.waitForElementPresence(driver, CONTACT_NUMBER, WAIT_SECONDS).getText();
	}

	public String getUserOTPNumber() {
		return SeleniumUtils.waitForElementPresence(driver, OTPCODE_NUMBER, WAIT_SECONDS).getText();
	}

	public WebElement profileDropDown() {
		return SeleniumUtils.waitForElementPresence(driver, PROFILE_DROPDOWN, WAIT_SECONDS);
	}

	public WebElement profileLogOut() {
		return SeleniumUtils.waitForElementPresence(driver, LOGOUT_BTN, WAIT_SECONDS);
	}	

	public WebElement userNameOfRedashDB() {
		return SeleniumUtils.waitForElementPresence(driver, USERNAME_OF_REDASHDB, WAIT_SECONDS);
	}

	/***
	 * This will open Redash DB URL
	 * @param driver
	 * @throws Exception
	 */
	public void openLinkURLInNewTab1() throws Exception {		
		try {			
			((JavascriptExecutor) driver)
					.executeScript("window.open('https://redash-bi.spinnyworks.in/login','_blank');");
			Thread.sleep(2000);			
			TestBase.logInfo(String.format(properties.getLogMessage("UserNavigatedToRedashDBPassed"), redashurl));
		} catch (Exception e) {
			TestBase.logError(String.format(properties.getLogMessage("UserNavigatedToRedashDBFailed"), redashurl));
			throw e;
		}
	}

	public void openLinkURLInNewTab() throws Exception
	{
		((JavascriptExecutor) driver)
		.executeScript("window.open('https://redash-bi.spinnyworks.in/login','_blank');");
		Thread.sleep(2000);		
	}
	/***
	 * This functions will Hit the URL Redash DB
	 * 
	 * @throws Exception
	 */
	public ArrayList<String> hitRedashDBURL() throws Exception {
		ArrayList<String> tabs = null;
		try {
			tabs=new ArrayList<String>();
			openLinkURLInNewTab();
			Set<String> windowTabid = driver.getWindowHandles();
			tabs = new ArrayList<String>(windowTabid);
			driver.switchTo().window(tabs.get(1));
		} catch (Exception e) {
			throw e;
		}
		return tabs;
	}

	/***
	 * This will login to Redash DB
	 * 
	 * @return
	 */
	public boolean loginToRedashDB() {
		boolean flag = false;
		try {
			if (redashUserName().isEnabled() && redashUserPassword().isEnabled()) {
				SeleniumUtils.enterTextInTextBox(driver, redashUserName(), WAIT_SECONDS, email);
				SeleniumUtils.enterTextInTextBox(driver, redashUserPassword(), WAIT_SECONDS, pass);
				if (LogInButtonOfRedash().isEnabled()) {
					LogInButtonOfRedash().click();
					if (userNameOfRedashDB().getText().equalsIgnoreCase(redshDBUserName)) {
						TestBase.logInfo(
								String.format(properties.getLogMessage("RedashUserLoggedInSuccessfullyPassed"), email, redshDBUserName));
						flag = true;
					}
				}
			}

		} catch (Exception e) {
			TestBase.logError(String.format(properties.getLogMessage("RedashUserLoggedInSuccessfullyFailed"), email, redshDBUserName));
			throw e;
		}
		return flag;
	}

	public boolean alternateWayToRunQueries() throws Exception {
		boolean flag = false;
		try {
			if (queryLink().isEnabled()) {
				queryLink().click();
				newQueryLink().click();
				refreshButton().click();
				Thread.sleep(2000);
				return flag = true;
			}

		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	/***
	 * This method will get OTP generated from Redash DB
	 * 
	 * @param userName
	 * @return String
	 * @throws Exception
	 */
	public String toGetOTPNumberFromRedashDB(String userName) throws Exception {
		String userNumber = "";
		String optNumber = "";
		try {
			if (alternateWayToRunQueries()) {
				userNumber = getUserContactNumber();
				if (userName.equalsIgnoreCase(userNumber)) {
					optNumber = getUserOTPNumber();
					TestBase.logInfo(
							String.format(properties.getLogMessage("OTPNumberGenerationPassed"), optNumber, userName));
				}
			}
		} catch (Exception e) {
			TestBase.logInfo(String.format(properties.getLogMessage("OTPNumberGenerationFailed"), userName));
			throw e;
		}
		return optNumber;
	}

	/***
	 * This function will logout from Redash DB
	 */
	public void logOutFromRedashDB(String userName) {
		try {
			if (profileDropDown().isEnabled()) {
				profileDropDown().click();
				profileLogOut().click();
				TestBase.logInfo(String.format(properties.getLogMessage("RedashDBLogOutPassed"), userName));
				driver.close();
			}
		} catch (Exception e) {
			TestBase.logError(String.format(properties.getLogMessage("RedashDBLogOutFailed"), userName));
			throw e;

		}
	}
}
