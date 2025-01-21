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
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class WriteIntoDataFiles 
{
	public static String orFile = "./ObjectRepository/orsample.xls";
	public static String Property_Value;
	public static String Object_Name;
	
	public static void ReadPropertyValueFromObjectRepository(WebDriver driver, int testData) throws ClassNotFoundException, SQLException, IOException, BiffException 
	{
		FileInputStream fs = new FileInputStream(orFile);
		Workbook wb = Workbook.getWorkbook(fs);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet("Sheet1");
		
		//String ObjColumn = "0";
		
		//System.out.print("Object_Name=" + sh.getCell(0,testData).getContents() + "\n" + "Property_Value=" + sh.getCell(2,testData).getContents() + "\n");
		Property_Value = sh.getCell(2,testData).getContents();
		Object_Name = sh.getCell(0,testData).getContents();
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.comment = "Pass" + " # " + "object name fetched from object repository =" + Object_Name;
		//Driver.comment = "Pass" + " # " + "property value fetched from object repository =" +Property_Value;
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
	
	public static void LockerRentSettingRentVerification(WebDriver driver,String propertyValue, String testData) throws ClassNotFoundException, BiffException, SQLException, IOException
	{
		Properties prop = new Properties();
		InputStream input = new FileInputStream(testData);
		prop.load(input);
		String Locker_Rent = prop.getProperty("RentFromInterface");
		System.out.println("Locker_Rent = "+Locker_Rent);
		
		String Locker_Type = prop.getProperty("Locker_Type");
		System.out.println("Locker_Type = "+Locker_Type);
		
		String Locker_Size_substr = prop.getProperty("Locker_Size_substr");
		System.out.println("Locker_Size_substr = "+Locker_Size_substr);
		
		String RentFromDatabase=null;
		String RentFromDatabase_SubString=null;
		Connection con=(Connection) Common.DatabaseConnector();
		Statement stmt = con.createStatement();
		  
		 String SQL1 = "select top 1 * from LockerRentSettings where ProductID="+Locker_Type+"and Size="+Locker_Size_substr+" order by SettingsID desc";
			ResultSet rs2= stmt.executeQuery(SQL1);
			int counter = 0;
	    	while(rs2.next()) 
	    	{
	    		counter = counter + 1;
	    		RentFromDatabase=rs2.getString(5);
	    		//System.out.println("RentFromDatabase= "+RentFromDatabase);
	    		RentFromDatabase_SubString = RentFromDatabase.substring(0,6);
	    		//System.out.println("RentFromDatabase_SubString= "+RentFromDatabase_SubString);
	    	}
	    if(Locker_Rent.equals(RentFromDatabase_SubString)) 
	    {
	    	System.out.println("Rent from database and interface are equal");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "Value From UI: " + Locker_Rent + "<br>" + "Value From LockerRentSettings table: " + RentFromDatabase_SubString; 
		 	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	    }
	    else 
	    {	
			Driver.tcFlag = "FAIL";
			Driver.comment = "FAIL" + " # " + "Value From UI: " + Locker_Rent + "<br>" + "Value From LockerRentSettings table: " + RentFromDatabase_SubString;
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
	}
	
	public static void LockerRentGraceDurationVerification(WebDriver driver,String propertyValue, String testData) throws ClassNotFoundException, BiffException, SQLException, IOException
	{
		Properties prop = new Properties();
		InputStream input = new FileInputStream(testData);
		prop.load(input);
		String GraceDuration = prop.getProperty("GraceDuration");
		System.out.println("GraceDuration = "+GraceDuration);
		
		String Locker_Type = prop.getProperty("Locker_Type");
		System.out.println("Locker_Type = "+Locker_Type);
		
		String Locker_Size_substr = prop.getProperty("Locker_Size_substr");
		System.out.println("Locker_Size_substr = "+Locker_Size_substr);
		
		String GraceDurationFromDatabase=null;
		Connection con=(Connection) Common.DatabaseConnector();
		Statement stmt = con.createStatement();
		  
		String SQL1 = "select top 1 * from LockerRentSettings where ProductID="+Locker_Type+"and Size="+Locker_Size_substr+" order by SettingsID desc";
		ResultSet rs2= stmt.executeQuery(SQL1);
		int counter = 0;
	    	while(rs2.next()) 
	    	{
	    		counter = counter + 1;
	    		GraceDurationFromDatabase=rs2.getString(8);
	    		//System.out.println("GraceDurationFromDatabase= "+GraceDurationFromDatabase);
	    	}
	    if(GraceDuration.equals(GraceDurationFromDatabase)) 
	    {
	    	System.out.println("Grace Duration from database and interface are equal");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "Value From UI: " + GraceDuration + "<br>" + "Value From LockerRentSettings table: " + GraceDurationFromDatabase; 
		 	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	    }
	    else 
	    {	
			Driver.tcFlag = "FAIL";
			Driver.comment = "FAIL" + " # " + "Value From UI: " + GraceDuration + "<br>" + "Value From LockerRentSettings table: " + GraceDurationFromDatabase;
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		
	}
	
	public static void LockerRentNoOfFreeVisitVerification(WebDriver driver,String propertyValue, String testData) throws ClassNotFoundException, BiffException, SQLException, IOException
	{
		Properties prop = new Properties();
		InputStream input = new FileInputStream(testData);
		prop.load(input);
		String NoOfFreeVisit = prop.getProperty("NoOfFreeVisit");
		System.out.println("NoOfFreeVisit = "+NoOfFreeVisit);
		
		String Locker_Type = prop.getProperty("Locker_Type");
		System.out.println("Locker_Type = "+Locker_Type);
		
		String Locker_Size_substr = prop.getProperty("Locker_Size_substr");
		System.out.println("Locker_Size_substr = "+Locker_Size_substr);
		
		String NoOfFreeVisitFromDatabase=null;
		  Connection con=(Connection) Common.DatabaseConnector();
		  Statement stmt = con.createStatement();
		  
		 String SQL1 = "select top 1 * from LockerRentSettings where ProductID="+Locker_Type+"and Size="+Locker_Size_substr+" order by SettingsID desc";
			ResultSet rs2= stmt.executeQuery(SQL1);
			int counter = 0;
	    	while(rs2.next()) 
	    	{
	    		counter = counter + 1;
	    		NoOfFreeVisitFromDatabase=rs2.getString(10);
	    	}
	    if(NoOfFreeVisit.equals(NoOfFreeVisitFromDatabase)) 
	    {
	    	System.out.println("NoOfFreeVisit from database and interface are equal");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "Value From UI: " + NoOfFreeVisit + "<br>" + "Value From LockerRentSettings table: " + NoOfFreeVisitFromDatabase; 
		 	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	    }
	    else 
	    {	
			Driver.tcFlag = "FAIL";
			Driver.comment = "FAIL" + " # " + "Value From UI: " + NoOfFreeVisit + "<br>" + "Value From LockerRentSettings table: " + NoOfFreeVisitFromDatabase;
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		
	}
	
}
