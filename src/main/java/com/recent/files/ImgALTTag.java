package com.spinny.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.spinny.qa.testbase.TestBase;

public class ImgALTTag {
	
	WebDriver driver;
	public ImgALTTag(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public boolean toCheckALTAttributeOfImg(String pageURL)
	{
		driver.navigate().to(pageURL);
		List<WebElement> elements;
		String strAlt="alt";
		String altAttributeValue="";
		boolean flag=false;
		try {
			elements=driver.findElements(By.tagName("img"));
			int totalImgTagCount=elements.size();
			for(int i=0;i<totalImgTagCount;i++) {
				altAttributeValue= elements.get(i).getAttribute(strAlt);
				if(!(elements.get(i).isEnabled()))
				{
					TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyImgALTAttributeFailed"),strAlt, altAttributeValue));
					flag=true;
				}
			}
		} catch (Exception e) {			
			throw e;
		}
		return flag;
	}

}
