Feature: Verify the news available in The Guardian is valid
Scenario: Verify the news available in The Guardian is Valid
	Given User navigates to The Guardian
	And User fetches first available news
	When User searches the news in The Sun
	And User searches the news in The Telegraph
	Then User should know whether the news is valid