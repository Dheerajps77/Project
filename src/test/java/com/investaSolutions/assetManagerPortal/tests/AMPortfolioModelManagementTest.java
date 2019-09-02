package com.investaSolutions.assetManagerPortal.tests;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.investaSolutions.assetManagerPortal.pages.AMPortfolioModelConstructionPage;
import com.investaSolutions.assetManagerPortal.pages.AMPortfolioModelManagementPage;
import com.investaSolutions.assetManagerPortal.pages.AMStrategyManagementPage;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class AMPortfolioModelManagementTest extends TestBase {

	SoftAssert softAssert;
	HashMap<String, String> testData;

	//@Test(groups = {"regression", "smoke"}, priority = 1)
	public void verifyPortfolioModelManagementDetailsTest(Method method) throws Throwable {
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("EXCEL_SHEETNAME"), "TC_7");
			String portfolioManagementTabText = testData.get("PM_MANAGEMENTTITLE");
			String portfolioModelListTitleText = testData.get("PORTFOLIOMODELLIST");
			String dColumnLabelText = testData.get("D_COLUMNNAME");
			String cColumnLabelText = testData.get("C_COLUMNNAME");
			String modelNameLabelText = testData.get("MODELNAME_COLUMNNAME");
			String currencyLabelText = testData.get("CURRENCY_COLUMNNAME");
			String contactDetailsLabelText = testData.get("CONTACTDETAILS_COLUMNNAME");
			String modelStyleLabelText = testData.get("MODELSTYLE_COLUMNNAME");
			String openCloseLabelText = testData.get("OPENCLOSE_COLUMNNAME");
			String lastUpdatedLabelText = testData.get("LASTUPDATED_COLUMNNAME");		
			String backButtonText = testData.get("BACK");	
			boolean titleOf_ModelListFlag;
			startTest(properties.getLogMessage("VerifyPortfolioModelManagementDetailsTest"),
					properties.getLogMessage("VerifyPortfolioModelManagementDetail"));
			setTestCategory(properties.getLogMessage("CategoryPortfolioModelManagementDetail"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			logInfo(properties.getLogMessage("LoginTestPassed"));
			AMPortfolioModelManagementPage objVerifyPortfolioModelManagementPageDetails = new AMPortfolioModelManagementPage(
					driver);
			boolean flag = objVerifyPortfolioModelManagementPageDetails.verifyPortfolioManagementTabAndDetailsInPage(portfolioManagementTabText, dColumnLabelText, cColumnLabelText, modelNameLabelText,
					currencyLabelText, contactDetailsLabelText, modelStyleLabelText, openCloseLabelText,
					lastUpdatedLabelText);			
			Assert.assertTrue(flag, properties.getLogMessage("VerifyPortfolioManagementTabAndDetailsPassed"));			

			titleOf_ModelListFlag = objVerifyPortfolioModelManagementPageDetails.verifyPortfolioModelListTitle(portfolioModelListTitleText.trim());			
			Assert.assertTrue(titleOf_ModelListFlag, properties.getLogMessage("VerifyPortfolioModelListTitlePassed"));		

			boolean backButton=objVerifyPortfolioModelManagementPageDetails.verifyBackButton(backButtonText);
			Assert.assertTrue(backButton, properties.getLogMessage("VerifyBackButton"));

			boolean newPortfolioButton=objVerifyPortfolioModelManagementPageDetails.verifyNewPortfolioButton();
			Assert.assertTrue(newPortfolioButton, properties.getLogMessage("VerifyNewPortfolioButton"));								
		} catch (Throwable e) {
			logError(properties.getLogMessage("VerifyPortfolioManagementPageDetailsTestFailed"));
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));
			throw e;
		}		
	}

	@Test(priority=1)
	// TC This test verifies New Portfolio creation
	public void verifyCreateNewPortfolioTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("EXCEL_SHEETNAME"), "TC_16");
			String strategyName = testData.get("STRATEGYNAME");
			String strategyDescription = testData.get("STRATEGYDESC");
			String objectiveName = testData.get("INVOBJECTIVENAME");
			String objectiveDescription = testData.get("INVOBJECTIVEDESC");
			String modelCurrency = testData.get("MODELCURRENCY");
			String openClose = testData.get("OPENCLOSE");	
			String modelStyle = testData.get("MODELSTYLE");	
			String subAdvisorFee = testData.get("SUBADVISORFEE");
			String targetAnnualReturn = testData.get("TARGETANNUALRETURN");	
			String targetAnnualVolatility = testData.get("TARGETANNUALVOLATILITY");	
			String successMsg = testData.get("PORTFOLIO_CREATED_SUCCESSMSG");
			String portfolioAlreadyExistsMsg = testData.get("PORTFOLIO_ALREADY_EXISTS_MSG");
			startTest(properties.getLogMessage("VerifyCreateNewStrategyTest"), properties.getLogMessage("VerifyCreateNewStrategy"));
			setTestCategory(properties.getLogMessage("CategoryVerifyCreateNewStrategy"));

			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));			

			// Create a new Strategy
			AMStrategyManagementPage strategyManagementPage = new AMStrategyManagementPage(driver);
			Assert.assertTrue(strategyManagementPage.createAndVerifyNewStrategy(strategyName, strategyDescription, objectiveName, objectiveDescription));

			// Create a new Portfolio using the strategy created above
			AMPortfolioModelManagementPage portfolioManagementPage = new AMPortfolioModelManagementPage(driver);
			//portfolioManagementPage.createNewPortfolio(strategyName, objectiveName, modelCurrency, openClose, modelStyle, subAdvisorFee, targetAnnualReturn, targetAnnualVolatility, successMsg, portfolioAlreadyExistsMsg);
			Assert.assertTrue(portfolioManagementPage.createAndVerifyNewPortfolio(strategyName, objectiveName, modelCurrency, openClose, modelStyle, subAdvisorFee, targetAnnualReturn, targetAnnualVolatility, successMsg, portfolioAlreadyExistsMsg));
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
