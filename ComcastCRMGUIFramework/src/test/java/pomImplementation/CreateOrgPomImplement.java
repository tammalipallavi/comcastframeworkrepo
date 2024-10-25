package pomImplementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility1.ExcelUtility;
import com.comcast.crm.generic.fileutility1.FileUtility;
import com.comcast.crm.generic.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.LoginPage;
import com.comcast.crm.generic.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.generic.objectrepositoryutility.Organizationspage;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrgPomImplement extends BaseClass{
	@Test
	public void createorgTest() throws Throwable {
		
	
		  //Read TestScriptData from excel file
     String orgName =ELib.getDataFromExcel("org", 1, 2)+JLib.getRandomNumber();		

	 
	 //navigate to org module
	 HomePage hp=new HomePage (driver);
	 hp.getOrgLink().click();
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
	 
	// if(actOrgName.contains(orgName)) {
		// System.out.println(orgName+ "is created===>pass");
	 //}else {
		 //System.out.println(orgName+ "is not created===>fail");
	 
		 
	 }
	 
		

}





