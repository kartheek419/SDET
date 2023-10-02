package com.locators;

import org.openqa.selenium.By;

public class TheTelegraph_PageLocators 
{
	
	/****************************************************************************************************************************
	 * These are the selenium.By variables in The Telegraph to interact
	 ***************************************************************************************************************************/
	public static final By initialSearchBox = By.xpath("//div[contains(@class,'e-site-header-button--search')]/a");
	public static final By actualSearchBox = By.xpath("//input[@id='fsearch']");
	public static final By resultsSectionAppeared = By.xpath("(//div[contains(@class,'cst-results ')]//p)[1]");
	
	public static final By noSearchResults = By.xpath("//div[@class='cst-results ']/p[contains(text(),'We couldn')][contains(text(),'find anything')]");
	public static final By searchResults = By.xpath("//div[@class='cst-results__total'][contains(text(),'We found')]");
	

}
