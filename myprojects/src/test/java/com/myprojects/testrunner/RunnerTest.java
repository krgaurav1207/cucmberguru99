package com.myprojects.testrunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.myprojects.utilities.CoreMethods;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 

@CucumberOptions(
		 features = "src//test//java//FeatureFiles"
		 ,glue={"com.myprojects.stepdefination"},
				plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
			        monochrome = true,
			        		tags= {"@CustomisedStatementForDeletedAccount"}
//		 multiple tags can be passed as
//			        tags= {"@InvalidUserID,@InvalidUserIDPassword"}
			        		
		 )
public class RunnerTest {
	 @AfterClass
	    public static void writeExtentReport() {
	        Reporter.loadXMLConfig(new File("ConfigurationFiles//report.xml"));
	        WebDriver driver = CoreMethods.getInstance();
	        driver.quit();
}
	 
	 
	 
	 
}

