package com.org.demoPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class MenuFinder {

	public static void Menu_Finder(WebDriver driver,String locatorType,String propertyValue) {
		

		switch(locatorType.toLowerCase()){
				
		case "xpath":
			
			
			try {
		Actions actions = new Actions(driver);
		WebElement element= driver.findElement(By.xpath(propertyValue));
		actions.moveToElement(element).click().perform();
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);  
					}catch( Exception e){
						Driver.tcFlag = "FAIL";
						Driver.comment = Driver.objectName + " is not displayed or not identified";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
							}
				break;
				
		case "id":
			try{
				Actions actions = new Actions(driver);
				WebElement element= driver.findElement(By.id(propertyValue));
				actions.moveToElement(element).click().perform();
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);  
							}catch( Exception e){
								Driver.tcFlag = "FAIL";
								Driver.comment = Driver.objectName + " is not displayed or not identified";
								Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
									}
						break;
			
		case "name":
			try{
				Actions actions = new Actions(driver);
				WebElement element= driver.findElement(By.name(propertyValue));
				actions.moveToElement(element).click().perform();
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);  
							}catch( Exception e){
								Driver.tcFlag = "FAIL";
								Driver.comment = Driver.objectName + " is not displayed or not identified";
								Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
									}
						break;
		}
	}
}