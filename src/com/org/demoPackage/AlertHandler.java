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

public class AlertHandler {
	
	public static WebElement element;

	public static WebDriver AlertHandler(WebDriver driver, String locatorType, String propertyValue, String testData) {
		

		switch(locatorType.toLowerCase()){
		
		case "id":

			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.id(propertyValue)));
				if (element.isDisplayed() == true) {
					driver.findElement(By.id(propertyValue)).click();
					Alert alert = driver.switchTo().alert(); 
					 alert.accept();
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			//element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
			
			break;
			
		case "xpath":
			
			//System.out.println("Inside alert method");
			
			try{
				//element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue)));
				element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					
					driver.findElement(By.xpath(propertyValue)).click();
					//System.out.println("Clicked");
					Thread.sleep(5000);
					Alert alert = driver.switchTo().alert();
					//System.out.println("Switched");
					 alert.accept();
					 
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);			
			}

			break;
			
		case "name":
			
			try{
				//element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.name(propertyValue)));
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.name(propertyValue)));
				if (element.isDisplayed() == true) {
					driver.findElement(By.name(propertyValue)).click();
					Alert alert = driver.switchTo().alert(); 
					 alert.accept();
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
				break;
				
		case "linktext":
			try{
				//element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.linkText(propertyValue)));
			element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText(propertyValue)));
				if (element.isDisplayed() == true) {
					driver.findElement(By.linkText(propertyValue)).click();
					Alert alert = driver.switchTo().alert(); 
					 alert.accept();
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}

			break;
			
		case "css":
			try{
				//element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.linkText(propertyValue)));

				//if (Driver.objectName.equalsIgnoreCase("Personal_Information_Nationality_India")) {

				//}
			element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(propertyValue)));
				if (element.isDisplayed() == true) {
					driver.findElement(By.cssSelector(propertyValue)).click();
					Alert alert = driver.switchTo().alert(); 
					 alert.accept();
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{

					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}

			break;
		
		}	
		return driver;
		
	}
	public static WebDriver AcceptAlert(WebDriver driver) throws InterruptedException {

		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println("Switched");
		alert.accept();
		 
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);

		return driver;

}

}

