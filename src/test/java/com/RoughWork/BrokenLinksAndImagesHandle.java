package com.RoughWork;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksAndImagesHandle {

	static WebDriver driver;
	static String str = System.getProperty("user.dir") + "/Resources/Drivers/chromedriver.exe";

	public static void BrokenLinksHandle() throws Exception {
		try {

			System.setProperty("webdriver.chrome.driver", str);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.tseries.com/");
			ArrayList<String> url = new ArrayList<String>();
			List<WebElement> elements = driver.findElements(By.tagName("a"));
			System.out.println("Size of full links of URL : " + elements.size());
			for (int i = 1; i < elements.size(); i++) {				
				String allURL=elements.get(i).getAttribute("href");
				System.out.println(allURL);
				if ((allURL != null) && (!allURL.contains("javascript"))) {
					url.add(allURL);
				}				
			}
			System.out.println("Size of active links of URL : " + url.size());
			for(int i=1;i<url.size();i++)
			{
				URL urlConnection=new URL(url.get(i));
				HttpURLConnection httpUrlConnection=(HttpURLConnection) urlConnection.openConnection();
				httpUrlConnection.connect();
				String responseMessage=httpUrlConnection.getResponseMessage();
				int responseCode=httpUrlConnection.getResponseCode();
				if(responseCode==200)
				{
					System.out.println(url.get(i) + "with response code "+responseCode+"-- > OK");
				}
				else
				{
					System.out.println(url.get(i) + "with response code "+responseCode+"-- > NOT OK");
				}
			}

		} catch (Exception e) {
			throw e;
		}
	}

	public static void main(String[] args) throws Exception {

		BrokenLinksHandle();
	}

}
