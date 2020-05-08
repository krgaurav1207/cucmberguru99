Feature:  Test the Delete Account functionality of Guru99 site
   
  @DeleteAccount @SM6 @SM7
  Scenario: The user should be able to Delete Account and verify related functionality
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
    Then user navigate to Delete Account
    And user is at Delete Account page
    Then user delete the account
    And user is navigated to Home Page
    
    
    @MiniStatementForDeletedAccount @SM8
  Scenario: Mini statement is not generated for Deleted Account
    Given user is on Login Page
    When user enters correct username and password
    Then user should be able to login
    Then user navigate to Mini Statement
    And user is at Mini Statement page
    Then user generate Mini Statatement for Account ID for delete
    And Account does not exist message is displayed
    
    @BalanceForDeletedAccount @SM9
  Scenario: Balance Enquiry is not performed for Deleted Account
    Given user is on Login Page
    When user enters correct username and password
    Then user should be able to login
    Then user navigate to Balance Enquiry
    And user is at Balance Enquiry page
    Then user generate Balance Enquiry for Account ID for delete
    And Account does not exist message is displayed
    
    
    @CustomisedStatementForDeletedAccount @SM9
  Scenario: Customised Statement is not performed for Deleted Account
    Given user is on Login Page
    When user enters correct username and password
    Then user should be able to login
    Then user navigate to Customised Statement
    And user is at Customised Statement page
    Then user generate Customised Statement for Account ID for delete
    And Account does not exist message is displayed
    
    
    