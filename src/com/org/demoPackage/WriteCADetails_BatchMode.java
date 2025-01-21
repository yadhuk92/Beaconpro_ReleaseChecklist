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

public class WriteCADetails_BatchMode {
	public static WebElement element;
	public static String Actual_Value;
	
	public static String CA_productName;
	public static String CA_AccountNumber;
	public static String CA_AccDisplayName;
	public static int CA_BatchId;
	public static int CA_TransId;
	public static int CA_VoucherNumber;
	public static String CA_TranType;
	public static String CA_TransAmount;
	public static String CA_AmountType;
	public static int CA_GlAcCode;
	public static String CA_TransferMode;
	public static int CA_OrgId;
	
	private static String CA_TransactionDate;
	private static String CA_ValueDate;

	public static WebDriver writeCADetails_BatchMode(WebDriver driver, String propertyValue) {
	
			
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
				        	
				        	CA_TransactionDate=rs1.getString(1);
				        	CA_ValueDate=rs1.getString(2);
				        }
				        
				        float TotalAmount=0;
				        String Amount1=null;
				       
				        
				        try {
				        	
				         Amount1=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]\r\n" + 
				        		"")).getText();
				        
				         
				         
				       float a= Float.parseFloat(Amount1);
				   
				        
				        TotalAmount= a;
				      
				       
				        }catch (NumberFormatException e) {
				        	
				        	e.printStackTrace();
				        }
				        
				        
				       System.out.println(CA_TransactionDate +"   "+ CA_ValueDate);
				        
                   String Data="select * from QaFnGetSummaryDetails ("+TransID+")";
						ResultSet rs= stmt.executeQuery(Data);
						
						System.out.println("SP executed");
						
						while(rs.next()) {
							
							CA_productName=rs.getString(1);
							
							CA_AccountNumber=rs.getString(2);
							
							CA_AccDisplayName=rs.getString(3);
							
							CA_BatchId=Integer.parseInt(rs.getString(4));
							
							CA_TransId=Integer.parseInt(rs.getString(5));
							
							CA_VoucherNumber=Integer.parseInt(rs.getString(6));
							
							CA_TranType=rs.getString(7);
							
							CA_TransAmount=rs.getString(8);
							
							CA_AmountType=rs.getString(9);
							
							CA_GlAcCode=Integer.parseInt(rs.getString(10));
							
							CA_TransferMode=rs.getString(11);
							
							CA_OrgId=Integer.parseInt(rs.getString(12));
							
						}
						      
						      	
								
						
					
								System.out.println("Creating property file");
								Properties prop=new Properties();
								
								FileOutputStream fos = new FileOutputStream("./DataFiles/CAOpeningDetails_BATCH.properties");
								
								prop.setProperty("CA_productName",CA_productName);
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
								prop.setProperty("CA_TransactionDate", CA_TransactionDate.substring(0, 10));
								prop.setProperty("CA_ValueDate", CA_ValueDate.substring(0, 10));
								prop.setProperty("TotalAmount", String.valueOf(TotalAmount));
								System.out.println("Written share details batch mode");
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
