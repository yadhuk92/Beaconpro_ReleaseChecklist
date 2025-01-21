package com.org.demoPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectionTest 
{
	public void dbConnect(String db_connect_string,String db_userid,String db_password) throws SQLException
	   {
	      try 
	      {
	    	 db_connect_string = "jdbc:sqlserver://192.168.32.9:1433;DatabaseName=Bpro_Automation;encrypt=true;trustServerCertificate=true";
	    	 db_userid = "qa";
	    	 db_password = "sql@2016" ;
	    	 
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         Connection conn = DriverManager.getConnection(db_connect_string,db_userid, db_password);
	         System.out.println("connected");
	         Statement statement = conn.createStatement();
	         String queryString = "select count(*) as NumberOfTables from sysobjects where type='u'";
	         ResultSet rs = statement.executeQuery(queryString);
	         while (rs.next()) {
	            System.out.println(rs.getString(1));
	         }
	      } catch (Exception e) 
	      {
	         e.printStackTrace();
	      }
	   }

	   public static void main(String[] args) throws SQLException
	   {
		   JDBCConnectionTest connServer = new JDBCConnectionTest();
	       connServer.dbConnect("jdbc:sqlserver://<hostname>", "<user>","<password>");
	   }
}
