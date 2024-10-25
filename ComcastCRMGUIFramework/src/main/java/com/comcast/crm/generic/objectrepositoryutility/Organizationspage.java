package com.comcast.crm.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationspage {
	WebDriver driver;
	public Organizationspage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy (name="submit")
	private WebElement searchBtn;
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	public WebElement getSearchDD() {
		return searchDD;
	}

	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

}
