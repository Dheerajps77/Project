package com.investaSolutions.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.investaSolutions.utils.GenericUtils;
import com.investaSolutions.utils.PropertiesManager;
import com.investaSolutions.utils.SeleniumUtils;
import com.investaSolutions.utils.SendEmailUtils;
import com.investaSolutions.utils.UserFunctions;

public class RevisedTestBase {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Capabilities cap;
	public static Logger log;
	public static PropertiesManager properties = PropertiesManager.getInstance();
	private static final int WAIT_SECONDS = Integer.valueOf(properties.getConfig("GLOBAL_WAIT"));
	public static ExtentReports extent;
	public static ExtentTest test;
	String hostName = properties.getConfig("HOST_NAME");
	String portID = properties.getConfig("PORT_ID");
	String senderEmail = properties.getConfig("SENDER_EMAIL_ID");
	String senderPassword = properties.getConfig("SENDER_EMAIL_PASSWORD");
	String receiverEmail = properties.getConfig("RECEIVER_EMAIL_ID");
	String ccEmail = properties.getConfig("CC_EMAIL_ID");
	String[] receiverEmailArray = receiverEmail.split(";");
	String[] ccEmailArray = ccEmail.split(";");
	static String reportPath = System.getProperty("user.dir") + properties.getConfig("HTMLREPORT_PATH")
			+ properties.getConfig("HTMLREPORT_NAME");

	@BeforeSuite(alwaysRun = true)
	@Parameters("browser")
	public static void beforeSuite(String browser) {
		try {
			initializeLogger();
			cleanupFolders();

			extent = createInstance(reportPath);

			log.info(properties.getLogMessage("GettingOSName"));
			if (isLinux()) {
				driver = SingletonWebDriver.getLinuxDriver();
				log.info(properties.getLogMessage("LinuxOS"));
			} else if (isWindows()) {
				driver = SingletonWebDriver.getWebDriverInstance(browser);
				log.info(properties.getLogMessage("WindowsOS"));
			} else {
				log.info(properties.getLogMessage("InvalidOS"));
			}

			if (driver != null) {
				driver.manage().window().setSize(new Dimension(1200, 1100));
				driver.manage().timeouts().implicitlyWait(WAIT_SECONDS, TimeUnit.SECONDS);
			}
		} catch (Exception e) {
			log.error("Error occurred in beforeSuite: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@AfterMethod(alwaysRun = true)
	public synchronized void afterMethod(ITestResult result) {
		try {
			if (result.getStatus() == ITestResult.FAILURE) {
				log.info("Test " + result.getMethod().getMethodName() + " module has failed");
				test.log(Status.FAIL,
						MarkupHelper.createLabel(result.getName() + ": Test Case Failed", ExtentColor.RED));
				test.fail(result.getThrowable());
				String screenShotPath = SeleniumUtils.getScreenshot(driver, result.getName());
				test.addScreenCaptureFromPath(screenShotPath);
			} else if (result.getStatus() == ITestResult.SKIP) {
				log.info("Test " + result.getMethod().getMethodName() + " module has been skipped");
				test.log(Status.SKIP,
						MarkupHelper.createLabel(result.getName() + ": Test Case Skipped", ExtentColor.ORANGE));
				test.skip(result.getThrowable());
			} else {
				log.info("Test " + result.getMethod().getMethodName() + " module has passed");
				test.log(Status.PASS,
						MarkupHelper.createLabel(result.getName() + ": Test Case Passed", ExtentColor.GREEN));
				test.pass("Test passed");
			}

			// Optional: Logout after each test
			UserFunctions userFunctions = new UserFunctions(driver);
			userFunctions.LogOut();
			log.info(properties.getLogMessage("UserLoggedOutSuccessfully"));
		} catch (Exception e) {
			log.error("Error occurred in afterMethod: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@AfterSuite(alwaysRun = true)
	public void generateReport() throws Exception {
		try {
			extent.setSystemInfo("Browser", cap.getBrowserName());
			extent.setSystemInfo("Browser Version", cap.getVersion());
			extent.flush();
			driver.quit();
			SendEmailUtils.SendEmailNow(hostName, portID, senderEmail, senderPassword, receiverEmailArray, ccEmailArray,
					0, reportPath);
		} catch (Exception e) {
			log.error("Error occurred in generateReport: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static ExtentReports createInstance(String fileName) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("INVESTA SOFTWARE AUTOMATION REPORT");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("INVESTA-QA AUTOMATION REPORT");

		extent = new ExtentReports();
		extent.setSystemInfo("OS Name:", System.getProperty("os.name"));
		extent.setSystemInfo("OS Version:", System.getProperty("os.version"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.attachReporter(htmlReporter);
		return extent;
	}

	private static void initializeLogger() {
		log = Logger.getLogger("Logger");
		PropertyConfigurator
				.configure(System.getProperty("user.dir") + properties.getConfig("LOG4J_PROPERTIES_FILENAME"));
	}

	private static void cleanupFolders() throws IOException {
		GenericUtils genericUtil = new GenericUtils();
		genericUtil.cleanUpFolder(System.getProperty("user.dir") + properties.getConfig("FAILEDTEST_SCREENSHOTS_PATH"));
		genericUtil.cleanUpFolder(System.getProperty("user.dir") + properties.getConfig("HTMLREPORT_PATH"));
	}

	private static boolean isLinux() {
		return System.getProperty("os.name").contains("Linux");
	}

	private static boolean isWindows() {
		return System.getProperty("os.name").contains("Windows");
	}
}
