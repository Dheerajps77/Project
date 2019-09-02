package com.investaSolutions.bankPortal.tests;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.assetManagerPortal.pages.AMUserManagementPage;
import com.investaSolutions.bankPortal.pages.BankUserManagementPage;
import com.investaSolutions.bankPortal.pages.BankUsersPage;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class BankUsersTest  extends TestBase{

	HashMap<String, String> testData;
	
	//@Test(priority = 1)
	public void verifyBankPortalUsersPageDetailsTest(Method method) throws Throwable {
		BankUsersPage objBankManagerUserPage;
		String userTabTitleText;
		String fractionURLValue;
		String exepctedURL;
		String userManagementTitle_Text;
		String e_Text;
		String d_Text;
		String firstName_Text;
		String lastName_Text;
		String email_Text;
		String e2_Text;
		String l_Text;
		String backButtonText;
		String newUserButtonText;

		boolean flagVerifyUserPageDetails;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("BANKPORTAL_DATA_SHEETNAME"), "TC_2");
			userTabTitleText = testData.get("USER_TAB_TITLE");
			fractionURLValue = testData.get("URL_FRACTION_VALUE");
			exepctedURL = testData.get("URL");
			userManagementTitle_Text = testData.get("USERMANAGEMENT_TITLE");
			e_Text = testData.get("E_COLUMNNAME");
			d_Text = testData.get("D_COLUMNNAME");
			firstName_Text = testData.get("FIRSTNAME_COLUMNNAME");
			lastName_Text = testData.get("LASTNAME_COLUMNNAME");
			email_Text = testData.get("EMAIL_COULMNNAME");
			e2_Text = testData.get("E_COLUMNNAME");
			l_Text = testData.get("L_COLUMNNAME");
			backButtonText = testData.get("BACKBUTTON_TEXT");
			newUserButtonText = testData.get("NEWUSERBUTTON_TEXT");

			startTest(properties.getLogMessage("UserManagementList"),
					properties.getLogMessage("VerifyUserTabAndUserPageDetail"));
			setTestCategory(properties.getLogMessage("CategoryUserPageDetailsOnUserPage"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("Bank"), properties.getConstant("Bank_User1"));
			objBankManagerUserPage = new BankUsersPage(driver);

			flagVerifyUserPageDetails = objBankManagerUserPage.verifyUserListPageDetails(userTabTitleText,
					fractionURLValue, exepctedURL, userManagementTitle_Text, e_Text, d_Text, firstName_Text,
					lastName_Text, email_Text, e2_Text, l_Text, backButtonText, newUserButtonText);
			Assert.assertTrue(flagVerifyUserPageDetails, properties.getLogMessage("VerifyUserOnUserListPageTestFailed"));
		} 
		catch (NoSuchElementException e) {
			logError(properties.getLogMessage("NoSuchElementMessage"));
			e.printStackTrace();
			throw e;
		}
		catch (TimeoutException e) {
			logError(properties.getLogMessage("TimeoutMessage"));
			e.printStackTrace();
			throw e;
		}
		catch (Exception e) {
			logError(properties.getLogMessage("VerifyUserOnUserListPageTestFailed"));
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));
			throw e;
		}
		catch (Throwable e) {		
			logError(properties.getLogMessage("ExceptionMessage"));
			e.printStackTrace();
			throw e;
		}
	}

	//@Test(groups = {"regression", "smoke", "sanity", "bank"}, priority=2)
	// TC - This test creates a new Bank User through User Management page
	public void createNewBankUserTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("BANKPORTAL_DATA_SHEETNAME"), "TC_4");
			String firstName = testData.get("FIRSTNAME");
			String lastName = testData.get("LASTNAME");
			String email = testData.get("EMAIL");
			String password = testData.get("PASSWORD");
			
			startTest(properties.getLogMessage("CreateNewBankUserTest"), properties.getLogMessage("CreateNewBankUserDetail"));
			setTestCategory(properties.getLogMessage("CategoryCreateNewBankUser"));
			
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("Bank"), properties.getConstant("Bank_User1"));
			
			BankUserManagementPage bankUserManagementPage = new BankUserManagementPage(driver);
			Assert.assertTrue(bankUserManagementPage.verifyBankUserCreation(firstName, lastName, email, password), String.format(properties.getLogMessage("BankUserCreationFailed"), firstName));
			logInfo(String.format(properties.getLogMessage("BankUserCreationPassed"), firstName));
		}
		catch (NoSuchElementException e) {
			logError(properties.getLogMessage("NoSuchElementMessage"));
			e.printStackTrace();
			throw e;
		}
		catch (TimeoutException e) {
			logError(properties.getLogMessage("TimeoutMessage"));
			e.printStackTrace();
			throw e;
		}
		catch (Throwable e) {		
			logError(properties.getLogMessage("ExceptionMessage"));
			e.printStackTrace();
			throw e;
		}
	}
	
	//@Test(groups = {"regression", "smoke", "sanity", "bank"}, priority=1)
	// TC - This test creates a new Bank User through User Management page  
	public void createAndLoginUsingNewBankUserTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("BANKPORTAL_DATA_SHEETNAME"), "TC_5");
			String firstName = testData.get("FIRSTNAME");
			String lastName = testData.get("LASTNAME");
			String email = testData.get("EMAIL");
			String password = testData.get("PASSWORD");
			
			startTest(properties.getLogMessage("CreateAndLoginUsingNewBankUserTest"), properties.getLogMessage("CreateAndLoginUsingNewBankUserDetail"));
			setTestCategory(properties.getLogMessage("CategoryCreateAndLoginUsingNewBankUser"));			
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("Bank"), properties.getConstant("Bank_User1"));			
			BankUserManagementPage bankUserManagementPage = new BankUserManagementPage(driver);
			Assert.assertTrue(bankUserManagementPage.verifyBankUserCreation(firstName, lastName, email, password), String.format(properties.getLogMessage("BankUserCreationFailed"), firstName));
			logInfo(String.format(properties.getLogMessage("BankUserCreationPassed"), firstName));			
			userFunctions.LogOut();		
			Assert.assertTrue(userFunctions.enterDetailsAndLoginUsingCredentials(email, password), String.format(properties.getLogMessage("BankUserLoginFailed"), firstName));
			logInfo(String.format(properties.getLogMessage("BankUserLoginPassed"), firstName));
		}
		catch (NoSuchElementException e) {
			logError(properties.getLogMessage("NoSuchElementMessage"));
			e.printStackTrace();
			throw e;
		}
		catch (TimeoutException e) {
			logError(properties.getLogMessage("TimeoutMessage"));
			e.printStackTrace();
			throw e;
		}
		catch (Throwable e) {		
			logError(properties.getLogMessage("ExceptionMessage"));
			e.printStackTrace();
			throw e;
		}
	}
	
	@Test(groups = {"regression", "smoke", "sanity", "bank"}, priority=1)
	// TC - This test creates a new Bank user and deletes the Bank User through User Management page  
	public void deleteBankUserTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("BANKPORTAL_DATA_SHEETNAME"), "TC_6");
			String firstName = testData.get("FIRSTNAME");
			String lastName = testData.get("LASTNAME");
			String email = testData.get("EMAIL");
			String password = testData.get("PASSWORD");
			
			startTest(properties.getLogMessage("CreateAndDeleteNewBankUserTest"), properties.getLogMessage("CreateAndDeleteNewBankUserDetail"));
			setTestCategory(properties.getLogMessage("CategoryCreateAndDeleteNewBankUser"));			
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("Bank"), properties.getConstant("Bank_User1"));			
			BankUserManagementPage bankUserManagementPage = new BankUserManagementPage(driver);
			Assert.assertTrue(bankUserManagementPage.verifyBankUserCreation(firstName, lastName, email, password), String.format(properties.getLogMessage("BankUserCreationFailed"), firstName));
			logInfo(String.format(properties.getLogMessage("BankUserCreationPassed"), firstName));			
			
			Assert.assertFalse(bankUserManagementPage.verifyBankUserDeletedSuccessfully(email), String.format(properties.getLogMessage("BankUserDeletionFailed"), firstName));
			logInfo(String.format(properties.getLogMessage("BankUserDeletionPassed"), firstName));						
		}
		catch (NoSuchElementException e) {
			logError(properties.getLogMessage("NoSuchElementMessage"));
			e.printStackTrace();
			throw e;
		}
		catch (TimeoutException e) {
			logError(properties.getLogMessage("TimeoutMessage"));
			e.printStackTrace();
			throw e;
		}
		catch (Throwable e) {		
			logError(properties.getLogMessage("ExceptionMessage"));
			e.printStackTrace();
			throw e;
		}
	}
}
