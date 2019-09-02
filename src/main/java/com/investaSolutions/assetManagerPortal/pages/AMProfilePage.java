package com.investaSolutions.assetManagerPortal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.investaSolutions.base.TestBase;
import com.investaSolutions.utils.PropertiesManager;
import com.investaSolutions.utils.SeleniumUtils;

public class AMProfilePage {

	private WebDriver driver;
	public static PropertiesManager properties = PropertiesManager.getInstance();
	
	public AMProfilePage (WebDriver driver) {
		this.driver = driver;
	}
	private final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));
	
	private final By ASSET_MANAGER_TAB = By.xpath("//span[text()='Asset Manager']");
	private final By PROFILE_LINK = By.xpath("//a[contains(@href,'profile')]");
	
	private final By NAME_TEXT = By.xpath("//label[text()='Name']");
	private final By DESCRIPTION_TEXT = By.xpath("//label[text()='Description']");
	private final By WEBSITEURL_TEXT = By.xpath("//label[text()='WebSite Url']");
	
	private final By NAME_TEXTBOX = By.xpath("(//div[@class='ui-g ui-fluid'])[1]/div[2]/span/input[1]");
	private final By DISCRIPTION_TEXTBOX = By.xpath("//span[@class='md-inputfield']/textarea");
	private final By WEBSITE_URL_TEXTBOX = By.xpath("(//div[@class='ui-g ui-fluid'])[3]/div[2]/span/input[1]");
	private final By UPLOAD_LOGO_BUTTON = By.xpath("//div[@class='ui-g-12 profile-containter']/div/div/span/div/p-fileupload");
	
	private final By PREVIEW_BUTTON = By.xpath("//span[text()='Preview']");
	private final By ADD_PROFILE_STATISTICS_ICON = By.xpath("//div[@class='info-items']//div/div/button[1]");
	private final By REMOVE_PROFILE_STATISTICS_ICON = By.xpath("//div[@class='info-items']//div/div/button[2]");
	
	private final By ADD_PROFILE_SECTION_ICON = By.xpath("(//div[@class='ui-g-12'])[2]//div/div/button[1]");
	private final By REMOVE_PROFILE_SECTION_ICON = By.xpath("(//div[@class='ui-g-12'])[2]//div/div/button[2]");
	
	private final By UPLOAD_SECTION_IMAGE_BUTTON = By.xpath("//*[@chooselabel='Upload Section Image']");
	private final By CANCEL_BUTTON = By.xpath("//span[text()='Cancel']");
	private final By SAVE_BUTTON = By.xpath("//span[text()='Save']");
	
	
	
	
	public String getNameText(){
		return SeleniumUtils.waitForElementPresence(driver, NAME_TEXT, WAIT_SECONDS).getText();
	}
	
    public String getDescriptionText(){
    	return SeleniumUtils.waitForElementPresence(driver, DESCRIPTION_TEXT, WAIT_SECONDS).getText();
	}

    public String getWebSiteURLText(){
    	return SeleniumUtils.waitForElementPresence(driver, WEBSITEURL_TEXT, WAIT_SECONDS).getText();
    }
	
	public void clickAssetManagerTab() {
		SeleniumUtils.waitForElementClickable(driver, ASSET_MANAGER_TAB, WAIT_SECONDS).click();
	}
	
	public void clickProfileLink() throws InterruptedException {
		SeleniumUtils.waitForElementClickable(driver, PROFILE_LINK, WAIT_SECONDS).click();
		
	}
	
	public boolean verifyDetailsOnProfilePage(String nameText,String descriptionText,String webSiteURLText) throws Exception{
		try{
			boolean flag=false;
			clickAssetManagerTab();
			clickProfileLink();
			String name=getNameText();
			String discription=getDescriptionText();
			String websiteurl=getWebSiteURLText();
			if(SeleniumUtils.isElementPresent(driver, NAME_TEXTBOX) &&
					SeleniumUtils.isElementPresent(driver, DISCRIPTION_TEXTBOX) &&
					SeleniumUtils.isElementPresent(driver, WEBSITE_URL_TEXTBOX) &&
					SeleniumUtils.isElementPresent(driver, UPLOAD_LOGO_BUTTON) &&
					SeleniumUtils.isElementPresent(driver, PREVIEW_BUTTON) &&
					SeleniumUtils.isElementPresent(driver, ADD_PROFILE_STATISTICS_ICON) &&
					SeleniumUtils.isElementPresent(driver, REMOVE_PROFILE_STATISTICS_ICON) &&
					SeleniumUtils.isElementPresent(driver, ADD_PROFILE_SECTION_ICON) &&
					SeleniumUtils.isElementPresent(driver, REMOVE_PROFILE_SECTION_ICON) &&
					SeleniumUtils.isElementPresent(driver, UPLOAD_SECTION_IMAGE_BUTTON) && 
					SeleniumUtils.isElementPresent(driver, CANCEL_BUTTON) &&
					SeleniumUtils.isElementPresent(driver, SAVE_BUTTON) && 
					name.equals(nameText) && 
					discription.equals(descriptionText) && 
					websiteurl.equals(webSiteURLText)){
				flag=true;
				TestBase.logInfo(properties.getLogMessage("DetaisOfProfilePage"));
			}else{
				TestBase.logError(properties.getLogMessage("SomeDetailsIsNotPresentOnProfilePage"));
			}
			return flag;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
