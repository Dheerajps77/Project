package com.investaSolutions.assetManagerPortal.tests;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.assetManagerPortal.pages.AMPortfolioModelApprovalPage;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class AMPortfolioModelApprovalTest extends TestBase {

	HashMap<String, String> testData;
	
	@Test(groups = {"regression", "smoke"}, priority = 2)
	public void verifyPortfolioModelApprovalDetailsTest(Method method) throws Throwable {
		String portfolioModelNameColumnLabelText = "";
		String bankColumnLabelText = "";
		String bankPermissionTitleText = "";
		String portfolioModelApprovalTabTitleText = "";
		String revokedByBankIconText = "";
		String notSubmittedIconText = "";
		String submittedToBankIconText = "";
		String approvedByBankIconText = "";
		String cancelledByAssetManagerIconText = "";
		String rejectedByBankIconText = "";
		boolean flag;
		AMPortfolioModelApprovalPage objApprovalPage = null;
		try {
			objApprovalPage = new AMPortfolioModelApprovalPage(driver);
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("EXCEL_SHEETNAME"), "TC_6");
			portfolioModelNameColumnLabelText = testData.get("PORTFOLIOMODELNAME");
			bankColumnLabelText = testData.get("BANK");
			bankPermissionTitleText = testData.get("BANKPERMISSIONS");
			portfolioModelApprovalTabTitleText = testData.get("PORTFOLIOMODELAPPROVALTABTITLE");
			revokedByBankIconText = testData.get("REVOKEDBYBANK");
			notSubmittedIconText = testData.get("NOTSUBMITTED");
			submittedToBankIconText = testData.get("SUBMITTEDTOBANK");
			approvedByBankIconText = testData.get("APPROVEDBYBANK");
			cancelledByAssetManagerIconText = testData.get("CANCELLEDBYASSETMANAGER");
			rejectedByBankIconText = testData.get("REJECTEDBYBANK");					
			startTest(properties.getLogMessage("VerifyPortfolioModelApprovalDetailsTest"),
					properties.getLogMessage("VerifyPortfolioModelApprovalDetail"));
			setTestCategory(properties.getLogMessage("CategoryPortfolioModelApprovalDetails"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));			
			flag = objApprovalPage.verifyPortfolioModelApprovalTabAndDetails(portfolioModelApprovalTabTitleText,
					portfolioModelNameColumnLabelText, bankColumnLabelText, bankPermissionTitleText,
					notSubmittedIconText, submittedToBankIconText, approvedByBankIconText,
					cancelledByAssetManagerIconText, revokedByBankIconText, rejectedByBankIconText);
  			Assert.assertTrue(flag, String.format(properties.getLogMessage("VerifyPortfolioModelApprovalPageDetailsPTestFailed"), portfolioModelApprovalTabTitleText,
					portfolioModelNameColumnLabelText, bankColumnLabelText, bankPermissionTitleText,
					notSubmittedIconText, submittedToBankIconText, approvedByBankIconText,
					cancelledByAssetManagerIconText, revokedByBankIconText, rejectedByBankIconText));
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
		catch (Exception e) {
			logError(properties.getLogMessage("VerifyPortfolioModelApprovalPageDetailsPTestFailed"));
			e.printStackTrace();
			logError(properties.getLogMessage(e.getMessage()));			
			throw e;
		}
		catch (Throwable e) {		
			logError(properties.getLogMessage("ExceptionMessage"));
			e.printStackTrace();
			throw e;
		}
	}
}
