package com.myprojects.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.myprojects.utilities.CoreMethods;

public class DeleteAccountPageObject {
	
	WebDriver driver;
	
	public DeleteAccountPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickOnDeleteAccountLink(){
		try {
			driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]")).click();;
		}
		catch(Exception e) {
			System.out.println("Delete Account button doesn't exist.");
		}
		
	}
	
	public boolean verifyPageTitleOfDeleteAccountPage() {
		String ActualTitle =driver.getTitle();
		
		if (ActualTitle.equalsIgnoreCase("Guru99 Bank Delete Account Page ")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void deleteAccount() {
		try{
			driver.findElement(By.name("accountno")).sendKeys(AddAccountPageObject.accountID);
			driver.findElement(By.name("AccSubmit")).click();
			CoreMethods.handleAlert("Do you really want to delete account pop-up didn't appeared.");
			CoreMethods.handleAlert("Account Deleted pop-up didn't appeared.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
