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

public class WriteSBDetails_TransferMode {
	
	public static WebElement element;
	public static String Actual_Value;
	public static String DDProductName;
	public static String DDAccountNumber;
	public static String DDAccDisplayName;
	public static int DDBatchId;
	public static int DDTransId;
	public static int DDVoucherNumber;
	public static String DDTranType;
	public static String DDTransAmount;
	public static String DDAmountType;
	public static int DDGlAcCode;
	public static String DDTransferMode;
	public static int DDOrgId;
	
	public static int SBBatchId;
	public static int SBTransId;
	public static String SBProductName;
	public static String SBAccountDisplayName;
	public static int SBVoucherNo;
	public static String SBTransType;
	public static String SBTrnAmount;
	public static String SBAmountType;
	public static int SBGlAcCode;
	public static String SbTrnMode;
	public static int SbOrgId;
	public static String SBAccountNumber;
	
	private static String ShareOpening_TransactionDate;
	private static String ShareOpening_ValueDate;
	
	public static WebDriver WriteSBOpeningDetails_TransferMode( WebDriver driver, String propertyValue) {
		
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
			        
			      
			        
   String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";

              //String Data="select * from QaFnGetSummaryDetails ("+TransID+")";
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
					      
					      	DDProductName=(String) ar.get(0);
					      	
					      	DDAccountNumber=(String) ar.get(1);
						
					      	DDAccDisplayName=(String) ar.get(2);
							
					      	DDBatchId=Integer.parseInt((String) ar.get(3));
							
					      	DDTransId=Integer.parseInt((String) ar.get(4));
							
					      	DDVoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	DDTranType=(String) ar.get(6);
							
					      	DDTransAmount=(String) ar.get(7);
						
					      	DDAmountType=(String) ar.get(8);
						
					      	DDGlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	DDTransferMode=(String) ar.get(10);
							
					      	DDOrgId=Integer.parseInt((String) ar.get(11));
						
							SBProductName=(String) ar.get(12);
							
							SBAccountNumber=(String) ar.get(13);
							
							SBAccountDisplayName=(String) ar.get(14);
							
							SBBatchId=Integer.parseInt((String) ar.get(15));
							
							SBTransId=Integer.parseInt((String) ar.get(16));
							
							SBVoucherNo=Integer.parseInt((String) ar.get(17));
							
							SBTransType=(String) ar.get(18);
							
							SBTrnAmount=(String) ar.get(19);
							
							SBAmountType=(String) ar.get(20);
							
							SBGlAcCode=Integer.parseInt((String) ar.get(21));
							
							SbTrnMode=(String) ar.get(22);
							
							SbOrgId=Integer.parseInt((String) ar.get(23));
					      
					
				
							// System.out.println("Creating property file");
							Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/SBOpeningDetails_TRANSFER.properties");
							
							prop.setProperty("SB_productName",DDProductName);
							prop.setProperty("SB_AccountNumber", DDAccountNumber);
							prop.setProperty("SB_AccountDisplayName",DDAccDisplayName);
							prop.setProperty("SB_BatchId",String.valueOf(DDBatchId));
							prop.setProperty("SB_TransId", String.valueOf(DDTransId));
							prop.setProperty("SB_VoucherId",String.valueOf(DDVoucherNumber));
							prop.setProperty("SB_TransactionType", DDTranType);	
							prop.setProperty("SB_Amount",DDTransAmount);
							prop.setProperty("SB_AmountType",DDAmountType);
							prop.setProperty("SB_GLAccCode",String.valueOf (DDGlAcCode));	
							prop.setProperty("SB_TransferMode", DDTransferMode);
							prop.setProperty("SB_OrgID",String.valueOf (DDOrgId));
							
							prop.setProperty("DD_ProductName", SBProductName);
							prop.setProperty("DD_AccountNumber", SBAccountNumber);
							prop.setProperty("DD_AccountDispalyName", SBAccountDisplayName);
							prop.setProperty("DD_BatchId", String.valueOf (SBBatchId));
							prop.setProperty("DD_TransactionId",String.valueOf ( SBTransId));
							prop.setProperty("DD_VoucherNumber",String.valueOf ( SBVoucherNo));
							prop.setProperty("DD_TransType", SBTransType);
							prop.setProperty("DD_TransAmount", SBTrnAmount);
							prop.setProperty("DD_AmountType", SBAmountType);
							prop.setProperty("DD_GLAcCode", String.valueOf (SBGlAcCode));
							prop.setProperty("DD_TransactionMode", SbTrnMode);
							prop.setProperty("DD_OrgID",String.valueOf ( SbOrgId));
							prop.setProperty("TransactionDate", ShareOpening_TransactionDate.substring(0, 10));
							prop.setProperty("ValueDate", ShareOpening_ValueDate.substring(0, 10));
							//prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
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
	return driver;

		}

}
