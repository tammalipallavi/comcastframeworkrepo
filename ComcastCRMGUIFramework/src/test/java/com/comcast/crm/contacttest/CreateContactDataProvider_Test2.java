package com.comcast.crm.contacttest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactDataProvider_Test2 {

	@Test(dataProvider ="getData")
	public void createcontacttest(String firstName,String lastName,long phoneNumber) {
		System.out.println("FirstName :"+firstName+ ",LastName:"+lastName +",phoneNumber :"+phoneNumber);
		
}
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][3];
		
		objArr[0][0]="Pallavi";
		objArr[0][1]="T";
		objArr[0][2]=9676494988l;
		
		objArr[1][0]="Aadya";
		objArr[1][1]="TA";
		objArr[1][2]=9565656990l;
		
		objArr[2][0]="Advaita";
		objArr[2][1]="t";
		objArr[2][2]=9898989890l;
		
		return objArr;
	}
	

}
