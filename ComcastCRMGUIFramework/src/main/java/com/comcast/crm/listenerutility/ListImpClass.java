package com.comcast.crm.listenerutility;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImpClass implements ITestListener,ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		System.out.println("report configuration");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("======"+result.getMethod().getMethodName()+"====Start=====");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("======"+result.getMethod().getMethodName()+"====end=====");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		//screenshot syntax
	
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

}
