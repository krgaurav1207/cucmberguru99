package com.myprojects.stepdefination;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.myprojects.pageobjects.BalanceEnquiryPageObject;
import com.myprojects.pageobjects.MiniStatementPageObject;
import com.myprojects.utilities.CoreMethods;
import com.myprojects.utilities.ReadExcelSheetData;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class BalanceEnquiry {
	WebDriver driver = CoreMethods.getInstance();
	BalanceEnquiryPageObject balanceEnquiry= new BalanceEnquiryPageObject(driver);
	
	@Then("^user navigate to Balance Enquiry$")
	public void user_navigate_to_Balance_Enquiry() {
		balanceEnquiry.clickOnBalanceEnquiryLink();
	}
	
	@And("^user is at Balance Enquiry page$")
	public void user_is_at_Balance_Enquiry_page() {
		boolean returnFlag = balanceEnquiry.verifyPageTitleOfBalanceEnquiryPage();
		if(returnFlag) {
			System.out.println("Success : Balance Enquiry Page is verified");
		}
		else {
			System.out.println("Failed : Balance Enquiry Page is not verified");
		}
	}
	
	@Then("^user generate Balance Enquiry for Account ID for delete$")
	public void user_generate_Balance_Enquiry_for_Account_ID() {
		String accID=null;
		try {
			accID = ReadExcelSheetData.getMapData("AccountIDForDelete");
		} catch (IOException e) {
			e.printStackTrace();
		}
		balanceEnquiry.generateBalanceEnquiry(accID);
	}
	
	
	
	

}
