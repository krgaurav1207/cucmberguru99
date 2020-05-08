package com.myprojects.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99LoginPageObjects {
	 WebDriver driver;
	 
	 public Guru99LoginPageObjects(WebDriver driver) {
		 this.driver =driver;
	 }
	 
	public  void getLoginPageTitle() {
		try {
			String ActualLoginPageTitle=driver.getTitle();
			if (ActualLoginPageTitle.equalsIgnoreCase("Guru99 Bank Home Page")) {
				System.out.println("Success : Login Page Title Verified");
			} else {
				System.out.println("Failed : Lpgin Page is not verified");
			}
		}
		catch(Exception e) {
			e.printStackTrace(System.out);
		}
		
	}
	
	public void getHomePageTitle() {
		try {
			String ActualHomePageTitle= driver.getTitle();
			if (ActualHomePageTitle.equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
				System.out.println("Success : Home Page Title Verified");
			} else {
				System.out.println("Failed : Home Page is not verified");
			}
		}
		catch(Exception e) {
			e.printStackTrace(System.out);
		}
		
		
	}

	public  void enterUserName() {
		try {
			driver.findElement(By.name("uid")).sendKeys("mngr256556");
//			userID.sendKeys("mngr256556");
		}
		catch(Exception e) {
			e.printStackTrace(System.out);
		}
		
	}

	public  void enterPassword() {
		try {
			driver.findElement(By.name("password")).sendKeys("hEzUhYz");
//			password.sendKeys("hEzUhYz");
		}
		catch(Exception e) {
			e.printStackTrace(System.out);
		}
		
	}

	public  void Login() {
		try {
			driver.findElement(By.name("btnLogin")).click();
//			loginBtn.click();
		}
		catch(Exception e) {
			e.printStackTrace(System.out);
		}
		
	}
	
	public void ErrorWindow() {
		Alert simpleAlert=driver.switchTo().alert();
		simpleAlert.accept();
	}
	
	public  void invalidUserName() {
		try {
			driver.findElement(By.name("uid")).sendKeys("Invalid");
		}
		catch(Exception e) {
			e.printStackTrace(System.out);
		}
		
	}

	public  void invalidPassword() {
		try {
			driver.findElement(By.name("password")).sendKeys("Invalid");
		}
		catch(Exception e) {
			e.printStackTrace(System.out);
		}
		
	}
	
	
	
}
