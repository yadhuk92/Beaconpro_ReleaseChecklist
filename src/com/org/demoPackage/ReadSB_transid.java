package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ReadSB_transid {
	
 public static void ReadTransIdForSBCredit_Cash(String propertyValue) throws IOException {
		  
		  Properties prop = new Properties();
		  InputStream input = new FileInputStream("./DataFiles/SBCREDIT_CASHMODE.properties");
		  prop.load(input);
		  String transId = prop.getProperty("SBTransId");
		  Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId); 
		  Driver.tcFlag = "PASS";
		  Driver.comment = "Pass";
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);  
		 }
 public static void ReadTransIdForSBCredit_Autopost(String propertyValue) throws IOException {
		  
		  Properties prop = new Properties();
		  InputStream input = new FileInputStream("./DataFiles/SBCREDIT_AUTOPOSTMODE.properties");
		  prop.load(input);
		  String transId = prop.getProperty("CA_TransId");
		  Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId); 
		  Driver.tcFlag = "PASS";
		  Driver.comment = "Pass";
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);  
		 }
 public static void ReadTransIdForSBCredit_Batch(String propertyValue) throws IOException {
		  
		  Properties prop = new Properties();
		  InputStream input = new FileInputStream("./DataFiles/SBCREDIT_BATCHMODE.properties");
		  prop.load(input);
		  String transId = prop.getProperty("SBTransId");
		  Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId); 
		  Driver.tcFlag = "PASS";
		  Driver.comment = "Pass";
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);  
		 }
 public static void getSBTransid(String propertyValue) throws IOException {
	  
	  Properties prop = new Properties();
	  InputStream input = new FileInputStream("./DataFiles/SBCreditOpening_CashMode.properties");
	  prop.load(input);
	  String transId = prop.getProperty("FDAc_TransId");
	  Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId); 
	  Driver.tcFlag = "PASS";
	  Driver.comment = "Pass";
	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);  
	 }
 public static void getSBTransidAutopost(String propertyValue) throws IOException {
		  
		  Properties prop = new Properties();
		  InputStream input = new FileInputStream("./DataFiles/SBCreditOpening_AutopostMode.properties");
		  prop.load(input);
		  String transId = prop.getProperty("CA_TransId");
		  Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId); 
		  Driver.tcFlag = "PASS";
		  Driver.comment = "Pass";
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);  
		 }
 public static void getSBTransidBatch(String propertyValue) throws IOException {
		  
		  Properties prop = new Properties();
		  InputStream input = new FileInputStream("./DataFiles/SBDebitOpening_BatchMode.properties");
		  prop.load(input);
		  String transId = prop.getProperty("FDAc_TransId");
		  Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId); 
		  Driver.tcFlag = "PASS";
		  Driver.comment = "Pass";
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);  
		 }
 public static void getDDCreditTransid_Cash(String propertyValue) throws IOException {
		
		System.out.println("GET TRANSID");
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/DDCredit_CashMode.properties");
		prop.load(input);
		String transId = prop.getProperty("FDAc_TransId");
		Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
	}
	
	public static void getDDCreditTransid_Batch(String propertyValue) throws IOException {
		
		System.out.println("GET TRANSID");
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/DDCredit_BatchMode.properties");
		prop.load(input);
		String transId = prop.getProperty("FDAc_TransId");
		Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
	}
public static void getDDCreditTransid_Autopost(String propertyValue) throws IOException {
		
		System.out.println("GET TRANSID");
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/DDCREDIT_AUTOPOST.properties");
		prop.load(input);
		String transId = prop.getProperty("DDTransId");
		Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
	}
public static void getRDCredit_CashTransid(String propertyValue) throws IOException {
	System.out.println("Inside get Transid method");
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/RDCredit_CashMode.properties");
	prop.load(input);
	String transId = prop.getProperty("FDAc_TransId");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}

 public static void getRDCredit_AutopostTransid(String propertyValue) throws IOException {


	Properties prop = new Properties();
    InputStream input = new FileInputStream("./DataFiles/RDCREDIT_AUTOPOST.properties");
    prop.load(input);
    String transId = prop.getProperty("DDTransId");
    Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId);	
    Driver.tcFlag = "PASS";
    Driver.comment = "Pass";
    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
 }

 public static void getRDCredit_BatchTransid(String propertyValue) throws IOException {
	 
    System.out.println("Inside Get Transid");
    Properties prop = new Properties();
    InputStream input = new FileInputStream("./DataFiles/RDCredit_BatchMode.properties");
    prop.load(input);
    String transId = prop.getProperty("FDAc_TransId");
    Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId);	
    Driver.tcFlag = "PASS";
    Driver.comment = "Pass";
    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
  }
}