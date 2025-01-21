package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import jxl.read.biff.BiffException;

public class WriteLockerDetails 
{
public static String LockerNO;
public static String LockerNumber2 = null;

	public static WebDriver WriteLockerNo(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException, IOException 
	{
		  String LockerNumber=null;
		  Connection con=(Connection) Common.DatabaseConnector();
		  Statement stmt = con.createStatement();
		  
		  String SQL1 = "Exec spGetLockerMasterList @ProductID=7005,@RowIndex=1,@PageSize=1";
			ResultSet rs2= stmt.executeQuery(SQL1);
			int counter = 0;
	    	while(rs2.next()) 
	    	{
	    		counter = counter + 1;
	    		LockerNumber=rs2.getString(7);
	    		//System.out.println("Locker number = "+LockerNumber);
	    	}
			//driver.findElement(By.id(propertyValue)).sendKeys(LockerNumber);
			
			Properties prop=new Properties();
			
			FileOutputStream fos = new FileOutputStream("./DataFiles/LockerAddingDetails.properties");
			prop.setProperty("Locker_number", LockerNumber);
			
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass";
			Driver.comment = "Pass" + " # " + "Locker Number feteched from query= " + LockerNumber;
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			
			//System.out.println("Written");
			prop.store(fos, "Done");
			fos.close();
			return driver;
	}
	
	public static WebDriver WriteLockerRentDetails(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException, IOException, BiffException 
	{
		WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 1269);
		System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
		System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
		String RentFromInterface=driver.findElement(By.id(WriteIntoDataFiles.Property_Value)).getAttribute("value");
		System.out.println("RentFromInterface="+ RentFromInterface + "\n");
		
		WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 1281);
		System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
		System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
		String GraceDuration=driver.findElement(By.id(WriteIntoDataFiles.Property_Value)).getAttribute("value");
		System.out.println("Grace Duration="+ GraceDuration + "\n");
		
		WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 1283);
		System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
		System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
		String NoOfFreeVisit=driver.findElement(By.id(WriteIntoDataFiles.Property_Value)).getAttribute("value");
		System.out.println("NoOfFreeVisit="+ NoOfFreeVisit + "\n");
		
		WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 1279);
		System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
		System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
		String  Locker_Type =driver.findElement(By.id(WriteIntoDataFiles.Property_Value)).getAttribute("value");
		System.out.println("Locker Type="+ Locker_Type + "\n");
		
		WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 1268);
		System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
		System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
		String  Locker_Size =driver.findElement(By.id(WriteIntoDataFiles.Property_Value)).getAttribute("value");
		System.out.println("Locker Size="+ Locker_Size + "\n");
		String Locker_Size_substr = Locker_Size.substring(1,2);
		System.out.println("Locker Size substring="+ Locker_Size_substr + "\n");  
			
		Properties prop=new Properties();
		
		FileOutputStream fos = new FileOutputStream("./DataFiles/LockerRentWindowDetails.properties");
		prop.setProperty("RentFromInterface", RentFromInterface);
		prop.setProperty("GraceDuration", GraceDuration);
		prop.setProperty("NoOfFreeVisit", NoOfFreeVisit);
		prop.setProperty("Locker_Type", Locker_Type);
		prop.setProperty("Locker_Size_substr", Locker_Size_substr);
		
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.comment = "Pass" + " # " + "All fields saved in LockerRentWindowDetails.properties file";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		
		//System.out.println("Written");
		prop.store(fos, "Done");
		fos.close();
		return driver;
	}
	
	public static void GeneratingLockerNumber (WebDriver driver,String propertyValue, String testData) throws ClassNotFoundException, SQLException, IOException
	{
		//String LockerNumber2;
		String NotExistingLockerNumber=null;
		  Connection con=(Connection) Common.DatabaseConnector();
		  Statement stmt = con.createStatement();
		  
		  String SQL1 = "Exec spQALockerNumberGenerating @ProductID=7005";
		  
		  System.out.println("GeneratingLockerNumber");
			ResultSet rs2= stmt.executeQuery(SQL1);
			int counter = 0;
	    	while(rs2.next()) 
	    	{
	    		counter = counter + 1;
	    		NotExistingLockerNumber=rs2.getString(1);
	    		System.out.println("Locker number from spQALockerNumberGenerating = "+NotExistingLockerNumber);
	    	}
			//driver.findElement(By.id(propertyValue)).sendKeys(LockerNumber);
			
			Properties prop=new Properties();
			
			FileOutputStream fos = new FileOutputStream("./DataFiles/LockerAddingDetails.properties");
			prop.setProperty("Not_Existing_Locker_Number", NotExistingLockerNumber);

			//System.out.println("Written");
			prop.store(fos, "Done");
//			fos.close();
//			return driver;
			
			//Properties proper = new Properties();
			InputStream input = new FileInputStream(testData);
			prop.load(input);
			LockerNumber2 = prop.getProperty("Not_Existing_Locker_Number");
			//Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(LockerNumber);
			driver.findElement(By.id(propertyValue)).sendKeys(LockerNumber2);
			System.out.println("Locker number which is entered = "+LockerNumber2);
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "Locker Number feteched from query= " + NotExistingLockerNumber + "<br>" + "Locker Number readed from file= " + LockerNumber2; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			//return driver;
	}
	
}
