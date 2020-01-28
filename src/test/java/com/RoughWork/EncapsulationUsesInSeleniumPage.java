package com.RoughWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EncapsulationUsesInSeleniumPage {

	
	private String url = "http://somedomain.com/myTest.html";
	
	@FindBy(how=How.XPATH, using="uname")
	private WebElement userName;
	
	@FindBy(how=How.XPATH, using="pass001")
	private WebElement password;
	
	@FindBy(how=How.XPATH, using="logButton")
	private WebElement loginButton;
	
	WebDriver driver;
	public EncapsulationUsesInSeleniumPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getUserName() {
		return userName;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void getPage()
	{
		driver.get(url);
	}
	
	
	
}
