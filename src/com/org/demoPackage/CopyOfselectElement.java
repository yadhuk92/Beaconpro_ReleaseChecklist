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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CopyOfselectElement {
	public static WebElement element;

	public static WebDriver DropDownValueSelector(WebDriver driver, String locatorType, String propertyValue, String testData) {
		

		switch(locatorType.toLowerCase()){
		
		case "id":
			
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
				if (element.isDisplayed() == true) {
					Select dropdown = new Select(driver.findElement(By.id(propertyValue)));
					//dropdown.selectByVisibleText(testData);
					driver.findElement(By.id(propertyValue)).click();
					//dropdown.selectByVisibleText(testData);
					dropdown.selectByVisibleText(testData);
					//driver.findElement(By.id(propertyValue)).sendKeys(testData);
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
			
		case "xpath":
			
			try{
				element = new WebDriverWait(driver,Driver.sinkWait).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				//element= new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue)));
				if ((element.isDisplayed() == true) && (element.isEnabled() == true)) {
					
					for(int i=0; i<Driver.sinkWait; i++)
					{
						try {
					Select dropdown = new Select(driver.findElement(By.xpath(propertyValue)));
					//System.out.println(testData);
					dropdown.selectByVisibleText(testData);		
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
					
					
					if (Driver.tcFlag == "PASS") {
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);

			}
			
			
			break;
			
		case "name":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.name(propertyValue)));
				if (element.isDisplayed() == true) {
					Select dropdown = new Select(driver.findElement(By.name(propertyValue)));
					//dropdown.selectByVisibleText(testData);
					driver.findElement(By.name(propertyValue)).click();
					dropdown.selectByVisibleText(testData);
					//driver.findElement(By.name(propertyValue)).sendKeys(testData);
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
		}
		
		
		return driver;
		
		
		
	}

}

