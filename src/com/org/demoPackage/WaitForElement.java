package com.org.demoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {
	
	public static int i=0;
	public static WebElement element;
	
	public static WebDriver WaitTillElementIsDisplayed(WebDriver driver, String locatorType, String propertyValue, String testData){
		
		switch(locatorType.toLowerCase()){
		case "id":
			
			System.out.println(IsDisplayedById(driver, propertyValue));
			break;
		case "xpath":
			System.out.println(IsDisplayedByXpath(driver, propertyValue));
			break;
		case "name":
			System.out.println(IsDisplayedByName(driver, propertyValue));
			break;
		}
		
		return driver;
	}

	public static WebDriver IsDisplayedByXpath(WebDriver driver, String propertyValue) {
		
		try{
			//By byXpath = By.xpath(propertyValue); 
			//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.textToBePresentInElement(byXpath, text)(byXpath));
			//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(propertyValue)));
			System.out.println("Trisha: " + driver.findElement(By.xpath(propertyValue)).getText());
			if(element.isDisplayed() == true) {
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}else{
				Driver.tcFlag = "FAIL";
				//e.printStackTrace();
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				
			}
			
		}catch (Exception e){
			Driver.tcFlag = "FAIL";
			//e.printStackTrace();
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			
		}
		return driver;
	
	}
	
	
	
	public static WebDriver IsDisplayedById(WebDriver driver, String propertyValue) {		
		try{
			By byXpath = By.id(propertyValue); 
			element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.presenceOfElementLocated(byXpath));
			//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.presenceOfElementLocated(By.id(propertyValue)));
			if(element.isDisplayed() == true) {
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}else{
				Driver.tcFlag = "FAIL";
				//e.printStackTrace();
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				
			}
			
		}catch (Exception e){
			Driver.tcFlag = "FAIL";
			//e.printStackTrace();
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			
		}
		return driver;
	
	}
	
	
	public static WebDriver IsDisplayedByName(WebDriver driver, String propertyValue) {	
		try{
			By byXpath = By.name(propertyValue); 
			element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.presenceOfElementLocated(byXpath));

			//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.presenceOfElementLocated(By.name(propertyValue)));
			if(element.isDisplayed() == true) {
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}else{
				Driver.tcFlag = "FAIL";
				//e.printStackTrace();
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				
			}
			
		}catch (Exception e){
			Driver.tcFlag = "FAIL";
			//e.printStackTrace();
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			
		}
		return driver;
	
	}
}
