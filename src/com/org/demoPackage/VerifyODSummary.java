package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyODSummary {
	
	private static WebElement element;
    public static int NoOfRows;
	
	public static void Verify_OD_CASH_Summary(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
		System.out.println("VERIFY OD SUMMARY");
		String Actual_Value=null;
		
		switch(locatorType.toLowerCase()){
		
		case "id":
			
		break;
			
			
		case "xpath":
			
			
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					if (element.isDisplayed() == true) {
						
						if(element.isEnabled()==true) {	
							
						Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
						
						}else {
							
							
						Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
							
						}
						
						System.out.println("Actual value is "+Actual_Value);

					    Properties prop1=new Properties();
						
						InputStream input = new FileInputStream("./DataFiles/OD_CASH_Details.properties");
						prop1.load(input);
						
						
						
						
						if(Actual_Value.equals(prop1.getProperty("ProductName1"))) {
		
						Common.print(Actual_Value,prop1.getProperty("ProductName1"));
							
						}else if(Actual_Value.equals(prop1.getProperty("AccountNumber1"))) {
							
						Common.print(Actual_Value,prop1.getProperty("AccountNumber1"));
							
						}else if(Actual_Value.equals(prop1.getProperty("ProductName2"))) {
							
						Common.print(Actual_Value,prop1.getProperty("ProductName2"));
								
						}else if(Actual_Value.equals(prop1.getProperty("AccountNumber2"))) {
								
						Common.print(Actual_Value,prop1.getProperty("AccountNumber2"));
								
						}else if(Actual_Value.equals(prop1.getProperty("DisplayName"))) {
							
						Common.print(Actual_Value,prop1.getProperty("DisplayName"));
							
						}else if(Actual_Value.equals(prop1.getProperty("BatchId"))) {
							
						Common.print(Actual_Value,prop1.getProperty("BatchId"));
							
						}else if(Actual_Value.equals(prop1.getProperty("TransId"))) {
							
						Common.print(Actual_Value,prop1.getProperty("TransId"));
							
						}else if(Actual_Value.equals(prop1.getProperty("TransferMode"))) {
							
						Common.print(Actual_Value,prop1.getProperty("TransferMode"));
							
						}else if (Actual_Value.equals(prop1.getProperty("OrgId"))) {
							
						Common.print(Actual_Value,prop1.getProperty("OrgId"));
							
								
						}else {
							Driver.tcFlag = "PASS";
							Driver.comment = Driver.objectName + " and its Database value are (test)  not matching";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
						}
					
					}
					
				}catch(Exception e){
					Driver.tcFlag = "PASS";
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

	
 public static void Verify_OD_VoucherNumbers(WebDriver driver) throws IOException {
		
		 System.out.println("VERIFY VOUCHER NUMBERS");
		 WebElement table = driver.findElement(By.id("tblCustList"));
         List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	     NoOfRows=listOfRows.size()-1;
	     System.out.println("Rows: "+NoOfRows);

		 Properties prop2=new Properties();
		 InputStream input2 = new FileInputStream("./DataFiles/OD_CASH_Details.properties");
		 prop2.load(input2);
		 	
		
	     for( int i=1,j=2;j<= NoOfRows+1 && i<=NoOfRows ;j++,i++) {
			
	   	      System.out.println(prop2.getProperty("VoucherNumber"+i)+" ="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText() );
				
			  if(prop2.getProperty("VoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
					
					System.out.println("Equal ");
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass" + " # " + "Value From Database: " +prop2.getProperty("VoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+" record"+i,  Driver.comment);
					
				
			  }
				
				else {
				    Driver.tcFlag = "FAIL";
				    Driver.comment = "Fail" + " # " + "Value From Database:" + prop2.getProperty("VoucherNumber"+i) + " Months<br>" + "Actual Next Shadow Balance from UI: " +driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText() +" Months";  
				    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				    
				    
				   }
		}
			
	}

 public static void Verify_OD_TransTypes(WebDriver driver) throws IOException {
		
		System.out.println("VERIFY TRANSACTION TYPES");
        Properties prop=new Properties();
		InputStream input = new FileInputStream("./DataFiles/OD_CASH_Details.properties");
		prop.load(input);
		WebElement table = driver.findElement(By.id("tblCustList"));
        List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		NoOfRows=listOfRows.size()-1;
		System.out.println("Rows: "+NoOfRows);
		 
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
			   
			 System.out.println("TranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

		          if(prop.getProperty("TranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
		     
		             System.out.println("Equal");
		             Driver.tcFlag = "PASS";
		             Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("TranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
		             Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		          }
	 }
				
}		
		
 public static void Verify_OD_Amounts(WebDriver driver) throws IOException {
				
			System.out.println("VERIFY AMOUNT");
			WebElement table = driver.findElement(By.id("tblCustList"));
            List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
			NoOfRows=listOfRows.size()-1;
			System.out.println("Rows: "+NoOfRows);
			Properties prop=new Properties();
			InputStream input = new FileInputStream("./DataFiles/OD_CASH_Details.properties");
			prop.load(input);
			  
			   
		      for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
			     
			   	   System.out.println("TransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

			           if(prop.getProperty("TransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
			      
			              System.out.println("Equal");
			              Driver.tcFlag = "PASS";
			              Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("TransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
			              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
			      
			     
			           }
			   }
 }
					
			
 public static void Verify_OD_AmountTypes(WebDriver driver) throws IOException {
			
	    System.out.println("VERIFY AMOUNT TYPES");
	    Properties prop=new Properties();
	    InputStream input = new FileInputStream("./DataFiles/OD_CASH_Details.properties");
	    prop.load(input);
	    WebElement table = driver.findElement(By.id("tblCustList"));
        List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	    NoOfRows=listOfRows.size()-1;
	    System.out.println("Rows: "+NoOfRows);

	    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	        System.out.println("AmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

	            if(prop.getProperty("AmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
	    
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("AmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	            }
	  }
			   
}
					
 public static void Verify_OD_GLAcCode(WebDriver driver) throws IOException {
			
			System.out.println("VERIFY GLAC NUMBERS");
			Properties prop=new Properties();
			InputStream input = new FileInputStream("./DataFiles/OD_CASH_Details.properties");
			prop.load(input);
			WebElement table = driver.findElement(By.id("tblCustList"));
            List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
			NoOfRows=listOfRows.size()-1;
			System.out.println("Rows: "+NoOfRows);

     for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
			   
			  System.out.println("GlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

			         if(prop.getProperty("GlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
			    
			            System.out.println("Equal");
			            Driver.tcFlag = "PASS";
			            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
			            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
			    
			          }
	  }
			   
				
}
					
			
  public static void Verify_OD_BATCH_Summary(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
		System.out.println("VERIFY OD SUMMARY");
		String Actual_Value=null;
		
		switch(locatorType.toLowerCase()){
		
		case "id":
			
		break;
			
			
		case "xpath":
			
			
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					if (element.isDisplayed() == true) {
						
						if(element.isEnabled()==true) {	
							
						Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
						
						}else {
							
							
						Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
							
						}
						
						System.out.println("Actual value is "+Actual_Value);

					    Properties prop1=new Properties();
						
						InputStream input = new FileInputStream("./DataFiles/OD_BATCH_Details.properties");
						prop1.load(input);
						
						
						
						
						if(Actual_Value.equals(prop1.getProperty("ProductName1"))) {
		
						Common.print(Actual_Value,prop1.getProperty("ProductName1"));
							
						}else if(Actual_Value.equals(prop1.getProperty("AccountNumber1"))) {
							
						Common.print(Actual_Value,prop1.getProperty("AccountNumber1"));
							
						}else if(Actual_Value.equals(prop1.getProperty("ProductName2"))) {
							
						Common.print(Actual_Value,prop1.getProperty("ProductName2"));
								
						}else if(Actual_Value.equals(prop1.getProperty("AccountNumber2"))) {
								
						Common.print(Actual_Value,prop1.getProperty("AccountNumber2"));
								
						}else if(Actual_Value.equals(prop1.getProperty("DisplayName"))) {
							
						Common.print(Actual_Value,prop1.getProperty("DisplayName"));
							
						}else if(Actual_Value.equals(prop1.getProperty("BatchId"))) {
							
						Common.print(Actual_Value,prop1.getProperty("BatchId"));
							
						}else if(Actual_Value.equals(prop1.getProperty("TransId"))) {
							
						Common.print(Actual_Value,prop1.getProperty("TransId"));
							
						}else if(Actual_Value.equals(prop1.getProperty("TransferMode"))) {
							
						Common.print(Actual_Value,prop1.getProperty("TransferMode"));
							
						}else if (Actual_Value.equals(prop1.getProperty("OrgId"))) {
							
						Common.print(Actual_Value,prop1.getProperty("OrgId"));
							
								
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
		
		
		
		
	
			
		
	}	
  
  public static void Verify_OD_VoucherNos(WebDriver driver) throws IOException {
		
		 System.out.println("VERIFY VOUCHER NUMBERS");
		 WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	     NoOfRows=listOfRows.size()-1;
	     System.out.println("Rows: "+NoOfRows);

		 Properties prop2=new Properties();
		 InputStream input2 = new FileInputStream("./DataFiles/OD_BATCH_Details.properties");
		 prop2.load(input2);
		 	
		
	     for( int i=1,j=2;j<= NoOfRows+1 && i<=NoOfRows ;j++,i++) {
			
	   	      System.out.println(prop2.getProperty("VoucherNumber"+i)+" ="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText() );
				
			  if(prop2.getProperty("VoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
					
					System.out.println("Equal ");
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass" + " # " + "Value From Database: " +prop2.getProperty("VoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+" record"+i,  Driver.comment);
					
				
			  }
				
				else {
				    Driver.tcFlag = "FAIL";
				    Driver.comment = "Fail" + " # " + "Value From Database:" + prop2.getProperty("VoucherNumber"+i) + " Months<br>" + "Actual Next Shadow Balance from UI: " +driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText() +" Months";  
				    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				    
				    
				   }
		}
			
	}

public static void Verify_OD_TransactionTypes(WebDriver driver) throws IOException {
		
		System.out.println("VERIFY TRANSACTION TYPES");
     Properties prop=new Properties();
		InputStream input = new FileInputStream("./DataFiles/OD_BATCH_Details.properties");
		prop.load(input);
		WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		NoOfRows=listOfRows.size()-1;
		System.out.println("Rows: "+NoOfRows);
		 
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
			   
			 System.out.println("TranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

		          if(prop.getProperty("TranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
		     
		             System.out.println("Equal");
		             Driver.tcFlag = "PASS";
		             Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("TranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
		             Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		          }
	 }
				
}		
		
 public static void Verify_OD_Amts(WebDriver driver) throws IOException {
				
			System.out.println("VERIFY AMOUNT");
			WebElement table = driver.findElement(By.id("tblCustList"));
         List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
			NoOfRows=listOfRows.size()-1;
			System.out.println("Rows: "+NoOfRows);
			Properties prop=new Properties();
			InputStream input = new FileInputStream("./DataFiles/OD_BATCH_Details.properties");
			prop.load(input);
			  
			   
		      for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
			     
			   	   System.out.println("TransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

			           if(prop.getProperty("TransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
			      
			              System.out.println("Equal");
			              Driver.tcFlag = "PASS";
			              Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("TransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
			              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
			      
			     
			           }
			   }
}
					
			
public static void Verify_OD_AmtTypes(WebDriver driver) throws IOException {
			
	    System.out.println("VERIFY AMOUNT TYPES");
	    Properties prop=new Properties();
	    InputStream input = new FileInputStream("./DataFiles/OD_BATCH_Details.properties");
	    prop.load(input);
	    WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	    NoOfRows=listOfRows.size()-1;
	    System.out.println("Rows: "+NoOfRows);

	    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	        System.out.println("AmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

	            if(prop.getProperty("AmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
	    
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("AmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	            }
	  }
			   
}
					
 public static void Verify_OD_GLcCodes(WebDriver driver) throws IOException {
			
			System.out.println("VERIFY GLAC NUMBERS");
			Properties prop=new Properties();
			InputStream input = new FileInputStream("./DataFiles/OD_BATCH_Details.properties");
			prop.load(input);
			WebElement table = driver.findElement(By.id("tblCustList"));
         List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
			NoOfRows=listOfRows.size()-1;
			System.out.println("Rows: "+NoOfRows);

  for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
			   
			  System.out.println("GlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

			         if(prop.getProperty("GlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
			    
			            System.out.println("Equal");
			            Driver.tcFlag = "PASS";
			            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
			            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
			    
			          }
	  }
			   
				
}
		
 public static void Verify_OD_AUTOPOST_Summary(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
		System.out.println("VERIFY OD SUMMARY");
		String Actual_Value=null;
		
		switch(locatorType.toLowerCase()){
		
		case "id":
			
		break;
			
			
		case "xpath":
			
			
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					if (element.isDisplayed() == true) {
						
						if(element.isEnabled()==true) {	
							
						Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
						
						}else {
							
							
						Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
							
						}
						
						System.out.println("Actual value is "+Actual_Value);

					    Properties prop1=new Properties();
						
						InputStream input = new FileInputStream("./DataFiles/OD_AUTOPOST_Details.properties");
						prop1.load(input);
						
						
						
						
						if(Actual_Value.equals(prop1.getProperty("ProductName1"))) {
		
						Common.print(Actual_Value,prop1.getProperty("ProductName1"));
							
						}else if(Actual_Value.equals(prop1.getProperty("AccountNumber1"))) {
							
						Common.print(Actual_Value,prop1.getProperty("AccountNumber1"));
							
						}else if(Actual_Value.equals(prop1.getProperty("AccDisplayName1"))) {
							
						Common.print(Actual_Value,prop1.getProperty("AccDisplayName1"));
							
						}else if(Actual_Value.equals(prop1.getProperty("ProductName2"))) {
							
						Common.print(Actual_Value,prop1.getProperty("ProductName2"));
								
						}else if(Actual_Value.equals(prop1.getProperty("AccountNumber2"))) {
								
						Common.print(Actual_Value,prop1.getProperty("AccountNumber2"));
								
						}else if(Actual_Value.equals(prop1.getProperty("AccDisplayName2"))) {
							
						Common.print(Actual_Value,prop1.getProperty("AccDisplayName2"));
							
						}else if(Actual_Value.equals(prop1.getProperty("ProductName3"))) {
							
						Common.print(Actual_Value,prop1.getProperty("ProductName3"));
								
						}else if(Actual_Value.equals(prop1.getProperty("AccountNumber3"))) {
								
						Common.print(Actual_Value,prop1.getProperty("AccountNumber3"));
								
						}else if(Actual_Value.equals(prop1.getProperty("AccDisplayName3"))) {
							
						Common.print(Actual_Value,prop1.getProperty("AccDisplayName3"));
							
						}else if(Actual_Value.equals(prop1.getProperty("BatchId"))) {
							
						Common.print(Actual_Value,prop1.getProperty("BatchId"));
							
						}else if(Actual_Value.equals(prop1.getProperty("TransId"))) {
							
						Common.print(Actual_Value,prop1.getProperty("TransId"));
							
						}else if(Actual_Value.equals(prop1.getProperty("TransferMode"))) {
							
						Common.print(Actual_Value,prop1.getProperty("TransferMode"));
							
						}else if (Actual_Value.equals(prop1.getProperty("OrgId"))) {
							
						Common.print(Actual_Value,prop1.getProperty("OrgId"));
							
								
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
		
		
		
		
	
			
		
	}	
 public static void VerifyODVoucherNos(WebDriver driver) throws IOException {
		
	 System.out.println("VERIFY VOUCHER NUMBERS");
	 WebElement table = driver.findElement(By.id("tblCustList"));
  List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
     NoOfRows=listOfRows.size()-1;
     System.out.println("Rows: "+NoOfRows);

	 Properties prop2=new Properties();
	 InputStream input2 = new FileInputStream("./DataFiles/OD_AUTOPOST_Details.properties");
	 prop2.load(input2);
	 	
	
     for( int i=1,j=2;j<= NoOfRows+1 && i<=NoOfRows ;j++,i++) {
		
   	      System.out.println(prop2.getProperty("VoucherNumber"+i)+" ="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText() );
			
		  if(prop2.getProperty("VoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
				
				System.out.println("Equal ");
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass" + " # " + "Value From Database: " +prop2.getProperty("VoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+" record"+i,  Driver.comment);
				
			
		  }
			
			else {
			    Driver.tcFlag = "FAIL";
			    Driver.comment = "Fail" + " # " + "Value From Database:" + prop2.getProperty("VoucherNumber"+i) + " Months<br>" + "Actual Next Shadow Balance from UI: " +driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText() +" Months";  
			    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			    
			    
			   }
	}
		
}

public static void VerifyODTransactionTypes(WebDriver driver) throws IOException {
	
	System.out.println("VERIFY TRANSACTION TYPES");
 Properties prop=new Properties();
	InputStream input = new FileInputStream("./DataFiles/OD_AUTOPOST_Details.properties");
	prop.load(input);
	WebElement table = driver.findElement(By.id("tblCustList"));
 List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	NoOfRows=listOfRows.size()-1;
	System.out.println("Rows: "+NoOfRows);
	 
for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		 System.out.println("TranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	          if(prop.getProperty("TranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	             System.out.println("Equal");
	             Driver.tcFlag = "PASS";
	             Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("TranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	             Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	          }
 }
			
}		
	
public static void VerifyODAmounts(WebDriver driver) throws IOException {
			
		System.out.println("VERIFY AMOUNT");
		WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		NoOfRows=listOfRows.size()-1;
		System.out.println("Rows: "+NoOfRows);
		Properties prop=new Properties();
		InputStream input = new FileInputStream("./DataFiles/OD_AUTOPOST_Details.properties");
		prop.load(input);
		  
		   
	      for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		     
		   	   System.out.println("TransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

		           if(prop.getProperty("TransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
		      
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("TransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		      
		     
		           }
		   }
}
				
		
public static void VerifyODAmtTypes(WebDriver driver) throws IOException {
		
    System.out.println("VERIFY AMOUNT TYPES");
    Properties prop=new Properties();
    InputStream input = new FileInputStream("./DataFiles/OD_AUTOPOST_Details.properties");
    prop.load(input);
    WebElement table = driver.findElement(By.id("tblCustList"));
 List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
    NoOfRows=listOfRows.size()-1;
    System.out.println("Rows: "+NoOfRows);

    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
   
        System.out.println("AmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

            if(prop.getProperty("AmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
    
               System.out.println("Equal");
               Driver.tcFlag = "PASS";
               Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("AmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
    
            }
  }
		   
}
				
public static void VerifyODGLcCodes(WebDriver driver) throws IOException {
		
		System.out.println("VERIFY GLAC NUMBERS");
		Properties prop=new Properties();
		InputStream input = new FileInputStream("./DataFiles/OD_AUTOPOST_Details.properties");
		prop.load(input);
		WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		NoOfRows=listOfRows.size()-1;
		System.out.println("Rows: "+NoOfRows);

for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		  System.out.println("GlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		         if(prop.getProperty("GlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		          }
  }
		   
			
}
}	
