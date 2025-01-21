package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ReadAmount {
	
public static void getAmount(String propertyValue) throws IOException {
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/ShareOpening_BatchMode_Details.properties");
		prop.load(input);
		String TotalAmount= prop.getProperty("Share_Total");
		Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
	}
public static void getAmountCA(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/CAOpeningDetails_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForGL_BATCH(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/GL_BATCH_Amount.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("NetPay");
	
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}

public static void getAmountForSL_BATCH(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/SL_BATCH_Details.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("SLAmount");
	
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForSA_BATCH(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/SA_BATCH_Details.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("SLAmount");
	
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForOL_Credit(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/OLCREDIT_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForOD_Credit(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/ODCREDIT_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForOD_Debit(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/ODDEBIT_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForDL_Credit(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/DLCREDIT_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForGL_Credit(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/GLCREDIT_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForFDInterestPayment_Credit(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/FDINTERESTPAYMENT_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForSBAccClosure_Batch(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForFDAccClosure_Batch(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForRDAccClosure_Batch(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForDDAccClosure_Batch(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForRIDAccClosure_Batch(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForODCashCreditRenewal_Batch(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/ODCASHCREDIT_RENEWAL_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForFDRenewal_Batch(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForGLRenewal_Batch(String propertyValue) throws IOException {
try {	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	
	for(int i=0; i<60; i++){
		try{
			if (Driver.driver.findElement(By.xpath(propertyValue)).isEnabled()){
				break;
			}else{
				Thread.sleep(1000);
			}
		}catch(Exception e1){
			Thread.sleep(1000);
		}
	}
	
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
    Driver.comment = "Element is not diplayed or identified";
    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
}
}
public static void getAmountForOLClosure_Batch(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/OL_CLOSURE_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForODClosure_Batch(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/OD_CLOSURE_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForDLClosure_Batch(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/DL_CLOSURE_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
public static void getAmountForGLClosure_Batch(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/GL_CLOSURE_BATCH.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}

public static void getAmountForSBCredit_Batch(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/SBCREDIT_BATCHMODE.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}

public static void getAmountForSBDebit(String propertyValue) throws IOException {
	
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/SBDebitOpening_BatchMode.properties");
	prop.load(input);
	String TotalAmount= prop.getProperty("TotalAmount");
	Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
}
}
