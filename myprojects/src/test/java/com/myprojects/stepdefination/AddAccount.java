package com.myprojects.stepdefination;

import org.openqa.selenium.WebDriver;

import com.myprojects.pageobjects.AddAccountPageObject;
import com.myprojects.pageobjects.Guru99AddCustomerPageObjects;
import com.myprojects.utilities.CoreMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class AddAccount {
	WebDriver driver = CoreMethods.getInstance();
	AddAccountPageObject addAccount=new AddAccountPageObject(driver);
	
	@Then("^user clicks on Add Account$")
	public void user_clicks_on_Add_Account() throws Throwable{
		addAccount.clickOnNewAccountLink();
	}

	@Then("^user should be navigated to Add new account form$")
	public void user_should_be_navigated_to_Add_new_account_form(){
		boolean returnFlag = addAccount.verifyPageTitleOfNewAccountPage();
		if(returnFlag) {
			System.out.println("Success : Add Account Page is verified");
		}
		else {
			System.out.println("Failed : Add Account Page is not verified");
		}
	}

	@Then("^user add account for customer ID$")
	public void user_add_account_for_customer_ID(){
		addAccount.addNewAccount();
	}
	
	@And("^Account should be created successfully$")
	public void Account_should_be_created_successfully() throws InterruptedException {
		boolean returnFlag = addAccount.verifyNewAccountCreation();
		if(returnFlag) {
			System.out.println("Success : New Account ID is added");
			System.out.println("Account ID:" + AddAccountPageObject.accountID);
		}
		else {
			System.out.println("Failed : New Account ID is not added");
		}
	}
	
	
	
	
}
