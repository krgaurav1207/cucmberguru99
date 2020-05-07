package com.myprojects.pageobjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myprojects.utilities.CoreMethods;
import com.myprojects.utilities.ReadExcelSheetData;

public class Guru99AddCustomerPageObjects extends ReadExcelSheetData{
	WebDriver driver;
	public static String customerID=null;
	 public Guru99AddCustomerPageObjects(WebDriver driver) {
		 this.driver =driver;
	 }
	
	public Guru99AddCustomerPageObjects() {
		// TODO Auto-generated constructor stub
	}

	public void clickOnNewCustomerLink() throws Throwable {
		
		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();
		
	}

	public boolean verifyPageTitleOfNewCustomerPage() {
		String ActualTitle =driver.getTitle();
				//driver.findElement(By.xpath("//p[contains(text(),'Add New Customer')]")).getText();
		
		if (ActualTitle.equalsIgnoreCase("Guru99 Bank New Customer Entry Page")) {
			return true;
		} else {
			return false;
		}
	}
	public void EnterCustomerPassword(WebDriver driver) throws IOException {
		String CustomerPass = ReadExcelSheetData.getMapData("CustomerPassword");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(CustomerPass);
	}

	public void EnterCustomerEmailId(WebDriver driver) throws Throwable {
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(CoreMethods.randomCharacter(10, "yes", "no")+"@test.com");
	}
	public void EnterCustomerMobileNumber(WebDriver driver) throws Throwable {
		String CustomerMobileNumber = ReadExcelSheetData.getMapData("CustomerMobileNumber");
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(CustomerMobileNumber);
	}

	public void EnterCustomerPinCode(WebDriver driver) throws Throwable {
		String CustomerPinCode = ReadExcelSheetData.getMapData("CustomerPinCode");
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(CustomerPinCode);
	}

	public void EnterCustomerState(WebDriver driver) throws Throwable {
		String CustomerState = ReadExcelSheetData.getMapData("CustomerState");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(CustomerState);
	}
	public void EnterCustomerCity(WebDriver driver) throws Throwable {
		String CustomerCity = ReadExcelSheetData.getMapData("CustomerCity");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(CustomerCity);
	}

	public void EnterCustomerAddress(WebDriver driver) throws Throwable {
		String CustomerAdd = ReadExcelSheetData.getMapData("CustomerAddress");
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(CustomerAdd);
	}

	public void SelectCustomerDateOfBirth(WebDriver driver) throws Throwable {
		String CustomerDOB = ReadExcelSheetData.getMapData("CustomerDateOfBirth");
		driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(CustomerDOB.substring(0, 4));
		driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(CustomerDOB.substring(4));
		CoreMethods.handleAlert("No Alert found at entering date for Add Customer.");
	}

	public void SelectCustomerGender(WebDriver driver) throws Throwable {
		String CustomerGender = ReadExcelSheetData.getMapData("CustomerGender");
		if(CustomerGender.equalsIgnoreCase("Male")) {
	
			driver.findElement(By.xpath("//input[@name='rad1']")).sendKeys("m");
		}
		else {
			driver.findElement(By.xpath("//input[@name='rad1']")).sendKeys("f");
		}}
	
	public void EnterCustomerName(WebDriver driver) throws Throwable {
		String custName = ReadExcelSheetData.getMapData("CustomerName");
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(custName);
			}

	public void clickOnSubmitButton() {
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}

	public boolean verifyNewCustomerCreation() throws InterruptedException {
		//Explicit wait
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement expectedMsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='heading3']")));
		
		String ExpectedText = expectedMsg.getText();
		if (ExpectedText.equalsIgnoreCase("Customer Registered Successfully!!!")) {
			customerID=driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();
			return true;
		} else {
			return false;
		}
	}

	public void enterCustomerDetails() throws Throwable {
		Guru99AddCustomerPageObjects obj1 = new Guru99AddCustomerPageObjects();
		obj1.EnterCustomerName(driver);
		obj1.SelectCustomerGender(driver);
		obj1.SelectCustomerDateOfBirth(driver);
		obj1.EnterCustomerAddress(driver);
		obj1.EnterCustomerCity(driver);
		obj1.EnterCustomerState(driver);
		obj1.EnterCustomerPinCode(driver);
		obj1.EnterCustomerMobileNumber(driver);
		obj1.EnterCustomerEmailId(driver);
		obj1.EnterCustomerPassword(driver);
			}
}
