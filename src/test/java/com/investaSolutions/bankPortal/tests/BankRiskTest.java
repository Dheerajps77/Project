package com.investaSolutions.bankPortal.tests;

import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.investaSolutions.bankPortal.pages.BankRiskPage;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class BankRiskTest extends TestBase{

	
     HashMap<String, String> testData;
	
	//@Test(groups = {"regression", "smoke"}, priority=4)
	// TC_83 This test verifies the details present on the Risk Summary page
	public void verifyRiskSummaryDetailsTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("BANKPORTAL_DATA_SHEETNAME"), "TC_83");
			String pColumnText = testData.get("P_COLUMN_TEXT");
			String cColumnText = testData.get("C_COLUMN_TEXT");
			String account = testData.get("ACCOUNT_COLUMN_TEXT");
			String accountMV = testData.get("ACCOUNTMV_COLUMN_TEXT");
			String advisor = testData.get("ADVISOR_COLUMN_TEXT");
			String status = testData.get("STATUS_COLUMN_TEXT");
			String issue = testData.get("ISSUES_COLUMN_TEXT");
			String assetAllocationBreach = testData.get("ASSET_ALLOCATION_BREACH_COLUMN_TEXT");
			String strategy = testData.get("STRATEGY_COLUMN_TEXT");
			String unrealizedGL = testData.get("UNREALIAZED_GAIN_LOSS_COLUMN_TEXT");
			String portfolioRiskRating = testData.get("PORTFOLIO_RISK_RATING_COLUMN_TEXT");
			startTest(properties.getLogMessage("VerifyRiskSummaryDetailsTest"), properties.getLogMessage("VerifyRiskSummaryDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyRiskSummaryDetails"));
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("Bank"), properties.getConstant("Bank_User1"));			
			BankRiskPage bankRiskPage = new BankRiskPage(driver);
			Assert.assertTrue(bankRiskPage.verifyDetailsOnRiskSummaryPage(pColumnText, cColumnText, account, accountMV, advisor, status, issue, assetAllocationBreach, strategy, unrealizedGL, portfolioRiskRating));
			logInfo(String.format(properties.getLogMessage("RiskSummaryDetailsVerificationPassed"), pColumnText, cColumnText, account, accountMV, advisor, status, issue, assetAllocationBreach, strategy, unrealizedGL, portfolioRiskRating));
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
	
	//@Test(groups = {"regression", "smoke"}, priority=5)
	// TC_84 This test verifies the details present on the Risk Portfolio Construction page
	public void verifyRiskPortfolioConstructionPageDetailsTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("BANKPORTAL_DATA_SHEETNAME"), "TC_84");
			String pColumnText = testData.get("P_COLUMN_TEXT");
			String cColumnText = testData.get("C_COLUMN_TEXT");
			String account = testData.get("ACCOUNT_COLUMN_TEXT");
			String accountMV = testData.get("ACCOUNTMV_COLUMN_TEXT");
			String status = testData.get("STATUS_COLUMN_TEXT");
			String issue = testData.get("ISSUES_COLUMN_TEXT");
			String assetAllocationBreach = testData.get("ASSET_ALLOCATION_BREACH_COLUMN_TEXT");
			String majorAABet = testData.get("MAJOR_AA_BET");
			String minorAABet = testData.get("MINOR_AA_BET");
			String unauthorizedPosition = testData.get("UNAUTHORIZED_POSITION");
			String concentretedPosition = testData.get("CONCENTRETED_POSITION");
			String overdraft = testData.get("OVERDRAFT");
			String excessCash = testData.get("EXCESS_CASH");
			String lastTradedDate = testData.get("LAST_TRADED_DATE");
			startTest(properties.getLogMessage("VerifyRiskPortfolioConstructionDetailsTest"), properties.getLogMessage("VerifyRiskPortfolioConstructionDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyRiskPortfolioConstructionDetails"));
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("Bank"), properties.getConstant("Bank_User1"));			
			BankRiskPage bankRiskPage = new BankRiskPage(driver);
			Assert.assertTrue(bankRiskPage.verifyDetailsOnRiskPortfolioConstructionPage(pColumnText, cColumnText, account, accountMV, status, issue, assetAllocationBreach, majorAABet, minorAABet, unauthorizedPosition, concentretedPosition, overdraft, excessCash, lastTradedDate));
			logInfo(String.format(properties.getLogMessage("RiskPortfolioConstructionDetailsVerificationPassed"), pColumnText, cColumnText, account, accountMV, status, issue, assetAllocationBreach, majorAABet, minorAABet, unauthorizedPosition, concentretedPosition, overdraft, excessCash, lastTradedDate, lastTradedDate));
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
	
	
	@Test(groups = {"regression", "smoke"}, priority=6)
	// TC_85 This test verifies the details present on the Analytics page
	public void verifyRiskAnalyticsDetailsTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("BANKPORTAL_DATA_SHEETNAME"), "TC_85");
			String pColumnText = testData.get("P_COLUMN_TEXT");
			String cColumnText = testData.get("C_COLUMN_TEXT");
			String account = testData.get("ACCOUNT_COLUMN_TEXT");
			String accountMV = testData.get("ACCOUNTMV_COLUMN_TEXT");
			String status = testData.get("STATUS_COLUMN_TEXT");
			String issue = testData.get("ISSUES_COLUMN_TEXT");
			String assetAllocationBreach = testData.get("ASSET_ALLOCATION_BREACH_COLUMN_TEXT");
			String ytdAccountPerf = testData.get("YTD_ACCOUNT_PERF");
			String ytdModelPerf = testData.get("YTD_MODEL_PERF");
			String ytdNetPerf = testData.get("YTD_NET_PERF");
			String alpha = testData.get("ALPHA");
			String beta = testData.get("BETA");
			String volatility = testData.get("VOLATILITY");
			String maxDrawDown = testData.get("MAX_DRAWDOWN");
			String sharpeRatio = testData.get("SHARPE_RATIO");
			startTest(properties.getLogMessage("VerifyRiskAnalyticsDetailsTest"), properties.getLogMessage("VerifyRiskAnalyticsDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyRiskAnalyticsDetails"));
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("Bank"), properties.getConstant("Bank_User1"));			
			BankRiskPage bankRiskPage = new BankRiskPage(driver);
			Assert.assertTrue(bankRiskPage.verifyDetailsOnRiskAnalyticsPage(pColumnText, cColumnText, account, accountMV, status, issue, assetAllocationBreach, ytdAccountPerf, ytdModelPerf, ytdNetPerf, alpha, beta, volatility, maxDrawDown, sharpeRatio));
			logInfo(String.format(properties.getLogMessage("RiskAnalyticsDetailsVerificationPassed"), pColumnText, cColumnText, account, accountMV, status, issue, assetAllocationBreach, ytdAccountPerf, ytdModelPerf, ytdNetPerf, alpha, beta, volatility, maxDrawDown, sharpeRatio));
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
		
	@Test(groups = {"regression", "smoke"}, priority=6)
	// TC_86 This test verifies the details present on the Risk Other page
	public void verifyRiskOtherDetailsTest() throws Throwable{
		try {
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("BANKPORTAL_DATA_SHEETNAME"), "TC_86");
			String pColumnText = testData.get("P_COLUMN_TEXT");
			String cColumnText = testData.get("C_COLUMN_TEXT");
			String account = testData.get("ACCOUNT_COLUMN_TEXT");
			String accountMV = testData.get("ACCOUNTMV_COLUMN_TEXT");
			String status = testData.get("STATUS_COLUMN_TEXT");
			String issue = testData.get("ISSUES_COLUMN_TEXT");
			String assetAllocationBreach = testData.get("ASSET_ALLOCATION_BREACH_COLUMN_TEXT");
			String onboarding = testData.get("ONBOARDING");
			String loginFromClient = testData.get("LOGIN_FROM_CLIENT");
			startTest(properties.getLogMessage("VerifyRiskOtherDetailsTest"), properties.getLogMessage("VerifyRiskOtherDetail"));
			setTestCategory(properties.getLogMessage("CategoryVerifyRiskOtherDetails"));
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("Bank"), properties.getConstant("Bank_User1"));			
			BankRiskPage bankRiskPage = new BankRiskPage(driver);
			Assert.assertTrue(bankRiskPage.verifyDetailsOnRiskOtherPage(pColumnText, cColumnText, account, accountMV, status, issue, assetAllocationBreach, onboarding, loginFromClient));
			logInfo(String.format(properties.getLogMessage("RiskOtherDetailsVerificationPassed"), pColumnText, cColumnText, account, accountMV, status, issue, assetAllocationBreach, onboarding, loginFromClient));
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
