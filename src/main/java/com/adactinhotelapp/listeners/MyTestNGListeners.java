package com.adactinhotelapp.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.adactinhotelapp.base.Page;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.adactinhotelapp.base.Page;

public class MyTestNGListeners extends Page implements ITestListener{

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("***************Test Passes "+result.getName());
		
		ExtentTest test=(ExtentTest)result.getTestContext().getAttribute("test");
		
		test.log(Status.PASS, result.getName()+" --- Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("***************Test Failed "+result.getName());
		
		System.out.println(result.getThrowable().getMessage());;
		
		ExtentTest test=(ExtentTest)result.getTestContext().getAttribute("test");
		
		test.log(Status.FAIL, result.getThrowable().getMessage());
	
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("***************Test Skipped "+result.getName());
		
		ExtentTest test=(ExtentTest)result.getTestContext().getAttribute("test");
		
		test.log(Status.SKIP, result.getName()+" --- Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

	
	
	
}
