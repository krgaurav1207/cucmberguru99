package com.myprojects.utilities;

import org.openqa.selenium.WebDriver;

public class CoreMethods extends DriverFactory{
	public static void launchURL(WebDriver driver)
	{
		driver.manage().window().maximize();
		driver.get("http://www.demo.guru99.com/V4/");
		}
}
