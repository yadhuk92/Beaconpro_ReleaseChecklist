package com.org.demoPackage;

import java.io.PrintWriter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcceptAlert {
	
	

	public static WebDriver AcceptAlert(WebDriver driver) {
		//System.out.println("inside alert class");
try{
				 Alert alert = driver.switchTo().alert(); 
				 alert.accept();
			        Driver.tcFlag = "PASS";
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}
			catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		
		
	}
			return driver;
	}
}


