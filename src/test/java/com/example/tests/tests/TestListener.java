package com.example.tests.tests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.framework.reports.ExtentManager;
import com.framework.utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {
	private static final ThreadLocal<ExtentTest> extentTest= new ThreadLocal();
	

			@Override
			public void onStart(ITestContext context) {
				ExtentManager.getInstance();
	    	}

		    @Override
		    public void onTestStart(ITestResult result) {
		        ExtentTest test = ExtentManager.getInstance().createTest(result.getMethod().getMethodName());
		        System.out.println("Test: "+test);
		        extentTest.set(test);
		        extentTest.get().log(Status.INFO, "Test started: " + result.getMethod().getMethodName());
		    }

		    @Override
		    public void onTestSuccess(ITestResult result) {
		        extentTest.get().log(Status.PASS, "Test passed");
		    }

		    @Override
		    public void onTestFailure(ITestResult result) {
		        extentTest.get().log(Status.FAIL, "Test failed: " + result.getThrowable());

		        String screenshotPath = ScreenshotUtils.captureScreenshot(result.getMethod().getMethodName());

		        try {
		            extentTest.get().addScreenCaptureFromPath(screenshotPath);
		        } catch (Exception e) {
		            extentTest.get().log(Status.WARNING, "Unable to attach screenshot: " + e.getMessage());
		        }
		    }

		    @Override
		    public void onTestSkipped(ITestResult result) {
		        extentTest.get().log(Status.SKIP, "Test skipped: " + result.getThrowable());
		    }

		    @Override
		    public void onFinish(ITestContext context) {
		        ExtentManager.getInstance().flush();
		    }
	

}
