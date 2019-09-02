package com.investaSolutions.assetManagerPortal.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.GenericUtils;
import com.investaSolutions.utils.PropertiesManager;
import com.investaSolutions.utils.SeleniumUtils;
import com.investaSolutions.utils.UserFunctions;

public class AMUserManagementPage {
	private WebDriver driver;
	public static PropertiesManager properties = PropertiesManager.getInstance();

	public AMUserManagementPage(WebDriver driver) {
		this.driver = driver;
	}

	private final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	private final By ASSET_MANAGER_TAB = By.xpath("//span[contains(text(),'Asset Manager')]");
	private final By PROFILE_LINK = By.xpath("//span[contains(text(),'Profile')]");
	private final By USER_MANAGEMENT_LINK = By.xpath("//span[contains(text(),'User Management')]");
	private final By USER_MANAGEMENT_LABEL = By.xpath("//legend[contains(text(),'User Management')]");
	private final By USER_MANAGEMENT_SEARCH_HEADER = By.xpath("(//th[text()='E'])[1]");
	private final By USER_MANAGEMENT_DELETE_HEADER = By.xpath("//th[text()='D']");
	private final By USER_MANAGEMENT_FIRSTNAME_HEADER = By.xpath("//th[contains(text(),'Firstname')]");
	private final By USER_MANAGEMENT_LASTNAME_HEADER = By.xpath("//th[contains(text(),'Lastname')]");
	private final By USER_MANAGEMENT_EMAIL_HEADER = By.xpath("//th[contains(text(),'Email')]");
	private final By USER_MANAGEMENT_ENABLED_HEADER = By.xpath("(//th[text()='E'])[2]");
	private final By USER_MANAGEMENT_LOCKED_HEADER = By.xpath("//th[text()='L']");
	private final By USER_MANAGEMENT_NEWUSER_BUTTON = By.xpath("//span[contains(text(),'New User')]");
	private final By USER_MANAGEMENT_BACK_BUTTON = By.xpath("//span[contains(text(),'Back')]");
	private final By USER_MANAGEMENT_FIRST_PAGINATION = By.xpath(
			"//a[@class='ui-paginator-first ui-paginator-element ui-state-default ui-corner-all ui-state-disabled']");
	private final By USER_MANAGEMENT_PREVIOUS_PAGINATION = By.xpath(
			"//a[@class='ui-paginator-prev ui-paginator-element ui-state-default ui-corner-all ui-state-disabled']");
	private final By USER_MANAGEMENT_NEXT_PAGINATION = By.xpath(
			"//a[@class='ui-paginator-next ui-paginator-element ui-state-default ui-corner-all ui-state-disabled']");
	private final By USER_MANAGEMENT_LAST_PAGINATION = By.xpath(
			"//a[@class='ui-paginator-last ui-paginator-element ui-state-default ui-corner-all ui-state-disabled']");
	private final By USER_MANAGEMENT_CURRENTPAGE_PAGINATION = By.xpath("//span[@class='ui-paginator-pages']");
	private final By NEW_USER_BUTTON = By.xpath("//span[contains(text(),'New User')]");
	private final By FIRSTNAME_TEXTBOX = By
			.xpath("//div[@class='ui-g-12']//div[1]//div[2]//span[1]//span[1]//input[1]");
	private final By LASTNAME_TEXTBOX = By.xpath("//div[@class='ui-g-12']//div[1]//div[4]//span[1]//span[1]//input[1]");
	private final By EMAIL_TEXTBOX = By.xpath("//div[@class='layout-main']//div[2]//div[2]//span[1]//span[1]//input");
	private final By PASSWORD_TEXTBOX = By.xpath(
			"//div[@class='ui-g-12 ui-md-6 ui-lg-3 ng-star-inserted']//span[@class='md-inputfield']//span[@class='md-inputfield']//input");
	private final By EXPIRATION_DATE_TEXTBOX = By.xpath(
			"//input[@class='ng-tns-c13-86 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']");
	private final By CREATE_NEW_USER_BUTTON = By.xpath("//span[contains(text(),'Create new user')]");

	private final By LIST_OF_USER_ROWS = By.xpath("//tbody[@class='ui-table-tbody']//tr");
	private final By LIST_OF_USER_COLUMNS = By
			.xpath("//thead[@class='ui-table-thead']//tr[@class='ng-star-inserted']/th");
	private final By MODIFY_USER_BUTTON = By.xpath("//span[text()='Modify user']");
	private final By DISABLE_BUTTON = By.xpath("//span[text()='Disable']");
	private final By ENABLE_BUTTON = By.xpath("//span[text()='Enable']");
	private final By SUCCESSMSG_TEXT = By.xpath("//*[contains(@class,'ui-messages-success')]//ul/li");
	private final By CANCEL_BUTTON = By.xpath("//span[text()='Cancel']");
	private final By DISABLED_USER_ERROR_MESSAGE = By.xpath("//*[contains(@class,'ui-messages-error')]//ul/li");
	private final By ENABLED_DISABLED_USER_SUCCESS_MSG = By.xpath("//*[contains(@class,'ui-messages-success')]//ul/li");
	private final By ENABLED_USER_BUTTON = By.xpath(
			"//button[@class='ui-button-success ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']");
	private final By DISABLED_USER_BUTON = By.xpath(
			"//button[@class='ui-button-warning ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']//span[text()='Disable']");
	private final By CONFIRMATION_WINDOW = By.xpath(
			"//p-confirmdialog[@icon='fa fa-question-circle']//div[@class='ui-dialog-titlebar ui-widget-header ui-helper-clearfix ui-corner-top']");

	private final By YES_BUTTON = By.xpath("//div[contains(@class,'ui-dialog-footer')]//button[1]");
	private final By DELETED_USER_ERROR_MESSAGE = By.xpath("//*[contains(@class,'ui-messages-error')]//ul/li");

	public WebElement assetManagerTabElement() {
		return SeleniumUtils.waitForElementVisibility(driver, ASSET_MANAGER_TAB, WAIT_SECONDS);
	}

	public String successMsgText() {
		return SeleniumUtils.waitForElementPresence(driver, SUCCESSMSG_TEXT, WAIT_SECONDS).getText();
	}

	public WebElement firstNameTextBoxElement() {
		return SeleniumUtils.waitForElementVisibility(driver, FIRSTNAME_TEXTBOX, WAIT_SECONDS);
	}

	public WebElement modifyUserButtonElement() throws InterruptedException {
		SeleniumUtils.scrollToViewElement(driver, MODIFY_USER_BUTTON);
		Thread.sleep(1000);
		return SeleniumUtils.waitForElementVisibility(driver, MODIFY_USER_BUTTON, WAIT_SECONDS);
	}

	public WebElement disableButtonElement() {
		return SeleniumUtils.waitForElementPresence(driver, DISABLE_BUTTON, WAIT_SECONDS);
	}

	public WebElement cancelButtonElement() {
		SeleniumUtils.scrollToViewElement(driver, CANCEL_BUTTON);
		return SeleniumUtils.waitForElementPresence(driver, CANCEL_BUTTON, WAIT_SECONDS);
	}

	public void clickAssetManagerTab() {
		assetManagerTabElement().click();
	}

	public void clickProfileLink() {
		SeleniumUtils.waitForElementPresence(driver, PROFILE_LINK, WAIT_SECONDS).click();
	}

	public WebElement userManagementLinkElement() {
		return SeleniumUtils.waitForElementVisibility(driver, USER_MANAGEMENT_LINK, WAIT_SECONDS);
	}

	public void clickUserManagementLink() {
		userManagementLinkElement().click();
	}

	public void clickNewUserButton() {
		SeleniumUtils.waitForElementPresence(driver, NEW_USER_BUTTON, WAIT_SECONDS).click();
	}

	public void enterFirstName(String firstName) throws InterruptedException {
		SeleniumUtils.clickAndEnterText(driver, FIRSTNAME_TEXTBOX, WAIT_SECONDS, firstName);
	}

	public void enterLastName(String lastName) throws InterruptedException {
		SeleniumUtils.clickAndEnterText(driver, LASTNAME_TEXTBOX, WAIT_SECONDS, lastName);
	}

	public void enterEmail(String email) throws InterruptedException {
		SeleniumUtils.clickAndEnterText(driver, EMAIL_TEXTBOX, WAIT_SECONDS, email);
	}

	public void enterPassword(String password) throws InterruptedException {
		SeleniumUtils.clickAndEnterText(driver, PASSWORD_TEXTBOX, WAIT_SECONDS, password);
	}

	public void clickCreateNewUserButton() {
		SeleniumUtils.waitForElementClickable(driver, CREATE_NEW_USER_BUTTON, WAIT_SECONDS).click();
	}

	public String userManagementLabelElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_LABEL, WAIT_SECONDS).getText();
	}

	public String userManagementSearchHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_SEARCH_HEADER, WAIT_SECONDS).getText();
	}

	public String userManagementDeleteHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_DELETE_HEADER, WAIT_SECONDS).getText();
	}

	public String userManagementFirstNameHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_FIRSTNAME_HEADER, WAIT_SECONDS).getText();
	}

	public String userManagementLastNameHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_LASTNAME_HEADER, WAIT_SECONDS).getText();
	}

	public String userManagementEmailHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_EMAIL_HEADER, WAIT_SECONDS).getText();
	}

	public String userManagementEnabledHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_ENABLED_HEADER, WAIT_SECONDS).getText();
	}

	public String userManagementLockedHeaderElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_LOCKED_HEADER, WAIT_SECONDS).getText();
	}

	public String userManagementNewUserButtonElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_NEWUSER_BUTTON, WAIT_SECONDS).getText();
	}

	public String userManagementBackButtonElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_BACK_BUTTON, WAIT_SECONDS).getText();
	}

	public WebElement userManagementFirstPaginationElement() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_FIRST_PAGINATION, WAIT_SECONDS);
	}

	public WebElement userManagementPreviousPaginationElement() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_PREVIOUS_PAGINATION, WAIT_SECONDS);
	}

	public WebElement userManagementNextPaginationElement() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_NEXT_PAGINATION, WAIT_SECONDS);
	}

	public WebElement userManagementLastPaginationElement() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_LAST_PAGINATION, WAIT_SECONDS);
	}

	public WebElement userManagementCurrentPagePaginationElementText() {
		return SeleniumUtils.waitForElementPresence(driver, USER_MANAGEMENT_CURRENTPAGE_PAGINATION, WAIT_SECONDS);
	}

	// This function will get deleted user after click on delete button
	public boolean verifyDeletedUserFromUsersList(String emailAddress) throws InterruptedException, Exception {
		boolean flag = true;
		SeleniumUtils.waitForElementVisibility(driver, NEW_USER_BUTTON, WAIT_SECONDS);
		int countOfUserRows = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_ROWS);
		int countOfUserColumns = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_COLUMNS);
		String specificUserEmailValue = "";
		WebElement clickOnDeletedButton;
		String columnText = "";		
		for (int i = 1; i <= countOfUserRows; i++) {
			for (int j = 5; j <= countOfUserColumns - 2; j++) {
				WebElement emailIdElement = driver
						.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[" + j + "]"));
				columnText = emailIdElement.getText();
				if (!emailAddress.equals(columnText)) {
					WebElement specificUserEmail = driver
							.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[2]/fa-icon"));
					specificUserEmailValue = driver
							.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[" + j + "]"))
							.getText();
					specificUserEmail.click();
					Thread.sleep(1000);
					if (confirmationWindow()) {
						clickOnDeletedButton = SeleniumUtils.waitForElementClickable(driver, YES_BUTTON, 30);
						SeleniumUtils.waitAndClick(driver, clickOnDeletedButton, 5);
						Thread.sleep(2000);
					}
				}
			}
		}
		int countOfUserRowsAfterDeletion = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_ROWS);
		if (countOfUserRowsAfterDeletion > 1) {
			flag = false;
		}
		return flag;
	}
	
	public void delete(String emailAddress) throws Exception {
		boolean flag = true;
		SeleniumUtils.waitForElementVisibility(driver, NEW_USER_BUTTON, WAIT_SECONDS);
		int countOfUserRows = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_ROWS);
		//int countOfUserColumns = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_COLUMNS);
		for(int i=1; i<=countOfUserRows; i++) {
			String email=driver.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[5]")).getText();
			if(!email.equalsIgnoreCase(emailAddress)) {
				driver.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[2]/fa-icon")).click();
				Thread.sleep(1000);
				if (confirmationWindow()) {
					WebElement clickOnDeletedButton = SeleniumUtils.waitForElementClickable(driver, YES_BUTTON, 30);
					SeleniumUtils.waitAndClick(driver, clickOnDeletedButton, 5);
					Thread.sleep(2000);
				}
			}
			
		}
	}

	/***
	 * This will verify if all delete user from user list
	 * 
	 * @throws Exception
	 */
	public boolean verifyAlldeletedUsers(String emailAddress) throws Exception {
		boolean flag = false;		
		try {
			clickAssetManagerTab();
			clickUserManagementLink();
			Thread.sleep(1000);
			if(verifyDeletedUserFromUsersList(emailAddress))
			{
				flag=true;
			}

		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	public void createNewUser(String firstName, String lastName, String email, String password) throws Exception {
		try {
			clickAssetManagerTab();
			clickUserManagementLink();
			clickNewUserButton();
			TestBase.logInfo(
					String.format(properties.getLogMessage("NewUserData"), firstName, lastName, email, password));
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

	public ArrayList<String> getUsersList() {
		ArrayList<String> listOfUsers = new ArrayList<String>();
		SeleniumUtils.waitForElementVisibility(driver, NEW_USER_BUTTON, WAIT_SECONDS);
		int countOfUserRows = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_ROWS);
		int countOfUserColumns = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_COLUMNS);
		for (int i = 1; i <= countOfUserRows; i++) {
			String finalText = "";
			for (int j = 3; j <= countOfUserColumns - 2; j++) {
				String columnText = driver
						.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[" + j + "]"))
						.getText();
				if (j == 3) {
					finalText = columnText;
				} else {
					finalText = finalText + " || " + columnText;
				}
			}
			listOfUsers.add(finalText);
		}
		return listOfUsers;
	}

	public boolean verifyUserCreation(String firstName, String lastName, String email, String password)
			throws Exception {
		try {
			createNewUser(firstName, lastName, email, password);
			String expectedUserDetails;
			ArrayList<String> listOfUSerDetails = getUsersList();
			expectedUserDetails = firstName + " || " + lastName + " || " + email;
			if (listOfUSerDetails.contains(expectedUserDetails)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean verifyUserManagementPageDetails(String userManagementLabelText, String searchHeaderText,
			String deleteHeaderText, String firstNameHeaderText, String lastNameHeaderText, String emailHeaderText,
			String enabledHeaderText, String lockedHeaderText, String newUserButtonText, String backButtonText)
			throws Exception {
		boolean flag = false;
		if (assetManagerTabElement().isDisplayed()) {
			SeleniumUtils.click(assetManagerTabElement(), properties.getLogMessage("AssetManagerTabClicked"));
			SeleniumUtils.click(userManagementLinkElement(), properties.getLogMessage("UserManagementTabClicked"));
			if (userManagementLabelElementText().equals(userManagementLabelText)
					&& userManagementSearchHeaderElementText().equals(searchHeaderText)
					&& userManagementDeleteHeaderElementText().equals(deleteHeaderText)
					&& userManagementFirstNameHeaderElementText().equals(firstNameHeaderText)
					&& userManagementLastNameHeaderElementText().equals(lastNameHeaderText)
					&& userManagementEmailHeaderElementText().equals(emailHeaderText)
					&& userManagementEnabledHeaderElementText().equals(enabledHeaderText)
					&& userManagementLockedHeaderElementText().equals(lockedHeaderText)
					&& userManagementNewUserButtonElementText().equals(newUserButtonText)
					&& userManagementBackButtonElementText().equals(backButtonText)) {
				try {
					if (userManagementFirstPaginationElement().isDisplayed()
							&& userManagementLastPaginationElement().isDisplayed()
							&& userManagementPreviousPaginationElement().isDisplayed()
							&& userManagementNextPaginationElement().isDisplayed()
							&& userManagementCurrentPagePaginationElementText().isDisplayed()) {
						flag = true;
						TestBase.logInfo(String.format(properties.getLogMessage("UserManagementDetailsVerified"),
								userManagementLabelText, searchHeaderText, deleteHeaderText, firstNameHeaderText,
								lastNameHeaderText, emailHeaderText, enabledHeaderText, lockedHeaderText,
								newUserButtonText, backButtonText, userManagementLabelElementText(),
								userManagementSearchHeaderElementText(), userManagementDeleteHeaderElementText(),
								userManagementFirstNameHeaderElementText(), userManagementLastNameHeaderElementText(),
								userManagementEmailHeaderElementText(), userManagementEnabledHeaderElementText(),
								userManagementLockedHeaderElementText(), userManagementNewUserButtonElementText(),
								userManagementBackButtonElementText()));
						return flag;
					}
				} catch (Exception e) {
					TestBase.logError(properties.getLogMessage("UserManagementPaginationError"));
					throw e;
				}
			}
		} else {
			TestBase.logError(properties.getLogMessage("AssetManagerTabNotFound"));
		}
		return flag;
	}

	public void clickViewIconOfUser(String userName) {
		By viewIconUser = By.xpath("//td[contains(text(),'" + userName + "')]/preceding-sibling :: td[2]//fa-icon");
		SeleniumUtils.scrollToViewElement(driver, viewIconUser);
		driver.findElement(viewIconUser).click();
	}

	public String getAttributeOfDisableUser(String userName) {
		By eImage = By.xpath("//*[contains(text(),'" + userName + "')]/following-sibling :: td[3]/fa-icon");
		String str = driver.findElement(eImage).getAttribute("icon");
		return str;
	}

	public boolean verifyDisableUser(String userName, String successMsg, String status) throws Exception {
		boolean flag = false;
		clickViewIconOfUser(userName);
		if (SeleniumUtils.isElementPresent(driver, DISABLE_BUTTON)) {
			Thread.sleep(2000);
			SeleniumUtils.Click(disableButtonElement(),
					String.format(TestBase.properties.getLogMessage("ClickOnDisableButton"), userName));
			if (successMsgText().equals(successMsg) && SeleniumUtils.isElementPresent(driver, ENABLE_BUTTON)) {
				Thread.sleep(1000);
				SeleniumUtils.Click(cancelButtonElement(),
						String.format(TestBase.properties.getLogMessage("ClickOnCancelButton"), userName));
				Thread.sleep(2000);
				if (getAttributeOfDisableUser(userName).equals(status)) {
					flag = true;
				}
			}
		}
		return flag;
	}

	public boolean verifyUpdateUserInformation(String userName, String updatedUserName, String lastName, String email)
			throws Exception {
		boolean flag = false;
		String expectedUserDetails;
		clickViewIconOfUser(userName);
		Thread.sleep(2000);
		firstNameTextBoxElement().clear();
		enterFirstName(updatedUserName);
		TestBase.logInfo(properties.getLogMessage("RemoveAndUpdateUserName"));
		SeleniumUtils.Click(modifyUserButtonElement(),
				String.format(TestBase.properties.getLogMessage("ClickOnModifyUserButton"), userName));
		expectedUserDetails = updatedUserName + " || " + lastName + " || " + email;
		if (getUsersList().contains(expectedUserDetails)) {
			flag = true;
		}
		return flag;
	}

	public boolean loginWithDisabledUser(String disabledEmailId, String password, String expectedErrorMSG,
			String homePageURL) throws Exception {
		boolean flag = false;
		UserFunctions userFunctions;
		userFunctions = new UserFunctions(driver);
		SeleniumUtils objSeleniumUtils = new SeleniumUtils();
		String actualErrorMSG = null;
		try {
			userFunctions.LogOut();
			if (userFunctions.enterDetailsAndLoginUsingDisabledUserCredentials(disabledEmailId, password,
					homePageURL)) {
				flag = false;
				TestBase.logError(
						String.format(TestBase.properties.getLogMessage("VerifyDisabledLoginErrorMessageFailed"),
								expectedErrorMSG, actualErrorMSG));
			} else {
				Thread.sleep(2000);
				actualErrorMSG = objSeleniumUtils.getTitleText(driver, DISABLED_USER_ERROR_MESSAGE);
				if (actualErrorMSG.equalsIgnoreCase(expectedErrorMSG)) {
					flag = true;
					TestBase.logInfo(
							String.format(TestBase.properties.getLogMessage("VerifyDisabledLoginErrorMessagePassed"),
									disabledEmailId, actualErrorMSG));
				}
			}
			Thread.sleep(1000);
			driver.navigate().refresh();
			Thread.sleep(1000);
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyDisabledLoginErrorMessageFailed"),
					disabledEmailId, actualErrorMSG));
			throw e;
		}
		return flag;
	}

	// This method will get a single user from the user list and perform disabled
	// operation
	@SuppressWarnings("unused")
	public boolean verifyDisabledUserFromUserList(String newlyCreatedEmailID, String expectedDisabledSuccessMSG)
			throws Exception {
		AMUserManagementPage objAMUserManagementPage;
		ArrayList<String> specificUserEmailValue = null, getUserEmailAddressValueFromUsersList;
		boolean flag = false;
		UserFunctions userFunctions;
		WebElement clickOnDisabledButton;
		SeleniumUtils objSeleniumUtils;
		String actualDisabledSuccessMSG = null;
		try {
			// objAMUserManagementLoginWithUpdatedUserPage = new
			// AMUserManagementLoginWithUpdatedUserPage(driver);
			objAMUserManagementPage = new AMUserManagementPage(driver);
			objSeleniumUtils = new SeleniumUtils();
			specificUserEmailValue = getUserFromUsersListToModifyuser(newlyCreatedEmailID);
			Thread.sleep(2000);
			if (SeleniumUtils.isElementPresent(driver, DISABLED_USER_BUTON)) {
				clickOnDisabledButton = SeleniumUtils.waitForElementClickable(driver, DISABLED_USER_BUTON, 30);
				clickOnDisabledButton.click();
				actualDisabledSuccessMSG = objSeleniumUtils.getTitleText(driver, ENABLED_DISABLED_USER_SUCCESS_MSG);
				if (actualDisabledSuccessMSG.equalsIgnoreCase(expectedDisabledSuccessMSG)) {
					flag = true;
					TestBase.logInfo(
							String.format(TestBase.properties.getLogMessage("VerifyDisabledSucessMessagePassed"),
									newlyCreatedEmailID, actualDisabledSuccessMSG.trim()));
				}
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyDisabledSucessMessageFailed"),
					newlyCreatedEmailID, actualDisabledSuccessMSG.trim()));
			throw e;
		}
		return flag;
	}

	// This will enabled the user which was in disabled mode
	@SuppressWarnings("unused")
	public boolean verifyEnabledUserFromUserList(String newlyCreatedEmailID, String expectedEnabledSuccessMSG)
			throws Exception {
		AMUserManagementPage objAMUserManagementPage;
		ArrayList<String> specificUserEmailValue = null, getUserEmailAddressValueFromUsersList;
		boolean flag = false;
		UserFunctions userFunctions;
		WebElement clickOnDisabledButton;
		SeleniumUtils objSeleniumUtils;
		String actualEnabledSuccessMSG = null;
		try {
			objAMUserManagementPage = new AMUserManagementPage(driver);
			objSeleniumUtils = new SeleniumUtils();
			specificUserEmailValue = getUserFromUsersListToModifyuser(newlyCreatedEmailID);
			Thread.sleep(2000);
			if (SeleniumUtils.isElementPresent(driver, ENABLED_USER_BUTTON)) {
				clickOnDisabledButton = SeleniumUtils.waitForElementClickable(driver, ENABLED_USER_BUTTON, 30);
				clickOnDisabledButton.click();
				actualEnabledSuccessMSG = objSeleniumUtils.getTitleText(driver, ENABLED_DISABLED_USER_SUCCESS_MSG);
				if (actualEnabledSuccessMSG.equalsIgnoreCase(expectedEnabledSuccessMSG)) {
					flag = true;
					TestBase.logInfo(
							String.format(TestBase.properties.getLogMessage("VerifyEnabledSucessMessagePassed"),
									newlyCreatedEmailID, actualEnabledSuccessMSG.trim()));
				}
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyEnabledSucessMessageFailed"),
					newlyCreatedEmailID, actualEnabledSuccessMSG.trim()));
			throw e;
		}
		return flag;
	}

	// This will check if new created user is modified successfully or not
	public boolean verifyLoginFunctionalityOfDisabledUser(String firstName, String lastName, String newlyCreatedEmail,
			String password, String expectedDisabledSuccessMSG, String expectedErrorMSG, String homePageURL)
			throws Exception {
		boolean flag = false;
		ArrayList<String> arraylist = null;
		try {
			if (createdNewUser(firstName, lastName, newlyCreatedEmail, password)) {
				if (verifyDisabledUserFromUserList(newlyCreatedEmail, expectedDisabledSuccessMSG)) {
					if (loginWithDisabledUser(newlyCreatedEmail, password, expectedErrorMSG, homePageURL)) {
						flag = true;
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	/***
	 * This will check the login functionality after enabling of disabled user
	 * 
	 * @param firstName
	 * @param lastName
	 * @param newlyCreatedEmail
	 * @param password
	 * @param expectedDisabledSuccessMSG
	 * @param expectedErrorMSG
	 * @param homePageURL
	 * @return
	 * @throws Exception
	 * @author dheeraj.singh
	 */
	public boolean verifyLoginFunctionalityOfEnablingDisabledUser(String firstName, String lastName,
			String newlyCreatedEmail, String password, String expectedDisabledSuccessMSG, String expectedErrorMSG,
			String homePageURL, String expectedEnabledSuccessMSG) throws Exception {
		boolean flag = false;
		ArrayList<String> arraylist = null;
		try {
			if (createdNewUser(firstName, lastName, newlyCreatedEmail, password)) {
				if (verifyDisabledUserFromUserList(newlyCreatedEmail, expectedDisabledSuccessMSG)) {
					if (loginWithDisabledUser(newlyCreatedEmail, password, expectedErrorMSG, homePageURL)) {
						if (verifyEnableOfDisabledUser(newlyCreatedEmail, expectedEnabledSuccessMSG, password,
								homePageURL)) {
							flag = true;
						}
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	/***
	 * 
	 * @param newlyCreatedEmailID
	 * @param expectedEnabledSuccessMSG
	 * @param password
	 * @param homePageURL
	 * @return
	 * @throws Exception
	 * @author dheeraj.singh
	 */
	public boolean verifyEnableOfDisabledUser(String newlyCreatedEmailID, String expectedEnabledSuccessMSG,
			String password, String homePageURL) throws Exception {
		boolean flag = false;
		UserFunctions userFunctions = new UserFunctions(driver);
		try {
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			Thread.sleep(2000);
			clickAssetManagerTab();
			clickUserManagementLink();
			if (verifyEnabledUserFromUserList(newlyCreatedEmailID, expectedEnabledSuccessMSG)) {
				if (loginWithEnablingDisabledUser(newlyCreatedEmailID, password, homePageURL)) {
					flag = true;
					TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyEnabledUserLoginPassed"),
							newlyCreatedEmailID));
				}
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyEnabledUserLoginFailed"),
					newlyCreatedEmailID));
			throw e;
		}
		return flag;
	}

	/***
	 * This will check the login functionality after enabling of disabled user
	 * 
	 * @author dheeraj.singh
	 * @return
	 * @throws Exception
	 */
	public boolean loginWithEnablingDisabledUser(String newlyCreatedEmailID, String password, String homePageURL)
			throws Exception {
		boolean flag = false;
		UserFunctions userFunctions;
		userFunctions = new UserFunctions(driver);
		try {
			userFunctions.LogOut();
			if (userFunctions.enterDetailsAndLoginUsingDisabledUserCredentials(newlyCreatedEmailID, password,
					homePageURL)) {
				Thread.sleep(1000);
				flag = true;
			}

		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	/*
	 * // This function will get an user and will click on search-icon plus button
	 * public ArrayList<String> getUserFromUsersList(String emailAddress) {
	 * ArrayList<String> singleUser = new ArrayList<String>();
	 * SeleniumUtils.waitForElementVisibility(driver, NEW_USER_BUTTON,
	 * WAIT_SECONDS); int countOfUserRows =
	 * SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_ROWS); int
	 * countOfUserColumns = SeleniumUtils.getCountOfWebElements(driver,
	 * LIST_OF_USER_COLUMNS); String specificUserEmailValue = ""; String columnText
	 * = ""; for (int i = 1; i <= countOfUserRows; i++) { for (int j = 5; j <=
	 * countOfUserColumns - 2; j++) { WebElement emailIdElement = driver
	 * .findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[" +
	 * j + "]")); columnText = emailIdElement.getText(); if
	 * (emailAddress.equals(columnText)) { WebElement specificUserEmail = driver
	 * .findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i +
	 * "]/td[1]/fa-icon")); specificUserEmailValue = driver
	 * .findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[" +
	 * j + "]")) .getText(); specificUserEmail.click(); break; } } }
	 * singleUser.add(specificUserEmailValue); return singleUser; }
	 */

	// This function will return the all user EmailAddress from the user-list
	public ArrayList<String> getUserEmailAddressFromUsersList() {
		ArrayList<String> allUserEmailAddress = new ArrayList<String>();
		SeleniumUtils.waitForElementVisibility(driver, NEW_USER_BUTTON, WAIT_SECONDS);
		int countOfUserRows = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_ROWS);
		int countOfUserColumns = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_COLUMNS);
		String specificUserEmailValue = "";
		String columnText = "";
		for (int i = 1; i <= countOfUserRows; i++) {
			for (int j = 5; j <= countOfUserColumns - 2; j++) {
				WebElement emailIdElement = driver
						.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[" + j + "]"));
				columnText = emailIdElement.getText();
			}
			allUserEmailAddress.add(columnText);
		}
		return allUserEmailAddress;
	}

	// This method will get a single user from the user list
	public boolean verifyModifyUserFromUserList(String newlyCreatedEmailID, String modifyCreatedEmailID)
			throws Exception {
		AMUserManagementPage objAMUserManagementPage;
		ArrayList<String> specificUserEmailValue = null, getUserEmailAddressValueFromUsersList;
		boolean flag = false;
		UserFunctions userFunctions;
		try {
			objAMUserManagementPage = new AMUserManagementPage(driver);
			specificUserEmailValue = getUserFromUsersListToModifyuser(newlyCreatedEmailID);
			Thread.sleep(2000);
			objAMUserManagementPage.enterEmail(modifyCreatedEmailID);
			Thread.sleep(2000);
			SeleniumUtils.actionScrollToBottom(driver);
			SeleniumUtils.clickElement(driver, MODIFY_USER_BUTTON);
			Thread.sleep(2000);
			getUserEmailAddressValueFromUsersList = getUserEmailAddressFromUsersList();
			Thread.sleep(3000);
			if (getUserEmailAddressValueFromUsersList.contains(modifyCreatedEmailID)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyUpdatedUserPassed"),
						newlyCreatedEmailID, modifyCreatedEmailID));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyUpdatedUserFailed"),
					newlyCreatedEmailID, modifyCreatedEmailID));
			throw e;
		}
		return flag;
	}

	// This functions will check the login functionality and modify the newly
	// created user
	public boolean createdNewUser(String firstName, String lastName, String email, String password) throws Exception {
		UserFunctions objUserFunctions;
		boolean flag = false;
		String fName = null;
		String lname = null;
		String userId = null;
		ArrayList<String> arraylist = null;
		try {
			objUserFunctions = new UserFunctions(driver);
			fName = firstName + GenericUtils.RandomString(3);
			lname = lastName + GenericUtils.RandomString(3);
			arraylist = new ArrayList<String>();
			arraylist.add(fName);
			arraylist.add(lname);
			arraylist.add(email);
			if (verifyNewCreatedUser(fName, lname, email, password)) {
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	/**
	 * This will login with modified user
	 * 
	 * @param login    with modified email ID and password
	 * @param Then     user land to home page
	 * @param Verified user login
	 * @return
	 * @throws Exception
	 * @author dheeraj.singh
	 */
	public boolean loginWithModifieduser(String modifiednewlyCreatedEmail, String password,
			String homePageURLFractionValue) throws Exception {
		boolean flag = false;
		UserFunctions userFunctions;
		userFunctions = new UserFunctions(driver);
		try {
			userFunctions.LogOut();
			Thread.sleep(2000);
			if (userFunctions.enterDetailsAndLoginUsingCredentials(modifiednewlyCreatedEmail, password)) {
				Thread.sleep(2000);
				if (driver.getCurrentUrl().endsWith(homePageURLFractionValue)) {
					flag = true;
					TestBase.logInfo(String.format(
							TestBase.properties.getLogMessage("VerifyLoginFunctionalityWithNewlyModifyUserPassed"),
							modifiednewlyCreatedEmail));
				}
			}
		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyLoginFunctionalityWithNewlyModifyUserFailed"),
					modifiednewlyCreatedEmail));
			throw e;
		}
		return flag;
	}

	// This will check if new created user is modified successfully or not
	public boolean verifyModifyNewlyCreatedUser(String firstName, String lastName, String newlyCreatedEmail,
			String modifiednewlyCreatedEmail, String password, String homePageURLFractionValue) throws Exception {
		boolean flag = false;
		ArrayList<String> arraylist = null;
		try {
			if (createdNewUser(firstName, lastName, newlyCreatedEmail, password)) {
				if (verifyModifyUserFromUserList(newlyCreatedEmail, modifiednewlyCreatedEmail)) {
					if (loginWithModifieduser(modifiednewlyCreatedEmail, password, homePageURLFractionValue)) {
						flag = true;
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	///////////////////////// Code added for Create and Login with
	///////////////////////// User////////////////////////////////////

	// This functions will created new User
	public boolean verifyNewCreatedUser(String firstName, String lastName, String email, String password)
			throws Exception {
		boolean flag = false;
		AMUserManagementPage objAMUserManagementPage;
		try {
			objAMUserManagementPage = new AMUserManagementPage(driver);
			flag = objAMUserManagementPage.verifyUserCreation(firstName, lastName, email, password);
			if (flag) {
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyNewCreatedUserPassed"),
						firstName, lastName, email));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyNewCreatedUserFailed"), firstName,
					lastName, email));
			throw e;
		}
		return flag;
	}

	// This functions will check the login functionality of created User
	public ArrayList<String> loginWithNewCreatedUser(String firstName, String lastName, String email, String password,
			String endURLFractionValue) throws Exception {
		UserFunctions objUserFunctions;
		String fName = null;
		String lname = null;
		String userId = null;
		ArrayList<String> arraylist = null;
		try {
			objUserFunctions = new UserFunctions(driver);
			fName = firstName + GenericUtils.RandomString(3);
			lname = lastName + GenericUtils.RandomString(3);
			// userId = GenericUtils.RandomString(4) + email.toLowerCase();
			arraylist = new ArrayList<String>();
			arraylist.add(fName);
			arraylist.add(lname);
			arraylist.add(email);
			if (verifyNewCreatedUser(fName, lname, email, password)) {
				objUserFunctions.LogOut();
				// String userIdInLowerCase = email.toLowerCase();
				objUserFunctions.enterDetailsAndLoginUsingCredentials(email, password);
			}
		} catch (Exception e) {
			throw e;
		}
		return arraylist;
	}

	// This will check if user is able to login with newly created user
	public boolean verifyIfLoggedInUsingNewlyCreatedUser(String firstName, String lastName, String email,
			String password, String endURLFractionValue) throws Exception {
		boolean flag = false;
		try {
			Thread.sleep(2000);
			if (driver.getCurrentUrl().endsWith(endURLFractionValue)) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyHomePageURLAfterCreatedUserLoginPassed"),
								endURLFractionValue));
			}
		} catch (Exception e) {
			TestBase.logInfo(
					String.format(TestBase.properties.getLogMessage("VerifyHomePageURLAfterCreatedUserLoginFailed"),
							endURLFractionValue));
			throw e;
		}

		return flag;
	}

	// This will check if new created user is able to login successfully or not
	public boolean verifyLoginFunctionalityWithNewlyCreatedUser(String firstName, String lastName, String email,
			String password, String endURLFractionValue) throws Exception {
		boolean flag = false;
		ArrayList<String> arraylist = null;
		try {
			arraylist = loginWithNewCreatedUser(firstName, lastName, email, password, endURLFractionValue);
			if (verifyIfLoggedInUsingNewlyCreatedUser(firstName, lastName, email, password, endURLFractionValue)) {
				flag = true;
				TestBase.logInfo(String.format(
						TestBase.properties.getLogMessage("VerifyLoginFunctionalityWithNewlyCreatedUserPassed"),
						arraylist));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyLoginFunctionalityWithNewlyCreatedUserFailed"),
					arraylist));
			throw e;
		}
		return flag;
	}

	// This function will get an user and will click on delete button
	public ArrayList<String> getUserFromUsersList(String emailAddress) {
		ArrayList<String> singleUser = new ArrayList<String>();
		SeleniumUtils.waitForElementVisibility(driver, NEW_USER_BUTTON, WAIT_SECONDS);
		int countOfUserRows = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_ROWS);
		int countOfUserColumns = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_COLUMNS);
		String specificUserEmailValue = "";
		String columnText = "";
		for (int i = 1; i <= countOfUserRows; i++) {
			for (int j = 5; j <= countOfUserColumns - 2; j++) {
				WebElement emailIdElement = driver
						.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[" + j + "]"));
				columnText = emailIdElement.getText();
				if (emailAddress.equals(columnText)) {
					WebElement specificUserEmail = driver
							.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[2]/fa-icon"));
					specificUserEmailValue = driver
							.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[" + j + "]"))
							.getText();
					specificUserEmail.click();
					break;
				}
			}
		}
		singleUser.add(specificUserEmailValue);
		return singleUser;
	}

	// This function will get an user and will click on delete button
	public ArrayList<String> getUserFromUsersListToModifyuser(String emailAddress) {
		ArrayList<String> singleUser = new ArrayList<String>();
		SeleniumUtils.waitForElementVisibility(driver, NEW_USER_BUTTON, WAIT_SECONDS);
		int countOfUserRows = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_ROWS);
		int countOfUserColumns = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_COLUMNS);
		String specificUserEmailValue = "";
		String columnText = "";
		for (int i = 1; i <= countOfUserRows; i++) {
			for (int j = 5; j <= countOfUserColumns - 2; j++) {
				WebElement emailIdElement = driver
						.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[" + j + "]"));
				columnText = emailIdElement.getText();
				if (emailAddress.equals(columnText)) {
					WebElement specificUserEmail = driver
							.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[1]/fa-icon"));
					specificUserEmailValue = driver
							.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[" + j + "]"))
							.getText();
					specificUserEmail.click();
					break;
				}
			}
		}
		singleUser.add(specificUserEmailValue);
		return singleUser;
	}

	// This function will check if deleted user is present in the users list
	public boolean checkIfDeletedUserFromUsersList(String emailAddress) throws InterruptedException {
		boolean flag = true;
		SeleniumUtils.waitForElementVisibility(driver, NEW_USER_BUTTON, WAIT_SECONDS);
		int countOfUserRows = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_ROWS);
		int countOfUserColumns = SeleniumUtils.getCountOfWebElements(driver, LIST_OF_USER_COLUMNS);
		String columnText = "";
		for (int i = 1; i <= countOfUserRows; i++) {
			for (int j = 5; j <= countOfUserColumns - 2; j++) {
				WebElement emailIdElement = driver
						.findElement(By.xpath("//tbody[@class='ui-table-tbody']//tr[" + i + "]/td[" + j + "]"));
				columnText = emailIdElement.getText();
				Thread.sleep(1000);
				if (emailAddress.equals(columnText)) {
					flag = false;
				}
			}
		}
		return flag;
	}

	// This will check if confirmation window is present or not(if yes then, it will
	// perform on click operation )
	public boolean confirmationWindow() throws Exception {
		boolean flag = false;
		try {
			if (SeleniumUtils.isElementPresent(driver, CONFIRMATION_WINDOW)) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyConfirmationWindowPresentPassed")));
			}

		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyConfirmationWindowPresentFailed")));
			throw e;
		}
		return flag;
	}

	// This method will get a single user from the user list and perform disabled
	// operation
	@SuppressWarnings("unused")
	public boolean verifyDeletedUserFromUserList(String newlyCreatedEmailID) throws Exception {
		AMUserManagementPage objAMUserManagementPage;
		ArrayList<String> specificUserEmailValue = null, getUserEmailAddressValueFromUsersList;
		boolean flag = false;
		UserFunctions userFunctions;
		WebElement clickOnDeletedButton;
		SeleniumUtils objSeleniumUtils;
		String actualDisabledSuccessMSG = null;
		try {

			objAMUserManagementPage = new AMUserManagementPage(driver);
			objSeleniumUtils = new SeleniumUtils();
			getUserFromUsersList(newlyCreatedEmailID);
			Thread.sleep(2000);
			if (confirmationWindow()) {
				clickOnDeletedButton = SeleniumUtils.waitForElementClickable(driver, YES_BUTTON, 30);
				SeleniumUtils.waitAndClick(driver, clickOnDeletedButton, 5);
				Thread.sleep(3000);
			}
			if (checkIfDeletedUserFromUsersList(newlyCreatedEmailID)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyDeletedUserFromUserListPassed"),
						newlyCreatedEmailID));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyDeletedUserFromUserListFailed"),
					newlyCreatedEmailID));
			throw e;
		}
		return flag;
	}

	/***
	 * This will check whether deleted customer is able to login or not
	 * 
	 * @param deletedEmailId
	 * @param password
	 * @param expectedErrorMSG
	 * @param homePageURL
	 * @return
	 * @throws Exception
	 */
	public boolean loginWithDeletedUser(String deletedEmailId, String password, String expectedErrorMSG,
			String homePageURL) throws Exception {
		boolean flag = false;
		UserFunctions userFunctions;
		userFunctions = new UserFunctions(driver);
		SeleniumUtils objSeleniumUtils;
		String actualErrorMSG = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			userFunctions.LogOut();
			if (userFunctions.enterDetailsAndLoginUsingDisabledUserCredentials(deletedEmailId, password, homePageURL)) {
				flag = false;
				TestBase.logError(
						String.format(TestBase.properties.getLogMessage("VerifyDeletedLoginErrorMessageFailed"),
								expectedErrorMSG, actualErrorMSG));
			} else {
				Thread.sleep(2000);
				actualErrorMSG = objSeleniumUtils.getTitleText(driver, DELETED_USER_ERROR_MESSAGE);
				if (actualErrorMSG.equalsIgnoreCase(expectedErrorMSG)) {
					flag = true;
					TestBase.logInfo(
							String.format(TestBase.properties.getLogMessage("VerifyDeletedLoginErrorMessagePassed"),
									deletedEmailId, actualErrorMSG));
				}
			}
			Thread.sleep(1000);
			driver.navigate().refresh();
			Thread.sleep(1000);
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyDeletedLoginErrorMessageFailed"),
					deletedEmailId, actualErrorMSG));
			throw e;
		}
		return flag;
	}

	/***
	 * This will check if new created user is modified successfully or not
	 * 
	 * @param firstName
	 * @param lastName
	 * @param newlyCreatedEmail
	 * @param password
	 * @param homePageURL
	 * @param expectedErrorMSG
	 * @return
	 * @throws Exception
	 */
	public boolean verifyLoginFunctionalityOfDeletedUser(String firstName, String lastName, String newlyCreatedEmail,
			String password, String homePageURL, String expectedErrorMSG) throws Exception {
		boolean flag = false;
		try {
			if (createdNewUser(firstName, lastName, newlyCreatedEmail, password)) {
				if (verifyDeletedUserFromUserList(newlyCreatedEmail)) {
					if (loginWithDeletedUser(newlyCreatedEmail, password, expectedErrorMSG, homePageURL)) {
						flag = true;
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}
}
