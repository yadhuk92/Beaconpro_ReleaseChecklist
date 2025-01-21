package com.org.demoPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Verify {
	
private static String[] InterFacedHeader;
private static String Amttype;
private static String CrOrDr;



public static void print(String ActualValue, String DbValue) {
	
	System.out.println("Actual value and DB value is "+ ActualValue +"  "+ DbValue);
	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass" + " # " + "Value From Database: " + DbValue + "<br>" + "Actual Value: " + ActualValue; 
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}

public static WebDriver VerifySummary_FD_CashMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("Inside verify summary method");
 try{
	   element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
	   //element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
	    
	   if (element.isDisplayed() == true) {
	     
	     if(element.isEnabled()==true) { 
	      
	     Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
	     
	     }else {
	      
	      
	     Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
	      
	     }
	     
	     System.out.println("Actual value is "+Actual_Value);

	     
	     Properties prop=new Properties();
	     
	     InputStream input = new FileInputStream("./DataFiles/FD_CASH_Details.properties");
	     prop.load(input);
	     
	     String TransDateFromFile=prop.getProperty("Share_TransactionDate");
	     SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
	     Date newTransdate=sdfrmt.parse(TransDateFromFile);
	     sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
	     String TRANSDATE=sdfrmt.format(newTransdate);
	     
	     
	     String ValueDateFromFile=prop.getProperty("Share_ValueDate");
	     SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
	     Date newValdate=sdfrmt1.parse(ValueDateFromFile);
	     sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
	     String VALUEDATE=sdfrmt1.format(newValdate);
	     
	      if(Actual_Value.equals(prop.getProperty("FDAc_ProductName"))) {
	      
	      //System.out.println("inside Product name validation  "+ Actual_Value+" "+prop.getProperty("InvestmentAccount_productName")) ;
	      
	       print(Actual_Value,prop.getProperty("FDAc_ProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_AccountNumber"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_AccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_DisplayName"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_DisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_BatchId"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_BatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_TransId"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_TransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_VoucherNumber"))) {
	     
	      print(Actual_Value,prop.getProperty("FDAc_VoucherNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_TranType"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_TranType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_TransAmount"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_TransAmount"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_AmountType"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_AmountType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_GlAcCode"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_GlAcCode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_TransferMode"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_TransferMode"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("FDAc_OrgId"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_OrgId"));
	     
	      
	      
	     }else if(Actual_Value.substring(0, 9).equals(TRANSDATE)){
	      
	      print(Actual_Value.substring(0, 9),TRANSDATE); 
	     
	     }else if(Actual_Value.substring(0, 9).equals(VALUEDATE)) {
	      
	      print(Actual_Value.substring(0, 9),VALUEDATE); 
	      
	       
	     }else {
	      Driver.tcFlag = "FAIL";
	      //e.printStackTrace(new PrintWriter(Driver.errors));
	      //Driver.comment = Driver.errors.toString();
	      Driver.comment = Driver.objectName + " and its Database value are (test)  not matching";
	      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	     }
	    
	    }
	    
	   }catch(Exception e){
	    Driver.tcFlag = "FAIL";
	    Driver.comment = Driver.objectName + " (test2)is not displayed or not identified";
	    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	    e.printStackTrace();
	   }
	   
	 

	 break;

	 
	  
	 case "name":
	  
	  break;
	  
	 case "css":
	  
	  break;
	 }
	 
	 
	 
	 
	 return driver;
	 
	}
/*public static WebDriver VerifySummary_FD_CashMode(WebDriver driver, String locatorType, String propertyValue, String testData) throws ClassNotFoundException, SQLException {
	
	 WebElement element=null;
	 String Actual_Value=null;

	switch(locatorType.toLowerCase()){
	
	case "id":
		
		
		
	break;
		
		
	case "xpath":
		
		try{
			element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				
			if (element.isDisplayed() == true) {
					
					if(element.isEnabled()==true) {	
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
					
					}else {
						
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
						
					}
					
					System.out.println("Actual value is "+Actual_Value);

					
					Properties prop=new Properties();
					
					InputStream input = new FileInputStream("./DataFiles/FD_CASH_Details.properties");
					prop.load(input);
					
					String TransDateFromFile=prop.getProperty("TransactionDate");
					SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
					Date newTransdate=sdfrmt.parse(TransDateFromFile);
					sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
					String TRANSDATE=sdfrmt.format(newTransdate);
					
					
					String ValueDateFromFile=prop.getProperty("ValueDate");
					SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
					Date newValdate=sdfrmt1.parse(ValueDateFromFile);
					sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
					String VALUEDATE=sdfrmt1.format(newValdate);
					
					
					
					
					
					
					if(Actual_Value.equals(prop.getProperty("ProductName1"))) {
						
							print(Actual_Value,prop.getProperty("ProductName1"));
					}
					else if(Actual_Value.equals(prop.getProperty("AccountName1"))){	
					
						print(Actual_Value,prop.getProperty("AccountName1"));
						
					}
					else if(Actual_Value.equals(prop.getProperty("BatchID1"))) {
						
						print(Actual_Value,prop.getProperty("BatchID1"));
					} 
					else if(Actual_Value.equals(prop.getProperty("TransType1"))) {
						
						print(Actual_Value,prop.getProperty("TransType1"));
						
					}else if(Actual_Value.equals(prop.getProperty("TransMode1"))) {
						
						print(Actual_Value,prop.getProperty("TransMode1"));
						
					}else if(Actual_Value.equals(prop.getProperty("TransAmount1"))) {
						
						print(Actual_Value,prop.getProperty("TransAmount1"));
						
					}else if(Actual_Value.equals(prop.getProperty("AmountType1"))) {
						
						print(Actual_Value,prop.getProperty("AmountType1"));
						
					}else if(Actual_Value.equals(prop.getProperty("GLACcode1"))) {
						
						print(Actual_Value,prop.getProperty("GLACcode1"));
						
					}else if(Actual_Value.equals(prop.getProperty("Branch1"))) {
						
						print(Actual_Value,prop.getProperty("Branch1"));
						
					}else {
						Driver.tcFlag = "FAIL";
						//e.printStackTrace(new PrintWriter(Driver.errors));
						//Driver.comment = Driver.errors.toString();
						Driver.comment = Driver.objectName + " and its Database value are (test)  not matching";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					}
				
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " (test2)is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}
			

		
	break;

	
		
	case "name":
		
		break;
		
	case "css":
		
		break;
	}
	
	
	
	
	return driver;
	
}
*/
public static WebDriver VerifySummary_FD_TransferMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("Inside verify text method");
	  try{
	   element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
	   //element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
	    
	   if (element.isDisplayed() == true) {
	     
	     if(element.isEnabled()==true) { 
	      
	     Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
	     
	     }else {
	      
	      
	     Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
	      
	     }
	     
	     System.out.println("Actual value is "+Actual_Value);

	     
	     Properties prop=new Properties();
	     
	     InputStream input = new FileInputStream("./DataFiles/FixedDepositAccountOpening_TransferMode.properties");
	     prop.load(input);
	     
	     String TransDateFromFile=prop.getProperty("Share_TransactionDate");
	     SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
	     Date newTransdate=sdfrmt.parse(TransDateFromFile);
	     sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
	     String TRANSDATE=sdfrmt.format(newTransdate);
	     
	     
	     String ValueDateFromFile=prop.getProperty("Share_ValueDate");
	     SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
	     Date newValdate=sdfrmt1.parse(ValueDateFromFile);
	     sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
	     String VALUEDATE=sdfrmt1.format(newValdate);
	     
	     
	     if(Actual_Value.equals(prop.getProperty("CrFDAc_ProductName"))) {
	      
	      //System.out.println("inside Product name validation  "+ Actual_Value+" "+prop.getProperty("InvestmentAccount_productName")) ;
	      
	       print(Actual_Value,prop.getProperty("CrFDAc_ProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("CrFDAc_AccountNumber"))) {
	      
	      print(Actual_Value,prop.getProperty("CrFDAc_AccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("CrFDAc_DisplayName"))) {
	      
	      print(Actual_Value,prop.getProperty("CrFDAc_DisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("CrFDAc_BatchId"))) {
	      
	      print(Actual_Value,prop.getProperty("CrFDAc_BatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("CrFDAc_TransId"))) {
	      
	      print(Actual_Value,prop.getProperty("CrFDAc_TransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("CrFDAc_VoucherNumber"))) {
	     
	      print(Actual_Value,prop.getProperty("CrFDAc_VoucherNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("CrFDAc_TranType"))) {
	      
	      print(Actual_Value,prop.getProperty("CrFDAc_TranType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("CrFDAc_TransAmount"))) {
	      
	      print(Actual_Value,prop.getProperty("CrFDAc_TransAmount"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("CrFDAc_AmountType"))) {
	      
	      print(Actual_Value,prop.getProperty("CrFDAc_AmountType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("CrFDAc_GlAcCode"))) {
	      
	      print(Actual_Value,prop.getProperty("CrFDAc_GlAcCode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("CrFDAc_TransferMode"))) {
	      
	      print(Actual_Value,prop.getProperty("CrFDAc_TransferMode"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("CrFDAc_OrgId"))) {
	      
	      print(Actual_Value,prop.getProperty("CrFDAc_OrgId"));
	     
	      
	     }else if (Actual_Value.equals(prop.getProperty("DrFDAc_ProductName"))) {
	      
	      print(Actual_Value,prop.getProperty("DrFDAc_ProductName")); 
	      
	     }else if (Actual_Value.equals(prop.getProperty("DrFDAc_AccountNumber"))) {
	      
	      print(Actual_Value,prop.getProperty("DrFDAc_AccountNumber"));  
	      
	     }else if (Actual_Value.equals(prop.getProperty("DrFDAc_AccountDisplayName"))) {
	      
	      print(Actual_Value,prop.getProperty("DrFDAc_AccountDisplayName"));  
	      
	     }else if (Actual_Value.equals(prop.getProperty("DrFDAc_BatchId"))) {
	      
	      print(Actual_Value,prop.getProperty("DrFDAc_BatchId")); 
	      
	     }else if (Actual_Value.equals(prop.getProperty("DrFDAc_TransId"))) {
	      
	      print(Actual_Value,prop.getProperty("DrFDAc_TransId"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("DrFDAc_VoucherNo"))) {
	      
	      print(Actual_Value,prop.getProperty("DrFDAc_VoucherNo"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("DrFDAc_TransType"))) {
	      
	      print(Actual_Value,prop.getProperty("DrFDAc_TransType"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("DrFDAc_TrnAmount"))) {
	      
	      print(Actual_Value,prop.getProperty("DrFDAc_TrnAmount")); 
	      
	     }else if (Actual_Value.equals(prop.getProperty("DrFDAc_AmountType"))) {
	      
	      print(Actual_Value,prop.getProperty("DrFDAc_AmountType"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("DrFDAc_GlAcCode"))) {
	      
	      print(Actual_Value,prop.getProperty("DrFDAc_GlAcCode")); 
	      
	     }else if (Actual_Value.equals(prop.getProperty("DrFDAc_TrnMode"))) {
	      
	      print(Actual_Value,prop.getProperty("DrFDAc_TrnMode")); 
	      
	     }else if (Actual_Value.equals(prop.getProperty("DrFDAc_OrgId"))) {
	      
	      print(Actual_Value,prop.getProperty("DrFDAc_OrgId"));
	      
	      
	     }else if(Actual_Value.substring(0, 9).equals(TRANSDATE)){
	      
	      print(Actual_Value.substring(0, 9),TRANSDATE); 
	     
	     }else if(Actual_Value.substring(0, 9).equals(VALUEDATE)) {
	      
	      print(Actual_Value.substring(0, 9),VALUEDATE); 
	      
	       
	     }else {
	      Driver.tcFlag = "FAIL";
	      //e.printStackTrace(new PrintWriter(Driver.errors));
	      //Driver.comment = Driver.errors.toString();
	      Driver.comment = Driver.objectName + " and its Database value are (test)  not matching";
	      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	     }
	    
	    }
	    
	   }catch(Exception e){
	    Driver.tcFlag = "FAIL";
	    Driver.comment = Driver.objectName + " (test2)is not displayed or not identified";
	    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	    e.printStackTrace();
	   }
	   
	 

	 break;

	 
	  
	 case "name":
	  
	  break;
	  
	 case "css":
	  
	  break;
	 }
	 
	 
	 
	 
	 return driver;
	 
	}

public static WebDriver VerifySummary_FD_BatchMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("Inside verify summary method");
	  try{
	   element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
	   //element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
	    
	   if (element.isDisplayed() == true) {
	     
	     if(element.isEnabled()==true) { 
	      
	     Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
	     
	     }else {
	      
	      
	     Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
	      
	     }
	     
	     System.out.println("Actual value is "+Actual_Value);

	     
	     Properties prop=new Properties();
	     
	     InputStream input = new FileInputStream("./DataFiles/FixedDepositAccountOpening_BatchMode.properties");
	     prop.load(input);
	     
	     String TransDateFromFile=prop.getProperty("Share_TransactionDate");
	     SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
	     Date newTransdate=sdfrmt.parse(TransDateFromFile);
	     sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
	     String TRANSDATE=sdfrmt.format(newTransdate);
	     
	     
	     String ValueDateFromFile=prop.getProperty("Share_ValueDate");
	     SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
	     Date newValdate=sdfrmt1.parse(ValueDateFromFile);
	     sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
	     String VALUEDATE=sdfrmt1.format(newValdate);
	     
	     
	       if(Actual_Value.equals(prop.getProperty("FDAc_ProductName"))) {
	      
	      //System.out.println("inside Product name validation  "+ Actual_Value+" "+prop.getProperty("InvestmentAccount_productName")) ;
	      
	       print(Actual_Value,prop.getProperty("FDAc_ProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_AccountNumber"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_AccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_DisplayName"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_DisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_BatchId"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_BatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_TransId"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_TransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_VoucherNumber"))) {
	     
	      print(Actual_Value,prop.getProperty("FDAc_VoucherNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_TranType"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_TranType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_TransAmount"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_TransAmount"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_AmountType"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_AmountType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_GlAcCode"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_GlAcCode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_TransferMode"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_TransferMode"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("FDAc_OrgId"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_OrgId"));
	     
	            
	     }else if(Actual_Value.substring(0, 9).equals(TRANSDATE)){
	      
	      print(Actual_Value.substring(0, 9),TRANSDATE); 
	     
	     }else if(Actual_Value.substring(0, 9).equals(VALUEDATE)) {
	      
	      print(Actual_Value.substring(0, 9),VALUEDATE); 
	      
	       
	     }else {
	      Driver.tcFlag = "FAIL";
	      //e.printStackTrace(new PrintWriter(Driver.errors));
	      //Driver.comment = Driver.errors.toString();
	      Driver.comment = Driver.objectName + " and its Database value are (test)  not matching";
	      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	     }
	    
	    }
	    
	   }catch(Exception e){
	    Driver.tcFlag = "FAIL";
	    Driver.comment = Driver.objectName + " (test2)is not displayed or not identified";
	    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	    e.printStackTrace();
	   }
	   
	 

	 break;

	 
	  
	 case "name":
	  
	  break;
	  
	 case "css":
	  
	  break;
	 }
	 
	 
	 
	 
	 return driver;
	 
	}

public static WebDriver VerifySummary_RID_BatchMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
	
	 WebElement element=null;
	 String Actual_Value=null;
	
	switch(locatorType.toLowerCase()){
	
	case "id":
		
	break;
		
		
	case "xpath":
		
		//System.out.println("Inside verify summary method");
		try{
			element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				
			if (element.isDisplayed() == true) {
					
					if(element.isEnabled()==true) {	
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
					
					}else {
						
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
						
					}
					
					System.out.println("Actual value is "+Actual_Value);

					
					Properties prop=new Properties();
					
					InputStream input = new FileInputStream("./DataFiles/RID_BATCH_Details.properties");
					prop.load(input);
					
					String TransDateFromFile=prop.getProperty("TransactionDate");
					SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
					Date newTransdate=sdfrmt.parse(TransDateFromFile);
					sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
					String TRANSDATE=sdfrmt.format(newTransdate);
					
					
					String ValueDateFromFile=prop.getProperty("ValueDate");
					SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
					Date newValdate=sdfrmt1.parse(ValueDateFromFile);
					sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
					String VALUEDATE=sdfrmt1.format(newValdate);
					
					//System.out.println("Transdate "+TRANSDATE );
					
					//System.out.println("Transdate "+TRANSDATE );
					
					
					if(Actual_Value.equals(prop.getProperty("ProductName"))) {
						
	
							print(Actual_Value,prop.getProperty("ProductName"));
						
					}else if(Actual_Value.equals(prop.getProperty("AccountNumber"))) {
						
						print(Actual_Value,prop.getProperty("AccountNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("DisplayName"))) {
						
						print(Actual_Value,prop.getProperty("DisplayName"));
						
					}else if(Actual_Value.equals(prop.getProperty("BatchId"))) {
						
						print(Actual_Value,prop.getProperty("BatchId"));
						
					}else if(Actual_Value.equals(prop.getProperty("TransId"))) {
						
						print(Actual_Value,prop.getProperty("TransId"));
						
					}else if(Actual_Value.equals(prop.getProperty("VoucherNumber"))) {
					
						print(Actual_Value,prop.getProperty("VoucherNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("TranType"))) {
						
						print(Actual_Value,prop.getProperty("TranType"));
						
					}else if(Actual_Value.equals(prop.getProperty("TransAmount"))) {
						
						print(Actual_Value,prop.getProperty("TransAmount"));
						
					}else if(Actual_Value.equals(prop.getProperty("AmountType"))) {
						
						print(Actual_Value,prop.getProperty("AmountType"));
						
					}else if(Actual_Value.equals(prop.getProperty("GlAcCode"))) {
						
						print(Actual_Value,prop.getProperty("GlAcCode"));
						
					}else if(Actual_Value.equals(prop.getProperty("TransferMode"))) {
						
						print(Actual_Value,prop.getProperty("TransferMode"));
						
					}else if (Actual_Value.equals(prop.getProperty("OrgId"))) {
						
						print(Actual_Value,prop.getProperty("OrgId"));
		
					}else {
						Driver.tcFlag = "FAIL";
						
						Driver.comment = Driver.objectName + " and its Database value are (test)  not matching";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					}
				
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " (test2)is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}
			
	

	break;

	
		
	case "name":
		
		break;
		
	case "css":
		
		break;
	}
	
	
	
	
	return driver;
		
	
	
	
	
}

public static WebDriver VerifySummary_RID_CashMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("Inside verify summary method");
	  try{
	   element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
	   //element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
	    
	   if (element.isDisplayed() == true) {
	     
	     if(element.isEnabled()==true) { 
	      
	     Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
	     
	     }else {
	      
	      
	     Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
	      
	     }
	     
	     System.out.println("Actual value is "+Actual_Value);

	     
	     Properties prop=new Properties();
	     
	     InputStream input = new FileInputStream("./DataFiles/RIDAccountOpening_CashMode.properties");
	     prop.load(input);
	     
	     String TransDateFromFile=prop.getProperty("Share_TransactionDate");
	     SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
	     Date newTransdate=sdfrmt.parse(TransDateFromFile);
	     sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
	     String TRANSDATE=sdfrmt.format(newTransdate);
	     
	     
	     String ValueDateFromFile=prop.getProperty("Share_ValueDate");
	     SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
	     Date newValdate=sdfrmt1.parse(ValueDateFromFile);
	     sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
	     String VALUEDATE=sdfrmt1.format(newValdate);
	     
	                       if(Actual_Value.equals(prop.getProperty("FDAc_ProductName"))) {
	      
	      //System.out.println("inside Product name validation  "+ Actual_Value+" "+prop.getProperty("InvestmentAccount_productName")) ;
	      
	       print(Actual_Value,prop.getProperty("FDAc_ProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_AccountNumber"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_AccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_DisplayName"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_DisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_BatchId"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_BatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_TransId"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_TransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_VoucherNumber"))) {
	     
	      print(Actual_Value,prop.getProperty("FDAc_VoucherNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_TranType"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_TranType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_TransAmount"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_TransAmount"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_AmountType"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_AmountType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_GlAcCode"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_GlAcCode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_TransferMode"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_TransferMode"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("FDAc_OrgId"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_OrgId"));
	     
	      
	      
	     }else if(Actual_Value.substring(0, 9).equals(TRANSDATE)){
	      
	      print(Actual_Value.substring(0, 9),TRANSDATE); 
	     
	     }else if(Actual_Value.substring(0, 9).equals(VALUEDATE)) {
	      
	      print(Actual_Value.substring(0, 9),VALUEDATE); 
	      
	       
	     }else {
	      Driver.tcFlag = "FAIL";
	      //e.printStackTrace(new PrintWriter(Driver.errors));
	      //Driver.comment = Driver.errors.toString();
	      Driver.comment = Driver.objectName + " and its Database value are (test)  not matching";
	      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	     }
	    
	    }
	    
	   }catch(Exception e){
	    Driver.tcFlag = "FAIL";
	    Driver.comment = Driver.objectName + " (test2)is not displayed or not identified";
	    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	    e.printStackTrace();
	   }
	   
	 

	 break;

	 
	  
	 case "name":
	  
	  break;
	  
	 case "css":
	  
	  break;
	 }
	 
	 
	 
	 
	 return driver;
	 
	}


public static WebDriver VerifySummary_RID_TransferMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
	
	 WebElement element=null;
	 String Actual_Value=null;
	
	switch(locatorType.toLowerCase()){
	
	case "id":
		
	break;
		
		
	case "xpath":
		
		System.out.println("Inside verify text method");
		try{
			element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				
			if (element.isDisplayed() == true) {
					
					if(element.isEnabled()==true) {	
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
					
					}else {
						
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
						
					}
					
					System.out.println("Actual value is "+Actual_Value);

					
					Properties prop=new Properties();
					
					InputStream input = new FileInputStream("./DataFiles/RIDAccountOpening_TransferMode.properties");
					prop.load(input);
					
					String TransDateFromFile=prop.getProperty("Share_TransactionDate");
					SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
					Date newTransdate=sdfrmt.parse(TransDateFromFile);
					sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
					String TRANSDATE=sdfrmt.format(newTransdate);
					
					
					String ValueDateFromFile=prop.getProperty("Share_ValueDate");
					SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
					Date newValdate=sdfrmt1.parse(ValueDateFromFile);
					sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
					String VALUEDATE=sdfrmt1.format(newValdate);
					
					
					if(Actual_Value.equals(prop.getProperty("CrFDAc_ProductName"))) {
						
						//System.out.println("inside Product name validation  "+ Actual_Value+" "+prop.getProperty("InvestmentAccount_productName")) ;
						
							print(Actual_Value,prop.getProperty("CrFDAc_ProductName"));
						
					}else if(Actual_Value.equals(prop.getProperty("CrFDAc_AccountNumber"))) {
						
						print(Actual_Value,prop.getProperty("CrFDAc_AccountNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("CrFDAc_DisplayName"))) {
						
						print(Actual_Value,prop.getProperty("CrFDAc_DisplayName"));
						
					}else if(Actual_Value.equals(prop.getProperty("CrFDAc_BatchId"))) {
						
						print(Actual_Value,prop.getProperty("CrFDAc_BatchId"));
						
					}else if(Actual_Value.equals(prop.getProperty("CrFDAc_TransId"))) {
						
						print(Actual_Value,prop.getProperty("CrFDAc_TransId"));
						
					}else if(Actual_Value.equals(prop.getProperty("CrFDAc_VoucherNumber"))) {
					
						print(Actual_Value,prop.getProperty("CrFDAc_VoucherNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("CrFDAc_TranType"))) {
						
						print(Actual_Value,prop.getProperty("CrFDAc_TranType"));
						
					}else if(Actual_Value.equals(prop.getProperty("CrFDAc_TransAmount"))) {
						
						print(Actual_Value,prop.getProperty("CrFDAc_TransAmount"));
						
					}else if(Actual_Value.equals(prop.getProperty("CrFDAc_AmountType"))) {
						
						print(Actual_Value,prop.getProperty("CrFDAc_AmountType"));
						
					}else if(Actual_Value.equals(prop.getProperty("CrFDAc_GlAcCode"))) {
						
						print(Actual_Value,prop.getProperty("CrFDAc_GlAcCode"));
						
					}else if(Actual_Value.equals(prop.getProperty("CrFDAc_TransferMode"))) {
						
						print(Actual_Value,prop.getProperty("CrFDAc_TransferMode"));
						
					}else if (Actual_Value.equals(prop.getProperty("CrFDAc_OrgId"))) {
						
						print(Actual_Value,prop.getProperty("CrFDAc_OrgId"));
					
						
					}else if (Actual_Value.equals(prop.getProperty("DrFDAc_ProductName"))) {
						
						print(Actual_Value,prop.getProperty("DrFDAc_ProductName"));	
						
					}else if (Actual_Value.equals(prop.getProperty("DrFDAc_AccountNumber"))) {
						
						print(Actual_Value,prop.getProperty("DrFDAc_AccountNumber"));		
						
					}else if (Actual_Value.equals(prop.getProperty("DrFDAc_AccountDisplayName"))) {
						
						print(Actual_Value,prop.getProperty("DrFDAc_AccountDisplayName"));		
						
					}else if (Actual_Value.equals(prop.getProperty("DrFDAc_BatchId"))) {
						
						print(Actual_Value,prop.getProperty("DrFDAc_BatchId"));	
						
					}else if (Actual_Value.equals(prop.getProperty("DrFDAc_TransId"))) {
						
						print(Actual_Value,prop.getProperty("DrFDAc_TransId"));
						
					}else if (Actual_Value.equals(prop.getProperty("DrFDAc_VoucherNo"))) {
						
						print(Actual_Value,prop.getProperty("DrFDAc_VoucherNo"));
						
					}else if (Actual_Value.equals(prop.getProperty("DrFDAc_TransType"))) {
						
						print(Actual_Value,prop.getProperty("DrFDAc_TransType"));
						
					}else if (Actual_Value.equals(prop.getProperty("DrFDAc_TrnAmount"))) {
						
						print(Actual_Value,prop.getProperty("DrFDAc_TrnAmount"));	
						
					}else if (Actual_Value.equals(prop.getProperty("DrFDAc_AmountType"))) {
						
						print(Actual_Value,prop.getProperty("DrFDAc_AmountType"));
						
					}else if (Actual_Value.equals(prop.getProperty("DrFDAc_GlAcCode"))) {
						
						print(Actual_Value,prop.getProperty("DrFDAc_GlAcCode"));	
						
					}else if (Actual_Value.equals(prop.getProperty("DrFDAc_TrnMode"))) {
						
						print(Actual_Value,prop.getProperty("DrFDAc_TrnMode"));	
						
					}else if (Actual_Value.equals(prop.getProperty("DrFDAc_OrgId"))) {
						
						print(Actual_Value,prop.getProperty("DrFDAc_OrgId"));
						
						
					}else if(Actual_Value.substring(0, 9).equals(TRANSDATE)){
						
						print(Actual_Value.substring(0, 9),TRANSDATE);	
					
					}else if(Actual_Value.substring(0, 9).equals(VALUEDATE)) {
						
						print(Actual_Value.substring(0, 9),VALUEDATE);	
						
							
					}else {
						Driver.tcFlag = "FAIL";
						//e.printStackTrace(new PrintWriter(Driver.errors));
						//Driver.comment = Driver.errors.toString();
						Driver.comment = Driver.objectName + " and its Database value are (test)  not matching";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					}
				
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " (test2)is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}
			
	

	break;

	
		
	case "name":
		
		break;
		
	case "css":
		
		break;
	}
	
	
	
	
	return driver;
	
}

public static WebDriver VerifySummary_RD_CashMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
	
	 WebElement element=null;
	 String Actual_Value=null;
	
	switch(locatorType.toLowerCase()){
	
	case "id":
		
	break;
		
		
	case "xpath":
		
		System.out.println("Inside verify summary method");
		try{
			element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				
			if (element.isDisplayed() == true) {
					
					if(element.isEnabled()==true) {	
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
					
					}else {
						
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
						
					}
					
					System.out.println("Actual value is "+Actual_Value);

					
					Properties prop=new Properties();
					
					InputStream input = new FileInputStream("./DataFiles/RDAccountOpening_CashMode.properties");
					prop.load(input);
					
					String TransDateFromFile=prop.getProperty("Share_TransactionDate");
					SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
					Date newTransdate=sdfrmt.parse(TransDateFromFile);
					sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
					String TRANSDATE=sdfrmt.format(newTransdate);
					
					
					String ValueDateFromFile=prop.getProperty("Share_ValueDate");
					SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
					Date newValdate=sdfrmt1.parse(ValueDateFromFile);
					sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
					String VALUEDATE=sdfrmt1.format(newValdate);
					
					
               if(Actual_Value.equals(prop.getProperty("FDAc_ProductName"))) {
						
						//System.out.println("inside Product name validation  "+ Actual_Value+" "+prop.getProperty("InvestmentAccount_productName")) ;
						
							print(Actual_Value,prop.getProperty("FDAc_ProductName"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_AccountNumber"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_AccountNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_DisplayName"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_DisplayName"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_BatchId"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_BatchId"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_TransId"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_TransId"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_VoucherNumber"))) {
					
						print(Actual_Value,prop.getProperty("FDAc_VoucherNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_TranType"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_TranType"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_TransAmount"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_TransAmount"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_AmountType"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_AmountType"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_GlAcCode"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_GlAcCode"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_TransferMode"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_TransferMode"));
						
					}else if (Actual_Value.equals(prop.getProperty("FDAc_OrgId"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_OrgId"));
					
												
					}else if(Actual_Value.substring(0, 9).equals(TRANSDATE)){
						
						print(Actual_Value.substring(0, 9),TRANSDATE);	
					
					}else if(Actual_Value.substring(0, 9).equals(VALUEDATE)) {
						
						print(Actual_Value.substring(0, 9),VALUEDATE);	
						
							
					}else {
						Driver.tcFlag = "FAIL";
						//e.printStackTrace(new PrintWriter(Driver.errors));
						//Driver.comment = Driver.errors.toString();
						Driver.comment = Driver.objectName + " and its Database value are (test)  not matching";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					}
				
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " (test2)is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}
			
	

	break;

	
		
	case "name":
		
		break;
		
	case "css":
		
		break;
	}
	
	
	
	
	return driver;
	
}

public static WebDriver VerifySummary_RD_BatchMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
	
	 WebElement element=null;
	 String Actual_Value=null;
	
	switch(locatorType.toLowerCase()){
	
	case "id":
		
	break;
		
		
	case "xpath":
		
		System.out.println("Inside verify summary method");
		try{
			element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				
			if (element.isDisplayed() == true) {
					
					if(element.isEnabled()==true) {	
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
					
					}else {
						
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
						
					}
					
					System.out.println("Actual value is "+Actual_Value);

					
					Properties prop=new Properties();
					
					InputStream input = new FileInputStream("./DataFiles/RDAccountOpening_BatchMode.properties");
					prop.load(input);
					
					String TransDateFromFile=prop.getProperty("Share_TransactionDate");
					SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
					Date newTransdate=sdfrmt.parse(TransDateFromFile);
					sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
					String TRANSDATE=sdfrmt.format(newTransdate);
					
					
					String ValueDateFromFile=prop.getProperty("Share_ValueDate");
					SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
					Date newValdate=sdfrmt1.parse(ValueDateFromFile);
					sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
					String VALUEDATE=sdfrmt1.format(newValdate);
					
					
               if(Actual_Value.equals(prop.getProperty("FDAc_ProductName"))) {
						
						//System.out.println("inside Product name validation  "+ Actual_Value+" "+prop.getProperty("InvestmentAccount_productName")) ;
						
							print(Actual_Value,prop.getProperty("FDAc_ProductName"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_AccountNumber"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_AccountNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_DisplayName"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_DisplayName"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_BatchId"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_BatchId"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_TransId"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_TransId"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_VoucherNumber"))) {
					
						print(Actual_Value,prop.getProperty("FDAc_VoucherNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_TranType"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_TranType"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_TransAmount"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_TransAmount"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_AmountType"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_AmountType"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_GlAcCode"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_GlAcCode"));
						
					}else if(Actual_Value.equals(prop.getProperty("FDAc_TransferMode"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_TransferMode"));
						
					}else if (Actual_Value.equals(prop.getProperty("FDAc_OrgId"))) {
						
						print(Actual_Value,prop.getProperty("FDAc_OrgId"));
					
												
					}else if(Actual_Value.substring(0, 9).equals(TRANSDATE)){
						
						print(Actual_Value.substring(0, 9),TRANSDATE);	
					
					}else if(Actual_Value.substring(0, 9).equals(VALUEDATE)) {
						
						print(Actual_Value.substring(0, 9),VALUEDATE);	
						
							
					}else {
						Driver.tcFlag = "FAIL";
						//e.printStackTrace(new PrintWriter(Driver.errors));
						//Driver.comment = Driver.errors.toString();
						Driver.comment = Driver.objectName + " and its Database value are (test)  not matching";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					}
				
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " (test2)is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}
			
	

	break;

	
		
	case "name":
		
		break;
		
	case "css":
		
		break;
	}
	
	
	
	
	return driver;
	
}

public static WebDriver Verify_message(WebDriver driver, String locatorType, String propertyValue, String testData) {
	
	WebElement element=null;
	 String Actual_Value=null;
	 
	System.out.println("inside verify message");
	
	switch(locatorType.toLowerCase()){
	
	case "id":
		
	break;
	
	case "xpath":
		
		try{
			//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue))); //commented on Jan 14th, 2020 by Ravikiran
			element = (new WebDriverWait(driver, 180)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue))); //Added this line on Jan 14th, 2020

			//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
			if (element.isDisplayed() == true) {
				
				System.out.println("testdata "+testData);
				
			Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
			
				
				//Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
				
			System.out.println("value is "+ Actual_Value);
				
				if (Actual_Value.equals(testData)) {
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass" + " # " + "Expected Value: " + testData + "<br>" + "Actual Value: " + Actual_Value; 
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					Driver.comment = "Expected Value: " + testData + "<br>" + "Actual Value: " + Actual_Value;
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
			
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

public static WebDriver VerifySummary_DD_CashMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
	
	 WebElement element=null;
	 String Actual_Value=null;
	
	switch(locatorType.toLowerCase()){
	
	case "id":
		
	break;
		
		
	case "xpath":
		
		System.out.println("Inside verify summary method");
		try{
			element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				
			if (element.isDisplayed() == true) {
					
					if(element.isEnabled()==true) {	
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
					
					}else {
						
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
						
					}
					
					System.out.println("Actual value is "+Actual_Value);

					
					Properties prop=new Properties();
					
					InputStream input = new FileInputStream("./DataFiles/DD_CASH_Details.properties");
					prop.load(input);
					
					/*String TransDateFromFile=prop.getProperty("Share_TransactionDate");
					SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
					Date newTransdate=sdfrmt.parse(TransDateFromFile);
					sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
					String TRANSDATE=sdfrmt.format(newTransdate);
					
					
					String ValueDateFromFile=prop.getProperty("Share_ValueDate");
					SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
					Date newValdate=sdfrmt1.parse(ValueDateFromFile);
					sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
					String VALUEDATE=sdfrmt1.format(newValdate);*/
					
					
                   if(Actual_Value.equals(prop.getProperty("DD_ProductName"))) {
						
						//System.out.println("inside Product name validation  "+ Actual_Value+" "+prop.getProperty("InvestmentAccount_productName")) ;
						
							print(Actual_Value,prop.getProperty("DD_ProductName"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_AccountNumber"))) {
						
						print(Actual_Value,prop.getProperty("DD_AccountNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_DisplayName"))) {
						
						print(Actual_Value,prop.getProperty("DD_DisplayName"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_BatchId"))) {
						
						print(Actual_Value,prop.getProperty("DD_BatchId"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_TransId"))) {
						
						print(Actual_Value,prop.getProperty("DD_TransId"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_VoucherNumber"))) {
					
						print(Actual_Value,prop.getProperty("DD_VoucherNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_TranType"))) {
						
						print(Actual_Value,prop.getProperty("DD_TranType"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_TransAmount"))) {
						
						print(Actual_Value,prop.getProperty("DD_TransAmount"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_AmountType"))) {
						
						print(Actual_Value,prop.getProperty("DD_AmountType"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_GlAcCode"))) {
						
						print(Actual_Value,prop.getProperty("DD_GlAcCode"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_TransferMode"))) {
						
						print(Actual_Value,prop.getProperty("DD_TransferMode"));
						
					}else if (Actual_Value.equals(prop.getProperty("DD_OrgId"))) {
						
						print(Actual_Value,prop.getProperty("DD_OrgId"));
					
						
						
						
					
							
					}else {
						Driver.tcFlag = "FAIL";
						//e.printStackTrace(new PrintWriter(Driver.errors));
						//Driver.comment = Driver.errors.toString();
						Driver.comment = Driver.objectName + " and its Database value are (test)  not matching";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					}
				
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " (test2)is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}
			
	

	break;

	
		
	case "name":
		
		break;
		
	case "css":
		
		break;
	}
	
	
	
	
	return driver;
	
}



public static WebDriver Verify_RD_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	
	 WebElement element=null;
	 String Actual_Value=null;
	
	switch(locatorType.toLowerCase()){
	
	case "id":
		
	break;
		
		
	case "xpath":
		
		System.out.println("Inside verify text method");
		try{
			element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				
			if (element.isDisplayed() == true) {
					
					if(element.isEnabled()==true) {	
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
					
					}else {
						
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
						
					}
					
					System.out.println("Actual value is "+Actual_Value);

					
					Properties prop=new Properties();
					
					InputStream input = new FileInputStream("./DataFiles/RD_AUTOPOST_Details.properties");
					prop.load(input);
					
					/*String TransDateFromFile=prop.getProperty("Share_TransactionDate");
					SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
					Date newTransdate=sdfrmt.parse(TransDateFromFile);
					sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
					String TRANSDATE=sdfrmt.format(newTransdate);
					
					
					String ValueDateFromFile=prop.getProperty("Share_ValueDate");
					SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
					Date newValdate=sdfrmt1.parse(ValueDateFromFile);
					sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
					String VALUEDATE=sdfrmt1.format(newValdate);*/
					
					if(Actual_Value.equals(prop.getProperty("ProductName"))) {
	
							print(Actual_Value,prop.getProperty("ProductName"));
						
					}else if(Actual_Value.equals(prop.getProperty("AccountNumber"))) {
						
						print(Actual_Value,prop.getProperty("AccountNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("DisplayName"))) {
						
						print(Actual_Value,prop.getProperty("DisplayName"));
						
					}else if(Actual_Value.equals(prop.getProperty("BatchId"))) {
						
						print(Actual_Value,prop.getProperty("BatchId"));
						
					}else if(Actual_Value.equals(prop.getProperty("TransId"))) {
						
						print(Actual_Value,prop.getProperty("TransId"));
						
					}else if(Actual_Value.equals(prop.getProperty("VoucherNumber"))) {
					
						print(Actual_Value,prop.getProperty("VoucherNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("TranType"))) {
						
						print(Actual_Value,prop.getProperty("TranType"));
						
					}else if(Actual_Value.equals(prop.getProperty("TransAmount"))) {
						
						print(Actual_Value,prop.getProperty("TransAmount"));
						
					}else if(Actual_Value.equals(prop.getProperty("AmountType"))) {
						
						print(Actual_Value,prop.getProperty("AmountType"));
						
					}else if(Actual_Value.equals(prop.getProperty("GlAcCode"))) {
						
						print(Actual_Value,prop.getProperty("GlAcCode"));
						
					}else if(Actual_Value.equals(prop.getProperty("TransferMode"))) {
						
						print(Actual_Value,prop.getProperty("TransferMode"));
						
					}else if (Actual_Value.equals(prop.getProperty("OrgId"))) {
						
						print(Actual_Value,prop.getProperty("OrgId"));
					
						
						
					}else if (Actual_Value.equals(prop.getProperty("SB_ProductName"))) {
						
						print(Actual_Value,prop.getProperty("SB_ProductName"));	
						
					}else if (Actual_Value.equals(prop.getProperty("SB_AccountNumber"))) {
						
						print(Actual_Value,prop.getProperty("SB_AccountNumber"));		
						
					}else if (Actual_Value.equals(prop.getProperty("SB_AccountDisplayName"))) {
						
						print(Actual_Value,prop.getProperty("SB_AccountDisplayName"));		
						
					}else if (Actual_Value.equals(prop.getProperty("SB__BatchId"))) {
						
						print(Actual_Value,prop.getProperty("SB_BatchId"));	
						
					}else if (Actual_Value.equals(prop.getProperty("SB_TransId"))) {
						
						print(Actual_Value,prop.getProperty("SB_TransId"));
						
					}else if (Actual_Value.equals(prop.getProperty("SB_VoucherNo"))) {
						
						print(Actual_Value,prop.getProperty("SB_VoucherNo"));
						
					}else if (Actual_Value.equals(prop.getProperty("SB_TransType"))) {
						
						print(Actual_Value,prop.getProperty("SB_TransType"));
						
					}else if (Actual_Value.equals(prop.getProperty("SB_TrnAmount"))) {
						
						print(Actual_Value,prop.getProperty("SB_TrnAmount"));	
						
					}else if (Actual_Value.equals(prop.getProperty("SB_AmountType"))) {
						
						print(Actual_Value,prop.getProperty("SB_AmountType"));
						
					}else if (Actual_Value.equals(prop.getProperty("SB_GlAcCode"))) {
						
						print(Actual_Value,prop.getProperty("SB_GlAcCode"));	
						
					}else if (Actual_Value.equals(prop.getProperty("SB_TrnMode"))) {
						
						print(Actual_Value,prop.getProperty("SB_TrnMode"));	
						
					}else if (Actual_Value.equals(prop.getProperty("SB_OrgId"))) {
						
						print(Actual_Value,prop.getProperty("SB_OrgId"));
			
					//}else if(Actual_Value.substring(0, 9).equals(TRANSDATE)){
						
					//	print(Actual_Value.substring(0, 9),TRANSDATE);	
					
					//}else if(Actual_Value.substring(0, 9).equals(VALUEDATE)) {
						
						//print(Actual_Value.substring(0, 9),VALUEDATE);	
							
					}else {
						Driver.tcFlag = "FAIL";
						//e.printStackTrace(new PrintWriter(Driver.errors));
						//Driver.comment = Driver.errors.toString();
						Driver.comment = Driver.objectName + " and its Database value are (test)  not matching";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					}
				
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " (test2)is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}
			
	

	break;

	
		
	case "name":
		
		break;
		
	case "css":
		
		break;
	}
	
	
	
	
	return driver;
	
}


public static WebDriver Verify_DD_CashMode(WebDriver driver, String locatorType, String propertyValue, String testData) {

	WebElement element=null;
	 String Actual_Value=null;
	
	switch(locatorType.toLowerCase()){
	
	case "id":
		
	break;
		
		
	case "xpath":
		
		//System.out.println("Inside verify summary method");
		try{
			element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				
			if (element.isDisplayed() == true) {
					
					if(element.isEnabled()==true) {	
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
					
					}else {
						
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
						
					}
					
					System.out.println("Actual value is "+Actual_Value);

					
					Properties prop=new Properties();
					
					InputStream input = new FileInputStream("./DataFiles/DD_BATCH_Details.properties");
					prop.load(input);
					
					
					
					if(Actual_Value.equals(prop.getProperty("DD_ProductName"))) {
						
						//System.out.println("inside Product name validation  "+ Actual_Value+" "+prop.getProperty("InvestmentAccount_productName")) ;
						
							print(Actual_Value,prop.getProperty("DD_ProductName"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_AccountNumber"))) {
						
						print(Actual_Value,prop.getProperty("DD_AccountNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_DisplayName"))) {
						
						print(Actual_Value,prop.getProperty("DD_DisplayName"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_BatchId"))) {
						
						print(Actual_Value,prop.getProperty("DD_BatchId"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_TransId"))) {
						
						print(Actual_Value,prop.getProperty("DD_TransId"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_VoucherNumber"))) {
					
						print(Actual_Value,prop.getProperty("DD_VoucherNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_TranType"))) {
						
						print(Actual_Value,prop.getProperty("DD_TranType"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_TransAmount"))) {
						
						print(Actual_Value,prop.getProperty("DD_TransAmount"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_AmountType"))) {
						
						print(Actual_Value,prop.getProperty("DD_AmountType"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_GlAcCode"))) {
						
						print(Actual_Value,prop.getProperty("DD_GlAcCode"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_TransferMode"))) {
						
						print(Actual_Value,prop.getProperty("DD_TransferMode"));
						
					}else if (Actual_Value.equals(prop.getProperty("DD_OrgId"))) {
						
						print(Actual_Value,prop.getProperty("DD_OrgId"));
				
					}else {
						Driver.tcFlag = "FAIL";
						//e.printStackTrace(new PrintWriter(Driver.errors));
						//Driver.comment = Driver.errors.toString();
						Driver.comment = Driver.objectName + " and its Database value are (test)  not matching";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					}
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " (test2)is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}
			
	

	break;

	
		
	case "name":
		
		break;
		
	case "css":
		
		break;
	}
	
	
	
	
	return driver;	
}

public static WebDriver Verify_DD_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	
	 WebElement element=null;
	 String Actual_Value=null;
	
	switch(locatorType.toLowerCase()){
	
	case "id":
		
	break;
		
		
	case "xpath":
		
		System.out.println("Inside verify text method");
		try{
			element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				
			if (element.isDisplayed() == true) {
					
					if(element.isEnabled()==true) {	
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
					
					}else {
						
						
					Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
						
					}
					
					System.out.println("Actual value is "+Actual_Value);

					
					Properties prop=new Properties();
					
					InputStream input = new FileInputStream("./DataFiles/DD_AUTOPOST_Details.properties");
					prop.load(input);
					
					/*String TransDateFromFile=prop.getProperty("Share_TransactionDate");
					SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
					Date newTransdate=sdfrmt.parse(TransDateFromFile);
					sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
					String TRANSDATE=sdfrmt.format(newTransdate);
					
					
					String ValueDateFromFile=prop.getProperty("Share_ValueDate");
					SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
					Date newValdate=sdfrmt1.parse(ValueDateFromFile);
					sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
					String VALUEDATE=sdfrmt1.format(newValdate);*/
					
					if(Actual_Value.equals(prop.getProperty("DD_ProductName"))) {
	
							print(Actual_Value,prop.getProperty("DD_ProductName"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_AccountNumber"))) {
						
						print(Actual_Value,prop.getProperty("DD_AccountNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_DisplayName"))) {
						
						print(Actual_Value,prop.getProperty("DD_DisplayName"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_BatchId"))) {
						
						print(Actual_Value,prop.getProperty("DD_BatchId"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_TransId"))) {
						
						print(Actual_Value,prop.getProperty("DD_TransId"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_VoucherNumber"))) {
					
						print(Actual_Value,prop.getProperty("DD_VoucherNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_TranType"))) {
						
						print(Actual_Value,prop.getProperty("DD_TranType"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_TransAmount"))) {
						
						print(Actual_Value,prop.getProperty("DD_TransAmount"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_AmountType"))) {
						
						print(Actual_Value,prop.getProperty("DD_AmountType"));
						
					}else if(Actual_Value.equals(prop.getProperty("DD_GlAcCode"))) {
						
						print(Actual_Value,prop.getProperty("DD_GlAcCode"));
						
					}else if(Actual_Value.equals(prop.getProperty("TDD_ransferMode"))) {
						
						print(Actual_Value,prop.getProperty("DD_TransferMode"));
						
					}else if (Actual_Value.equals(prop.getProperty("DD_OrgId"))) {
						
						print(Actual_Value,prop.getProperty("DD_OrgId"));
					
						
						
					}else if (Actual_Value.equals(prop.getProperty("SB_Productname"))) {
						
						print(Actual_Value,prop.getProperty("SB_Productname"));	
						
					}else if (Actual_Value.equals(prop.getProperty("SB_AccountNumber"))) {
						
						print(Actual_Value,prop.getProperty("SB_AccountNumber"));		
						
					}else if (Actual_Value.equals(prop.getProperty("SB_AccountDisplayName"))) {
						
						print(Actual_Value,prop.getProperty("SB_AccountDisplayName"));		
						
					}else if (Actual_Value.equals(prop.getProperty("SB_BatchId"))) {
						
						print(Actual_Value,prop.getProperty("SB_BatchId"));	
						
					}else if (Actual_Value.equals(prop.getProperty("SB_TransId"))) {
						
						print(Actual_Value,prop.getProperty("SB_TransId"));
						
					}else if (Actual_Value.equals(prop.getProperty("SB_VoucherNo"))) {
						
						print(Actual_Value,prop.getProperty("SB_VoucherNo"));
						
					}else if (Actual_Value.equals(prop.getProperty("SB_TransType"))) {
						
						print(Actual_Value,prop.getProperty("SB_TransType"));
						
					}else if (Actual_Value.equals(prop.getProperty("SB_TrnAmount"))) {
						
						print(Actual_Value,prop.getProperty("SB_TrnAmount"));	
						
					}else if (Actual_Value.equals(prop.getProperty("SB_AmountType"))) {
						
						print(Actual_Value,prop.getProperty("SB_AmountType"));
						
					}else if (Actual_Value.equals(prop.getProperty("SB_GlAcCode"))) {
						
						print(Actual_Value,prop.getProperty("SB_GlAcCode"));	
						
					}else if (Actual_Value.equals(prop.getProperty("SB_TrnMode"))) {
						
						print(Actual_Value,prop.getProperty("SB_TrnMode"));	
						
					}else if (Actual_Value.equals(prop.getProperty("SB_OrgId"))) {
						
						print(Actual_Value,prop.getProperty("SB_OrgId"));
			
					//}else if(Actual_Value.substring(0, 9).equals(TRANSDATE)){
						
					//	print(Actual_Value.substring(0, 9),TRANSDATE);	
					
					//}else if(Actual_Value.substring(0, 9).equals(VALUEDATE)) {
						
						//print(Actual_Value.substring(0, 9),VALUEDATE);	
							
					}else {
						Driver.tcFlag = "FAIL";
						//e.printStackTrace(new PrintWriter(Driver.errors));
						//Driver.comment = Driver.errors.toString();
						Driver.comment = Driver.objectName + " and its Database value are (test)  not matching";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					}
				
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " (test2)is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}
			
	

	break;

	
		
	case "name":
		
		break;
		
	case "css":
		
		break;
	}
	
	
	
	
	return driver;
	
}

}



