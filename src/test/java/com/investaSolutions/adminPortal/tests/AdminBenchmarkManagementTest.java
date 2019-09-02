package com.investaSolutions.adminPortal.tests;

import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.adminPortal.pages.AdminBenchmarkManagementPage;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class AdminBenchmarkManagementTest extends TestBase{

HashMap<String, String> testData;
	
	@Test(groups = {"regression", "smoke", "admin"}, priority=1)
	// TC This test verifies the details present on the Admin Portal's Benchmark Management page
	public void verifyInstrumentManagementPageDetailsTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("ADMINPORTAL_DATA_SHEETNAME"), "TC_7");
			String benchmarkManagementTitleText = testData.get("BENCHMARK_MANAGEMENT_TITLE");
			String viewColumnText = testData.get("VIEW_COLUMN");
			String benchmarkNameColumnText = testData.get("BENCHMARK_NAME_COLUMN");
			String providerText = testData.get("PROVIDER_COLUMN");
			String currencyColumnText = testData.get("CURRENCY_COLUMN");
			String lastPriceColumnText = testData.get("LAST_PRICE_COLUMN");
			String lastPriceDateText = testData.get("LAST_PRICE_DATE_COLUMN");
			String dateAddedColumnText = testData.get("DATE_ADDED");
			String globalFilterText = testData.get("GLOBAL_FILTER");
			String backButtonText = testData.get("BACK_BUTTON_TEXT");
			String newBenchmarkButtonText = testData.get("NEW_BENCHMARK_BUTTON_TEXT");
			
			startTest(properties.getLogMessage("VerifyAdminBenchmarkManagementPageDetailsTest"), properties.getLogMessage("VerifyAdminBenchmarkManagementPageDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyAdminBenchmarkManagementPageDetails"));
			
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("Admin"), properties.getConstant("Admin_User1"));	

			AdminBenchmarkManagementPage adminBenchmarkManagementPage = new AdminBenchmarkManagementPage(driver);			
			Assert.assertTrue(adminBenchmarkManagementPage.verifyAdminBenchmarkManagementPageDetails(benchmarkManagementTitleText,  viewColumnText,  benchmarkNameColumnText,  providerText,  currencyColumnText,  lastPriceColumnText,  lastPriceDateText,  dateAddedColumnText,  globalFilterText,  backButtonText,  newBenchmarkButtonText), String.format(properties.getLogMessage("AdminBenchmarkManagementPageDetailsVerificationError"), benchmarkManagementTitleText,  viewColumnText,  benchmarkNameColumnText,  providerText,  currencyColumnText,  lastPriceColumnText,  lastPriceDateText,  dateAddedColumnText,  globalFilterText,  backButtonText,  newBenchmarkButtonText));
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
