package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FetchDDCredit_TransID {
public static void ReadAcNo_DDCreditCash(String propertyValue ) throws IOException {
try {		  
		  Properties prop = new Properties();
		  InputStream input = new FileInputStream("./DataFiles/DD_CASH_Details.properties");
		  prop.load(input);
		  
		  String accountNumber = prop.getProperty("DD_AccountNumber");
		  String Acno= accountNumber.substring(9, 15);
		  Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(Acno); 
}catch(Exception e) {
	
	  Driver.tcFlag = "FAIL";
	  Driver.comment = "AccNo is null";
	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
}
		 }
public static void ReadAcNo_DDCrAutopost(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
	
       System.out.println("READ DD CREDIT ACCOUNT NUMBER");
	   String ACNO=null;
	   Connection con=(Connection) Common.DatabaseConnector();
	   if(con !=null) {


      Statement stmt = con.createStatement();	
      String Q_datefetch = "select distinct AcNo,AgentCode FROM( SELECT  TOP(10)  AcNo , AcDisplayName ,AgentCode, (SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS                 TrnUnauthCount from viAccMaster m where m.ProductID = 15001 and AcStartDate >'01 jan 2010' and duedate>(select CurrentTransDate from TransactionDate) and IsClosed =0 and M.RecordStatus = 3 and M.OrgBranchID =108 and IsFreezed=0	 order by InterestEffectFrom desc )AS A WHERE A.TrnUnauthCount = 0 ";
    //Commented below query on Feb 12th, 2019 and added above line
    /*String Q_datefetch="select distinct AcNo,AgentCode\r\n" + 
    		"FROM(\r\n" + 
    		"SELECT  TOP(10) \r\n" + 
    		"		AcNo , AcDisplayName ,AgentCode, (SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
    		"from viAccMaster m\r\n" + 
    		"where m.ProductID = 15001\r\n" + 
    		"	and AcStartDate >'01 jan 2010'\r\n" + 
    		"	and duedate>(select CurrentTransDate from TransactionDate)\r\n" + 
    		"	and IsClosed =0\r\n" + 
    		"	and M.RecordStatus = 3\r\n" + 
    		"	and M.OrgBranchID =108\r\n" + 
    		"	and IsFreezed=0	\r\n" + 
    		"	order by InterestEffectFrom desc\r\n" + 
    		")AS A\r\n" + 
    		"WHERE A.TrnUnauthCount = 0"; 
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
    	  
		  
      }
      //System.out.println("2: ");
      else {
      String AccNo=ACNO.substring(10, 15);
      System.out.println("ACCOUNT NUMBER:"+ACNO);
	  System.out.println("ACCOUNT NO:"+AccNo);
    
      driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
      Driver.tcFlag = "PASS";
      Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
      }

		}else {
			  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database connection is not successfull";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			
		}
		   
}
public static void ReadAgentCode_DDCrAutopost(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
	
     System.out.println("READ DD CREDIT AGENTCODE");
	 String ACNO=null;
	 String AgentCode=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {


         Statement stmt = con.createStatement();	
         String Q_datefetch="select AcNo,AgentCode\r\n" + 
    		"FROM(\r\n" + 
    		"SELECT  TOP(10) \r\n" + 
    		"		AcNo , AcDisplayName ,AgentCode,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
    		"from viAccMaster m\r\n" + 
    		"where m.ProductID = 15001\r\n" + 
    		"	and AcStartDate >'01 jan 2010'\r\n" + 
    		"	and duedate<(select CurrentTransDate from TransactionDate)\r\n" + 
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
 	          AgentCode=rs1.getString(2);
 	
         }
        if(counter==0) {
        	
        	  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
        }
        else {
        String AccNo=ACNO.substring(10, 15);
        //System.out.println("ACCOUNT NUMBER:"+ACNO);
		System.out.println("ACCOUNT NO:"+AccNo);
		System.out.println("AGENT CODE:"+AgentCode);
    
        driver.findElement(By.xpath(propertyValue)).sendKeys(""+AgentCode);
        Driver.tcFlag = "PASS";
        Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
        }
		}else {
			  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database connection is not successfull";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			
		}
		   
}
public static void ReadAcNo_RDCreditCash(String propertyValue ) throws IOException {
	
try {	
	  
	  Properties prop = new Properties();
	  InputStream input = new FileInputStream("./DataFiles/RDAccountOpening_CashMode.properties");
	  prop.load(input);
	  
	  String accountNumber = prop.getProperty("FDAc_AccountNumber");
	  String Acno= accountNumber.substring(9, 15);
	  Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(Acno); 
}catch(Exception e) {
	  Driver.tcFlag = "FAIL";
	  Driver.comment = "AccNo is null";
	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	
}
	 }
public static void ReadAcNo_RDCrAutopost(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {	
	
     System.out.println("READ RD CREDIT ACCOUNT NUMBER");
	 String ACNO=null;
	 Connection con=(Connection) Common.DatabaseConnector();
	 if(con !=null) {


        Statement stmt = con.createStatement();	
        String Q_datefetch="select  AcNo,AgentCode\r\n" + 
    		"FROM(\r\n" + 
    		"SELECT  TOP(10) \r\n" + 
    		"		AcNo , AcDisplayName ,AgentCode,(SELECT COUNT(TransID)FROM Transactions t where RecordStatus Not IN (3,6) AND t.AccMasterID=m.AccMasterID)AS TrnUnauthCount\r\n" + 
    		"from viAccMaster m\r\n" + 
    		"where m.ProductID = 14001\r\n" + 
    		"	and AcStartDate >'01 jan 2010'\r\n" + 
    		"	and duedate>(select CurrentTransDate from TransactionDate)\r\n" + 
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
       String AccNo=ACNO.substring(10, 15);
       System.out.println("ACCOUNT NUMBER:"+ACNO);
	   System.out.println("ACCOUNT NO:"+AccNo);
    
       driver.findElement(By.xpath(propertyValue)).sendKeys(""+AccNo);
       Driver.tcFlag = "PASS";
       Driver.comment = "Pass"+" # "+"Account No: " +AccNo;
	   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
       }

		}else {
			
			  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database connection is not successfull";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
		}
		   
}

}