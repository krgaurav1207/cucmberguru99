Feature:  Test the Add new customer functionality of Guru99 site
 
  @AddCustomer
  Scenario: The user should be able to add new customer successfully
      Given user is on Login Page
	    When user enters correct username and password
	    Then user should be able to login
	  	Then user click on New Customer
	    Then Add New Customer Page should be displayed
	  	Then user enter all the required details in add customer page
	   	Then click on Submit Button
	  	Then New Customer should be created