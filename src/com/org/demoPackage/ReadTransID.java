package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ReadTransID {
	
	
public static WebDriver ReadTransIdForGL_CASH(WebDriver driver,String locatorType, String propertyValue) throws IOException 
	{
		switch(locatorType.toLowerCase()) 
			{
				case "id":
				try
				{
					Properties prop = new Properties();
					InputStream input = new FileInputStream("./DataFiles/GL_CASH_Details.properties");
					prop.load(input);
					String TransID = prop.getProperty("GLTransId");
					Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TransID);	
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
					InputStream input = new FileInputStream("./DataFiles/GL_CASH_Details.properties");
					prop.load(input);
					String TransID = prop.getProperty("GLTransId");
					Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TransID);	
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
public static WebDriver ReadTransIdForGL_Batch(WebDriver driver,String locatorType, String propertyValue) throws IOException 
{
	switch(locatorType.toLowerCase()) 
		{
			case "id":
			try
			{
				Properties prop = new Properties();
				InputStream input = new FileInputStream("./DataFiles/GL_BATCH_Details.properties");
				prop.load(input);
				String TransID = prop.getProperty("GLTransId");
				Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
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
				InputStream input = new FileInputStream("./DataFiles/GL_BATCH_Details.properties");
				prop.load(input);
				String TransID = prop.getProperty("GLTransId");
				Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TransID);	
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
public static WebDriver ReadTransIdForGL_Autopost(WebDriver driver,String locatorType, String propertyValue) throws IOException 
{
	switch(locatorType.toLowerCase()) 
		{
			case "id":
			try
			{
				Properties prop = new Properties();
				InputStream input = new FileInputStream("./DataFiles/GL_AUTOPOST_Details.properties");
				prop.load(input);
				String TransID = prop.getProperty("GLTransId");
				Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
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
				InputStream input = new FileInputStream("./DataFiles/GL_AUTOPOST_Details.properties");
				prop.load(input);
				String TransID = prop.getProperty("GLTransId");
				Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TransID);	
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
public static WebDriver ReadTransIdForSL_CASH(WebDriver driver,String locatorType, String propertyValue) throws IOException 
{
	switch(locatorType.toLowerCase()) 
		{
			case "id":
			try
			{
				Properties prop = new Properties();
				InputStream input = new FileInputStream("./DataFiles/SL_CASH_Details.properties");
				prop.load(input);
				String TransID = prop.getProperty("SLTransId");
				Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
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
				InputStream input = new FileInputStream("./DataFiles/SL_CASH_Details.properties");
				prop.load(input);
				String TransID = prop.getProperty("SLTransId");
				Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TransID);	
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
public static WebDriver ReadTransIdForSL_AUTOPOST(WebDriver driver,String locatorType, String propertyValue) throws IOException 
{
	switch(locatorType.toLowerCase()) 
		{
			case "id":
			try
			{
				Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/SL_AUTOPOST_Details.properties");
	prop.load(input);
	String TransID = prop.getProperty("SLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
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
	InputStream input = new FileInputStream("./DataFiles/SL_AUTOPOST_Details.properties");
	prop.load(input);
	String TransID = prop.getProperty("SLTransId");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TransID);	
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
public static WebDriver ReadTransIdForSL_BATCH(WebDriver driver,String locatorType, String propertyValue) throws IOException 
{
	switch(locatorType.toLowerCase()) 
		{
			case "id":
			try
			{
				Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/SL_BATCH_Details.properties");
	prop.load(input);
	String TransID = prop.getProperty("SLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
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
	InputStream input = new FileInputStream("./DataFiles/SL_BATCH_Details.properties");
	prop.load(input);
	String TransID = prop.getProperty("SLTransId");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TransID);	
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
public static WebDriver ReadTransIdForSA_CASH(WebDriver driver,String locatorType, String propertyValue) throws IOException 
{
	switch(locatorType.toLowerCase()) 
		{
			case "id":
			try
			{
				Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/SA_CASH_Details.properties");
	prop.load(input);
	String TransID = prop.getProperty("SLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
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
	InputStream input = new FileInputStream("./DataFiles/SA_CASH_Details.properties");
	prop.load(input);
	String TransID = prop.getProperty("SLTransId");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TransID);	
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
public static WebDriver ReadTransIdForSA_BATCH(WebDriver driver,String locatorType, String propertyValue) throws IOException 
{
	switch(locatorType.toLowerCase()) 
		{
			case "id":
			try
			{
				Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/SA_BATCH_Details.properties");
	prop.load(input);
	String TransID = prop.getProperty("SLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
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
	InputStream input = new FileInputStream("./DataFiles/SA_BATCH_Details.properties");
	prop.load(input);
	String TransID = prop.getProperty("SLTransId");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TransID);	
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
public static WebDriver ReadTransIdForSA_AUTOPOST(WebDriver driver,String locatorType, String propertyValue) throws IOException 
{
	switch(locatorType.toLowerCase()) 
		{
			case "id":
			try
			{
				Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/SA_AUTOPOST_Details.properties");
	prop.load(input);
	String TransID = prop.getProperty("SLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
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
	InputStream input = new FileInputStream("./DataFiles/SA_AUTOPOST_Details.properties");
	prop.load(input);
	String TransID = prop.getProperty("SLTransId");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TransID);	
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
public static WebDriver GetTransIdForOD(WebDriver driver,String locatorType, String propertyValue) throws IOException 
{
	switch(locatorType.toLowerCase()) 
		{
			case "id":
			try
			{
				Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/OD_CASH_Details.properties");
	prop.load(input);
	String transId = prop.getProperty("TransId");
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
	InputStream input = new FileInputStream("./DataFiles/OD_CASH_Details.properties");
	prop.load(input);
	String transId = prop.getProperty("TransId");
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
public static WebDriver GetTransIdODCash(WebDriver driver,String locatorType, String propertyValue) throws IOException 
{
	switch(locatorType.toLowerCase()) 
		{
			case "id":
			try
			{
				Properties prop = new Properties();
				InputStream input = new FileInputStream("./DataFiles/OL_CASH_Details.properties");
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
				InputStream input = new FileInputStream("./DataFiles/OL_CASH_Details.properties");
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
public static WebDriver GetTransIdForODBatch(WebDriver driver,String locatorType, String propertyValue) throws IOException 
{
	switch(locatorType.toLowerCase()) 
		{
			case "id":
			try
			{
				Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/OD_BATCH_Details.properties");
	prop.load(input);
	String transId = prop.getProperty("TransId");
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
	InputStream input = new FileInputStream("./DataFiles/OD_BATCH_Details.properties");
	prop.load(input);
	String transId = prop.getProperty("TransId");
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
public static WebDriver GetTransIdForODAutopost(WebDriver driver,String locatorType, String propertyValue) throws IOException 
{
	switch(locatorType.toLowerCase()) 
		{
			case "id":
			try
			{
				Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/OD_AUTOPOST_Details.properties");
	prop.load(input);
	String transId = prop.getProperty("TransId");
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
	InputStream input = new FileInputStream("./DataFiles/OD_AUTOPOST_Details.properties");
	prop.load(input);
	String transId = prop.getProperty("TransId");
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
public static void GetTransIdForOLCash(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/OLCREDIT_CASH.properties");
	prop.load(input);
	String transId = prop.getProperty("OLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForOLBatch(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/OLCREDIT_BATCH.properties");
	prop.load(input);
	String transId = prop.getProperty("OLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForOLAutopost(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/OLCREDIT_AUTOPOST.properties");
	prop.load(input);
	String transId = prop.getProperty("OL_TransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForODCrCash(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/ODCREDIT_CASH.properties");
	prop.load(input);
	String transId = prop.getProperty("ODTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForODCrBatch(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/ODCREDIT_BATCH.properties");
	prop.load(input);
	String transId = prop.getProperty("ODTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForODCreditAutopost(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/ODCREDIT_AUTOPOST.properties");
	prop.load(input);
	String transId = prop.getProperty("ODTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForODDrCash(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/ODDEBIT_CASH.properties");
	prop.load(input);
	String transId = prop.getProperty("ODTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForODDrBatch(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/ODDEBIT_BATCH.properties");
	prop.load(input);
	String transId = prop.getProperty("ODTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForODDebitAutopost(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/ODDEBIT_AUTOPOST.properties");
	prop.load(input);
	String transId = prop.getProperty("ODTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForDLCrCash(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/DLCREDIT_CASH.properties");
	prop.load(input);
	String transId = prop.getProperty("DLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForDLCrBatch(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/DLCREDIT_BATCH.properties");
	prop.load(input);
	String transId = prop.getProperty("DLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForGLCrCash(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/GLCREDIT_CASH.properties");
	prop.load(input);
	String transId = prop.getProperty("GLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForGLCrBatch(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/GLCREDIT_BATCH.properties");
	prop.load(input);
	String transId = prop.getProperty("GLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForGLCreditAutopost(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/GLCREDIT_AUTOPOST.properties");
	prop.load(input);
	String transId = prop.getProperty("GLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForFDInterestPayment_Cash(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/FDINTERESTPAYMENT_CASH.properties");
	prop.load(input);
	String transId = prop.getProperty("FDTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForFDInterestPaymentBatch(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/FDINTERESTPAYMENT_BATCH.properties");
	prop.load(input);
	String transId = prop.getProperty("FDTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void ReadTransIdForFDInterestPayment_AUTOPOST(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/FDINTERESTPAYMENT_AUTOPOST.properties");
	prop.load(input);
	String TransID = prop.getProperty("SLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}
public static void GetTransIdForSBClosure_Cash(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_CASH.properties");
	prop.load(input);
	String TransID = prop.getProperty("SBTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}
public static void GetTransIdForSBClosure_Batch(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_BATCH.properties");
	prop.load(input);
	String TransID = prop.getProperty("SBTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}
public static void ReadTransIdForWriteSBAccountClosure_AUTOPOST(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_AUTOPOST.properties");
	prop.load(input);
	String TransID = prop.getProperty("SBTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}
public static void GetTransIdForFDClosure_Cash(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_CASH.properties");
	prop.load(input);
	String TransID = prop.getProperty("FDTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}

public static void GetTransIdForFDClosure_Batch(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_BATCH.properties");
	prop.load(input);
	String TransID = prop.getProperty("FDTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}
public static void GetTransIdForFDAccountClosureAutopost(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_AUTOPOST.properties");
	prop.load(input);
	String TransID = prop.getProperty("FDTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}
public static void GetTransIdForRDClosure_Cash(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_CASH.properties");
	prop.load(input);
	String TransID = prop.getProperty("FDTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}

public static void GetTransIdForRDClosure_Batch(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_BATCH.properties");
	prop.load(input);
	String TransID = prop.getProperty("FDTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}
public static void GetTransIdForRDAccountClosureAutopost(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_AUTOPOST.properties");
	prop.load(input);
	String TransID = prop.getProperty("FDTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}
public static void GetTransIdForDDClosure_Cash(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_CASH.properties");
	prop.load(input);
	String TransID = prop.getProperty("FDTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}

public static void GetTransIdForDDClosure_Batch(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_BATCH.properties");
	prop.load(input);
	String TransID = prop.getProperty("FDTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}
public static void GetTransIdForDDAccountClosureAutopost(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_AUTOPOST.properties");
	prop.load(input);
	String TransID = prop.getProperty("FDTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}
public static void GetTransIdForRIDClosure_Cash(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_CASH.properties");
	prop.load(input);
	String TransID = prop.getProperty("FDTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}

public static void GetTransIdForRIDClosure_Batch(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_BATCH.properties");
	prop.load(input);
	String TransID = prop.getProperty("FDTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}
public static void GetTransIdForRIDAccountClosureAutopost(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_AUTOPOST.properties");
	prop.load(input);
	String TransID = prop.getProperty("FDTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(TransID);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}
public static void GetTransIdForODCashCreditRenewalBatch(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/ODCASHCREDIT_RENEWAL_BATCH.properties");
	prop.load(input);
	String transId = prop.getProperty("ODTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForODCashCreditRenewalCash(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/ODCASHCREDIT_RENEWAL_CASH.properties");
	prop.load(input);
	String transId = prop.getProperty("ODTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForFDRenewalCash(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_CASH.properties");
	prop.load(input);
	String transId = prop.getProperty("FDTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForFDRenewalAutopost(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_AUTOPOST.properties");
	prop.load(input);
	String transId = prop.getProperty("FDTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForFDRenewalBatch(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_BATCH.properties");
	prop.load(input);
	String transId = prop.getProperty("FDTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForGLRenewalCash(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_CASH.properties");
	prop.load(input);
	String transId = prop.getProperty("GLTransId");
	input.close();
	
	try{
		new WebDriverWait(driver,10).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(By.id(propertyValue)))));
		Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
		
		
	}catch(Exception e){
		try{
			Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
		}catch(Exception e1){
			Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
			Driver.tcFlag = "FAIL";
			Driver.comment = Driver.objectName  + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
		}
	}
	
	
	
	
}
public static WebDriver GetTransIdForGLRenewalBatch(WebDriver driver,String locatorType, String propertyValue) throws IOException, InterruptedException 
	{
		switch(locatorType.toLowerCase()) 
		{
		case "xpath":
			try
			{
				Thread.sleep(6000);
				Properties prop = new Properties();
				InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_BATCH.properties");
				prop.load(input);
				String transId = prop.getProperty("GLTransId");
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
		case "id":
			try
			{
				Thread.sleep(6000);
				Properties prop = new Properties();
				InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_BATCH.properties");
				prop.load(input);
				String transId = prop.getProperty("GLTransId");
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
public static void GetTransIdForGLRenewalAutopost(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_AUTOPOST.properties");
	prop.load(input);
	String transId = prop.getProperty("GLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForOLClosure_Cash(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/OL_CLOSURE_CASH.properties");
	prop.load(input);
	String transId = prop.getProperty("OLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForODClosure_Cash(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/OD_CLOSURE_CASH.properties");
	prop.load(input);
	String transId = prop.getProperty("ODTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForDLClosure_Cash(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/DL_CLOSURE_CASH.properties");
	prop.load(input);
	String transId = prop.getProperty("DLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForGLClosure_Cash(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/GL_CLOSURE_CASH.properties");
	prop.load(input);
	String transId = prop.getProperty("GLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForOLClosureAutopost(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/OLCLOSURE_AUTOPOST.properties");
	prop.load(input);
	String transId = prop.getProperty("OL_TransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}

public static void GetTransIdForODClosureAutopost(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/ODCLOSURE_AUTOPOST.properties");
	prop.load(input);
	String transId = prop.getProperty("OD_TransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForDLClosureAutopost(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/DLCLOSURE_AUTOPOST.properties");
	prop.load(input);
	String transId = prop.getProperty("DL_TransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForGLClosureAutopost(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/GLCLOSURE_AUTOPOST.properties");
	prop.load(input);
	String transId = prop.getProperty("DL_TransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForOLClosure_Batch(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/OL_CLOSURE_BATCH.properties");
	prop.load(input);
	String transId = prop.getProperty("OLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForODClosure_Batch(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/OD_CLOSURE_BATCH.properties");
	prop.load(input);
	String transId = prop.getProperty("ODTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForDLClosure_Batch(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/DL_CLOSURE_BATCH.properties");
	prop.load(input);
	String transId = prop.getProperty("DLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void GetTransIdForGLClosure_Batch(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/GL_CLOSURE_BATCH.properties");
	prop.load(input);
	String transId = prop.getProperty("GLTransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	
}
public static void getTransid(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/ShareOpening_CashMode_Details.properties");
	prop.load(input);
	String transId = prop.getProperty("ShareAc_TransId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getTransid_Autopost(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/ShareOpening_TransferMode_Details.properties");
	prop.load(input);
	String transId = prop.getProperty("Share_TransactionId");
	Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static WebDriver WriteGLRenewCash(WebDriver driver,String locatorType, String propertyValue) throws ClassNotFoundException, SQLException, IOException 
{
	switch(locatorType.toLowerCase()) 
	{
		case "id":
		try
		{
	    String transid = driver.findElement(By.id(propertyValue)).getText();
	    System.out.println("GL Renew cash transid="+ transid);
		
		Properties prop=new Properties();
		
		FileOutputStream fos = new FileOutputStream("./DataFiles/GL_RENEWAL_CASH_NEW.properties");
		prop.setProperty("GLRenwCashTransid", transid);
		
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.comment = "Pass" + " # " + "Transid = " + transid;
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		
		//System.out.println("Written");
		prop.store(fos, "Done");
		fos.close();
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
			String transid = driver.findElement(By.xpath(propertyValue)).getText();
		    System.out.println("GL Renew cash transid="+ transid);
			
			Properties prop=new Properties();
			
			FileOutputStream fos = new FileOutputStream("./DataFiles/GL_RENEWAL_CASH_NEW.properties");
			prop.setProperty("GLRenwCashTransid", transid);
			
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass";
			Driver.comment = "Pass" + " # " + "Transid = " + transid;
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			
			//System.out.println("Written");
			prop.store(fos, "Done");
			fos.close();
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

public static void GetTransIdForGLRenewalCash2(WebDriver driver, String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_CASH_NEW.properties");
	prop.load(input);
	String transId = prop.getProperty("GLRenwCashTransid");
	input.close();
	
	try{
		new WebDriverWait(driver,10).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(By.id(propertyValue)))));
		Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
		
		
	}catch(Exception e){
		try{
			Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
		}catch(Exception e1){
			Driver.driver.findElement(By.id(propertyValue)).sendKeys(transId);	
			Driver.tcFlag = "FAIL";
			Driver.comment = Driver.objectName  + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
		}
	}
}
	
}
