package com.investaSolutions.assetManagerPortal.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;
import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.UserFunctions;

public class DisconnectTest  extends TestBase{
	
	@Test(groups = {"regression", "smoke"}, priority=3)
	// TC_8 This test verifies that the Disconnect button is present
	public void verifyDisconnectButtonIsDisplayed() throws Throwable {
		try {
			String disconnectText;
			startTest(properties.getLogMessage("DisconnectVerification"), properties.getLogMessage("DisconnectVerificationDetail"));
			setTestCategory(properties.getLogMessage("CategoryDisconnect"));
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.loginUser(properties.getConstant("AssetManager"), properties.getConstant("AM_User1"));
			logInfo(properties.getLogMessage("LoginTestPassed"));
			disconnectText = userFunctions.getLogoutText();
			assertEquals(disconnectText, properties.getConstant("DisconnectText"));
			logInfo(String.format(properties.getLogMessage("VerifiedDisconnectText"), disconnectText));
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
