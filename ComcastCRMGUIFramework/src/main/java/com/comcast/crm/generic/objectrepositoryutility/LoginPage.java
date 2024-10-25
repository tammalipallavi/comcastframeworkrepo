package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {  //Rule 1 create a separate java class
	         
	                                               //Rule 2 Object(element) Creation
	
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		//Rule3 Object Initialization
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;

	@FindBy(name="user_password")
	private WebElement passwordEdt;

	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Rule 4 Object encapsulation
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
//Rule 5 :provide Action
	public void logintoapp( String url,String username,String password) {
		waitforPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		
		
	}
	
	
	
}
