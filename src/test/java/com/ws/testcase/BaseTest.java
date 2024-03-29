package com.ws.testcase;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LoginPage;
import com.ws.utils.Helper;

public class BaseTest extends DriverScript {
	
	protected static ExtentTest logger;
	protected static ExtentReports report;
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeSuite
	public void setUpReport()
	{
		ExtentHtmlReporter extent = new ExtentHtmlReporter("./testreport/wsreport.html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeMethod
	public void setUp()
	{
		initApplication();
		homePage = new HomePage();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				logger.fail("Test Failed",
						MediaEntityBuilder.createScreenCaptureFromPath
						(Helper.captureScreen(driver)).build());
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		report.flush();
		Thread.sleep(4000);
		quitDriver();
	}

}
