package com.myprojects.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.myprojects.utilities.CoreMethods;

public class CustomisedStatementPageObject {
	
	WebDriver driver;
	
	public CustomisedStatementPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public void clickOnCustomisedStatementLink(){
		try {
			driver.findElement(By.xpath("//a[contains(text(),'Customised Statement')]")).click();;
		}
		catch(Exception e) {
			System.out.println("Customised Statement button doesn't exist.");
		}
		
	}
	
	public boolean verifyPageTitleOfCustomisedStatementPage() {
		String ActualTitle =driver.getTitle();
		
		if (ActualTitle.equalsIgnoreCase("Guru99 Bank Statement Page")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void fillCustomisedStatement(String accID,String fromDate,String toDate,String minTran,String noTran) {
		
		try {
		driver.findElement(By.name("accountno")).sendKeys(accID);
		
		driver.findElement(By.xpath("//input[@name='fdate']")).sendKeys(fromDate.substring(0, 4));
		driver.findElement(By.xpath("//input[@name='fdate']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@name='fdate']")).sendKeys(fromDate.substring(4));
		CoreMethods.handleAlert("No Alert found at entering from date for Customised Statement.");
		
		driver.findElement(By.xpath("//input[@name='tdate']")).sendKeys(toDate.substring(0, 4));
		driver.findElement(By.xpath("//input[@name='tdate']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@name='tdate']")).sendKeys(toDate.substring(4));
		CoreMethods.handleAlert("No Alert found at entering date for Customised Statement.");
		
		driver.findElement(By.name("amountlowerlimit")).sendKeys(minTran);
		
		driver.findElement(By.name("numtransaction")).sendKeys(noTran);
		
		driver.findElement(By.name("AccSubmit")).click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
