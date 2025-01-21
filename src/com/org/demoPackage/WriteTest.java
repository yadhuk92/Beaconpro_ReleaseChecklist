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

public class WriteTest {
	
	public static WebElement element;
	public static String Actual_Value;
	
	private static String ShareOpening_TransactionDate;
	private static String ShareOpening_ValueDate;
	
	public static void main(String args[]) {
	
	//public static WebDriver WriteFD_CASH_Details( WebDriver driver, String propertyValue) {
		
		try {
			
			
			//System.out.println("inside write method");
			//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				
					
					//String BatchId= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[5]")).getText();
					
				//	System.out.println("Trans ID "+BatchId);
					
			
					
					Connection con=(Connection) Common.DatabaseConnector();
					
					if(con !=null) {
			  	
						System.out.println("con= "+con );
						
					Statement stmt = con.createStatement();	
			        
			        //String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID =353678"; 
			       
			       // ResultSet rs1= stmt.executeQuery(Q_datefetch);
			        
			       // while(rs1.next()) {
			        	
			        //	ShareOpening_TransactionDate=rs1.getString(1);
			       // 	ShareOpening_ValueDate=rs1.getString(2);
			        //}
			        
			  
			        
					String Data="select * from  QaFnGetSummaryDetailsForMultpleFDOpening (353684)";
					
					ResultSet rs= stmt.executeQuery(Data);
					
					ResultSetMetaData rsmd;
					int row=rs.getRow();
					
					/*try {
			            rsmd = rs.getMetaData();

			            int NumOfCol = rsmd.getColumnCount();
			            
			          

			            while (rs.next()) {
			             

			                for (int i = 1; i <= NumOfCol; i++) {
			                   
			                	System.out.println(rs.getString(i));
			                	
			                }

			                row++;
			            }
			            
			            
			        } catch (SQLException e) {
			            throw e;
			        }
					*/
					  
					  
					System.out.println("SP executed");
					
					
					
					
					System.out.println("No of rows in result set "+ row);
		        	
					
					ArrayList ar=new ArrayList<>();
					
					 System.out.println("created arraylist");
					
					 
					 
					 
					 Properties prop=new Properties();
						
					 FileOutputStream fos = new FileOutputStream("./DataFiles/FD_CASH_Details.properties");
					 
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
					 
					 for (int m=0;m<ar.size();m++) {
						 
						 System.out.println("ar= "+ ar.get(m));
					 }
					
					 
					 
					 for(int k=0;k<ar.size();k++) {
					 
					 
						 for(int i=0; i<12;) {
					
						 
							 for(int j=1;j<=row;j++) { 
								 	
								
								 	System.out.println("Product Name"+j+" "+ String.valueOf(ar.get(i)));	
								 	prop.setProperty("ProductName"+ j, String.valueOf(ar.get(i)));
								 	
								 	i++;
								 	int p=0;
								 	p=i++;
								 	System.out.println("AccountNumber"+j+" "+ String.valueOf(ar.get(p)));	
								 	prop.setProperty("AccountNumber"+j,   String.valueOf(ar.get(p)));
								 	
								 	
								 	p++;
								 	int q=0;
								 	q=p++;
								 	System.out.println("AccountName"+j+" "+ String.valueOf(ar.get(q)));	
								 	prop.setProperty("AccountName"+j,  String.valueOf(ar.get(q)));
								 	
								 	
								 	q++;
								 	int s=0;
								 	s=q++; 
								 	System.out.println("BatchID"+j+" "+ String.valueOf(ar.get(s)));
								 	prop.setProperty("BatchID"+j,   String.valueOf(ar.get(s)));
					
								 	s++;
								 	int t=0;
								 	t=s++;
								 	System.out.println("TransID"+j+" "+ String.valueOf(ar.get(t)));
								 	prop.setProperty("TransID"+j,   String.valueOf(ar.get(t)));
				
								 	t++;
								 	int u=t;
								 	System.out.println("VoucherNo"+j+" "+ String.valueOf(ar.get(u)));
								 	prop.setProperty("VoucherNo"+j,  String.valueOf(ar.get(u)));
								 	
								 	u++;
								 	int v=u;
								 	System.out.println("TransType"+j+" "+ String.valueOf(ar.get(v)));
								 	prop.setProperty("TransType"+j,   String.valueOf(ar.get(v)));
								 	
								 	v++;
								 	int w=v;
								 	System.out.println("TransAmount"+j+" "+ String.valueOf(ar.get(w)));
								 	prop.setProperty("TransAmount"+j,  String.valueOf(ar.get(w)));
					
								 	w++;
								 	int x=w;
								 	System.out.println("AmountType"+j+" "+ String.valueOf(ar.get(x)));
								 	prop.setProperty("AmountType"+j,   String.valueOf(ar.get(x)));
								 	
								 	x++;
								 	int y=x;
								 	System.out.println("GLACcode"+j+" "+ String.valueOf(ar.get(y)));
								 	prop.setProperty("GLACcode"+j,  String.valueOf(ar.get(y)));
					
								 	y++;
								 	int z=y;
								 	System.out.println("TransMode"+j+" "+ String.valueOf(ar.get(z)));
								 	prop.setProperty("TransMode"+j,  String.valueOf(ar.get(z)));
								 	int a=z;
								 
								 	System.out.println("Branch"+j+" "+ String.valueOf(ar.get(a++)));
								 	prop.setProperty("Branch"+j,  String.valueOf(ar.get(a++)));
					
								 	i=a;
					
								 	if(i==11) {
						
								 		System.out.println("Value of i inside if"+ i);
						
								 		k=i;
								 	}
					
								 	System.out.println("Value of j"+ j);
					
							}
						
  	
						}
	
					 }
					
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
	

		}

}
