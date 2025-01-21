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

  public class VerifyCClass {
	
  public static void print(String ActualValue, String DbValue) {
		
		System.out.println("Actual value and DB value is "+ ActualValue +"  "+ DbValue);
		
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "Value From Database: " + DbValue + "<br>" + "Actual Value: " + ActualValue; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
  }
  public static WebDriver Verify_NominalShareOpening_CashMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
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
						
						InputStream input = new FileInputStream("./DataFiles/NominalShareOpening_CashMode_Details.properties");
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
						
						
	                   if(Actual_Value.equals(prop.getProperty("ShareAc_ProductName"))) {
							
							//System.out.println("inside Product name validation  "+ Actual_Value+" "+prop.getProperty("InvestmentAccount_productName")) ;
							
								print(Actual_Value,prop.getProperty("ShareAc_ProductName"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_AccountNumber"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_DisplayName"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_DisplayName"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_BatchId"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_TransId"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_TransId"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_VoucherNumber"))) {
						
							print(Actual_Value,prop.getProperty("ShareAc_VoucherNumber"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_TranType"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_TranType"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_TransAmount"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_TransAmount"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_AmountType"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_GlAcCode"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_GlAcCode"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_TransferMode"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_TransferMode"));
							
						}else if (Actual_Value.equals(prop.getProperty("ShareAc_OrgId"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_OrgId"));
						
							
							
						}else if (Actual_Value.equals(prop.getProperty("EF_ProductName"))) {
							
							print(Actual_Value,prop.getProperty("EF_ProductName"));	
							
						}else if (Actual_Value.equals(prop.getProperty("EF_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("EF_AccountNumber"));		
							
						}else if (Actual_Value.equals(prop.getProperty("EF_AccountDisplayName"))) {
							
							print(Actual_Value,prop.getProperty("EF_AccountDisplayName"));		
							
						}else if (Actual_Value.equals(prop.getProperty("EF_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("EF_BatchId"));	
							
						}else if (Actual_Value.equals(prop.getProperty("EF_TransId"))) {
							
							print(Actual_Value,prop.getProperty("EF_TransId"));
							
						}else if (Actual_Value.equals(prop.getProperty("EF_VoucherNo"))) {
							
							print(Actual_Value,prop.getProperty("EF_VoucherNo"));
							
						}else if (Actual_Value.equals(prop.getProperty("EF_TransType"))) {
							
							print(Actual_Value,prop.getProperty("EF_TransType"));
							
						}else if (Actual_Value.equals(prop.getProperty("EF_TrnAmount"))) {
							
							print(Actual_Value,prop.getProperty("EF_TrnAmount"));	
							
						}else if (Actual_Value.equals(prop.getProperty("EF_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("EF_AmountType"));
							
						}else if (Actual_Value.equals(prop.getProperty("EF_GlAcCode"))) {
							
							print(Actual_Value,prop.getProperty("EF_GlAcCode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("EF_TrnMode"))) {
							
							print(Actual_Value,prop.getProperty("EF_TrnMode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("EF_OrgId"))) {
							
							print(Actual_Value,prop.getProperty("EF_OrgId"));
							
							
						}else if (Actual_Value.equals(prop.getProperty("ST_ProductName"))) {
							
							print(Actual_Value,prop.getProperty("ST_ProductName"));	
							
						}else if (Actual_Value.equals(prop.getProperty("ST_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("ST_AccountNumber"));		
							
						}else if (Actual_Value.equals(prop.getProperty("ST_AccountDisplayName"))) {
							
							print(Actual_Value,prop.getProperty("ST_AccountDisplayName"));		
							
						}else if (Actual_Value.equals(prop.getProperty("ST_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("ST_BatchId"));	
							
						}else if (Actual_Value.equals(prop.getProperty("ST_TransId"))) {
							
							print(Actual_Value,prop.getProperty("ST_TransId"));
							
						}else if (Actual_Value.equals(prop.getProperty("ST_VoucherNo"))) {
							
							print(Actual_Value,prop.getProperty("ST_VoucherNo"));
							
						}else if (Actual_Value.equals(prop.getProperty("ST_TransType"))) {
							
							print(Actual_Value,prop.getProperty("ST_TransType"));
							
						}else if (Actual_Value.equals(prop.getProperty("ST_TrnAmount"))) {
							
							print(Actual_Value,prop.getProperty("ST_TrnAmount"));	
							
						}else if (Actual_Value.equals(prop.getProperty("ST_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("ST_AmountType"));
							
						}else if (Actual_Value.equals(prop.getProperty("ST_GlAcCode"))) {
							
							print(Actual_Value,prop.getProperty("ST_GlAcCode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("ST_TrnMode"))) {
							
							print(Actual_Value,prop.getProperty("ST_TrnMode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("ST_OrgId"))) {
							
							print(Actual_Value,prop.getProperty("ST_OrgId"));
								
							
							
						}else if (Actual_Value.equals(prop.getProperty("PF_ProductName"))) {
							
							print(Actual_Value,prop.getProperty("PF_ProductName"));	
							
						}else if (Actual_Value.equals(prop.getProperty("PF_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("PF_AccountNumber"));		
							
						}else if (Actual_Value.equals(prop.getProperty("PF_AccountDisplayName"))) {
							
							print(Actual_Value,prop.getProperty("PF_AccountDisplayName"));		
							
						}else if (Actual_Value.equals(prop.getProperty("PF_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("PF_BatchId"));	
							
						}else if (Actual_Value.equals(prop.getProperty("PF_TransId"))) {
							
							print(Actual_Value,prop.getProperty("PF_TransId"));
							
						}else if (Actual_Value.equals(prop.getProperty("PF_VoucherNo"))) {
							
							print(Actual_Value,prop.getProperty("PF_VoucherNo"));
							
						}else if (Actual_Value.equals(prop.getProperty("PF_TransType"))) {
							
							print(Actual_Value,prop.getProperty("PF_TransType"));
							
						}else if (Actual_Value.equals(prop.getProperty("PF_TrnAmount"))) {
							
							print(Actual_Value,prop.getProperty("PF_TrnAmount"));	
							
						}else if (Actual_Value.equals(prop.getProperty("PF_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("PF_AmountType"));
							
						}else if (Actual_Value.equals(prop.getProperty("PF_GlAcCode"))) {
							
							print(Actual_Value,prop.getProperty("PF_GlAcCode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("PF_TrnMode"))) {
							
							print(Actual_Value,prop.getProperty("PF_TrnMode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("PF_OrgId"))) {
							
							print(Actual_Value,prop.getProperty("PF_OrgId"));
							
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
  public static WebDriver Verify_NominalShareOpening_TransferMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
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
						
						InputStream input = new FileInputStream("./DataFiles/NominalShareOpening_TransferMode_Details.properties");
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
						
						if(Actual_Value.equals(prop.getProperty("ShareAc_ProductName"))) {
							
							//System.out.println("inside Product name validation  "+ Actual_Value+" "+prop.getProperty("InvestmentAccount_productName")) ;
							
								print(Actual_Value,prop.getProperty("ShareAc_ProductName"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_AccountNumber"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_DisplayName"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_DisplayName"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_BatchId"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_TransId"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_TransId"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_VoucherNumber"))) {
						
							print(Actual_Value,prop.getProperty("ShareAc_VoucherNumber"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_TranType"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_TranType"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_TransAmount"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_TransAmount"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_AmountType"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_GlAcCode"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_GlAcCode"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_TransferMode"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_TransferMode"));
							
						}else if (Actual_Value.equals(prop.getProperty("ShareAc_OrgId"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_OrgId"));
						
							
							
						}else if (Actual_Value.equals(prop.getProperty("EF_ProductName"))) {
							
							print(Actual_Value,prop.getProperty("EF_ProductName"));	
							
						}else if (Actual_Value.equals(prop.getProperty("EF_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("EF_AccountNumber"));		
							
						}else if (Actual_Value.equals(prop.getProperty("EF_AccountDisplayName"))) {
							
							print(Actual_Value,prop.getProperty("EF_AccountDisplayName"));		
							
						}else if (Actual_Value.equals(prop.getProperty("EF_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("EF_BatchId"));	
							
						}else if (Actual_Value.equals(prop.getProperty("EF_TransId"))) {
							
							print(Actual_Value,prop.getProperty("EF_TransId"));
							
						}else if (Actual_Value.equals(prop.getProperty("EF_VoucherNo"))) {
							
							print(Actual_Value,prop.getProperty("EF_VoucherNo"));
							
						}else if (Actual_Value.equals(prop.getProperty("EF_TransType"))) {
							
							print(Actual_Value,prop.getProperty("EF_TransType"));
							
						}else if (Actual_Value.equals(prop.getProperty("EF_TrnAmount"))) {
							
							print(Actual_Value,prop.getProperty("EF_TrnAmount"));	
							
						}else if (Actual_Value.equals(prop.getProperty("EF_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("EF_AmountType"));
							
						}else if (Actual_Value.equals(prop.getProperty("EF_GlAcCode"))) {
							
							print(Actual_Value,prop.getProperty("EF_GlAcCode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("EF_TrnMode"))) {
							
							print(Actual_Value,prop.getProperty("EF_TrnMode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("EF_OrgId"))) {
							
							print(Actual_Value,prop.getProperty("EF_OrgId"));
							
							
						}else if (Actual_Value.equals(prop.getProperty("ST_ProductName"))) {
							
							print(Actual_Value,prop.getProperty("ST_ProductName"));	
							
						}else if (Actual_Value.equals(prop.getProperty("ST_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("ST_AccountNumber"));		
							
						}else if (Actual_Value.equals(prop.getProperty("ST_AccountDisplayName"))) {
							
							print(Actual_Value,prop.getProperty("ST_AccountDisplayName"));		
							
						}else if (Actual_Value.equals(prop.getProperty("ST_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("ST_BatchId"));	
							
						}else if (Actual_Value.equals(prop.getProperty("ST_TransId"))) {
							
							print(Actual_Value,prop.getProperty("ST_TransId"));
							
						}else if (Actual_Value.equals(prop.getProperty("ST_VoucherNo"))) {
							
							print(Actual_Value,prop.getProperty("ST_VoucherNo"));
							
						}else if (Actual_Value.equals(prop.getProperty("ST_TransType"))) {
							
							print(Actual_Value,prop.getProperty("ST_TransType"));
							
						}else if (Actual_Value.equals(prop.getProperty("ST_TrnAmount"))) {
							
							print(Actual_Value,prop.getProperty("ST_TrnAmount"));	
							
						}else if (Actual_Value.equals(prop.getProperty("ST_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("ST_AmountType"));
							
						}else if (Actual_Value.equals(prop.getProperty("ST_GlAcCode"))) {
							
							print(Actual_Value,prop.getProperty("ST_GlAcCode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("ST_TrnMode"))) {
							
							print(Actual_Value,prop.getProperty("ST_TrnMode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("ST_OrgId"))) {
							
							print(Actual_Value,prop.getProperty("ST_OrgId"));
								
							
							
						}else if (Actual_Value.equals(prop.getProperty("PF_ProductName"))) {
							
							print(Actual_Value,prop.getProperty("PF_ProductName"));	
							
						}else if (Actual_Value.equals(prop.getProperty("PF_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("PF_AccountNumber"));		
							
						}else if (Actual_Value.equals(prop.getProperty("PF_AccountDisplayName"))) {
							
							print(Actual_Value,prop.getProperty("PF_AccountDisplayName"));		
							
						}else if (Actual_Value.equals(prop.getProperty("PF_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("PF_BatchId"));	
							
						}else if (Actual_Value.equals(prop.getProperty("PF_TransId"))) {
							
							print(Actual_Value,prop.getProperty("PF_TransId"));
							
						}else if (Actual_Value.equals(prop.getProperty("PF_VoucherNo"))) {
							
							print(Actual_Value,prop.getProperty("PF_VoucherNo"));
							
						}else if (Actual_Value.equals(prop.getProperty("PF_TransType"))) {
							
							print(Actual_Value,prop.getProperty("PF_TransType"));
							
						}else if (Actual_Value.equals(prop.getProperty("PF_TrnAmount"))) {
							
							print(Actual_Value,prop.getProperty("PF_TrnAmount"));	
							
						}else if (Actual_Value.equals(prop.getProperty("PF_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("PF_AmountType"));
							
						}else if (Actual_Value.equals(prop.getProperty("PF_GlAcCode"))) {
							
							print(Actual_Value,prop.getProperty("PF_GlAcCode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("PF_TrnMode"))) {
							
							print(Actual_Value,prop.getProperty("PF_TrnMode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("PF_OrgId"))) {
							
							print(Actual_Value,prop.getProperty("PF_OrgId"));
							
							
						}else if (Actual_Value.equals(prop.getProperty("DrAc_ProductName"))) {
							
							print(Actual_Value,prop.getProperty("DrAc_ProductName"));	
							
						}else if (Actual_Value.equals(prop.getProperty("DrAc_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("DrAc_AccountNumber"));		
							
						}else if (Actual_Value.equals(prop.getProperty("DrAc_AccountDisplayName"))) {
							
							print(Actual_Value,prop.getProperty("DrAc_AccountDisplayName"));		
							
						}else if (Actual_Value.equals(prop.getProperty("DrAc_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("DrAc_BatchId"));	
							
						}else if (Actual_Value.equals(prop.getProperty("DrAc_TransId"))) {
							
							print(Actual_Value,prop.getProperty("DrAc_TransId"));
							
						}else if (Actual_Value.equals(prop.getProperty("DrAc_VoucherNo"))) {
							
							print(Actual_Value,prop.getProperty("DrAc_VoucherNo"));
							
						}else if (Actual_Value.equals(prop.getProperty("DrAc_TransType"))) {
							
							print(Actual_Value,prop.getProperty("DrAc_TransType"));
							
						}else if (Actual_Value.equals(prop.getProperty("DrAc_TrnAmount"))) {
							
							print(Actual_Value,prop.getProperty("DrAc_TrnAmount"));	
							
						}else if (Actual_Value.equals(prop.getProperty("DrAc_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("DrAc_AmountType"));
							
						}else if (Actual_Value.equals(prop.getProperty("DrAc_GlAcCode"))) {
							
							print(Actual_Value,prop.getProperty("DrAc_GlAcCode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("DrAc_TrnMode"))) {
							
							print(Actual_Value,prop.getProperty("DrAc_TrnMode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("DrAc_OrgId"))) {
							
							print(Actual_Value,prop.getProperty("DrAc_OrgId"));	
							
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
  public static WebDriver Verify_NominalShareOpening_BatchMode(WebDriver driver, String locatorType, String propertyValue, String testData) {

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
						
						InputStream input = new FileInputStream("./DataFiles/NominalShareOpening_BatchMode_Details.properties");
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
						
						
	                                                  if(Actual_Value.equals(prop.getProperty("ShareAc_ProductName"))) {
							
							//System.out.println("inside Product name validation  "+ Actual_Value+" "+prop.getProperty("InvestmentAccount_productName")) ;
							
								print(Actual_Value,prop.getProperty("ShareAc_ProductName"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_AccountNumber"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_DisplayName"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_DisplayName"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_BatchId"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_TransId"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_TransId"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_VoucherNumber"))) {
						
							print(Actual_Value,prop.getProperty("ShareAc_VoucherNumber"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_TranType"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_TranType"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_TransAmount"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_TransAmount"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_AmountType"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_GlAcCode"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_GlAcCode"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAc_TransferMode"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_TransferMode"));
							
						}else if (Actual_Value.equals(prop.getProperty("ShareAc_OrgId"))) {
							
							print(Actual_Value,prop.getProperty("ShareAc_OrgId"));
						
							
							
						}else if (Actual_Value.equals(prop.getProperty("EF_ProductName"))) {
							
							print(Actual_Value,prop.getProperty("EF_ProductName"));	
							
						}else if (Actual_Value.equals(prop.getProperty("EF_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("EF_AccountNumber"));		
							
						}else if (Actual_Value.equals(prop.getProperty("EF_AccountDisplayName"))) {
							
							print(Actual_Value,prop.getProperty("EF_AccountDisplayName"));		
							
						}else if (Actual_Value.equals(prop.getProperty("EF_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("EF_BatchId"));	
							
						}else if (Actual_Value.equals(prop.getProperty("EF_TransId"))) {
							
							print(Actual_Value,prop.getProperty("EF_TransId"));
							
						}else if (Actual_Value.equals(prop.getProperty("EF_VoucherNo"))) {
							
							print(Actual_Value,prop.getProperty("EF_VoucherNo"));
							
						}else if (Actual_Value.equals(prop.getProperty("EF_TransType"))) {
							
							print(Actual_Value,prop.getProperty("EF_TransType"));
							
						}else if (Actual_Value.equals(prop.getProperty("EF_TrnAmount"))) {
							
							print(Actual_Value,prop.getProperty("EF_TrnAmount"));	
							
						}else if (Actual_Value.equals(prop.getProperty("EF_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("EF_AmountType"));
							
						}else if (Actual_Value.equals(prop.getProperty("EF_GlAcCode"))) {
							
							print(Actual_Value,prop.getProperty("EF_GlAcCode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("EF_TrnMode"))) {
							
							print(Actual_Value,prop.getProperty("EF_TrnMode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("EF_OrgId"))) {
							
							print(Actual_Value,prop.getProperty("EF_OrgId"));
							
							
						}else if (Actual_Value.equals(prop.getProperty("ST_ProductName"))) {
							
							print(Actual_Value,prop.getProperty("ST_ProductName"));	
							
						}else if (Actual_Value.equals(prop.getProperty("ST_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("ST_AccountNumber"));		
							
						}else if (Actual_Value.equals(prop.getProperty("ST_AccountDisplayName"))) {
							
							print(Actual_Value,prop.getProperty("ST_AccountDisplayName"));		
							
						}else if (Actual_Value.equals(prop.getProperty("ST_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("ST_BatchId"));	
							
						}else if (Actual_Value.equals(prop.getProperty("ST_TransId"))) {
							
							print(Actual_Value,prop.getProperty("ST_TransId"));
							
						}else if (Actual_Value.equals(prop.getProperty("ST_VoucherNo"))) {
							
							print(Actual_Value,prop.getProperty("ST_VoucherNo"));
							
						}else if (Actual_Value.equals(prop.getProperty("ST_TransType"))) {
							
							print(Actual_Value,prop.getProperty("ST_TransType"));
							
						}else if (Actual_Value.equals(prop.getProperty("ST_TrnAmount"))) {
							
							print(Actual_Value,prop.getProperty("ST_TrnAmount"));	
							
						}else if (Actual_Value.equals(prop.getProperty("ST_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("ST_AmountType"));
							
						}else if (Actual_Value.equals(prop.getProperty("ST_GlAcCode"))) {
							
							print(Actual_Value,prop.getProperty("ST_GlAcCode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("ST_TrnMode"))) {
							
							print(Actual_Value,prop.getProperty("ST_TrnMode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("ST_OrgId"))) {
							
							print(Actual_Value,prop.getProperty("ST_OrgId"));
								
							
							
						}else if (Actual_Value.equals(prop.getProperty("PF_ProductName"))) {
							
							print(Actual_Value,prop.getProperty("PF_ProductName"));	
							
						}else if (Actual_Value.equals(prop.getProperty("PF_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("PF_AccountNumber"));		
							
						}else if (Actual_Value.equals(prop.getProperty("PF_AccountDisplayName"))) {
							
							print(Actual_Value,prop.getProperty("PF_AccountDisplayName"));		
							
						}else if (Actual_Value.equals(prop.getProperty("PF_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("PF_BatchId"));	
							
						}else if (Actual_Value.equals(prop.getProperty("PF_TransId"))) {
							
							print(Actual_Value,prop.getProperty("PF_TransId"));
							
						}else if (Actual_Value.equals(prop.getProperty("PF_VoucherNo"))) {
							
							print(Actual_Value,prop.getProperty("PF_VoucherNo"));
							
						}else if (Actual_Value.equals(prop.getProperty("PF_TransType"))) {
							
							print(Actual_Value,prop.getProperty("PF_TransType"));
							
						}else if (Actual_Value.equals(prop.getProperty("PF_TrnAmount"))) {
							
							print(Actual_Value,prop.getProperty("PF_TrnAmount"));	
							
						}else if (Actual_Value.equals(prop.getProperty("PF_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("PF_AmountType"));
							
						}else if (Actual_Value.equals(prop.getProperty("PF_GlAcCode"))) {
							
							print(Actual_Value,prop.getProperty("PF_GlAcCode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("PF_TrnMode"))) {
							
							print(Actual_Value,prop.getProperty("PF_TrnMode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("PF_OrgId"))) {
							
							print(Actual_Value,prop.getProperty("PF_OrgId"));
							
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
}
