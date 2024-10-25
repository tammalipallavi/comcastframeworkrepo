package comcast.package1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class CreateTestContact extends BaseClass {
	
	@Test
	public void createContact() {
		System.out.println("execute create contact");
	}@Test
	public void createContactwithdate() {
		System.out.println("execute create contactwith date");
	}
	
}
