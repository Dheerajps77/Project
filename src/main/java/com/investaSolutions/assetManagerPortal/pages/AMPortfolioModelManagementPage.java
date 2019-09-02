package com.investaSolutions.assetManagerPortal.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.GenericUtils;
import com.investaSolutions.utils.SeleniumUtils;

public class AMPortfolioModelManagementPage {

	public WebDriver driver;

	public AMPortfolioModelManagementPage(WebDriver driver) {
		this.driver = driver;
	}

	private final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	public final By PORTFOLIO_MODEL_MANAGEMENT_TAB = By.xpath("//div[@class='nano-content menu-scroll-content']//ul//li//a//span[text()='Portfolio Model Management ']");
	public final By PORTFOLIO_MODEL_MANAGEMENT_LIST_TITLE = By.xpath("//div[@class='ui-g']//div[@class='ui-g-12']//legend");
	public final By TABLE_COLUMN_NAMES = By.xpath("//div[@class='ui-table-wrapper ng-star-inserted']//table//thead//tr//th");
	public final By BACK_BUTTON = By.xpath("//div[@class='ui-g-12 ui-md-3']//button[@label='Back']");
	public final By NEW_PORTFOLIO_BUTTON = By.xpath("//div[@class='ui-g-12 ui-md-3']//button[@label='New Portfolio Model']");

	public WebElement newPortfolioButtonElement() {
		return SeleniumUtils.waitForElementPresence(driver, NEW_PORTFOLIO_BUTTON, WAIT_SECONDS);
	}

	public boolean verifyPortfolioManagementTabAndDetailsInPage(String portfolioMangementTabLabelText,
			String dColumnValue, String cColumnValue, String modelNameColumnValue, String currencyColumnValue,
			String contactDetailsColumnValue, String modelStyleColumnValue, String openCloseColumnValue,
			String lastUpdatedColumnValue) throws Exception {
		boolean flag = false;
		try {
			if (verifyPortfolioManagementTabTitle(portfolioMangementTabLabelText)) {
				clickOnPortfolioManagementTab();
				if (verifyDetailsOnPortfolioPortfolioManagement(dColumnValue, cColumnValue, modelNameColumnValue,
						currencyColumnValue, contactDetailsColumnValue, modelStyleColumnValue, openCloseColumnValue,
						lastUpdatedColumnValue)) {
					flag = true;
					TestBase.logInfo(String.format(
							TestBase.properties.getLogMessage("VerifyPortfolioManagementPageDetailsPassed"),
							dColumnValue, cColumnValue, modelNameColumnValue, currencyColumnValue,
							contactDetailsColumnValue, modelStyleColumnValue, openCloseColumnValue,
							lastUpdatedColumnValue));
				}
			}
		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyPortfolioManagementPageDetailsFailed"), dColumnValue,
					cColumnValue, modelNameColumnValue, currencyColumnValue, contactDetailsColumnValue,
					modelStyleColumnValue, openCloseColumnValue, lastUpdatedColumnValue));
			throw e;
		}
		return flag;
	}

	public boolean verifyBackButton(String backbtnTextValue) throws Exception
	{
		SeleniumUtils objSeleniumUtils = null;
		WebElement backButtonElement;	
		String backButtonText="";
		boolean flag = false;
		try {
			objSeleniumUtils=new SeleniumUtils();
			backButtonElement = driver.findElement(BACK_BUTTON);
			backButtonText = backButtonElement.getText();
			if (backButtonElement.isDisplayed() && backButtonText.equalsIgnoreCase(backbtnTextValue)) {
				flag=true;
			}		
			if(flag)
			{
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyBackButtonPassed"), backButtonText, backbtnTextValue));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyBackButtonFailed"), backButtonText, backbtnTextValue));
			throw e;
		}
		return flag;
	}

	public boolean verifyNewPortfolioButton() throws Exception
	{
		SeleniumUtils objSeleniumUtils = null;
		boolean flag;
		try {
			objSeleniumUtils=new SeleniumUtils();
			flag=objSeleniumUtils.isElementDisplayed(driver, NEW_PORTFOLIO_BUTTON);			
			if(flag)
			{
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyNewPortfolioButtonPassed")));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyNewPortfolioButtonFailed")));
			throw e;
		}
		return flag;
	}

	public void clickOnPortfolioManagementTab() throws Exception {
		try {
			SeleniumUtils.waitForElementClickable(driver, PORTFOLIO_MODEL_MANAGEMENT_TAB, 25).click();
			TestBase.properties.getLogMessage("PortfolioManagementTabClicked");

		} catch (Exception e) {
			throw e;
		}
	}

	public boolean verifyPortfolioManagementTabTitle(String portfolioMangementTabLabelText) throws Exception {
		SeleniumUtils objSeleniumUtils = null;
		String getTitleOfPMTab = "";
		boolean flag = false;
		try {

			objSeleniumUtils = new SeleniumUtils();
			getTitleOfPMTab = objSeleniumUtils.getTitleText(driver, PORTFOLIO_MODEL_MANAGEMENT_TAB);
			WebElement portfolioManElement = driver.findElement(PORTFOLIO_MODEL_MANAGEMENT_TAB);
			if (portfolioManElement.isDisplayed() && portfolioMangementTabLabelText.equalsIgnoreCase(getTitleOfPMTab)) {
				flag = true;
				TestBase.logInfo(String.format(
						TestBase.properties.getLogMessage("VerifyPortfolioManagementTabTitlePassed"), getTitleOfPMTab));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyPortfolioManagementTabTitleFailed"), getTitleOfPMTab));
			throw e;
		}
		return flag;
	}

	public boolean verifyDetailsOnPortfolioPortfolioManagement(String dColumnValue, String cColumnValue,
			String modelNameColumnValue, String currencyColumnValue, String contactDetailsColumnValue,
			String modelStyleColumnValue, String openCloseColumnValue, String lastUpdatedColumnValue) throws Exception {
		ArrayList<String> arrayList = null;
		GenericUtils objGenericUtils=new GenericUtils();
		boolean flag = false;
		try {			
			arrayList = new ArrayList<String>();
			arrayList=objGenericUtils.TableColumnNameValues(driver, TABLE_COLUMN_NAMES);			
			if (arrayList.contains(dColumnValue) && arrayList.contains(cColumnValue)
					&& arrayList.contains(modelNameColumnValue) && arrayList.contains(currencyColumnValue)
					&& arrayList.contains(contactDetailsColumnValue) && arrayList.contains(modelStyleColumnValue)
					&& arrayList.contains(openCloseColumnValue) && arrayList.contains(lastUpdatedColumnValue)) {
				flag = true;
			}

		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	public boolean verifyPortfolioModelListTitle(String portfolioModelListName) throws Exception {
		String getTitleOfPMModelList = "";
		SeleniumUtils objSeleniumUtils = null;
		boolean flag = false;
		try {
			objSeleniumUtils = new SeleniumUtils();
			getTitleOfPMModelList = objSeleniumUtils.getTitleText(driver, PORTFOLIO_MODEL_MANAGEMENT_LIST_TITLE);
			WebElement element = driver.findElement(PORTFOLIO_MODEL_MANAGEMENT_LIST_TITLE);
			if (element.isDisplayed() && getTitleOfPMModelList.equalsIgnoreCase(portfolioModelListName)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyPortfolioModelListTitlePassed"),
						getTitleOfPMModelList));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyPortfolioModelListTitleFailed"),
					getTitleOfPMModelList));
			throw e;
		}
		return flag;
	}	

	public boolean createAndVerifyNewPortfolio(String strategyName, String objectiveName, String modelCurrency, String openClose, String modelStyle, String subAdvisorFee, String targetAnnualReturn, String targetAnnualVolatility, String successMsg, String portfolioAlreadyExistsMsg) throws Exception{
		String portfolioNameText = "A";
		boolean verifyPortfolioFlag = false;
		//portfolioNameText = createNewPortfolio(strategyName, objectiveName, modelCurrency, openClose, modelStyle, subAdvisorFee, targetAnnualReturn, targetAnnualVolatility, successMsg, portfolioAlreadyExistsMsg);
		verifyPortfolioFlag = verifyPortfolioIsPresent(modelCurrency, modelStyle, openClose);
		if((portfolioNameText!=null) && (verifyPortfolioFlag)){
			return true;
		}
		else{
			return false;
		}
	}
	
	// This method is used create new portfolio
	public String createNewPortfolio(String strategyName, String objectiveName, String modelCurrency, String openClose, String modelStyle, String subAdvisorFee, String targetAnnualReturn, String targetAnnualVolatility, String successMsg, String portfolioAlreadyExistsMsg) throws Exception{
		String portfolioNameText;
		clickOnPortfolioManagementTab();
		SeleniumUtils.actionScrollToBottom(driver);
		Thread.sleep(2000);
		SeleniumUtils.click(newPortfolioButtonElement(), ""); // Add message here
		AMPortfolioModelConstructionPage portfolioConstructionPage = new AMPortfolioModelConstructionPage(driver);
		portfolioNameText = portfolioConstructionPage.enterDetailsAndCreatePortfolio(strategyName, objectiveName, modelCurrency, openClose, modelStyle, subAdvisorFee, targetAnnualReturn, targetAnnualVolatility, successMsg, portfolioAlreadyExistsMsg);	
		return portfolioNameText;
	}
	
	// This method verifies the portfolio is present in the list
	public boolean verifyPortfolioIsPresent(String currency, String modelStyle, String openClose) throws Exception{
		int countOfRows;
		String actualRow = null;
		String expectedRow;
		try {
			String portfolioName = AMPortfolioModelConstructionPage.portfolioNameText;
			clickOnPortfolioManagementTab();
			expectedRow = portfolioName + " || " + currency + " || " + modelStyle + " || " + openClose;		
			countOfRows=SeleniumUtils.getCountOfWebElements(driver, By.xpath("//table/tbody/tr"));
			for(int i=1;i<=countOfRows;i++){
				String modelNameText = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				String currencyText = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();
				String modelStyleText = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				String openCloseText = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				if(modelNameText.equals(portfolioName)){
					actualRow = modelNameText + " || " + currencyText + " || " + modelStyleText + " || " + openCloseText;
					break;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		if(expectedRow.equals(actualRow)){
			return true;
		}
		else{
			return false;
		}
	}
}
