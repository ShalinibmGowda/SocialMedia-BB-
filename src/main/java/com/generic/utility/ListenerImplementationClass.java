package com.generic.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener{
   public static ExtentReports report;
   public static ExtentTest test;
    
	public void onTestStart(ITestResult result) {
		//Execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"------>Testscript execution started");
		test.log(Status.INFO, MethodName+"---->testscript execution start");

	}

	public void onTestSuccess(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"------>Passed");
		Reporter.log(MethodName+"----->Testscript execution successfully");

	}

	public void onTestFailure(ITestResult result) {
		
		String FailedScript = result.getMethod().getMethodName();
		
		String fs = FailedScript + new JavaUtility().getSystemDateAndTimeInFormate();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File path = new File("./ScreenShot/"+fs+".png");
		String filepath = path.getAbsolutePath();
		try {
			FileUtils.copyFile(src, path);
		}
	catch(Exception e)
		{
		e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath);
		test.log(Status.FAIL,result.getThrowable()+"--Test script execution failed--");
		Reporter.log("--test script Execution failed");
	}

	public void onTestSkipped(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName(); 
		test.log(Status.SKIP, MethodName+"------>skipped");
		Reporter.log("---TestScript Execution skipped--");

	}

	public void onStart(ITestContext context) {
		//configure the report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-45 Extent Report");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("BIOBOOK report");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-URL", " http://rmgtestingserver/domain/Bio_Book/");
		report.setSystemInfo("Reporter Name", "Shalini");
		
		ITestNGMethod[] allMethodName=context.getAllTestMethods();
		String methodname = allMethodName.toString();
		test=report.createTest(methodname);

	}

	public void onFinish(ITestContext context) {
		//consolidated the report
		report.flush();

	}
	

}
