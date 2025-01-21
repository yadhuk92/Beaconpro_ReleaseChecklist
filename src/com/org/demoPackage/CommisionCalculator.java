package com.org.demoPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommisionCalculator {
	
	public static void getCommisionAmount( WebDriver driver,String propertyValue) {
		
		Float Chitty_Amount, Commision_Amount ;
		
		//Chitty_Amount= driver.findElement(By.xpath(".//*[@id='ChittyInfoContainer']/tr/td[3]")).getText();
		try {	
			Chitty_Amount= Float.valueOf(driver.findElement(By.xpath(".//*[@id='ChittyInfoContainer']/tr/td[3]")).getText());
			//System.out.println("Chitty Amoun t"+Chitty_Amount);
		
			WebElement CommPerc=driver.findElement(By.xpath(".//*[@id='ChittyInfoContainer']/tr/td[9]")) ;
			String str= CommPerc.getText();
			String newStr= str.replaceAll("%", "");
			int Commision_Percentage= Integer.parseInt(newStr);
			//System.out.println("Commision rate "+Commision_Percentage);
		
			Commision_Amount=Float.valueOf((Chitty_Amount*Commision_Percentage)/100);
			//System.out.println("Commision Amount "+Commision_Amount);
		
			driver.findElement(By.xpath(propertyValue)).sendKeys(""+Commision_Amount);
		
		
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}catch(Exception e) {
		
		Driver.tcFlag = "FAIL";
	    Driver.comment = "Element is not diplayed or identified";
	    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	}
	}

public static void GetSBAccountNoForTransfer(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		
		 //System.out.println("READ SB ACCOUNT NUMBERS");
		
		  String Custid=null;
		  String Accno=null;
		  String Name=null;
		  Connection con=(Connection) Common.DatabaseConnector();
		  if(con !=null) {
		    Statement stmt = con.createStatement(); 
		    
		    try {	    
		    	//String SQL1="exec QaOutstanding 1,1000000,2000000,10001,102"; // commented on January 29th, 2019
		    	String SQL1 = " exec QaOutstanding 1,100000,200000000,10001,102";
		    	ResultSet rs2= stmt.executeQuery(SQL1);
		    	Thread.sleep(1000);
		    	int counter = 0;
		    	while(rs2.next()) {
		    		counter = counter + 1;
		    		Accno=rs2.getString(2);
		        
		    
		    	}
		    	
		    	if (counter == 0) {
		    		Driver.tcFlag = "FAIL";
		    		Driver.comment = "Database did not return any records";
		    		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		    	}else {
			    	String ACCNO=Accno.substring(10, 15);
			    	//System.out.println("SB AccountNo:"+ACCNO);
			    	driver.findElement(By.xpath(PropertyValue)).clear();
			    	Thread.sleep(1000);
			    	driver.findElement(By.xpath(PropertyValue)).sendKeys(""+ACCNO);
			    	Thread.sleep(3000);
			    	Driver.tcFlag = "PASS";
			    	Driver.comment = "Pass" + " # " + "SB AccNO: " +ACCNO; 
			    	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		    		
		    	}
		       
		       
		    }catch(Exception e) {
		
		    	Driver.tcFlag = "FAIL";
		    	Driver.comment = Driver.objectName + " is not displayed or not identified";
		    	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		
		    }
	   
		 }
		  else {
			  
			  Driver.tcFlag = "FAIL";
	    	  Driver.comment = "Database is not connected";
	    	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment); 
		  }
	}
public static void GetFDAccountNo(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException, InterruptedException {
	
	//System.out.println("READ FD ACCOUNT NUMBERS");
	
	String Accno=null;
	parenttry: try {	  
		Connection con=(Connection) Common.DatabaseConnector();
		if(con !=null) {
			Statement stmt = con.createStatement(); 
			String SQL1="Select Top 1 AcNo,* from viAccMaster --a join securitymaster m on a.accmasterid=m.accmasterid\r\n" + 
					" where ProductID=12001 and DueDate>(Select * from TransactionDate) and IsClosed=0 and OrgBranchID=102\r\n" + 
					" and RecordStatus=3 \r\n" + 
					" and AccMasterID not in (Select DepositAccMasterID from SecurityDeposits)and AcOpeningAmount<=100000";
	    
			ResultSet rs2= stmt.executeQuery(SQL1);
			Thread.sleep(1000);
			int counter = 0;
			while(rs2.next()) {
				counter = counter + 1;
				Accno=rs2.getString(1);
	         
			}
			
			if (counter == 0) {
				Driver.tcFlag = "FAIL";
				Driver.comment = "Database did not return any records";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				break parenttry;
			}
	       
			//System.out.println(Accno);
			String ACCNO=Accno.substring(9, 15);
			//System.out.println("FD AccountNo:"+ACCNO);
			driver.findElement(By.xpath(PropertyValue)).sendKeys(""+ACCNO);
			//Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpSecurity_tbSecurity_tpSecDeposit_SDF_btnSDADD']")).click();
			//System.out.println("Clicked1");
			//Thread.sleep(3000);
			Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			//System.out.println("Checking for popups");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			try {
				driver.findElement(By.xpath(".//*[@id='closewarning']")).click();
				//System.out.println("Clicked2");
				Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass"; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);

			}catch(Exception e) {
				//e.getStackTrace();
				//System.out.println("Clicked3");

				Driver.tcFlag = "PASS";
				Driver.comment = "Pass"; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment); 
			}

			//System.out.println("AccNo entered");
  
		}
	}catch(Exception e) {
	
		Driver.tcFlag = "FAIL";
		Driver.comment = "Didnot connect to database";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	}
}


  public static void PostSanctionedAmountCalculator(WebDriver driver,String propertyValue) {
	
	  try {	
		  Thread.sleep(3000);
		  String balanceAmount=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_tbLoan_tpLoanDet_lstLoanDetail_ctrl0_LDF_txtEligibility_txt']")).getAttribute("value");
		  System.out.println("Sanctioned Amount"+balanceAmount);
		  //Thread.sleep(3000);
		  driver.findElement(By.xpath(propertyValue)).sendKeys(""+balanceAmount);
		  Driver.tcFlag = "PASS";
		  Driver.comment = "Pass";
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	  }catch(Exception e){
		  Driver.tcFlag = "FAIL";
		  Driver.comment = "Element is not diplayed or identified";
		  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
	  }
	
  }
  
  public static void GetFDAccountNo2(WebDriver driver, String PropertyValue) throws ClassNotFoundException, SQLException, IOException, InterruptedException 
  {
	  String Accno=null;
	  parenttry: try {	  
		  Connection con=(Connection) Common.DatabaseConnector();
			if(con !=null) {
				Statement stmt = con.createStatement(); 
				String SQL1="Select Top 1 AcNo,* from viAccMaster --a join securitymaster m on a.accmasterid=m.accmasterid\r\n" + 
						" where ProductID=12001 and DueDate>(Select * from TransactionDate) and IsClosed=0 and OrgBranchID=102\r\n" + 
						" and RecordStatus=3 \r\n" + 
						" and AccMasterID not in (Select DepositAccMasterID from SecurityDeposits)and AcOpeningAmount<=100000";
		    
				ResultSet rs2= stmt.executeQuery(SQL1);
				int counter = 0;
				while(rs2.next()) {
					counter = counter + 1;
					Accno=rs2.getString(1);
		         
				}
				
				if (counter == 0) {
					Driver.tcFlag = "FAIL";
					Driver.comment = "Database did not return any records";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					break parenttry;
				}
				String ACCNO=Accno.substring(9, 15);
				driver.findElement(By.xpath(PropertyValue)).sendKeys(""+ACCNO);
				
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	  
			}
		}
	  catch(Exception e) 
	  	{
			Driver.tcFlag = "FAIL";
			Driver.comment = "Didnot connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
	}
}
