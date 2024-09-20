package com.investaSolutions.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.investaSolutions.utils.PropertiesManager;

public class SingletonWebDriver {

    private static WebDriver driver;
    public static PropertiesManager properties = PropertiesManager.getInstance();
    public static Logger log;
    // Private constructor to prevent instantiation
    private SingletonWebDriver() {
    }
    
    public static WebDriver getLinuxDriver() throws MalformedURLException, Exception {
		new DesiredCapabilities();
		URL serverUrl = new URL(properties.getConfig("LINUXSERVERURL"));
		log.info(properties.getLogMessage("HittingURL" ) + serverUrl);
		log.info(properties.getLogMessage("LinuxDesiredCapabilities"));
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(serverUrl, capabilities);
		return driver;
	}

    // Static method to get the single instance of WebDriver
    public static WebDriver getWebDriverInstance(String browser) throws Exception {
        if (driver == null) {
            // Create WebDriver based on browser type
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = createChromeDriver();
                    break;
                case "firefox":
                	driver = createFirefoxDriver();
                    break;
                case "ie":
                	driver = createInternetExplorerDriver();
                    break;
                case "headless":
                	driver=createHeadlessChromeDriver();
                default:
                    throw new IllegalArgumentException("Unsupported browser type: " + browser);
            }
        }
        return driver;
    }

    // Method to create ChromeDriver instance
    private static WebDriver createChromeDriver() throws Exception {
    	System.setProperty("webdriver.chrome.driver", properties.getConfig("CHROMEDRIVERPATH"));
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		driver = new ChromeDriver(caps);
		return driver;
    }
    
    private static WebDriver createFirefoxDriver() throws Exception {
    	System.setProperty("webdriver.gecko.driver", properties.getConfig("FIREFOXDRIVERPATH"));
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		driver = new FirefoxDriver();
        return driver; // Replace with actual implementation
    }

    private static WebDriver createInternetExplorerDriver() throws Exception {
    	System.setProperty("webdriver.ie.driver", properties.getConfig("IEDRIVERPATH"));
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		driver = new InternetExplorerDriver(caps);
        return null; // Replace with actual implementation
    }

    private static WebDriver createHeadlessChromeDriver() throws Exception {
    	System.setProperty("webdriver.chrome.driver", properties.getConfig("CHROMEDRIVERPATH"));
		ChromeOptions option=new ChromeOptions();
		option.setHeadless(true);
		option.addArguments("window-size=1200,1100");
		option.addArguments("--proxy-server='direct://'");
		option.addArguments("--proxy-bypass-list=*");
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		driver = new ChromeDriver(option);
        return null; // Replace with actual implementation
    }

    // Add methods to close and quit WebDriver if needed
    public static void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
