package com.actions;

import com.locators.TheSun_PageLocators;
import com.reusable.componensts.CommonMethods;

public class Search_In_TheSun implements Search_In_Reference_Sites
{
	CommonMethods cm = new CommonMethods();
	Boolean searchResults=false;

	@Override
	/****************************************************************************************************************************
	 * This method will search for the news in The Sun web site.
	 * @param news - will accept String to be searched
	 ***************************************************************************************************************************/
	public void searchTheNews(String news) 
	{
		try 
		{
			cm.openURL(CommonMethods.getProperty("theSun_Link"));
			cm.click(TheSun_PageLocators.initialSearchBox);
			cm.enterText(TheSun_PageLocators.actualSearchBox, news);
			cm.click(TheSun_PageLocators.searchButton);
			cm.takeScreenshot("TheSunSearchResults");
			
			try 
			{
				if(cm.isElementPresent(TheSun_PageLocators.searchResults))
					searchResults=true;
				else if(cm.isElementPresent(TheSun_PageLocators.noSearchResults))
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
