package com.investaSolutions.bankPortal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.PropertiesManager;
import com.investaSolutions.utils.SeleniumUtils;

public class BankPortalPage {
	private WebDriver driver;
	public static PropertiesManager properties = PropertiesManager.getInstance();

	public BankPortalPage(WebDriver driver) {
		this.driver = driver;
	}

	private static final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	private final By DASHBOARD_TAB = By.xpath("//span[contains(text(),'Dashboard')]");
	private final By SETTINGS_TAB = By.xpath("//span[contains(text(),'Settings')]");
	private final By INSTRUMENTS_TAB = By.xpath("(//span[contains(text(),'Instruments')])[1]");
	private final By MODELS_TAB = By.xpath("//span[contains(text(),'Models')]");
	private final By REBALANCE_TAB = By.xpath("//span[contains(text(),'Rebalance')]");
	private final By RISK_TAB = By.xpath("(//span[contains(text(),'Risk')])[3]");
	private final By DISCONNECT_TAB = By.xpath("//span[contains(text(),'Disconnect')]");
	private final By USERS_TAB = By.xpath("//span[contains(text(),'Users')]");

	public WebElement bankPortalDashboardElement() {
		return SeleniumUtils.waitForElementPresence(driver, DASHBOARD_TAB, WAIT_SECONDS);
	}

	public WebElement bankPortalSettingsElement() {
		return SeleniumUtils.waitForElementPresence(driver, SETTINGS_TAB, WAIT_SECONDS);
	}

	public WebElement bankPortalInstrumentsElement() {
		return SeleniumUtils.waitForElementPresence(driver, INSTRUMENTS_TAB, WAIT_SECONDS);
	}

	public WebElement bankPortalModelsElement() {
		return SeleniumUtils.waitForElementPresence(driver, MODELS_TAB, WAIT_SECONDS);
	}

	public WebElement bankPortalRebalanceElement() {
		return SeleniumUtils.waitForElementPresence(driver, REBALANCE_TAB, WAIT_SECONDS);
	}

	public WebElement bankPortalRiskElement() {
		return SeleniumUtils.waitForElementPresence(driver, RISK_TAB, WAIT_SECONDS);
	}

	public WebElement bankPortalUsersElement() {
		return SeleniumUtils.waitForElementPresence(driver, USERS_TAB, WAIT_SECONDS);
	}

	public WebElement bankPortalDisconnectElement() {
		return SeleniumUtils.waitForElementPresence(driver, DISCONNECT_TAB, WAIT_SECONDS);
	}

	// This method verifies the details present on the Bank Portal's page
	public boolean verifyBankPortalPageDetails(String dashboardTab, String settingsTab, String instrumentsTab,
			String modelsTab, String rebalanceTab, String riskTab, String usersTab, String disconnectTab)
			throws Exception {
		boolean flag = false;
		try {
			String dashboardTextFromUI = bankPortalDashboardElement().getText();
			String settingsTextFromUI = bankPortalSettingsElement().getText();
			String instrumentsTextFromUI = bankPortalInstrumentsElement().getText();
			String modelsTextFromUI = bankPortalModelsElement().getText();
			String rebalanceTextFromUI = bankPortalRebalanceElement().getText();
			String riskTextFromUI = bankPortalRiskElement().getText();
			String usersTextFromUI = bankPortalUsersElement().getText();
			String disconnectTextFromUI = bankPortalDisconnectElement().getText();
			Thread.sleep(2000);
			if (dashboardTextFromUI.equals(dashboardTab) && settingsTextFromUI.equals(settingsTab)
					&& instrumentsTextFromUI.equals(instrumentsTab) && modelsTextFromUI.equals(modelsTab)
					&& rebalanceTextFromUI.equals(rebalanceTab) && riskTextFromUI.equals(riskTab)
					&& usersTextFromUI.equals(usersTab) && disconnectTextFromUI.equals(disconnectTab)) {
				flag = true;
				TestBase.logInfo(String.format(properties.getLogMessage("BankPortalPageDetailsVerified"), dashboardTab,
						settingsTab, instrumentsTab, modelsTab, rebalanceTab, riskTab, usersTab, disconnectTab,
						dashboardTextFromUI, settingsTextFromUI, instrumentsTextFromUI, modelsTextFromUI,
						rebalanceTextFromUI, riskTextFromUI, usersTextFromUI, disconnectTextFromUI));
				return flag;
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}
}
