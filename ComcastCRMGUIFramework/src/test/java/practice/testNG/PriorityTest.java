package practice.testNG;

import org.testng.annotations.Test;

public class PriorityTest {
@Test(priority=1)
public void creatContactTest(){
	System.out.println("execute create contact test");
	
}
@Test(priority =-3)
public void creatContactTestwithmobileNumberTest(){
	System.out.println("execute create contact test with phone number");
	
	
}
}
