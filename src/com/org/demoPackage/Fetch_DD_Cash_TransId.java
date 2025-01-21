package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Fetch_DD_Cash_TransId 
{
	
	
	public static WebDriver getTransid(WebDriver driver,String locatorType, String propertyValue) throws IOException, InterruptedException 
	{
		
		switch(locatorType.toLowerCase()) 
		{
			case "id":
			try
			{
				Properties prop = new Properties();
				InputStream input = new FileInputStream("./DataFiles/DD_CASH_Details.properties");
				//Commented below code on Feb 13th, 2019 by Ravikiran
				//InputStream input = new FileInputStream("./DataFiles/DD_BATCH_Details.properties");
				prop.load(input);
				String transId = prop.getProperty("DD_TransId");
				Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
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
				Properties prop = new Properties();
				InputStream input = new FileInputStream("./DataFiles/DD_CASH_Details.properties");
				//Commented below code on Feb 13th, 2019 by Ravikiran
				//InputStream input = new FileInputStream("./DataFiles/DD_BATCH_Details.properties");
				prop.load(input);
				String transId = prop.getProperty("DD_TransId");
				Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId);	
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			}
			catch(Exception e)
			{
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			
			break;
		}
		return driver;
	}	
	}


