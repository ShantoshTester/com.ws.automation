package com.ws.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseTest {
	
	@Test(priority = 1)
	public void testLoginPageTitle()
	{
		homePage.clickLoginLink();
		String title = loginPage.getLoginPageTitle();
		System.out.println("Page title : "+title);
		Assert.assertTrue(title.contains("Login"));
	}
	
	@Test(priority = 2)
	public void testLoginFunction()
	{
		homePage.clickLoginLink();
		loginPage.enterEmail("selauto1@test.com");
		loginPage.enterPassword("Pass@123");
		loginPage.clickLoginButton();
		boolean flag = homePage.isLogoutLinkDisplayed();
		Assert.assertTrue(flag);
		homePage.clickLogout();
	}
	
	@Test(priority = 3)
	public void testForgotPasswordDisplayed()
	{
		homePage.clickLoginLink();
		boolean flag = loginPage.isForgotPasswordLinkDisplayed();
		Assert.assertTrue(flag);
	}

}







