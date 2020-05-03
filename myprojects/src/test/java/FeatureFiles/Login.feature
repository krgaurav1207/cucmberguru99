@Login
Feature: Test the login functionality of Guru99 site

  @SuccessfullLogin
  Scenario: The user should be able to login with correct userid and password
    Given user is on Login Page
    When user enters correct userid and password
    Then user should be able to login

 @InvalidUserID
  Scenario: The user should be able to login with correct userid and password
    Given user is on Login Page
  	When user enters invalid userid and password
    Then Error alert should be given

 @InvalidPassword
  Scenario: The user should be able to login with correct userid and password
    Given user is on Login Page
  	When user enters userid and invalid password
    Then Error alert should be given
    
 @InvalidUserIDPassword
  Scenario: The user should be able to login with correct userid and password
    Given user is on Login Page
  	When user enters invalid userid and invalid password
    Then Error alert should be given