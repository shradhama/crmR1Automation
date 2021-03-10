package crmframework.crmAutomation;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtendReporterNG;

public class TestListeners implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent = ExtendReporterNG.getReportObject();
	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		test.fail(arg0.getThrowable());
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		test = extent.createTest(arg0.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");
	}

}
