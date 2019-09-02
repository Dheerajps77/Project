package com.investaSolutions.adminPortal.tests;

import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.adminPortal.pages.AdminSoftwareVendorsPage;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class AdminSoftwareVendorsTest extends TestBase{

	HashMap<String, String> testData;

	@Test(groups = {"regression", "smoke", "admin"}, priority=1)
	// TC This test verifies the details present on the Admin Portal's Software Vendors page
	public void verifySoftwareVendorsPageDetailsTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("ADMINPORTAL_DATA_SHEETNAME"), "TC_4");
			String softwareVendorsTitle = testData.get("SOFTWARE_VENDORS_TITLE");
			String dColumnText = testData.get("D");
			String nameColumnText = testData.get("NAME");
			String addressColumnText = testData.get("ADDRESS");
			String contactColumnText = testData.get("CONTACT");
			String lastUpdateDateColumnText = testData.get("LAST_UPDATE_DATE");
			String backButtonText = testData.get("BACK_BUTTON");
			String newSoftwareVendorButtonText = testData.get("NEW_SOFTWARE_VENDOR");	

			startTest(properties.getLogMessage("VerifyAdminSoftwareVendorsPageDetailsTest"), properties.getLogMessage("VerifyAdminSoftwareVendorsPageDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyAdminSoftwareVendorsPageDetails"));

			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("Admin"), properties.getConstant("Admin_User1"));	

			AdminSoftwareVendorsPage adminSoftwareVendorsPage = new AdminSoftwareVendorsPage(driver);			
			Assert.assertTrue(adminSoftwareVendorsPage.verifySoftwareVendorsPageDetails(softwareVendorsTitle, dColumnText, nameColumnText, addressColumnText, contactColumnText, lastUpdateDateColumnText, backButtonText, newSoftwareVendorButtonText), String.format(properties.getLogMessage("AdminSoftwareVendorsPageDetailsVerificationFailed"), softwareVendorsTitle, dColumnText, nameColumnText, addressColumnText, contactColumnText, lastUpdateDateColumnText, backButtonText, newSoftwareVendorButtonText));
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
