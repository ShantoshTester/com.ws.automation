package com.ws.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPasswordRecoveryPage extends BaseTest {
	
	@Test(priority = 1)
	public void testPasswordRecoverPage()
	{
		logger = report.createTest("Test Password Recovery Page");
		homePage.clickLoginLink();
		logger.pass("clicked login link");
		boolean flag = loginPage.isForgotPasswordLinkDisplayed();
		Assert.assertTrue(flag);
		logger.pass("forgot password link is displayed");
		loginPage.clickForgotPasswordLink();
		logger.pass("clicked on forgot password link");
		boolean flag1 = passwordRecoveryPage.isPasswordRecoveryDisplayed();
		Assert.assertTrue(flag1);
		logger.pass("Password recovery text is present");
		String actual = passwordRecoveryPage.getPasswordRecoveryText();
		System.out.println(actual);
		Assert.assertTrue(actual.contains("recovery"));
		logger.pass("Recovery text validated");
	}
	
	@Test(priority = 2)
	public void testInvalidEmailAddress()
	{
		logger = report.createTest("Test Invalid Email Address");
		homePage.clickLoginLink();
		logger.pass("clicked login link");
		boolean flag = loginPage.isForgotPasswordLinkDisplayed();
		Assert.assertTrue(flag);
		logger.pass("forgot password link is displayed");
		loginPage.clickForgotPasswordLink();
		logger.pass("clicked on forgot password link");
		boolean flag1 = passwordRecoveryPage.isPasswordRecoveryDisplayed();
		Assert.assertTrue(flag1);
		logger.pass("Password recovery text is present");
		
		passwordRecoveryPage.enterUserEmail("abcd");
		logger.pass("entered invalid address");
		
		passwordRecoveryPage.clickRecoverButton();
		logger.pass("clicked recover button");
		
		String wrongEmailText = passwordRecoveryPage.getWrongEmailMsg();
		System.out.println(wrongEmailText);
		Assert.assertTrue(wrongEmailText.contains("Shantosh"));
		logger.pass("verified the wrong email message successfully");
	}
	
	@Test(priority = 3)
	public void testValidEmailRecovery()
	{
		logger = report.createTest("Test Valid Email Address Password Recovery");
		homePage.clickLoginLink();
		logger.pass("clicked login link");
		boolean flag = loginPage.isForgotPasswordLinkDisplayed();
		Assert.assertTrue(flag);
		logger.pass("forgot password link is displayed");
		loginPage.clickForgotPasswordLink();
		logger.pass("clicked on forgot password link");
		boolean flag1 = passwordRecoveryPage.isPasswordRecoveryDisplayed();
		Assert.assertTrue(flag1);
		logger.pass("Password recovery text is present");
		
		passwordRecoveryPage.enterUserEmail("selauto1@test.com");
		logger.pass("entered valid address");
		
		passwordRecoveryPage.clickRecoverButton();
		logger.pass("clicked recover button");
		
		String emailMsgSent = passwordRecoveryPage.getEmailSentMsg();
		System.out.println(emailMsgSent);
		Assert.assertTrue(emailMsgSent.contains("Email with instructions has been sent"));
		logger.pass("verified email message successfully");
	}

}
















