package com.myprojects.stepdefination;

import org.openqa.selenium.WebDriver;

import com.myprojects.pageobjects.Guru99AddCustomerPageObjects;
import com.myprojects.utilities.Driver;

import cucumber.api.java.en.Then;

public class Guru99AddCustomer {
	WebDriver driver = Driver.getInstance();
	Guru99AddCustomerPageObjects AddCustomerObj = new Guru99AddCustomerPageObjects(driver);

	@Then("^user click on New Customer$")
	public void user_click_on_New_Customer() throws Throwable {
			AddCustomerObj.clickOnNewCustomerLink();
		
	}

	@Then("^Add New Customer Page should be displayed$")
	public void add_New_Customer_Page_should_be_displayed() throws Throwable {
	boolean returnFlag = AddCustomerObj.verifyPageTitleOfNewCustomerPage();
	if(returnFlag) {
		System.out.println("Success : Add New Customer Page is verified");
	}
	else {
		System.out.println("Failed : Add New Customer Page is not verified");
	}
	}

	@Then("^user enter all the required details in add customer page$")
	public void user_enter_all_the_required_details_in_add_customer_page() throws Throwable {
	AddCustomerObj.enterCustomerDetails();
	}

	@Then("^click on Submit Button$")
	public void click_on_Submit_Button() throws Throwable {
		AddCustomerObj.clickOnSubmitButton();
	}

	@Then("^New Customer should be created$")
	public void new_Customer_should_be_created() throws Throwable {
		boolean returnFlag = AddCustomerObj.verifyNewCustomerCreation();
		if(returnFlag) {
			System.out.println("Success : New Customer is added");
		}
		else {
			System.out.println("Failed : New Customer Page is not added");
		}
		}
}
