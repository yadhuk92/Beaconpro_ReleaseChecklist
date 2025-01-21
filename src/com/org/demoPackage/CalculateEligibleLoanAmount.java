package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculateEligibleLoanAmount {
 


 public static void CalculateAmountForDepositLoan(WebDriver driver,String propertyValue) {
	 
try {	 
  
     String worthAmount=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtTotWorth_txt']")).getAttribute("value");
     float WorthAmt= Float.parseFloat(worthAmount);
  
     float eligibleAmount= (WorthAmt*50)/100;
  
     String eligibleAmt= String.valueOf(eligibleAmount);
     driver.findElement(By.xpath(propertyValue)).sendKeys(eligibleAmt);
     Driver.tcFlag = "PASS";
     Driver.comment = "Pass"+" # "+"EligibleAmount: " +eligibleAmt;
     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment); 
}catch(Exception e) {
	
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Required object is not displayed or identified";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
}
  
 }

public static void CalculateAmountForOtherLoan(WebDriver driver,String propertyValue) throws Exception, SQLException {
  
 String DocSecEligibleAmount[]=new String[10];
 double MarketValue=0.00;
try {


 String marketvalue= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtTotWorth_txt']")).getAttribute("value");
 
 MarketValue=Double.parseDouble(marketvalue);
 
 //System.out.println(" market value "+MarketValue);
 
 Connection con=(Connection) Common.DatabaseConnector();
 if(con!=null) {
  
  String sqlquery =("exec QaOLLoanEligibleAmount " +23001+ ","+MarketValue);
  Statement stmt = con.createStatement();
      ResultSet rs2 = stmt.executeQuery(sqlquery);
      int counter=0;
      while (rs2.next()) 
       
      {
       counter=counter+1;
       DocSecEligibleAmount[0] = rs2.getString("DocSecEligibleAmount");
      
      } 
      if(counter==0) {
    	  
    	  Driver.tcFlag = "FAIL";
    	  Driver.comment = "Database did not return any records";
    	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
      }else {
  driver.findElement(By.xpath(propertyValue)).sendKeys(DocSecEligibleAmount[0]);
  Driver.tcFlag = "PASS";
  Driver.comment = "Pass"+" # "+"Amount: " +DocSecEligibleAmount[0];
  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment); 
      }
 }
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = "Failed to connect to database";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
}
}

public static void CalculateAmountForOtherGoldLoan(WebDriver driver,String propertyValue) throws Exception, SQLException {
	
	 String DocSecEligibleAmount[]=new String[10];
	 String netWeight;
	
	
	
	//String NetWeight= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpJewels_JSF_txtMarkValue_txt']")).getAttribute("value");
	
	 Properties prop=new Properties();
	 InputStream input = new FileInputStream("./DataFiles/GL_CASH_Details.properties");
	 prop.load(input);
	 netWeight=prop.getProperty("NetWeight");
	
	//System.out.println(" Net Weight "+netWeight);
	
	 float Net_weight= Float.parseFloat(netWeight);
	
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con!=null) {
		
		  String sqlquery =("exec QaJewelLoanDetails " +21001+ ","+Net_weight);
		  Statement stmt = con.createStatement();
	      ResultSet rs2 = stmt.executeQuery(sqlquery);
	      int counter=0;
	      while (rs2.next()) 
	      
	            {
                 counter=counter+1;	    
	             DocSecEligibleAmount[0] = rs2.getString("EligibleAmt");
	     
	            }	
          if(counter==0) {
        	  
        	  Driver.tcFlag = "FAIL";
        	  Driver.comment = "Database did not return any records";
        	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
           }else {
	      float value=Float.parseFloat(DocSecEligibleAmount[0]); 
	    
	      float valueOriginal= Math.round(value);
	   
		  driver.findElement(By.xpath(propertyValue)).sendKeys(""+String.valueOf(valueOriginal));
		
		  Driver.tcFlag = "PASS";
		  Driver.comment = "Pass" + " # " + "Eliglible Amount is  " + DocSecEligibleAmount[0] ;
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
           }
	}else {
		
		Driver.tcFlag = "FAIL";
		Driver.comment = "Failed to connect to database";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	}
		
}
public static void CalculateAmountForOtherOD(WebDriver driver,String propertyValue) throws Exception, SQLException {
	
	String DocSecEligibleAmount[]=new String[10];
	double MarketValue=0.00;
try {	
	String marketvalue= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtTotWorth_txt']")).getAttribute("value");
	
	 MarketValue=Double.parseDouble(marketvalue);
	
	//System.out.println(" market value "+MarketValue);
	
	Connection con=(Connection) Common.DatabaseConnector();
	if(con!=null) {
		
		String sqlquery =("exec QaOLLoanEligibleAmount " +24001+ ","+MarketValue);
		Statement stmt = con.createStatement();
	     ResultSet rs2 = stmt.executeQuery(sqlquery);
	     int counter=0;
	     while (rs2.next()) 
	      
	     {
	      counter=counter+1;
	      DocSecEligibleAmount[0] = rs2.getString("DocSecEligibleAmount");
	     
	     }
	     if(counter==0) {
	    	 
	    	 Driver.tcFlag = "FAIL";
       	     Driver.comment = "Database did not return any records";
       	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	    	 
	     }else {
		driver.findElement(By.xpath(propertyValue)).sendKeys(DocSecEligibleAmount[0]);
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "Eliglible Amount is  " + DocSecEligibleAmount[0] ;
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	     }
	}else {
		
		Driver.tcFlag = "FAIL";
		Driver.comment = "Failed to connect to database";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	}
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = "Required object is not displayed or identified";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
}
}
}