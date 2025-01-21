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

public class VerifyGLSummary {
	
	public static WebDriver Verify_GL_Cash_Summary(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
		 WebElement element=null;
		 String Actual_Value=null;
		
		switch(locatorType.toLowerCase()){
		
		case "id":
			
		break;
			
			
		case "xpath":
			
			//System.out.println("Inside verify summary method");
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable

					
				if (element.isDisplayed() == true) {
						
						if(element.isEnabled()==true) {	
							
						Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
						
						}else {
							
							
						Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
							
						}
						
						//System.out.println("Actual value is "+Actual_Value);

						
						Properties prop=new Properties();
						
						InputStream input = new FileInputStream("./DataFiles/GL_CASH_Details.properties");
						prop.load(input);
						
						/*String TransDateFromFile=prop.getProperty("SB_TransactionDate");
						SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
						Date newTransdate=sdfrmt.parse(TransDateFromFile);
						sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
						String TRANSDATE=sdfrmt.format(newTransdate);
						
						
						String ValueDateFromFile=prop.getProperty("SB_ValueDate");
						SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
						Date newValdate=sdfrmt1.parse(ValueDateFromFile);
						sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
						String VALUEDATE=sdfrmt1.format(newValdate);*/
						
						
						if(Actual_Value.equals(prop.getProperty("GLproductName"))) {
		
							Common.	print(Actual_Value,prop.getProperty("GLproductName"));
							
						}else if(Actual_Value.equals(prop.getProperty("GLAccountNumber"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLAccountNumber"));
							
						}else if(Actual_Value.equals(prop.getProperty("GLAccountDisplayName"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLAccountDisplayName"));
							
						}else if(Actual_Value.equals(prop.getProperty("GLBatchId"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLBatchId"));
							
						}else if(Actual_Value.equals(prop.getProperty("GLTransId"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLTransId"));
							
						}else if(Actual_Value.equals(prop.getProperty("GLVoucherId"))) {
						
							Common.	print(Actual_Value,prop.getProperty("GLVoucherId"));
							
						}else if(Actual_Value.equals(prop.getProperty("ChargeVoucherNumber"))) {
							
							Common.	print(Actual_Value,prop.getProperty("ChargeVoucherNumber"));	
							
							
						}else if(Actual_Value.equals(prop.getProperty("GLTransactionType"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLTransactionType"));
							
						}else if(Actual_Value.equals(prop.getProperty("ChargeTransType"))) {
							
							Common.	print(Actual_Value,prop.getProperty("ChargeTransType"));	
							
						}else if(Actual_Value.equals(prop.getProperty("GLAmount"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLAmount"));
							
						}else if(Actual_Value.equals(prop.getProperty("ChargeTransAmount"))) {
							
							Common.	print(Actual_Value,prop.getProperty("ChargeTransAmount"));	
							
						}else if(Actual_Value.equals(prop.getProperty("GLAmountType"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLAmountType"));
							
						}else if(Actual_Value.equals(prop.getProperty("ChargeAmountType"))) {
							
							Common.	print(Actual_Value,prop.getProperty("ChargeAmountType"));	
							
							
						}else if(Actual_Value.equals(prop.getProperty("GLGLAccCode"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLGLAccCode"));
							
						}else if(Actual_Value.equals(prop.getProperty("ChargeGLAcCode"))) {
							
							Common.	print(Actual_Value,prop.getProperty("ChargeGLAcCode"));	
							
							
						}else if(Actual_Value.equals(prop.getProperty("GLTransferMode"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLTransferMode"));
							
						}else if (Actual_Value.equals(prop.getProperty("GLOrgID"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLOrgID"));
							
						
							
								
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
	
	public static WebDriver Verify_GL_Autopost_Summary(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
		 WebElement element=null;
		 String Actual_Value=null;
		
		switch(locatorType.toLowerCase()){
		
		case "id":
			
		break;
			
			
		case "xpath":
			
			//System.out.println("Inside verify summary method");
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable

					
				if (element.isDisplayed() == true) {
						
						if(element.isEnabled()==true) {	
							
						Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
						
						}else {
							
							
						Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
							
						}
						
						//System.out.println("Actual value is "+Actual_Value);

						
						Properties prop=new Properties();
						
						InputStream input = new FileInputStream("./DataFiles/GL_AUTOPOST_Details.properties");
						prop.load(input);
						
						/*String TransDateFromFile=prop.getProperty("SB_TransactionDate");
						SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
						Date newTransdate=sdfrmt.parse(TransDateFromFile);
						sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
						String TRANSDATE=sdfrmt.format(newTransdate);
						
						
						String ValueDateFromFile=prop.getProperty("SB_ValueDate");
						SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
						Date newValdate=sdfrmt1.parse(ValueDateFromFile);
						sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
						String VALUEDATE=sdfrmt1.format(newValdate);*/
						
						
						if(Actual_Value.equals(prop.getProperty("GLproductName"))) {
		
							Common.	print(Actual_Value,prop.getProperty("GLproductName"));
							
						}else if(Actual_Value.equals(prop.getProperty("GLAccountNumber"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLAccountNumber"));
							
						}else if(Actual_Value.equals(prop.getProperty("GLAccountDisplayName"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLAccountDisplayName"));
							
						}else if(Actual_Value.equals(prop.getProperty("GLBatchId"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLBatchId"));
							
						}else if(Actual_Value.equals(prop.getProperty("GLTransId"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLTransId"));
							
						}else if(Actual_Value.equals(prop.getProperty("GLVoucherId"))) {
						
							Common.	print(Actual_Value,prop.getProperty("GLVoucherId"));
							
						}else if(Actual_Value.equals(prop.getProperty("ChargeVoucherNumber"))) {
							
							Common.	print(Actual_Value,prop.getProperty("ChargeVoucherNumber"));	
							
							
						}else if(Actual_Value.equals(prop.getProperty("GLTransactionType"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLTransactionType"));
							
						}else if(Actual_Value.equals(prop.getProperty("ChargeTransType"))) {
							
							Common.	print(Actual_Value,prop.getProperty("ChargeTransType"));	
							
						}else if(Actual_Value.equals(prop.getProperty("GLAmount"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLAmount"));
							
						}else if(Actual_Value.equals(prop.getProperty("ChargeTransAmount"))) {
							
							Common.	print(Actual_Value,prop.getProperty("ChargeTransAmount"));	
							
						}else if(Actual_Value.equals(prop.getProperty("GLAmountType"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLAmountType"));
							
						}else if(Actual_Value.equals(prop.getProperty("ChargeAmountType"))) {
							
							Common.	print(Actual_Value,prop.getProperty("ChargeAmountType"));	
							
							
						}else if(Actual_Value.equals(prop.getProperty("GLGLAccCode"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLGLAccCode"));
							
						}else if(Actual_Value.equals(prop.getProperty("ChargeGLAcCode"))) {
							
							Common.	print(Actual_Value,prop.getProperty("ChargeGLAcCode"));	
							
							
						}else if(Actual_Value.equals(prop.getProperty("GLTransferMode"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLTransferMode"));
							
						}else if (Actual_Value.equals(prop.getProperty("GLOrgID"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLOrgID"));
						
							
						}else if(Actual_Value.equals(prop.getProperty("SBProductName"))) {
								
							
								
								Common.	print(Actual_Value,prop.getProperty("SBProductName"));
								
							}else if(Actual_Value.equals(prop.getProperty("SBAccountNumber"))) {
								
								Common.	print(Actual_Value,prop.getProperty("SBAccountNumber"));
								
							}else if(Actual_Value.equals(prop.getProperty("SBAccountDispalyName"))) {
								
								Common.	print(Actual_Value,prop.getProperty("SBAccountDispalyName"));
								
							}else if(Actual_Value.equals(prop.getProperty("SBBatchId"))) {
								
								Common.	print(Actual_Value,prop.getProperty("SBBatchId"));
								
							}else if(Actual_Value.equals(prop.getProperty("SBTransactionId"))) {
								
								Common.	print(Actual_Value,prop.getProperty("SBTransactionId"));
								
							}else if(Actual_Value.equals(prop.getProperty("SBVoucherNumber"))) {
							
								Common.	print(Actual_Value,prop.getProperty("SBVoucherNumber"));
								
							}else if(Actual_Value.equals(prop.getProperty("SBTransType"))) {
								
								Common.	print(Actual_Value,prop.getProperty("SBTransType"));
							
							}else if(Actual_Value.equals(prop.getProperty("SBTransAmount"))) {
								
								Common.	print(Actual_Value,prop.getProperty("SBTransAmount"));
								
							}else if(Actual_Value.equals(prop.getProperty("SBAmountType"))) {
								
							Common.	print(Actual_Value,prop.getProperty("SBAmountType"));
								
							}else if(Actual_Value.equals(prop.getProperty("SBGLAcCode"))) {
								
								Common.print(Actual_Value,prop.getProperty("SBGLAcCode"));
								
							}else if(Actual_Value.equals(prop.getProperty("SBTransactionMode"))) {
								
								Common.print(Actual_Value,prop.getProperty("SBTransactionMode"));
								
							}else if (Actual_Value.equals(prop.getProperty("SBOrgID"))) {
								
								Common.	print(Actual_Value,prop.getProperty("SBOrgID"));
								
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
	
	public static WebDriver Verify_GL_Batch_Summary(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
		 WebElement element=null;
		 String Actual_Value=null;
		
		switch(locatorType.toLowerCase()){
		
		case "id":
			
		break;
			
			
		case "xpath":
			
			//System.out.println("Inside verify summary method");
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable

					
				if (element.isDisplayed() == true) {
						
						if(element.isEnabled()==true) {	
							
						Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
						
						}else {
							
							
						Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
							
						}
						
						//System.out.println("Actual value is "+Actual_Value);

						
						Properties prop=new Properties();
						
						InputStream input = new FileInputStream("./DataFiles/GL_BATCH_Details.properties");
						prop.load(input);
						
						/*String TransDateFromFile=prop.getProperty("SB_TransactionDate");
						SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
						Date newTransdate=sdfrmt.parse(TransDateFromFile);
						sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
						String TRANSDATE=sdfrmt.format(newTransdate);
						
						
						String ValueDateFromFile=prop.getProperty("SB_ValueDate");
						SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
						Date newValdate=sdfrmt1.parse(ValueDateFromFile);
						sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
						String VALUEDATE=sdfrmt1.format(newValdate);*/
						
						
						if(Actual_Value.equals(prop.getProperty("GLproductName"))) {
		
							Common.	print(Actual_Value,prop.getProperty("GLproductName"));
							
						}else if(Actual_Value.equals(prop.getProperty("GLAccountNumber"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLAccountNumber"));
							
						}else if(Actual_Value.equals(prop.getProperty("GLAccountDisplayName"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLAccountDisplayName"));
							
						}else if(Actual_Value.equals(prop.getProperty("GLBatchId"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLBatchId"));
							
						}else if(Actual_Value.equals(prop.getProperty("GLTransId"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLTransId"));
							
						}else if(Actual_Value.equals(prop.getProperty("GLVoucherId"))) {
						
							Common.	print(Actual_Value,prop.getProperty("GLVoucherId"));
							
						}else if(Actual_Value.equals(prop.getProperty("ChargeVoucherNumber"))) {
							
							Common.	print(Actual_Value,prop.getProperty("ChargeVoucherNumber"));	
							
							
						}else if(Actual_Value.equals(prop.getProperty("GLTransactionType"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLTransactionType"));
							
						}else if(Actual_Value.equals(prop.getProperty("ChargeTransType"))) {
							
							Common.	print(Actual_Value,prop.getProperty("ChargeTransType"));	
							
						}else if(Actual_Value.equals(prop.getProperty("GLAmount"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLAmount"));
							
						}else if(Actual_Value.equals(prop.getProperty("ChargeTransAmount"))) {
							
							Common.	print(Actual_Value,prop.getProperty("ChargeTransAmount"));	
							
						}else if(Actual_Value.equals(prop.getProperty("GLAmountType"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLAmountType"));
							
						}else if(Actual_Value.equals(prop.getProperty("ChargeAmountType"))) {
							
							Common.	print(Actual_Value,prop.getProperty("ChargeAmountType"));	
							
							
						}else if(Actual_Value.equals(prop.getProperty("GLGLAccCode"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLGLAccCode"));
							
						}else if(Actual_Value.equals(prop.getProperty("ChargeGLAcCode"))) {
							
							Common.	print(Actual_Value,prop.getProperty("ChargeGLAcCode"));	
							
							
						}else if(Actual_Value.equals(prop.getProperty("GLTransferMode"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLTransferMode"));
							
						}else if (Actual_Value.equals(prop.getProperty("GLOrgID"))) {
							
							Common.	print(Actual_Value,prop.getProperty("GLOrgID"));
							
						
							
								
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

	
