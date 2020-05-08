package com.myprojects.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.myprojects.utilities.CoreMethods;

public class MiniStatementPageObject {
	WebDriver driver;
	
	public MiniStatementPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public void clickOnMiniStatementLink(){
		try {
			driver.findElement(By.xpath("//a[contains(text(),'Mini Statement')]")).click();;
		}
		catch(Exception e) {
			System.out.println("Mini Statement button doesn't exist.");
		}
		
	}
	
	public boolean verifyPageTitleOfMiniStatementPage() {
		String ActualTitle =driver.getTitle();
		
		if (ActualTitle.equalsIgnoreCase("Guru99 Bank Mini Statement Page")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void generateMiniStatement(String accountID) {
		try {
			driver.findElement(By.name("accountno")).sendKeys(accountID);
			driver.findElement(By.name("AccSubmit")).click();
		}
		catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	

}
