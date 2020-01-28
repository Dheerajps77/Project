package com.RoughWork;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EncapsulationUsesInSeleniumTest {

	private WebDriver driver;
	 
	@BeforeTest
	// Some code to initialize driver
	 
	@Test
		public void testLoginPage() throws InterruptedException {
		
			// Create an instance of SeleniumEncapsulationLoginPage class and provide the driver
		EncapsulationUsesInSeleniumPage seleniumEncapPage = new EncapsulationUsesInSeleniumPage(driver);
	 
			// Open the Application Page
			seleniumEncapPage.getPage();
	 
	// Ecapsulation - I am accessing private member using getter method
	// Enter user name
			seleniumEncapPage.getUserName().sendKeys("someUserName");
			
	// Ecapsulation - I am accessing private member using getter method getter // // Enter password
			seleniumEncapPage.getPassword().sendKeys("someUserName");
	 
	// Ecapsulation - I am accessing private member using getter method getter // // Click login button
	        seleniumEncapPage.getLoginButton().click();
			
			Thread.sleep(10);
			
			// Verify something on HomePage
			Assert.assertEquals("actual","expected");
		}
		
	//@AfterTest
	// Some code to close browser
	} // End of method - testLoginPage
	 // End of class - SeleniumEncapsulationLoginPageTest 

