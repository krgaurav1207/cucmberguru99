package com.myprojects.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CoreMethods{
	//static objects
	protected static WebDriver driver = null;
	public static String customerID= null;
	public static String accountID= null;
	
	//This method launches AUT
	public static void launchURL(WebDriver driver)
	{
		driver.manage().window().maximize();
		driver.get("http://www.demo.guru99.com/V4/");
	}
	
	//This method checks instance of web driver
	public static WebDriver getInstance(){
		if(driver!=null) { return driver; }
     driver = launchDriver("chrome");
     return driver;
	}
	
	//This method initiate Web driver based on browser type
	public static WebDriver launchDriver(String BrowserType) {
		if (BrowserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Repository\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	//This method handle alert automatically as well print message in case no alert is found
	public static void handleAlert(String text) {
		try {
			String alertText=driver.switchTo().alert().getText();
			System.out.println(alertText);
			driver.switchTo().alert().accept();
		}
		catch(NoAlertPresentException e)
		{
			System.out.println(text);
		}
	}
	
	//This method generate random character based on length, using alphabets and numbers based on user input
	public static String randomCharacter(int noOfCharacter,String useLetters,String useNumbers) {
		int length= noOfCharacter;
		boolean letters;
		boolean numbers;
		
		if (useLetters.equalsIgnoreCase("YES")) 
			letters=true;
		else 
			letters=false;
		
		
		if (useNumbers.equalsIgnoreCase("YES")) 
			numbers=true;
		else 
			numbers=false;
		
		String random=RandomStringUtils.random(length, letters, numbers);
		
		return random;
	}
	
	//This method checks if string is empty/null and returns boolean value
	public static boolean isNullOrEmpty(String s) {
		if(s != null && !s.isEmpty())
			return false;
		return true;
	}
	//returns today's date in ddMMyyyy format
	public static String todayDate() {
		Date date=new Date();
		String sDate=new SimpleDateFormat("ddMMyyyy").format(date);
		return sDate;
	}
	
	
	
	
}
