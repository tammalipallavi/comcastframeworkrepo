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

public class CreateContactWithSupportDatePomImplementation {
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
		
		  String LastName =ELib.getDataFromExcel("contact", 4, 2)+JLib.getRandomNumber();	
			

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
	  
	 driver.findElement(By.linkText("Contacts")).click();
	 
	 //step 3:click on create contact button
	 driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	 
	 //step 4:enter all the details and create new contact
	 
	String StartDate=JLib.getSystemDateYYYYDDMM();
	String endDate=JLib.getRequiredDateYYYYDDMM(30);
		
		
	 driver.findElement(By.name("lastname")).sendKeys(LastName);
	 driver.findElement(By.name("support_start_date")).clear();
	 driver.findElement(By.name("support_start_date")).sendKeys(StartDate);
	 
	 driver.findElement(By.name("support_end_date")).clear();
	 driver.findElement(By.name("support_end_date")).sendKeys(endDate);
	 
	 driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	 
//verify start date and end date expected result

String actStartDate=driver.findElement(By.xpath("//span[@id='dtlview_Support Start Date']")).getText();
	 
	 if(actStartDate.equals(StartDate)) {
		 System.out.println(StartDate+ "is created===>pass");
	 }else {
		 System.out.println(StartDate+ "is not created===>fail");
		 
	 }
String actendDate=driver.findElement(By.xpath("//span[@id='dtlview_Support End Date']")).getText();
	 
	 if(actendDate.equals(endDate)) {
		 System.out.println(endDate+ "is created===>pass");
	 }else {
		 System.out.println(endDate+ "is not created===>fail");
		 
	 }
	
	 driver.quit();
		

}

}



