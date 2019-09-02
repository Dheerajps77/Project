package com.investaSolutions.assetManagerPortal.tests;

import java.util.HashMap;

import javax.swing.JOptionPane;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.investaSolutions.assetManagerPortal.pages.AMProfilePage;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.ExcelUtils;
import com.investaSolutions.utils.UserFunctions;

public class AMProfileTest extends TestBase{

	HashMap<String, String> testData;
	
	@Test(priority=1)
	// TC_1 This test verify details of profile page.
	public void verifyDetailsOnProfilePage() throws Throwable{
		try{
			testData = ExcelUtils.GetTestCaseData(System.getProperty("user.dir") + properties.getConfig("TESTDATA_EXCELFILE_PATH"), properties.getConfig("PROFILE_SHEETNAME"), "TC_1");
			String name = testData.get("Name_Text");
			String description = testData.get("Description_Text");
			String webSiteURL = testData.get("WebSiteUrl_Text");
			startTest(properties.getLogMessage("VerifyProfileTest"), properties.getLogMessage("VerifyProfileDetails"));
			setTestCategory(properties.getLogMessage("CategoryProfileTest"));
			UserFunctions userFunctions = new UserFunctions(driver); 
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			AMProfilePage assetManagerProfilePage=new AMProfilePage(driver);
			Assert.assertTrue(assetManagerProfilePage.verifyDetailsOnProfilePage(name,description,webSiteURL),properties.getLogMessage("VerifyDetailsOnProfilePageTestFail"));
			logInfo(properties.getLogMessage("VerifyDetailsOnProfilePageTestPass"));
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
