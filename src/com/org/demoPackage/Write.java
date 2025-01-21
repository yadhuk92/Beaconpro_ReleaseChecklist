package com.org.demoPackage;

import java.sql.DriverManager;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Write {
	public static WebElement element;
	public static String GL_TransactionDate;
	public static String GL_ValueDate;
	public static String GL_ProductName;
	public static String GL_AccountNumber;
	public static String GL_AccDisplayName;
	public static String GL_ProductName1;
	public static String GL_AccountNumber1;
	public static String GL_AccDisplayName1;
	public static String GL_ProductName2;
	public static String GL_AccountNumber2;
	public static String GL_AccDisplayName2;
	public static int GL_BatchId;
	public static int GL_TransId;
	public static int GL_VoucherNumber;
	public static String GL_TranType;
	public static String GL_TransAmount;
	public static String GL_AmountType;
	public static int GL_GlAcCode;
	public static String GL_TransferMode;
	public static String GL_TransferMode1;
	public static String GL_TransferMode2;
	public static String GL_TransferMode3;
	public static String GL_TransferMode4;
	public static int GL_OrgId;
	public static String Appr_ProductName;
	public static String Appr_AccountNumber;
	public static String Appr_AccDisplayName;
	public static int Appr_BatchId;
	public static int Appr_TransId;
	public static int Appr_VoucherNumber;
	public static String Appr_TranType;
	public static String Appr_TransAmount;
	public static String Appr_AmountType;
	public static int Appr_GlAcCode;
	public static String Appr_TransferMode;
	public static int Appr_OrgId;
	public static String Sb_ProductName;
	public static String  Sb_AccountNumber;
	public static String  Sb_AccDisplayName;
	public static int  Sb_BatchId;
	public static int  Sb_TransId;
	public static int  Sb_VoucherNumber;
	public static String  Sb_TranType;
	public static String  Sb_TransAmount;
	public static String  Sb_AmountType;
	public static int  Sb_GlAcCode;
	public static String  Sb_TransferMode;
	public static int  Sb_OrgId;
	public static int GL_VoucherNumber1;
	public static String GL_TranType1;
	public static String GL_TransAmount1;
	public static String GL_AmountType1;
	public static int GL_GlAcCode1;
	public static int GL_OrgId1;
	public static int GL_VoucherNumber2;
	public static String GL_TranType2;
	public static String GL_TransAmount2;
	public static String GL_AmountType2;
	public static int GL_GlAcCode2;
	public static int GL_OrgId2;
	public static int GL_VoucherNumber3;
	public static String GL_TranType3;
	public static String GL_TransAmount3;
	public static String GL_AmountType3;
	public static int GL_GlAcCode3;
	public static int GL_OrgId3;
	public static int GL_VoucherNumber4;
	public static String GL_TranType4;
	public static String GL_TransAmount4;
	public static String GL_AmountType4;
	public static int GL_GlAcCode4;
    public static int GL_OrgId4;
    public static int GL_VoucherNumber5;
	public static String GL_TranType5;
	public static String GL_TransAmount5;
	public static String GL_AmountType5;
	public static int GL_GlAcCode5;
	public static String  GL_TransferMode5;
    public static int GL_OrgId5;
    public static int GL_VoucherNumber6;
	public static String GL_TranType6;
	public static String GL_TransAmount6;
	public static String GL_AmountType6;
	public static int GL_GlAcCode6;
	public static String  GL_TransferMode6;
    public static int GL_OrgId6;
    public static int GL_VoucherNumber7;
	public static String GL_TranType7;
	public static String GL_TransAmount7;
	public static String GL_AmountType7;
	public static int GL_GlAcCode7;
    public static int GL_OrgId7;
    public static int GL_VoucherNumber8;
	public static String GL_TranType8;
	public static String GL_TransAmount8;
	public static String GL_AmountType8;
	public static int GL_GlAcCode8;
    public static int GL_OrgId8;
	public static void Write_GL_Cash(WebDriver driver, String propertyValue) {
		 
		 
		 
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
				           while(rs1.next()) {
				            
				        	   GL_TransactionDate=rs1.getString(1);
				        	   GL_ValueDate=rs1.getString(2);
				           }
				   //    System.out.println(CA_TransactionDate +"   "+ CA_ValueDate);
		      String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";

		             ResultSet rs= stmt.executeQuery(Data);
						
						System.out.println("SP executed");
						
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
						
						 	GL_ProductName=(String) ar.get(0);
					      	
					      	GL_AccountNumber=(String) ar.get(1);
						
					      	GL_AccDisplayName=(String) ar.get(2);
							
					      	GL_BatchId=Integer.parseInt((String) ar.get(3));
							
					      	GL_TransId=Integer.parseInt((String) ar.get(4));
							
					      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	GL_TranType=(String) ar.get(6);
							
					      	GL_TransAmount=(String) ar.get(7);
						
					      	GL_AmountType=(String) ar.get(8);
						
					      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	GL_TransferMode=(String) ar.get(10);
							
					      	GL_OrgId=Integer.parseInt((String) ar.get(11));
					      	
					      	
					      	Appr_ProductName=(String) ar.get(12);
					      	
					      	Appr_AccountNumber=(String) ar.get(13);
						
					      	Appr_AccDisplayName=(String) ar.get(14);
							
					      	Appr_BatchId=Integer.parseInt((String) ar.get(15));
							
					      	Appr_TransId=Integer.parseInt((String) ar.get(16));
							
					      	Appr_VoucherNumber=Integer.parseInt((String) ar.get(17));
							
					      	Appr_TranType=(String) ar.get(18);
							
					      	Appr_TransAmount=(String) ar.get(19);
						
					      	Appr_AmountType=(String) ar.get(20);
						
					      	Appr_GlAcCode=Integer.parseInt((String) ar.get(21));
							
					      	Appr_TransferMode=(String) ar.get(22);
							
					      	Appr_OrgId=Integer.parseInt((String) ar.get(23));
					
					      	
					      	Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/GL_CASH_Details.properties");
							prop.setProperty("GLproductName",GL_ProductName);
							prop.setProperty("GLAccountNumber", GL_AccountNumber);
							prop.setProperty("GLAccountDisplayName",GL_AccDisplayName);
							prop.setProperty("GLBatchId",String.valueOf(GL_BatchId));
							prop.setProperty("GLTransId", String.valueOf(GL_TransId));
							prop.setProperty("GLVoucherId",String.valueOf(GL_VoucherNumber));
							prop.setProperty("GLTransactionType", GL_TranType);	
							prop.setProperty("GLAmount",GL_TransAmount);
							prop.setProperty("GLAmountType",GL_AmountType);
							prop.setProperty("GLGLAccCode",String.valueOf (GL_GlAcCode));	
							prop.setProperty("GLTransferMode", GL_TransferMode);
							prop.setProperty("GLOrgID",String.valueOf (GL_OrgId));
							
							prop.setProperty("ChargeProductName", Appr_ProductName);
							prop.setProperty("ChargeAccountNumber", Appr_AccountNumber);
							prop.setProperty("ChargeAccountDispalyName", Appr_AccDisplayName);
							prop.setProperty("ChargeBatchId", String.valueOf (Appr_BatchId));
							prop.setProperty("ChargeTransactionId",String.valueOf ( Appr_TransId));
							prop.setProperty("ChargeVoucherNumber",String.valueOf ( Appr_VoucherNumber));
							prop.setProperty("ChargeTransType", Appr_TranType);
							prop.setProperty("ChargeTransAmount", Appr_TransAmount);
							prop.setProperty("ChargeAmountType", Appr_AmountType);
							prop.setProperty("ChargeGLAcCode", String.valueOf (Appr_GlAcCode));
							prop.setProperty("ChargeTransactionMode", Appr_TransferMode);
							prop.setProperty("ChargeOrgID",String.valueOf ( Appr_OrgId));
					      	
							System.out.println("Written ");
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
	
	public static void Write_GL_Autopost(WebDriver driver, String propertyValue) {
		 
		 
		 
		 
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
				           while(rs1.next()) {
				            
				        	   GL_TransactionDate=rs1.getString(1);
				        	   GL_ValueDate=rs1.getString(2);
				           }
				   //    System.out.println(CA_TransactionDate +"   "+ CA_ValueDate);
				        
		String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";

                      ResultSet rs= stmt.executeQuery(Data);
						
						System.out.println("SP executed");
						
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
						
						 	GL_ProductName=(String) ar.get(0);
					      	
					      	GL_AccountNumber=(String) ar.get(1);
						
					      	GL_AccDisplayName=(String) ar.get(2);
							
					      	GL_BatchId=Integer.parseInt((String) ar.get(3));
							
					      	GL_TransId=Integer.parseInt((String) ar.get(4));
							
					      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	GL_TranType=(String) ar.get(6);
							
					      	GL_TransAmount=(String) ar.get(7);
						
					      	GL_AmountType=(String) ar.get(8);
						
					      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	GL_TransferMode=(String) ar.get(10);
							
					      	GL_OrgId=Integer.parseInt((String) ar.get(11));
					      	
					      	
					      	Appr_ProductName=(String) ar.get(12);
					      	
					      	Appr_AccountNumber=(String) ar.get(13);
						
					      	Appr_AccDisplayName=(String) ar.get(14);
							
					      	Appr_BatchId=Integer.parseInt((String) ar.get(15));
							
					      	Appr_TransId=Integer.parseInt((String) ar.get(16));
							
					      	Appr_VoucherNumber=Integer.parseInt((String) ar.get(17));
							
					      	Appr_TranType=(String) ar.get(18);
							
					      	Appr_TransAmount=(String) ar.get(19);
						
					      	Appr_AmountType=(String) ar.get(20);
						
					      	Appr_GlAcCode=Integer.parseInt((String) ar.get(21));
							
					      	Appr_TransferMode=(String) ar.get(22);
							
					      	Appr_OrgId=Integer.parseInt((String) ar.get(23));
					
					      	
					      	
					      	Sb_ProductName=(String) ar.get(24);
					      	
					      	Sb_AccountNumber=(String) ar.get(25);
						
					      	Sb_AccDisplayName=(String) ar.get(26);
							
					      	Sb_BatchId=Integer.parseInt((String) ar.get(27));
							
					      	Sb_TransId=Integer.parseInt((String) ar.get(28));
							
					      	Sb_VoucherNumber=Integer.parseInt((String) ar.get(29));
							
					      	Sb_TranType=(String) ar.get(30);
							
					      	Sb_TransAmount=(String) ar.get(31);
						
					      	Sb_AmountType=(String) ar.get(32);
						
					      	Sb_GlAcCode=Integer.parseInt((String) ar.get(33));
							
					      	Sb_TransferMode=(String) ar.get(34);
							
					      	Sb_OrgId=Integer.parseInt((String) ar.get(35));
					
					      	
					      	
					      	Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/GL_AUTOPOST_Details.properties");
							prop.setProperty("GLproductName",GL_ProductName);
							prop.setProperty("GLAccountNumber", GL_AccountNumber);
							prop.setProperty("GLAccountDisplayName",GL_AccDisplayName);
							prop.setProperty("GLBatchId",String.valueOf(GL_BatchId));
							prop.setProperty("GLTransId", String.valueOf(GL_TransId));
							prop.setProperty("GLVoucherId",String.valueOf(GL_VoucherNumber));
							prop.setProperty("GLTransactionType", GL_TranType);	
							prop.setProperty("GLAmount",GL_TransAmount);
							prop.setProperty("GLAmountType",GL_AmountType);
							prop.setProperty("GLGLAccCode",String.valueOf (GL_GlAcCode));	
							prop.setProperty("GLTransferMode", GL_TransferMode);
							prop.setProperty("GLOrgID",String.valueOf (GL_OrgId));
							
							prop.setProperty("ChargeProductName", Appr_ProductName);
							prop.setProperty("ChargeAccountNumber", Appr_AccountNumber);
							prop.setProperty("ChargeAccountDispalyName", Appr_AccDisplayName);
							prop.setProperty("ChargeBatchId", String.valueOf (Appr_BatchId));
							prop.setProperty("ChargeTransactionId",String.valueOf ( Appr_TransId));
							prop.setProperty("ChargeVoucherNumber",String.valueOf ( Appr_VoucherNumber));
							prop.setProperty("ChargeTransType", Appr_TranType);
							prop.setProperty("ChargeTransAmount", Appr_TransAmount);
							prop.setProperty("ChargeAmountType", Appr_AmountType);
							prop.setProperty("ChargeGLAcCode", String.valueOf (Appr_GlAcCode));
							prop.setProperty("ChargeTransactionMode", Appr_TransferMode);
							prop.setProperty("ChargeOrgID",String.valueOf ( Appr_OrgId));
							
							prop.setProperty("SBProductName", Sb_ProductName);
							prop.setProperty("SBAccountNumber", Sb_AccountNumber);
							prop.setProperty("SBAccountDispalyName", Sb_AccDisplayName);
							prop.setProperty("SBBatchId", String.valueOf (Sb_BatchId));
							prop.setProperty("SBTransactionId",String.valueOf ( Sb_TransId));
							prop.setProperty("SBVoucherNumber",String.valueOf ( Sb_VoucherNumber));
							prop.setProperty("SBTransType", Sb_TranType);
							prop.setProperty("SBTransAmount", Sb_TransAmount);
							prop.setProperty("SBAmountType", Sb_AmountType);
							prop.setProperty("SBGLAcCode", String.valueOf (Sb_GlAcCode));
							prop.setProperty("SBTransactionMode", Sb_TransferMode);
							prop.setProperty("SBOrgID",String.valueOf ( Sb_OrgId));
					      	
							System.out.println("Written ");
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
	
	public static void Write_GL_Batch(WebDriver driver, String propertyValue) {
		
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
				           while(rs1.next()) {
				            
				        	   GL_TransactionDate=rs1.getString(1);
				        	   GL_ValueDate=rs1.getString(2);
				           }
				   //    System.out.println(CA_TransactionDate +"   "+ CA_ValueDate);
				        
		String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";

                      ResultSet rs= stmt.executeQuery(Data);
						
						System.out.println("SP executed");
						
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
						
						 	GL_ProductName=(String) ar.get(0);
					      	
					      	GL_AccountNumber=(String) ar.get(1);
						
					      	GL_AccDisplayName=(String) ar.get(2);
							
					      	GL_BatchId=Integer.parseInt((String) ar.get(3));
							
					      	GL_TransId=Integer.parseInt((String) ar.get(4));
							
					      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	GL_TranType=(String) ar.get(6);
							
					      	GL_TransAmount=(String) ar.get(7);
						
					      	GL_AmountType=(String) ar.get(8);
						
					      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	GL_TransferMode=(String) ar.get(10);
							
					      	GL_OrgId=Integer.parseInt((String) ar.get(11));
					      	
					      	
					      	Appr_ProductName=(String) ar.get(12);
					      	
					      	Appr_AccountNumber=(String) ar.get(13);
						
					      	Appr_AccDisplayName=(String) ar.get(14);
							
					      	Appr_BatchId=Integer.parseInt((String) ar.get(15));
							
					      	Appr_TransId=Integer.parseInt((String) ar.get(16));
							
					      	Appr_VoucherNumber=Integer.parseInt((String) ar.get(17));
							
					      	Appr_TranType=(String) ar.get(18);
							
					      	Appr_TransAmount=(String) ar.get(19);
						
					      	Appr_AmountType=(String) ar.get(20);
						
					      	Appr_GlAcCode=Integer.parseInt((String) ar.get(21));
							
					      	Appr_TransferMode=(String) ar.get(22);
							
					      	Appr_OrgId=Integer.parseInt((String) ar.get(23));
					
					      	
					      	Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/GL_BATCH_Details.properties");
							prop.setProperty("GLproductName",GL_ProductName);
							prop.setProperty("GLAccountNumber", GL_AccountNumber);
							prop.setProperty("GLAccountDisplayName",GL_AccDisplayName);
							prop.setProperty("GLBatchId",String.valueOf(GL_BatchId));
							prop.setProperty("GLTransId", String.valueOf(GL_TransId));
							prop.setProperty("GLVoucherId",String.valueOf(GL_VoucherNumber));
							prop.setProperty("GLTransactionType", GL_TranType);	
							prop.setProperty("GLAmount",GL_TransAmount);
							prop.setProperty("GLAmountType",GL_AmountType);
							prop.setProperty("GLGLAccCode",String.valueOf (GL_GlAcCode));	
							prop.setProperty("GLTransferMode", GL_TransferMode);
							prop.setProperty("GLOrgID",String.valueOf (GL_OrgId));
							
							prop.setProperty("ChargeProductName", Appr_ProductName);
							prop.setProperty("ChargeAccountNumber", Appr_AccountNumber);
							prop.setProperty("ChargeAccountDispalyName", Appr_AccDisplayName);
							prop.setProperty("ChargeBatchId", String.valueOf (Appr_BatchId));
							prop.setProperty("ChargeTransactionId",String.valueOf ( Appr_TransId));
							prop.setProperty("ChargeVoucherNumber",String.valueOf ( Appr_VoucherNumber));
							prop.setProperty("ChargeTransType", Appr_TranType);
							prop.setProperty("ChargeTransAmount", Appr_TransAmount);
							prop.setProperty("ChargeAmountType", Appr_AmountType);
							prop.setProperty("ChargeGLAcCode", String.valueOf (Appr_GlAcCode));
							prop.setProperty("ChargeTransactionMode", Appr_TransferMode);
							prop.setProperty("ChargeOrgID",String.valueOf ( Appr_OrgId));
					      	
							System.out.println("Written ");
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
	
	public static void Write_SL_Cash(WebDriver driver, String propertyValue) {
		
		 
		
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
				           while(rs1.next()) {
				            
				        	   GL_TransactionDate=rs1.getString(1);
				        	   GL_ValueDate=rs1.getString(2);
				           }
				   //    System.out.println(CA_TransactionDate +"   "+ CA_ValueDate);
	String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
		        
				       
                         ResultSet rs= stmt.executeQuery(Data);
						
						System.out.println("SP executed");
						
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
						
						 	GL_ProductName=(String) ar.get(0);
					      	
					      	GL_AccountNumber=(String) ar.get(1);
						
					      	GL_AccDisplayName=(String) ar.get(2);
							
					      	GL_BatchId=Integer.parseInt((String) ar.get(3));
							
					      	GL_TransId=Integer.parseInt((String) ar.get(4));
							
					      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	GL_TranType=(String) ar.get(6);
							
					      	GL_TransAmount=(String) ar.get(7);
						
					      	GL_AmountType=(String) ar.get(8);
						
					      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	GL_TransferMode=(String) ar.get(10);
							
					      	GL_OrgId=Integer.parseInt((String) ar.get(11));
					      	
					      	
					      	
					      	
					      	Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/SL_CASH_Details.properties");
							prop.setProperty("SLproductName",GL_ProductName);
							prop.setProperty("SLAccountNumber", GL_AccountNumber);
							prop.setProperty("SLAccountDisplayName",GL_AccDisplayName);
							prop.setProperty("SLBatchId",String.valueOf(GL_BatchId));
							prop.setProperty("SLTransId", String.valueOf(GL_TransId));
							prop.setProperty("SLVoucherId",String.valueOf(GL_VoucherNumber));
							prop.setProperty("SLTransactionType", GL_TranType);	
							prop.setProperty("SLAmount",GL_TransAmount);
							prop.setProperty("SLAmountType",GL_AmountType);
							prop.setProperty("SLGLAccCode",String.valueOf (GL_GlAcCode));	
							prop.setProperty("SLTransferMode", GL_TransferMode);
							prop.setProperty("SLOrgID",String.valueOf (GL_OrgId));
							
							
					      	
							System.out.println("Written ");
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
	public static void Write_SL_Autopost(WebDriver driver, String propertyValue) {
		 
		 
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
				           while(rs1.next()) {
				            
				        	   GL_TransactionDate=rs1.getString(1);
				        	   GL_ValueDate=rs1.getString(2);
				           }
				   //    System.out.println(CA_TransactionDate +"   "+ CA_ValueDate);
				        
	String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
		        
                        ResultSet rs= stmt.executeQuery(Data);
						
						System.out.println("SP executed");
						
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
						
						 	GL_ProductName=(String) ar.get(0);
					      	
					      	GL_AccountNumber=(String) ar.get(1);
						
					      	GL_AccDisplayName=(String) ar.get(2);
							
					      	GL_BatchId=Integer.parseInt((String) ar.get(3));
							
					      	GL_TransId=Integer.parseInt((String) ar.get(4));
							
					      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	GL_TranType=(String) ar.get(6);
							
					      	GL_TransAmount=(String) ar.get(7);
						
					      	GL_AmountType=(String) ar.get(8);
						
					      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	GL_TransferMode=(String) ar.get(10);
							
					      	GL_OrgId=Integer.parseInt((String) ar.get(11));
					      	
					      	
					      	Sb_ProductName=(String) ar.get(12);
					      	
					      	Sb_AccountNumber=(String) ar.get(13);
						
					      	Sb_AccDisplayName=(String) ar.get(14);
							
					      	Sb_BatchId=Integer.parseInt((String) ar.get(15));
							
					      	Sb_TransId=Integer.parseInt((String) ar.get(16));
							
					      	Sb_VoucherNumber=Integer.parseInt((String) ar.get(17));
							
					      	Sb_TranType=(String) ar.get(18);
							
					      	Sb_TransAmount=(String) ar.get(19);
						
					      	Sb_AmountType=(String) ar.get(20);
						
					      	Sb_GlAcCode=Integer.parseInt((String) ar.get(21));
							
					      	Sb_TransferMode=(String) ar.get(22);
							
					      	Sb_OrgId=Integer.parseInt((String) ar.get(23));
					
					      	
					      	
					
					      	
					      	
					      	Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/SL_AUTOPOST_Details.properties");
							prop.setProperty("SLproductName",GL_ProductName);
							prop.setProperty("SLAccountNumber", GL_AccountNumber);
							prop.setProperty("SLAccountDisplayName",GL_AccDisplayName);
							prop.setProperty("SLBatchId",String.valueOf(GL_BatchId));
							prop.setProperty("SLTransId", String.valueOf(GL_TransId));
							prop.setProperty("SLVoucherId",String.valueOf(GL_VoucherNumber));
							prop.setProperty("SLTransactionType", GL_TranType);	
							prop.setProperty("SLAmount",GL_TransAmount);
							prop.setProperty("SLAmountType",GL_AmountType);
							prop.setProperty("SLGLAccCode",String.valueOf (GL_GlAcCode));	
							prop.setProperty("SLTransferMode", GL_TransferMode);
							prop.setProperty("SLOrgID",String.valueOf (GL_OrgId));
							
							
							
							prop.setProperty("SBProductName", Sb_ProductName);
							prop.setProperty("SBAccountNumber", Sb_AccountNumber);
							prop.setProperty("SBAccountDispalyName", Sb_AccDisplayName);
							prop.setProperty("SBBatchId", String.valueOf (Sb_BatchId));
							prop.setProperty("SBTransactionId",String.valueOf ( Sb_TransId));
							prop.setProperty("SBVoucherNumber",String.valueOf ( Sb_VoucherNumber));
							prop.setProperty("SBTransType", Sb_TranType);
							prop.setProperty("SBTransAmount", Sb_TransAmount);
							prop.setProperty("SBAmountType", Sb_AmountType);
							prop.setProperty("SBGLAcCode", String.valueOf (Sb_GlAcCode));
							prop.setProperty("SBTransactionMode", Sb_TransferMode);
							prop.setProperty("SBOrgID",String.valueOf ( Sb_OrgId));
					      	
							System.out.println("Written ");
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
	public static void Write_SL_Batch(WebDriver driver, String propertyValue) {
		 
		 
		
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
				           while(rs1.next()) {
				            
				        	   GL_TransactionDate=rs1.getString(1);
				        	   GL_ValueDate=rs1.getString(2);
				           }
				   //    System.out.println(CA_TransactionDate +"   "+ CA_ValueDate);
				        
	String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
		       
                     ResultSet rs= stmt.executeQuery(Data);
						
						System.out.println("SP executed");
						
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
						
						 	GL_ProductName=(String) ar.get(0);
					      	
					      	GL_AccountNumber=(String) ar.get(1);
						
					      	GL_AccDisplayName=(String) ar.get(2);
							
					      	GL_BatchId=Integer.parseInt((String) ar.get(3));
							
					      	GL_TransId=Integer.parseInt((String) ar.get(4));
							
					      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	GL_TranType=(String) ar.get(6);
							
					      	GL_TransAmount=(String) ar.get(7);
						
					      	GL_AmountType=(String) ar.get(8);
						
					      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	GL_TransferMode=(String) ar.get(10);
							
					      	GL_OrgId=Integer.parseInt((String) ar.get(11));
					      	
					      	
					      	
					      	
					      	Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/SL_BATCH_Details.properties");
							prop.setProperty("SLproductName",GL_ProductName);
							prop.setProperty("SLAccountNumber", GL_AccountNumber);
							prop.setProperty("SLAccountDisplayName",GL_AccDisplayName);
							prop.setProperty("SLBatchId",String.valueOf(GL_BatchId));
							prop.setProperty("SLTransId", String.valueOf(GL_TransId));
							prop.setProperty("SLVoucherId",String.valueOf(GL_VoucherNumber));
							prop.setProperty("SLTransactionType", GL_TranType);	
							prop.setProperty("SLAmount",GL_TransAmount);
							prop.setProperty("SLAmountType",GL_AmountType);
							prop.setProperty("SLGLAccCode",String.valueOf (GL_GlAcCode));	
							prop.setProperty("SLTransferMode", GL_TransferMode);
							prop.setProperty("SLOrgID",String.valueOf (GL_OrgId));
							
							
					      	
							System.out.println("Written ");
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
	public static void Write_SA_Cash(WebDriver driver, String propertyValue) {
		 
		
			 
			
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
					           while(rs1.next()) {
					            
					        	   GL_TransactionDate=rs1.getString(1);
					        	   GL_ValueDate=rs1.getString(2);
					           }
					   //    System.out.println(CA_TransactionDate +"   "+ CA_ValueDate);
		String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";

                        ResultSet rs= stmt.executeQuery(Data);
							
							System.out.println("SP executed");
							
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
							
							 	GL_ProductName=(String) ar.get(0);
						      	
						      	GL_AccountNumber=(String) ar.get(1);
							
						      	GL_AccDisplayName=(String) ar.get(2);
								
						      	GL_BatchId=Integer.parseInt((String) ar.get(3));
								
						      	GL_TransId=Integer.parseInt((String) ar.get(4));
								
						      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
								
						      	GL_TranType=(String) ar.get(6);
								
						      	GL_TransAmount=(String) ar.get(7);
							
						      	GL_AmountType=(String) ar.get(8);
							
						      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
								
						      	GL_TransferMode=(String) ar.get(10);
								
						      	GL_OrgId=Integer.parseInt((String) ar.get(11));
						      	
						      	
						      	
						      	
						      	Properties prop=new Properties();
								
								FileOutputStream fos = new FileOutputStream("./DataFiles/SA_CASH_Details.properties");
								prop.setProperty("SLproductName",GL_ProductName);
								prop.setProperty("SLAccountNumber", GL_AccountNumber);
								prop.setProperty("SLAccountDisplayName",GL_AccDisplayName);
								prop.setProperty("SLBatchId",String.valueOf(GL_BatchId));
								prop.setProperty("SLTransId", String.valueOf(GL_TransId));
								prop.setProperty("SLVoucherId",String.valueOf(GL_VoucherNumber));
								prop.setProperty("SLTransactionType", GL_TranType);	
								prop.setProperty("SLAmount",GL_TransAmount);
								prop.setProperty("SLAmountType",GL_AmountType);
								prop.setProperty("SLGLAccCode",String.valueOf (GL_GlAcCode));	
								prop.setProperty("SLTransferMode", GL_TransferMode);
								prop.setProperty("SLOrgID",String.valueOf (GL_OrgId));
								
								
						      	
								System.out.println("Written ");
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
	public static void Write_SA_Autopost(WebDriver driver, String propertyValue) {
		
		
		 
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
				           while(rs1.next()) {
				            
				        	   GL_TransactionDate=rs1.getString(1);
				        	   GL_ValueDate=rs1.getString(2);
				           }
				   //    System.out.println(CA_TransactionDate +"   "+ CA_ValueDate);
	String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
		        
                     ResultSet rs= stmt.executeQuery(Data);
						
						System.out.println("SP executed");
						
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
						
						 	GL_ProductName=(String) ar.get(0);
					      	
					      	GL_AccountNumber=(String) ar.get(1);
						
					      	GL_AccDisplayName=(String) ar.get(2);
							
					      	GL_BatchId=Integer.parseInt((String) ar.get(3));
							
					      	GL_TransId=Integer.parseInt((String) ar.get(4));
							
					      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	GL_TranType=(String) ar.get(6);
							
					      	GL_TransAmount=(String) ar.get(7);
						
					      	GL_AmountType=(String) ar.get(8);
						
					      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	GL_TransferMode=(String) ar.get(10);
							
					      	GL_OrgId=Integer.parseInt((String) ar.get(11));
					      	
					      	
					      	Sb_ProductName=(String) ar.get(12);
					      	
					      	Sb_AccountNumber=(String) ar.get(13);
						
					      	Sb_AccDisplayName=(String) ar.get(14);
							
					      	Sb_BatchId=Integer.parseInt((String) ar.get(15));
							
					      	Sb_TransId=Integer.parseInt((String) ar.get(16));
							
					      	Sb_VoucherNumber=Integer.parseInt((String) ar.get(17));
							
					      	Sb_TranType=(String) ar.get(18);
							
					      	Sb_TransAmount=(String) ar.get(19);
						
					      	Sb_AmountType=(String) ar.get(20);
						
					      	Sb_GlAcCode=Integer.parseInt((String) ar.get(21));
							
					      	Sb_TransferMode=(String) ar.get(22);
							
					      	Sb_OrgId=Integer.parseInt((String) ar.get(23));
					
					      	
					      	
					
					      	
					      	
					      	Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/SA_AUTOPOST_Details.properties");
							prop.setProperty("SLproductName",GL_ProductName);
							prop.setProperty("SLAccountNumber", GL_AccountNumber);
							prop.setProperty("SLAccountDisplayName",GL_AccDisplayName);
							prop.setProperty("SLBatchId",String.valueOf(GL_BatchId));
							prop.setProperty("SLTransId", String.valueOf(GL_TransId));
							prop.setProperty("SLVoucherId",String.valueOf(GL_VoucherNumber));
							prop.setProperty("SLTransactionType", GL_TranType);	
							prop.setProperty("SLAmount",GL_TransAmount);
							prop.setProperty("SLAmountType",GL_AmountType);
							prop.setProperty("SLGLAccCode",String.valueOf (GL_GlAcCode));	
							prop.setProperty("SLTransferMode", GL_TransferMode);
							prop.setProperty("SLOrgID",String.valueOf (GL_OrgId));
							
							
							
							prop.setProperty("SBProductName", Sb_ProductName);
							prop.setProperty("SBAccountNumber", Sb_AccountNumber);
							prop.setProperty("SBAccountDispalyName", Sb_AccDisplayName);
							prop.setProperty("SBBatchId", String.valueOf (Sb_BatchId));
							prop.setProperty("SBTransactionId",String.valueOf ( Sb_TransId));
							prop.setProperty("SBVoucherNumber",String.valueOf ( Sb_VoucherNumber));
							prop.setProperty("SBTransType", Sb_TranType);
							prop.setProperty("SBTransAmount", Sb_TransAmount);
							prop.setProperty("SBAmountType", Sb_AmountType);
							prop.setProperty("SBGLAcCode", String.valueOf (Sb_GlAcCode));
							prop.setProperty("SBTransactionMode", Sb_TransferMode);
							prop.setProperty("SBOrgID",String.valueOf ( Sb_OrgId));
					      	
							System.out.println("Written ");
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
	public static void Write_SA_Batch(WebDriver driver, String propertyValue) {
		 
		 
		
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
				           while(rs1.next()) {
				            
				        	   GL_TransactionDate=rs1.getString(1);
				        	   GL_ValueDate=rs1.getString(2);
				           }
				   //    System.out.println(CA_TransactionDate +"   "+ CA_ValueDate);
String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
	        
                     ResultSet rs= stmt.executeQuery(Data);
						
						System.out.println("SP executed");
						
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
						
						 	GL_ProductName=(String) ar.get(0);
					      	
					      	GL_AccountNumber=(String) ar.get(1);
						
					      	GL_AccDisplayName=(String) ar.get(2);
							
					      	GL_BatchId=Integer.parseInt((String) ar.get(3));
							
					      	GL_TransId=Integer.parseInt((String) ar.get(4));
							
					      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	GL_TranType=(String) ar.get(6);
							
					      	GL_TransAmount=(String) ar.get(7);
						
					      	GL_AmountType=(String) ar.get(8);
						
					      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	GL_TransferMode=(String) ar.get(10);
							
					      	GL_OrgId=Integer.parseInt((String) ar.get(11));
					      	
					      	
					      	
					      	
					      	Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/SA_BATCH_Details.properties");
							prop.setProperty("SLproductName",GL_ProductName);
							prop.setProperty("SLAccountNumber", GL_AccountNumber);
							prop.setProperty("SLAccountDisplayName",GL_AccDisplayName);
							prop.setProperty("SLBatchId",String.valueOf(GL_BatchId));
							prop.setProperty("SLTransId", String.valueOf(GL_TransId));
							prop.setProperty("SLVoucherId",String.valueOf(GL_VoucherNumber));
							prop.setProperty("SLTransactionType", GL_TranType);	
							prop.setProperty("SLAmount",GL_TransAmount);
							prop.setProperty("SLAmountType",GL_AmountType);
							prop.setProperty("SLGLAccCode",String.valueOf (GL_GlAcCode));	
							prop.setProperty("SLTransferMode", GL_TransferMode);
							prop.setProperty("SLOrgID",String.valueOf (GL_OrgId));
							
							
					      	
							System.out.println("Written ");
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
	
 public static void Write_OLCr_Cash_Details(WebDriver driver, String propertyValue) {
		 
		try {
					
			System.out.println("OL CREDIT CASH SUMMARY");
				   element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				   String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
				   System.out.println("Trans ID "+TransID);
							
				   Connection con=(Connection) Common.DatabaseConnector();
						  if(con !=null) {
								  
					          Statement stmt = con.createStatement();	
					          String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
					          ResultSet rs1= stmt.executeQuery(Q_datefetch);
					       while(rs1.next()) {
					            
					        	   GL_TransactionDate=rs1.getString(1);
					        	   GL_ValueDate=rs1.getString(2);
					         }
					  
		     String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
             ResultSet rs= stmt.executeQuery(Data);
			 System.out.println("SP1 executed");
			 int row=rs.getRow();
			 ArrayList ar=new ArrayList<>();
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
							
						GL_ProductName=(String) ar.get(0);
						GL_AccountNumber=(String) ar.get(1);
					    GL_AccDisplayName=(String) ar.get(2);
		                GL_BatchId=Integer.parseInt((String) ar.get(3));
						GL_TransId=Integer.parseInt((String) ar.get(4));
					    GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
						GL_TranType=(String) ar.get(6);
						GL_TransferMode=(String) ar.get(7);
					    GL_OrgId=Integer.parseInt((String) ar.get(8));
								
		     String Data1="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
			 ResultSet result= stmt.executeQuery(Data1);
			 System.out.println("SP2 executed");
			 int row1=result.getRow();
			 ArrayList ar1=new ArrayList<>();
			 ResultSetMetaData rsmd1;
										 
					try {
							rsmd1 = result.getMetaData();

		                    int NumOfCol1 = rsmd1.getColumnCount();
									            
									while (result.next()) {
									             
			                               for (int i = 1; i <= NumOfCol1; i++) {
									                   
									             ar1.add(result.getString(i));
									                	
									          }

									                row1++;
									  }
									            
									            
						} catch (SQLException e) {
									      throw e;
							}  			      	
								
						      	
						      	
					    GL_TransAmount1=(String) ar1.get(0);
					    GL_AmountType1=(String) ar1.get(1);
				        GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
				        
				        GL_TransAmount2=(String) ar1.get(3);
					    GL_AmountType2=(String) ar1.get(4);
				        GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
				        
				       
				        
				        
						      	
						      	
				Properties prop=new Properties();
						      	
				FileOutputStream fos = new FileOutputStream("./DataFiles/OLCREDIT_CASH.properties");
				
						prop.setProperty("OLproductName",GL_ProductName);
						prop.setProperty("OLAccountNumber", GL_AccountNumber);
						prop.setProperty("OLAccountDisplayName",GL_AccDisplayName);
						prop.setProperty("OLBatchId",String.valueOf(GL_BatchId));
						prop.setProperty("OLTransId", String.valueOf(GL_TransId));
						prop.setProperty("OLVoucherId",String.valueOf(GL_VoucherNumber));
						prop.setProperty("OLTransactionType", GL_TranType);	
						prop.setProperty("OLTransferMode", GL_TransferMode);
						prop.setProperty("OLOrgID",String.valueOf (GL_OrgId));
						
						prop.setProperty("OLAmount1",GL_TransAmount1);
						prop.setProperty("OLAmountType1",GL_AmountType1);
						prop.setProperty("OLGLAccCode1",String.valueOf (GL_GlAcCode1));
						
						prop.setProperty("OLAmount2",GL_TransAmount2);
						prop.setProperty("OLAmountType2",GL_AmountType2);
						prop.setProperty("OLGLAccCode2",String.valueOf (GL_GlAcCode2));
						
						
						
						
								
								
						      	
								System.out.println("Written ");
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
 
 public static void Write_OLCr_Batch_Details(WebDriver driver, String propertyValue) {
	 
		try {
					
			System.out.println("OL CREDIT CASH SUMMARY");
				   element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				   String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
				   System.out.println("Trans ID "+TransID);
							
				   Connection con=(Connection) Common.DatabaseConnector();
						  if(con !=null) {
								  
					          Statement stmt = con.createStatement();	
					          String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
					          ResultSet rs1= stmt.executeQuery(Q_datefetch);
					       while(rs1.next()) {
					            
					        	   GL_TransactionDate=rs1.getString(1);
					        	   GL_ValueDate=rs1.getString(2);
					         }
					float TotalAmount=0;
					String Principal=null;
					String Interest=null;
					String fine=null;
					        
					       
					        
					        try {
					        	
					        	Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
					        	Interest=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[3]/td[9]")).getText();
					        	fine=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[4]/td[9]")).getText();
					         
					         
					             float a= Float.parseFloat(Principal);
					             float b= Float.parseFloat(Interest);
					             float c= Float.parseFloat(fine);
					       
					        
					        TotalAmount= a+b+c;
					        System.out.println("Total Amount"+TotalAmount);
					       
					        }catch (NumberFormatException e) {
					        	
					        	e.printStackTrace();
					        }
		  String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
          ResultSet rs= stmt.executeQuery(Data);
		  System.out.println("SP1 executed");
		  int row=rs.getRow();
		  ArrayList ar=new ArrayList<>();
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
							
						GL_ProductName=(String) ar.get(0);
						GL_AccountNumber=(String) ar.get(1);
					    GL_AccDisplayName=(String) ar.get(2);
		                GL_BatchId=Integer.parseInt((String) ar.get(3));
						GL_TransId=Integer.parseInt((String) ar.get(4));
					    GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
						GL_TranType=(String) ar.get(6);
						GL_TransferMode=(String) ar.get(7);
					    GL_OrgId=Integer.parseInt((String) ar.get(8));
								
		     String Data1="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
			 ResultSet result= stmt.executeQuery(Data1);
			 System.out.println("SP2 executed");
			 int row1=result.getRow();
			 ArrayList ar1=new ArrayList<>();
			 ResultSetMetaData rsmd1;
										 
					try {
							rsmd1 = result.getMetaData();

		                    int NumOfCol1 = rsmd1.getColumnCount();
									            
									while (result.next()) {
									             
			                               for (int i = 1; i <= NumOfCol1; i++) {
									                   
									             ar1.add(result.getString(i));
									                	
									          }

									                row1++;
									  }
									            
									            
						} catch (SQLException e) {
									      throw e;
							}  			      	
								
						      	
						      	
					    GL_TransAmount1=(String) ar1.get(0);
					    GL_AmountType1=(String) ar1.get(1);
				        GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
				        
				        GL_TransAmount2=(String) ar1.get(3);
					    GL_AmountType2=(String) ar1.get(4);
				        GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
				        
				        GL_TransAmount3=(String) ar1.get(6);
					    GL_AmountType3=(String) ar1.get(7);
				        GL_GlAcCode3=Integer.parseInt((String) ar1.get(8));
						      	
						      	
				Properties prop=new Properties();
						      	
				FileOutputStream fos = new FileOutputStream("./DataFiles/OLCREDIT_BATCH.properties");
				
						prop.setProperty("OLproductName",GL_ProductName);
						prop.setProperty("OLAccountNumber", GL_AccountNumber);
						prop.setProperty("OLAccountDisplayName",GL_AccDisplayName);
						prop.setProperty("OLBatchId",String.valueOf(GL_BatchId));
						prop.setProperty("OLTransId", String.valueOf(GL_TransId));
						prop.setProperty("OLVoucherId",String.valueOf(GL_VoucherNumber));
						prop.setProperty("OLTransactionType", GL_TranType);	
						prop.setProperty("OLTransferMode", GL_TransferMode);
						prop.setProperty("OLOrgID",String.valueOf (GL_OrgId));
						
						prop.setProperty("OLAmount1",GL_TransAmount1);
						prop.setProperty("OLAmountType1",GL_AmountType1);
						prop.setProperty("OLGLAccCode1",String.valueOf (GL_GlAcCode1));
						
						prop.setProperty("OLAmount2",GL_TransAmount2);
						prop.setProperty("OLAmountType2",GL_AmountType2);
						prop.setProperty("OLGLAccCode2",String.valueOf (GL_GlAcCode2));
						
						prop.setProperty("OLAmount3",GL_TransAmount3);
						prop.setProperty("OLAmountType3",GL_AmountType3);
						prop.setProperty("OLGLAccCode3",String.valueOf (GL_GlAcCode3));
						prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
								
								
						      	
								System.out.println("Written ");
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
 
 public static WebDriver writeOLCredit_Autopost(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select distinct  ProductName,AcNo,AcDisplayName from QaFnGetinterbranchSummaryDetails  ("+TransID+")";     
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName1=(String) ar.get(3);
				       GL_AccountNumber1=(String) ar.get(4);
				       GL_AccDisplayName1=(String) ar.get(5);
				       GL_ProductName2=(String) ar.get(0);
				       GL_AccountNumber2=(String) ar.get(1);
				       GL_AccDisplayName2=(String) ar.get(2);  
				       
				   String Data1="select BatchID,TransID,TrnMode from QaFnGetinterbranchSummaryDetails  ("+TransID+")";
				   ResultSet rslt= stmt.executeQuery(Data1);
				   System.out.println("SP2 EXECUTED");
				   while(rslt.next()) {
			        	
					   GL_BatchId=Integer.parseInt(rslt.getString(1));
					   GL_TransId=Integer.parseInt(rslt.getString(2));
					   GL_TransferMode=rslt.getString(3);
					   
			        }
					   
				         
			 String Data2="select VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,RespBranchID from QaFnGetinterbranchSummaryDetails ("+TransID+")";
             ResultSet result= stmt.executeQuery(Data2);
             System.out.println("SP3 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(0));
				          GL_TranType2=(String) ar1.get(1);
				          GL_TransAmount2=(String) ar1.get(2);
				          GL_AmountType2=(String) ar1.get(3);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(4));
				          GL_OrgId2=Integer.parseInt((String) ar1.get(5));
				 	       
				          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(6));
				          GL_TranType1=(String) ar1.get(7);
				          GL_TransAmount1=(String) ar1.get(8);
				          GL_AmountType1=(String) ar1.get(9);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(10));
				          GL_OrgId1=Integer.parseInt((String) ar1.get(11));
				          
				          GL_VoucherNumber6=Integer.parseInt((String) ar1.get(12));
				          GL_TranType6=(String) ar1.get(13);
				          GL_TransAmount6=(String) ar1.get(14);
				          GL_AmountType6=(String) ar1.get(15);
				          GL_GlAcCode6=Integer.parseInt((String) ar1.get(16));
				          GL_OrgId6=Integer.parseInt((String) ar1.get(17));
				          
				          GL_VoucherNumber5=Integer.parseInt((String) ar1.get(18));
				          GL_TranType5=(String) ar1.get(19);
				          GL_TransAmount5=(String) ar1.get(20);
				          GL_AmountType5=(String) ar1.get(21);
				          GL_GlAcCode5=Integer.parseInt((String) ar1.get(22));
				          GL_OrgId5=Integer.parseInt((String) ar1.get(23));
				          
				          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(24));
				          GL_TranType3=(String) ar1.get(25);
				          GL_TransAmount3=(String) ar1.get(26);
				          GL_AmountType3=(String) ar1.get(27);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(28));
				          GL_OrgId3=Integer.parseInt((String) ar1.get(29));
				          
				          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(30));
				          GL_TranType4=(String) ar1.get(31);
				          GL_TransAmount4=(String) ar1.get(32);
				          GL_AmountType4=(String) ar1.get(33);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(34));
				          GL_OrgId4=Integer.parseInt((String) ar1.get(35));
				          
				 	      
				       
				            
				       
				       
				     Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/OLCREDIT_AUTOPOST.properties");
				      prop.setProperty("OL_ProductName1",GL_ProductName1);
				      prop.setProperty("OL_AccountNumber1", GL_AccountNumber1);
				      prop.setProperty("OL_DisplayName1",GL_AccDisplayName1);
				      prop.setProperty("OL_ProductName2",GL_ProductName2);
				      prop.setProperty("OL_AccountNumber2", GL_AccountNumber2);
				      prop.setProperty("OL_DisplayName2",GL_AccDisplayName2);
				      prop.setProperty("OL_BatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("OL_TransId", String.valueOf(GL_TransId));
				      prop.setProperty("OL_TransferMode",GL_TransferMode);
				      
				      
				      prop.setProperty("OL_VoucherNumber1",String.valueOf(GL_VoucherNumber1));
				      prop.setProperty("OL_TranType1", GL_TranType1); 
				      prop.setProperty("OL_TransAmount1",GL_TransAmount1);
				      prop.setProperty("OL_AmountType1",GL_AmountType1);
				      prop.setProperty("OL_GlAcCode1",String.valueOf (GL_GlAcCode1)); 
				      prop.setProperty("OL_OrgId1",String.valueOf (GL_OrgId1));
				      
				      prop.setProperty("OL_VoucherNumber2",String.valueOf(GL_VoucherNumber2));
				      prop.setProperty("OL_TranType2", GL_TranType2); 
				      prop.setProperty("OL_TransAmount2",GL_TransAmount2);
				      prop.setProperty("OL_AmountType2",GL_AmountType2);
				      prop.setProperty("OL_GlAcCode2",String.valueOf (GL_GlAcCode2)); 
				      prop.setProperty("OL_OrgId2",String.valueOf (GL_OrgId2));
				      
				      prop.setProperty("OL_VoucherNumber3",String.valueOf(GL_VoucherNumber3));
				      prop.setProperty("OL_TranType3", GL_TranType3); 
				      prop.setProperty("OL_TransAmount3",GL_TransAmount3);
				      prop.setProperty("OL_AmountType3",GL_AmountType3);
				      prop.setProperty("OL_GlAcCode3",String.valueOf (GL_GlAcCode3)); 
				      prop.setProperty("OL_OrgId3",String.valueOf (GL_OrgId3));
				      
				      prop.setProperty("OL_VoucherNumber4",String.valueOf(GL_VoucherNumber4));
				      prop.setProperty("OL_TranType4", GL_TranType4); 
				      prop.setProperty("OL_TransAmount4",GL_TransAmount4);
				      prop.setProperty("OL_AmountType4",GL_AmountType4);
				      prop.setProperty("OL_GlAcCode4",String.valueOf (GL_GlAcCode4)); 
				      prop.setProperty("OL_OrgId4",String.valueOf (GL_OrgId4));
				      
				      prop.setProperty("OL_VoucherNumber5",String.valueOf(GL_VoucherNumber5));
				      prop.setProperty("OL_TranType5", GL_TranType5); 
				      prop.setProperty("OL_TransAmount5",GL_TransAmount5);
				      prop.setProperty("OL_AmountType5",GL_AmountType5);
				      prop.setProperty("OL_GlAcCode5",String.valueOf (GL_GlAcCode5)); 
				      prop.setProperty("OL_OrgId5",String.valueOf (GL_OrgId5));
				      
				      prop.setProperty("OL_VoucherNumber6",String.valueOf(GL_VoucherNumber6));
				      prop.setProperty("OL_TranType6", GL_TranType6); 
				      prop.setProperty("OL_TransAmount6",GL_TransAmount6);
				      prop.setProperty("OL_AmountType6",GL_AmountType6);
				      prop.setProperty("OL_GlAcCode6",String.valueOf (GL_GlAcCode6)); 
				      prop.setProperty("OL_OrgId6",String.valueOf (GL_OrgId6));
				      
				      
				      
				      
				   
				      
				      
							
				      
				     System.out.println("Written ");
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
	return driver;

		}

 public static void writeODCredit_Cash(WebDriver driver, String propertyValue) {
		
	 
		
		try {
					
					System.out.println("WRITE SUMMARY");
					element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
						
							
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
							
		            Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
					Statement stmt = con.createStatement();	
					           
					           String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
					           ResultSet rs1= stmt.executeQuery(Q_datefetch);
					           while(rs1.next()) {
					            
					        	   GL_TransactionDate=rs1.getString(1);
					        	   GL_ValueDate=rs1.getString(2);
					           }
					 
		           String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
			       ResultSet rs= stmt.executeQuery(Data);
				   System.out.println("SP executed");
				   int row=rs.getRow();
				   ArrayList ar=new ArrayList<>();
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
							
							 	GL_ProductName=(String) ar.get(0);
						      	
						      	GL_AccountNumber=(String) ar.get(1);
							
						      	GL_AccDisplayName=(String) ar.get(2);
								
						      	GL_BatchId=Integer.parseInt((String) ar.get(3));
								
						      	GL_TransId=Integer.parseInt((String) ar.get(4));
								
						      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
								
						      	GL_TranType=(String) ar.get(6);
								
						      	GL_TransAmount=(String) ar.get(7);
							
						      	GL_AmountType=(String) ar.get(8);
							
						      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
								
						      	GL_TransferMode=(String) ar.get(10);
								
						      	GL_OrgId=Integer.parseInt((String) ar.get(11));
						      	
						      	
						      	
						      	
						      	Properties prop=new Properties();
								
								FileOutputStream fos = new FileOutputStream("./DataFiles/ODCREDIT_CASH.properties");
								prop.setProperty("ODproductName",GL_ProductName);
								prop.setProperty("ODAccountNumber", GL_AccountNumber);
								prop.setProperty("ODAccountDisplayName",GL_AccDisplayName);
								prop.setProperty("ODBatchId",String.valueOf(GL_BatchId));
								prop.setProperty("ODTransId", String.valueOf(GL_TransId));
								prop.setProperty("ODVoucherId",String.valueOf(GL_VoucherNumber));
								prop.setProperty("ODTransactionType", GL_TranType);	
								prop.setProperty("ODAmount",GL_TransAmount);
								prop.setProperty("ODAmountType",GL_AmountType);
								prop.setProperty("ODGLAccCode",String.valueOf (GL_GlAcCode));	
								prop.setProperty("ODTransferMode", GL_TransferMode);
								prop.setProperty("ODOrgID",String.valueOf (GL_OrgId));
								
								
						      	
								System.out.println("Written ");
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
 
 public static void writeODCredit_Batch(WebDriver driver, String propertyValue) {
		
	 
		
		try {
					
					System.out.println("WRITE SUMMARY");
					element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
						
							
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
							
		            Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
					Statement stmt = con.createStatement();	
					           
					           String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
					           ResultSet rs1= stmt.executeQuery(Q_datefetch);
					           while(rs1.next()) {
					            
					        	   GL_TransactionDate=rs1.getString(1);
					        	   GL_ValueDate=rs1.getString(2);
					           }
					     float TotalAmount=0;
						 String Principal=null;
								
								       
								        
								 try {
								        	
								      Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
								      float a= Float.parseFloat(Principal);
								      TotalAmount= a;
								        System.out.println("Total Amount"+TotalAmount);
								       
								        }catch (NumberFormatException e) {
								        	
								        	e.printStackTrace();
								        }
					 
		           String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
			       ResultSet rs= stmt.executeQuery(Data);
				   System.out.println("SP executed");
				   int row=rs.getRow();
				   ArrayList ar=new ArrayList<>();
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
							
							 	GL_ProductName=(String) ar.get(0);
						      	
						      	GL_AccountNumber=(String) ar.get(1);
							
						      	GL_AccDisplayName=(String) ar.get(2);
								
						      	GL_BatchId=Integer.parseInt((String) ar.get(3));
								
						      	GL_TransId=Integer.parseInt((String) ar.get(4));
								
						      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
								
						      	GL_TranType=(String) ar.get(6);
								
						      	GL_TransAmount=(String) ar.get(7);
							
						      	GL_AmountType=(String) ar.get(8);
							
						      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
								
						      	GL_TransferMode=(String) ar.get(10);
								
						      	GL_OrgId=Integer.parseInt((String) ar.get(11));
						      	
						      	
						      	
						      	
						      	Properties prop=new Properties();
								
								FileOutputStream fos = new FileOutputStream("./DataFiles/ODCREDIT_BATCH.properties");
								prop.setProperty("ODproductName",GL_ProductName);
								prop.setProperty("ODAccountNumber", GL_AccountNumber);
								prop.setProperty("ODAccountDisplayName",GL_AccDisplayName);
								prop.setProperty("ODBatchId",String.valueOf(GL_BatchId));
								prop.setProperty("ODTransId", String.valueOf(GL_TransId));
								prop.setProperty("ODVoucherId",String.valueOf(GL_VoucherNumber));
								prop.setProperty("ODTransactionType", GL_TranType);	
								prop.setProperty("ODAmount",GL_TransAmount);
								prop.setProperty("ODAmountType",GL_AmountType);
								prop.setProperty("ODGLAccCode",String.valueOf (GL_GlAcCode));	
								prop.setProperty("ODTransferMode", GL_TransferMode);
								prop.setProperty("ODOrgID",String.valueOf (GL_OrgId));
								prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
								
						      	
								System.out.println("Written ");
								prop.store(fos, "Done");
								fos.close();
									
						}
				}catch(Exception e){
					Driver.tcFlag = "PASS";
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					e.printStackTrace();
				}
			

				}
 
 public static WebDriver writeODCredit_Autopost(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select distinct  ProductName,AcNo,AcDisplayName from QaFnGetinterbranchSummaryDetails  ("+TransID+")";     
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName1=(String) ar.get(3);
				       GL_AccountNumber1=(String) ar.get(4);
				       GL_AccDisplayName1=(String) ar.get(5);
				       GL_ProductName2=(String) ar.get(0);
				       GL_AccountNumber2=(String) ar.get(1);
				       GL_AccDisplayName2=(String) ar.get(2);  
				       
				   String Data1="select BatchID,TransID,TrnAmount,TrnMode from QaFnGetinterbranchSummaryDetails  ("+TransID+")";
				   ResultSet rslt= stmt.executeQuery(Data1);
				   System.out.println("SP2 EXECUTED");
				   while(rslt.next()) {
			        	
					   GL_BatchId=Integer.parseInt(rslt.getString(1));
					   GL_TransId=Integer.parseInt(rslt.getString(2));
					   GL_TransAmount=rslt.getString(3);
					   GL_TransferMode=rslt.getString(4);
					   
			        }
					   
				         
			 String Data2="select VoucherNo,CrorDr,AmtTypeText,GLAcCode,RespBranchID from QaFnGetinterbranchSummaryDetails ("+TransID+")";
          ResultSet result= stmt.executeQuery(Data2);
          System.out.println("SP3 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(0));
				          GL_TranType1=(String) ar1.get(1);
				          GL_AmountType1=(String) ar1.get(2);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(3));
				          GL_OrgId1=Integer.parseInt((String) ar1.get(4));
				 	       
				          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(5));
				          GL_TranType2=(String) ar1.get(6);
				          GL_AmountType2=(String) ar1.get(7);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(8));
				          GL_OrgId2=Integer.parseInt((String) ar1.get(9));
				          
				          
				          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(10));
				          GL_TranType4=(String) ar1.get(11);
				          GL_AmountType4=(String) ar1.get(12);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(13));
				          GL_OrgId4=Integer.parseInt((String) ar1.get(14));
				          
				          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(15));
				          GL_TranType3=(String) ar1.get(16);
				          GL_AmountType3=(String) ar1.get(17);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(18));
				          GL_OrgId3=Integer.parseInt((String) ar1.get(19));
				          
				 	      
				       
				            
				       
				       
				     Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/ODCREDIT_AUTOPOST.properties");
				      prop.setProperty("ODProductName1",GL_ProductName1);
				      prop.setProperty("ODAccountNumber1", GL_AccountNumber1);
				      prop.setProperty("ODDisplayName1",GL_AccDisplayName1);
				      prop.setProperty("ODProductName2",GL_ProductName2);
				      prop.setProperty("ODAccountNumber2", GL_AccountNumber2);
				      prop.setProperty("ODDisplayName2",GL_AccDisplayName2);
				      prop.setProperty("ODBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("ODTransId", String.valueOf(GL_TransId));
				      prop.setProperty("ODTransAmount",GL_TransAmount);
				      prop.setProperty("ODTransferMode",GL_TransferMode);
				      
				      
				      prop.setProperty("ODVoucherNumber1",String.valueOf(GL_VoucherNumber1));
				      prop.setProperty("ODTranType1", GL_TranType1); 
				      prop.setProperty("ODAmountType1",GL_AmountType1);
				      prop.setProperty("ODGlAcCode1",String.valueOf (GL_GlAcCode1)); 
				      prop.setProperty("ODOrgId1",String.valueOf (GL_OrgId1));
				      
				      prop.setProperty("ODVoucherNumber2",String.valueOf(GL_VoucherNumber2));
				      prop.setProperty("ODTranType2", GL_TranType2); 
				      prop.setProperty("ODAmountType2",GL_AmountType2);
				      prop.setProperty("ODGlAcCode2",String.valueOf (GL_GlAcCode2)); 
				      prop.setProperty("ODOrgId2",String.valueOf (GL_OrgId2));
				      
				      prop.setProperty("ODVoucherNumber3",String.valueOf(GL_VoucherNumber3));
				      prop.setProperty("ODTranType3", GL_TranType3); 
				      prop.setProperty("ODAmountType3",GL_AmountType3);
				      prop.setProperty("ODGlAcCode3",String.valueOf (GL_GlAcCode3)); 
				      prop.setProperty("ODOrgId3",String.valueOf (GL_OrgId3));
				      
				      prop.setProperty("ODVoucherNumber4",String.valueOf(GL_VoucherNumber4));
				      prop.setProperty("ODTranType4", GL_TranType4); 
				      prop.setProperty("ODAmountType4",GL_AmountType4);
				      prop.setProperty("ODGlAcCode4",String.valueOf (GL_GlAcCode4)); 
				      prop.setProperty("ODOrgId4",String.valueOf (GL_OrgId4));
				      
				      
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 
 public static void writeODDebit_Cash(WebDriver driver, String propertyValue) {
		
	 
		
		try {
					
					System.out.println("WRITE SUMMARY");
					element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
						
							
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
							
		            Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
					Statement stmt = con.createStatement();	
					           
					           String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
					           ResultSet rs1= stmt.executeQuery(Q_datefetch);
					           while(rs1.next()) {
					            
					        	   GL_TransactionDate=rs1.getString(1);
					        	   GL_ValueDate=rs1.getString(2);
					           }
					 
		           String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
			       ResultSet rs= stmt.executeQuery(Data);
				   System.out.println("SP executed");
				   int row=rs.getRow();
				   ArrayList ar=new ArrayList<>();
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
							
							 	GL_ProductName=(String) ar.get(0);
						      	
						      	GL_AccountNumber=(String) ar.get(1);
							
						      	GL_AccDisplayName=(String) ar.get(2);
								
						      	GL_BatchId=Integer.parseInt((String) ar.get(3));
								
						      	GL_TransId=Integer.parseInt((String) ar.get(4));
								
						      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
								
						      	GL_TranType=(String) ar.get(6);
								
						      	GL_TransAmount=(String) ar.get(7);
							
						      	GL_AmountType=(String) ar.get(8);
							
						      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
								
						      	GL_TransferMode=(String) ar.get(10);
								
						      	GL_OrgId=Integer.parseInt((String) ar.get(11));
						      	
						      	
						      	
						      	
						      	Properties prop=new Properties();
								
								FileOutputStream fos = new FileOutputStream("./DataFiles/ODDEBIT_CASH.properties");
								prop.setProperty("ODproductName",GL_ProductName);
								prop.setProperty("ODAccountNumber", GL_AccountNumber);
								prop.setProperty("ODAccountDisplayName",GL_AccDisplayName);
								prop.setProperty("ODBatchId",String.valueOf(GL_BatchId));
								prop.setProperty("ODTransId", String.valueOf(GL_TransId));
								prop.setProperty("ODVoucherId",String.valueOf(GL_VoucherNumber));
								prop.setProperty("ODTransactionType", GL_TranType);	
								prop.setProperty("ODAmount",GL_TransAmount);
								prop.setProperty("ODAmountType",GL_AmountType);
								prop.setProperty("ODGLAccCode",String.valueOf (GL_GlAcCode));	
								prop.setProperty("ODTransferMode", GL_TransferMode);
								prop.setProperty("ODOrgID",String.valueOf (GL_OrgId));
								
								
						      	
								System.out.println("Written ");
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
 public static void writeODDebit_Batch(WebDriver driver, String propertyValue) {
		
	 
		
		try {
					
					System.out.println("WRITE SUMMARY");
					element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
						
							
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
							
		            Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
					Statement stmt = con.createStatement();	
					           
					           String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
					           ResultSet rs1= stmt.executeQuery(Q_datefetch);
					           while(rs1.next()) {
					            
					        	   GL_TransactionDate=rs1.getString(1);
					        	   GL_ValueDate=rs1.getString(2);
					           }
					     float TotalAmount=0;
						 String Principal=null;
								
								       
								        
								 try {
								        	
								      Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
								      float a= Float.parseFloat(Principal);
								      TotalAmount= a;
								        System.out.println("Total Amount"+TotalAmount);
								       
								        }catch (NumberFormatException e) {
								        	
								        	e.printStackTrace();
								        }
					 
		           String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
			       ResultSet rs= stmt.executeQuery(Data);
				   System.out.println("SP executed");
				   int row=rs.getRow();
				   ArrayList ar=new ArrayList<>();
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
							
							 	GL_ProductName=(String) ar.get(0);
						      	
						      	GL_AccountNumber=(String) ar.get(1);
							
						      	GL_AccDisplayName=(String) ar.get(2);
								
						      	GL_BatchId=Integer.parseInt((String) ar.get(3));
								
						      	GL_TransId=Integer.parseInt((String) ar.get(4));
								
						      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
								
						      	GL_TranType=(String) ar.get(6);
								
						      	GL_TransAmount=(String) ar.get(7);
							
						      	GL_AmountType=(String) ar.get(8);
							
						      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
								
						      	GL_TransferMode=(String) ar.get(10);
								
						      	GL_OrgId=Integer.parseInt((String) ar.get(11));
						      	
						      	
						      	
						      	
						      	Properties prop=new Properties();
								
								FileOutputStream fos = new FileOutputStream("./DataFiles/ODDEBIT_BATCH.properties");
								prop.setProperty("ODproductName",GL_ProductName);
								prop.setProperty("ODAccountNumber", GL_AccountNumber);
								prop.setProperty("ODAccountDisplayName",GL_AccDisplayName);
								prop.setProperty("ODBatchId",String.valueOf(GL_BatchId));
								prop.setProperty("ODTransId", String.valueOf(GL_TransId));
								prop.setProperty("ODVoucherId",String.valueOf(GL_VoucherNumber));
								prop.setProperty("ODTransactionType", GL_TranType);	
								prop.setProperty("ODAmount",GL_TransAmount);
								prop.setProperty("ODAmountType",GL_AmountType);
								prop.setProperty("ODGLAccCode",String.valueOf (GL_GlAcCode));	
								prop.setProperty("ODTransferMode", GL_TransferMode);
								prop.setProperty("ODOrgID",String.valueOf (GL_OrgId));
								prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
								
						      	
								System.out.println("Written ");
								prop.store(fos, "Done");
								fos.close();
									
						}
				}catch(Exception e){
					Driver.tcFlag = "PASS";
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					e.printStackTrace();
				}
			

				}
 public static WebDriver writeODDebit_Autopost(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select distinct  ProductName,AcNo,AcDisplayName from QaFnGetinterbranchSummaryDetails  ("+TransID+")";     
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName1=(String) ar.get(0);
				       GL_AccountNumber1=(String) ar.get(1);
				       GL_AccDisplayName1=(String) ar.get(2);
				       GL_ProductName2=(String) ar.get(3);
				       GL_AccountNumber2=(String) ar.get(4);
				       GL_AccDisplayName2=(String) ar.get(5);  
				       
				   String Data1="select BatchID,TransID,TrnAmount,TrnMode from QaFnGetinterbranchSummaryDetails  ("+TransID+")";
				   ResultSet rslt= stmt.executeQuery(Data1);
				   System.out.println("SP2 EXECUTED");
				   while(rslt.next()) {
			        	
					   GL_BatchId=Integer.parseInt(rslt.getString(1));
					   GL_TransId=Integer.parseInt(rslt.getString(2));
					   GL_TransAmount=rslt.getString(3);
					   GL_TransferMode=rslt.getString(4);
					   
			        }
					   
				         
			 String Data2="select VoucherNo,CrorDr,AmtTypeText,GLAcCode,RespBranchID from QaFnGetinterbranchSummaryDetails ("+TransID+")";
       ResultSet result= stmt.executeQuery(Data2);
       System.out.println("SP3 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(0));
				          GL_TranType4=(String) ar1.get(1);
				          GL_AmountType4=(String) ar1.get(2);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(3));
				          GL_OrgId4=Integer.parseInt((String) ar1.get(4));
				 	       
				          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(5));
				          GL_TranType1=(String) ar1.get(6);
				          GL_AmountType1=(String) ar1.get(7);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(8));
				          GL_OrgId1=Integer.parseInt((String) ar1.get(9));
				          
				          
				          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(10));
				          GL_TranType3=(String) ar1.get(11);
				          GL_AmountType3=(String) ar1.get(12);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(13));
				          GL_OrgId3=Integer.parseInt((String) ar1.get(14));
				          
				          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(15));
				          GL_TranType2=(String) ar1.get(16);
				          GL_AmountType2=(String) ar1.get(17);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(18));
				          GL_OrgId2=Integer.parseInt((String) ar1.get(19));
				          
				 	      
				       
				            
				       
				       
				     Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/ODDEBIT_AUTOPOST.properties");
				      prop.setProperty("ODProductName1",GL_ProductName1);
				      prop.setProperty("ODAccountNumber1", GL_AccountNumber1);
				      prop.setProperty("ODDisplayName1",GL_AccDisplayName1);
				      prop.setProperty("ODProductName2",GL_ProductName2);
				      prop.setProperty("ODAccountNumber2", GL_AccountNumber2);
				      prop.setProperty("ODDisplayName2",GL_AccDisplayName2);
				      prop.setProperty("ODBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("ODTransId", String.valueOf(GL_TransId));
				      prop.setProperty("ODTransAmount",GL_TransAmount);
				      prop.setProperty("ODTransferMode",GL_TransferMode);
				      
				      
				      prop.setProperty("ODVoucherNumber1",String.valueOf(GL_VoucherNumber1));
				      prop.setProperty("ODTranType1", GL_TranType1); 
				      prop.setProperty("ODAmountType1",GL_AmountType1);
				      prop.setProperty("ODGlAcCode1",String.valueOf (GL_GlAcCode1)); 
				      prop.setProperty("ODOrgId1",String.valueOf (GL_OrgId1));
				      
				      prop.setProperty("ODVoucherNumber2",String.valueOf(GL_VoucherNumber2));
				      prop.setProperty("ODTranType2", GL_TranType2); 
				      prop.setProperty("ODAmountType2",GL_AmountType2);
				      prop.setProperty("ODGlAcCode2",String.valueOf (GL_GlAcCode2)); 
				      prop.setProperty("ODOrgId2",String.valueOf (GL_OrgId2));
				      
				      prop.setProperty("ODVoucherNumber3",String.valueOf(GL_VoucherNumber3));
				      prop.setProperty("ODTranType3", GL_TranType3); 
				      prop.setProperty("ODAmountType3",GL_AmountType3);
				      prop.setProperty("ODGlAcCode3",String.valueOf (GL_GlAcCode3)); 
				      prop.setProperty("ODOrgId3",String.valueOf (GL_OrgId3));
				      
				      prop.setProperty("ODVoucherNumber4",String.valueOf(GL_VoucherNumber4));
				      prop.setProperty("ODTranType4", GL_TranType4); 
				      prop.setProperty("ODAmountType4",GL_AmountType4);
				      prop.setProperty("ODGlAcCode4",String.valueOf (GL_GlAcCode4)); 
				      prop.setProperty("ODOrgId4",String.valueOf (GL_OrgId4));
				      
				      
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}

 public static void writeDLCredit_Cash(WebDriver driver, String propertyValue) {
		
	 
		
		try {
					
					System.out.println("WRITE SUMMARY");
					element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
						
							
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
							
		            Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
					Statement stmt = con.createStatement();	
					           
					           String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
					           ResultSet rs1= stmt.executeQuery(Q_datefetch);
					           while(rs1.next()) {
					            
					        	   GL_TransactionDate=rs1.getString(1);
					        	   GL_ValueDate=rs1.getString(2);
					           }
					 
		           String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
			       ResultSet rs= stmt.executeQuery(Data);
				   System.out.println("SP executed");
				   int row=rs.getRow();
				   ArrayList ar=new ArrayList<>();
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
							
							 	GL_ProductName=(String) ar.get(0);
						      	
						      	GL_AccountNumber=(String) ar.get(1);
							
						      	GL_AccDisplayName=(String) ar.get(2);
								
						      	GL_BatchId=Integer.parseInt((String) ar.get(3));
								
						      	GL_TransId=Integer.parseInt((String) ar.get(4));
								
						      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
								
						      	GL_TranType=(String) ar.get(6);
								
						      	GL_TransAmount=(String) ar.get(7);
							
						      	GL_AmountType=(String) ar.get(8);
							
						      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
								
						      	GL_TransferMode=(String) ar.get(10);
								
						      	GL_OrgId=Integer.parseInt((String) ar.get(11));
						      	
						      	
						      	
						      	
						      	Properties prop=new Properties();
								
								FileOutputStream fos = new FileOutputStream("./DataFiles/DLCREDIT_CASH.properties");
								prop.setProperty("DLproductName",GL_ProductName);
								prop.setProperty("DLAccountNumber", GL_AccountNumber);
								prop.setProperty("DLAccountDisplayName",GL_AccDisplayName);
								prop.setProperty("DLBatchId",String.valueOf(GL_BatchId));
								prop.setProperty("DLTransId", String.valueOf(GL_TransId));
								prop.setProperty("DLVoucherId",String.valueOf(GL_VoucherNumber));
								prop.setProperty("DLTransactionType", GL_TranType);	
								prop.setProperty("DLAmount",GL_TransAmount);
								prop.setProperty("DLAmountType",GL_AmountType);
								prop.setProperty("DLGLAccCode",String.valueOf (GL_GlAcCode));	
								prop.setProperty("DLTransferMode", GL_TransferMode);
								prop.setProperty("DLOrgID",String.valueOf (GL_OrgId));
								
								
						      	
								System.out.println("Written ");
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
public static void writeDLCredit_Batch(WebDriver driver, String propertyValue) {
		
	 
		
		try {
					
					System.out.println("WRITE SUMMARY");
					element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
						
							
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
							
		            Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
					Statement stmt = con.createStatement();	
					           
					           String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
					           ResultSet rs1= stmt.executeQuery(Q_datefetch);
					           while(rs1.next()) {
					            
					        	   GL_TransactionDate=rs1.getString(1);
					        	   GL_ValueDate=rs1.getString(2);
					           }
					     float TotalAmount=0;
						 String Principal=null;
								
								       
								        
								 try {
								        	
								      Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
								      float a= Float.parseFloat(Principal);
								      TotalAmount= a;
								        System.out.println("Total Amount"+TotalAmount);
								       
								        }catch (NumberFormatException e) {
								        	
								        	e.printStackTrace();
								        }
					 
		           String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
			       ResultSet rs= stmt.executeQuery(Data);
				   System.out.println("SP executed");
				   int row=rs.getRow();
				   ArrayList ar=new ArrayList<>();
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
							
							 	GL_ProductName=(String) ar.get(0);
						      	
						      	GL_AccountNumber=(String) ar.get(1);
							
						      	GL_AccDisplayName=(String) ar.get(2);
								
						      	GL_BatchId=Integer.parseInt((String) ar.get(3));
								
						      	GL_TransId=Integer.parseInt((String) ar.get(4));
								
						      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
								
						      	GL_TranType=(String) ar.get(6);
								
						      	GL_TransAmount=(String) ar.get(7);
							
						      	GL_AmountType=(String) ar.get(8);
							
						      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
								
						      	GL_TransferMode=(String) ar.get(10);
								
						      	GL_OrgId=Integer.parseInt((String) ar.get(11));
						      	
						      	
						      	
						      	
						      	Properties prop=new Properties();
								
								FileOutputStream fos = new FileOutputStream("./DataFiles/DLCREDIT_BATCH.properties");
								prop.setProperty("DLproductName",GL_ProductName);
								prop.setProperty("DLAccountNumber", GL_AccountNumber);
								prop.setProperty("DLAccountDisplayName",GL_AccDisplayName);
								prop.setProperty("DLBatchId",String.valueOf(GL_BatchId));
								prop.setProperty("DLTransId", String.valueOf(GL_TransId));
								prop.setProperty("DLVoucherId",String.valueOf(GL_VoucherNumber));
								prop.setProperty("DLTransactionType", GL_TranType);	
								prop.setProperty("DLAmount",GL_TransAmount);
								prop.setProperty("DLAmountType",GL_AmountType);
								prop.setProperty("DLGLAccCode",String.valueOf (GL_GlAcCode));	
								prop.setProperty("DLTransferMode", GL_TransferMode);
								prop.setProperty("DLOrgID",String.valueOf (GL_OrgId));
								prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
								
						      	
								System.out.println("Written ");
								prop.store(fos, "Done");
								fos.close();
									
						}
				}catch(Exception e){
					Driver.tcFlag = "PASS";
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					e.printStackTrace();
				}
			

				}
public static void writeGLCredit_Cash(WebDriver driver, String propertyValue) {
	
	 
	
	try {
				
				System.out.println("WRITE SUMMARY");
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
					
						
				String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
				System.out.println("Trans ID "+TransID);
						
	            Connection con=(Connection) Common.DatabaseConnector();
				if(con !=null) {
				Statement stmt = con.createStatement();	
				           
				           String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
				           ResultSet rs1= stmt.executeQuery(Q_datefetch);
				           while(rs1.next()) {
				            
				        	   GL_TransactionDate=rs1.getString(1);
				        	   GL_ValueDate=rs1.getString(2);
				           }
				 
	           String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
		       ResultSet rs= stmt.executeQuery(Data);
			   System.out.println("SP executed");
			   int row=rs.getRow();
			   ArrayList ar=new ArrayList<>();
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
						
						 	GL_ProductName=(String) ar.get(0);
					      	
					      	GL_AccountNumber=(String) ar.get(1);
						
					      	GL_AccDisplayName=(String) ar.get(2);
							
					      	GL_BatchId=Integer.parseInt((String) ar.get(3));
							
					      	GL_TransId=Integer.parseInt((String) ar.get(4));
							
					      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	GL_TranType=(String) ar.get(6);
							
					      	GL_TransAmount=(String) ar.get(7);
						
					      	GL_AmountType=(String) ar.get(8);
						
					      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	GL_TransferMode=(String) ar.get(10);
							
					      	GL_OrgId=Integer.parseInt((String) ar.get(11));
					      	
					      	
					      	
					      	
					      	Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/GLCREDIT_CASH.properties");
							prop.setProperty("GLproductName",GL_ProductName);
							prop.setProperty("GLAccountNumber", GL_AccountNumber);
							prop.setProperty("GLAccountDisplayName",GL_AccDisplayName);
							prop.setProperty("GLBatchId",String.valueOf(GL_BatchId));
							prop.setProperty("GLTransId", String.valueOf(GL_TransId));
							prop.setProperty("GLVoucherId",String.valueOf(GL_VoucherNumber));
							prop.setProperty("GLTransactionType", GL_TranType);	
							prop.setProperty("GLAmount",GL_TransAmount);
							prop.setProperty("GLAmountType",GL_AmountType);
							prop.setProperty("GLGLAccCode",String.valueOf (GL_GlAcCode));	
							prop.setProperty("GLTransferMode", GL_TransferMode);
							prop.setProperty("GLOrgID",String.valueOf (GL_OrgId));
							
							
					      	
							System.out.println("Written ");
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
public static void writeGLCredit_Batch(WebDriver driver, String propertyValue) {
	
 
	
	try {
				
				System.out.println("WRITE SUMMARY");
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
					
						
				String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
				System.out.println("Trans ID "+TransID);
						
	            Connection con=(Connection) Common.DatabaseConnector();
				if(con !=null) {
				Statement stmt = con.createStatement();	
				           
				           String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
				           ResultSet rs1= stmt.executeQuery(Q_datefetch);
				           while(rs1.next()) {
				            
				        	   GL_TransactionDate=rs1.getString(1);
				        	   GL_ValueDate=rs1.getString(2);
				           }
				     float TotalAmount=0;
					 String Principal=null;
							
							       
							        
							 try {
							        	
							      Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
							      float a= Float.parseFloat(Principal);
							      TotalAmount= a;
							        System.out.println("Total Amount"+TotalAmount);
							       
							        }catch (NumberFormatException e) {
							        	
							        	e.printStackTrace();
							        }
				 
	           String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
		       ResultSet rs= stmt.executeQuery(Data);
			   System.out.println("SP executed");
			   int row=rs.getRow();
			   ArrayList ar=new ArrayList<>();
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
						
						 	GL_ProductName=(String) ar.get(0);
					      	
					      	GL_AccountNumber=(String) ar.get(1);
						
					      	GL_AccDisplayName=(String) ar.get(2);
							
					      	GL_BatchId=Integer.parseInt((String) ar.get(3));
							
					      	GL_TransId=Integer.parseInt((String) ar.get(4));
							
					      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	GL_TranType=(String) ar.get(6);
							
					      	GL_TransAmount=(String) ar.get(7);
						
					      	GL_AmountType=(String) ar.get(8);
						
					      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	GL_TransferMode=(String) ar.get(10);
							
					      	GL_OrgId=Integer.parseInt((String) ar.get(11));
					      	
					      	
					      	
					      	
					      	Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/GLCREDIT_BATCH.properties");
							prop.setProperty("GLproductName",GL_ProductName);
							prop.setProperty("GLAccountNumber", GL_AccountNumber);
							prop.setProperty("GLAccountDisplayName",GL_AccDisplayName);
							prop.setProperty("GLBatchId",String.valueOf(GL_BatchId));
							prop.setProperty("GLTransId", String.valueOf(GL_TransId));
							prop.setProperty("GLVoucherId",String.valueOf(GL_VoucherNumber));
							prop.setProperty("GLTransactionType", GL_TranType);	
							prop.setProperty("GLAmount",GL_TransAmount);
							prop.setProperty("GLAmountType",GL_AmountType);
							prop.setProperty("GLGLAccCode",String.valueOf (GL_GlAcCode));	
							prop.setProperty("GLTransferMode", GL_TransferMode);
							prop.setProperty("GLOrgID",String.valueOf (GL_OrgId));
							prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
							
					      	
							System.out.println("Written ");
							prop.store(fos, "Done");
							fos.close();
								
					}
			}catch(Exception e){
				Driver.tcFlag = "PASS";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}
		

			}
public static WebDriver writeGLCredit_Autopost(WebDriver driver, String propertyValue) {
	
	try {
		
		       System.out.println("WRITE SUMMARY");
		       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			
				String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
				System.out.println("Trans ID "+TransID);
				
				Connection con=(Connection) Common.DatabaseConnector();
				if(con !=null) {
		        Statement stmt = con.createStatement();	
		        
		        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
		        ResultSet rs1= stmt.executeQuery(Q_datefetch);
		        System.out.println("FETCHED DATES");
		       
		           while(rs1.next()) {
		        	
		        	   GL_TransactionDate=rs1.getString(1);
		        	   GL_ValueDate=rs1.getString(2);
		           }
		        
		        String Data="select distinct  ProductName,AcNo,AcDisplayName from QaFnGetinterbranchSummaryDetails  ("+TransID+")";     
		        ResultSet rst= stmt.executeQuery(Data); 
		        System.out.println("SP1 EXECUTED");
		       
	                int row=rst.getRow();
			        ArrayList ar=new ArrayList<>();
			        ResultSetMetaData rsmd;
			       
			       try {
			                 rsmd = rst.getMetaData();

			                 int NumOfCol = rsmd.getColumnCount();
			                 
			               

			                 while (rst.next()) {
			                  

			                     for (int i = 1; i <= NumOfCol; i++) {
			                        
			                      ar.add(rst.getString(i));
			                      
			                     }

			                     row++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
			       GL_ProductName1=(String) ar.get(0);
			       GL_AccountNumber1=(String) ar.get(1);
			       GL_AccDisplayName1=(String) ar.get(2);
			       GL_ProductName2=(String) ar.get(3);
			       GL_AccountNumber2=(String) ar.get(4);
			       GL_AccDisplayName2=(String) ar.get(5);  
			       
			   String Data1="select BatchID,TransID,TrnAmount,TrnMode from QaFnGetinterbranchSummaryDetails  ("+TransID+")";
			   ResultSet rslt= stmt.executeQuery(Data1);
			   System.out.println("SP2 EXECUTED");
			   while(rslt.next()) {
		        	
				   GL_BatchId=Integer.parseInt(rslt.getString(1));
				   GL_TransId=Integer.parseInt(rslt.getString(2));
				   GL_TransAmount=rslt.getString(3);
				   GL_TransferMode=rslt.getString(4);
				   
		        }
				   
			         
		 String Data2="select VoucherNo,CrorDr,AmtTypeText,GLAcCode,RespBranchID from QaFnGetinterbranchSummaryDetails ("+TransID+")";
         ResultSet result= stmt.executeQuery(Data2);
         System.out.println("SP3 EXECUTED");
			    int row1=result.getRow();
			    ArrayList ar1=new ArrayList<>();
			      
			       ResultSetMetaData rsmd1;
			       
			       try {
			                 rsmd1 = result.getMetaData();

			                 int NumOfCol1 = rsmd1.getColumnCount();
			                 
			               

			                 while (result.next()) {
			                  

			                     for (int i = 1; i <= NumOfCol1; i++) {
			                        
			                      ar1.add(result.getString(i));
			                      
			                     }

			                     row1++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
			       
			          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(0));
			          GL_TranType4=(String) ar1.get(1);
			          GL_AmountType4=(String) ar1.get(2);
			          GL_GlAcCode4=Integer.parseInt((String) ar1.get(3));
			          GL_OrgId4=Integer.parseInt((String) ar1.get(4));
			 	       
			          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(5));
			          GL_TranType1=(String) ar1.get(6);
			          GL_AmountType1=(String) ar1.get(7);
			          GL_GlAcCode1=Integer.parseInt((String) ar1.get(8));
			          GL_OrgId1=Integer.parseInt((String) ar1.get(9));
			          
			          
			          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(10));
			          GL_TranType3=(String) ar1.get(11);
			          GL_AmountType3=(String) ar1.get(12);
			          GL_GlAcCode3=Integer.parseInt((String) ar1.get(13));
			          GL_OrgId3=Integer.parseInt((String) ar1.get(14));
			          
			          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(15));
			          GL_TranType2=(String) ar1.get(16);
			          GL_AmountType2=(String) ar1.get(17);
			          GL_GlAcCode2=Integer.parseInt((String) ar1.get(18));
			          GL_OrgId2=Integer.parseInt((String) ar1.get(19));
			          
			 	      
			       
			            
			       
			       
			     Properties prop=new Properties();
			      
			      FileOutputStream fos = new FileOutputStream("./DataFiles/GLCREDIT_AUTOPOST.properties");
			      prop.setProperty("GLProductName1",GL_ProductName1);
			      prop.setProperty("GLAccountNumber1", GL_AccountNumber1);
			      prop.setProperty("GLDisplayName1",GL_AccDisplayName1);
			      prop.setProperty("GLProductName2",GL_ProductName2);
			      prop.setProperty("GLAccountNumber2", GL_AccountNumber2);
			      prop.setProperty("GLDisplayName2",GL_AccDisplayName2);
			      prop.setProperty("GLBatchId",String.valueOf(GL_BatchId));
			      prop.setProperty("GLTransId", String.valueOf(GL_TransId));
			      prop.setProperty("GLTransAmount",GL_TransAmount);
			      prop.setProperty("GLTransferMode",GL_TransferMode);
			      
			      
			      prop.setProperty("GLVoucherNumber1",String.valueOf(GL_VoucherNumber1));
			      prop.setProperty("GLTranType1", GL_TranType1); 
			      prop.setProperty("GLAmountType1",GL_AmountType1);
			      prop.setProperty("GLGlAcCode1",String.valueOf (GL_GlAcCode1)); 
			      prop.setProperty("GLOrgId1",String.valueOf (GL_OrgId1));
			      
			      prop.setProperty("GLVoucherNumber2",String.valueOf(GL_VoucherNumber2));
			      prop.setProperty("GLTranType2", GL_TranType2); 
			      prop.setProperty("GLAmountType2",GL_AmountType2);
			      prop.setProperty("GLGlAcCode2",String.valueOf (GL_GlAcCode2)); 
			      prop.setProperty("GLOrgId2",String.valueOf (GL_OrgId2));
			      
			      prop.setProperty("GLVoucherNumber3",String.valueOf(GL_VoucherNumber3));
			      prop.setProperty("GLTranType3", GL_TranType3); 
			      prop.setProperty("GLAmountType3",GL_AmountType3);
			      prop.setProperty("GLGlAcCode3",String.valueOf (GL_GlAcCode3)); 
			      prop.setProperty("GLOrgId3",String.valueOf (GL_OrgId3));
			      
			      prop.setProperty("GLVoucherNumber4",String.valueOf(GL_VoucherNumber4));
			      prop.setProperty("GLTranType4", GL_TranType4); 
			      prop.setProperty("GLAmountType4",GL_AmountType4);
			      prop.setProperty("GLGlAcCode4",String.valueOf (GL_GlAcCode4)); 
			      prop.setProperty("GLOrgId4",String.valueOf (GL_OrgId4));
			      
			      
			      
			      
			     System.out.println("Written ");
				 prop.store(fos, "Done");
				 fos.close();
				        Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
					
				 }
	   }catch(Exception e){
		Driver.tcFlag = "PASS";
		Driver.comment = Driver.objectName + " is not displayed or not identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		e.printStackTrace();
	}
return driver;

	}
public static void writeFDInterestPayment_Cash(WebDriver driver, String propertyValue) {
	
	 
	
	try {
				
				System.out.println("WRITE SUMMARY");
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
					
						
				String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
				System.out.println("Trans ID "+TransID);
						
	            Connection con=(Connection) Common.DatabaseConnector();
				if(con !=null) {
				Statement stmt = con.createStatement();	
				           
				           String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
				           ResultSet rs1= stmt.executeQuery(Q_datefetch);
				           while(rs1.next()) {
				            
				        	   GL_TransactionDate=rs1.getString(1);
				        	   GL_ValueDate=rs1.getString(2);
				           }
				 
	           String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
		       ResultSet rs= stmt.executeQuery(Data);
			   System.out.println("SP executed");
			   int row=rs.getRow();
			   ArrayList ar=new ArrayList<>();
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
						
						 	GL_ProductName=(String) ar.get(0);
					      	
					      	GL_AccountNumber=(String) ar.get(1);
						
					      	GL_AccDisplayName=(String) ar.get(2);
							
					      	GL_BatchId=Integer.parseInt((String) ar.get(3));
							
					      	GL_TransId=Integer.parseInt((String) ar.get(4));
							
					      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	GL_TranType=(String) ar.get(6);
							
					      	GL_TransAmount=(String) ar.get(7);
						
					      	GL_AmountType=(String) ar.get(8);
						
					      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	GL_TransferMode=(String) ar.get(10);
							
					      	GL_OrgId=Integer.parseInt((String) ar.get(11));
					      	
					      	
					      	
					      	
					      	Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/FDINTERESTPAYMENT_CASH.properties");
							prop.setProperty("FDproductName",GL_ProductName);
							prop.setProperty("FDAccountNumber", GL_AccountNumber);
							prop.setProperty("FDAccountDisplayName",GL_AccDisplayName);
							prop.setProperty("FDBatchId",String.valueOf(GL_BatchId));
							prop.setProperty("FDTransId", String.valueOf(GL_TransId));
							prop.setProperty("FDVoucherId",String.valueOf(GL_VoucherNumber));
							prop.setProperty("FDTransactionType", GL_TranType);	
							prop.setProperty("FDAmount",GL_TransAmount);
							prop.setProperty("FDAmountType",GL_AmountType);
							prop.setProperty("FDGLAccCode",String.valueOf (GL_GlAcCode));	
							prop.setProperty("FDTransferMode", GL_TransferMode);
							prop.setProperty("FDOrgID",String.valueOf (GL_OrgId));
							
							
					      	
							System.out.println("Written ");
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
public static void writeFDInterestPayment_Batch(WebDriver driver, String propertyValue) {
	
 
	
	try {
				
				System.out.println("WRITE SUMMARY");
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
					
						
				String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
				System.out.println("Trans ID "+TransID);
						
	            Connection con=(Connection) Common.DatabaseConnector();
				if(con !=null) {
				Statement stmt = con.createStatement();	
				           
				           String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
				           ResultSet rs1= stmt.executeQuery(Q_datefetch);
				           while(rs1.next()) {
				            
				        	   GL_TransactionDate=rs1.getString(1);
				        	   GL_ValueDate=rs1.getString(2);
				           }
				     float TotalAmount=0;
					 String Principal=null;
							
							       
							        
							 try {
							        	
							      Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
							      float a= Float.parseFloat(Principal);
							      TotalAmount= a;
							        System.out.println("Total Amount"+TotalAmount);
							       
							        }catch (NumberFormatException e) {
							        	
							        	e.printStackTrace();
							        }
				 
	           String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
		       ResultSet rs= stmt.executeQuery(Data);
			   System.out.println("SP executed");
			   int row=rs.getRow();
			   ArrayList ar=new ArrayList<>();
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
						
						 	GL_ProductName=(String) ar.get(0);
					      	
					      	GL_AccountNumber=(String) ar.get(1);
						
					      	GL_AccDisplayName=(String) ar.get(2);
							
					      	GL_BatchId=Integer.parseInt((String) ar.get(3));
							
					      	GL_TransId=Integer.parseInt((String) ar.get(4));
							
					      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	GL_TranType=(String) ar.get(6);
							
					      	GL_TransAmount=(String) ar.get(7);
						
					      	GL_AmountType=(String) ar.get(8);
						
					      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	GL_TransferMode=(String) ar.get(10);
							
					      	GL_OrgId=Integer.parseInt((String) ar.get(11));
					      	
					      	
					      	
					      	
					      	Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/FDINTERESTPAYMENT_BATCH.properties");
							prop.setProperty("FDproductName",GL_ProductName);
							prop.setProperty("FDAccountNumber", GL_AccountNumber);
							prop.setProperty("FDAccountDisplayName",GL_AccDisplayName);
							prop.setProperty("FDBatchId",String.valueOf(GL_BatchId));
							prop.setProperty("FDTransId", String.valueOf(GL_TransId));
							prop.setProperty("FDVoucherId",String.valueOf(GL_VoucherNumber));
							prop.setProperty("FDTransactionType", GL_TranType);	
							prop.setProperty("FDAmount",GL_TransAmount);
							prop.setProperty("FDAmountType",GL_AmountType);
							prop.setProperty("FDGLAccCode",String.valueOf (GL_GlAcCode));	
							prop.setProperty("FDTransferMode", GL_TransferMode);
							prop.setProperty("FDOrgID",String.valueOf (GL_OrgId));
							prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
							
					      	
							System.out.println("Written ");
							prop.store(fos, "Done");
							fos.close();
								
					}
			}catch(Exception e){
				Driver.tcFlag = "PASS";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}
		

			}
 public static void WriteFDInterestPayment_Autopost(WebDriver driver, String propertyValue) {
	
	
	 
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
				           while(rs1.next()) {
				            
				        	   GL_TransactionDate=rs1.getString(1);
				        	   GL_ValueDate=rs1.getString(2);
				           }
				   //    System.out.println(CA_TransactionDate +"   "+ CA_ValueDate);
	   String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
		        
                     ResultSet rs= stmt.executeQuery(Data);
						
						System.out.println("SP executed");
						
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
						
						 	GL_ProductName=(String) ar.get(0);
					      	
					      	GL_AccountNumber=(String) ar.get(1);
						
					      	GL_AccDisplayName=(String) ar.get(2);
							
					      	GL_BatchId=Integer.parseInt((String) ar.get(3));
							
					      	GL_TransId=Integer.parseInt((String) ar.get(4));
							
					      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	GL_TranType=(String) ar.get(6);
							
					      	GL_TransAmount=(String) ar.get(7);
						
					      	GL_AmountType=(String) ar.get(8);
						
					      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	GL_TransferMode=(String) ar.get(10);
							
					      	GL_OrgId=Integer.parseInt((String) ar.get(11));
					      	
					      	
					      	Sb_ProductName=(String) ar.get(12);
					      	
					      	Sb_AccountNumber=(String) ar.get(13);
						
					      	Sb_AccDisplayName=(String) ar.get(14);
							
					      	Sb_BatchId=Integer.parseInt((String) ar.get(15));
							
					      	Sb_TransId=Integer.parseInt((String) ar.get(16));
							
					      	Sb_VoucherNumber=Integer.parseInt((String) ar.get(17));
							
					      	Sb_TranType=(String) ar.get(18);
							
					      	Sb_TransAmount=(String) ar.get(19);
						
					      	Sb_AmountType=(String) ar.get(20);
						
					      	Sb_GlAcCode=Integer.parseInt((String) ar.get(21));
							
					      	Sb_TransferMode=(String) ar.get(22);
							
					      	Sb_OrgId=Integer.parseInt((String) ar.get(23));
					
					      	
					      	
					
					      	
					      	
					      	Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/FDINTERESTPAYMENT_AUTOPOST.properties");
							prop.setProperty("SLproductName",GL_ProductName);
							prop.setProperty("SLAccountNumber", GL_AccountNumber);
							prop.setProperty("SLAccountDisplayName",GL_AccDisplayName);
							prop.setProperty("SLBatchId",String.valueOf(GL_BatchId));
							prop.setProperty("SLTransId", String.valueOf(GL_TransId));
							prop.setProperty("SLVoucherId",String.valueOf(GL_VoucherNumber));
							prop.setProperty("SLTransactionType", GL_TranType);	
							prop.setProperty("SLAmount",GL_TransAmount);
							prop.setProperty("SLAmountType",GL_AmountType);
							prop.setProperty("SLGLAccCode",String.valueOf (GL_GlAcCode));	
							prop.setProperty("SLTransferMode", GL_TransferMode);
							prop.setProperty("SLOrgID",String.valueOf (GL_OrgId));
							
							
							
							prop.setProperty("SBProductName", Sb_ProductName);
							prop.setProperty("SBAccountNumber", Sb_AccountNumber);
							prop.setProperty("SBAccountDispalyName", Sb_AccDisplayName);
							prop.setProperty("SBBatchId", String.valueOf (Sb_BatchId));
							prop.setProperty("SBTransactionId",String.valueOf ( Sb_TransId));
							prop.setProperty("SBVoucherNumber",String.valueOf ( Sb_VoucherNumber));
							prop.setProperty("SBTransType", Sb_TranType);
							prop.setProperty("SBTransAmount", Sb_TransAmount);
							prop.setProperty("SBAmountType", Sb_AmountType);
							prop.setProperty("SBGLAcCode", String.valueOf (Sb_GlAcCode));
							prop.setProperty("SBTransactionMode", Sb_TransferMode);
							prop.setProperty("SBOrgID",String.valueOf ( Sb_OrgId));
					      	
							System.out.println("Written ");
							prop.store(fos, "Done");
							fos.close();
								
					}
			}catch(Exception e){
				Driver.tcFlag = "PASS";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}
		

			}
 public static WebDriver writeSBAccClosure_Cash(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE SB ACCOUNT CLOSURE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName=(String) ar.get(6);
				       GL_AccountNumber=(String) ar.get(7);
				       GL_AccDisplayName=(String) ar.get(8);
				       GL_BatchId=Integer.parseInt((String) ar.get(9));
					   GL_TransId=Integer.parseInt((String) ar.get(10));
					   GL_OrgId=Integer.parseInt((String) ar.get(11));
				        
				       
			 String Data2="select VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode from QaFnGetSummaryDetails ("+TransID+")";
	         ResultSet result= stmt.executeQuery(Data2);
	         System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(0));
				          GL_TranType1=(String) ar1.get(1);
				          GL_TransAmount1=(String) ar1.get(2);
				          GL_AmountType1=(String) ar1.get(3);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(4));
				          GL_TransferMode1=(String) ar1.get(5);
				          
				          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(6));
				          GL_TranType3=(String) ar1.get(7);
				          GL_TransAmount3=(String) ar1.get(8);
				          GL_AmountType3=(String) ar1.get(9);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(10));
				          GL_TransferMode3=(String) ar1.get(11);
				          
				          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(12));
				          GL_TranType2=(String) ar1.get(13);
				          GL_TransAmount2=(String) ar1.get(14);
				          GL_AmountType2=(String) ar1.get(15);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(16));
				          GL_TransferMode2=(String) ar1.get(17);
				 	       
				          
				          
				 	      
				      Properties prop=new Properties();
				      FileOutputStream fos = new FileOutputStream("./DataFiles/SBACC_CLOSURE_CASH.properties");
				      
				      prop.setProperty("SBProductName",GL_ProductName);
				      prop.setProperty("SBAccountNumber", GL_AccountNumber);
				      prop.setProperty("SBDisplayName",GL_AccDisplayName);
				      prop.setProperty("SBBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("SBTransId", String.valueOf(GL_TransId));
				      prop.setProperty("SBOrgId",String.valueOf (GL_OrgId));
				      
				      
				      prop.setProperty("SBVoucherNumber1",String.valueOf(GL_VoucherNumber1));
				      prop.setProperty("SBTranType1", GL_TranType1); 
				      prop.setProperty("SBTransAmount1",GL_TransAmount1);
				      prop.setProperty("SBAmountType1",GL_AmountType1);
				      prop.setProperty("SBGlAcCode1",String.valueOf (GL_GlAcCode1));
				      prop.setProperty("SBTransferMode1",GL_TransferMode1);
				      
				      
				      prop.setProperty("SBVoucherNumber2",String.valueOf(GL_VoucherNumber2));
				      prop.setProperty("SBTranType2", GL_TranType2); 
				      prop.setProperty("SBTransAmount2",GL_TransAmount2);
				      prop.setProperty("SBAmountType2",GL_AmountType2);
				      prop.setProperty("SBGlAcCode2",String.valueOf (GL_GlAcCode2));
				      prop.setProperty("SBTransferMode2",GL_TransferMode2);
				      
				      
				      prop.setProperty("SBVoucherNumber3",String.valueOf(GL_VoucherNumber3));
				      prop.setProperty("SBTranType3", GL_TranType3); 
				      prop.setProperty("SBTransAmount3",GL_TransAmount3);
				      prop.setProperty("SBAmountType3",GL_AmountType3);
				      prop.setProperty("SBGlAcCode3",String.valueOf (GL_GlAcCode3));
				      prop.setProperty("SBTransferMode3",GL_TransferMode3);
				      
				      
				      
				      
				      
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 public static WebDriver writeSBAccClosure_Batch(WebDriver driver, String propertyValue) {
		
		try {
			
			  System.out.println("WRITE SB ACCOUNT CLOSURE SUMMARY");
			  element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			  String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
			  System.out.println("Trans ID "+TransID);
					
				Connection con=(Connection) Common.DatabaseConnector();
				if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			            }
			             float TotalAmount=0;
					     String Principal=null;
							try {
								  Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[3]/td[9]")).getText();
								  float a= Float.parseFloat(Principal);
								  TotalAmount= a;
								   System.out.println("Total Amount"+TotalAmount);
								       
								        }catch (NumberFormatException e) {
								        	
								        	e.printStackTrace();
								        }
			        
			        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName=(String) ar.get(6);
				       GL_AccountNumber=(String) ar.get(7);
				       GL_AccDisplayName=(String) ar.get(8);
				       GL_BatchId=Integer.parseInt((String) ar.get(9));
					   GL_TransId=Integer.parseInt((String) ar.get(10));
					   GL_OrgId=Integer.parseInt((String) ar.get(11));
				        
				       
			 String Data2="select VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode from QaFnGetSummaryDetails ("+TransID+")";
	         ResultSet result= stmt.executeQuery(Data2);
	         System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(0));
				          GL_TranType1=(String) ar1.get(1);
				          GL_TransAmount1=(String) ar1.get(2);
				          GL_AmountType1=(String) ar1.get(3);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(4));
				          GL_TransferMode1=(String) ar1.get(5);
				          
				          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(6));
				          GL_TranType3=(String) ar1.get(7);
				          GL_TransAmount3=(String) ar1.get(8);
				          GL_AmountType3=(String) ar1.get(9);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(10));
				          GL_TransferMode3=(String) ar1.get(11);
				          
				          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(12));
				          GL_TranType2=(String) ar1.get(13);
				          GL_TransAmount2=(String) ar1.get(14);
				          GL_AmountType2=(String) ar1.get(15);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(16));
				          GL_TransferMode2=(String) ar1.get(17);
				 	       
				          
				          
				 	      
				      Properties prop=new Properties();
				      FileOutputStream fos = new FileOutputStream("./DataFiles/SBACC_CLOSURE_BATCH.properties");
				      
				      prop.setProperty("SBProductName",GL_ProductName);
				      prop.setProperty("SBAccountNumber", GL_AccountNumber);
				      prop.setProperty("SBAccountDisplayName",GL_AccDisplayName);
				      prop.setProperty("SBBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("SBTransId", String.valueOf(GL_TransId));
				      prop.setProperty("SBOrgId",String.valueOf (GL_OrgId));
				      
				      
				      prop.setProperty("SBVoucherNumber1",String.valueOf(GL_VoucherNumber1));
				      prop.setProperty("SBTranType1", GL_TranType1); 
				      prop.setProperty("SBTransAmount1",GL_TransAmount1);
				      prop.setProperty("SBAmountType1",GL_AmountType1);
				      prop.setProperty("SBGlAcCode1",String.valueOf (GL_GlAcCode1));
				      prop.setProperty("SBTransferMode1",GL_TransferMode1);
				      
				      
				      prop.setProperty("SBVoucherNumber2",String.valueOf(GL_VoucherNumber2));
				      prop.setProperty("SBTranType2", GL_TranType2); 
				      prop.setProperty("SBTransAmount2",GL_TransAmount2);
				      prop.setProperty("SBAmountType2",GL_AmountType2);
				      prop.setProperty("SBGlAcCode2",String.valueOf (GL_GlAcCode2));
				      prop.setProperty("SBTransferMode2",GL_TransferMode2);
				      
				      
				      prop.setProperty("SBVoucherNumber3",String.valueOf(GL_VoucherNumber3));
				      prop.setProperty("SBTranType3", GL_TranType3); 
				      prop.setProperty("SBTransAmount3",GL_TransAmount3);
				      prop.setProperty("SBAmountType3",GL_AmountType3);
				      prop.setProperty("SBGlAcCode3",String.valueOf (GL_GlAcCode3));
				      prop.setProperty("SBTransferMode3",GL_TransferMode3);
				      
				      prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
				      
				      
				      
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 public static WebDriver WriteSBAccountClosure_Autopost(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE SB ACCOUNT CLOSURE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName=(String) ar.get(21);
				       GL_AccountNumber=(String) ar.get(22);
				       GL_AccDisplayName=(String) ar.get(23);
				       GL_BatchId=Integer.parseInt((String) ar.get(24));
					   GL_TransId=Integer.parseInt((String) ar.get(25));
					   GL_TransferMode=(String) ar.get(26);
					   GL_OrgId=Integer.parseInt((String) ar.get(27));
				        
				       
			 String Data2="select VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
	         ResultSet result= stmt.executeQuery(Data2);
	         System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(0));
				          GL_TranType1=(String) ar1.get(1);
				          GL_TransAmount1=(String) ar1.get(2);
				          GL_AmountType1=(String) ar1.get(3);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(4));
				         
				          
				          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(5));
				          GL_TranType2=(String) ar1.get(6);
				          GL_TransAmount2=(String) ar1.get(7);
				          GL_AmountType2=(String) ar1.get(8);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(9));
				          
				          
				          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(10));
				          GL_TranType4=(String) ar1.get(11);
				          GL_TransAmount4=(String) ar1.get(12);
				          GL_AmountType4=(String) ar1.get(13);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(14));
				          
				          
				          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(15));
				          GL_TranType3=(String) ar1.get(16);
				          GL_TransAmount3=(String) ar1.get(17);
				          GL_AmountType3=(String) ar1.get(18);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(19));
				         
				 	       
				          
				          
				 	      
				      Properties prop=new Properties();
				      FileOutputStream fos = new FileOutputStream("./DataFiles/SBACC_CLOSURE_AUTOPOST.properties");
				      
				      prop.setProperty("SBProductName",GL_ProductName);
				      prop.setProperty("SBAccountNumber", GL_AccountNumber);
				      prop.setProperty("SBDisplayName",GL_AccDisplayName);
				      prop.setProperty("SBBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("SBTransId", String.valueOf(GL_TransId));
				      prop.setProperty("SBTransferMode",GL_TransferMode);
				      prop.setProperty("SBOrgId",String.valueOf (GL_OrgId));
				      
				      
				      prop.setProperty("SBVoucherNumber1",String.valueOf(GL_VoucherNumber1));
				      prop.setProperty("SBTranType1", GL_TranType1); 
				      prop.setProperty("SBTransAmount1",GL_TransAmount1);
				      prop.setProperty("SBAmountType1",GL_AmountType1);
				      prop.setProperty("SBGlAcCode1",String.valueOf (GL_GlAcCode1));
				      
				      prop.setProperty("SBVoucherNumber2",String.valueOf(GL_VoucherNumber2));
				      prop.setProperty("SBTranType2", GL_TranType2); 
				      prop.setProperty("SBTransAmount2",GL_TransAmount2);
				      prop.setProperty("SBAmountType2",GL_AmountType2);
				      prop.setProperty("SBGlAcCode2",String.valueOf (GL_GlAcCode2));
				      
				      
				      prop.setProperty("SBVoucherNumber3",String.valueOf(GL_VoucherNumber3));
				      prop.setProperty("SBTranType3", GL_TranType3); 
				      prop.setProperty("SBTransAmount3",GL_TransAmount3);
				      prop.setProperty("SBAmountType3",GL_AmountType3);
				      prop.setProperty("SBGlAcCode3",String.valueOf (GL_GlAcCode3));
				      
				      
				      prop.setProperty("SBVoucherNumber4",String.valueOf(GL_VoucherNumber4));
				      prop.setProperty("SBTranType4", GL_TranType4); 
				      prop.setProperty("SBTransAmount4",GL_TransAmount4);
				      prop.setProperty("SBAmountType4",GL_AmountType4);
				      prop.setProperty("SBGlAcCode4",String.valueOf (GL_GlAcCode4));
				     
				      
				      
				      
				      
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 
 public static WebDriver writeFDAccClosure_Cash(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE FD ACCOUNT CLOSURE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName=(String) ar.get(0);
				       GL_AccountNumber=(String) ar.get(1);
				       GL_AccDisplayName=(String) ar.get(2);
				       GL_BatchId=Integer.parseInt((String) ar.get(3));
					   GL_TransId=Integer.parseInt((String) ar.get(4));
					   GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
				       GL_TranType=(String) ar.get(6);
					   GL_TransferMode=(String) ar.get(7);
					   GL_OrgId=Integer.parseInt((String) ar.get(8));
				        
				       
			 String Data2="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
	         ResultSet result= stmt.executeQuery(Data2);
	         System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          
				          GL_TransAmount1=(String) ar1.get(0);
				          GL_AmountType1=(String) ar1.get(1);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
				         
				          
				          GL_TransAmount2=(String) ar1.get(3);
				          GL_AmountType2=(String) ar1.get(4);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
				          
				          
				          
				      Properties prop=new Properties();
				      FileOutputStream fos = new FileOutputStream("./DataFiles/FDACC_CLOSURE_CASH.properties");
				      
				      prop.setProperty("FDProductName",GL_ProductName);
				      prop.setProperty("FDAccountNumber", GL_AccountNumber);
				      prop.setProperty("FDDisplayName",GL_AccDisplayName);
				      prop.setProperty("FDBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("FDTransId", String.valueOf(GL_TransId));
				      prop.setProperty("FDVoucherNumber",String.valueOf(GL_VoucherNumber));
				      prop.setProperty("FDTranType", GL_TranType); 
				      prop.setProperty("FDTransferMode",GL_TransferMode);
				      prop.setProperty("FDOrgId",String.valueOf (GL_OrgId));
				      
				      prop.setProperty("FDTransAmount1",GL_TransAmount1);
				      prop.setProperty("FDAmountType1",GL_AmountType1);
				      prop.setProperty("FDGlAcCode1",String.valueOf (GL_GlAcCode1));
				      
				      prop.setProperty("FDTransAmount2",GL_TransAmount2);
				      prop.setProperty("FDAmountType2",GL_AmountType2);
				      prop.setProperty("FDGlAcCode2",String.valueOf (GL_GlAcCode2));
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 public static WebDriver writeFDAccClosure_Batch(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE FD ACCOUNT CLOSURE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			         float TotalAmount=0;
					 String Principal=null;
					 String Interest=null;
							try {
								  Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
								  Interest=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[3]/td[9]")).getText();
								  float a= Float.parseFloat(Principal);
								  float b= Float.parseFloat(Interest);
								  TotalAmount= a+b;
								   System.out.println("Total Amount"+TotalAmount);
								       
								        }catch (NumberFormatException e) {
								        	
								        	e.printStackTrace();
								        }
			        
			        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName=(String) ar.get(0);
				       GL_AccountNumber=(String) ar.get(1);
				       GL_AccDisplayName=(String) ar.get(2);
				       GL_BatchId=Integer.parseInt((String) ar.get(3));
					   GL_TransId=Integer.parseInt((String) ar.get(4));
					   GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
				       GL_TranType=(String) ar.get(6);
					   GL_TransferMode=(String) ar.get(7);
					   GL_OrgId=Integer.parseInt((String) ar.get(8));
				        
				       
			 String Data2="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
	         ResultSet result= stmt.executeQuery(Data2);
	         System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          
				          GL_TransAmount1=(String) ar1.get(0);
				          GL_AmountType1=(String) ar1.get(1);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
				         
				          
				          GL_TransAmount2=(String) ar1.get(3);
				          GL_AmountType2=(String) ar1.get(4);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
				          
				          
				          
				      Properties prop=new Properties();
				      FileOutputStream fos = new FileOutputStream("./DataFiles/FDACC_CLOSURE_BATCH.properties");
				      
				      prop.setProperty("FDProductName",GL_ProductName);
				      prop.setProperty("FDAccountNumber", GL_AccountNumber);
				      prop.setProperty("FDDisplayName",GL_AccDisplayName);
				      prop.setProperty("FDBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("FDTransId", String.valueOf(GL_TransId));
				      prop.setProperty("FDVoucherNumber",String.valueOf(GL_VoucherNumber));
				      prop.setProperty("FDTranType", GL_TranType); 
				      prop.setProperty("FDTransferMode",GL_TransferMode);
				      prop.setProperty("FDOrgId",String.valueOf (GL_OrgId));
				      
				      prop.setProperty("FDTransAmount1",GL_TransAmount1);
				      prop.setProperty("FDAmountType1",GL_AmountType1);
				      prop.setProperty("FDGlAcCode1",String.valueOf (GL_GlAcCode1));
				      
				      prop.setProperty("FDTransAmount2",GL_TransAmount2);
				      prop.setProperty("FDAmountType2",GL_AmountType2);
				      prop.setProperty("FDGlAcCode2",String.valueOf (GL_GlAcCode2));
				      
				      prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 
 public static WebDriver writeFDAccountClosure_Autopost(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select distinct  ProductName,AcNo,AcDisplayName from QaFnGetinterbranchSummaryDetails  ("+TransID+")";     
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName2=(String) ar.get(0);
				       GL_AccountNumber2=(String) ar.get(1);
				       GL_AccDisplayName2=(String) ar.get(2); 
				       GL_ProductName1=(String) ar.get(3);
				       GL_AccountNumber1=(String) ar.get(4);
				       GL_AccDisplayName1=(String) ar.get(5); 
				        
				       
				   String Data1="select BatchID,TransID,TrnAmount,TrnMode from QaFnGetinterbranchSummaryDetails  ("+TransID+")";
				   ResultSet rslt= stmt.executeQuery(Data1);
				   System.out.println("SP2 EXECUTED");
				   while(rslt.next()) {
					   
					    
					   GL_BatchId=Integer.parseInt(rslt.getString(1));
					   GL_TransId=Integer.parseInt(rslt.getString(2));
					   GL_TransAmount=rslt.getString(3);
					   GL_TransferMode=rslt.getString(4);
					   
			        }
					   
				         
	           String Data2="select VoucherNo,CrorDr,AmtTypeText,GLAcCode,RespBranchID from QaFnGetinterbranchSummaryDetails ("+TransID+")";
               ResultSet result= stmt.executeQuery(Data2);
               System.out.println("SP3 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          
				          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(0));
				          GL_TranType1=(String) ar1.get(1);
				          GL_AmountType1=(String) ar1.get(2);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(3));
				          GL_OrgId1=Integer.parseInt((String) ar1.get(4));
				 	       
				          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(5));
				          GL_TranType2=(String) ar1.get(6);
				          GL_AmountType2=(String) ar1.get(7);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(8));
				          GL_OrgId2=Integer.parseInt((String) ar1.get(9));
				          
				          GL_VoucherNumber5=Integer.parseInt((String) ar1.get(10));
				          GL_TranType5=(String) ar1.get(11);
				          GL_AmountType5=(String) ar1.get(12);
				          GL_GlAcCode5=Integer.parseInt((String) ar1.get(13));
				          GL_OrgId5=Integer.parseInt((String) ar1.get(14));
				          
				          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(15));
				          GL_TranType4=(String) ar1.get(16);
				          GL_AmountType4=(String) ar1.get(17);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(18));
				          GL_OrgId4=Integer.parseInt((String) ar1.get(19));
				          
				          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(20));
				          GL_TranType3=(String) ar1.get(21);
				          GL_AmountType3=(String) ar1.get(22);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(23));
				          GL_OrgId3=Integer.parseInt((String) ar1.get(24));    
				 	      
				       
				            
				       
				       
				     Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/FDACC_CLOSURE_AUTOPOST.properties");
				      prop.setProperty("FDProductName1",GL_ProductName1);
				      prop.setProperty("FDAccountNumber1", GL_AccountNumber1);
				      prop.setProperty("FDDisplayName1",GL_AccDisplayName1);
				      prop.setProperty("FDProductName2",GL_ProductName2);
				      prop.setProperty("FDAccountNumber2", GL_AccountNumber2);
				      prop.setProperty("FDDisplayName2",GL_AccDisplayName2);
				      prop.setProperty("FDBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("FDTransId", String.valueOf(GL_TransId));
				      prop.setProperty("FDTransAmount",GL_TransAmount);
				      prop.setProperty("FDTransferMode",GL_TransferMode);
				      
				      
				      prop.setProperty("FDVoucherNumber1",String.valueOf(GL_VoucherNumber1));
				      prop.setProperty("FDTranType1", GL_TranType1); 
				      prop.setProperty("FDAmountType1",GL_AmountType1);
				      prop.setProperty("FDGlAcCode1",String.valueOf (GL_GlAcCode1)); 
				      prop.setProperty("FDOrgId1",String.valueOf (GL_OrgId1));
				      
				      prop.setProperty("FDVoucherNumber2",String.valueOf(GL_VoucherNumber2));
				      prop.setProperty("FDTranType2", GL_TranType2); 
				      prop.setProperty("FDAmountType2",GL_AmountType2);
				      prop.setProperty("FDGlAcCode2",String.valueOf (GL_GlAcCode2)); 
				      prop.setProperty("FDOrgId2",String.valueOf (GL_OrgId2));
				      
				      prop.setProperty("FDVoucherNumber3",String.valueOf(GL_VoucherNumber3));
				      prop.setProperty("FDTranType3", GL_TranType3); 
				      prop.setProperty("FDAmountType3",GL_AmountType3);
				      prop.setProperty("FDGlAcCode3",String.valueOf (GL_GlAcCode3)); 
				      prop.setProperty("FDOrgId3",String.valueOf (GL_OrgId3));
				      
				      prop.setProperty("FDVoucherNumber4",String.valueOf(GL_VoucherNumber4));
				      prop.setProperty("FDTranType4", GL_TranType4); 
				      prop.setProperty("FDAmountType4",GL_AmountType4);
				      prop.setProperty("FDGlAcCode4",String.valueOf (GL_GlAcCode4)); 
				      prop.setProperty("FDOrgId4",String.valueOf (GL_OrgId4));
				      
				      prop.setProperty("FDVoucherNumber5",String.valueOf(GL_VoucherNumber5));
				      prop.setProperty("FDTranType5", GL_TranType5); 
				      prop.setProperty("FDAmountType5",GL_AmountType5);
				      prop.setProperty("FDGlAcCode5",String.valueOf (GL_GlAcCode5)); 
				      prop.setProperty("FDOrgId5",String.valueOf (GL_OrgId5));
				      
				      
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 public static WebDriver writeRDAccClosure_Cash(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE FD ACCOUNT CLOSURE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName=(String) ar.get(0);
				       GL_AccountNumber=(String) ar.get(1);
				       GL_AccDisplayName=(String) ar.get(2);
				       GL_BatchId=Integer.parseInt((String) ar.get(3));
					   GL_TransId=Integer.parseInt((String) ar.get(4));
					   GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
				       GL_TranType=(String) ar.get(6);
					   GL_TransferMode=(String) ar.get(7);
					   GL_OrgId=Integer.parseInt((String) ar.get(8));
				        
				       
			 String Data2="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
	         ResultSet result= stmt.executeQuery(Data2);
	         System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          
				          GL_TransAmount1=(String) ar1.get(0);
				          GL_AmountType1=(String) ar1.get(1);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
				         
				          
				          GL_TransAmount2=(String) ar1.get(3);
				          GL_AmountType2=(String) ar1.get(4);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
				          
				          
				          
				      Properties prop=new Properties();
				      FileOutputStream fos = new FileOutputStream("./DataFiles/RDACC_CLOSURE_CASH.properties");
				      
				      prop.setProperty("FDProductName",GL_ProductName);
				      prop.setProperty("FDAccountNumber", GL_AccountNumber);
				      prop.setProperty("FDDisplayName",GL_AccDisplayName);
				      prop.setProperty("FDBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("FDTransId", String.valueOf(GL_TransId));
				      prop.setProperty("FDVoucherNumber",String.valueOf(GL_VoucherNumber));
				      prop.setProperty("FDTranType", GL_TranType); 
				      prop.setProperty("FDTransferMode",GL_TransferMode);
				      prop.setProperty("FDOrgId",String.valueOf (GL_OrgId));
				      
				      prop.setProperty("FDTransAmount1",GL_TransAmount1);
				      prop.setProperty("FDAmountType1",GL_AmountType1);
				      prop.setProperty("FDGlAcCode1",String.valueOf (GL_GlAcCode1));
				      
				      prop.setProperty("FDTransAmount2",GL_TransAmount2);
				      prop.setProperty("FDAmountType2",GL_AmountType2);
				      prop.setProperty("FDGlAcCode2",String.valueOf (GL_GlAcCode2));
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
public static WebDriver writeRDAccClosure_Batch(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE FD ACCOUNT CLOSURE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			         float TotalAmount=0;
					 String Principal=null;
					 String Interest=null;
							try {
								  Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
								  Interest=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[3]/td[9]")).getText();
								  float a= Float.parseFloat(Principal);
								  float b= Float.parseFloat(Interest);
								  TotalAmount= a+b;
								   System.out.println("Total Amount"+TotalAmount);
								       
								        }catch (NumberFormatException e) {
								        	
								        	e.printStackTrace();
								        }
			        
			        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName=(String) ar.get(0);
				       GL_AccountNumber=(String) ar.get(1);
				       GL_AccDisplayName=(String) ar.get(2);
				       GL_BatchId=Integer.parseInt((String) ar.get(3));
					   GL_TransId=Integer.parseInt((String) ar.get(4));
					   GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
				       GL_TranType=(String) ar.get(6);
					   GL_TransferMode=(String) ar.get(7);
					   GL_OrgId=Integer.parseInt((String) ar.get(8));
				        
				       
			 String Data2="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
	         ResultSet result= stmt.executeQuery(Data2);
	         System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				   
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          
				          GL_TransAmount1=(String) ar1.get(0);
				          GL_AmountType1=(String) ar1.get(1);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
				         
				          
				          GL_TransAmount2=(String) ar1.get(3);
				          GL_AmountType2=(String) ar1.get(4);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
				          
				          
				          
				      Properties prop=new Properties();
				      FileOutputStream fos = new FileOutputStream("./DataFiles/RDACC_CLOSURE_BATCH.properties");
				      
				      prop.setProperty("FDProductName",GL_ProductName);
				      prop.setProperty("FDAccountNumber", GL_AccountNumber);
				      prop.setProperty("FDDisplayName",GL_AccDisplayName);
				      prop.setProperty("FDBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("FDTransId", String.valueOf(GL_TransId));
				      prop.setProperty("FDVoucherNumber",String.valueOf(GL_VoucherNumber));
				      prop.setProperty("FDTranType", GL_TranType); 
				      prop.setProperty("FDTransferMode",GL_TransferMode);
				      prop.setProperty("FDOrgId",String.valueOf (GL_OrgId));
				      
				      prop.setProperty("FDTransAmount1",GL_TransAmount1);
				      prop.setProperty("FDAmountType1",GL_AmountType1);
				      prop.setProperty("FDGlAcCode1",String.valueOf (GL_GlAcCode1));
				      
				      prop.setProperty("FDTransAmount2",GL_TransAmount2);
				      prop.setProperty("FDAmountType2",GL_AmountType2);
				      prop.setProperty("FDGlAcCode2",String.valueOf (GL_GlAcCode2));
				      
				      prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

}
public static WebDriver writeRDAccountClosure_Autopost(WebDriver driver, String propertyValue) {
	
	try {
		
		       System.out.println("WRITE SUMMARY");
		       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			
				String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
				System.out.println("Trans ID "+TransID);
				
				Connection con=(Connection) Common.DatabaseConnector();
				if(con !=null) {
		        Statement stmt = con.createStatement();	
		        
		        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
		        ResultSet rs1= stmt.executeQuery(Q_datefetch);
		        System.out.println("FETCHED DATES");
		       
		           while(rs1.next()) {
		        	
		        	   GL_TransactionDate=rs1.getString(1);
		        	   GL_ValueDate=rs1.getString(2);
		           }
		        
		        String Data="select distinct  ProductName,AcNo,AcDisplayName from QaFnGetinterbranchSummaryDetails  ("+TransID+")";     
		        ResultSet rst= stmt.executeQuery(Data); 
		        System.out.println("SP1 EXECUTED");
		       
	                int row=rst.getRow();
			        ArrayList ar=new ArrayList<>();
			        ResultSetMetaData rsmd;
			       
			       try {
			                 rsmd = rst.getMetaData();

			                 int NumOfCol = rsmd.getColumnCount();
			                 
			               

			                 while (rst.next()) {
			                  

			                     for (int i = 1; i <= NumOfCol; i++) {
			                        
			                      ar.add(rst.getString(i));
			                      
			                     }

			                     row++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
			       GL_ProductName2=(String) ar.get(0);
			       GL_AccountNumber2=(String) ar.get(1);
			       GL_AccDisplayName2=(String) ar.get(2); 
			       GL_ProductName1=(String) ar.get(3);
			       GL_AccountNumber1=(String) ar.get(4);
			       GL_AccDisplayName1=(String) ar.get(5); 
			        
			       
			   String Data1="select BatchID,TransID,TrnAmount,TrnMode from QaFnGetinterbranchSummaryDetails  ("+TransID+")";
			   ResultSet rslt= stmt.executeQuery(Data1);
			   System.out.println("SP2 EXECUTED");
			   while(rslt.next()) {
				   
				    
				   GL_BatchId=Integer.parseInt(rslt.getString(1));
				   GL_TransId=Integer.parseInt(rslt.getString(2));
				   GL_TransAmount=rslt.getString(3);
				   GL_TransferMode=rslt.getString(4);
				   
		        }
				   
			         
           String Data2="select VoucherNo,CrorDr,AmtTypeText,GLAcCode,RespBranchID from QaFnGetinterbranchSummaryDetails ("+TransID+")";
           ResultSet result= stmt.executeQuery(Data2);
           System.out.println("SP3 EXECUTED");
			    int row1=result.getRow();
			    ArrayList ar1=new ArrayList<>();
			      
			       ResultSetMetaData rsmd1;
			       
			       try {
			                 rsmd1 = result.getMetaData();

			                 int NumOfCol1 = rsmd1.getColumnCount();
			                 
			               

			                 while (result.next()) {
			                  

			                     for (int i = 1; i <= NumOfCol1; i++) {
			                        
			                      ar1.add(result.getString(i));
			                      
			                     }

			                     row1++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
			       
			          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(0));
			          GL_TranType1=(String) ar1.get(1);
			          GL_AmountType1=(String) ar1.get(2);
			          GL_GlAcCode1=Integer.parseInt((String) ar1.get(3));
			          GL_OrgId1=Integer.parseInt((String) ar1.get(4));
			 	       
			          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(5));
			          GL_TranType2=(String) ar1.get(6);
			          GL_AmountType2=(String) ar1.get(7);
			          GL_GlAcCode2=Integer.parseInt((String) ar1.get(8));
			          GL_OrgId2=Integer.parseInt((String) ar1.get(9));
			          
			          GL_VoucherNumber5=Integer.parseInt((String) ar1.get(10));
			          GL_TranType5=(String) ar1.get(11);
			          GL_AmountType5=(String) ar1.get(12);
			          GL_GlAcCode5=Integer.parseInt((String) ar1.get(13));
			          GL_OrgId5=Integer.parseInt((String) ar1.get(14));
			          
			          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(15));
			          GL_TranType4=(String) ar1.get(16);
			          GL_AmountType4=(String) ar1.get(17);
			          GL_GlAcCode4=Integer.parseInt((String) ar1.get(18));
			          GL_OrgId4=Integer.parseInt((String) ar1.get(19));
			          
			          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(20));
			          GL_TranType3=(String) ar1.get(21);
			          GL_AmountType3=(String) ar1.get(22);
			          GL_GlAcCode3=Integer.parseInt((String) ar1.get(23));
			          GL_OrgId3=Integer.parseInt((String) ar1.get(24));
			          
			 	      
			       
			            
			       
			       
			     Properties prop=new Properties();
			      
			      FileOutputStream fos = new FileOutputStream("./DataFiles/RDACC_CLOSURE_AUTOPOST.properties");
			      prop.setProperty("FDProductName1",GL_ProductName1);
			      prop.setProperty("FDAccountNumber1", GL_AccountNumber1);
			      prop.setProperty("FDDisplayName1",GL_AccDisplayName1);
			      prop.setProperty("FDProductName2",GL_ProductName2);
			      prop.setProperty("FDAccountNumber2", GL_AccountNumber2);
			      prop.setProperty("FDDisplayName2",GL_AccDisplayName2);
			      prop.setProperty("FDBatchId",String.valueOf(GL_BatchId));
			      prop.setProperty("FDTransId", String.valueOf(GL_TransId));
			      prop.setProperty("FDTransAmount",GL_TransAmount);
			      prop.setProperty("FDTransferMode",GL_TransferMode);
			      
			      
			      prop.setProperty("FDVoucherNumber1",String.valueOf(GL_VoucherNumber1));
			      prop.setProperty("FDTranType1", GL_TranType1); 
			      prop.setProperty("FDAmountType1",GL_AmountType1);
			      prop.setProperty("FDGlAcCode1",String.valueOf (GL_GlAcCode1)); 
			      prop.setProperty("FDOrgId1",String.valueOf (GL_OrgId1));
			      
			      prop.setProperty("FDVoucherNumber2",String.valueOf(GL_VoucherNumber2));
			      prop.setProperty("FDTranType2", GL_TranType2); 
			      prop.setProperty("FDAmountType2",GL_AmountType2);
			      prop.setProperty("FDGlAcCode2",String.valueOf (GL_GlAcCode2)); 
			      prop.setProperty("FDOrgId2",String.valueOf (GL_OrgId2));
			      
			      prop.setProperty("FDVoucherNumber3",String.valueOf(GL_VoucherNumber3));
			      prop.setProperty("FDTranType3", GL_TranType3); 
			      prop.setProperty("FDAmountType3",GL_AmountType3);
			      prop.setProperty("FDGlAcCode3",String.valueOf (GL_GlAcCode3)); 
			      prop.setProperty("FDOrgId3",String.valueOf (GL_OrgId3));
			      
			      prop.setProperty("FDVoucherNumber4",String.valueOf(GL_VoucherNumber4));
			      prop.setProperty("FDTranType4", GL_TranType4); 
			      prop.setProperty("FDAmountType4",GL_AmountType4);
			      prop.setProperty("FDGlAcCode4",String.valueOf (GL_GlAcCode4)); 
			      prop.setProperty("FDOrgId4",String.valueOf (GL_OrgId4));
			      
			      prop.setProperty("FDVoucherNumber5",String.valueOf(GL_VoucherNumber5));
			      prop.setProperty("FDTranType5", GL_TranType5); 
			      prop.setProperty("FDAmountType5",GL_AmountType5);
			      prop.setProperty("FDGlAcCode5",String.valueOf (GL_GlAcCode5)); 
			      prop.setProperty("FDOrgId5",String.valueOf (GL_OrgId5));
			      
			      
			      
			      
			     System.out.println("Written ");
				 prop.store(fos, "Done");
				 fos.close();
				        Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
					
				 }
	   }catch(Exception e){
		Driver.tcFlag = "PASS";
		Driver.comment = Driver.objectName + " is not displayed or not identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		e.printStackTrace();
	}
return driver;

	}
public static WebDriver writeDDAccClosure_Cash(WebDriver driver, String propertyValue) {
	
	try {
		
		       System.out.println("WRITE FD ACCOUNT CLOSURE SUMMARY");
		       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			
				String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
				System.out.println("Trans ID "+TransID);
				
				Connection con=(Connection) Common.DatabaseConnector();
				if(con !=null) {
		        Statement stmt = con.createStatement();	
		        
		        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
		        ResultSet rs1= stmt.executeQuery(Q_datefetch);
		        System.out.println("FETCHED DATES");
		       
		           while(rs1.next()) {
		        	
		        	   GL_TransactionDate=rs1.getString(1);
		        	   GL_ValueDate=rs1.getString(2);
		           }
		        
		        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
		        ResultSet rst= stmt.executeQuery(Data); 
		        System.out.println("SP1 EXECUTED");
		       
	                int row=rst.getRow();
			        ArrayList ar=new ArrayList<>();
			        ResultSetMetaData rsmd;
			       
			       try {
			                 rsmd = rst.getMetaData();

			                 int NumOfCol = rsmd.getColumnCount();
			                 
			               

			                 while (rst.next()) {
			                  

			                     for (int i = 1; i <= NumOfCol; i++) {
			                        
			                      ar.add(rst.getString(i));
			                      
			                     }

			                     row++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
			       GL_ProductName=(String) ar.get(0);
			       GL_AccountNumber=(String) ar.get(1);
			       GL_AccDisplayName=(String) ar.get(2);
			       GL_BatchId=Integer.parseInt((String) ar.get(3));
				   GL_TransId=Integer.parseInt((String) ar.get(4));
				   GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
			       GL_TranType=(String) ar.get(6);
				   GL_TransferMode=(String) ar.get(7);
				   GL_OrgId=Integer.parseInt((String) ar.get(8));
			        
			       
		 String Data2="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
         ResultSet result= stmt.executeQuery(Data2);
         System.out.println("SP2 EXECUTED");
			    int row1=result.getRow();
			    ArrayList ar1=new ArrayList<>();
			      
			       ResultSetMetaData rsmd1;
			       
			       try {
			                 rsmd1 = result.getMetaData();

			                 int NumOfCol1 = rsmd1.getColumnCount();
			                 
			               

			                 while (result.next()) {
			                  

			                     for (int i = 1; i <= NumOfCol1; i++) {
			                        
			                      ar1.add(result.getString(i));
			                      
			                     }

			                     row1++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
			       
			          
			          GL_TransAmount1=(String) ar1.get(0);
			          GL_AmountType1=(String) ar1.get(1);
			          GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
			         
			          
			          GL_TransAmount2=(String) ar1.get(3);
			          GL_AmountType2=(String) ar1.get(4);
			          GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
			          
			          
			          
			      Properties prop=new Properties();
			      FileOutputStream fos = new FileOutputStream("./DataFiles/DDACC_CLOSURE_CASH.properties");
			      
			      prop.setProperty("FDProductName",GL_ProductName);
			      prop.setProperty("FDAccountNumber", GL_AccountNumber);
			      prop.setProperty("FDDisplayName",GL_AccDisplayName);
			      prop.setProperty("FDBatchId",String.valueOf(GL_BatchId));
			      prop.setProperty("FDTransId", String.valueOf(GL_TransId));
			      prop.setProperty("FDVoucherNumber",String.valueOf(GL_VoucherNumber));
			      prop.setProperty("FDTranType", GL_TranType); 
			      prop.setProperty("FDTransferMode",GL_TransferMode);
			      prop.setProperty("FDOrgId",String.valueOf (GL_OrgId));
			      
			      prop.setProperty("FDTransAmount1",GL_TransAmount1);
			      prop.setProperty("FDAmountType1",GL_AmountType1);
			      prop.setProperty("FDGlAcCode1",String.valueOf (GL_GlAcCode1));
			      
			      prop.setProperty("FDTransAmount2",GL_TransAmount2);
			      prop.setProperty("FDAmountType2",GL_AmountType2);
			      prop.setProperty("FDGlAcCode2",String.valueOf (GL_GlAcCode2));
			      
			      
			     System.out.println("Written ");
				 prop.store(fos, "Done");
				 fos.close();
				        Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
					
				 }
	   }catch(Exception e){
		Driver.tcFlag = "PASS";
		Driver.comment = Driver.objectName + " is not displayed or not identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		e.printStackTrace();
	}
return driver;

	}
public static WebDriver writeDDAccClosure_Batch(WebDriver driver, String propertyValue) {
	
	try {
		       System.out.println("WRITE FD ACCOUNT CLOSURE SUMMARY");
		       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			
				String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
				System.out.println("Trans ID "+TransID);
				
				Connection con=(Connection) Common.DatabaseConnector();
				if(con !=null) {
		        Statement stmt = con.createStatement();	
		        
		        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
		        ResultSet rs1= stmt.executeQuery(Q_datefetch);
		        System.out.println("FETCHED DATES");
		       
		           while(rs1.next()) {
		        	
		        	   GL_TransactionDate=rs1.getString(1);
		        	   GL_ValueDate=rs1.getString(2);
		           }
		         float TotalAmount=0;
				 String Principal=null;
				 String Interest=null;
						try {
							  Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
							  Interest=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[3]/td[9]")).getText();
							  float a= Float.parseFloat(Principal);
							  float b= Float.parseFloat(Interest);
							  TotalAmount= a+b;
							   System.out.println("Total Amount"+TotalAmount);
							       
							        }catch (NumberFormatException e) {
							        	
							        	e.printStackTrace();
							        }
		        
		        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
		        ResultSet rst= stmt.executeQuery(Data); 
		        System.out.println("SP1 EXECUTED");
		       
	                int row=rst.getRow();
			        ArrayList ar=new ArrayList<>();
			        ResultSetMetaData rsmd;
			       
			       try {
			                 rsmd = rst.getMetaData();

			                 int NumOfCol = rsmd.getColumnCount();
			                 
			               

			                 while (rst.next()) {
			                  

			                     for (int i = 1; i <= NumOfCol; i++) {
			                        
			                      ar.add(rst.getString(i));
			                      
			                     }

			                     row++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
			       GL_ProductName=(String) ar.get(0);
			       GL_AccountNumber=(String) ar.get(1);
			       GL_AccDisplayName=(String) ar.get(2);
			       GL_BatchId=Integer.parseInt((String) ar.get(3));
				   GL_TransId=Integer.parseInt((String) ar.get(4));
				   GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
			       GL_TranType=(String) ar.get(6);
				   GL_TransferMode=(String) ar.get(7);
				   GL_OrgId=Integer.parseInt((String) ar.get(8));
			        
			       
		 String Data2="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
         ResultSet result= stmt.executeQuery(Data2);
         System.out.println("SP2 EXECUTED");
			    int row1=result.getRow();
			    ArrayList ar1=new ArrayList<>();
			      
			       ResultSetMetaData rsmd1;
			       
			       try {
			                 rsmd1 = result.getMetaData();

			                 int NumOfCol1 = rsmd1.getColumnCount();
			                 
			               

			                 while (result.next()) {
			                  

			                     for (int i = 1; i <= NumOfCol1; i++) {
			                        
			                      ar1.add(result.getString(i));
			                      
			                     }

			                     row1++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
			       
			          
			          GL_TransAmount1=(String) ar1.get(0);
			          GL_AmountType1=(String) ar1.get(1);
			          GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
			         
			          
			          GL_TransAmount2=(String) ar1.get(3);
			          GL_AmountType2=(String) ar1.get(4);
			          GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
			          
			          
			          
			      Properties prop=new Properties();
			      FileOutputStream fos = new FileOutputStream("./DataFiles/DDACC_CLOSURE_BATCH.properties");
			      
			      prop.setProperty("FDProductName",GL_ProductName);
			      prop.setProperty("FDAccountNumber", GL_AccountNumber);
			      prop.setProperty("FDDisplayName",GL_AccDisplayName);
			      prop.setProperty("FDBatchId",String.valueOf(GL_BatchId));
			      prop.setProperty("FDTransId", String.valueOf(GL_TransId));
			      prop.setProperty("FDVoucherNumber",String.valueOf(GL_VoucherNumber));
			      prop.setProperty("FDTranType", GL_TranType); 
			      prop.setProperty("FDTransferMode",GL_TransferMode);
			      prop.setProperty("FDOrgId",String.valueOf (GL_OrgId));
			      
			      prop.setProperty("FDTransAmount1",GL_TransAmount1);
			      prop.setProperty("FDAmountType1",GL_AmountType1);
			      prop.setProperty("FDGlAcCode1",String.valueOf (GL_GlAcCode1));
			      
			      prop.setProperty("FDTransAmount2",GL_TransAmount2);
			      prop.setProperty("FDAmountType2",GL_AmountType2);
			      prop.setProperty("FDGlAcCode2",String.valueOf (GL_GlAcCode2));
			      
			      prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
			      
			     System.out.println("Written ");
				 prop.store(fos, "Done");
				 fos.close();
				        Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
					
				 }
	   }catch(Exception e){
		Driver.tcFlag = "PASS";
		Driver.comment = Driver.objectName + " is not displayed or not identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		e.printStackTrace();
	}
return driver;

	}
public static WebDriver writeDDAccountClosure_Autopost(WebDriver driver, String propertyValue) {
	
	try {
		
		       System.out.println("WRITE DD SUMMARY");
		       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			
				String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
				System.out.println("Trans ID "+TransID);
				
				Connection con=(Connection) Common.DatabaseConnector();
				if(con !=null) {
		        Statement stmt = con.createStatement();	
		        
		        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
		        ResultSet rs1= stmt.executeQuery(Q_datefetch);
		        System.out.println("FETCHED DATES");
		       
		           while(rs1.next()) {
		        	
		        	   GL_TransactionDate=rs1.getString(1);
		        	   GL_ValueDate=rs1.getString(2);
		           }
		        
		        String Data="select distinct  ProductName,AcNo,AcDisplayName from QaFnGetinterbranchSummaryDetails  ("+TransID+")";     
		        ResultSet rst= stmt.executeQuery(Data); 
		        System.out.println("SP1 EXECUTED");
		       
	                int row=rst.getRow();
			        ArrayList ar=new ArrayList<>();
			        ResultSetMetaData rsmd;
			       
			       try {
			                 rsmd = rst.getMetaData();

			                 int NumOfCol = rsmd.getColumnCount();
			                 
			               

			                 while (rst.next()) {
			                  

			                     for (int i = 1; i <= NumOfCol; i++) {
			                        
			                      ar.add(rst.getString(i));
			                      
			                     }

			                     row++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
			       GL_ProductName2=(String) ar.get(0);
			       GL_AccountNumber2=(String) ar.get(1);
			       GL_AccDisplayName2=(String) ar.get(2); 
			       GL_ProductName1=(String) ar.get(3);
			       GL_AccountNumber1=(String) ar.get(4);
			       GL_AccDisplayName1=(String) ar.get(5); 
			        
			       
			   String Data1="select BatchID,TransID,TrnAmount,TrnMode from QaFnGetinterbranchSummaryDetails  ("+TransID+")";
			   ResultSet rslt= stmt.executeQuery(Data1);
			   System.out.println("SP2 EXECUTED");
			   while(rslt.next()) {
				   
				    
				   GL_BatchId=Integer.parseInt(rslt.getString(1));
				   GL_TransId=Integer.parseInt(rslt.getString(2));
				   GL_TransAmount=rslt.getString(3);
				   GL_TransferMode=rslt.getString(4);
				   
		        }
				   
			         
           String Data2="select VoucherNo,CrorDr,AmtTypeText,GLAcCode,RespBranchID from QaFnGetinterbranchSummaryDetails ("+TransID+")";
           ResultSet result= stmt.executeQuery(Data2);
           System.out.println("SP3 EXECUTED");
			    int row1=result.getRow();
			    ArrayList ar1=new ArrayList<>();
			      
			       ResultSetMetaData rsmd1;
			       
			       try {
			                 rsmd1 = result.getMetaData();

			                 int NumOfCol1 = rsmd1.getColumnCount();
			                 
			               

			                 while (result.next()) {
			                  

			                     for (int i = 1; i <= NumOfCol1; i++) {
			                        
			                      ar1.add(result.getString(i));
			                      
			                     }

			                     row1++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
			       
			          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(0));
			          GL_TranType1=(String) ar1.get(1);
			          GL_AmountType1=(String) ar1.get(2);
			          GL_GlAcCode1=Integer.parseInt((String) ar1.get(3));
			          GL_OrgId1=Integer.parseInt((String) ar1.get(4));
			 	       
			          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(5));
			          GL_TranType2=(String) ar1.get(6);
			          GL_AmountType2=(String) ar1.get(7);
			          GL_GlAcCode2=Integer.parseInt((String) ar1.get(8));
			          GL_OrgId2=Integer.parseInt((String) ar1.get(9));
			          
			          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(10));
			          GL_TranType4=(String) ar1.get(11);
			          GL_AmountType4=(String) ar1.get(12);
			          GL_GlAcCode4=Integer.parseInt((String) ar1.get(13));
			          GL_OrgId4=Integer.parseInt((String) ar1.get(14));
			          
			          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(15));
			          GL_TranType3=(String) ar1.get(16);
			          GL_AmountType3=(String) ar1.get(17);
			          GL_GlAcCode3=Integer.parseInt((String) ar1.get(18));
			          GL_OrgId3=Integer.parseInt((String) ar1.get(19));
			          
			          GL_VoucherNumber5=Integer.parseInt((String) ar1.get(20));
			          GL_TranType5=(String) ar1.get(21);
			          GL_AmountType5=(String) ar1.get(22);
			          GL_GlAcCode5=Integer.parseInt((String) ar1.get(23));
			          GL_OrgId5=Integer.parseInt((String) ar1.get(24));
			          
			 	      
			       
			            
			       
			       
			     Properties prop=new Properties();
			      
			      FileOutputStream fos = new FileOutputStream("./DataFiles/DDACC_CLOSURE_AUTOPOST.properties");
			      prop.setProperty("FDProductName1",GL_ProductName1);
			      prop.setProperty("FDAccountNumber1", GL_AccountNumber1);
			      prop.setProperty("FDDisplayName1",GL_AccDisplayName1);
			      prop.setProperty("FDProductName2",GL_ProductName2);
			      prop.setProperty("FDAccountNumber2", GL_AccountNumber2);
			      prop.setProperty("FDDisplayName2",GL_AccDisplayName2);
			      prop.setProperty("FDBatchId",String.valueOf(GL_BatchId));
			      prop.setProperty("FDTransId", String.valueOf(GL_TransId));
			      prop.setProperty("FDTransAmount",GL_TransAmount);
			      prop.setProperty("FDTransferMode",GL_TransferMode);
			      
			      
			      prop.setProperty("FDVoucherNumber1",String.valueOf(GL_VoucherNumber1));
			      prop.setProperty("FDTranType1", GL_TranType1); 
			      prop.setProperty("FDAmountType1",GL_AmountType1);
			      prop.setProperty("FDGlAcCode1",String.valueOf (GL_GlAcCode1)); 
			      prop.setProperty("FDOrgId1",String.valueOf (GL_OrgId1));
			      
			      prop.setProperty("FDVoucherNumber2",String.valueOf(GL_VoucherNumber2));
			      prop.setProperty("FDTranType2", GL_TranType2); 
			      prop.setProperty("FDAmountType2",GL_AmountType2);
			      prop.setProperty("FDGlAcCode2",String.valueOf (GL_GlAcCode2)); 
			      prop.setProperty("FDOrgId2",String.valueOf (GL_OrgId2));
			      
			      prop.setProperty("FDVoucherNumber3",String.valueOf(GL_VoucherNumber3));
			      prop.setProperty("FDTranType3", GL_TranType3); 
			      prop.setProperty("FDAmountType3",GL_AmountType3);
			      prop.setProperty("FDGlAcCode3",String.valueOf (GL_GlAcCode3)); 
			      prop.setProperty("FDOrgId3",String.valueOf (GL_OrgId3));
			      
			      prop.setProperty("FDVoucherNumber4",String.valueOf(GL_VoucherNumber4));
			      prop.setProperty("FDTranType4", GL_TranType4); 
			      prop.setProperty("FDAmountType4",GL_AmountType4);
			      prop.setProperty("FDGlAcCode4",String.valueOf (GL_GlAcCode4)); 
			      prop.setProperty("FDOrgId4",String.valueOf (GL_OrgId4));
			      
			      prop.setProperty("FDVoucherNumber5",String.valueOf(GL_VoucherNumber5));
			      prop.setProperty("FDTranType5", GL_TranType5); 
			      prop.setProperty("FDAmountType5",GL_AmountType5);
			      prop.setProperty("FDGlAcCode5",String.valueOf (GL_GlAcCode5)); 
			      prop.setProperty("FDOrgId5",String.valueOf (GL_OrgId5));
			      
			      
			      
			      
			     System.out.println("Written ");
				 prop.store(fos, "Done");
				 fos.close();
				        Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
					
				 }
	   }catch(Exception e){
		Driver.tcFlag = "PASS";
		Driver.comment = Driver.objectName + " is not displayed or not identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		e.printStackTrace();
	}
return driver;

	}
public static WebDriver writeRIDAccClosure_Cash(WebDriver driver, String propertyValue) {
	
	try {
		
		       System.out.println("WRITE FD ACCOUNT CLOSURE SUMMARY");
		       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			
				String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
				System.out.println("Trans ID "+TransID);
				
				Connection con=(Connection) Common.DatabaseConnector();
				if(con !=null) {
		        Statement stmt = con.createStatement();	
		        
		        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
		        ResultSet rs1= stmt.executeQuery(Q_datefetch);
		        System.out.println("FETCHED DATES");
		       
		           while(rs1.next()) {
		        	
		        	   GL_TransactionDate=rs1.getString(1);
		        	   GL_ValueDate=rs1.getString(2);
		           }
		        
		        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
		        ResultSet rst= stmt.executeQuery(Data); 
		        System.out.println("SP1 EXECUTED");
		       
	                int row=rst.getRow();
			        ArrayList ar=new ArrayList<>();
			        ResultSetMetaData rsmd;
			       
			       try {
			                 rsmd = rst.getMetaData();

			                 int NumOfCol = rsmd.getColumnCount();
			                 
			               

			                 while (rst.next()) {
			                  

			                     for (int i = 1; i <= NumOfCol; i++) {
			                        
			                      ar.add(rst.getString(i));
			                      
			                     }

			                     row++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
			       GL_ProductName=(String) ar.get(0);
			       GL_AccountNumber=(String) ar.get(1);
			       GL_AccDisplayName=(String) ar.get(2);
			       GL_BatchId=Integer.parseInt((String) ar.get(3));
				   GL_TransId=Integer.parseInt((String) ar.get(4));
				   GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
			       GL_TranType=(String) ar.get(6);
				   GL_TransferMode=(String) ar.get(7);
				   GL_OrgId=Integer.parseInt((String) ar.get(8));
			        
			       
		 String Data2="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
         ResultSet result= stmt.executeQuery(Data2);
         System.out.println("SP2 EXECUTED");
			    int row1=result.getRow();
			    ArrayList ar1=new ArrayList<>();
			      
			       ResultSetMetaData rsmd1;
			       
			       try {
			                 rsmd1 = result.getMetaData();

			                 int NumOfCol1 = rsmd1.getColumnCount();
			                 
			               

			                 while (result.next()) {
			                  

			                     for (int i = 1; i <= NumOfCol1; i++) {
			                        
			                      ar1.add(result.getString(i));
			                      
			                     }

			                     row1++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
			       
			          
			          GL_TransAmount1=(String) ar1.get(0);
			          GL_AmountType1=(String) ar1.get(1);
			          GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
			         
			          
			          GL_TransAmount2=(String) ar1.get(3);
			          GL_AmountType2=(String) ar1.get(4);
			          GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
			          
			          
			          
			      Properties prop=new Properties();
			      FileOutputStream fos = new FileOutputStream("./DataFiles/RIDACC_CLOSURE_CASH.properties");
			      
			      prop.setProperty("FDProductName",GL_ProductName);
			      prop.setProperty("FDAccountNumber", GL_AccountNumber);
			      prop.setProperty("FDDisplayName",GL_AccDisplayName);
			      prop.setProperty("FDBatchId",String.valueOf(GL_BatchId));
			      prop.setProperty("FDTransId", String.valueOf(GL_TransId));
			      prop.setProperty("FDVoucherNumber",String.valueOf(GL_VoucherNumber));
			      prop.setProperty("FDTranType", GL_TranType); 
			      prop.setProperty("FDTransferMode",GL_TransferMode);
			      prop.setProperty("FDOrgId",String.valueOf (GL_OrgId));
			      
			      prop.setProperty("FDTransAmount1",GL_TransAmount1);
			      prop.setProperty("FDAmountType1",GL_AmountType1);
			      prop.setProperty("FDGlAcCode1",String.valueOf (GL_GlAcCode1));
			      
			      prop.setProperty("FDTransAmount2",GL_TransAmount2);
			      prop.setProperty("FDAmountType2",GL_AmountType2);
			      prop.setProperty("FDGlAcCode2",String.valueOf (GL_GlAcCode2));
			      
			      
			     System.out.println("Written ");
				 prop.store(fos, "Done");
				 fos.close();
				        Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
					
				 }
	   }catch(Exception e){
		Driver.tcFlag = "PASS";
		Driver.comment = Driver.objectName + " is not displayed or not identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		e.printStackTrace();
	}
return driver;

	}
public static WebDriver writRIDDAccClosure_Batch(WebDriver driver, String propertyValue) {
	
	try {
		
		       System.out.println("WRITE FD ACCOUNT CLOSURE SUMMARY");
		       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			
				String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
				System.out.println("Trans ID "+TransID);
				
				Connection con=(Connection) Common.DatabaseConnector();
				if(con !=null) {
		        Statement stmt = con.createStatement();	
		        
		        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
		        ResultSet rs1= stmt.executeQuery(Q_datefetch);
		        System.out.println("FETCHED DATES");
		       
		           while(rs1.next()) {
		        	
		        	   GL_TransactionDate=rs1.getString(1);
		        	   GL_ValueDate=rs1.getString(2);
		           }
		         float TotalAmount=0;
				 String Principal=null;
				 String Interest=null;
						try {
							  Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
							  Interest=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[3]/td[9]")).getText();
							  float a= Float.parseFloat(Principal);
							  float b= Float.parseFloat(Interest);
							  TotalAmount= a+b;
							   System.out.println("Total Amount"+TotalAmount);
							       
							        }catch (NumberFormatException e) {
							        	
							        	e.printStackTrace();
							        }
		        
		        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
		        ResultSet rst= stmt.executeQuery(Data); 
		        System.out.println("SP1 EXECUTED");
		       
	                int row=rst.getRow();
			        ArrayList ar=new ArrayList<>();
			        ResultSetMetaData rsmd;
			       
			       try {
			                 rsmd = rst.getMetaData();

			                 int NumOfCol = rsmd.getColumnCount();
			                 
			               

			                 while (rst.next()) {
			                  

			                     for (int i = 1; i <= NumOfCol; i++) {
			                        
			                      ar.add(rst.getString(i));
			                      
			                     }

			                     row++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
			       GL_ProductName=(String) ar.get(0);
			       GL_AccountNumber=(String) ar.get(1);
			       GL_AccDisplayName=(String) ar.get(2);
			       GL_BatchId=Integer.parseInt((String) ar.get(3));
				   GL_TransId=Integer.parseInt((String) ar.get(4));
				   GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
			       GL_TranType=(String) ar.get(6);
				   GL_TransferMode=(String) ar.get(7);
				   GL_OrgId=Integer.parseInt((String) ar.get(8));
			        
			       
		 String Data2="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
         ResultSet result= stmt.executeQuery(Data2);
         System.out.println("SP2 EXECUTED");
			    int row1=result.getRow();
			    ArrayList ar1=new ArrayList<>();
			      
			       ResultSetMetaData rsmd1;
			       
			       try {
			                 rsmd1 = result.getMetaData();

			                 int NumOfCol1 = rsmd1.getColumnCount();
			                 
			               

			                 while (result.next()) {
			                  

			                     for (int i = 1; i <= NumOfCol1; i++) {
			                        
			                      ar1.add(result.getString(i));
			                      
			                     }

			                     row1++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
			       
			          
			          GL_TransAmount1=(String) ar1.get(0);
			          GL_AmountType1=(String) ar1.get(1);
			          GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
			         
			          
			          GL_TransAmount2=(String) ar1.get(3);
			          GL_AmountType2=(String) ar1.get(4);
			          GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
			          
			          
			          
			      Properties prop=new Properties();
			      FileOutputStream fos = new FileOutputStream("./DataFiles/RIDACC_CLOSURE_BATCH.properties");
			      
			      prop.setProperty("FDProductName",GL_ProductName);
			      prop.setProperty("FDAccountNumber", GL_AccountNumber);
			      prop.setProperty("FDDisplayName",GL_AccDisplayName);
			      prop.setProperty("FDBatchId",String.valueOf(GL_BatchId));
			      prop.setProperty("FDTransId", String.valueOf(GL_TransId));
			      prop.setProperty("FDVoucherNumber",String.valueOf(GL_VoucherNumber));
			      prop.setProperty("FDTranType", GL_TranType); 
			      prop.setProperty("FDTransferMode",GL_TransferMode);
			      prop.setProperty("FDOrgId",String.valueOf (GL_OrgId));
			      
			      prop.setProperty("FDTransAmount1",GL_TransAmount1);
			      prop.setProperty("FDAmountType1",GL_AmountType1);
			      prop.setProperty("FDGlAcCode1",String.valueOf (GL_GlAcCode1));
			      
			      prop.setProperty("FDTransAmount2",GL_TransAmount2);
			      prop.setProperty("FDAmountType2",GL_AmountType2);
			      prop.setProperty("FDGlAcCode2",String.valueOf (GL_GlAcCode2));
			      
			      prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
			      
			     System.out.println("Written ");
				 prop.store(fos, "Done");
				 fos.close();
				        Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
					
				 }
	   }catch(Exception e){
		Driver.tcFlag = "PASS";
		Driver.comment = Driver.objectName + " is not displayed or not identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		e.printStackTrace();
	}
return driver;

	}
public static WebDriver writeRIDAccountClosure_Autopost(WebDriver driver, String propertyValue) {
	
	try {
		
		       System.out.println("WRITE RID SUMMARY");
		       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			
				String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
				System.out.println("Trans ID "+TransID);
				
				Connection con=(Connection) Common.DatabaseConnector();
				if(con !=null) {
		        Statement stmt = con.createStatement();	
		        
		        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
		        ResultSet rs1= stmt.executeQuery(Q_datefetch);
		        System.out.println("FETCHED DATES");
		       
		           while(rs1.next()) {
		        	
		        	   GL_TransactionDate=rs1.getString(1);
		        	   GL_ValueDate=rs1.getString(2);
		           }
		        
		        String Data="select distinct  ProductName,AcNo,AcDisplayName from QaFnGetinterbranchSummaryDetails  ("+TransID+")";     
		        ResultSet rst= stmt.executeQuery(Data); 
		        System.out.println("SP1 EXECUTED");
		       
	                int row=rst.getRow();
			        ArrayList ar=new ArrayList<>();
			        ResultSetMetaData rsmd;
			       
			       try {
			                 rsmd = rst.getMetaData();

			                 int NumOfCol = rsmd.getColumnCount();
			                 
			               

			                 while (rst.next()) {
			                  

			                     for (int i = 1; i <= NumOfCol; i++) {
			                        
			                      ar.add(rst.getString(i));
			                      
			                     }

			                     row++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
			       GL_ProductName2=(String) ar.get(0);
			       GL_AccountNumber2=(String) ar.get(1);
			       GL_AccDisplayName2=(String) ar.get(2); 
			       GL_ProductName1=(String) ar.get(3);
			       GL_AccountNumber1=(String) ar.get(4);
			       GL_AccDisplayName1=(String) ar.get(5); 
			        
			       
			   String Data1="select BatchID,TransID,TrnAmount,TrnMode from QaFnGetinterbranchSummaryDetails  ("+TransID+")";
			   ResultSet rslt= stmt.executeQuery(Data1);
			   System.out.println("SP2 EXECUTED");
			   while(rslt.next()) {
				   
				    
				   GL_BatchId=Integer.parseInt(rslt.getString(1));
				   GL_TransId=Integer.parseInt(rslt.getString(2));
				   GL_TransAmount=rslt.getString(3);
				   GL_TransferMode=rslt.getString(4);
				   
		        }
				   
			         
           String Data2="select VoucherNo,CrorDr,AmtTypeText,GLAcCode,RespBranchID from QaFnGetinterbranchSummaryDetails ("+TransID+")";
           ResultSet result= stmt.executeQuery(Data2);
           System.out.println("SP3 EXECUTED");
			    int row1=result.getRow();
			    ArrayList ar1=new ArrayList<>();
			      
			       ResultSetMetaData rsmd1;
			       
			       try {
			                 rsmd1 = result.getMetaData();

			                 int NumOfCol1 = rsmd1.getColumnCount();
			                 
			               

			                 while (result.next()) {
			                  

			                     for (int i = 1; i <= NumOfCol1; i++) {
			                        
			                      ar1.add(result.getString(i));
			                      
			                     }

			                     row1++;
			                 }
			                 
			                 
			             } catch (SQLException e) {
			                 throw e;
			         
			             }
			       
			          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(0));
			          GL_TranType1=(String) ar1.get(1);
			          GL_AmountType1=(String) ar1.get(2);
			          GL_GlAcCode1=Integer.parseInt((String) ar1.get(3));
			          GL_OrgId1=Integer.parseInt((String) ar1.get(4));
			 	       
			          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(5));
			          GL_TranType2=(String) ar1.get(6);
			          GL_AmountType2=(String) ar1.get(7);
			          GL_GlAcCode2=Integer.parseInt((String) ar1.get(8));
			          GL_OrgId2=Integer.parseInt((String) ar1.get(9));
			          
			          GL_VoucherNumber5=Integer.parseInt((String) ar1.get(10));
			          GL_TranType5=(String) ar1.get(11);
			          GL_AmountType5=(String) ar1.get(12);
			          GL_GlAcCode5=Integer.parseInt((String) ar1.get(13));
			          GL_OrgId5=Integer.parseInt((String) ar1.get(14));
			          
			          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(15));
			          GL_TranType4=(String) ar1.get(16);
			          GL_AmountType4=(String) ar1.get(17);
			          GL_GlAcCode4=Integer.parseInt((String) ar1.get(18));
			          GL_OrgId4=Integer.parseInt((String) ar1.get(19));
			          
			          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(20));
			          GL_TranType3=(String) ar1.get(21);
			          GL_AmountType3=(String) ar1.get(22);
			          GL_GlAcCode3=Integer.parseInt((String) ar1.get(23));
			          GL_OrgId3=Integer.parseInt((String) ar1.get(24));
			          
			 	      
			       
			            
			       
			       
			     Properties prop=new Properties();
			      
			      FileOutputStream fos = new FileOutputStream("./DataFiles/RIDACC_CLOSURE_AUTOPOST.properties");
			      prop.setProperty("FDProductName1",GL_ProductName1);
			      prop.setProperty("FDAccountNumber1", GL_AccountNumber1);
			      prop.setProperty("FDDisplayName1",GL_AccDisplayName1);
			      prop.setProperty("FDProductName2",GL_ProductName2);
			      prop.setProperty("FDAccountNumber2", GL_AccountNumber2);
			      prop.setProperty("FDDisplayName2",GL_AccDisplayName2);
			      prop.setProperty("FDBatchId",String.valueOf(GL_BatchId));
			      prop.setProperty("FDTransId", String.valueOf(GL_TransId));
			      prop.setProperty("FDTransAmount",GL_TransAmount);
			      prop.setProperty("FDTransferMode",GL_TransferMode);
			      
			      
			      prop.setProperty("FDVoucherNumber1",String.valueOf(GL_VoucherNumber1));
			      prop.setProperty("FDTranType1", GL_TranType1); 
			      prop.setProperty("FDAmountType1",GL_AmountType1);
			      prop.setProperty("FDGlAcCode1",String.valueOf (GL_GlAcCode1)); 
			      prop.setProperty("FDOrgId1",String.valueOf (GL_OrgId1));
			      
			      prop.setProperty("FDVoucherNumber2",String.valueOf(GL_VoucherNumber2));
			      prop.setProperty("FDTranType2", GL_TranType2); 
			      prop.setProperty("FDAmountType2",GL_AmountType2);
			      prop.setProperty("FDGlAcCode2",String.valueOf (GL_GlAcCode2)); 
			      prop.setProperty("FDOrgId2",String.valueOf (GL_OrgId2));
			      
			      prop.setProperty("FDVoucherNumber3",String.valueOf(GL_VoucherNumber3));
			      prop.setProperty("FDTranType3", GL_TranType3); 
			      prop.setProperty("FDAmountType3",GL_AmountType3);
			      prop.setProperty("FDGlAcCode3",String.valueOf (GL_GlAcCode3)); 
			      prop.setProperty("FDOrgId3",String.valueOf (GL_OrgId3));
			      
			      prop.setProperty("FDVoucherNumber4",String.valueOf(GL_VoucherNumber4));
			      prop.setProperty("FDTranType4", GL_TranType4); 
			      prop.setProperty("FDAmountType4",GL_AmountType4);
			      prop.setProperty("FDGlAcCode4",String.valueOf (GL_GlAcCode4)); 
			      prop.setProperty("FDOrgId4",String.valueOf (GL_OrgId4));
			      
			      prop.setProperty("FDVoucherNumber5",String.valueOf(GL_VoucherNumber5));
			      prop.setProperty("FDTranType5", GL_TranType5); 
			      prop.setProperty("FDAmountType5",GL_AmountType5);
			      prop.setProperty("FDGlAcCode5",String.valueOf (GL_GlAcCode5)); 
			      prop.setProperty("FDOrgId5",String.valueOf (GL_OrgId5));
			      
			      
			      
			      
			     System.out.println("Written ");
				 prop.store(fos, "Done");
				 fos.close();
				        Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
					
				 }
	   }catch(Exception e){
		Driver.tcFlag = "PASS";
		Driver.comment = Driver.objectName + " is not displayed or not identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		e.printStackTrace();
	}
return driver;

	}

 public static void writeODCashCreditRenewal_Batch(WebDriver driver, String propertyValue) {
	
 
	
	try {
				
				System.out.println("WRITE CASH CREDIT SUMMARY");
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
					
						
				String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
				System.out.println("Trans ID "+TransID);
						
	            Connection con=(Connection) Common.DatabaseConnector();
				if(con !=null) {
				Statement stmt = con.createStatement();	
				           
				           String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
				           ResultSet rs1= stmt.executeQuery(Q_datefetch);
				           while(rs1.next()) {
				            
				        	   GL_TransactionDate=rs1.getString(1);
				        	   GL_ValueDate=rs1.getString(2);
				           }
				     float TotalAmount=0;
					 String Principal=null;
							
							       
							        
							 try {
							        	
							      Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
							      float a= Float.parseFloat(Principal);
							      TotalAmount= a;
							        System.out.println("Total Amount"+TotalAmount);
							       
							        }catch (NumberFormatException e) {
							        	
							        	e.printStackTrace();
							        }
				 
	           String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
		       ResultSet rs= stmt.executeQuery(Data);
			   System.out.println("SP executed");
			   int row=rs.getRow();
			   ArrayList ar=new ArrayList<>();
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
						
						 	GL_ProductName=(String) ar.get(0);
					      	
					      	GL_AccountNumber=(String) ar.get(1);
						
					      	GL_AccDisplayName=(String) ar.get(2);
							
					      	GL_BatchId=Integer.parseInt((String) ar.get(3));
							
					      	GL_TransId=Integer.parseInt((String) ar.get(4));
							
					      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	GL_TranType=(String) ar.get(6);
							
					      	GL_TransAmount=(String) ar.get(7);
						
					      	GL_AmountType=(String) ar.get(8);
						
					      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	GL_TransferMode=(String) ar.get(10);
							
					      	GL_OrgId=Integer.parseInt((String) ar.get(11));
					      	
					      	
					      	
					      	
					      	Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/ODCASHCREDIT_RENEWAL_BATCH.properties");
							prop.setProperty("ODproductName",GL_ProductName);
							prop.setProperty("ODAccountNumber", GL_AccountNumber);
							prop.setProperty("ODAccountDisplayName",GL_AccDisplayName);
							prop.setProperty("ODBatchId",String.valueOf(GL_BatchId));
							prop.setProperty("ODTransId", String.valueOf(GL_TransId));
							prop.setProperty("ODVoucherId",String.valueOf(GL_VoucherNumber));
							prop.setProperty("ODTransactionType", GL_TranType);	
							prop.setProperty("ODAmount",GL_TransAmount);
							prop.setProperty("ODAmountType",GL_AmountType);
							prop.setProperty("ODGLAccCode",String.valueOf (GL_GlAcCode));	
							prop.setProperty("ODTransferMode", GL_TransferMode);
							prop.setProperty("ODOrgID",String.valueOf (GL_OrgId));
							prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
							
					      	
							System.out.println("Written ");
							prop.store(fos, "Done");
							fos.close();
								
					}
			}catch(Exception e){
				Driver.tcFlag = "PASS";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}
		

			}
 
 public static void writeODCashCreditRenewal_Cash(WebDriver driver, String propertyValue) {
		
	 
		
		try {
					
					System.out.println("WRITE CASH CREDIT SUMMARY");
					element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
						
							
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
							
		            Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
					Statement stmt = con.createStatement();	
					           
					           String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
					           ResultSet rs1= stmt.executeQuery(Q_datefetch);
					           while(rs1.next()) {
					            
					        	   GL_TransactionDate=rs1.getString(1);
					        	   GL_ValueDate=rs1.getString(2);
					           }
					     float TotalAmount=0;
						 String Principal=null;
								
								       
								        
								 try {
								        	
								      Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
								      float a= Float.parseFloat(Principal);
								      TotalAmount= a;
								        System.out.println("Total Amount"+TotalAmount);
								       
								        }catch (NumberFormatException e) {
								        	
								        	e.printStackTrace();
								        }
					 
		           String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
			       ResultSet rs= stmt.executeQuery(Data);
				   System.out.println("SP executed");
				   int row=rs.getRow();
				   ArrayList ar=new ArrayList<>();
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
							
							 	GL_ProductName=(String) ar.get(0);
						      	
						      	GL_AccountNumber=(String) ar.get(1);
							
						      	GL_AccDisplayName=(String) ar.get(2);
								
						      	GL_BatchId=Integer.parseInt((String) ar.get(3));
								
						      	GL_TransId=Integer.parseInt((String) ar.get(4));
								
						      	GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
								
						      	GL_TranType=(String) ar.get(6);
								
						      	GL_TransAmount=(String) ar.get(7);
							
						      	GL_AmountType=(String) ar.get(8);
							
						      	GL_GlAcCode=Integer.parseInt((String) ar.get(9));
								
						      	GL_TransferMode=(String) ar.get(10);
								
						      	GL_OrgId=Integer.parseInt((String) ar.get(11));
						      	
						      	
						      	
						      	
						      	Properties prop=new Properties();
								
								FileOutputStream fos = new FileOutputStream("./DataFiles/ODCASHCREDIT_RENEWAL_CASH.properties");
								prop.setProperty("ODproductName",GL_ProductName);
								prop.setProperty("ODAccountNumber", GL_AccountNumber);
								prop.setProperty("ODAccountDisplayName",GL_AccDisplayName);
								prop.setProperty("ODBatchId",String.valueOf(GL_BatchId));
								prop.setProperty("ODTransId", String.valueOf(GL_TransId));
								prop.setProperty("ODVoucherId",String.valueOf(GL_VoucherNumber));
								prop.setProperty("ODTransactionType", GL_TranType);	
								prop.setProperty("ODAmount",GL_TransAmount);
								prop.setProperty("ODAmountType",GL_AmountType);
								prop.setProperty("ODGLAccCode",String.valueOf (GL_GlAcCode));	
								prop.setProperty("ODTransferMode", GL_TransferMode);
								prop.setProperty("ODOrgID",String.valueOf (GL_OrgId));
								prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
								
						      	
								System.out.println("Written ");
								prop.store(fos, "Done");
								fos.close();
									
						}
				}catch(Exception e){
					Driver.tcFlag = "PASS";
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					e.printStackTrace();
				}
			

				}
 
 public static WebDriver writeFDRenewal_Cash(WebDriver driver, String propertyValue) {
		
		try {
			
			  System.out.println("WRITE SB ACCOUNT CLOSURE SUMMARY");
			  element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
			  String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
			  System.out.println("Trans ID "+TransID);
					
				Connection con=(Connection) Common.DatabaseConnector();
				if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			            }
			             float TotalAmount=0;
					     String Principal=null;
							try {
								  Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[3]/td[9]")).getText();
								  float a= Float.parseFloat(Principal);
								  TotalAmount= a;
								   System.out.println("Total Amount"+TotalAmount);
								       
								        }catch (NumberFormatException e) {
								        	
								        	e.printStackTrace();
								        }
			        
			        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName=(String) ar.get(6);
				       GL_AccountNumber=(String) ar.get(7);
				       GL_AccDisplayName=(String) ar.get(8);
				       GL_BatchId=Integer.parseInt((String) ar.get(9));
					   GL_TransId=Integer.parseInt((String) ar.get(10));
					   GL_OrgId=Integer.parseInt((String) ar.get(11));
				        
				       
			 String Data2="select VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode from QaFnGetSummaryDetails ("+TransID+")";
	         ResultSet result= stmt.executeQuery(Data2);
	         System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(0));
				          GL_TranType1=(String) ar1.get(1);
				          GL_TransAmount1=(String) ar1.get(2);
				          GL_AmountType1=(String) ar1.get(3);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(4));
				          GL_TransferMode1=(String) ar1.get(5);
				          
				          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(6));
				          GL_TranType2=(String) ar1.get(7);
				          GL_TransAmount2=(String) ar1.get(8);
				          GL_AmountType2=(String) ar1.get(9);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(10));
				          GL_TransferMode2=(String) ar1.get(11);
				          
				          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(12));
				          GL_TranType3=(String) ar1.get(13);
				          GL_TransAmount3=(String) ar1.get(14);
				          GL_AmountType3=(String) ar1.get(15);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(16));
				          GL_TransferMode3=(String) ar1.get(17);
				          
				          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(18));
				          GL_TranType4=(String) ar1.get(19);
				          GL_TransAmount4=(String) ar1.get(20);
				          GL_AmountType4=(String) ar1.get(21);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(22));
				          GL_TransferMode4=(String) ar1.get(23);
				 	       
				          
				          
				 	      
				      Properties prop=new Properties();
				      FileOutputStream fos = new FileOutputStream("./DataFiles/FD_RENEWAL_CASH.properties");
				      
				      prop.setProperty("FDProductName",GL_ProductName);
				      prop.setProperty("FDAccountNumber", GL_AccountNumber);
				      prop.setProperty("FDAccountDisplayName",GL_AccDisplayName);
				      prop.setProperty("FDBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("FDTransId", String.valueOf(GL_TransId));
				      prop.setProperty("FDOrgId",String.valueOf (GL_OrgId));
				      
				      
				      prop.setProperty("FDVoucherNumber1",String.valueOf(GL_VoucherNumber1));
				      prop.setProperty("FDTranType1", GL_TranType1); 
				      prop.setProperty("FDTransAmount1",GL_TransAmount1);
				      prop.setProperty("FDAmountType1",GL_AmountType1);
				      prop.setProperty("FDGlAcCode1",String.valueOf (GL_GlAcCode1));
				      prop.setProperty("FDTransferMode1",GL_TransferMode1);
				      
				      
				      prop.setProperty("FDVoucherNumber2",String.valueOf(GL_VoucherNumber2));
				      prop.setProperty("FDTranType2", GL_TranType2); 
				      prop.setProperty("FDTransAmount2",GL_TransAmount2);
				      prop.setProperty("FDAmountType2",GL_AmountType2);
				      prop.setProperty("FDGlAcCode2",String.valueOf (GL_GlAcCode2));
				      prop.setProperty("FDTransferMode2",GL_TransferMode2);
				      
				      
				      prop.setProperty("FDVoucherNumber3",String.valueOf(GL_VoucherNumber3));
				      prop.setProperty("FDTranType3", GL_TranType3); 
				      prop.setProperty("FDTransAmount3",GL_TransAmount3);
				      prop.setProperty("FDAmountType3",GL_AmountType3);
				      prop.setProperty("FDGlAcCode3",String.valueOf (GL_GlAcCode3));
				      prop.setProperty("FDTransferMode3",GL_TransferMode3);
				      
				      prop.setProperty("FDVoucherNumber4",String.valueOf(GL_VoucherNumber4));
				      prop.setProperty("FDTranType4", GL_TranType4); 
				      prop.setProperty("FDTransAmount4",GL_TransAmount4);
				      prop.setProperty("FDAmountType4",GL_AmountType4);
				      prop.setProperty("FDGlAcCode4",String.valueOf (GL_GlAcCode4));
				      prop.setProperty("FDTransferMode4",GL_TransferMode4);
				      
				      prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
				      
				      
				      
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 public static WebDriver writeFDRenewal_Autopost(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE FD RENEWAL SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        
				        
				   String Data1="select BatchID,TransID,TrnMode from QaFnGetinterbranchSummaryDetails  ("+TransID+")";
				   ResultSet rslt= stmt.executeQuery(Data1);
				   System.out.println("SP1 EXECUTED");
				   while(rslt.next()) {
					   
					    
					   GL_BatchId=Integer.parseInt(rslt.getString(1));
					   GL_TransId=Integer.parseInt(rslt.getString(2));
					   GL_TransferMode=rslt.getString(3);
					   
			        }
					   
				         
	           String Data2="select VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,RespBranchID from QaFnGetinterbranchSummaryDetails ("+TransID+")";
	           ResultSet result= stmt.executeQuery(Data2);
	           System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(0));
				          GL_TranType1=(String) ar1.get(1);
				          GL_TransAmount1=(String) ar1.get(2);
				          GL_AmountType1=(String) ar1.get(3);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(4));
				          GL_OrgId1=Integer.parseInt((String) ar1.get(5));
				 	       
				          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(6));
				          GL_TranType2=(String) ar1.get(7);
				          GL_TransAmount2=(String) ar1.get(8);
				          GL_AmountType2=(String) ar1.get(9);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(10));
				          GL_OrgId2=Integer.parseInt((String) ar1.get(11));
				          
				          GL_VoucherNumber5=Integer.parseInt((String) ar1.get(12));
				          GL_TranType5=(String) ar1.get(13);
				          GL_TransAmount5=(String) ar1.get(14);
				          GL_AmountType5=(String) ar1.get(15);
				          GL_GlAcCode5=Integer.parseInt((String) ar1.get(16));
				          GL_OrgId5=Integer.parseInt((String) ar1.get(17));
				          
				          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(18));
				          GL_TranType3=(String) ar1.get(19);
				          GL_TransAmount3=(String) ar1.get(20);
				          GL_AmountType3=(String) ar1.get(21);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(22));
				          GL_OrgId3=Integer.parseInt((String) ar1.get(23));
				          
				          GL_VoucherNumber6=Integer.parseInt((String) ar1.get(24));
				          GL_TranType6=(String) ar1.get(25);
				          GL_TransAmount6=(String) ar1.get(26);
				          GL_AmountType6=(String) ar1.get(27);
				          GL_GlAcCode6=Integer.parseInt((String) ar1.get(28));
				          GL_OrgId6=Integer.parseInt((String) ar1.get(29));
				          
				          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(30));
				          GL_TranType4=(String) ar1.get(31);
				          GL_TransAmount4=(String) ar1.get(32);
				          GL_AmountType4=(String) ar1.get(33);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(34));
				          GL_OrgId4=Integer.parseInt((String) ar1.get(35));
				          
				          GL_VoucherNumber7=Integer.parseInt((String) ar1.get(36));
				          GL_TranType7=(String) ar1.get(37);
				          GL_TransAmount7=(String) ar1.get(38);
				          GL_AmountType7=(String) ar1.get(39);
				          GL_GlAcCode7=Integer.parseInt((String) ar1.get(40));
				          GL_OrgId7=Integer.parseInt((String) ar1.get(41));
				          
				          GL_VoucherNumber8=Integer.parseInt((String) ar1.get(42));
				          GL_TranType8=(String) ar1.get(43);
				          GL_TransAmount8=(String) ar1.get(44);
				          GL_AmountType8=(String) ar1.get(45);
				          GL_GlAcCode8=Integer.parseInt((String) ar1.get(46));
				          GL_OrgId8=Integer.parseInt((String) ar1.get(47));
				          
				 	      
				       
				            
				       
				       
				     Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/FD_RENEWAL_AUTOPOST.properties");
				      
	                  prop.setProperty("FDBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("FDTransId", String.valueOf(GL_TransId));
				      prop.setProperty("FDTransferMode",GL_TransferMode);
				      
				      
				      prop.setProperty("FDVoucherNumber1",String.valueOf(GL_VoucherNumber1));
				      prop.setProperty("FDTranType1", GL_TranType1);
				      prop.setProperty("FDTransAmount1",GL_TransAmount1);
				      prop.setProperty("FDAmountType1",GL_AmountType1);
				      prop.setProperty("FDGlAcCode1",String.valueOf (GL_GlAcCode1)); 
				      prop.setProperty("FDOrgId1",String.valueOf (GL_OrgId1));
				      
				      prop.setProperty("FDVoucherNumber2",String.valueOf(GL_VoucherNumber2));
				      prop.setProperty("FDTranType2", GL_TranType2); 
				      prop.setProperty("FDTransAmount2",GL_TransAmount2);
                      prop.setProperty("FDAmountType2",GL_AmountType2);
				      prop.setProperty("FDGlAcCode2",String.valueOf (GL_GlAcCode2)); 
				      prop.setProperty("FDOrgId2",String.valueOf (GL_OrgId2));
				      
				      prop.setProperty("FDVoucherNumber3",String.valueOf(GL_VoucherNumber3));
				      prop.setProperty("FDTranType3", GL_TranType3); 
				      prop.setProperty("FDTransAmount3",GL_TransAmount3);
				      prop.setProperty("FDAmountType3",GL_AmountType3);
				      prop.setProperty("FDGlAcCode3",String.valueOf (GL_GlAcCode3)); 
				      prop.setProperty("FDOrgId3",String.valueOf (GL_OrgId3));
				      
				      prop.setProperty("FDVoucherNumber4",String.valueOf(GL_VoucherNumber4));
				      prop.setProperty("FDTranType4", GL_TranType4);
				      prop.setProperty("FDTransAmount4",GL_TransAmount4);
				      prop.setProperty("FDAmountType4",GL_AmountType4);
				      prop.setProperty("FDGlAcCode4",String.valueOf (GL_GlAcCode4)); 
				      prop.setProperty("FDOrgId4",String.valueOf (GL_OrgId4));
				      
				      prop.setProperty("FDVoucherNumber5",String.valueOf(GL_VoucherNumber5));
				      prop.setProperty("FDTranType5", GL_TranType5);
				      prop.setProperty("FDTransAmount5",GL_TransAmount5);
                      prop.setProperty("FDAmountType5",GL_AmountType5);
				      prop.setProperty("FDGlAcCode5",String.valueOf (GL_GlAcCode5)); 
				      prop.setProperty("FDOrgId5",String.valueOf (GL_OrgId5));
				      
				      prop.setProperty("FDVoucherNumber6",String.valueOf(GL_VoucherNumber6));
				      prop.setProperty("FDTranType6", GL_TranType6);
				      prop.setProperty("FDTransAmount6",GL_TransAmount6);
                      prop.setProperty("FDAmountType6",GL_AmountType6);
				      prop.setProperty("FDGlAcCode6",String.valueOf (GL_GlAcCode6)); 
				      prop.setProperty("FDOrgId6",String.valueOf (GL_OrgId6));
				      
				      prop.setProperty("FDVoucherNumber7",String.valueOf(GL_VoucherNumber7));
				      prop.setProperty("FDTranType7", GL_TranType7);
				      prop.setProperty("FDTransAmount7",GL_TransAmount7);
                      prop.setProperty("FDAmountType7",GL_AmountType7);
				      prop.setProperty("FDGlAcCode7",String.valueOf (GL_GlAcCode7)); 
				      prop.setProperty("FDOrgId7",String.valueOf (GL_OrgId7));
				      
				      prop.setProperty("FDVoucherNumber8",String.valueOf(GL_VoucherNumber8));
				      prop.setProperty("FDTranType8", GL_TranType8);
				      prop.setProperty("FDTransAmount8",GL_TransAmount8);
                      prop.setProperty("FDAmountType8",GL_AmountType8);
				      prop.setProperty("FDGlAcCode8",String.valueOf (GL_GlAcCode8)); 
				      prop.setProperty("FDOrgId8",String.valueOf (GL_OrgId8));
				      
				      
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 
 public static WebDriver writeFDRenewal_Batch(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE FD RENEWAL SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        float TotalAmount=0;
					String Principal1=null;
					String Principal2=null;
					String Interest=null;
								try {
									  Principal1=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
									  Principal2=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[3]/td[9]")).getText();
									  Interest=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[4]/td[9]")).getText();
									  float a= Float.parseFloat(Principal1);
									  float b= Float.parseFloat(Principal2);
									  float c= Float.parseFloat(Interest);
									  TotalAmount= a-(b+c);
									   System.out.println("Total Amount"+TotalAmount);
									       
									        }catch (NumberFormatException e) {
									        	
									        	e.printStackTrace();
									        }
				        
				   String Data1="select ProductName,AcNo,AcDisplayName,BatchID,TransID,TrnMode,OrgBranchID from QaFnGetSummaryDetails  ("+TransID+")";
				   ResultSet rslt= stmt.executeQuery(Data1);
				   System.out.println("SP1 EXECUTED");
				   while(rslt.next()) {
					   
					   GL_ProductName=rslt.getString(1);
				       GL_AccountNumber=rslt.getString(2);
				       GL_AccDisplayName=rslt.getString(3);
					   GL_BatchId=Integer.parseInt(rslt.getString(4));
					   GL_TransId=Integer.parseInt(rslt.getString(5));
					   GL_TransferMode=rslt.getString(6);
					   GL_OrgId=Integer.parseInt(rslt.getString(7));
					   
			        }
					   
				         
	           String Data2="select VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
	           ResultSet result= stmt.executeQuery(Data2);
	           System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(0));
				          GL_TranType1=(String) ar1.get(1);
				          GL_TransAmount1=(String) ar1.get(2);
				          GL_AmountType1=(String) ar1.get(3);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(4));
				         
				 	       
				          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(5));
				          GL_TranType2=(String) ar1.get(6);
				          GL_TransAmount2=(String) ar1.get(7);
				          GL_AmountType2=(String) ar1.get(8);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(9));
				          
				          
				          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(10));
				          GL_TranType3=(String) ar1.get(11);
				          GL_TransAmount3=(String) ar1.get(12);
				          GL_AmountType3=(String) ar1.get(13);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(14));
				          
				          
				          
				          
				 	      
				       
				            
				       
				       
				     Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/FD_RENEWAL_BATCH.properties");
				      
				      
				      prop.setProperty("FDProductName",GL_ProductName);
				      prop.setProperty("FDAccountNumber", GL_AccountNumber);
				      prop.setProperty("FDAccountDisplayName",GL_AccDisplayName);
	                  prop.setProperty("FDBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("FDTransId", String.valueOf(GL_TransId));
				      prop.setProperty("FDTransferMode",GL_TransferMode);
				      prop.setProperty("FDOrgId",String.valueOf (GL_OrgId));
				      
				      
				      prop.setProperty("FDVoucherNumber1",String.valueOf(GL_VoucherNumber1));
				      prop.setProperty("FDTranType1", GL_TranType1);
				      prop.setProperty("FDTransAmount1",GL_TransAmount1);
				      prop.setProperty("FDAmountType1",GL_AmountType1);
				      prop.setProperty("FDGlAcCode1",String.valueOf (GL_GlAcCode1)); 
				     
				      
				      prop.setProperty("FDVoucherNumber2",String.valueOf(GL_VoucherNumber2));
				      prop.setProperty("FDTranType2", GL_TranType2); 
				      prop.setProperty("FDTransAmount2",GL_TransAmount2);
                      prop.setProperty("FDAmountType2",GL_AmountType2);
				      prop.setProperty("FDGlAcCode2",String.valueOf (GL_GlAcCode2)); 
				     
				      prop.setProperty("FDVoucherNumber3",String.valueOf(GL_VoucherNumber3));
				      prop.setProperty("FDTranType3", GL_TranType3); 
				      prop.setProperty("FDTransAmount3",GL_TransAmount3);
				      prop.setProperty("FDAmountType3",GL_AmountType3);
				      prop.setProperty("FDGlAcCode3",String.valueOf (GL_GlAcCode3)); 
				      
				      prop.setProperty("TotalAmount", String.valueOf(TotalAmount)); 
				      
				      
				      
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 
 public static WebDriver writeGLRenewal_Cash(WebDriver driver, String propertyValue) {
		
		try {
			
			  System.out.println("WRITE GL SUMMARY");
			  element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
			  String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
			  System.out.println("Trans ID "+TransID);
					
			  Connection con=(Connection) Common.DatabaseConnector();
			  if(con !=null) {
			  Statement stmt = con.createStatement();	
			        
			  String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			  ResultSet rs1= stmt.executeQuery(Q_datefetch);
			  System.out.println("FETCHED DATES");
			       
			  while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			  }
			        
			  String Data="select distinct  AcNo from QaFnGetSummaryDetails  ("+TransID+")";     
			  ResultSet rst= stmt.executeQuery(Data); 
			  System.out.println("SP1 EXECUTED");
			       
		          int row=rst.getRow();
				  ArrayList ar=new ArrayList<>();
				  ResultSetMetaData rsmd;
				       
				  try {
				        rsmd = rst.getMetaData();

				        int NumOfCol = rsmd.getColumnCount();
				                 
				               

				         while (rst.next()) {
				                  

				                for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                 }

				                     row++;
				          }
				                 
				                 
				     } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				       GL_AccountNumber2=(String) ar.get(0);
				       GL_AccountNumber1=(String) ar.get(1);
				        
				       
				   String Data1="select ProductName,AcDisplayName,BatchID,TransID,RespBranchID from QaFnGetSummaryDetails  ("+TransID+")";
				   ResultSet rslt= stmt.executeQuery(Data1);
				   System.out.println("SP2 EXECUTED");
				   while(rslt.next()) {
					   
					   GL_ProductName=rslt.getString(1);
					   GL_AccDisplayName=rslt.getString(2);
					   GL_BatchId=Integer.parseInt(rslt.getString(3));
					   GL_TransId=Integer.parseInt(rslt.getString(4));
					   GL_OrgId=Integer.parseInt(rslt.getString(5));
					   
			        }
					   
				         
	           String Data2="select VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode from QaFnGetSummaryDetails ("+TransID+")";
	           ResultSet result= stmt.executeQuery(Data2);
	           System.out.println("SP3 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(0));
				          GL_TranType3=(String) ar1.get(1);
				          GL_TransAmount3=(String) ar1.get(2);
				          GL_AmountType3=(String) ar1.get(3);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(4));
				          GL_TransferMode3=(String) ar1.get(5);
				 	       
				          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(6));
				          GL_TranType4=(String) ar1.get(7);
				          GL_TransAmount4=(String) ar1.get(8);
				          GL_AmountType4=(String) ar1.get(9);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(10));
				          GL_TransferMode4=(String) ar1.get(11);
				          
				          GL_VoucherNumber5=Integer.parseInt((String) ar1.get(12));
				          GL_TranType5=(String) ar1.get(13);
				          GL_TransAmount5=(String) ar1.get(14);
				          GL_AmountType5=(String) ar1.get(15);
				          GL_GlAcCode5=Integer.parseInt((String) ar1.get(16));
				          GL_TransferMode5=(String) ar1.get(17);
				          
				          GL_VoucherNumber6=Integer.parseInt((String) ar1.get(18));
				          GL_TranType6=(String) ar1.get(19);
				          GL_TransAmount6=(String) ar1.get(20);
				          GL_AmountType6=(String) ar1.get(21);
				          GL_GlAcCode6=Integer.parseInt((String) ar1.get(22));
				          GL_TransferMode6=(String) ar1.get(23);
				          
				          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(24));
				          GL_TranType2=(String) ar1.get(25);
				          GL_TransAmount2=(String) ar1.get(26);
				          GL_AmountType2=(String) ar1.get(27);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(28));
				          GL_TransferMode2=(String) ar1.get(29);
				          
				          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(30));
				          GL_TranType1=(String) ar1.get(31);
				          GL_TransAmount1=(String) ar1.get(32);
				          GL_AmountType1=(String) ar1.get(33);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(34));
				          GL_TransferMode1=(String) ar1.get(35);
				          
				 	      
				       
				      Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/GL_RENEWAL_CASH.properties");
				      
				      prop.setProperty("GLProductName",GL_ProductName);
				      prop.setProperty("GLAccountNumber1", GL_AccountNumber1);
				      prop.setProperty("GLAccountNumber2", GL_AccountNumber2);
				      prop.setProperty("GLAccountDisplayName",GL_AccDisplayName);
				      prop.setProperty("GLBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("GLTransId", String.valueOf(GL_TransId));
				      prop.setProperty("GLOrgId",String.valueOf (GL_OrgId));

				      
				      prop.setProperty("GLVoucherNumber1",String.valueOf(GL_VoucherNumber1));
				      prop.setProperty("GLTranType1", GL_TranType1); 
				      prop.setProperty("GLTransAmount1",GL_TransAmount1);
				      prop.setProperty("GLAmountType1",GL_AmountType1);
				      prop.setProperty("GLGlAcCode1",String.valueOf (GL_GlAcCode1)); 
				      prop.setProperty("GLTransferMode1",GL_TransferMode1);
				      
				      prop.setProperty("GLVoucherNumber2",String.valueOf(GL_VoucherNumber2));
				      prop.setProperty("GLTranType2", GL_TranType2);
				      prop.setProperty("GLTransAmount2",GL_TransAmount2);
				      prop.setProperty("GLAmountType2",GL_AmountType2);
				      prop.setProperty("GLGlAcCode2",String.valueOf (GL_GlAcCode2)); 
				      prop.setProperty("GLTransferMode2",GL_TransferMode2);
				      
				      prop.setProperty("GLVoucherNumber3",String.valueOf(GL_VoucherNumber3));
				      prop.setProperty("GLTranType3", GL_TranType3);
				      prop.setProperty("GLTransAmount3",GL_TransAmount3);
				      prop.setProperty("GLAmountType3",GL_AmountType3);
				      prop.setProperty("GLGlAcCode3",String.valueOf (GL_GlAcCode3)); 
				      prop.setProperty("GLTransferMode3",GL_TransferMode3);
				      
				      prop.setProperty("GLVoucherNumber4",String.valueOf(GL_VoucherNumber4));
				      prop.setProperty("GLTranType4", GL_TranType4);
				      prop.setProperty("GLTransAmount4",GL_TransAmount4);
				      prop.setProperty("GLAmountType4",GL_AmountType4);
				      prop.setProperty("GLGlAcCode4",String.valueOf (GL_GlAcCode4)); 
				      prop.setProperty("GLTransferMode4",GL_TransferMode4);
				      
				      prop.setProperty("GLVoucherNumber5",String.valueOf(GL_VoucherNumber5));
				      prop.setProperty("GLTranType5", GL_TranType5);
				      prop.setProperty("GLTransAmount5",GL_TransAmount5);
				      prop.setProperty("GLAmountType5",GL_AmountType5);
				      prop.setProperty("GLGlAcCode5",String.valueOf (GL_GlAcCode5)); 
				      prop.setProperty("GLTransferMode5",GL_TransferMode5);
				      
				      
				      prop.setProperty("GLVoucherNumber6",String.valueOf(GL_VoucherNumber6));
				      prop.setProperty("GLTranType6",GL_TranType6);
				      prop.setProperty("GLTransAmount6",GL_TransAmount6);
				      prop.setProperty("GLAmountType6",GL_AmountType6);
				      prop.setProperty("GLGlAcCode6",String.valueOf (GL_GlAcCode6)); 
				      prop.setProperty("GLTransferMode6",GL_TransferMode6);
				      
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 public static WebDriver writeGLRenewal_Batch(WebDriver driver, String propertyValue) {
		
		try {
			
			  System.out.println("WRITE GL SUMMARY");
			  element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
			  String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
			  System.out.println("Trans ID "+TransID);
					
			  Connection con=(Connection) Common.DatabaseConnector();
			  if(con !=null) {
			  Statement stmt = con.createStatement();	
			        
			  String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			  ResultSet rs1= stmt.executeQuery(Q_datefetch);
			  System.out.println("FETCHED DATES");
			       
			  while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			  }
			  float TotalAmount=0;
			  String Principal1=null;
			  String Principal2=null;
			  String Appraisal=null;
			  String Interest=null;
			  String fine=null;
							try {
								  Principal1=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
								  Appraisal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[3]/td[9]")).getText();
								  Principal2=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[4]/td[9]")).getText();
								  Interest=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[5]/td[9]")).getText();
								  fine=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[6]/td[9]")).getText();
								  float a= Float.parseFloat(Principal1);
								  float b= Float.parseFloat(Appraisal);
								  float c= Float.parseFloat(Principal2);
								  float d= Float.parseFloat(Interest);
								  float e= Float.parseFloat(fine);
								  TotalAmount=(b+c+d+e)-a;
								   System.out.println("Total Amount"+TotalAmount);
								       
								        }catch (NumberFormatException e) {
								        	
								        	e.printStackTrace();
								        }
			        
			  String Data="select distinct  AcNo from QaFnGetSummaryDetails  ("+TransID+")";     
			  ResultSet rst= stmt.executeQuery(Data); 
			  System.out.println("SP1 EXECUTED");
			       
		          int row=rst.getRow();
				  ArrayList ar=new ArrayList<>();
				  ResultSetMetaData rsmd;
				       
				  try {
				        rsmd = rst.getMetaData();

				        int NumOfCol = rsmd.getColumnCount();
				                 
				               

				         while (rst.next()) {
				                  

				                for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                 }

				                     row++;
				          }
				                 
				                 
				     } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				       GL_AccountNumber2=(String) ar.get(0);
				       GL_AccountNumber1=(String) ar.get(1);
				        
				       
				   String Data1="select ProductName,AcDisplayName,BatchID,TransID,TrnMode,RespBranchID from QaFnGetSummaryDetails  ("+TransID+")";
				   ResultSet rslt= stmt.executeQuery(Data1);
				   System.out.println("SP2 EXECUTED");
				   while(rslt.next()) {
					   
					   GL_ProductName=rslt.getString(1);
					   GL_AccDisplayName=rslt.getString(2);
					   GL_BatchId=Integer.parseInt(rslt.getString(3));
					   GL_TransId=Integer.parseInt(rslt.getString(4));
					   GL_TransferMode=rslt.getString(5);
					   GL_OrgId=Integer.parseInt(rslt.getString(6));
					   
			        }
					   
				         
	           String Data2="select VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
	           ResultSet result= stmt.executeQuery(Data2);
	           System.out.println("SP3 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(0));
				          GL_TranType3=(String) ar1.get(1);
				          GL_TransAmount3=(String) ar1.get(2);
				          GL_AmountType3=(String) ar1.get(3);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(4));
				          
				 	       
				          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(5));
				          GL_TranType1=(String) ar1.get(6);
				          GL_TransAmount1=(String) ar1.get(7);
				          GL_AmountType1=(String) ar1.get(8);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(9));
				          
				          
				          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(10));
				          GL_TranType4=(String) ar1.get(11);
				          GL_TransAmount4=(String) ar1.get(12);
				          GL_AmountType4=(String) ar1.get(13);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(14));
				         
				          
				          GL_VoucherNumber5=Integer.parseInt((String) ar1.get(15));
				          GL_TranType5=(String) ar1.get(16);
				          GL_TransAmount5=(String) ar1.get(17);
				          GL_AmountType5=(String) ar1.get(18);
				          GL_GlAcCode5=Integer.parseInt((String) ar1.get(19));
				          
				          
				          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(20));
				          GL_TranType2=(String) ar1.get(21);
				          GL_TransAmount2=(String) ar1.get(22);
				          GL_AmountType2=(String) ar1.get(23);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(24));
				          
				          
				          
				         
				      Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/GL_RENEWAL_BATCH.properties");
				      
				      prop.setProperty("GLProductName",GL_ProductName);
				      prop.setProperty("GLAccountNumber1", GL_AccountNumber1);
				      prop.setProperty("GLAccountNumber2", GL_AccountNumber2);
				      prop.setProperty("GLAccountDisplayName",GL_AccDisplayName);
				      prop.setProperty("GLBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("GLTransId", String.valueOf(GL_TransId));
				      prop.setProperty("GLTransferMode",GL_TransferMode);
				      prop.setProperty("GLOrgId",String.valueOf (GL_OrgId));

				      
				      prop.setProperty("GLVoucherNumber1",String.valueOf(GL_VoucherNumber1));
				      prop.setProperty("GLTranType1", GL_TranType1); 
				      prop.setProperty("GLTransAmount1",GL_TransAmount1);
				      prop.setProperty("GLAmountType1",GL_AmountType1);
				      prop.setProperty("GLGlAcCode1",String.valueOf (GL_GlAcCode1)); 
				      
				      prop.setProperty("GLVoucherNumber2",String.valueOf(GL_VoucherNumber2));
				      prop.setProperty("GLTranType2", GL_TranType2);
				      prop.setProperty("GLTransAmount2",GL_TransAmount2);
				      prop.setProperty("GLAmountType2",GL_AmountType2);
				      prop.setProperty("GLGlAcCode2",String.valueOf (GL_GlAcCode2)); 
				      
				      prop.setProperty("GLVoucherNumber3",String.valueOf(GL_VoucherNumber3));
				      prop.setProperty("GLTranType3", GL_TranType3);
				      prop.setProperty("GLTransAmount3",GL_TransAmount3);
				      prop.setProperty("GLAmountType3",GL_AmountType3);
				      prop.setProperty("GLGlAcCode3",String.valueOf (GL_GlAcCode3)); 
				      
				      prop.setProperty("GLVoucherNumber4",String.valueOf(GL_VoucherNumber4));
				      prop.setProperty("GLTranType4", GL_TranType4);
				      prop.setProperty("GLTransAmount4",GL_TransAmount4);
				      prop.setProperty("GLAmountType4",GL_AmountType4);
				      prop.setProperty("GLGlAcCode4",String.valueOf (GL_GlAcCode4));
				      
				      
				      prop.setProperty("GLVoucherNumber5",String.valueOf(GL_VoucherNumber5));
				      prop.setProperty("GLTranType5", GL_TranType5);
				      prop.setProperty("GLTransAmount5",GL_TransAmount5);
				      prop.setProperty("GLAmountType5",GL_AmountType5);
				      prop.setProperty("GLGlAcCode5",String.valueOf (GL_GlAcCode5));
				      
				      prop.setProperty("TotalAmount", String.valueOf(TotalAmount)); 
				      
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 
 public static WebDriver writeGLRenewal_Autopost(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE GL RENEWAL SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        
				        
				   String Data1="select BatchID,TransID,TrnMode from QaFnGetinterbranchSummaryDetails  ("+TransID+")";
				   ResultSet rslt= stmt.executeQuery(Data1);
				   System.out.println("SP1 EXECUTED");
				   while(rslt.next()) {
					   
					    
					   GL_BatchId=Integer.parseInt(rslt.getString(1));
					   GL_TransId=Integer.parseInt(rslt.getString(2));
					   GL_TransferMode=rslt.getString(3);
					   
			        }
					   
				         
	           String Data2="select VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,RespBranchID from QaFnGetinterbranchSummaryDetails ("+TransID+")";
	           ResultSet result= stmt.executeQuery(Data2);
	           System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          GL_VoucherNumber6=Integer.parseInt((String) ar1.get(0));
				          GL_TranType6=(String) ar1.get(1);
				          GL_TransAmount6=(String) ar1.get(2);
				          GL_AmountType6=(String) ar1.get(3);
				          GL_GlAcCode6=Integer.parseInt((String) ar1.get(4));
				          GL_OrgId6=Integer.parseInt((String) ar1.get(5));
				 	       
				          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(6));
				          GL_TranType1=(String) ar1.get(7);
				          GL_TransAmount1=(String) ar1.get(8);
				          GL_AmountType1=(String) ar1.get(9);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(10));
				          GL_OrgId1=Integer.parseInt((String) ar1.get(11));
				          
				          GL_VoucherNumber7=Integer.parseInt((String) ar1.get(12));
				          GL_TranType7=(String) ar1.get(13);
				          GL_TransAmount7=(String) ar1.get(14);
				          GL_AmountType7=(String) ar1.get(15);
				          GL_GlAcCode7=Integer.parseInt((String) ar1.get(16));
				          GL_OrgId7=Integer.parseInt((String) ar1.get(17));
				          
				          GL_VoucherNumber8=Integer.parseInt((String) ar1.get(18));
				          GL_TranType8=(String) ar1.get(19);
				          GL_TransAmount8=(String) ar1.get(20);
				          GL_AmountType8=(String) ar1.get(21);
				          GL_GlAcCode8=Integer.parseInt((String) ar1.get(22));
				          GL_OrgId8=Integer.parseInt((String) ar1.get(23));
				          
				          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(24));
				          GL_TranType4=(String) ar1.get(25);
				          GL_TransAmount4=(String) ar1.get(26);
				          GL_AmountType4=(String) ar1.get(27);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(28));
				          GL_OrgId4=Integer.parseInt((String) ar1.get(29));
				          
				          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(30));
				          GL_TranType3=(String) ar1.get(31);
				          GL_TransAmount3=(String) ar1.get(32);
				          GL_AmountType3=(String) ar1.get(33);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(34));
				          GL_OrgId3=Integer.parseInt((String) ar1.get(35));
				          
				          GL_VoucherNumber5=Integer.parseInt((String) ar1.get(36));
				          GL_TranType5=(String) ar1.get(37);
				          GL_TransAmount5=(String) ar1.get(38);
				          GL_AmountType5=(String) ar1.get(39);
				          GL_GlAcCode5=Integer.parseInt((String) ar1.get(40));
				          GL_OrgId5=Integer.parseInt((String) ar1.get(41));
				          
				          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(42));
				          GL_TranType2=(String) ar1.get(43);
				          GL_TransAmount2=(String) ar1.get(44);
				          GL_AmountType2=(String) ar1.get(45);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(46));
				          GL_OrgId2=Integer.parseInt((String) ar1.get(47));
				          
				          
				          
				 	      
				       
				      Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/GL_RENEWAL_AUTOPOST.properties");
				      
	                  prop.setProperty("GLBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("GLTransId", String.valueOf(GL_TransId));
				      prop.setProperty("GLTransferMode",GL_TransferMode);
				      
				      
				      prop.setProperty("GLVoucherNumber1",String.valueOf(GL_VoucherNumber1));
				      prop.setProperty("GLTranType1", GL_TranType1);
				      prop.setProperty("GLTransAmount1",GL_TransAmount1);
				      prop.setProperty("GLAmountType1",GL_AmountType1);
				      prop.setProperty("GLGlAcCode1",String.valueOf (GL_GlAcCode1)); 
				      prop.setProperty("GLOrgId1",String.valueOf (GL_OrgId1));
				      
				      prop.setProperty("GLVoucherNumber2",String.valueOf(GL_VoucherNumber2));
				      prop.setProperty("GLTranType2", GL_TranType2); 
				      prop.setProperty("GLTransAmount2",GL_TransAmount2);
                      prop.setProperty("GLAmountType2",GL_AmountType2);
				      prop.setProperty("GLGlAcCode2",String.valueOf (GL_GlAcCode2)); 
				      prop.setProperty("GLOrgId2",String.valueOf (GL_OrgId2));
				      
				      prop.setProperty("GLVoucherNumber3",String.valueOf(GL_VoucherNumber3));
				      prop.setProperty("GLTranType3", GL_TranType3); 
				      prop.setProperty("GLTransAmount3",GL_TransAmount3);
				      prop.setProperty("GLAmountType3",GL_AmountType3);
				      prop.setProperty("GLGlAcCode3",String.valueOf (GL_GlAcCode3)); 
				      prop.setProperty("GLOrgId3",String.valueOf (GL_OrgId3));
				      
				      prop.setProperty("GLVoucherNumber4",String.valueOf(GL_VoucherNumber4));
				      prop.setProperty("GLTranType4", GL_TranType4);
				      prop.setProperty("GLTransAmount4",GL_TransAmount4);
				      prop.setProperty("GLAmountType4",GL_AmountType4);
				      prop.setProperty("GLGlAcCode4",String.valueOf (GL_GlAcCode4)); 
				      prop.setProperty("GLOrgId4",String.valueOf (GL_OrgId4));
				      
				      prop.setProperty("GLVoucherNumber5",String.valueOf(GL_VoucherNumber5));
				      prop.setProperty("GLTranType5", GL_TranType5);
				      prop.setProperty("GLTransAmount5",GL_TransAmount5);
                      prop.setProperty("GLAmountType5",GL_AmountType5);
				      prop.setProperty("GLGlAcCode5",String.valueOf (GL_GlAcCode5)); 
				      prop.setProperty("GLOrgId5",String.valueOf (GL_OrgId5));
				      
				      prop.setProperty("GLVoucherNumber6",String.valueOf(GL_VoucherNumber6));
				      prop.setProperty("GLTranType6", GL_TranType6);
				      prop.setProperty("GLTransAmount6",GL_TransAmount6);
                      prop.setProperty("GLAmountType6",GL_AmountType6);
				      prop.setProperty("GLGlAcCode6",String.valueOf (GL_GlAcCode6)); 
				      prop.setProperty("GLOrgId6",String.valueOf (GL_OrgId6));
				      
				      prop.setProperty("GLVoucherNumber7",String.valueOf(GL_VoucherNumber7));
				      prop.setProperty("GLTranType7", GL_TranType7);
				      prop.setProperty("GLTransAmount7",GL_TransAmount7);
                      prop.setProperty("GLAmountType7",GL_AmountType7);
				      prop.setProperty("GLGlAcCode7",String.valueOf (GL_GlAcCode7)); 
				      prop.setProperty("GLOrgId7",String.valueOf (GL_OrgId7));
				      
				      prop.setProperty("GLVoucherNumber8",String.valueOf(GL_VoucherNumber8));
				      prop.setProperty("GLTranType8", GL_TranType8);
				      prop.setProperty("GLTransAmount8",GL_TransAmount8);
                      prop.setProperty("GLAmountType8",GL_AmountType8);
				      prop.setProperty("GLGlAcCode8",String.valueOf (GL_GlAcCode8)); 
				      prop.setProperty("GLOrgId8",String.valueOf (GL_OrgId8));
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 public static WebDriver writeOLClosure_Cash(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE OTHER LOAN CLOSURE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName=(String) ar.get(0);
				       GL_AccountNumber=(String) ar.get(1);
				       GL_AccDisplayName=(String) ar.get(2);
				       GL_BatchId=Integer.parseInt((String) ar.get(3));
					   GL_TransId=Integer.parseInt((String) ar.get(4));
					   GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
				       GL_TranType=(String) ar.get(6);
					   GL_TransferMode=(String) ar.get(7);
					   GL_OrgId=Integer.parseInt((String) ar.get(8));
				        
				       
			 String Data2="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
	         ResultSet result= stmt.executeQuery(Data2);
	         System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          
				          GL_TransAmount1=(String) ar1.get(0);
				          GL_AmountType1=(String) ar1.get(1);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
				         
				          
				          GL_TransAmount2=(String) ar1.get(3);
				          GL_AmountType2=(String) ar1.get(4);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
				          
				          GL_TransAmount3=(String) ar1.get(6);
				          GL_AmountType3=(String) ar1.get(7);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(8));
				          
				          
				      Properties prop=new Properties();
				      FileOutputStream fos = new FileOutputStream("./DataFiles/OL_CLOSURE_CASH.properties");
				      
				      prop.setProperty("OLProductName",GL_ProductName);
				      prop.setProperty("OLAccountNumber", GL_AccountNumber);
				      prop.setProperty("OLDisplayName",GL_AccDisplayName);
				      prop.setProperty("OLBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("OLTransId", String.valueOf(GL_TransId));
				      prop.setProperty("OLVoucherNumber",String.valueOf(GL_VoucherNumber));
				      prop.setProperty("OLTranType", GL_TranType); 
				      prop.setProperty("OLTransferMode",GL_TransferMode);
				      prop.setProperty("OLOrgId",String.valueOf (GL_OrgId));
				      
				      prop.setProperty("OLTransAmount1",GL_TransAmount1);
				      prop.setProperty("OLAmountType1",GL_AmountType1);
				      prop.setProperty("OLGlAcCode1",String.valueOf (GL_GlAcCode1));
				      
				      prop.setProperty("OLTransAmount2",GL_TransAmount2);
				      prop.setProperty("OLAmountType2",GL_AmountType2);
				      prop.setProperty("OLGlAcCode2",String.valueOf (GL_GlAcCode2));
				      
				      prop.setProperty("OLTransAmount3",GL_TransAmount3);
				      prop.setProperty("OLAmountType3",GL_AmountType3);
				      prop.setProperty("OLGlAcCode3",String.valueOf (GL_GlAcCode3));
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 public static WebDriver writeODClosure_Cash(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE OVERDRAFT LOAN CLOSURE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName=(String) ar.get(0);
				       GL_AccountNumber=(String) ar.get(1);
				       GL_AccDisplayName=(String) ar.get(2);
				       GL_BatchId=Integer.parseInt((String) ar.get(3));
					   GL_TransId=Integer.parseInt((String) ar.get(4));
					   GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
				       GL_TranType=(String) ar.get(6);
					   GL_TransferMode=(String) ar.get(7);
					   GL_OrgId=Integer.parseInt((String) ar.get(8));
				        
				       
			 String Data2="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
	         ResultSet result= stmt.executeQuery(Data2);
	         System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          
				          GL_TransAmount1=(String) ar1.get(0);
				          GL_AmountType1=(String) ar1.get(1);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
				         
				          
				          GL_TransAmount2=(String) ar1.get(3);
				          GL_AmountType2=(String) ar1.get(4);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
				          
				          GL_TransAmount3=(String) ar1.get(6);
				          GL_AmountType3=(String) ar1.get(7);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(8));
				          
				          
				      Properties prop=new Properties();
				      FileOutputStream fos = new FileOutputStream("./DataFiles/OD_CLOSURE_CASH.properties");
				      
				      prop.setProperty("ODProductName",GL_ProductName);
				      prop.setProperty("ODAccountNumber", GL_AccountNumber);
				      prop.setProperty("ODDisplayName",GL_AccDisplayName);
				      prop.setProperty("ODBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("ODTransId", String.valueOf(GL_TransId));
				      prop.setProperty("ODVoucherNumber",String.valueOf(GL_VoucherNumber));
				      prop.setProperty("ODTranType", GL_TranType); 
				      prop.setProperty("ODTransferMode",GL_TransferMode);
				      prop.setProperty("ODOrgId",String.valueOf (GL_OrgId));
				      
				      prop.setProperty("ODTransAmount1",GL_TransAmount1);
				      prop.setProperty("ODAmountType1",GL_AmountType1);
				      prop.setProperty("ODGlAcCode1",String.valueOf (GL_GlAcCode1));
				      
				      prop.setProperty("ODTransAmount2",GL_TransAmount2);
				      prop.setProperty("ODAmountType2",GL_AmountType2);
				      prop.setProperty("ODGlAcCode2",String.valueOf (GL_GlAcCode2));
				      
				      prop.setProperty("ODTransAmount3",GL_TransAmount3);
				      prop.setProperty("ODAmountType3",GL_AmountType3);
				      prop.setProperty("ODGlAcCode3",String.valueOf (GL_GlAcCode3));
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 public static WebDriver writeDLClosure_Cash(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE DEPOSIT LOAN CLOSURE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName=(String) ar.get(0);
				       GL_AccountNumber=(String) ar.get(1);
				       GL_AccDisplayName=(String) ar.get(2);
				       GL_BatchId=Integer.parseInt((String) ar.get(3));
					   GL_TransId=Integer.parseInt((String) ar.get(4));
					   GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
				       GL_TranType=(String) ar.get(6);
					   GL_TransferMode=(String) ar.get(7);
					   GL_OrgId=Integer.parseInt((String) ar.get(8));
				        
				       
			 String Data2="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
	         ResultSet result= stmt.executeQuery(Data2);
	         System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          
				          GL_TransAmount1=(String) ar1.get(0);
				          GL_AmountType1=(String) ar1.get(1);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
				         
				          
				          GL_TransAmount2=(String) ar1.get(3);
				          GL_AmountType2=(String) ar1.get(4);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
				          
				          
				          
				          
				      Properties prop=new Properties();
				      FileOutputStream fos = new FileOutputStream("./DataFiles/DL_CLOSURE_CASH.properties");
				      
				      prop.setProperty("DLProductName",GL_ProductName);
				      prop.setProperty("DLAccountNumber", GL_AccountNumber);
				      prop.setProperty("DLDisplayName",GL_AccDisplayName);
				      prop.setProperty("DLBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("DLTransId", String.valueOf(GL_TransId));
				      prop.setProperty("DLVoucherNumber",String.valueOf(GL_VoucherNumber));
				      prop.setProperty("DLTranType", GL_TranType); 
				      prop.setProperty("DLTransferMode",GL_TransferMode);
				      prop.setProperty("DLOrgId",String.valueOf (GL_OrgId));
				      
				      prop.setProperty("DLTransAmount1",GL_TransAmount1);
				      prop.setProperty("DLAmountType1",GL_AmountType1);
				      prop.setProperty("DLGlAcCode1",String.valueOf (GL_GlAcCode1));
				      
				      prop.setProperty("DLTransAmount2",GL_TransAmount2);
				      prop.setProperty("DLAmountType2",GL_AmountType2);
				      prop.setProperty("DLGlAcCode2",String.valueOf (GL_GlAcCode2));
				      
				      
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 
 public static WebDriver writeGLClosure_Cash(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE JEWEL LOAN CLOSURE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName=(String) ar.get(0);
				       GL_AccountNumber=(String) ar.get(1);
				       GL_AccDisplayName=(String) ar.get(2);
				       GL_BatchId=Integer.parseInt((String) ar.get(3));
					   GL_TransId=Integer.parseInt((String) ar.get(4));
					   GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
				       GL_TranType=(String) ar.get(6);
					   GL_TransferMode=(String) ar.get(7);
					   GL_OrgId=Integer.parseInt((String) ar.get(8));
				        
				       
			 String Data2="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
	         ResultSet result= stmt.executeQuery(Data2);
	         System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          
				          GL_TransAmount1=(String) ar1.get(0);
				          GL_AmountType1=(String) ar1.get(1);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
				         
				          
				          GL_TransAmount2=(String) ar1.get(3);
				          GL_AmountType2=(String) ar1.get(4);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
				          
				          GL_TransAmount3=(String) ar1.get(6);
				          GL_AmountType3=(String) ar1.get(7);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(8));
				          
				          
				      Properties prop=new Properties();
				      FileOutputStream fos = new FileOutputStream("./DataFiles/GL_CLOSURE_CASH.properties");
				      
				      prop.setProperty("GLProductName",GL_ProductName);
				      prop.setProperty("GLAccountNumber", GL_AccountNumber);
				      prop.setProperty("GLDisplayName",GL_AccDisplayName);
				      prop.setProperty("GLBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("GLTransId", String.valueOf(GL_TransId));
				      prop.setProperty("GLVoucherNumber",String.valueOf(GL_VoucherNumber));
				      prop.setProperty("GLTranType", GL_TranType); 
				      prop.setProperty("GLTransferMode",GL_TransferMode);
				      prop.setProperty("GLOrgId",String.valueOf (GL_OrgId));
				      
				      prop.setProperty("GLTransAmount1",GL_TransAmount1);
				      prop.setProperty("GLAmountType1",GL_AmountType1);
				      prop.setProperty("GLGlAcCode1",String.valueOf (GL_GlAcCode1));
				      
				      prop.setProperty("GLTransAmount2",GL_TransAmount2);
				      prop.setProperty("GLAmountType2",GL_AmountType2);
				      prop.setProperty("GLGlAcCode2",String.valueOf (GL_GlAcCode2));
				      
				      prop.setProperty("GLTransAmount3",GL_TransAmount3);
				      prop.setProperty("GLAmountType3",GL_AmountType3);
				      prop.setProperty("GLGlAcCode3",String.valueOf (GL_GlAcCode3));
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 public static WebDriver writeOLClosure_Autopost(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select distinct  ProductName,AcNo,AcDisplayName from QaFnGetinterbranchSummaryDetails  ("+TransID+")";     
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName1=(String) ar.get(3);
				       GL_AccountNumber1=(String) ar.get(4);
				       GL_AccDisplayName1=(String) ar.get(5);
				       GL_ProductName2=(String) ar.get(0);
				       GL_AccountNumber2=(String) ar.get(1);
				       GL_AccDisplayName2=(String) ar.get(2);  
				       
				   String Data1="select BatchID,TransID,TrnMode from QaFnGetinterbranchSummaryDetails  ("+TransID+")";
				   ResultSet rslt= stmt.executeQuery(Data1);
				   System.out.println("SP2 EXECUTED");
				   while(rslt.next()) {
			        	
					   GL_BatchId=Integer.parseInt(rslt.getString(1));
					   GL_TransId=Integer.parseInt(rslt.getString(2));
					   GL_TransferMode=rslt.getString(3);
					   
			        }
					   
				         
		  String Data2="select VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,RespBranchID from QaFnGetinterbranchSummaryDetails ("+TransID+")";
          ResultSet result= stmt.executeQuery(Data2);
          System.out.println("SP3 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(0));
				          GL_TranType2=(String) ar1.get(1);
				          GL_TransAmount2=(String) ar1.get(2);
				          GL_AmountType2=(String) ar1.get(3);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(4));
				          GL_OrgId2=Integer.parseInt((String) ar1.get(5));
				 	       
				          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(6));
				          GL_TranType1=(String) ar1.get(7);
				          GL_TransAmount1=(String) ar1.get(8);
				          GL_AmountType1=(String) ar1.get(9);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(10));
				          GL_OrgId1=Integer.parseInt((String) ar1.get(11));
				          
				          GL_VoucherNumber6=Integer.parseInt((String) ar1.get(12));
				          GL_TranType6=(String) ar1.get(13);
				          GL_TransAmount6=(String) ar1.get(14);
				          GL_AmountType6=(String) ar1.get(15);
				          GL_GlAcCode6=Integer.parseInt((String) ar1.get(16));
				          GL_OrgId6=Integer.parseInt((String) ar1.get(17));
				          
				          GL_VoucherNumber5=Integer.parseInt((String) ar1.get(18));
				          GL_TranType5=(String) ar1.get(19);
				          GL_TransAmount5=(String) ar1.get(20);
				          GL_AmountType5=(String) ar1.get(21);
				          GL_GlAcCode5=Integer.parseInt((String) ar1.get(22));
				          GL_OrgId5=Integer.parseInt((String) ar1.get(23));
				          
				          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(24));
				          GL_TranType3=(String) ar1.get(25);
				          GL_TransAmount3=(String) ar1.get(26);
				          GL_AmountType3=(String) ar1.get(27);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(28));
				          GL_OrgId3=Integer.parseInt((String) ar1.get(29));
				          
				          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(30));
				          GL_TranType4=(String) ar1.get(31);
				          GL_TransAmount4=(String) ar1.get(32);
				          GL_AmountType4=(String) ar1.get(33);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(34));
				          GL_OrgId4=Integer.parseInt((String) ar1.get(35));
				          
				          GL_VoucherNumber7=Integer.parseInt((String) ar1.get(36));
				          GL_TranType7=(String) ar1.get(37);
				          GL_TransAmount7=(String) ar1.get(38);
				          GL_AmountType7=(String) ar1.get(39);
				          GL_GlAcCode7=Integer.parseInt((String) ar1.get(40));
				          GL_OrgId7=Integer.parseInt((String) ar1.get(41));
				          
				 	      
				      Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/OLCLOSURE_AUTOPOST.properties");
				      prop.setProperty("OL_ProductName1",GL_ProductName1);
				      prop.setProperty("OL_AccountNumber1", GL_AccountNumber1);
				      prop.setProperty("OL_DisplayName1",GL_AccDisplayName1);
				      prop.setProperty("OL_ProductName2",GL_ProductName2);
				      prop.setProperty("OL_AccountNumber2", GL_AccountNumber2);
				      prop.setProperty("OL_DisplayName2",GL_AccDisplayName2);
				      prop.setProperty("OL_BatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("OL_TransId", String.valueOf(GL_TransId));
				      prop.setProperty("OL_TransferMode",GL_TransferMode);
				      
				      
				      prop.setProperty("OL_VoucherNumber1",String.valueOf(GL_VoucherNumber1));
				      prop.setProperty("OL_TranType1", GL_TranType1); 
				      prop.setProperty("OL_TransAmount1",GL_TransAmount1);
				      prop.setProperty("OL_AmountType1",GL_AmountType1);
				      prop.setProperty("OL_GlAcCode1",String.valueOf (GL_GlAcCode1)); 
				      prop.setProperty("OL_OrgId1",String.valueOf (GL_OrgId1));
				      
				      prop.setProperty("OL_VoucherNumber2",String.valueOf(GL_VoucherNumber2));
				      prop.setProperty("OL_TranType2", GL_TranType2); 
				      prop.setProperty("OL_TransAmount2",GL_TransAmount2);
				      prop.setProperty("OL_AmountType2",GL_AmountType2);
				      prop.setProperty("OL_GlAcCode2",String.valueOf (GL_GlAcCode2)); 
				      prop.setProperty("OL_OrgId2",String.valueOf (GL_OrgId2));
				      
				      prop.setProperty("OL_VoucherNumber3",String.valueOf(GL_VoucherNumber3));
				      prop.setProperty("OL_TranType3", GL_TranType3); 
				      prop.setProperty("OL_TransAmount3",GL_TransAmount3);
				      prop.setProperty("OL_AmountType3",GL_AmountType3);
				      prop.setProperty("OL_GlAcCode3",String.valueOf (GL_GlAcCode3)); 
				      prop.setProperty("OL_OrgId3",String.valueOf (GL_OrgId3));
				      
				      prop.setProperty("OL_VoucherNumber4",String.valueOf(GL_VoucherNumber4));
				      prop.setProperty("OL_TranType4", GL_TranType4); 
				      prop.setProperty("OL_TransAmount4",GL_TransAmount4);
				      prop.setProperty("OL_AmountType4",GL_AmountType4);
				      prop.setProperty("OL_GlAcCode4",String.valueOf (GL_GlAcCode4)); 
				      prop.setProperty("OL_OrgId4",String.valueOf (GL_OrgId4));
				      
				      prop.setProperty("OL_VoucherNumber5",String.valueOf(GL_VoucherNumber5));
				      prop.setProperty("OL_TranType5", GL_TranType5); 
				      prop.setProperty("OL_TransAmount5",GL_TransAmount5);
				      prop.setProperty("OL_AmountType5",GL_AmountType5);
				      prop.setProperty("OL_GlAcCode5",String.valueOf (GL_GlAcCode5)); 
				      prop.setProperty("OL_OrgId5",String.valueOf (GL_OrgId5));
				      
				      prop.setProperty("OL_VoucherNumber6",String.valueOf(GL_VoucherNumber6));
				      prop.setProperty("OL_TranType6", GL_TranType6); 
				      prop.setProperty("OL_TransAmount6",GL_TransAmount6);
				      prop.setProperty("OL_AmountType6",GL_AmountType6);
				      prop.setProperty("OL_GlAcCode6",String.valueOf (GL_GlAcCode6)); 
				      prop.setProperty("OL_OrgId6",String.valueOf (GL_OrgId6));
				      
				      prop.setProperty("OL_VoucherNumber7",String.valueOf(GL_VoucherNumber7));
				      prop.setProperty("OL_TranType7", GL_TranType7); 
				      prop.setProperty("OL_TransAmount7",GL_TransAmount7);
				      prop.setProperty("OL_AmountType7",GL_AmountType7);
				      prop.setProperty("OL_GlAcCode7",String.valueOf (GL_GlAcCode7)); 
				      prop.setProperty("OL_OrgId7",String.valueOf (GL_OrgId7));
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 public static WebDriver writeODClosure_Autopost(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select distinct  ProductName,AcNo,AcDisplayName from QaFnGetinterbranchSummaryDetails  ("+TransID+")";     
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName1=(String) ar.get(3);
				       GL_AccountNumber1=(String) ar.get(4);
				       GL_AccDisplayName1=(String) ar.get(5);
				       GL_ProductName2=(String) ar.get(0);
				       GL_AccountNumber2=(String) ar.get(1);
				       GL_AccDisplayName2=(String) ar.get(2);  
				       
				   String Data1="select BatchID,TransID,TrnMode from QaFnGetinterbranchSummaryDetails  ("+TransID+")";
				   ResultSet rslt= stmt.executeQuery(Data1);
				   System.out.println("SP2 EXECUTED");
				   while(rslt.next()) {
			        	
					   GL_BatchId=Integer.parseInt(rslt.getString(1));
					   GL_TransId=Integer.parseInt(rslt.getString(2));
					   GL_TransferMode=rslt.getString(3);
					   
			        }
					   
				         
	   String Data2="select VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,RespBranchID from QaFnGetinterbranchSummaryDetails ("+TransID+")";
       ResultSet result= stmt.executeQuery(Data2);
       System.out.println("SP3 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(0));
				          GL_TranType2=(String) ar1.get(1);
				          GL_TransAmount2=(String) ar1.get(2);
				          GL_AmountType2=(String) ar1.get(3);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(4));
				          GL_OrgId2=Integer.parseInt((String) ar1.get(5));
				 	       
				          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(6));
				          GL_TranType1=(String) ar1.get(7);
				          GL_TransAmount1=(String) ar1.get(8);
				          GL_AmountType1=(String) ar1.get(9);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(10));
				          GL_OrgId1=Integer.parseInt((String) ar1.get(11));
				          
				          GL_VoucherNumber6=Integer.parseInt((String) ar1.get(12));
				          GL_TranType6=(String) ar1.get(13);
				          GL_TransAmount6=(String) ar1.get(14);
				          GL_AmountType6=(String) ar1.get(15);
				          GL_GlAcCode6=Integer.parseInt((String) ar1.get(16));
				          GL_OrgId6=Integer.parseInt((String) ar1.get(17));
				          
				          GL_VoucherNumber5=Integer.parseInt((String) ar1.get(18));
				          GL_TranType5=(String) ar1.get(19);
				          GL_TransAmount5=(String) ar1.get(20);
				          GL_AmountType5=(String) ar1.get(21);
				          GL_GlAcCode5=Integer.parseInt((String) ar1.get(22));
				          GL_OrgId5=Integer.parseInt((String) ar1.get(23));
				          
				          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(24));
				          GL_TranType3=(String) ar1.get(25);
				          GL_TransAmount3=(String) ar1.get(26);
				          GL_AmountType3=(String) ar1.get(27);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(28));
				          GL_OrgId3=Integer.parseInt((String) ar1.get(29));
				          
				          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(30));
				          GL_TranType4=(String) ar1.get(31);
				          GL_TransAmount4=(String) ar1.get(32);
				          GL_AmountType4=(String) ar1.get(33);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(34));
				          GL_OrgId4=Integer.parseInt((String) ar1.get(35));
				          
				          GL_VoucherNumber7=Integer.parseInt((String) ar1.get(36));
				          GL_TranType7=(String) ar1.get(37);
				          GL_TransAmount7=(String) ar1.get(38);
				          GL_AmountType7=(String) ar1.get(39);
				          GL_GlAcCode7=Integer.parseInt((String) ar1.get(40));
				          GL_OrgId7=Integer.parseInt((String) ar1.get(41));
				          
				 	      
				      Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/ODCLOSURE_AUTOPOST.properties");
				      prop.setProperty("OD_ProductName1",GL_ProductName1);
				      prop.setProperty("OD_AccountNumber1", GL_AccountNumber1);
				      prop.setProperty("OD_DisplayName1",GL_AccDisplayName1);
				      prop.setProperty("OD_ProductName2",GL_ProductName2);
				      prop.setProperty("OD_AccountNumber2", GL_AccountNumber2);
				      prop.setProperty("OD_DisplayName2",GL_AccDisplayName2);
				      prop.setProperty("OD_BatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("OD_TransId", String.valueOf(GL_TransId));
				      prop.setProperty("OD_TransferMode",GL_TransferMode);
				      
				      
				      prop.setProperty("OD_VoucherNumber1",String.valueOf(GL_VoucherNumber1));
				      prop.setProperty("OD_TranType1", GL_TranType1); 
				      prop.setProperty("OD_TransAmount1",GL_TransAmount1);
				      prop.setProperty("OD_AmountType1",GL_AmountType1);
				      prop.setProperty("OD_GlAcCode1",String.valueOf (GL_GlAcCode1)); 
				      prop.setProperty("OD_OrgId1",String.valueOf (GL_OrgId1));
				      
				      prop.setProperty("OD_VoucherNumber2",String.valueOf(GL_VoucherNumber2));
				      prop.setProperty("OD_TranType2", GL_TranType2); 
				      prop.setProperty("OD_TransAmount2",GL_TransAmount2);
				      prop.setProperty("OD_AmountType2",GL_AmountType2);
				      prop.setProperty("OD_GlAcCode2",String.valueOf (GL_GlAcCode2)); 
				      prop.setProperty("OD_OrgId2",String.valueOf (GL_OrgId2));
				      
				      prop.setProperty("OD_VoucherNumber3",String.valueOf(GL_VoucherNumber3));
				      prop.setProperty("OD_TranType3", GL_TranType3); 
				      prop.setProperty("OD_TransAmount3",GL_TransAmount3);
				      prop.setProperty("OD_AmountType3",GL_AmountType3);
				      prop.setProperty("OD_GlAcCode3",String.valueOf (GL_GlAcCode3)); 
				      prop.setProperty("OD_OrgId3",String.valueOf (GL_OrgId3));
				      
				      prop.setProperty("OD_VoucherNumber4",String.valueOf(GL_VoucherNumber4));
				      prop.setProperty("OD_TranType4", GL_TranType4); 
				      prop.setProperty("OD_TransAmount4",GL_TransAmount4);
				      prop.setProperty("OD_AmountType4",GL_AmountType4);
				      prop.setProperty("OD_GlAcCode4",String.valueOf (GL_GlAcCode4)); 
				      prop.setProperty("OD_OrgId4",String.valueOf (GL_OrgId4));
				      
				      prop.setProperty("OD_VoucherNumber5",String.valueOf(GL_VoucherNumber5));
				      prop.setProperty("OD_TranType5", GL_TranType5); 
				      prop.setProperty("OD_TransAmount5",GL_TransAmount5);
				      prop.setProperty("OD_AmountType5",GL_AmountType5);
				      prop.setProperty("OD_GlAcCode5",String.valueOf (GL_GlAcCode5)); 
				      prop.setProperty("OD_OrgId5",String.valueOf (GL_OrgId5));
				      
				      prop.setProperty("OD_VoucherNumber6",String.valueOf(GL_VoucherNumber6));
				      prop.setProperty("OD_TranType6", GL_TranType6); 
				      prop.setProperty("OD_TransAmount6",GL_TransAmount6);
				      prop.setProperty("OD_AmountType6",GL_AmountType6);
				      prop.setProperty("OD_GlAcCode6",String.valueOf (GL_GlAcCode6)); 
				      prop.setProperty("OD_OrgId6",String.valueOf (GL_OrgId6));
				      
				      prop.setProperty("OD_VoucherNumber7",String.valueOf(GL_VoucherNumber7));
				      prop.setProperty("OD_TranType7", GL_TranType7); 
				      prop.setProperty("OD_TransAmount7",GL_TransAmount7);
				      prop.setProperty("OD_AmountType7",GL_AmountType7);
				      prop.setProperty("OD_GlAcCode7",String.valueOf (GL_GlAcCode7)); 
				      prop.setProperty("OD_OrgId7",String.valueOf (GL_OrgId7));
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 public static WebDriver writeDLClosure_Autopost(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select distinct  ProductName,AcNo,AcDisplayName from QaFnGetinterbranchSummaryDetails  ("+TransID+")";     
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName1=(String) ar.get(3);
				       GL_AccountNumber1=(String) ar.get(4);
				       GL_AccDisplayName1=(String) ar.get(5);
				       GL_ProductName2=(String) ar.get(0);
				       GL_AccountNumber2=(String) ar.get(1);
				       GL_AccDisplayName2=(String) ar.get(2);  
				       
				   String Data1="select BatchID,TransID,TrnMode from QaFnGetinterbranchSummaryDetails  ("+TransID+")";
				   ResultSet rslt= stmt.executeQuery(Data1);
				   System.out.println("SP2 EXECUTED");
				   while(rslt.next()) {
			        	
					   GL_BatchId=Integer.parseInt(rslt.getString(1));
					   GL_TransId=Integer.parseInt(rslt.getString(2));
					   GL_TransferMode=rslt.getString(3);
					   
			        }
					   
				         
    String Data2="select VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,RespBranchID from QaFnGetinterbranchSummaryDetails ("+TransID+")";
    ResultSet result= stmt.executeQuery(Data2);
    System.out.println("SP3 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(0));
				          GL_TranType2=(String) ar1.get(1);
				          GL_TransAmount2=(String) ar1.get(2);
				          GL_AmountType2=(String) ar1.get(3);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(4));
				          GL_OrgId2=Integer.parseInt((String) ar1.get(5));
				 	       
				          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(6));
				          GL_TranType1=(String) ar1.get(7);
				          GL_TransAmount1=(String) ar1.get(8);
				          GL_AmountType1=(String) ar1.get(9);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(10));
				          GL_OrgId1=Integer.parseInt((String) ar1.get(11));
				          
				          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(12));
				          GL_TranType4=(String) ar1.get(13);
				          GL_TransAmount4=(String) ar1.get(14);
				          GL_AmountType4=(String) ar1.get(15);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(16));
				          GL_OrgId4=Integer.parseInt((String) ar1.get(17));
				          
				          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(18));
				          GL_TranType3=(String) ar1.get(19);
				          GL_TransAmount3=(String) ar1.get(20);
				          GL_AmountType3=(String) ar1.get(21);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(22));
				          GL_OrgId3=Integer.parseInt((String) ar1.get(23));
				          
				          GL_VoucherNumber5=Integer.parseInt((String) ar1.get(24));
				          GL_TranType5=(String) ar1.get(25);
				          GL_TransAmount5=(String) ar1.get(26);
				          GL_AmountType5=(String) ar1.get(27);
				          GL_GlAcCode5=Integer.parseInt((String) ar1.get(28));
				          GL_OrgId5=Integer.parseInt((String) ar1.get(29));
				          
				          
				          
				 	      
				      Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/DLCLOSURE_AUTOPOST.properties");
				      prop.setProperty("DL_ProductName1",GL_ProductName1);
				      prop.setProperty("DL_AccountNumber1", GL_AccountNumber1);
				      prop.setProperty("DL_DisplayName1",GL_AccDisplayName1);
				      prop.setProperty("DL_ProductName2",GL_ProductName2);
				      prop.setProperty("DL_AccountNumber2", GL_AccountNumber2);
				      prop.setProperty("DL_DisplayName2",GL_AccDisplayName2);
				      prop.setProperty("DL_BatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("DL_TransId", String.valueOf(GL_TransId));
				      prop.setProperty("DL_TransferMode",GL_TransferMode);
				      
				      
				      prop.setProperty("DL_VoucherNumber1",String.valueOf(GL_VoucherNumber1));
				      prop.setProperty("DL_TranType1", GL_TranType1); 
				      prop.setProperty("DL_TransAmount1",GL_TransAmount1);
				      prop.setProperty("DL_AmountType1",GL_AmountType1);
				      prop.setProperty("DL_GlAcCode1",String.valueOf (GL_GlAcCode1)); 
				      prop.setProperty("DL_OrgId1",String.valueOf (GL_OrgId1));
				      
				      prop.setProperty("DL_VoucherNumber2",String.valueOf(GL_VoucherNumber2));
				      prop.setProperty("DL_TranType2", GL_TranType2); 
				      prop.setProperty("DL_TransAmount2",GL_TransAmount2);
				      prop.setProperty("DL_AmountType2",GL_AmountType2);
				      prop.setProperty("DL_GlAcCode2",String.valueOf (GL_GlAcCode2)); 
				      prop.setProperty("DL_OrgId2",String.valueOf (GL_OrgId2));
				      
				      prop.setProperty("DL_VoucherNumber3",String.valueOf(GL_VoucherNumber3));
				      prop.setProperty("DL_TranType3", GL_TranType3); 
				      prop.setProperty("DL_TransAmount3",GL_TransAmount3);
				      prop.setProperty("DL_AmountType3",GL_AmountType3);
				      prop.setProperty("DL_GlAcCode3",String.valueOf (GL_GlAcCode3)); 
				      prop.setProperty("DL_OrgId3",String.valueOf (GL_OrgId3));
				      
				      prop.setProperty("DL_VoucherNumber4",String.valueOf(GL_VoucherNumber4));
				      prop.setProperty("DL_TranType4", GL_TranType4); 
				      prop.setProperty("DL_TransAmount4",GL_TransAmount4);
				      prop.setProperty("DL_AmountType4",GL_AmountType4);
				      prop.setProperty("DL_GlAcCode4",String.valueOf (GL_GlAcCode4)); 
				      prop.setProperty("DL_OrgId4",String.valueOf (GL_OrgId4));
				      
				      prop.setProperty("DL_VoucherNumber5",String.valueOf(GL_VoucherNumber5));
				      prop.setProperty("DL_TranType5", GL_TranType5); 
				      prop.setProperty("DL_TransAmount5",GL_TransAmount5);
				      prop.setProperty("DL_AmountType5",GL_AmountType5);
				      prop.setProperty("DL_GlAcCode5",String.valueOf (GL_GlAcCode5)); 
				      prop.setProperty("DL_OrgId5",String.valueOf (GL_OrgId5));
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 public static WebDriver writeGLClosure_Autopost(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select distinct  ProductName,AcNo,AcDisplayName from QaFnGetinterbranchSummaryDetails  ("+TransID+")";     
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName1=(String) ar.get(3);
				       GL_AccountNumber1=(String) ar.get(4);
				       GL_AccDisplayName1=(String) ar.get(5);
				       GL_ProductName2=(String) ar.get(0);
				       GL_AccountNumber2=(String) ar.get(1);
				       GL_AccDisplayName2=(String) ar.get(2);  
				       
				   String Data1="select BatchID,TransID,TrnMode,RespBranchID from QaFnGetinterbranchSummaryDetails  ("+TransID+")";
				   ResultSet rslt= stmt.executeQuery(Data1);
				   System.out.println("SP2 EXECUTED");
				   while(rslt.next()) {
			        	
					   GL_BatchId=Integer.parseInt(rslt.getString(1));
					   GL_TransId=Integer.parseInt(rslt.getString(2));
					   GL_TransferMode=rslt.getString(3);
					   GL_OrgId=Integer.parseInt(rslt.getString(4));
					   
			        }
					   
				         
 String Data2="select VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode from QaFnGetinterbranchSummaryDetails ("+TransID+")";
 ResultSet result= stmt.executeQuery(Data2);
 System.out.println("SP3 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          GL_VoucherNumber2=Integer.parseInt((String) ar1.get(0));
				          GL_TranType2=(String) ar1.get(1);
				          GL_TransAmount2=(String) ar1.get(2);
				          GL_AmountType2=(String) ar1.get(3);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(4));
				          
				 	       
				          GL_VoucherNumber1=Integer.parseInt((String) ar1.get(5));
				          GL_TranType1=(String) ar1.get(6);
				          GL_TransAmount1=(String) ar1.get(7);
				          GL_AmountType1=(String) ar1.get(8);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(9));
				          
				          
				          GL_VoucherNumber3=Integer.parseInt((String) ar1.get(10));
				          GL_TranType3=(String) ar1.get(11);
				          GL_TransAmount3=(String) ar1.get(12);
				          GL_AmountType3=(String) ar1.get(13);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(14));
				          
				          
				          GL_VoucherNumber4=Integer.parseInt((String) ar1.get(15));
				          GL_TranType4=(String) ar1.get(16);
				          GL_TransAmount4=(String) ar1.get(17);
				          GL_AmountType4=(String) ar1.get(18);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(19));
				          
				          
				          GL_VoucherNumber5=Integer.parseInt((String) ar1.get(20));
				          GL_TranType5=(String) ar1.get(21);
				          GL_TransAmount5=(String) ar1.get(22);
				          GL_AmountType5=(String) ar1.get(23);
				          GL_GlAcCode5=Integer.parseInt((String) ar1.get(24));
				          
				          
				          
				          
				 	      
				      Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/GLCLOSURE_AUTOPOST.properties");
				      prop.setProperty("DL_ProductName1",GL_ProductName1);
				      prop.setProperty("DL_AccountNumber1", GL_AccountNumber1);
				      prop.setProperty("DL_DisplayName1",GL_AccDisplayName1);
				      prop.setProperty("DL_ProductName2",GL_ProductName2);
				      prop.setProperty("DL_AccountNumber2", GL_AccountNumber2);
				      prop.setProperty("DL_DisplayName2",GL_AccDisplayName2);
				      prop.setProperty("DL_BatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("DL_TransId", String.valueOf(GL_TransId));
				      prop.setProperty("DL_TransferMode",GL_TransferMode);
				      prop.setProperty("DL_OrgId",String.valueOf (GL_OrgId));
				      
				      prop.setProperty("DL_VoucherNumber1",String.valueOf(GL_VoucherNumber1));
				      prop.setProperty("DL_TranType1", GL_TranType1); 
				      prop.setProperty("DL_TransAmount1",GL_TransAmount1);
				      prop.setProperty("DL_AmountType1",GL_AmountType1);
				      prop.setProperty("DL_GlAcCode1",String.valueOf (GL_GlAcCode1)); 
				      
				      
				      prop.setProperty("DL_VoucherNumber2",String.valueOf(GL_VoucherNumber2));
				      prop.setProperty("DL_TranType2", GL_TranType2); 
				      prop.setProperty("DL_TransAmount2",GL_TransAmount2);
				      prop.setProperty("DL_AmountType2",GL_AmountType2);
				      prop.setProperty("DL_GlAcCode2",String.valueOf (GL_GlAcCode2)); 
				      
				      
				      prop.setProperty("DL_VoucherNumber3",String.valueOf(GL_VoucherNumber3));
				      prop.setProperty("DL_TranType3", GL_TranType3); 
				      prop.setProperty("DL_TransAmount3",GL_TransAmount3);
				      prop.setProperty("DL_AmountType3",GL_AmountType3);
				      prop.setProperty("DL_GlAcCode3",String.valueOf (GL_GlAcCode3)); 
				      
				      
				      prop.setProperty("DL_VoucherNumber4",String.valueOf(GL_VoucherNumber4));
				      prop.setProperty("DL_TranType4", GL_TranType4); 
				      prop.setProperty("DL_TransAmount4",GL_TransAmount4);
				      prop.setProperty("DL_AmountType4",GL_AmountType4);
				      prop.setProperty("DL_GlAcCode4",String.valueOf (GL_GlAcCode4)); 
				      
				      
				      prop.setProperty("DL_VoucherNumber5",String.valueOf(GL_VoucherNumber5));
				      prop.setProperty("DL_TranType5", GL_TranType5); 
				      prop.setProperty("DL_TransAmount5",GL_TransAmount5);
				      prop.setProperty("DL_AmountType5",GL_AmountType5);
				      prop.setProperty("DL_GlAcCode5",String.valueOf (GL_GlAcCode5)); 
				      
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 public static WebDriver writeOLClosure_Batch(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE OTHER LOAN CLOSURE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			           
			           float TotalAmount=0;
						  String Principal=null;
						  String Fine=null;
						  String Misc=null;
						  String Interest=null;
						  String Advertisement=null;
						  String Cgst=null;
										try {
											  Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
											  Interest=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[3]/td[9]")).getText();
											  Fine=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[4]/td[9]")).getText();
											  Misc=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[5]/td[9]")).getText();
											  Advertisement=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[6]/td[9]")).getText();
											  Cgst=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[7]/td[9]")).getText();
											  float a= Float.parseFloat(Principal);
											  float b= Float.parseFloat(Interest);
											  float c= Float.parseFloat(Fine);
											  float d= Float.parseFloat(Misc);
											  float e= Float.parseFloat(Advertisement);
											  float f= Float.parseFloat(Cgst);
											  TotalAmount=(a+b+c+d+e+f);
											   System.out.println("Total Amount"+TotalAmount);
											       
											        }catch (NumberFormatException e) {
											        	
											        	e.printStackTrace();
											        }
			        
			        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName=(String) ar.get(0);
				       GL_AccountNumber=(String) ar.get(1);
				       GL_AccDisplayName=(String) ar.get(2);
				       GL_BatchId=Integer.parseInt((String) ar.get(3));
					   GL_TransId=Integer.parseInt((String) ar.get(4));
					   GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
				       GL_TranType=(String) ar.get(6);
					   GL_TransferMode=(String) ar.get(7);
					   GL_OrgId=Integer.parseInt((String) ar.get(8));
				        
				       
			 String Data2="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
	         ResultSet result= stmt.executeQuery(Data2);
	         System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          
				          GL_TransAmount1=(String) ar1.get(0);
				          GL_AmountType1=(String) ar1.get(1);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
				         
				          
				          GL_TransAmount2=(String) ar1.get(3);
				          GL_AmountType2=(String) ar1.get(4);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
				          
				          GL_TransAmount3=(String) ar1.get(6);
				          GL_AmountType3=(String) ar1.get(7);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(8));
				          
				          GL_TransAmount4=(String) ar1.get(9);
				          GL_AmountType4=(String) ar1.get(10);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(11));
				          
				          GL_TransAmount5=(String) ar1.get(12);
				          GL_AmountType5=(String) ar1.get(13);
				          GL_GlAcCode5=Integer.parseInt((String) ar1.get(14));
				          
				          GL_TransAmount6=(String) ar1.get(15);
				          GL_AmountType6=(String) ar1.get(16);
				          GL_GlAcCode6=Integer.parseInt((String) ar1.get(17));
				          
				          
				      Properties prop=new Properties();
				      FileOutputStream fos = new FileOutputStream("./DataFiles/OL_CLOSURE_BATCH.properties");
				      
				      prop.setProperty("OLProductName",GL_ProductName);
				      prop.setProperty("OLAccountNumber", GL_AccountNumber);
				      prop.setProperty("OLDisplayName",GL_AccDisplayName);
				      prop.setProperty("OLBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("OLTransId", String.valueOf(GL_TransId));
				      prop.setProperty("OLVoucherNumber",String.valueOf(GL_VoucherNumber));
				      prop.setProperty("OLTranType", GL_TranType); 
				      prop.setProperty("OLTransferMode",GL_TransferMode);
				      prop.setProperty("OLOrgId",String.valueOf (GL_OrgId));
				      
				      prop.setProperty("OLTransAmount1",GL_TransAmount1);
				      prop.setProperty("OLAmountType1",GL_AmountType1);
				      prop.setProperty("OLGlAcCode1",String.valueOf (GL_GlAcCode1));
				      
				      prop.setProperty("OLTransAmount2",GL_TransAmount2);
				      prop.setProperty("OLAmountType2",GL_AmountType2);
				      prop.setProperty("OLGlAcCode2",String.valueOf (GL_GlAcCode2));
				      
				      prop.setProperty("OLTransAmount3",GL_TransAmount3);
				      prop.setProperty("OLAmountType3",GL_AmountType3);
				      prop.setProperty("OLGlAcCode3",String.valueOf (GL_GlAcCode3));
				      
				      prop.setProperty("OLTransAmount4",GL_TransAmount4);
				      prop.setProperty("OLAmountType4",GL_AmountType4);
				      prop.setProperty("OLGlAcCode4",String.valueOf (GL_GlAcCode4));
				      
				      prop.setProperty("OLTransAmount5",GL_TransAmount5);
				      prop.setProperty("OLAmountType5",GL_AmountType5);
				      prop.setProperty("OLGlAcCode5",String.valueOf (GL_GlAcCode5));
				      
				      prop.setProperty("OLTransAmount6",GL_TransAmount6);
				      prop.setProperty("OLAmountType6",GL_AmountType6);
				      prop.setProperty("OLGlAcCode6",String.valueOf (GL_GlAcCode6));
				      prop.setProperty("TotalAmount", String.valueOf(TotalAmount)); 
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 public static WebDriver writeODClosure_Batch(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE OVERDRAFT LOAN CLOSURE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			           float TotalAmount=0;
					   String Principal=null;
					   String Fine=null;
					   String Misc=null;
					   String Interest=null;
					   String Advertisement=null;
					   String Cgst=null;
										try {
											  Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
											  Interest=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[3]/td[9]")).getText();
											  Fine=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[4]/td[9]")).getText();
											  Misc=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[5]/td[9]")).getText();
											  Advertisement=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[6]/td[9]")).getText();
											  Cgst=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[7]/td[9]")).getText();
											  float a= Float.parseFloat(Principal);
											  float b= Float.parseFloat(Interest);
											  float c= Float.parseFloat(Fine);
											  float d= Float.parseFloat(Misc);
											  float e= Float.parseFloat(Advertisement);
											  float f= Float.parseFloat(Cgst);
											  TotalAmount=(a+b+c+d+e+f);
											   System.out.println("Total Amount"+TotalAmount);
											       
											        }catch (NumberFormatException e) {
											        	
											        	e.printStackTrace();
											        }
			        
			        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName=(String) ar.get(0);
				       GL_AccountNumber=(String) ar.get(1);
				       GL_AccDisplayName=(String) ar.get(2);
				       GL_BatchId=Integer.parseInt((String) ar.get(3));
					   GL_TransId=Integer.parseInt((String) ar.get(4));
					   GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
				       GL_TranType=(String) ar.get(6);
					   GL_TransferMode=(String) ar.get(7);
					   GL_OrgId=Integer.parseInt((String) ar.get(8));
				        
				       
			 String Data2="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
	         ResultSet result= stmt.executeQuery(Data2);
	         System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          
				          GL_TransAmount1=(String) ar1.get(0);
				          GL_AmountType1=(String) ar1.get(1);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
				         
				          
				          GL_TransAmount2=(String) ar1.get(3);
				          GL_AmountType2=(String) ar1.get(4);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
				          
				          GL_TransAmount3=(String) ar1.get(6);
				          GL_AmountType3=(String) ar1.get(7);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(8));
				          
				          GL_TransAmount4=(String) ar1.get(9);
				          GL_AmountType4=(String) ar1.get(10);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(11));
				          
				          GL_TransAmount5=(String) ar1.get(12);
				          GL_AmountType5=(String) ar1.get(13);
				          GL_GlAcCode5=Integer.parseInt((String) ar1.get(14));
				          
				          GL_TransAmount6=(String) ar1.get(15);
				          GL_AmountType6=(String) ar1.get(16);
				          GL_GlAcCode6=Integer.parseInt((String) ar1.get(17));
				          
				          
				      Properties prop=new Properties();
				      FileOutputStream fos = new FileOutputStream("./DataFiles/OD_CLOSURE_BATCH.properties");
				      
				      prop.setProperty("ODProductName",GL_ProductName);
				      prop.setProperty("ODAccountNumber", GL_AccountNumber);
				      prop.setProperty("ODDisplayName",GL_AccDisplayName);
				      prop.setProperty("ODBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("ODTransId", String.valueOf(GL_TransId));
				      prop.setProperty("ODVoucherNumber",String.valueOf(GL_VoucherNumber));
				      prop.setProperty("ODTranType", GL_TranType); 
				      prop.setProperty("ODTransferMode",GL_TransferMode);
				      prop.setProperty("ODOrgId",String.valueOf (GL_OrgId));
				      
				      prop.setProperty("ODTransAmount1",GL_TransAmount1);
				      prop.setProperty("ODAmountType1",GL_AmountType1);
				      prop.setProperty("ODGlAcCode1",String.valueOf (GL_GlAcCode1));
				      
				      prop.setProperty("ODTransAmount2",GL_TransAmount2);
				      prop.setProperty("ODAmountType2",GL_AmountType2);
				      prop.setProperty("ODGlAcCode2",String.valueOf (GL_GlAcCode2));
				      
				      prop.setProperty("ODTransAmount3",GL_TransAmount3);
				      prop.setProperty("ODAmountType3",GL_AmountType3);
				      prop.setProperty("ODGlAcCode3",String.valueOf (GL_GlAcCode3));
				      
				      prop.setProperty("ODTransAmount4",GL_TransAmount4);
				      prop.setProperty("ODAmountType4",GL_AmountType4);
				      prop.setProperty("ODGlAcCode4",String.valueOf (GL_GlAcCode4));
				      
				      prop.setProperty("ODTransAmount5",GL_TransAmount5);
				      prop.setProperty("ODAmountType5",GL_AmountType5);
				      prop.setProperty("ODGlAcCode5",String.valueOf (GL_GlAcCode5));
				      
				      prop.setProperty("ODTransAmount6",GL_TransAmount6);
				      prop.setProperty("ODAmountType6",GL_AmountType6);
				      prop.setProperty("ODGlAcCode6",String.valueOf (GL_GlAcCode6));
				      prop.setProperty("TotalAmount", String.valueOf(TotalAmount)); 
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 public static WebDriver writeDLClosure_Batch(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE DEPOSIT LOAN CLOSURE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			           float TotalAmount=0;
					   String Principal=null;
					   String Misc=null;
					   String Advertisement=null;
					   String Cgst=null;
					try {
							Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
							Misc=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[3]/td[9]")).getText();
							Advertisement=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[4]/td[9]")).getText();
					        Cgst=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[5]/td[9]")).getText();
											  
									float a= Float.parseFloat(Principal);
									float b= Float.parseFloat(Misc);
									float c= Float.parseFloat(Advertisement);
									float d= Float.parseFloat(Cgst);
											TotalAmount=(a+b+c+d);
											System.out.println("Total Amount"+TotalAmount);
											       
											        }catch (NumberFormatException e) {
											        	
											        	e.printStackTrace();
											        }
			               
			        
			        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName=(String) ar.get(0);
				       GL_AccountNumber=(String) ar.get(1);
				       GL_AccDisplayName=(String) ar.get(2);
				       GL_BatchId=Integer.parseInt((String) ar.get(3));
					   GL_TransId=Integer.parseInt((String) ar.get(4));
					   GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
				       GL_TranType=(String) ar.get(6);
					   GL_TransferMode=(String) ar.get(7);
					   GL_OrgId=Integer.parseInt((String) ar.get(8));
				        
				       
			 String Data2="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
	         ResultSet result= stmt.executeQuery(Data2);
	         System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          
				          GL_TransAmount1=(String) ar1.get(0);
				          GL_AmountType1=(String) ar1.get(1);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
				         
				          
				          GL_TransAmount2=(String) ar1.get(3);
				          GL_AmountType2=(String) ar1.get(4);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
				          
				          GL_TransAmount3=(String) ar1.get(6);
				          GL_AmountType3=(String) ar1.get(7);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(8));
				          
				          GL_TransAmount4=(String) ar1.get(9);
				          GL_AmountType4=(String) ar1.get(10);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(11));
				          
				          
				          
				          
				      Properties prop=new Properties();
				      FileOutputStream fos = new FileOutputStream("./DataFiles/DL_CLOSURE_BATCH.properties");
				      
				      prop.setProperty("DLProductName",GL_ProductName);
				      prop.setProperty("DLAccountNumber", GL_AccountNumber);
				      prop.setProperty("DLDisplayName",GL_AccDisplayName);
				      prop.setProperty("DLBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("DLTransId", String.valueOf(GL_TransId));
				      prop.setProperty("DLVoucherNumber",String.valueOf(GL_VoucherNumber));
				      prop.setProperty("DLTranType", GL_TranType); 
				      prop.setProperty("DLTransferMode",GL_TransferMode);
				      prop.setProperty("DLOrgId",String.valueOf (GL_OrgId));
				      
				      prop.setProperty("DLTransAmount1",GL_TransAmount1);
				      prop.setProperty("DLAmountType1",GL_AmountType1);
				      prop.setProperty("DLGlAcCode1",String.valueOf (GL_GlAcCode1));
				      
				      prop.setProperty("DLTransAmount2",GL_TransAmount2);
				      prop.setProperty("DLAmountType2",GL_AmountType2);
				      prop.setProperty("DLGlAcCode2",String.valueOf (GL_GlAcCode2));
				      
				      prop.setProperty("DLTransAmount3",GL_TransAmount3);
				      prop.setProperty("DLAmountType3",GL_AmountType3);
				      prop.setProperty("DLGlAcCode3",String.valueOf (GL_GlAcCode3));
				      
				      prop.setProperty("DLTransAmount4",GL_TransAmount4);
				      prop.setProperty("DLAmountType4",GL_AmountType4);
				      prop.setProperty("DLGlAcCode4",String.valueOf (GL_GlAcCode4));
				      
				      prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
 public static WebDriver writeGLClosure_Batch(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE OVERDRAFT LOAN CLOSURE SUMMARY");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	   GL_TransactionDate=rs1.getString(1);
			        	   GL_ValueDate=rs1.getString(2);
			           }
			           float TotalAmount=0;
					   String Principal=null;
					   String Fine=null;
					   String Misc=null;
					   String Interest=null;
					   String Advertisement=null;
					   String Cgst=null;
										try {
											  Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
											  Interest=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[3]/td[9]")).getText();
											  Fine=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[4]/td[9]")).getText();
											  Misc=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[5]/td[9]")).getText();
											  Advertisement=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[6]/td[9]")).getText();
											  Cgst=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[7]/td[9]")).getText();
											  float a= Float.parseFloat(Principal);
											  float b= Float.parseFloat(Interest);
											  float c= Float.parseFloat(Fine);
											  float d= Float.parseFloat(Misc);
											  float e= Float.parseFloat(Advertisement);
											  float f= Float.parseFloat(Cgst);
											  TotalAmount=(a+b+c+d+e+f);
											   System.out.println("Total Amount"+TotalAmount);
											       
											        }catch (NumberFormatException e) {
											        	
											        	e.printStackTrace();
											        }
			        
			        String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")"; 
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		                int row=rst.getRow();
				        ArrayList ar=new ArrayList<>();
				        ResultSetMetaData rsmd;
				       
				       try {
				                 rsmd = rst.getMetaData();

				                 int NumOfCol = rsmd.getColumnCount();
				                 
				               

				                 while (rst.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol; i++) {
				                        
				                      ar.add(rst.getString(i));
				                      
				                     }

				                     row++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       GL_ProductName=(String) ar.get(0);
				       GL_AccountNumber=(String) ar.get(1);
				       GL_AccDisplayName=(String) ar.get(2);
				       GL_BatchId=Integer.parseInt((String) ar.get(3));
					   GL_TransId=Integer.parseInt((String) ar.get(4));
					   GL_VoucherNumber=Integer.parseInt((String) ar.get(5));
				       GL_TranType=(String) ar.get(6);
					   GL_TransferMode=(String) ar.get(7);
					   GL_OrgId=Integer.parseInt((String) ar.get(8));
				        
				       
			 String Data2="select TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";
	         ResultSet result= stmt.executeQuery(Data2);
	         System.out.println("SP2 EXECUTED");
				    int row1=result.getRow();
				    ArrayList ar1=new ArrayList<>();
				      
				       ResultSetMetaData rsmd1;
				       
				       try {
				                 rsmd1 = result.getMetaData();

				                 int NumOfCol1 = rsmd1.getColumnCount();
				                 
				               

				                 while (result.next()) {
				                  

				                     for (int i = 1; i <= NumOfCol1; i++) {
				                        
				                      ar1.add(result.getString(i));
				                      
				                     }

				                     row1++;
				                 }
				                 
				                 
				             } catch (SQLException e) {
				                 throw e;
				         
				             }
				       
				          
				          GL_TransAmount1=(String) ar1.get(0);
				          GL_AmountType1=(String) ar1.get(1);
				          GL_GlAcCode1=Integer.parseInt((String) ar1.get(2));
				         
				          
				          GL_TransAmount2=(String) ar1.get(3);
				          GL_AmountType2=(String) ar1.get(4);
				          GL_GlAcCode2=Integer.parseInt((String) ar1.get(5));
				          
				          GL_TransAmount3=(String) ar1.get(6);
				          GL_AmountType3=(String) ar1.get(7);
				          GL_GlAcCode3=Integer.parseInt((String) ar1.get(8));
				          
				          GL_TransAmount4=(String) ar1.get(9);
				          GL_AmountType4=(String) ar1.get(10);
				          GL_GlAcCode4=Integer.parseInt((String) ar1.get(11));
				          
				          GL_TransAmount5=(String) ar1.get(12);
				          GL_AmountType5=(String) ar1.get(13);
				          GL_GlAcCode5=Integer.parseInt((String) ar1.get(14));
				          
				          GL_TransAmount6=(String) ar1.get(15);
				          GL_AmountType6=(String) ar1.get(16);
				          GL_GlAcCode6=Integer.parseInt((String) ar1.get(17));
				          
				          
				      Properties prop=new Properties();
				      FileOutputStream fos = new FileOutputStream("./DataFiles/GL_CLOSURE_BATCH.properties");
				      
				      prop.setProperty("GLProductName",GL_ProductName);
				      prop.setProperty("GLAccountNumber", GL_AccountNumber);
				      prop.setProperty("GLDisplayName",GL_AccDisplayName);
				      prop.setProperty("GLBatchId",String.valueOf(GL_BatchId));
				      prop.setProperty("GLTransId", String.valueOf(GL_TransId));
				      prop.setProperty("GLVoucherNumber",String.valueOf(GL_VoucherNumber));
				      prop.setProperty("GLTranType", GL_TranType); 
				      prop.setProperty("GLTransferMode",GL_TransferMode);
				      prop.setProperty("GLOrgId",String.valueOf (GL_OrgId));
				      
				      prop.setProperty("GLTransAmount1",GL_TransAmount1);
				      prop.setProperty("GLAmountType1",GL_AmountType1);
				      prop.setProperty("GLGlAcCode1",String.valueOf (GL_GlAcCode1));
				      
				      prop.setProperty("GLTransAmount2",GL_TransAmount2);
				      prop.setProperty("GLAmountType2",GL_AmountType2);
				      prop.setProperty("GLGlAcCode2",String.valueOf (GL_GlAcCode2));
				      
				      prop.setProperty("GLTransAmount3",GL_TransAmount3);
				      prop.setProperty("GLAmountType3",GL_AmountType3);
				      prop.setProperty("GLGlAcCode3",String.valueOf (GL_GlAcCode3));
				      
				      prop.setProperty("GLTransAmount4",GL_TransAmount4);
				      prop.setProperty("GLAmountType4",GL_AmountType4);
				      prop.setProperty("GLGlAcCode4",String.valueOf (GL_GlAcCode4));
				      
				      prop.setProperty("GLTransAmount5",GL_TransAmount5);
				      prop.setProperty("GLAmountType5",GL_AmountType5);
				      prop.setProperty("GLGlAcCode5",String.valueOf (GL_GlAcCode5));
				      
				      prop.setProperty("GLTransAmount6",GL_TransAmount6);
				      prop.setProperty("GLAmountType6",GL_AmountType6);
				      prop.setProperty("GLGlAcCode6",String.valueOf (GL_GlAcCode6));
				      prop.setProperty("TotalAmount", String.valueOf(TotalAmount)); 
				      
				      
				     System.out.println("Written ");
					 prop.store(fos, "Done");
					 fos.close();
					        Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
						
					 }
		   }catch(Exception e){
			Driver.tcFlag = "PASS";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			e.printStackTrace();
		}
	return driver;

		}
}

