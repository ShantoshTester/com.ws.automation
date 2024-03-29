package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;

public class PasswordRecoverPage extends DriverScript {

//***************************************** Page Elements ***************************************** //
	
	@FindBy(xpath = "//h1[text()='Password recovery']") WebElement passwordRecoveryText;
	@FindBy(xpath = "//input[@id='Email']") WebElement passwordrecoveryEmailTextbox;
	@FindBy(name = "send-email") WebElement recoverButton;
	@FindBy(xpath = "//span[@for='Email']") WebElement wrongEmailMsg;
	@FindBy(xpath = "//div[@class='result']") WebElement emailInstructionsSentMsg;

//***************************************** Page Initialization *********************************** //
	
	public PasswordRecoverPage()
	{
		PageFactory.initElements(driver, this);
	}
	
//***************************************** Page Actions/Methods ************************************ //
	
	public String getWrongEmailMsg()
	{
		return wrongEmailMsg.getText();
	}
	
	public String getEmailSentMsg()
	{
		return emailInstructionsSentMsg.getText();
	}
	
	public void clickRecoverButton()
	{
		recoverButton.click();
	}
	
	public void enterUserEmail(String email)
	{
		passwordrecoveryEmailTextbox.clear();
		passwordrecoveryEmailTextbox.sendKeys(email);
	}
	
	public boolean isPasswordRecoveryDisplayed()
	{
		return passwordRecoveryText.isDisplayed();
	}
	
	public String getPasswordRecoveryText()
	{
		return passwordRecoveryText.getText();
	}

}
