package com.org.demoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollDown {
	
		
	public static WebElement element;
		public static WebDriver ScrollDown(WebDriver driver, String locatorType, String propertyValue, String testData){
			
			switch(locatorType.toLowerCase()){
			case "id":
				try{
					element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
					//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
					if (element.isDisplayed() == true) {
						driver.findElement(By.id(propertyValue)).sendKeys(Keys.PAGE_DOWN);
						Driver.tcFlag = "PASS";
						//Driver.comment = "Pass";
						//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
					}else{
						Driver.tcFlag = "FAIL";
						//e.printStackTrace(new PrintWriter(Driver.errors));
						//Driver.comment = Driver.errors.toString();
						//Driver.comment = Driver.objectName + " is not displayed or not identified";
						//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					}
				}catch(Exception e){
					Driver.tcFlag = "FAIL";
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);		
					e.printStackTrace();
				}

				break;
			case "xpath":
				try{
					element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue)));
					//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
					if (element.isDisplayed() == true) {
						driver.findElement(By.xpath(propertyValue)).sendKeys(Keys.PAGE_DOWN);
						Driver.tcFlag = "PASS";
						//Driver.comment = "Pass";
						//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
					}else{
						Driver.tcFlag = "FAIL";
						//e.printStackTrace(new PrintWriter(Driver.errors));
						//Driver.comment = Driver.errors.toString();
						//Driver.comment = Driver.objectName + " is not displayed or not identified";
						//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					}
					
				}catch(Exception e){
					Driver.tcFlag = "FAIL";
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					e.printStackTrace();
				}

				break;
			case "name":
				try{
					
					element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.name(propertyValue)));
					//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
					if (element.isDisplayed() == true) {
						driver.findElement(By.name(propertyValue)).sendKeys(Keys.PAGE_DOWN);
						Driver.tcFlag = "PASS";
						//Driver.comment = "Pass";
						//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
					}else{
						Driver.tcFlag = "FAIL";
						//e.printStackTrace(new PrintWriter(Driver.errors));
						//Driver.comment = Driver.errors.toString();
						//Driver.comment = Driver.objectName + " is not displayed or not identified";
						//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
						
					}

					
				}catch(Exception e){
					Driver.tcFlag = "FAIL";
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					e.printStackTrace();
				}
				break;
			}
			return driver;
		
		
	}
	
}


