package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Common 
{
	public static String DatafileValue;
	
public static Connection DatabaseConnector() throws ClassNotFoundException, SQLException {
		Connection con = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String UserName = "sqa";
			String Password = "SPQA@sql2019" ;
			String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=Beaconpro_Automation;encrypt=true;trustServerCertificate=true";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(Url,UserName,Password);
			System.out.println("Class: Common Method: DatabaseConnector: Connected");
			return con;
		}catch(Exception e)
		{
			System.out.println("Class: Common Method: DatabaseConnector: Not Connected");
			e.printStackTrace();
			return con;
		}
	   
	}




public static ExpectedCondition<Alert> alertIsPresent() {
    return new ExpectedCondition<Alert>() {
      
      public Alert apply(WebDriver driver) {
        try {
          return driver.switchTo().alert();
        } catch (NoAlertPresentException e) {
          return null;
        }
      }

     
      public String toString() {
        return "alert to be present";
      }
    };
  }

public static void GetDocNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
	  System.out.println("Inside getdoc method");

	  int docNo=0;
	  parenttry: try {    
		  Connection con = DatabaseConnector();
		  if(con !=null) {
			  Statement stmt = con.createStatement();
	 
			  String Query_docNo="select MAX(DocNo)+1 AS DocumentNo from Automation_DocNo";
	        
			  ResultSet rs= stmt.executeQuery(Query_docNo);
			  int counter = 0;
			  while(rs.next()) {
				  counter = counter + 1;
				  docNo=rs.getInt(1);
	    
			  }
			  
			  if (counter == 0) {
				  Driver.tcFlag = "FAIL";
				  Driver.comment = "Database did not return any records";
				  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
				  break parenttry;
			  }
			  System.out.println("Document no"+docNo);
			  driver.findElement(By.xpath(propertyValue)).sendKeys(String.valueOf(docNo));
			  String Insert_DocNo = "INSERT INTO Automation_DocNo values (0,"+docNo+")";
			  stmt.execute(Insert_DocNo);
	        
			  Driver.tcFlag = "PASS";
			  Driver.comment = "Pass"+" # "+"Doc No"+docNo;
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment); 
		  }else {
			  Driver.tcFlag = "FAIL";
			  Driver.comment = "Did not connect to database";
			  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
		  }
	  }catch(Exception e) {
		
		  Driver.tcFlag = "FAIL";
		  Driver.comment = Driver.objectName + " is not displayed or not identified";
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	  }
	}
public static void ClickonGetValues(WebDriver driver, String trim) throws Exception {
	
	System.out.println("GET Values");
	
	try {
		driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TC1_tp1_lstProductDetails_ctrl0_GAF1_btnGetROI']")).click();
		System.out.println("Clicked");
		Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
		Driver.tcFlag = "PASS";
 	  	Driver.comment = "Pass"; 
 	  	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
 		try {
 			
     	   	driver.findElement(By.xpath(".//*[@id='closewarning']")).click();
     	   	Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
           	//Driver.tcFlag = "PASS";
     	  	//Driver.comment = "Pass"; 
     	  	//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);

        }catch(Exception e) {
        	
           	//Driver.tcFlag = "PASS";
     	  	//Driver.comment = "Pass"; 
     	  	//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);        	
     }
		
	}catch(Exception e) {
		Driver.tcFlag = "FAIL";
		Driver.comment = "Required object is not displayed or not identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	}
	

	
	
	
}

public static void verifyNetPay(WebDriver driver, String propertyValue) throws IOException, Exception {
     System.out.println("VERIFY NETPAY");
	 float Pay_amount=0;
	 
	 float Total_Recoveries=0;
	
	 //Added by Ravi on Feb 06 2019
	 try {
	 new WebDriverWait(driver,40).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtPayAmount_txt']")))));
	 String PayAmount=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtPayAmount_txt']")).getAttribute("value");
	                                               
	 String TotalRecoveries= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_ucRecoveries_txtRecoveryTotal_txt']")).getAttribute("value");
	                                                               
	 Pay_amount=Float.parseFloat(PayAmount);
	 Total_Recoveries=Float.parseFloat(TotalRecoveries);
	  System.out.println("Pay Amount: "+Pay_amount);
	  System.out.println("Total_Recoveries: "+Total_Recoveries); 
     String netpay= String.valueOf(Pay_amount-Total_Recoveries);
     DecimalFormat decimalFormat = new DecimalFormat("###.##");
	 String Int = decimalFormat.format(Double.valueOf(netpay));
	 System.out.println("CalculatedNetpay: "+Int);
	 
	 String x= driver.findElement(By.xpath(propertyValue)).getAttribute("value").substring(0, 8);
	 DecimalFormat decimalFormat1 = new DecimalFormat("###.##");
	 String Value = decimalFormat.format(Double.valueOf(x));
	 System.out.println("ActualNetPay: "+Value);
	 if(Int.equals(Value) ) {
	  System.out.println("Equal");
	  Driver.tcFlag = "PASS";
	  Driver.comment = "Pass" + " # " + "Calculated Value: " + Int + "<br>" + "Actual Value: " +Value ; 
	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	 }
     
	 else {
	  
	  Driver.tcFlag = "FAIL";
	  Driver.comment = "Fail" + " # " + "Calculated Value: " + Int + "<br>" + "Actual Value: " + Value;
	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	 }
	 }catch(Exception e) {
		 
		 Driver.tcFlag = "FAIL";
		 Driver.comment = "Required  object is not displayed or not identified";
		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
		 
	 }
	 
	}

public static void verifyODNetPay(WebDriver driver, String propertyValue) {
      System.out.println("VERIFY OD NETPAY");
	 float Pay_amount=0;
	 float Total_Recoveries=0;
	 try {
	 String PayAmount=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtPayAmount_txt']")).getAttribute("value");
	 String TotalRecoveries= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_ucRecoveries_txtRecoveryTotal_txt']")).getAttribute("value");
	 Pay_amount=Float.parseFloat(PayAmount);
	 Total_Recoveries=Float.parseFloat(TotalRecoveries);
     String netpay= String.valueOf(Pay_amount-Total_Recoveries);
	 DecimalFormat decimalFormat = new DecimalFormat("###.##");
	 String Int = decimalFormat.format(Double.valueOf(netpay));
	 System.out.println("CalculatedNetpay"+Int);
	 String x= driver.findElement(By.xpath(propertyValue)).getAttribute("value").substring(0, 9);
	 DecimalFormat decimalFormat1 = new DecimalFormat("###.##");
	 String Value = decimalFormat.format(Double.valueOf(x));
	 System.out.println("ActualNetPay"+Value);
	 if(Int.equals(Value) ){
	  System.out.println("Equal");
	  Driver.tcFlag = "PASS";
	  Driver.comment = "Pass" + " # " + "Calculated Value: " + Int + "<br>" + "Actual Value: " + Value ; 
	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	  
	 }else {
	  
	  Driver.tcFlag = "FAIL";
	  Driver.comment = "Fail" + " # " + "Calculated Value: " + Int + "<br>" + "Actual Value: " +Value; 
      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	 }
	 }catch(Exception e) {
		 
		 Driver.tcFlag = "FAIL";
		 Driver.comment = "Required object is not displayed or not identified";
		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	 }
	 
	}
public static void ReadValueDate(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
	  System.out.println("CHANGE VALUE DATE");

	  String ValueDate = null;
Parenttry: try {	  
	  
	 Connection con = DatabaseConnector();
	 if(con !=null) {
		 
	        Statement stmt = con.createStatement();
	        String Query_ValueDate="select DATEADD (d,-1,(select * from TransactionDate ))";
	        ResultSet rs= stmt.executeQuery(Query_ValueDate);
	        int counter=0;
	        while(rs.next()) {
	        	counter=counter+1;
	            ValueDate=rs.getString(1);
	    
	        }
	        if (counter==0) {
	        	Driver.tcFlag="FAIL";
	        	Driver.comment="Database didnot return any records";
	        	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	        	break Parenttry;
	        	
	        }
	        System.out.println("Value Date without convertion"+ValueDate);
	        String Value_Date=ValueDate.substring(0, 10);
	        System.out.println("Substring of value date"+Value_Date);
	        
            SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
			Date newValdate = null;
			try {
				newValdate = sdfrmt1.parse(Value_Date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Fluent wait started");
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
					.withTimeout(15, TimeUnit.MINUTES) 	
					 .ignoring(NullPointerException.class)
	                 .ignoring(StaleElementReferenceException.class)
	                 .ignoring(NoSuchElementException.class)
	                 .ignoring(ElementNotVisibleException.class)
	                 .ignoring(WebDriverException.class)
					.pollingEvery(5, TimeUnit.MILLISECONDS);			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue)));
			System.out.println("Fluent Wait Ended - Element found and to be in clickable state");
			
			sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
			String VALUEDATE=sdfrmt1.format(newValdate);
	        System.out.println("Value Date :"+VALUEDATE);
	     //driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_ucTransactionAccInfo_dtValueDate_dtValueDate_txt']")).sendKeys(""+VALUEDATE);
	        Driver.driver.findElement(By.xpath(propertyValue)).click();	
		    Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(VALUEDATE);	
		    Driver.driver.findElement(By.xpath(propertyValue)).click();

	     //driver.findElement(By.xpath(propertyValue)).sendKeys(String.valueOf(VALUEDATE));
	       Driver.tcFlag = "PASS";
	       Driver.comment = "Pass";
	       Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment); 
	 }else {
		 
		 Driver.tcFlag = "FAIL";
		 Driver.comment = "Did not connect to database";
		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		 
	 }
  }catch(Exception e) {
	  
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Required object is not displayed or identified";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	
}
	}
public static void OLCreditStartDate(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
	
	  System.out.println("Inside OL Credit Start Date method");
Parenttry:try {	  
	  String ACNO= driver.findElement(By.xpath(".//*[@id='abc']/tbody/tr[1]/td/div/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]")).getText();
      System.out.println("Account No "+ACNO);
	  String StartDate = null;
	  Connection con = DatabaseConnector();
	  if(con !=null) {
		  
	        Statement stmt = con.createStatement();
	        String Query_StartDate="select AcStartDate from QATransactionDetails1 ("+ACNO+")";
	        
	        ResultSet rs= stmt.executeQuery(Query_StartDate);
	        int counter=0;
	        while(rs.next()) {
	         counter=counter+1;	
	         StartDate=rs.getString(1);
	    
	        }
	        if(counter==0) {
	        	
	        	Driver.tcFlag="FAIL";
	        	Driver.comment="Database didnot return any records";
	        	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	        	break Parenttry;
	        }
	        System.out.println("Start Date without convertion"+StartDate);
	        SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
			Date newValdate = null;
			try {
				newValdate = sdfrmt1.parse(StartDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
			String VALUEDATE=sdfrmt1.format(newValdate);
	         System.out.println("Start Date :"+VALUEDATE);
	        
	     if(VALUEDATE.equals(driver.findElement(By.xpath(propertyValue)).getText()))
	     {
	      System.out.println("Equal");
	   	  Driver.tcFlag = "PASS";
	   	  Driver.comment = "Pass" + " # " + "DB Value: " + VALUEDATE + "<br>" + "Actual Value: " + driver.findElement(By.xpath(propertyValue)).getText(); 
	   	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);

	     }
	     else {
	    	 
	    	 Driver.tcFlag = "FAIL";
		   	 Driver.comment = "Fail" + " # " + "DB Value: " + VALUEDATE + "<br>" + "Actual Value: " + driver.findElement(By.xpath(propertyValue)).getText(); 
		   	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	    	 
	     }
	}else {
		
		Driver.tcFlag = "FAIL";
		Driver.comment = "Did not connect to database";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	}
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = "Element is not displayed or identified";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
}

public static void OLCreditDuration(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
	
	   System.out.println("Inside OL Credit Start Date method");
Parenttry:try {	
	
	  String ACNO= driver.findElement(By.xpath(".//*[@id='abc']/tbody/tr[1]/td/div/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]")).getText();
      System.out.println("Account No "+ACNO);
	  String StartDate = null;
	  Connection con = DatabaseConnector();
	  if(con !=null) {
	        Statement stmt = con.createStatement();
	        String Query_StartDate="select AcStartDate from QATransactionDetails1 ("+ACNO+")";
	        ResultSet rs= stmt.executeQuery(Query_StartDate);
	        int counter=0;
	        while(rs.next()) {
	         StartDate=rs.getString(1);
	    
	        }
	        if(counter==0) {
	        	
	        	Driver.tcFlag="FAIL";
	        	Driver.comment="Database didnot return any records";
	        	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);	
	        	break Parenttry;
	        	
	        }
	        System.out.println("Start Date without convertion"+StartDate);
	        SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
			Date newValdate = null;
			try {
				newValdate = sdfrmt1.parse(StartDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
			String VALUEDATE=sdfrmt1.format(newValdate);
	         System.out.println("Start Date :"+VALUEDATE);
	        
	     if(VALUEDATE.equals(driver.findElement(By.xpath(propertyValue)).getText()))
	     {
	      System.out.println("Equal");
	   	  Driver.tcFlag = "PASS";
	   	  Driver.comment = "Pass" + " # " + "DB Value: " + VALUEDATE + "<br>" + "Actual Value: " + driver.findElement(By.xpath(propertyValue)).getText(); 
	   	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);

	     
	  
	     }else {
	    	 
	    	 Driver.tcFlag = "FAIL";
		   	 Driver.comment = "Fail" + " # " + "DB Value: " + VALUEDATE + "<br>" + "Actual Value: " + driver.findElement(By.xpath(propertyValue)).getText(); 
		   	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	    	 
	     }
	}
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = "Either didnot connect to the database or required element is not displayed or identified";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
}
}

public static void verifyNetPayForGL(WebDriver driver, String propertyValue) throws IOException {

	System.out.println("inside verify net pay method");
	//Added by Ravi on Feb 06, 2019
try {	
	new WebDriverWait(driver,40).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(propertyValue)))));
	System.out.println("text ="+ driver.findElement(By.xpath(propertyValue)).getAttribute("value")); 
	
	
	float Aprisalcharge=0;
	float payAmount=0;
	float Insurance=0;
	float Total_Recoveries=0;
	
	
	String ApprisalCharge=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_ucRecoveries_txt101']")).getAttribute("value");
	String pay_Amount=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtPayAmount_txt']")).getAttribute("value");
	String TotalRecoveries= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_ucRecoveries_txtRecoveryTotal_txt']")).getAttribute("value");
	
	Aprisalcharge=Float.parseFloat(ApprisalCharge);
	payAmount=Float.parseFloat(pay_Amount);
	Total_Recoveries=Float.parseFloat(TotalRecoveries);

	
	String netpay= String.valueOf(payAmount-Total_Recoveries);
	
	Properties prop=new Properties();
	FileOutputStream fos = new FileOutputStream("./DataFiles/GL_BATCH_Amount.properties");
	prop.setProperty("NetPay",netpay);
	System.out.println("NetPay saved to file");
	prop.store(fos, "Done");
	fos.close();
	
	System.out.println("netpay "+netpay);
	
	String N_pay=netpay.concat("0 Dr");
	
	if(N_pay.equals(driver.findElement(By.xpath(propertyValue)).getAttribute("value"))) {
		
		System.out.println("equal");
		
		Driver.tcFlag = "PASdS";
		Driver.comment = "Pass" + " # " + "Calculated Value: " +N_pay+ "<br>" + "Actual Value: " + driver.findElement(By.xpath(propertyValue)).getAttribute("value"); 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		
	}else {
		
		Driver.tcFlag = "FAIL";
		Driver.comment = Driver.objectName + " is not displayed or not identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	}
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = "Required element is not displayed or identified";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
}
	
}
public static void print(String ActualValue, String DbValue) {
	
try {	
	
	System.out.println("Actual value and DB value is "+ ActualValue +"  "+ DbValue);
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass" + " # " + "Value From Database: " + DbValue + "<br>" + "Actual Value: " + ActualValue; 
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}catch(Exception e) {
		
		Driver.tcFlag="FAIL";
		Driver.comment = "Fail" + " # " + "Value From Database: " + DbValue + "<br>" + "Actual Value: " + ActualValue; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		
		}
}

public static void WriteNetWeightToFile(WebDriver driver) throws IOException {
	
	//Added by Ravi on Feb 06, 2019
try {	
	new WebDriverWait(driver,40).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpJewels_JSF_txtNetWt_txt']")))));
	
	Properties prop=new Properties();
	
	FileOutputStream fos = new FileOutputStream("./DataFiles/GL_CASH_Details.properties");
	
	prop.setProperty("NetWeight", driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpJewels_JSF_txtNetWt_txt']")).getAttribute("value"));
	
	prop.store(fos, "Done");
	
	fos.close();
	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass"; 
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = "Required element is not displayed or identified";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
}
public static void verifyNETPAY(WebDriver driver, String propertyValue) {

	System.out.println("inside verify net pay method");
try {	
	System.out.println("text ="+driver.findElement(By.xpath(propertyValue)).getAttribute("value")); 
	double Pay_amount=0.00;
	float form_Fee=0;
	float risk_fund=0;
	float Insurance=0;
	float Total_Recoveries=0;
	String PayAmount=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtPayAmount_txt']")).getAttribute("value");
	String FormFee=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_ucRecoveries_txt192']")).getAttribute("value");
	String riskFund=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_ucRecoveries_txt194']")).getAttribute("value");
	//String insurance=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_ucRecoveries_txt1553']")).getAttribute("value");
	String TotalRecoveries= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_ucRecoveries_txtRecoveryTotal_txt']")).getAttribute("value");
	Pay_amount=Double.parseDouble(PayAmount);
	form_Fee=Float.parseFloat(FormFee);
	risk_fund=Float.parseFloat(riskFund);
	//Insurance=Float.parseFloat(insurance);
	Total_Recoveries=Float.parseFloat(TotalRecoveries);

	
	String netpay= String.valueOf(Pay_amount-(form_Fee+risk_fund));
	System.out.println("netpay "+netpay);
	String N_pay=netpay.concat("0 Dr");
	System.out.println("Concatenated netpay"+N_pay);
	if(N_pay.equals(driver.findElement(By.xpath(propertyValue)).getAttribute("value"))) {
		
		System.out.println("equal");
		
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "Calculated Value: " +N_pay+ "<br>" + "Actual Value: " + driver.findElement(By.xpath(propertyValue)).getAttribute("value"); 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		
	}else {
		
		Driver.tcFlag = "FAIL";
		Driver.comment = "Fail" + " # " + "Calculated Value: " +N_pay+ "<br>" + "Actual Value: " + driver.findElement(By.xpath(propertyValue)).getAttribute("value"); 
        Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	}
	
	driver.findElement(By.xpath(".//*[@id='__tab_ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpStandInst']")).click();
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = "Required element is not displayed or identified";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
}
	
}
 public static void verifyODNetPay1(WebDriver driver, String propertyValue) throws IOException {
    System.out.println("VERIFY NETPAY");
	 float Pay_amount=0;
	 float form_Fee=0;
	 float risk_fund=0;
	 float Insurance=0;
	 float Total_Recoveries=0;
try {	 
	 String PayAmount=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtPayAmount_txt']")).getAttribute("value");
	 String FormFee=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_ucRecoveries_txt192']")).getAttribute("value");
	 String riskFund=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_ucRecoveries_txt194']")).getAttribute("value");
	 String insurance=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_ucRecoveries_txt1553']")).getAttribute("value");
	 String TotalRecoveries= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_ucRecoveries_txtRecoveryTotal_txt']")).getAttribute("value");
	 Pay_amount=Float.parseFloat(PayAmount);
	 form_Fee=Float.parseFloat(FormFee);
	 risk_fund=Float.parseFloat(riskFund);
	 Insurance=Float.parseFloat(insurance);
	 Total_Recoveries=Float.parseFloat(TotalRecoveries);
   String netpay= String.valueOf(Pay_amount-Total_Recoveries);
	 System.out.println("CALCULATED NETPAY:"+netpay);
	 //String Connetpay=netpay.concat("0");
	 
	 System.out.println("ACTUAL NETPAY:"+driver.findElement(By.xpath(propertyValue)).getAttribute("value").substring(0, 9));
	 if(netpay.equals(driver.findElement(By.xpath(propertyValue)).getAttribute("value").substring(0, 9))) {
	  System.out.println("Equal");
	  Driver.tcFlag = "PASS";
	  Driver.comment = "Pass" + " # " + "Calculated Value: " + netpay + "<br>" + "Actual Value: " + driver.findElement(By.xpath(propertyValue)).getAttribute("value").substring(0, 9); 
	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	 }
   
	 else {
	  
	  Driver.tcFlag = "FAIL";
	  Driver.comment = "Fail" + " # " + "Calculated Value: " + netpay + "<br>" + "Actual Value: " + driver.findElement(By.xpath(propertyValue)).getAttribute("value").substring(0, 9);
	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	 }
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = "Required element is not displayed or identified";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
}
	 
	}

 public static void ChangeTransactionMonth() throws ClassNotFoundException, SQLException {
	 System.out.println("Inside Date Change method");
	 String NewDate=null;
Parenttry: try {	 
	 Connection con=(Connection) Common.DatabaseConnector();
	    if(con !=null) {
	       Statement stmt = con.createStatement(); 
	       String SQL1="exec QASpChangeMonthDate ";
	       ResultSet rs2= stmt.executeQuery(SQL1);
	       int counter=0;
	       while(rs2.next()) {
	    	   
	    	   counter=counter+1;
	           NewDate=rs2.getString(1);
	    
	       }
	       
	       if(counter==0) {
	    	   
	    	   Driver.tcFlag = "FAIL";
	    	   Driver.comment = "Database didnot return any records";
	    	   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);  
	    	   break Parenttry;
	    	   
	       }
	     }
	    System.out.println("Changed Date"+NewDate);
		//stmt.execute(SQL1);
	    System.out.println("Month Changed");
	    Driver.tcFlag = "PASS";
		Driver.comment = "Pass"; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	    
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = "Didnot connect to database";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
	
}
	    
	}
 public static void ReadCCRenewalOD_ResolutionDate(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException, InterruptedException {
	  
	 System.out.println("CASH CREDIT RENEWAL RESOLUTION DATE");

	 String ValueDate = null;
	 Connection con = DatabaseConnector();
	 if(con !=null) {
	        Statement stmt = con.createStatement();
	 
	        String Query_ValueDate="select * from TransactionDate\r\n" +"";
	        
	        ResultSet rs= stmt.executeQuery(Query_ValueDate);
	        int counter=0;
	        while(rs.next()) {
	        
	         counter=counter+1;	
	         ValueDate=rs.getString(1);
	    
	        }
	        
	        if(counter==0) {
	        	
	        	Driver.tcFlag = "FAIL";
	   		    Driver.comment = "Database didnot return any records";
	   		    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	        	
	        	
	        }else {
	        
	        System.out.println("Value Date without convertion"+ValueDate);
		    String Value_Date=ValueDate.substring(0, 10);
		    System.out.println("Substring of value date"+Value_Date);
			SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
			Date newValdate = null;
			try {
				newValdate = sdfrmt1.parse(Value_Date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
			String VALUEDATE=sdfrmt1.format(newValdate);
	        System.out.println("Value Date :"+VALUEDATE);
	        Thread.sleep(1000);
	       //Driver.driver.findElement(By.xpath(propertyValue)).click();	
		    Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(VALUEDATE);	
		   //Driver.driver.findElement(By.xpath(propertyValue)).click();
            Driver.tcFlag = "PASS";
	        Driver.comment = "Pass";
	        Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment); 
	        }
	 }else {
		 
		 Driver.tcFlag = "FAIL";
		 Driver.comment = "Didnot connect to database";
		 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	 }
	}

 public static void CheckInterestTransfer(WebDriver driver, String propertyValue ) throws Exception {
	 
	 System.out.println("INTEREST TRANSFER");
try {
	// TODO Auto-generated method stub
	
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
			.withTimeout(15, TimeUnit.MINUTES) 	
			 .ignoring(NullPointerException.class)
             .ignoring(StaleElementReferenceException.class)
             .ignoring(NoSuchElementException.class)
             .ignoring(ElementNotVisibleException.class)
             .ignoring(WebDriverException.class)
			.pollingEvery(5, TimeUnit.MILLISECONDS);			
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='btnInterestTransfer']")));
	System.out.println("Interest transfer is clickable");
	
	if(driver.findElement(By.xpath(".//*[@id='btnInterestTransfer']")).isEnabled()) {
		System.out.println("Entered to Enable loop");
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		//Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='btnInterestTransfer']")).click();
		Thread.sleep(5000);
		SwitchToChildWindow.SwitchToChild(driver, propertyValue );
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
		Thread.sleep(5000);
		SwitchToParentWindow.SwitchToParent(driver,  propertyValue);
		 Driver.tcFlag = "PASS";
	     Driver.comment = "Pass";
	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment); 
		}
	else
	{
		System.out.println("Entered to Else Loop");
	driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_chkStandingInstruction']")).click();
	driver.findElement(By.xpath(".//*[@id='btnInterestTransfer']")).click();
	SwitchToChildWindow.SwitchToChild(driver, propertyValue );
	Select sel1=new Select(driver.findElement(By.xpath(".//*[@id='ucStndInstrAccInfo_ddlBranch']")));
	sel1.selectByVisibleText("MAIN BRANCH");
	Thread.sleep(5000);
	Select sel2=new Select(driver.findElement(By.xpath(".//*[@id='ucStndInstrAccInfo_ddlFromProduct_ddl']")));
	sel2.selectByVisibleText("ORDINARY SB");
	Thread.sleep(5000);
	driver.findElement(By.xpath(".//*[@id='ucStndInstrAccInfo_txtStandAcNoF_txt']")).sendKeys(""+30110);
	Thread.sleep(8000);
	driver.findElement(By.xpath(".//*[@id='ucStndInstrAccInfo_txtExeFrequency_txt']")).sendKeys(""+1);
	Thread.sleep(5000);
	driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
	SwitchToParentWindow.SwitchToParent(driver,  propertyValue);
	Driver.tcFlag = "PASS";
    Driver.comment = "Pass";
    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment); 
	
  }
	System.out.println("END");
}catch(Exception e) {
	
	 Driver.tcFlag = "FAIL";
	 Driver.comment = "Required object is not identified or displayed";
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
 }
 public static void ClickonCheckAvailability(WebDriver driver, String PropertyValue) throws Exception {
		
		System.out.println("Click On Check Availability Button");
	try {	
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Window Title "+driver.getTitle());
		driver.findElement(By.xpath(PropertyValue)).click();
		System.out.println("Clicked On Check Availability Button");
		 Thread.sleep(5000);
		String subWindowHandler = null;
		System.out.println("1");
        Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		        subWindowHandler = iterator.next();
		    }
		driver.switchTo().window(subWindowHandler);
		System.out.println("2");
		driver.close();
		System.out.println("3");
		driver.switchTo().window(parentHandle);
		System.out.println("4");
		driver.switchTo().frame(0);
		System.out.println("5");
				
		Driver.tcFlag = "PASS";
	    Driver.comment = "Pass";
	    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment); 
	}catch(Exception e) {
		
		Driver.tcFlag = "FAIL";
		Driver.comment = "Required object is not displayed or identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		
	}
		
		
}
 public static void CheckAvailabilityforQuickCustomer(WebDriver driver, String PropertyValue) throws Exception {
		
		System.out.println("Click On Check Availability Button");
try {		
		String parentHandle = driver.getWindowHandle();
		driver.findElement(By.xpath(PropertyValue)).click();
	    String subWindowHandler = null;
	    Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		        subWindowHandler = iterator.next();
		    }
		driver.switchTo().window(subWindowHandler);
		driver.close();
		driver.switchTo().window(parentHandle);
		//driver.switchTo().frame(0);
		Driver.tcFlag = "PASS";
	    Driver.comment = "Pass";
	    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment); 
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = "Required object is not displayed or identified";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
		
		
} 
 public static void HandlePopup(WebDriver driver) throws Exception {
		
		System.out.println("Click On Save&Proceed Button");
try {		
		String parentHandle = driver.getWindowHandle();
		driver.findElement(By.xpath(" //input[@name='ctl00$CPHFrame$btnSave']")).click();
		String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		        subWindowHandler = iterator.next();
		    }
		driver.switchTo().window(subWindowHandler);
		driver.close();
		driver.switchTo().window(parentHandle);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath(" //input[@name='ctl00$CPHFrame$btnSave']")).click();
		Driver.tcFlag = "PASS";
	    Driver.comment = "Pass";
	    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment); 
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = "Required object is not displayed or identified";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
		
} 
 
 public static void ClickonGoButton(WebDriver driver, String trim ) throws Exception {
		
	  System.out.println("GO Button");
try {	  
	  Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
	//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	
	try {
		
    	   	driver.findElement(By.xpath("html/body/div[3]/div[3]/div/button")).click();
    	   	Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
          	
       }catch(Exception e) {
       	
          	     	}
	Driver.tcFlag = "PASS";
  	Driver.comment = "Pass"; 
  	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);   
  	
}catch(Exception e) {
	Driver.tcFlag = "FAIL";
	Driver.comment = "Required object is not displayed or identified";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	}
	
}
 
 public static void ClickonGoButton_InterestPayment(WebDriver driver, String PropertyValue) throws Exception {
		
	  System.out.println("GO Button");
	 Thread.sleep(2000);
try {	 
	  driver.findElement(By.xpath(PropertyValue)).click();
	  Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
	  //driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	
	try {
		
   	   	driver.findElement(By.xpath(".//*[@id='closewarning']")).click();
   	   	Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
         
      }catch(Exception e) {
      	
            }
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass"; 
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment); 
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = "Required object is not displayed or identified";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
	
}
 public static void ClickonSubmitButton(WebDriver driver, String Propertyvalue) throws Exception {
		
		System.out.println("Submit");
try {		
		driver.findElement(By.xpath(Propertyvalue)).click();
		System.out.println("Clicked");
		Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		try {
			
	     	   	driver.findElement(By.xpath(".//*[@id='closewarning']")).click();
	     	   	Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
	     	    driver.findElement(By.xpath(Propertyvalue)).click();
	           	

	        }catch(Exception e) {
	        	
	           	 	}
		Driver.tcFlag = "PASS";
 	  	Driver.comment = "Pass"; 
 	  	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);       
		
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = "Required object is not displayed or identified";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
	}
 
 public static void ClickonSubmitButton_Batch(WebDriver driver, String Propertyvalue) throws Exception {
		
		System.out.println("Submit");
try {		
		driver.findElement(By.xpath(Propertyvalue)).click();
		System.out.println("Clicked");
		
		Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
		try {
			
			if(driver.findElement(By.xpath("html/body/div[2]/div[11]/div/button[1]")).isDisplayed()) {
				
				driver.findElement(By.xpath("html/body/div[2]/div[11]/div/button[1]")).click();
				Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
				//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			}
			else if(driver.findElement(By.xpath(".//*[@id='closewarning']")).isDisplayed()) {
	     	   	driver.findElement(By.xpath(".//*[@id='closewarning']")).click();
	     	   	Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
	     	    driver.findElement(By.xpath(Propertyvalue)).click();
	     		Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
	     		driver.findElement(By.xpath("html/body/div[2]/div[11]/div/button[1]")).click();
	     		
			}
          }catch(Exception e) {
	        	
	           	      	
	         }
		
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = "Required object is not displayed or not identified";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
		
	}
 
 public static void ChangeTransactionDate() throws ClassNotFoundException, SQLException {
	 System.out.println("Inside Date Change method");
	 Connection con = DatabaseConnector();
	 if(con !=null) {
	        Statement stmt = con.createStatement();
	   
	 String SQL="exec QASpChangeDateForDeposit ";
	 stmt.execute(SQL);
	 System.out.println("Date Changed");
	 }else {
		 
		 Driver.tcFlag = "FAIL";
	     Driver.comment = "Didnot connect to database";
	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment); 
	 }
	}
 
 public static void Execute_SP() throws ClassNotFoundException, SQLException {
	 System.out.println("Inside Date chande Sp for daybegin admin");
	 Connection con = DatabaseConnector();
	 if(con !=null) {
	        Statement stmt = con.createStatement();
	   
	 String SQL="exec QASpChangeDate";
	 stmt.execute(SQL);
	 Driver.tcFlag = "PASS";
	 Driver.comment = "Pass"+" # "+"Data Changed for Daybegin Admin"; 
	 Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	 System.out.println("Ready for Admin daybegin");
	 }else {
		 
		 Driver.tcFlag = "FAIL";
	     Driver.comment = "Didnot connect to database";
	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment); 
	 }
	}
 
 public static void ReadFromDataFileCommon (WebDriver driver, String FileName,String SavedName) throws ClassNotFoundException, SQLException, IOException, BiffException 
	{
	 	Properties prop = new Properties();
		InputStream input = new FileInputStream(FileName);
		prop.load(input);
		DatafileValue = prop.getProperty(SavedName);
		System.out.println("Value from datafile = "+DatafileValue);
		
		//driver.findElement(By.id(propertyValue)).sendKeys(LockerNo);
		//System.out.println("Locker number = "+propertyValue);
		
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "Readed value = " + DatafileValue; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
 
 public static void ReadElementAndSendKeys (WebDriver driver,String propertyValue, String testData) throws InterruptedException, IOException
	{
			Properties prop = new Properties();
			InputStream input = new FileInputStream(testData);
			prop.load(input);
			String Element = prop.getProperty("Date");
			String Element1 = prop.getProperty("Month");
			String Element2 = prop.getProperty("Year");
			//Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(LockerNumber);
			System.out.println("Element = "+Element);
			System.out.println("Element1 = "+Element1);
			System.out.println("Element2 = "+Element2);
			
			//driver.findElement(By.id(propertyValue)).click(); // Click to focus on the input field
			String locatorType = "id";
			DifferentTypesOfWaits.FluentWait(driver, locatorType, propertyValue);
			
			driver.findElement(By.id(propertyValue)).clear(); // Clear existing content if any
			driver.findElement(By.id(propertyValue)).sendKeys(Element); // Enter the desired date
			driver.findElement(By.id(propertyValue)).sendKeys(Element1);
			driver.findElement(By.id(propertyValue)).sendKeys(Element2);
			
			
			//driver.findElement(By.id(propertyValue)).sendKeys(Element);
			//System.out.println("For loop if = "+propertyValue);
			
			Driver.tcFlag = "PASS";
			//Driver.comment = "Pass";
			Driver.comment = "Pass" + " # " + "Locker Number readed from file= " + Element; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);

	}
 
 }

