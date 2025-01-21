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

public class selectElement {
	public static WebElement element;

	public static WebDriver DropDownValueSelector(WebDriver driver, String locatorType, String propertyValue, String testData) throws InterruptedException {
		

		switch(locatorType.toLowerCase()){
		
		case "id":
			
			try{
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
				element = (new WebDriverWait(driver, 180)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
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
			//========================================
			String s = null;
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String flagStatus = "FALSE";

			
			for(int j=0; j<Driver.sinkWait; j++){
				//System.out.println("Select: Page Sync");
				try{
					s = js.executeScript("return document.readystate") + "True";
					if ((s.equals("completeTrue")) || (s.equals("nullTrue"))){
						break;
					}
				}catch(Exception e){
					Thread.sleep(500);
				}
			}
			for(int j=0; j<Driver.sinkWait; j++){
				//System.out.println("Select: JQuery Sync");
				try{
					
					s = js.executeScript("return jQuery.active") + "True";
					if (s.equals("0True")){
						//System.out.println("Select: JQuery Sync" + js.executeScript("return jQuery.active") + "Ravi");
						break;
					}
				}catch(Exception e){
					//System.out.println("Select: Catch JQuery Sync");
					Thread.sleep(500);
				}
			}
			
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE).perform();
			
			for(int i=0; i<60; i++){
				try{
					if(driver.findElement(By.xpath(propertyValue)).isEnabled()){
						break;
					}else{
						Thread.sleep(1000);
					}
				}catch(Exception e1){
					Thread.sleep(1000);
				}
			}
			try{
				new WebDriverWait(driver,180).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(propertyValue))))); //Changed 60 to 180 on Jan 14th, 2020 by Ravikiran
				Select dropdown = new Select(driver.findElement(By.xpath(propertyValue)));
				dropdown.selectByVisibleText(testData);		
				flagStatus = "TRUE";
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			}catch(Exception e){
				
				try{
					//new WebDriverWait(driver,5).until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(propertyValue))));
					
					
					
					Select dropdown = new Select(driver.findElement(By.xpath(propertyValue)));
					dropdown.selectByVisibleText(testData);		
					flagStatus = "TRUE";
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}catch(Exception e1){
					Driver.tcFlag = "FAIL";
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
				
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

	public static WebDriver DropDownValueSelector2(WebDriver driver, String locatorType, String propertyValue, String testData) throws InterruptedException 
	{
		switch(locatorType.toLowerCase())
		{
			case "id":
			try
			{
				for(int i=0; i<60; i++)
				{
					try
					{
						if (driver.findElement(By.id(propertyValue)).isEnabled())
						{
							Select dropdown = new Select(driver.findElement(By.id(propertyValue)));
							//driver.findElement(By.id(propertyValue)).click();
							dropdown.selectByVisibleText(testData);
							
							Actions act = new Actions(driver);
							act.sendKeys(Keys.TAB).build().perform();
							
							System.out.println("For loop else="+ i);
							Driver.tcFlag = "PASS";
							Driver.comment = "Pass" + " # " + "Selected "+ "'"+testData+ "'" +" From Drop Down";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
							break;
						}
						else
						{
							System.out.println("For loop else="+ i);
						}
					}
					catch(Exception e1)
					{
						System.out.println("Catch exception"+e1);
					}
				}
			}
			catch(Exception e)
			{
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);			
			}
						
			break;
			
			case "xpath":
				try
				{
//					if (element.isDisplayed() == true) 
//					{
						Select dropdown = new Select(driver.findElement(By.xpath(propertyValue)));
						driver.findElement(By.xpath(propertyValue)).click();
						dropdown.selectByVisibleText(testData);
						Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
//					}
//					else
//					{
//						Driver.tcFlag = "FAIL";
//						Driver.comment = Driver.objectName + " is not displayed or not identified";
//						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
//					}
						
				}
				catch(Exception e)
				{
					Driver.tcFlag = "FAIL";
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);			
				}
		}
		return driver;
	}
}

