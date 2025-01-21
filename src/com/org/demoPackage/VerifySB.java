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

public class VerifySB {
	
	public static void print(String ActualValue, String DbValue) {
	    
		System.out.println("Actual value and DB value is :"+ ActualValue+"  "+ DbValue);
		
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "Value From Database: " + DbValue + "<br>" + "Actual Value: " + ActualValue; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}


	public static WebDriver Verify_SBOpening_CashMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
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
						
						//System.out.println("Actual value is "+Actual_Value);

						
						Properties prop=new Properties();
						
						InputStream input = new FileInputStream("./DataFiles/SBOpeningDetails_CASH.properties");
						prop.load(input);
						
						String TransDateFromFile=prop.getProperty("SB_TransactionDate");
						SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
						Date newTransdate=sdfrmt.parse(TransDateFromFile);
						sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
						String TRANSDATE=sdfrmt.format(newTransdate);
						
						
						String ValueDateFromFile=prop.getProperty("SB_ValueDate");
						SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
						Date newValdate=sdfrmt1.parse(ValueDateFromFile);
						sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
						String VALUEDATE=sdfrmt1.format(newValdate);
						
						
						if(Actual_Value.equals(prop.getProperty("SB_ProductName"))) {
		
								print(Actual_Value,prop.getProperty("SB_ProductName"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("SB_AccountNumber"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_AccountDispalyName"))) {
							
							print(Actual_Value,prop.getProperty("SB_AccountDispalyName"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("SB_BatchId"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_TransactionId"))) {
							
							print(Actual_Value,prop.getProperty("SB_TransactionId"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_VoucherNumber"))) {
						
							print(Actual_Value,prop.getProperty("SB_VoucherNumber"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_TransType"))) {
							
							print(Actual_Value,prop.getProperty("SB_TransType"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_TransAmount"))) {
							
							print(Actual_Value,prop.getProperty("SB_TransAmount"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("SB_AmountType"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_GLAcCode"))) {
							
							print(Actual_Value,prop.getProperty("SB_GLAcCode"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_TransactionMode"))) {
							
							print(Actual_Value,prop.getProperty("SB_TransactionMode"));
							
						}else if (Actual_Value.equals(prop.getProperty("SB_OrgID"))) {
							
							print(Actual_Value,prop.getProperty("SB_OrgID"));
							
						}else if(Actual_Value.substring(0, 10).equals(TRANSDATE)){
							
							print(Actual_Value.substring(0, 10),TRANSDATE);	
						
						}else if(Actual_Value.substring(0, 10).equals(VALUEDATE)) {
							
							print(Actual_Value.substring(0, 10),VALUEDATE);	
							
								
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
	public static WebDriver Verify_SBopening_TransferMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
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
						
						//System.out.println("Actual value is "+Actual_Value);

						
						Properties prop=new Properties();
						
						InputStream input = new FileInputStream("./DataFiles/SBOpeningDetails_TRANSFER.properties");
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
						
						
						if(Actual_Value.equals(prop.getProperty("SB_productName"))) {
							
							print(Actual_Value,prop.getProperty("SB_productName"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("SB_AccountNumber"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_AccountDisplayName"))) {
							
							print(Actual_Value,prop.getProperty("SB_AccountDisplayName"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("SB_BatchId"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_TransId"))) {
							
							print(Actual_Value,prop.getProperty("SB_TransId"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_VoucherId"))) {
						
							print(Actual_Value,prop.getProperty("SB_VoucherId"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_TransactionType"))) {
							
							print(Actual_Value,prop.getProperty("SB_TransactionType"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_Amount"))) {
							
							print(Actual_Value,prop.getProperty("SB_Amount"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("SB_AmountType"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_GLAccCode"))) {
							
							print(Actual_Value,prop.getProperty("SB_GLAccCode"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_TransferMode"))) {
							
							print(Actual_Value,prop.getProperty("SB_TransferMode"));
							
						}else if (Actual_Value.equals(prop.getProperty("SB_OrgID"))) {
							
							print(Actual_Value,prop.getProperty("SB_OrgID"));
						
							
						}else if (Actual_Value.equals(prop.getProperty("DD_ProductName"))) {
							
							print(Actual_Value,prop.getProperty("DD_ProductName"));	
							
						}else if (Actual_Value.equals(prop.getProperty("DD_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("DD_AccountNumber"));		
								
						}else if (Actual_Value.equals(prop.getProperty("DD_AccountDispalyName"))) {
							
							print(Actual_Value,prop.getProperty("DD_AccountDispalyName"));		
							
						}else if (Actual_Value.equals(prop.getProperty("DD_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("DD_BatchId"));	
							
						}else if (Actual_Value.equals(prop.getProperty("DD_TransactionId"))) {
							
							print(Actual_Value,prop.getProperty("DD_TransactionId"));
							
						}else if (Actual_Value.equals(prop.getProperty("DD_VoucherNumber"))) {
							
							print(Actual_Value,prop.getProperty("DD_VoucherNumber"));
							
						}else if (Actual_Value.equals(prop.getProperty("DD_TransType"))) {
							
							print(Actual_Value,prop.getProperty("DD_TransType"));
							
						}else if (Actual_Value.equals(prop.getProperty("DD_TransAmount"))) {
							
							print(Actual_Value,prop.getProperty("DD_TransAmount"));	
							
						}else if (Actual_Value.equals(prop.getProperty("DD_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("DD_AmountType"));
							
						}else if (Actual_Value.equals(prop.getProperty("DD_GLAcCode"))) {
							
							print(Actual_Value,prop.getProperty("DD_GLAcCode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("DD_TransactionMode"))) {
							
							print(Actual_Value,prop.getProperty("DD_TransactionMode"));	
							
						}else if (Actual_Value.equals(prop.getProperty("DD_OrgID"))) {
							
							print(Actual_Value,prop.getProperty("DD_OrgID"));
							
						
						}else if(Actual_Value.substring(0, 10).equals(TRANSDATE)){
							
							print(Actual_Value.substring(0, 10),TRANSDATE);	
						
						}else if(Actual_Value.substring(0, 10).equals(VALUEDATE)) {
							
							print(Actual_Value.substring(0, 10),VALUEDATE);	
							
								
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
public static WebDriver Verify_SBOpening_BatchMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
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
						
						InputStream input = new FileInputStream("./DataFiles/SBOpeningDetails_BATCH.properties");
						prop.load(input);
						
						String TransDateFromFile=prop.getProperty("SB_TransactionDate");
						SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
						Date newTransdate=sdfrmt.parse(TransDateFromFile);
						sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
						String TRANSDATE=sdfrmt.format(newTransdate);
						
						
						String ValueDateFromFile=prop.getProperty("SB_ValueDate");
						SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
						Date newValdate=sdfrmt1.parse(ValueDateFromFile);
						sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
						String VALUEDATE=sdfrmt1.format(newValdate);
						
						
						if(Actual_Value.equals(prop.getProperty("SB_ProductName"))) {
							
							//System.out.println("inside Product name validation  "+ Actual_Value+" "+prop.getProperty("InvestmentAccount_productName")) ;
							
								print(Actual_Value,prop.getProperty("SB_ProductName"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("SB_AccountNumber"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_AccountDispalyName"))) {
							
							print(Actual_Value,prop.getProperty("SB_AccountDispalyName"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("SB_BatchId"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_TransactionId"))) {
							
							print(Actual_Value,prop.getProperty("SB_TransactionId"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_VoucherNumber"))) {
						
							print(Actual_Value,prop.getProperty("SB_VoucherNumber"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_TransType"))) {
							
							print(Actual_Value,prop.getProperty("SB_TransType"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_TransAmount"))) {
							
							print(Actual_Value,prop.getProperty("SB_TransAmount"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("SB_AmountType"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_GLAcCode"))) {
							
							print(Actual_Value,prop.getProperty("SB_GLAcCode"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_TransactionMode"))) {
							
							print(Actual_Value,prop.getProperty("SB_TransactionMode"));
							
						}else if (Actual_Value.equals(prop.getProperty("SB_OrgID"))) {
							
							print(Actual_Value,prop.getProperty("SB_OrgID"));
						
						}else if(Actual_Value.substring(0, 10).equals(TRANSDATE)){
							
							print(Actual_Value.substring(0, 10),TRANSDATE);	
						
						}else if(Actual_Value.substring(0, 10).equals(VALUEDATE)) {
							
							print(Actual_Value.substring(0, 10),VALUEDATE);	
							
								
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
public static WebDriver Verify_CAOpening_CashMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
	
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
					
					InputStream input = new FileInputStream("./DataFiles/CAOpeningDetails_CASH.properties");
					prop.load(input);
					
					String TransDateFromFile=prop.getProperty("CA_TransactionDate");
					SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
					Date newTransdate=sdfrmt.parse(TransDateFromFile);
					sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
					String TRANSDATE=sdfrmt.format(newTransdate);
					
					
					String ValueDateFromFile=prop.getProperty("CA_ValueDate");
					SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
					Date newValdate=sdfrmt1.parse(ValueDateFromFile);
					sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
					String VALUEDATE=sdfrmt1.format(newValdate);
					
					
					if(Actual_Value.equals(prop.getProperty("CA_ProductName"))) {
						
						//System.out.println("inside Product name validation  "+ Actual_Value+" "+prop.getProperty("InvestmentAccount_productName")) ;
						
							print(Actual_Value,prop.getProperty("CA_ProductName"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_AccountNumber"))) {
						
						print(Actual_Value,prop.getProperty("CA_AccountNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_AccountDispalyName"))) {
						
						print(Actual_Value,prop.getProperty("CA_AccountDispalyName"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_BatchId"))) {
						
						print(Actual_Value,prop.getProperty("CA_BatchId"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_TransactionId"))) {
						
						print(Actual_Value,prop.getProperty("CA_TransactionId"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_VoucherNumber"))) {
					
						print(Actual_Value,prop.getProperty("CA_VoucherNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_TransType"))) {
						
						print(Actual_Value,prop.getProperty("CA_TransType"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_TransAmount"))) {
						
						print(Actual_Value,prop.getProperty("CA_TransAmount"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_AmountType"))) {
						
						print(Actual_Value,prop.getProperty("CA_AmountType"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_GLAcCode"))) {
						
						print(Actual_Value,prop.getProperty("CA_GLAcCode"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_TransactionMode"))) {
						
						print(Actual_Value,prop.getProperty("CA_TransactionMode"));
						
					}else if (Actual_Value.equals(prop.getProperty("CA_OrgID"))) {
						
						print(Actual_Value,prop.getProperty("CA_OrgID"));

					}else if(Actual_Value.substring(0, 10).equals(TRANSDATE)){
						
						print(Actual_Value.substring(0, 10),TRANSDATE);	
					
					}else if(Actual_Value.substring(0, 10).equals(VALUEDATE)) {
						
						print(Actual_Value.substring(0, 10),VALUEDATE);	
						
							
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
public static WebDriver Verify_CAOpening_TransferMode(WebDriver driver, String locatorType, String propertyValue, String testData) {
	
	 WebElement element=null;
	 String Actual_Value=null;
	
	switch(locatorType.toLowerCase()){
	
	case "id":
		
	break;
		
		
	case "xpath":
		
		//System.out.println("Inside verify text method");
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
					
					InputStream input = new FileInputStream("./DataFiles/CAOpeningDetails_TRANSFER.properties");
					prop.load(input);
					
					/*String TransDateFromFile=prop.getProperty("CA_TransactionDate");
					SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
					Date newTransdate=sdfrmt.parse(TransDateFromFile);
					sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
					String TRANSDATE=sdfrmt.format(newTransdate);
					
					
					
					String ValueDateFromFile=prop.getProperty("CA_ValueDate");
					SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
					Date newValdate=sdfrmt1.parse(ValueDateFromFile);
					sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
					String VALUEDATE=sdfrmt1.format(newValdate);*/
					
					
					if(Actual_Value.equals(prop.getProperty("CA_productName"))) {
						
						//System.out.println("inside Product name validation  "+ Actual_Value+" "+prop.getProperty("InvestmentAccount_productName")) ;
						
							print(Actual_Value,prop.getProperty("CA_productName"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_AccountNumber"))) {
						
						print(Actual_Value,prop.getProperty("CA_AccountNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_AccountDisplayName"))) {
						
						print(Actual_Value,prop.getProperty("CA_AccountDisplayName"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_BatchId"))) {
						
						print(Actual_Value,prop.getProperty("CA_BatchId"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_TransId"))) {
						
						print(Actual_Value,prop.getProperty("CA_TransId"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_VoucherId"))) {
					
						print(Actual_Value,prop.getProperty("CA_VoucherId"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_TransactionType"))) {
						
						print(Actual_Value,prop.getProperty("CA_TransactionType"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_Amount"))) {
						
						print(Actual_Value,prop.getProperty("CA_Amount"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_AmountType"))) {
						
						print(Actual_Value,prop.getProperty("CA_AmountType"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_GLAccCode"))) {
						
						print(Actual_Value,prop.getProperty("CA_GLAccCode"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_TransferMode"))) {
						
						print(Actual_Value,prop.getProperty("CA_TransferMode"));
						
					}else if (Actual_Value.equals(prop.getProperty("CA_OrgID"))) {
						
						print(Actual_Value,prop.getProperty("CA_OrgID"));
					
					}
						else if(Actual_Value.equals(prop.getProperty("SB_productName"))) {
							
							//System.out.println("inside Product name validation  "+ Actual_Value+" "+prop.getProperty("InvestmentAccount_productName")) ;
							
								print(Actual_Value,prop.getProperty("SB_productName"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_AccountNumber"))) {
							
							print(Actual_Value,prop.getProperty("SB_AccountNumber"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_AccountDispalyName"))) {
							
							print(Actual_Value,prop.getProperty("SB_AccountDispalyName"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_BatchId"))) {
							
							print(Actual_Value,prop.getProperty("SB_BatchId"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_TransId"))) {
							
							print(Actual_Value,prop.getProperty("SB_TransId"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_VoucherNumber"))) {
						
							print(Actual_Value,prop.getProperty("SB_VoucherNumber"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_TransType"))) {
							
							print(Actual_Value,prop.getProperty("SB_TransType"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_Amount"))) {
							
							print(Actual_Value,prop.getProperty("SB_Amount"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_AmountType"))) {
							
							print(Actual_Value,prop.getProperty("SB_AmountType"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_GLAcCode"))) {
							
							print(Actual_Value,prop.getProperty("SB_GLAcCode"));
							
						}else if(Actual_Value.equals(prop.getProperty("SB_TransactionMode"))) {
							
							print(Actual_Value,prop.getProperty("SB_TransactionMode"));
							
						}else if (Actual_Value.equals(prop.getProperty("SB_OrgID"))) {
							
							print(Actual_Value,prop.getProperty("SB_OrgID"));
					
						/*}else if(Actual_Value.substring(0, 10).equals(TRANSDATE)){
						
						print(Actual_Value.substring(0, 10),TRANSDATE);	
					
					}else if(Actual_Value.substring(0, 10).equals(VALUEDATE)) {
						
						print(Actual_Value.substring(0, 10),VALUEDATE);	
						
					*/		
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
public static WebDriver Verify_CAOpening_BatchMode(WebDriver driver, String locatorType, String propertyValue, String testData) {

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
					
					InputStream input = new FileInputStream("./DataFiles/CAOpeningDetails_BATCH.properties");
					prop.load(input);
					
					String TransDateFromFile=prop.getProperty("CA_TransactionDate");
					System.out.println(TransDateFromFile);
					SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
					Date newTransdate=sdfrmt.parse(TransDateFromFile);
					
					sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
					String TRANSDATE=sdfrmt.format(newTransdate);
					
					
					String ValueDateFromFile=prop.getProperty("CA_ValueDate");
					SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
					Date newValdate=sdfrmt1.parse(ValueDateFromFile);
					sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
					String VALUEDATE=sdfrmt1.format(newValdate);
					
					
					if(Actual_Value.equals(prop.getProperty("CA_productName"))) {
						
							print(Actual_Value,prop.getProperty("CA_productName"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_AccountNumber"))) {
						
						print(Actual_Value,prop.getProperty("CA_AccountNumber"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_AccountDisplayName"))) {
						
						print(Actual_Value,prop.getProperty("CA_AccountDisplayName"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_BatchId"))) {
						
						print(Actual_Value,prop.getProperty("CA_BatchId"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_TransId"))) {
						
						print(Actual_Value,prop.getProperty("CA_TransId"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_VoucherId"))) {
					
						print(Actual_Value,prop.getProperty("CA_VoucherId"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_TransactionType"))) {
						
						print(Actual_Value,prop.getProperty("CA_TransactionType"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_Amount"))) {
						
						print(Actual_Value,prop.getProperty("CA_Amount"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_AmountType"))) {
						
						print(Actual_Value,prop.getProperty("CA_AmountType"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_GLAccCode"))) {
						
						print(Actual_Value,prop.getProperty("CA_GLAccCode"));
						
					}else if(Actual_Value.equals(prop.getProperty("CA_TransferMode"))) {
						
						print(Actual_Value,prop.getProperty("CA_TransferMode"));
						
					}else if (Actual_Value.equals(prop.getProperty("CA_OrgID"))) {
						
						print(Actual_Value,prop.getProperty("CA_OrgID"));

					}else if(Actual_Value.substring(0, 10).equals(TRANSDATE)){
						
						print(Actual_Value.substring(0, 10),TRANSDATE);	
					
					}else if(Actual_Value.substring(0, 10).equals(VALUEDATE)) {
						
						print(Actual_Value.substring(0, 10),VALUEDATE);	
						
							
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
