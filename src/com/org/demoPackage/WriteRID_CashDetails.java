package com.org.demoPackage;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WriteRID_CashDetails {
	
	public static WebElement element;
	public static String Actual_Value;
	private static String FDAc_AccountNumber;
	private static int FDAc_TransId;
	private static int FDAc_VoucherNumber;

	
	private static String ShareOpening_TransactionDate;
	private static String ShareOpening_ValueDate;
	private static int NoOfRows;
	private static int TransID;

	//public static void writeAccountOpeningRIDDetails_CashMode(WebDriver driver, String propertyValue) {
	
	public static void main(String args[]) {
		
		
		try {
			NoOfRows=10;
			TransID= 3613912;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			        String UserName = "sa";
			        String Password = "Speridian1" ;
			        String Url = "jdbc:sqlserver://192.168.1.87:1433;DatabaseName=BeaconProQC";
			       
			        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			        Connection con = DriverManager.getConnection(Url,UserName,Password);
			       
			        Statement stmt = con.createStatement();	
			  
					String Data="select AcNo,TransID,VoucherNo from QaFnGetSummaryDetails ("+TransID+")";
					ResultSet rs= stmt.executeQuery(Data);
					
					while(rs.next()) {
						
						FDAc_AccountNumber=rs.getString(1);
                    	  
  				       	FDAc_TransId=Integer.parseInt(rs.getString(2));
  							
  				       	FDAc_VoucherNumber=Integer.parseInt(rs.getString(3));
							}
			
					BigInteger Acnumber = new BigInteger(FDAc_AccountNumber);
			
					Properties prop=new Properties();
					
					FileOutputStream fos = new FileOutputStream("./DataFiles/RIDAccountOpening_CashMode.properties");
					
					
					for(int i=1;i<=NoOfRows;i++) {
						
					System.out.println(	prop.setProperty("AccountNumber"+i,String.valueOf(Acnumber )));
						
						BigInteger bi1 = new BigInteger("1");
						
						BigInteger	AcNoresult = new BigInteger("50");
						
						AcNoresult=Acnumber.add(bi1);
						
						Acnumber=AcNoresult;
						
						System.out.println(prop.setProperty("TransID"+i,String.valueOf(FDAc_TransId )));
						FDAc_TransId++;
						
						System.out.println(	prop.setProperty("VoucherNo"+i,String.valueOf(FDAc_VoucherNumber )));
						FDAc_VoucherNumber++;
						}
						System.out.println("Written  details cash mode\n");
						prop.store(fos, "Done");
						fos.close();
                        
			        
	
		}catch(Exception e){
			Driver.tcFlag = "FAIL";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
		
	}
}

	
	


