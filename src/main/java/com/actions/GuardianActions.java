package com.actions;

import com.locators.TheGuradian_PageLocators;
import com.reusable.componensts.CommonMethods;


public class GuardianActions extends CommonMethods
{
	CommonMethods cm = new CommonMethods();
	private String firstNews=null;
	
	/****************************************************************************************************************************
	 * This method is to navigate to The Guardian web site.
	 ***************************************************************************************************************************/
	public void navigateToTheGuardian() 
	{
		try 
		{
			cm.openURL(CommonMethods.getProperty("theGuardian_Link"));
		} 
		catch (Exception e) 
		{
			cm.takeScreenshot("Failed at");
			e.printStackTrace();
			throw new AssertionError(e);
		}
	}
	
	/****************************************************************************************************************************
	 * This method will fetch the first available news article from The Guardian web site.
	 * @return will return the news as String
	 ***************************************************************************************************************************/
	public void fetchFirstAvailableNews()
	{
		try 
		{
			firstNews = cm.getText(TheGuradian_PageLocators.firstAvailableNewsArticle);
		} 
		catch (Exception e) 
		{
			System.out.println("Not able to find First news");
			cm.takeScreenshot("Failed at");
			e.printStackTrace();
			throw new AssertionError(e);
		}
		
	}
	
	/****************************************************************************************************************************
	 * This will reject cookies in case any additional cookies popup appears
	 ***************************************************************************************************************************/
	public void rejectCookies()
	{
		try 
		{
			cm.switchToFrame(TheGuradian_PageLocators.cookieFrame);
			cm.click(TheGuradian_PageLocators.manageOrRejectCookiesButton);
			cm.switchToParentFrame();
			
			cm.switchToFrame(TheGuradian_PageLocators.rejectCookieFrame);
			cm.click(TheGuradian_PageLocators.rejectCookie);
			cm.switchToParentFrame();
		} 
		catch (Exception e) 
		{
			
		}
	}
	
	/***************************************************************************************************************************
	 * This method will return the news string
	 * @return
	 ***************************************************************************************************************************/
	public String getNews()
	{
		return firstNews;
	}

}
