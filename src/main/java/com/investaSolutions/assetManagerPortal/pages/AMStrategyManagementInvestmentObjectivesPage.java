package com.investaSolutions.assetManagerPortal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.SeleniumUtils;

public class AMStrategyManagementInvestmentObjectivesPage {

	WebDriver driver;

	public AMStrategyManagementInvestmentObjectivesPage(WebDriver driver) {
		this.driver = driver;
	}

	private final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	public final By STRATEGY_MANAGEMENT_TAB = By.xpath("//a//span[text()='Strategy Management ']");
	public final By STRATEGY_MANAGEMENT_TITLET_EXT_ELEMENT = By.xpath("//div[@class='layout-content']//legend");
	public final By SEARCH_PLUS_BUTTON = By
			.xpath("//div[@class='ui-table ui-widget']//table//tr[1]//td[1]//fa-icon[@icon='search-plus']");
	public final By STRATEGYNAMET_EXT = By.xpath("//div[@class='ui-table ui-widget']//table//tr[1]//td[2]");
	public final By STRATEGYMANAGEMENT_NAME_TITLE_WITH_STRATEGYNAME_TEXT = By
			.xpath("//legend[text()='Strategy Details']//preceding::legend");
	public final By INVESTMENT_OBJECTIVES_TITLE_TEXT = By.xpath("//legend[text()='Investment Objectives']");
	public final By INVESTMENT_OBJECTIVES_TITLE_TAB_TEXT = By
			.xpath(" //a[@role='tab']//span[text()='Investment Objectives']");
	public final By BACK_BUTTON = By.xpath("//button[@label='Back']");
	public final By SAVE_BUTTON = By.xpath("//button//span[text()='Save']");
	public final By INVESTMENT_OBJECTIVES_NAME = By.xpath(
			"//legend[text()='Investment Objectives']//following::div[@class='ui-table ui-widget ui-table-hoverable-rows']//table//thead//tr//th[2]");
	public final By TITLE_OF_INVESTMENTOBJECTIVES = By.xpath(
			"//legend[text()='Investment Objectives']//following::div[@class='ui-toolbar-group-left']//parent::span[text()=' Please order investment Objectives from lowest to highest risk']");
	public final By INVESTMENT_OBJECTIVES_DESCRIPTION = By.xpath(
			"//legend[text()='Investment Objectives']//following::div[@class='ui-table ui-widget ui-table-hoverable-rows']//table//thead//tr//th[3]");
	public final By NEW_STRATEGYBUTTON=By.xpath("//button[@label='New Strategy']");
	public final By ADD_INVESTMENT_OBJECTIVES_BTN = By.xpath("//p-tabpanel[@header='Investment Objectives']//span[@class='ui-button-icon-left ui-clickable ui-icon-plus']");
	public final By REMOVE_INVESTMENT_OBJECTIVES_BTN = By.xpath("//div[@id='ui-tabpanel-1']//span[@class='ui-button-icon-left ui-clickable ui-icon-minus']");	
	public final By INVESTMENT_OBJECTIVES_NAME_COLUMN = By.xpath("//tbody[@class='ui-table-tbody']//tr[1]/td[2]");	
	public final By INVESTMENT_OBJECTIVES_NAME_TEXTBOX = By.xpath("//input[@class='ng-pristine ng-valid ng-star-inserted ng-touched']");		
	public final By INVESTMENT_OBJECTIVES_DESCRIPTION_COLUMN = By.xpath("//tbody[@class='ui-table-tbody']//tr[1]/td[3]");
	public final By INVESTMENT_OBJECTIVES_DESCRIPTION_TEXTBOX = By.xpath("//textarea[@class='ng-pristine ng-valid ui-inputtext ui-corner-all ui-state-default ui-widget ng-star-inserted ng-touched']");
	public final By ADD_INVESTMENT_OBJECTIVES_BUTTON = By.xpath("//button[@ptooltip='Add Investment Objective']");
	public final By REMOVE_INVESTMENT_OBJECTIVES_BUTTON = By.xpath("//button[@ptooltip='Remove Investment Objective']");
	public final By NEW_STRATEGYBUTTON_UNDER_INVESTMENTOBJECTIVES_TAB=By.xpath("//button[@class='ui-button-warning ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']");
	

	public WebElement addInvestmentObjectiveButtonElement() {
		return SeleniumUtils.waitForElementPresence(driver, ADD_INVESTMENT_OBJECTIVES_BTN, WAIT_SECONDS);
	}

	public WebElement removeInvestmentObjectiveButtonElement() {
		return SeleniumUtils.waitForElementPresence(driver, REMOVE_INVESTMENT_OBJECTIVES_BTN, WAIT_SECONDS);
	}

	// This clicks on the Investment Objective Name Column of the 1st row 
	public WebElement addInvestmentObjectiveNameColumnElement() {
		return SeleniumUtils.waitForElementPresence(driver, INVESTMENT_OBJECTIVES_NAME_COLUMN, WAIT_SECONDS);
	}
	// This enters text on the Investment Objective Name Column of the 1st row 
	public WebElement addInvestmentObjectiveNameTextElement() {
		return SeleniumUtils.waitForElementPresence(driver, INVESTMENT_OBJECTIVES_NAME_TEXTBOX, WAIT_SECONDS);
	}

	// This clicks on the Investment Objective Description Column of the 1st row 
	public WebElement addInvestmentObjectiveDescriptionColumnElement() {
		return SeleniumUtils.waitForElementPresence(driver, INVESTMENT_OBJECTIVES_DESCRIPTION_COLUMN, WAIT_SECONDS);
	}

	// This enters text on the Investment Objective Description Column of the 1st row 
	public WebElement addInvestmentObjectiveDescriptionTextElement() {
		return SeleniumUtils.waitForElementPresence(driver, INVESTMENT_OBJECTIVES_DESCRIPTION_TEXTBOX, WAIT_SECONDS);
	}

	public boolean clickOnStrategyManagementTab() throws Exception {
		boolean flag = false;
		try {
			Thread.sleep(2000);
			SeleniumUtils.waitForElementClickable(driver, STRATEGY_MANAGEMENT_TAB, 30).click();
			flag = true;
			TestBase.logInfo(
					String.format(TestBase.properties.getLogMessage("VerifyClickOnStrategyManagmentTabPassed")));
		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyClickOnStrategyManagmentTabFailed")));
			throw e;
		}
		return flag;
	}

	public boolean clickOnNewStrategyButton() throws Exception {
		boolean flag = false;
		String getNewStrategyButtonText="";
		SeleniumUtils objSeleniumUtils;
		try {
			Thread.sleep(3000);
			objSeleniumUtils=new SeleniumUtils();
			boolean isElementPresentFlag = SeleniumUtils.isElementPresent(driver, NEW_STRATEGYBUTTON);
			if (isElementPresentFlag) {
				getNewStrategyButtonText=objSeleniumUtils.getTitleText(driver, NEW_STRATEGYBUTTON);
				Thread.sleep(2000);
				SeleniumUtils.scrollToViewElement(driver, NEW_STRATEGYBUTTON);
				SeleniumUtils.waitForElementClickable(driver, NEW_STRATEGYBUTTON, 30).click();				
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyNewStrategyButtonPassed"), getNewStrategyButtonText));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyNewStrategyButtonFailed"), getNewStrategyButtonText));
			throw e;
		}
		return flag;
	}

	public boolean clickOnInvestmentObjectivesTab() throws Exception {
		boolean flag = false;
		String getInvestmentObjectivesTabText = "";
		try {
			Thread.sleep(2000);
			if (SeleniumUtils.isElementPresent(driver, INVESTMENT_OBJECTIVES_TITLE_TAB_TEXT)) {
				getInvestmentObjectivesTabText = driver.findElement(INVESTMENT_OBJECTIVES_TITLE_TAB_TEXT).getText();
				Thread.sleep(2000);
				SeleniumUtils.scrollUp(driver);
				Thread.sleep(2000);
				SeleniumUtils.waitForElementClickable(driver, INVESTMENT_OBJECTIVES_TITLE_TAB_TEXT, 30).click();
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyInvestmentObjectivesTabButtonPassed"),
								getInvestmentObjectivesTabText));
			}
		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyInvestmentObjectivesTabButtonFailed"),
							getInvestmentObjectivesTabText));
			throw e;
		}
		return flag;
	}

	public boolean verifyInvestmentOjectivesTabTitle(String investmentObjectivesTabLabel) throws Exception {
		SeleniumUtils objSeleniumUtils;
		boolean flag = false;
		String getInvestmentObjectivesTablTitle = "";
		try {
			objSeleniumUtils = new SeleniumUtils();
			Thread.sleep(2000);
			getInvestmentObjectivesTablTitle = objSeleniumUtils.getTitleText(driver,
					INVESTMENT_OBJECTIVES_TITLE_TAB_TEXT);
			if (investmentObjectivesTabLabel.equalsIgnoreCase(getInvestmentObjectivesTablTitle)) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyInvestmentObjectivesTabTitlePassed"),
								investmentObjectivesTabLabel, getInvestmentObjectivesTablTitle));
			}
		} catch (Exception e) {
			TestBase.logInfo(
					String.format(TestBase.properties.getLogMessage("VerifyInvestmentObjectivesTabTitleFailed"),
							investmentObjectivesTabLabel, getInvestmentObjectivesTablTitle));
			throw e;
		}
		return flag;
	}

	public boolean verifyInvestmentObjectivesTitle(String investmentObjectivesTitleLabel) throws Exception {
		SeleniumUtils objSeleniumUtils;
		boolean flag = false;
		String getInvestmentObjectivesTitle = "";
		try {
			objSeleniumUtils = new SeleniumUtils();
			getInvestmentObjectivesTitle = objSeleniumUtils.getTitleText(driver, INVESTMENT_OBJECTIVES_TITLE_TEXT);
			if (investmentObjectivesTitleLabel.equalsIgnoreCase(getInvestmentObjectivesTitle)) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyInvestmentObjectivesTitlePassed"),
								investmentObjectivesTitleLabel, getInvestmentObjectivesTitle));
			}
		} catch (Exception e) {
			TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyInvestmentObjectivesTitleFailed"),
					investmentObjectivesTitleLabel, getInvestmentObjectivesTitle));
			throw e;
		}
		return flag;
	}

	public boolean verifyButtonsUnderInvestmentObjectives(String backButtonLabel, String newStrategyButtonLabel) throws Exception {
		boolean flag = false;
		String getbackButtonText = "";
		String getNewStrategyButtonText = "";
		try {

			if (SeleniumUtils.isElementPresent(driver, BACK_BUTTON)
					&& SeleniumUtils.isElementPresent(driver, NEW_STRATEGYBUTTON_UNDER_INVESTMENTOBJECTIVES_TAB)
					&& SeleniumUtils.isElementPresent(driver, ADD_INVESTMENT_OBJECTIVES_BUTTON)
					&& SeleniumUtils.isElementPresent(driver, REMOVE_INVESTMENT_OBJECTIVES_BUTTON)) {
				getbackButtonText = driver.findElement(BACK_BUTTON).getText();
				getNewStrategyButtonText = driver.findElement(NEW_STRATEGYBUTTON_UNDER_INVESTMENTOBJECTIVES_TAB).getText();
				if (backButtonLabel.equalsIgnoreCase(getbackButtonText)
						&& newStrategyButtonLabel.equalsIgnoreCase(getNewStrategyButtonText)) {
					flag = true;
					TestBase.logInfo(String.format(
							TestBase.properties.getLogMessage("VerifyButtonsUnderInvestmentObjectivesPassed"),
							backButtonLabel, getbackButtonText, newStrategyButtonLabel, getNewStrategyButtonText));
				}
			}

		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyButtonsUnderInvestmentObjectivesFailed"), backButtonLabel,
					getbackButtonText, newStrategyButtonLabel, getNewStrategyButtonText));
			throw e;
		}
		return flag;
	}

	public boolean verifyInvestmentObjectivesLabelName(String titleOfInvestmentObjectives,
			String investmentObjectivesNameLabel, String investmentObjectiveDescriptionLabel) throws Exception {
		String getTitleOfInvestmentObjectiveTable = "";
		String investmentObjectivesNameTextLabel = "";
		String investmentObjectiveDescriptionTextLabel = "";
		String trimValue = null;
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		try {
			objSeleniumUtils = new SeleniumUtils();
			getTitleOfInvestmentObjectiveTable = objSeleniumUtils.getTitleText(driver, TITLE_OF_INVESTMENTOBJECTIVES);
			investmentObjectivesNameTextLabel = objSeleniumUtils.getTitleText(driver, INVESTMENT_OBJECTIVES_NAME);
			investmentObjectiveDescriptionTextLabel = objSeleniumUtils.getTitleText(driver,
					INVESTMENT_OBJECTIVES_DESCRIPTION);
			trimValue = titleOfInvestmentObjectives.trim();
			if (getTitleOfInvestmentObjectiveTable.equalsIgnoreCase(trimValue)
					&& investmentObjectivesNameTextLabel.equalsIgnoreCase(investmentObjectivesNameLabel)
					&& investmentObjectiveDescriptionTextLabel.equalsIgnoreCase(investmentObjectiveDescriptionLabel)) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyInvestmentObjectivesLabelNamePassed"),
								trimValue, investmentObjectivesNameLabel, investmentObjectiveDescriptionLabel,
								getTitleOfInvestmentObjectiveTable, investmentObjectivesNameTextLabel,
								investmentObjectiveDescriptionTextLabel));
			}
		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyInvestmentObjectivesLabelNameFailed"),
							trimValue, investmentObjectivesNameLabel, investmentObjectiveDescriptionLabel,
							getTitleOfInvestmentObjectiveTable, investmentObjectivesNameTextLabel,
							investmentObjectiveDescriptionTextLabel));
			throw e;
		}
		return flag;
	}

	public boolean verifyInvestmentObjectivesOnStrategyManagementPage(String investmentObjectivesTabLabel,
			String investmentObjectivesTitleLabel, String titleOfInvestObjectivesInTable,
			String investmentObjectiveNameLabel, String investmentObjectiveDescriptionLabel, String backButtonLabel,
			String newStrategyButtonLabel) throws Exception {
		boolean flag = false;
		try {
			if (clickOnStrategyManagementTab()) {
				if (clickOnNewStrategyButton()) {
					if (clickOnInvestmentObjectivesTab()) {
						if (verifyInvestmentOjectivesTabTitle(investmentObjectivesTabLabel)) {
							if (verifyInvestmentObjectivesTitle(investmentObjectivesTitleLabel)) {
								if (verifyButtonsUnderInvestmentObjectives(backButtonLabel, newStrategyButtonLabel)) {
									if (verifyInvestmentObjectivesLabelName(titleOfInvestObjectivesInTable,
											investmentObjectiveNameLabel, investmentObjectiveDescriptionLabel)) {
										flag = true;
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	// This method is used to add investment objectives on 1st row
	public void addFirstInvestmentObjective(String objectiveName, String objectiveText) throws Exception{
		try {
			Thread.sleep(1000);
			SeleniumUtils.enterData(driver, INVESTMENT_OBJECTIVES_NAME_COLUMN, WAIT_SECONDS, objectiveName);
			Thread.sleep(1000);
			SeleniumUtils.enterData(driver, INVESTMENT_OBJECTIVES_DESCRIPTION_COLUMN, WAIT_SECONDS, objectiveText);			
		} catch (Exception e) {
			throw e;
		}
	}

	// This method is used to add investment objectives
	public void addInvestmentObjectives(String objectiveName, String objectiveText) throws Exception{
		try {
			Thread.sleep(2000);
			SeleniumUtils.waitForElementClickable(driver, ADD_INVESTMENT_OBJECTIVES_BTN, WAIT_SECONDS).click();
			addFirstInvestmentObjective(objectiveName, objectiveText);
		} catch (Exception e) {
			throw e;
		}
	}
}
