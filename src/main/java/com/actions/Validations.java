package com.actions;

public class Validations 
{
	Boolean isValid;
	
	/***************************************************************************************************************************
	 * This method will verify the conditions for the news to be valid
	 * @param searchResults1 - boolean search result
	 * @param searchResults2 - boolean search result
	 * @param news - news
	 **************************************************************************************************************************/
	public void isNewsValid(Boolean searchResults1, Boolean searchResults2, String news)
	{
		if(searchResults1 && searchResults2) 
			isValid= true;
		else
			isValid=false;
	
		getValidity(isValid, news);
	}
	
	
	/***************************************************************************************************************************
	 * This method will give the output to the user regarding the validity
	 * @param validity - validity
	 * @param news - news
	 **************************************************************************************************************************/
	private void getValidity(Boolean validity, String news)
	{
		if(validity) 
		{
			System.out.println("The news in The Guardian - "+news+" is valid.");
		}
		else
		{
			System.out.println("The news in The Guardian -"+news+" is invalid.");
		}
	}

}
