package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility1.ExcelUtility;
import com.comcast.crm.generic.fileutility1.FileUtility;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.LoginPage;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class BaseClass {
	/*create Object*/
	
	  public DataBaseUtility dbLib =new DataBaseUtility();
	  public FileUtility FLib=new FileUtility();
	  public ExcelUtility ELib=new ExcelUtility();
	  public JavaUtility JLib=new JavaUtility();
	  
	  
	  public WebDriver driver=null;
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("====connect to DB Report Config====");
		dbLib.getDBConnection();
	}
	
	@BeforeClass
	public void conficBC() throws Throwable {
		System.out.println("====launch the browser=====");
		String BROWSER = FLib.getDataFromPropertiesFile("browser");
		if(BROWSER.equals("chrome")) {
			  driver=new ChromeDriver();
		  }else if(BROWSER.equals("firefox")) {
				  driver=new FirefoxDriver();
		  }else if(BROWSER.equals("edge")) {
					  driver=new EdgeDriver();
		  }else {
			  driver=new FirefoxDriver();
	
		  }
	}
	
	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("==login==");
		String URL=FLib.getDataFromPropertiesFile("url");
		String USERNAME=FLib.getDataFromPropertiesFile("username");
		String PASSWORD=FLib.getDataFromPropertiesFile("password");
		
		
		LoginPage lp=new LoginPage(driver);
		lp.logintoapp(URL, USERNAME, PASSWORD);
	}
	@AfterMethod
	public void configAM() {
		System.out.println("===logout===");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	@AfterClass
	public void conficAC() {
		System.out.println("====close the browser====");
		driver.quit();
	}
	@AfterSuite
	public void configAS() throws SQLException {
		System.out.println("=====close DB,Report BackUp====");
		dbLib.closeDBconnection();
	}

}
