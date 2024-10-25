package practice.testNG;

import org.testng.annotations.Test;

public class InvocationCount {
	@Test(invocationCount =5)
	public void creatContactTest(){
		System.out.println("execute create contact test");
		
	}
	@Test(invocationCount = 2)
	public void creatContactTestwithmobileNumberTest(){
		System.out.println("execute create contact test with phone number");
		
		
	}

}
