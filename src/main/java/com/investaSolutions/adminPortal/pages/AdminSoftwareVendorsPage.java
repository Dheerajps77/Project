package com.investaSolutions.adminPortal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.PropertiesManager;
import com.investaSolutions.utils.SeleniumUtils;

public class AdminSoftwareVendorsPage {


	private WebDriver driver;
	public static PropertiesManager properties = PropertiesManager.getInstance();

	public AdminSoftwareVendorsPage (WebDriver driver) {
		this.driver = driver;
	}

	private static final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	private final By SOFTWARE_VENDOR_MANAGEMENT_TITLE = By.xpath("//legend[contains(text(),'Software Vendor Management')]");
	private final By D_COLUMN_NAME = By.xpath("//th[contains(text(),'D')]");
	private final By NAME_COLUMN_NAME = By.xpath("//th[contains(text(),'Name')]");
	private final By ADDRESS_COLUMN_NAME = By.xpath("//th[contains(text(),'Address')]");
	private final By CONTACT_COLUMN_NAME = By.xpath("//th[contains(text(),'Contact')]");
	private final By LAST_UPDATE_DATE_COLUMN_NAME = By.xpath("//th[contains(text(),'Last update date')]");
	private final By BACK_BUTTON = By.xpath("//span[contains(text(),'Back')]");
	private final By NEW_SOFTWARE_VENDOR_BUTTON = By.xpath("//span[contains(text(),'New Software Vendor')]");
	private final By SOFTWARE_VENDORS_TAB = By.xpath("//span[contains(text(),'Software Vendors')]");

	public WebElement softwareVendorsTabElement() {
		return SeleniumUtils.waitForElementPresence(driver, SOFTWARE_VENDORS_TAB, WAIT_SECONDS);
	}

	public String softwareVendorTitleText() {
		return SeleniumUtils.waitForElementPresence(driver, SOFTWARE_VENDOR_MANAGEMENT_TITLE, WAIT_SECONDS).getText();
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

	public WebElement newSoftwareVendorButtonElement() {
		return SeleniumUtils.waitForElementPresence(driver, NEW_SOFTWARE_VENDOR_BUTTON, WAIT_SECONDS);
	}

	public void clickOnSoftwareVendorTab(){
		try {
			SeleniumUtils.click(softwareVendorsTabElement(), properties.getLogMessage("AdminSoftwareVendorsTabClickedSuccessfully"));
		} catch (Exception e) {
			TestBase.logError(properties.getLogMessage("AdminSoftwareVendorsTabClickFailed"));
		}
	}

	// This method verifies the details present on the Software Vendor Portal's page
	public boolean verifySoftwareVendorsPageDetails(String softwareVendorTitle, String dColumnText, String nameColumnText, String addressColumnText, String contactColumnText, String lastUpdateDateColumnText, String backButtonText, String newSoftwareVendorButtonText) throws Exception{
		boolean flag = false;
		try {
			clickOnSoftwareVendorTab();
			String softwareVendorTitleTextFromUI = softwareVendorTitleText();
			String dColumnTextFromUI = dColumnText();
			String nameColumnTextFromUI = nameColumnText();
			String addressColumnTextFromUI = addressColumnText();
			String contactColumnTextFromUI = contactColumnText();
			String lastUpdateDateTextFromUI = lastUpdateDateText();
			String backButtonTextFromUI = backButtonElement().getText();
			String newSoftwareVendorButtonTextFromUI = newSoftwareVendorButtonElement().getText();
			if(softwareVendorTitleTextFromUI.equals(softwareVendorTitle) && dColumnTextFromUI.equals(dColumnText) && nameColumnTextFromUI.equals(nameColumnText) && addressColumnTextFromUI.equals(addressColumnText) && contactColumnTextFromUI.equals(contactColumnText) && lastUpdateDateTextFromUI.equals(lastUpdateDateColumnText) && backButtonTextFromUI.equals(backButtonText) && newSoftwareVendorButtonTextFromUI.equals(newSoftwareVendorButtonText)){
				flag = true;
				TestBase.logInfo(String.format(properties.getLogMessage("AdminSoftwareVendorsPageDetailsVerified"), softwareVendorTitle, dColumnText, nameColumnText, addressColumnText, contactColumnText, lastUpdateDateColumnText, backButtonText, newSoftwareVendorButtonText, 
						softwareVendorTitleTextFromUI, dColumnTextFromUI, nameColumnTextFromUI, addressColumnTextFromUI, contactColumnTextFromUI, lastUpdateDateTextFromUI, backButtonTextFromUI, newSoftwareVendorButtonTextFromUI));
				return flag;
			}
		} catch (Exception e) {
			throw e;
		}		
		return flag;
	}


}
