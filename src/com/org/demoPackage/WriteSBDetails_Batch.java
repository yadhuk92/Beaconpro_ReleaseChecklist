package com.org.demoPackage;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WriteSBDetails_Batch {
	
	public static WebElement element;
	public static String Actual_Value;
	
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

	public static WebDriver writeSBOpeningDetails_Batch(WebDriver driver, String propertyValue) {
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
			        System.out.println("fetched dates");
			        while(rs1.next()) {
			        	
			        	ShareOpening_TransactionDate=rs1.getString(1);
			        	ShareOpening_ValueDate=rs1.getString(2);
			        }
			        
			        float TotalAmount=0;
			        String Amount1=null;
			       
			        
			        try {
			         Amount1=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]\r\n" + 
			        		"")).getText();
			        
			        // Amount2=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[3]/td[9]\r\n" + 
			        	//	"\r\n" + 
			        	//	"")).getText();
			         
			       float a= Float.parseFloat(Amount1);
			     
			        
			        TotalAmount= a;
			      
			       
			        }catch (NumberFormatException e) {
			        	
			        	e.printStackTrace();
			        }
			        
			        
			       // System.out.println(ShareOpening_TransactionDate +"   "+ ShareOpening_ValueDate);
			        
					String Data="select * from QaFnGetSummaryDetails ("+TransID+")";
					ResultSet rs= stmt.executeQuery(Data);
					
					while(rs.next()) {
					
						SBProductName=rs.getString(1);
						
						SBAccountNumber=rs.getString(2);
						
						SBAccountDisplayName=rs.getString(3);
						
						SBBatchId=Integer.parseInt(rs.getString(4));
						
						SBTransId=Integer.parseInt(rs.getString(5));
						
						SBVoucherNo=Integer.parseInt(rs.getString(6));
						
						SBTransType=rs.getString(7);
						
						SBTrnAmount=rs.getString(8);
						
						SBAmountType=rs.getString(9);
						
						SBGlAcCode=Integer.parseInt(rs.getString(10));
						
						SbTrnMode=rs.getString(11);
						
						SbOrgId=Integer.parseInt(rs.getString(12));
						
					}
					// System.out.println("added to arraylist");
					// System.out.println("Readingfro arraylist to variables");
					      
					      	
						
							
					      
					
				
							// System.out.println("Creating property file");
							Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/SBOpeningDetails_BATCH.properties");
							
							
							prop.setProperty("SB_ProductName", SBProductName);
							prop.setProperty("SB_AccountNumber", SBAccountNumber);
							prop.setProperty("SB_AccountDispalyName", SBAccountDisplayName);
							prop.setProperty("SB_BatchId", String.valueOf (SBBatchId));
							prop.setProperty("SB_TransactionId",String.valueOf ( SBTransId));
							prop.setProperty("SB_VoucherNumber",String.valueOf ( SBVoucherNo));
							prop.setProperty("SB_TransType", SBTransType);
							prop.setProperty("SB_TransAmount", SBTrnAmount);
							prop.setProperty("SB_AmountType", SBAmountType);
							prop.setProperty("SB_GLAcCode", String.valueOf (SBGlAcCode));
							prop.setProperty("SB_TransactionMode", SbTrnMode);
							prop.setProperty("SB_OrgID",String.valueOf ( SbOrgId));
							prop.setProperty("SB_TransactionDate", ShareOpening_TransactionDate.substring(0, 10));
							prop.setProperty("SB_ValueDate", ShareOpening_ValueDate.substring(0, 10));
							prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
							System.out.println("Written SB details BATCH mode");
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
