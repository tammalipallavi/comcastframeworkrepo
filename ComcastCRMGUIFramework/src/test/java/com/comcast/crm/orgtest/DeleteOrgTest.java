package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility1.ExcelUtility;
import com.comcast.crm.generic.fileutility1.FileUtility;
import com.comcast.crm.generic.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.LoginPage;
import com.comcast.crm.generic.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.generic.objectrepositoryutility.Organizationspage;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class DeleteOrgTest {
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
    String orgName =ELib.getDataFromExcel("org", 10, 2)+JLib.getRandomNumber();		

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
	
	 
	
	 wLib.waitforPageToLoad(driver);
	 driver.get(URL);
	 //navigate to page
	 LoginPage lp=new LoginPage(driver);
	 lp.logintoapp("http://localhost:8888/","admin","admin");
	 //navigate to org module
	 HomePage op=new HomePage (driver);
	 op.getOrgLink().click();
	// op.navigateToCampaignPage();//business method

	 //click on new org button
	 Organizationspage nop = new Organizationspage(driver);
	 nop.getCreateNewOrgBtn().click();
	 
	 
	 //step4:enter all the details and create new organization
	 CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
	 
	 cnop.createOrg(orgName);
	 //verify Header msg Expected result
	 OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	 
	 String actOrgName=oip.getHeaderMsg().getText();
	 
	 if(actOrgName.contains(orgName)) {
		 System.out.println(orgName+ "is created===>pass");
	 }else {
		 System.out.println(orgName+ "is not created===>fail");
		 
	 }
	 
	 //go back to organizations page
	 op.getOrgLink().click();
	 // search for organization
	 nop.getSearchEdt().sendKeys(orgName);
	 wLib.select(nop.getSearchDD(), "Organization Name");
	 nop.getSearchBtn().click();
	 //in dynamic webtable selact and delete org
	 driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
	 
	 //logout
	// op.logout();
	// driver.quit();
	 
		

}


}
