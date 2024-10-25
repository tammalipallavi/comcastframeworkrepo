package practice.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class ListenerInvoiceTest extends BaseClass{
	@Test
	public void createinvoicetest() {
		System.out.println("execute create invoice test");
		//String actTitle=driver.getTitle();
		//Assert.assertEquals(actTitle, Login);
		System.out.println("step 1");
		System.out.println("Step 2");
		System.out.println("step 3");
		System.out.println("step 4");
		
	}
	@Test
	public void createinvoicewithContactTest() {
		System.out.println("execute create invoice test with contact");
		System.out.println("step 1");
		System.out.println("Step 2");
		System.out.println("step 3");
		System.out.println("step 4");
		
	}
	

}
