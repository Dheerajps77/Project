package com.investaSolutions.bankPortal.tests;

import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.bankPortal.pages.BankPMConfigurationPage;
import com.investaSolutions.bankPortal.pages.BankPortalPage;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class BankPortalTest extends TestBase {

	HashMap<String, String> testData;

	// @Test(groups = { "regression", "smoke", "bank" }, priority = 1)
	// TC This test verifies the details present on the Bank Portal's home page
	public void verifyBankPortalDetailsTest() throws Throwable {
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("BANKPORTAL_DATA_SHEETNAME"), "TC_1");
			String dashboardTab = testData.get("DASHBOARD");
			String settingsTab = testData.get("SETTINGS");
			String instrumentsTab = testData.get("INSTRUMENTS");
			String modelsTab = testData.get("MODELS");
			String rebalanceTab = testData.get("REBALANCE");
			String riskTab = testData.get("RISK");
			String usersTab = testData.get("USERS");
			String disconnectTab = testData.get("DISCONNECT");

			startTest(properties.getLogMessage("VerifyBankPortalDetailsTest"),
					properties.getLogMessage("VerifyBankPortalDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyBankPortalDetails"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("Bank"), properties.getConstant("Bank_User1"));

			BankPortalPage bankPortalPage = new BankPortalPage(driver);
			Assert.assertTrue(
					bankPortalPage.verifyBankPortalPageDetails(dashboardTab, settingsTab, instrumentsTab, modelsTab,
							rebalanceTab, riskTab, usersTab, disconnectTab),
					String.format(properties.getLogMessage("BankPortalPageDetailsVerificationFailed"), dashboardTab,
							settingsTab, instrumentsTab, modelsTab, rebalanceTab, riskTab, usersTab, disconnectTab));
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

	// @Test(groups = { "regression", "smoke", "bank" }, priority = 2)
	// TC This test Verify Global filter functionality on PM Configuration page
	public void verifyGlobalFilterFunctionalityOnPMConfigurationTest() throws Throwable {
		String settingsTabText;
		String dropdownValue;
		String urlFractionValue;
		String expectedURL;
		String assetManagerNameValue;
		boolean flagVerifyGlobalFilterOnPMConfigPage;
		BankPMConfigurationPage objBankPMConfigurationPage;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("BANKPORTAL_DATA_SHEETNAME"), "TC_7");
			settingsTabText = testData.get("SETTING_TAB_TITLE");
			dropdownValue = testData.get("DROPDOWNVALUE_OF_SETTINGSTAB");
			urlFractionValue = testData.get("URL_FRACTION_VALUE");
			expectedURL = testData.get("URL");
			assetManagerNameValue = testData.get("ASSETMANAGER_NAME");

			startTest(properties.getLogMessage("GlobalFilterOnPMConfigurationPage"),
					properties.getLogMessage("VerifyGlobalFilterFunctionalityOnPMConfigurationPage"));
			setTestCategory(properties.getLogMessage("CategoryGlobalFilterOnPMConfigurationPage"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("Bank"), properties.getConstant("Bank_User1"));

			objBankPMConfigurationPage = new BankPMConfigurationPage(driver);
			flagVerifyGlobalFilterOnPMConfigPage = objBankPMConfigurationPage
					.verifyGlobalFilterFunctionalityOnPMConfigurationPage(settingsTabText, dropdownValue,
							urlFractionValue, expectedURL, assetManagerNameValue);
			Assert.assertTrue(flagVerifyGlobalFilterOnPMConfigPage,
					properties.getLogMessage("VerifyGlobalFilterOnPMConfigurationTestFailed"));
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

	// @Test(groups = { "regression", "smoke", "bank" }, priority = 3)
	// TC-4// This test Verify details present on General Information page
	public void verifyDetailsPresentOnGeneralInformationPageTest() throws Throwable {
		String settingsTabText;
		String dropdownValue;
		String urlFractionValue;
		String expectedURL;
		String assetManagerNameValue;
		String pmConfigTitle;
		String eColumnName;
		String assetManagerColumnName;
		String asetManagerColumn;
		String strategyNameColumnName;
		String riskRatingColumnName;
		String minimumInvestementColumnName;
		String managementFSColumnName;
		String custodyFSColumnName;
		String titleOfGeneralInformationTab;
		String creationDateTitle;
		String inceptionDateTitle;
		String open_CloseTitle;
		String benchmarkTitle;
		String modelStyleTitle;
		String managerNameTitle;
		String managerEmailTitle;
		String managerPhoneTitle;
		String lastModificationTitle;

		boolean flagVerifyDetailsPresentOnGeneralInformation;
		BankPMConfigurationPage objBankPMConfigurationPage;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("BANKPORTAL_DATA_SHEETNAME"), "TC_7");
			settingsTabText = testData.get("SETTING_TAB_TITLE");
			dropdownValue = testData.get("DROPDOWNVALUE_OF_SETTINGSTAB");
			urlFractionValue = testData.get("URL_FRACTION_VALUE");
			expectedURL = testData.get("URL");
			assetManagerNameValue = testData.get("ASSETMANAGER_NAME");
			pmConfigTitle = testData.get("PM_CONFIG_TITLE");
			eColumnName = testData.get("E_COLUMNNAME");
			assetManagerColumnName = testData.get("ASSET_MANAGER_COLUMNNAME");
			asetManagerColumn = testData.get("ASET_MANAGER_COLUMNNAME");
			strategyNameColumnName = testData.get("STRATEGY_NAME_COLUMNNAME");
			riskRatingColumnName = testData.get("RISK_RATING_COLUMNNAME");
			minimumInvestementColumnName = testData.get("MININUM_INVESTMENT_COLUMNNAME");
			managementFSColumnName = testData.get("MANAGEMENT_FS_COLUMNNAME");
			custodyFSColumnName = testData.get("CUSTODY_FS_COLUMNNAME");
			titleOfGeneralInformationTab = testData.get("GENERAL_INFORMATION_TAB_TITLE");
			creationDateTitle = testData.get("CREATION_DATE_TITLE");
			inceptionDateTitle = testData.get("INCEPTION_DATE_TITLE");
			open_CloseTitle = testData.get("OPENCLOSE_TITLE");
			benchmarkTitle = testData.get("BENCHMARK_TITLE");
			modelStyleTitle = testData.get("MODEL_STYLE_TITLE");
			managerNameTitle = testData.get("MANAGERNAME_TITLE");
			managerEmailTitle = testData.get("MANAGEREMAIL_TITLE");
			managerPhoneTitle = testData.get("MANAGEREPHONE_TITLE");
			lastModificationTitle = testData.get("LAST_MODIFICATION_TITLE");

			startTest(properties.getLogMessage("VerifyDetailsPresentOnGeneralInformation"),
					properties.getLogMessage("VerifyDetailsPresentOnGeneralInformationInPage"));
			setTestCategory(properties.getLogMessage("CategoryVerifyDetailsPresentOnGeneralInformation"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("Bank"), properties.getConstant("Bank_User1"));

			objBankPMConfigurationPage = new BankPMConfigurationPage(driver);

			flagVerifyDetailsPresentOnGeneralInformation = objBankPMConfigurationPage
					.verifyDetailsPresentOnGeneralInformationPage(settingsTabText, dropdownValue, urlFractionValue,
							expectedURL, assetManagerNameValue, pmConfigTitle, strategyNameColumnName,
							assetManagerColumnName, asetManagerColumn, strategyNameColumnName, riskRatingColumnName,
							minimumInvestementColumnName, managementFSColumnName, custodyFSColumnName,
							titleOfGeneralInformationTab, creationDateTitle, inceptionDateTitle, open_CloseTitle,
							benchmarkTitle, modelStyleTitle, managerNameTitle, managerEmailTitle, managerPhoneTitle,
							lastModificationTitle);

			Assert.assertTrue(flagVerifyDetailsPresentOnGeneralInformation,
					properties.getLogMessage("VerifyDetailsPresentOnGeneralInformationTestFailed"));
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

	// @Test(groups = { "regression", "smoke", "bank" }, priority = 4)
	// TC-5// This test Verify details present on Strategy page
	public void verifyDetailsPresentOnStrategyPageTest() throws Throwable {
		String settingsTabText;
		String dropdownValue;
		String urlFractionValue;
		String expectedURL;
		String assetManagerNameValue;
		String pmConfigTitle;
		String titleOfStrategyTab;
		String diversifiedActiveTitle;
		String objectivesTitle;
		String overviewTitle;
		String insightsTitle;
		String assetAllocationTitle;
		String marketingMaterialsTitle;
		String expertStrategyExplainsTitle;
		String cautiousTitle;
		String moderatelyCautiousTitle;
		String moderateTitle;
		String moderatelyAdventureTitle;
		String adventurousTitle;
		String tagNameOfLink;

		boolean flagVerifyDetailsPresentOnStrategyPage;
		BankPMConfigurationPage objBankPMConfigurationPage;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("BANKPORTAL_DATA_SHEETNAME"), "TC_8");
			settingsTabText = testData.get("SETTING_TAB_TITLE");
			dropdownValue = testData.get("DROPDOWNVALUE_OF_SETTINGSTAB");
			urlFractionValue = testData.get("URL_FRACTION_VALUE");
			expectedURL = testData.get("URL");
			assetManagerNameValue = testData.get("ASSETMANAGER_NAME");
			pmConfigTitle = testData.get("PM_CONFIG_TITLE");
			titleOfStrategyTab = testData.get("STRATEGYTAB_TITLE");
			diversifiedActiveTitle = testData.get("DIVERSIFIEDACTIVE_TITLE");
			objectivesTitle = testData.get("OBJECTIVES_TITLE");
			overviewTitle = testData.get("OVERVIEW_TITLE");
			insightsTitle = testData.get("INSIGHTS_TITLE");
			assetAllocationTitle = testData.get("ASSETALLOCATION_TITLE");
			marketingMaterialsTitle = testData.get("MARKETINGMATERIALS_TITLE");
			expertStrategyExplainsTitle = testData.get("EXPERTSTRATEGYEXPLAINS_TITLE");
			cautiousTitle = testData.get("CAUTIOUS_TITLE");
			moderatelyCautiousTitle = testData.get("MODERATELYCAUTIOUS_TITLE");
			moderateTitle = testData.get("MODERATE_TITLE");
			moderatelyAdventureTitle = testData.get("MODERATELYADVENTUROUS_TITLE");
			adventurousTitle = testData.get("ADVENTUROUS_TITLE");
			tagNameOfLink = testData.get("TAGNAME_OF_A");

			startTest(properties.getLogMessage("VerifyDetailsPresentOnStrategyPage"),
					properties.getLogMessage("VerifyDetailsPresentOnStrategyInPage"));
			setTestCategory(properties.getLogMessage("CategoryVerifyDetailsPresentOnStrategyPage"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("Bank"), properties.getConstant("Bank_User1"));

			objBankPMConfigurationPage = new BankPMConfigurationPage(driver);
			flagVerifyDetailsPresentOnStrategyPage = objBankPMConfigurationPage.verifyDetailsPresentOnStrategyPage(
					settingsTabText, dropdownValue, urlFractionValue, expectedURL, assetManagerNameValue, pmConfigTitle,
					titleOfStrategyTab, diversifiedActiveTitle, objectivesTitle, overviewTitle, insightsTitle,
					assetAllocationTitle, marketingMaterialsTitle, expertStrategyExplainsTitle, cautiousTitle,
					moderatelyCautiousTitle, moderateTitle, moderatelyAdventureTitle, adventurousTitle, tagNameOfLink);
			Assert.assertTrue(flagVerifyDetailsPresentOnStrategyPage,
					properties.getLogMessage("VerifyDetailsPresentOnStrategyTestFailed"));

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

	@Test(groups = { "regression", "smoke", "bank" }, priority = 5)
	// TC-6// TC This test Verify details present on Strategy page
	public void verifyDetailsPresentOnAMProfilePageTest() throws Throwable {
		String settingsTabText;
		String dropdownValue;
		String urlFractionValue;
		String expectedURL;
		String pmConfigTitle;
		String assetManagerNameValue;
		String titleOfAMProfileTab;
		boolean flagVerifyDetailsPresentOnAMProfilePageTest;
		BankPMConfigurationPage objBankPMConfigurationPage;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("BANKPORTAL_DATA_SHEETNAME"), "TC_9");
			settingsTabText = testData.get("SETTING_TAB_TITLE");
			dropdownValue = testData.get("DROPDOWNVALUE_OF_SETTINGSTAB");
			urlFractionValue = testData.get("URL_FRACTION_VALUE");
			expectedURL = testData.get("URL");
			assetManagerNameValue = testData.get("ASSETMANAGER_NAME");
			pmConfigTitle = testData.get("PM_CONFIG_TITLE");
			titleOfAMProfileTab = testData.get("AMPROFILE_TITLE");
			startTest(properties.getLogMessage("VerifyDetailsPresentOnAMProfilePage"),
					properties.getLogMessage("VerifyDetailsPresentOnAMProfilePage"));
			setTestCategory(properties.getLogMessage("CategoryVerifyDetailsPresentAMProfilePage"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("Bank"), properties.getConstant("Bank_User1"));

			objBankPMConfigurationPage = new BankPMConfigurationPage(driver);
			flagVerifyDetailsPresentOnAMProfilePageTest = objBankPMConfigurationPage
					.verifyDetailsPresentOnAMProfilePage(settingsTabText, dropdownValue, urlFractionValue, expectedURL,
							assetManagerNameValue, pmConfigTitle, titleOfAMProfileTab);
			Assert.assertTrue(flagVerifyDetailsPresentOnAMProfilePageTest,
					properties.getLogMessage("VerifyDetailsPresentOnAMProfileTestFailed"));
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
