package com.org.demoPackage;

import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CopyOfEnter {
	
	

	public static void Enter(WebDriver driver, String locatorType, String propertyValue, String testData) {
		

		switch(locatorType.toLowerCase()){
		
		case "id":
			try{
				//WaitForElement.IsDisplayedById(driver, propertyValue);	
				//driver.findElement(By.id(propertyValue)).click();
				//driver.findElement(By.id(propertyValue)).clear();
				driver.findElement(By.id(propertyValue)).sendKeys(testData);
				Thread.sleep(1000);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				e.printStackTrace(new PrintWriter(Driver.errors));
				Driver.comment = Driver.errors.toString();
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			break;
			
		case "xpath":
			try{
				//WaitForElement.IsDisplayedByXpath(driver, propertyValue);
				WebElement element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='__input1-inner']")));
				driver.findElement(By.xpath(propertyValue)).click();
				driver.findElement(By.xpath(propertyValue)).clear();
				driver.findElement(By.xpath(propertyValue)).sendKeys(testData);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				Thread.sleep(1000);
				}catch(Exception e){
					Driver.tcFlag = "FAIL";
					e.printStackTrace(new PrintWriter(Driver.errors));
					Driver.comment = Driver.errors.toString();
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
			break;
			
		case "name":
			try{
				//WaitForElement.IsDisplayedByname(driver, propertyValue);
				driver.findElement(By.name(propertyValue)).click();
				driver.findElement(By.name(propertyValue)).clear();
				driver.findElement(By.name(propertyValue)).sendKeys(testData);
				Thread.sleep(1000);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}catch(Exception e){
					Driver.tcFlag = "FAIL";
					e.printStackTrace(new PrintWriter(Driver.errors));
					Driver.comment = Driver.errors.toString();
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
			break;
			
				
		}
		
		
		//return driver;
		
		
		
	}
	
	public static void PressEnterKey(WebDriver driver, String locatorType, String propertyValue, String testData){
		
		switch(locatorType.toLowerCase()){
		case "id":
			try{
				driver.findElement(By.id(propertyValue)).sendKeys(Keys.ENTER);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			}catch (Exception e){
				Driver.tcFlag = "FAIL";
				e.printStackTrace(new PrintWriter(Driver.errors));
				Driver.comment = Driver.errors.toString();
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}

			break;
		case "xpath":
			try{
				driver.findElement(By.xpath(propertyValue)).sendKeys(Keys.ENTER);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			}catch (Exception e){
				Driver.tcFlag = "FAIL";
				e.printStackTrace(new PrintWriter(Driver.errors));
				Driver.comment = Driver.errors.toString();
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}

			
			break;
		case "name":
			try{
				driver.findElement(By.name(propertyValue)).sendKeys(Keys.ENTER);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			}catch (Exception e){
				Driver.tcFlag = "FAIL";
				e.printStackTrace(new PrintWriter(Driver.errors));
				Driver.comment = Driver.errors.toString();
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			
			break;
		}
	}

	public static void PressDownArrow(WebDriver driver, String locatorType, String propertyValue, String testData){
		
		switch(locatorType.toLowerCase()){
		case "id":
			try{
				//Thread.sleep(3000);
				driver.findElement(By.id(propertyValue)).sendKeys(Keys.ARROW_DOWN);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			}catch (Exception e){
				Driver.tcFlag = "FAIL";
				e.printStackTrace(new PrintWriter(Driver.errors));
				Driver.comment = Driver.errors.toString();
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}

			break;
		case "xpath":
			try{
				//Thread.sleep(3000);
				driver.findElement(By.xpath(propertyValue)).sendKeys(Keys.ARROW_DOWN);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			}catch (Exception e){
				Driver.tcFlag = "FAIL";
				e.printStackTrace(new PrintWriter(Driver.errors));
				Driver.comment = Driver.errors.toString();
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}

			
			break;
		case "name":
			try{
				//Thread.sleep(3000);
				driver.findElement(By.name(propertyValue)).sendKeys(Keys.ARROW_DOWN);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			}catch (Exception e){
				Driver.tcFlag = "FAIL";
				e.printStackTrace(new PrintWriter(Driver.errors));
				Driver.comment = Driver.errors.toString();
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			
			break;
		}
	}
	
	public static void PressTabKey(WebDriver driver, String locatorType, String propertyValue, String testData) {
		switch(locatorType.toLowerCase()){
		case "id":
			try{
				driver.findElement(By.id(propertyValue)).sendKeys(Keys.TAB);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			}catch (Exception e){
				Driver.tcFlag = "FAIL";
				e.printStackTrace(new PrintWriter(Driver.errors));
				Driver.comment = Driver.errors.toString();
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}

			break;
		case "xpath":
			try{
				driver.findElement(By.xpath(propertyValue)).sendKeys(Keys.TAB);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			}catch (Exception e){
				Driver.tcFlag = "FAIL";
				e.printStackTrace(new PrintWriter(Driver.errors));
				Driver.comment = Driver.errors.toString();
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}

			
			break;
		case "name":
			try{
				driver.findElement(By.name(propertyValue)).sendKeys(Keys.TAB);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			}catch (Exception e){
				Driver.tcFlag = "FAIL";
				e.printStackTrace(new PrintWriter(Driver.errors));
				Driver.comment = Driver.errors.toString();
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			
			break;
		}
	}
	
	public static WebDriver Type(WebDriver driver, String testData)  {
		Actions action = new Actions(driver);
		action.sendKeys(testData).perform();
		Driver.tcFlag = "PASS";
		return driver;
	}

}
