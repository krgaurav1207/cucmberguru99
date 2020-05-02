Feature: Login Feature
  
  
  @Login
   Scenario: The user should be able to login with correct username and password
    Given user is on Login Page
    When user enters correct username and password
    Then user should be able to login