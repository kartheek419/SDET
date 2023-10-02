package com.locators;

import org.openqa.selenium.By;

public class TheGuradian_PageLocators 
{
	/****************************************************************************************************************************
	 * These are the selenium.By variables in The Guardian web site to interact
	 ***************************************************************************************************************************/
	
	public static final By firstAvailableNewsArticle = By.xpath("(//div[@data-link-name='Front | /tone/news']//*[contains(@class,'fc-container__body')]//ul/li/div[contains(@class,'fc-item--type-article')]//h3//span[@class='js-headline-text'])[1]");
	
	public static final By cookieFrame = By.xpath("//iframe[@title='The Guardian consent message']");
	public static final By manageOrRejectCookiesButton = By.xpath("//button[@title='Manage or reject cookies']");
	
	public static final By rejectCookieFrame = By.xpath("//iframe[@title='SP Consent Message']");
	public static final By rejectCookie = By.xpath("//button[@title='Reject all']");

}
