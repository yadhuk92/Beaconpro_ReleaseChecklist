package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifySummary {
	
 private static WebElement element;
 public static int NoOfRows;
	
 public static WebDriver Verify_OLCr_Cash_Summary(WebDriver driver, String locatorType, String propertyValue, String testData) {
		
	WebElement element=null;
	String Actual_Value=null;
		
  switch(locatorType.toLowerCase()){
		
		case "id":
			
		break;
			
			
		case "xpath":
			
			    System.out.println("VERIFY OL CREDIT SUMMARY");
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
                 if (element.isDisplayed() == true) {
						
						if(element.isEnabled()==true) {	
							
						Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
						
						}else {
							
							
						Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
							
				  }
						
						
              Properties prop=new Properties();
			  InputStream input = new FileInputStream("./DataFiles/OLCREDIT_CASH.properties");
			  prop.load(input);
						
						
				if(Actual_Value.equals(prop.getProperty("OLproductName"))) {
		
				Common.	print(Actual_Value,prop.getProperty("OLproductName"));
							
				}else if(Actual_Value.equals(prop.getProperty("OLAccountNumber"))) {
							
				Common.	print(Actual_Value,prop.getProperty("OLAccountNumber"));
							
				}else if(Actual_Value.equals(prop.getProperty("OLAccountDisplayName"))) {
							
				Common.	print(Actual_Value,prop.getProperty("OLAccountDisplayName"));
							
				}else if(Actual_Value.equals(prop.getProperty("OLBatchId"))) {
							
				Common.	print(Actual_Value,prop.getProperty("OLBatchId"));
							
				}else if(Actual_Value.equals(prop.getProperty("OLTransId"))) {
							
				Common.	print(Actual_Value,prop.getProperty("OLTransId"));
							
				}else if(Actual_Value.equals(prop.getProperty("OLVoucherId"))) {
						
				Common.	print(Actual_Value,prop.getProperty("OLVoucherId"));
							
				}else if(Actual_Value.equals(prop.getProperty("OLTransactionType"))) {
							
				Common.	print(Actual_Value,prop.getProperty("OLTransactionType"));
							
				}else if(Actual_Value.equals(prop.getProperty("OLTransferMode"))) {
							
				Common.	print(Actual_Value,prop.getProperty("OLTransferMode"));
							
				}else if (Actual_Value.equals(prop.getProperty("OLOrgID"))) {
							
				Common.	print(Actual_Value,prop.getProperty("OLOrgID"));
							
						
							
								
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
 public static void Verify_OLCr_Amts(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/OLCREDIT_CASH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("OLAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("OLAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("OLAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
 }
 public static void Verify_OLCr_AmtTypes(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/OLCREDIT_CASH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("OLAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("OLAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("OLAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void Verify_OLCr_GLcCodes(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/OLCREDIT_CASH.properties");
		  prop.load(input);
		  
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("OLGLAccCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("OLGLAccCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("OLGLAccCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  
	 
 public static WebDriver Verify_OLCr_Batch_Summary(WebDriver driver, String locatorType, String propertyValue, String testData) {
	
	WebElement element=null;
	String Actual_Value=null;
		
  switch(locatorType.toLowerCase()){
		
		case "id":
			
		break;
			
			
		case "xpath":
			
			    System.out.println("VERIFY OL CREDIT SUMMARY");
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
                 if (element.isDisplayed() == true) {
						
						if(element.isEnabled()==true) {	
							
						Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
						
						}else {
							
							
						Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
							
				  }
						
						
              Properties prop=new Properties();
			  InputStream input = new FileInputStream("./DataFiles/OLCREDIT_BATCH.properties");
			  prop.load(input);
						
						
				if(Actual_Value.equals(prop.getProperty("OLproductName"))) {
		
				Common.	print(Actual_Value,prop.getProperty("OLproductName"));
							
				}else if(Actual_Value.equals(prop.getProperty("OLAccountNumber"))) {
							
				Common.	print(Actual_Value,prop.getProperty("OLAccountNumber"));
							
				}else if(Actual_Value.equals(prop.getProperty("OLAccountDisplayName"))) {
							
				Common.	print(Actual_Value,prop.getProperty("OLAccountDisplayName"));
							
				}else if(Actual_Value.equals(prop.getProperty("OLBatchId"))) {
							
				Common.	print(Actual_Value,prop.getProperty("OLBatchId"));
							
				}else if(Actual_Value.equals(prop.getProperty("OLTransId"))) {
							
				Common.	print(Actual_Value,prop.getProperty("OLTransId"));
							
				}else if(Actual_Value.equals(prop.getProperty("OLVoucherId"))) {
						
				Common.	print(Actual_Value,prop.getProperty("OLVoucherId"));
							
				}else if(Actual_Value.equals(prop.getProperty("OLTransactionType"))) {
							
				Common.	print(Actual_Value,prop.getProperty("OLTransactionType"));
							
				}else if(Actual_Value.equals(prop.getProperty("OLTransferMode"))) {
							
				Common.	print(Actual_Value,prop.getProperty("OLTransferMode"));
							
				}else if (Actual_Value.equals(prop.getProperty("OLOrgID"))) {
							
				Common.	print(Actual_Value,prop.getProperty("OLOrgID"));
							
						
							
								
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
 
 public static void Verify_OLCr_Amount(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/OLCREDIT_BATCH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("OLAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("OLAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("OLAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
 }
 public static void Verify_OLCr_AmountTypes(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/OLCREDIT_BATCH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("OLAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("OLAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("OLAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void Verify_OLCr_GLcCode(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/OLCREDIT_BATCH.properties");
		  prop.load(input);
		  
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("OLGLAccCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("OLGLAccCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("OLGLAccCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  

public static WebDriver Verify_OLCredit_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/OLCREDIT_AUTOPOST.properties");
	     prop.load(input);
	     
	     
	     
	     
	      if(Actual_Value.equals(prop.getProperty("OL_ProductName1"))) {
	      
	    	  Common.print(Actual_Value,prop.getProperty("OL_ProductName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OL_AccountNumber1"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("OL_AccountNumber1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OL_DisplayName1"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("OL_DisplayName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OL_ProductName2"))) {
		      
	    	 Common.print(Actual_Value,prop.getProperty("OL_ProductName2"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("OL_AccountNumber2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("OL_AccountNumber2"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("OL_DisplayName2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("OL_DisplayName2"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("OL_BatchId"))) {
	      
			  Common.print(Actual_Value,prop.getProperty("OL_BatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OL_TransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("OL_TransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OL_TransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("OL_TransferMode"));
	      
	     } else {
	      Driver.tcFlag = "PASS";
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

 public static void VerifyOLCrAutopostVrNo(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
    Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/OLCREDIT_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("OL_VoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("OL_VoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("OL_VoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyOLCrAutopostTrType(WebDriver driver) throws IOException {
	   
	  System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/OLCREDIT_AUTOPOST.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	          for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("OL_TranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("OL_TranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("OL_TranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}

public static void VerifyOLCrAutopostAmt(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/OLCREDIT_AUTOPOST.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("OL_TransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("OL_TransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("OL_TransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyOLCrAutopostAmtTypes(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
     Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/OLCREDIT_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("OL_AmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("OL_AmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("OL_AmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyOLCrAutopostGLCode(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/OLCREDIT_AUTOPOST.properties");
		  prop.load(input);
		  
		  WebElement table = driver.findElement(By.id("tblCustList"));
         List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("OL_GlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("OL_GlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("OL_GlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  


public static void VerifyOLCreditAutopostBrCode(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY BRANCHCODES");
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/OLCREDIT_AUTOPOST.properties");
	   prop.load(input);
	   
 for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	  System.out.println("OL_OrgId"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText());

	           if(prop.getProperty("OL_OrgId"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText())){
	      
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("OL_OrgId"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	      
	     
	            }
	  }
	    
}
	
public static WebDriver Verify_ODCredit_Cash(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY OD CREDIT SUMMARY");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/ODCREDIT_CASH.properties");
	     prop.load(input);
	     
	     if(Actual_Value.equals(prop.getProperty("ODproductName"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("ODproductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAccountNumber"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAccountDisplayName"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAccountDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODBatchId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODVoucherId"))) {
	     
	    	 Common.print(Actual_Value,prop.getProperty("ODVoucherId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransactionType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransactionType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAmount"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAmount"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAmountType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAmountType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODGLAccCode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODGLAccCode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransferMode"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("ODOrgID"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODOrgID"));
	     
	            
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

public static WebDriver Verify_ODCredit_Batch(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY OD CREDIT SUMMARY");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/ODCREDIT_BATCH.properties");
	     prop.load(input);
	     
	     if(Actual_Value.equals(prop.getProperty("ODproductName"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("ODproductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAccountNumber"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAccountDisplayName"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAccountDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODBatchId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODVoucherId"))) {
	     
	    	 Common.print(Actual_Value,prop.getProperty("ODVoucherId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransactionType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransactionType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAmount"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAmount"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAmountType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAmountType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODGLAccCode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODGLAccCode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransferMode"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("ODOrgID"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODOrgID"));
	     
	            
	     }
	      
	       
	     else {
	      Driver.tcFlag = "PASS";
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
public static WebDriver Verify_ODCredit_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/ODCREDIT_AUTOPOST.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("ODProductName1"))) {
	      
	    Common.print(Actual_Value,prop.getProperty("ODProductName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAccountNumber1"))) {
	      
	     Common.print(Actual_Value,prop.getProperty("ODAccountNumber1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODDisplayName1"))) {
	      
	     Common.print(Actual_Value,prop.getProperty("ODDisplayName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODProductName2"))) {
		      
	     Common.print(Actual_Value,prop.getProperty("ODProductName2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODAccountNumber2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("ODAccountNumber2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODDisplayName2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("ODDisplayName2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODBatchId"))) {
	      
			  Common.print(Actual_Value,prop.getProperty("ODBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransAmount"))) {
		      
		    	 Common.print(Actual_Value,prop.getProperty("ODTransAmount"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODTransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransferMode"));
	      
	     } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}

public static void VerifyODCrAutopostVrNo(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
  Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/ODCREDIT_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
  List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("ODVoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("ODVoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("ODVoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyODCrAutopostTrType(WebDriver driver) throws IOException {
	   
	  System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/ODCREDIT_AUTOPOST.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
   List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	          for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("ODTranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("ODTranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("ODTranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}


public static void VerifyODCrAutopostAmtTypes(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
   Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/ODCREDIT_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
   List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("ODAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("ODAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("ODAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyODCrAutopostGLCode(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/ODCREDIT_AUTOPOST.properties");
		  prop.load(input);
		  
		  WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("ODGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("ODGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("ODGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  


public static void VerifyODCreditAutopostBrCode(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY BRANCHCODES");
	   WebElement table = driver.findElement(By.id("tblCustList"));
   List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/ODCREDIT_AUTOPOST.properties");
	   prop.load(input);
	   
for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	  System.out.println("ODOrgId"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText());

	           if(prop.getProperty("ODOrgId"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText())){
	      
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("ODOrgId"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	      
	     
	            }
	  }
	    
}
public static WebDriver Verify_ODDebit_Cash(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY OD CREDIT SUMMARY");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/ODDEBIT_CASH.properties");
	     prop.load(input);
	     
	     if(Actual_Value.equals(prop.getProperty("ODproductName"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("ODproductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAccountNumber"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAccountDisplayName"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAccountDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODBatchId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODVoucherId"))) {
	     
	    	 Common.print(Actual_Value,prop.getProperty("ODVoucherId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransactionType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransactionType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAmount"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAmount"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAmountType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAmountType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODGLAccCode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODGLAccCode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransferMode"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("ODOrgID"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODOrgID"));
	     
	            
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
public static WebDriver Verify_ODDebit_Batch(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY OD CREDIT SUMMARY");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/ODDEBIT_BATCH.properties");
	     prop.load(input);
	     
	     if(Actual_Value.equals(prop.getProperty("ODproductName"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("ODproductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAccountNumber"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAccountDisplayName"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAccountDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODBatchId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODVoucherId"))) {
	     
	    	 Common.print(Actual_Value,prop.getProperty("ODVoucherId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransactionType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransactionType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAmount"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAmount"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAmountType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAmountType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODGLAccCode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODGLAccCode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransferMode"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("ODOrgID"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODOrgID"));
	     
	            
	     }
	      
	       
	     else {
	      Driver.tcFlag = "PASS";
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
public static WebDriver Verify_ODDebit_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/ODDEBIT_AUTOPOST.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("ODProductName1"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("ODProductName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAccountNumber1"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("ODAccountNumber1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODDisplayName1"))) {
	      
	          Common.print(Actual_Value,prop.getProperty("ODDisplayName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODProductName2"))) {
		      
	          Common.print(Actual_Value,prop.getProperty("ODProductName2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODAccountNumber2"))) {
		      
	          Common.print(Actual_Value,prop.getProperty("ODAccountNumber2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODDisplayName2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("ODDisplayName2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODBatchId"))) {
	      
			  Common.print(Actual_Value,prop.getProperty("ODBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransId"))) {
	      
	    	  Common.print(Actual_Value,prop.getProperty("ODTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransAmount"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("ODTransAmount"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODTransferMode"))) {
	      
	    	    Common.print(Actual_Value,prop.getProperty("ODTransferMode"));
	      
	     } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}

public static void VerifyODDrAutopostVrNo(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/ODDEBIT_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("ODVoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("ODVoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("ODVoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyODDrAutopostTrType(WebDriver driver) throws IOException {
	   
	  System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/ODDEBIT_AUTOPOST.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	          for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("ODTranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("ODTranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("ODTranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}


public static void VerifyODDrAutopostAmtTypes(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/ODDEBIT_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("ODAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("ODAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("ODAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyODDrAutopostGLCode(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/ODDEBIT_AUTOPOST.properties");
		  prop.load(input);
		  
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("ODGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("ODGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("ODGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  


public static void VerifyODDebitAutopostBrCode(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY BRANCHCODES");
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/ODDEBIT_AUTOPOST.properties");
	   prop.load(input);
	   
for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	  System.out.println("ODOrgId"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText());

	           if(prop.getProperty("ODOrgId"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText())){
	      
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("ODOrgId"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	      
	     
	            }
	  }
	    
}
public static WebDriver Verify_DLCredit_Cash(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY OD CREDIT SUMMARY");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/DLCREDIT_CASH.properties");
	     prop.load(input);
	     
	     if(Actual_Value.equals(prop.getProperty("DLproductName"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("DLproductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLAccountNumber"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLAccountDisplayName"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLAccountDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLBatchId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLTransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLVoucherId"))) {
	     
	    	 Common.print(Actual_Value,prop.getProperty("DLVoucherId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLTransactionType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLTransactionType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLAmount"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLAmount"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLAmountType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLAmountType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLGLAccCode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLGLAccCode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLTransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLTransferMode"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("DLOrgID"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLOrgID"));
	     
	            
	     }
	      
	       
	     else {
	      Driver.tcFlag = "FAIL";
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
	 
	 
	 
	 
	 return driver;
	 
	}
public static WebDriver Verify_DLCredit_Batch(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY OD CREDIT SUMMARY");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/DLCREDIT_BATCH.properties");
	     prop.load(input);
	     if(Actual_Value.equals(prop.getProperty("DLproductName"))) {
		      
	         Common.print(Actual_Value,prop.getProperty("DLproductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLAccountNumber"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLAccountDisplayName"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLAccountDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLBatchId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLTransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLVoucherId"))) {
	     
	    	 Common.print(Actual_Value,prop.getProperty("DLVoucherId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLTransactionType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLTransactionType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLAmount"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLAmount"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLAmountType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLAmountType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLGLAccCode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLGLAccCode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLTransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLTransferMode"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("DLOrgID"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DLOrgID"));
	     
	            
	     }
	      
	     
	       
	     else {
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
	 
	 
	 
	 
	 return driver;
	 
	}
public static WebDriver Verify_GLCredit_Cash(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY OD CREDIT SUMMARY");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/GLCREDIT_CASH.properties");
	     prop.load(input);
	     
	     if(Actual_Value.equals(prop.getProperty("GLproductName"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("GLproductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLAccountNumber"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLAccountDisplayName"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLAccountDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLBatchId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLTransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLVoucherId"))) {
	     
	    	 Common.print(Actual_Value,prop.getProperty("GLVoucherId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLTransactionType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLTransactionType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLAmount"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLAmount"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLAmountType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLAmountType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLGLAccCode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLGLAccCode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLTransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLTransferMode"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("GLOrgID"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLOrgID"));
	     
	            
	     }
	      
	       
	     else {
	      Driver.tcFlag = "FAIL";
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
	 
	 
	 
	 
	 return driver;
	 
	}
public static WebDriver Verify_GLCredit_Batch(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY OD CREDIT SUMMARY");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/GLCREDIT_BATCH.properties");
	     prop.load(input);
	     if(Actual_Value.equals(prop.getProperty("GLproductName"))) {
		      
	         Common.print(Actual_Value,prop.getProperty("GLproductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLAccountNumber"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLAccountDisplayName"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLAccountDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLBatchId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLTransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLVoucherId"))) {
	     
	    	 Common.print(Actual_Value,prop.getProperty("GLVoucherId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLTransactionType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLTransactionType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLAmount"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLAmount"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLAmountType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLAmountType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLGLAccCode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLGLAccCode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLTransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLTransferMode"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("GLOrgID"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("GLOrgID"));
	     
	            
	     }
	     
	       
	     else {
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
	 
	 
	 
	 
	 return driver;
	 
	}

public static WebDriver Verify_GLCredit_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/GLCREDIT_AUTOPOST.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("GLProductName1"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("GLProductName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLAccountNumber1"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("GLAccountNumber1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLDisplayName1"))) {
	      
	          Common.print(Actual_Value,prop.getProperty("GLDisplayName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLProductName2"))) {
		      
	          Common.print(Actual_Value,prop.getProperty("GLProductName2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("GLAccountNumber2"))) {
		      
	          Common.print(Actual_Value,prop.getProperty("GLAccountNumber2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("GLDisplayName2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("GLDisplayName2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("GLBatchId"))) {
	      
			  Common.print(Actual_Value,prop.getProperty("GLBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLTransId"))) {
	      
	    	  Common.print(Actual_Value,prop.getProperty("GLTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLTransAmount"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("GLTransAmount"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("GLTransferMode"))) {
	      
	    	    Common.print(Actual_Value,prop.getProperty("GLTransferMode"));
	      
	     } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}

public static void VerifyGLCrAutopostVrNo(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
    Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/GLCREDIT_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("GLVoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("GLVoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GLVoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyGLCrAutopostTrType(WebDriver driver) throws IOException {
	   
	  System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/GLCREDIT_AUTOPOST.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	          for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("GLTranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("GLTranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("GLTranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}


public static void VerifyGLCrAutopostAmtTypes(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
    Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/GLCREDIT_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("GLAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("GLAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GLAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyGLCrAutopostGLCode(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/GLCREDIT_AUTOPOST.properties");
		  prop.load(input);
		  
		  WebElement table = driver.findElement(By.id("tblCustList"));
        List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("GLGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("GLGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GLGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  


public static void VerifyGLCreditAutopostBrCode(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY BRANCHCODES");
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/GLCREDIT_AUTOPOST.properties");
	   prop.load(input);
	   
for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	  System.out.println("GLOrgId"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText());

	           if(prop.getProperty("GLOrgId"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText())){
	      
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("GLOrgId"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	      
	     
	            }
	  }
	    
}
public static WebDriver VerifyFDInterestPayment_Cash(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY FD INTEREST PAYMENT SUMMARY");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/FDINTERESTPAYMENT_CASH.properties");
	     prop.load(input);
	     
	     if(Actual_Value.equals(prop.getProperty("FDproductName"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("FDproductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAccountDisplayName"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDAccountDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDBatchId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDVoucherId"))) {
	     
	    	 Common.print(Actual_Value,prop.getProperty("FDVoucherId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransactionType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDTransactionType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAmount"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDAmount"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAmountType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDAmountType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDGLAccCode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDGLAccCode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDTransferMode"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("FDOrgID"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDOrgID"));
	     
	            
	     }
	      
	       
	     else {
	      Driver.tcFlag = "FAIL";
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
	 
	 
	 
	 
	 return driver;
	 
	}
public static WebDriver VerifyFDInterestPayment_Batch(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY FD INTEREST PAYMENT SUMMARY");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/FDINTERESTPAYMENT_BATCH.properties");
	     prop.load(input);
	     if(Actual_Value.equals(prop.getProperty("FDproductName"))) {
		      
	         Common.print(Actual_Value,prop.getProperty("FDproductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAccountDisplayName"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDAccountDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDBatchId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDVoucherId"))) {
	     
	    	 Common.print(Actual_Value,prop.getProperty("FDVoucherId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransactionType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDTransactionType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAmount"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDAmount"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAmountType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDAmountType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDGLAccCode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDGLAccCode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDTransferMode"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("FDOrgID"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("FDOrgID"));
	     
	            
	     }
	     
	     
	       
	     else {
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
	 
	 
	 
	 
	 return driver;
	 
	}
public static WebDriver VerifyFDInterestPayment_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	
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
					
					//System.out.println("Actual value is "+Actual_Value);

					
					Properties prop=new Properties();
					
					InputStream input = new FileInputStream("./DataFiles/FDINTERESTPAYMENT_AUTOPOST.properties");
					prop.load(input);
					
					
					
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
	
	
	
	
	return driver;
	
}
 public static WebDriver VerifySBAccClosure_Cash(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_CASH.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("SBProductName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("SBProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("SBAccountNumber"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("SBAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("SBDisplayName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("SBDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("SBBatchId"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("SBBatchId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("SBTransId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("SBTransId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("SBOrgId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("SBOrgId"));
		      
		  } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}

public static void VerifySBClosureVoucherNo_Cash(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_CASH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("SBVoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("SBVoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("SBVoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifySBClosureTransType_Cash(WebDriver driver) throws IOException {
	   
	  System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_CASH.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	          for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("SBTranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("SBTranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("SBTranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}

 public static void VerifySBClosureAmount_Cash(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_CASH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("SBTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("SBTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("SBTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
 public static void VerifySBClosureAmountType_Cash(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_CASH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("SBAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("SBAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("SBAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifySBClosureGLCode_Cash(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_CASH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("SBGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("SBGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("SBGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  


public static void VerifySBClosureTrMode_Cash(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY TRANSACTION MODE");
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_CASH.properties");
	   prop.load(input);
	   
     for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	  System.out.println("SBTransferMode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[12]")).getText());

	           if(prop.getProperty("SBTransferMode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[12]")).getText())){
	      
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("SBTransferMode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[12]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	      
	     
	            }
	  }
	    
}
public static WebDriver VerifySBAccClosure_Batch(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_BATCH.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("SBProductName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("SBProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("SBAccountNumber"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("SBAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("SBAccountDisplayName"))) {
	    	 
	       Common.print(Actual_Value,prop.getProperty("SBAccountDisplayName"));
				
		}else if(Actual_Value.equals(prop.getProperty("SBBatchId"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("SBBatchId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("SBTransId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("SBTransId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("SBOrgId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("SBOrgId"));
		      
		  } else {
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
	 
	 
	 
	 
	 return driver;
	 
	} 

public static void VerifySBClosureVoucherNo_Batch(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_BATCH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("SBVoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("SBVoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("SBVoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifySBClosureTransType_Batch(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_BATCH.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	          for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("SBTranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("SBTranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("SBTranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}

public static void VerifySBClosureAmount_Batch(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_BATCH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("SBTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("SBTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("SBTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifySBClosureAmountType_Batch(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
    Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_BATCH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("SBAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("SBAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("SBAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifySBClosureGLCode_Batch(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_BATCH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
        List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("SBGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("SBGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("SBGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  


public static void VerifySBClosureTrMode_Batch(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY TRANSACTION MODE");
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_BATCH.properties");
	   prop.load(input);
	   
   for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	  System.out.println("SBTransferMode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[12]")).getText());

	           if(prop.getProperty("SBTransferMode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[12]")).getText())){
	      
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("SBTransferMode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[12]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	      
	     
	            }
	  }
	    
}
public static WebDriver VerifySBAccountClosure_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_AUTOPOST.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("SBProductName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("SBProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("SBAccountNumber"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("SBAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("SBDisplayName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("SBDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("SBBatchId"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("SBBatchId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("SBTransId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("SBTransId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("SBTransferMode"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("SBTransferMode"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("SBOrgId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("SBOrgId"));
		      
		  } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}

public static void VerifySBClosureVoucherNo_Autopost(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
    Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("SBVoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("SBVoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("SBVoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifySBClosureTransType_Autopost(WebDriver driver) throws IOException {
	   
	  System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_AUTOPOST.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	          for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("SBTranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("SBTranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("SBTranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}

public static void VerifySBClosureAmount_Autopost(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_AUTOPOST.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("SBTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("SBTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("SBTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifySBClosureAmountType_Autopost(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
    Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("SBAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("SBAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("SBAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifySBClosureGLCode_Autopost(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/SBACC_CLOSURE_AUTOPOST.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
        List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("SBGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("SBGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("SBGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  
public static WebDriver VerifyFDAccClosure_Cash(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_CASH.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("FDProductName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("FDProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("FDAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDDisplayName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("FDDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDBatchId"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("FDBatchId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDTransId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("FDTransId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDVoucherNumber"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("FDVoucherNumber"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDTranType"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("FDTranType"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDTransferMode"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("FDTransferMode"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDOrgId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("FDOrgId"));
		      
		  } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}



public static void VerifyFDClosureAmount_Cash(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
   List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_CASH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("FDTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("FDTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyFDClosureAmountType_Cash(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
  Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_CASH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
  List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("FDAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("FDAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyFDClosureGLCode_Cash(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_CASH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("FDGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("FDGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  

public static WebDriver VerifyFDAccClosure_Batch(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_BATCH.properties");
	     prop.load(input);
	     
	     if(Actual_Value.equals(prop.getProperty("FDProductName"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("FDProductName"));
		      
		     }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("FDAccountNumber"));
		      
		     }else if(Actual_Value.equals(prop.getProperty("FDDisplayName"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("FDDisplayName"));
		      
		     }else if(Actual_Value.equals(prop.getProperty("FDBatchId"))) {
			      
		       Common.print(Actual_Value,prop.getProperty("FDBatchId"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDTransId"))) {
			      
			   Common.print(Actual_Value,prop.getProperty("FDTransId"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDVoucherNumber"))) {
			      
		       Common.print(Actual_Value,prop.getProperty("FDVoucherNumber"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDTranType"))) {
			      
		       Common.print(Actual_Value,prop.getProperty("FDTranType"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDTransferMode"))) {
			      
			   Common.print(Actual_Value,prop.getProperty("FDTransferMode"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDOrgId"))) {
			      
			   Common.print(Actual_Value,prop.getProperty("FDOrgId"));
	     
	     } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}



public static void VerifyFDClosureAmount_Batch(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
 List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_BATCH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("FDTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("FDTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyFDClosureAmountType_Batch(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_BATCH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("FDAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("FDAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyFDClosureGLCode_Batch(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_BATCH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("FDGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("FDGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  

public static WebDriver Verify_FDAccountClosure_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
  switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_AUTOPOST.properties");
	     prop.load(input);
	     
	     
	     if(Actual_Value.equals(prop.getProperty("FDProductName1"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("FDProductName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber1"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("FDAccountNumber1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDDisplayName1"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("FDDisplayName1"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDProductName2"))) {
		      
	          Common.print(Actual_Value,prop.getProperty("FDProductName2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber2"))) {
		      
	          Common.print(Actual_Value,prop.getProperty("FDAccountNumber2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDDisplayName2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("FDDisplayName2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDBatchId"))) {
	      
			  Common.print(Actual_Value,prop.getProperty("FDBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransId"))) {
	      
	    	  Common.print(Actual_Value,prop.getProperty("FDTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransAmount"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("FDTransAmount"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDTransferMode"))) {
	      
	    	    Common.print(Actual_Value,prop.getProperty("FDTransferMode"));
	      
	     } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}

public static void VerifyFDAccountClosureAutopostVrNo(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("FDVoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("FDVoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDVoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyFDAccountClosureAutopostTrType(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_AUTOPOST.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	          for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("FDTranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("FDTranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}


public static void VerifyFDAccountClosureAutopostAmtTypes(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("FDAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("FDAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyFDAccountClosureAutopostGLCode(WebDriver driver) throws IOException {
		  
		 
		  System.out.println("VERIFY GLCODES");
          Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_AUTOPOST.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("FDGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("FDGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  


public static void VerifyFDAccountClosureAutopostBrCode(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY BRANCHCODES");
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/FDACC_CLOSURE_AUTOPOST.properties");
	   prop.load(input);
	   
for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	  System.out.println("FDOrgId"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText());

	           if(prop.getProperty("FDOrgId"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText())){
	      
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDOrgId"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	      
	     
	            }
	  }
	    
}
public static WebDriver VerifyRDAccClosure_Cash(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_CASH.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("FDProductName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("FDProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("FDAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDDisplayName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("FDDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDBatchId"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("FDBatchId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDTransId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("FDTransId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDVoucherNumber"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("FDVoucherNumber"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDTranType"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("FDTranType"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDTransferMode"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("FDTransferMode"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDOrgId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("FDOrgId"));
		      
		  } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}



public static void VerifyRDClosureAmount_Cash(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
 List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_CASH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("FDTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("FDTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyRDClosureAmountType_Cash(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_CASH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("FDAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("FDAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyRDClosureGLCode_Cash(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_CASH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("FDGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("FDGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  

public static WebDriver VerifyRDAccClosure_Batch(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_BATCH.properties");
	     prop.load(input);
	     
	     if(Actual_Value.equals(prop.getProperty("FDProductName"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("FDProductName"));
		      
		     }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("FDAccountNumber"));
		      
		     }else if(Actual_Value.equals(prop.getProperty("FDDisplayName"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("FDDisplayName"));
		      
		     }else if(Actual_Value.equals(prop.getProperty("FDBatchId"))) {
			      
		       Common.print(Actual_Value,prop.getProperty("FDBatchId"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDTransId"))) {
			      
			   Common.print(Actual_Value,prop.getProperty("FDTransId"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDVoucherNumber"))) {
			      
		       Common.print(Actual_Value,prop.getProperty("FDVoucherNumber"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDTranType"))) {
			      
		       Common.print(Actual_Value,prop.getProperty("FDTranType"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDTransferMode"))) {
			      
			   Common.print(Actual_Value,prop.getProperty("FDTransferMode"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDOrgId"))) {
			      
			   Common.print(Actual_Value,prop.getProperty("FDOrgId"));
	     
	     } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}



public static void VerifyRDClosureAmount_Batch(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_BATCH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("FDTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("FDTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyRDClosureAmountType_Batch(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_BATCH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("FDAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("FDAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyRDClosureGLCode_Batch(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_BATCH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
  List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("FDGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("FDGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	} 

public static WebDriver Verify_RDAccountClosure_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_AUTOPOST.properties");
	     prop.load(input);
	     
	     
	     if(Actual_Value.equals(prop.getProperty("FDProductName1"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("FDProductName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber1"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("FDAccountNumber1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDDisplayName1"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("FDDisplayName1"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDProductName2"))) {
		      
	          Common.print(Actual_Value,prop.getProperty("FDProductName2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber2"))) {
		      
	          Common.print(Actual_Value,prop.getProperty("FDAccountNumber2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDDisplayName2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("FDDisplayName2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDBatchId"))) {
	      
			  Common.print(Actual_Value,prop.getProperty("FDBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransId"))) {
	      
	    	  Common.print(Actual_Value,prop.getProperty("FDTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransAmount"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("FDTransAmount"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDTransferMode"))) {
	      
	    	    Common.print(Actual_Value,prop.getProperty("FDTransferMode"));
	      
	     } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}

public static void VerifyRDAccountClosureAutopostVrNo(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
    Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("FDVoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("FDVoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDVoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyRDAccountClosureAutopostTrType(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_AUTOPOST.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	          for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("FDTranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("FDTranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}


public static void VerifyRDAccountClosureAutopostAmtTypes(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
    Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("FDAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("FDAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyRDAccountClosureAutopostGLCode(WebDriver driver) throws IOException {
		  
		 
		  System.out.println("VERIFY GLCODES");
        Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_AUTOPOST.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
        List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("FDGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("FDGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  


public static void VerifyRDAccountClosureAutopostBrCode(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY BRANCHCODES");
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/RDACC_CLOSURE_AUTOPOST.properties");
	   prop.load(input);
	   
for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	  System.out.println("FDOrgId"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText());

	           if(prop.getProperty("FDOrgId"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText())){
	      
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDOrgId"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	      
	     
	            }
	  }
	    
}
public static WebDriver VerifyDDAccClosure_Cash(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_CASH.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("FDProductName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("FDProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("FDAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDDisplayName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("FDDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDBatchId"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("FDBatchId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDTransId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("FDTransId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDVoucherNumber"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("FDVoucherNumber"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDTranType"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("FDTranType"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDTransferMode"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("FDTransferMode"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDOrgId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("FDOrgId"));
		      
		  } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}



public static void VerifyDDClosureAmount_Cash(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_CASH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("FDTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("FDTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyDDClosureAmountType_Cash(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_CASH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("FDAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("FDAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyDDClosureGLCode_Cash(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_CASH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
  List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("FDGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("FDGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  

public static WebDriver VerifyDDAccClosure_Batch(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_BATCH.properties");
	     prop.load(input);
	     
	     if(Actual_Value.equals(prop.getProperty("FDProductName"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("FDProductName"));
		      
		     }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("FDAccountNumber"));
		      
		     }else if(Actual_Value.equals(prop.getProperty("FDDisplayName"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("FDDisplayName"));
		      
		     }else if(Actual_Value.equals(prop.getProperty("FDBatchId"))) {
			      
		       Common.print(Actual_Value,prop.getProperty("FDBatchId"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDTransId"))) {
			      
			   Common.print(Actual_Value,prop.getProperty("FDTransId"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDVoucherNumber"))) {
			      
		       Common.print(Actual_Value,prop.getProperty("FDVoucherNumber"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDTranType"))) {
			      
		       Common.print(Actual_Value,prop.getProperty("FDTranType"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDTransferMode"))) {
			      
			   Common.print(Actual_Value,prop.getProperty("FDTransferMode"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDOrgId"))) {
			      
			   Common.print(Actual_Value,prop.getProperty("FDOrgId"));
	     
	     } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}



public static void VerifyDDClosureAmount_Batch(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_BATCH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("FDTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("FDTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyDDClosureAmountType_Batch(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_BATCH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("FDAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("FDAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyDDClosureGLCode_Batch(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_BATCH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("FDGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("FDGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  
public static WebDriver Verify_DDAccountClosure_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_AUTOPOST.properties");
	     prop.load(input);
	     
	     
	     if(Actual_Value.equals(prop.getProperty("FDProductName1"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("FDProductName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber1"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("FDAccountNumber1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDDisplayName1"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("FDDisplayName1"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDProductName2"))) {
		      
	          Common.print(Actual_Value,prop.getProperty("FDProductName2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber2"))) {
		      
	          Common.print(Actual_Value,prop.getProperty("FDAccountNumber2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDDisplayName2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("FDDisplayName2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDBatchId"))) {
	      
			  Common.print(Actual_Value,prop.getProperty("FDBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransId"))) {
	      
	    	  Common.print(Actual_Value,prop.getProperty("FDTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransAmount"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("FDTransAmount"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDTransferMode"))) {
	      
	    	    Common.print(Actual_Value,prop.getProperty("FDTransferMode"));
	      
	     } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}

public static void VerifyDDAccountClosureAutopostVrNo(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
  Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
  List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("FDVoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("FDVoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDVoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyDDAccountClosureAutopostTrType(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_AUTOPOST.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
   List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	          for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("FDTranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("FDTranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}


public static void VerifyDDAccountClosureAutopostAmtTypes(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
  Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
  List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("FDAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("FDAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyDDAccountClosureAutopostGLCode(WebDriver driver) throws IOException {
		  
		 
		  System.out.println("VERIFY GLCODES");
      Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_AUTOPOST.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("FDGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("FDGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  


public static void VerifyDDAccountClosureAutopostBrCode(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY BRANCHCODES");
	   WebElement table = driver.findElement(By.id("tblCustList"));
   List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/DDACC_CLOSURE_AUTOPOST.properties");
	   prop.load(input);
	   
for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	  System.out.println("FDOrgId"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText());

	           if(prop.getProperty("FDOrgId"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText())){
	      
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDOrgId"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	      
	     
	            }
	  }
	    
}
public static WebDriver VerifyRIDAccClosure_Cash(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_CASH.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("FDProductName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("FDProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("FDAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDDisplayName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("FDDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDBatchId"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("FDBatchId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDTransId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("FDTransId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDVoucherNumber"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("FDVoucherNumber"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDTranType"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("FDTranType"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDTransferMode"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("FDTransferMode"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDOrgId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("FDOrgId"));
		      
		  } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}



public static void VerifyRIDClosureAmount_Cash(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_CASH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("FDTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("FDTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyRIDClosureAmountType_Cash(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_CASH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("FDAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("FDAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyRIDClosureGLCode_Cash(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_CASH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("FDGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("FDGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  

public static WebDriver VerifyRIDAccClosure_Batch(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_BATCH.properties");
	     prop.load(input);
	     
	     if(Actual_Value.equals(prop.getProperty("FDProductName"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("FDProductName"));
		      
		     }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("FDAccountNumber"));
		      
		     }else if(Actual_Value.equals(prop.getProperty("FDDisplayName"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("FDDisplayName"));
		      
		     }else if(Actual_Value.equals(prop.getProperty("FDBatchId"))) {
			      
		       Common.print(Actual_Value,prop.getProperty("FDBatchId"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDTransId"))) {
			      
			   Common.print(Actual_Value,prop.getProperty("FDTransId"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDVoucherNumber"))) {
			      
		       Common.print(Actual_Value,prop.getProperty("FDVoucherNumber"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDTranType"))) {
			      
		       Common.print(Actual_Value,prop.getProperty("FDTranType"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDTransferMode"))) {
			      
			   Common.print(Actual_Value,prop.getProperty("FDTransferMode"));
			      
			 }else if(Actual_Value.equals(prop.getProperty("FDOrgId"))) {
			      
			   Common.print(Actual_Value,prop.getProperty("FDOrgId"));
	     
	     } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}



public static void VerifyRIDClosureAmount_Batch(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_BATCH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("FDTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("FDTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyRIDClosureAmountType_Batch(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_BATCH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("FDAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("FDAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyRIDClosureGLCode_Batch(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_BATCH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("FDGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("FDGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  
public static WebDriver Verify_RIDAccountClosure_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_AUTOPOST.properties");
	     prop.load(input);
	     
	     
	     if(Actual_Value.equals(prop.getProperty("FDProductName1"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("FDProductName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber1"))) {
	      
	         Common.print(Actual_Value,prop.getProperty("FDAccountNumber1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDDisplayName1"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("FDDisplayName1"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDProductName2"))) {
		      
	          Common.print(Actual_Value,prop.getProperty("FDProductName2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber2"))) {
		      
	          Common.print(Actual_Value,prop.getProperty("FDAccountNumber2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDDisplayName2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("FDDisplayName2"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDBatchId"))) {
	      
			  Common.print(Actual_Value,prop.getProperty("FDBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransId"))) {
	      
	    	  Common.print(Actual_Value,prop.getProperty("FDTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransAmount"))) {
		      
		       Common.print(Actual_Value,prop.getProperty("FDTransAmount"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDTransferMode"))) {
	      
	    	    Common.print(Actual_Value,prop.getProperty("FDTransferMode"));
	      
	     } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}

public static void VerifyRIDAccountClosureAutopostVrNo(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("FDVoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("FDVoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDVoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyRIDAccountClosureAutopostTrType(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_AUTOPOST.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	          for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("FDTranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("FDTranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}


public static void VerifyRIDAccountClosureAutopostAmtTypes(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("FDAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("FDAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyRIDAccountClosureAutopostGLCode(WebDriver driver) throws IOException {
		  
		 
		  System.out.println("VERIFY GLCODES");
          Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_AUTOPOST.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("FDGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("FDGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  


public static void VerifyRIDAccountClosureAutopostBrCode(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY BRANCHCODES");
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/RIDACC_CLOSURE_AUTOPOST.properties");
	   prop.load(input);
	   
for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	  System.out.println("FDOrgId"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText());

	           if(prop.getProperty("FDOrgId"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText())){
	      
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDOrgId"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	      
	     
	            }
	  }
	    
}
public static WebDriver VerifyODCashCreditRenewal_Batch(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY FD INTEREST PAYMENT SUMMARY");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/ODCASHCREDIT_RENEWAL_BATCH.properties");
	     prop.load(input);
	     if(Actual_Value.equals(prop.getProperty("ODproductName"))) {
		      
	         Common.print(Actual_Value,prop.getProperty("ODproductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAccountNumber"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAccountDisplayName"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAccountDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODBatchId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODVoucherId"))) {
	     
	    	 Common.print(Actual_Value,prop.getProperty("ODVoucherId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransactionType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransactionType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAmount"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAmount"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAmountType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAmountType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODGLAccCode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODGLAccCode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransferMode"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("ODOrgID"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODOrgID"));
	     
	            
	     }
	     
	     
	       
	     else {
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
	 
	 
	 
	 
	 return driver;
	 
	}
public static WebDriver VerifyODCashCreditRenewal_Cash(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY FD INTEREST PAYMENT SUMMARY");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/ODCASHCREDIT_RENEWAL_CASH.properties");
	     prop.load(input);
	     if(Actual_Value.equals(prop.getProperty("ODproductName"))) {
		      
	         Common.print(Actual_Value,prop.getProperty("ODproductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAccountNumber"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAccountDisplayName"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAccountDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODBatchId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODVoucherId"))) {
	     
	    	 Common.print(Actual_Value,prop.getProperty("ODVoucherId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransactionType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransactionType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAmount"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAmount"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAmountType"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODAmountType"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODGLAccCode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODGLAccCode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODTransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODTransferMode"));
	      
	     }else if (Actual_Value.equals(prop.getProperty("ODOrgID"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("ODOrgID"));
	     
	            
	     }
	     
	     
	       
	     else {
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
	 
	 
	 
	 
	 return driver;
	 
	}
public static WebDriver VerifyFDRenewal_Cash(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_CASH.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("FDProductName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("FDProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("FDAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAccountDisplayName"))) {
	    	 
	       Common.print(Actual_Value,prop.getProperty("FDAccountDisplayName"));
				
		}else if(Actual_Value.equals(prop.getProperty("FDBatchId"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("FDBatchId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDTransId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("FDTransId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDOrgId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("FDOrgId"));
		      
		  } else {
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
	 
	 
	 
	 
	 return driver;
	 
	} 

public static void VerifyFDRenewalVoucherNo_Cash(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
    Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_CASH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("FDVoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("FDVoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDVoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyFDRenewalTransType_Cash(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_CASH.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	          for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("FDTranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("FDTranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}

public static void VerifyFDRenewalAmount_Cash(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
   List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_CASH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("FDTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("FDTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyFDRenewalAmountType_Cash(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
  Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_CASH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
  List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("FDAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("FDAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyFDRenewalGLCode_Cash(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_CASH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("FDGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("FDGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  


public static void VerifyFDRenewalTrMode_Cash(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY TRANSACTION MODE");
	   WebElement table = driver.findElement(By.id("tblCustList"));
   List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_CASH.properties");
	   prop.load(input);
	   
 for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	  System.out.println("FDTransferMode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[12]")).getText());

	           if(prop.getProperty("FDTransferMode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[12]")).getText())){
	      
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTransferMode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[12]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	      
	     
	            }
	  }
	    
}
public static WebDriver VerifyFDRenewal_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_AUTOPOST.properties");
	     prop.load(input);
	     
	     
	     if(Actual_Value.equals(prop.getProperty("FDBatchId"))) {
	      
			  Common.print(Actual_Value,prop.getProperty("FDBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransId"))) {
	      
	    	  Common.print(Actual_Value,prop.getProperty("FDTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransferMode"))) {
	      
	    	    Common.print(Actual_Value,prop.getProperty("FDTransferMode"));
	      
	     } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}

public static void VerifyFDRenewalVoucherNo_Autopost(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("FDVoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("FDVoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDVoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyFDRenewalTransType_Autopost(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_AUTOPOST.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	          for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("FDTranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("FDTranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}
public static void VerifyFDRenewalAmount_Autopost(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_CASH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("FDTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("FDTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}

public static void VerifyFDRenewalAmountType_Autopost(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("FDAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("FDAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyFDRenewalGLCode_Autopost(WebDriver driver) throws IOException {
		  
		 
		  System.out.println("VERIFY GLCODES");
          Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_AUTOPOST.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("FDGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("FDGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  


public static void VerifyFDRenewalTrMode_Autopost(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY BRANCHCODES");
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_AUTOPOST.properties");
	   prop.load(input);
	   
for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	  System.out.println("FDOrgId"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText());

	           if(prop.getProperty("FDOrgId"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText())){
	      
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDOrgId"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	      
	     
	            }
	  }
	    
}
public static WebDriver VerifyFDRenewal_Batch(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_BATCH.properties");
	     prop.load(input);
	     
	     
	     if(Actual_Value.equals(prop.getProperty("FDProductName"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("FDProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAccountNumber"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("FDAccountNumber"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("FDAccountDisplayName"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("FDAccountDisplayName"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("FDBatchId"))) {
	      
			  Common.print(Actual_Value,prop.getProperty("FDBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransId"))) {
	      
	    	  Common.print(Actual_Value,prop.getProperty("FDTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDTransferMode"))) {
	      
	    	    Common.print(Actual_Value,prop.getProperty("FDTransferMode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDOrgId"))) {
		      
	    	    Common.print(Actual_Value,prop.getProperty("FDOrgId"));
	      
	     } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}

public static void VerifyFDRenewalVoucherNo_Batch(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_BATCH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	   for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("FDVoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("FDVoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDVoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyFDRenewalTransType_Batch(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_BATCH.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	   for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("FDTranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("FDTranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}
public static void VerifyFDRenewalAmount_Batch(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_BATCH.properties");
	   prop.load(input);
	   
	  for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("FDTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("FDTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}

public static void VerifyFDRenewalAmountType_Batch(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_BATCH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	 for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("FDAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("FDAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyFDRenewalGLCode_Batch(WebDriver driver) throws IOException {
		  
		 
		  System.out.println("VERIFY GLCODES");
          Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/FD_RENEWAL_BATCH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	     for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("FDGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("FDGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  

public static WebDriver VerifyGLRenewal_Cash(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
  switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_CASH.properties");
	     prop.load(input);
	     
	     
	      if(Actual_Value.equals(prop.getProperty("GLProductName"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("GLProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLAccountNumber1"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("GLAccountNumber1"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("GLAccountNumber2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("GLAccountNumber2"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("GLAccountDisplayName"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("GLAccountDisplayName"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("GLBatchId"))) {
	      
			  Common.print(Actual_Value,prop.getProperty("GLBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLTransId"))) {
	      
	    	  Common.print(Actual_Value,prop.getProperty("GLTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLOrgId"))) {
		      
	    	    Common.print(Actual_Value,prop.getProperty("GLOrgId"));
	      
	     } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}

public static void VerifyGLRenewalVoucherNo_Cash(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_CASH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	   for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("GLVoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("GLVoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GLVoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyGLRenewalTransType_Cash(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_CASH.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	   for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("GLTranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("GLTranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("GLTranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}
public static void VerifyGLRenewalAmount_Cash(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_CASH.properties");
	   prop.load(input);
	   
	  for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("GLTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("GLTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("GLTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}

public static void VerifyGLRenewalAmountType_Cash(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_CASH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	 for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("GLAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("GLAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GLAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyGLRenewalGLCode_Cash(WebDriver driver) throws IOException {
		  
		 
		  System.out.println("VERIFY GLCODES");
          Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_CASH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	     for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("GLGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("GLGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GLGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  

public static void VerifyGLRenewalTrMode_Cash(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY TRANSACTION MODE");
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_CASH.properties");
	   prop.load(input);
	   
       for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	  System.out.println("GLTransferMode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[12]")).getText());

	           if(prop.getProperty("GLTransferMode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[12]")).getText())){
	      
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("GLTransferMode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[12]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	      
	     
	            }
	  }
	    
}
public static WebDriver VerifyGLRenewal_Batch(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("VERIFY SUMMARY METHOD");
	  //driver.get("http://121.242.120.119:8086/BeaconProQC/ProductForms/ProductAccountSummaryViewForm.aspx?request=7dZyf1EZz455U2yUFOApA+m/XE0c7ULKRR/yWc4GvjJVxYL2kd0dHBaXxn+Li/JsMKOnFfcdaxaqET90YvWo97XXcKTr8oNy");
	  Connection con = null;
	  String TransID = "";
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String UserName = "sqa";
			String Password = "SPQA@sql2019" ;
			String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=Beaconpro_Automation;encrypt=true;trustservercertificate=true";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(Url,UserName,Password);
			//System.out.println("Class: Common Method: DatabaseConnector: Connected");
			Thread.sleep(5000);
			if (con != null){
				try{
					new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]"))));
					TransID = driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					
					System.out.println("Trisha: " + TransID);
					
										
					
				}catch(Exception e){
					Driver.tcFlag = "FAIL";
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				// Got Transaction ID
				String sql1 = "select ProductName,AcNo, AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,RespBranchID from QaFnGetSummaryDetails (" + TransID + ") ORDER BY VoucherNo Desc";
				System.out.println(sql1);
						Statement stmt1 = con.createStatement();
						ResultSet rs1 = stmt1.executeQuery(sql1);
						int rowCounter = 0;
						LinkedHashMap<String,  String> summaryReportDB = new LinkedHashMap<String,String>();
						LinkedHashMap<String,  String> summaryReportAPP = new LinkedHashMap<String,String>();
						String batchid="";
						
						
						while(rs1.next()){
							rowCounter = rowCounter + 1;
							summaryReportDB.put("productName" + rowCounter, rs1.getString("ProductName").trim());
							summaryReportDB.put("acno" + rowCounter, rs1.getString("AcNo").trim());
							summaryReportDB.put("displayName" + rowCounter, rs1.getString("AcDisplayName").trim());
							summaryReportDB.put("batchId" + rowCounter,rs1.getString("BatchID").trim() );
							//batchid = rs1.getString("BatchID");
							summaryReportDB.put("transId" + rowCounter, rs1.getString("TransID").trim());
							summaryReportDB.put("voucherNo" + rowCounter, rs1.getString("VoucherNo").trim());
							summaryReportDB.put("crdr" + rowCounter, rs1.getString("CrorDr").trim());
							summaryReportDB.put("amount" + rowCounter, rs1.getString("TrnAmount").trim());
							summaryReportDB.put("amounttype" + rowCounter, rs1.getString("AmtTypeText").trim());
							summaryReportDB.put("accode" + rowCounter, rs1.getString("GLAcCode").trim());
							summaryReportDB.put("tmode" + rowCounter, rs1.getString("TrnMode").trim());
							summaryReportDB.put("branchId" + rowCounter,rs1.getString("RespBranchID").trim() );
							
							
						}
						
						
						//System.out.println("No. of Rows: " + rowCounter);
						rs1.close();
						
						sql1 = "select TrnAmount from QaFnGetSummaryDetails (" + TransID + ") Where CrorDr = 'Cr'";
						rs1 = stmt1.executeQuery(sql1);
						float creditAmount = 0;
						while(rs1.next()){
							creditAmount = creditAmount + Float.valueOf(rs1.getString(1));
						}
						rs1.close();
						sql1 = "select TrnAmount from QaFnGetSummaryDetails (" + TransID + ") Where CrorDr = 'Dr'";
						rs1 = stmt1.executeQuery(sql1);
						float debitAmount = 0;
						while(rs1.next()){
							debitAmount = debitAmount + Float.valueOf(rs1.getString(1));
						}
						rs1.close();
						
						
						Properties prop=new Properties();
					      
					      FileOutputStream fos = new FileOutputStream("./DataFiles/GL_RENEWAL_BATCH.properties");
					      prop.setProperty("GLTransId", String.valueOf(TransID));
					      
					      
											
						prop.setProperty("TotalAmount", (creditAmount-debitAmount)+""); 
						System.out.println("Total Credit Amount: " + creditAmount);
						System.out.println("Total Debit Amount: " + debitAmount);
						System.out.println("Total Amount: " + (creditAmount - debitAmount));
						
						prop.store(fos, "Done");
						 fos.close();
						
						 System.out.println("*********** RowCount: " + rowCounter);
						 
						
						
						con.close();
						if (rowCounter == 0){
							System.out.println("Inside If Loop: rowcounter is zero");
							Driver.tcFlag = "FAIL";
							Driver.comment = "Query has returned 0 records";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
						}else{
							System.out.println("Inside Else loop: ");
							//Thread.sleep(3000);
							List<WebElement> rows = driver.findElements(By.xpath(propertyValue));
							//System.out.println(rows.size());
							System.out.println("Row Size: " + (rows.size()-1));
							int indexCounter = 0;
							
							if (rows.size()-1 == rowCounter){
								indexCounter = rows.size()-1;
							}else if ((rows.size()-2 == rowCounter)){
								indexCounter =  rows.size()-2;
							}else if ((rows.size()-3 == rowCounter)){
								indexCounter = rows.size()-3;
							}else{
								Driver.tcFlag = "FAIL";
								Driver.comment = "Rows displayed on the screen are not same with rows contained in database. Application is displaying more invisible blank rows";
								Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
							}
							
							
							if (rowCounter == indexCounter){
								System.out.println("Entered comparison loop");
								//indexCounter = indexCounter - 1;
								for(int i=1; i<= indexCounter; i++){
									int rowIndex = i+1;

									summaryReportAPP.put("productName" + i, driver.findElement(By.xpath(propertyValue + "[" + rowIndex + "]/td[2]")).getText().trim() );
									summaryReportAPP.put("acno" + i, driver.findElement(By.xpath(propertyValue + "[" + rowIndex + "]/td[3]")).getText().trim());
									summaryReportAPP.put("displayName" + i, driver.findElement(By.xpath(propertyValue + "[" + rowIndex + "]/td[4]")).getText().trim());
									summaryReportAPP.put("batchId" + i, driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[5]")).getText().trim());
									summaryReportAPP.put("transId" + i, driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[6]")).getText().trim());
									summaryReportAPP.put("voucherNo" + i, driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[7]")).getText().trim());
									summaryReportAPP.put("crdr" + i, driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[8]")).getText().trim());
									summaryReportAPP.put("amount" + i, driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[9]")).getText().trim());
									summaryReportAPP.put("amounttype" + i, driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[10]")).getText().trim());
									summaryReportAPP.put("accode" + i, driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[11]")).getText().trim());
									summaryReportAPP.put("tmode" + i, driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[12]")).getText().trim());
									summaryReportAPP.put("branchId" + i, driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[13]")).getText().trim());
								}
								//System.out.println("Hello Ravikiran");
								String comment = "";
								//Thread.sleep(2000);
								for(int i=1; i<=indexCounter; i++){
									comment = comment + " Product Name:        " + "Expected Value: " + summaryReportDB.get("productName" + i) + " Actual Value: " + summaryReportAPP.get("productName" + i) + "<br>" +
														"Account No:           " + "Expected Value: " + summaryReportDB.get("acno" + i)        + " Actual Value: " + summaryReportAPP.get("acno" + i) + "<br>" +
														"Account Display Name: " + "Expected Value: " + summaryReportDB.get("displayName" +i)  + " Actual Value: " + summaryReportAPP.get("displayName" + i) + "<br>" +
														"Batch ID:             " + "Expected Value: " + summaryReportDB.get("batchId" + i)     + " Actual Value: " + summaryReportAPP.get("batchId" + i) + "<br>" +
														"Trans ID:             " + "Expected Value: " + summaryReportDB.get("transId" + i)     + " Actual Value: " + summaryReportAPP.get("transId" + i) + "<br>" +
														"Voucher No:           " + "Expected Value: " + summaryReportDB.get("voucherNo" + i)   + " Actual Value: " + summaryReportAPP.get("voucherNo" + i) + "<br>" +
														"Cr/Dr:                " + "Expected Value: " + summaryReportDB.get("crdr" + i)        + " Actual Value: " + summaryReportAPP.get("crdr" + i) + "<br>" +
														"Amount:               " + "Expected Value: " + summaryReportDB.get("amount" + i)      + " Actual Value: " + summaryReportAPP.get("amount" + i) + "<br>" +
														"Amount Type:          " + "Expected Value: " + summaryReportDB.get("amounttype" + i)  + " Actual Value: " + summaryReportAPP.get("amounttype" + i) + "<br>" +
														"Account Code:         " + "Expected Value: " + summaryReportDB.get("accode" + i)      + " Actual Value: " + summaryReportAPP.get("accode" + i) + "<br>" +
														"Trans Mode:           " + "Expected Value: " + summaryReportDB.get("tmode" + i)       + " Actual Value: " + summaryReportAPP.get("tmode" + i) + "<br>" +
														"Branch ID:            " + "Expected Value: " + summaryReportDB.get("branchId" + i)    + " Actual Value: " + summaryReportAPP.get("branchId" + i) + "<br><br><br>" ;
														
														
								}
								
								System.out.println(comment);
								if (summaryReportDB.equals(summaryReportAPP)){
									Driver.tcFlag = "PASS";
									Driver.comment = "Pass" + " # " + comment;
									Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
									
								}else{
									Driver.tcFlag =  "FAIL";
									Driver.comment = comment;
									Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);		
								}
						}
					}	
						
						
						//Read  Values From Database - Completed
						
						
				
			}else{
				System.out.println("Hello Null");
				Driver.tcFlag = "FAIL";
				Driver.comment = "Database connection is null";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}

		}catch(Exception e)
		{
			Driver.tcFlag = "FAIL";
			Driver.comment =  "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
			//System.out.println("Class: Common Method: DatabaseConnector: Not Connected");
		}
	  
	  
/*	  try{
	   element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
	    
	   if (element.isDisplayed() == true) {
	     
	     if(element.isEnabled()==true) { 
	      
	     Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
	     
	     }else {
	      
	      
	     Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
	      
	     }
	     
	     System.out.println("Actual value = "+Actual_Value);

	     
	     Properties prop=new Properties();
	     
	     InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_BATCH.properties");
	     prop.load(input);
	     
	     
	      if(Actual_Value.equals(prop.getProperty("GLProductName"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("GLProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLAccountNumber1"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("GLAccountNumber1"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("GLAccountNumber2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("GLAccountNumber2"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("GLAccountDisplayName"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("GLAccountDisplayName"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("GLBatchId"))) {
	      
			  Common.print(Actual_Value,prop.getProperty("GLBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLTransId"))) {
	      
	    	  Common.print(Actual_Value,prop.getProperty("GLTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLTransferMode"))) {
		      
	    	  Common.print(Actual_Value,prop.getProperty("GLTransferMode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLOrgId"))) {
		      
	    	    Common.print(Actual_Value,prop.getProperty("GLOrgId"));
	      
	     } else {
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
*/	   
	 

	 break;

	 
	  
	 case "name":
	  
	  break;
	  
	 case "css":
	  
	  break;
	 }
	 
	 
	 
	 
	 return driver;
	 
	}

public static void VerifyGLRenewalVoucherNo_Batch(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_BATCH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	   for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("GLVoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("GLVoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GLVoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyGLRenewalTransType_Batch(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_BATCH.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	   for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("GLTranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("GLTranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("GLTranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}
public static void VerifyGLRenewalAmount_Batch(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_BATCH.properties");
	   prop.load(input);
	   
	  for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("GLTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("GLTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("GLTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}

public static void VerifyGLRenewalAmountType_Batch(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_BATCH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	 for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("GLAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("GLAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GLAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyGLRenewalGLCode_Batch(WebDriver driver) throws IOException {
		  
		 
		  System.out.println("VERIFY GLCODES");
          Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_BATCH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
         List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	     for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("GLGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("GLGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GLGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}
public static WebDriver VerifyGLRenewal_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_AUTOPOST.properties");
	     prop.load(input);
	     
	     
	     if(Actual_Value.equals(prop.getProperty("GLBatchId"))) {
	      
			  Common.print(Actual_Value,prop.getProperty("GLBatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLTransId"))) {
	      
	    	  Common.print(Actual_Value,prop.getProperty("GLTransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLTransferMode"))) {
	      
	    	    Common.print(Actual_Value,prop.getProperty("GLTransferMode"));
	      
	     } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}

public static void VerifyGLRenewalVoucherNo_Autopost(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("GLVoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("GLVoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GLVoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyGLRenewalTransType_Autopost(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_AUTOPOST.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	          for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("GLTranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("GLTranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("GLTranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}
public static void VerifyGLRenewalAmount_Autopost(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_AUTOPOST.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("GLTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("GLTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("GLTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}

public static void VerifyGLRenewalAmountType_Autopost(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

     for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("GLAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("GLAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GLAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyGLRenewalGLCode_Autopost(WebDriver driver) throws IOException {
		  
		 
		  System.out.println("VERIFY GLCODES");
          Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_AUTOPOST.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	   for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("GLGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("GLGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GLGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  


public static void VerifyGLRenewalTrMode_Autopost(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY BRANCHCODES");
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/GL_RENEWAL_AUTOPOST.properties");
	   prop.load(input);
	   
      for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	  System.out.println("GLOrgId"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText());

	           if(prop.getProperty("GLOrgId"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText())){
	      
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("GLOrgId"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	      
	     
	            }
	  }
	    
}
public static WebDriver VerifyOLClosure_Cash(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/OL_CLOSURE_CASH.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("OLProductName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("OLProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OLAccountNumber"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("OLAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OLDisplayName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("OLDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OLBatchId"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("OLBatchId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("OLTransId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("OLTransId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("OLVoucherNumber"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("OLVoucherNumber"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("OLTranType"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("OLTranType"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("OLTransferMode"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("OLTransferMode"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("OLOrgId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("OLOrgId"));
		      
		  } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}



public static void VerifyOLClosureAmount_Cash(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/OL_CLOSURE_CASH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("OLTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("OLTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("OLTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyOLClosureAmountType_Cash(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/OL_CLOSURE_CASH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("OLAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("OLAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("OLAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyOLClosureGLCode_Cash(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/OL_CLOSURE_CASH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("OLGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("OLGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("OLGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  
public static WebDriver VerifyODClosure_Cash(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/OD_CLOSURE_CASH.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("ODProductName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("ODProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAccountNumber"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("ODAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODDisplayName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("ODDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODBatchId"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("ODBatchId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODTransId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("ODTransId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODVoucherNumber"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("ODVoucherNumber"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODTranType"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("ODTranType"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODTransferMode"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("ODTransferMode"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODOrgId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("ODOrgId"));
		      
		  } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}



public static void VerifyODClosureAmount_Cash(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/OD_CLOSURE_CASH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("ODTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("ODTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("ODTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyODClosureAmountType_Cash(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
    Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/OD_CLOSURE_CASH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("ODAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("ODAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("ODAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyODClosureGLCode_Cash(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/OD_CLOSURE_CASH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
        List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("ODGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("ODGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("ODGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  
public static WebDriver VerifyDLClosure_Cash(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/DL_CLOSURE_CASH.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("DLProductName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("DLProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLAccountNumber"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("DLAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLDisplayName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("DLDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLBatchId"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("DLBatchId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("DLTransId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("DLTransId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("DLVoucherNumber"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("DLVoucherNumber"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("DLTranType"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("DLTranType"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("DLTransferMode"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("DLTransferMode"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("DLOrgId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("DLOrgId"));
		      
		  } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}



public static void VerifyDLClosureAmount_Cash(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/DL_CLOSURE_CASH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("DLTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("DLTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("DLTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyDLClosureAmountType_Cash(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/DL_CLOSURE_CASH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("DLAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("DLAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("DLAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyDLClosureGLCode_Cash(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/DL_CLOSURE_CASH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("DLGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("DLGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("DLGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  

public static WebDriver VerifyGLClosure_Cash(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/GL_CLOSURE_CASH.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("GLProductName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("GLProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLAccountNumber"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("GLAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLDisplayName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("GLDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLBatchId"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("GLBatchId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("GLTransId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("GLTransId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("GLVoucherNumber"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("GLVoucherNumber"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("GLTranType"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("GLTranType"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("GLTransferMode"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("GLTransferMode"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("GLOrgId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("GLOrgId"));
		      
		  } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}



public static void VerifyGLClosureAmount_Cash(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/GL_CLOSURE_CASH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("GLTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("GLTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("GLTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
 public static void VerifyGLClosureAmountType_Cash(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/GL_CLOSURE_CASH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("GLAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("GLAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GLAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyGLClosureGLCode_Cash(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/GL_CLOSURE_CASH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("GLGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("GLGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GLGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  

public static WebDriver Verify_OLClosure_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/OLCLOSURE_AUTOPOST.properties");
	     prop.load(input);
	     
	     
	     
	     
	      if(Actual_Value.equals(prop.getProperty("OL_ProductName1"))) {
	      
	    	  Common.print(Actual_Value,prop.getProperty("OL_ProductName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OL_AccountNumber1"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("OL_AccountNumber1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OL_DisplayName1"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("OL_DisplayName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OL_ProductName2"))) {
		      
	    	 Common.print(Actual_Value,prop.getProperty("OL_ProductName2"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("OL_AccountNumber2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("OL_AccountNumber2"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("OL_DisplayName2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("OL_DisplayName2"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("OL_BatchId"))) {
	      
			  Common.print(Actual_Value,prop.getProperty("OL_BatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OL_TransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("OL_TransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OL_TransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("OL_TransferMode"));
	      
	     } else {
	      Driver.tcFlag = "PASS";
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

public static void VerifyOLClosureAutopostVrNo(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/OLCLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("OL_VoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("OL_VoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("OL_VoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyOLClosureAutopostTrType(WebDriver driver) throws IOException {
	   
	  System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/OLCLOSURE_AUTOPOST.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	          for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("OL_TranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("OL_TranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("OL_TranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}

public static void VerifyOLClosureAutopostAmt(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/OLCLOSURE_AUTOPOST.properties");
	    prop.load(input);
	   
 for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("OL_TransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("OL_TransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("OL_TransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyOLClosureAutopostAmtTypes(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/OLCLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

  for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("OL_AmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("OL_AmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("OL_AmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyOLClosureAutopostGLCode(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/OLCLOSURE_AUTOPOST.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("OL_GlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("OL_GlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("OL_GlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  


public static void VerifyOLClosureAutopostBrCode(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY BRANCHCODES");
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/OLCLOSURE_AUTOPOST.properties");
	   prop.load(input);
	   
  for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	  System.out.println("OL_OrgId"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText());

	           if(prop.getProperty("OL_OrgId"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText())){
	      
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("OL_OrgId"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	      
	     
	            }
	  }
	    
}
public static WebDriver Verify_ODClosure_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/ODCLOSURE_AUTOPOST.properties");
	     prop.load(input);
	     
	     
	     
	     
	      if(Actual_Value.equals(prop.getProperty("OD_ProductName1"))) {
	      
	    	  Common.print(Actual_Value,prop.getProperty("OD_ProductName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OD_AccountNumber1"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("OD_AccountNumber1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OD_DisplayName1"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("OD_DisplayName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OD_ProductName2"))) {
		      
	    	 Common.print(Actual_Value,prop.getProperty("OD_ProductName2"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("OD_AccountNumber2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("OD_AccountNumber2"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("OD_DisplayName2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("OD_DisplayName2"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("OD_BatchId"))) {
	      
			  Common.print(Actual_Value,prop.getProperty("OD_BatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OD_TransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("OD_TransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OD_TransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("OD_TransferMode"));
	      
	     } else {
	      Driver.tcFlag = "PASS";
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

public static void VerifyODClosureAutopostVrNo(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
    Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/ODCLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("OD_VoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("OD_VoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("OD_VoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyODClosureAutopostTrType(WebDriver driver) throws IOException {
	   
	  System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/ODCLOSURE_AUTOPOST.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	          for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("OD_TranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("OD_TranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("OD_TranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}

public static void VerifyODClosureAutopostAmt(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/ODCLOSURE_AUTOPOST.properties");
	    prop.load(input);
	   
for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("OD_TransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("OD_TransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("OD_TransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyODClosureAutopostAmtTypes(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
    Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/ODCLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("OD_AmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("OD_AmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("OD_AmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyODClosureAutopostGLCode(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/ODCLOSURE_AUTOPOST.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
        List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("OD_GlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("OD_GlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("OD_GlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  


public static void VerifyODClosureAutopostBrCode(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY BRANCHCODES");
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/ODCLOSURE_AUTOPOST.properties");
	   prop.load(input);
	   
for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	  System.out.println("OD_OrgId"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText());

	           if(prop.getProperty("OD_OrgId"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText())){
	      
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("OD_OrgId"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	      
	     
	            }
	  }
	    
}

public static WebDriver Verify_DLClosure_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/DLCLOSURE_AUTOPOST.properties");
	     prop.load(input);
	     
	     
	     
	     
	      if(Actual_Value.equals(prop.getProperty("DL_ProductName1"))) {
	      
	    	  Common.print(Actual_Value,prop.getProperty("DL_ProductName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DL_AccountNumber1"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DL_AccountNumber1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DL_DisplayName1"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DL_DisplayName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DL_ProductName2"))) {
		      
	    	 Common.print(Actual_Value,prop.getProperty("DL_ProductName2"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("DL_AccountNumber2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("DL_AccountNumber2"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("DL_DisplayName2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("DL_DisplayName2"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("DL_BatchId"))) {
	      
			  Common.print(Actual_Value,prop.getProperty("DL_BatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DL_TransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DL_TransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DL_TransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DL_TransferMode"));
	      
	     } else {
	      Driver.tcFlag = "PASS";
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

public static void VerifyDLClosureAutopostVrNo(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
    Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/DLCLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("DL_VoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("DL_VoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("DL_VoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyDLClosureAutopostTrType(WebDriver driver) throws IOException {
	   
	  System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/DLCLOSURE_AUTOPOST.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	     for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("DL_TranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("DL_TranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("DL_TranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}

public static void VerifyDLClosureAutopostAmt(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/DLCLOSURE_AUTOPOST.properties");
	    prop.load(input);
	   
for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("DL_TransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("DL_TransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("DL_TransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyDLClosureAutopostAmtTypes(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
    Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/DLCLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("DL_AmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("DL_AmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("DL_AmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyDLClosureAutopostGLCode(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/DLCLOSURE_AUTOPOST.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
        List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	 for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("DL_GlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("DL_GlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("DL_GlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  


public static void VerifyDLClosureAutopostBrCode(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY BRANCHCODES");
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/DLCLOSURE_AUTOPOST.properties");
	   prop.load(input);
	   
for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	  System.out.println("DL_OrgId"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText());

	           if(prop.getProperty("DL_OrgId"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText())){
	      
	               System.out.println("Equal");
	               Driver.tcFlag = "PASS";
	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("DL_OrgId"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText(); 
	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	      
	     
	            }
	  }
	    
}
public static WebDriver Verify_GLClosure_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/GLCLOSURE_AUTOPOST.properties");
	     prop.load(input);
	     
	     
	     
	     
	      if(Actual_Value.equals(prop.getProperty("DL_ProductName1"))) {
	      
	    	  Common.print(Actual_Value,prop.getProperty("DL_ProductName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DL_AccountNumber1"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DL_AccountNumber1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DL_DisplayName1"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DL_DisplayName1"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DL_ProductName2"))) {
		      
	    	 Common.print(Actual_Value,prop.getProperty("DL_ProductName2"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("DL_AccountNumber2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("DL_AccountNumber2"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("DL_DisplayName2"))) {
		      
			  Common.print(Actual_Value,prop.getProperty("DL_DisplayName2"));
		      
		  }else if(Actual_Value.equals(prop.getProperty("DL_BatchId"))) {
	      
			  Common.print(Actual_Value,prop.getProperty("DL_BatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DL_TransId"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DL_TransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DL_TransferMode"))) {
	      
	    	 Common.print(Actual_Value,prop.getProperty("DL_TransferMode"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DL_OrgId"))) {
		      
		     Common.print(Actual_Value,prop.getProperty("DL_OrgId"));
		      
		 } else {
	      Driver.tcFlag = "PASS";
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

public static void VerifyGLClosureAutopostVrNo(WebDriver driver) throws IOException {
	  
	 
	  System.out.println("VERIFY VOUCHER NUMBER");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/GLCLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

	       for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	            System.out.println("DL_VoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
	    
	                 if(prop.getProperty("DL_VoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
	    
	                    System.out.println("Equal");
	                    Driver.tcFlag = "PASS";
	                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("DL_VoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
	                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                 }
	       }
	   
}  

public static void VerifyGLClosureAutopostTrType(WebDriver driver) throws IOException {
	   
	  System.out.println("VERIFY TRANSACTION TYPE");
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/GLCLOSURE_AUTOPOST.properties");
	   prop.load(input);
	   WebElement table = driver.findElement(By.id("tblCustList"));
   List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	 
	     for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
		   
		          System.out.println("DL_TranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

	                   if(prop.getProperty("DL_TranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
	     
	                      System.out.println("Equal");
	                      Driver.tcFlag = "PASS";
	                      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("DL_TranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	                   }
	          }
}

public static void VerifyGLClosureAutopostAmt(WebDriver driver) throws IOException {
	   
	 System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/GLCLOSURE_AUTOPOST.properties");
	    prop.load(input);
	   
for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("DL_TransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("DL_TransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("DL_TransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyGLClosureAutopostAmtTypes(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/GLCLOSURE_AUTOPOST.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("DL_AmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("DL_AmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("DL_AmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyGLClosureAutopostGLCode(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/GLCLOSURE_AUTOPOST.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	 for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("DL_GlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("DL_GlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("DL_GlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  

public static WebDriver VerifyOLClosure_Batch(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/OL_CLOSURE_BATCH.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("OLProductName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("OLProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OLAccountNumber"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("OLAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OLDisplayName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("OLDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("OLBatchId"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("OLBatchId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("OLTransId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("OLTransId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("OLVoucherNumber"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("OLVoucherNumber"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("OLTranType"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("OLTranType"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("OLTransferMode"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("OLTransferMode"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("OLOrgId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("OLOrgId"));
		      
		  } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}



public static void VerifyOLClosureAmount_Batch(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/OL_CLOSURE_BATCH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("OLTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("OLTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("OLTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyOLClosureAmountType_Batch(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/OL_CLOSURE_BATCH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("OLAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("OLAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("OLAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyOLClosureGLCode_Batch(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/OL_CLOSURE_BATCH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("OLGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("OLGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("OLGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  
public static WebDriver VerifyODClosure_Batch(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/OD_CLOSURE_BATCH.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("ODProductName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("ODProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODAccountNumber"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("ODAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODDisplayName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("ODDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("ODBatchId"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("ODBatchId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODTransId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("ODTransId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODVoucherNumber"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("ODVoucherNumber"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODTranType"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("ODTranType"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODTransferMode"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("ODTransferMode"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("ODOrgId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("ODOrgId"));
		      
		  } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}



public static void VerifyODClosureAmount_Batch(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/OD_CLOSURE_BATCH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("ODTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("ODTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("ODTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyODClosureAmountType_Batch(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/OD_CLOSURE_BATCH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("ODAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("ODAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("ODAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyODClosureGLCode_Batch(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/OD_CLOSURE_BATCH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("ODGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("ODGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("ODGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  
public static WebDriver VerifyDLClosure_Batch(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/DL_CLOSURE_BATCH.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("DLProductName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("DLProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLAccountNumber"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("DLAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLDisplayName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("DLDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("DLBatchId"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("DLBatchId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("DLTransId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("DLTransId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("DLVoucherNumber"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("DLVoucherNumber"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("DLTranType"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("DLTranType"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("DLTransferMode"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("DLTransferMode"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("DLOrgId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("DLOrgId"));
		      
		  } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}



 public static void VerifyDLClosureAmount_Batch(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/DL_CLOSURE_BATCH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("DLTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("DLTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("DLTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
 public static void VerifyDLClosureAmountType_Batch(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
      Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/DL_CLOSURE_BATCH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
      List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("DLAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("DLAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("DLAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyDLClosureGLCode_Batch(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/DL_CLOSURE_BATCH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("DLGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("DLGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("DLGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  
public static WebDriver VerifyGLClosure_Batch(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	  WebElement element=null;
	  String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	 System.out.println("VERIFY SUMMARY METHOD");
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
	     
	     InputStream input = new FileInputStream("./DataFiles/GL_CLOSURE_BATCH.properties");
	     prop.load(input);
	     
	     
	     
	     
	     if(Actual_Value.equals(prop.getProperty("GLProductName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("GLProductName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLAccountNumber"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("GLAccountNumber"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLDisplayName"))) {
	      
	       Common.print(Actual_Value,prop.getProperty("GLDisplayName"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("GLBatchId"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("ODBatchId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("GLTransId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("GLTransId"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("GLVoucherNumber"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("GLVoucherNumber"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("GLTranType"))) {
		      
	       Common.print(Actual_Value,prop.getProperty("GLTranType"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("GLTransferMode"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("GLTransferMode"));
		      
		 }else if(Actual_Value.equals(prop.getProperty("GLOrgId"))) {
		      
		   Common.print(Actual_Value,prop.getProperty("GLOrgId"));
		      
		  } else {
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
	 
	 
	 
	 
	 return driver;
	 
	}



public static void VerifyGLClosureAmount_Batch(WebDriver driver) throws IOException {
	   
	   System.out.println("VERIFY AMOUNTS");
	   
	   WebElement table = driver.findElement(By.id("tblCustList"));
     List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	   NoOfRows=listOfRows.size()-1;
	   System.out.println("Rows: "+NoOfRows);
	   Properties prop=new Properties();
	   InputStream input = new FileInputStream("./DataFiles/GL_CLOSURE_BATCH.properties");
	    prop.load(input);
	   
	for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	     
	   	 System.out.println("GLTransAmount"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText());

	         if(prop.getProperty("GLTransAmount"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText())){
	      
	            System.out.println("Equal");
	            Driver.tcFlag = "PASS";
	            Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("GLTransAmount"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[9]")).getText(); 
	            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	         }
	   }
}
public static void VerifyGLClosureAmountType_Batch(WebDriver driver) throws IOException {
		  
		 
	  System.out.println("VERIFY AMOUNT TYPES");
    Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/GL_CLOSURE_BATCH.properties");
	  prop.load(input);
	  WebElement table = driver.findElement(By.id("tblCustList"));
    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	  NoOfRows=listOfRows.size()-1;
	  System.out.println("Rows: "+NoOfRows);

		    for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   
	          System.out.println("GLAmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

		           if(prop.getProperty("GLAmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
		    
		              System.out.println("Equal");
		              Driver.tcFlag = "PASS";
		              Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GLAmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
		              Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		           }
		     }
		   
	}  
public static void VerifyGLClosureGLCode_Batch(WebDriver driver) throws IOException {
		  
		 
		 System.out.println("VERIFY GLCODES");

		  Properties prop=new Properties();
		  InputStream input = new FileInputStream("./DataFiles/GL_CLOSURE_BATCH.properties");
		  prop.load(input);
		  WebElement table = driver.findElement(By.id("tblCustList"));
        List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
		  NoOfRows=listOfRows.size()-1;
		  System.out.println("Rows: "+NoOfRows);

	for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
		   
		   System.out.println("GLGlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

		       if(prop.getProperty("GLGlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
		    
		            System.out.println("Equal");
		            Driver.tcFlag = "PASS";
		            Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("GLGlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
		            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
		    
		        }
		  }
		   
	}  


public static void verifySummaryData(WebDriver driver, String locatorType, String propertyValue, String testData) throws SQLException, InterruptedException{
	
	//String baseURL = "http://121.242.120.119:8086/BeaconProQC/ProductForms/ProductAccountSummaryViewForm.aspx?request=7dZyf1EZz44pyMb08zdJ56gwbyI+lAIusiOl+lCto5sMvZ10K0aURh4p99f0YJFjHKu5Jz31aFpVz1d31wDwxf7/LA/EEqqo";
	String TransID = "";
	Connection con;
	Statement stmt1;
	String sql1;
	ResultSet rs1;
	int rowCounter = 0;
	int indexCounter = 0;
	String comment = "";
	
	parenttry: try{
		
		//driver.get(baseURL);
		//Thread.sleep(5000);
		
		System.out.println("Cash credit renewal summary");
		//WebElement AllOthercase = driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]"));
		if (testData=="Cash Credit Renewal OD BATCH")
		{
			System.out.println("Cash credit renewal summary");
		}
		else
		{
		new WebDriverWait(driver, 60).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")))));
		Thread.sleep(1000);
		}
		
		for(int i=0; i<60; i++){
			try{
				driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]"));
				break;
			}catch(Exception e1){
				Thread.sleep(1000);
			}			
		}
		
		
		
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]"))));
		TransID = driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
		System.out.println(TransID);
		
		if(TransID == ""){ // If TransID is blank then come out
			Driver.tcFlag =  "FAIL";
			Driver.comment = "Either TransID is blank or it is not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			break parenttry;
		}else{ // TransID if condition ends and else condition starts
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//String UserName = "sa";
			//String Password = "Speridian1" ;
			//String Url = "jdbc:sqlserver://192.168.1.87:1433;DatabaseName=BeaconProQC";

			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//con = DriverManager.getConnection(Url,UserName,Password);
			con=(Connection) Common.DatabaseConnector();
			if (con != null){
				
				sql1 = "select ProductName,AcNo, AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,RespBranchID from QaFnGetSummaryDetails (" + TransID + ") ";
				System.out.println(sql1);
				stmt1 = con.createStatement();
				rs1 = stmt1.executeQuery(sql1);
				
				LinkedHashMap<String,  String> summaryReportDB = new LinkedHashMap<String,String>();
				LinkedHashMap<String,  String> summaryReportAPP = new LinkedHashMap<String,String>();
				while(rs1.next()){
					rowCounter = rowCounter + 1;
				}
				
				if (rowCounter == 0){
					Driver.tcFlag = "FAIL";
					Driver.comment = "Database has returned 0 records for TransID: "  + TransID;
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					break parenttry;
				}
				
				System.out.println("Number of Records From Database: " + rowCounter);
				List<WebElement> rows = driver.findElements(By.xpath(propertyValue));
				
				/*if ((rows.size()) < 3){
					Driver.tcFlag = "FAIL";
					Driver.comment = "Application did not display any records";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					break parenttry;
				}*/
				
				//indexCounter = rows.size() -  3;
				
				if (rowCounter == (rows.size() -1)){
					indexCounter = rows.size() - 1;
				}else if (rowCounter == (rows.size() -2)) {
					indexCounter = rows.size() - 2;
				}else if (rowCounter == (rows.size() -3)){
					indexCounter = rows.size() - 3;
				}else if (rowCounter == (rows.size() -4)){
					indexCounter = rows.size() - 4;
				}
				
				System.out.println("Actual Number of Rows From Application: " + rows.size());
				System.out.println("Rows From Application: " + indexCounter);
				rs1.close();
				String tempFlag = "TRUE";
				if (rowCounter == indexCounter){
					
					for(int i=1; i<= indexCounter; i++){
						int rowIndex = i+1;
						
						String productNameApp = driver.findElement(By.xpath(propertyValue + "[" + rowIndex + "]/td[2]")).getText().trim();
						String acnoApp = driver.findElement(By.xpath(propertyValue + "[" + rowIndex + "]/td[3]")).getText().trim();
					//	String displayNameApp = driver.findElement(By.xpath(propertyValue + "[" + rowIndex + "]/td[4]")).getText().trim();
						String batchIdApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[5]")).getText().trim();
						String transIdApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[6]")).getText().trim();
						String voucherNoApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[7]")).getText().trim();
						String crdrApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[8]")).getText().trim();
						String amountApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[9]")).getText().trim();
						String amounttypeApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[10]")).getText().trim();
						String accodeApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[11]")).getText().trim();
						String tmodeApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[12]")).getText().trim();
						String branchIdApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[13]")).getText().trim();
						
						summaryReportAPP.put("productName" + i, productNameApp );
						summaryReportAPP.put("acno" + i, acnoApp);
					//	summaryReportAPP.put("displayName" + i, displayNameApp);
						summaryReportAPP.put("batchId" + i, batchIdApp);
						summaryReportAPP.put("transId" + i, transIdApp);
						summaryReportAPP.put("voucherNo" + i, voucherNoApp);
						summaryReportAPP.put("crdr" + i, crdrApp);
						summaryReportAPP.put("amount" + i, amountApp);
						summaryReportAPP.put("amounttype" + i, amounttypeApp);
						summaryReportAPP.put("accode" + i, accodeApp);
						summaryReportAPP.put("tmode" + i, tmodeApp);
						summaryReportAPP.put("branchId" + i, branchIdApp);

											
						sql1 = "select ProductName,AcNo, AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,RespBranchID from QaFnGetSummaryDetails (" + TransID+ ") Where VoucherNo='" + voucherNoApp + "' AND GLAcCode = '" + accodeApp + "' AND AmtTypeText = '" + amounttypeApp + "' ";
						rs1 = stmt1.executeQuery(sql1);
						int tempCounter = 0;
						
						
						while(rs1.next()){
							tempCounter = tempCounter + 1;						
							summaryReportDB.put("productName" + i, rs1.getString("ProductName").trim());
							summaryReportDB.put("acno" + i, rs1.getString("AcNo").trim());
					//		summaryReportDB.put("displayName" + i, rs1.getString("AcDisplayName").trim());
							summaryReportDB.put("batchId" + i,rs1.getString("BatchID").trim() );
							summaryReportDB.put("transId" + i, rs1.getString("TransID").trim());
							summaryReportDB.put("voucherNo" + i, rs1.getString("VoucherNo").trim());
							summaryReportDB.put("crdr" + i, rs1.getString("CrorDr").trim());
							summaryReportDB.put("amount" + i, rs1.getString("TrnAmount").trim());
							summaryReportDB.put("amounttype" + i, rs1.getString("AmtTypeText").trim());
							summaryReportDB.put("accode" + i, rs1.getString("GLAcCode").trim());
							summaryReportDB.put("tmode" + i, rs1.getString("TrnMode").trim());
							summaryReportDB.put("branchId" + i,rs1.getString("RespBranchID").trim() );
							
							
							
						}
						if (tempCounter == 0){
							
							tempFlag = "FALSE";
						}
						
					} // End of for loop for Application
					
					for(int i=1; i<=indexCounter; i++){
						comment = comment + " Product Name:        " + "Expected Value: " + summaryReportDB.get("productName" + i) + " Actual Value: " + summaryReportAPP.get("productName" + i) + "<br>" +
											"Account No:           " + "Expected Value: " + summaryReportDB.get("acno" + i)        + " Actual Value: " + summaryReportAPP.get("acno" + i) + "<br>" +
									//		"Account Display Name: " + "Expected Value: " + summaryReportDB.get("displayName" +i)  + " Actual Value: " + summaryReportAPP.get("displayName" + i) + "<br>" +
											"Batch ID:             " + "Expected Value: " + summaryReportDB.get("batchId" + i)     + " Actual Value: " + summaryReportAPP.get("batchId" + i) + "<br>" +
											"Trans ID:             " + "Expected Value: " + summaryReportDB.get("transId" + i)     + " Actual Value: " + summaryReportAPP.get("transId" + i) + "<br>" +
											"Voucher No:           " + "Expected Value: " + summaryReportDB.get("voucherNo" + i)   + " Actual Value: " + summaryReportAPP.get("voucherNo" + i) + "<br>" +
											"Cr/Dr:                " + "Expected Value: " + summaryReportDB.get("crdr" + i)        + " Actual Value: " + summaryReportAPP.get("crdr" + i) + "<br>" +
											"Amount:               " + "Expected Value: " + summaryReportDB.get("amount" + i)      + " Actual Value: " + summaryReportAPP.get("amount" + i) + "<br>" +
											"Amount Type:          " + "Expected Value: " + summaryReportDB.get("amounttype" + i)  + " Actual Value: " + summaryReportAPP.get("amounttype" + i) + "<br>" +
											"Account Code:         " + "Expected Value: " + summaryReportDB.get("accode" + i)      + " Actual Value: " + summaryReportAPP.get("accode" + i) + "<br>" +
											"Trans Mode:           " + "Expected Value: " + summaryReportDB.get("tmode" + i)       + " Actual Value: " + summaryReportAPP.get("tmode" + i) + "<br>" +
											"Branch ID:            " + "Expected Value: " + summaryReportDB.get("branchId" + i)    + " Actual Value: " + summaryReportAPP.get("branchId" + i) + "<br><br><br>" ;
											
											
					}
					
					
					
					System.out.println(comment);
					if (summaryReportDB.equals(summaryReportAPP)){
						Driver.tcFlag = "PASS";
						Driver.comment = "Pass" + " # " + comment;
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
						
					}else{
						Driver.tcFlag =  "FAIL";
						Driver.comment = comment;
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
						break parenttry;
					}
					rs1.close();
					
					sql1 = "select TrnAmount from QaFnGetSummaryDetails (" + TransID + ") Where CrorDr = 'Cr'";
					rs1 = stmt1.executeQuery(sql1);
					float creditAmount = 0;
					while(rs1.next()){
						creditAmount = creditAmount + Float.valueOf(rs1.getString(1));
					}
					rs1.close();
					sql1 = "select TrnAmount from QaFnGetSummaryDetails (" + TransID + ") Where CrorDr = 'Dr'";
					rs1 = stmt1.executeQuery(sql1);
					float debitAmount = 0;
					while(rs1.next()){
						debitAmount = debitAmount + Float.valueOf(rs1.getString(1));
					}
					rs1.close();
					
					
					Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/GL_RENEWAL_BATCH.properties");
				      prop.setProperty("GLTransId", String.valueOf(TransID));
				      
				      
										
					prop.setProperty("TotalAmount", (creditAmount-debitAmount)+""); 
					System.out.println("Total Credit Amount: " + creditAmount);
					System.out.println("Total Debit Amount: " + debitAmount);
					System.out.println("Total Amount: " + (creditAmount - debitAmount));
					
					prop.store(fos, "Done");
					 fos.close();
					
				}else{
					Driver.tcFlag =  "FAIL";
					Driver.comment = "There is a mismatch in the number of records displayed on the application screen against number of records returned by database";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					break parenttry;
				}
				
				
			}else{ // connection is not null if condition ends and else condition starts
				
				Driver.tcFlag = "FAIL";
				Driver.comment = "Did not connect to database";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				break parenttry;
				
			} // Else condition for connection is not null ends
			
		} // TransID else condition ends
		
	}catch(Exception e){
		e.printStackTrace();
		Driver.tcFlag = "FAIL";
		Driver.comment = "Did not connect to databasse";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		
	}
	
	
}

public static void verifyDayEndProcessName(WebDriver driver, String locatorType, String propertyValue, String testData) throws SQLException, InterruptedException{
    
	   System.out.println("Entered into method");
	   Connection con;
	   Statement stmt1;
	   String sql1;
	   ResultSet rs1;
	   int rowCounter = 0;
	   int indexCounter = 0;
	   String comment = "";
	    
	    parenttry: try{
	          
	                con=(Connection) Common.DatabaseConnector();
	                if (con != null){
	                	
	                	
	                    sql1 = "Select ProcessName from DayendProcessList where BranchID=102 and ProcessTime=2 order by priority";
	                    System.out.println("1");
	                    stmt1 = con.createStatement(); 
	                    rs1= stmt1.executeQuery(sql1);
	                    
	                 
	                      
	                      LinkedHashMap<String,  String> ProcessListDB = new LinkedHashMap<String,String>();
	                      LinkedHashMap<String,  String> ProcessListAPP = new LinkedHashMap<String,String>();
	                      while(rs1.next()){
	                            rowCounter = rowCounter + 1;
	                      }
	                      
	                      if (rowCounter == 0){
	                            Driver.tcFlag = "FAIL";
	                            Driver.comment = "Database has returned 0 records for DayEnd";
	                            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	                            break parenttry;
	                      }
	                      
	                      System.out.println("Number of Records From Database: " + rowCounter);
	                      List<WebElement> rows = driver.findElements(By.xpath(propertyValue));
	                      
	                      if (rowCounter == (rows.size() -1)){
	                            indexCounter = rows.size() - 1;
	                      }else if (rowCounter == (rows.size() -2)) {
	                            indexCounter = rows.size() - 2;
	                      }else if (rowCounter == (rows.size() -3)){
	                            indexCounter = rows.size() - 3;
	                      }
	                      
	                      System.out.println("Rows From Application: " + indexCounter);
	                      rs1.close();
	                      String tempFlag = "TRUE";
	                      if (rowCounter == indexCounter){
	                            
	                            for(int i=1; i<= indexCounter; i++){
	                                  int rowIndex = i+1;
	                                  
	                                String processnameApp = driver.findElement(By.xpath(propertyValue + "[" + rowIndex + "]/td[2]")).getText().trim();
	                                  
	                                  
	                                ProcessListAPP.put("processName" + i, processnameApp );
	                                  

	                            }                                  
	                                  sql1 = "Select ProcessName from DayendProcessList where BranchID=102 and ProcessTime=2 order by priority";
	                                  rs1 = stmt1.executeQuery(sql1);
	                                  System.out.println("2");
	                                  int tempCounter = 0;
	                                  
	                                  
	                                  while(rs1.next()){
	                                        tempCounter = tempCounter + 1;  
	                                       ProcessListDB.put("processName" + tempCounter, rs1.getString("ProcessName").trim());
	                                        
	                                  }
	                                  System.out.println("TempCounter"+tempCounter);
	                                  if (tempCounter == 0){
	                                        
	                                        tempFlag = "FALSE";
	                                  }
	                                  
	                          
	                            
	                            for(int i=1; i<=indexCounter; i++){
	                                  comment = comment + " Process Name:        " + "Expected Value: " + ProcessListDB.get("processName" + i)+"  "+ " Actual Value: " + ProcessListAPP.get("processName" + i) + "<br>";
	                                                               
	                                                           
	                            }
	                            System.out.println(comment);   
	                            
	                            
	                            
	                            
	                           
	                            if (ProcessListDB.equals(ProcessListAPP)){
	                            	System.out.println("Hello Anushka");
	                            	System.out.println("Db and application records are equal");
	                                  Driver.tcFlag = "PASS";
	                                  Driver.comment = "Pass" + " # " + comment;
	                                  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	                                  
	                            }else{
	                            		System.out.println("Hello Trisha");
	                                  Driver.tcFlag =  "FAIL";
	                                  Driver.comment = comment;
	                                  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);  
	                                  break parenttry;
	                            }
	                            rs1.close();
	                            
	                           
	                            
	                            
	                            
	                            
	                      }/* rowcounter=indexcounter*/else{
	                            Driver.tcFlag =  "FAIL";
	                            Driver.comment = "There is a mismatch in the number of records displayed on the application screen against number of records returned by database";
	                            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	                            break parenttry;
	                      }
	                      
	                      
	                }else{ // connection is not null if condition ends and else condition starts
	                      
	                      Driver.tcFlag = "FAIL";
	                      Driver.comment = "Did not connect to database";
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	                      break parenttry;
	                      
	                } // Else condition for connection is not null ends
	                
	         
	          
	    }catch(Exception e){
	          Driver.tcFlag = "FAIL";
	          Driver.comment = "Did not connect to databasse";
	          Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	          
	    }
	    
	    
	}

public static void verifyDayEndAdminProcessName(WebDriver driver, String locatorType, String propertyValue, String testData) throws SQLException, InterruptedException{
    
	   System.out.println("Entered into method");
	   Connection con;
	   Statement stmt1;
	   String sql1;
	   ResultSet rs1;
	   int rowCounter = 0;
	   int indexCounter = 0;
	   String comment = "";
	    
	    parenttry: try{
	          
	                con=(Connection) Common.DatabaseConnector();
	                if (con != null){
	                	
		  				 

	                 String xpathProp=".//*[@id='ctl00_CPH1_DEPDC1_dtEODDate_txt']";
	                 String TransDate= driver.findElement(By.xpath(xpathProp)).getAttribute("value");
	  			     System.out.println("Date from Application "+TransDate);
	  				 
	  				 Properties prop=new Properties();
	                 FileOutputStream fos = new FileOutputStream("./DataFiles/DayEndData.properties");
	                 
	                 prop.setProperty("Admin_Date",TransDate);
	                 
	                 prop.store(fos, "Done");
	                 fos.close();
	                	
	                	
	                    sql1 = "Select ProcessName from DayendProcessList where BranchID=100 and ProcessTime=2 and IsAssociatedProcess=0  order by Priority;";
	                    stmt1 = con.createStatement(); 
	                    rs1= stmt1.executeQuery(sql1);
	                    
	                 
	                      
	                      LinkedHashMap<String,  String> ProcessListDB = new LinkedHashMap<String,String>();
	                      LinkedHashMap<String,  String> ProcessListAPP = new LinkedHashMap<String,String>();
	                      while(rs1.next()){
	                            rowCounter = rowCounter + 1;
	                      }
	                      
	                      if (rowCounter == 0){
	                            Driver.tcFlag = "FAIL";
	                            Driver.comment = "Database has returned 0 records for DayEnd";
	                            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	                            break parenttry;
	                      }
	                      
	                      System.out.println("Number of Records From Database: " + rowCounter);
	                      List<WebElement> rows = driver.findElements(By.xpath(propertyValue));
	                      
	                      if (rowCounter == (rows.size() -1)){
	                            indexCounter = rows.size() - 1;
	                      }else if (rowCounter == (rows.size() -2)) {
	                            indexCounter = rows.size() - 2;
	                      }else if (rowCounter == (rows.size() -3)){
	                            indexCounter = rows.size() - 3;
	                      }
	                      
	                      System.out.println("Rows From Application: " + indexCounter);
	                      rs1.close();
	                      String tempFlag = "TRUE";
	                      if (rowCounter == indexCounter){
	                            
	                            for(int i=1; i<= indexCounter; i++){
	                                  int rowIndex = i+1;
	                                  
	                                String processnameApp = driver.findElement(By.xpath(propertyValue + "[" + rowIndex + "]/td[2]")).getText().trim();
	                                  
	                                  
	                                ProcessListAPP.put("processName" + i, processnameApp );
	                                  

	                            }                                  
	                                  sql1 = "Select ProcessName from DayendProcessList where BranchID=100 and ProcessTime=2 and IsAssociatedProcess=0  order by Priority;";
	                                  rs1 = stmt1.executeQuery(sql1);
	                                  int tempCounter = 0;
	                                  
	                                  
	                                  while(rs1.next()){
	                                        tempCounter = tempCounter + 1;  
	                                       ProcessListDB.put("processName" + tempCounter, rs1.getString("ProcessName").trim());
	                                        
	                                  }
	                                  System.out.println("TempCounter"+tempCounter);
	                                  if (tempCounter == 0){
	                                        
	                                        tempFlag = "FALSE";
	                                  }
	                                  
	                          
	                            
	                            for(int i=1; i<=indexCounter; i++){
	                                  comment = comment + " Process Name:        " + "Expected Value: " + ProcessListDB.get("processName" + i)+"  "+ " Actual Value: " + ProcessListAPP.get("processName" + i) + "<br>";
	                                                               
	                                                           
	                            }
	                            System.out.println(comment);   
	                            
	                            
	                            
	                            
	                           
	                            if (ProcessListDB.equals(ProcessListAPP)){
	                            	System.out.println("Hello Anushka");
	                            	System.out.println("Db and application records are equal");
	                                  Driver.tcFlag = "PASS";
	                                  Driver.comment = "Pass" + " # " + comment;
	                                  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	                                  
	                            }else{
	                            		System.out.println("Hello Trisha");
	                                  Driver.tcFlag =  "FAIL";
	                                  Driver.comment = comment;
	                                  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);  
	                                  break parenttry;
	                            }
	                            rs1.close();
	                            
	                           
	                            
	                            
	                            
	                            
	                      }/* rowcounter=indexcounter*/else{
	                            Driver.tcFlag =  "FAIL";
	                            Driver.comment = "There is a mismatch in the number of records displayed on the application screen against number of records returned by database";
	                            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	                            break parenttry;
	                      }
	                      
	                      
	                }else{ // connection is not null if condition ends and else condition starts
	                      
	                      Driver.tcFlag = "FAIL";
	                      Driver.comment = "Did not connect to database";
	                      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	                      break parenttry;
	                      
	                } // Else condition for connection is not null ends
	                
	         
	          
	    }catch(Exception e){
	          Driver.tcFlag = "FAIL";
	          Driver.comment = "Did not connect to databasse";
	          Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	          
	    }
	    
	    
	}
public static void verifySummaryData_Exceptions(WebDriver driver, String locatorType, String propertyValue, String testData) throws SQLException, InterruptedException{
	
	//String baseURL = "http://121.242.120.119:8086/BeaconProQC/ProductForms/ProductAccountSummaryViewForm.aspx?request=7dZyf1EZz44pyMb08zdJ56gwbyI+lAIusiOl+lCto5sMvZ10K0aURh4p99f0YJFjHKu5Jz31aFpVz1d31wDwxf7/LA/EEqqo";
	String TransID = "";
	Connection con;
	Statement stmt1;
	String sql1;
	ResultSet rs1;
	int rowCounter = 0;
	int indexCounter = 0;
	String comment = "";
	
	parenttry: try{
		
		//driver.get(baseURL);
		//Thread.sleep(5000);
		new WebDriverWait(driver, 60).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")))));
		Thread.sleep(1000);
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]"))));
		TransID = driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
		System.out.println(TransID);
		
		if(TransID == ""){ // If TransID is blank then come out
			Driver.tcFlag =  "FAIL";
			Driver.comment = "Either TransID is blank or it is not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			break parenttry;
		}else{ // TransID if condition ends and else condition starts
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//String UserName = "sa";
			//String Password = "Speridian1" ;
			//String Url = "jdbc:sqlserver://192.168.1.87:1433;DatabaseName=BeaconProQC";

			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//con = DriverManager.getConnection(Url,UserName,Password);
			con=(Connection) Common.DatabaseConnector();
			if (con != null){
				
				sql1 = "select BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,RespBranchID from QaFnGetSummaryDetails (" + TransID + ") ";
				System.out.println(sql1);
				stmt1 = con.createStatement();
				rs1 = stmt1.executeQuery(sql1);
				
				LinkedHashMap<String,  String> summaryReportDB = new LinkedHashMap<String,String>();
				LinkedHashMap<String,  String> summaryReportAPP = new LinkedHashMap<String,String>();
				while(rs1.next()){
					rowCounter = rowCounter + 1;
				}
				
				if (rowCounter == 0){
					Driver.tcFlag = "FAIL";
					Driver.comment = "Database has returned 0 records for TransID: "  + TransID;
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					break parenttry;
				}
				
				System.out.println("Number of Records From Database: " + rowCounter);
				List<WebElement> rows = driver.findElements(By.xpath(propertyValue));
				
				/*if ((rows.size()) < 3){
					Driver.tcFlag = "FAIL";
					Driver.comment = "Application did not display any records";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					break parenttry;
				}*/
				
				//indexCounter = rows.size() -  3;
				
				if (rowCounter == (rows.size() -1)){
					indexCounter = rows.size() - 1;
				}else if (rowCounter == (rows.size() -2)) {
					indexCounter = rows.size() - 2;
				}else if (rowCounter == (rows.size() -3)){
					indexCounter = rows.size() - 3;
				}else if (rowCounter == (rows.size() -4)){
					indexCounter = rows.size() - 4;
				}
				
				System.out.println("Actual Number of Rows From Application: " + rows.size());
				System.out.println("Rows From Application: " + indexCounter);
				rs1.close();
				String tempFlag = "TRUE";
				if (rowCounter == indexCounter){
					
					for(int i=1; i<= indexCounter; i++){
						int rowIndex = i+1;
						
						//String productNameApp = driver.findElement(By.xpath(propertyValue + "[" + rowIndex + "]/td[2]")).getText().trim();
						//String acnoApp = driver.findElement(By.xpath(propertyValue + "[" + rowIndex + "]/td[3]")).getText().trim();
						//String displayNameApp = driver.findElement(By.xpath(propertyValue + "[" + rowIndex + "]/td[4]")).getText().trim();
						String batchIdApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[5]")).getText().trim();
						String transIdApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[6]")).getText().trim();
						String voucherNoApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[7]")).getText().trim();
						String crdrApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[8]")).getText().trim();
						String amountApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[9]")).getText().trim();
						String amounttypeApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[10]")).getText().trim();
						String accodeApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[11]")).getText().trim();
						String tmodeApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[12]")).getText().trim();
						String branchIdApp = driver.findElement(By.xpath(propertyValue + "["  + rowIndex + "]/td[13]")).getText().trim();
						
						//summaryReportAPP.put("productName" + i, productNameApp );
						//summaryReportAPP.put("acno" + i, acnoApp);
						//summaryReportAPP.put("displayName" + i, displayNameApp);
						summaryReportAPP.put("batchId" + i, batchIdApp);
						summaryReportAPP.put("transId" + i, transIdApp);
						summaryReportAPP.put("voucherNo" + i, voucherNoApp);
						summaryReportAPP.put("crdr" + i, crdrApp);
						summaryReportAPP.put("amount" + i, amountApp);
						summaryReportAPP.put("amounttype" + i, amounttypeApp);
						summaryReportAPP.put("accode" + i, accodeApp);
						summaryReportAPP.put("tmode" + i, tmodeApp);
						summaryReportAPP.put("branchId" + i, branchIdApp);

											
						sql1 = "select BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,RespBranchID from QaFnGetSummaryDetails (" + TransID+ ") Where VoucherNo='" + voucherNoApp + "' AND GLAcCode = '" + accodeApp + "' AND AmtTypeText = '" + amounttypeApp + "' ";
						rs1 = stmt1.executeQuery(sql1);
						int tempCounter = 0;
						
						
						while(rs1.next()){
							tempCounter = tempCounter + 1;						
							//summaryReportDB.put("productName" + i, rs1.getString("ProductName").trim());
							//summaryReportDB.put("acno" + i, rs1.getString("AcNo").trim());
							//summaryReportDB.put("displayName" + i, rs1.getString("AcDisplayName").trim());
							summaryReportDB.put("batchId" + i,rs1.getString("BatchID").trim() );
							summaryReportDB.put("transId" + i, rs1.getString("TransID").trim());
							summaryReportDB.put("voucherNo" + i, rs1.getString("VoucherNo").trim());
							summaryReportDB.put("crdr" + i, rs1.getString("CrorDr").trim());
							summaryReportDB.put("amount" + i, rs1.getString("TrnAmount").trim());
							summaryReportDB.put("amounttype" + i, rs1.getString("AmtTypeText").trim());
							summaryReportDB.put("accode" + i, rs1.getString("GLAcCode").trim());
							summaryReportDB.put("tmode" + i, rs1.getString("TrnMode").trim());
							summaryReportDB.put("branchId" + i,rs1.getString("RespBranchID").trim() );
							
							
							
						}
						if (tempCounter == 0){
							
							tempFlag = "FALSE";
						}
						
					} // End of for loop for Application
					
					for(int i=1; i<=indexCounter; i++){
						comment = comment + //" Product Name:        " + "Expected Value: " + summaryReportDB.get("productName" + i) + " Actual Value: " + summaryReportAPP.get("productName" + i) + "<br>" +
											//"Account No:           " + "Expected Value: " + summaryReportDB.get("acno" + i)        + " Actual Value: " + summaryReportAPP.get("acno" + i) + "<br>" +
											//"Account Display Name: " + "Expected Value: " + summaryReportDB.get("displayName" +i)  + " Actual Value: " + summaryReportAPP.get("displayName" + i) + "<br>" +
											"Batch ID:             " + "Expected Value: " + summaryReportDB.get("batchId" + i)     + " Actual Value: " + summaryReportAPP.get("batchId" + i) + "<br>" +
											"Trans ID:             " + "Expected Value: " + summaryReportDB.get("transId" + i)     + " Actual Value: " + summaryReportAPP.get("transId" + i) + "<br>" +
											"Voucher No:           " + "Expected Value: " + summaryReportDB.get("voucherNo" + i)   + " Actual Value: " + summaryReportAPP.get("voucherNo" + i) + "<br>" +
											"Cr/Dr:                " + "Expected Value: " + summaryReportDB.get("crdr" + i)        + " Actual Value: " + summaryReportAPP.get("crdr" + i) + "<br>" +
											"Amount:               " + "Expected Value: " + summaryReportDB.get("amount" + i)      + " Actual Value: " + summaryReportAPP.get("amount" + i) + "<br>" +
											"Amount Type:          " + "Expected Value: " + summaryReportDB.get("amounttype" + i)  + " Actual Value: " + summaryReportAPP.get("amounttype" + i) + "<br>" +
											"Account Code:         " + "Expected Value: " + summaryReportDB.get("accode" + i)      + " Actual Value: " + summaryReportAPP.get("accode" + i) + "<br>" +
											"Trans Mode:           " + "Expected Value: " + summaryReportDB.get("tmode" + i)       + " Actual Value: " + summaryReportAPP.get("tmode" + i) + "<br>" +
											"Branch ID:            " + "Expected Value: " + summaryReportDB.get("branchId" + i)    + " Actual Value: " + summaryReportAPP.get("branchId" + i) + "<br><br><br>" ;
											
											
					}
					
					
					
					System.out.println(comment);
					if (summaryReportDB.equals(summaryReportAPP)){
						Driver.tcFlag = "PASS";
						Driver.comment = "Pass" + " # " + comment;
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
						
					}else{
						Driver.tcFlag =  "FAIL";
						Driver.comment = comment;
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
						break parenttry;
					}
					rs1.close();
					
					sql1 = "select TrnAmount from QaFnGetSummaryDetails (" + TransID + ") Where CrorDr = 'Cr'";
					rs1 = stmt1.executeQuery(sql1);
					float creditAmount = 0;
					while(rs1.next()){
						creditAmount = creditAmount + Float.valueOf(rs1.getString(1));
					}
					rs1.close();
					sql1 = "select TrnAmount from QaFnGetSummaryDetails (" + TransID + ") Where CrorDr = 'Dr'";
					rs1 = stmt1.executeQuery(sql1);
					float debitAmount = 0;
					while(rs1.next()){
						debitAmount = debitAmount + Float.valueOf(rs1.getString(1));
					}
					rs1.close();
					
					
					Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/GL_RENEWAL_BATCH.properties");
				      prop.setProperty("GLTransId", String.valueOf(TransID));
				      
				      
										
					prop.setProperty("TotalAmount", (creditAmount-debitAmount)+""); 
					System.out.println("Total Credit Amount: " + creditAmount);
					System.out.println("Total Debit Amount: " + debitAmount);
					System.out.println("Total Amount: " + (creditAmount - debitAmount));
					
					prop.store(fos, "Done");
					 fos.close();
					
				}else{
					Driver.tcFlag =  "FAIL";
					Driver.comment = "There is a mismatch in the number of records displayed on the application screen against number of records returned by database";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					break parenttry;
				}
				
				
			}else{ // connection is not null if condition ends and else condition starts
				
				Driver.tcFlag = "FAIL";
				Driver.comment = "Did not connect to database";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				break parenttry;
				
			} // Else condition for connection is not null ends
			
		} // TransID else condition ends
		
	}catch(Exception e){
		e.printStackTrace();
		Driver.tcFlag = "FAIL";
		Driver.comment = "Did not connect to databasse";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		
	}
	
	
}

}
