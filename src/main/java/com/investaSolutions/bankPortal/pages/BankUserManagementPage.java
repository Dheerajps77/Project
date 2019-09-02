package com.investaSolutions.bankPortal.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.PropertiesManager;
import com.investaSolutions.utils.SeleniumUtils;

public class BankUserManagementPage {
	private WebDriver driver;
	public static PropertiesManager properties = PropertiesManager.getInstance();

	public BankUserManagementPage (WebDriver driver) {
		this.driver = driver;
	}	

	private final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	private final By USERS_TAB = By.xpath("//span[contains(text(),'Users')]");
	private final By FIRSTNAME_TEXTBOX = By.xpath("//label[contains(text(),'FirstName')]/following::div[1]");
	private final By LASTNAME_TEXTBOX = By.xpath("//label[contains(text(),'LastName')]/following::div[1]");
	private final By EMAIL_TEXTBOX = By.xpath("//label[contains(text(),'Email')]/following::div[1]");
	private final By PASSWORD_TEXTBOX = By.xpath("//label[contains(text(),'Password')]/following::div[1]");
	private final By EXPIRATION_DATE_TEXTBOX = By.xpath("//label[contains(text(),'Expiration Date')]/following::div[1]");
	private final By CREATE_NEW_USER_BUTTON = By.xpath("//span[contains(text(),'Create New User')]");
	private final By NEW_USER_BUTTON = By.xpath("//span[contains(text(),'New User')]");
	private final By LIST_OF_USER_ROWS = By.xpath("//tbody[@class='ui-table-tbody']//tr");
	private final By LIST_OF_USER_COLUMNS = By.xpath("//thead[@class='ui-table-thead']//tr[@class='ng-star-inserted']/th");
	private final By DELETE_USER_CONFIRMATION_TITLE = By.xpath("//span[text()='Confirmation']");
	private final By DELETE_USER_YES_BUTTON = By.xpath("//span[text()='Yes']");

	public void clickOnUsersTab() {
		SeleniumUtils.waitForElementVisibility(driver, USERS_TAB, WAIT_SECONDS).click();
	}

	public WebElement deleteUserConfirmationTitleElement() {
		return	SeleniumUtils.waitForElementVisibility(driver, DELETE_USER_CONFIRMATION_TITLE, WAIT_SECONDS);
	}

	public WebElement deleteUserYesButtonElement() {
		return	SeleniumUtils.waitForElementVisibility(driver, DELETE_USER_YES_BUTTON, WAIT_SECONDS);
	}

	public void enterFirstName(String firstName) throws InterruptedException {
		SeleniumUtils.clickAndEnterText(driver, FIRSTNAME_TEXTBOX, WAIT_SECONDS, firstName);				
	}

	public void enterLastName(String lastName) throws InterruptedException{
		SeleniumUtils.clickAndEnterText(driver, LASTNAME_TEXTBOX, WAIT_SECONDS, lastName);				
	}

	public void enterEmail(String email) throws InterruptedException{
		SeleniumUtils.clickAndEnterText(driver, EMAIL_TEXTBOX, WAIT_SECONDS, email);				
	}

	public void enterPassword(String password) throws InterruptedException{
		SeleniumUtils.clickAndEnterText(driver, PASSWORD_TEXTBOX, WAIT_SECONDS, password);				
	}

	public void clickOnNewUserButton() {
		SeleniumUtils.waitForElementClickable(driver, NEW_USER_BUTTON, WAIT_SECONDS).click();
	}

	public void clickOnCreateNewUserButton() {
		SeleniumUtils.waitForElementClickable(driver, CREATE_NEW_USER_BUTTON, WAIT_SECONDS).click();
	}

	public void createNewBankUser(String firstName, String lastName, String email, String password) throws Exception{
		try {
			clickOnUsersTab();
			clickOnNewUserButton();
			TestBase.logInfo(String.format(properties.getLogMessage("NewBankUserData"), firstName, lastName, email, password));
			enterFirstName(firstName);
			enterLastName(lastName);
			enterEmail(email);
			enterPassword(password);
			SeleniumUtils.actionScrollToBottom(driver);
			SeleniumUtils.clickElement(driver, CREATE_NEW_USER_BUTTON);			
		} catch (Exception e) {
			throw e;
		}		
	}

	public ArrayList<String> getBankUsersList(){
		ArrayList<String> listOfUsers = new ArrayList<String>();
		SeleniumUtils.waitForElementVisibility(driver, NEW_USER_BUTTON, WAIT_SECONDS);
		int countOfUserRows = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_ROWS);
		int countOfUserColumns = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_COLUMNS);
		for(int i=1;i<=countOfUserRows;i++){
			String finalText = "";
			for(int j=3;j<=countOfUserColumns-2;j++){
				String columnText = driver.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[" + j + "]")).getText();
				if(j==3){
					finalText = columnText;
				}
				else{
					finalText = finalText + " || " + columnText;
				}
			}
			listOfUsers.add(finalText);
		}
		return listOfUsers;
	}

	public boolean verifyBankUserCreation(String firstName, String lastName, String email, String password) throws Exception{
		try {
			createNewBankUser(firstName, lastName, email, password);
			Thread.sleep(3000);
			String expectedUserDetails;
			ArrayList<String> listOfUSerDetails = getBankUsersList();
			expectedUserDetails = firstName + " || " + lastName + " || " + email;
			if(listOfUSerDetails.contains(expectedUserDetails)){
				return true;
			}
			else{
				return false;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean deleteBankUserUsingEmailAddress(String email) throws Exception{
		boolean flag = false;
		try {
			int countOfUserRows = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_ROWS);
			for(int i=1;i<=countOfUserRows;i++){
				String emailColumnText = driver.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[5]")).getText();
				if(emailColumnText.equals(email)){
					driver.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[2]")).click();
					if(deleteUserConfirmationTitleElement().isDisplayed()){
						deleteUserYesButtonElement().click();
						flag = true;
						break;
					}
				}
			}
			return flag;
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean verifyBankUserDeletedSuccessfully(String email) throws Exception{
		boolean flag = false;
		try {
			TestBase.logInfo(String.format(properties.getLogMessage("DeleteBankUserOperationStarted"), email));
			if(deleteBankUserUsingEmailAddress(email)){
				Thread.sleep(3000);
				int countOfUserRows = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_ROWS);
				for(int i=1;i<=countOfUserRows;i++){
					String emailColumnText = driver.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[5]")).getText();
					if(emailColumnText.equals(email)){
						flag = true;
					}
				}
			}
			return flag;
		}catch (Exception e) {
			throw e;
		}
	}
}
