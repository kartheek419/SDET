package com.archive;


import com.locators.TheSun_PageLocators;
import com.locators.TheTelegraph_PageLocators;
import com.reusable.componensts.CommonMethods;

public class SearchActions 
{
	
	CommonMethods cm = new CommonMethods();
	Boolean searchResults=false;
	
	/****************************************************************************************************************************
	 * This method will search for the news in The Sun web site.
	 * @param news - will accept String to be searched
	 * @return - will return true if the given string is found, else false
	 ***************************************************************************************************************************/
	public Boolean searchInTheSun(String news)
	{
		
		try 
		{
			cm.navigateToURL("https://www.thesun.co.uk/");
			cm.click(TheSun_PageLocators.initialSearchBox);
			cm.enterText(TheSun_PageLocators.actualSearchBox, news);
			cm.click(TheSun_PageLocators.searchButton);
			
			try 
			{
				if(cm.isElementPresent(TheSun_PageLocators.searchResults))
					searchResults=true;
				else if(cm.isElementPresent(TheSun_PageLocators.noSearchResults))
					searchResults=false;
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return searchResults;
	}
	
	/****************************************************************************************************************************
	 * This method will search the news in The Telegraph web site.
	 * @param news - will accept string to be searched
	 * @return - will return true if the given string is found, else false
	 ***************************************************************************************************************************/
	public Boolean searchInTheTelegraph(String news)
	{
		try 
		{
			cm.navigateToURL("https://www.telegraph.co.uk/news/");
			cm.click(TheTelegraph_PageLocators.initialSearchBox);
			cm.enterText(TheTelegraph_PageLocators.actualSearchBox, news);
			cm.waitForElementToBeVisible(TheTelegraph_PageLocators.resultsSectionAppeared);
			
			try 
			{
				if(cm.isElementPresent(TheTelegraph_PageLocators.searchResults))
					searchResults=true;
				else if(cm.isElementPresent(TheTelegraph_PageLocators.noSearchResults))
					searchResults=false;
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return searchResults;
		
	}
	
	
}
