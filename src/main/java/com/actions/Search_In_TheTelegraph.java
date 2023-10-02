package com.actions;

import com.locators.TheTelegraph_PageLocators;
import com.reusable.componensts.CommonMethods;

public class Search_In_TheTelegraph implements Search_In_Reference_Sites
{

	CommonMethods cm = new CommonMethods();
	Boolean searchResults=false;
	
	@Override
	/****************************************************************************************************************************
	 * This method will search the news in The Telegraph web site.
	 * @param news - will accept string to be searched
	 * @return - will return true if the given string is found, else false
	 ***************************************************************************************************************************/
	public void searchTheNews(String news) 
	{
		try 
		{
			cm.navigateToURL(CommonMethods.getProperty("theTelegraph_Link"));
			cm.click(TheTelegraph_PageLocators.initialSearchBox);
			cm.enterText(TheTelegraph_PageLocators.actualSearchBox, news);
			cm.waitForElementToBeVisible(TheTelegraph_PageLocators.resultsSectionAppeared);
			cm.takeScreenshot("TheTelegraphSearchResults");
			
			try 
			{
				if(cm.isElementPresent(TheTelegraph_PageLocators.searchResults))
					searchResults=true;
				else if(cm.isElementPresent(TheTelegraph_PageLocators.noSearchResults))
					searchResults=false;
			} 
			catch (Exception e) 
			{
				cm.takeScreenshot("Failed at");
				e.printStackTrace();
				throw new AssertionError(e);
			}
			
		} 
		catch (Exception e) 
		{
			cm.takeScreenshot("Failed at");
			e.printStackTrace();
			throw new AssertionError(e);
		}
	}
	
	@Override
	/****************************************************************************************************************************
	 * This method returns the boolean search result
	 * @return - will return true if search results are available, else false
	 ***************************************************************************************************************************/
	public Boolean getSearchResults()
	{
		return searchResults;
	}

}
