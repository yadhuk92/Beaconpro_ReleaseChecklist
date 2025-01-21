package com.org.demoPackage;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Write_RID_BATCH {

	private static String ShareOpening_TransactionDate;
	private static String ShareOpening_ValueDate;
	private static String TransID;
	private static String RID_ProductName;
	private static String RID_AccountNumber;
	private static String RID_DisplayName;
	private static int RID_BatchId;
	private static int RID_TransId;
	private static int RID_VoucherNumber;
	private static String RID_TranType;
	private static String RID_TransAmount;
	private static String RID_AmountType;
	private static int RID_GlAcCode;
	private static String RID_TransferMode;
	private static int RID_OrgId;
	public static void WriteRID_Batch_Details(WebDriver driver, String propertyValue) {
		
		
		try {
		String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
		
		System.out.println("TransID"+TransID);
		
		Connection con=(Connection) Common.DatabaseConnector();
		if(con !=null) {
       
        Statement stmt = con.createStatement();	
        
        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
        ResultSet rs1= stmt.executeQuery(Q_datefetch);
        //System.out.println("fetched dates");
        while(rs1.next()) {
        	
        	ShareOpening_TransactionDate=rs1.getString(1);
        	ShareOpening_ValueDate=rs1.getString(2);
        }
        
        
        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
		
        ResultSet rs= stmt.executeQuery(Data);
		
		while(rs.next()) {
		      
			RID_ProductName=rs.getString(1);
	      	
		    RID_AccountNumber=rs.getString(2);
		
		    RID_DisplayName=rs.getString(3);
			
		    RID_BatchId=Integer.parseInt(rs.getString(4));
			
		    RID_TransId=Integer.parseInt(rs.getString(5));
			
		    RID_VoucherNumber=Integer.parseInt(rs.getString(6));
			
		    RID_TranType=rs.getString(7);
			
		    RID_TransAmount=rs.getString(8);
		
		    RID_AmountType=rs.getString(9);
		
		    RID_GlAcCode=Integer.parseInt(rs.getString(10));
			
		    RID_TransferMode=rs.getString(11);
			
		    RID_OrgId=Integer.parseInt(rs.getString(12));
	      	
				}
	      	
	      	Properties prop=new Properties();
			
			FileOutputStream fos = new FileOutputStream("./DataFiles/RID_BATCH_Details.properties");
			
			prop.setProperty("ProductName",RID_ProductName);
			prop.setProperty("AccountNumber", RID_AccountNumber);
			prop.setProperty("DisplayName",RID_DisplayName);
			prop.setProperty("BatchId",String.valueOf(RID_BatchId));
			prop.setProperty("TransId", String.valueOf(RID_TransId));
			prop.setProperty("VoucherNumber",String.valueOf(RID_VoucherNumber));
			prop.setProperty("TranType", RID_TranType);	
			prop.setProperty("TransAmount",RID_TransAmount);
			prop.setProperty("AmountType",RID_AmountType);
			prop.setProperty("GlAcCode",String.valueOf (RID_GlAcCode));	
			prop.setProperty("TransferMode", RID_TransferMode);
			prop.setProperty("OrgId",String.valueOf (RID_OrgId));
			
			prop.setProperty("TransactionDate", ShareOpening_TransactionDate.substring(0, 10));
			prop.setProperty("ValueDate", ShareOpening_ValueDate.substring(0, 10));
		
			System.out.println("Written share details cash mode");
			prop.store(fos, "Done");
			fos.close();
		}	
	}catch(Exception e){
		Driver.tcFlag = "FAIL";
		Driver.comment = Driver.objectName + " is not displayed or not identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		e.printStackTrace();
	}
		
}
}
	
	
	

