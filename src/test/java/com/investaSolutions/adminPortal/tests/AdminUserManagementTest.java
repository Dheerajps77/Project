package com.investaSolutions.adminPortal.tests;

import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.adminPortal.pages.AdminUserManagementPage;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class AdminUserManagementTest extends TestBase{

HashMap<String, String> testData;
	
	@Test(groups = {"regression", "smoke", "admin"}, priority=1)
	// TC This test verifies the details present on the Admin Portal's User Management page
	public void verifyAdminUserManagementPageDetailsTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("ADMINPORTAL_DATA_SHEETNAME"), "TC_5");
			String adminUserManagementTitle = testData.get("ADMIN_USER_MANAGEMENT_TITLE");			
			String viewColumnText = testData.get("VIEW_COLUMN");
			String deleteColumnText = testData.get("DELETE_COLUMN");
			String firstNameColumnText = testData.get("FIRSTNAME_COLUMN");
			String lastNameColumnText = testData.get("LASTNAME_COLUMN");
			String emailColumnText = testData.get("EMAIL_COLUMN");
			String enabledColumnText = testData.get("ENABLED_COLUMN");
			String lockedColumnText = testData.get("LOCKED_COLUMN");
			String backButtonText = testData.get("BACK_BUTTON");
			String newUserButtonText = testData.get("NEW_USER_BUTTON");
			
			startTest(properties.getLogMessage("VerifyAdminUserManagementPageDetailsTest"), properties.getLogMessage("VerifyAdminUserManagementPageDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyAdminUserManagementPageDetails"));
			
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("Admin"), properties.getConstant("Admin_User1"));	

			AdminUserManagementPage adminUserManagementPage = new AdminUserManagementPage(driver);			
			Assert.assertTrue(adminUserManagementPage.verifyAssetUserManagementPageDetails(adminUserManagementTitle, viewColumnText, deleteColumnText, firstNameColumnText, lastNameColumnText, emailColumnText, enabledColumnText, lockedColumnText, backButtonText, newUserButtonText), String.format(properties.getLogMessage("AdminUserManagementPageDetailsVerificationFailed"), adminUserManagementTitle,  viewColumnText,  deleteColumnText,  firstNameColumnText,  lastNameColumnText,  emailColumnText,  enabledColumnText,  lockedColumnText,  backButtonText,  newUserButtonText));
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
