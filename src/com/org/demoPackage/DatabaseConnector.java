package com.org.demoPackage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {
	
	public static void dateChanger() throws SQLException, ClassNotFoundException 
	{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	        String UserName = "sqa";
	        String Password = "SPQA@sql2019" ;
	        String Url = "jdbc:sqlserver://192.168.32.32\\QA;DatabaseName=Beaconpro_Automation";
	       
	       // Loading the required JDBC Driver class
	       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	       Connection con = DriverManager.getConnection(Url,UserName,Password);
	      
	       
	       
	       CallableStatement stmt=con.prepareCall("{call QASpChangeMonthDate }");
	       stmt.execute();
	     
	    		   
	       Driver.tcFlag = "PASS";
			Driver.comment = "Pass";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	       
	       //String sqlquery =("exec QASpChangeMonthDate");
	       
	       //System.out.println("querie "+sqlquery);
	       
	      // ResultSet rs2 =  ((Statement) con).executeQuery(sqlquery);
	      
	      /*  while (rs2.next()) 
	        
	        {
	       
	         TransacitonDate[0] = rs2.getString("Transdate");
	         
	         System.out.println("Date "+TransacitonDate[0]);
	         
	        
	        }
	              
	 }*/
	}

	public static void GetCurrentTransactionDate() throws SQLException, ClassNotFoundException 
		{
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			//String UserName = "sa";
			//String Password = "sql@2016" ;
			//String Url = "jdbc:sqlserver://192.168.31.27:1433;DatabaseName=Beaconpro_Automation";
			String TransDate=null;
       
			// Loading the required JDBC Driver class
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//Connection con = DriverManager.getConnection(Url,UserName,Password);
       
			//CallableStatement stmt=con.prepareCall("{call select convert(varchar(200),CurrentTransDate, 106) as TransDate from TransactionDate }");
			//stmt.execute();
			
			Connection con=(Connection) Common.DatabaseConnector();
			
			Statement stmt = con.createStatement();	
			String Q_datefetch="select convert(varchar(200),CurrentTransDate, 106) as TransDate from TransactionDate"; 
			ResultSet rs1= stmt.executeQuery(Q_datefetch);
			int counter = 0;
			
			while(rs1.next()) 
			{
				counter = counter + 1;
				TransDate=rs1.getString(1);
			}
			
			System.out.println("Transaction date: "+TransDate);
    		   
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}

}

