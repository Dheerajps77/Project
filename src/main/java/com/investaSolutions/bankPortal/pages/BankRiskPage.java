package com.investaSolutions.bankPortal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.PropertiesManager;
import com.investaSolutions.utils.SeleniumUtils;

public class BankRiskPage {

	private WebDriver driver;
	public static PropertiesManager properties = PropertiesManager.getInstance();

	public BankRiskPage(WebDriver driver) {
		this.driver = driver;
	}

	private final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));

	private final By RISK_TAB = By.xpath("//*[@href='#/risk']");
	private final By SUMMERY_TAB = By.xpath("//span[text()='Summary']");
	private final By PORTFOLIO_CUNSTRUCTION_TAB = By.xpath("//span[text()='Portfolio Construction']");
	private final By ANALYTICS_TAB = By.xpath("//span[text()='Analytics']");
	private final By OTHER_TAB = By.xpath("//span[text()='Other']");

	private final By P_COLUMN_TEXT = By.xpath("//*[text()='P']");
	private final By C_COLUMN_TEXT = By.xpath("//*[text()='C']");
	private final By ACCOUNT_COLUMN_TEXT = By.xpath("//*[text()=' Account ']");
	private final By ACCOUNTMV_COLUMN_TEXT = By.xpath("//*[text()=' Account MV ']");
	private final By ADVISOR_COLUMN_TEXT = By.xpath("//*[text()='Advisor']");
	private final By STATUS_COLUMN_TEXT = By.xpath("//*[text()='Status']");
	private final By ISSUES_COLUMN_TEXT = By.xpath("//*[text()='Issues']");
	private final By ASSET_ALLOCATION_BREACH_COLUMN_TEXT = By.xpath("//*[text()='Asset Allocation Breach']");
	private final By STRATEGY_COLUMN_TEXT = By.xpath("//*[text()='Strategy']");
	private final By UNREALIZED_GAINLOSS_COLUMN_TEXT = By.xpath("//*[text()='Unrealized Gain/(Loss)']");
	private final By PORTFOLIO_RISK_RATING_COLUMN_TEXT = By.xpath("//*[text()='Portfolio Risk Rating']");

	// Portfolio Construction
	private final By MAJOR_AA_BET_COLUMN_TEXT = By.xpath("//*[text()='Major AA Bet (%)']");
	private final By MINOR_AA_BET_COLUMN_TEXT = By.xpath("//*[text()='Minor AA Bet (%)']");
	private final By UNAUTHORIZED_POSITION_COLUMN_TEXT = By.xpath("//*[text()='Unauthorized position (%)']");
	private final By CONCENTRATED_POSITION_COLUMN_TEXT = By.xpath("//*[text()='Concentrated position (%)']");
	private final By OVERDRAFT_COLUMN_TEXT = By.xpath("//*[text()='Overdraft (%)']");
	private final By EXCESS_CASH_COLUMN_TEXT = By.xpath("//*[text()='Excess cash (%)']");
	private final By LAST_TRADED_DATE_VS_MODEL_COLUMN_TEXT = By.xpath("//*[text()='Last Traded Date vs Model (days)']");

	// Analytics
	private final By YTD_ACCOUNT_PERF_COLUMN_TEXT = By.xpath("//*[text()='YTD Account Perf (%)']");
	private final By YTD_MODEL_PERF_COLUMN_TEXT = By.xpath("//*[text()='YTD Model Perf (%)']");
	private final By YTD_NET_PERF_COLUMN_TEXT = By.xpath("//*[text()='YTD Net Perf (%)']");
	private final By ALPHA_COLUMN_TEXT = By.xpath("//*[text()='Alpha (%)']");
	private final By BETA_COLUMN_TEXT = By.xpath("//*[text()='Beta (%)']");
	private final By VOLATILITY_COLUMN_TEXT = By.xpath("//*[text()='Volatility (%)']");
	private final By MAX_DRAWDOWN_COLUMN_TEXT = By.xpath("//*[text()='Max Drawdown (%)']");
	private final By SHARPE_RATIO_COLUMN_TEXT = By.xpath("//*[text()='Sharpe Ratio (%)']");

	// Other
	private final By ONBOARDING_COLUMN_TEXT = By.xpath("//*[text()='Onboarding']");
	private final By LOG_IN_FROM_CLIENT_COLUMN_TEXT = By.xpath("//*[text()='Log-in from client']");

	public void clickRiskTab() {
		SeleniumUtils.waitForElementClickable(driver, RISK_TAB, WAIT_SECONDS).click();
	}

	public void clickRiskSummaryTab() {
		SeleniumUtils.waitForElementClickable(driver, SUMMERY_TAB, WAIT_SECONDS).click();
		TestBase.logInfo(properties.getLogMessage("NavigateOnRiskSummaryPage"));
	}

	public void clickRiskPortfolioConstructionTab() {
		SeleniumUtils.waitForElementClickable(driver, PORTFOLIO_CUNSTRUCTION_TAB, WAIT_SECONDS).click();
		TestBase.logInfo(properties.getLogMessage("NavigateOnRiskPortFolioConstructionPage"));
	}

	public void clickRiskAnalyticsTab() {
		SeleniumUtils.waitForElementClickable(driver, ANALYTICS_TAB, WAIT_SECONDS).click();
		TestBase.logInfo(properties.getLogMessage("NavigateOnRiskAnalyticsPage"));
	}

	public void clickRiskOtherTab() {
		SeleniumUtils.waitForElementClickable(driver, OTHER_TAB, WAIT_SECONDS).click();
		TestBase.logInfo(properties.getLogMessage("NavigateOnRiskOtherPage"));
	}

	public String pColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, P_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String cColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, C_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String accountColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, ACCOUNT_COLUMN_TEXT, WAIT_SECONDS).getText().trim();
	}

	public String accountMVColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, ACCOUNTMV_COLUMN_TEXT, WAIT_SECONDS).getText().trim();
	}

	public String advisorColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, ADVISOR_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String statusColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, STATUS_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String issuesColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, ISSUES_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String assetAllocationBreachColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, ASSET_ALLOCATION_BREACH_COLUMN_TEXT, WAIT_SECONDS)
				.getText();
	}

	public String strategyColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, STRATEGY_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String unrealizedGainLossColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, UNREALIZED_GAINLOSS_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String portfolioRiskRatingColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, PORTFOLIO_RISK_RATING_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String majorAaBetColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, MAJOR_AA_BET_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String minorAaBetColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, MINOR_AA_BET_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String unauthorizedPositionColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, UNAUTHORIZED_POSITION_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String concentratedPositionColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, CONCENTRATED_POSITION_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String overdraftColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, OVERDRAFT_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String excessCashColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, EXCESS_CASH_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String lastTradedDateVsModelColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, LAST_TRADED_DATE_VS_MODEL_COLUMN_TEXT, WAIT_SECONDS)
				.getText();
	}

	public String ytdAccountPerfColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, YTD_ACCOUNT_PERF_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String ytdModelPerfColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, YTD_MODEL_PERF_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String ytdNetPerfColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, YTD_NET_PERF_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String alphaColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, ALPHA_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String betaColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, BETA_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String volatilityColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, VOLATILITY_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String maxDrawdownColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, MAX_DRAWDOWN_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String sharpeRatioColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, SHARPE_RATIO_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String onboadingColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, ONBOARDING_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	public String logInFromClientColumnText() {
		return SeleniumUtils.waitForElementPresence(driver, LOG_IN_FROM_CLIENT_COLUMN_TEXT, WAIT_SECONDS).getText();
	}

	
	
	
	public boolean verifyDetailsOnRiskSummaryPage(String pColumn, String cColumn, String account, String accMV,String advisor, String status, String issues, String assetAllocationBreach, String stretegy,String unrealiezedGL, String portfolioRiskRating) {
		boolean flag = false;
		clickRiskTab();
		clickRiskSummaryTab();
		if (pColumnText().equals(pColumn) && cColumnText().equals(cColumn) && accountColumnText().equals(account)
				&& accountMVColumnText().equals(accMV) && advisorColumnText().equals(advisor)
				&& statusColumnText().equals(status) && issuesColumnText().equals(issues)
				&& assetAllocationBreachColumnText().equals(assetAllocationBreach)
				&& strategyColumnText().equals(stretegy) && unrealizedGainLossColumnText().equals(unrealiezedGL)&& portfolioRiskRatingColumnText().equals(portfolioRiskRating)) {
               
			   flag=true;
		}else{
			TestBase.logError(properties.getLogMessage("RiskSummaryDetailsVerificationFailed"));
		}
        return flag;
	}
	
	
	public boolean verifyDetailsOnRiskPortfolioConstructionPage(String pColumn, String cColumn, String account, String accMV, String status, String issues, String assetAllocationBreach, String majorAABet,String minorAABet, String unauthorizedPosition,String concentretedPosition,String overdraft,String excessCash,String lastTradedDate) {
		boolean flag = false;
		clickRiskTab();
		clickRiskPortfolioConstructionTab();
		if (pColumnText().equals(pColumn) && cColumnText().equals(cColumn) && accountColumnText().equals(account)
				&& accountMVColumnText().equals(accMV)
				&& statusColumnText().equals(status) && issuesColumnText().equals(issues)
				&& assetAllocationBreachColumnText().equals(assetAllocationBreach)
				&& majorAaBetColumnText().equals(majorAABet) && minorAaBetColumnText().equals(minorAABet) && unauthorizedPositionColumnText().equals(unauthorizedPosition)
				&& concentratedPositionColumnText().equals(concentretedPosition) && overdraftColumnText().equals(overdraft) && excessCashColumnText().equals(excessCash) && lastTradedDateVsModelColumnText().equals(lastTradedDate)) {
               
			   flag=true;
		}else{
			TestBase.logError(properties.getLogMessage("RiskPortfolioConstructionDetailsVerificationFailed"));
		}	
        return flag;
	}
	
	public boolean verifyDetailsOnRiskAnalyticsPage(String pColumn, String cColumn, String account, String accMV, String status, String issues, String assetAllocationBreach, String ytdAccountPerf,String ytdModelPerf, String ytdNetPerf,String alpha,String beta,String volatility,String maxDrawDown,String sharpeRatio) {
		boolean flag = false;
		clickRiskTab();
		clickRiskAnalyticsTab();
		if (pColumnText().equals(pColumn) && cColumnText().equals(cColumn) && accountColumnText().equals(account)
				&& accountMVColumnText().equals(accMV)
				&& statusColumnText().equals(status) && issuesColumnText().equals(issues)
				&& assetAllocationBreachColumnText().equals(assetAllocationBreach)
				&& ytdAccountPerfColumnText().equals(ytdAccountPerf) && ytdModelPerfColumnText().equals(ytdModelPerf) && ytdNetPerfColumnText().equals(ytdNetPerf)
				&& alphaColumnText().equals(alpha) && betaColumnText().equals(beta) && volatilityColumnText().equals(volatility) && maxDrawdownColumnText().equals(maxDrawDown) && sharpeRatioColumnText().equals(sharpeRatio)) {
               
			   flag=true;
		}else{
			TestBase.logError(properties.getLogMessage("RiskPortAnalyticsDetailsVerificationFailed"));
		}	
        return flag;
	}
	
	public boolean verifyDetailsOnRiskOtherPage(String pColumn, String cColumn, String account, String accMV, String status, String issues, String assetAllocationBreach, String onboarding,String loginFromClient) {
		boolean flag = false;
		clickRiskTab();
		clickRiskOtherTab();
		if (pColumnText().equals(pColumn) && cColumnText().equals(cColumn) && accountColumnText().equals(account)
				&& accountMVColumnText().equals(accMV)
				&& statusColumnText().equals(status) && issuesColumnText().equals(issues)
				&& assetAllocationBreachColumnText().equals(assetAllocationBreach)
				&& onboadingColumnText().equals(onboarding) && logInFromClientColumnText().equals(loginFromClient)) {
               
			   flag=true;
		}else{
			TestBase.logError(properties.getLogMessage("RiskOtherDetailsVerificationFailed"));
		}	
        return flag;
	}
	
}
