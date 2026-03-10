package com.framework.reports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	 private static ExtentReports extent;

	    public static ExtentReports getInstance() {
	        if (extent == null) {
	        	String reportDir = System.getProperty("user.dir") + "/reports";
	        	File dir = new File(reportDir);

	        	if (!dir.exists()) {
	        	    dir.mkdirs();
	        	}

	        	String reportPath = reportDir + "/ExtentReport.html";
	            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
	            sparkReporter.config().setReportName("Automation Test Report");
	            sparkReporter.config().setDocumentTitle("Execution Report");

	            extent = new ExtentReports();
	            extent.attachReporter(sparkReporter);
	            extent.setSystemInfo("Framework", "Spring Boot + Selenium + TestNG");
	            extent.setSystemInfo("Tester", "Subhrata");
	        }
	        return extent;
	    }

}
