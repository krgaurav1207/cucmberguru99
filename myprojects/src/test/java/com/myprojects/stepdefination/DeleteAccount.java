package com.myprojects.stepdefination;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.myprojects.pageobjects.DeleteAccountPageObject;
import com.myprojects.pageobjects.Guru99LoginPageObjects;
import com.myprojects.utilities.CoreMethods;
import com.myprojects.utilities.ReadExcelSheetData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class DeleteAccount {
	WebDriver driver = CoreMethods.getInstance();
	DeleteAccountPageObject deleteAccount=new DeleteAccountPageObject(driver);
	
	@Then("^user navigate to Delete Account$")
	public void user_navigate_to_Delete_Account() {
		deleteAccount.clickOnDeleteAccountLink();
	}
	
	@And("^user is at Delete Account page$")
	public void user_is_at_Delete_Account_page() {
		boolean returnFlag = deleteAccount.verifyPageTitleOfDeleteAccountPage();
		if(returnFlag) {
			System.out.println("Success : Delete Account Page is verified");
		}
		else {
			System.out.println("Failed : Delete Account Page is not verified");
		}
	}
	
	@Then("^user delete the account$")
	public void user_delete_the_account() {
		deleteAccount.deleteAccount();
	}
	
	@And("^user is navigated to Home Page$")
	public void user_is_navigated_to_Home_Page() {
		(new Guru99LoginPageObjects(driver)).getHomePageTitle();
	}
	
	@And("^Account does not exist message is displayed$")
	public void Account_does_not_exist_message_is_displayed() {
		String alertText=driver.switchTo().alert().getText();
		if (alertText.equalsIgnoreCase("Account does not exist"))
			driver.switchTo().alert().accept();
		else
			System.out.println(alertText);
	}
	
	
	
}
