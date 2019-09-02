package com.investaSolutions.assetManagerPortal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.PropertiesManager;
import com.investaSolutions.utils.SeleniumUtils;

public class AMStrategyManagementPage {
	private WebDriver driver;

	public AMStrategyManagementPage (WebDriver driver) {
		this.driver = driver;
	}

	private final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	public static PropertiesManager properties = PropertiesManager.getInstance();
	private final By STRATEGY_MANAGEMENT_TAB = By.xpath("//span[contains(text(),'Strategy Management')]");
	private final By STRATEGY_MANAGEMENT_LABEL = By.xpath("//legend[contains(text(),'Strategy Management')]");
	private final By STRATEGY_MANAGEMENT_SEARCH_HEADER = By.xpath("//th[text()='D']");
	private final By STRATEGY_MANAGEMENT_NAME_HEADER = By.xpath("//th[contains(text(),'Name')]");
	private final By STRATEGY_MANAGEMENT_DESCRIPTION_HEADER = By.xpath("//th[contains(text(),'Description')]");
	private final By STRATEGY_MANAGEMENT_NEWSTRATEGY_BUTTON = By.xpath("//span[contains(text(),'New Strategy')]");
	private final By STRATEGY_MANAGEMENT_BACK_BUTTON = By.xpath("//span[contains(text(),'Back')]");
	private final By STRATEGY_MANAGEMENT_SAVE_BUTTON = By.xpath("//span[contains(text(),'Save')]");
	private final By STRATEGY_MANAGEMENT_SUCCESS_MSG = By.xpath("//*[contains(@class,'ui-messages-success')]//ul/li");
	private final By STRATEGY_MANAGEMENT_NAME_TEXTBOX = By.xpath("//div[@class='ui-tabview-panels']/p-tabpanel/div/div//div[2]/span/b/input"); ////div[@id='ui-tabpanel-0']//div[1]//div[2]//span[1]
	private final By STRATEGY_MANAGEMENT_DESCRIPTION_TEXTBOX = By.xpath("//div[@class='ui-g-12 ui-md-6 ui-lg-9']//span[@class='md-inputfield']");

	public WebElement strategyManagementTabElement() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_TAB, WAIT_SECONDS);
	}

	public void clickViewIconOfStrategy(String strategyName) throws Exception {
		try {
			By viewIconUser=By.xpath("//td[contains(text(),'"+strategyName+"')]/preceding-sibling :: td//fa-icon");
			SeleniumUtils.scrollToViewElement(driver, viewIconUser);
			driver.findElement(viewIconUser).click();
			TestBase.logInfo(String.format(properties.getLogMessage("SelectStrategyFromList"), strategyName));
		} catch (Exception e) {
			TestBase.logInfo(String.format(properties.getLogMessage("SelectStrategyFromListError"), strategyName));
			throw e;
		}	
	}

	public WebElement strategyManagementBackButtonElement() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_BACK_BUTTON, WAIT_SECONDS);
	}

	public WebElement strategyManagementNewStrategyButtonElement() {
		return SeleniumUtils.waitForElementClickable(driver, STRATEGY_MANAGEMENT_NEWSTRATEGY_BUTTON, WAIT_SECONDS);
	}

	public WebElement strategyManagementNameTextBoxElement() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_NAME_TEXTBOX, WAIT_SECONDS);
	}

	public WebElement strategyManagementDescriptionTextBoxElement() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_DESCRIPTION_TEXTBOX, WAIT_SECONDS);
	}

	public String strategyManagementLabelElementText() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_LABEL, WAIT_SECONDS).getText();
	}

	public String strategyManagementSearchHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_SEARCH_HEADER, WAIT_SECONDS).getText();
	}

	public WebElement strategyManagementSaveButtonElement() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_SAVE_BUTTON, WAIT_SECONDS);
	}

	public String strategyManagementNameHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_NAME_HEADER, WAIT_SECONDS).getText();
	}

	public String strategyManagementDescriptionHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_DESCRIPTION_HEADER, WAIT_SECONDS).getText();
	}

	public String strategyManagementNewStrategyButtonElementText() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_NEWSTRATEGY_BUTTON, WAIT_SECONDS).getText();
	}

	public String strategyManagementBackButtonElementText() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_BACK_BUTTON, WAIT_SECONDS).getText();
	}

	public void clickNewStrategyButton() throws Exception{
		SeleniumUtils.click(strategyManagementNewStrategyButtonElement(), properties.getLogMessage("NewStrategyButtonClicked"));
	}

	public void clickSaveButton() throws Exception {
		SeleniumUtils.click(strategyManagementSaveButtonElement(), properties.getLogMessage("SaveButtonClicked"));
		TestBase.logInfo(String.format(properties.getLogMessage("ClickSaveButtonSuccess")));
	}

	public String strategyManagementSuccessTextMSG() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_MANAGEMENT_SUCCESS_MSG, WAIT_SECONDS).getText();
	}

	// This method verifies the details present on the Strategy Management page - returns true if success
	public boolean verifyStrategyManagementPageDetails(String strategyManagementLabelText, String searchHeaderText, String nameHeaderText, String descHeaderText, String newStrategyButtonText, String backButtonText) throws Exception{
		boolean flag = false;
		try {
			if(strategyManagementTabElement().isDisplayed()){
				SeleniumUtils.click(strategyManagementTabElement(), properties.getLogMessage("StrategyManagementTabClicked"));
				if(strategyManagementLabelElementText().equals(strategyManagementLabelText) && strategyManagementSearchHeaderElementText().equals(searchHeaderText) && strategyManagementNameHeaderElementText().equals(nameHeaderText) && strategyManagementDescriptionHeaderElementText().equals(descHeaderText) && strategyManagementNewStrategyButtonElementText().equals(newStrategyButtonText) && strategyManagementBackButtonElementText().equals(backButtonText)){
					flag = true;
					TestBase.logInfo(String.format(properties.getLogMessage("StrategyManagementDetailsVerified"), strategyManagementLabelElementText(), strategyManagementSearchHeaderElementText(), strategyManagementNameHeaderElementText(), strategyManagementDescriptionHeaderElementText(), strategyManagementNewStrategyButtonElementText(), strategyManagementBackButtonElementText(), strategyManagementLabelText, searchHeaderText, nameHeaderText, descHeaderText, newStrategyButtonText, backButtonText));
					return flag;
				}
				else{
					TestBase.logError(String.format(properties.getLogMessage("StrategyManagementDetailsNotMatched"), strategyManagementLabelText, searchHeaderText, nameHeaderText, descHeaderText, newStrategyButtonText, backButtonText, strategyManagementLabelElementText(), strategyManagementSearchHeaderElementText(), strategyManagementNameHeaderElementText(), strategyManagementDescriptionHeaderElementText(), strategyManagementNewStrategyButtonElementText(), strategyManagementBackButtonElementText()));
				}
			}
			else{
				TestBase.logError(properties.getLogMessage("StrategyManagementTabNotFound"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// This method creates a new Strategy from the Strategy Management page
	public boolean createNewStrategy(String strategyName, String strategyDescription, String objectiveName, String objectiveText) throws Exception{
		boolean flag = false;
		try {
			if(strategyManagementTabElement().isDisplayed()){
				SeleniumUtils.click(strategyManagementTabElement(), properties.getLogMessage("StrategyManagementTabClicked"));
				if(strategyManagementNewStrategyButtonElement().isDisplayed()){
					SeleniumUtils.actionScrollToBottom(driver);
					//SeleniumUtils.scrollToBottom(driver);
					//SeleniumUtils.scrollToViewElement(driver, STRATEGY_MANAGEMENT_NEWSTRATEGY_BUTTON);
					clickNewStrategyButton();
					Thread.sleep(3000);
					SeleniumUtils.clickAndEnterText(driver, STRATEGY_MANAGEMENT_NAME_TEXTBOX, 10, strategyName);
					SeleniumUtils.clickAndEnterText(driver, STRATEGY_MANAGEMENT_DESCRIPTION_TEXTBOX, 10, strategyDescription);	
					SeleniumUtils.actionScrollToTop(driver);
					//Added investment objectives
					AMStrategyManagementInvestmentObjectivesPage investmentObjectivesPage = new AMStrategyManagementInvestmentObjectivesPage(driver);
					investmentObjectivesPage.clickOnInvestmentObjectivesTab();
					investmentObjectivesPage.addInvestmentObjectives(objectiveName, objectiveText);
					SeleniumUtils.actionScrollToBottom(driver);
					clickNewStrategyButton();
					flag=true;
					TestBase.logInfo(String.format(properties.getLogMessage("NewStrategyCreationPassed"), strategyName, strategyDescription));					
				}
				else{
					TestBase.logError(String.format(properties.getLogMessage("NewStrategyCreationFailed"), strategyName, strategyDescription));
				}
			}
		}
		catch (Exception e) {
			throw e;
		}
		return flag;
	}

	// This method verifies a Strategy is present on the list present on Strategy Management page
	public boolean verifyStrategyIsPresent(String strategyName, String strategyDescription) throws Exception{
		boolean flag = false;
		try {
			int countOfRows = driver.findElements(By.xpath("//tbody[@class='ui-table-tbody']/tr")).size();
			for(int i=1;i<=countOfRows;i++){
				String strategyNameDisplayed = driver.findElement(By.xpath("//tbody[@class='ui-table-tbody']/tr["+ i +"]/td[2]")).getText();
				String strategyDescDisplayed = driver.findElement(By.xpath("//tbody[@class='ui-table-tbody']/tr["+ i +"]/td[3]")).getText();
				if(strategyNameDisplayed.equals(strategyName) && strategyDescDisplayed.equals(strategyDescription)){
					flag = true;
					TestBase.logInfo(String.format(properties.getLogMessage("VerifyStrategyPassed"), strategyName, strategyDescription));	
					break;
				}
			}
			if(flag==false){
				TestBase.logError(String.format(properties.getLogMessage("VerifyStrategyFailed"), strategyName, strategyDescription));
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	// This method creates a new strategy and verifies that the Strategy is present in the list
	public boolean createAndVerifyNewStrategy(String strategyName, String strategyDescription, String objectiveName, String objectiveText) throws Exception{
		boolean flag = false;			
		boolean verifyStrategyFlag = false;
		boolean createNewStrategyFlag = false;
		try {
			createNewStrategyFlag = createNewStrategy(strategyName, strategyDescription, objectiveName, objectiveText);
			SeleniumUtils.click(strategyManagementBackButtonElement(), properties.getLogMessage("BackButtonClicked"));
			SeleniumUtils.waitForElementVisibility(driver, By.xpath("//tbody[@class='ui-table-tbody']/tr"), 10) ;
			Thread.sleep(2000);
			verifyStrategyFlag = verifyStrategyIsPresent(strategyName, strategyDescription);
			if(createNewStrategyFlag && verifyStrategyFlag){
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	public boolean verifyUpdateExistingStrategyName(String strategyName,String updateStrategyName,String strategyDescription, String successMSG) throws Exception {
		boolean flag=false;
		boolean verifyStrategyFlag=false;
		boolean verifySuccessMSG=false;
		try {
			clickViewIconOfStrategy(strategyName);
			Thread.sleep(2000);
			TestBase.logInfo(String.format(properties.getLogMessage("EnterStrategyDetailsToUpdate"), strategyName, updateStrategyName));
			strategyManagementNameTextBoxElement().clear();
			strategyManagementNameTextBoxElement().sendKeys(updateStrategyName);
			clickSaveButton();
			String actualSuccessMSG=strategyManagementSuccessTextMSG();
			verifySuccessMSG=actualSuccessMSG.equals(successMSG);
			if(verifySuccessMSG){
				TestBase.logInfo(String.format(properties.getLogMessage("VerifyUpdateStrategySuccessMessagePassed"), successMSG));				
			}
			else{
				TestBase.logInfo(String.format(properties.getLogMessage("VerifyUpdateStrategySuccessMessageFailed"), successMSG));								
			}
			SeleniumUtils.click(strategyManagementBackButtonElement(), properties.getLogMessage("BackButtonClicked"));
			verifyStrategyFlag = verifyStrategyIsPresent(updateStrategyName, strategyDescription);
			if(verifyStrategyFlag && verifySuccessMSG){
				flag = true;
				TestBase.logInfo(String.format(properties.getLogMessage("UpdateStrategyNameSuccess"), strategyName, updateStrategyName));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(properties.getLogMessage("UpdateStrategyNameError"), strategyName, updateStrategyName));			
			throw e;
		}
		return flag;
	}
}
