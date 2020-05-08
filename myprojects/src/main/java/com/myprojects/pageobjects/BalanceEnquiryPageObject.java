package com.myprojects.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BalanceEnquiryPageObject {
	
	
	WebDriver driver;
	
	public BalanceEnquiryPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public void clickOnBalanceEnquiryLink(){
		try {
			driver.findElement(By.xpath("//a[contains(text(),'Balance Enquiry')]")).click();;
		}
		catch(Exception e) {
			System.out.println("Balance Enquiry button doesn't exist.");
		}
		
	}
	
	public boolean verifyPageTitleOfBalanceEnquiryPage() {
		String ActualTitle =driver.getTitle();
		
		if (ActualTitle.equalsIgnoreCase("Guru99 Bank Balance Enquiry Page")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void generateBalanceEnquiry(String accountID) {
		try {
			driver.findElement(By.name("accountno")).sendKeys(accountID);
			driver.findElement(By.name("AccSubmit")).click();
		}
		catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
	

}
