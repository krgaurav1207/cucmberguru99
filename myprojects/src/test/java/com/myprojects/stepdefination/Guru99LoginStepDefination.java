package com.myprojects.stepdefination;

import org.openqa.selenium.WebDriver;

import com.myprojects.pageobjects.Guru99LoginPageObjects;
import com.myprojects.utilities.CoreMethods;
import com.myprojects.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Guru99LoginStepDefination {
	WebDriver driver = Driver.getInstance();
	Guru99LoginPageObjects LoginPageObj = new Guru99LoginPageObjects(driver);
	@Given("^user is on Login Page$")
	public void user_is_on_Login_Page() throws Throwable {
		WebDriver driver = Driver.getInstance();
		 		 CoreMethods.launchURL(driver);
		 		LoginPageObj.getLoginPageTitle();
	}

	@When("^user enters correct username and password$")
	public void user_enters_correct_username_and_password() throws Throwable {
		LoginPageObj.enterUserName();
		LoginPageObj.enterPassword();
	    
	}

	@Then("^user should be able to login$")
	public void user_should_be_able_to_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LoginPageObj.Login();
		LoginPageObj.getHomePageTitle();
		
	}

	
	@When("^user enters invalid userid and password$")
	public void user_enters_invalid_username_and_password() {
		LoginPageObj.invalidUserName();
		LoginPageObj.enterPassword();
	}
	
	@When("^user enters userid and invalid password$")
	public void user_enters_username_and_invalid_password() {
		LoginPageObj.enterUserName();
		LoginPageObj.invalidPassword();
	}
	
	@When("^user enters invalid userid and invalid password$")
	public void user_enters_invalid_username_and_invalid_password() {
		LoginPageObj.invalidUserName();
		LoginPageObj.invalidPassword();
	}
	
	@Then("^Error alert should be given$")
	public void Error_alert_should_be_given() {
		LoginPageObj.Login();
		LoginPageObj.ErrorWindow();
		driver.close();
	}
}
