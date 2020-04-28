package com.spinny.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.spinny.qa.testbase.TestBase;
import com.spinny.qa.utils.GenericUtils;
import com.spinny.qa.utils.PropertiesManager;
import com.spinny.qa.utils.SeleniumUtils;

public class MetaDataOfPage {

	WebDriver driver;
	SeleniumUtils objSeleniumUtils = new SeleniumUtils();
	GenericUtils objGenericUtils = new GenericUtils();
	static PropertiesManager properties = PropertiesManager.getInstance();

	public MetaDataOfPage(WebDriver driver) {
		this.driver = driver;
	}

	/***
	 * This will verify the Title of home page which should be between 30-60
	 * characters
	 * 
	 * @return
	 */
	public void verifyLengthTitleOfPage(String initalCharCount, String endCharCount, String pageURL) {		
		int totalNumberOfChars = 0;
		int startCountOfCharNumber = 0;
		int endCountOfCharNumber = 0;
		String titleOfPage = null;
		try {
			driver.navigate().to(pageURL);
			startCountOfCharNumber = objGenericUtils.convertStringToInt(initalCharCount);
			endCountOfCharNumber = objGenericUtils.convertStringToInt(endCharCount);
			titleOfPage = driver.getTitle();
			totalNumberOfChars = objGenericUtils.getTotalNumbersOfCharacters(titleOfPage);

			if (!(totalNumberOfChars >= startCountOfCharNumber && totalNumberOfChars <= endCountOfCharNumber)) {
				TestBase.logInfo(String.format(properties.getLogMessage("VerifyTheLengthOfHomePageTitleFailed"),
						titleOfPage, totalNumberOfChars, startCountOfCharNumber, endCountOfCharNumber));				
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	

	public boolean verifyKeywordOfMetaDataOfage() {
		List<WebElement> metaElements;
		boolean flag = false;
		int totalCount;
		try {
			metaElements = driver.findElements(By.tagName("meta"));
			totalCount = metaElements.size();
			for (int i = 0; i < totalCount; i++) {
				{
					if ((metaElements.get(i).isEnabled())) {
						flag = true;
					} else {
						
						flag=false;
					}
				}
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyMetaDataKeywordDisplayFailed")));
			throw e;
		}
		return flag;
	}

	public void verifyMetaDataDescriptionOfPage(String initalCharCount, String endCharCount) throws Exception {
		List<WebElement> metaElements;
		String nameAttributeValue = "";
		String contentAttributeValue = "";
		String propertyAttributeValue = "";
		int totalCountOfDescription = 0;
		int startCountOfCharNumber = 0;
		int endCountOfCharNumber = 0;
		startCountOfCharNumber = objGenericUtils.convertStringToInt(initalCharCount);
		endCountOfCharNumber = objGenericUtils.convertStringToInt(endCharCount);
		int totalCount;
		try {
			Thread.sleep(2000);
			metaElements = driver.findElements(By.tagName("meta"));
			totalCount = metaElements.size();
			for (int i = 0; i < totalCount; i++) {
				nameAttributeValue = metaElements.get(i)
						.getAttribute(TestBase.properties.getConstant("ATTRIBUTE_NAME"));
				contentAttributeValue = metaElements.get(i)
						.getAttribute(TestBase.properties.getConstant("ATTRIBUTE_CONTENT"));
				propertyAttributeValue = metaElements.get(i)
						.getAttribute(TestBase.properties.getConstant("ATTRIBUTE_PROPERTY"));
				totalCountOfDescription = objGenericUtils.getTotalNumbersOfCharacters(contentAttributeValue);
				{
					if (!(totalCountOfDescription <= endCountOfCharNumber)) {
						TestBase.logInfo(
								String.format(properties.getLogMessage("VerifyTheLengthOfMetaDataDescriptionFailed"),
										nameAttributeValue, propertyAttributeValue, contentAttributeValue,
										totalCountOfDescription, endCountOfCharNumber));
					}
				}

			}
		} catch (Exception e) {
			throw e;
		}
	}
}
