
@E2E
Feature: Title of your feature
  As a user, I want enter my email and my psseword to authenticate
  
  @SmokeTEST
  Scenario: Authentication
    Given I launch the sephora application
    When I click on login-icon of nav_menu 
    Then connexion page is opened
    
    When I enter the mail and passeword correct
    And I click on the connect button
		Then I connect to my application account
	


