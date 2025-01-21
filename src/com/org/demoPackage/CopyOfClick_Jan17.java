package com.org.demoPackage;

import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CopyOfClick_Jan17 {

	public static WebElement element;

	public static WebDriver Click(WebDriver driver, String locatorType, String propertyValue, String testData) throws InterruptedException {
		
		
		switch(locatorType.toLowerCase()){
		
		case "id":
			
			try{
				
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.id(propertyValue)));
				if (element.isDisplayed() == true) {
					driver.findElement(By.id(propertyValue)).click();
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
			
			String exeflag = "TRUE";
			//=============================== Async Wait Starts =============
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			String flag1 = "FALSE";
			String flag2 = "FALSE";
			String s;
			
			for (int j=0; j<Driver.sinkWait; j++)
			{
				if (Driver.objectName.equals("Beacon_ChittyApplication_Transfer_Submitbtn"))
				 {
					 System.out.println("Inside Page wait: " + js.executeScript("return document.readyState").toString() );
				 }
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
				 if (Driver.objectName.equals("Beacon_ChittyApplication_Transfer_Submitbtn"))
				 {
					 System.out.println(Driver.objectName + " " + s);
				 }
				try{
					if (s.equals("0TRUE")){
						flag2 = "TRUE";
						Thread.sleep(500);
						//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						break;
					}
					
				}catch(Exception e){
					Thread.sleep(500);
				}
			}

			

			//=============================== Async Wait Ends ===============

			try{
				//System.out.println("inside click");
				//element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue)));
				//element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));

				//element = driver.findElement(By.xpath(propertyValue));
				
				
				if (Driver.objectName.toUpperCase().equals("COLLAPSEALL")) {
					try 
					{
						element= new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
						element.click();
						break;
					}catch(Exception e)
					{
						exeflag = "FALSE";
						Driver.comment = "Pass";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
					}
					
				}
				
				if (exeflag == "TRUE")
				{
				element= new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue))); 
				//element= new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue))));
				
				
				
				if (element.isDisplayed() == true) {
					
					for(int i=0; i<Driver.sinkWait; i++)
					{
						try {
							driver.findElement(By.xpath(propertyValue)).click();
							Driver.tcFlag = "PASS";
							
							if (Driver.objectName.equals("Beacon_ChittyApplication_Transfer_Submitbtn"))
							 {
								 System.out.println("Inside click");
							 }
							
							//driver.manage().timeouts().pageLoadTimeout((Driver.sinkWait)/12, TimeUnit.SECONDS);
							//Originally wait code was here
							
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
						Driver.comment = Driver.objectName + " is not displayed or not identified";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					}
					//Driver.comment = "Pass";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
					//}else{
					//Driver.tcFlag = "FAIL";
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					
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
				//element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.name(propertyValue)));
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.name(propertyValue)));
				if (element.isDisplayed() == true) {
					driver.findElement(By.name(propertyValue)).click();
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
	

}
