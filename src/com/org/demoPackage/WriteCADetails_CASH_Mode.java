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

public class WriteCADetails_CASH_Mode {
	public static WebElement element;
	public static String Actual_Value;
	public static int CABatchId;
	public static int CATransId;
	public static String CAProductName;
	public static String CAAccountDisplayName;
	public static int CAVoucherNo;
	public static String CATransType;
	public static String CATrnAmount;
	public static String CAAmountType;
	public static int CAGlAcCode;
	public static String CATrnMode;
	public static int CAOrgId;
	public static String CAAccountNumber;
	
	private static String CA_TransactionDate;
	private static String CA_ValueDate;

	public static WebDriver writeCAOpeningDetails_cash(WebDriver driver, String propertyValue) {
		
		
		
			
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
				        	
				        	CA_TransactionDate=rs1.getString(1);
				        	CA_ValueDate=rs1.getString(2);
				        }
				        
				       // System.out.println(ShareOpening_TransactionDate +"   "+ ShareOpening_ValueDate);
				        
						String Data="select * from QaFnGetSummaryDetails ("+TransID+")";
						ResultSet rs= stmt.executeQuery(Data);
						
						
						      while(rs.next()) {
						    	  
						    	  CAProductName=rs.getString(1);
						    	  CAAccountNumber=rs.getString(2);
						    	  CAAccountDisplayName=rs.getString(3);
						    	  CABatchId= Integer.parseInt(rs.getString(4));
						    	  CATransId= Integer.parseInt(rs.getString(5));
						    	  CAVoucherNo= Integer.parseInt(rs.getString(6));
						    	  CATransType=rs.getString(7);
						    	  CATrnAmount=rs.getString(8);
						    	  CAAmountType=rs.getString(9);
						    	  CAGlAcCode=Integer.parseInt(rs.getString(10));
						    	  CATrnMode=rs.getString(11);
						    	  CAOrgId=Integer.parseInt(rs.getString(12));
						      }

								// System.out.println("Creating property file");
								Properties prop=new Properties();
								
								FileOutputStream fos = new FileOutputStream("./DataFiles/CAOpeningDetails_CASH.properties");
								
								
								prop.setProperty("CA_ProductName", CAProductName);
								prop.setProperty("CA_AccountNumber", CAAccountNumber);
								prop.setProperty("CA_AccountDispalyName", CAAccountDisplayName);
								prop.setProperty("CA_BatchId", String.valueOf (CABatchId));
								prop.setProperty("CA_TransactionId",String.valueOf ( CATransId));
								prop.setProperty("CA_VoucherNumber",String.valueOf ( CAVoucherNo));
								prop.setProperty("CA_TransType", CATransType);
								prop.setProperty("CA_TransAmount", CATrnAmount);
								prop.setProperty("CA_AmountType", CAAmountType);
								prop.setProperty("CA_GLAcCode", String.valueOf (CAGlAcCode));
								prop.setProperty("CA_TransactionMode", CATrnMode);
								prop.setProperty("CA_OrgID",String.valueOf ( CAOrgId));
								
								prop.setProperty("CA_TransactionDate", CA_TransactionDate.substring(0, 10));
								prop.setProperty("CA_ValueDate", CA_ValueDate.substring(0, 10));
								
								System.out.println("Written");
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
