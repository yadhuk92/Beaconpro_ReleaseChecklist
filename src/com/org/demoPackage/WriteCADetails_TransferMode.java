package com.org.demoPackage;

import java.io.FileOutputStream;
import java.sql.Connection;
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

public class WriteCADetails_TransferMode {
	private static String ShareOpening_TransactionDate;
	private static String ShareOpening_ValueDate;
	
	private static String CA_ProductName;
	private static String CA_AccountNumber;
	private static String CA_AccDisplayName;
	private static int CA_BatchId;
	private static int CA_TransId;
	private static int CA_VoucherNumber;
	private static String CA_TranType;
	private static String CA_TransAmount;
	private static String CA_AmountType;
	private static int CA_GlAcCode;
	private static String CA_TransferMode;
	private static int CA_OrgId;
	private static String SB_ProductName;
	private static String SB_AccountNumber;
	private static String SB_AccountDisplayName;
	private static int SB_BatchId;
	private static int SB_TransId;
	private static int SB_VoucherNo;
	private static String SB_TransType;
	private static String SB_TrnAmount;
	private static String SB_AmountType;
	private static int SB_GlAcCode;
	private static String Sb_TrnMode;
	private static int Sb_OrgId;
	private static WebElement element;

	public static void writeCADetails_transferMode(WebDriver driver, String propertyValue) {
		
		
try {
			
			System.out.println("inside write method");
			element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
		    
		           Statement stmt = con.createStatement();
			        
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("fetched dates");
			        while(rs1.next()) {
			        	
			        	ShareOpening_TransactionDate=rs1.getString(1);
			        	ShareOpening_ValueDate=rs1.getString(2);
			        }
			        
			       System.out.println(ShareOpening_TransactionDate +"   "+ ShareOpening_ValueDate);
			 String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";

					//String Data="select * from QaFnGetSummaryDetails ("+TransID+")";
					ResultSet rs= stmt.executeQuery(Data);
					
					System.out.println("SP executed");
					
					int row=rs.getRow();
					ArrayList ar=new ArrayList<>();
					
					 System.out.println("created arraylist");
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
					System.out.println("added to arraylist");
					System.out.println("Readingfro arraylist to variables");
					      
					      	CA_ProductName=(String) ar.get(0);
					      	
					      	CA_AccountNumber=(String) ar.get(1);
						
					      	CA_AccDisplayName=(String) ar.get(2);
							
					      	CA_BatchId=Integer.parseInt((String) ar.get(3));
							
					      	CA_TransId=Integer.parseInt((String) ar.get(4));
							
					      	CA_VoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	CA_TranType=(String) ar.get(6);
							
					      	CA_TransAmount=(String) ar.get(7);
						
					      	CA_AmountType=(String) ar.get(8);
						
					      	CA_GlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	CA_TransferMode=(String) ar.get(10);
							
					      	CA_OrgId=Integer.parseInt((String) ar.get(11));
					      	
					      	
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
							
					      	Sb_TrnMode=(String) ar.get(22);
							
					      	Sb_OrgId=Integer.parseInt((String) ar.get(23));
					      	
						
							
					      
					
				
							// System.out.println("Creating property file");
							Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/CAOpeningDetails_TRANSFER.properties");
							
							prop.setProperty("CA_productName",CA_ProductName);
							prop.setProperty("CA_AccountNumber", CA_AccountNumber);
							prop.setProperty("CA_AccountDisplayName",CA_AccDisplayName);
							prop.setProperty("CA_BatchId",String.valueOf(CA_BatchId));
							prop.setProperty("CA_TransId", String.valueOf(CA_TransId));
							prop.setProperty("CA_VoucherId",String.valueOf(CA_VoucherNumber));
							prop.setProperty("CA_TransactionType", CA_TranType);	
							prop.setProperty("CA_Amount",CA_TransAmount);
							prop.setProperty("CA_AmountType",CA_AmountType);
							prop.setProperty("CA_GLAccCode",String.valueOf (CA_GlAcCode));	
							prop.setProperty("CA_TransferMode", CA_TransferMode);
							prop.setProperty("CA_OrgID",String.valueOf (CA_OrgId));
							
							prop.setProperty("SB_ProductName", SB_ProductName);
							prop.setProperty("SB_AccountNumber", SB_AccountNumber);
							prop.setProperty("SB_AccountDispalyName", SB_AccountDisplayName);
							prop.setProperty("SB_BatchId", String.valueOf (SB_BatchId));
							prop.setProperty("SB_TransactionId",String.valueOf ( SB_TransId));
							prop.setProperty("SB_VoucherNumber",String.valueOf ( SB_VoucherNo));
							prop.setProperty("SB_TransType", SB_TransType);
							prop.setProperty("SB_TransAmount", SB_TrnAmount);
							prop.setProperty("SB_AmountType", SB_AmountType);
							prop.setProperty("SB_GLAcCode", String.valueOf (SB_GlAcCode));
							prop.setProperty("SB_TransactionMode", Sb_TrnMode);
							prop.setProperty("SB_OrgID",String.valueOf ( Sb_OrgId));
							
							prop.setProperty("CA_TransactionDate", ShareOpening_TransactionDate.substring(0, 10));
							prop.setProperty("CA_ValueDate", ShareOpening_ValueDate.substring(0, 10));
							
							
							System.out.println("Written share details transfer mode");
							prop.store(fos, "Done");
							fos.close();
							
							Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
					}
		}catch(Exception e){
			Driver.tcFlag = "FAIL";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
		
	}
	

}
