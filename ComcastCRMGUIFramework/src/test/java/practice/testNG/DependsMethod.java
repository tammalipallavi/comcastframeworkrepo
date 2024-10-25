package practice.testNG;

import org.testng.annotations.Test;

public class DependsMethod {

	
		@Test
		public void creatContactTest(){
			System.out.println("execute create contact test");
			
		}
		@Test(dependsOnMethods = "creatContactTest")
		public void creatContactTestwithmobileNumberTest(){
			System.out.println("execute create contact test with phone number");
			
			

	}

}
