Feature:  Test the Add Account functionality of Guru99 site
 
  @AddAccountExisting
  Scenario: The user should be able to Add Account for existing customer
    Given user is on Login Page
    When user enters correct username and password
    Then user should be able to login
    And user clicks on Add Account
    Then user should be navigated to Add new account form
    Then user add account for customer ID 
    And Account should be created successfully
    
    
  @AddCustomerAndAccount
  Scenario: The user should be able to Add Account for New customer
       Given user is on Login Page
    When user enters correct username and password
    Then user should be able to login
  	Then user click on New Customer
    Then Add New Customer Page should be displayed
  	Then user enter all the required details in add customer page
   	Then click on Submit Button
  	Then New Customer should be created
    And user clicks on Add Account
    Then user should be navigated to Add new account form
    Then user add account for customer ID
    And Account should be created successfully