package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility1.ExcelUtility;
import com.comcast.crm.generic.fileutility1.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrganizationTest {
	public static void main(String[] args) throws Throwable {
		 FileUtility FLib=new FileUtility();
		  ExcelUtility ELib=new ExcelUtility();
		  JavaUtility JLib=new JavaUtility();
		  WebDriverUtility wLib=new WebDriverUtility();
		
		
		  
		  String BROWSER =FLib.getDataFromPropertiesFile("browser"); 
		  String URL =FLib.getDataFromPropertiesFile("url");
		  String USERNAME =FLib.getDataFromPropertiesFile("username");
		  String PASSWORD =FLib.getDataFromPropertiesFile("password");
		  
		  
		   //Read TestScriptData from excel file
		  String orgName =ELib.getDataFromExcel("org", 1, 2)+JLib.getRandomNumber();		

	//polymorphism program if we change browser 	 
		  
			WebDriver driver=null;
		  if(BROWSER.equals("chrome")) {
			  driver=new ChromeDriver();
		  }else if(BROWSER.equals("firefox")) {
				  driver=new FirefoxDriver();
		  }else if(BROWSER.equals("edge")) {
					  driver=new EdgeDriver();
		  }else {
			  driver=new ChromeDriver();
	
		  }
	//login to app
	
	 driver.manage().window().maximize();
	 wLib.waitforPageToLoad(driver);
	 driver.get(URL);
	 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	 driver.findElement(By.id("submitButton")).click();
	 //step 2:navigate to organization module
	  
	 driver.findElement(By.linkText("Organizations")).click();
	 
	 //step 3:click on create organization button
	 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	 
	 //step 4:enter all the details and create new Organization
	 driver.findElement(By.name("accountname")).sendKeys(orgName);
	 
	 driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	 
//verify expected result
	 String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	 
	 if(headerinfo.contains(orgName)) {
		 System.out.println(orgName+ "is created===>pass");
	 }else {
		 System.out.println(orgName+ "is not created===>fail");
		 
	 }
	//verify org info
String actOrgName= driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
	 
	 if(actOrgName.contains(orgName)) {
		 System.out.println(orgName+ "is created===>pass");
	 }else {
		 System.out.println(orgName+ "is not created===>fail");
		 
	 }
	 driver.quit();
		

}

}






