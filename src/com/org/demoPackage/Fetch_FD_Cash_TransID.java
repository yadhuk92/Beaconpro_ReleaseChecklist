/*package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Fetch_FD_Cash_TransID {
	
public static int NoOfRows;

public static void getTransid(WebDriver driver ,String propertyValue) throws IOException, InterruptedException {
		
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/FD_CASH_Details.properties");
	prop.load(input);
	String transId = prop.getProperty("TransID1");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	}

}
*/

package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Fetch_FD_Cash_TransID {
	
public static int NoOfRows;

public static WebDriver getTransid(WebDriver driver,String locatorType, String propertyValue) throws IOException, InterruptedException 
{
	switch(locatorType.toLowerCase()) 
	{
		case "id":
		try
		{
			Properties prop = new Properties();
			InputStream input = new FileInputStream("./DataFiles/FD_CASH_Details.properties");
			prop.load(input);
			String transId = prop.getProperty("TransID1");
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
			InputStream input = new FileInputStream("./DataFiles/FD_CASH_Details.properties");
			prop.load(input);
			String transId = prop.getProperty("TransID1");
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
	}
	return driver;
}

}