package com.investaSolutions.assetManagerPortal.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.GenericUtils;
import com.investaSolutions.utils.SeleniumUtils;

public class AMPortfolioModelApprovalPage {

	WebDriver driver;

	public AMPortfolioModelApprovalPage(WebDriver driver) {
		this.driver = driver;
	}

	private final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	public final By PORTFOLIO_MODEL_APPROVAL_TAB = By.xpath("//div[@class='nano-content menu-scroll-content']//ul//li//a//span[text()='Portfolio Model Approval ']");
	public final By TABLE_COLUMN_VALUES = By.xpath("//div[@class='ui-table-wrapper ng-star-inserted']//table//thead//tr//th");
	public final By STATUS_ICON_LABEL_NAME = By.xpath("//div[@class='layout-content']//child::div[@class='ui-table-wrapper ng-star-inserted']//following::div[1]//span/text()");
	public final By PM_APPROVAL_BANK_PERMISSIONS_TITLE=By.xpath("//div[@class='layout-content']//legend");
	public final By FIRST_ROW_DATA = By.xpath("//tbody[@class='ui-table-tbody']/tr[1]");

	public WebElement firstRowOfTableElement() {
		return SeleniumUtils.waitForElementPresence(driver, FIRST_ROW_DATA, WAIT_SECONDS);
	}

	public boolean verifyPortfolioModelApprovalTab(String portfolioModelApprovalTabLabelText) throws Exception {
		SeleniumUtils objSeleniumUtils = null;
		String getTitleOfPMTab = "";
		boolean flag = false;
		try {
			objSeleniumUtils = new SeleniumUtils();
			getTitleOfPMTab = objSeleniumUtils.getTitleText(driver, PORTFOLIO_MODEL_APPROVAL_TAB);
			WebElement portfolioModelApprovalElement = driver.findElement(PORTFOLIO_MODEL_APPROVAL_TAB);
			if (portfolioModelApprovalElement.isDisplayed()
					&& getTitleOfPMTab.equalsIgnoreCase(portfolioModelApprovalTabLabelText.trim())) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyPortfolioModelApprovalTabPassed"),
								getTitleOfPMTab));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyPortfolioModelApprovalTabFailed"), getTitleOfPMTab));
			throw e;
		}
		return flag;
	}

	public void clickOnPortfolioModelApprovalTab() throws Exception {
		try {
			SeleniumUtils.waitForElementClickable(driver, PORTFOLIO_MODEL_APPROVAL_TAB, 25).click();
			TestBase.logInfo(String.format(TestBase.properties.getLogMessage("PortfolioModelApprovalTabClicked")));
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean verifyPortfolioModelApprovalBankPermissionsTitle(String portfolioModelApprovalBankPermissionTitle) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils = null;
		WebElement element = null;
		String titleOfBankPermission = "";
		try {
			objSeleniumUtils = new SeleniumUtils();
			element = driver.findElement(PM_APPROVAL_BANK_PERMISSIONS_TITLE);
			titleOfBankPermission = objSeleniumUtils.getTitleText(driver, PM_APPROVAL_BANK_PERMISSIONS_TITLE);

			if (element.isDisplayed()
					&& titleOfBankPermission.equalsIgnoreCase(portfolioModelApprovalBankPermissionTitle.trim())) {
				flag = true;
				TestBase.logInfo(String.format(
						TestBase.properties.getLogMessage("VerifyPortfolioModelListBankPermissionsTitlePassed"),
						titleOfBankPermission));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyPortfolioModelListBankPermissionsTitleFailed"),
					titleOfBankPermission));
			throw e;
		}
		return flag;
	}

	// This method verifies details present on the Portfolio Model Approval Page
	public boolean verifyPortfolioModelApprovalTabAndDetails(String portfolioModelApprovalTabLabelText,
			String portfolioModelName, String bankName, String portfolioModelApprovalBankPermissionTitle,
			String notSubmittedIconText, String submittedToBankIconText, String approvedByBankIconText,
			String cancelledByAssetManagerIconText, String revokedByBankIconText, String rejectedByBankIconText) throws Exception {
		boolean flag = false;
		try {
			if (verifyPortfolioModelApprovalTab(portfolioModelApprovalTabLabelText)) 
			{
				clickOnPortfolioModelApprovalTab();
				if (verifyPortfolioModelApprovalBankPermissionsTitle(portfolioModelApprovalBankPermissionTitle)) 
				{
					if (verifyPortfolioModelApprovalDetails(portfolioModelName, bankName)) 
					{
						if (verifyStatusIconImageText(notSubmittedIconText, submittedToBankIconText,
								approvedByBankIconText, cancelledByAssetManagerIconText, revokedByBankIconText,
								rejectedByBankIconText)) 
						{
							flag = true;
						}
					}
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	public boolean verifyPortfolioModelApprovalDetails(String portfolioModelName, String bankName) throws Exception {
		boolean flag = false;		
		ArrayList<String> arrayList = null;
		GenericUtils objGenericUtils=null;
		try {		
			objGenericUtils=new GenericUtils();
			Thread.sleep(2000);
			arrayList = objGenericUtils.getColumnHeaderNames(driver, TABLE_COLUMN_VALUES);
			if (arrayList.contains(portfolioModelName) && arrayList.contains(bankName)) {
				flag = true;
				TestBase.logInfo(String.format(
						TestBase.properties.getLogMessage("VerifyPortfolioModelApprovalPageDetailsPassed"),
						portfolioModelName, bankName, arrayList.get(0), arrayList.get(1)));
			}
		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyPortfolioModelApprovalPageDetailsFailed"),
							portfolioModelName, bankName, arrayList.get(0), arrayList.get(1)));
			throw e;
		}
		return flag;
	}

	// Below method will return the column name in the arraylist
	public ArrayList<String> tableColumnNameValuesPortalfolioModelApproval() throws Exception {

		ArrayList<String> arrayList = null;
		try {
			arrayList = new ArrayList<String>();
			List<WebElement> element = driver.findElements(STATUS_ICON_LABEL_NAME);
			int totalNumberOfColumn = element.size();
			for (int i = 1; i < totalNumberOfColumn; i++) {
				WebElement elementOfColumnText = driver.findElement(By.xpath(
						"//div[@class='layout-content']//child::div[@class='ui-table-wrapper ng-star-inserted']//following::div[1]//span//text()["
								+ i + "]"));
				String stringValueOfElement = elementOfColumnText.getText();
				arrayList.add(stringValueOfElement);
			}
		} catch (Exception e) {
			throw e;
		}
		return arrayList;
	}

	public boolean verifyStatusIconImageText(String notSubmittedIconText, String submittedToBankIconText,
			String approvedByBankIconText, String cancelledByAssetManagerIconText, String revokedByBankIconText,
			String rejectedByBankIconText) throws Exception {
		boolean flag = false;
		String statusString = "";
		try {
			statusString=driver.findElement(By.xpath("//div[@class='layout-content']//child::div[@class='ui-table-wrapper ng-star-inserted']//following::div[1]//span")).getText();
			if (statusString.contains(notSubmittedIconText) && statusString.contains(submittedToBankIconText)
					&& statusString.contains(approvedByBankIconText) && statusString.contains(cancelledByAssetManagerIconText)
					&& statusString.contains(revokedByBankIconText) && statusString.contains(rejectedByBankIconText)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyStatusIconTestPassed"),
						notSubmittedIconText, submittedToBankIconText, approvedByBankIconText,
						cancelledByAssetManagerIconText, revokedByBankIconText, rejectedByBankIconText, statusString));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyStatusIconTestFailed"),
					notSubmittedIconText, submittedToBankIconText, approvedByBankIconText,
					cancelledByAssetManagerIconText, revokedByBankIconText, rejectedByBankIconText, statusString));
			throw e;
		}
		return flag;
	}
}
