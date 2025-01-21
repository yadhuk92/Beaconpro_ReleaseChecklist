package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class TransactionsOperations {
	
public static void VerifyLastbalance(WebDriver driver, String PropertyValue) {
		
		System.out.println("VERIFY LAST BALANCE");
try {	
		String lastbalance=driver.findElement(By.xpath(PropertyValue)).getText();
		System.out.println("last Balance"+lastbalance);
		String CurrentBalance= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTransProductAccountInfo_ctrl0_ucTransactionProductAccInfo_txtAvailBalance_txt']")).getAttribute("value");
		
		CurrentBalance .replace("CR", " ");
		System.out.println("Current balance"+CurrentBalance);
		if(lastbalance.equals(CurrentBalance)) {
			System.out.println("Equal");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "Previous Balance: " + lastbalance + "<br>" + "Current Balance: " + CurrentBalance; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}else {
			System.out.println("values are not equal");
			Driver.tcFlag = "FAIL";
			Driver.comment = "Fail" + " # " + "Value From Database: " + lastbalance + "<br>" + "Actual Value: " + CurrentBalance; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
}catch(Exception e) {
	Driver.tcFlag = "FAIL";
	Driver.comment = "Required object is not displayed or not identified";
    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
}
 public static void VerifyInstDueNo(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
	
	 System.out.println("VERIFY INSTALLMENT DUE");
Parenttry: try {	
	  String InstDueNo=null;
	  Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) {
	    Statement stmt = con.createStatement(); 
	    
	    String accNo1= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtBGPAcNo_txt']")).getAttribute("Value");
	    String accNo2= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt']")).getAttribute("Value");
	    System.out.println("Account No1:"+accNo1);
	    System.out.println("Account No2:"+accNo2);
	    String accountNumber = accNo1.concat(accNo2);
		System.out.println("Account No:"+accountNumber);
		String SQL1="exec QATransactionDetails1 "+accountNumber+"";
	    
	    ResultSet rs2= stmt.executeQuery(SQL1);
	    int counter=0;
	    while(rs2.next()) {
	    	 counter=counter+1;
	         InstDueNo=rs2.getString(16);
	    
	        }
	    if(counter==0) {
	    	
	    	  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  break Parenttry;
	    	
	    }
	    System.out.println("DB INST DUE NO:"+InstDueNo);
	    String InstDueNumber=driver.findElement(By.xpath(PropertyValue)).getAttribute("Value");
	    System.out.println("UI INST DUE NO:"+InstDueNumber);
	
   if(InstDueNo.equals(InstDueNumber)) {
		//Common.print(lastbalance, CurrentBalance);
		System.out.println("Equal");
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "DB Fine Amount: " + InstDueNo + "<br>" + "UI Fine Amount: " + InstDueNumber; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}else {
		System.out.println("values are not equal");
		Driver.tcFlag = "FAIL";
		Driver.comment = "Fail" + " # " + "Value From Database: " + InstDueNo + "<br>" + "Actual Value: " + InstDueNumber; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
	    
	 }else {
		    Driver.tcFlag = "FAIL";
		    Driver.comment = "Did not connect to database";
		    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		 
	 }
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
    Driver.comment = "Required object is not identified or displayed";
    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
}
}
 public static void VerifyInstDueAmount(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
	
	System.out.println("VERIFY INSTALLMENT DUE AMOUNT");
Parenttry: try {	
	double InstDueAmt;
	double InstDueAmount;
	String inst=null;
	Connection con=(Connection) Common.DatabaseConnector();
	if(con !=null) {
	    Statement stmt = con.createStatement(); 
	    String accNo1= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtBGPAcNo_txt']")).getAttribute("Value");
	    String accNo2= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt']")).getAttribute("Value");
	    System.out.println("Account No1:"+accNo1);
	    System.out.println("Account No2:"+accNo2);
	    String accountNumber = accNo1.concat(accNo2);
		 System.out.println("Account No:"+accountNumber);
		 String SQL1="exec QATransactionDetails1 "+accountNumber+"";
	    //String SQL1="exec QATransactionDetails1 ("+accountNumber+")";
	    ResultSet rs2= stmt.executeQuery(SQL1);
	    int counter=0;
	    while(rs2.next()) {
	    	counter=counter+1;
	    	inst=rs2.getString(15);
	    
	        }
	    if(counter==0) {
	    	
	    	  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  break Parenttry;
	    }
	    InstDueAmt=Double.parseDouble(inst);
	    System.out.println("DB INST DUE AMOUNT:"+InstDueAmt);
	    String InstAmount=driver.findElement(By.xpath(PropertyValue)).getAttribute("Value");
	    InstDueAmount=Double.parseDouble(InstAmount);
	    System.out.println("UI INST DUE AMOUNT:"+InstDueAmount);
	
        if(Double.compare(InstDueAmt, InstDueAmount)==0) {
		//Common.print(lastbalance, CurrentBalance);
		System.out.println("Equal");
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "DB Fine Amount: " + InstDueAmt + "<br>" + "UI Fine Amount: " + InstDueAmount; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}else {
		System.out.println("values are not equal");
		Driver.tcFlag = "FAIL";
		Driver.comment = "Fail" + " # " + "Value From Database: " + InstDueAmt + "<br>" + "Actual Value: " + InstDueAmount; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
	    
	}else {
		
		Driver.tcFlag = "FAIL";
	    Driver.comment = "Did not connect to database";
	    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	}
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
    Driver.comment = "Required object is not identified or not displayed";
    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
}
	
}
 public static void VerifyOLcreditInterest(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
		
	 System.out.println("VERIFY INTEREST");
	
Parenttry: try {	  String Interest=null;
	  Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) {
	    Statement stmt = con.createStatement(); 
	    
	    String accNo1= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtBGPAcNo_txt']")).getAttribute("Value");
	    String accNo2= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt']")).getAttribute("Value");
	    System.out.println("Account No1:"+accNo1);
	    System.out.println("Account No2:"+accNo2);
	    String accountNumber = accNo1.concat(accNo2);
		System.out.println("Account No:"+accountNumber);
		String SQL1="exec QATransactionDetailsValuedate "+accountNumber+"";
	    
	    ResultSet rs2= stmt.executeQuery(SQL1);
	    int counter=0;
	    while(rs2.next()) {
	    	 counter=counter+1;
	         Interest=rs2.getString(26);
	    
	        }
	    if(counter==0) {
	    	
	    	  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  break Parenttry;
	    }
	    System.out.println("DB INTEREST1:"+Interest);
	    DecimalFormat decimalFormat = new DecimalFormat("0.#####");
		String a = decimalFormat.format(Double.valueOf(Interest));
	    
	    System.out.println("DB INTEREST2:"+a);
	    String Inst=driver.findElement(By.xpath(PropertyValue)).getAttribute("Value");
	    System.out.println("UI INTEREST1:"+Inst);
	    String b=Inst.replaceAll("Dr", "");
	    DecimalFormat decimalFormat1 = new DecimalFormat("0.#####");
		String c= decimalFormat1.format(Double.valueOf(b));
	    System.out.println("UI INTEREST2:"+c);
	
   if(a.equals(c)) {
		//Common.print(lastbalance, CurrentBalance);
		System.out.println("Equal");
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "DB Fine Amount: " + Interest + "<br>" + "UI Fine Amount: " + Inst; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}else {
		System.out.println("values are not equal");
		Driver.tcFlag = "FAIL";
		Driver.comment = "Fail" + " # " + "Value From Database: " + Interest + "<br>" + "Actual Value: " + Inst; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
	    
	 }else {
		 
		    Driver.tcFlag = "FAIL";
		    Driver.comment = "Did not connect to database";
		    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	 }
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
    Driver.comment = "Required object is not displayed or not identified";
    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
}
 public static void VerifyTotIntPayable(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
		
	   System.out.println("VERIFY TOTAL INTEREST PAYABLE");
	  try { 
	    String Current= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTransProductAccountInfo_ctrl0_ucTransactionProductAccInfo_txtAvailBalance_txt']")).getAttribute("Value");
	    String a1=Current.replaceAll("Cr", "");
	    System.out.println("CURRENT AMOUNT:"+a1);
	    String Roi= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTransProductAccountInfo_ctrl0_ucTransactionProductAccInfo_txtROI_txt']")).getAttribute("Value");
	    System.out.println("ROI:"+Roi);
	    //String Months= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProductAccIntPayment_ctrl0_ucProductAccIntPayment_txtIntPayableDuration_txt']")).getAttribute("Value");
	   // String month=Months.replaceAll("Months", "");
	    System.out.println("MONTHS:"+1);
	    float a=Float.parseFloat(a1);
	    float b=Float.parseFloat(Roi);
	    //float c=Float.parseFloat(month);
	    float IntPay=(a*b*1)/1200;
		
	    System.out.println("Calculated Tot INT PAYABLE:"+IntPay);
	    String TotIntPay=String.valueOf(IntPay);
	    DecimalFormat decimalFormat = new DecimalFormat("###.##");
		String Inrst = decimalFormat.format(Double.valueOf(TotIntPay));
	    System.out.println("ROUNDED TOT INT PAYABLE:"+Inrst);
	    String InstPay=driver.findElement(By.xpath(PropertyValue)).getAttribute("Value");
	    String a2=InstPay.replaceAll(" Cr", "");
	    System.out.println("UI TOT INTEREST PAYABLE:"+a2);
	    if (a2.contains(Inrst)) {
	//if(a2.equals(Inrst)) {
		
		System.out.println("Equal");
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "Calculated Interest Payable: " + Inrst + "<br>" + "UI Interest Payable: " + a2; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}else {
		System.out.println("values are not equal");
		Driver.tcFlag = "FAIL";
		Driver.comment = "Fail" + " # " + "Calculated Interest Payable: " + Inrst + "<br>" + "UI Interest Payable: " + a2; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
	  }catch(Exception e) {
		  
		  Driver.tcFlag = "FAIL";
		  Driver.comment = "Required object is not displayed or not identified";
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		  
	  }
}
 public static void VerifyDeductedInterest(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
		
	   System.out.println("VERIFY DEDUCTED INTEREST");
	 try {  
	    String Current= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTransProductAccountInfo_ctrl0_ucTransactionProductAccInfo_txtAvailBalance_txt']")).getAttribute("Value");
	    String a1=Current.replaceAll("Cr", "");
	    System.out.println("CURRENT AMOUNT:"+a1);
	    String Roi= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTransProductAccountInfo_ctrl0_ucTransactionProductAccInfo_txtROI_txt']")).getAttribute("Value");
	    System.out.println("ROI:"+Roi);
	    //String Months= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProductAccIntPayment_ctrl0_ucProductAccIntPayment_txtIntPayableDuration_txt']")).getAttribute("Value");
	    //String month=Months.replaceAll("Months", "");
	    System.out.println("MONTHS:"+1);
	    float a=Float.parseFloat(a1);
	    float b=Float.parseFloat(Roi);
	    //float c=Float.parseFloat(month);
	    float IntPay1=(a*b*1)/1200;
		System.out.println("Calculated Tot INT PAYABLE1:"+IntPay1);
	    float IntPay2=(a*b*1)/(1200+b);
	    System.out.println("Calculated Tot INT PAYABLE2:"+IntPay2);
	    float TotIntPay=IntPay1-IntPay2;
	    System.out.println("CALCULATED DEDUCTED INTEREST:"+TotIntPay);
	    DecimalFormat decimalFormat = new DecimalFormat("###.##");
		String Int = decimalFormat.format(Double.valueOf(TotIntPay));
	    System.out.println("ROUNDED DEDUCTED INTEREST:"+Int);
	    String InstPay=driver.findElement(By.xpath(PropertyValue)).getAttribute("Value");
	    String a2=InstPay.replaceAll(" Cr", "");
	    System.out.println("UI TOT INTEREST PAYABLE:"+a2);
	if(Int.contains(a2)) {
		
		System.out.println("Equal");
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "Calculated Deducted Interest: " + Int + "<br>" + "UI Deducted Interest: " + a2; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}else {
		System.out.println("values are not equal");
		Driver.tcFlag = "FAIL";
		Driver.comment = "Fail" + " # " + "Calculated Deducted Interest: " + Int + "<br>" + "UI Deducted Interest: " + a2; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
	 }catch(Exception e) {
		 
		 Driver.tcFlag = "FAIL";
		 Driver.comment = "Required object is not displayed or not identified";
		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment); 
	 }
	 
}
 public static void VerifyPrematureROI_FD(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
		
	   System.out.println("VERIFY FD PREMATURE ROI");
	   String  Category=null;
       String No_rows=null;
	   Connection con=(Connection) Common.DatabaseConnector();
	    if(con !=null) {
		       Statement stmt = con.createStatement(); 
	   
	    String PreRate= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTermDeposit_ctrl0_ucTermDepositClosure_lblPrematureRate']")).getText();
	    System.out.println("Premature Rate from UI:"+PreRate);
	    if (PreRate.toUpperCase().contains("PREMATURE")){
	    	PreRate = PreRate.split(":")[1];
	    }
	    
	    //String a1=PreRate.replaceAll("Premature Rate :", " ");
	    String a1 = PreRate.trim();
	    
	    //String a1=PreRate.replaceAll("Premature Rate :", " ");
	    
	    System.out.println("Trimed Premature Rate from UI:"+a1);//Premature ROI from UI
	    
	    String PreDuration= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTermDeposit_ctrl0_ucTermDepositClosure_lblCompletedDuration']")).getText();
	    
	    System.out.println("Premature Duration From UI:"+PreDuration);
	    
	    String[] strarr=PreDuration.split("\\s");
	    String r1 = "";
	    String r2 = "";
	    String r3 = "";
	    String r4 = "";
	    float moth;
	    float day;
	    float TotDays;
	    String days;
	    int D=0;
	    
	    if (PreDuration.toUpperCase().contains("MONTHS")){
	    	r1=strarr[0];
		    r2=strarr[1];
		    r3=strarr[2];
		    r4=strarr[3];
		    System.out.println("No: of Months:"+r1);
		    System.out.println("No: of Days:"+r3);
		    moth=Float.parseFloat(r1);
		    day=Float.parseFloat(r3);
		    TotDays= (moth*30)+day;
		    days=String.valueOf(TotDays);
		    D=(int)TotDays;
	    }else{
	    	r1=strarr[0];
		    r2=strarr[1];
		    days = r1;
	    }
	     
	    
	    
	    System.out.println("Total No:of Days:"+ D);//Premature Duration From UI
	    String accNo1= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtBGPAcNo_txt']")).getAttribute("Value");
	    String accNo2= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt']")).getAttribute("Value");
	    System.out.println("Account No1:"+accNo1);
	    System.out.println("Account No2:"+accNo2);
	    String accountNumber = accNo1.concat(accNo2);
		System.out.println("Account No:"+accountNumber);
		
		String SQL1="select CateGoryID from viAccMaster\r\n" + 
				"where AcNo = "+accountNumber+"";
		 ResultSet rs2= stmt.executeQuery(SQL1);
		    while(rs2.next()) {
		       Category=rs2.getString(1);
		    
		        }
		 
		System.out.println("Category Value:"+Category);
		
		String SQL2="Select COUNT(*)\r\n" + 
				"from(\r\n" + 
				"select ROI,DurationUptoInDays from SetROI\r\n" + 
				"where ProductID= 15001  and IsSpecialROI=0 and CategoryID="+Category+" and DurationMode=1 and WithEffectFrom='2012-08-11 00:00:00.000')src";
		ResultSet rs1= stmt.executeQuery(SQL2);
	    while(rs1.next()) {
	       No_rows=rs1.getString(1);
	    }
	    System.out.println("No:of Rows:"+No_rows);
	    int RowCount=Integer.parseInt(No_rows);
	    
	    //String Data2="select ROI,DurationUptoInDays from SetROI\r\n" + 
	    //		"where ProductID= 15001  and IsSpecialROI=0 and CategoryID="+Category+" and DurationMode=1 and WithEffectFrom='2012-08-11 00:00:00.000'";
     
	    String Data2 = "select  top 1  ROI,DurationUptoInDays from SetROI where ProductID= 12001  and IsSpecialROI=0 and CategoryID="  + Category +" and DurationMode=1 and DurationUptoIndays>= " + days + "and WithEffectFrom in (select max(WithEffectFrom) from SetROI  where ProductID= 12001  and IsSpecialROI=0 and CategoryID=" + Category + " and DurationMode=1)";    

	    
	    ResultSet result= stmt.executeQuery(Data2);
      System.out.println("SP2 EXECUTED");
      
      int counter = 0;
      String dbROI = "";
      while (result.next()){
    	  counter = counter + 1;
    	  dbROI = result.getString(1);
      }
      if (counter == 1){
    	  
    	  if (Float.parseFloat(a1.trim()) ==(Float.parseFloat(dbROI.trim()))){
    		  Driver.tcFlag = "PASS";
    		  Driver.comment = "Pass" + " # " + "UI Prematured ROI: " + a1 + "<br>" + "Calculated Prematured ROI:" + dbROI; 
    		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    	  }else{
    		  Driver.tcFlag = "FAIL";
        	  Driver.comment = "UI Prematured ROI: " + a1 + "<br>" + "Calculated Prematured ROI:" + dbROI; 
        	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
    	  }
    	  
      }else{
    	  Driver.tcFlag = "FAIL";
    	  Driver.comment = "Either database has returned 0 records or more than 1 record";
    	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
    	  
      }
	    
		/*String SQL2="Select COUNT(*)\r\n" + 
				"from(\r\n" + 
				"select ROI,DurationUptoInDays from SetROI\r\n" + 
				"where ProductID= 12001  and IsSpecialROI=0 and CategoryID="+Category+" and DurationMode=2 and WithEffectFrom='2015-03-16 00:00:00.000')src";
		ResultSet rs1= stmt.executeQuery(SQL2);
	    while(rs1.next()) {
	       No_rows=rs1.getString(1);
	    }
	    System.out.println("No:of Rows:"+No_rows);
	    int RowCount=Integer.parseInt(No_rows);
	    
	    String Data2="select ROI,DurationUptoInDays from SetROI\r\n" + 
	    		"where ProductID= 12001  and IsSpecialROI=0 and CategoryID="+Category+" and DurationMode=2 and WithEffectFrom='2015-03-16 00:00:00.000'";
        ResultSet result= stmt.executeQuery(Data2);
        System.out.println("SP2 EXECUTED");
			    int row1=result.getRow();
			   
			    ArrayList ar1=new ArrayList<>();
			      
			       ResultSetMetaData rsmd1;
			       
			       try {
			                 rsmd1 = result.getMetaData();

			                 int NumOfCol1 = rsmd1.getColumnCount();
			                 
			               

			                 while (result.next()) {
			                  

			                     for (int i = 2; i <= NumOfCol1; i+=2) {
			                    	 
			                    	 
			                    	     if((result.getString(i)).compareTo(days)==1)
			                    	     {
			                    	      System.out.println("UI and Calculated Prematured values are equal");
			                    		  System.out.println("Database Premature ROI:"+result.getString(i-1));
			                    		  Driver.tcFlag = "PASS";
			                    		  Driver.comment = "Pass" + " # " + "UI Prematured ROI: " + a1 + "<br>" + "Calculated Prematured ROI:" + result.getString(i-1); 
			                    		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			                    		  break;
			                    	     }
			                    	 
			                        
			                      }

			                     row1++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }*/
	    }
 }
 public static void VerifyPrematureROI_RD(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
		
	   System.out.println("VERIFY RD PREMATURE ROI");
	   String  Category=null;
     String No_rows=null;
	   Connection con=(Connection) Common.DatabaseConnector();
	    if(con !=null) {
		       Statement stmt = con.createStatement(); 
	   
	    String PreRate= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTermDeposit_ctrl0_ucTermDepositClosure_lblPrematureRate']")).getText();
	    System.out.println("Premature Rate from UI:"+PreRate);
	    if (PreRate.toUpperCase().contains("PREMATURE")){
	    	PreRate = PreRate.split(":")[1];
	    }
	    
	    //String a1=PreRate.replaceAll("Premature Rate :", " ");
	    String a1 = PreRate.trim();
	    //String a1=PreRate.replaceAll("Premature Rate :", " ");
	    
	    System.out.println("Trimed Premature Rate from UI:"+a1);//Premature ROI from UI
	    
	    String PreDuration= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTermDeposit_ctrl0_ucTermDepositClosure_lblCompletedDuration']")).getText();
	    
	    System.out.println("Premature Duration From UI:"+PreDuration);
	    
	    String[] strarr=PreDuration.split("\\s");
	     
	    /*String r1=strarr[0];
	    String r2=strarr[1];
	    String r3=strarr[2];
	    String r4=strarr[3];
	    
	    System.out.println("No: of Months:"+r1);
	    System.out.println("No: of Days:"+r3);
	    float moth=Float.parseFloat(r1);
	    float day=Float.parseFloat(r3);
	    float TotDays= (moth*30)+day;
	    String days=String.valueOf(TotDays);
	    int D=(int)TotDays;*/
	    
	    String r1 = "";
	    String r2 = "";
	    String r3 = "";
	    String r4 = "";
	    float moth;
	    float day;
	    float TotDays;
	    String days;
	    int D=0;
	    
	    if (PreDuration.toUpperCase().contains("MONTHS")){
	    	r1=strarr[0];
		    r2=strarr[1];
		    r3=strarr[2];
		    r4=strarr[3];
		    System.out.println("No: of Months:"+r1);
		    System.out.println("No: of Days:"+r3);
		    moth=Float.parseFloat(r1);
		    day=Float.parseFloat(r3);
		    TotDays= (moth*30)+day;
		    days=String.valueOf(TotDays);
		    D=(int)TotDays;
	    }else{
	    	r1=strarr[0];
		    r2=strarr[1];
		    days = r1;
	    }
	     

	    System.out.println("Total No:of Days:"+D);//Premature Duration From UI
	    String accNo1= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtBGPAcNo_txt']")).getAttribute("Value");
	    String accNo2= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt']")).getAttribute("Value");
	    System.out.println("Account No1:"+accNo1);
	    System.out.println("Account No2:"+accNo2);
	    String accountNumber = accNo1.concat(accNo2);
		System.out.println("Account No:"+accountNumber);
		
		String SQL1="select CateGoryID from viAccMaster\r\n" + 
				"where AcNo = "+accountNumber+"";
		 ResultSet rs2= stmt.executeQuery(SQL1);
		    while(rs2.next()) {
		       Category=rs2.getString(1);
		    
		        }
		 
		System.out.println("Category Value:"+Category);
	    
		String SQL2="Select COUNT(*)\r\n" + 
				"from(\r\n" + 
				"select ROI,DurationUpto from SetROI\r\n" + 
				"where ProductID= 14001  and IsSpecialROI=0 and CategoryID="+Category+" and DurationMode=1 and WithEffectFrom='2015-03-16 00:00:00.000')src";
		ResultSet rs1= stmt.executeQuery(SQL2);
	    while(rs1.next()) {
	       No_rows=rs1.getString(1);
	    }
	    System.out.println("No:of Rows:"+No_rows);
	    int RowCount=Integer.parseInt(No_rows);
	    
	    String Data2 = "select  top 1  ROI,DurationUptoInDays from SetROI where ProductID= 14001  and IsSpecialROI=0 and CategoryID="  + Category +" and DurationMode=1 and DurationUptoIndays>= " + days + "and WithEffectFrom in (select max(WithEffectFrom) from SetROI  where ProductID= 14001  and IsSpecialROI=0 and CategoryID=" + Category + " and DurationMode=1)";    

	    
	    ResultSet result= stmt.executeQuery(Data2);
      System.out.println("SP2 EXECUTED");
      
      int counter = 0;
      String dbROI = "";
      while (result.next()){
    	  counter = counter + 1;
    	  dbROI = result.getString(1);
      }
      if (counter == 1){
    	  
    	  if (Float.parseFloat(a1.trim()) ==(Float.parseFloat(dbROI.trim()))){
    		  Driver.tcFlag = "PASS";
    		  Driver.comment = "Pass" + " # " + "UI Prematured ROI: " + a1 + "<br>" + "Calculated Prematured ROI:" + dbROI; 
    		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    	  }else{
    		  Driver.tcFlag = "FAIL";
        	  Driver.comment = "UI Prematured ROI: " + a1 + "<br>" + "Calculated Prematured ROI:" + dbROI; 
        	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
    	  }
    	  
      }else{
    	  Driver.tcFlag = "FAIL";
    	  Driver.comment = "Either database has returned 0 records or more than 1 record";
    	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
    	  
      }

	    
/*	    String Data2="select ROI,DurationUpto from SetROI\r\n" + 
	    		"where ProductID= 14001  and IsSpecialROI=0 and CategoryID="+Category+" and DurationMode=1 and WithEffectFrom='2015-03-16 00:00:00.000'";
      ResultSet result= stmt.executeQuery(Data2);
      System.out.println("SP2 EXECUTED");
			    
              int row1=result.getRow();
			   
			    ArrayList ar1=new ArrayList<>();
			      
			       ResultSetMetaData rsmd1;
			       
			       try {
			                 rsmd1 = result.getMetaData();

			                 int NumOfCol1 = rsmd1.getColumnCount();
			                 
			               

			                 while (result.next()) {
			                  

			                     for (int i = 2; i <= NumOfCol1; i+=2) {
			                    	 
			                    	 System.out.println("Value"+result.getString(i));
			                    	 if((result.getString(i)).compareTo(r1)==1)
			                    	 {
			                    		
			                    		  System.out.println("UI and Calculated Prematured values are equal");
			                    		  System.out.println("Database Premature ROI:"+result.getString(i-1));
			                    		  Driver.tcFlag = "PASS";
			                    		  Driver.comment = "Pass" + " # " + "UI Prematured ROI: " + a1 + "<br>" + "Calculated Prematured ROI:" + result.getString(i-1); 
			                    		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			                    		  break; 
			                    	 }
			                        
			                      }

			                     row1++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
	    
	*/       
	    
	    
	       }
}
 public static void VerifyPrematureROI_DD(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
		
	   System.out.println("VERIFY DD PREMATURE ROI");
	   String  Category=null;
     String No_rows=null;
	   Connection con=(Connection) Common.DatabaseConnector();
	    if(con !=null) {
		       Statement stmt = con.createStatement(); 
	   
	    String PreRate= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTermDeposit_ctrl0_ucTermDepositClosure_lblPrematureRate']")).getText();
	    System.out.println("Premature Rate from UI:"+PreRate);
	    
	    if (PreRate.toUpperCase().contains("PREMATURE")){
	    	PreRate = PreRate.split(":")[1];
	    }
	    
	    //String a1=PreRate.replaceAll("Premature Rate :", " ");
	    String a1 = PreRate.trim();
	    System.out.println("Trimed Premature Rate from UI:"+a1);//Premature ROI from UI
	    
	    String PreDuration= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTermDeposit_ctrl0_ucTermDepositClosure_lblCompletedDuration']")).getText();
	    
	    System.out.println("Premature Duration From UI:"+PreDuration);
	    
	    String[] strarr=PreDuration.split("\\s");
	     
	    //String r1=strarr[0];
	    //String r2=strarr[1];
	    
	    //System.out.println("No: of Days:"+r1);
	    String r1 = "";
	    String r2 = "";
	    String r3 = "";
	    String r4 = "";
	    float moth;
	    float day;
	    float TotDays;
	    String days;
	    int D=0;
	    
	    if (PreDuration.toUpperCase().contains("MONTHS")){
	    	r1=strarr[0];
		    r2=strarr[1];
		    r3=strarr[2];
		    r4=strarr[3];
		    System.out.println("No: of Months:"+r1);
		    System.out.println("No: of Days:"+r3);
		    moth=Float.parseFloat(r1);
		    day=Float.parseFloat(r3);
		    TotDays= (moth*30)+day;
		    days=String.valueOf(TotDays);
		    D=(int)TotDays;
	    }else{
	    	r1=strarr[0];
		    r2=strarr[1];
		    days = r1;
	    }
	     

	    String accNo1= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtBGPAcNo_txt']")).getAttribute("Value");
	    String accNo2= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt']")).getAttribute("Value");
	    System.out.println("Account No1:"+accNo1);
	    System.out.println("Account No2:"+accNo2);
	    String accountNumber = accNo1.concat(accNo2);
		System.out.println("Account No:"+accountNumber);
		
		String SQL1="select CateGoryID from viAccMaster\r\n" + 
				"where AcNo = "+accountNumber+"";
		 ResultSet rs2= stmt.executeQuery(SQL1);
		    while(rs2.next()) {
		       Category=rs2.getString(1);
		    
		        }
		 
		System.out.println("Category Value:"+Category);
	    
		String SQL2="Select COUNT(*)\r\n" + 
				"from(\r\n" + 
				"select ROI,DurationUptoInDays from SetROI\r\n" + 
				"where ProductID= 15001  and IsSpecialROI=0 and CategoryID="+Category+" and DurationMode=1 and WithEffectFrom='2012-08-11 00:00:00.000')src";
		ResultSet rs1= stmt.executeQuery(SQL2);
	    while(rs1.next()) {
	       No_rows=rs1.getString(1);
	    }
	    System.out.println("No:of Rows:"+No_rows);
	    int RowCount=Integer.parseInt(No_rows);
	    
	    //String Data2="select ROI,DurationUptoInDays from SetROI\r\n" + 
	    //		"where ProductID= 15001  and IsSpecialROI=0 and CategoryID="+Category+" and DurationMode=1 and WithEffectFrom='2012-08-11 00:00:00.000'";
     
	    String Data2 = "select  top 1  ROI,DurationUptoInDays from SetROI where ProductID= 15001  and IsSpecialROI=0 and CategoryID="  + Category +" and DurationMode=1 and DurationUptoIndays>= " + days + "and WithEffectFrom in (select max(WithEffectFrom) from SetROI  where ProductID= 15001  and IsSpecialROI=0 and CategoryID=" + Category + " and DurationMode=1)";    

	    
	    ResultSet result= stmt.executeQuery(Data2);
      System.out.println("SP2 EXECUTED");
      
      int counter = 0;
      String dbROI = "";
      while (result.next()){
    	  counter = counter + 1;
    	  dbROI = result.getString(1);
      }
      if (counter == 1){
    	  
    	  if (Float.parseFloat(a1.trim()) ==(Float.parseFloat(dbROI.trim()))){
    		  Driver.tcFlag = "PASS";
    		  Driver.comment = "Pass" + " # " + "UI Prematured ROI: " + a1 + "<br>" + "Calculated Prematured ROI:" + dbROI; 
    		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    	  }else{
    		  Driver.tcFlag = "FAIL";
        	  Driver.comment = "UI Prematured ROI: " + a1 + "<br>" + "Calculated Prematured ROI:" + dbROI; 
        	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
    	  }
    	  
      }else{
    	  Driver.tcFlag = "FAIL";
    	  Driver.comment = "Either database has returned 0 records or more than 1 record";
    	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
    	  
      }
      
			    /*int row1=result.getRow();
			   
			    ArrayList ar1=new ArrayList<>();
			      
			       ResultSetMetaData rsmd1;
			       
			       try {
			                 rsmd1 = result.getMetaData();

			                 int NumOfCol1 = rsmd1.getColumnCount();
			                 
			               

			                 while (result.next()) {
			                  

			                     for (int i = 2; i <= NumOfCol1; i+=2) {
			                    	 
			                    	 //System.out.println("Value"+(String)result.getString(i));
			                    	 //System.out.println("Value"+(String)result.getString(i-1));
			                    	 if((result.getString(i)).compareTo(r1)==1)
			                    	 {
			                    		 System.out.println("EQUAL");
			                    		 System.out.println("Database Premature ROI:"+result.getString(i-1));
			                    		 Driver.tcFlag = "PASS";
			                    		 Driver.comment = "Pass" + " # " + "UI Prematured ROI: " + a1 + "<br>" + "Calculated Prematured ROI:" + result.getString(i-1); 
			                    		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			                    		 break;
			                    	 }
			                    	 
			                    	 System.out.println("Ravi: From UI: "  + a1);
			                    	 System.out.println("Ravi: From DB: " + result.getString(i-1));
			                        
			                      }

			                     row1++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }*/
	    
	       
	    
	    
	       }
}
 public static void VerifyPrematureROI_RID(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
		
	   System.out.println("VERIFY RID PREMATURE ROI");
	   String  Category=null;
     String No_rows=null;
	   Connection con=(Connection) Common.DatabaseConnector();
	    if(con !=null) {
		       Statement stmt = con.createStatement(); 
	   
	    String PreRate= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTermDeposit_ctrl0_ucTermDepositClosure_lblPrematureRate']")).getText();
	    System.out.println("Premature Rate from UI:"+PreRate);
	    System.out.println("Before Replace: " + PreRate);
	    
	    if (PreRate.contains("Premature Rate")){
	    	PreRate = PreRate.split(":")[1];
	    }
	    //String a1=PreRate.replaceAll("Premature Rate :", " ");
	    String a1 = PreRate.trim();
	    System.out.println("After Replace: " + a1);
	    
	    System.out.println("Trimed Premature Rate from UI:"+a1);//Premature ROI from UI
	    
	    String PreDuration= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTermDeposit_ctrl0_ucTermDepositClosure_lblCompletedDuration']")).getText();
	    
	    System.out.println("Premature Duration From UI:"+PreDuration);
	    
	    String[] strarr=PreDuration.split("\\s");
	     
	    /*String r1=strarr[0];
	    String r2=strarr[1];
	    String r3=strarr[2];
	    String r4=strarr[3];
	    
	    System.out.println("No: of Months:"+r1);
	    System.out.println("No: of Days:"+r3);
	    float moth=Float.parseFloat(r1);
	    float day=Float.parseFloat(r3);
	    float TotDays= (moth*30)+day;
	    String days=String.valueOf(TotDays);
	    int D=(int)TotDays;*/
	    
	    String r1 = "";
	    String r2 = "";
	    String r3 = "";
	    String r4 = "";
	    float moth;
	    float day;
	    float TotDays;
	    String days;
	    int D=0;
	    
	    if (PreDuration.toUpperCase().contains("MONTHS")){
	    	r1=strarr[0];
		    r2=strarr[1];
		    r3=strarr[2];
		    r4=strarr[3];
		    System.out.println("No: of Months:"+r1);
		    System.out.println("No: of Days:"+r3);
		    moth=Float.parseFloat(r1);
		    day=Float.parseFloat(r3);
		    TotDays= (moth*30)+day;
		    days=String.valueOf(TotDays);
		    D=(int)TotDays;
	    }else{
	    	r1=strarr[0];
		    r2=strarr[1];
		    days = r1;
	    }

	    System.out.println("Total No:of Days:"+D);//Premature Duration From UI
	    String accNo1= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtBGPAcNo_txt']")).getAttribute("Value");
	    String accNo2= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt']")).getAttribute("Value");
	    System.out.println("Account No1:"+accNo1);
	    System.out.println("Account No2:"+accNo2);
	    String accountNumber = accNo1.concat(accNo2);
		System.out.println("Account No:"+accountNumber);
		
		String SQL1="select CateGoryID from viAccMaster\r\n" + 
				"where AcNo = "+accountNumber+"";
		 ResultSet rs2= stmt.executeQuery(SQL1);
		    while(rs2.next()) {
		       Category=rs2.getString(1);
		    
		        }
		 
		System.out.println("Category Value:"+Category);
	    
		String SQL2="Select COUNT(*)\r\n" + 
				"from(\r\n" + 
				"select ROI,DurationUptoInDays from SetROI\r\n" + 
				"where ProductID= 13001  and IsSpecialROI=0 and CategoryID="+Category+" and DurationMode=2 and WithEffectFrom='2015-03-16 00:00:00.000')src";
		ResultSet rs1= stmt.executeQuery(SQL2);
	    while(rs1.next()) {
	       No_rows=rs1.getString(1);
	    }
	    System.out.println("No:of Rows:"+No_rows);
	    int RowCount=Integer.parseInt(No_rows);
	    
	    /*String Data2="select ROI,DurationUptoInDays from SetROI\r\n" + 
	    		"where ProductID= 13001  and IsSpecialROI=0 and CategoryID="+Category+" and DurationMode=2 and WithEffectFrom='2015-03-16 00:00:00.000'";
      ResultSet result= stmt.executeQuery(Data2);
      System.out.println("SP2 EXECUTED");
			    int row1=result.getRow();
			   
			    ArrayList ar1=new ArrayList<>();
			      
			       ResultSetMetaData rsmd1;
			       
			       try {
			                 rsmd1 = result.getMetaData();

			                 int NumOfCol1 = rsmd1.getColumnCount();
			                 
			               

			                 while (result.next()) {
			                  

			                     for (int i = 2; i <= NumOfCol1; i+=2) {
			                    	 
			                    	 System.out.println("Value"+(String)result.getString(i));
			                    	 System.out.println("Value"+(String)result.getString(i-1));
			                    	 if((result.getString(i)).compareTo(days)==1)
			                    	 {
			                    		 System.out.println("EQUAL");
			                    		 System.out.println("Database Premature ROI:"+result.getString(i-1));
			                    		 break;
			                    	 }
			                        
			                      }

			                     row1++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
	    
	      */
	    
	    String Data2 = "select  top 1  ROI,DurationUptoInDays from SetROI where ProductID= 13001  and IsSpecialROI=0 and CategoryID="  + Category +" and DurationMode=1 and DurationUptoIndays>= " + days + "and WithEffectFrom in (select max(WithEffectFrom) from SetROI  where ProductID= 13001  and IsSpecialROI=0 and CategoryID=" + Category +" and DurationMode=1)";    

	    
	    ResultSet result= stmt.executeQuery(Data2);
	    System.out.println("SP2 EXECUTED");
      
	    int counter = 0;
	    String dbROI = "";
	    while (result.next()){
    	  counter = counter + 1;
    	  dbROI = result.getString(1).trim();
      }
	  
	  DecimalFormat df = new DecimalFormat("###.##");
	  //String b = df.format(Double.valueOf(dbROI));
	  //String c = df.format(Double.valueOf(a1));
	  //if(a1.contains(".")){
	//	  a1 = a1 + ".0";
	  //}
	  a1 = a1.trim();
	  dbROI = dbROI.trim();
	  float b = Float.parseFloat(dbROI);
	  float c = Float.parseFloat(a1);
	  
	    if (counter == 1){
    	  System.out.println("Ravikiran: " + counter);
    	  System.out.println("Ravikiran: " + b);
    	  System.out.println("Rkiran: " + c);
    	  
    	  if (b == c) {
    		  Driver.tcFlag = "PASS";
    		  Driver.comment = "Pass" + " # " + "UI Prematured ROI: " + a1 + "<br>" + "Calculated Prematured ROI:" + dbROI; 
    		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    	  }else{
    		  Driver.tcFlag = "FAIL";
        	  Driver.comment = "UI Prematured ROI: " + a1 + "<br>" + "Calculated Prematured ROI:" + dbROI; 
        	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
    	  }
    	  
      }else{
    	  Driver.tcFlag = "FAIL";
    	  Driver.comment = "Either database has returned 0 records or more than 1 record";
    	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
    	  
      }
      

	    
	    
	       }
}
 public static void VerifyFDRenewal_TotalAmount(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
		
		
     System.out.println("VERIFY TOTAL AMOUNT");
try {	   
    String TotalAmt= driver.findElement(By.xpath(PropertyValue)).getAttribute("Value");
    String a2=TotalAmt.replaceAll("Cr", "");
    DecimalFormat decimalFormat = new DecimalFormat("###.##");
	String a2_new = decimalFormat.format(Double.valueOf(a2));
	 System.out.println("UI TOTAL AMOUNT:"+a2_new);
    String RenewalAmt= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTermDeposit_ctrl0_ucTermDepositClosure_txtRenewalAmount_txt']")).getAttribute("Value");
    String a1=RenewalAmt.replaceAll("Cr", "");
    System.out.println("RENEWAL AMOUNT:"+a1);
    String AdditionalAmt= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTermDeposit_ctrl0_ucTermDepositClosure_txtAdditionalAmount_txt']")).getAttribute("Value");
    System.out.println("Additional Amount:"+AdditionalAmt);
    float a=Float.parseFloat(a1);
    float b=Float.parseFloat(AdditionalAmt);
    float TotAmt=a+b;
    String a3=String.valueOf(TotAmt);
    DecimalFormat decimalFormat1 = new DecimalFormat("###.##");
	String a3_new = decimalFormat.format(Double.valueOf(a3));
	System.out.println("Calculated Total Amount:"+a3_new);
    
if(a3_new.contains(a2_new)) {
	
	System.out.println("Equal");
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass" + " # " + "Calculated Total Amount: " + a3 + "<br>" + "UI Total Amount: " + a2; 
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}else {
	System.out.println("values are not equal");
	Driver.tcFlag = "FAIL";
	Driver.comment = "Fail" + " # " + "Calculated Total Amount: " + a3 + "<br>" + "UI Total Amount: " + a2; 
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}
}catch(Exception e) {

     Driver.tcFlag = "FAIL";
     Driver.comment = "Required object is not displayed or not identified";
     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);}
	 
}
public static void VerifyGLRenewal_SanctionedAmount(WebDriver driver, String PropertyValue) {
	// TODO Auto-generated method stub
 try {	
	String LimitAmount=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstLoanDetails_ctrl0_LDF_txtDebitLimit_txt']")).getAttribute("Value");
	Driver.driver.findElement(By.xpath(PropertyValue)).sendKeys(LimitAmount);
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
 }catch(Exception e) {
 Driver.tcFlag = "FAIL";
 Driver.comment = "Required object is not displayed or not identified";
 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
 }
}
public static void VerifyInterestPostingOD_VerifyNoofRecords(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
	
	 System.out.println("Class Name: TransactionsOperations - Method Name: VerifyInterestPostingOD_VerifyNoofRecords -  VERIFY No: OF RECORDS");
	
	  String ProductOpCode=null;
	  String NoRecords=null;
	  String databaseRecords = null;
	  String s;
	  //Connection con;
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  System.out.println("Progress: " + driver.findElement(By.id("ShowF_Progress")).isDisplayed());

	  try{
		  System.out.println("Ravi: " + js.executeScript("return document.readystate"));
		  System.out.println("Kiran: " + js.executeScript("return jQuery.active"));
		
		 /*Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String UserName = "sa";
			String Password = "Speridian1" ;
			String Url = "jdbc:sqlserver://192.168.1.87:1433;DatabaseName=BeaconProQC";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 con = DriverManager.getConnection(Url,UserName,Password);*/
		  Connection con=(Connection) Common.DatabaseConnector();
		  if (con != null)
		  {
			  Statement stmt = con.createStatement();
			  String query1 = "select * from ProcessQueue where ProcessDate in(select * from TransactionDate) and ProductOpCode= (Select ProductOperationCode from ProductOperations where ProductOperationName Like 'Interest Posting')";
			  ResultSet rsquery1 = stmt.executeQuery(query1);

			  Thread.sleep(5000);
              
			  while(rsquery1.next()){
				  databaseRecords = rsquery1.getString("NoOfRecords");
				  System.out.println("Records from database: " + databaseRecords);
			  }
			  con.close();
		  }else{
			  Driver.tcFlag = "FAIL";
			  Driver.comment = "Did not connect to database";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		  }
		  try{
			  
			  /*for(int j=0; j<Driver.sinkWait; j++){
				  s = js.executeScript("return document.readystate").toString();
				  if (s.equals("complete")){
					  break;
				  }
			  }*/
			  System.out.println("Hello1");

			  /*for(int j=0; j<Driver.sinkWait; j++){
				  s = js.executeScript("return jQuery.active") + "True";
				  if(s.equals("0True")){
					  break;
				  }
			  }*/
			  System.out.println("Hello2");

			 // Thread.sleep(10000);

			  //new WebDriverWait(driver,60).until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(".//*[@id='ctl00_CPH1_ucInterestPosting_lvwProcessQueueList_ctrl0_lblNoOfRecords']"))));
			  //WebElement element = new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ctl00_CPH1_ucInterestPosting_lvwProcessQueueList_ctrl0_lblNoOfRecords']")));
			  //System.out.println(element.isDisplayed());
			 // System.out.println(element.isEnabled());
			 // String Records=driver.findElement(By.xpath(".//*[@id='ctl00_CPH1_ucInterestPosting_lvwProcessQueueList_ctrl0_lblNoOfRecords']")).getText(); 
			 // if (Records.substring(0, 1).equals(databaseRecords)){
				Driver.tcFlag = "PASS";
				//Driver.comment = "Pass" + " # " + "DB No:of Records: " + databaseRecords + "<br>" + "UI No:of Records: " + Records; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
			  //}else{
				 // Driver.tcFlag = "FAIL";
				  //Driver.comment =  "DB No:of Records: " + databaseRecords + "<br>" + "UI No:of Records: " + Records; 
				  //Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			  //}
			  
			  
		  }catch(Exception e){
			  Driver.tcFlag =  "FAIL";
			  Driver.comment = "The object was not displayed or not identified";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			  
		  }
		  
	  }catch(Exception e){
		  Driver.tcFlag = "FAIL";
		  Driver.comment = "Did not connect to database or query did not return anydata.";
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	  }
  	  
	  
  	  
	  /*Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) {
	    Statement stmt = con.createStatement(); 
	    
	    
		
		String SQL1="Select ProductOperationCode from ProductOperations where ProductOperationName Like 'Interest Posting'";
	    
	    ResultSet rs1= stmt.executeQuery(SQL1);
	    System.out.println("SP1 EXECUTED");
	    while(rs1.next()) {
	         ProductOpCode=rs1.getString(1);
	    
	        }
	    //System.out.println("ProductOperationCode:"+ProductOpCode);
	    System.out.println("SP1: " + ProductOpCode);
	    
	    String SQL2="select * from ProcessQueue where ProcessDate in(select * from TransactionDate) and ProductOpCode= "+ProductOpCode+"";
	    System.out.println("SP2 EXECUTED");
	    System.out.println("SQL2: " + SQL2);
	    ResultSet rs2=stmt.executeQuery(SQL2);
	   

	    while(rs2.next()) {
	    	
	    	//NoRecords=rs2.getString(14);
	    	//NoRecords=rs2.getString("NoOfRecords");
	    	System.out.println("Ravi: " + rs2.getString("NoOfRecords"));
	    	
	    	
	    	
	    }
	       System.out.println("NO of Records:"+NoRecords);
	       
	    	new WebDriverWait(driver,60).until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(".//*[@id='ctl00_CPH1_ucInterestPosting_lvwProcessQueueList_ctrl0_lblNoOfRecords']"))));
	    	new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ctl00_CPH1_ucInterestPosting_lvwProcessQueueList_ctrl0_lblNoOfRecords']")));
	       String Records=driver.findElement(By.xpath(".//*[@id='ctl00_CPH1_ucInterestPosting_lvwProcessQueueList_ctrl0_lblNoOfRecords']")).getText(); 
		   //System.out.println("No Of Records From UI:"+Records);
		   String records=Records.substring(0, 1);
		   System.out.println("SubString ofNo Of Records From UI:"+records);
		   
		   if(NoRecords.equals(records)) {
			   
			    System.out.println("NO of Records Verified");
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass" + " # " + "DB No:of Records: " + NoRecords + "<br>" + "UI No:of Records: " + records; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
		   }
		   
	 }*/
}


public static void VerifyInterestPostingOD_status(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
	
	 System.out.println("VERIFY STATUS");
	
	  String ProductOpCode=null;
	  
 	  String Status=null;
Parenttry: try { 	  
	  Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) {
	    Statement stmt = con.createStatement(); 
	    
	    String SQL1="Select ProductOperationCode from ProductOperations where ProductOperationName Like 'Interest Posting'";
	    
	    ResultSet rs1= stmt.executeQuery(SQL1);
	    System.out.println("SP1 EXECUTED");
	    
	    while(rs1.next()) {
	    	
	         ProductOpCode=rs1.getString(1);
	    
	        }
	    //System.out.println("ProductOperationCode:"+ProductOpCode);
	    
	    
	    String SQL2="select * from ProcessQueue where ProcessDate in(select * from TransactionDate) and ProductOpCode= "+ProductOpCode+"";
	    System.out.println("SP2 EXECUTED");
	    ResultSet rs2=stmt.executeQuery(SQL2);
	    int counter=0;
	    while(rs2.next()) {
	    	
	    	 counter=counter+1;
	    	Status=rs2.getString(15);
	    	
	    }
	       
	       //System.out.println("Status:"+Status);
	    if(counter==0) {
	    	  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  break Parenttry;
	    }
	    
	       int a=3;
		   String RecordStatus=String.valueOf(a);
		   if(Status.equals(RecordStatus)) {
			   
			    System.out.println("Status Verified");
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass" + " # " + "DB Status: " + Status + "<br>" + "Actual Status: " + 3; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
		   }
		   else {
			   
			   Driver.tcFlag = "FAIL";
			   Driver.comment = "Fail" + " # " + "DB Status: " + Status + "<br>" + "Actual Status: " + 3;  
			   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,Driver.comment);
			   
		   }
		   
		   
	 }else {
		    Driver.tcFlag = "FAIL";
		    Driver.comment = "Dtabase connection is not successfull";
		    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	 }
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
    Driver.comment = "Either Did not connect to database or databse return 0 records ";
    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
}
}
public static void VerifyInterestPostingOD_ProgressValue(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
	
	 System.out.println("VERIFY PROGRESS VALUE");
	
	  String ProductOpCode=null;
	  
	  String ProgressValue=null;
	  
Parenttry: try {	  
	  Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) {
	    Statement stmt = con.createStatement(); 
	    
	   String SQL1="Select ProductOperationCode from ProductOperations where ProductOperationName Like 'Interest Posting'";
	    
	    ResultSet rs1= stmt.executeQuery(SQL1);
	    System.out.println("SP1 EXECUTED");
	    while(rs1.next()) {
	         ProductOpCode=rs1.getString(1);
	    
	        }
	    //System.out.println("ProductOperationCode:"+ProductOpCode);
	    
	    
	    String SQL2="select * from ProcessQueue where ProcessDate in(select * from TransactionDate) and ProductOpCode= "+ProductOpCode+"";
	    System.out.println("SP2 EXECUTED");
	    ResultSet rs2=stmt.executeQuery(SQL2);
	    int counter=0;
	    while(rs2.next()) {
	    	counter=counter+1;
	    	ProgressValue=rs2.getString(18);
	    	
	    }
	      if(counter==0) {
	    	  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  break Parenttry;
	      }
	       //System.out.println("Progress Value:"+ProgressValue);
	       
	    
	    //String Progress=driver.findElement(By.xpath(".//*[@id='ctl00_CPH1_ucInterestPosting_lvwProcessQueueList_ctrl0_lblPv']")).getText();
	    String Progress="100";
		//System.out.println("Progress Value From UI:"+Progress);
		  
		   if(ProgressValue.equals(Progress)) {
			   
			    System.out.println("Progress Value Verified");
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass" + " # " + "DB Progress Value: " + ProgressValue + "<br>" + "UI Progress Value: " + Progress; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
		   }
		   else {
			   Driver.tcFlag = "FAIL";
			   Driver.comment = "Pass" + " # " + "DB Progress Value: " + ProgressValue + "<br>" + "UI Progress Value: " + Progress; 
			   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);      
			 
			   
		   }
		   
		   
	 }else {
		 
		    Driver.tcFlag = "FAIL";
		    Driver.comment = "Database connection is not successfull";
		    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	 }
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
    Driver.comment = "Required object is not displayed or not identified";
    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
}
public static void VerifyInterestPostingOD_CompletedAccounts(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
	
	 System.out.println("VERIFY NO:OF COMPLETED ACCOUNTS");
	
	  String ProductOpCode=null;
	  
 	  String CompletedAccounts=null;
 Parenttry: try {	  
 	  Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) {
	    Statement stmt = con.createStatement(); 
	    
	    String SQL1="Select ProductOperationCode from ProductOperations where ProductOperationName Like 'Interest Posting'";
	    
	    ResultSet rs1= stmt.executeQuery(SQL1);
	    System.out.println("SP1 EXECUTED");
	    while(rs1.next()) {
	         ProductOpCode=rs1.getString(1);
	    
	        }
	    //System.out.println("ProductOperationCode:"+ProductOpCode);
	    
	    
	    String SQL2="select * from ProcessQueue where ProcessDate in(select * from TransactionDate) and ProductOpCode= "+ProductOpCode+"";
	    System.out.println("SP2 EXECUTED");
	    ResultSet rs2=stmt.executeQuery(SQL2);
	    int counter=0;
	    while(rs2.next()) {
	    	
	    	counter=counter+1;
	    	CompletedAccounts=rs2.getString(21);
	    	
	    }
	       if(counter==0) {
	    	   
	    	      Driver.tcFlag = "FAIL";
				  Driver.comment = "Database did not return any records";
				  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
				  break Parenttry;
	    	   
	    	   
	       }
	      System.out.println("No of Completed Accounts:"+CompletedAccounts);
	       
	    
	   String Completed=driver.findElement(By.xpath(".//*[@id='ctl00_CPH1_ucInterestPosting_lvwProcessQueueList_ctrl0_lblPv']")).getText(); 
	   
	   //ctl00_CPH1_ucInterestPosting_lvwProcessQueueList_ctrl0_lblNoOfRecords
	   
	   System.out.println("No Of Completed Accounts From UI:"+Completed);
	   String CompletedAcc=Completed.substring(0, 1);
	   System.out.println("SubString ofNo Of Records From UI:"+CompletedAcc);
		   
		   if(CompletedAccounts.equals(CompletedAcc)) {
			   
			    System.out.println("No of Completed Records Verified");
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass" + " # " + "DB No:of Completed Records: " + CompletedAccounts + "<br>" + "UI No:of Completed Records:: " + CompletedAcc; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
		   }
		   else {
			   Driver.tcFlag = "FAIL";
				Driver.comment = "Fail" + " # " + "DB No:of Completed Records: " + CompletedAccounts + "<br>" + "UI No:of Completed Records:: " + CompletedAcc; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
			   
		   }
		   
   
	 }else {
		 
		    Driver.tcFlag = "FAIL";
		    Driver.comment = "Database connection is not successfull";
		    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	 }
 }catch(Exception e) {
	 
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Required object is not displayed or not identified";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	 
 }
}
public static void VerifyInterestPostingOD_Interest(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
	
	 System.out.println("VERIFY INTEREST");
	
	  String ProductOpCode=null;
	  String FromDate=null;
 	  String InApplicationId=null;
 	  String Interest=null;
 	  
 Parenttry: try {	  
	  Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) {
	    Statement stmt = con.createStatement(); 
	    
	    
		
		String SQL1="Select ProductOperationCode from ProductOperations where ProductOperationName Like 'Interest Posting'";
	    
	    ResultSet rs1= stmt.executeQuery(SQL1);
	    System.out.println("SP1 EXECUTED");
	    while(rs1.next()) {
	         ProductOpCode=rs1.getString(1);
	    
	        }
	    //System.out.println("ProductOperationCode:"+ProductOpCode);
	    
	    
	    String SQL2="select * from ProcessQueue where ProcessDate in(select * from TransactionDate) and ProductOpCode= "+ProductOpCode+"";
	    System.out.println("SP2 EXECUTED");
	    ResultSet rs2=stmt.executeQuery(SQL2);
	    while(rs2.next()) {
	    	
	    	
	    	FromDate=rs2.getString(22);
	    	
	    }
	       
	       //System.out.println("From Date"+FromDate);
	    
	    
	       
	    String SQL3="select  Top 1 MAX (IntApplicationId)as IntApplicationID,TransID from InterestPostingMaster\r\n" + 
       		"where PostingDate in(select * from TransactionDate)and ProductOperationID= "+ProductOpCode+" and FromDate='"+FromDate+"' and ToDate in(select * from TransactionDate) and RecordStatus=1\r\n" + 
       		"group by IntApplicationID,TransID \r\n" + 
       		"order by IntApplicationID desc";
       
       ResultSet rs3= stmt.executeQuery(SQL3);
       System.out.println("SP3 EXECUTED");
       while(rs3.next()) {
	         InApplicationId=rs3.getString(1);
	         
	        }
	    //System.out.println("Application Id:"+InApplicationId);
	    
	   
      String SQL4="Select Amount ,* from InterestPostingDetails where IntApplicationID = "+InApplicationId+"";
	    
	    ResultSet rs4= stmt.executeQuery(SQL4);
	    System.out.println("SP4 EXECUTED");
	    int counter=0;
	    while(rs4.next()) {
	    	counter=counter+1;
	         Interest=rs4.getString(1);
	         
	    
	        }
	    if(counter==0) {
	    	
	    	  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  break Parenttry;
	    }
	   //System.out.println("Interest Amount from Db:"+Interest);
	   DecimalFormat decimalFormat = new DecimalFormat("0.#####");
	   String x = decimalFormat.format(Double.valueOf(Interest));
	   String Intrst=x.concat(".00");
	   //System.out.println("Rounded Interest from Db:"+Intrst);
	   
	  Properties prop=new Properties();
	  InputStream input = new FileInputStream("./DataFiles/INTERESTPOSTING_OD.properties");
	  prop.load(input);
	  
	 //System.out.println("Interest from Sp"+Intrst);
	 //System.out.println("Interest from File"+prop.getProperty("InterestOD"));

		
	  if(Intrst.equals(prop.getProperty("InterestOD"))) {  
		  
		  System.out.println("Interest Verified");
		  Driver.tcFlag = "PASS";
		  Driver.comment = "Pass" + " # " + "DB Interest Amount: " + Intrst + "<br>" + "UI Interest Amount: " +prop.getProperty("InterestOD"); 
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);  
	  }else {
		  
		  Driver.tcFlag = "FAIL";
		  Driver.comment = "Fail" + " # " + "DB Interest Amount: " + Intrst + "<br>" + "UI Interest Amount: " +prop.getProperty("InterestOD"); 
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);  
		  
	  }
	  
	  }
 }catch(Exception e) {
	 
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Either Did not connect to database or databse return 0 records ";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	 
 }
}
public static void VerifyInterestPostingOD_AccMasterId(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
	
	 System.out.println("VERIFY AccMasterID");
	
	  String ProductOpCode=null;
	  String FromDate=null;
 	  String InApplicationId=null;
 	  String AccMasterID=null;
 	  String AccMaster_Id=null;
Parenttry:try { 	  
	  Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) {
	    Statement stmt = con.createStatement(); 
	    
	    String SQL1="Select ProductOperationCode from ProductOperations where ProductOperationName Like 'Interest Posting'";
	    ResultSet rs1= stmt.executeQuery(SQL1);
	    System.out.println("SP1 EXECUTED");
	    while(rs1.next()) {
	    	
	         ProductOpCode=rs1.getString(1);
	    
	        }
	    //System.out.println("ProductOperationCode:"+ProductOpCode);
	    String SQL2="select * from ProcessQueue where ProcessDate in(select * from TransactionDate) and ProductOpCode= "+ProductOpCode+"";
	    System.out.println("SP2 EXECUTED");
	    ResultSet rs2=stmt.executeQuery(SQL2);
	    while(rs2.next()) {
	    	
	    	FromDate=rs2.getString(22);
	    	
	    }
	       
	       //System.out.println("From Date"+FromDate);
	    
	     String SQL3="select  Top 1 MAX (IntApplicationId)as IntApplicationID,TransID from InterestPostingMaster\r\n" + 
       		"where PostingDate in(select * from TransactionDate)and ProductOperationID= "+ProductOpCode+" and FromDate='"+FromDate+"' and ToDate in(select * from TransactionDate) and RecordStatus=1\r\n" + 
       		"group by IntApplicationID,TransID \r\n" + 
       		"order by IntApplicationID desc";
       
         ResultSet rs3= stmt.executeQuery(SQL3);
         System.out.println("SP3 EXECUTED");
         while(rs3.next()) {
	         InApplicationId=rs3.getString(1);
	         
	        }
	    //System.out.println("Application Id:"+InApplicationId);
	    
	   String SQL4="Select Amount ,* from InterestPostingDetails where IntApplicationID = "+InApplicationId+"";
	   ResultSet rs4= stmt.executeQuery(SQL4);
	   System.out.println("SP4 EXECUTED");
	    while(rs4.next()) {
	         
	         AccMasterID=rs4.getString(4);
	    
	        }
	   
	   
	   //System.out.println("AccMasterID1:"+AccMasterID);

	 String accNo1= driver.findElement(By.xpath(".//*[@id='ctl00_CPH1_ucInterestPosting_ucTransactionAccInfo_txtBGPAcNo_txt']")).getAttribute("Value");
	 String accNo2= driver.findElement(By.xpath(".//*[@id='ctl00_CPH1_ucInterestPosting_ucTransactionAccInfo_txtAcNo_txt']")).getAttribute("Value");
	 //System.out.println("Account No1:"+accNo1);
	 //System.out.println("Account No2:"+accNo2);
	 String accountNumber = accNo1.concat(accNo2);
	 //System.out.println("Account No:"+accountNumber);
	 String SQL5="Select * From viAccMaster where AcNo="+accountNumber+"";
	    
	    ResultSet rs5= stmt.executeQuery(SQL5);
	    System.out.println("SP5 EXECUTED");
	    int counter=0;
	    while(rs5.next()) {
	         counter=counter+1;
	         AccMaster_Id=rs5.getString(2);
	    
	        } 
	    if(counter==0) {
	    	
	    	  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			  break Parenttry;
	    }
   //System.out.println("AccMasterID2:"+AccMaster_Id);	
   if(AccMasterID.equals(AccMaster_Id)) {  
		  
		  System.out.println("AccMasterId Verified");
		  Driver.tcFlag = "PASS";
		  Driver.comment = "Pass" + " # " + "AccmasterId From InterestPostingDetails: " + AccMasterID + "<br>" + "AccmasterId from ViAccmaster: " +AccMaster_Id; 
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);  
	  }else {
		  
		  Driver.tcFlag = "FAIL";
		  Driver.comment = "Fail" + " # " + "AccmasterId From InterestPostingDetails: " + AccMasterID + "<br>" + "AccmasterId from ViAccmaster: " +AccMaster_Id; 
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);  
		  
	  }
   
	 }
}catch(Exception e) {
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Either Did not connect to database or databse return 0 records ";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
}
}
public static void InterestPostingOD(WebDriver driver, String PropertyValue) throws IOException, InterruptedException {
	// TODO Auto-generated method stub
	//System.out.println("Inside Get Interest");
	String s;
	JavascriptExecutor js = (JavascriptExecutor)driver;

	for(int k=0; k<Driver.sinkWait; k++){
		try{
			s = js.executeScript("return document.readyState").toString();
			if (s.equals("complete")){
				break;
			}
		}catch(Exception e){
			Thread.sleep(500);
		}
	}
	
	for(int j=0; j<Driver.sinkWait; j++){
		try{
			s = js.executeScript("return jQuery.active") + "True";
			if (s.equals("0True")){
				break;
			}
		}catch(Exception e){
			Thread.sleep(500);
		}
	}
	WebElement element;
	try
	{
		
		//new WebDriverWait(driver,60).until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(PropertyValue))));
		element = new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyValue)));
		System.out.println("Element:"+element);
		if (element.isDisplayed()) {
			
			String Interest=driver.findElement(By.xpath(PropertyValue)).getAttribute("Value");
			System.out.println("UI Interest:"+Interest);
			String intZero = "0.00";
			//if (Interest.Integer.parseInt(intZero)){
			if (Interest.equals(intZero))
			{
				System.out.println("Interest is zero");
				Driver.tcFlag = "FAIL";
				Driver.comment = "Failed to capture Interest Amount.";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			else
			{
				Properties prop=new Properties();
				FileOutputStream fos = new FileOutputStream("./DataFiles/INTERESTPOSTING_OD.properties");
				prop.setProperty("InterestOD",Interest);
				System.out.println("Written to INTERESTPOSTING_OD.properties file");
				prop.store(fos, "Done");
				fos.close();
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			}
		}else
		{
			Driver.tcFlag = "FAIL";
			Driver.comment = Driver.objectName  + " is not displayed or is not identified.";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			
		}
		
		
	}catch(Exception e)
	{
		Driver.tcFlag = "FAIL";
		Driver.comment = Driver.objectName  + " is not displayed or is not identified.";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	    
	}
	
	
    }

 public static void VerifyNPAProcessing(WebDriver driver, String PropertyValue) throws Exception {
	
	 System.out.println("VERIFY NPA PROCESSING");
	
         driver.findElement(By.xpath(PropertyValue)).click();
	     System.out.println("Clicked on Process Button");
try {	
	
	     FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	     wait.withTimeout(20, TimeUnit.MINUTES);
	     wait.pollingEvery(250, TimeUnit.MILLISECONDS);
	     wait.ignoring(NoSuchElementException.class);
	     wait.until(ExpectedConditions.alertIsPresent());
	
	for(int i=0;i<=10;i++)
		try
		{
			driver.switchTo().alert().accept();
			break;
		}
		catch (Exception e)
		{
			e.getMessage();
		}
	     
			
			
			
  if(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnSummeryFinal']")).isEnabled()) {
	 
	 System.out.println("Summary Clicked");
	 driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnSummeryFinal']")).click();
	 
  }
	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
}catch(Exception e) {
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Required object is not displayed or not identified";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
}
		 }	
 public static void VerifyNPAProcessing_status(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
		
	 System.out.println("VERIFY NPA STATUS");
	
	  String ProductOpCode=null;
	  
 	  String Status=null;
Parenttry: try { 	  
	  Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) {
	    Statement stmt = con.createStatement(); 
	    
	    String SQL1="Select ProductOperationCode from ProductOperations where ProductOperationName Like 'NPA Processing'";
	    ResultSet rs1= stmt.executeQuery(SQL1);
	    System.out.println("SP1 EXECUTED");
	    while(rs1.next()) {
	    	
	         ProductOpCode=rs1.getString(1);
	    
	        }
	    //System.out.println("ProductOperationCode:"+ProductOpCode);
	    
	    
	    String SQL2="select Distinct Status from ProcessQueue where ProcessDate in(select * from TransactionDate)and ProductOpCode="+ProductOpCode+"";
	    System.out.println("SP2 EXECUTED");
	    ResultSet rs2=stmt.executeQuery(SQL2);
	    int counter=0;
	    while(rs2.next()) {
	    	
	    	counter=counter+1;
	    	Status=rs2.getString(1);
	    	
	    }
	       
	       //System.out.println("Status:"+Status);
	       
	    if(counter==0) {
	    	
	    	  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			  break Parenttry;
	    }
	       int a=3;
		   String RecordStatus=String.valueOf(a);
		   if(Status.equals(RecordStatus)) {
			   
			    System.out.println("Status Verified");
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass" + " # " + "DB Status: " + Status + "<br>" + "Actual Status: " + 3; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
		   }else {
			   
			   Driver.tcFlag = "FAIL";
			   Driver.comment = "Fail" + " # " + "DB Status: " + Status + "<br>" + "Actual Status: " + 3; 
			   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
			   
		   }
		   
		   
	 }
}catch(Exception e) {
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Either Did not connect to database or databse return 0 records ";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
}
}
 public static void VerifyNPAProcessing_ProgressValue(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
	
	 System.out.println("VERIFY PROGRESS VALUE");
	
	  String ProductOpCode=null;
	  
	  String ProgressValue=null;
	  
Parenttry: try {	  
	  Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) {
	    Statement stmt = con.createStatement(); 
	    
	   String SQL1="Select ProductOperationCode from ProductOperations where ProductOperationName Like 'NPA Processing'";
	    
	    ResultSet rs1= stmt.executeQuery(SQL1);
	    System.out.println("SP1 EXECUTED");
	    while(rs1.next()) {
	         ProductOpCode=rs1.getString(1);
	    
	        }
	    //System.out.println("ProductOperationCode:"+ProductOpCode);
	    
	    
	    String SQL2="select Distinct ProgressValue from ProcessQueue where ProcessDate in(select * from TransactionDate)and ProductOpCode="+ProductOpCode+"";
	    System.out.println("SP2 EXECUTED");
	    ResultSet rs2=stmt.executeQuery(SQL2);
	    int counter=0;
	    while(rs2.next()) {
	    	counter=counter+1;
	    	ProgressValue=rs2.getString(1);
	    	
	    }
	       
	       //System.out.println("Progress Value:"+ProgressValue);
	     if(counter==0) {
	    	 
	    	 Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  break Parenttry;
	     }
	    
	    String Progress=driver.findElement(By.xpath(".//*[@id='ctl00_CPH1_ucInterestPosting_lvwProcessQueueList_ctrl0_lblPv']")).getText();
		//System.out.println("Progress Value From UI:"+Progress);
		  
		   if(ProgressValue.equals(Progress)) {
			   
			    System.out.println("Progress Value Verified");
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass" + " # " + "DB Progress Value: " + ProgressValue + "<br>" + "UI Progress Value: " + Progress; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
		   }else {
			   
			   Driver.tcFlag = "FAIL";
				Driver.comment = "Fail" + " # " + "DB Progress Value: " + ProgressValue + "<br>" + "UI Progress Value: " + Progress; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
			   
		   }
		   
		   
	 }
}catch(Exception e) {
	
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Either Did not connect to database or databse return 0 records ";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
}
} 
 public static void VerifyNPAProcessing_VerifyNoofRecords(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
		
	 System.out.println("VERIFY NPA No: OF RECORDS");
	
	  String ProductOpCode=null;
	  String NoRecords=null;
  	  
 try { 	  
	  Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) {
	    Statement stmt = con.createStatement(); 
	    
	    
		
		String SQL1="Select ProductOperationCode from ProductOperations where ProductOperationName Like 'NPA Processing'";
	    
	    ResultSet rs1= stmt.executeQuery(SQL1);
	    System.out.println("SP1 EXECUTED");
	    while(rs1.next()) {
	         ProductOpCode=rs1.getString(1);
	    
	        }
	    //System.out.println("ProductOperationCode:"+ProductOpCode);
	    
	    
	    String SQL2="select NoOfRecords from ProcessQueue where ProcessDate in(select * from TransactionDate)and ProductOpCode="+ProductOpCode+" and NoOfRecords <> 0";
	    System.out.println("SP2 EXECUTED");
	    ResultSet rs2=stmt.executeQuery(SQL2);
	    
	    int row1=rs2.getRow();
	    System.out.println("No of Rows"+row1);
	    ArrayList ar1=new ArrayList<>();
	      
	       ResultSetMetaData rsmd1;
	       
	       try {
	                 rsmd1 = rs2.getMetaData();

	                 int NumOfCol1 = rsmd1.getColumnCount();
	                 
	               

	                 while (rs2.next()) {
	                  

	                     for (int i = 1; i <= NumOfCol1; i++) {
	                        
	                      ar1.add(rs2.getString(i));
	                      
	                     }

	                     row1++;
	                 }
	                 
	                 
	             } catch (SQLException e) {
	                 throw e;
	         
	             }
	       //System.out.println("NO of Records:"+NoRecords);
	       String Records=driver.findElement(By.xpath(".//*[@id='ctl00_CPH1_ucInterestPosting_lvwProcessQueueList_ctrl0_lblNoOfRecords']")).getText(); 
		   //System.out.println("No Of Records From UI:"+Records);
		   String records=Records.substring(0, 1);
		   //System.out.println("SubString ofNo Of Records From UI:"+records);
		   
		   if(NoRecords.equals(records)) {
			   
			    System.out.println("NO of Records Verified");
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass" + " # " + "DB No:of Records: " + NoRecords + "<br>" + "UI No:of Records: " + records; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
		   }else {
			   
			   Driver.tcFlag = "FAIL";
			   Driver.comment = "Fail" + " # " + "DB No:of Records: " + NoRecords + "<br>" + "UI No:of Records: " + records; 
			   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
			   
		   }
		   
	 }
 }catch(Exception e) {
	 
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Either Did not connect to database or databse return 0 records ";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	 
 }
}
 
 public static void VerifyInstDueNoForOL(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
		
	 System.out.println("VERIFY INSTALLMENT DUE");
Parenttry:	try {
	  String InstDueNo=null;
	  Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) {
	    Statement stmt = con.createStatement(); 
	    
	    String accNo1= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtBGPAcNo_txt']")).getAttribute("Value");
	    String accNo2= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt']")).getAttribute("Value");
	    System.out.println("Account No1:"+accNo1);
	    System.out.println("Account No2:"+accNo2);
	    String accountNumber = accNo1.concat(accNo2);
		System.out.println("Account No:"+accountNumber);
		String SQL1="exec QATransactionDetails1 "+accountNumber+"";
	    
	    ResultSet rs2= stmt.executeQuery(SQL1);
	    int counter=0;
	    while(rs2.next()) {
	    	 counter=counter+1;
	         InstDueNo=rs2.getString(25);//25
	    
	        }
	    if(counter==0) {
	    	
	    	Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  break Parenttry;
	    }
	    System.out.println("DB INST DUE NO:"+InstDueNo);
	    String InstDueNumber=driver.findElement(By.xpath(PropertyValue)).getAttribute("Value");
	    System.out.println("UI INST DUE NO:"+InstDueNumber);
	
   if(InstDueNo.equals(InstDueNumber)) {
		//Common.print(lastbalance, CurrentBalance);
		System.out.println("Equal");
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "DB Fine Amount: " + InstDueNo + "<br>" + "UI Fine Amount: " + InstDueNumber; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}else {
		System.out.println("values are not equal");
		Driver.tcFlag = "PASS";
		Driver.comment = "Fail" + " # " + "Value From Database: " + InstDueNo + "<br>" + "Actual Value: " + InstDueNumber; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
	 }
	}catch(Exception e) {
		
		 Driver.tcFlag = "FAIL";
		 Driver.comment = "Either Did not connect to database or databse return 0 records ";
		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
		
	}
} 
 
 public static void VerifyInstDueAmountForOL(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
		
		System.out.println("VERIFY INSTALLMENT DUE AMOUNT");
		
		  double InstDueAmt;
		  double InstDueAmount;
		  String inst=null;
Parenttry: try {		  
		  Connection con=(Connection) Common.DatabaseConnector();
		  if(con !=null) {
		    Statement stmt = con.createStatement(); 
		 try {   
		    String accNo1= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtBGPAcNo_txt']")).getAttribute("Value");
		    String accNo2= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt']")).getAttribute("Value");
		    System.out.println("Account No1:"+accNo1);
		    System.out.println("Account No2:"+accNo2);
		    String accountNumber = accNo1.concat(accNo2);
			 System.out.println("Account No:"+accountNumber);
			 String SQL1="exec QATransactionDetails1 "+accountNumber+"";
		    //String SQL1="exec QATransactionDetails1 ("+accountNumber+")";
		    ResultSet rs2= stmt.executeQuery(SQL1);
		    int counter=0;
		    while(rs2.next()) {
		    	counter=counter+1;
		    	inst=rs2.getString(15);//15
		    
		    }
		    if(counter==0) {
		    	
		    	  Driver.tcFlag = "FAIL";
				  Driver.comment = "Database did not return any records";
				  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
				  break Parenttry;
		    	
		    }
		    InstDueAmt=Double.parseDouble(inst);
		    System.out.println("DB INST DUE AMOUNT:"+InstDueAmt);
		    String InstAmount=driver.findElement(By.xpath(PropertyValue)).getAttribute("Value");
		    InstDueAmount=Double.parseDouble(InstAmount);
		    System.out.println("UI INST DUE AMOUNT:"+InstDueAmount);
		
	        if(Double.compare(InstDueAmt, InstDueAmount)==0) {
			//Common.print(lastbalance, CurrentBalance);
			System.out.println("Equal");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "DB Fine Amount: " + InstDueAmt + "<br>" + "UI Fine Amount: " + InstDueAmount; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		    }else {
			System.out.println("values are not equal");
			Driver.tcFlag = "FAIL";
			Driver.comment = "Fail" + " # " + "Value From Database: " + InstDueAmt + "<br>" + "Actual Value: " + InstDueAmount; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
		 }catch(SQLException e) {
				
		       Driver.tcFlag = "FAIL";
			   Driver.comment = Driver.objectName + " is not displayed or not identified";
			   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			   e.printStackTrace();
		  }         
		  }
}catch(Exception e) {
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Either Did not connect to database or databse return 0 records ";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
}
	}

 
 public static void VerifyNextShadowbalance1(WebDriver driver, String trim) {
		// TODO Auto-generated method stub
		System.out.println("inside next shadow balance verification");
		
		double C_amount=0.00;
		double Amount_to_be_credited=0.00;
		double Total=0.00;
try {		
		String CurrentBalance=driver.findElement(By.xpath(".//*[@id='LastNTrnContainer']/tr[1]/td[12]")).getText();
		
		System.out.println("current balance from the grid= "+CurrentBalance);
		
		//CurrentBalance .replaceAll("CR", " ");
		
		String a=CurrentBalance.substring(0,CurrentBalance.length()-3 );
		
		System.out.println("Current balance= "+ a);
		
		 C_amount= Double.parseDouble(a);
		
		 
		 
		String CreditAmount= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtTrnAmount_txt']")).getAttribute("value");
		
		Amount_to_be_credited= Double.parseDouble(CreditAmount);
		
		System.out.println("amount to be credited="+Amount_to_be_credited);
		
		Total= C_amount+Amount_to_be_credited;
		
		
		
		String Tot_org = String.valueOf(Total+"0");
		
		System.out.println("calculated shadow balance = "+ Tot_org);
		
		String ShadowBalance=driver.findElement(By.xpath(".//*[@id='_txtNextShadow_txt']")).getAttribute("value");
		
		System.out.println("value form UI--next shadow balance"+ ShadowBalance);
		
		if(Tot_org.equals(ShadowBalance)) {
			
			Common.print(Tot_org+"0", driver.findElement(By.xpath(".//*[@id='_txtNextShadow_txt']")).getText());
			System.out.println("Equal");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "Calculated Next Shadow Balance " + Tot_org + "<br>" + "Actual Next Shadow Balance from UI: " +ShadowBalance; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}else {
			
			System.out.println("values are not equal");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "Calculated Next Shadow Balance" + Tot_org + "<br>" + "Actual Next Shadow Balance from UI: " + ShadowBalance; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
}catch(Exception e) {
	
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Required element is not displayed or identified";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,Driver.comment);	
	
}
		
		}
 
 
 public static void VerifyNextShadowbalance(WebDriver driver, String PropertyValue) {
		
		System.out.println("inside next shadow balance verification");
		
		double C_amount=0.00;
		double Amount_to_be_credited=0.00;
		double Total=0.00;
try {		
		String CurrentBalance=driver.findElement(By.xpath(".//*[@id='LastNTrnContainer']/tr[1]/td[12]")).getText();
	     System.out.println(" "+CurrentBalance);
		//CurrentBalance .replaceAll("CR", " ");
		
		String a=CurrentBalance.substring(0,7);
		
		System.out.println("Current balance= "+ a);
		
		 C_amount= Double.parseDouble(a);
		
		String CreditAmount= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtTrnAmount_txt']")).getAttribute("value");
		
		Amount_to_be_credited= Double.parseDouble(CreditAmount);
		
		Total= C_amount-Amount_to_be_credited;
		
		String Tot_org = String.valueOf(Total);
		System.out.println("Total Amount"+Tot_org);
		 //System.out.println("NetPay"+driver.findElement(By.xpath(propertyValue)).getAttribute("value").substring(0, 9));

		System.out.println("Total Amount From UI"+driver.findElement(By.xpath(".//*[@id='_txtNextShadow_txt']")).getAttribute("value").substring(0, 6));
		if(Tot_org.equals(driver.findElement(By.xpath(".//*[@id='_txtNextShadow_txt']")).getAttribute("value").substring(0, 6))) {
			
			//Common.print(Tot_org, driver.findElement(By.xpath(".//*[@id='_txtNextShadow_txt']")).getText());
			System.out.println("Equal");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "Value From Database: " + Tot_org + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='_txtNextShadow_txt']")).getAttribute("value").substring(0, 6);
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}else {
			
			System.out.println("values are not equal");
			Driver.tcFlag = "PASS";
			Driver.comment = "Fail" + " # " + "Value From Database: " + Tot_org + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='_txtNextShadow_txt']")).getAttribute("value").substring(0, 6);
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
		
}catch(Exception e) {
	
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Required element is not displayed or identified";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,Driver.comment);	
	
}
	}
 
 public static void VerifyDDNextShadowbalance(WebDriver driver, String PropertyValue) {
		
		System.out.println("VERIFY DD NEXT SHADOW BALANCE");
		
		double C_amount=0.00;
		double Amount_to_be_credited=0.00;
		double FineAmt=0.00;
		double Total=0.00;
try {		
		
		String CurrentBalance=driver.findElement(By.xpath(".//*[@id='LastNTrnContainer']/tr[1]/td[12]")).getText();
	     System.out.println(" "+CurrentBalance);
		//CurrentBalance .replaceAll("CR", " ");
		
		String a=CurrentBalance.substring(0,7);
		
		System.out.println("Current balance= "+ a);
		
		 C_amount= Double.parseDouble(a);
		
		String TransAmount= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtTrnAmount_txt']")).getAttribute("value");
		
		Amount_to_be_credited= Double.parseDouble(TransAmount);
		
		Total= C_amount+Amount_to_be_credited;
		System.out.println("Total"+Total);
		String Tot_org = String.valueOf(Total);
		String NewTot=Tot_org.concat("0");
		
		System.out.println("Total Amount after Calculation:"+NewTot);
		 

		System.out.println("Total Amount From UI"+driver.findElement(By.xpath(".//*[@id='_txtNextShadow_txt']")).getAttribute("value"));
		
		if(NewTot.equals(driver.findElement(By.xpath(".//*[@id='_txtNextShadow_txt']")).getAttribute("value"))) {
			
			//Common.print(Tot_org, driver.findElement(By.xpath(".//*[@id='_txtNextShadow_txt']")).getText());
			System.out.println("Equal");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "Value From Database: " + Tot_org + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='_txtNextShadow_txt']")).getAttribute("value"); 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}else {
			
			System.out.println("values are not equal");
			Driver.tcFlag = "FAIL";
			Driver.comment = "Fail" + " # " + "Value From Database: " + Tot_org + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='_txtNextShadow_txt']")).getAttribute("value"); 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
}catch(Exception e) {
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Required element is not displayed or identified";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,Driver.comment);	
	
}
		
	}
 
 public static void VerifyFineAmount(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
		
		System.out.println("VERIFY FINE AMOUNT");
Parenttry: try {		
		     String FineAmt=null;
		     Connection con=(Connection) Common.DatabaseConnector();
			  if(con !=null) {
			    Statement stmt = con.createStatement(); 
		        Properties prop = new Properties();
			    InputStream input = new FileInputStream("./DataFiles/RDAccountOpening_CashMode.properties");
			    prop.load(input);
			    String accountNumber = prop.getProperty("FDAc_AccountNumber");
			    System.out.println("Account No:"+accountNumber);
			    String SQL1="exec QATransactionDetails1 "+accountNumber+"";
		    //String SQL1="exec QATransactionDetails1 ("+accountNumber+")";
		       ResultSet rs2= stmt.executeQuery(SQL1);
		       int counter=0;
		       while(rs2.next()) {
		    	 counter=counter+1;  
		         FineAmt=rs2.getString(17);
		       }
		       if(counter==0) {
		    	   
		    	      Driver.tcFlag = "FAIL";
					  Driver.comment = "Database did not return any records";
					  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
		    	      break Parenttry;
		       }
		    System.out.println("DB FINE AMOUNT:"+FineAmt);
		    String TotalFineAmount=driver.findElement(By.xpath(PropertyValue)).getAttribute("Value");
		    System.out.println("UI FINE AMOUNT:"+TotalFineAmount);
		
		
		if(FineAmt.equals(TotalFineAmount)) {
			//Common.print(lastbalance, CurrentBalance);
			System.out.println("Equal");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "DB Fine Amount: " + FineAmt + "<br>" + "UI Fine Amount: " + TotalFineAmount; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}else {
			System.out.println("values are not equal");
			Driver.tcFlag = "FAIL";
			Driver.comment = "Fail" + " # " + "Value From Database: " + FineAmt + "<br>" + "Actual Value: " + TotalFineAmount; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
			}	
}catch(Exception e) {
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Did not connect to database";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	
}
	}
 
 public static void VerifyRDNextShadowbalance(WebDriver driver, String PropertyValue) {
		
		System.out.println("VERIFY NEXT SHADOW BALANCE");
		
		double C_amount=0.00;
		double Amount_to_be_credited=0.00;
		double FineAmt=0.00;
		double Total=0.00;
try {		
		String CurrentBalance=driver.findElement(By.xpath(".//*[@id='LastNTrnContainer']/tr[1]/td[12]")).getText();
	     System.out.println(" "+CurrentBalance);
		//CurrentBalance .replaceAll("CR", " ");
		
		String a=CurrentBalance.substring(0,7);
		
		System.out.println("Current balance= "+ a);
		
		 C_amount= Double.parseDouble(a);
		
		String TransAmount= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtTrnAmount_txt']")).getAttribute("value");
		
		Amount_to_be_credited= Double.parseDouble(TransAmount);
		String Fine=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionRecoveryDue_txtTotalAllDue_txt']")).getAttribute("Value");
		System.out.println("Fine Amount"+Fine);
		FineAmt=Double.parseDouble(Fine);
		Total= C_amount+Amount_to_be_credited-FineAmt;
		System.out.println("Total"+Total);
		String Tot_org = String.valueOf(Total);
		String NewTot=Tot_org.concat("0");
		
		System.out.println("Total Amount after Calculation:"+NewTot);
		 //System.out.println("NetPay"+driver.findElement(By.xpath(propertyValue)).getAttribute("value").substring(0, 9));

		System.out.println("Total Amount From UI"+driver.findElement(By.xpath(".//*[@id='_txtNextShadow_txt']")).getAttribute("value"));
		
		if(NewTot.equals(driver.findElement(By.xpath(".//*[@id='_txtNextShadow_txt']")).getAttribute("value"))) {
			
			//Common.print(Tot_org, driver.findElement(By.xpath(".//*[@id='_txtNextShadow_txt']")).getText());
			System.out.println("Equal");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "Value From Database: " + Tot_org + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='_txtNextShadow_txt']")).getAttribute("value");
			; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}else {
			
			System.out.println("values are not equal");
			Driver.tcFlag = "FAIL";
			Driver.comment = "Fail" + " # " + "Value From Database: " + Tot_org + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='_txtNextShadow_txt']")).getAttribute("value"); 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
}catch(Exception e) {
	
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Required element is not displayed or identified";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,Driver.comment);	
	
}
		
	}
 
 public static void VerifyInstallmentAmountForOL(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
		
	   System.out.println("VERIFY INSTALLMENT DUE AMOUNT");
		
		  double InstDueAmt;
		  double InstDueAmount;
		  String inst=null;
		  
		  Connection con=(Connection) Common.DatabaseConnector();
		  if(con !=null) {
		    Statement stmt = con.createStatement(); 
		 try {   
		    String accNo1= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtBGPAcNo_txt']")).getAttribute("Value");
		    String accNo2= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt']")).getAttribute("Value");
		    System.out.println("Account No1:"+accNo1);
		    System.out.println("Account No2:"+accNo2);
		    String accountNumber = accNo1.concat(accNo2);
			System.out.println("Account No:"+accountNumber);
			 String SQL1="exec QATransactionDetails1 "+accountNumber+"";
		    //String SQL1="exec QATransactionDetails1 ("+accountNumber+")";
		    ResultSet rs2= stmt.executeQuery(SQL1);
		    int counter=0;
		    while(rs2.next()) {
		    	counter=counter+1;
		    	inst=rs2.getString(14);//15
		    
		    }
		    if(counter==0) {
		    	
		    	  Driver.tcFlag = "FAIL";
				  Driver.comment = "Database did not return any records";
				  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
		    }else {
		    InstDueAmt=Double.parseDouble(inst);
		    System.out.println("DB INSTALLMENT AMOUNT:"+InstDueAmt);
		    String InstAmount=driver.findElement(By.xpath(PropertyValue)).getAttribute("Value");
		    InstDueAmount=Double.parseDouble(InstAmount);
		    System.out.println("UI INSTALLMENT AMOUNT:"+InstDueAmount);
		    
		
	        if(Double.compare(InstDueAmt, InstDueAmount)==0) {
			//Common.print(lastbalance, CurrentBalance);
			System.out.println("Equal");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "Value From Database: " + InstDueAmt + "<br>" + "Actual Value: " + InstDueAmount; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		    }else {
			System.out.println("values are not equal");
			Driver.tcFlag = "PASS";
			Driver.comment = "Fail" + " # " + "Value From Database: " + InstDueAmt + "<br>" + "Actual Value: " + InstDueAmount; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		    }
		}
		 }catch(SQLException e) {
				
		       Driver.tcFlag = "FAIL";
			   Driver.comment = Driver.objectName + " is not displayed or not identified";
			   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			   e.printStackTrace();
		  }         
		  }else {
			  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database connection is not successfull";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  
		  }
	}
 
 
 public static void VerifyNPAstatus_OL(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
		
	 System.out.println("VERIFY NPA STATUS  OL");
	 String Status=null;
 	  
	  Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) {
	    Statement stmt = con.createStatement(); 
	try {    
	    String SQL1=" select Status from ProcessQueue where ProcessDate in(select * from TransactionDate)and ProductOpCode=75 and NoOfRecords<> 0 and                         ProductFrom=23001";
	    ResultSet rs1= stmt.executeQuery(SQL1);
	    System.out.println("SP1 EXECUTED");
	    while(rs1.next()) {
	    	
	         Status=rs1.getString(1);
	    
	    }
	       int a=3;
		   String RecordStatus=String.valueOf(a);
		   if(Status.equals(RecordStatus)) {
			   
			    System.out.println("Status Verified");
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass" + " # " + "DB Status : " + Status; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
		   }else {
			   
			   // System.out.println("Status Verified");
				Driver.tcFlag = "FAIL";
				Driver.comment = "Fail" + " # " + "DB Status : " + Status; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	 
		   }
	}catch(Exception e) {
		
		 Driver.tcFlag = "FAIL";
		 Driver.comment = "Database didnot return any records";
		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
		
	}
		   
	 }else {
		 
		    Driver.tcFlag = "FAIL";
			Driver.comment = "Not connected with database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	  }
}
 public static void VerifyNPAProgressValue_OL(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
	
	 System.out.println("VERIFY PROGRESS VALUE OL");
	 String ProgressValue=null;
	  
	  Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) {
	    Statement stmt = con.createStatement(); 
try {	    
	   String SQL1="select ProgressValue from ProcessQueue where ProcessDate in(select * from TransactionDate)and ProductOpCode=75 and NoOfRecords<> 0 and                     ProductFrom=23001";
	    
	    ResultSet rs1= stmt.executeQuery(SQL1);
	    System.out.println("SP1 EXECUTED");
	    while(rs1.next()) {
	    	ProgressValue=rs1.getString(1);
	    
	        }
	    
	       int a=100;
		   String Progress=String.valueOf(a);
	       
	    
	   if(ProgressValue.equals(Progress)) {
			   
			    System.out.println("Progress Value Verified");
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass" + " # " + "DB Progress Value: " + ProgressValue; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
		   }else {
			   
			    Driver.tcFlag = "FAIL";
				Driver.comment = "Fail" + " # " + "DB Progress Value: " + ProgressValue; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	  
		   }
		   
}catch(Exception e) {
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Database didnot return any records";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	
}
	 }else {
		 
		    Driver.tcFlag = "FAIL";
			Driver.comment = "Not connected with database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	 }
} 
 
 public static void VerifyNPAstatus_OD(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
	 System.out.println("VERIFY NPA STATUS  OD");
	 String Status=null;
 	  
	  Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) {
	    Statement stmt = con.createStatement(); 
	try {    
	    String SQL1=" select Status from ProcessQueue where ProcessDate in(select * from TransactionDate)and ProductOpCode=75 and NoOfRecords<> 0 and                         ProductFrom=24001";
	    ResultSet rs1= stmt.executeQuery(SQL1);
	    System.out.println("SP1 EXECUTED");
	    while(rs1.next()) {
	    	
	         Status=rs1.getString(1);
	    
	    }
	       int a=3;
		   String RecordStatus=String.valueOf(a);
		   if(Status.equals(RecordStatus)) {
			   
			    System.out.println("Status Verified");
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass" + " # " + "DB Status : " + Status; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
		   }else {
			   
			    Driver.tcFlag = "FAIL";
				Driver.comment = "Fail" + " # " + "DB Status : " + Status; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			   
		   }
	}catch(Exception e) {
		
		 Driver.tcFlag = "FAIL";
		 Driver.comment = "Database didnot return any records";
		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
		
	}
		   
	 }else {
		 
		    Driver.tcFlag = "FAIL";
			Driver.comment = "Not connected with database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	  }
	
}
 public static void VerifyNPAProgressValue_OD(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
	 System.out.println("VERIFY PROGRESS VALUE OD");
	 String ProgressValue=null;
	  
	  Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) {
	    Statement stmt = con.createStatement(); 
try {	    
	   String SQL1="select ProgressValue from ProcessQueue where ProcessDate in(select * from TransactionDate)and ProductOpCode=75 and NoOfRecords<> 0 and                     ProductFrom=24001";
	    
	    ResultSet rs1= stmt.executeQuery(SQL1);
	    System.out.println("SP1 EXECUTED");
	    while(rs1.next()) {
	    	ProgressValue=rs1.getString(1);
	    
	        }
	    
	       int a=100;
		   String Progress=String.valueOf(a);
	       
	    
	   if(ProgressValue.equals(Progress)) {
			   
			    System.out.println("Progress Value Verified");
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass" + " # " + "DB Progress Value: " + ProgressValue; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
		   }else {
			   
			    Driver.tcFlag = "FAIL";
				Driver.comment = "Fail" + " # " + "DB Progress Value: " + ProgressValue; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	  
		   }
		   
}catch(Exception e) {
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Database didnot return any records";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	
}
	 }else {
		 
		    Driver.tcFlag = "FAIL";
			Driver.comment = "Not connected with database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	 }
	
} 
 
 public static void StartProcessing(WebDriver driver, String PropertyValue) throws Exception {
		
     System.out.println("START PROCESSING");
try {	
     driver.findElement(By.xpath(PropertyValue)).click();
     System.out.println("Clicked on Process Button");
     Thread.sleep(3000);
     
     Alert alert=driver.switchTo().alert();
     alert.accept();
     System.out.println("Alert Handled");
     


     FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
     wait.withTimeout(20, TimeUnit.MINUTES);
     wait.pollingEvery(250, TimeUnit.MILLISECONDS);
     wait.ignoring(NoSuchElementException.class);
     wait.until(ExpectedConditions.alertIsPresent());

         for(int i=0;i<=10;i++) {
	    try
	    {
		driver.switchTo().alert().accept();
		break;
	    }
	    catch (Exception e)
	     {
		e.getMessage();
	     }
     
         }
		
/*String xpath=".//*[@id='ctl00_CPH1_DEPV1_btnSubmit']";		
WebElement element=driver.findElement(By.xpath(xpath));
if(element.isEnabled())
{
 
 System.out.println("Summary Clicked");
 element.click();
 
 }*/

Driver.tcFlag = "PASS";
Driver.comment = "Pass";
Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}
catch(Exception e) {
Driver.tcFlag = "FAIL";
Driver.comment = "Fail";
Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);

}
	 
}	
 public static void WriteValues(WebDriver driver, String PropertyValue) {
		
		String Brcode=null;;
		String Trans_Date=null;
		String CashBalance=null;
		
		
		System.out.println("Verify BranchId,TransDate and AvailableBalance");
		
	try {	
		    
		
				  String AvailBalance=driver.findElement(By.xpath(PropertyValue)).getAttribute("value");
				  System.out.println(AvailBalance);
				  AvailBalance=AvailBalance.substring(0, AvailBalance.length()-3);
				  System.out.println("Available Cash Balance From Application"+AvailBalance);
				  /*DecimalFormat decimalFormat = new DecimalFormat("###.##");
				  String AvailableBalance = decimalFormat.format(Double.valueOf(AvailBalance));
				  System.out.println("Available Cash Balance From Application  :"+AvailableBalance);*/
				  
				  String xpathProp=".//*[@id='ctl00_CPH1_DEPV1_dtEODDate_txt']";
				  String TransDate= driver.findElement(By.xpath(xpathProp)).getAttribute("value");
				  System.out.println("TransDate from Application "+TransDate);
				  
				  xpathProp=".//*[@id='ctl00_CPH1_DEPV1_txtEODBranch_txt']";  
				  String Branch= driver.findElement(By.xpath(xpathProp)).getAttribute("value");
				  System.out.println("Branch from Application "+Branch);
				  
				  
				  Properties prop=new Properties();
               FileOutputStream fos = new FileOutputStream("./DataFiles/DayEndData.properties");
               
               prop.setProperty("AvailableBalance", AvailBalance); 
               prop.setProperty("TransDate",TransDate);
               prop.setProperty("Branch", Branch);
               prop.store(fos, "Done");
               fos.close();
          
       Driver.tcFlag = "PASS";
  	  Driver.comment = "Pass";
  	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,Driver.comment);

		     
	 }catch(Exception e)	{
		 
		 Driver.tcFlag = "FAIL";
	     Driver.comment = "Did not connect to databasse";
	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	     
		
	 }
		}	 
 public static void DayEndAuthorize(WebDriver driver, String PropertyValue) {
		
		int counter=0;
		int indexcounter=0;
		
		System.out.println("DayEnd Authorizations");
		
	parenttry:try {	
		    
		 new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(PropertyValue))));
		 List<WebElement> rows = driver.findElements(By.xpath(PropertyValue));
		 counter=rows.size();
	     System.out.println("Rows from Application  :"+counter);
	     
	     
	     if(counter==0) {
	    	 
	    	 Driver.tcFlag =  "FAIL";
	         Driver.comment = "Fail";
		     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
          break parenttry; 
	    	 
	     }else {
	    	 
	    	 for(int i=1;i<=counter;i++) {
	    		 
	    		 String xpathprop=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl"+ indexcounter + "_chkSelect']";
	    		 WebElement element=driver.findElement(By.xpath(xpathprop));
	    		 if(element.isDisplayed()) {
	    			 element.click();
	    			 
	    			 xpathprop=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnSubmit']";
	    			 element=driver.findElement(By.xpath(xpathprop));
	    			 Thread.sleep(3000);
	    			 if(element.isDisplayed()) {
	    				 element.click();
	    			     Thread.sleep(3000);
	    			       for(int j=0;j<=10;j++) {
	    				      try
	    				         {
	    				    	     xpathprop=".//*[@id='closetop']";
	    				    	     element=driver.findElement(By.xpath(xpathprop)); 
	    			    			 if(element.isDisplayed()) 
	    			    			 element.click();
	    			    			 break;
	    				     } catch (Exception e){
	    				
	    					         Thread.sleep(500);
	    				      }
	    	
	    			       }  
	    				 
	    				/* xpathprop=".//*[@id='closetop']";
		    			 element=driver.findElement(By.xpath(xpathprop)); 
		    			 Thread.sleep(3000);
		    			 if(element.isDisplayed()) {
		    				 element.click();
		    				 Driver.tcFlag="PASS";
		    			 }//end of 3rd if loop*/
	    				 
	    			 }//end of 2nd if loop
	    			 
	    		 }//end of 1st if loop
	    		 
	    		 
	    		 
	    	 }//end of for loop
	    	  Driver.tcFlag = "PASS";
			  Driver.comment = "Pass";
  	      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,Driver.comment);
	         }//end of first else loop
	    
	    }catch(Exception e)	{
		
	      Driver.tcFlag = "FAILED";
	      Driver.comment = "Fail";
	      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,Driver.comment);
	     
		
	   }
		}
 
 public static void DayEndAuthorizeManager_Cash(WebDriver driver, String PropertyValue) {
		
		int counter=0;
		int indexcounter=0;
		
		System.out.println("DayEnd Authorizations");
		
	 parenttry:try {	
		    
		 new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(PropertyValue))));
		 List<WebElement> rows = driver.findElements(By.xpath(PropertyValue));
		 counter=rows.size();
	     System.out.println("Rows from Application  :"+counter);
	     
	     
	     if(counter==0) {
	    	 
	    	 Driver.tcFlag =  "FAIL";
	         Driver.comment = "Fail";
		     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	         break parenttry; 
	    	 
	      }else {
	    	 
	    	 for(int i=1;i<=counter;i++) {
	    		 
	    		 String xpathprop=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpCash_ucMACashier_lvwBatchDetails_ctrl"+ indexcounter + "_chkSelect']";
	    		 WebElement element=driver.findElement(By.xpath(xpathprop));
	    		 if(element.isDisplayed()) {
	    			 element.click();
	    			 
	    			 xpathprop=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnOtherPass']";
	    			 element=driver.findElement(By.xpath(xpathprop));
	    			 Thread.sleep(3000);
	    			 if(element.isDisplayed()) {
	    				 element.click();
	    			     Thread.sleep(3000);
	    			       for(int j=0;j<=10;j++) {
	    				      try
	    				         {
	    				    	     xpathprop=".//*[@id='closetop']";
	    				    	     element=driver.findElement(By.xpath(xpathprop)); 
	    			    			 if(element.isDisplayed()) 
	    			    			 element.click();
	    			    			 break;
	    				     } catch (Exception e){
	    				
	    					         Thread.sleep(500);
	    				      }
	    	
	    			       }  
	    	
	    				 
	    			 }//end of 2nd if loop
	    			 
	    		 }//end of 1st if loop
	    		 
	    		 
	    		 
	    	 }//end of for loop
	    	  Driver.tcFlag = "PASS";
			  Driver.comment = "Pass";
	 	      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,Driver.comment);
	         }//end of first else loop
	    
	    }catch(Exception e)	{
		
	      Driver.tcFlag = "PASS";
	      Driver.comment = "Pass";
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,Driver.comment);
	     
		
	   }
		}	
	public static void DayEndAuthorizeManager_Transfer(WebDriver driver, String PropertyValue) {
		
		int counter=0;
		int indexcounter=0;
		
		System.out.println("DayEnd Authorizations");
		
	 parenttry:try {	
		    
		 new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(PropertyValue))));
		 List<WebElement> rows = driver.findElements(By.xpath(PropertyValue));
		 counter=rows.size();
	     System.out.println("Rows from Application  :"+counter);
	     
	     
	     if(counter==0) {
	    	 
	    	 Driver.tcFlag =  "FAIL";
	         Driver.comment = "Fail";
		     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	         break parenttry; 
	    	 
	      }else {
	    	 
	    	 for(int i=1;i<=counter;i++) {
	    		 
	    		 String xpathprop=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbMgr_tpTransfer_ucMATransfer_lvwBatchDetails_ctrl"+ indexcounter + "_chkSelect']";
	    		 WebElement element=driver.findElement(By.xpath(xpathprop));
	    		 if(element.isDisplayed()) {
	    			 element.click();
	    			 xpathprop=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnOtherPass']";
	    			 element=driver.findElement(By.xpath(xpathprop));
	    			 Thread.sleep(3000);
	    			 if(element.isDisplayed()) {
	    				 element.click();
	    			     Thread.sleep(3000);
	    			       for(int j=0;j<=10;j++) {
	    				      try
	    				         {
	    				    	     xpathprop=".//*[@id='closetop']";
	    				    	     element=driver.findElement(By.xpath(xpathprop)); 
	    			    			 if(element.isDisplayed()) 
	    			    			 element.click();
	    			    			 break;
	    				     } catch (Exception e){
	    				
	    					         Thread.sleep(500);
	    				      }
	    	
	    			       }  
	    	
	    				 
	    			 }//end of 2nd if loop
	    			 
	    		 }//end of 1st if loop
	    		 
	    		 
	    		 
	    	 }//end of for loop
	    	  Driver.tcFlag = "PASS";
			  Driver.comment = "Pass";
	 	      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,Driver.comment);
	         }//end of first else loop
	    
	    }catch(Exception e)	{
		
	      Driver.tcFlag = "PASS";
	      Driver.comment = "Pass";
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,Driver.comment);
	     
		
	   }
		}	
		 
	public static void DayEndAuthorizeManager_Others(WebDriver driver, String PropertyValue) {
		
		int counter=0;
		int indexcounter=0;
		
		System.out.println("DayEnd Authorizations");
		
	 parenttry:try {	
		    
		 new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(PropertyValue))));
		 List<WebElement> rows = driver.findElements(By.xpath(PropertyValue));
		 counter=rows.size();
	     System.out.println("Rows from Application  :"+counter);
	     
	     
	     if(counter==0) {
	    	 
	    	 Driver.tcFlag =  "FAIL";
	         Driver.comment = "Fail";
		     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	         break parenttry; 
	    	 
	      }else {
	    	 
	    	 for(int i=1;i<=counter;i++) {
	    		 
	    		 String xpathprop=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucAB_lvwBatchDetails_ctrl"+ indexcounter + "_chkSelect']";
	    		 WebElement element=driver.findElement(By.xpath(xpathprop));
	    		 if(element.isDisplayed()) {
	    			 element.click();
	    			 
	    			 xpathprop=".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnSubmit']";
	    			 element=driver.findElement(By.xpath(xpathprop));
	    			 Thread.sleep(3000);
	    			 if(element.isDisplayed()) {
	    				 element.click();
	    			     Thread.sleep(3000);
	    			       for(int j=0;j<=10;j++) {
	    				      try
	    				         {
	    				    	     xpathprop=".//*[@id='closetop']";
	    				    	     element=driver.findElement(By.xpath(xpathprop)); 
	    			    			 if(element.isDisplayed()) 
	    			    			 element.click();
	    			    			 break;
	    				     } catch (Exception e){
	    				
	    					         Thread.sleep(500);
	    				      }
	    	
	    			       }  
	    	
	    				 
	    			 }//end of 2nd if loop
	    			 
	    		 }//end of 1st if loop
	    		 
	    		 
	    		 
	    	 }//end of for loop
	    	  Driver.tcFlag = "PASS";
			  Driver.comment = "Pass";
	 	      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,Driver.comment);
	         }//end of first else loop
	    
	    }catch(Exception e)	{
		
	      Driver.tcFlag = "PASS";
	      Driver.comment = "Pass";
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,Driver.comment);
	     
		
	   }
		}	
	
	public static void VerifyDayEnd_status(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
		 
		 System.out.println("VERIFY DAYEND STATUS");
		 String Status=null;
	 	  
		  Connection con=(Connection) Common.DatabaseConnector();
		  if(con !=null) {
		    Statement stmt = con.createStatement(); 
		try {    
		    String SQL1="Select DayEnd from Ac_DayStatus where TransDate in (select * from TransactionDate) and BranchID=102";
		    ResultSet rs1= stmt.executeQuery(SQL1);
		    System.out.println("SP1 EXECUTED");
		    while(rs1.next()) {
		    	
		         Status=rs1.getString(1);
		    
		    }
		       int a=3;
			   String RecordStatus=String.valueOf(a);
			   if(Status.equals(RecordStatus)) {
				   
				    System.out.println("Status Verified");
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass" + " # " + "DB Status : " + Status; 
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
			   }
		}catch(Exception e) {
			
			 Driver.tcFlag = "FAIL";
			 Driver.comment = "Database didnot return any records";
			 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			
		}
			   
		 }else {
			 
			    Driver.tcFlag = "FAIL";
				Driver.comment = "Not connected with database";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment); 
		  }
		
	}
	
	public static void DayEndSubmit(WebDriver driver, String PropertyValue) {
		
		int counter=0;
		int indexcounter=0;
		
		System.out.println("DayEnd Submit");
		
	parenttry:try {	
		    
		         String xpathprop=PropertyValue;
	    		 WebElement element=driver.findElement(By.xpath(xpathprop));
	    		 if(element.isDisplayed()) {
	    			 element.click();
	    			 Thread.sleep(10000);
	    		 }//end of 1st if loop
	    		 
	    		 
	    	  Driver.tcFlag = "PASS";
			  Driver.comment = "Pass";
	 	      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,Driver.comment);
	     
	    
	    }catch(Exception e)	{
		
	          Driver.tcFlag = "FAIL";
	          Driver.comment = "Page is not displayed or visible";
		      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,Driver.comment);
	     
		
	   }
		}	
	
	public static void AdminStartProcessing(WebDriver driver, String PropertyValue) throws Exception {
		
	     System.out.println("START PROCESSING");
	try {	
		
		Thread.sleep(6000);
	     driver.findElement(By.xpath(PropertyValue)).click();
	     System.out.println("Clicked on Process Button");
	     Thread.sleep(3000);
	     
	     Alert alert=driver.switchTo().alert();
	     alert.accept();
	     System.out.println("Alert Handled");
	     
	     String flag = "FALSE";
	       for(int i=0;i<=50;i++) {
		 try
		    {
			 String xpathprop=".//*[@id='ctl00_CPH1_DEPDC1_btnSubmitDC']";
			 WebElement element=driver.findElement(By.xpath(xpathprop));
			 if(element.isEnabled())
			 {
			 element.click();
			 flag = "TRUE";
			 break;
			 }else{
				 Thread.sleep(500);
			 }
		    
		 }catch (Exception e)
		  {
			Thread.sleep(500);
		  }
	     
	       }
			
	/*String xpath=".//*[@id='ctl00_CPH1_DEPV1_btnSubmit']";		
	WebElement element=driver.findElement(By.xpath(xpath));
	if(element.isEnabled())
	{
	 
	 System.out.println("Summary Clicked");
	 element.click();
	 
	 }*/
	       
	       if (flag == "TRUE"){
	    	   Driver.tcFlag = "PASS";
	  	     Driver.comment = "Pass";
	  	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	       }else{
	    	   Driver.tcFlag = "FAIL";
	    	   Driver.comment = "Continue button is not enabled";
	    	   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	       }

	    
	 
	   }catch(Exception e) {
	   Driver.tcFlag = "FAIL";
	   Driver.comment = "Required object is not displayed or not identified";
	   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);

	 }
		 
	}	
	
	public static void VerifyAdminDayEnd_status(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
		 
		 System.out.println("VERIFY DAYEND STATUS");
		 String Status=null;
	 	  
		  Connection con=(Connection) Common.DatabaseConnector();
		  if(con !=null) {
			  
		     Statement stmt = con.createStatement(); 
		     Properties prop = new Properties();
			 InputStream input = new FileInputStream("./DataFiles/DayEndData.properties");
			 prop.load(input);
			 String Date = prop.getProperty("Admin_Date");
			 
			 SimpleDateFormat sdfrmt1 = new SimpleDateFormat("dd/MM/yyyy");
				Date newValdate = null;
				try {
					newValdate = sdfrmt1.parse(Date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sdfrmt1=new SimpleDateFormat("dd MMMM yyyy");
				String VALUEDATE=sdfrmt1.format(newValdate);
		        System.out.println("DB Date Format :"+VALUEDATE);
			 
			 
		    
		try {    
		    String SQL1="Select DayEnd from Ac_DayStatus where TransDate =' "+VALUEDATE+" 'and BranchID=100";
		    System.out.println(SQL1);
		    ResultSet rs1= stmt.executeQuery(SQL1);
		    System.out.println("SP1 EXECUTED");
		    int counter = 0;
		    while(rs1.next()) {
		    	counter = counter + 1;
		         Status=rs1.getString(1);
		    
		    }
		    
		    if (counter == 0 ){
		    	Driver.tcFlag =  "FAIL";
		    	Driver.comment = "Database did not return any records";
		    	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		    }else{
		    	int a=3;
				   String RecordStatus=String.valueOf(a);
				   String b =  a  + "";
				   if(Status.equals(b)) {
					   
					    System.out.println("Status Verified");
						Driver.tcFlag = "PASS";
						Driver.comment = "Pass" + " # " + "DB Status : " + Status; 
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
				   }else{
					   Driver.tcFlag = "FAIL";
					   Driver.comment = "Value Mismatch <br> Expected: " + b + "<br> Actual: " + Status;
					   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				   }
		    }
		       
		}catch(Exception e) {
			
			 Driver.tcFlag = "FAIL";
			 Driver.comment = "Fail";
			 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			
		}
			   
		 }else {
			 
			    Driver.tcFlag = "FAIL";
				Driver.comment = "Not connected with database";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		  }
		
	}
	
	public static void DayEndDataCenterAlertHandlerAlone(WebDriver driver) throws InterruptedException{
		Actions action = new Actions(driver);
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	    wait.withTimeout(20, TimeUnit.MINUTES);
	    wait.pollingEvery(250, TimeUnit.MILLISECONDS);
	    wait.ignoring(NoSuchElementException.class);
	    wait.until(ExpectedConditions.alertIsPresent());
	    String flag = "FALSE";
	    for(int i=0;i<=100;i++) {
		    try
		    {
		    	driver.switchTo().alert().accept();
		    	flag = "TRUE";
		    	break;
		    }
		    catch (Exception e)
		    {
		    	//e.getMessage();
		    	Thread.sleep(500);
		    }
	     
	    }
	    if (flag == "TRUE"){
	    	Driver.tcFlag = "PASS";
	    	Driver.comment = "Pass";
	    	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	    }else{
	    	Driver.tcFlag = "FAIL";
	    	Driver.comment = "Alert Pop up did not show up in 50 seconds";
	    	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	    }
	}
	
public static void verifyDayBegindate(WebDriver driver, String locatorType, String propertyValue, String testData) throws ClassNotFoundException, SQLException, ParseException {
		
		try {
			
	
		String dayBeginDateFromDB =null;
		String DayBeginDate=driver.findElement(By.xpath(propertyValue)).getAttribute("value");
		System.out.println("Date from UI "+DayBeginDate );
		Connection con=(Connection) Common.DatabaseConnector();
		  if(con !=null) {
        
        Statement stmt = con.createStatement();	
        String Q_sql="select *from TransactionDate";
        ResultSet rs= stmt.executeQuery(Q_sql);
    	System.out.println("Query executed");
        while (rs.next()){
        	
        	dayBeginDateFromDB=rs.getString(1);
        }
		
    	System.out.println(" date from DB"+ dayBeginDateFromDB);
    	
        SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
    	System.out.println("format object created");
		Date newdaybegindate=sdfrmt.parse(dayBeginDateFromDB);
		System.out.println("parsed");
		sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
		
		String DAYBEGINDATE=sdfrmt.format(newdaybegindate);
		System.out.println("after conversion date is"+DAYBEGINDATE);
		
        if(DayBeginDate.equals(DAYBEGINDATE)) {
        	System.out.println("equal");
        	Driver.comment = "Pass" + " # " + "Value From Database: " + DAYBEGINDATE + "<br>" + "Actual Value: " + DayBeginDate; 
		 	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		
        	
        }
        
        else {
        	Driver.tcFlag = "FAIL";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
        }
		  }
		}
	catch(Exception e) {
		Driver.tcFlag = "FAIL";
		Driver.comment = Driver.objectName + "(productname) is not displayed or not identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		e.printStackTrace();
	}
		
	}
public static void verifyBOD(WebDriver driver, String locatorType, String propertyValue, String testData) {
	Parenttry:try {
		
		
		String bod =null;
		String BODFromUi=driver.findElement(By.xpath(propertyValue)).getAttribute("value");
		System.out.println("Date from UI "+BODFromUi );
		Connection con=(Connection) Common.DatabaseConnector();
		  if(con !=null) {
        
        Statement stmt = con.createStatement();	
        String Q_sql="select *from TransactionDate";
        ResultSet rs= stmt.executeQuery(Q_sql);
    	System.out.println("Query executed");
    	int counter=0;
        while (rs.next()){
        	counter=counter+1;
        	bod=rs.getString(1);
        }
        if(counter==0) {
        	
        	  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  break Parenttry;
        }
		
    	System.out.println(" date from DB"+ bod);
    	
        SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
    	System.out.println("format object created");
		Date newBOD=sdfrmt.parse(bod);
		System.out.println("parsed");
		sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
		
		String BODDATE=sdfrmt.format(newBOD);
		
		System.out.println("after conversion date is"+BODDATE);
		
        if(BODFromUi.equals(BODDATE)) {
        	System.out.println("equal");
        	Driver.comment = "Pass" + " # " + "Value From Database: " + BODDATE + "<br>" + "Actual Value: " + BODFromUi; 
		 	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		
        	
        }
        
        else {
        	Driver.tcFlag = "FAIL";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
        }
		  }
		}
	catch(Exception e) {
		Driver.tcFlag = "FAIL";
		Driver.comment = Driver.objectName + "(productname) is not displayed or not identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		e.printStackTrace();
	}	
	
}	
public static void Verify_status(WebDriver driver,String locatorType, String propertyValue, String testData) throws ClassNotFoundException, SQLException, InterruptedException 
{
	
	
	switch(testData) {
	
	
	case "Admin":
	{
		Thread.sleep(5000);
		int dayBeginStatus=0;
Parenttry:	try {	
		Connection con=(Connection) Common.DatabaseConnector();
		  if(con !=null) {
        Statement stmt = con.createStatement();	
		String Q_sql= "select DayBegin,BranchID,DayBeginUserID \r\n" + 
				"from Ac_DayStatus\r\n" + 
				"where TransDate in (select *from TransactionDate)and DayBeginUserID='admin' ";
		
		ResultSet rs=stmt.executeQuery(Q_sql);
		int counter=0;
		while(rs.next()) {
			counter=counter+1;
			dayBeginStatus=rs.getInt(1);
			
		}
		if(counter==0) {
			
			  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  break Parenttry;
		}
		if(dayBeginStatus==3) {
			
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "DayBeginStatus against Admin is 3"; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			Thread.sleep(5000);
		}
		else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "DayBeginStatus ";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		
		  }	
	}catch(Exception e) {
		
		 Driver.tcFlag = "FAIL";
	     Driver.comment = "Either Did not connect to database or databse return 0 records ";
	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	}
	}
	break;
	
	
	case "User":
	{
		Thread.sleep(5000);
		int dayBeginStatus=0;
Parenttry:	try	{
		Connection con=(Connection) Common.DatabaseConnector();
		  if(con !=null) {
        Statement stmt = con.createStatement();	
		String Q_sql= "select DayBegin,BranchID,DayBeginUserID \r\n" + 
				"from Ac_DayStatus\r\n" + 
				"where TransDate in (select *from TransactionDate)and Branchid=102 ";
		
		ResultSet rs=stmt.executeQuery(Q_sql);
		int counter=0;
		while(rs.next()) {
			counter=counter+1;
			dayBeginStatus=rs.getInt(1);
			
		}
		if(counter==0) {
			 Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  break Parenttry;
		}
		if(dayBeginStatus==3) {
			
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "DayBeginStatus against user is 3"; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
		else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		
		  }	
	}catch(Exception e) {
		
		Driver.tcFlag = "FAIL";
	    Driver.comment = "Either Did not connect to database or databse return 0 records ";
	    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		
	}
	}
	break;
	}
}

public static void VerifyInstDueAmount2(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException 
{
	System.out.println("VERIFY INSTALLMENT DUE AMOUNT");
	Parenttry: try 
	{	
		double InstDueAmt;
		double InstDueAmount;
		String inst=null;
		Connection con=(Connection) Common.DatabaseConnector();
		if(con !=null) 
		{
		    Statement stmt = con.createStatement(); 
		    
		    //String accNo1= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtBGPAcNo_txt']")).getAttribute("Value");
		   
		    WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 1288);
			System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
			System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
			String accNo1=driver.findElement(By.xpath(WriteIntoDataFiles.Property_Value)).getAttribute("value");
			System.out.println("accNo1="+ accNo1 + "\n");
			
		    //String accNo2= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt']")).getAttribute("Value");
			
			WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 373);
			System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
			System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
			String accNo2=driver.findElement(By.xpath(WriteIntoDataFiles.Property_Value)).getAttribute("value");
			System.out.println("accNo2="+ accNo2 + "\n");
			
		    System.out.println("Account No1:"+accNo1);
		    System.out.println("Account No2:"+accNo2);
		    String accountNumber = accNo1.concat(accNo2);
			 System.out.println("Account No:"+accountNumber);
			 String SQL1="exec QATransactionDetails1 "+accountNumber+"";
		    //String SQL1="exec QATransactionDetails1 ("+accountNumber+")";
		    ResultSet rs2= stmt.executeQuery(SQL1);
		    int counter=0;
		    
		    while(rs2.next()) 
		    {
		    	counter=counter+1;
		    	inst=rs2.getString(23);
	        }
		    if(counter==0) 
		    {
	    	  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  break Parenttry;
		    }
		    
		    InstDueAmt=Double.parseDouble(inst);
		    System.out.println("DB INST DUE AMOUNT:"+InstDueAmt);
		    String InstAmount=driver.findElement(By.xpath(PropertyValue)).getAttribute("Value");
		    InstDueAmount=Double.parseDouble(InstAmount);
		    System.out.println("UI INST DUE AMOUNT:"+InstDueAmount);
	
	        if(Double.compare(InstDueAmt, InstDueAmount)==0) 
	        {
				//Common.print(lastbalance, CurrentBalance);
				System.out.println("Equal");
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass" + " # " + "DB Fine Amount: " + InstDueAmt + "<br>" + "UI Fine Amount: " + InstDueAmount; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	        }
	        else 
	        {
				System.out.println("values are not equal");
				Driver.tcFlag = "FAIL";
				Driver.comment = "Fail" + " # " + "Value From Database: " + InstDueAmt + "<br>" + "Actual Value: " + InstDueAmount; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	        }
		}
		else 
		{
			Driver.tcFlag = "FAIL";
		    Driver.comment = "Did not connect to database";
		    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
	}
	catch(Exception e) 
	{
		Driver.tcFlag = "FAIL";
	    Driver.comment = "Required object is not identified or not displayed";
	    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	}	
}

public static void VerifyInstDueAmountForOL2(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException {
	
	System.out.println("VERIFY INSTALLMENT DUE AMOUNT");
	
	  double InstDueAmt;
	  double InstDueAmount;
	  String inst=null;
Parenttry: try {		  
	  Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) {
	    Statement stmt = con.createStatement(); 
	 try {   
	    //String accNo1= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtBGPAcNo_txt']")).getAttribute("Value");
	    WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 1288);
		System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
		System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
		String accNo1=driver.findElement(By.xpath(WriteIntoDataFiles.Property_Value)).getAttribute("value");
		System.out.println("accNo1="+ accNo1 + "\n");
	    
	    //String accNo2= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt']")).getAttribute("Value");
		 WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 373);
	    System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
		System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
		String accNo2=driver.findElement(By.xpath(WriteIntoDataFiles.Property_Value)).getAttribute("value");
		System.out.println("accNo1="+ accNo2 + "\n");
		
	    System.out.println("Account No1:"+accNo1);
	    System.out.println("Account No2:"+accNo2);
	    String accountNumber = accNo1.concat(accNo2);
		 System.out.println("Account No:"+accountNumber);
		 String SQL1="exec QATransactionDetails1 "+accountNumber+"";
	    //String SQL1="exec QATransactionDetails1 ("+accountNumber+")";
	    ResultSet rs2= stmt.executeQuery(SQL1);
	    int counter=0;
	    while(rs2.next()) {
	    	counter=counter+1;
	    	inst=rs2.getString(23);//15
	    
	    }
	    if(counter==0) {
	    	
	    	  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  break Parenttry;
	    	
	    }
	    InstDueAmt=Double.parseDouble(inst);
	    System.out.println("DB INST DUE AMOUNT:"+InstDueAmt);
	    String InstAmount=driver.findElement(By.xpath(PropertyValue)).getAttribute("Value");
	    InstDueAmount=Double.parseDouble(InstAmount);
	    System.out.println("UI INST DUE AMOUNT:"+InstDueAmount);
	
        if(Double.compare(InstDueAmt, InstDueAmount)==0) {
		//Common.print(lastbalance, CurrentBalance);
		System.out.println("Equal");
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "DB Fine Amount: " + InstDueAmt + "<br>" + "UI Fine Amount: " + InstDueAmount; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	    }else {
		System.out.println("values are not equal");
		Driver.tcFlag = "FAIL";
		Driver.comment = "Fail" + " # " + "Value From Database: " + InstDueAmt + "<br>" + "Actual Value: " + InstDueAmount; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
	 }catch(SQLException e) {
			
	       Driver.tcFlag = "FAIL";
		   Driver.comment = Driver.objectName + " is not displayed or not identified";
		   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		   e.printStackTrace();
	  }         
	  }
}catch(Exception e) {
 Driver.tcFlag = "FAIL";
 Driver.comment = "Either Did not connect to database or databse return 0 records ";
 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
}
}

public static void VerifyInstDueNo2(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException 
{
	 //System.out.println("VERIFY INSTALLMENT DUE");
	 Parenttry: try 
	{	
	  String accmasterID=null;
	  Connection con=(Connection) Common.DatabaseConnector();
	  if(con !=null) 
	  {
	    Statement stmt = con.createStatement(); 
	    
	    //Get Account number from UI
	    WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 1288);
		System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
		System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
		String accNo1=driver.findElement(By.xpath(WriteIntoDataFiles.Property_Value)).getAttribute("value");
		System.out.println("accNo1="+ accNo1 + "\n");
	    
	    //String accNo2= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_txtAcNo_txt']")).getAttribute("Value");
	    WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 373);
		System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
		System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
		String accNo2=driver.findElement(By.xpath(WriteIntoDataFiles.Property_Value)).getAttribute("value");
		System.out.println("accNo2="+ accNo2 + "\n");
	    
	    System.out.println("Account No1:"+accNo1);
	    System.out.println("Account No2:"+accNo2);
	    String accountNumber = accNo1.concat(accNo2);
		System.out.println("Account No:"+accountNumber);
		
		//Get AccmasterID from accmaster table
		String SQL1="select accmasterid from accmaster where acno="+accountNumber;
	    ResultSet rs2= stmt.executeQuery(SQL1);
	    int counter=0;
	    while(rs2.next()) 
	    {
	    	 counter=counter+1;
	    	 accmasterID=rs2.getString(1);
	    }
	    System.out.println("accmasterID from DB="+accmasterID);
	    if(counter==0) 
	    {
	    	  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  break Parenttry;
	    }
	    
	    // Get transaction date from TransactionDate table
	    String TransactionDate=null;
	    String SQL3="select convert(varchar, CurrentTransDate, 106) from transactiondate";
	    
	    ResultSet rs3= stmt.executeQuery(SQL3);
	    int counter3=0;
	    while(rs3.next()) 
	    {
	    	 counter3=counter3+1;
	    	 TransactionDate=rs3.getString(1);
	    }
	    System.out.println("Transaction Date from DB="+TransactionDate);
	    if(counter3==0) 
	    {
	    	  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  break Parenttry;
	    }
	    
	    //Get InstallmentDue from spQAGetProductAccInstallmentDue and compare with Inst Due showing in UI
	    String InstallmentDue=null;
	    String SQL4="DECLARE \r\n" +
						"@InstallmentDue SMALLINT, \r\n" +
						"@TotInstallment SMALLINT, \r\n" +
						"@InstallmentDueAmt MONEY, \r\n" +
						"@CollInst Money \r\n" +
					"EXEC spQAGetProductAccInstallmentDue \r\n" +
						"14001,"+accmasterID+",'"+TransactionDate+"',@InstallmentDue OUTPUT,   \r\n" + 
						"@TotInstallment OUTPUT,@InstallmentDueAmt OUTPUT, @CollInst OutPut, 1 \r\n" +
					"SELECT @InstallmentDue Due, @TotInstallment Tot, @InstallmentDueAmt DueAmt, \r\n" +
												"@CollInst CollInst";
	    
	    ResultSet rs4= stmt.executeQuery(SQL4);
	    int counter4=0;
	    while(rs4.next()) 
	    {
	    	counter4=counter4+1;
	    	InstallmentDue=rs4.getString(1);
	    }
	    if(counter4==0) 
	    {
	    	  Driver.tcFlag = "FAIL";
			  Driver.comment = "Database did not return any records";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
			  break Parenttry;
	    }
	    
	    
	    System.out.println("DB INST DUE NO="+InstallmentDue);
	    String InstDueNumber2=driver.findElement(By.xpath(PropertyValue)).getAttribute("Value");
	    System.out.println("UI INST DUE NO:"+InstDueNumber2);
	
	  if(InstallmentDue.equals(InstDueNumber2)) 
	  {
		System.out.println("Equal");
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "DB Installment Due: " + InstallmentDue + "<br>" + "UI Installment Due: " + InstDueNumber2; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	  }
	  else 
	  {
		System.out.println("values are not equal");
		Driver.tcFlag = "FAIL";
		Driver.comment = "Pass" + " # " + "DB Installment Due: " + InstallmentDue + "<br>" + "UI Installment Due: " + InstDueNumber2; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	  }
	    
	 }
	  else 
	  {
		    Driver.tcFlag = "FAIL";
		    Driver.comment = "Did not connect to database";
		    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		 
	 }
	}
	catch(Exception e) 
	{
		Driver.tcFlag = "FAIL";
		Driver.comment = "Required object is not identified or displayed";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	}
	}

}
