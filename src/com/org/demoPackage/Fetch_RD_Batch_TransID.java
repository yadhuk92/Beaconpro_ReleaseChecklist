package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Fetch_RD_Batch_TransID {
	
public static WebDriver getTransid(WebDriver driver,String locatorType, String propertyValue) throws IOException 
	{
	switch(locatorType.toLowerCase()) 
	{
		case "id":
		try
		{
			Properties prop = new Properties();
			InputStream input = new FileInputStream("./DataFiles/RDAccountOpening_BatchMode.properties");
			prop.load(input);
			String transId = prop.getProperty("FDAc_TransId");
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
			InputStream input = new FileInputStream("./DataFiles/RDAccountOpening_BatchMode.properties");
			prop.load(input);
			String transId = prop.getProperty("FDAc_TransId");
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


