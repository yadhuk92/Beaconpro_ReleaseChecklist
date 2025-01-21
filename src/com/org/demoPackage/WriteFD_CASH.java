package com.org.demoPackage;

import java.io.FileOutputStream;
import java.math.BigInteger;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WriteFD_CASH {
 
 public static WebElement element;
 public static String Actual_Value;
 private static String FDAc_AccountNumber;
 private static int FDAc_TransId;
 private static int FDAc_VoucherNumber;
 private static String FDAc_ProductName;
    private static String FDAc_DisplayName;
 private static int FDAc_BatchId;
 private static String FDAc_TranType;
 private static String FDAc_TransAmount;
 private static String FDAc_AmountType;
 private static int FDAc_GlAcCode;
 private static String FDAc_TransferMode;
 private static int FDAc_OrgId;

 
 private static String ShareOpening_TransactionDate;
 private static String ShareOpening_ValueDate;
 private static int NoOfRows;
 private static int TransID;

 //public static void writeAccountOpeningRIDDetails_CashMode(WebDriver driver, String propertyValue) {
 
 public static void WriteFD_CASH_Details(WebDriver driver, String propertyValue) {
  
  
  try {
   //NoOfRows=10;
   //TransID= 3613912;
          WebElement table = driver.findElement(By.id("tblCustList"));
          List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
          NoOfRows=listOfRows.size()-1;
          System.out.println("Rows: "+NoOfRows);
          String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
          System.out.println("Trans ID "+TransID);
          Connection con=(Connection) Common.DatabaseConnector();
		  if(con !=null) {
           
          
           Statement stmt = con.createStatement();
           String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
           ResultSet rs2= stmt.executeQuery(Q_datefetch);
                    while(rs2.next()) {
            
            ShareOpening_TransactionDate=rs2.getString(1);
            ShareOpening_ValueDate=rs2.getString(2);
           }
           
           String Data1="select ProductName,AcDisplayName,BatchID,CrorDr,TrnAmount,AmtTypeText,GLAcCode,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";
        ResultSet rs1= stmt.executeQuery(Data1);
        int row=rs1.getRow();
       ArrayList ar=new ArrayList<>();
     
      //System.out.println("created arraylist");
      ResultSetMetaData rsmd;
      
      try {
                rsmd = rs1.getMetaData();

                int NumOfCol = rsmd.getColumnCount();
                
              

                while (rs1.next()) {
                 

                    for (int i = 1; i <= NumOfCol; i++) {
                       
                     ar.add(rs1.getString(i));
                     
                    }

                    row++;
                }
                
                
            } catch (SQLException e) {
                throw e;
            }
     // System.out.println("added to arraylist");
     // System.out.println("Readingfro arraylist to variables");
           
        FDAc_ProductName=(String) ar.get(0);
                   
           FDAc_DisplayName=(String) ar.get(1);
      
           FDAc_BatchId=Integer.parseInt((String) ar.get(2));
      
           FDAc_TranType=(String) ar.get(3);
      
           FDAc_TransAmount=(String) ar.get(4);
     
           FDAc_AmountType=(String) ar.get(5);
     
           FDAc_GlAcCode=Integer.parseInt((String) ar.get(6));
      
           FDAc_TransferMode=(String) ar.get(7);
      
           FDAc_OrgId=Integer.parseInt((String) ar.get(8));
     
     
     String Data="select AcNo,TransID,VoucherNo from QaFnGetSummaryDetails ("+TransID+")";
     ResultSet rs= stmt.executeQuery(Data);
     int counter=0;
     while(rs.next()) {
             counter=counter+1;
             FDAc_AccountNumber=rs.getString(1);
                       
              FDAc_TransId=Integer.parseInt(rs.getString(2));
         
              FDAc_VoucherNumber=Integer.parseInt(rs.getString(3));
       }
     if(counter==0) {
    	 
    	 Driver.tcFlag = "FAIL";
   	     Driver.comment = "Database did not return any records";
   	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
    	 
     }
   
     BigInteger Acnumber = new BigInteger(FDAc_AccountNumber);
   
     Properties prop=new Properties();
     
     FileOutputStream fos = new FileOutputStream("./DataFiles/FD_CASH_Details.properties");
     
     
     for(int i=1;i<=NoOfRows;i++) {
      
     prop.setProperty("AccountNumber"+i,String.valueOf(Acnumber ));
      
      BigInteger bi1 = new BigInteger("1");
      
      BigInteger AcNoresult = new BigInteger("50");
      
      AcNoresult=Acnumber.add(bi1);
      
      Acnumber=AcNoresult;
      
      prop.setProperty("TransID"+i,String.valueOf(FDAc_TransId ));
      FDAc_TransId++;
      
      prop.setProperty("VoucherNo"+i,String.valueOf(FDAc_VoucherNumber ));
      FDAc_VoucherNumber++;
      }
     prop.setProperty("FDAc_ProductName",FDAc_ProductName);
     prop.setProperty("FDAc_DisplayName",FDAc_DisplayName);
     prop.setProperty("FDAc_BatchId",String.valueOf(FDAc_BatchId));
     prop.setProperty("FDAc_TranType", FDAc_TranType); 
     prop.setProperty("FDAc_TransAmount",FDAc_TransAmount);
     prop.setProperty("FDAc_AmountType",FDAc_AmountType);
     prop.setProperty("FDAc_GlAcCode",String.valueOf (FDAc_GlAcCode)); 
     prop.setProperty("FDAc_TransferMode", FDAc_TransferMode);
     prop.setProperty("FDAc_OrgId",String.valueOf (FDAc_OrgId));
     prop.setProperty("Share_TransactionDate", ShareOpening_TransactionDate.substring(0, 10));
     prop.setProperty("Share_ValueDate", ShareOpening_ValueDate.substring(0, 10));
      System.out.println("Written  details cash mode\n");
      prop.store(fos, "Done");
      fos.close();
                        
		} else {
			Driver.tcFlag = "FAIL";
			Driver.comment = "Failed to connect to database";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			
		}
 
  }catch(Exception e){
   Driver.tcFlag = "FAIL";
   Driver.comment = Driver.objectName + " is not displayed or not identified";
   Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
   e.printStackTrace();
  }
  
 }
}