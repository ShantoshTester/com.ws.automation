package com.ws.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Helper  {
	
	public static String captureScreen(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenPath = "D:/WORKSPACE/BATCH29/Framework/com.ws.automation/testreport/screenshots/screen.png";
		try 
		{
			FileHandler.copy(src, new File(screenPath));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return screenPath;
	}

}
