package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifySuspenseSummary {

	
	private static WebElement element;

	public static void Verify_SL_CASH_Summary(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
		
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

						
						Properties prop1=new Properties();
						
						InputStream input = new FileInputStream("./DataFiles/SL_CASH_Details.properties");
						prop1.load(input);
						
						
						
						
						if(Actual_Value.equals(prop1.getProperty("SLproductName"))) {
		
								Common.print(Actual_Value,prop1.getProperty("SLproductName"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLAccountNumber"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLAccountNumber"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLAccountDisplayName"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLAccountDisplayName"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLBatchId"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLBatchId"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLTransId"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLTransId"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLVoucherId"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLVoucherId"));
							
						}else if (Actual_Value.equals(prop1.getProperty("SLTransactionType"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLTransactionType"));
							
						}else if (Actual_Value.equals(prop1.getProperty("SLAmount"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLAmount"));
						}else if (Actual_Value.equals(prop1.getProperty("SLAmountType"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLAmountType"));
						}else if (Actual_Value.equals(prop1.getProperty("SLGLAccCode"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLGLAccCode"));	
						}else if (Actual_Value.equals(prop1.getProperty("SLTransferMode"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLTransferMode"));		
						}else if (Actual_Value.equals(prop1.getProperty("SLOrgID"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLOrgID"));		
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
		
		
		
		
	
			
		
	}

	public static WebDriver Verify_SL_Autopost_Summary(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
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
						
						//System.out.println("Actual value is "+Actual_Value);

						
						Properties prop=new Properties();
						
						InputStream input = new FileInputStream("./DataFiles/SL_AUTOPOST_Details.properties");
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
						
						
							if(Actual_Value.equals(prop.getProperty("SLproductName"))) {
		
							Common.	print(Actual_Value,prop.getProperty("SLproductName"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLAccountNumber"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLAccountNumber"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLAccountDisplayName"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLAccountDisplayName"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLBatchId"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLBatchId"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLTransId"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLTransId"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLVoucherId"))) {
						
							Common.	print(Actual_Value,prop.getProperty("SLVoucherId"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLTransactionType"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLTransactionType"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLAmount"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLAmount"));
								
							}else if(Actual_Value.equals(prop.getProperty("SLAmountType"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLAmountType"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLGLAccCode"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLGLAccCode"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLTransferMode"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLTransferMode"));	
							
							}else if(Actual_Value.equals(prop.getProperty("SLOrgID"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLOrgID"));		
							
							
							}else if(Actual_Value.equals(prop.getProperty("SBProductName"))) {
						
							Common.	print(Actual_Value,prop.getProperty("SBProductName"));
						
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
	
	public static void Verify_SL_BATCH_Summary(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
		
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

						
						Properties prop1=new Properties();
						
						InputStream input = new FileInputStream("./DataFiles/SL_BATCH_Details.properties");
						prop1.load(input);
						
						
						
						
						if(Actual_Value.equals(prop1.getProperty("SLproductName"))) {
		
								Common.print(Actual_Value,prop1.getProperty("SLproductName"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLAccountNumber"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLAccountNumber"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLAccountDisplayName"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLAccountDisplayName"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLBatchId"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLBatchId"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLTransId"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLTransId"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLVoucherId"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLVoucherId"));
							
						}else if (Actual_Value.equals(prop1.getProperty("SLTransactionType"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLTransactionType"));
							
						}else if (Actual_Value.equals(prop1.getProperty("SLAmount"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLAmount"));
						}else if (Actual_Value.equals(prop1.getProperty("SLAmountType"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLAmountType"));
						}else if (Actual_Value.equals(prop1.getProperty("SLGLAccCode"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLGLAccCode"));	
						}else if (Actual_Value.equals(prop1.getProperty("SLTransferMode"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLTransferMode"));		
						}else if (Actual_Value.equals(prop1.getProperty("SLOrgID"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLOrgID"));		
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
		
		
		
		
	
			
		
	}
	
	public static void Verify_SA_CASH_Summary(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
		
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

						
						Properties prop1=new Properties();
						
						InputStream input = new FileInputStream("./DataFiles/SA_CASH_Details.properties");
						prop1.load(input);
						
						
						
						
						if(Actual_Value.equals(prop1.getProperty("SLproductName"))) {
		
								Common.print(Actual_Value,prop1.getProperty("SLproductName"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLAccountNumber"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLAccountNumber"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLAccountDisplayName"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLAccountDisplayName"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLBatchId"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLBatchId"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLTransId"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLTransId"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLVoucherId"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLVoucherId"));
							
						}else if (Actual_Value.equals(prop1.getProperty("SLTransactionType"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLTransactionType"));
							
						}else if (Actual_Value.equals(prop1.getProperty("SLAmount"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLAmount"));
						}else if (Actual_Value.equals(prop1.getProperty("SLAmountType"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLAmountType"));
						}else if (Actual_Value.equals(prop1.getProperty("SLGLAccCode"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLGLAccCode"));	
						}else if (Actual_Value.equals(prop1.getProperty("SLTransferMode"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLTransferMode"));		
						}else if (Actual_Value.equals(prop1.getProperty("SLOrgID"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLOrgID"));		
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
		
		
		
		
	
			
		
	}

	public static void Verify_SA_BATCH_Summary(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
		
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

						
						Properties prop1=new Properties();
						
						InputStream input = new FileInputStream("./DataFiles/SA_BATCH_Details.properties");
						prop1.load(input);
						
						
						
						
						if(Actual_Value.equals(prop1.getProperty("SLproductName"))) {
		
								Common.print(Actual_Value,prop1.getProperty("SLproductName"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLAccountNumber"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLAccountNumber"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLAccountDisplayName"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLAccountDisplayName"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLBatchId"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLBatchId"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLTransId"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLTransId"));
							
						}else if(Actual_Value.equals(prop1.getProperty("SLVoucherId"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLVoucherId"));
							
						}else if (Actual_Value.equals(prop1.getProperty("SLTransactionType"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLTransactionType"));
							
						}else if (Actual_Value.equals(prop1.getProperty("SLAmount"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLAmount"));
						}else if (Actual_Value.equals(prop1.getProperty("SLAmountType"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLAmountType"));
						}else if (Actual_Value.equals(prop1.getProperty("SLGLAccCode"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLGLAccCode"));	
						}else if (Actual_Value.equals(prop1.getProperty("SLTransferMode"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLTransferMode"));		
						}else if (Actual_Value.equals(prop1.getProperty("SLOrgID"))) {
							
							Common.print(Actual_Value,prop1.getProperty("SLOrgID"));		
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
		
		
		
		
	
			
		
	}	
	
	public static WebDriver Verify_SA_Autopost_Summary(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
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
						
						//System.out.println("Actual value is "+Actual_Value);

						
						Properties prop=new Properties();
						
						InputStream input = new FileInputStream("./DataFiles/SA_AUTOPOST_Details.properties");
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
						
						
							if(Actual_Value.equals(prop.getProperty("SLproductName"))) {
		
							Common.	print(Actual_Value,prop.getProperty("SLproductName"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLAccountNumber"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLAccountNumber"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLAccountDisplayName"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLAccountDisplayName"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLBatchId"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLBatchId"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLTransId"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLTransId"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLVoucherId"))) {
						
							Common.	print(Actual_Value,prop.getProperty("SLVoucherId"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLTransactionType"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLTransactionType"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLAmount"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLAmount"));
								
							}else if(Actual_Value.equals(prop.getProperty("SLAmountType"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLAmountType"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLGLAccCode"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLGLAccCode"));
							
							}else if(Actual_Value.equals(prop.getProperty("SLTransferMode"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLTransferMode"));	
							
							}else if(Actual_Value.equals(prop.getProperty("SLOrgID"))) {
							
							Common.	print(Actual_Value,prop.getProperty("SLOrgID"));		
							
							
							}else if(Actual_Value.equals(prop.getProperty("SBProductName"))) {
						
							Common.	print(Actual_Value,prop.getProperty("SBProductName"));
						
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



}