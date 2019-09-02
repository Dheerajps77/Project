package com.investaSolutions.adminPortal.tests;

import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.adminPortal.pages.AdminBankManagementPage;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class AdminBankManagementTest extends TestBase{

HashMap<String, String> testData;
	
	@Test(groups = {"regression", "smoke", "admin"}, priority=1)
	// TC This test verifies the details present on the Admin Portal's Bank Management page
	public void verifyBankManagementPageDetailsTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("ADMINPORTAL_DATA_SHEETNAME"), "TC_2");
			String bankManagementTitle = testData.get("BANK_MANAGEMENT_TITLE");
			String dColumnText = testData.get("D");
			String nameColumnText = testData.get("NAME");
			String addressColumnText = testData.get("ADDRESS");
			String contactColumnText = testData.get("CONTACT");
			String lastUpdateDateColumnText = testData.get("LAST_UPDATE_DATE");
			String backButtonText = testData.get("BACK_BUTTON");
			String newBankButtonText = testData.get("NEW_BANK_BUTTON");	
			
			startTest(properties.getLogMessage("VerifyAdminBankManagementPageDetailsTest"), properties.getLogMessage("VerifyAdminBankManagementPageDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyAdminBankManagementPageDetails"));
			
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("Admin"), properties.getConstant("Admin_User1"));	

			AdminBankManagementPage adminBankManagementPage = new AdminBankManagementPage(driver);			
			Assert.assertTrue(adminBankManagementPage.verifyBankManagementPageDetails(bankManagementTitle, dColumnText, nameColumnText, addressColumnText, contactColumnText, lastUpdateDateColumnText, backButtonText, newBankButtonText), String.format(properties.getLogMessage("AdminBankManagementPageDetailsVerificationFailed"), bankManagementTitle, dColumnText, nameColumnText, addressColumnText, contactColumnText, lastUpdateDateColumnText, backButtonText, newBankButtonText));
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
