package com.investaSolutions.assetManagerPortal.tests;

import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.assetManagerPortal.pages.AMUserManagementPage;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.GenericUtils;
import com.investaSolutions.utils.UserFunctions;

public class AMAssetManagerTest extends TestBase {

	HashMap<String, String> testData;

	// @Test(groups = {"regression", "smoke"}, priority=2)
	// TC_4 This test verifies the details present on the User Management page
	public void verifyUserManagementDetailsTest() throws Throwable {
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME"), "TC_4");
			String userManagementLabelText = testData.get("LABEL");
			String searchHeaderText = testData.get("SEARCH");
			String deleteHeaderText = testData.get("DELETE");
			String firstNameHeaderText = testData.get("FIRSTNAME");
			String lastNameHeaderText = testData.get("LASTNAME");
			String emailHeaderText = testData.get("EMAIL");
			String enabledHeaderText = testData.get("ENABLED");
			String lockedHeaderText = testData.get("LOCKED");
			String newUserButtonText = testData.get("NEWUSERBUTTON");
			String backButtonText = testData.get("BACKBUTTON");
			startTest(properties.getLogMessage("VerifyUserManagementDetailsTest"),
					properties.getLogMessage("VerifyUserManagementDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyUserManagementDetails"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			AMUserManagementPage userManagementPage = new AMUserManagementPage(driver);
			Assert.assertTrue(
					userManagementPage.verifyUserManagementPageDetails(userManagementLabelText, searchHeaderText,
							deleteHeaderText, firstNameHeaderText, lastNameHeaderText, emailHeaderText,
							enabledHeaderText, lockedHeaderText, newUserButtonText, backButtonText),
					String.format(properties.getLogMessage("UserManagementDetailsVerificationFailed"),
							userManagementLabelText, searchHeaderText, deleteHeaderText, firstNameHeaderText,
							lastNameHeaderText, emailHeaderText, enabledHeaderText, lockedHeaderText, newUserButtonText,
							backButtonText));
			logInfo(String.format(properties.getLogMessage("UserManagementDetailsVerificationPassed"),
					userManagementLabelText, searchHeaderText, deleteHeaderText, firstNameHeaderText,
					lastNameHeaderText, emailHeaderText, enabledHeaderText, lockedHeaderText, newUserButtonText,
					backButtonText));
		} catch (NoSuchElementException e) {
			logError(properties.getLogMessage("NoSuchElementMessage"));
			e.printStackTrace();
			throw e;
		} catch (TimeoutException e) {
			logError(properties.getLogMessage("TimeoutMessage"));
			e.printStackTrace();
			throw e;
		} catch (Throwable e) {
			logError(properties.getLogMessage("ExceptionMessage"));
			e.printStackTrace();
			throw e;
		}
	}

	// @Test(groups = {"regression", "smoke", "sanity"}, priority=2)
	// TC_2 This test creates a new User through Asset Manager -> User Management
	// Section
	public void createNewUserTest() throws Throwable {
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME"), "TC_2");
			String firstName = testData.get("FIRSTNAME");
			String lastName = testData.get("LASTNAME");
			String email = testData.get("EMAIL");
			String password = testData.get("PASSWORD");
			startTest(properties.getLogMessage("CreateNewUserTest"), properties.getLogMessage("CreateNewUserDetail"));
			setTestCategory(properties.getLogMessage("CategoryCreateNewUser"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			AMUserManagementPage userManagementPage = new AMUserManagementPage(driver);
			Assert.assertTrue(userManagementPage.verifyUserCreation(firstName, lastName, email, password),
					String.format(properties.getLogMessage("UserCreationFailed"), firstName));
			logInfo(String.format(properties.getLogMessage("UserCreationPassed"), firstName));
		} catch (NoSuchElementException e) {
			logError(properties.getLogMessage("NoSuchElementMessage"));
			e.printStackTrace();
			throw e;
		} catch (TimeoutException e) {
			logError(properties.getLogMessage("TimeoutMessage"));
			e.printStackTrace();
			throw e;
		} catch (Throwable e) {
			logError(properties.getLogMessage("ExceptionMessage"));
			e.printStackTrace();
			throw e;
		}
	}

	// @Test(priority=3)
	// TC_3 This test creates a new User and check status.
	public void disableCreatedUserTest() throws Throwable {
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("USERMANAGEMENT_SHEETNAME"), "TC_3");
			String firstName = testData.get("FIRSTNAME") + " " + GenericUtils.RandomString(3);
			String lastName = testData.get("LASTNAME");
			String email = testData.get("EMAIL");
			String password = testData.get("PASSWORD");
			String successMsg = testData.get("DISABLESUCCESS_MSG");
			String userDisableStatus = testData.get("USER_DISABLE_STATUS");
			startTest(properties.getLogMessage("VerifyDisableUserTest"), properties.getLogMessage("VerifyDisableUser"));
			setTestCategory(properties.getLogMessage("CategoryVerifyDisableUser"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			AMUserManagementPage userManagementPage = new AMUserManagementPage(driver);
			Assert.assertTrue(userManagementPage.verifyUserCreation(firstName, lastName, email, password),
					String.format(properties.getLogMessage("UserCreationFailed"), firstName));
			logInfo(String.format(properties.getLogMessage("UserCreationPassed"), firstName));
			Assert.assertTrue(userManagementPage.verifyDisableUser(firstName, successMsg, userDisableStatus),
					String.format(properties.getLogMessage("UserDisabledFailed"), firstName));
			logInfo(String.format(properties.getLogMessage("UserDisableTestPass"), firstName));
		} catch (NoSuchElementException e) {
			logError(properties.getLogMessage("NoSuchElementMessage"));
			e.printStackTrace();
			throw e;
		} catch (TimeoutException e) {
			logError(properties.getLogMessage("TimeoutMessage"));
			e.printStackTrace();
			throw e;
		} catch (Throwable e) {
			logError(properties.getLogMessage("ExceptionMessage"));
			e.printStackTrace();
			throw e;
		}
	}

	// @Test(priority=4)
	// TC_4 This test verify creates a new User and modify information.
	public void updateCreatedUserTest() throws Throwable {
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("USERMANAGEMENT_SHEETNAME"), "TC_4");
			String firstName = testData.get("FIRSTNAME") + " " + GenericUtils.RandomString(3);
			String lastName = testData.get("LASTNAME");
			String email = testData.get("EMAIL");
			String password = testData.get("PASSWORD");
			startTest(properties.getLogMessage("VerifyUpdateUserTest"), properties.getLogMessage("VerifyUpdateUser"));
			setTestCategory(properties.getLogMessage("CategoryVerifyUpdateUser"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			AMUserManagementPage userManagementPage = new AMUserManagementPage(driver);
			Assert.assertTrue(userManagementPage.verifyUserCreation(firstName, lastName, email, password),
					String.format(properties.getLogMessage("UserCreationFailed"), firstName));
			logInfo(String.format(properties.getLogMessage("UserCreationPassed"), firstName));
			String updateFirstName = firstName + GenericUtils.RandomString(2);
			Assert.assertTrue(
					userManagementPage.verifyUpdateUserInformation(firstName, updateFirstName, lastName, email),
					String.format(properties.getLogMessage("UserModifyTestFailed"), firstName));
			logInfo(String.format(properties.getLogMessage("UserModifyTestPass"), firstName));
		} catch (NoSuchElementException e) {
			logError(properties.getLogMessage("NoSuchElementMessage"));
			e.printStackTrace();
			throw e;
		} catch (TimeoutException e) {
			logError(properties.getLogMessage("TimeoutMessage"));
			e.printStackTrace();
			throw e;
		} catch (Throwable e) {
			logError(properties.getLogMessage("ExceptionMessage"));
			e.printStackTrace();
			throw e;
		}
	}

	// @Test(priority = 1)// This is working
	// TC_19 This test verifies the login functionality after created a new user
	public void verifyAMUserManagementLoginWithCreateUserTest() throws Throwable {
		boolean loginWithNewlyCreatedUserFlag;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME"), "TC_19");
			String firstName = testData.get("FIRSTNAME");
			String lastName = testData.get("LASTNAME");
			String emailId = testData.get("EMAIL");
			String password = testData.get("PASSWORD");
			String updatedEmail = GenericUtils.RandomString(4).toLowerCase() + emailId.toLowerCase();
			String homePageURLFractionValue = testData.get("HOMEPAGE_URL_FRACTION");
			startTest(properties.getLogMessage("LoginWithCreatedUser"),
					properties.getLogMessage("VerifyLoginWithCreatedUser"));
			setTestCategory(properties.getLogMessage("CategoryLoginWithCreatedUser"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			AMUserManagementPage amUserManagementPage = new AMUserManagementPage(driver);
			loginWithNewlyCreatedUserFlag = amUserManagementPage.verifyLoginFunctionalityWithNewlyCreatedUser(firstName,
					lastName, updatedEmail, password, homePageURLFractionValue);
			Assert.assertTrue(loginWithNewlyCreatedUserFlag,
					properties.getLogMessage("VerifyLoginWithNewlyCreatedUserTestFailed"));
		} catch (NoSuchElementException e) {
			logError(properties.getLogMessage("NoSuchElementMessage"));
			e.printStackTrace();
			throw e;
		} catch (TimeoutException e) {
			logError(properties.getLogMessage("TimeoutMessage"));
			e.printStackTrace();
			throw e;
		} catch (Throwable e) {
			logError(properties.getLogMessage("ExceptionMessage"));
			e.printStackTrace();
			throw e;
		}
	}

	@SuppressWarnings("unused")
	// @Test(priority = 2)
	// TC_20 This test verifies the login functionality after modified a new user
	public void verifyAMUserManagementLoginWithUpdatedUserTest() throws Throwable {
		AMUserManagementPage objAMUserManagementPage;
		boolean objAMUserManagementLoginWithUpdatedUserPageFlag;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME"), "TC_20");
			String firstName = testData.get("FIRSTNAME");
			String lastName = testData.get("LASTNAME");
			String emailId = testData.get("EMAIL");
			String password = testData.get("PASSWORD");
			String email = testData.get("EMAILID");
			String homePageURLFractionValue = testData.get("HOMEPAGE_URL_FRACTION");
			String newlyCreatedEmail = GenericUtils.RandomString(4).toLowerCase() + emailId.toLowerCase();
			String updatedModifiedEmail = GenericUtils.RandomString(3).toLowerCase() + email.toLowerCase();
			startTest(properties.getLogMessage("LoginWithUpdatedUser"),
					properties.getLogMessage("VerifyLoginWithUpdatedUser"));
			setTestCategory(properties.getLogMessage("CategoryLoginWithUpdatedUser"));
			UserFunctions userFunctions = new UserFunctions(driver);
			AMUserManagementPage amUserManagementPage = new AMUserManagementPage(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			objAMUserManagementLoginWithUpdatedUserPageFlag = amUserManagementPage.verifyModifyNewlyCreatedUser(
					firstName, lastName, newlyCreatedEmail, updatedModifiedEmail, password, homePageURLFractionValue);
			Assert.assertTrue(objAMUserManagementLoginWithUpdatedUserPageFlag,
					properties.getLogMessage("VerifyLoginWithModifyUserTestFailed"));

		} catch (NoSuchElementException e) {
			logError(properties.getLogMessage("NoSuchElementMessage"));
			e.printStackTrace();
			throw e;
		} catch (TimeoutException e) {
			logError(properties.getLogMessage("TimeoutMessage"));
			e.printStackTrace();
			throw e;
		} catch (Throwable e) {
			logError(properties.getLogMessage("ExceptionMessage"));
			e.printStackTrace();
			throw e;
		}
	}

	// @Test(priority = 3)
	// TC_21 // TC_4 This test verifies the login functionality after disabled a new
	// user
	public void verifyAMUserManagementLoginWithDisabledUserTest() throws Throwable {

		AMUserManagementPage amUserManagementPage = new AMUserManagementPage(driver);
		boolean loginWithDisabledUserFlag;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME"), "TC_21");
			String firstName = testData.get("FIRSTNAME");
			String lastName = testData.get("LASTNAME");
			String emailId = testData.get("EMAIL");
			String password = testData.get("PASSWORD");
			String disabledSuccessMSG = testData.get("DISABLED_SUCCESS_MSG");
			String disabledErrorMSG = testData.get("DISABLED_USER_LOGIN_ERROR_MSG");
			String homePageURL = testData.get("HOME_PAGE_URL");
			String newlyCreatedEmail = GenericUtils.RandomString(4).toLowerCase() + emailId.toLowerCase();
			startTest(properties.getLogMessage("LoginWithdisabledUser"),
					properties.getLogMessage("VerifyLoginWithdisabledUser"));
			setTestCategory(properties.getLogMessage("CategoryLoginWithdisabledUser"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			loginWithDisabledUserFlag = amUserManagementPage.verifyLoginFunctionalityOfDisabledUser(firstName, lastName,
					newlyCreatedEmail, password, disabledSuccessMSG, disabledErrorMSG, homePageURL);
			Assert.assertTrue(loginWithDisabledUserFlag,
					properties.getLogMessage("VerifyLoginWithdisabledUserTestFailed"));
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
		} catch (NoSuchElementException e) {
			logError(properties.getLogMessage("NoSuchElementMessage"));
			e.printStackTrace();
			throw e;
		} catch (TimeoutException e) {
			logError(properties.getLogMessage("TimeoutMessage"));
			e.printStackTrace();
			throw e;
		} catch (Throwable e) {
			logError(properties.getLogMessage("ExceptionMessage"));
			e.printStackTrace();
			throw e;
		}
	}

	// @Test(priority = 4)
	// TC_22 // TC_4 This test verifies the login functionality after deleted a new
	// user
	public void verifyAMUserManagementLoginWithDeletedUserTest() throws Throwable {
		boolean loginWithDeletedUserFlag;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME"), "TC_22");
			String firstName = testData.get("FIRSTNAME");
			String lastName = testData.get("LASTNAME");
			String emailId = testData.get("EMAIL");
			String password = testData.get("PASSWORD");
			String deletedErrorMSG = testData.get("DELETED_USER_LOGIN_ERROR_MSG");
			String homePageURL = testData.get("HOME_PAGE_URL");
			String newlyCreatedEmail = GenericUtils.RandomString(4).toLowerCase() + emailId.toLowerCase();
			startTest(properties.getLogMessage("LoginWithDeletedUser"),
					properties.getLogMessage("VerifyLoginWithDeletedUser"));
			setTestCategory(properties.getLogMessage("CategoryLoginWithDeletedUser"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			AMUserManagementPage amUserManagementPage = new AMUserManagementPage(driver);
			loginWithDeletedUserFlag = amUserManagementPage.verifyLoginFunctionalityOfDeletedUser(firstName, lastName,
					newlyCreatedEmail, password, homePageURL, deletedErrorMSG);
			Assert.assertTrue(loginWithDeletedUserFlag,
					properties.getLogMessage("VerifyLoginWithDeletedUserTestFailed"));
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
		} catch (NoSuchElementException e) {
			logError(properties.getLogMessage("NoSuchElementMessage"));
			e.printStackTrace();
			throw e;
		} catch (TimeoutException e) {
			logError(properties.getLogMessage("TimeoutMessage"));
			e.printStackTrace();
			throw e;
		} catch (Throwable e) {
			logError(properties.getLogMessage("ExceptionMessage"));
			e.printStackTrace();
			throw e;
		}
	}

	// @Test(priority = 5)
	// TC_23 This test verifies the login enabling disabled user test
	// user
	public void verifyAMUserManagementLoginEnablingDisabledUserTest() throws Throwable {
		AMUserManagementPage amUserManagementPage = new AMUserManagementPage(driver);
		boolean loginWithDisabledUserFlag;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME"), "TC_23");
			String firstName = testData.get("FIRSTNAME");
			String lastName = testData.get("LASTNAME");
			String emailId = testData.get("EMAIL");
			String password = testData.get("PASSWORD");
			String disabledSuccessMSG = testData.get("DISABLED_SUCCESS_MSG");
			String enabledSuccessMSG = testData.get("ENABLED_SUCCESS_MSG");
			String disabledErrorMSG = testData.get("DISABLED_USER_LOGIN_ERROR_MSG");
			String homePageURL = testData.get("HOME_PAGE_URL");
			String newlyCreatedEmail = GenericUtils.RandomString(4).toLowerCase() + emailId.toLowerCase();
			startTest(properties.getLogMessage("LoginWithEnablingDisabledUser"),
					properties.getLogMessage("VerifyLoginWithEnablingDisabledUser"));
			setTestCategory(properties.getLogMessage("CategoryLoginWithEnablingDisabledUser"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			loginWithDisabledUserFlag = amUserManagementPage.verifyLoginFunctionalityOfEnablingDisabledUser(firstName,
					lastName, newlyCreatedEmail, password, disabledSuccessMSG, disabledErrorMSG, homePageURL,
					enabledSuccessMSG);
			Assert.assertTrue(loginWithDisabledUserFlag,
					properties.getLogMessage("VerifyLoginWithdisabledUserTestFailed"));
		} catch (NoSuchElementException e) {
			logError(properties.getLogMessage("NoSuchElementMessage"));
			e.printStackTrace();
			throw e;
		} catch (TimeoutException e) {
			logError(properties.getLogMessage("TimeoutMessage"));
			e.printStackTrace();
			throw e;
		} catch (Throwable e) {
			logError(properties.getLogMessage("ExceptionMessage"));
			e.printStackTrace();
			throw e;
		}
	}

	@Test(priority = 5)
	// TC_24 This test verifies the login enabling disabled user test
	// user
	public void verifyDeleteAllUserFromUserList() throws Throwable {
		boolean deletedAllUserFlag;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME"), "TC_24");
			String emailId = testData.get("EMAIL");
			startTest(properties.getLogMessage("LoginWithEnablingDisabledUser"),
					properties.getLogMessage("VerifyLoginWithEnablingDisabledUser"));
			setTestCategory(properties.getLogMessage("CategoryLoginWithEnablingDisabledUser"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			AMUserManagementPage amUserManagementPage = new AMUserManagementPage(driver);
			deletedAllUserFlag = amUserManagementPage.verifyAlldeletedUsers(emailId);
			Assert.assertTrue(deletedAllUserFlag, properties.getLogMessage("VerifyAllDeletedUserTestFailed"));

		} catch (NoSuchElementException e) {
			logError(properties.getLogMessage("NoSuchElementMessage"));
			e.printStackTrace();
			throw e;
		} catch (TimeoutException e) {
			logError(properties.getLogMessage("TimeoutMessage"));
			e.printStackTrace();
			throw e;
		} catch (Throwable e) {
			logError(properties.getLogMessage("ExceptionMessage"));
			e.printStackTrace();
			throw e;
		}
	}

}
