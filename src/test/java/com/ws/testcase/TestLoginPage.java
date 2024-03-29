package com.ws.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseTest {
	
	@Test(priority = 1)
	public void testLoginPageTitle()
	{
		logger = report.createTest("Test Login Page");
		homePage.clickLoginLink();
		logger.pass("clicked login link");
		String title = loginPage.getLoginPageTitle();
		logger.pass("get the login page title");
		System.out.println("Page title : "+title);
		Assert.assertTrue(title.contains("Login"));
		logger.pass("login page verification successfull");
	}
	
	@Test(priority = 2)
	public void testLoginFunction()
	{
		logger = report.createTest("Test Login Function");
		homePage.clickLoginLink();
		logger.pass("clicked login link");
		loginPage.enterEmail("selauto1@test.com");
		logger.pass("entered username");
		loginPage.enterPassword("Pass@123");
		logger.pass("entered password");
		loginPage.clickLoginButton();
		logger.pass("clicked login button");
		boolean flag = homePage.isLogoutLinkDisplayed();
		Assert.assertTrue(flag);
		homePage.clickLogout();
		logger.pass("login successfull");
	}
	
	@Test(priority = 1)
	public void testForgotPasswordDisplayed()
	{
		logger = report.createTest("Test Forgot password link is displayed");
		homePage.clickLoginLink();
		logger.pass("clicked login link");
		boolean flag = loginPage.isForgotPasswordLinkDisplayed();
		Assert.assertTrue(flag);
		logger.pass("forgot password link is displayed");
	}

}







