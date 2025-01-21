package com.org.demoPackage;

import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Copy_of_Enter_Jan_17 {
	
	public static WebElement element;

	public static WebDriver Enter(WebDriver driver, String locatorType, String propertyValue, String testData) {
		

		switch(locatorType.toLowerCase()){
		
		case "id":
			
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.id(propertyValue)).click();
					//driver.findElement(By.id(propertyValue)).clear();
					driver.findElement(By.id(propertyValue)).sendKeys(testData);
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
			
		case "xpath":
			
			try{
				
				if ((Driver.objectName.toUpperCase().contains("AADHAARNO")) || (Driver.objectName.toUpperCase().contains("IDENTITYNO")) || (Driver.objectName.toUpperCase().contains("EMPCODE"))){
					testData = Driver.uniquenumber;
				}
				
				element = new WebDriverWait(driver,Driver.sinkWait).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));

				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if ((element.isDisplayed() == true) && (element.isEnabled() == true)) {
					for(int i=0; i<Driver.sinkWait; i++)
					{
						try {
							
					driver.findElement(By.xpath(propertyValue)).click();
					driver.findElement(By.xpath(propertyValue)).clear();
					driver.findElement(By.xpath(propertyValue)).sendKeys(testData);
					Thread.sleep(1000);
					//driver.manage().timeouts().pageLoadTimeout(Driver.sinkWait, TimeUnit.SECONDS);
					
					Driver.tcFlag = "PASS";
					break;
						}catch(Exception e)
						{
							Thread.sleep(500);
						}
						
					}
					
					//driver.findElement(By.xpath(propertyValue)).click();

					//Driver.tcFlag = "PASS";
					if (Driver.tcFlag == "PASS") {
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				}
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}
			
			
			break;
			
		case "name":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.name(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.name(propertyValue)).click();
					//driver.findElement(By.name(propertyValue)).clear();
					driver.findElement(By.name(propertyValue)).sendKeys(testData);
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
			
		case "css":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.cssSelector(propertyValue)).click();
					driver.findElement(By.cssSelector(propertyValue)).clear();
					driver.findElement(By.cssSelector(propertyValue)).sendKeys(testData);
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
	
	public static WebDriver PressEnterKey(WebDriver driver, String locatorType, String propertyValue, String testData){
		
		switch(locatorType.toLowerCase()){
		case "id":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.id(propertyValue)).sendKeys(Keys.ENTER);
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
					driver.findElement(By.xpath(propertyValue)).sendKeys(Keys.ENTER);
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
					driver.findElement(By.name(propertyValue)).sendKeys(Keys.ENTER);
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

	public static WebDriver PressDownArrow(WebDriver driver, String locatorType, String propertyValue, String testData){
		
		switch(locatorType.toLowerCase()){
		case "id":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.id(propertyValue)).sendKeys(Keys.ARROW_DOWN);
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
			}

			break;
		case "xpath":
			
			
			
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.xpath(propertyValue)).sendKeys(Keys.ARROW_DOWN);
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
			}

			break;
		case "name":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.name(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.name(propertyValue)).sendKeys(Keys.ARROW_DOWN);
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
			}
			
			break;
		}
		return driver;
	}
	
	public static WebDriver PressTabKey(WebDriver driver, String locatorType, String propertyValue, String testData) {
		switch(locatorType.toLowerCase()){
		case "id":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.id(propertyValue)).sendKeys(Keys.TAB);
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
			}

			break;
		case "xpath":
			
			try{
				element = new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					
					for(int i=0; i<Driver.sinkWait; i++)
					{
						try {
					driver.findElement(By.xpath(propertyValue)).sendKeys(Keys.TAB);
					//driver.manage().timeouts().pageLoadTimeout((Driver.sinkWait)/12, TimeUnit.SECONDS);
					JavascriptExecutor js = (JavascriptExecutor)driver;
					String flag1 = "FALSE";
					String flag2 = "FALSE";
					String s;
					
					for (int j=0; j<Driver.sinkWait; j++)
					{
						try{
							if (js.executeScript("return document.readyState").toString().equals("complete")){
								flag1 = "TRUE";
								break;
							}
						}catch(Exception e){
							Thread.sleep(500);
						}
					}
					
					for (int k=0; k<Driver.sinkWait; k++)
					{
						 s = js.executeScript("return jQuery.active")+ "TRUE";
						try{
							if (s.equals("0TRUE")){
								flag2 = "TRUE";
								Thread.sleep(1000);
								//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								break;
							}
							
						}catch(Exception e){
							Thread.sleep(500);
						}
					}
					//=============================== Async Wait Starts =============
					
					
					//=============================== Async Wait Ends ===============
					Driver.tcFlag = "PASS";
					break;
						}catch(Exception e)
						{
							Thread.sleep(500);
						}
						
					}
					
					//driver.findElement(By.xpath(propertyValue)).click();

					//Driver.tcFlag = "PASS";
					if (Driver.tcFlag == "PASS") {
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);

				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);

				}
				}
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				//Driver.comment = Driver.objectName + " is not displayed or not identified";
				//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			
			break;
		case "name":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.name(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.name(propertyValue)).sendKeys(Keys.TAB);
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
			}

			break;
		}
		return driver;
	}

	
	public static WebDriver Type(WebDriver driver, String testData)  {
		Actions action = new Actions(driver);
		action.sendKeys(testData).perform();
		Driver.tcFlag = "PASS";
		return driver;
	}
	
	public static WebDriver PressUpArrow(WebDriver driver, String locatorType, String propertyValue, String testData) {
		switch(locatorType.toLowerCase()){
		case "id":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.id(propertyValue)).sendKeys(Keys.ARROW_UP);
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
			}

			break;
		case "xpath":
			
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.xpath(propertyValue)).sendKeys(Keys.ARROW_UP);
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
			}
			
			break;
		case "name":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.name(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.name(propertyValue)).sendKeys(Keys.ARROW_UP);
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
			}

			break;
		}
		return driver;
	}
	
public static WebDriver PressDeleteKey(WebDriver driver, String locatorType, String propertyValue, String testData){
		
		switch(locatorType.toLowerCase()){
		case "id":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.id(propertyValue)).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
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
			}

			break;
		case "xpath":
			
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.xpath(propertyValue)).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
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
			}

			break;
		case "name":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.name(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.name(propertyValue)).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
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
			}
			
			break;
		}
		return driver;
	}
	

}
