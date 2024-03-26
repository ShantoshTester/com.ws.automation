package com.ws.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverScript {
	
	public static WebDriver driver;
	static Properties prop;
	
	public DriverScript() 
	{
		try
		{
			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("unable to load the properties file ");
			System.out.println(e.getMessage());
		}
	}
	
	
	public void initApplication()
	{
		String browser = prop.getProperty("browser");
		
		if(browser.trim().equalsIgnoreCase("chrome"))
		{
			System.out.println("browser in use : "+browser);
			driver = new ChromeDriver();
		}
		
		else if(browser.trim().equalsIgnoreCase("firefox"))
		{
			System.out.println("browser in use : "+browser);
			driver = new FirefoxDriver();
		}
		
		else if(browser.trim().equalsIgnoreCase("edge"))
		{
			System.out.println("browser in use : "+browser);
			driver = new EdgeDriver();
		}
		
		else
		{
			System.out.println("unsupported browser: please check the config file for the supported browsers");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		getAppUrl();
		
	}
	
	public static void getAppUrl()
	{
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	public static void quitDriver()
	{
		driver.quit();
	}

}









