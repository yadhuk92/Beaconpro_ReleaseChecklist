package com.org.demoPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LockerRentVerification 
{
	private static Object RentFromSQLQuery = null;

	public static void VerifyLockerRent (WebDriver driver,String propertyValue, String testData) throws ClassNotFoundException, SQLException
	{
		String LockerRentDisplayed = driver.findElement(By.id(propertyValue)).getAttribute("value");
		System.out.println("Locker rent Displayed = "+LockerRentDisplayed);
		String LockerType = driver.findElement(By.id("ctl00_ctl00_CPH1_PRDCNT_ddlLockerType_ddl")).getAttribute("value");
		System.out.println("Locker Type selected = "+LockerType);
		String LockerSize = driver.findElement(By.id("ctl00_ctl00_CPH1_PRDCNT_ddlLockerSize_ddl")).getAttribute("value");
		System.out.println("Locker size selected = "+LockerSize);
		
		String columnValue = null;
		Connection con=(Connection) Common.DatabaseConnector();
		if(con !=null) 
		{
				Statement stmt = con.createStatement();	
				Statement stmt2 = con.createStatement();
				
				String TransactionDate="select * from transactiondate"; 
				ResultSet rs2= stmt2.executeQuery(TransactionDate);
				
				ResultSetMetaData rsmd = rs2.getMetaData();
				//int columnsNumber = rsmd.getColumnCount();
				//String columnValue;
				while (rs2.next()) 
				{
				    //for (int i = 1; i <= columnsNumber; i++) 
				    //{
				       // if (i > 1) System.out.print(",  ");
				        columnValue = rs2.getString("CurrentTransDate");
				        System.out.println(rsmd.getColumnName(1) + " =" + columnValue);
				    //}
				    //System.out.println("");
				}
				
				//System.out.println("Transaction date = "+rs2);
				
				String LockerRentInSP ="exec spGetLockerRentSetting @ProductID=" +LockerType+ ",@Size=" +LockerSize+",@AsOnDate='"+columnValue+"'"; 
				ResultSet rs1= stmt.executeQuery(LockerRentInSP);
				ResultSetMetaData rsmd1 = rs1.getMetaData();
				//int columnsNumber1 = rsmd1.getColumnCount();
				int counter=0;
	
			while(rs1.next()) 
			{
				counter=counter+1;
				//for (int i = 1; i <= columnsNumber1; i++) 
			   // {
			       // if (i > 1) System.out.print(",  ");
			        RentFromSQLQuery = rs1.getString("Rent");
			        System.out.println(rsmd1.getColumnName(2) + " =" + RentFromSQLQuery);
			   // }
			    System.out.println("");
			}
			
			if(LockerRentDisplayed.equals(((String) RentFromSQLQuery).substring(0,6))) {
				
				System.out.println("Locker Rent from UI and DB are equal");
				 Driver.tcFlag = "PASS";
				Driver.comment = "Pass" + " # " + "Locker Rent From UI= " + LockerRentDisplayed + "<br>" + "Locker Rent From DB= " + ((String) RentFromSQLQuery).substring(0,6); 
			 	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			 	
			}
			else {
				
				Driver.tcFlag = "FAIL";
				Driver.comment = "Fail" + " # " + "Locker Rent From UI= " + LockerRentDisplayed + "<br>" + "Locker Rent From DB= " + ((String) RentFromSQLQuery).substring(0,6); 		//Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}

		}	
		else 
		{
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
	}
	
	public static void LockerNumberAlreadyExist (WebDriver driver,String propertyValue)
	{
		try
		{
			//System.out.println("Entered into for loop wait and send keys");
			for(int i=0; i<60; i++)
			{
				try
				{
					if (driver.findElement(By.id(propertyValue)).isEnabled())
					{
						driver.findElement(By.id(propertyValue)).click();
						//System.out.println("For loop if = "+propertyValue);
						
						Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
						
						break;
					}
					else
					{
						System.out.println("For loop else");
					}
				}
				catch(Exception e1)
				{
					System.out.println("Catch exception");
				}
			}
		}
		catch(Exception e)
		{
			Driver.tcFlag = "FAIL";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
	}
	
	public static void ClearTextField (WebDriver driver,String propertyValue)
	{
		try
		{
			driver.findElement(By.id(propertyValue)).clear();
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "Field cleared" ;
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
		catch(Exception e)
		{
			Driver.tcFlag = "FAIL";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
	}

}
