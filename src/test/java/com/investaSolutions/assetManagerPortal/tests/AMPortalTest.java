package com.investaSolutions.assetManagerPortal.tests;

import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.assetManagerPortal.pages.AMPortalPage;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class AMPortalTest extends TestBase{
	
	HashMap<String, String> testData;
	
	@Test(groups = {"regression", "smoke"}, priority=2)
	// TC_5 This test verifies the details present on the Asset Manager Portal's home page
	public void verifyAssetManagerPortalDetailsTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("EXCEL_SHEETNAME"), "TC_5");
			String dashboardTab = testData.get("DASHBOARD");
			String assetManagerTab = testData.get("ASSETMANAGER");
			String strategyManagementTab = testData.get("STRATEGYMANAGEMENT");
			String instrumentManagementTab = testData.get("INSTRUMENTMANAGEMENT");
			String portfolioModelManagementTab = testData.get("PORTFOLIOMODELMANAGEMENT");
			String portfolioModelApprovalTab = testData.get("PORTFOLIOMODELAPPROVAL");
			String disconnectTab = testData.get("DISCONNECT");	
			startTest(properties.getLogMessage("VerifyAssetManagerPortalDetailsTest"), properties.getLogMessage("VerifyAssetManagerPortalDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyAssetManagerPortalDetails"));
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));	

			AMPortalPage userManagementPage = new AMPortalPage(driver);			
			Assert.assertTrue(userManagementPage.verifyAssetManagerPortalPageDetails(dashboardTab, assetManagerTab, strategyManagementTab, instrumentManagementTab, portfolioModelManagementTab, portfolioModelApprovalTab, disconnectTab), String.format(properties.getLogMessage("AssetManagerPortalPageDetailsVerificationFailed"), dashboardTab, assetManagerTab, strategyManagementTab, instrumentManagementTab, portfolioModelManagementTab, portfolioModelApprovalTab, disconnectTab));
			logInfo(String.format(properties.getLogMessage("AssetManagerPortalPageDetailsVerificationPassed"), dashboardTab, assetManagerTab, strategyManagementTab, instrumentManagementTab, portfolioModelManagementTab, portfolioModelApprovalTab, disconnectTab));
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

	@Test(groups = {"regression", "smoke"}, priority=2)
	// TC_10 This test verifies the details present on the Asset Manager Portal's home page
	public void verifyLanguagesTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("EXCEL_SHEETNAME"), "TC_10");
			String englishLanguage = testData.get("ENGLISH");
			String frenchLanguage = testData.get("FRENCH");
			String italianLanguage = testData.get("ITALIAN");
			String germanLanguage = testData.get("GERMAN");
			String spanishLanguage = testData.get("SPANISH");
			startTest(properties.getLogMessage("VerifySupportedLanguagesTest"), properties.getLogMessage("VerifySupportedLanguages"));
			setTestCategory(properties.getLogMessage("CategoryVerifySupportedLanguages"));
			
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));	

			AMPortalPage userManagementPage = new AMPortalPage(driver);			
			Assert.assertTrue(userManagementPage.verifySupportedLanguages(englishLanguage, frenchLanguage, italianLanguage, germanLanguage, spanishLanguage), String.format(properties.getLogMessage("AssetManagerPortalSupportedLanguagesVerificationFailed"), englishLanguage, frenchLanguage, italianLanguage, germanLanguage, spanishLanguage));
			logInfo(String.format(properties.getLogMessage("AssetManagerPortalSupportedLanguagesVerificationPassed"), englishLanguage, frenchLanguage, italianLanguage, germanLanguage, spanishLanguage));
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
