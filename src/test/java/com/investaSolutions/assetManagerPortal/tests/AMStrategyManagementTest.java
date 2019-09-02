package com.investaSolutions.assetManagerPortal.tests;

import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.assetManagerPortal.pages.AMStrategyManagementInvestmentObjectivesPage;
import com.investaSolutions.assetManagerPortal.pages.AMStrategyManagementMarketingMaterialsPage;
import com.investaSolutions.assetManagerPortal.pages.AMStrategyManagementPage;
import com.investaSolutions.assetManagerPortal.pages.AMStrategyManagementStrategyDetailsPage;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.GenericUtils;
import com.investaSolutions.utils.UserFunctions;

public class AMStrategyManagementTest  extends TestBase{

	HashMap<String, String> testData;
	
	@Test(groups = {"regression", "smoke"}, priority=4)
	// TC_3 This test verifies the details present on the Strategy Management page
	public void verifyStrategyManagementDetailsTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("EXCEL_SHEETNAME"), "TC_3");
			String strategyManagementLabelText = testData.get("LABEL");
			String searchHeaderText = testData.get("SEARCH");
			String strategyNameHeaderText = testData.get("NAME");
			String strategyDescHeaderText = testData.get("DESCRIPTION");
			String newStrategyButtonText = testData.get("NEWSTRATEGYBUTTON");
			String backButtonText = testData.get("BACKBUTTON");
			startTest(properties.getLogMessage("VerifyStrategyManagementDetailsTest"), properties.getLogMessage("VerifyStrategyManagementDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyStrategyManagementDetails"));
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));			
			AMStrategyManagementPage strategyManagementPage = new AMStrategyManagementPage(driver);
			Assert.assertTrue(strategyManagementPage.verifyStrategyManagementPageDetails(strategyManagementLabelText, searchHeaderText, strategyNameHeaderText, strategyDescHeaderText, newStrategyButtonText, backButtonText), String.format(properties.getLogMessage("StrategyManagementDetailsVerificationFailed"), strategyManagementLabelText, searchHeaderText, strategyNameHeaderText, strategyDescHeaderText, newStrategyButtonText, backButtonText));
			logInfo(String.format(properties.getLogMessage("StrategyManagementDetailsVerificationPassed"), strategyManagementLabelText, searchHeaderText, strategyNameHeaderText, strategyDescHeaderText, newStrategyButtonText, backButtonText));
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
	
	@Test(groups = {"regression", "smoke"}, priority=1)
	// TC This test creates new Strategy
	public void verifyCreateNewStrategyTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("EXCEL_SHEETNAME"), "TC_9");
			String strategyName = testData.get("STRATEGYNAME");
			String strategyDescription = testData.get("STRATEGYDESC");
			String objectiveName = testData.get("INVOBJECTIVENAME");
			String objectiveText = testData.get("INVOBJECTIVEDESC");
			startTest(properties.getLogMessage("VerifyCreateNewStrategyTest"), properties.getLogMessage("VerifyCreateNewStrategy"));
			setTestCategory(properties.getLogMessage("CategoryVerifyCreateNewStrategy"));			
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));			
			AMStrategyManagementPage strategyManagementPage = new AMStrategyManagementPage(driver);
			Assert.assertTrue(strategyManagementPage.createAndVerifyNewStrategy(strategyName, strategyDescription, objectiveName, objectiveText), properties.getLogMessage("VerifyCreateNewStrategyFailed")); 
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
	
	@Test(priority = 3, enabled = true)
	// TC This test verifies the details present on the Strategy details page of Strategy Management
	public void verifyDetailsOnStrategyDetailsPageTest() throws Throwable {
		String strategyDetailsLabelText = "";
		String strategyNameLabelText = "";
		String descriptionLabelText = "";
		String highLightLabelText = "";
		String imageLabelText = "";
		String backButtonText = "";
		String newStrategyButtonText = "";
		boolean flagStrategyDetails;

		AMStrategyManagementStrategyDetailsPage objvVerifyStrategyDetailsOnStrategyManagementPage = null;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME"), "TC_13");
			objvVerifyStrategyDetailsOnStrategyManagementPage = new AMStrategyManagementStrategyDetailsPage(
					driver);
			strategyDetailsLabelText = testData.get("STRATEGYDETAILSNAME");
			strategyNameLabelText = testData.get("STRATEGYNAME");
			descriptionLabelText = testData.get("DESCRIPTION");
			highLightLabelText = testData.get("HIGHLIGHTS");
			imageLabelText = testData.get("IMAGE");
			backButtonText = testData.get("BACKBUTTON");
			newStrategyButtonText = testData.get("NEWSTRATEGY_BUTTON");

			startTest(properties.getLogMessage("VerifyStrategyDetailsTest"),
					properties.getLogMessage("VerifyStrategyDetailsPageDetails"));
			setTestCategory(properties.getLogMessage("CategoryVerifyStrategyDetails"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));

			flagStrategyDetails = objvVerifyStrategyDetailsOnStrategyManagementPage
					.verifyStrategyDetailsOnStrategyManagementPage(strategyDetailsLabelText, strategyDetailsLabelText,
							strategyNameLabelText, descriptionLabelText, highLightLabelText, imageLabelText,
							backButtonText, newStrategyButtonText);
			Assert.assertTrue(flagStrategyDetails,
					properties.getLogMessage("VerifyStrategyDetailsOnStrategyManagementPageFailed"));
		} catch (Exception e) {
			logError(properties.getLogMessage("VerifyStrategyDetailsOnStrategyManagementPageFailed"));
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));
			throw e;
		}
	}
	
	@Test(priority = 1, enabled = true)
	// TC This test verifies the details present on the Marketing Materials page of Strategy Management
	public void verifyDetailsOnMarketingMaterialsPageTest() throws Throwable {
		String marketingMaterialsTabLabel = "";
		String marketMaterialsTitleLabel = "";
		String backButtonLabel = "";
		String newStrategyButtonLabel = "";
		String strategyVideoLabel = "";
		String updateFrequencyLabel = "";
		String effectiveDateLabel = "";		
		String vidoeLabel = "";	
		String strategySlidesLabel = "";
		String updateFrequencyLabelOfSlides = "";
		String slidesLabel = "";
		String strategyReportLabel = "";
		String updateFrequencyLabelOfReport = "";
		String reportLabel = "";
		String riskDisclosureLabel = "";
		String updateFrequencyLabelOfRisk = "";
		String reportLabelOfRisk = "";
		
		boolean flagMarketMaterialsTabAndPageDetails;

		AMStrategyManagementMarketingMaterialsPage objVerifyMarketingMaterialsOnStrategyManagementPage = null;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME"), "TC_15");
			objVerifyMarketingMaterialsOnStrategyManagementPage = new AMStrategyManagementMarketingMaterialsPage(
					driver);
			marketingMaterialsTabLabel = testData.get("MARKET_MATERIALS_TAB_TITLE_NAME");
			marketMaterialsTitleLabel = testData.get("MARKET_MATERIALS_TITLE_NAME");			
			backButtonLabel = testData.get("BACKBUTTON");
			newStrategyButtonLabel = testData.get("NEWSTRATEGY_BUTTON");			
			strategyVideoLabel = testData.get("STRATEGY_VIDEO_NAME");
			updateFrequencyLabel = testData.get("UPDATE_FREQUENCY_NAME");
			effectiveDateLabel = testData.get("EFFECTIVE_DATE_NAME");
			vidoeLabel = testData.get("VIDEO_NAME");
			strategySlidesLabel = testData.get("STRATEGY_SLIDES_NAME");
			updateFrequencyLabelOfSlides = testData.get("UPDATE_FREQUENCEY_NAME_UNDER_STRATEGYSLIDES");
			slidesLabel = testData.get("SLIDES_NAME");
			strategyReportLabel = testData.get("STRATEGY_REPORT_NAME");			
			updateFrequencyLabelOfReport = testData.get("UPDATE_FREQUENCEY_NAME_UNDER_STRATEGYREPORT");
			reportLabel = testData.get("REPORT_NAME");
			riskDisclosureLabel = testData.get("RISK_DISCLOSURE");
			updateFrequencyLabelOfRisk = testData.get("UPDATE_FREQUENCEY_NAME_UNDER_RISKDISCLOSURE");
			reportLabelOfRisk = testData.get("REPORT_NAME_UNDER_RISKDISCLOSURE");

			startTest(properties.getLogMessage("VerifyMarketingMaterialsDetailsTest"),
					properties.getLogMessage("VerifyMarketingMaterialsPageDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyMarketingMaterialsDetails"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));

			flagMarketMaterialsTabAndPageDetails = objVerifyMarketingMaterialsOnStrategyManagementPage
					.verifyMarketingMaterialsOnStrategyManagementPage(marketingMaterialsTabLabel,
							marketMaterialsTitleLabel, backButtonLabel, newStrategyButtonLabel, strategyVideoLabel,
							updateFrequencyLabel, effectiveDateLabel, vidoeLabel, strategySlidesLabel,
							updateFrequencyLabelOfSlides, slidesLabel, strategyReportLabel,
							updateFrequencyLabelOfReport, reportLabel, riskDisclosureLabel, updateFrequencyLabelOfRisk,
							reportLabelOfRisk);
			Assert.assertTrue(flagMarketMaterialsTabAndPageDetails,
					properties.getLogMessage("VerifyMarketingMaterialsTabAndDetailsOnStrategyManagementTestFailed"));

		} catch (Exception e) {
			logError(properties.getLogMessage("VerifyMarketingMaterialsTabAndDetailsOnStrategyManagementTestFailed"));
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));
			throw e;
		}
	}
	
	@Test(priority = 1, enabled = true)
	// TC This test verifies the details present on the Investment objective page of Strategy Management
	public void verifyDetailsOnInvestmentObjectivesPageTest() throws Throwable {
		String investmentObjectivesTabLabel = "";
		String investmentObjectivesTitleLabel = "";
		String investmentObjectivesTitleUnderTable = "";
		String investmentObjectiveNameLabel = "";
		String investmentObjectiveDescriptionLabel = "";
		String backButtonLabel = "";
		String newStrategyButtonLabel = "";		
		boolean flagStrategyManagementTabAndPageDetails;

		AMStrategyManagementInvestmentObjectivesPage objVerifyInvestmentObjectivesOnStrategyManagementpage = null;
		try {
			testData = ExcelUtils.GetTestCaseData(
					System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"),
					properties.getConfig("EXCEL_SHEETNAME"), "TC_14");
			objVerifyInvestmentObjectivesOnStrategyManagementpage = new AMStrategyManagementInvestmentObjectivesPage(
					driver);
			investmentObjectivesTabLabel = testData.get("INVESTMENTOBJECTIVESTABTITLE_NAME");
			investmentObjectivesTitleLabel = testData.get("INVESTMENTOBJECTIVESTITLE_NAME");
			investmentObjectivesTitleUnderTable = testData.get("TITLE");
			investmentObjectiveNameLabel = testData.get("INVESTMENTOBJECTIVE_NAME");
			investmentObjectiveDescriptionLabel = testData.get("INVESTMENTOBJECTIVEDESCRIPTION_NAME");
			backButtonLabel = testData.get("BACKBUTTON");
			newStrategyButtonLabel = testData.get("NEWSTRATEGY_BUTTON");

			startTest(properties.getLogMessage("VerifyInvestmentObjectivesDetailsTest"),
					properties.getLogMessage("VerifyInvestmentObjectivesPageDetail"));
			setTestCategory(properties.getLogMessage("CategoryInvestmentObjectivesDetails"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));

			flagStrategyManagementTabAndPageDetails = objVerifyInvestmentObjectivesOnStrategyManagementpage
					.verifyInvestmentObjectivesOnStrategyManagementPage(investmentObjectivesTabLabel,
							investmentObjectivesTitleLabel, investmentObjectivesTitleUnderTable,
							investmentObjectiveNameLabel, investmentObjectiveDescriptionLabel, backButtonLabel,
							newStrategyButtonLabel);			
			Assert.assertTrue(flagStrategyManagementTabAndPageDetails,
					properties.getLogMessage("VerifyInvestmentObjectivesTabAndDetailsOnStrategyManagementTestFailed"));
			
		} catch (Exception e) {
			logError(properties.getLogMessage("VerifyInvestmentObjectivesTabAndDetailsOnStrategyManagementTestFailed"));
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));
			throw e;
		}
	}
	
	@Test(groups = {"regression", "smoke"}, priority=1)
	public void updateExistingStategyDetailsTest() throws Throwable {
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("EXCEL_SHEETNAME"), "TC_17");
			String strategyName = testData.get("STRATEGYNAME")+" "+GenericUtils.RandomString(3);
			String strategyDescription = testData.get("STRATEGYDESC");
			String objectiveName = testData.get("INVOBJECTIVENAME");
			String objectiveText = testData.get("INVOBJECTIVEDESC");
			String successMSG = testData.get("UPDATE_SUCCESSFULL_MSG");
			String updateStrategyName = testData.get("STRATEGYNAME")+" "+GenericUtils.RandomString(3);
			startTest(properties.getLogMessage("VerifyUpdateStrategyTest"), properties.getLogMessage("VerifyUpdateStrategy"));
			setTestCategory(properties.getLogMessage("CategoryVerifyUpdateStrategy"));			
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));			
			AMStrategyManagementPage strategyManagementPage = new AMStrategyManagementPage(driver);
			Assert.assertTrue(strategyManagementPage.createAndVerifyNewStrategy(strategyName, strategyDescription, objectiveName, objectiveText), properties.getLogMessage("VerifyCreateNewStrategyFailed")); 
			Assert.assertTrue(strategyManagementPage.verifyUpdateExistingStrategyName(strategyName, updateStrategyName, strategyDescription,successMSG), properties.getLogMessage("VerifyUpdateNewStrategyFailed")); 
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
