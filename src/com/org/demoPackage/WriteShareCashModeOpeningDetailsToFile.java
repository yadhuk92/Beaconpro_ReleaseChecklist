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

public class WriteShareCashModeOpeningDetailsToFile {
	
	public static WebElement element;
	public static String Actual_Value;
	private static String ShareAc_ProductName;
	private static String ShareAc_AccountNumber;
	private static String ShareAc_DisplayName;
	private static int ShareAc_BatchId;
	private static int ShareAc_TransId;
	private static int ShareAc_VoucherNumber;
	private static String ShareAc_TranType;
	private static String ShareAc_TransAmount;
	private static String ShareAc_AmountType;
	private static int ShareAc_GlAcCode;
	private static String ShareAc_TransferMode;
	private static int ShareAc_OrgId;
	private static String EF_ProductName;
	private static String EF_AccountNumber;
	private static String EF_AccountDisplayName;
	private static int EF_BatchId;
	private static int EF_TransId;
	private static int EF_VoucherNo;
	private static String EF_TransType;
	private static String EF_TrnAmount;
	private static String EF_AmountType;
	private static int EF_GlAcCode;
	private static String EF_TrnMode;
	private static int EF_OrgId;
	private static String ST_ProductName;
	private static String ST_AccountNumber;
	private static String ST_AccountDisplayName;
	private static int ST_BatchId;
	private static int ST_TransId;
	private static int ST_VoucherNo;
	private static String ST_TransType;
	private static String ST_TrnAmount;
	private static String ST_AmountType;
	private static int ST_GlAcCode;
	private static String ST_TrnMode;
	private static int ST_OrgId;
	private static String PF_ProductName;
	private static String PF_AccountNumber;
	private static String PF_AccountDisplayName;
	private static int PF_BatchId;
	private static int PF_TransId;
	private static int PF_VoucherNo;
	private static String PF_TransType;
	private static String PF_TrnAmount;
	private static String PF_AmountType;
	private static int PF_GlAcCode;
	private static String PF_TrnMode;
	private static int PF_OrgId;
	private static String CGST_ProductName;
	private static String CGST_AccountNumber;
	private static String CGST_AccountDisplayName;
	private static int CGST_BatchId;
	private static int CGST_TransId;
	private static int CGST_VoucherNo;
	private static String CGST_TransType;
	private static String CGST_TrnAmount;
	private static String CGST_AmountType;
	private static int CGST_GlAcCode;
	private static String CGST_TrnMode;
	private static int CGST_OrgId;
	private static String ShareOpening_TransactionDate;
	private static String ShareOpening_ValueDate;
	
	
	
	
	
	public static WebDriver writeShareOpeningDetails_CashMode( WebDriver driver, String propertyValue) {
		
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
					      
					      	ShareAc_ProductName=(String) ar.get(0);
					      	
					      	ShareAc_AccountNumber=(String) ar.get(1);
						
					      	ShareAc_DisplayName=(String) ar.get(2);
							
					      	ShareAc_BatchId=Integer.parseInt((String) ar.get(3));
							
					      	ShareAc_TransId=Integer.parseInt((String) ar.get(4));
							
					      	ShareAc_VoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	ShareAc_TranType=(String) ar.get(6);
							
					      	ShareAc_TransAmount=(String) ar.get(7);
						
					      	ShareAc_AmountType=(String) ar.get(8);
						
					      	ShareAc_GlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	ShareAc_TransferMode=(String) ar.get(10);
							
					      	ShareAc_OrgId=Integer.parseInt((String) ar.get(11));
						
					      	
							EF_ProductName=(String) ar.get(12);
							
							EF_AccountNumber=(String) ar.get(13);
							
							EF_AccountDisplayName=(String) ar.get(14);
							
							EF_BatchId=Integer.parseInt((String) ar.get(15));
							
							EF_TransId=Integer.parseInt((String) ar.get(16));
							
							EF_VoucherNo=Integer.parseInt((String) ar.get(17));
							
							EF_TransType=(String) ar.get(18);
							
							EF_TrnAmount=(String) ar.get(19);
							
							EF_AmountType=(String) ar.get(20);
							
							EF_GlAcCode=Integer.parseInt((String) ar.get(21));
							
							EF_TrnMode=(String) ar.get(22);
							
							EF_OrgId=Integer.parseInt((String) ar.get(23));
							
							
							ST_ProductName=(String) ar.get(24);
							
							ST_AccountNumber=(String) ar.get(25);
							
							ST_AccountDisplayName=(String) ar.get(26);
							
							ST_BatchId=Integer.parseInt((String) ar.get(27));
							
							ST_TransId=Integer.parseInt((String) ar.get(28));
							
							ST_VoucherNo=Integer.parseInt((String) ar.get(29));
							
							ST_TransType=(String) ar.get(30);
							
							ST_TrnAmount=(String) ar.get(31);
							
							ST_AmountType=(String) ar.get(32);
							
							ST_GlAcCode=Integer.parseInt((String) ar.get(33));
							
							ST_TrnMode=(String) ar.get(34);
							
							ST_OrgId=Integer.parseInt((String) ar.get(3));
							
					      

							PF_ProductName=(String) ar.get(36);
							
							PF_AccountNumber=(String) ar.get(37);
							
							PF_AccountDisplayName=(String) ar.get(38);
							
							PF_BatchId=Integer.parseInt((String) ar.get(39));
							
							PF_TransId=Integer.parseInt((String) ar.get(40));
							
							PF_VoucherNo=Integer.parseInt((String) ar.get(41));
							
							PF_TransType=(String) ar.get(42);
							
							PF_TrnAmount=(String) ar.get(43);
							
							PF_AmountType=(String) ar.get(44);
							
							PF_GlAcCode=Integer.parseInt((String) ar.get(45));
							
							PF_TrnMode=(String) ar.get(46);
							
							PF_OrgId=Integer.parseInt((String) ar.get(47));
							
					      
							CGST_ProductName=(String) ar.get(48);
							
							CGST_AccountNumber=(String) ar.get(49);
							
							CGST_AccountDisplayName=(String) ar.get(50);
							
							CGST_BatchId=Integer.parseInt((String) ar.get(51));
							
							CGST_TransId=Integer.parseInt((String) ar.get(52));
							
							CGST_VoucherNo=Integer.parseInt((String) ar.get(53));
							
							CGST_TransType=(String) ar.get(54);
							
							CGST_TrnAmount=(String) ar.get(55);
							
							CGST_AmountType=(String) ar.get(56);
							
							CGST_GlAcCode=Integer.parseInt((String) ar.get(57));
							
							CGST_TrnMode=(String) ar.get(58);
							
							CGST_OrgId=Integer.parseInt((String) ar.get(59));
				
							// System.out.println("Creating property file");
							Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/ShareOpening_CashMode_Details.properties");
							
							prop.setProperty("ShareAc_ProductName",ShareAc_ProductName);
							prop.setProperty("ShareAc_AccountNumber", ShareAc_AccountNumber);
							prop.setProperty("ShareAc_DisplayName",ShareAc_DisplayName);
							prop.setProperty("ShareAc_BatchId",String.valueOf(ShareAc_BatchId));
							prop.setProperty("ShareAc_TransId", String.valueOf(ShareAc_TransId));
							prop.setProperty("ShareAc_VoucherNumber",String.valueOf(ShareAc_VoucherNumber));
							prop.setProperty("ShareAc_TranType", ShareAc_TranType);	
							prop.setProperty("ShareAc_TransAmount",ShareAc_TransAmount);
							prop.setProperty("ShareAc_AmountType",ShareAc_AmountType);
							prop.setProperty("ShareAc_GlAcCode",String.valueOf (ShareAc_GlAcCode));	
							prop.setProperty("ShareAc_TransferMode", ShareAc_TransferMode);
							prop.setProperty("ShareAc_OrgId",String.valueOf (ShareAc_OrgId));
							
							prop.setProperty("EF_ProductName", EF_ProductName);
							prop.setProperty("EF_AccountNumber", EF_AccountNumber);
							prop.setProperty("EF_AccountDisplayName", EF_AccountDisplayName);
							prop.setProperty("EF_BatchId", String.valueOf (EF_BatchId));
							prop.setProperty("EF_TransId",String.valueOf ( EF_TransId));
							prop.setProperty("EF_VoucherNo",String.valueOf ( EF_VoucherNo));
							prop.setProperty("EF_TransType", EF_TransType);
							prop.setProperty("EF_TrnAmount", EF_TrnAmount);
							prop.setProperty("EF_AmountType", EF_AmountType);
							prop.setProperty("EF_GlAcCode", String.valueOf (EF_GlAcCode));
							prop.setProperty("EF_TrnMode", EF_TrnMode);
							prop.setProperty("EF_OrgId",String.valueOf ( EF_OrgId));
							
							prop.setProperty("ST_ProductName", ST_ProductName);
							prop.setProperty("ST_AccountNumber", ST_AccountNumber);
							prop.setProperty("ST_AccountDisplayName", ST_AccountDisplayName);
							prop.setProperty("ST_BatchId", String.valueOf (ST_BatchId));
							prop.setProperty("ST_TransId",String.valueOf ( ST_TransId));
							prop.setProperty("ST_VoucherNo",String.valueOf ( ST_VoucherNo));
							prop.setProperty("ST_TransType", ST_TransType);
							prop.setProperty("ST_TrnAmount", ST_TrnAmount);
							prop.setProperty("ST_AmountType", ST_AmountType);
							prop.setProperty("ST_GlAcCode", String.valueOf (ST_GlAcCode));
							prop.setProperty("ST_TrnMode", ST_TrnMode);
							prop.setProperty("ST_OrgId",String.valueOf ( ST_OrgId));
							
							prop.setProperty("PF_ProductName", PF_ProductName);
							prop.setProperty("PF_AccountNumber", PF_AccountNumber);
							prop.setProperty("PF_AccountDisplayName", PF_AccountDisplayName);
							prop.setProperty("PF_BatchId", String.valueOf (PF_BatchId));
							prop.setProperty("PF_TransId",String.valueOf ( PF_TransId));
							prop.setProperty("PF_VoucherNo",String.valueOf ( PF_VoucherNo));
							prop.setProperty("PF_TransType", PF_TransType);
							prop.setProperty("PF_TrnAmount",PF_TrnAmount);
							prop.setProperty("PF_AmountType", PF_AmountType);
							prop.setProperty("PF_GlAcCode", String.valueOf (PF_GlAcCode));
							prop.setProperty("PF_TrnMode", PF_TrnMode);
							prop.setProperty("PF_OrgId",String.valueOf ( PF_OrgId));
							
							
							prop.setProperty("CGST_ProductName", CGST_ProductName);
							prop.setProperty("CGST_AccountNumber", CGST_AccountNumber);
							prop.setProperty("CGST_AccountDisplayName", CGST_AccountDisplayName);
							prop.setProperty("CGST_BatchId", String.valueOf (CGST_BatchId));
							prop.setProperty("CGST_TransId",String.valueOf ( CGST_TransId));
							prop.setProperty("CGST_VoucherNo",String.valueOf ( CGST_VoucherNo));
							prop.setProperty("CGST_TransType", CGST_TransType);
							prop.setProperty("CGST_TrnAmount",CGST_TrnAmount);
							prop.setProperty("CGST_AmountType", CGST_AmountType);
							prop.setProperty("CGST_GlAcCode", String.valueOf (CGST_GlAcCode));
							prop.setProperty("CGST_TrnMode", CGST_TrnMode);
							prop.setProperty("CGST_OrgId",String.valueOf ( CGST_OrgId));
							
							
							prop.setProperty("Share_TransactionDate", ShareOpening_TransactionDate.substring(0, 10));
							prop.setProperty("Share_ValueDate", ShareOpening_ValueDate.substring(0, 10));
							
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
