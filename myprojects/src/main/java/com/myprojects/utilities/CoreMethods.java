package com.myprojects.utilities;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CoreMethods{
	
	protected static WebDriver driver = null;
	
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
			driver.switchTo().alert().accept();
		}
		catch(NoAlertPresentException e)
		{
			System.out.println(text);
		}
	}
	
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
}
