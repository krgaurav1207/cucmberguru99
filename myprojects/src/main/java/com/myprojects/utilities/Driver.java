package com.myprojects.utilities;

import org.openqa.selenium.WebDriver;

public class Driver {

	protected static WebDriver driver = null;
	
	public static WebDriver getInstance(){
		if(driver!=null) { return driver; }
     driver = DriverFactory.launchDriver("chrome");
     return driver;
	}
}
