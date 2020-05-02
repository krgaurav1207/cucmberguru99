package com.myprojects.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	static WebDriver driver;

	public static WebDriver launchDriver(String BrowserType) {
		if (BrowserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Repository\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
}
