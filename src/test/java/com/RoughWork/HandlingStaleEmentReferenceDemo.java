package com.RoughWork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingStaleEmentReferenceDemo {
	
	
	static WebDriver driver;
	ArrayList<String> arraylist=new ArrayList<String>();
	
	public static boolean handleStaleElement(WebDriver driver, WebElement locator, int timeToWait)
	{
		boolean b=false;
		try {
			WebDriverWait wait=new WebDriverWait(driver, timeToWait);
			b=wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(locator)));
			if(b)
			{
				b=true;
			}
		} catch (Exception e) {
			//throw new StaleElementReferenceException("Element got Stale.. Please handle properly");
			return b=false;
		}
		return b;
	}
	public static void handlingStaleElementReferenceException() throws Exception
	{
		try {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahul\\git\\Project\\Resources\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.get("https://www.google.com/");
			
			WebElement googleTextBox=driver.findElement(By.xpath("//input[@name='q']"));
			googleTextBox.sendKeys("Hello....");
			Thread.sleep(2000);
			
			List<WebElement> dropdownListValue=driver.findElements(By.xpath("//div[@class='aajZCb']//ul//li//div[2]//span"));			
			int totalCount=dropdownListValue.size();
			
			for(int i=1;i<=totalCount;i++)
			{
				WebElement element=driver.findElement(By.xpath("//div[@class='aajZCb']//ul//li["+i+"]//div[2]//span"));
				String textOfDropDownValue=element.getText();
				System.out.println(textOfDropDownValue);
			}
			Thread.sleep(2000);
			driver.navigate().refresh();
/*			String str=driver.getWindowHandle();
			driver.switchTo().window(str);*/
			Thread.sleep(2000);
			
			boolean b=handleStaleElement(driver, googleTextBox, 30);
			if(b)
			{
				driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Annabelle...");
			}
					
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		handlingStaleElementReferenceException();
		
	}

}
