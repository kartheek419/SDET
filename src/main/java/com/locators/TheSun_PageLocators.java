package com.locators;

import org.openqa.selenium.By;

public class TheSun_PageLocators 
{
	
	/****************************************************************************************************************************
	 * These are the selneium.By variables in The Sun web site to interact
	 ***************************************************************************************************************************/
	
	public static final By initialSearchBox = By.xpath("//div[contains(@class,'top-banner-search')]");
	public static final By actualSearchBox = By.xpath("//input[@placeholder='Search The Sun']");
	public static final By searchButton = By.xpath("//button[@aria-label='Search submit']");
	
	public static final By noSearchResults = By.xpath("//div[@class='search-page-header__container']/span[contains(text(),'No search results')]");
	public static final By searchResults = By.xpath("(//div[@class='grids-container']//a/h3)[1]");

}
