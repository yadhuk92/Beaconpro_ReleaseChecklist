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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Write_RD_Autopost_Details {

	public static WebElement element;
	public static String Actual_Value;
	
	private static String ShareOpening_TransactionDate;
	private static String ShareOpening_ValueDate;
	private static String RD_ProductName;
	private static String RD_AccountNumber;
	private static String RD_DisplayName;
	private static int RD_BatchId;
	private static int RD_TransId;
	private static int RD_VoucherNumber;
	private static String RD_TranType;
	private static String RD_AmountType;
	private static String RD_TransAmount;
	private static int RD_GlAcCode;
	private static String RD_TransferMode;
	private static int RD_OrgId;
	private static String SB_ProductName;
	private static String SB_AccountNumber;
	private static String SB_AccountDisplayName;
	private static int SB_TransId;
	private static int SB_BatchId;
	private static int SB_VoucherNo;
	private static String SB_TransType;
	private static String SB_TrnAmount;
	private static String SB_AmountType;
	private static int SB_GlAcCode;
	private static String SB_TrnMode;
	private static int SB_OrgId;

	public static void RD_Autopost_Details(WebDriver driver, String propertyValue) {
		
		
try {
			
			//System.out.println("inside write method");
			element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					
					System.out.println("Trans ID "+TransID);

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
			        
			       // System.out.println(ShareOpening_TransactionDate +"   "+ ShareOpening_ValueDate);
			        
					String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
					ResultSet rs= stmt.executeQuery(Data);
					
					//System.out.println("SP executed");
					
					int row=rs.getRow();
					ArrayList ar=new ArrayList<>();
					
					 //System.out.println("created arraylist");
					 ResultSetMetaData rsmd;
					 
					 try {
				            rsmd = rs.getMetaData();

				            int NumOfCol = rsmd.getColumnCount();
				            
				          

				            while (rs.next()) {
				             

				                for (int i = 1; i <= NumOfCol; i++) {
				                   
				                	ar.add(rs.getString(i));
				                	
				                }

				                row++;
				            }
				            
				            
				        } catch (SQLException e) {
				            throw e;
				        }
					// System.out.println("added to arraylist");
					// System.out.println("Readingfro arraylist to variables");
					      
					 	RD_ProductName=(String) ar.get(0);
				      	
				      	RD_AccountNumber=(String) ar.get(1);
					
				      	RD_DisplayName=(String) ar.get(2);
						
				      	RD_BatchId=Integer.parseInt((String) ar.get(3));
						
				      	RD_TransId=Integer.parseInt((String) ar.get(4));
						
				      	RD_VoucherNumber=Integer.parseInt((String) ar.get(5));
						
				      	RD_TranType=(String) ar.get(6);
						
				      	RD_TransAmount=(String) ar.get(7);
					
				      	RD_AmountType=(String) ar.get(8);
					
				      	RD_GlAcCode=Integer.parseInt((String) ar.get(9));
						
				      	RD_TransferMode=(String) ar.get(10);
						
				      	RD_OrgId=Integer.parseInt((String) ar.get(11));
					
				      	
						SB_ProductName=(String) ar.get(12);
						
						SB_AccountNumber=(String) ar.get(13);
						
						SB_AccountDisplayName=(String) ar.get(14);
						
						SB_BatchId=Integer.parseInt((String) ar.get(15));
						
						SB_TransId=Integer.parseInt((String) ar.get(16));
						
						SB_VoucherNo=Integer.parseInt((String) ar.get(17));
						
						SB_TransType=(String) ar.get(18);
						
						SB_TrnAmount=(String) ar.get(19);
						
						SB_AmountType=(String) ar.get(20);
						
						SB_GlAcCode=Integer.parseInt((String) ar.get(21));
						
						SB_TrnMode=(String) ar.get(22);
						
						SB_OrgId=Integer.parseInt((String) ar.get(23));
					
						Properties prop=new Properties();
						
						FileOutputStream fos = new FileOutputStream("./DataFiles/RD_AUTOPOST_Details.properties");
						
						prop.setProperty("ProductName",RD_ProductName);
						prop.setProperty("AccountNumber", RD_AccountNumber);
						prop.setProperty("DisplayName",RD_DisplayName);
						prop.setProperty("BatchId",String.valueOf(RD_BatchId));
						prop.setProperty("TransId", String.valueOf(RD_TransId));
						prop.setProperty("VoucherNumber",String.valueOf(RD_VoucherNumber));
						prop.setProperty("TranType", RD_TranType);	
						prop.setProperty("TransAmount",RD_TransAmount);
						prop.setProperty("AmountType",RD_AmountType);
						prop.setProperty("GlAcCode",String.valueOf (RD_GlAcCode));	
						prop.setProperty("TransferMode", RD_TransferMode);
						prop.setProperty("OrgId",String.valueOf (RD_OrgId));
						
						prop.setProperty("SB_ProductName", SB_ProductName);
						prop.setProperty("SB_AccountNumber", SB_AccountNumber);
						prop.setProperty("SB_AccountDisplayName", SB_AccountDisplayName);
						prop.setProperty("SB_BatchId", String.valueOf (SB_BatchId));
						prop.setProperty("SB_TransId",String.valueOf ( SB_TransId));
						prop.setProperty("SB_VoucherNo",String.valueOf ( SB_VoucherNo));
						prop.setProperty("SB_TransType", SB_TransType);
						prop.setProperty("SB_TrnAmount", SB_TrnAmount);
						prop.setProperty("SB_AmountType", SB_AmountType);
						prop.setProperty("SB_GlAcCode", String.valueOf (SB_GlAcCode));
						prop.setProperty("SB_TrnMode", SB_TrnMode);
						prop.setProperty("SB_OrgId",String.valueOf ( SB_OrgId));
					
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
