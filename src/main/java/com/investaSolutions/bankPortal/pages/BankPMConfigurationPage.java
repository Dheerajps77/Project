package com.investaSolutions.bankPortal.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.GenericUtils;
import com.investaSolutions.utils.SeleniumUtils;

public class BankPMConfigurationPage {

	WebDriver driver;

	public BankPMConfigurationPage(WebDriver driver) {
		this.driver = driver;
	}

	public final By SETTINGS_TAB = By
			.xpath("//a[@class='ripplelink ng-tns-c2-0 ng-star-inserted']//span[text()='Settings']");
	public final By SETTINGS_TAB_DROPDOWNVALUES_TEXT = By.xpath(
			"//ul[@class='ng-tns-c2-1 ng-tns-c2-0 ng-trigger ng-trigger-children ng-star-inserted']//li//a//span[@class='ng-tns-c2-1']");
	public final By GLOBALFILTER_TEXTBOX = By
			.xpath("//div[@class='ui-table-caption ui-widget-header ng-star-inserted']//input");
	public final By GENERAL_INFORMATION_TAB_TITLE = By.xpath("//ul[@role='tablist']//li[1]//a");
	public final By STRATEGY_TAB_TITLE = By.xpath("//ul[@role='tablist']//li[2]//a");
	public final By AMPROFILE_TAB_TITLE = By.xpath("//ul[@role='tablist']//li[3]//a");
	private final By PM_CONFIG_TITLE = By.xpath("//div[@class='card card-w-title']//legend");
	private final By tableColumns = By.xpath("//div[@class='ui-table-wrapper ng-star-inserted']//table//thead//tr//th");
	public final By SEARCHPLUSBUTTON = By
			.xpath("//p-table[@selectionmode='single']/div/div[2]/table/tbody/tr[1]/td[1]/fa-icon");
	private final By STRATEGYNAME_TITLE = By.xpath(
			"//div[@class='layout-container menu-layout-static menu-layout-horizontal']//portfolio-model-display[@class='ng-star-inserted']//div/div/legend");
	private final By DIVERSIFIEDACTIVE_TITLE = By
			.xpath("//div[@id='header']//table[1]//div[contains(@class,'_15vkz2jm if-header')]");
	private final By EXPERTSTRATEGYEXPLAINS_TITLE = By.xpath("//div[@id='Benefits']//child::div//child::h1//div");
	private final By ASSETALLOCATION_TITLE = By.xpath("//div[@id='Objectives']//child::div//child::h1//div");
	private final By MARKETING_MATERIALS_TITLE = By.xpath("//div[@id='Documents']//child::div//child::h1//div");

	// This will get all dropdown text values of Settings Tab
	public ArrayList<String> getSettingsTabDropDownText() throws Exception {
		ArrayList<String> arrayList;
		List<WebElement> dropDownTextElements;
		WebElement element;
		try {
			arrayList = new ArrayList<String>();
			dropDownTextElements = driver.findElements(SETTINGS_TAB_DROPDOWNVALUES_TEXT);
			int counts = dropDownTextElements.size();

			for (int i = 1; i < counts; i++) {
				element = driver.findElement(By.xpath(
						"//ul[@class='ng-tns-c2-1 ng-tns-c2-0 ng-trigger ng-trigger-children ng-star-inserted']//li["
								+ i + "]//a//span"));
				String textValue = element.getText();
				arrayList.add(textValue);
			}

		} catch (Exception e) {
			throw e;
		}
		return arrayList;
	}

	// This will verify the Settings Tab
	public boolean verifySettingsTab() throws Exception {
		boolean flag = false;
		String tabText = null;
		try {

			if (SeleniumUtils.isElementPresent(driver, SETTINGS_TAB)) {
				tabText = driver.findElement(SETTINGS_TAB).getText();
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifySettingsTabTitlePassed"), tabText));
			}
		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifySettingsTabTitleFailed"), tabText));
			throw e;
		}
		return flag;
	}

	// This will verify the Settings Tab Text
	public boolean verifySettingsTabText(String settingsTabText) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		String getTitleTextOfSettingTab = null;
		try {
			if (verifySettingsTab()) {
				objSeleniumUtils = new SeleniumUtils();
				getTitleTextOfSettingTab = objSeleniumUtils.getTitleText(driver, SETTINGS_TAB);
				if (getTitleTextOfSettingTab.equalsIgnoreCase(settingsTabText)) {
					flag = true;
					TestBase.logInfo(
							String.format(TestBase.properties.getLogMessage("VerifySettingsTabTextTitlePassed"),
									settingsTabText, getTitleTextOfSettingTab));
				}
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifySettingsTabTextTitleFailed"),
					settingsTabText, getTitleTextOfSettingTab));
			throw e;
		}
		return flag;
	}

	// This will click on Settings Tab
	public boolean clickOnSettingsTab(String settingsTabText) throws Exception {
		boolean flag = false;
		WebElement clickOnSettingsTab;
		String tabTextValue = null;
		try {
			if (verifySettingsTabText(settingsTabText)) {
				clickOnSettingsTab = driver.findElement(SETTINGS_TAB);
				tabTextValue = clickOnSettingsTab.getText();
				SeleniumUtils.waitAndClick(driver, clickOnSettingsTab, 20);
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyClickOnSettingsTabPassed"),
						tabTextValue));
			}

		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyClickOnSettingsTabFailed"), tabTextValue));
			throw e;
		}
		return flag;
	}

	/***
	 * This will verify the dropdown value of Settings
	 * 
	 * @param dropdownValue
	 * @return
	 * @throws Exception
	 * @author dheeraj.singh
	 */
	public boolean verifyPortfolioModelConfigurationDropDownValue(String dropdownValue) throws Exception {
		boolean flag = false;
		ArrayList<String> arrayList;
		WebElement dropdownElement;
		String dropdownTextValue = null;
		try {
			arrayList = getSettingsTabDropDownText();
			if (arrayList.contains(dropdownValue.trim())) {
				dropdownElement = driver.findElement(By.xpath("//a[@href='#/pm-configuration']"));
				dropdownTextValue = dropdownElement.getText();
				SeleniumUtils.waitAndClick(driver, dropdownElement, 20);
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyDropdownValuesInSettingsTabPassed"),
								dropdownTextValue));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyDropdownValuesInSettingsTabFailed"), dropdownTextValue));
			throw e;
		}
		return flag;
	}

	/***
	 * This will verify pm-configuration page is opened or not
	 * 
	 * @param urlFractionValue
	 * @param expectedURL
	 * @return boolean
	 * @throws Exception
	 * @author dheeraj.singh
	 */
	public boolean verifyPMConfigurationPageOpened(String urlFractionValue, String expectedURL) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		String actualURL = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			actualURL = objSeleniumUtils.getCurrentPageURL(driver);
			if (objSeleniumUtils.waitTillPageURLToBeLoad(driver, urlFractionValue, 30)) {
				if (actualURL.equalsIgnoreCase(expectedURL)) {
					flag = true;
					TestBase.logInfo(
							String.format(TestBase.properties.getLogMessage("VerifyPMConfingurationPageURLPassed"),
									urlFractionValue, expectedURL, actualURL));
				}
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyPMConfingurationPageURLFailed"),
					urlFractionValue, expectedURL, actualURL));
			throw e;
		}
		return flag;
	}

	/***
	 * This will verify the Global filter textBox
	 * 
	 * @param assetManagerNameValue
	 * @return
	 * @throws Exception
	 * @author dheeraj.singh
	 */
	public boolean verifyGlobalFilterTextBox(String assetManagerNameValue) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils = null;
		WebElement globalFilterTextBoxWebElement;
		VerifyInstrumentsPage objVerifyInstrumentsPage;
		ArrayList<String> arrayList;
		try {
			objSeleniumUtils = new SeleniumUtils();
			objVerifyInstrumentsPage = new VerifyInstrumentsPage(driver);
			if (objVerifyInstrumentsPage.VerifyGlobalFilterSearchTextBox()) {
				globalFilterTextBoxWebElement = driver.findElement(GLOBALFILTER_TEXTBOX);
				globalFilterTextBoxWebElement.sendKeys(assetManagerNameValue);
				Thread.sleep(2000);
				arrayList = objSeleniumUtils.getSepcificColumnCellDetailsFromTable(driver);
				if (arrayList.contains(assetManagerNameValue)) {
					flag = true;
					TestBase.logInfo(String.format(
							TestBase.properties.getLogMessage("VerifyColumnCellsUnderTableInPMConfigurationPagePassed"),
							assetManagerNameValue));
				}

			}
		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyColumnCellsUnderTableInPMConfigurationPageFailed"),
					assetManagerNameValue));
			throw e;
		}
		return flag;
	}

	/***
	 * This Verify Global filter functionality on PM Configuration page
	 * 
	 * @param settingsTabText
	 * @param dropdownValue
	 * @param urlFractionValue
	 * @param expectedURL
	 * @param assetManagerNameValue
	 * @return
	 * @throws Exception
	 * @author dheeraj.singh
	 */
	public boolean verifyGlobalFilterFunctionalityOnPMConfigurationPage(String settingsTabText, String dropdownValue,
			String urlFractionValue, String expectedURL, String assetManagerNameValue) throws Exception {
		boolean flag = false;
		try {
			Thread.sleep(3000);
			if (clickOnSettingsTab(settingsTabText)) {
				if (verifyPortfolioModelConfigurationDropDownValue(dropdownValue)) {
					if (verifyPMConfigurationPageOpened(urlFractionValue, expectedURL)) {
						if (verifyGlobalFilterTextBox(assetManagerNameValue)) {
							flag = true;
						}
					}
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	/***
	 * This will verify the PMConfiguration Title in pm-configuration page
	 * 
	 * @param pmConfigTitle
	 * @return
	 * @throws Exception
	 * @author dheeraj.singh
	 */
	public boolean verifyPMConfigurationTitle(String pmConfigTitle) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		String actualPMConfigurationTitle = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			if (SeleniumUtils.isElementPresent(driver, PM_CONFIG_TITLE)) {
				actualPMConfigurationTitle = objSeleniumUtils.getTitleText(driver, PM_CONFIG_TITLE);
			}
			if (actualPMConfigurationTitle.equalsIgnoreCase(pmConfigTitle)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyPMConfigurationTitlePassed"),
						actualPMConfigurationTitle, pmConfigTitle));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyPMConfigurationTitleFailed"),
					actualPMConfigurationTitle, pmConfigTitle));
			throw e;
		}
		return flag;
	}

	/***
	 * This will verify the column name under PMConfiguration in pm-configuration
	 * page
	 * 
	 * @param eColumnName
	 * @param assetManagerColumnName
	 * @param asetManagerColumn
	 * @param strategyNameColumnName
	 * @param riskRatingColumnName
	 * @param minimumInvestementColumnName
	 * @param managementFSColumnName
	 * @param custodyFSColumnName
	 * @return
	 * @throws Exception
	 * @author dheeraj.singh
	 */
	public boolean verifyTableColumnsUnderPMConfiguration(String eColumnName, String assetManagerColumnName,
			String asetManagerColumn, String strategyNameColumnName, String riskRatingColumnName,
			String minimumInvestementColumnName, String managementFSColumnName, String custodyFSColumnName)
			throws Exception {
		boolean flag = false;
		GenericUtils objGenericUtils;
		ArrayList<String> arrayLists = null;
		try {
			objGenericUtils = new GenericUtils();
			arrayLists = objGenericUtils.TableColumnNameValues(driver, tableColumns);
			if (arrayLists.contains(eColumnName) && arrayLists.contains(assetManagerColumnName)
					&& arrayLists.contains(asetManagerColumn) && arrayLists.contains(strategyNameColumnName)
					&& arrayLists.contains(riskRatingColumnName) && arrayLists.contains(minimumInvestementColumnName)
					&& arrayLists.contains(managementFSColumnName) && arrayLists.contains(custodyFSColumnName)) {

				flag = true;
				TestBase.logInfo(String.format(
						TestBase.properties.getLogMessage("VerifyTableColumnNameUnderPMConfigurationPassed"),
						eColumnName, assetManagerColumnName, asetManagerColumn, strategyNameColumnName,
						riskRatingColumnName, minimumInvestementColumnName, managementFSColumnName, custodyFSColumnName,
						arrayLists));
			}

		} catch (Exception e) {
			TestBase.logError(String.format(
					TestBase.properties.getLogMessage("VerifyTableColumnNameUnderPMConfigurationFailed"), eColumnName,
					assetManagerColumnName, asetManagerColumn, strategyNameColumnName, riskRatingColumnName,
					minimumInvestementColumnName, managementFSColumnName, custodyFSColumnName, arrayLists));
			throw e;
		}
		return flag;
	}

	/***
	 * This will return the StrategyName title in portfolio-model page
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String getTitleOfStrategyName() throws Exception {
		String strategyNameTitle = null;
		SeleniumUtils objSeleniumUtils;
		try {
			objSeleniumUtils = new SeleniumUtils();
			if (SeleniumUtils.isElementPresent(driver, STRATEGYNAME_TITLE)) {
				strategyNameTitle = objSeleniumUtils.getTitleText(driver, STRATEGYNAME_TITLE);
			}
		} catch (Exception e) {
			throw e;
		}
		return strategyNameTitle;
	}

	/***
	 * This will return title under General Information Tab
	 * 
	 * @return ArrayList<String>
	 * @throws Exception
	 * @author dheeraj.singh
	 */
	public ArrayList<String> getTitlesUnderGeneralInformationTab() throws Exception {
		ArrayList<String> arraylists = new ArrayList<String>();
		try {
			List<WebElement> elements = driver.findElements(By.xpath(
					"//div[@class='ui-tabview-panel ui-widget-content ng-star-inserted']//div//div//div//div[1]/label"));
			int totalCount = elements.size();
			for (int i = 1; i <= totalCount; i++) {
				String textOfTitle = driver.findElement(
						By.xpath("//div[@class='ui-tabview-panel ui-widget-content ng-star-inserted']/div/div/div[" + i
								+ "]/div[1]/label"))
						.getText().replace(":", "").trim();
				arraylists.add(textOfTitle);
			}
		} catch (Exception e) {
			throw e;
		}
		return arraylists;
	}

	/***
	 * This will verify the title of General Information Tab
	 * 
	 * @param titleOfGeneralInformationTab
	 * @return boolean
	 * @author dheeraj.singh
	 * @throws Exception
	 */
	public boolean verifyGeneralInformationTab(String titleOfGeneralInformationTab) throws Exception {
		String actualTabTitle = null;
		SeleniumUtils objSeleniumUtils;
		boolean flag = false;
		try {
			objSeleniumUtils = new SeleniumUtils();
			if (SeleniumUtils.isElementPresent(driver, GENERAL_INFORMATION_TAB_TITLE)) {
				actualTabTitle = objSeleniumUtils.getTitleText(driver, GENERAL_INFORMATION_TAB_TITLE);
			}
			if (actualTabTitle.equalsIgnoreCase(titleOfGeneralInformationTab)) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyGeneralInformationTabTitlePassed"),
								titleOfGeneralInformationTab, actualTabTitle));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyGeneralInformationTabTitleFailed"),
					titleOfGeneralInformationTab, actualTabTitle));
			throw e;
		}
		return flag;
	}

	/***
	 * This will click on "search-Plus button in a table"
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author dheeraj.singh
	 */
	public boolean clickOnSearchPlusButton() throws Exception {
		boolean flag = false;
		try {
			flag = SeleniumUtils.isElementPresent(driver, SEARCHPLUSBUTTON);
			if (flag) {
				SeleniumUtils.waitAndClick(driver, driver.findElement(SEARCHPLUSBUTTON), 30);
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyClickOnSearchPlusButtonPassed")));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyClickOnSearchPlusButtonFailed")));
			throw e;

		}
		return flag;
	}

	/***
	 * This will verify the title of each under General information Tab
	 * 
	 * @param creationDateTitle
	 * @param inceptionDateTitle
	 * @param open_CloseTitle
	 * @param benchmarkTitle
	 * @param modelStyleTitle
	 * @param managerNameTitle
	 * @param managerEmailTitle
	 * @param managerPhoneTitle
	 * @param lastModificationTitle
	 * @return
	 * @throws Exception
	 */
	public boolean verifyPortfolioModelOfGeneralInformation(String creationDateTitle, String inceptionDateTitle,
			String open_CloseTitle, String benchmarkTitle, String modelStyleTitle, String managerNameTitle,
			String managerEmailTitle, String managerPhoneTitle, String lastModificationTitle) throws Exception {
		ArrayList<String> titles = null;
		boolean flag = false;
		try {
			titles = getTitlesUnderGeneralInformationTab();
			if (titles.contains(creationDateTitle) && titles.contains(inceptionDateTitle)
					&& titles.contains(open_CloseTitle) && titles.contains(benchmarkTitle)
					&& titles.contains(modelStyleTitle) && titles.contains(managerNameTitle)
					&& titles.contains(managerEmailTitle) && titles.contains(managerPhoneTitle)
					&& titles.contains(lastModificationTitle)) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyTitlesUnderGeneralInformationTabPassed"),
								creationDateTitle, inceptionDateTitle, open_CloseTitle, benchmarkTitle, modelStyleTitle,
								managerNameTitle, managerEmailTitle, managerPhoneTitle, lastModificationTitle, titles));
			}
		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyTitlesUnderGeneralInformationTabFailed"),
							creationDateTitle, inceptionDateTitle, open_CloseTitle, benchmarkTitle, modelStyleTitle,
							managerNameTitle, managerEmailTitle, managerPhoneTitle, lastModificationTitle, titles));
			throw e;
		}
		return flag;
	}

	/***
	 * This will Verify details present on General Information page
	 * 
	 * @param settingsTabText
	 * @param dropdownValue
	 * @param urlFractionValue
	 * @param expectedURL
	 * @param assetManagerNameValue
	 * @param pmConfigTitle
	 * @param eColumnName
	 * @param assetManagerColumnName
	 * @param asetManagerColumn
	 * @param strategyNameColumnName
	 * @param riskRatingColumnName
	 * @param minimumInvestementColumnName
	 * @param managementFSColumnName
	 * @param custodyFSColumnName
	 * @param titleOfGeneralInformationTab
	 * @param creationDateTitle
	 * @param inceptionDateTitle
	 * @param open_CloseTitle
	 * @param benchmarkTitle
	 * @param modelStyleTitle
	 * @param managerNameTitle
	 * @param managerEmailTitle
	 * @param managerPhoneTitle
	 * @param lastModificationTitle
	 * @return boolean
	 * @throws Exception
	 * @author dheeraj.singh
	 */
	public boolean verifyDetailsPresentOnGeneralInformationPage(String settingsTabText, String dropdownValue,
			String urlFractionValue, String expectedURL, String assetManagerNameValue, String pmConfigTitle,
			String eColumnName, String assetManagerColumnName, String asetManagerColumn, String strategyNameColumnName,
			String riskRatingColumnName, String minimumInvestementColumnName, String managementFSColumnName,
			String custodyFSColumnName, String titleOfGeneralInformationTab, String creationDateTitle,
			String inceptionDateTitle, String open_CloseTitle, String benchmarkTitle, String modelStyleTitle,
			String managerNameTitle, String managerEmailTitle, String managerPhoneTitle, String lastModificationTitle)
			throws Exception {
		boolean flag = false;
		try {
			Thread.sleep(3000);
			if (clickOnSettingsTab(settingsTabText)) {
				if (verifyPortfolioModelConfigurationDropDownValue(dropdownValue)) {
					if (verifyPMConfigurationPageOpened(urlFractionValue, expectedURL)) {
						if (verifyPMConfigurationTitle(pmConfigTitle)) {
							if (verifyGlobalFilterTextBox(assetManagerNameValue)) {
								if (verifyTableColumnsUnderPMConfiguration(eColumnName, assetManagerColumnName,
										asetManagerColumn, strategyNameColumnName, riskRatingColumnName,
										minimumInvestementColumnName, managementFSColumnName, custodyFSColumnName)) {
									if (clickOnSearchPlusButton()) {
										Thread.sleep(2000);
										if (verifyGeneralInformationTab(titleOfGeneralInformationTab)) {
											if (verifyPortfolioModelOfGeneralInformation(creationDateTitle,
													inceptionDateTitle, open_CloseTitle, benchmarkTitle,
													modelStyleTitle, managerNameTitle, managerEmailTitle,
													managerPhoneTitle, lastModificationTitle)) {
												flag = true;
											}
										}
									}
								}
							}
						}
					}
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	// This will click on Strategy Tab
	public boolean clickOnStrategyTab(String titleOfStrategyTab) throws Exception {
		boolean flag = false;
		String actualStrategyTabTitle = null;
		SeleniumUtils objSeleniumUtils;
		WebElement clickOnStrategyTab;
		try {
			objSeleniumUtils = new SeleniumUtils();
			if (SeleniumUtils.isElementPresent(driver, STRATEGY_TAB_TITLE)) {
				actualStrategyTabTitle = objSeleniumUtils.getTitleText(driver, STRATEGY_TAB_TITLE);
			}
			if (actualStrategyTabTitle.equalsIgnoreCase(actualStrategyTabTitle)) {
				clickOnStrategyTab = driver.findElement(STRATEGY_TAB_TITLE);
				SeleniumUtils.waitAndClick(driver, clickOnStrategyTab, 20);
				Thread.sleep(2000);
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyStrategyTabTitlePassed"),
						titleOfStrategyTab, actualStrategyTabTitle));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyStrategyTabTitleFailed"),
					titleOfStrategyTab, actualStrategyTabTitle));
			throw e;
		}
		return flag;
	}

	// This will click on AM Profile Tab
	public boolean clickOnAMProfileTab(String titleOfAMProfileTab) throws Exception {
		boolean flag = false;
		String actualAMProfileTabTitle = null;
		SeleniumUtils objSeleniumUtils;
		WebElement clickOnStrategyTab;
		try {
			objSeleniumUtils = new SeleniumUtils();
			if (SeleniumUtils.isElementPresent(driver, AMPROFILE_TAB_TITLE)) {
				actualAMProfileTabTitle = objSeleniumUtils.getTitleText(driver, AMPROFILE_TAB_TITLE);
			}
			if (actualAMProfileTabTitle.equalsIgnoreCase(titleOfAMProfileTab)) {
				clickOnStrategyTab = driver.findElement(AMPROFILE_TAB_TITLE);
				SeleniumUtils.waitAndClick(driver, clickOnStrategyTab, 20);
				Thread.sleep(2000);
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyAMProfileTabTitlePassed"),
						titleOfAMProfileTab, actualAMProfileTabTitle));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyAMProfileTabTitleFailed"),
					titleOfAMProfileTab, actualAMProfileTabTitle));
			throw e;
		}
		return flag;
	}

	// This will verify the diversified active title
	public boolean verifyDiversifiedActiveTitle(String diversifiedActiveTitle) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		String actualdiversifiedActiveTitle = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			if (SeleniumUtils.isElementPresent(driver, DIVERSIFIEDACTIVE_TITLE)) {
				actualdiversifiedActiveTitle = objSeleniumUtils.getTitleText(driver, DIVERSIFIEDACTIVE_TITLE);
			}
			if (actualdiversifiedActiveTitle.equalsIgnoreCase(diversifiedActiveTitle)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyDiversifiedActiveTitlePassed"),
						diversifiedActiveTitle, actualdiversifiedActiveTitle));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyDiversifiedActiveTitleFailed"),
					diversifiedActiveTitle, actualdiversifiedActiveTitle));
			throw e;
		}
		return flag;
	}

	// This will verify the diversified active title
	public boolean verifyExpertStrategyExplainsTitle(String expertStrategyExplainsTitle) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		String actualExpertStrategyExplainsTitle = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			SeleniumUtils.scrollToViewElement(driver, EXPERTSTRATEGYEXPLAINS_TITLE);
			Thread.sleep(1000);
			if (SeleniumUtils.isElementPresent(driver, EXPERTSTRATEGYEXPLAINS_TITLE)) {
				actualExpertStrategyExplainsTitle = objSeleniumUtils.getTitleText(driver, EXPERTSTRATEGYEXPLAINS_TITLE);
			}
			if (actualExpertStrategyExplainsTitle.equalsIgnoreCase(expertStrategyExplainsTitle)) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyExpertStrategyExplainsTitlePassed"),
								expertStrategyExplainsTitle, actualExpertStrategyExplainsTitle));
			}
		} catch (Exception e) {
			TestBase.logError(
					String.format(TestBase.properties.getLogMessage("VerifyExpertStrategyExplainsTitleFailed"),
							expertStrategyExplainsTitle, actualExpertStrategyExplainsTitle));
			throw e;
		}
		return flag;
	}

	/***
	 * This will get Tabs title which is present under DiversifiedActive
	 * 
	 * @return ArrayList<String>
	 * @throws Exception
	 * @author dheeraj.singh
	 */
	public ArrayList<String> getTabsTitlePresentUnderDiversifiedActive() throws Exception {
		ArrayList<String> arrayList = new ArrayList<String>();
		List<WebElement> element;
		try {
			element = driver.findElements(By.xpath("//div[@id='header']//table[2]//td//a"));
			int totalCount = element.size();
			for (int i = 1; i <= totalCount; i++) {
				String elementText = driver.findElement(By.xpath("//div[@id='header']//table[2]//td[" + i + "]//a"))
						.getText();
				arrayList.add(elementText);
			}
		} catch (Exception e) {
			throw e;
		}
		return arrayList;
	}

	/***
	 * This will verify the Asset Allocation title
	 * 
	 * @param assetAllocationTitle
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAssetAllocationTitle(String assetAllocationTitle) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		String actualassetAllocationTitleTitle = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			SeleniumUtils.scrollToViewElement(driver, ASSETALLOCATION_TITLE);
			Thread.sleep(1000);
			SeleniumUtils.scrollToViewElement(driver, ASSETALLOCATION_TITLE);
			if (SeleniumUtils.isElementPresent(driver, ASSETALLOCATION_TITLE)) {
				actualassetAllocationTitleTitle = objSeleniumUtils.getTitleText(driver, ASSETALLOCATION_TITLE);
			}
			if (actualassetAllocationTitleTitle.equalsIgnoreCase(assetAllocationTitle)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyAssetAllocationTitlePassed"),
						assetAllocationTitle, actualassetAllocationTitleTitle));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyAssetAllocationTitleFailed"),
					assetAllocationTitle, actualassetAllocationTitleTitle));
			throw e;
		}
		return flag;
	}

	/***
	 * This will verify the Marketing Materials title
	 * 
	 * @param marketingMaterialsTitle
	 * @return
	 * @throws Exception
	 */
	public boolean verifyMarketingMaterialsTitle(String marketingMaterialsTitle) throws Exception {
		boolean flag = false;
		SeleniumUtils objSeleniumUtils;
		String actualmarketingMaterialsTitle = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			SeleniumUtils.scrollToViewElement(driver, MARKETING_MATERIALS_TITLE);
			Thread.sleep(1000);
			SeleniumUtils.scrollToViewElement(driver, MARKETING_MATERIALS_TITLE);
			if (SeleniumUtils.isElementPresent(driver, MARKETING_MATERIALS_TITLE)) {
				actualmarketingMaterialsTitle = objSeleniumUtils.getTitleText(driver, MARKETING_MATERIALS_TITLE);
			}
			if (actualmarketingMaterialsTitle.equalsIgnoreCase(marketingMaterialsTitle)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyMarketingMaterialsTitlePassed"),
						marketingMaterialsTitle, actualmarketingMaterialsTitle));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyMarketingMaterialsTitleFailed"),
					marketingMaterialsTitle, actualmarketingMaterialsTitle));
			throw e;
		}
		return flag;
	}

	/***
	 * This will get Tabs title which is present under AssetAllocation
	 * 
	 * @return
	 * @throws Exception
	 * @author dheeraj.singh
	 */
	public ArrayList<String> getTabsTitlePresentUnderAssetAllocationTitle() throws Exception {
		ArrayList<String> arrayList = new ArrayList<String>();
		List<WebElement> element;
		try {
			element = driver.findElements(By.xpath("//div[@id='Objectives']/child::div/child::table//td//a"));
			int totalCount = element.size();
			for (int i = 1; i <= totalCount; i++) {
				String elementText = driver
						.findElement(By.xpath("//div[@id='Objectives']/child::div/child::table//td[" + i + "]//a"))
						.getText();
				arrayList.add(elementText);
			}
		} catch (Exception e) {
			throw e;
		}
		return arrayList;
	}

	/***
	 * This will verify the TagName of Each Button link which is present under
	 * Assert Allocation
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author dheeraj.singh
	 */
	public boolean getTagNameOfElementPresentUnderAssetAllocation(String tagName) throws Exception {
		boolean flag = false;
		List<WebElement> elements;
		try {
			elements = driver.findElements(By.xpath("//div[@id='Objectives']/child::div/child::table//td//a"));
			int totalCount = elements.size();
			for (int i = 1; i <= totalCount; i++) {
				String elementTagName = driver
						.findElement(By.xpath("//div[@id='Objectives']/child::div/child::table//td[" + i + "]//a"))
						.getTagName();
				if (tagName.equalsIgnoreCase(elementTagName)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	/***
	 * This will verify the Title of link present under Asset Allocation
	 * 
	 * @param cautiousTitle, moderatelyCautiousTitle, moderateTitle,
	 *        moderatelyAdventureTitle, adventurousTitle
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyTabsPresentUnderAssetAllocation(String cautiousTitle, String moderatelyCautiousTitle,
			String moderateTitle, String moderatelyAdventureTitle, String adventurousTitle, String tagNameOfLink)
			throws Exception {
		boolean flag = false;
		ArrayList<String> arrayListOfTabTitle = null;
		try {
			arrayListOfTabTitle = getTabsTitlePresentUnderAssetAllocationTitle();
			if (((arrayListOfTabTitle.contains(cautiousTitle) && arrayListOfTabTitle.contains(moderatelyCautiousTitle)
					&& arrayListOfTabTitle.contains(moderateTitle)
					&& arrayListOfTabTitle.contains(moderatelyAdventureTitle)
					&& arrayListOfTabTitle.contains(adventurousTitle))
					&& (getTagNameOfElementPresentUnderAssetAllocation(tagNameOfLink)))) {
				flag = true;
				TestBase.logInfo(
						String.format(TestBase.properties.getLogMessage("VerifyTitlesUnderAssetAllocationPassed"),
								tagNameOfLink, cautiousTitle, moderatelyCautiousTitle, moderateTitle,
								moderatelyAdventureTitle, adventurousTitle, arrayListOfTabTitle));
			}
		} catch (Exception e) {
			TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyTitlesUnderAssetAllocationFailed"),
					tagNameOfLink, cautiousTitle, moderatelyCautiousTitle, moderateTitle, moderatelyAdventureTitle,
					adventurousTitle, arrayListOfTabTitle));
			throw e;
		}
		return flag;
	}

	/***
	 * This will verify that each tabs present under Diversified Active
	 * 
	 * @param objectivesTitle
	 * @param overviewTitle
	 * @param insightsTitle
	 * @param assetAllocationTitle
	 * @param marketingMaterialsTitle
	 * @return boolean
	 * @throws Exception
	 * @author dheeraj.singh
	 */
	public boolean verifyTabsPresentUnderDiversifiedActive(String objectivesTitle, String overviewTitle,
			String insightsTitle, String assetAllocationTitle, String marketingMaterialsTitle) throws Exception {
		boolean flag = false;
		ArrayList<String> arrayList = null;
		try {
			arrayList = getTabsTitlePresentUnderDiversifiedActive();
			Thread.sleep(2000);
			if (arrayList.contains(objectivesTitle) && arrayList.contains(overviewTitle)
					&& arrayList.contains(insightsTitle) && arrayList.contains(assetAllocationTitle)
					&& arrayList.contains(marketingMaterialsTitle)) {
				flag = true;
				TestBase.logInfo(String.format(
						TestBase.properties.getLogMessage("VerifyTitlesUnderDiversifiedActivePassed"), objectivesTitle,
						overviewTitle, insightsTitle, assetAllocationTitle, marketingMaterialsTitle, arrayList));
			}
		} catch (Exception e) {
			TestBase.logInfo(String.format(
					TestBase.properties.getLogMessage("VerifyTitlesUnderDiversifiedActiveFailed"), objectivesTitle,
					overviewTitle, insightsTitle, assetAllocationTitle, marketingMaterialsTitle, arrayList));
			throw e;
		}
		return flag;
	}

	/***
	 * This will verify the details present in Strategy page
	 * 
	 * @param settingsTabText
	 * @param dropdownValue
	 * @param urlFractionValue
	 * @param expectedURL
	 * @param assetManagerNameValue
	 * @param pmConfigTitle
	 * @param titleOfStrategyTab
	 * @param diversifiedActiveTitle
	 * @param objectivesTitle
	 * @param overviewTitle
	 * @param insightsTitle
	 * @param assetAllocationTitle
	 * @param marketingMaterialsTitle
	 * @param expertStrategyExplainsTitle
	 * @param assetAllocationTitleText
	 * @param cautiousTitle
	 * @param moderatelyCautiousTitle
	 * @param moderateTitle
	 * @param moderatelyAdventureTitle
	 * @param adventurousTitle
	 * @param tagNameOfLink
	 * @param marketingMaterialsTitleText
	 * @return boolean
	 * @throws Exception
	 * @author dheeraj.singh
	 */
	public boolean verifyDetailsPresentOnStrategyPage(String settingsTabText, String dropdownValue,
			String urlFractionValue, String expectedURL, String assetManagerNameValue, String pmConfigTitle,
			String titleOfStrategyTab, String diversifiedActiveTitle, String objectivesTitle, String overviewTitle,
			String insightsTitle, String assetAllocationTitle, String marketingMaterialsTitle,
			String expertStrategyExplainsTitle, String cautiousTitle, String moderatelyCautiousTitle,
			String moderateTitle, String moderatelyAdventureTitle, String adventurousTitle, String tagNameOfLink)
			throws Exception {
		boolean flag = false;
		try {
			Thread.sleep(3000);
			if (clickOnSettingsTab(settingsTabText)) {
				if (verifyPortfolioModelConfigurationDropDownValue(dropdownValue)) {
					if (verifyPMConfigurationPageOpened(urlFractionValue, expectedURL)) {
						if (verifyPMConfigurationTitle(pmConfigTitle)) {
							if (verifyGlobalFilterTextBox(assetManagerNameValue)) {
								if (clickOnSearchPlusButton()) {
									Thread.sleep(2000);
									if (clickOnStrategyTab(titleOfStrategyTab)) {
										if (verifyDiversifiedActiveTitle(diversifiedActiveTitle)) {
											if (verifyTabsPresentUnderDiversifiedActive(objectivesTitle, overviewTitle,
													insightsTitle, assetAllocationTitle, marketingMaterialsTitle)) {
												if (verifyExpertStrategyExplainsTitle(expertStrategyExplainsTitle)) {
													if (verifyAssetAllocationTitle(assetAllocationTitle)) {
														if (verifyTabsPresentUnderAssetAllocation(cautiousTitle,
																moderatelyCautiousTitle, moderateTitle,
																moderatelyAdventureTitle, adventurousTitle,
																tagNameOfLink)) {
															if (verifyMarketingMaterialsTitle(
																	marketingMaterialsTitle)) {
																flag = true;
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	private final By OUR_WEBSITE_LINK = By
			.xpath("//a[@class='buttonGetInvested']//span[@class='buttonGetInvestedText']");
	private final By MORNINGSTAR_TITLE = By.xpath("//h1[@class='_14i3z6h']//div");

	/***
	 * This will verify the link of Our WebSite in AM profile page
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyOurWebSiteLink() throws Exception {
		SeleniumUtils objSeleniumUtils;
		boolean flag = false;
		try {
			objSeleniumUtils = new SeleniumUtils();
			if (objSeleniumUtils.isElementDisplayed(driver, OUR_WEBSITE_LINK)) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyOurWebSiteLinkPassed")));
			}
		} catch (Exception e) {
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyOurWebSiteLinkFailed")));
			throw e;
		}
		return flag;
	}

	/***
	 * This will verify morningStar title in the page
	 * 
	 * @param morningStarTitle
	 * @return
	 * @throws Exception
	 */
	public boolean verifyMorningStarTitle(String morningStarTitle) throws Exception {
		boolean flag = false;
		String actualMorningStarTitle = null;
		SeleniumUtils objSeleniumUtils;
		String expectedMorningStarTitle = null;
		try {
			objSeleniumUtils = new SeleniumUtils();
			expectedMorningStarTitle=morningStarTitle.toLowerCase();
			if (SeleniumUtils.isElementPresent(driver, MORNINGSTAR_TITLE)) {
				actualMorningStarTitle = objSeleniumUtils.getTitleText(driver, MORNINGSTAR_TITLE).toLowerCase();
			}
			if (actualMorningStarTitle.equalsIgnoreCase(morningStarTitle.toLowerCase())) {
				flag = true;
				TestBase.logInfo(String.format(TestBase.properties.getLogMessage("VerifyMorningStarTitlePassed"),
						expectedMorningStarTitle, actualMorningStarTitle));
			}
		} catch (Exception e) {
			flag = true;
			TestBase.logError(String.format(TestBase.properties.getLogMessage("VerifyMorningStarTitleFailed"),
					expectedMorningStarTitle, actualMorningStarTitle));
			throw e;
		}
		return flag;
	}

	// This will verify the details present in AM Profile page

	public boolean verifyDetailsPresentOnAMProfilePage(String settingsTabText, String dropdownValue,
			String urlFractionValue, String expectedURL, String assetManagerNameValue, String pmConfigTitle,
			String titleOfAMProfileTab) throws Exception {
		boolean flag = false;
		try {
			Thread.sleep(3000);
			if (clickOnSettingsTab(settingsTabText)) {
				if (verifyPortfolioModelConfigurationDropDownValue(dropdownValue)) {
					if (verifyPMConfigurationPageOpened(urlFractionValue, expectedURL)) {
						if (verifyPMConfigurationTitle(pmConfigTitle)) {
							if (verifyGlobalFilterTextBox(assetManagerNameValue)) {
								if (clickOnSearchPlusButton()) {
									Thread.sleep(2000);
									if (clickOnAMProfileTab(titleOfAMProfileTab)) {
										if (verifyMorningStarTitle(assetManagerNameValue)) {
											if (verifyOurWebSiteLink()) {
												flag=true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

}
