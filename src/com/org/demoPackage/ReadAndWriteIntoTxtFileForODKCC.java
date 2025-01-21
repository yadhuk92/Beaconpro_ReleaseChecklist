package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReadAndWriteIntoTxtFileForODKCC
{
	public static String Element2 = null;
	
	public static WebDriver Write(WebDriver driver, String locatorType, String propertyValue, String testData) throws IOException
	{
		switch(locatorType.toLowerCase()) 
		{
		case "id":
			Properties prop=new Properties();
			
			//String element1 = driver.findElement(By.id(propertyValue)).getAttribute("value");
			String element = driver.findElement(By.id(propertyValue)).getText();
			//System.out.println("element = "+element1);
			System.out.println("element="+element);
			FileOutputStream fos = new FileOutputStream(testData);
			//prop.setProperty("Element 1 = ", element1);
			prop.setProperty("Element",element);
			
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass";
			Driver.comment = "Pass" + " # " + "Details written into file " + testData;
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			prop.store(fos, "Done");
			fos.close();
			//return driver;
		}
		return driver;
	}
	
	public static void Read (WebDriver driver,String propertyValue, String testData) throws InterruptedException, IOException
	{
			Properties prop = new Properties();
			InputStream input = new FileInputStream(testData);
			prop.load(input);
			Element2 = prop.getProperty("Element");
			//Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(IntPostODTransID);
			//System.out.println("Locker number = "+Element2);
			String Sub1 = Element2.substring(8);
			System.out.println("Sub string = "+Sub1);
			Driver.tcFlag = "PASS";
			//Driver.comment = "Pass";
			Driver.comment = "Pass" + " # " + "Account number readed from file= " + Element2; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		
			driver.findElement(By.xpath(propertyValue)).sendKeys(Sub1);
			//System.out.println("For loop if = "+propertyValue);
	}
	
	public static WebDriver WriteODKCCIntPostingTransIDIntoTXTFile(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException, IOException 
	{
		  String IntPostODTransID=null;
		  Connection con=(Connection) Common.DatabaseConnector();
		  Statement stmt = con.createStatement();
		  
		  String SQL1 = "select TransID from interestpostingmaster where postingdate in (select * from TransactionDate) and recordstatus=1 order by IntApplicationID desc";
			ResultSet rs2= stmt.executeQuery(SQL1);
			int counter = 0;
			//System.out.println("IntPostODTransID");
	    	while(rs2.next()) 
	    	{
	    		counter = counter + 1;
	    		IntPostODTransID=rs2.getString(1);
	    		System.out.println("IntPostODTransID="+IntPostODTransID);
	    	}
			//driver.findElement(By.id(propertyValue)).sendKeys(IntPostODTransID);
			
			Properties prop=new Properties();
			
			FileOutputStream fos = new FileOutputStream("./DataFiles/IntPostODKCCTransID.properties");
			prop.setProperty("IntPostODTransID",IntPostODTransID);
			
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass";
			Driver.comment = "Pass" + " # " + "Interest Posting ODKCC TransID = " + IntPostODTransID;
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			
			//System.out.println("Written");
			prop.store(fos, "Done");
			fos.close();
			return driver;
	}
	
	public static WebDriver WriteUsingGetAttribute(WebDriver driver, String locatorType, String propertyValue, String testData) throws IOException
	{
		switch(locatorType.toLowerCase()) 
		{
		case "id":
			Properties prop=new Properties();
			
			String element = driver.findElement(By.id(propertyValue)).getAttribute("value");
			//String element = driver.findElement(By.id(propertyValue)).getText();
			//String element = driver.findElement(By.id(propertyValue)).getText();
			//System.out.println("element = "+element1);
			System.out.println("element="+element);
			FileOutputStream fos = new FileOutputStream(testData);
			//prop.setProperty("Element 1 = ", element1);
			prop.setProperty("Element",element);
			
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass";
			Driver.comment = "Pass" + " # " + "Details written into file " + testData;
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			prop.store(fos, "Done");
			fos.close();
			//return driver;
		}
		return driver;
	}
	
	public static WebDriver GetTransDateFromTableAndSaveIntoSpecifiedFile(WebDriver driver, String locatorType, String propertyValue, String testData) throws IOException, ClassNotFoundException, SQLException
	{
		String columnValue1 = null;
		String columnValue2 = null;
		String columnValue3 = null;
		String columnValue4 = null;
		String columnValue5 = null;
		String columnValue6 = null;
		
		Connection con = Common.DatabaseConnector();
		Statement stmt = con.createStatement();
		
		String SQL1="exec GetTransactionDateinDifferentFormat";
		//String SQL2="exec GetTransactionDateinDifferentFormat 2";
		//String SQL3="exec GetTransactionDateinDifferentFormat 3";
		
		ResultSet rs1= stmt.executeQuery(SQL1);
		//ResultSet rs2= stmt.executeQuery(SQL1);
		//ResultSet rs3= stmt.executeQuery(SQL3);
		
		ResultSetMetaData rsmd1 = rs1.getMetaData();
		//ResultSetMetaData rsmd2 = rs2.getMetaData();
		//ResultSetMetaData rsmd3 = rs3.getMetaData();
		
		while (rs1.next()) 
		{
			columnValue1 = rs1.getString("yyyymmdd");
		    System.out.println(rsmd1.getColumnName(1) + " =" + columnValue1);
		    
		    columnValue2 = rs1.getString("ddmmyyyy");
		    System.out.println(rsmd1.getColumnName(2) + " =" + columnValue2);
		    
		    columnValue3 = rs1.getString("Date");
		    System.out.println(rsmd1.getColumnName(3) + " =" + columnValue3);
		    
		    columnValue4 = rs1.getString("Month");
		    System.out.println(rsmd1.getColumnName(4) + " =" + columnValue4);
		    
		    columnValue5 = rs1.getString("Year");
		    System.out.println(rsmd1.getColumnName(5) + " =" + columnValue5);
		    
		    columnValue6 = rs1.getString("ddmmyyyyWithSlash");
		    System.out.println(rsmd1.getColumnName(6) + " =" + columnValue6);
		}
		
		Properties prop=new Properties();
		FileOutputStream fos = new FileOutputStream(testData);
		
		prop.setProperty("yyyymmdd",columnValue1);
		prop.setProperty("ddmmyyyy",columnValue2);
		prop.setProperty("Date",columnValue3);
		prop.setProperty("Month",columnValue4);
		prop.setProperty("Year",columnValue5);
		prop.setProperty("ddmmyyyyWithSlash",columnValue6);
		
		prop.store(fos, "Done");
		fos.close();
		return driver;
	}
	
	public static void CommonRead (WebDriver driver,String propertyValue, String testData) throws InterruptedException, IOException
	{
			Properties prop = new Properties();
			InputStream input = new FileInputStream(testData);
			prop.load(input);
			Element2 = prop.getProperty("Element");
			//Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(IntPostODTransID);
			//System.out.println("Locker number = "+Element2);
			String Sub1 = Element2.substring(0,2);
			System.out.println("Sub string = "+Sub1);
			String Sub2 = Element2.substring(3,5);
			System.out.println("Sub string = "+Sub2);
			String Sub3 = Element2.substring(6,10);
			System.out.println("Sub string = "+Sub3);
			
			System.out.println("Full string = "+Sub1+Sub2+Sub3);
			Driver.tcFlag = "PASS";
			//Driver.comment = "Pass";
			Driver.comment = "Pass" + " # " + "Account number readed from file= " + Element2; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		
			for(int i=0; i<60; i++)
			{
				try
				{
					if (driver.findElement(By.id(propertyValue)).isEnabled())
					{
						//((JavascriptExecutor)driver).executeScript ("document.getElementById('dateofbirth').removeAttribute('readonly',0);");

						//WebElement BirthDate= driver.findElement(By.id("dateofbirth"));
						driver.findElement(By.id(propertyValue)).clear();
						driver.findElement(By.id(propertyValue)).sendKeys(Sub1+Sub2+Sub3); //Enter this date details with valid date format
						
						//driver.findElement(By.id(propertyValue)).sendKeys(Sub1);
						//driver.findElement(By.id(propertyValue)).sendKeys(Sub2);
						//driver.findElement(By.id(propertyValue)).sendKeys(Sub3);
						System.out.println("For loop if = "+Sub1+Sub2+Sub3);
						Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.comment = "Pass" + " # " + "Selected value= " + testData ; 		
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
						break;
					}
					else
					{
						System.out.println("For loop else");
					}
				}
				catch(Exception e1)
				{
					System.out.println("Catch exception");
				}
			}
			//driver.findElement(By.id(propertyValue)).sendKeys(Element2);
			//System.out.println("For loop if = "+propertyValue);
	}
}
