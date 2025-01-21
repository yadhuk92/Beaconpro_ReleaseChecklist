package com.org.demoPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralUtilities {

	public static void getAadhaar()  throws IOException {
		
		
		String s = System.currentTimeMillis()/10 + "";
		Driver.uniquenumber = s;
		
	}
	
	
	public static void test() throws ClassNotFoundException, SQLException{
		Connection testcon =(Connection) Common.DatabaseConnector();
		System.out.println("Connection: " + testcon);
		
		if (testcon != null){
			Statement teststmt = testcon.createStatement();
			String testquery = "select distinct AcNo,AgentCode\r\n" + 
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
			ResultSet testrs = teststmt.executeQuery(testquery);
			String ACNO = "";
			int counter=0;
			while (testrs.next()){
				counter=counter+1;
				ACNO = testrs.getString(1);
				System.out.println(ACNO);
			}
			if(counter==0) {
				
				 Driver.tcFlag = "FAIL";
		   	     Driver.comment = "Database did not return any records";
		   	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			System.out.println("Successfull");
			System.out.println(ACNO.substring(10,15));
			Driver.tcFlag = "PASS";
		    Driver.comment = "Pass"+" # "+"Account No: " +ACNO.substring(10,15);
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription, Driver.comment);	
		}else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		
		
		//Driver.tcFlag = "PASS";
	}

	public static void ArrearPopUps(WebDriver driver, String locatorType, String propertyValue, String testData) throws SQLException, InterruptedException{
		
		try{
			
			String xpathprop = ".//*[@id='closewarning']";
			WebElement element = driver.findElement(By.xpath(xpathprop));
			if (element.isDisplayed()){
				element.click();
				xpathprop = ".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnSubmit']";
				element = driver.findElement(By.xpath(xpathprop));
				Thread.sleep(3000);
				if (element.isDisplayed()){
					element.click();
					xpathprop = "html/body/div[2]/div[11]/div/button[1]";
					element = driver.findElement(By.xpath(xpathprop));
					Thread.sleep(3000);
					if (element.isDisplayed()){
						element.click();
						Driver.tcFlag = "PASS";
					}
				}
			}
			
		}catch(Exception e){
			
		}
		
		//ODCredit_Trans_Account_is_Due_PopUp
		//Beacon_Chitty_Bidding_SubmitButton
		//Share_AClassShareBatch_OkButton
		
	}// End of test1 Method
	
	
	
	
}
