package com.investaSolutions.adminPortal.tests;

import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.adminPortal.pages.AdminInstrumentManagementPage;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class AdminInstrumentManagementTest extends TestBase{

HashMap<String, String> testData;
	
	@Test(groups = {"regression", "smoke", "admin"}, priority=1)
	// TC This test verifies the details present on the Admin Portal's Instrument Management page
	public void verifyInstrumentManagementPageDetailsTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("ADMINPORTAL_DATA_SHEETNAME"), "TC_6");
			String instrumentManagementTitleText = testData.get("INSTRUMENT_MANAGEMENT_TITLE");
			String viewColumnText = testData.get("VIEW_COLUMN");
			String isinColumnText = testData.get("ISIN_COLUMN");
			String nameColumnText = testData.get("NAME_COLUMN");
			String productTypeColumnText = testData.get("PRODUCT_TYPE_COLUMN");
			String majorAssetClassColumnText = testData.get("MAJOR_ASSET_COLUMN");
			String currencyColumnText = testData.get("CURRENCY_COLUMN");
			String lastPriceColumnText = testData.get("LAST_PRICE_COLUMN");
			String lastPriceDateText = testData.get("LAST_PRICE_DATE_COLUMN");
			String globalFilterText = testData.get("GLOBAL_FILTER");
			String backButtonText = testData.get("BACK_BUTTON_TEXT");
			String newInstrumentButtonText = testData.get("NEW_INSTRUMENT_BUTTON_TEXT");
			
			startTest(properties.getLogMessage("VerifyAdminInstrumentManagementPageDetailsTest"), properties.getLogMessage("VerifyAdminInstrumentManagementPageDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyAdminInstrumentManagementPageDetails"));
			
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("Admin"), properties.getConstant("Admin_User1"));	

			AdminInstrumentManagementPage adminInstrumentManagementPage = new AdminInstrumentManagementPage(driver);			
			Assert.assertTrue(adminInstrumentManagementPage.verifyAdminInstrumentManagementPageDetails(instrumentManagementTitleText, viewColumnText, isinColumnText, nameColumnText, productTypeColumnText, majorAssetClassColumnText, currencyColumnText, lastPriceColumnText, lastPriceDateText, globalFilterText, backButtonText, newInstrumentButtonText), String.format(properties.getLogMessage("AdminInstrumentManagementPageDetailsVerificationError"), instrumentManagementTitleText, viewColumnText, isinColumnText, nameColumnText, productTypeColumnText, majorAssetClassColumnText, currencyColumnText, lastPriceColumnText, lastPriceDateText, globalFilterText, backButtonText, newInstrumentButtonText));
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
