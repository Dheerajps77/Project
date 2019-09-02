package com.investaSolutions.adminPortal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.PropertiesManager;
import com.investaSolutions.utils.SeleniumUtils;

public class AdminPortalPage {

	private WebDriver driver;
	public static PropertiesManager properties = PropertiesManager.getInstance();

	public AdminPortalPage (WebDriver driver) {
		this.driver = driver;
	}
	
	private static final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	private final By DASHBOARD_TAB = By.xpath("//span[contains(text(),'Dashboard')]");
	private final By INSTRUMENT_MANAGEMENT_TAB = By.xpath("//span[contains(text(),'Instrument Management')]");
	private final By P_MODELS_TAB = By.xpath("//span[contains(text(),'P Models')]");
	private final By BANK_MANAGEMENT_TAB = By.xpath("//span[contains(text(),'Bank Management')]");
	private final By ASSET_MANAGER_MANAGEMENT_TAB = By.xpath("//span[contains(text(),'Asset Manager Management')]");
	private final By SOFTWARE_VENDORS_TAB = By.xpath("//span[contains(text(),'Software Vendors')]");
	private final By DISCONNECT_TAB = By.xpath("//span[contains(text(),'Disconnect')]");
	private final By USER_MANAGEMENT_TAB = By.xpath("//span[contains(text(),'User Management')]");
	

	public WebElement adminPortalDashboardElement() {
		return SeleniumUtils.waitForElementPresence(driver, DASHBOARD_TAB, WAIT_SECONDS);
	}
	
	public WebElement adminPortalInstrumentManagementElement() {
		return SeleniumUtils.waitForElementPresence(driver, INSTRUMENT_MANAGEMENT_TAB, WAIT_SECONDS);
	}
	
	public WebElement adminPortalPModelsElement() {
		return SeleniumUtils.waitForElementPresence(driver, P_MODELS_TAB, WAIT_SECONDS);
	}
	
	public WebElement adminPortalBankManagementElement() {
		return SeleniumUtils.waitForElementPresence(driver, BANK_MANAGEMENT_TAB, WAIT_SECONDS);
	}
	
	public WebElement adminPortalAssetManagerManagementElement() {
		return SeleniumUtils.waitForElementPresence(driver, ASSET_MANAGER_MANAGEMENT_TAB, WAIT_SECONDS);
	}
	
	public WebElement adminPortalSoftwareVendorsElement() {
		return SeleniumUtils.waitForElementPresence(driver, SOFTWARE_VENDORS_TAB, WAIT_SECONDS);
	}
	
	public WebElement adminPortalUserManagementElement() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_TAB, WAIT_SECONDS);
	}
	
	public WebElement adminPortalDisconnectElement() {
		return SeleniumUtils.waitForElementPresence(driver, DISCONNECT_TAB, WAIT_SECONDS);
	}
	
	// This method verifies the details present on the Admin Portal's page
	public boolean verifyAdminPortalPageDetails(String dashboardTab, String instrumentManagementTab, String pModelsTab, String bankManagementTab, String assetManagerManagementTab, String softwareVendorsTab, String userManagementTab, String disconnectTab) throws Exception{
		boolean flag = false;
		try {
			String dashboardTextFromUI = adminPortalDashboardElement().getText();
			String instrumentManagementTextFromUI = adminPortalInstrumentManagementElement().getText();
			String pModelsTextFromUI = adminPortalPModelsElement().getText();
			String bankManagementTextFromUI = adminPortalBankManagementElement().getText();
			String assetManagerManagementTextFromUI = adminPortalAssetManagerManagementElement().getText();
			String softwareVendorsTextFromUI = adminPortalSoftwareVendorsElement().getText();
			String userManagementTextFromUI = adminPortalUserManagementElement().getText();
			String disconnectTextFromUI = adminPortalDisconnectElement().getText();
			if(dashboardTextFromUI.equals(dashboardTab) && instrumentManagementTextFromUI.equals(instrumentManagementTab) && pModelsTextFromUI.equals(pModelsTab) && bankManagementTextFromUI.equals(bankManagementTab) && assetManagerManagementTextFromUI.equals(assetManagerManagementTab) && softwareVendorsTextFromUI.equals(softwareVendorsTab) && userManagementTextFromUI.equals(userManagementTab) && disconnectTextFromUI.equals(disconnectTab)){
				flag = true;
				TestBase.logInfo(String.format(properties.getLogMessage("AdminPortalPageDetailsVerified"), dashboardTab, instrumentManagementTab, pModelsTab, bankManagementTab, assetManagerManagementTab, softwareVendorsTab, userManagementTab, disconnectTab, 
						dashboardTextFromUI, instrumentManagementTextFromUI, pModelsTextFromUI, bankManagementTextFromUI, assetManagerManagementTextFromUI, softwareVendorsTextFromUI, userManagementTextFromUI, disconnectTextFromUI));
				return flag;
			}
		} catch (Exception e) {
			throw e;
		}		
		return flag;
	}
}
