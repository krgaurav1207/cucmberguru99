package com.myprojects.stepdefination;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.myprojects.pageobjects.CustomisedStatementPageObject;
import com.myprojects.utilities.CoreMethods;
import com.myprojects.utilities.ReadExcelSheetData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class CustomisedStatement {
	WebDriver driver = CoreMethods.getInstance();
	CustomisedStatementPageObject customisedStatement= new CustomisedStatementPageObject(driver);
	
	@Then("^user navigate to Customised Statement$")
	public void user_navigate_to_Customised_Statement() {
		customisedStatement.clickOnCustomisedStatementLink();
	}
	
	@And("^user is at Customised Statement page$")
	public void user_is_at_Customised_Statement_page() {
		boolean returnFlag = customisedStatement.verifyPageTitleOfCustomisedStatementPage();
		if(returnFlag) {
			System.out.println("Success : Customised Statement Page is verified");
		}
		else {
			System.out.println("Failed : Customised Statement Page is not verified");
		}
	}
	
	@Then("^user generate Customised Statement for Account ID for delete$")
	public void user_generate_Customised_Statement_for_Account_ID() {		
		String accID = null;
		String fromDate = CoreMethods.todayDate();
		String toDate = CoreMethods.todayDate();
		String minTran = "";
		String noTran = "";
		try {
			accID = ReadExcelSheetData.getMapData("AccountIDForDelete");
		} catch (IOException e) {
			e.printStackTrace();
		}
		customisedStatement.fillCustomisedStatement(accID, fromDate, toDate, minTran, noTran);
	}
	
	
	
	

}
