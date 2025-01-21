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

public class VerifyAclass {
	public static void print(String ActualValue, String DbValue) {
		
		System.out.println("Actual value and DB value is "+ ActualValue +"  "+ DbValue);
		
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "Value From Database: " + DbValue + "<br>" + "Actual Value: " + ActualValue; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}


	public static WebDriver Verify_ShareOpening_CashMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
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
						InputStream input = new FileInputStream("./DataFiles/ShareOpening_CashMode_Details.properties");
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
							
							
						}else if (Actual_Value.equals(prop.getProperty("CGST_ProductName"))) {
							
							print(Actual_Value,prop.getProperty("CGST_ProductName"));	
							
						}else if (Actual_Value.equals(prop.getProperty("CGST_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("CGST_AccountNumber"));		
							
						}else if (Actual_Value.equals(prop.getProperty("CGST_AccountDisplayName"))) {
							
							print(Actual_Value,prop.getProperty("CGST_AccountDisplayName"));		
							
						}else if (Actual_Value.equals(prop.getProperty("CGST_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("CGST_BatchId"));	
							
						}else if (Actual_Value.equals(prop.getProperty("CGST_TransId"))) {
							
							print(Actual_Value,prop.getProperty("CGST_TransId"));
							
						}else if (Actual_Value.equals(prop.getProperty("CGST_VoucherNo"))) {
							
							print(Actual_Value,prop.getProperty("CGST_VoucherNo"));
							
						}else if (Actual_Value.equals(prop.getProperty("CGST_TransType"))) {
							
							print(Actual_Value,prop.getProperty("CGST_TransType"));
							
						}else if (Actual_Value.equals(prop.getProperty("CGST_TrnAmount"))) {
							
							print(Actual_Value,prop.getProperty("CGST_TrnAmount"));	
							
						}else if (Actual_Value.equals(prop.getProperty("CGST_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("CGST_AmountType"));
							
						}else if (Actual_Value.equals(prop.getProperty("CGST_GlAcCode"))) {
							
							print(Actual_Value,prop.getProperty("CGST_GlAcCode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("CGST_TrnMode"))) {
							
							print(Actual_Value,prop.getProperty("CGST_TrnMode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("CGST_OrgId"))) {
							
							print(Actual_Value,prop.getProperty("CGST_OrgId"));	
							
							
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
 public static WebDriver Verify_ShareOpening_TransferMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
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
						
						InputStream input = new FileInputStream("./DataFiles/ShareOpening_TransferMode_Details.properties");
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
						
						
						if(Actual_Value.equals(prop.getProperty("ShareproductName"))) {
							
							//System.out.println("inside Product name validation  "+ Actual_Value+" "+prop.getProperty("InvestmentAccount_productName")) ;
							
								print(Actual_Value,prop.getProperty("ShareproductName"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("ShareAccountNumber"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAccountDisplayName"))) {
							
							print(Actual_Value,prop.getProperty("ShareAccountDisplayName"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareBatchId"))) {
							
							print(Actual_Value,prop.getProperty("ShareBatchId"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareTransId"))) {
							
							print(Actual_Value,prop.getProperty("ShareTransId"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareVoucherId"))) {
						
							print(Actual_Value,prop.getProperty("ShareVoucherId"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareTransactionType"))) {
							
							print(Actual_Value,prop.getProperty("ShareTransactionType"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAmount"))) {
							
							print(Actual_Value,prop.getProperty("ShareAmount"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareAmountType"))) {
							
							print(Actual_Value,prop.getProperty("ShareAmountType"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareGLAccCode"))) {
							
							print(Actual_Value,prop.getProperty("ShareGLAccCode"));
							
						}else if(Actual_Value.equals(prop.getProperty("ShareTransferMode"))) {
							
							print(Actual_Value,prop.getProperty("ShareTransferMode"));
							
						}else if (Actual_Value.equals(prop.getProperty("ShareOrgID"))) {
							
							print(Actual_Value,prop.getProperty("ShareOrgID"));
						
							
						}else if (Actual_Value.equals(prop.getProperty("Share_ProductName"))) {
							
							print(Actual_Value,prop.getProperty("Share_ProductName"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("Share_AccountNumber"));		
							
						}else if (Actual_Value.equals(prop.getProperty("Share_AccountDispalyName"))) {
							
							print(Actual_Value,prop.getProperty("Share_AccountDispalyName"));		
							
						}else if (Actual_Value.equals(prop.getProperty("Share_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("Share_BatchId"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_TransactionId"))) {
							
							print(Actual_Value,prop.getProperty("Share_TransactionId"));
							
						}else if (Actual_Value.equals(prop.getProperty("Share_VoucherNumber"))) {
							
							print(Actual_Value,prop.getProperty("Share_VoucherNumber"));
							
						}else if (Actual_Value.equals(prop.getProperty("Share_TransType"))) {
							
							print(Actual_Value,prop.getProperty("Share_TransType"));
							
						}else if (Actual_Value.equals(prop.getProperty("Share_TransAmount"))) {
							
							print(Actual_Value,prop.getProperty("Share_TransAmount"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("Share_AmountType"));
							
						}else if (Actual_Value.equals(prop.getProperty("Share_GLAcCode"))) {
							
							print(Actual_Value,prop.getProperty("Share_GLAcCode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_TransactionMode"))) {
							
							print(Actual_Value,prop.getProperty("Share_TransactionMode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_OrgID"))) {
							
							print(Actual_Value,prop.getProperty("Share_OrgID"));
							
							
							
	                   }else if (Actual_Value.equals(prop.getProperty("Share_ProductName1"))) {
							
							print(Actual_Value,prop.getProperty("Share_ProductName1"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_AccountNumber1"))) {
							
							print(Actual_Value,prop.getProperty("Share_AccountNumber1"));		
							
						}else if (Actual_Value.equals(prop.getProperty("Share_AccountDispalyName1"))) {
							
							print(Actual_Value,prop.getProperty("Share_AccountDispalyName1"));		
							
						}else if (Actual_Value.equals(prop.getProperty("Share_BatchId1"))) {
							
							print(Actual_Value,prop.getProperty("Share_BatchId1"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_TransactionId1"))) {
							
							print(Actual_Value,prop.getProperty("Share_TransactionId1"));
							
						}else if (Actual_Value.equals(prop.getProperty("Share_VoucherNumber1"))) {
							
							print(Actual_Value,prop.getProperty("Share_VoucherNumber1"));
							
						}else if (Actual_Value.equals(prop.getProperty("Share_TransType1"))) {
							
							print(Actual_Value,prop.getProperty("Share_TransType1"));
							
						}else if (Actual_Value.equals(prop.getProperty("Share_TransAmount1"))) {
							
							print(Actual_Value,prop.getProperty("Share_TransAmount1"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_AmountType1"))) {
							
							print(Actual_Value,prop.getProperty("Share_AmountType1"));
							
						}else if (Actual_Value.equals(prop.getProperty("Share_GLAcCode1"))) {
							
							print(Actual_Value,prop.getProperty("Share_GLAcCode1"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_TransactionMode1"))) {
							
							print(Actual_Value,prop.getProperty("Share_TransactionMode1"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_OrgID1"))) {
							
							print(Actual_Value,prop.getProperty("Share_OrgID1"));
							
							
							
							
	                   }else if (Actual_Value.equals(prop.getProperty("Share_ProductName2"))) {
							
							print(Actual_Value,prop.getProperty("Share_ProductName2"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_AccountNumber2"))) {
							
							print(Actual_Value,prop.getProperty("Share_AccountNumber2"));		
							
						}else if (Actual_Value.equals(prop.getProperty("Share_AccountDispalyName2"))) {
							
							print(Actual_Value,prop.getProperty("Share_AccountDispalyName2"));		
							
						}else if (Actual_Value.equals(prop.getProperty("Share_BatchId2"))) {
							
							print(Actual_Value,prop.getProperty("Share_BatchId2"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_TransactionId2"))) {
							
							print(Actual_Value,prop.getProperty("Share_TransactionId2"));
							
						}else if (Actual_Value.equals(prop.getProperty("Share_VoucherNumber2"))) {
							
							print(Actual_Value,prop.getProperty("Share_VoucherNumber2"));
							
						}else if (Actual_Value.equals(prop.getProperty("Share_TransType2"))) {
							
							print(Actual_Value,prop.getProperty("Share_TransType2"));
							
						}else if (Actual_Value.equals(prop.getProperty("Share_TransAmount2"))) {
							
							print(Actual_Value,prop.getProperty("Share_TransAmount2"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_AmountType2"))) {
							
							print(Actual_Value,prop.getProperty("Share_AmountType2"));
							
						}else if (Actual_Value.equals(prop.getProperty("Share_GLAcCode2"))) {
							
							print(Actual_Value,prop.getProperty("Share_GLAcCode2"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_TransactionMode2"))) {
							
							print(Actual_Value,prop.getProperty("Share_TransactionMode2"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_OrgID2"))) {
							
							print(Actual_Value,prop.getProperty("Share_OrgID2"));
							
							
							
	                   }else if (Actual_Value.equals(prop.getProperty("Share_ProductName3"))) {
							
							print(Actual_Value,prop.getProperty("Share_ProductName3"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_AccountNumber3"))) {
							
							print(Actual_Value,prop.getProperty("Share_AccountNumber3"));		
							
						}else if (Actual_Value.equals(prop.getProperty("Share_AccountDispalyName3"))) {
							
							print(Actual_Value,prop.getProperty("Share_AccountDispalyName3"));		
							
						}else if (Actual_Value.equals(prop.getProperty("Share_BatchId3"))) {
							
							print(Actual_Value,prop.getProperty("Share_BatchId3"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_TransactionId3"))) {
							
							print(Actual_Value,prop.getProperty("Share_TransactionId3"));
							
						}else if (Actual_Value.equals(prop.getProperty("Share_VoucherNumber3"))) {
							
							print(Actual_Value,prop.getProperty("Share_VoucherNumber3"));
							
						}else if (Actual_Value.equals(prop.getProperty("Share_TransType3"))) {
							
							print(Actual_Value,prop.getProperty("Share_TransType3"));
							
						}else if (Actual_Value.equals(prop.getProperty("Share_TransAmount3"))) {
							
							print(Actual_Value,prop.getProperty("Share_TransAmount3"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_AmountType3"))) {
							
							print(Actual_Value,prop.getProperty("Share_AmountType3"));
							
						}else if (Actual_Value.equals(prop.getProperty("Share_GLAcCode3"))) {
							
							print(Actual_Value,prop.getProperty("Share_GLAcCode3"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_TransactionMode3"))) {
							
							print(Actual_Value,prop.getProperty("Share_TransactionMode3"));	
							
						}else if (Actual_Value.equals(prop.getProperty("Share_OrgID3"))) {
							
							print(Actual_Value,prop.getProperty("Share_OrgID3"));
							
							
							
						}else if (Actual_Value.equals(prop.getProperty("SBProductName"))) {
							
							print(Actual_Value,prop.getProperty("SBProductName"));	
							
						}else if (Actual_Value.equals(prop.getProperty("SBAccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("SBAccountNumber"));		
							
						}else if (Actual_Value.equals(prop.getProperty("SBAccountDispalyName"))) {
							
							print(Actual_Value,prop.getProperty("SBAccountDispalyName"));		
							
						}else if (Actual_Value.equals(prop.getProperty("SBBatchId"))) {
							
							print(Actual_Value,prop.getProperty("SBBatchId"));	
							
						}else if (Actual_Value.equals(prop.getProperty("SBTransactionId"))) {
							
							print(Actual_Value,prop.getProperty("SBTransactionId"));
							
						}else if (Actual_Value.equals(prop.getProperty("SBVoucherNumber"))) {
							
							print(Actual_Value,prop.getProperty("SBVoucherNumber"));
							
						}else if (Actual_Value.equals(prop.getProperty("SBTransType"))) {
							
							print(Actual_Value,prop.getProperty("SBTransType"));
							
						}else if (Actual_Value.equals(prop.getProperty("SBTransAmount"))) {
							
							print(Actual_Value,prop.getProperty("SBTransAmount"));	
							
						}else if (Actual_Value.equals(prop.getProperty("SBAmountType"))) {
							
							print(Actual_Value,prop.getProperty("SBAmountType"));
							
						}else if (Actual_Value.equals(prop.getProperty("SBGLAcCode"))) {
							
							print(Actual_Value,prop.getProperty("SBGLAcCode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("SBTransactionMode"))) {
							
							print(Actual_Value,prop.getProperty("SBTransactionMode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("SbOrgID"))) {
							
							print(Actual_Value,prop.getProperty("SbOrgID"));
							
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
 public static WebDriver Verify_ShareOpening_BatchMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
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
					
					InputStream input = new FileInputStream("./DataFiles/ShareOpening_BatchMode_Details.properties");
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
					String VALUEDATE=sdfrmt1.format(newValdate);
					
					System.out.println("Transdate "+TRANSDATE );
					
					System.out.println("Transdate "+TRANSDATE );*/
					
					
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
						
						
					}else if (Actual_Value.equals(prop.getProperty("CGST_ProductName"))) {
						
						print(Actual_Value,prop.getProperty("CGST_ProductName"));	
						
					}else if (Actual_Value.equals(prop.getProperty("CGST_AccountNumber"))) {
						
						print(Actual_Value,prop.getProperty("CGST_AccountNumber"));		
						
					}else if (Actual_Value.equals(prop.getProperty("CGST_AccountDisplayName"))) {
						
						print(Actual_Value,prop.getProperty("CGST_AccountDisplayName"));		
						
					}else if (Actual_Value.equals(prop.getProperty("CGST_BatchId"))) {
						
						print(Actual_Value,prop.getProperty("CGST_BatchId"));	
						
					}else if (Actual_Value.equals(prop.getProperty("CGST_TransId"))) {
						
						print(Actual_Value,prop.getProperty("CGST_TransId"));
						
					}else if (Actual_Value.equals(prop.getProperty("CGST_VoucherNo"))) {
						
						print(Actual_Value,prop.getProperty("CGST_VoucherNo"));
						
					}else if (Actual_Value.equals(prop.getProperty("CGST_TransType"))) {
						
						print(Actual_Value,prop.getProperty("CGST_TransType"));
						
					}else if (Actual_Value.equals(prop.getProperty("CGST_TrnAmount"))) {
						
						print(Actual_Value,prop.getProperty("CGST_TrnAmount"));	
						
					}else if (Actual_Value.equals(prop.getProperty("CGST_AmountType"))) {
						
						print(Actual_Value,prop.getProperty("CGST_AmountType"));
						
					}else if (Actual_Value.equals(prop.getProperty("CGST_GlAcCode"))) {
						
						print(Actual_Value,prop.getProperty("CGST_GlAcCode"));	
						
					}else if (Actual_Value.equals(prop.getProperty("CGST_TrnMode"))) {
						
						print(Actual_Value,prop.getProperty("CGST_TrnMode"));	
						
					}else if (Actual_Value.equals(prop.getProperty("CGST_OrgId"))) {
						
						print(Actual_Value,prop.getProperty("CGST_OrgId"));	
					
							
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
