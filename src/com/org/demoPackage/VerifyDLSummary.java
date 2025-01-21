package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyDLSummary {
	
	public static void print(String ActualValue, String DbValue) {
		
		System.out.println("DB value = "+ DbValue);
		
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "Value From Database: " + DbValue + "<br>" + "Actual Value: " + ActualValue; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
	
	
	public static WebDriver VerifySummary_DL_CashMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
		 
		  WebElement element=null;
		  String Actual_Value=null;
		 
		 switch(locatorType.toLowerCase()){
		 
		 case "id":
		  
		 break;
		  
		  
		 case "xpath":
		  
		  System.out.println("Inside verify summary method");
		  try{
		   element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
		    
		   if (element.isDisplayed() == true) {
		     
		     if(element.isEnabled()==true) { 
		      
		     Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
		     
		     }else {
		      
		      
		     Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
		      
		     }
		     
		     System.out.println("Actual value = "+Actual_Value);

		     
		     Properties prop=new Properties();
		     
		     InputStream input = new FileInputStream("./DataFiles/DepositLoanOpening_CashMode.properties");
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
		     
		     
		       if(Actual_Value.equals(prop.getProperty("FDAc_ProductName"))) {
		      
		      
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
		     
		            
		     }
		      
		       
		     else {
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
	
	
	public static WebDriver VerifySummary_DL_TransferMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
		 
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
		     
		     InputStream input = new FileInputStream("./DataFiles/DepositLoanOpening_TransferMode.properties");
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
		     
		     
		     if(Actual_Value.equals(prop.getProperty("CrFDAc_ProductName"))) {
		      
		      
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
		      
		      
		     }/*else if(Actual_Value.substring(0, 9).equals(TRANSDATE)){
		      
		      print(Actual_Value.substring(0, 9),TRANSDATE); 
		     
		     }else if(Actual_Value.substring(0, 9).equals(VALUEDATE)) {
		      
		      print(Actual_Value.substring(0, 9),VALUEDATE);*/ 
		      
		       
		     else {
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

	public static WebDriver VerifySummary_DL_BatchMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
		 
		  WebElement element=null;
		  String Actual_Value=null;
		 
		 switch(locatorType.toLowerCase()){
		 
		 case "id":
		  
		 break;
		  
		  
		 case "xpath":
		  
		  System.out.println("Inside verify summary method");
		  try{
		   element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
		    
		   if (element.isDisplayed() == true) {
		     
		     if(element.isEnabled()==true) { 
		      
		     Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
		     
		     }else {
		      
		      
		     Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
		      
		     }
		     
		     System.out.println("Actual value = "+Actual_Value);

		     
		     Properties prop=new Properties();
		     
		     InputStream input = new FileInputStream("./DataFiles/DepositLoanOpening_BatchMode.properties");
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
		     
		     
		       if(Actual_Value.equals(prop.getProperty("FDAc_ProductName"))) {
		      
		      
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
		     
		            
		     }
		      
		       
		     else {
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

}
