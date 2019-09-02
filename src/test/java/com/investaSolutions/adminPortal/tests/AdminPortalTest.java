package com.investaSolutions.adminPortal.tests;

import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.adminPortal.pages.AdminPortalPage;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class AdminPortalTest extends TestBase{

HashMap<String, String> testData;
	
	@Test(groups = {"regression", "smoke", "admin"}, priority=1)
	// TC This test verifies the details present on the Admin Portal's home page
	public void verifyBankPortalDetailsTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("ADMINPORTAL_DATA_SHEETNAME"), "TC_1");
			String dashboardTab = testData.get("DASHBOARD");
			String instrumentManagementTab = testData.get("INSTRUMENTMANAGEMENT");
			String pModelsTab = testData.get("PMODELS");
			String bankManagementTab = testData.get("BANKMANAGEMENT");
			String assetManagerManagementTab = testData.get("ASSETMANAGERMANAGEMENT");
			String softwareVendorsTab = testData.get("SOFTWAREVENDORS");
			String userManagementTab = testData.get("USERMANAGEMENT");
			String disconnectTab = testData.get("DISCONNECT");	
			
			startTest(properties.getLogMessage("VerifyAdminPortalDetailsTest"), properties.getLogMessage("VerifyAdminPortalDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyAdminPortalDetails"));
			
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("Admin"), properties.getConstant("Admin_User1"));	

			AdminPortalPage adminPortalPage = new AdminPortalPage(driver);			
			Assert.assertTrue(adminPortalPage.verifyAdminPortalPageDetails(dashboardTab, instrumentManagementTab, pModelsTab, bankManagementTab, assetManagerManagementTab, softwareVendorsTab, userManagementTab, disconnectTab), String.format(properties.getLogMessage("AdminPortalPageDetailsVerificationFailed"), dashboardTab, instrumentManagementTab, pModelsTab, bankManagementTab, assetManagerManagementTab, softwareVendorsTab, userManagementTab, disconnectTab));
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
