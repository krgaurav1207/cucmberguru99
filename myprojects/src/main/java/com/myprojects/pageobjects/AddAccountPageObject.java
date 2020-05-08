package com.myprojects.pageobjects;

import java.time.Duration;

import org.joda.time.Seconds;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myprojects.utilities.CoreMethods;
import com.myprojects.utilities.ReadExcelSheetData;

public class AddAccountPageObject extends CoreMethods {
	WebDriver driver;
	
	public AddAccountPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickOnNewAccountLink() throws Throwable{
		driver.findElement(By.xpath("//a[contains(text(),'New Account')]")).click();
	}
	
	public boolean verifyPageTitleOfNewAccountPage() {
		String ActualTitle =driver.getTitle();
		
		if (ActualTitle.equalsIgnoreCase("Guru99 Bank add new account")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addNewAccount() {
		try {
			 if(CoreMethods.isNullOrEmpty(customerID)) {
				 String custID = ReadExcelSheetData.getMapData("CustomerID");
				 driver.findElement(By.cssSelector("input[name='cusid']")).sendKeys(custID);
			 }else {
				 driver.findElement(By.cssSelector("input[name='cusid']")).sendKeys(customerID);
			 }
						
			 String acType = ReadExcelSheetData.getMapData("AccountType");
			 driver.findElement(By.cssSelector("select[name='selaccount']")).sendKeys(acType);
			 
			 String initDept = ReadExcelSheetData.getMapData("InitialDeposit");
			 driver.findElement(By.cssSelector("input[name='inideposit']")).sendKeys(initDept);
			 
			 driver.findElement(By.cssSelector("input[type='submit']")).click();
		}
		catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	public boolean verifyNewAccountCreation() throws InterruptedException {
		//Explicit wait
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement expectedMsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='heading3']")));
		
		String ExpectedText = expectedMsg.getText();
		if (ExpectedText.equalsIgnoreCase("Account Generated Successfully!!!")) {
			accountID=driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[4]/td[2]")).getText();
			return true;
		} else {
			return false;
		}
	}
	
	
	

}
