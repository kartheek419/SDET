package com.utils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.reusable.componensts.CommonMethods;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScriptHelper 
{
	private static WebDriver driver;
	
	/*****************************************************************************************************************************
	 * This method will initiate and open the browser
	 ****************************************************************************************************************************/
	public static void instantiateBrowser()
	{
		String browser = CommonMethods.getProperty("browser").toLowerCase();
//		String browser = "chrome";
		Map prefs = new HashMap();
		
		switch (browser) 
		{
		case "chrome":
			
			WebDriverManager.chromedriver().setup();
			prefs.put("profile.default_content_settings.cookies", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			
			driver = new ChromeDriver(options);
			
			break;
		case "firefox":
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
			break;
		
		default:
			System.out.println("Please provide valid browser Details");
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/*****************************************************************************************************************************
	 * This method will retrieve the driver instance
	 * @return - driver
	 ****************************************************************************************************************************/
	public static WebDriver getWebDriver()
	{
		return driver;
	}
	

	
}
