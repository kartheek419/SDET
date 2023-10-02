package com.definitions;

import com.actions.GuardianActions;
import com.actions.Search_In_TheSun;
import com.actions.Search_In_TheTelegraph;
import com.actions.Validations;
import com.reusable.componensts.CommonMethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class StepDefinition 
{
	
	CommonMethods cm = new CommonMethods();
	GuardianActions ga = new GuardianActions();
	Search_In_TheSun theSun = new Search_In_TheSun();
	Search_In_TheTelegraph theTelegraph = new Search_In_TheTelegraph();
	Validations validation = new Validations();
	
	
	
	@Given("^User navigates to The Guardian$")
	public void navigateToURL()
	{
		ga.navigateToTheGuardian();
		ga.rejectCookies();
	}
	
	@And("^User fetches first available news$")
	public void FetchFirstAvailableNews()
	{
		ga.fetchFirstAvailableNews();
	}
	
	@When("^User searches the news in The Sun$")
	public void searchNewsInTheSun()
	{
		String news = ga.getNews();
		theSun.searchTheNews(news);
	}
	
	@And("^User searches the news in The Telegraph$")
	public void searchNewsInTheTelegraph()
	{
		String news = ga.getNews();
		theTelegraph.searchTheNews(news);
	}
	
	@Then("^User should know whether the news is valid$")
	public void validateResults()
	{
		Boolean theSunSearchResults = theSun.getSearchResults();
		Boolean theTelegraphSearchResults = theTelegraph.getSearchResults();
		String news = ga.getNews();
		
		validation.isNewsValid(theSunSearchResults, theTelegraphSearchResults, news);
	}

}
