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

public class WriteShareOpeningDetails_TransferMode {
	
	public static WebElement element;
	public static String Actual_Value;
	public static String InvProductName;
	public static String InvAccountNumber;
	public static String InvAccDisplayName;
	public static int InvBatchId;
	public static int InvTransId;
	public static int InvVoucherNumber;
	public static String InvTranType;
	public static String InvTransAmount;
	public static String InvAmountType;
	public static int InvGlAcCode;
	public static String InvTransferMode;
	public static int InvOrgId;
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
	public static String  shadowBalnce;
	public static String  currentBalance;
	private static String ShareOpening_TransactionDate;
	private static String ShareOpening_ValueDate;
	private static String ShareProductName;
	private static String ShareAccountNumber;
	private static String ShareAccDisplayName;
	private static int ShareBatchId;
	private static int ShareTransId;
	private static int ShareVoucherNumber;
	private static String ShareTranType;
	private static String ShareTransAmount;
	private static String ShareAmountType;
	private static int ShareGlAcCode;
	private static String ShareTransferMode;
	private static int ShareOrgId;
	private static String Share_ProductName;
	private static String Share_AccountNumber;
	private static String Share_AccDisplayName;
	private static int Share_BatchId;
	private static int Share_TransId;
	private static int Share_VoucherNumber;
	private static String Share_TranType;
	private static String Share_TransAmount;
	private static String Share_AmountType;
	private static int Share_GlAcCode;
	private static String Share_TransferMode;
	private static int Share_OrgId;
	private static String Share_ProductName1;
	private static String Share_AccountNumber1;
	private static String Share_AccDisplayName1;
	private static int Share_BatchId1;
	private static int Share_TransId1;
	private static int Share_VoucherNumber1;
	private static String Share_TranType1;
	private static String Share_TransAmount1;
	private static String Share_AmountType1;
	private static int Share_GlAcCode1;
	private static String Share_TransferMode1;
	private static int Share_OrgId1;
	private static String Share_ProductName2;
	private static String Share_AccountNumber2;
	private static String Share_AccDisplayName2;
	private static int Share_BatchId2;
	private static int Share_TransId2;
	private static int Share_VoucherNumber2;
	private static String Share_TranType2;
	private static String Share_TransAmount2;
	private static String Share_AmountType2;
	private static int Share_GlAcCode2;
	private static String Share_TransferMode2;
	private static int Share_OrgId2;
	private static String Share_ProductName3;
	private static String Share_AccountNumber3;
	private static String Share_AccDisplayName3;
	private static int Share_BatchId3;
	private static int Share_TransId3;
	private static int Share_VoucherNumber3;
	private static String Share_TranType3;
	private static String Share_TransAmount3;
	private static String Share_AmountType3;
	private static int Share_GlAcCode3;
	private static String Share_TransferMode3;
	private static int Share_OrgId3;
	
	public static WebDriver writeShareOpeningDetails_TransferMode( WebDriver driver, String propertyValue) {
		
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
					      
					      	ShareProductName=(String) ar.get(48);
					      	
					      	ShareAccountNumber=(String) ar.get(49);
						
					      	ShareAccDisplayName=(String) ar.get(50);
							
					      	ShareBatchId=Integer.parseInt((String) ar.get(51));
							
					      	ShareTransId=Integer.parseInt((String) ar.get(52));
							
					      	ShareVoucherNumber=Integer.parseInt((String) ar.get(53));
							
					      	ShareTranType=(String) ar.get(54);
							
					      	ShareTransAmount=(String) ar.get(55);
						
					      	ShareAmountType=(String) ar.get(56);
						
					      	ShareGlAcCode=Integer.parseInt((String) ar.get(57));
							
					      	ShareTransferMode=(String) ar.get(58);
							
					      	ShareOrgId=Integer.parseInt((String) ar.get(59));
					      	
					      	
					      	Share_ProductName=(String) ar.get(0);
					      	
					      	Share_AccountNumber=(String) ar.get(1);
						
					      	Share_AccDisplayName=(String) ar.get(2);
							
					      	Share_BatchId=Integer.parseInt((String) ar.get(3));
							
					      	Share_TransId=Integer.parseInt((String) ar.get(4));
							
					      	Share_VoucherNumber=Integer.parseInt((String) ar.get(5));
							
					      	Share_TranType=(String) ar.get(6);
							
					      	Share_TransAmount=(String) ar.get(7);
						
					      	Share_AmountType=(String) ar.get(8);
						
					      	Share_GlAcCode=Integer.parseInt((String) ar.get(9));
							
					      	Share_TransferMode=(String) ar.get(10);
							
					      	Share_OrgId=Integer.parseInt((String) ar.get(11));
					      	
					      	
					      	
					      	
                            Share_ProductName1=(String) ar.get(12);
					      	
					      	Share_AccountNumber1=(String) ar.get(13);
						
					      	Share_AccDisplayName1=(String) ar.get(14);
							
					      	Share_BatchId1=Integer.parseInt((String) ar.get(15));
							
					      	Share_TransId1=Integer.parseInt((String) ar.get(16));
							
					      	Share_VoucherNumber1=Integer.parseInt((String) ar.get(17));
							
					      	Share_TranType1=(String) ar.get(18);
							
					      	Share_TransAmount1=(String) ar.get(19);
						
					      	Share_AmountType1=(String) ar.get(20);
						
					      	Share_GlAcCode1=Integer.parseInt((String) ar.get(21));
							
					      	Share_TransferMode1=(String) ar.get(22);
							
					      	Share_OrgId1=Integer.parseInt((String) ar.get(23));
					      	
					      	
					      	
                            Share_ProductName2=(String) ar.get(24);
					      	
					      	Share_AccountNumber2=(String) ar.get(25);
						
					      	Share_AccDisplayName2=(String) ar.get(26);
							
					      	Share_BatchId2=Integer.parseInt((String) ar.get(27));
							
					      	Share_TransId2=Integer.parseInt((String) ar.get(28));
							
					      	Share_VoucherNumber2=Integer.parseInt((String) ar.get(29));
							
					      	Share_TranType2=(String) ar.get(30);
							
					      	Share_TransAmount2=(String) ar.get(31);
						
					      	Share_AmountType2=(String) ar.get(32);
						
					      	Share_GlAcCode2=Integer.parseInt((String) ar.get(33));
							
					      	Share_TransferMode2=(String) ar.get(34);
							
					      	Share_OrgId2=Integer.parseInt((String) ar.get(35));
					      	
					      	
					      	
					      	
					      	
                            Share_ProductName3=(String) ar.get(36);
					      	
					      	Share_AccountNumber3=(String) ar.get(37);
						
					      	Share_AccDisplayName3=(String) ar.get(38);
							
					      	Share_BatchId3=Integer.parseInt((String) ar.get(39));
							
					      	Share_TransId3=Integer.parseInt((String) ar.get(40));
							
					      	Share_VoucherNumber3=Integer.parseInt((String) ar.get(41));
							
					      	Share_TranType3=(String) ar.get(42);
							
					      	Share_TransAmount3=(String) ar.get(43);
						
					      	Share_AmountType3=(String) ar.get(44);
						
					      	Share_GlAcCode3=Integer.parseInt((String) ar.get(45));
							
					      	Share_TransferMode3=(String) ar.get(46);
							
					      	Share_OrgId3=Integer.parseInt((String) ar.get(47));
					      	
					      	
					      	
						
							SBProductName=(String) ar.get(60);
							
							SBAccountNumber=(String) ar.get(61);
							
							SBAccountDisplayName=(String) ar.get(62);
							
							SBBatchId=Integer.parseInt((String) ar.get(63));
							
							SBTransId=Integer.parseInt((String) ar.get(64));
							
							SBVoucherNo=Integer.parseInt((String) ar.get(65));
							
							SBTransType=(String) ar.get(66);
							
							SBTrnAmount=(String) ar.get(67);
							
							SBAmountType=(String) ar.get(68);
							
							SBGlAcCode=Integer.parseInt((String) ar.get(69));
							
							SbTrnMode=(String) ar.get(70);
							
							SbOrgId=Integer.parseInt((String) ar.get(71));
					      
					
				
							// System.out.println("Creating property file");
							Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/ShareOpening_TransferMode_Details.properties");
							
							prop.setProperty("ShareproductName",ShareProductName);
							prop.setProperty("ShareAccountNumber", ShareAccountNumber);
							prop.setProperty("ShareAccountDisplayName",ShareAccDisplayName);
							prop.setProperty("ShareBatchId",String.valueOf(ShareBatchId));
							prop.setProperty("ShareTransId", String.valueOf(ShareTransId));
							prop.setProperty("ShareVoucherId",String.valueOf(ShareVoucherNumber));
							prop.setProperty("ShareTransactionType", ShareTranType);	
							prop.setProperty("ShareAmount",ShareTransAmount);
							prop.setProperty("ShareAmountType",ShareAmountType);
							prop.setProperty("ShareGLAccCode",String.valueOf (ShareGlAcCode));	
							prop.setProperty("ShareTransferMode", ShareTransferMode);
							prop.setProperty("ShareOrgID",String.valueOf (ShareOrgId));
							
							prop.setProperty("Share_ProductName", Share_ProductName);
							prop.setProperty("Share_AccountNumber", Share_AccountNumber);
							prop.setProperty("Share_AccountDispalyName", Share_AccDisplayName);
							prop.setProperty("Share_BatchId", String.valueOf (Share_BatchId));
							prop.setProperty("Share_TransactionId",String.valueOf ( Share_TransId));
							prop.setProperty("Share_VoucherNumber",String.valueOf ( Share_VoucherNumber));
							prop.setProperty("Share_TransType", Share_TranType);
							prop.setProperty("Share_TransAmount", Share_TransAmount);
							prop.setProperty("Share_AmountType", Share_AmountType);
							prop.setProperty("Share_GLAcCode", String.valueOf (Share_GlAcCode));
							prop.setProperty("Share_TransactionMode", Share_TransferMode);
							prop.setProperty("Share_OrgID",String.valueOf ( Share_OrgId));
							
							
							prop.setProperty("Share_ProductName1", Share_ProductName1);
							prop.setProperty("Share_AccountNumber1", Share_AccountNumber1);
							prop.setProperty("Share_AccountDispalyName1", Share_AccDisplayName1);
							prop.setProperty("Share_BatchId1", String.valueOf (Share_BatchId1));
							prop.setProperty("Share_TransactionId1",String.valueOf ( Share_TransId1));
							prop.setProperty("Share_VoucherNumber1",String.valueOf ( Share_VoucherNumber1));
							prop.setProperty("Share_TransType1", Share_TranType1);
							prop.setProperty("Share_TransAmount1", Share_TransAmount1);
							prop.setProperty("Share_AmountType1", Share_AmountType1);
							prop.setProperty("Share_GLAcCode1", String.valueOf (Share_GlAcCode1));
							prop.setProperty("Share_TransactionMode1", Share_TransferMode1);
							prop.setProperty("Share_OrgID1",String.valueOf ( Share_OrgId1));
							
							
							prop.setProperty("Share_ProductName2", Share_ProductName2);
							prop.setProperty("Share_AccountNumber2", Share_AccountNumber2);
							prop.setProperty("Share_AccountDispalyName2", Share_AccDisplayName2);
							prop.setProperty("Share_BatchId2", String.valueOf (Share_BatchId2));
							prop.setProperty("Share_TransactionId2",String.valueOf ( Share_TransId2));
							prop.setProperty("Share_VoucherNumber2",String.valueOf ( Share_VoucherNumber2));
							prop.setProperty("Share_TransType2", Share_TranType2);
							prop.setProperty("Share_TransAmount2", Share_TransAmount2);
							prop.setProperty("Share_AmountType2", Share_AmountType2);
							prop.setProperty("Share_GLAcCode2", String.valueOf (Share_GlAcCode2));
							prop.setProperty("Share_TransactionMode2", Share_TransferMode2);
							prop.setProperty("Share_OrgID2",String.valueOf ( Share_OrgId2));
							
							
							prop.setProperty("Share_ProductName3", Share_ProductName3);
							prop.setProperty("Share_AccountNumber3", Share_AccountNumber3);
							prop.setProperty("Share_AccountDispalyName3", Share_AccDisplayName3);
							prop.setProperty("Share_BatchId3", String.valueOf (Share_BatchId3));
							prop.setProperty("Share_TransactionId3",String.valueOf ( Share_TransId3));
							prop.setProperty("Share_VoucherNumber3",String.valueOf ( Share_VoucherNumber3));
							prop.setProperty("Share_TransType3", Share_TranType3);
							prop.setProperty("Share_TransAmount3", Share_TransAmount3);
							prop.setProperty("Share_AmountType3", Share_AmountType3);
							prop.setProperty("Share_GLAcCode3", String.valueOf (Share_GlAcCode3));
							prop.setProperty("Share_TransactionMode3", Share_TransferMode3);
							prop.setProperty("Share_OrgID3",String.valueOf ( Share_OrgId3));
							
							prop.setProperty("SBProductName", SBProductName);
							prop.setProperty("SBAccountNumber", SBAccountNumber);
							prop.setProperty("SBAccountDispalyName", SBAccountDisplayName);
							prop.setProperty("SBBatchId", String.valueOf (SBBatchId));
							prop.setProperty("SBTransactionId",String.valueOf ( SBTransId));
							prop.setProperty("SBVoucherNumber",String.valueOf ( SBVoucherNo));
							prop.setProperty("SBTransType", SBTransType);
							prop.setProperty("SBTransAmount", SBTrnAmount);
							prop.setProperty("SBAmountType", SBAmountType);
							prop.setProperty("SBGLAcCode", String.valueOf (SBGlAcCode));
							prop.setProperty("SBTransactionMode", SbTrnMode);
							prop.setProperty("SbOrgID",String.valueOf ( SbOrgId));
							
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
