package com.definitions;

import com.utils.ScriptHelper;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks 
{
	@Before
	public void setUp()
	{
		ScriptHelper.instantiateBrowser();
	}
	
	@After
	public void tearDown()
	{
		ScriptHelper.getWebDriver().quit();
	}

}
