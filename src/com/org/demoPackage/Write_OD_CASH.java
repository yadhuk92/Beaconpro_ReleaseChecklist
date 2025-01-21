package com.org.demoPackage;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Write_OD_CASH {

	public static WebElement element;
	public static String Actual_Value;
	private static String TransactionDate;
	private static String ValueDate;
	private static String productName1;
	private static String AccountNumber1;
	private static String AccDisplayName1;
	private static String productName2;
	private static String AccountNumber2;
	private static String AccDisplayName2;
	private static String productName3;
	private static String AccountNumber3;
	private static String AccDisplayName3;
	private static String AccDisplayName;
    private static int BatchId;
	private static int TransId;
	private static String TransferMode;
	private static int OrgId;
	private static int NoOfRows;
	private static int VoucherNumber1;
	private static String TranType1;
	private static String TransAmount1;
	private static String AmountType1;
	private static int GlAcCode1;
	private static int VoucherNumber2;
	private static String TranType2;
	private static String TransAmount2;
	private static String AmountType2;
	private static int GlAcCode2;
	private static int VoucherNumber3;
	private static String TranType3;
	private static String TransAmount3;
	private static String AmountType3;
	private static int GlAcCode3;
	private static int VoucherNumber4;
	private static String TranType4;
	private static String TransAmount4;
	private static String AmountType4;
	private static int GlAcCode4;
	private static int VoucherNumber5;
	private static String TranType5;
	private static String TransAmount5;
	private static String AmountType5;
	private static int GlAcCode5;
	private static int VoucherNumber6;
	private static String TranType6;
	private static String TransAmount6;
	private static String AmountType6;
	private static int GlAcCode6;
	private static int VoucherNumber7;
	private static String TranType7;
	private static String TransAmount7;
	private static String AmountType7;
	private static int GlAcCode7;
	public static WebDriver Write_OD_CASH_Details(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE TO FILE");
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
			        	
			        	    TransactionDate=rs1.getString(1);
			        	    ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select distinct  ProductName,AcNo from QaFnGetSummaryDetails  ("+TransID+")";     
			        ResultSet rst= stmt.executeQuery(Data); 
			        System.out.println("SP1 EXECUTED");
			       
		              /*while(rst.next()) {
		        	
		        	        productName2 =rst.getString(1);
		        	        AccountNumber2=rst.getString(2);
		        	        productName1 =rst.getString(3);
		        	        AccountNumber1=rst.getString(4);
		              }*/
			   
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
				            productName2=(String) ar.get(0);
				      	    AccountNumber2=(String) ar.get(1);
				      	    productName1=(String) ar.get(2);
				      	    AccountNumber1=(String) ar.get(3);
				      	    
				   String Data1="select AcDisplayName,BatchID,TransID,TrnMode,OrgBranchID from QaFnGetSummaryDetails  ("+TransID+")";
				   ResultSet rs= stmt.executeQuery(Data1);
				   System.out.println("SP2 EXECUTED");
					
					   while(rs.next()) {
						
						    
						    AccDisplayName=rs.getString(1);
						    BatchId=Integer.parseInt(rs.getString(2));
						    TransId=Integer.parseInt(rs.getString(3));
						    TransferMode=rs.getString(4);
						    OrgId=Integer.parseInt(rs.getString(5));
						
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
				       
				            VoucherNumber4=Integer.parseInt((String) ar1.get(0));
				            TranType4=(String) ar1.get(1);
				            TransAmount4=(String) ar1.get(2);
                            AmountType4=(String) ar1.get(3);
				            GlAcCode4=Integer.parseInt((String) ar1.get(4));
				       
				       
				            VoucherNumber1=Integer.parseInt((String) ar1.get(5));
					        TranType1=(String) ar1.get(6);
					        TransAmount1=(String) ar1.get(7);
                            AmountType1=(String) ar1.get(8);
                            GlAcCode1=Integer.parseInt((String) ar1.get(9));
				       
				       
				            VoucherNumber3=Integer.parseInt((String) ar1.get(10));
				            TranType3=(String) ar1.get(11);
				            TransAmount3=(String) ar1.get(12);
                            AmountType3=(String) ar1.get(13);
                            GlAcCode3=Integer.parseInt((String) ar1.get(14));
				       
				      
				            VoucherNumber2=Integer.parseInt((String) ar1.get(15));
				            TranType2=(String) ar1.get(16);
				            TransAmount2=(String) ar1.get(17);
                            AmountType2=(String) ar1.get(18);
                            GlAcCode2=Integer.parseInt((String) ar1.get(19));
                            
                            VoucherNumber6=Integer.parseInt((String) ar1.get(20));
				            TranType6=(String) ar1.get(21);
				            TransAmount6=(String) ar1.get(22);
                            AmountType6=(String) ar1.get(23);
                            GlAcCode6=Integer.parseInt((String) ar1.get(24));
                            
                            VoucherNumber5=Integer.parseInt((String) ar1.get(25));
				            TranType5=(String) ar1.get(26);
				            TransAmount5=(String) ar1.get(27);
                            AmountType5=(String) ar1.get(28);
                            GlAcCode5=Integer.parseInt((String) ar1.get(29));
				      
				      
				    
				      Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/OD_CASH_Details.properties");
				      prop.setProperty("ProductName1",productName1);
				      prop.setProperty("AccountNumber1", AccountNumber1);
				      prop.setProperty("ProductName2",productName2);
				      prop.setProperty("AccountNumber2", AccountNumber2);
				      prop.setProperty("DisplayName",AccDisplayName);
				      prop.setProperty("BatchId",String.valueOf(BatchId));
				      prop.setProperty("TransId", String.valueOf(TransId));
				      prop.setProperty("TransferMode", TransferMode);
				      prop.setProperty("OrgId",String.valueOf (OrgId));
				      
				      prop.setProperty("VoucherNumber1",String.valueOf(VoucherNumber1));
				      prop.setProperty("TranType1", TranType1); 
				      prop.setProperty("TransAmount1",TransAmount1);
				      prop.setProperty("AmountType1",AmountType1);
				      prop.setProperty("GlAcCode1",String.valueOf (GlAcCode1)); 
				      
				   
				      prop.setProperty("VoucherNumber2",String.valueOf(VoucherNumber2));
				      prop.setProperty("TranType2", TranType2); 
				      prop.setProperty("TransAmount2",TransAmount2);
				      prop.setProperty("AmountType2",AmountType2);
				      prop.setProperty("GlAcCode2",String.valueOf (GlAcCode2)); 
				      
				      prop.setProperty("VoucherNumber3",String.valueOf(VoucherNumber3));
				      prop.setProperty("TranType3", TranType3); 
				      prop.setProperty("TransAmount3",TransAmount3);
				      prop.setProperty("AmountType3",AmountType3);
				      prop.setProperty("GlAcCode3",String.valueOf (GlAcCode3)); 
				      
				      
				      prop.setProperty("VoucherNumber4",String.valueOf(VoucherNumber4));
				      prop.setProperty("TranType4", TranType4); 
				      prop.setProperty("TransAmount4",TransAmount4);
				      prop.setProperty("AmountType4",AmountType4);
				      prop.setProperty("GlAcCode4",String.valueOf (GlAcCode4));
				      
				      prop.setProperty("VoucherNumber5",String.valueOf(VoucherNumber5));
				      prop.setProperty("TranType5", TranType5); 
				      prop.setProperty("TransAmount5",TransAmount5);
				      prop.setProperty("AmountType5",AmountType5);
				      prop.setProperty("GlAcCode5",String.valueOf (GlAcCode5));
				      
				      prop.setProperty("VoucherNumber6",String.valueOf(VoucherNumber6));
				      prop.setProperty("TranType6", TranType6); 
				      prop.setProperty("TransAmount6",TransAmount6);
				      prop.setProperty("AmountType6",AmountType6);
				      prop.setProperty("GlAcCode6",String.valueOf (GlAcCode6));
				      
							
				      
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
	
 public static WebDriver Write_OD_AUTOPOST_Details(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE TO FILE");
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
			        	
			        	    TransactionDate=rs1.getString(1);
			        	    ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select distinct  ProductName,AcNo,AcDisplayName from QaFnGetSummaryDetails  ("+TransID+")";     
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
				        productName2=(String) ar.get(0);
			      	    AccountNumber2=(String) ar.get(1);
			      	    AccDisplayName2=(String) ar.get(2);
			      	    productName1=(String) ar.get(3);
			      	    AccountNumber1=(String) ar.get(4);
			      	    AccDisplayName1=(String) ar.get(5);
			      	    productName3=(String) ar.get(6);
		      	        AccountNumber3=(String) ar.get(7);
		      	        AccDisplayName3=(String) ar.get(8);
				      	    
				   String Data1="select BatchID,TransID,TrnMode,OrgBranchID from QaFnGetSummaryDetails  ("+TransID+")";
				   ResultSet rs= stmt.executeQuery(Data1);
				   System.out.println("SP2 EXECUTED");
					
					   while(rs.next()) {
						
						    
						    
						    BatchId=Integer.parseInt(rs.getString(1));
						    TransId=Integer.parseInt(rs.getString(2));
						    TransferMode=rs.getString(3);
						    OrgId=Integer.parseInt(rs.getString(4));
						
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
				       
				            
				        VoucherNumber5=Integer.parseInt((String) ar1.get(0));
			            TranType5=(String) ar1.get(1);
			            TransAmount5=(String) ar1.get(2);
                        AmountType5=(String) ar1.get(3);
			            GlAcCode5=Integer.parseInt((String) ar1.get(4));
			       
			       
			            VoucherNumber4=Integer.parseInt((String) ar1.get(5));
				        TranType4=(String) ar1.get(6);
				        TransAmount4=(String) ar1.get(7);
                        AmountType4=(String) ar1.get(8);
                        GlAcCode4=Integer.parseInt((String) ar1.get(9));
			       
			       
			            VoucherNumber2=Integer.parseInt((String) ar1.get(10));
			            TranType2=(String) ar1.get(11);
			            TransAmount2=(String) ar1.get(12);
                        AmountType2=(String) ar1.get(13);
                        GlAcCode2=Integer.parseInt((String) ar1.get(14));
			       
			      
			            VoucherNumber7=Integer.parseInt((String) ar1.get(15));
			            TranType7=(String) ar1.get(16);
			            TransAmount7=(String) ar1.get(17);
                        AmountType7=(String) ar1.get(18);
                        GlAcCode7=Integer.parseInt((String) ar1.get(19));
                       
                       
                        VoucherNumber6=Integer.parseInt((String) ar1.get(20));
				        TranType6=(String) ar1.get(21);
				        TransAmount6=(String) ar1.get(22);
                        AmountType6=(String) ar1.get(23);
                        GlAcCode6=Integer.parseInt((String) ar1.get(24));
                        
                        VoucherNumber1=Integer.parseInt((String) ar1.get(25));
				        TranType1=(String) ar1.get(26);
				        TransAmount1=(String) ar1.get(27);
                        AmountType1=(String) ar1.get(28);
                        GlAcCode1=Integer.parseInt((String) ar1.get(29));
                        
                        VoucherNumber3=Integer.parseInt((String) ar1.get(30));
				        TranType3=(String) ar1.get(31);
				        TransAmount3=(String) ar1.get(32);
                        AmountType3=(String) ar1.get(33);
                        GlAcCode3=Integer.parseInt((String) ar1.get(34));
				      
				    
				      Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/OD_AUTOPOST_Details.properties");
				      prop.setProperty("ProductName1",productName1);
				      prop.setProperty("AccountNumber1", AccountNumber1);
				      prop.setProperty("AccDisplayName1",AccDisplayName1);
				      prop.setProperty("ProductName2",productName2);
				      prop.setProperty("AccountNumber2", AccountNumber2);
				      prop.setProperty("AccDisplayName2",AccDisplayName2);
				      prop.setProperty("ProductName3",productName3);
				      prop.setProperty("AccountNumber3", AccountNumber3);
				      prop.setProperty("AccDisplayName3",AccDisplayName3);
				      prop.setProperty("BatchId",String.valueOf(BatchId));
				      prop.setProperty("TransId", String.valueOf(TransId));
				      prop.setProperty("TransferMode", TransferMode);
				      prop.setProperty("OrgId",String.valueOf (OrgId));
				      
				      prop.setProperty("VoucherNumber1",String.valueOf(VoucherNumber1));
				      prop.setProperty("TranType1", TranType1); 
				      prop.setProperty("TransAmount1",TransAmount1);
				      prop.setProperty("AmountType1",AmountType1);
				      prop.setProperty("GlAcCode1",String.valueOf (GlAcCode1)); 
				      
				   
				      prop.setProperty("VoucherNumber2",String.valueOf(VoucherNumber2));
				      prop.setProperty("TranType2", TranType2); 
				      prop.setProperty("TransAmount2",TransAmount2);
				      prop.setProperty("AmountType2",AmountType2);
				      prop.setProperty("GlAcCode2",String.valueOf (GlAcCode2)); 
				      
				      prop.setProperty("VoucherNumber3",String.valueOf(VoucherNumber3));
				      prop.setProperty("TranType3", TranType3); 
				      prop.setProperty("TransAmount3",TransAmount3);
				      prop.setProperty("AmountType3",AmountType3);
				      prop.setProperty("GlAcCode3",String.valueOf (GlAcCode3)); 
				      
				      
				      prop.setProperty("VoucherNumber4",String.valueOf(VoucherNumber4));
				      prop.setProperty("TranType4", TranType4); 
				      prop.setProperty("TransAmount4",TransAmount4);
				      prop.setProperty("AmountType4",AmountType4);
				      prop.setProperty("GlAcCode4",String.valueOf (GlAcCode4)); 
				      
				      prop.setProperty("VoucherNumber5",String.valueOf(VoucherNumber5));
				      prop.setProperty("TranType5", TranType5); 
				      prop.setProperty("TransAmount5",TransAmount5);
				      prop.setProperty("AmountType5",AmountType5);
				      prop.setProperty("GlAcCode5",String.valueOf (GlAcCode5));
				      
				      prop.setProperty("VoucherNumber6",String.valueOf(VoucherNumber6));
				      prop.setProperty("TranType6", TranType6); 
				      prop.setProperty("TransAmount6",TransAmount6);
				      prop.setProperty("AmountType6",AmountType6);
				      prop.setProperty("GlAcCode6",String.valueOf (GlAcCode6));
				      
				      prop.setProperty("VoucherNumber7",String.valueOf(VoucherNumber7));
				      prop.setProperty("TranType7", TranType7); 
				      prop.setProperty("TransAmount7",TransAmount7);
				      prop.setProperty("AmountType7",AmountType7);
				      prop.setProperty("GlAcCode7",String.valueOf (GlAcCode7));
				      
				      
				      
							
				      
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
	
 public static WebDriver Write_OD_BATCH_Details(WebDriver driver, String propertyValue) {
		
		try {
			
			       System.out.println("WRITE TO FILE");
			       element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
					System.out.println("Trans ID "+TransID);
					String Principal=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
			        String FormFee=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[3]/td[9]")).getText();
			        String RiskFund=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[4]/td[9]")).getText();
			        String ProvidentFund=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[5]/td[9]")).getText();
			          
			          
			          float PrincipalAmt= Float.parseFloat(Principal);
			          float FormAmt= Float.parseFloat(FormFee);
			          float RiskAmt= Float.parseFloat(RiskFund);
			          float ProvidentAmt= Float.parseFloat(ProvidentFund);
			     
			     
			           float ShareTotal=(PrincipalAmt-(FormAmt+RiskAmt+ProvidentAmt));
			     
			         String share_total=String.valueOf(ShareTotal);
			         System.out.println("Share total "+share_total);
					
					Connection con=(Connection) Common.DatabaseConnector();
					if(con !=null) {
			        Statement stmt = con.createStatement();	
			        
			        String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
			        ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        System.out.println("FETCHED DATES");
			       
			           while(rs1.next()) {
			        	
			        	    TransactionDate=rs1.getString(1);
			        	    ValueDate=rs1.getString(2);
			           }
			        
			        String Data="select distinct  ProductName,AcNo from QaFnGetSummaryDetails  ("+TransID+")";     
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
				            
			      	        productName2=(String) ar.get(0);
				      	    AccountNumber2=(String) ar.get(1);
				      	    productName1=(String) ar.get(2);
				      	    AccountNumber1=(String) ar.get(3);
			      	   
				   String Data1="select AcDisplayName,BatchID,TransID,TrnMode,OrgBranchID from QaFnGetSummaryDetails  ("+TransID+")";
				   ResultSet rs= stmt.executeQuery(Data1);
				   System.out.println("SP2 EXECUTED");
					
					   while(rs.next()) {
						
						    
						    AccDisplayName=rs.getString(1);
						    BatchId=Integer.parseInt(rs.getString(2));
						    TransId=Integer.parseInt(rs.getString(3));
						    TransferMode=rs.getString(4);
						    OrgId=Integer.parseInt(rs.getString(5));
						
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
				       
				            
                            
				       VoucherNumber4=Integer.parseInt((String) ar1.get(0));
			           TranType4=(String) ar1.get(1);
			           TransAmount4=(String) ar1.get(2);
                       AmountType4=(String) ar1.get(3);
			           GlAcCode4=Integer.parseInt((String) ar1.get(4));
			       
			       
			           VoucherNumber1=Integer.parseInt((String) ar1.get(5));
				       TranType1=(String) ar1.get(6);
				       TransAmount1=(String) ar1.get(7);
                       AmountType1=(String) ar1.get(8);
                       GlAcCode1=Integer.parseInt((String) ar1.get(9));
			       
			       
			           VoucherNumber3=Integer.parseInt((String) ar1.get(10));
			           TranType3=(String) ar1.get(11);
			           TransAmount3=(String) ar1.get(12);
                       AmountType3=(String) ar1.get(13);
                       GlAcCode3=Integer.parseInt((String) ar1.get(14));
			       
			      
			           VoucherNumber2=Integer.parseInt((String) ar1.get(15));
			           TranType2=(String) ar1.get(16);
			           TransAmount2=(String) ar1.get(17);
                       AmountType2=(String) ar1.get(18);
                       GlAcCode2=Integer.parseInt((String) ar1.get(19));
                       
                       VoucherNumber6=Integer.parseInt((String) ar1.get(20));
			           TranType6=(String) ar1.get(21);
			           TransAmount6=(String) ar1.get(22);
                       AmountType6=(String) ar1.get(23);
                       GlAcCode6=Integer.parseInt((String) ar1.get(24));
                       
                       VoucherNumber5=Integer.parseInt((String) ar1.get(25));
			           TranType5=(String) ar1.get(26);
			           TransAmount5=(String) ar1.get(27);
                       AmountType5=(String) ar1.get(28);
                       GlAcCode5=Integer.parseInt((String) ar1.get(29));
                            
				      
				      
				    
				      Properties prop=new Properties();
				      
				      FileOutputStream fos = new FileOutputStream("./DataFiles/OD_BATCH_Details.properties");
				      prop.setProperty("ProductName1",productName1);
				      prop.setProperty("AccountNumber1", AccountNumber1);
				      prop.setProperty("ProductName2",productName2);
				      prop.setProperty("AccountNumber2", AccountNumber2);
				      prop.setProperty("DisplayName",AccDisplayName);
				      prop.setProperty("BatchId",String.valueOf(BatchId));
				      prop.setProperty("TransId", String.valueOf(TransId));
				      prop.setProperty("TransferMode", TransferMode);
				      prop.setProperty("OrgId",String.valueOf (OrgId));
				      
				      
				      prop.setProperty("VoucherNumber1",String.valueOf(VoucherNumber1));
				      prop.setProperty("TranType1", TranType1); 
				      prop.setProperty("TransAmount1",TransAmount1);
				      prop.setProperty("AmountType1",AmountType1);
				      prop.setProperty("GlAcCode1",String.valueOf (GlAcCode1)); 
				      
				   
				      prop.setProperty("VoucherNumber2",String.valueOf(VoucherNumber2));
				      prop.setProperty("TranType2", TranType2); 
				      prop.setProperty("TransAmount2",TransAmount2);
				      prop.setProperty("AmountType2",AmountType2);
				      prop.setProperty("GlAcCode2",String.valueOf (GlAcCode2)); 
				      
				      prop.setProperty("VoucherNumber3",String.valueOf(VoucherNumber3));
				      prop.setProperty("TranType3", TranType3); 
				      prop.setProperty("TransAmount3",TransAmount3);
				      prop.setProperty("AmountType3",AmountType3);
				      prop.setProperty("GlAcCode3",String.valueOf (GlAcCode3)); 
				      
				      
				      prop.setProperty("VoucherNumber4",String.valueOf(VoucherNumber4));
				      prop.setProperty("TranType4", TranType4); 
				      prop.setProperty("TransAmount4",TransAmount4);
				      prop.setProperty("AmountType4",AmountType4);
				      prop.setProperty("GlAcCode4",String.valueOf (GlAcCode4)); 
				      
				      prop.setProperty("VoucherNumber5",String.valueOf(VoucherNumber5));
				      prop.setProperty("TranType5", TranType5); 
				      prop.setProperty("TransAmount5",TransAmount5);
				      prop.setProperty("AmountType5",AmountType5);
				      prop.setProperty("GlAcCode5",String.valueOf (GlAcCode5));
				      
				      prop.setProperty("VoucherNumber6",String.valueOf(VoucherNumber6));
				      prop.setProperty("TranType6", TranType6); 
				      prop.setProperty("TransAmount6",TransAmount6);
				      prop.setProperty("AmountType6",AmountType6);
				      prop.setProperty("GlAcCode6",String.valueOf (GlAcCode6));
				      
				      prop.setProperty("Share_Total", share_total);		
				      
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
	
		
		
	}
