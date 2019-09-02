package com.investaSolutions.assetManagerPortal.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.PropertiesManager;
import com.investaSolutions.utils.SeleniumUtils;

public class AMPortfolioModelConstructionPage {
	private WebDriver driver;

	public AMPortfolioModelConstructionPage (WebDriver driver) {
		this.driver = driver;
	}

	private final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	public static PropertiesManager properties = PropertiesManager.getInstance();
	public static String portfolioNameText;
	private final By CONSTRUCTION_TAB = By.xpath("//span[contains(text(),'Construction')]");	
	private final By STRATEGY_DROPDOWN = By.xpath("//div[@class='layout-main']//div[2]//div[2]//p-dropdown[1]");
	private final By STRATEGY_DROPDOWN_VALUES = By.xpath("//div[@class='ui-dropdown-items-wrapper']//li");
	private final By INVESTMENT_OBJECTIVE_DROPDOWN = By.xpath("//div[@class='ui-g-12 ui-md-6 ui-lg-7 ng-star-inserted']//p-dropdown[@id='dropdown']");
	private final By INVESTMENT_OBJECTIVE_DROPDOWN_VALUES = By.xpath("//div[@class='ui-dropdown-items-wrapper']//li");
	private final By MODEL_CURRENCY_DROPDOWN = By.xpath("//span[@class='md-inputfield']//p-dropdown[@id='dropdown']");
	private final By MODEL_CURRENCY_DROPDOWN_VALUES = By.xpath("//div[@class='ui-dropdown-items-wrapper']//li");
	private final By OPEN_CLOSE_DROPDOWN = By.xpath("//div[@class='ui-tabview-panel ui-widget-content ng-star-inserted']//div[@class='ui-g-6 nopad']//div[6]//p-dropdown[@id='dropdown']");
	private final By OPEN_CLOSE_DROPDOWN_VALUES = By.xpath("//div[@class='ui-dropdown-items-wrapper']//li");
	private final By MODEL_STYLE_DROPDOWN = By.xpath("//div[@class='ui-tabview-panel ui-widget-content ng-star-inserted']//div[@class='ui-g-6 nopad']//div[8]//p-dropdown[@id='dropdown']");
	private final By MODEL_STYLE_DROPDOWN_VALUES = By.xpath("//div[@class='ui-dropdown-items-wrapper']//li");
	private final By SAVE_BUTTON = By.xpath("//span[contains(text(),'Save')]");
	private final By SUB_ADVISOR_FEE_TEXTBOX = By.xpath("//div[@class='layout-main']//div[2]//div[1]//div[1]//div[2]");
	private final By TARGET_ANNUAL_RETURN_TEXTBOX = By.xpath("//div[contains(@class,'layout-main')]//div[2]//div[1]//div[2]//div[2]");
	private final By TARGET_ANNUAL_VOLATILITY_TEXTBOX = By.xpath("//div[contains(@class,'layout-main')]//div[2]//div[1]//div[3]//div[2]");
	private final By INCEPTION_DATE_CALENDAR_LINK = By.xpath("//span[@class='ui-button-icon-left ui-clickable pi pi-calendar']");
	private final By INCEPTION_DATE_TODAYS_DATE = By.xpath("//a[@class='ui-state-default ng-tns-c9-6 ui-state-highlight ng-star-inserted']");
	private final By PORTFOLIO_CREATION_SUCCESS_MSG = By.xpath("//*[contains(@class,'ui-messages')]//ul/li");
	private final By PORTFOLIO_ALREADY_EXISTS_MSG = By.xpath("//*[contains(@class,'ui-messages')]//ul/li");
	private final By PORTFOLIO_NAME_TEXT = By.xpath("(//span[@class='md-inputfield'])[1]");
	
	public WebElement constructionTabElement() {
		return SeleniumUtils.waitForElementPresence(driver, CONSTRUCTION_TAB, WAIT_SECONDS);
	}

	public WebElement strategyDropdownElement() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_DROPDOWN, WAIT_SECONDS);
	}
	
	public String portfolioNameText() {
		return SeleniumUtils.waitForElementPresence(driver, PORTFOLIO_NAME_TEXT, WAIT_SECONDS).getText();
	}
	
	public WebElement inceptionDateCurrentDateElement() {
		return SeleniumUtils.waitForElementPresence(driver, INCEPTION_DATE_TODAYS_DATE, WAIT_SECONDS);
	}

	public WebElement inceptionDateDatePickerElement() {
		return SeleniumUtils.waitForElementPresence(driver, INCEPTION_DATE_CALENDAR_LINK, WAIT_SECONDS);
	}

	public WebElement strategyDropdownValuesElement() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_DROPDOWN_VALUES, WAIT_SECONDS);
	}
	
	public String portfolioCreationSuccessTextMSG() {
		return SeleniumUtils.waitForElementPresence(driver, PORTFOLIO_CREATION_SUCCESS_MSG, WAIT_SECONDS).getText();
	}
	
	public WebElement portfolioAlreadyExistsTextMSG() {
		return SeleniumUtils.waitForElementPresence(driver, PORTFOLIO_ALREADY_EXISTS_MSG, WAIT_SECONDS);
	}
	
	public WebElement subAdvisorFeeElement() {
		return SeleniumUtils.waitForElementPresence(driver, SUB_ADVISOR_FEE_TEXTBOX, WAIT_SECONDS);
	}
	public WebElement targetAnnualReturnElement() {
		return SeleniumUtils.waitForElementPresence(driver, TARGET_ANNUAL_RETURN_TEXTBOX, WAIT_SECONDS);
	}

	public WebElement targetAnnualVolatilityElement() {
		return SeleniumUtils.waitForElementPresence(driver, TARGET_ANNUAL_VOLATILITY_TEXTBOX, WAIT_SECONDS);
	}

	public WebElement investmentObjectiveDropdownElement() {
		return SeleniumUtils.waitForElementPresence(driver, INVESTMENT_OBJECTIVE_DROPDOWN, WAIT_SECONDS);
	}

	public WebElement investmentObjectiveDropdownValuesElement() {
		return SeleniumUtils.waitForElementPresence(driver, INVESTMENT_OBJECTIVE_DROPDOWN_VALUES, WAIT_SECONDS);
	}

	public WebElement modelCurrencyDropdownElement() {
		return SeleniumUtils.waitForElementPresence(driver, MODEL_CURRENCY_DROPDOWN, WAIT_SECONDS);
	}

	public WebElement modelCurrencyDropdownValuesElement() {
		return SeleniumUtils.waitForElementPresence(driver, MODEL_CURRENCY_DROPDOWN_VALUES, WAIT_SECONDS);
	}

	public WebElement openCloseDropdownElement() {
		return SeleniumUtils.waitForElementPresence(driver, OPEN_CLOSE_DROPDOWN, WAIT_SECONDS);
	}

	public WebElement openCloseDropdownValuesElement() {
		return SeleniumUtils.waitForElementPresence(driver, OPEN_CLOSE_DROPDOWN_VALUES, WAIT_SECONDS);
	}

	public WebElement modelStyleDropdownElement() {
		return SeleniumUtils.waitForElementPresence(driver, MODEL_STYLE_DROPDOWN, WAIT_SECONDS);
	}

	public WebElement modelStyleDropdownValuesElement() {
		return SeleniumUtils.waitForElementPresence(driver, MODEL_STYLE_DROPDOWN_VALUES, WAIT_SECONDS);
	}

	public WebElement saveButtonElement() {
		return SeleniumUtils.waitForElementPresence(driver, SAVE_BUTTON, WAIT_SECONDS);
	}

	// This method is used to select the inception date 
	public void selectInceptionDate(){
		inceptionDateDatePickerElement().click();
		inceptionDateCurrentDateElement().click();
	}

	public void clickAndSelectStrategyDropdown(String strategyValue) throws InterruptedException{
		boolean flag = false;
		strategyDropdownElement().click();
		List<WebElement> strategyDropdownValues = driver.findElements(STRATEGY_DROPDOWN_VALUES);
		int totalNumberOfstrategyDropdownValues = strategyDropdownValues.size();
		for (int i = 1; i <= totalNumberOfstrategyDropdownValues; i++) {
			String textOfStrategy = driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']//li[" + i + "]")).getText();
			if(textOfStrategy.equals(strategyValue)){
				driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']//li[" + i + "]")).click();
				flag=true;
				Thread.sleep(1000);
				break;
			}
		}
		if(!flag){
			TestBase.logError(String.format(TestBase.properties.getLogMessage("PortfolioConstructionStrategyDropdownValueNotFound"), strategyValue));
		}
	}

	public void clickAndSelectOpenCloseDropdown(String openCloseValue) throws InterruptedException{
		boolean flag = false;
		openCloseDropdownElement().click();
		List<WebElement> openCloseDropdownValues = driver.findElements(OPEN_CLOSE_DROPDOWN_VALUES);
		int totalNumberOfOpenCloseDropdownValues = openCloseDropdownValues.size();
		for (int i = 1; i <= totalNumberOfOpenCloseDropdownValues; i++) {
			String textOfOpenClose = driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']//li[" + i + "]")).getText();
			if(textOfOpenClose.equals(openCloseValue)){
				driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']//li[" + i + "]")).click();
				flag=true;
				Thread.sleep(1000);
				break;
			}
		}
		if(!flag){
			TestBase.logError(String.format(TestBase.properties.getLogMessage("PortfolioConstructionOpenCloseDropdownValueNotFound"), openCloseValue));
		}
	}

	public void clickAndSelectModelCurrencyDropdown(String modelCurrencyDropdownValue) throws InterruptedException{
		boolean flag = false;
		modelCurrencyDropdownElement().click();
		List<WebElement> modelCurrencyDropdownValues = driver.findElements(MODEL_CURRENCY_DROPDOWN_VALUES);
		int totalNumberOfModelCurrencyDropdownValues = modelCurrencyDropdownValues.size();
		for (int i = 1; i <= totalNumberOfModelCurrencyDropdownValues; i++) {
			String textOfModelCurrency = driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']//li[" + i + "]")).getText();
			if(textOfModelCurrency.equals(modelCurrencyDropdownValue)){
				driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']//li[" + i + "]")).click();
				flag=true;
				Thread.sleep(1000);
				break;
			}
		}
		if(!flag){
			TestBase.logError(String.format(TestBase.properties.getLogMessage("PortfolioConstructionModelCurrencyDropdownValueNotFound"), modelCurrencyDropdownValue));
		}
	}

	public void clickAndSelectInvestmentObjectiveDropdown(String investmentObjectiveValue) throws InterruptedException{
		boolean flag = false;
		investmentObjectiveDropdownElement().click();
		List<WebElement> investmentObjectiveDropdownValues = driver.findElements(INVESTMENT_OBJECTIVE_DROPDOWN_VALUES);
		int totalNumberOfinvestmentObjectiveDropdownValues = investmentObjectiveDropdownValues.size();
		for (int i = 1; i <= totalNumberOfinvestmentObjectiveDropdownValues; i++) {
			String textOfInvestmentObjective = driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']//li[" + i + "]")).getText();
			if(textOfInvestmentObjective.equals(investmentObjectiveValue)){
				driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']//li[" + i + "]")).click();
				flag=true;
				Thread.sleep(1000);
				break;
			}
		}
		if(!flag){
			TestBase.logError(String.format(TestBase.properties.getLogMessage("PortfolioConstructionInvestmentObjectiveDropdownValueNotFound"), investmentObjectiveValue));
		}
	}

	public void clickAndSelectModelStyleDropdown(String modelStyleValue) throws InterruptedException{
		boolean flag = false;
		modelStyleDropdownElement().click();
		List<WebElement> modelStyleDropdownValues = driver.findElements(MODEL_STYLE_DROPDOWN_VALUES);
		int totalNumberOfModelStyleDropdownValues = modelStyleDropdownValues.size();
		for (int i = 1; i <= totalNumberOfModelStyleDropdownValues; i++) {
			String textOfModelStyle = driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']//li[" + i + "]")).getText();
			if(textOfModelStyle.equals(modelStyleValue)){
				driver.findElement(By.xpath("//div[@class='ui-dropdown-items-wrapper']//li[" + i + "]")).click();
				flag=true;
				Thread.sleep(1000);
				break;
			}
		}
		if(!flag){
			TestBase.logError(String.format(TestBase.properties.getLogMessage("PortfolioConstructionModelStyleDropdownValueNotFound"), modelStyleValue));
		}
	}

	public String enterDetailsAndCreatePortfolio(String strategyValue, String investmentObjectiveValue, String modelCurrencyDropdownValue, String openCloseValue, String modelStyleValue, String subAdvisorFee, String targetAnnualReturn, String targetAnnualVolatility, String successMSG, String portfolioAlreadyExistsMsg) throws Exception{
		try {
			Boolean verifySuccessMSG;
			//String portfolioNameText;
			SeleniumUtils.actionScrollToTop(driver);
			constructionTabElement().click();
			clickAndSelectStrategyDropdown(strategyValue);
			selectInceptionDate();
			clickAndSelectInvestmentObjectiveDropdown(investmentObjectiveValue);
			clickAndSelectModelCurrencyDropdown(modelCurrencyDropdownValue);
			clickAndSelectOpenCloseDropdown(openCloseValue);
			clickAndSelectModelStyleDropdown(modelStyleValue);
			SeleniumUtils.actionScrollToBottom(driver);
			SeleniumUtils.clickAndEnterText(driver, SUB_ADVISOR_FEE_TEXTBOX, WAIT_SECONDS, subAdvisorFee);
			SeleniumUtils.clickAndEnterText(driver, TARGET_ANNUAL_RETURN_TEXTBOX, WAIT_SECONDS, targetAnnualReturn);
			SeleniumUtils.clickAndEnterText(driver, TARGET_ANNUAL_VOLATILITY_TEXTBOX, WAIT_SECONDS, targetAnnualVolatility);
			saveButtonElement().click();
			SeleniumUtils.actionScrollToTop(driver);
			portfolioNameText = portfolioNameText();
			String actualMsgDisplayedOnPage=portfolioCreationSuccessTextMSG();
			verifySuccessMSG=actualMsgDisplayedOnPage.equals(successMSG);
			if(verifySuccessMSG){
				TestBase.logInfo(String.format(properties.getLogMessage("VerifyCreatePortfolioSuccessMessagePassed"), successMSG));				
			}
			else if(portfolioAlreadyExistsTextMSG().isDisplayed()){
				if(portfolioAlreadyExistsTextMSG().getText().equals(portfolioAlreadyExistsMsg))
				{
					TestBase.logError(String.format(properties.getLogMessage("PortfolioAlreadyExistsMessage"), portfolioAlreadyExistsMsg));		
				}
				else{
					TestBase.logError(String.format(properties.getLogMessage("VerifyCreatePortfolioSuccessMessageFailed"), successMSG, actualMsgDisplayedOnPage));	
				}											
			}
			else{
				TestBase.logError(String.format(properties.getLogMessage("VerifyCreatePortfolioSuccessMessageFailed"), successMSG, actualMsgDisplayedOnPage));	
			}
			return portfolioNameText;
		} catch (Exception e) {
			throw e;
		}
	}
}
