package com.investaSolutions.adminPortal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.PropertiesManager;
import com.investaSolutions.utils.SeleniumUtils;

public class AdminUserManagementPage {

	private WebDriver driver;
	public static PropertiesManager properties = PropertiesManager.getInstance();

	public AdminUserManagementPage (WebDriver driver) {
		this.driver = driver;
	}

	private static final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	private final By USER_MANAGEMENT_TAB = By.xpath("//span[contains(text(),'User Management')]");
	private final By ADMIN_USERS_TAB = By.xpath("//span[contains(text(),'Admin Users')]");	
	private final By VIEW_COLUMN_NAME = By.xpath("(//th[text()='E'])[1]");
	private final By DELETE_COLUMN_NAME = By.xpath("//th[text()='D']");
	private final By FIRSTNAME_COLUMN_NAME = By.xpath("//th[contains(text(),'Firstname')]");
	private final By LASTNAME_COLUMN_NAME = By.xpath("//th[contains(text(),'Lastname')]");
	private final By EMAIL_COLUMN_NAME = By.xpath("//th[contains(text(),'Email')]");
	private final By ENABLED_COLUMN_NAME = By.xpath("(//th[text()='E'])[2]");
	private final By LOCKED_COLUMN_NAME = By.xpath("//th[text()='L']");
	private final By BACK_BUTTON = By.xpath("//span[contains(text(),'Back')]");
	private final By NEW_USER_BUTTON = By.xpath("//span[contains(text(),'New User')]");
	private final By ADMIN_USER_MANAGEMENT_TITLE = By.xpath("//legend[contains(text(),'Admin User Management')]");

	public WebElement userManagementTabElement() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_TAB, WAIT_SECONDS);
	}
	
	public WebElement adminUsersTabElement() {
		return SeleniumUtils.waitForElementPresence(driver, ADMIN_USERS_TAB, WAIT_SECONDS);
	}

	public String adminUserManagementTitleText() {
		return SeleniumUtils.waitForElementPresence(driver, ADMIN_USER_MANAGEMENT_TITLE, WAIT_SECONDS).getText();
	}

	public String viewColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, VIEW_COLUMN_NAME, WAIT_SECONDS).getText();
	}
	
	public String deleteColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, DELETE_COLUMN_NAME, WAIT_SECONDS).getText();
	}

	public String firstNameColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, FIRSTNAME_COLUMN_NAME, WAIT_SECONDS).getText();
	}

	public String lastNameColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, LASTNAME_COLUMN_NAME, WAIT_SECONDS).getText();
	}

	public String emailColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, EMAIL_COLUMN_NAME, WAIT_SECONDS).getText();
	}

	public String enabledColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, ENABLED_COLUMN_NAME, WAIT_SECONDS).getText();
	}
	
	public String lockedColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, LOCKED_COLUMN_NAME, WAIT_SECONDS).getText();
	}

	public WebElement backButtonElement() {
		return SeleniumUtils.waitForElementPresence(driver, BACK_BUTTON, WAIT_SECONDS);
	}

	public WebElement newUserButtonElement() {
		return SeleniumUtils.waitForElementPresence(driver, NEW_USER_BUTTON, WAIT_SECONDS);
	}

	public void clickOnAdminUsersTab(){
		try {
			SeleniumUtils.waitForElementClickable(driver, USER_MANAGEMENT_TAB, WAIT_SECONDS);
			SeleniumUtils.click(userManagementTabElement(), properties.getLogMessage("AdminUserManagementTabClickedSuccessfully"));
			SeleniumUtils.waitForElementClickable(driver, ADMIN_USERS_TAB, WAIT_SECONDS);
			SeleniumUtils.click(adminUsersTabElement(), properties.getLogMessage("AdminUsersTabClickedSuccessfully"));
		} catch (Exception e) {
			TestBase.logError(properties.getLogMessage("AdminUsersTabClickFailed"));
		}
	}

	// This method verifies the details present on the Admin Portal's Users Management page
	public boolean verifyAssetUserManagementPageDetails(String adminUserManagementTitle, String viewColumnText, String deleteColumnText, String firstNameColumnText, String lastNameColumnText, String emailColumnText, String enabledColumnText, String lockedColumnText, String backButtonText, String newUserButtonText) throws Exception{
		boolean flag = false;
		try {
			clickOnAdminUsersTab();
			String adminUserManagementTitleTextFromUI = adminUserManagementTitleText();
			String viewColumnTextFromUI = viewColumnText();
			String deleteColumnTextFromUI = deleteColumnText();
			String firstNameColumnTextFromUI = firstNameColumnText();
			String lastNameColumnTextFromUI = lastNameColumnText();
			String emailColumnTextFromUI = emailColumnText();
			String enabledColumnTextFromUI = enabledColumnText();
			String lockedColumnTextFromUI = lockedColumnText();
			String backButtonTextFromUI = backButtonElement().getText();
			String newUserButtonTextFromUI = newUserButtonElement().getText();
			if(adminUserManagementTitleTextFromUI.equals(adminUserManagementTitle) && viewColumnTextFromUI.equals(viewColumnText) && deleteColumnTextFromUI.equals(deleteColumnText) && firstNameColumnTextFromUI.equals(firstNameColumnText) && lastNameColumnTextFromUI.equals(lastNameColumnText) && emailColumnTextFromUI.equals(emailColumnText) && enabledColumnTextFromUI.equals(enabledColumnText) && lockedColumnTextFromUI.equals(lockedColumnText) && backButtonTextFromUI.equals(backButtonText) && newUserButtonTextFromUI.equals(newUserButtonText)){
				flag = true;
				TestBase.logInfo(String.format(properties.getLogMessage("AdminUserManagementPageDetailsVerified"),  adminUserManagementTitle,  viewColumnText,  deleteColumnText,  firstNameColumnText,  lastNameColumnText,  emailColumnText,  enabledColumnText,  lockedColumnText,  backButtonText,  newUserButtonText, 
						adminUserManagementTitleTextFromUI, viewColumnTextFromUI, deleteColumnTextFromUI, firstNameColumnTextFromUI, lastNameColumnTextFromUI, emailColumnTextFromUI, enabledColumnTextFromUI, lockedColumnTextFromUI, backButtonTextFromUI, newUserButtonTextFromUI));
				return flag;
			}
		} catch (Exception e) {
			throw e;
		}		
		return flag;
	}

}
