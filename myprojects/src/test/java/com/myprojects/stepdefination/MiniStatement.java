package com.myprojects.stepdefination;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.myprojects.pageobjects.MiniStatementPageObject;
import com.myprojects.utilities.CoreMethods;
import com.myprojects.utilities.ReadExcelSheetData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class MiniStatement {
	WebDriver driver = CoreMethods.getInstance();
	MiniStatementPageObject miniStatement= new MiniStatementPageObject(driver);
	
	@Then("^user navigate to Mini Statement$")
	public void user_navigate_to_Mini_Statement() {
		miniStatement.clickOnMiniStatementLink();
	}
	
	@And("^user is at Mini Statement page$")
	public void user_is_at_Mini_Statement_page() {
		boolean returnFlag = miniStatement.verifyPageTitleOfMiniStatementPage();
		if(returnFlag) {
			System.out.println("Success : Mini Statement Page is verified");
		}
		else {
			System.out.println("Failed : Mini Statement Page is not verified");
		}
	}
	
	@Then("^user generate Mini Statatement for Account ID for delete$")
	public void user_generate_Mini_Statement_for_Account_ID() {
		String accID=null;
		try {
			accID = ReadExcelSheetData.getMapData("AccountIDForDelete");
		} catch (IOException e) {
			e.printStackTrace();
		}
		miniStatement.generateMiniStatement(accID);
	}
	

}
