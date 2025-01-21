package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.read.biff.BiffException;

public class Locker 
{
	
	public static void GetCustomerIDForLockerOpening (WebDriver driver,String propertyValue, String testData) throws ClassNotFoundException, SQLException, IOException
	{
		String CustomerID=null;
		String AcNo=null;
		Connection con=(Connection) Common.DatabaseConnector();
		Statement stmt = con.createStatement();
		String SQL1 = "Exec spQAGetCustomerIDForLockerOpening @ProductID=12001,@BranchID=102,@SecurityType=3,@Top=10";
		ResultSet rs2= stmt.executeQuery(SQL1);
		int counter = 0;
		while(rs2.next()) 
		{
			  counter = counter + 1;
			  CustomerID=rs2.getString(1);
			  AcNo=rs2.getString(2);
		}
		System.out.println("CustomerID1 for locker opening = "+CustomerID);
		
		String CustomerID2=null;
		String AcNo2=null;
		Connection con2=(Connection) Common.DatabaseConnector();
		Statement stmt2 = con2.createStatement();
		String SQL2 = "Exec spQAGetCustomerIDForLockerOpening @ProductID=12001,@BranchID=102,@SecurityType=3,@Top=9";
		ResultSet rs1= stmt2.executeQuery(SQL2);
		int counter2 = 0;
		while(rs1.next()) 
		{
			  counter2 = counter2 + 1;
			  CustomerID2=rs1.getString(1);
			  AcNo2=rs1.getString(2);
		}
		System.out.println("CustomerID1 for locker opening = "+CustomerID2);
		
		Properties prop=new Properties();
		FileOutputStream fos = new FileOutputStream(testData);
		prop.setProperty("CustomerID1_For_LockerOpening", CustomerID);
		prop.setProperty("CustomerID1_AcNo", AcNo);
		prop.setProperty("CustomerID2_For_LockerOpening", CustomerID2);
		prop.setProperty("CustomerID2_AcNo2", AcNo2);
		prop.store(fos, "Done");
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "Cust ID fetched from spQAGetCustomerIDForLockerOpening= " + CustomerID; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
	
	public static void ReadFromTXTFileAndSendKeys (WebDriver driver,String propertyValue, String testData) throws InterruptedException, IOException, ClassNotFoundException, BiffException, SQLException
	{
		String Value =null;
		Properties prop = new Properties();
		InputStream input = new FileInputStream(testData);
		prop.load(input);
		Value = prop.getProperty("CustomerID1_For_LockerOpening");
		System.out.println("CustomerID1_For_LockerOpening = "+Value);
		
		driver.findElement(By.id(propertyValue)).sendKeys(Value);
		
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "Customer id for locker opening= " + Value; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
	
	public static void ReadFromTXTFileAndSendKeys2 (WebDriver driver,String propertyValue, String testData) throws InterruptedException, IOException, ClassNotFoundException, BiffException, SQLException
	{
		String Value =null;
		Properties prop = new Properties();
		InputStream input = new FileInputStream(testData);
		prop.load(input);
		Value = prop.getProperty("CustomerID2_For_LockerOpening");
		System.out.println("CustomerID2_For_LockerOpening = "+Value);
		
		driver.findElement(By.id(propertyValue)).sendKeys(Value);
		
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "Customer id for locker opening= " + Value; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
	
	public static void ReadFromTXTFileAndSendKeysForLockerNumber (WebDriver driver,String propertyValue, String testData) throws InterruptedException, IOException, ClassNotFoundException, BiffException, SQLException
	{
		String Value =null;
		Properties prop = new Properties();
		InputStream input = new FileInputStream(testData);
		prop.load(input);
		Value = prop.getProperty("Not_Existing_Locker_Number");
		System.out.println("Not_Existing_Locker_Number = "+Value);
		
		driver.findElement(By.id(propertyValue)).sendKeys(Value);
		
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "Customer id for locker opening= " + Value; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
	
	public static void RentVerificationLockerOpening (WebDriver driver,String propertyValue, String testData) throws InterruptedException, IOException, ClassNotFoundException, BiffException, SQLException
	{
		String Value =null;
		Properties prop = new Properties();
		InputStream input = new FileInputStream(testData);
		prop.load(input);
		Value = prop.getProperty("RentFromInterface");
		System.out.println("Locker rent while submit locker rent setting through admin = "+Value);
		
		String Rent = driver.findElement(By.id(propertyValue)).getAttribute("value");
		System.out.println("Locker rent from locker opening window = "+Rent);
		
		if (Value.equalsIgnoreCase(Rent))
		{
			System.out.println("Both rent are equal");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "Locker rent while submit locker rent setting through admin = "+Value + "<br>" + "Locker rent from locker opening window = "+Rent;
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
		else
		{
			System.out.println("Not equal");
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Pass" + " # " + "Locker rent while submit locker rent setting through admin = "+Value + "<br>" + "Locker rent from locker opening window = "+Rent;
		    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}

	}
	
	public static void EnterCautionDepAcNo (WebDriver driver,String propertyValue, String testData) throws InterruptedException, IOException, ClassNotFoundException, BiffException, SQLException
	{
		String Value =null;
		Properties prop = new Properties();
		InputStream input = new FileInputStream(testData);
		prop.load(input);
		Value = prop.getProperty("CustomerID1_AcNo");
		System.out.println("Caution deposit account number = "+Value);
		
		String res = Value.substring(8, 15);
		
		System.out.println("Sub string account number = "+res);
		
		driver.findElement(By.id(propertyValue)).sendKeys(res);
	}
	
	public static void ForLoopWaitBasedOnGetTextLocker (WebDriver driver, String locatorType,String propertyValue) throws InterruptedException
	{
		switch(locatorType.toLowerCase())
		{
		case "id":
		
			try
			{
				for(int i=0; i<60; i++)
				{
					try
					{
						String element2 = driver.findElement(By.id(propertyValue)).getAttribute("value");
						//String ProgressValue="100";
						String Value =null;
						Properties prop = new Properties();
						InputStream input = new FileInputStream("./DataFiles/LockerRentWindowDetails.properties");
						prop.load(input);
						Value = prop.getProperty("RentFromInterface");
						//System.out.println("Locker rent while submit locker rent setting through admin = "+Value);
						
						//String Rent = driver.findElement(By.id(propertyValue)).getAttribute("value");
						//System.out.println("Locker rent from locker opening window = "+Rent);
						
						//System.out.print("Progress value = "+element2);
						if (element2.equals(Value))
						{
							System.out.println("Rent value equals " + element2 + " %");
							//System.out.println("For loop if = "+propertyValue);
							Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.comment = "Pass" + " # " + "Process completed"; 		
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
							break;
						}
						else
						{
							System.out.println("Progress value not equal to 100");
						}
					}
					catch(Exception e1)
					{
						System.out.println("Something is not right");
					}
				}
			}
			catch(Exception e)
			{
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			break;
		}	
	}
	
	public static void TableVerificationAfterLockerOpening (WebDriver driver,String propertyValue, String testData) throws ClassNotFoundException, SQLException, IOException
	{
		String Value1 =null;
		Properties prop1 = new Properties();
		InputStream input1 = new FileInputStream("./DataFiles/LockerAddingDetails.properties");
		prop1.load(input1);
		Value1 = prop1.getProperty("Not_Existing_Locker_Number");
		System.out.println("Not_Existing_Locker_Number = "+Value1);
		
		String ActualRecordStatus=null;
		String ExpectedRecordStatus="3";
		String IsUsable=null;
		String IsAlloted=null;
		Connection con=(Connection) Common.DatabaseConnector();
		Statement stmt = con.createStatement();
		
		String SQL1 = "select \r\n" +
							"a.Accmasterid,a.RecordStatus ,b.acno \r\n" + 
						"from AccDetails a \r\n" + 
								"JOIN \r\n" + 
							"AccMaster b ON a.Accmasterid=b.Accmasterid \r\n" + 
						"where a.lockerno="+Value1+" and RecordStatus=3";
		
		String SQL = "select \r\n" +
						"IsUsable,IsAlloted \r\n" +
					"from LockerMaster where LockerNo="+Value1;
		
		ResultSet rs2= stmt.executeQuery(SQL1);
		int counter = 0;
		while(rs2.next()) 
		{
			  counter = counter + 1;
			  ActualRecordStatus=rs2.getString(2);
		}
		
		ResultSet rs1= stmt.executeQuery(SQL);
		int counter2 = 0;
		while(rs1.next()) 
		{
			  counter2 = counter2 + 1;
			  IsUsable=rs1.getString(1);
			  IsAlloted=rs1.getString(2);
		}
		System.out.println("Locker account's ExpectedRecordStatus = "+ActualRecordStatus);
		System.out.println("IsUsable in LockerMaster table = "+IsUsable);
		System.out.println("IsAlloted in LockerMaster table = "+IsAlloted);
		
		if (ExpectedRecordStatus.equals(ActualRecordStatus) && IsUsable.equals(0) && IsAlloted.equals(1))
		{
			System.out.println("Expected and actual recordstatus is 3 in AccDetails table");
			System.out.println("IsUsable=0 and IsAlloted=1 in LockerMaster table");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "Actual Record status is "+ActualRecordStatus + "<br>" + "Expected record status is "+ExpectedRecordStatus;
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
		
	}
	
	public static void GetAttributeAndSaveValueinTXT (WebDriver driver,String locatorType, String propertyValue, String testData) throws IOException, ClassNotFoundException, BiffException, SQLException
	{
		switch(locatorType.toLowerCase()) 
		{
			case "id":
				
				WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 1311);
				System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
				System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
				
				String value = driver.findElement(By.id(propertyValue)).getAttribute("value");
				Properties prop=new Properties();
				FileOutputStream fos = new FileOutputStream(testData);
				prop.setProperty("Locker_Account_Number", value);
				prop.store(fos, "Done");
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass" + " # " + "Locker account number = " + value; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			
			break;
			
			case "xpath":
				
				String value1 = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
				Properties prop1=new Properties();
				FileOutputStream fos1 = new FileOutputStream(testData);
				prop1.setProperty("Locker_Account_Number", value1);
				prop1.store(fos1, "Done");
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass" + " # " + "Locker account number = " + value1; 
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				
			break;
		}
	}
	
	public static void LockerAvailabilityChecking (WebDriver driver,String propertyValue, String testData) throws ClassNotFoundException, SQLException, IOException, BiffException
	{
		String LockerID=null;
		int IsAlloted;
		int IsUsableValue;
		
		WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 1267);
		System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
		System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
		String LockerProductID=driver.findElement(By.id(WriteIntoDataFiles.Property_Value)).getAttribute("value");
		System.out.println("LockerProductID="+ LockerProductID + "\n");
		
		WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 1313);
		System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
		System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
		String IsUsable=driver.findElement(By.id(WriteIntoDataFiles.Property_Value)).getAttribute("value");
		System.out.println("IsUsable="+ IsUsable + "\n");
		if (IsUsable.equalsIgnoreCase("Usable"))
		{
			IsUsableValue=1;
		}
		else
		{
			IsUsableValue=0;
		}
		System.out.println("@IsUsable="+ IsUsableValue + "\n");
		
		WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 1314);
		System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
		System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
		String UnAllotedOnly=driver.findElement(By.id(WriteIntoDataFiles.Property_Value)).getAttribute("value");
		System.out.println("IsAlloted="+ UnAllotedOnly + "\n");
		if (UnAllotedOnly.equalsIgnoreCase("on"))
		{
			IsAlloted=0;
		}
		else
		{
			IsAlloted=1;
		}
		System.out.println("@IsAlloted="+ IsAlloted + "\n");
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream(testData);
		prop.load(input);
		String LockerNumberFromTXT = prop.getProperty("Not_Existing_Locker_Number");
		System.out.println("Locker number = "+LockerNumberFromTXT);
		
		Connection con=(Connection) Common.DatabaseConnector();
		Statement stmt = con.createStatement();
		String SQL1 = "exec spQAGetLockerAvailabilityList @ProductID=N'"+LockerProductID+"',@IsUsable="+IsUsableValue+",@IsAlloted="+IsAlloted+",@LockerID="+LockerNumberFromTXT+",@Size=1,@RowIndex=1,@PageSize=10";
		ResultSet rs2= stmt.executeQuery(SQL1);
		int counter = 0;
		while(rs2.next()) 
		{
			  counter = counter + 1;	
			  LockerID=rs2.getString(7);
		}
		System.out.println("LockerNo from SP = "+LockerID);
		
		if (LockerNumberFromTXT.equals(LockerID))
		{
			System.out.println("Locker is usable and unalloted");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "Locker is usable and unalloted : " + LockerNumberFromTXT; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
		else
		{
			System.out.println("Locker is not usable and alloted");
			Driver.tcFlag = "FAIL";
			Driver.comment = "FAIL" + " # " + "Locker is not usable and alloted : "+LockerNumberFromTXT;
		    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}

	}
	
	public static void GetCustomerIDForLockerOpeningOperator (WebDriver driver,String propertyValue, String testData) throws ClassNotFoundException, SQLException, IOException
	{
		String CustomerID=null;
		Connection con=(Connection) Common.DatabaseConnector();
		Statement stmt = con.createStatement();
		String SQL1 = "Exec spQAGetCustomerIDForLockerOpening @ProductID=12001,@BranchID=102,@SecurityType=3,@Top=8";
		ResultSet rs2= stmt.executeQuery(SQL1);
		int counter = 0;
		while(rs2.next()) 
		{
			  counter = counter + 1;
			  CustomerID=rs2.getString(1);
		}
		System.out.println("CustomerID for locker opening operator= "+CustomerID);
		
		Properties prop=new Properties();
		FileOutputStream fos = new FileOutputStream(testData);
		prop.setProperty("CustomerID_For_LockerOpening_Operators", CustomerID);
		prop.store(fos, "Done");
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "Operator customer for locker opening: " + CustomerID; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}

	public static void OperatorCustReadFromTXTFileAndSendKeys (WebDriver driver,String propertyValue, String testData) throws InterruptedException, IOException, ClassNotFoundException, BiffException, SQLException
	{
		String Value =null;
		Properties prop = new Properties();
		InputStream input = new FileInputStream(testData);
		prop.load(input);
		Value = prop.getProperty("CustomerID_For_LockerOpening_Operators");
		System.out.println("CustomerID_For_LockerOpening_Operators = "+Value);
		
		driver.findElement(By.xpath(propertyValue)).sendKeys(Value);
		
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass" + " # " + "Customer id for locker opening= " + Value; 
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
	
	public static void LockerNoReadAndWrite (WebDriver driver,String propertyValue, String testData) throws InterruptedException, IOException
	{
			Properties prop = new Properties();
			InputStream input = new FileInputStream(testData);
			prop.load(input);
			String LockerNo = prop.getProperty("Not_Existing_Locker_Number");
			//Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(LockerNumber);
			System.out.println("Locker number = "+LockerNo);
			
			driver.findElement(By.id(propertyValue)).sendKeys(LockerNo);
			System.out.println("Locker number = "+propertyValue);
			
			Driver.tcFlag = "PASS";
			//Driver.comment = "Pass";
			Driver.comment = "Pass" + " # " + "Locker Number readed from file= " + LockerNo; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);

	}

	public static void LockerAttendanceTblVerification (WebDriver driver,String propertyValue, String testData) throws ClassNotFoundException, SQLException, IOException, BiffException
	{
		Common.ReadFromDataFileCommon(driver,"./DataFiles/LockerAddingDetails.properties","Not_Existing_Locker_Number");
		//System.out.println("Object_Name from object repository file=" + Common.DatafileValue + "\t");
		
		String LockerAttendance=null;
		Connection con=(Connection) Common.DatabaseConnector();
		Statement stmt = con.createStatement();
		String SQL1 = "declare @LockerNo varchar(20)="+ Common.DatafileValue +"\r\n" + 
					  "select * from LockerAttendance where lockerno=@LockerNo";
		ResultSet rs2= stmt.executeQuery(SQL1);
		int counter = 0;
		while(rs2.next()) 
		{
			  counter = counter + 1;
			  LockerAttendance=rs2.getString(5);
		}
		System.out.println("LockerNo = "+LockerAttendance);
		
		if (Common.DatafileValue.equals(LockerAttendance))
		{
			System.out.println("LockerNo: "+Common.DatafileValue+" entry showing in LockerAttendance table");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "LockerNo: "+Common.DatafileValue+" entry showing in LockerAttendance table"; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
		else
		{
			System.out.println("LockerNo: "+Common.DatafileValue+" entry not showing in LockerAttendance table");
			Driver.tcFlag = "FAIL";
			Driver.comment = "FAIL" + " # " + "LockerNo: "+Common.DatafileValue+" entry not showing in LockerAttendance table"; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
		
	}
	
	public static void LockerVisitedMembersTblVerification (WebDriver driver,String propertyValue, String testData) throws ClassNotFoundException, SQLException, IOException, BiffException
	{
		Common.ReadFromDataFileCommon(driver,"./DataFiles/LockerAddingDetails.properties","Not_Existing_Locker_Number");
		//System.out.println("Object_Name from object repository file=" + Common.DatafileValue + "\t");
		
		String LockerAttendance=null;
		Connection con=(Connection) Common.DatabaseConnector();
		Statement stmt = con.createStatement();
		String SQL1 = "declare @LockerNo varchar(20)="+ Common.DatafileValue +",@VisitID bigint \r\n" +
						"select @VisitID=VisitID from LockerAttendance where lockerno=@LockerNo \r\n" +
						"select * from LockerVisitedMembers where VisitID=@VisitID";
		ResultSet rs2= stmt.executeQuery(SQL1);
		int counter = 0;
		while(rs2.next()) 
		{
			  counter = counter + 1;
			  LockerAttendance=rs2.getString(2);
		}
		System.out.println("CustID = "+LockerAttendance);
		
		if (LockerAttendance.isEmpty())
		{
			System.out.println("LockerNo: "+Common.DatafileValue+" entry not showing in LockerVisitedMembers table");
			Driver.tcFlag = "FAIL";
			Driver.comment = "FAIL" + " # " + "LockerNo: "+Common.DatafileValue+" entry not showing in LockerAttendance table"; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
		else
		{
			System.out.println("LockerNo: "+Common.DatafileValue+" entry showing in LockerVisitedMembers table");
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "LockerNo: "+Common.DatafileValue+" entry showing in LockerAttendance table"; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
		
	}
}
