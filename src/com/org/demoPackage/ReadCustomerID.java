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
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ReadCustomerID {
	
	
public static void getCustomerIdForSB1(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
		
		  String CustID=null;
		  System.out.println("inside method");
		  Connection con=(Connection) Common.DatabaseConnector();
		  
		  if(con !=null) {
  
			  Statement stmt = con.createStatement();	
			  String Q_datefetch="exec spQAGetCustomerForAcOpeningSB"; 
			  ResultSet rs1= stmt.executeQuery(Q_datefetch);
			  String dbconflag = "FALSE";
			  int counter = 0;
			  while(rs1.next()) {
				  counter = counter + 1;
				  CustID=rs1.getString(1);
				  dbconflag = "TRUE";
      	
			  }
		
			  System.out.println("customer id "+CustID);
			  if (counter == 0) {
				  Driver.tcFlag = "FAIL";
				  Driver.comment = "Database did not return any records";
				  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  }else {
				  
				  try {
					  driver.findElement(By.xpath(propertyValue)).sendKeys(""+CustID);
					  
					  System.out.println("Fluent wait started");
					  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
								.withTimeout(15, TimeUnit.MINUTES) 	
								 .ignoring(NullPointerException.class)
				                 .ignoring(StaleElementReferenceException.class)
				                 .ignoring(NoSuchElementException.class)
				                 .ignoring(ElementNotVisibleException.class)
				                 .ignoring(WebDriverException.class)
								.pollingEvery(5, TimeUnit.MILLISECONDS);			
					  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_btnAddCustomer']")));
					  System.out.println("Fluent Wait Ended - Element found and to be in clickable state");
					  driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_btnAddCustomer']")).click();
					  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					  Driver.tcFlag = "PASS";
					  Driver.comment = "Pass"+" # "+"Customer ID: " +CustID;
					  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,   Driver.comment);	

				  }
				  catch (Exception e)
				  {
					  Driver.tcFlag = "FAIL";
					  Driver.comment = Driver.objectName + " is not displayed or not identified";
					  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);

	    	  
				  }
	      
				  try {  
	      
					  if (driver.findElement(By.xpath("html/body/div[3]/div[11]/div/button")).isDisplayed()==true) {
						  driver.findElement(By.xpath("html/body/div[3]/div[11]/div/button")).click();
						  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	      	
					  }
					  else if(driver.findElement(By.xpath(" html/body/div[4]/div[11]/div/button")).isDisplayed()==true) {
	      	
						  driver.findElement(By.xpath(" html/body/div[4]/div[11]/div/button")).click();
						  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	      	
					  }
					  else if(driver.findElement(By.xpath("html/body/div[5]/div[11]/div/button")).isDisplayed()==true) {
	      	
						  driver.findElement(By.xpath("html/body/div[5]/div[11]/div/button")).click();
						  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	      	
					  }
				  }
				  catch(Exception e){
	  	  
				  }
			  }
			
			  
			  
		  }else {
			  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database connection is not successfull";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
		  }
     
		
	} 


//===========================================================================================================================
//===========================================================================================================================
	
public static void getCustomerIdForSB2(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
	
	String CustID=null;
	System.out.println("inside method");
	Connection con=(Connection) Common.DatabaseConnector();
	if(con !=null) {

		Statement stmt = con.createStatement();	
   
    
    
		String Q_datefetch="select top 1 Cust_ID \r\n" + 
    		"from CustMaster \r\n" + 
    		"where Cust_ID not in(select Isnull(Cust_ID,0) from viAccMaster) and IsKYCCompleted=1 and Age < 50 and IsActive=1 and CustType_Id=1"; 
		ResultSet rs1= stmt.executeQuery(Q_datefetch);
		int counter = 0;
		while(rs1.next()) {
			counter = counter + 1;
			CustID=rs1.getString(1);
    	
		}
	
		System.out.println("customer id "+CustID);
		if (counter == 0) {
			Driver.tcFlag = "FAIL";
			Driver.comment = "Database did not return any records";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}else {
			try {
				driver.findElement(By.xpath(propertyValue)).sendKeys(""+CustID);
				driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_btnAddCustomer']")).click();
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass"+" # "+"Customer ID: " +CustID;
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,   Driver.comment);	

	        	}
	        	catch (Exception e)
	        	{
	        		Driver.tcFlag = "FAIL";
	        		Driver.comment = Driver.objectName + " is not displayed or not identified";
	        		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);

	      	  
	        	}
	    
	   
			try {  
	    
				if (driver.findElement(By.xpath("html/body/div[3]/div[11]/div/button")).isDisplayed()==true) {
					driver.findElement(By.xpath("html/body/div[3]/div[11]/div/button")).click();
					driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	    	
				}
				else if(driver.findElement(By.xpath(" html/body/div[4]/div[11]/div/button")).isDisplayed()==true) {
	    	
					driver.findElement(By.xpath(" html/body/div[4]/div[11]/div/button")).click();
					driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	    	
				}
				else if(driver.findElement(By.xpath("html/body/div[5]/div[11]/div/button")).isDisplayed()==true) {
	    	
					driver.findElement(By.xpath("html/body/div[5]/div[11]/div/button")).click();
					driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	    	
				}
			}
			catch(Exception e){
		  
			}			
		}
    

	}else {
		 Driver.tcFlag = "FAIL";
		 Driver.comment = "Database connection is not successfull";
		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	}
	
} 
   
//===========================================================================================================================
//===========================================================================================================================
	
	public static void getCustomerId(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
		
		String CustID=null;
		System.out.println("inside method");
		Connection con=(Connection) Common.DatabaseConnector();
		if(con !=null) {
       
			Statement stmt = con.createStatement();	
        
			String Q_datefetch="SELECT DISTINCT Cust_ID FROM CustMaster where IsKYCCompleted=1 \r\n" + 
        		"and Age < 50 and LEN(Cust_id)>4 and Branch_ID =102 and CustType_ID=1"; 
			ResultSet rs1= stmt.executeQuery(Q_datefetch);
			int counter = 0;
			
        
			while(rs1.next()) {
				counter = counter + 1;
				CustID=rs1.getString(1);
        	
			}
		
			
			
			if (counter == 0) {
				Driver.tcFlag = "FAIL";
				Driver.comment = "Database did not return any records";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			}else {
				
				try {
				
				System.out.println("customer id "+CustID);
				driver.findElement(By.xpath(propertyValue)).sendKeys(""+CustID);
		        
				driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_btnAddCustomer']")).click();
	            Driver.tcFlag = "PASS";
				Driver.comment = "Pass"+" # "+"Customer ID: " +CustID;
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,   Driver.comment);	
				}catch(Exception e) {
					
					Driver.tcFlag = "FAIL";
					Driver.comment = "Required element is not displayed or identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
					
				}

				
			}
        
		
		} else {
			Driver.tcFlag = "FAIL";
			Driver.comment = "Database connection is not successfull";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
		}
       
	}

	//===========================================================================================================================
	//===========================================================================================================================

 public static void getCustomerIdForGoldLoan(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
		
	 	String CustID=null;
		Connection con=(Connection) Common.DatabaseConnector();
		if(con !=null) {
      
       
			Statement stmt = con.createStatement();	
        
			String Q_datefetch="SELECT top 10 m.Cust_ID \r\n" + 
					"        		FROM CustMaster m \r\n" + 
					"        		JOIN viAccMaster a ON m.Cust_ID = a.Cust_ID\r\n" + 
					"        		WHERE m.Cust_ID not in (select Cust_ID from viaccmaster where ProductID IN ( select ProductID	from Products where IsLoan=1)) \r\n" + 
					"				AND a.productid in(1001)\r\n" +	
					"        		AND m.IsKYCCompleted = 1 \r\n" + 
					"        		AND m.Branch_ID = 102 and m.CustType_ID=1"; 
        
			ResultSet rs1= stmt.executeQuery(Q_datefetch);
			int counter = 0;
			while(rs1.next()) {
				counter = counter + 1;
				CustID=rs1.getString(1);
        	
			}
			
		
			
			
			if (counter == 0) {
				Driver.tcFlag = "FAIL";
				Driver.comment = "Database did not return any records";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);				
				
			}else {
				
				System.out.println("customer id "+CustID);
				driver.findElement(By.xpath(propertyValue)).sendKeys(""+CustID);
		        
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	       
				try {
					driver.findElement(By.xpath("html/body/div[3]/div[3]/div/button")).click();
					driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

				}catch(Exception e) {
	    	   
	            }
	       try {
				System.out.println("customer Id entered");
	            driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_LAI_btnAddCustomer1']")).click();
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass"+" # "+"Customer ID: " +CustID;
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	       }catch(Exception e) {
	    	   
	    	    Driver.tcFlag = "FAIL";
				Driver.comment = "Required element is not displayed or identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	       }
				
			}

        
       
			}else {
				Driver.tcFlag = "FAIL";
				Driver.comment = "Database connection is not successfull";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);				
			}
		   
 }
 
	//===========================================================================================================================
	//===========================================================================================================================

 public static void getCustomerIdForSL(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException, Exception {	
		
	 	String CustID=null;
		Connection con=(Connection) Common.DatabaseConnector();
		if(con !=null) {
	  
	   
	    Statement stmt = con.createStatement();	
	    
	    String Q_datefetch="SELECT top 10 m.Cust_ID \r\n" + 
	    		"        		FROM CustMaster m \r\n" + 
	    		"        		JOIN viAccMaster a ON m.Cust_ID = a.Cust_ID\r\n" + 
	    		"        		WHERE m.Cust_ID not in (select Cust_ID from viaccmaster where ProductID IN (   select ProductID					from Products where IsLoan=1)) \r\n" + 
	    		"        		AND m.IsKYCCompleted = 1  And a.ProductID=1001  \r\n" + 
	    		"        		AND m.Branch_ID = 102 and m.CustType_ID=1"; 
	    
	    ResultSet rs1= stmt.executeQuery(Q_datefetch);
	    int counter = 0;
	    while(rs1.next()) {
	    	counter = counter + 1;
	    	CustID=rs1.getString(1);
	    	
	    }
		
	    
	    if (counter == 0) {
			Driver.tcFlag = "FAIL";
			Driver.comment = "Database did not return any records";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);				
	    }else {
	    	System.out.println("customer id "+CustID);
		    driver.findElement(By.xpath(propertyValue)).sendKeys(""+CustID);
		    try {
		    	//---------------- Fluent wait --------------------//
		    	System.out.println("Fluent wait started against customer add button");
				Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)							
						.withTimeout(10, TimeUnit.MINUTES) 	
						 .ignoring(NullPointerException.class)
		                 .ignoring(StaleElementReferenceException.class)
		                 .ignoring(NoSuchElementException.class)
		                 .ignoring(ElementNotVisibleException.class)
		                 .ignoring(WebDriverException.class)
						.pollingEvery(5, TimeUnit.MILLISECONDS);			
				wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_ucProductAccInfo_btnAddCustomer']")));
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				System.out.println("Fluent Wait Ended - Add button found and to be in clickable state");
				//---------------- Fluent wait --------------------//
				
		    	driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_ucProductAccInfo_btnAddCustomer']")).click();
			    Thread.sleep(3000);
			    //FLUENT WAIT
			    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
						.withTimeout(10, TimeUnit.MINUTES) 	
						 .ignoring(NullPointerException.class)
		                 .ignoring(StaleElementReferenceException.class)
		                 .ignoring(NoSuchElementException.class)
		                 .ignoring(ElementNotVisibleException.class)
		                 .ignoring(WebDriverException.class)
						.pollingEvery(5, TimeUnit.MILLISECONDS);			
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TB2_tp1_lstProductDetails_ctrl0_ucGeneralAccountInfo_txtAcOpeningAmount_txt']")));
				System.out.println("Ac opening amount field is now clickable");
			    driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TB2_tp1_lstProductDetails_ctrl0_ucGeneralAccountInfo_txtAcOpeningAmount_txt']")).clear();
			    Thread.sleep(1000);
			    driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TB2_tp1_lstProductDetails_ctrl0_ucGeneralAccountInfo_txtAcOpeningAmount_txt']")).sendKeys("3000");
			    Thread.sleep(1000);
			    System.out.println("entered");
			    
			    Driver.tcFlag = "PASS";
				Driver.comment = "Pass"+" # "+"Customer ID: " +CustID;
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);			    	
		    }catch(Exception e) {
				Driver.tcFlag = "FAIL";
				Driver.comment = "Required object is not displayed or identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);									    	
		    }
		    
	    	
	    }
	    
	   
		}else {
			Driver.tcFlag = "FAIL";
			Driver.comment = "Database connection is not successfull";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);							
		}
		   
}
 
	//===========================================================================================================================
	//===========================================================================================================================

 public static void getCustomerIdForLoan(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
		
	 	String CustID=null;
		Connection con=(Connection) Common.DatabaseConnector();
		if(con !=null) {
   
    
			Statement stmt = con.createStatement();	
     
			String Q_datefetch="SELECT top 10 m.Cust_ID \r\n" + 
					"        		FROM CustMaster m \r\n" + 
					"        		JOIN viAccMaster a ON m.Cust_ID = a.Cust_ID\r\n" + 
					"        		WHERE m.Cust_ID not in (select Cust_ID from viaccmaster where ProductID IN (   select ProductID					from Products where IsLoan=1)) \r\n" + 
					"        		AND m.IsKYCCompleted = 1  And a.ProductID=1001  \r\n" + 
					"        		AND m.Branch_ID = 102 and m.CustType_ID=1"; 
     
			ResultSet rs1= stmt.executeQuery(Q_datefetch);
			int counter = 0;
			while(rs1.next()) {
				counter = counter + 1;
				CustID=rs1.getString(1);
     	
			}
		
			System.out.println("customer id "+CustID);
			
			if (counter == 0) {
				Driver.tcFlag = "FAIL";
				Driver.comment = "Database did not return any records";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);								
			}else {
				try {
					driver.findElement(By.xpath(propertyValue)).sendKeys(""+CustID);
				     
					driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_LAI_btnAddCustomer1']")).click();

					Driver.tcFlag = "PASS";
					Driver.comment = "Pass"+" # "+"Customer ID: " +CustID;
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
					
				}catch(Exception e) {
					Driver.tcFlag = "FAIL";
					Driver.comment = "Required object is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);									    						
				}
				
				
			}
     
    
		}else {
			Driver.tcFlag = "FAIL";
			Driver.comment = "Database connection is not successfull";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);										
		}
		   
}
	//===========================================================================================================================
	//===========================================================================================================================

 public static void getCustomerIdForOtherLoan1(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
		
	 	String CustID=null;
		Connection con=(Connection) Common.DatabaseConnector();
		if(con !=null) {

 
		Statement stmt = con.createStatement();	
  
		String Q_datefetch="SELECT top 10 m.Cust_ID \r\n" + 
				"        		FROM CustMaster m \r\n" + 
				"        		JOIN viAccMaster a ON m.Cust_ID = a.Cust_ID\r\n" + 
				"        		WHERE m.Cust_ID not in (select Cust_ID from viaccmaster where ProductID IN (select ProductID					from Products where IsLoan=1)) \r\n" + 
				"        		AND m.IsKYCCompleted = 1  And a.ProductID=1001 AND a.isclosed=0 \r\n" + 
				"        		AND m.Branch_ID = 102 and m.CustType_ID=1 and a.recordstatus=3" +
				"               order by m.Cust_ID                                            "	; 
  
		ResultSet rs1= stmt.executeQuery(Q_datefetch);
		int counter = 0;
		while(rs1.next()) {
			counter = counter + 1;
			CustID=rs1.getString(1);
  	
		}
		
		
		
		if (counter == 0) {
			Driver.tcFlag = "FAIL";
			Driver.comment = "Database did not return any records";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);								
			
		}else {
			
			//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	   
			try {
				System.out.println("customer id "+CustID);
				driver.findElement(By.xpath(propertyValue)).sendKeys(""+CustID);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass"+" # "+"Customer ID: " +CustID;
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
				System.out.println("customer Id entered");
			}catch(Exception e) {
				Driver.tcFlag = "FAIL";
				Driver.comment = "Required object is not displayed or identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);									    							   
			}
			
			try {
				driver.findElement(By.xpath("html/body/div[3]/div[3]/div/button")).click();
			}catch(Exception e1) {
				
			}
	   

			
		}
		
  
   }else {
		Driver.tcFlag = "FAIL";
		Driver.comment = "Database connection is not successfull";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);											   
   }
		   
 }

//===========================================================================================================================
//===========================================================================================================================

 public static void getCustomerIdForOtherLoan2(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
		
	 	String CustID=null;
		Connection con=(Connection) Common.DatabaseConnector();
		if(con !=null) {

 
			Statement stmt = con.createStatement();	
  
			String Q_datefetch="SELECT top 9 m.Cust_ID \r\n" + 
				"        		FROM CustMaster m \r\n" + 
  		        "        		JOIN viAccMaster a ON m.Cust_ID = a.Cust_ID\r\n" + 
  		        "        		WHERE m.Cust_ID not in (select Cust_ID from viaccmaster where ProductID IN (   select ProductID					from Products where IsLoan=1)) \r\n" + 
  		        "        		AND m.IsKYCCompleted = 1  And a.ProductID=1001  \r\n" + 
  		        "        		AND m.Branch_ID = 102 and m.CustType_ID=1" +
  		        "               order by m.Cust_ID                       " ;
  
             ResultSet rs1= stmt.executeQuery(Q_datefetch);
             int counter=0;
  
             while(rs1.next()) {
            	 counter=counter+1;
  	             CustID=rs1.getString(1);
  	
               }
		
           
            if(counter==0) {
            	
            	Driver.tcFlag = "FAIL";
    			Driver.comment = "Database did not return any records";
    			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
            	
            }else {
    
           //driver.findElement(By.xpath(propertyValue)).sendKeys(""+CustID);
            	try {
            		 System.out.println("customer id "+CustID);
            		driver.findElement(By.xpath(propertyValue)).sendKeys(""+CustID);
            		Driver.tcFlag = "PASS";
    				Driver.comment = "Pass"+" # "+"Customer ID: " +CustID;
    				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
            		
            	}catch(Exception e1) {
            		Driver.tcFlag = "FAIL";
            		Driver.comment = "Required object is not displayed or not identified";
            		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
            	}
           try {
	           driver.findElement(By.xpath("html/body/div[3]/div[3]/div/button")).click();
	            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

             }catch(Exception e) {
	   
                       }
            }
  
   }	else {
	  
	       Driver.tcFlag = "FAIL";
	       Driver.comment = "Database connection is not successfull";
	       Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment); 
  }
		   
}
 
//===========================================================================================================================
//===========================================================================================================================

 public static void getCustomerIdForOtherLoan3(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
		
	 	String CustID=null;
		Connection con=(Connection) Common.DatabaseConnector();
		if(con !=null) {

 
           Statement stmt = con.createStatement();	
  
           String Q_datefetch="SELECT top 8 m.Cust_ID \r\n" + 
  		      "        		FROM CustMaster m \r\n" + 
  		      "        		JOIN viAccMaster a ON m.Cust_ID = a.Cust_ID\r\n" + 
  		      "        		WHERE m.Cust_ID not in (select Cust_ID from viaccmaster where ProductID IN (   select ProductID					from Products where IsLoan=1)) \r\n" + 
  		      "        		AND m.IsKYCCompleted = 1  And a.ProductID=1001  \r\n" + 
  		      "        		AND m.Branch_ID = 102 and m.CustType_ID=1"; 
  
          ResultSet rs1= stmt.executeQuery(Q_datefetch);
          int counter=0;
  
          while(rs1.next()) {
        	  counter=counter+1;
              CustID=rs1.getString(1);
  	
          }
		
        System.out.println("customer id "+CustID);
        if(counter==0) {
        	Driver.tcFlag = "FAIL";
			Driver.comment = "Database did not return any records";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
        	
        }else {
        	
        	try {
        		driver.findElement(By.xpath(propertyValue)).sendKeys(""+CustID);
        		Driver.tcFlag = "PASS";
				Driver.comment = "Pass"+" # "+"Customer ID: " +CustID;
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
        		
        	}catch(Exception e1) {
        		Driver.tcFlag = "FAIL";
        		Driver.comment = "Required object is not displayed or not identified";
        		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
        	}
  
        
  
       try {
	   driver.findElement(By.xpath("html/body/div[3]/div[3]/div/button")).click();
	   driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        }catch(Exception e) {
	   
                       }
        }
  }	else {
	  
	  Driver.tcFlag = "FAIL";
      Driver.comment = "Database connection is not successfull";
      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment); 
  }
		   
}
//===========================================================================================================================
//===========================================================================================================================


 public static void getOLAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
		
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {

 
        Statement stmt = con.createStatement();	
        String Q_datefetch="select AcNo\r\n" + 
     		"FROM(\r\n" + 
     		"SELECT  TOP(30) \r\n" + 
     		"		AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
     		"from viAccMaster m\r\n" + 
     		"where m.ProductID = 23001\r\n" + 
     		"	and OpenDate <(select CurrentTransDate from TransactionDate)\r\n" + 
     		"	and IsClosed =0\r\n" + 
     		"	and M.RecordStatus = 3\r\n" + 
     		"	and M.OrgBranchID =102\r\n" + 
     		"	and IsFreezed=0	\r\n" + 
     		"	order by InterestEffectFrom desc\r\n" + 
     		")AS A\r\n" + 
     		"WHERE A.TrnUnauthCount = 0"; 
  
        ResultSet rs1= stmt.executeQuery(Q_datefetch);
        int counter=0;
        while(rs1.next()) {
        	
        	  counter=counter+1;
    	      ACNO=rs1.getString(1);
  	
        }
        if(counter==0) {
        	
        	Driver.tcFlag = "FAIL";
			Driver.comment = "Database did not return any records";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
        	
        }else {
             try { 	
               String AccNo=ACNO.substring(10, 15);
               System.out.println("ACCOUNT NUMBER:"+ACNO);
		       System.out.println("ACCOUNT NO:"+AccNo);
               driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
               Driver.tcFlag = "PASS";
               Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
	           Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
             }catch(Exception e) {
            	 
            	 Driver.tcFlag = "FAIL";
         		 Driver.comment = "Required object is not displayed or not identified";
         		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
            	 
             }
        }
 
		}else {
			
			Driver.tcFlag = "FAIL";
		    Driver.comment = "Database connection is not successfull";
		    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment); 
			
		}
		   
}
//===========================================================================================================================
//===========================================================================================================================

 public static void getOLInterBranchAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
		
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {

 
        Statement stmt = con.createStatement();	
        String Q_datefetch="select AcNo\r\n" + 
     		"FROM(\r\n" + 
     		"SELECT  TOP(10) \r\n" + 
     		"		AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
     		"from viAccMaster m\r\n" + 
     		"where m.ProductID = 23001\r\n" + 
     		"	and OpenDate <(select CurrentTransDate from TransactionDate)\r\n" + 
     		"	and IsClosed =0\r\n" + 
     		"	and M.RecordStatus = 3\r\n" + 
     		"	and M.OrgBranchID =108\r\n" + 
     		"	and IsFreezed=0	\r\n" + 
     		"	order by InterestEffectFrom desc\r\n" + 
     		")AS A\r\n" + 
     		"WHERE A.TrnUnauthCount = 0"; 
  
       ResultSet rs1= stmt.executeQuery(Q_datefetch);
       int counter=0;
       while(rs1.next()) {
    	   
    	      counter=counter+1;
  	          ACNO=rs1.getString(1);
  	
         }
       if(counter==0) {
    	   
    	   Driver.tcFlag = "FAIL";
		   Driver.comment = "Database did not return any records";
		   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
       }else {
    	   try {
          String AccNo=ACNO.substring(10, 15);
          System.out.println("ACCOUNT NUMBER:"+ACNO);
		  System.out.println("ACCOUNT NO:"+AccNo);
          driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
          Driver.tcFlag = "PASS";
          Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
          Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    	   }catch(Exception e) {
    		   
    		   Driver.tcFlag = "FAIL";
       		   Driver.comment = "Required object is not displayed or not identified";
       		   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
    	   }
       }
 
		}else {
			
			Driver.tcFlag = "FAIL";
		    Driver.comment = "Database connection is not successfull";
		    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment); 
			
		}
		   
 }
//===========================================================================================================================
//===========================================================================================================================
 public static void getODAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
		
	 String ACNO=null;
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 Connection con=(Connection) Common.DatabaseConnector();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 if(con !=null) {
		 
 
        Statement stmt = con.createStatement();	
     
        String Q_datefetch = "EXEC QAFETCHODACCOUNTS 2,102";
        		//"select AcNo FROM( SELECT  TOP(30) AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount from viAccMaster m where m.ProductID = 24001 and AcStartDate >'01 jan 2010' and duedate>(select CurrentTransDate from TransactionDate) and IsClosed =0 and M.RecordStatus = 3 and M.OrgBranchID =102 and IsFreezed=0 order by InterestEffectFrom desc )AS A 	WHERE A.TrnUnauthCount = 0 ";
     	//System.out.println(Q_datefetch);
     /*String Q_datefetch="select AcNo\r\n" + 
     		"FROM(\r\n" + 
     		"SELECT  TOP(30) \r\n" + 
     		"		AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
     		"from viAccMaster m\r\n" + 
     		"where m.ProductID = 24001\r\n" + 
     		"	and OpenDate <(select CurrentTransDate from TransactionDate)\r\n" + 
     		"	and IsClosed =0\r\n" + 
     		"	and M.RecordStatus = 3\r\n" + 
     		"	and M.OrgBranchID =102\r\n" +
     		"	and IsFreezed=0	\r\n" + 
     		"	order by InterestEffectFrom desc\r\n" + 
     		")AS A\r\n" + 
     		"WHERE A.TrnUnauthCount = 0"; 
  */
      ResultSet rs1= stmt.executeQuery(Q_datefetch);
      int tempCounter = 0;
      while(rs1.next()) {
    	   	tempCounter = tempCounter + 1;
  	          ACNO=rs1.getString(1);
  	
       }
      if(tempCounter==0) {
    	  
    	 Driver.tcFlag = "FAIL";
		 Driver.comment = "Database did not return any records";
		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);  
      }else {
    	  try {
            String AccNo=ACNO.substring(10, 15);
            System.out.println("ACCOUNT NUMBER:"+ACNO);
		    System.out.println("ACCOUNT NO:"+AccNo);
            driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
            Driver.tcFlag = "PASS";
            Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
            Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
    	  }catch(Exception e) {
    		  
    		  Driver.tcFlag = "FAIL";
      		  Driver.comment = "Required object is not displayed or not identified";
      		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
    	  }
      }
		 
		 
	  }else{
			Driver.tcFlag = "FAIL";
			Driver.comment = "Database connection is null";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
	 
}
//===========================================================================================================================
//===========================================================================================================================
 public static void getODInterBranchAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException 
 {	
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {

 
        Statement stmt = con.createStatement();	
        String Q_datefetch="EXEC QAFETCHODACCOUNTS 2,108";
//        		"select AcNo\r\n" + 
//     		"FROM(\r\n" + 
//     		"SELECT  TOP(10) \r\n" + 
//     		"		AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
//     		"from viAccMaster m\r\n" + 
//     		"where m.ProductID = 24001\r\n" + 
//     		"	and OpenDate <(select CurrentTransDate from TransactionDate)\r\n" + 
//     		"	and IsClosed =0\r\n" + 
//     		"	and M.RecordStatus = 3\r\n" + 
//     		"	and M.OrgBranchID =108\r\n" + 
//     		"	and IsFreezed=0	\r\n" + 
//     		"	order by InterestEffectFrom desc\r\n" + 
//     		")AS A\r\n" + 
//     		"WHERE A.TrnUnauthCount = 0"; 
  
       ResultSet rs1= stmt.executeQuery(Q_datefetch);
       int counter=0;
       while(rs1.next()) {
    	   
    	      counter=counter+1;
  	          ACNO=rs1.getString(1);
  	   }
       if(counter==0) {
    	   
    	   Driver.tcFlag = "FAIL";
  		   Driver.comment = "Database did not return any records";
  		   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);  
    	   
       }else {
    	   try {
             String AccNo=ACNO.substring(10, 15);
             System.out.println("ACCOUNT NUMBER:"+ACNO);
	         System.out.println("ACCOUNT NO:"+AccNo);
             driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
             Driver.tcFlag = "PASS";
             Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
	         Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    	   }catch(Exception e) {
    		   
    		   Driver.tcFlag = "FAIL";
       		   Driver.comment = "Required object is not displayed or not identified";
       		   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
    	   }
       }
 
		}else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Database connection is null";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		   
 }
//===========================================================================================================================
//===========================================================================================================================
 public static void getODDebitAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
		
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {

 
        Statement stmt = con.createStatement();	
        String Q_datefetch="EXEC QAFETCHODACCOUNTS 1,102";
//        		"DECLARE @DbDate DATETIME = (SELECT CurrentTransDate FROM  TransactionDate)\r\n" + 
//        		"     		\r\n" + 
//        		"     		SELECT \r\n" + 
//        		"     			Acno\r\n" + 
//        		"     		FROM  FnGetOutstanding ('24001',@DbDate,102)   \r\n" + 
//        		"     	\r\n" + 
//        		"     	\r\n" + 
//        		"     		WHERE 	PrnBal < 0 AND\r\n" + 
//        		"     			AccmasterID NOT IN\r\n" + 
//        		"     			(\r\n" + 
//        		"     				SELECT \r\n" + 
//        		"     					AccMasterID\r\n" + 
//        		"     				FROM ProductAccountBalance\r\n" + 
//        		"     				WHERE BalDate>@DbDate \r\n" + 
//        		"     			)\r\n" + 
//        		"     				and AccmasterID  NOT IN\r\n" + 
//        		"     			(\r\n" + 
//        		"     				SELECT \r\n" + 
//        		"     					AccMasterID\r\n" + 
//        		"     				FROM Transactions\r\n" + 
//        		"     				where PRODUCTID=24001 AND \r\n" + 
//        		"     				 RecordStatus in (1,2,4,5) \r\n" + 
//        		"     			)\r\n"+  		
//        		"				and Duedate>=@DbDate";	
        ResultSet rs1= stmt.executeQuery(Q_datefetch);
        int counter=0;
        while(rs1.next()) {
    	      counter=counter+1;
  	          ACNO=rs1.getString(1);
  	
         }
       if(counter==0) {
    	   
    	   Driver.tcFlag = "FAIL";
  		   Driver.comment = "Database did not return any records";
  		   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);  
    	   
       }else {
    	   try {
             String AccNo=ACNO.substring(10, 15);
             System.out.println("ACCOUNT NUMBER:"+ACNO);
		     System.out.println("ACCOUNT NO:"+AccNo);
             driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
             Driver.tcFlag = "PASS";
             Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
	         Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    	   }catch(Exception e) {
    		   Driver.tcFlag = "FAIL";
       		   Driver.comment = "Required object is not displayed or not identified";
       		   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
    	   }
       }
 
		}else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Database connection is null";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		   
 }
//===========================================================================================================================
//===========================================================================================================================
 public static void getODDebitInterBranchAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
		
	 System.out.println("Get a/c number");
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {

 
        Statement stmt = con.createStatement();	
        String Q_datefetch = "EXEC QAFETCHODACCOUNTS 1,108";
        		/*"DECLARE @DbDate DATETIME = (SELECT CurrentTransDate FROM  TransactionDate)\r\n" + 
        		"     		\r\n" + 
        		"     		SELECT \r\n" + 
        		"     			Acno,*\r\n" + 
        		"     		FROM  FnGetOutstanding ('24001',@DbDate,108)   \r\n" + 
        		"     	\r\n" + 
        		"     	\r\n" + 
        		"     		WHERE 	PrnBal > 0 AND\r\n" + 
        		"     			AccmasterID NOT IN\r\n" + 
        		"     			(\r\n" + 
        		"     				SELECT \r\n" + 
        		"     					AccMasterID\r\n" + 
        		"     				FROM ProductAccountBalance\r\n" + 
        		"     				WHERE BalDate>@DbDate \r\n" + 
        		"     			)\r\n" + 
        		"     				and AccmasterID  NOT IN\r\n" + 
        		"     			(\r\n" + 
        		"     				SELECT \r\n" + 
        		"     					AccMasterID\r\n" + 
        		"     				FROM Transactions\r\n" + 
        		"     				where PRODUCTID=24001 AND \r\n" + 
        		"     				 RecordStatus in (1,2,4,5)  --AND TRANSDATE<=@DbDate\r\n" + 
        		"     			)\r\n"+  		
        		"				and Duedate>=@DbDate";	
        		*/
        //Commented below line on Feb 12th, 2019 and added above line
        /*String Q_datefetch="DECLARE @DbDate DATETIME = (SELECT CurrentTransDate FROM  TransactionDate)\r\n" + 
     		"\r\n" + 
     		"SELECT \r\n" + 
     		"	Acno\r\n" + 
     		"FROM  FnGetOutstanding ('24001',@DbDate,108)\r\n" + 
     		"WHERE 	PrnBal < 0 AND\r\n" + 
     		"	AccMasterID NOT IN\r\n" + 
     		"	(\r\n" + 
     		"		SELECT \r\n" + 
     		"			AccMasterID\r\n" + 
     		"		FROM ProductAccountBalance\r\n" + 
     		"		WHERE BalDate>@DbDate\r\n" + 
     		"	)"; 
  */
        ResultSet rs1= stmt.executeQuery(Q_datefetch);
        int counter=0;
        while(rs1.next()) {
    	   
        	counter=counter+1;
  	        ACNO=rs1.getString(1);
  	
         }
        if(counter==0) {
        	
        	 Driver.tcFlag = "FAIL";
   		     Driver.comment = "Database did not return any records";
   		     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
        	
        }else {
        	try {
               String AccNo=ACNO.substring(10, 15);
               System.out.println("ACCOUNT NUMBER:"+ACNO);
		       System.out.println("ACCOUNT NO:"+AccNo);
               driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
               Driver.tcFlag = "PASS";
               Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
		       Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
        	}catch(Exception e) {
        		
        		Driver.tcFlag = "FAIL";
        		Driver.comment = "Required object is not displayed or not identified";
        		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
        	}
        }
 
		}else {
			Driver.tcFlag = "FAIL";
			Driver.comment = "Database connection is null";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			
		}
		   
 }
//===========================================================================================================================
//===========================================================================================================================
 public static void getDLCreditInterBranchAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
		
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {

 
        Statement stmt = con.createStatement();	
        String Q_datefetch="select AcNo\r\n" + 
     		"FROM(\r\n" + 
     		"SELECT  TOP(10) \r\n" + 
     		"		AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
     		"from viAccMaster m\r\n" + 
     		"where m.ProductID = 22001\r\n" + 
     		"	and OpenDate <(select CurrentTransDate from TransactionDate)\r\n" + 
     		"	and IsClosed =0\r\n" + 
     		"	and M.RecordStatus = 3\r\n" + 
     		"	and M.OrgBranchID =108\r\n" + 
     		"	and IsFreezed=0	\r\n" + 
     		"	order by InterestEffectFrom desc\r\n" + 
     		")AS A\r\n" + 
     		"WHERE A.TrnUnauthCount = 0"; 
  
        ResultSet rs1= stmt.executeQuery(Q_datefetch);
        int counter=0;
        while(rs1.next()) {
        	
    	      counter=counter+1;
  	          ACNO=rs1.getString(1);
  	
         }
        if(counter==0) {
        	
        	 Driver.tcFlag = "FAIL";
  		     Driver.comment = "Database did not return any records";
  		     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
        	
        }else {
        	try {
        		String AccNo=ACNO.substring(10, 15);
        		System.out.println("ACCOUNT NUMBER:"+ACNO);
        		System.out.println("ACCOUNT NO:"+AccNo);
        		driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
                Driver.tcFlag = "PASS";
                Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
                Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
        	}catch(Exception e) {
        		Driver.tcFlag = "FAIL";
        		Driver.comment = "Required object is not displayed or not identified";
        		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
        	}
        }
 
		}else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Database connection is null";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		   
 }
//===========================================================================================================================
//===========================================================================================================================
 public static void getDLCreditAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
		
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {

 
         Statement stmt = con.createStatement();	
         String Q_datefetch="select AcNo\r\n" + 
     		"FROM(\r\n" + 
     		"SELECT  TOP(10) \r\n" + 
     		"		AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
     		"from viAccMaster m\r\n" + 
     		"where m.ProductID = 22001\r\n" + 
     		"	and OpenDate <(select CurrentTransDate from TransactionDate)\r\n" + 
     		"	and IsClosed =0\r\n" + 
     		"	and M.RecordStatus = 3\r\n" + 
     		"	and M.OrgBranchID =102\r\n" + 
     		"	and IsFreezed=0	\r\n" + 
     		"	order by InterestEffectFrom desc\r\n" + 
     		")AS A\r\n" + 
     		"WHERE A.TrnUnauthCount = 0"; 
  
         ResultSet rs1= stmt.executeQuery(Q_datefetch);
         int counter=0;
         while(rs1.next()) {
    	      counter=counter+1;
  	          ACNO=rs1.getString(1);
  	
           }
        if(counter==0) {
        	
        	Driver.tcFlag = "FAIL";
 		    Driver.comment = "Database did not return any records";
 		    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
        	
        }else {
        	try {
        		String AccNo=ACNO.substring(10, 15);
        		System.out.println("ACCOUNT NUMBER:"+ACNO);
        		System.out.println("ACCOUNT NO:"+AccNo);
        		driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
        		Driver.tcFlag = "PASS";
        		Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
        		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
        	}catch(Exception e) {
        		Driver.tcFlag = "FAIL";
        		Driver.comment = "Required object is not displayed or not identified";
        		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
        	}
        }
 
		}else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Database connection is null";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			
		}
		   
 }
//===========================================================================================================================
//===========================================================================================================================
 public static void getGLCreditAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
	 
	 String ACNO=null;
	 Connection getGLCreditAcNocon=(Connection) Common.DatabaseConnector();
	 System.out.println("Connection: " + getGLCreditAcNocon);

	 if(getGLCreditAcNocon !=null) {

 
          Statement getGLCreditAcNostmt = getGLCreditAcNocon.createStatement();	
     
          String Q_datefetch = "select distinct AcNo,AgentCode FROM( SELECT  TOP(10)  AcNo , AcDisplayName ,AgentCode, (SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount from viAccMaster m where m.ProductID = 21001 and AcStartDate >'01 jan 2010' and duedate<(select CurrentTransDate from TransactionDate) and IsClosed =0 and M.RecordStatus = 3 and M.OrgBranchID =102 and IsFreezed=0	 order by InterestEffectFrom desc )AS A WHERE A.TrnUnauthCount = 0 ";
         //Commented this on Feb 12th, 2019 and added above line
         /*String Q_datefetch="select distinct AcNo,AgentCode\r\n" + 
     		"FROM(\r\n" + 
     		"SELECT  TOP(10) \r\n" + 
     		"		AcNo , AcDisplayName ,AgentCode, (SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
     		"from viAccMaster m\r\n" + 
     		"where m.ProductID = 21001\r\n" + 
     		"	and AcStartDate >'01 jan 2010'\r\n" + 
     		"	and duedate>(select CurrentTransDate from TransactionDate)\r\n" + 
     		"	and IsClosed =0\r\n" + 
     		"	and M.RecordStatus = 3\r\n" + 
     		"	and M.OrgBranchID =102\r\n" + 
     		"	and IsFreezed=0	\r\n" + 
     		"	order by InterestEffectFrom desc\r\n" + 
     		")AS A\r\n" + 
     		"WHERE A.TrnUnauthCount = 0  "; 
     */
          ResultSet getGLCreditAcNors1= getGLCreditAcNostmt.executeQuery(Q_datefetch);
     
          String AccNo;
          int counter=0;
          while(getGLCreditAcNors1.next()) {
        	  
    	       counter=counter+1;
  	           ACNO=getGLCreditAcNors1.getString(1);
  	
             }
           if(counter==0) {
        	   
        	   Driver.tcFlag = "FAIL";
       		   Driver.comment = "Database didnot return any records";
       		   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
        	   
           }
           else {
     
         try{
    	    AccNo=ACNO.substring(10, 15);
    	    System.out.println("ACCOUNT NUMBER:"+ACNO);
  	        System.out.println("ACCOUNT NO:"+AccNo);
  	        //rs1.close();
  	        //con.close();
  	        //stmt.close();
            driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
            Driver.tcFlag = "PASS";
            Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
  		    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
         }catch(Exception e){
    	 //e.printStackTrace();
        	 Driver.tcFlag = "FAIL";
     		 Driver.comment = "Required object is not displayed or not identified";
     		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
     }
           }
     
       //String AccNo=ACNO.substring(10, 15);
       
 
		}else{
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);

		}
	
	   
 }
//===========================================================================================================================
//===========================================================================================================================
 public static void getGLCreditInterBranchAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
		
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {

 
        Statement stmt = con.createStatement();	
        String Q_datefetch="select distinct AcNo,AgentCode\r\n" + 
     		"FROM(\r\n" + 
     		"SELECT  TOP(10) \r\n" + 
     		"		AcNo , AcDisplayName ,AgentCode, (SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
     		"from viAccMaster m\r\n" + 
     		"where m.ProductID = 21001\r\n" + 
     		"	and AcStartDate >'01 jan 2010'\r\n" + 
     		"	and duedate<(select CurrentTransDate from TransactionDate)\r\n" + 
     		"	and IsClosed =0\r\n" + 
     		"	and M.RecordStatus = 3\r\n" + 
     		"	and M.OrgBranchID =108\r\n" + 
     		"	and IsFreezed=0	\r\n" + 
     		"	order by InterestEffectFrom desc\r\n" + 
     		")AS A\r\n" + 
     		"WHERE A.TrnUnauthCount = 0  "; 
  
         ResultSet rs1= stmt.executeQuery(Q_datefetch);
         int counter=0;
         while(rs1.next()) {
        	 
    	      counter=counter+1;
  	          ACNO=rs1.getString(1);
  	
         }
         if(counter==0) {
        	 
        	 Driver.tcFlag = "FAIL";
  		     Driver.comment = "Database did not return any records";
  		     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
         }else {
        	 try {
               String AccNo=ACNO.substring(10, 15);
               System.out.println("ACCOUNT NUMBER:"+ACNO);
               System.out.println("ACCOUNT NO:"+AccNo);
               driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
               Driver.tcFlag = "PASS";
               Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
        	 }catch(Exception e) {
        		 
        		 Driver.tcFlag = "FAIL";
         		 Driver.comment = "Required object is not displayed or not identified";
         		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
        	 }
         }
 
		}	else {
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			
		}
		   
 }
//===========================================================================================================================
//===========================================================================================================================
 public static void getFDInterestPaymentAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
		
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {

 
        Statement stmt = con.createStatement();	
        String Q_datefetch="select distinct AcNo,AgentCode\r\n" + 
     		"FROM(\r\n" + 
     		"SELECT  TOP(10) \r\n" + 
     		"AcNo , AcDisplayName ,AgentCode, (SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
     		"from viAccMaster m\r\n" + 
     		"where m.ProductID = 12001\r\n" + 
     		"	and AcStartDate >'01 jan 2010'\r\n" + 
     		"	and duedate>(select CurrentTransDate from TransactionDate)\r\n" + 
     		"	and IsClosed =0\r\n" + 
     		"	and M.RecordStatus = 3\r\n" + 
     		"	and M.OrgBranchID =102\r\n" + 
     		"	and IsFreezed=0	\r\n" + 
     		"	order by InterestEffectFrom desc\r\n" + 
     		")AS A\r\n" + 
     		"WHERE A.TrnUnauthCount = 0"; 
  
        ResultSet rs1= stmt.executeQuery(Q_datefetch);
        int counter=0;
        while(rs1.next()) {
    	      counter=counter+1;   
  	          ACNO=rs1.getString(1);
  	
         }
        if(counter==0) {
        	
       	     Driver.tcFlag = "FAIL";
		     Driver.comment = "Database did not return any records";
		     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
        }else {
        	try {
        		String AccNo=ACNO.substring(9, 15);
        		System.out.println("ACCOUNT NUMBER:"+ACNO);
        		System.out.println("ACCOUNT NO:"+AccNo);
        		driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
        		Driver.tcFlag = "PASS";
        		Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
        		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
        	}catch(Exception e) {
        		Driver.tcFlag = "FAIL";
        		Driver.comment = "Required object is not displayed or not identified";
        		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
        	}
        }
 
		}else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		   
 }
//===========================================================================================================================
//===========================================================================================================================
 public static void getSBACCountClosure_AcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
	 
	 System.out.println("SB ACCOUNT NUMBER");	
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {

 
       Statement stmt = con.createStatement();	
       String Q_datefetch="select AcNo\r\n" + 
     		"FROM(\r\n" + 
     		"SELECT  TOP(10) \r\n" + 
     		"		AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
     		"from viAccMaster m\r\n" + 
     		"where m.ProductID = 10001\r\n" + 
     		"	and OpenDate <(select CurrentTransDate from TransactionDate)\r\n" + 
     		"	and IsClosed =0\r\n" + 
     		"	and M.RecordStatus = 3\r\n" + 
     		"	and M.OrgBranchID =102\r\n" + 
     		"	and IsFreezed=0	\r\n" + 
     		"	order by InterestEffectFrom desc\r\n" + 
     		")AS A\r\n" + 
     		"WHERE A.TrnUnauthCount = 0"; 
  
     ResultSet rs1= stmt.executeQuery(Q_datefetch);
     int counter=0;
     while(rs1.next()) {
    	 
    	      counter=counter+1;
  	          ACNO=rs1.getString(1);
  	
      }
     if(counter==0) {
    	 
    	 Driver.tcFlag = "FAIL";
	     Driver.comment = "Database did not return any records";
	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
     }else {
    	 try {
    		 String AccNo=ACNO.substring(10, 15);
    		 System.out.println("ACCOUNT NUMBER:"+ACNO);
    		 System.out.println("ACCOUNT NO:"+AccNo);
    		 driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
    		 Driver.tcFlag = "PASS";
    		 Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
    		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    	 }catch(Exception e) {
    		 Driver.tcFlag = "FAIL";
     		 Driver.comment = "Required object is not displayed or not identified";
     		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
    	 }
     }
 
		}	else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			
			}
		   
 }
//===========================================================================================================================
//=========================================================================================================================== 
 
public static void getFDACCountClosure_AcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
	 
	 System.out.println("FD ACCOUNT NUMBER");	
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {

 
     Statement stmt = con.createStatement();	
     String Q_datefetch="select AcNo ,AcOpeningAmount\r\n" + 
     		"    		FROM( \r\n" + 
     		"    		SELECT  TOP(10)  \r\n" + 
     		"    			AcNo ,AcOpeningAmount, AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus \r\n" + 
     		"    				Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount \r\n" + 
     		"    		from viAccMaster m \r\n" + 
     		"    		where m.ProductID = 12001 \r\n" + 
     		"    			and DueDate <(select CurrentTransDate from TransactionDate) \r\n" + 
     		"    			and IsClosed =0 \r\n" + 
     		"    			and M.RecordStatus = 3 \r\n" + 
     		"    			and M.OrgBranchID =102\r\n" + 
     		"    			and IsFreezed=0	 \r\n" + 
     		"    			and AcOpeningAmount<10000000\r\n" + 
     		"				and AccMasterID not in (select CautionDepMasterID from CautionDepositHistory)\r\n"	+ // Line added on 27 Sep 2020 by yadhu to exclude a/c no which is set as caution deposit in locker product	
     		"    			order by InterestEffectFrom desc \r\n" + 
     		"    		)AS A \r\n" + 
     		"    		WHERE A.TrnUnauthCount = 0"; 
  
     ResultSet rs1= stmt.executeQuery(Q_datefetch);
     int counter=0;
     while(rs1.next()) {
    	 
    	      counter=counter+1;
  	          ACNO=rs1.getString(1);
  	
      }
     if(counter==0) {
    	 
    	 Driver.tcFlag = "FAIL";
	     Driver.comment = "Database did not return any records";
	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
    	 
     }else {
    	 try {
    		 String AccNo=ACNO.substring(9, 15);
    		 System.out.println("ACCOUNT NUMBER:"+ACNO);
	         System.out.println("ACCOUNT NO:"+AccNo);
             driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
             Driver.tcFlag = "PASS";
             Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
		     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    	 }catch(Exception e) {
    		 
    		 Driver.tcFlag = "FAIL";
     		 Driver.comment = "Required object is not displayed or not identified";
     		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
    	 }
     }
 
		}else {
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			
		}
		   
 }
//===========================================================================================================================
//=========================================================================================================================== 
public static void getFDInterBranchAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
	 
	 System.out.println("FD ACCOUNT NUMBER");	
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {


        Statement stmt = con.createStatement();	
        String Q_datefetch="select AcNo ,AcOpeningAmount\r\n" + 
        		"    		FROM( \r\n" + 
        		"    		SELECT  TOP(10)  \r\n" + 
        		"    			AcNo ,AcOpeningAmount, AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus \r\n" + 
        		"    				Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount \r\n" + 
        		"    		from viAccMaster m \r\n" + 
        		"    		where m.ProductID = 12001 \r\n" + 
        		"    			and DueDate >(select CurrentTransDate from TransactionDate) \r\n" + 
        		"    			and IsClosed =0 \r\n" + 
        		"    			and M.RecordStatus = 3 \r\n" + 
        		"    			and M.OrgBranchID =108 \r\n" + 
        		"    			and IsFreezed=0	 \r\n" + 
        		"    			and AcOpeningAmount<10000000\r\n" + 
        		"    			order by InterestEffectFrom desc \r\n" + 
        		"    		)AS A \r\n" + 
        		"    		WHERE A.TrnUnauthCount = 0"; 
 
        ResultSet rs1= stmt.executeQuery(Q_datefetch);
        int counter=0;
        while(rs1.next()) {
   	          counter=counter+1;
 	          ACNO=rs1.getString(1);
 	
         }
        if(counter==0) {
        	
        	Driver.tcFlag = "FAIL";
   	        Driver.comment = "Database did not return any records";
   	        Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
        	
        }else {
        	try {
        		String AccNo=ACNO.substring(9, 15);
        		System.out.println("ACCOUNT NUMBER:"+ACNO);
        		System.out.println("ACCOUNT NO:"+AccNo);
        		driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
        		Driver.tcFlag = "PASS";
        		Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
        		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
        	}catch(Exception e) {
        		
        		Driver.tcFlag = "FAIL";
        		Driver.comment = "Required object is not displayed or not identified";
        		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
        	}
        }

		}	else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		   
}
//===========================================================================================================================
//=========================================================================================================================== 
public static void getRDACCountClosure_AcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
	 
	 System.out.println("RD ACCOUNT NUMBER");	
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {


          Statement stmt = con.createStatement();	
          String Q_datefetch="select AcNo\r\n" + 
    		"FROM(\r\n" + 
    		"SELECT  TOP(10) \r\n" + 
    		"		AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
    		"from viAccMaster m\r\n" + 
    		"where m.ProductID = 14001\r\n" + 
    		"	and DueDate <(select CurrentTransDate from TransactionDate)\r\n" + 
    		"	and IsClosed =0\r\n" + 
    		"	and M.RecordStatus = 3\r\n" + 
    		"	and M.OrgBranchID =102\r\n" + 
    		"	and IsFreezed=0	\r\n" + 
    		"	order by InterestEffectFrom desc\r\n" + 
    		")AS A\r\n" + 
    		"WHERE A.TrnUnauthCount = 0"; 
 
         ResultSet rs1= stmt.executeQuery(Q_datefetch);
         int counter=0;
         while(rs1.next()) {
   	          counter=counter+1;
 	          ACNO=rs1.getString(1);
 	
           }
         if(counter==0) {
        	 
        	 Driver.tcFlag = "FAIL";
    	     Driver.comment = "Database did not return any records";
    	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
        	 
         }else {
        	 try {
        		 String AccNo=ACNO.substring(9, 15);
        		 System.out.println("ACCOUNT NUMBER:"+ACNO);
        		 System.out.println("ACCOUNT NO:"+AccNo);
        		 driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
        		 Driver.tcFlag = "PASS";
        		 Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
        		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
        	 }catch(Exception e) {
        		 
        		 Driver.tcFlag = "FAIL";
         		 Driver.comment = "Required object is not displayed or not identified";
         		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
        	 }
         }

		}else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			
		}
		   
}
//===========================================================================================================================
//=========================================================================================================================== 
public static void getDDACCountClosure_AcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
	 
	 System.out.println("DD ACCOUNT NUMBER");	
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {


         Statement stmt = con.createStatement();	
         String Q_datefetch="select AcNo\r\n" + 
   		       "FROM(\r\n" + 
   		       "SELECT  TOP(10) \r\n" + 
   		       "		AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
   		       "from viAccMaster m\r\n" + 
   		       "where m.ProductID = 15001\r\n" + 
   		       "	and DueDate <(select CurrentTransDate from TransactionDate)\r\n" + 
   		       "	and IsClosed =0\r\n" + 
   		       "	and M.RecordStatus = 3\r\n" + 
   		       "	and M.OrgBranchID =102\r\n" + 
   		       "	and IsFreezed=0	\r\n" + 
   		       "	order by InterestEffectFrom desc\r\n" + 
   		       ")AS A\r\n" + 
   		       "WHERE A.TrnUnauthCount = 0"; 

        ResultSet rs1= stmt.executeQuery(Q_datefetch);
        int counter=0;
        while(rs1.next()) {
  	     
        	  counter=counter+1;
	          ACNO=rs1.getString(1);
	
          }
       if(counter==0) {
    	   
    	 Driver.tcFlag = "FAIL";
  	     Driver.comment = "Database did not return any records";
  	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
    	   
       }else {
    	   try {
    		   String AccNo=ACNO.substring(9, 15);
    		   System.out.println("ACCOUNT NUMBER:"+ACNO);
    		   System.out.println("ACCOUNT NO:"+AccNo);
    		   driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
    		   Driver.tcFlag = "PASS";
    		   Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
    		   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    	   }catch(Exception e) {
    		   
    		   Driver.tcFlag = "FAIL";
       		   Driver.comment = "Required object is not displayed or not identified";
       		   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
    	   }
       }

		}else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		   
}
//===========================================================================================================================
//=========================================================================================================================== 
public static void getRIDACCountClosure_AcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
	 
	 System.out.println("RID ACCOUNT NUMBER");	
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {


        Statement stmt = con.createStatement();	
        String Q_datefetch="select AcNo ,AcOpeningAmount\r\n" + 
        		"    		FROM( \r\n" + 
        		"    		SELECT  TOP(10)  \r\n" + 
        		"    			AcNo ,AcOpeningAmount, AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus \r\n" + 
        		"    				Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount \r\n" + 
        		"    		from viAccMaster m \r\n" + 
        		"    		where m.ProductID = 13001 \r\n" + 
        		"    			and DueDate >(select CurrentTransDate from TransactionDate) \r\n" + 
        		"    			and IsClosed =0 \r\n" + 
        		"    			and M.RecordStatus = 3 \r\n" + 
        		"    			and M.OrgBranchID =102\r\n" + 
        		"    			and IsFreezed=0	 \r\n" + 
        		"    			and AcOpeningAmount<10000000\r\n" + 
        		"    			order by InterestEffectFrom desc \r\n" + 
        		"    		)AS A \r\n" + 
        		"    		WHERE A.TrnUnauthCount = 0"; 

        ResultSet rs1= stmt.executeQuery(Q_datefetch);
        int counter=0;
        while(rs1.next()) {
 	          counter=counter+1;
	          ACNO=rs1.getString(1);
	
          }
        if(counter==0) {
        	
        	 Driver.tcFlag = "FAIL";
     	     Driver.comment = "Database did not return any records";
     	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
        	
        }else {
        	try {
             String AccNo=ACNO.substring(9, 15);
             System.out.println("ACCOUNT NUMBER:"+ACNO);
	         System.out.println("ACCOUNT NO:"+AccNo);
             driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
             Driver.tcFlag = "PASS";
             Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
		     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
        	}catch(Exception e) {
        		
        		Driver.tcFlag = "FAIL";
        		Driver.comment = "Required object is not displayed or not identified";
        		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
        	}
        }

		}	else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		   
}
//===========================================================================================================================
//=========================================================================================================================== 
public static void getRDInterBranchAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
	 
	 System.out.println("RD ACCOUNT NUMBER");	
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {


        Statement stmt = con.createStatement();	
        String Q_datefetch="select AcNo ,AcOpeningAmount\r\n" + 
        		"    		FROM( \r\n" + 
        		"    		SELECT  TOP(10)  \r\n" + 
        		"    			AcNo ,AcOpeningAmount, AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus \r\n" + 
        		"    				Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount \r\n" + 
        		"    		from viAccMaster m \r\n" + 
        		"    		where m.ProductID = 14001 \r\n" + 
        		"    			and DueDate >(select CurrentTransDate from TransactionDate) \r\n" + 
        		"    			and IsClosed =0 \r\n" + 
        		"    			and M.RecordStatus = 3 \r\n" + 
        		"    			and M.OrgBranchID =108\r\n" + 
        		"    			and IsFreezed=0	 \r\n" + 
        		"    			and AcOpeningAmount<10000000\r\n" + 
        		"    			order by InterestEffectFrom desc \r\n" + 
        		"    		)AS A \r\n" + 
        		"    		WHERE A.TrnUnauthCount = 0"; 

        ResultSet rs1= stmt.executeQuery(Q_datefetch);
        int counter=0;
        while(rs1.next()) {
        	
  	          counter=counter+1;
	          ACNO=rs1.getString(1);
	
          }
        if(counter==0) {
        	
        	 Driver.tcFlag = "FAIL";
     	     Driver.comment = "Database did not return any records";
     	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
        }else {
        	try {
        		String AccNo=ACNO.substring(9, 15);
        		System.out.println("ACCOUNT NUMBER:"+ACNO);
        		System.out.println("ACCOUNT NO:"+AccNo);
        		driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
        		Driver.tcFlag = "PASS";
        		Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
        		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
        	}catch(Exception e) {
        		
        		Driver.tcFlag = "FAIL";
        		Driver.comment = "Required object is not displayed or not identified";
        		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
        	}
        }
		}	else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			
		}
		   
}
//===========================================================================================================================
//=========================================================================================================================== 
public static void getDDInterBranchAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
	 
	 System.out.println("DD ACCOUNT NUMBER");	
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {


  Statement stmt = con.createStatement();	
  String Q_datefetch="select AcNo\r\n" + 
  		"FROM(\r\n" + 
  		"SELECT  TOP(10) \r\n" + 
  		"		AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
  		"from viAccMaster m\r\n" + 
  		"where m.ProductID = 15001\r\n" + 
  		"	and DueDate >(select CurrentTransDate from TransactionDate)\r\n" + 
  		"	and IsClosed =0\r\n" + 
  		"	and M.RecordStatus = 3\r\n" + 
  		"	and M.OrgBranchID =108\r\n" + 
  		"	and IsFreezed=0	\r\n" + 
  		"	order by InterestEffectFrom desc\r\n" + 
  		")AS A\r\n" + 
  		"WHERE A.TrnUnauthCount = 0"; 

  ResultSet rs1= stmt.executeQuery(Q_datefetch);
  int counter = 0;
  while(rs1.next()) {
 	   		 counter = counter + 1;
	          ACNO=rs1.getString(1);
	
   }
  
  if (counter == 0){
	  Driver.tcFlag = "FAIL";
	  Driver.comment = "Database did not return any records";
	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
  }else{
	  try {
	     String AccNo=ACNO.substring(9, 15);
	     System.out.println("ACCOUNT NUMBER:"+ACNO);
		 System.out.println("ACCOUNT NO:"+AccNo);
	  
	     driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
	     Driver.tcFlag = "PASS";
	     Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	  }catch(Exception e) {
		  Driver.tcFlag = "FAIL";
  		Driver.comment = "Required object is not displayed or not identified";
  		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	  }
  }
    

		}	else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		   
}
//===========================================================================================================================
//=========================================================================================================================== 
public static void getRIDInterBranchAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
	 
	 System.out.println("DD ACCOUNT NUMBER");	
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {


 Statement stmt = con.createStatement();	
 String Q_datefetch="select AcNo\r\n" + 
 		"FROM(\r\n" + 
 		"SELECT  TOP(10) \r\n" + 
 		"		AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
 		"from viAccMaster m\r\n" + 
 		"where m.ProductID = 13001\r\n" + 
 		"	and DueDate >(select CurrentTransDate from TransactionDate)\r\n" + 
 		"	and IsClosed =0\r\n" + 
 		"	and M.RecordStatus = 3\r\n" + 
 		"	and M.OrgBranchID =108\r\n" + 
 		"	and IsFreezed=0	\r\n" + 
 		"	order by InterestEffectFrom desc\r\n" + 
 		")AS A\r\n" + 
 		"WHERE A.TrnUnauthCount = 0"; 

 ResultSet rs1= stmt.executeQuery(Q_datefetch);
 int counter = 0;
 while(rs1.next()) {
	   		counter = counter + 1;
	          ACNO=rs1.getString(1);
	
  }
 
 if (counter == 0){
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Database did not return any records";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
 }else{
 try {
   String AccNo=ACNO.substring(9, 15);
   System.out.println("ACCOUNT NUMBER:"+ACNO);
   System.out.println("ACCOUNT NO:"+AccNo);
   driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
    Driver.tcFlag = "PASS";
    Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
 }catch(Exception e) {
	 
	 Driver.tcFlag = "FAIL";
		Driver.comment = "Required object is not displayed or not identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
 }
 			}
		}else {
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			
		}
		   
}
//===========================================================================================================================
//=========================================================================================================================== 
public static void getInterestPostingODAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
	 
	 System.out.println("INTEREST POSTING OD ACCOUNT NUMBER");	
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {


        Statement stmt = con.createStatement();	
        String Q_datefetch="select AcNo\r\n" + 
  		     "FROM(\r\n" + 
  		     "SELECT  TOP(10) \r\n" + 
  		     "		AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
  		     "from viAccMaster m\r\n" + 
  		     "where m.ProductID = 24001\r\n" + 
  		     "	and OpenDate <(select CurrentTransDate from TransactionDate)\r\n" + 
  		     "	and IsClosed =0\r\n" + 
  		     "	and M.RecordStatus = 3\r\n" + 
  		     "	and M.OrgBranchID =102\r\n" + 
  		     "	and IsFreezed=0	\r\n" + 
  		     "	order by InterestEffectFrom desc\r\n" + 
  		     ")AS A\r\n" + 
  		     "WHERE A.TrnUnauthCount = 0"; 

      ResultSet rs1= stmt.executeQuery(Q_datefetch);
       int counter=0;
      while(rs1.next()) {
    	  
	          counter=counter+1;
	          ACNO=rs1.getString(1);
	
        }
      if(counter==0) {
    	  
    	  Driver.tcFlag = "FAIL";
    	  Driver.comment = "Database did not return any records";
    	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
    	  
      }else {
    	  try {
    		  String AccNo=ACNO.substring(9, 15);
    		  System.out.println("ACCOUNT NUMBER:"+ACNO);
    		  System.out.println("ACCOUNT NO:"+AccNo);
    		  driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
    		  Driver.tcFlag = "PASS";
    		  Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
    		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    	  }catch(Exception e) {
    		  
    		  Driver.tcFlag = "FAIL";
      		Driver.comment = "Required object is not displayed or not identified";
      		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
    	  }
      }

		}	else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		   
}
//===========================================================================================================================
//=========================================================================================================================== 
public static void getPrematureFDRenewalAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
	 
	 System.out.println("PRE-MATURE FD RENEWAL ACCNO");	
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {


        Statement stmt = con.createStatement();	
        String Q_datefetch="select AcNo\r\n" + 
 		    "FROM(\r\n" + 
 		    "SELECT  TOP(10) \r\n" + 
 		    "		AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
 		    "from viAccMaster m\r\n" + 
 		    "where m.ProductID = 12001\r\n" + 
 		    "	and DueDate >(select CurrentTransDate from TransactionDate)\r\n" + 
 	     	"	and IsClosed =0\r\n" + 
 		    "	and M.RecordStatus = 3\r\n" + 
 		    "	and M.OrgBranchID =102\r\n" + 
 		    "	and IsFreezed=0	\r\n" + 
 		   " and m.AccMasterID not in (select DepositAccMasterID from SecurityDeposits)	\r\n" + 
 		    "	order by InterestEffectFrom desc\r\n" + 
 		    ")AS A\r\n" + 
 		    "WHERE A.TrnUnauthCount = 0"; 

      ResultSet rs1= stmt.executeQuery(Q_datefetch);
      int counter=0;
      while(rs1.next()) {
	          counter=counter+1; 
	          ACNO=rs1.getString(1);
	
       }
      if (counter==0) {
    	  
    	  Driver.tcFlag = "FAIL";
    	  Driver.comment = "Database did not return any records";
    	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
    	  
      }else {
    	  try {
     String AccNo=ACNO.substring(9, 15);
     System.out.println("ACCOUNT NUMBER:"+ACNO);
	 System.out.println("ACCOUNT NO:"+AccNo);
     driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
     Driver.tcFlag = "PASS";
     Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    	  }catch(Exception e) {
    		  Driver.tcFlag = "FAIL";
      		Driver.comment = "Required object is not displayed or not identified";
      		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
    	  }
      }

		}	else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			
		}
		   
}
//===========================================================================================================================
//=========================================================================================================================== 
 public static void getMaturedFDRenewalInterBranchAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
	 
	 System.out.println("MATURED FD INTERBRANCH RENEWAL ACCNO");	
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {


         Statement stmt = con.createStatement();	
         String Q_datefetch="select AcNo\r\n" + 
  		     "FROM(\r\n" + 
  		     "SELECT  TOP(10) \r\n" + 
  		     "		AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
  		     "from viAccMaster m\r\n" + 
  		     "where m.ProductID = 12001\r\n" + 
  		     "	and DueDate <(select CurrentTransDate from TransactionDate)\r\n" + 
  		     "	and IsClosed =0\r\n" + 
  		     "	and M.RecordStatus = 3\r\n" + 
  	       	 "	and M.OrgBranchID =108\r\n" + 
  		     "	and IsFreezed=0	\r\n" + 
  		     " and m.AccMasterID not in (select DepositAccMasterID from SecurityDeposits)	\r\n" + 
  		     //" and m.AccMasterID in (select FromAccMasterID from standinginstruction) \r\n" +
  		     //"and acno=108120010002966\r\n" + 
  		     "	order by InterestEffectFrom desc\r\n" + 
  		     ")AS A\r\n" + 
  		     "WHERE A.TrnUnauthCount = 0 "; 
         	
        ResultSet rs1= stmt.executeQuery(Q_datefetch);
        int counter=0;

        while(rs1.next()) {
        	
        	counter=counter+1;
	        ACNO=rs1.getString(1);
	
        }
       if(counter==0) {
    	   
    	   Driver.tcFlag = "FAIL";
     	   Driver.comment = "Database did not return any records";
     	   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
       }else {
    	   try {
      String AccNo=ACNO.substring(9, 15);
      System.out.println("ACCOUNT NUMBER:"+ACNO);
      System.out.println("ACCOUNT NO:"+AccNo);

      driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
      Driver.tcFlag = "PASS";
      Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    	   }catch(Exception e) {
    		   
    		   Driver.tcFlag = "FAIL";
       		Driver.comment = "Required object is not displayed or not identified";
       		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
    	   }
       }

    }	else {
    	
    	Driver.tcFlag = "FAIL";
		Driver.comment = "Failed to connect to database";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
    }
		   
}
//===========================================================================================================================
//=========================================================================================================================== 
 public static void getOLClosureAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
		
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {

 
     Statement stmt = con.createStatement();	
     String Q_datefetch="select AcNo \r\n" + 
     		"     		FROM(\r\n" + 
     		"     		SELECT  TOP(20)  \r\n" + 
     		"     		AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount \r\n" + 
     		"     		from viAccMaster m\r\n" + 
     		"     		where m.ProductID = 23001 \r\n" + 
     		"     		and OpenDate <(select CurrentTransDate from TransactionDate)\r\n" + 
     		"     		and IsClosed =0 \r\n" + 
     		"     		and M.RecordStatus = 3 \r\n" + 
     		"     		and M.OrgBranchID =102 \r\n" + 
     		"     		and IsFreezed=0	\r\n" + 
     		"     		order by InterestEffectFrom desc \r\n" + 
     		"     		)AS A \r\n" + 
     		"     		WHERE A.TrnUnauthCount = 0"; 
  
     ResultSet rs1= stmt.executeQuery(Q_datefetch);
     int  counter=0;
     while(rs1.next()) {
    	      counter=counter+1;
  	          ACNO=rs1.getString(1);
  	
      }
     if(counter==0) {
    	 
       Driver.tcFlag = "FAIL";
   	   Driver.comment = "Database did not return any records";
   	   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
    	 
     }else {
    	 try {
    		 String AccNo=ACNO.substring(10, 15);
    		 System.out.println("ACCOUNT NUMBER:"+ACNO);
    		 System.out.println("ACCOUNT NO:"+AccNo);
    		 driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
    		 Driver.tcFlag = "PASS";
    		 Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
    		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    	 }catch(Exception e) {
    		 
    		 Driver.tcFlag = "FAIL";
     		Driver.comment = "Required object is not displayed or not identified";
     		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
    	 }
     }
 
		}	else {
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		   
}
//===========================================================================================================================
//=========================================================================================================================== 
 public static void getODClosureAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
		
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {

 
     Statement stmt = con.createStatement();	
     String Q_datefetch="select AcNo \r\n" + 
     		"     		FROM(\r\n" + 
     		"     		SELECT  TOP(20)  \r\n" + 
     		"     		AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount \r\n" + 
     		"     		from viAccMaster m\r\n" + 
     		"     		where m.ProductID = 24001 \r\n" + 
     		"     		and OpenDate <(select CurrentTransDate from TransactionDate)\r\n" + 
     		"     		and IsClosed =0 \r\n" + 
     		"     		and M.RecordStatus = 3 \r\n" + 
     		"     		and M.OrgBranchID =102 \r\n" + 
     		"     		and IsFreezed=0	\r\n" + 
     		"     		order by InterestEffectFrom desc \r\n" + 
     		"     		)AS A \r\n" + 
     		"     		WHERE A.TrnUnauthCount = 0"; 
  
     ResultSet rs1= stmt.executeQuery(Q_datefetch);
     int counter=0;
  
     while(rs1.next()) {
              counter=counter+1;    	   
  	          ACNO=rs1.getString(1);
  	
      }
     if (counter==0) {
    	 
    	   Driver.tcFlag = "FAIL";
     	   Driver.comment = "Database did not return any records";
     	   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
     }else {
    	 try {
        String AccNo=ACNO.substring(10, 15);
        System.out.println("ACCOUNT NUMBER:"+ACNO);
		
        System.out.println("ACCOUNT NO:"+AccNo);
     
        driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
        Driver.tcFlag = "PASS";
        Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    	 }catch(Exception e) {
    		 Driver.tcFlag = "FAIL";
     		Driver.comment = "Required object is not displayed or not identified";
     		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
    	 }
     }
 
		}else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		   
}
//===========================================================================================================================
//=========================================================================================================================== 
 public static void getCashCreditODAcNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException, IOException {	

	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {


	 Statement stmt = con.createStatement();	
	 
	 String Q_datefetch = "EXEC QAFETCHODACCOUNTS 2,102";
//	 		+ "--DECLARE @DbDate DATETIME = (SELECT CurrentTransDate FROM  TransactionDate)\r\n" +
//	 		 "select AcNo\r\n" + 
//              "             FROM(  \r\n" + 
//              "             SELECT  TOP(20)    \r\n" + 
//              "             AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount  \r\n" + 
//              "             from viAccMaster m  \r\n" + 
//              "             where m.ProductID = 24001  \r\n" + 
//              "             and AcStartDate >'01 jan 2010'  \r\n" + 
//              "             --and OpenDate <(select CurrentTransDate from TransactionDate)  \r\n" + 
//              "             and duedate>(select CurrentTransDate from TransactionDate)and DueDateCCLoan>(select CurrentTransDate from TransactionDate) \r\n" + 
//              "             and IsClosed =0   \r\n" + 
//              "             and M.RecordStatus = 3   \r\n" + 
//              "             and M.OrgBranchID =102   \r\n" + 
//              "             and IsFreezed=0        \r\n" + 
//              "--and m.AcNo in (SELECT  Acno	FROM  FnGetOutstanding ('24001',@DbDate,102) WHERE  PrnBal > 0   \r\n" +
//              "             and m.AccMasterID not in (select accmasterid from   interestpostingdetails d join \r\n" + 
//              "              interestpostingmaster m on d.intapplicationid=m.intapplicationid where\r\n" + 
//              "               PostingDate =(select * from transactiondate))\r\n" + 
//              "             order by InterestEffectFrom desc  \r\n" + 
//              "             )AS A  \r\n" + 
//              "             WHERE A.TrnUnauthCount = 0";
	 /*String Q_datefetch="select AcNo\r\n" + 
	 " FROM(\r\n" + 
	 " SELECT TOP(30) \r\n" + 
	 " AcNo , AcDisplayName ,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount \r\n" + 
	 " from viAccMaster m \r\n" + 
	 " where m.ProductID = 24001\r\n" + 
	 " and OpenDate <(select CurrentTransDate from TransactionDate) \r\n" + 
	 " and duedate>(select CurrentTransDate from TransactionDate) \r\n" + 
	 " and IsClosed =0 \r\n" + 
	 " and M.RecordStatus = 3 \r\n" + 
	 " and M.OrgBranchID =102 \r\n" + 
	 " and IsFreezed=0	\r\n" + 
	 " order by InterestEffectFrom desc \r\n" + 
	 " )AS A \r\n" + 
	 " WHERE A.TrnUnauthCount = 0"; 
	*/
	 ResultSet rs1= stmt.executeQuery(Q_datefetch);
     int counter=0;
	 while(rs1.next()) {
     counter=counter+1;
	 ACNO=rs1.getString(1);

	 }
	 
	 if(counter==0) {
		 
		 Driver.tcFlag = "FAIL";
   	     Driver.comment = "Database did not return any records";
   	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	 }else {
		 try {
	 String AccNo=ACNO.substring(10, 15);
	 System.out.println("ACCOUNT NUMBER:"+ACNO);

	 System.out.println("ACCOUNT NO:"+AccNo);

	 driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
	 Properties prop=new Properties();
	 FileOutputStream fos = new FileOutputStream("./DataFiles/CashCreditAccountNo.properties");
	 prop.setProperty("CashCreditODAccountNo", AccNo);
	 System.out.println("Written ");
	 prop.store(fos, "Done");
	 fos.close();
	 Driver.tcFlag = "PASS";
     Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription, Driver.comment);
		 }catch(Exception e) {
			 Driver.tcFlag = "FAIL";
     		Driver.comment = "Required object is not displayed or not identified";
     		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
		 }
	 }

	 }	else {
		 
		    Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		 
	 }

	 }
//===========================================================================================================================
//=========================================================================================================================== 
 public static void ReadCashCreditODAccountNo(String propertyValue) throws IOException {
try {		
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/CashCreditAccountNo.properties");
		prop.load(input);
		String CCODAccount = prop.getProperty("CashCreditODAccountNo");
		Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(CCODAccount);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = "Fail";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
}
//===========================================================================================================================
//=========================================================================================================================== 
 public static void getCustomerIdforAClass(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
		
	 String CustID=null;
	 //System.out.println("inside method");
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {	
    
     Statement stmt = con.createStatement();	
     
     String Q_datefetch="SELECT DISTINCT m.Cust_ID\r\n" + 
     		"FROM CustMaster m\r\n" + 
     		"JOIN viAccMaster a ON m.Cust_ID = a.Cust_ID\r\n" + 
     		"WHERE m.Cust_ID not in (select Cust_ID from viaccmaster where ProductID IN (1001, 2001))\r\n" + 
     		"	AND m.IsKYCCompleted = 1\r\n" + 
     		"	AND len(displayname)<20\r\n" +
     		"	AND m.Branch_ID = 102 and a.recordstatus=3"; 
     ResultSet rs1= stmt.executeQuery(Q_datefetch);
     int counter = 0;
     while(rs1.next()) {
     	counter = counter + 1;
     	CustID=rs1.getString(1);
     	
     }
     
	if (counter == 0) {
		Driver.tcFlag = "FAIL";
		Driver.comment = "Database did not return any records";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	}else {
		try {
     System.out.println("customer id "+CustID);
     
     driver.findElement(By.xpath(propertyValue)).sendKeys(""+CustID);
     
     driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_ucProductAccInfo_btnAddCustomer']")).click();
     
    System.out.println("Exit");
		}catch(Exception e) {
			Driver.tcFlag = "FAIL";
    		Driver.comment = "Required object is not displayed or not identified";
    		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
		}
	}
		}else {
			Driver.tcFlag = "FAIL";
			Driver.comment = "Connection to database is not successfull";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
		}
 }
 
//===========================================================================================================================
//===========================================================================================================================  
 public static void getSecondCustomerId(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException, Exception {
		
	String CustID=null;
	System.out.println("inside method");
    Connection con=(Connection) Common.DatabaseConnector();
	if(con !=null) {
 
        Statement stmt = con.createStatement();	
  
        String Q_datefetch="SELECT DISTINCT Top 9 Cust_ID FROM CustMaster where IsKYCCompleted=1\r\n" + 
  		     "and Age < 50 and LEN(Cust_id)>4 and Branch_ID =102 and CustType_ID=1"; 
        ResultSet rs1= stmt.executeQuery(Q_datefetch);
        int counter=0;
        while(rs1.next()) {
  	        counter=counter+1;
  	        CustID=rs1.getString(1);
  	
         }
		if(counter==0) {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Database did not return any records";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			
		}else {
			try {
        System.out.println("customer id "+CustID);
        driver.findElement(By.xpath(propertyValue)).sendKeys(""+CustID);
        driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_btnAddCustomer']")).click();
			}catch(Exception e) {
				Driver.tcFlag = "FAIL";
        		Driver.comment = "Required object is not displayed or not identified";
        		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			}
		}
  
  	
			} else {
				
				Driver.tcFlag = "FAIL";
				Driver.comment = "Connection to database is not successfull";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
				
			}
 
	}
 public static void GetODKCCAcNoForCashCrediRenewalBatch(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException, IOException {	

	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {
	 Statement stmt = con.createStatement();	
	 String Q_datefetch = "select acno											\r\n" + 
						  "from viaccmaster										\r\n" + 
						  "where productid=24001								\r\n" + 
						  "and orgbranchid=102									\r\n" + 
						  "and isclosed=0										\r\n" + 
						  "and opendate < (select * from transactiondate)		\r\n" + 
						  "and duedate >= (select * from transactiondate)		\r\n" + 
						  "order by acno desc";
	 ResultSet rs1= stmt.executeQuery(Q_datefetch);
     int counter=0;
	 while(rs1.next()) {
     counter=counter+1;
	 ACNO=rs1.getString(1);

	 }
	 
	 if(counter==0) {
		 
		 Driver.tcFlag = "FAIL";
   	     Driver.comment = "Database did not return any records";
   	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	 }else {
		 try {
	 String AccNo=ACNO.substring(10, 15);
	 System.out.println("ACCOUNT NUMBER:"+ACNO);

	 System.out.println("ACCOUNT NO:"+AccNo);

	 driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
	 Properties prop=new Properties();
	 FileOutputStream fos = new FileOutputStream("./DataFiles/CashCreditAccountNo.properties");
	 prop.setProperty("CashCreditODAccountNo", AccNo);
	 System.out.println("Written ");
	 prop.store(fos, "Done");
	 fos.close();
	 Driver.tcFlag = "PASS";
     Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription, Driver.comment);
		 }catch(Exception e) {
			 Driver.tcFlag = "FAIL";
     		Driver.comment = "Required object is not displayed or not identified";
     		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
		 }
	 }

	 }	else {
		 
		    Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		 
	 }

	 }
 
}
//===========================================================================================================================
//=========================================================================================================================== 
