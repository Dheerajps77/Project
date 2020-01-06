package com.RoughWork;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetWindowHandles {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rahul\\git\\Project\\Resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		Thread.sleep(3000);
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window title name : " + driver.getTitle());
		System.out.println("Parent window name : " + parentWindow);

		Set<String> childWIndows = driver.getWindowHandles();
		Iterator<String> iterator = childWIndows.iterator();
		while (iterator.hasNext()) {
			String windows = iterator.next();
			if (!windows.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(windows);
				System.out.println("Child window title name : " + driver.getTitle());
				driver.manage().window().maximize();
				System.out.println("Child window name : " + windows);
				driver.close();
			}
		}
	}

}
