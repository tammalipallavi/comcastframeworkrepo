package pomImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility1.ExcelUtility;
import com.comcast.crm.generic.fileutility1.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrgWithPhoneNumberPomImplementation {
	public static void main(String[] args) throws Throwable {
		FileUtility FLib=new FileUtility();
		  ExcelUtility ELib=new ExcelUtility();
		  JavaUtility JLib=new JavaUtility();
		  WebDriverUtility wLib=new WebDriverUtility();
		
		
		  String BROWSER = FLib.getDataFromPropertiesFile("browser");
		  String URL =FLib.getDataFromPropertiesFile("url");
		  String USERNAME =FLib.getDataFromPropertiesFile("username");
		  String PASSWORD =FLib.getDataFromPropertiesFile("password");
		  
		  
			
		   //Read TestScriptData from excel file
		  String orgName =ELib.getDataFromExcel("org", 7, 2)+JLib.getRandomNumber();		
		  String phoneNumber =ELib.getDataFromExcel("org", 7, 3);		

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
	 driver.findElement(By.id("phone")).sendKeys(phoneNumber);
	 driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	 

	 
	//verify header msg info expected result
	 String actphonenum=driver.findElement(By.id("dtlview_Phone")).getText();
	 if(actphonenum.contains(phoneNumber)) {
		 System.out.println(phoneNumber+ "is created===>pass");
	 }else {
		 System.out.println(phoneNumber+ "is not created===>fail");
		 
	 }
	
	 driver.quit();
		

}

}





