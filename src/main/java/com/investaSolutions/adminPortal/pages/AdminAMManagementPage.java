package com.investaSolutions.adminPortal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.PropertiesManager;
import com.investaSolutions.utils.SeleniumUtils;

public class AdminAMManagementPage {

	private WebDriver driver;
	public static PropertiesManager properties = PropertiesManager.getInstance();

	public AdminAMManagementPage(WebDriver driver) {
		this.driver = driver;
	}

	private static final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	private final By ASSET_MANAGER_MANAGEMENT_TITLE = By.xpath("//legend[contains(text(),'Asset Manager Management')]");
	private final By D_COLUMN_NAME = By.xpath("//th[contains(text(),'D')]");
	private final By NAME_COLUMN_NAME = By.xpath("//th[contains(text(),'Name')]");
	private final By ADDRESS_COLUMN_NAME = By.xpath("//th[contains(text(),'Address')]");
	private final By CONTACT_COLUMN_NAME = By.xpath("//th[contains(text(),'Contact')]");
	private final By LAST_UPDATE_DATE_COLUMN_NAME = By.xpath("//th[contains(text(),'Last update date')]");
	private final By BACK_BUTTON = By.xpath("//span[contains(text(),'Back')]");
	private final By NEW_ASSET_MANAGER_BUTTON = By.xpath("//span[contains(text(),'New Asset Manager')]");
	private final By ASSET_MANAGER_MANAGEMENT_TAB = By.xpath("//span[contains(text(),'Asset Manager Management')]");

	public WebElement assetManagerManagementTabElement() {
		return SeleniumUtils.waitForElementPresence(driver, ASSET_MANAGER_MANAGEMENT_TAB, WAIT_SECONDS);
	}

	public String assetManagerManagementTitleText() {
		return SeleniumUtils.waitForElementPresence(driver, ASSET_MANAGER_MANAGEMENT_TITLE, WAIT_SECONDS).getText();
	}

	public String dColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, D_COLUMN_NAME, WAIT_SECONDS).getText();
	}

	public String nameColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, NAME_COLUMN_NAME, WAIT_SECONDS).getText();
	}

	public String addressColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, ADDRESS_COLUMN_NAME, WAIT_SECONDS).getText();
	}

	public String contactColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, CONTACT_COLUMN_NAME, WAIT_SECONDS).getText();
	}

	public String lastUpdateDateText() {
		return SeleniumUtils.waitForElementPresence(driver, LAST_UPDATE_DATE_COLUMN_NAME, WAIT_SECONDS).getText();
	}

	public WebElement backButtonElement() {
		return SeleniumUtils.waitForElementPresence(driver, BACK_BUTTON, WAIT_SECONDS);
	}

	public WebElement newAssetManagerButtonElement() {
		return SeleniumUtils.waitForElementPresence(driver, NEW_ASSET_MANAGER_BUTTON, WAIT_SECONDS);
	}

	public void clickOnAssetManagerManagementTab() {
		try {
			SeleniumUtils.click(assetManagerManagementTabElement(),
					properties.getLogMessage("AdminAssetManagerManagementTabClickedSuccessfully"));
		} catch (Exception e) {
			TestBase.logError(properties.getLogMessage("AdminAssetManagerManagementTabClickFailed"));
		}
	}

	// This method verifies the details present on the Admin Portal's page
	public boolean verifyAssetManagerManagementPageDetails(String assetManagerManagementTitle, String dColumnText,
			String nameColumnText, String addressColumnText, String contactColumnText, String lastUpdateDateColumnText,
			String backButtonText, String newAssetManagerButtonText) throws Exception {
		boolean flag = false;
		try {
			clickOnAssetManagerManagementTab();
			String assetManagerManagementTitleTextFromUI = assetManagerManagementTitleText();
			String dColumnTextFromUI = dColumnText();
			String nameColumnTextFromUI = nameColumnText();
			String addressColumnTextFromUI = addressColumnText();
			String contactColumnTextFromUI = contactColumnText();
			String lastUpdateDateTextFromUI = lastUpdateDateText();
			String backButtonTextFromUI = backButtonElement().getText();
			String newAssetManagerButtonTextFromUI = newAssetManagerButtonElement().getText();
			if (assetManagerManagementTitleTextFromUI.equals(assetManagerManagementTitle)
					&& dColumnTextFromUI.equals(dColumnText) && nameColumnTextFromUI.equals(nameColumnText)
					&& addressColumnTextFromUI.equals(addressColumnText)
					&& contactColumnTextFromUI.equals(contactColumnText)
					&& lastUpdateDateTextFromUI.equals(lastUpdateDateColumnText)
					&& backButtonTextFromUI.equals(backButtonText)
					&& newAssetManagerButtonTextFromUI.equals(newAssetManagerButtonText)) {
				flag = true;
				TestBase.logInfo(
						String.format(properties.getLogMessage("AdminAssetManagerManagementPageDetailsVerified"),
								assetManagerManagementTitle, dColumnText, nameColumnText, addressColumnText,
								contactColumnText, lastUpdateDateColumnText, backButtonText, newAssetManagerButtonText,
								assetManagerManagementTitleTextFromUI, dColumnTextFromUI, nameColumnTextFromUI,
								addressColumnTextFromUI, contactColumnTextFromUI, lastUpdateDateTextFromUI,
								backButtonTextFromUI, newAssetManagerButtonTextFromUI));
				return flag;
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

}
