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

public class Write_DD_CashDetails {
	public static WebElement element;
	public static String Actual_Value;
	
	private static String ShareOpening_TransactionDate;
	private static String ShareOpening_ValueDate;
	private static String DD_ProductName;
	private static String DD_AccountNumber;
	private static String DD_DisplayName;
	private static int DD_BatchId;
	private static int DD_TransId;
	private static int DD_VoucherNumber;
	private static String DD_TranType;
	private static String DD_TransAmount;
	private static String DD_AmountType;
	private static int DD_GlAcCode;
	private static String DD_TransferMode;
	private static int DD_OrgId;
	
	public static WebDriver write_DD_Details_CashMode( WebDriver driver, String propertyValue) {
		
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
			        	
			        	ShareOpening_TransactionDate=rs1.getString(1);
			        	ShareOpening_ValueDate=rs1.getString(2);
			        }
			        
			     
			        
					String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
					ResultSet rs= stmt.executeQuery(Data);
					
					//System.out.println("SP executed");
					
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
					// System.out.println("added to arraylist");
					// System.out.println("Readingfro arraylist to variables");
					      
					 	DD_ProductName=(String) ar.get(0);
				      	
				      	DD_AccountNumber=(String) ar.get(1);
					
				      	DD_DisplayName=(String) ar.get(2);
						
				      	DD_BatchId=Integer.parseInt((String) ar.get(3));
						
				      	DD_TransId=Integer.parseInt((String) ar.get(4));
						
				      	DD_VoucherNumber=Integer.parseInt((String) ar.get(5));
						
				      	DD_TranType=(String) ar.get(6);
						
				      	DD_TransAmount=(String) ar.get(7);
					
				      	DD_AmountType=(String) ar.get(8);
					
				      	DD_GlAcCode=Integer.parseInt((String) ar.get(9));
						
				      	DD_TransferMode=(String) ar.get(10);
						
				      	DD_OrgId=Integer.parseInt((String) ar.get(11));
					
				      	
						
						
				    
					
				
							// System.out.println("Creating property file");
							Properties prop=new Properties();
							
							FileOutputStream fos = new FileOutputStream("./DataFiles/DD_CASH_Details.properties");
							
							prop.setProperty("DD_ProductName",DD_ProductName);
							prop.setProperty("DD_AccountNumber", DD_AccountNumber);
							prop.setProperty("DD_DisplayName",DD_DisplayName);
							prop.setProperty("DD_BatchId",String.valueOf(DD_BatchId));
							prop.setProperty("DD_TransId", String.valueOf(DD_TransId));
							prop.setProperty("DD_VoucherNumber",String.valueOf(DD_VoucherNumber));
							prop.setProperty("DD_TranType", DD_TranType);	
							prop.setProperty("DD_TransAmount",DD_TransAmount);
							prop.setProperty("DD_AmountType",DD_AmountType);
							prop.setProperty("DD_GlAcCode",String.valueOf (DD_GlAcCode));	
							prop.setProperty("DD_TransferMode", DD_TransferMode);
							prop.setProperty("DD_OrgId",String.valueOf (DD_OrgId));
							
							
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
	return driver;

		}
}
