package com.reusable.componensts;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.ScriptHelper;


public class CommonMethods
{
	
	WebDriver driver= ScriptHelper.getWebDriver();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement wb;
	
	/****************************************************************************************************************************
	 * This method will open the given url and it will wait till the page is completely loaded.
	 * @param url - url to be navigated to
	 ***************************************************************************************************************************/
	public void openURL(String url)
	{
		driver.get(url);
	}
	
	/****************************************************************************************************************************
	 * This method will open the given url but will not wait for the page to load
	 * @param url
	 ***************************************************************************************************************************/
	public void navigateToURL(String url)
	{
		driver.navigate().to(url);
	}
	
	/****************************************************************************************************************************
	 * This method will wait till the given web element is clickable and then clicks on it.
	 * @param wb - web element to be clicked
	 ***************************************************************************************************************************/
	public void click(WebElement wb)
	{
		waitForElementToBeClickable(wb);
		wb.click();
	}
	
	/****************************************************************************************************************************
	 * This method will wait till the given by element is clickable and then clicks on it.
	 * @param byElement - by element to be clicked
	 ***************************************************************************************************************************/
	public void click(By byElement)
	{
		waitForElementToBeClickable(byElement);
		driver.findElement(byElement).click();
	}
	
	
	/****************************************************************************************************************************
	 * This method will wait till the given web element is clickable and then enters text into it.
	 * @param wb - web element on which text needs to be entered
	 * @param textToBeEntered - text to be entered
	 ***************************************************************************************************************************/
	public void enterText(WebElement wb, String textToBeEntered)
	{
		waitForElementToBeClickable(wb);
		wb.clear();
		wb.sendKeys(textToBeEntered);
	}
	
	/****************************************************************************************************************************
	 * This method will wait till the given by element is clickable and then enters text into it.
	 * @param byElement - by element on which text needs to be entered
	 * @param textToBeEntered - text to be entered
	 ***************************************************************************************************************************/
	public void enterText(By byElement, String textToBeEntered)
	{
		waitForElementToBeClickable(byElement);
		driver.findElement(byElement).clear();
		driver.findElement(byElement).sendKeys(textToBeEntered);
	}
	
	/****************************************************************************************************************************
	 * This method will wait till the given by element is visible and then get the text from it
	 * @param byElement - by element from which the text needs to be entered
	 * @return - will return the fetched string text
	 ***************************************************************************************************************************/
	public String getText(By byElement)
	{
		waitForElementToBeVisible(byElement);
		String text = driver.findElement(byElement).getText();
		return text;
	}
	
	/****************************************************************************************************************************
	 * This method will wait till the given web element is visible and then get the text from it
	 * @param wb - web element from which the text needs to be entered
	 * @return - will return the fetched string text
	 ***************************************************************************************************************************/
	public String getText(WebElement wb)
	{
		waitForElementToBeVisible(wb);
		String text = wb.getText();
		return text;
	}
	
	/****************************************************************************************************************************
	 * This method will get the web element from the given by element
	 * @param byElement - by element
	 * @return - web element for the given by element
	 ***************************************************************************************************************************/
	public WebElement getWebElement(By byElement)
	{
		wb=driver.findElement(byElement);
		return wb;
	}
	
	
	/****************************************************************************************************************************
	 * This method will switch to the frame as per the given by element
	 * @param byElement - by element for the frame
	 ***************************************************************************************************************************/
	public void switchToFrame(By byElement)
	{
		waitForElementToBeVisible(byElement);
		WebElement wb = getWebElement(byElement);
		driver.switchTo().frame(wb);
	}
	
	/****************************************************************************************************************************
	 * This method will switch the frame back to parent frame
	 ***************************************************************************************************************************/
	public void switchToParentFrame()
	{
		driver.switchTo().parentFrame();
	}
	
	/****************************************************************************************************************************
	 * This method will verify if the given by element is present or not
	 * @param byElement - by element 
	 * @return - will return true if given by element is present, else false
	 ***************************************************************************************************************************/
	public Boolean isElementPresent(By byElement)
	{
		Boolean bool;
		try 
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			wb = driver.findElement(byElement);
			bool = wb.isDisplayed();
		} 
		catch (Exception e) 
		{
			bool=false;
		}
		
		return bool;
	}
	
	
	/****************************************************************************************************************************
	 * This method will wait for the given by element to be visible
	 * @param byElement - by element
	 ***************************************************************************************************************************/
	public void waitForElementToBeVisible(By byElement)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
	}
	
	/****************************************************************************************************************************
	 * This method will wait for the given web element to be visible
	 * @param wb - web element
	 ***************************************************************************************************************************/
	public void waitForElementToBeVisible(WebElement wb)
	{
		wait.until(ExpectedConditions.visibilityOf(wb));
	}
	
	/****************************************************************************************************************************
	 * This method will wait for the given by element to be clickable
	 * @param byElement - by element
	 ***************************************************************************************************************************/
	public void waitForElementToBeClickable(By byElement)
	{
		wait.until(ExpectedConditions.elementToBeClickable(byElement));
	}
	
	/****************************************************************************************************************************
	 * This method will wait for the given web element to be clickable
	 * @param wb - web element
	 ***************************************************************************************************************************/
	public void waitForElementToBeClickable(WebElement wb)
	{
		wait.until(ExpectedConditions.elementToBeClickable(wb));
	}
	
	
	/****************************************************************************************************************************
	 * This method will get the value of the given property name
	 * @param propertyName - Property name 
	 * @return - will return value of property
	 ***************************************************************************************************************************/
	public static String getProperty(String propertyName)
	{
		String propertyValue=null;
		Properties prop = new Properties();
		 
		try 
		{
			FileReader reader = new FileReader("Properties.properties");
			prop.load(reader);
			propertyValue = prop.getProperty(propertyName);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.exit(1);
		}
		
		return propertyValue;
	}
	
	/****************************************************************************************************************************
	 * This method will take the screenshot
	 * @param screenshotName - Name of the screenshot
	 ***************************************************************************************************************************/
	public void takeScreenshot(String screenshotName)
	{
		TakesScreenshot shot = (TakesScreenshot)driver;
		File srcFile = shot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("target/screenshots/"+screenshotName+".png");
		try 
		{
			FileUtils.copyFile(srcFile, destFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	
	

}
