package com.investaSolutions.factoryPatterns;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class TestClassOfFactoryPatterns {

	@Test
	public void sampleTest001() {
		WebDriver driver = BrowserFactoryPatterns.getBrowser("Firefox");
		driver.get("https://toolsqa.com");

		// Test that both the browsers are actually only one instance of firefox driver
		WebDriver driver1 = BrowserFactoryPatterns.getBrowser("Firefox");

		if (driver.equals(driver1)) {
			System.out.println("The two firefox drivers are same");
		}
	}

	@Test
	public void sampleTest002() {
		WebDriver driver = BrowserFactoryPatterns.getBrowser("Chrome");
		driver.get("https://google.com");

		// Test that both the browsers are actually only one instance of chrome driver
		WebDriver driver1 = BrowserFactoryPatterns.getBrowser("Chrome");
		if (driver.equals(driver1)) {
			System.out.println("The two chrome drivers are same");
		}
	}

	@AfterSuite
	public void tearDown() {
		BrowserFactoryPatterns.closeAllDriver();
	}

}
