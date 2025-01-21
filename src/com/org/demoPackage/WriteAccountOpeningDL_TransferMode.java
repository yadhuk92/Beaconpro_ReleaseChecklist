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

public class WriteAccountOpeningDL_TransferMode {

 public static WebElement element;
 public static String Actual_Value;
 private static String CrFDAc_ProductName;
 private static String CrFDAc_AccountNumber;
 private static String CrFDAc_DisplayName;
 private static int CrFDAc_BatchId;
 private static int CrFDAc_TransId;
 private static int CrFDAc_VoucherNumber;
 private static String CrFDAc_TranType;
 private static String CrFDAc_TransAmount;
 private static String CrFDAc_AmountType;
 private static int CrFDAc_GlAcCode;
 private static String CrFDAc_TransferMode;
 private static int CrFDAc_OrgId;
 private static String DrFDAc_ProductName;
 private static String DrFDAc_AccountNumber;
 private static String DrFDAc_AccountDisplayName;
 private static int DrFDAc_BatchId;
 private static int DrFDAc_TransId;
 private static int DrFDAc_VoucherNo;
 private static String DrFDAc_TransType;
 private static String DrFDAc_TrnAmount;
 private static String DrFDAc_AmountType;
 private static int DrFDAc_GlAcCode;
 private static String DrFDAc_TrnMode;
 private static int DrFDAc_OrgId;
 
 private static String ShareOpening_TransactionDate;
 private static String ShareOpening_ValueDate;

 public static void writeAccountOpeningDLDetails_TransferMode(WebDriver driver, String propertyValue) {
  
  
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
     
           
        CrFDAc_ProductName=(String) ar.get(0);
           
           CrFDAc_AccountNumber=(String) ar.get(1);
     
           CrFDAc_DisplayName=(String) ar.get(2);
      
           CrFDAc_BatchId=Integer.parseInt((String) ar.get(3));
      
           CrFDAc_TransId=Integer.parseInt((String) ar.get(4));
      
           CrFDAc_VoucherNumber=Integer.parseInt((String) ar.get(5));
      
           CrFDAc_TranType=(String) ar.get(6);
      
           CrFDAc_TransAmount=(String) ar.get(7);
     
           CrFDAc_AmountType=(String) ar.get(8);
     
           CrFDAc_GlAcCode=Integer.parseInt((String) ar.get(9));
      
           CrFDAc_TransferMode=(String) ar.get(10);
      
           CrFDAc_OrgId=Integer.parseInt((String) ar.get(11));
     
           
      DrFDAc_ProductName=(String) ar.get(12);
      
      DrFDAc_AccountNumber=(String) ar.get(13);
      
      DrFDAc_AccountDisplayName=(String) ar.get(14);
      
      DrFDAc_BatchId=Integer.parseInt((String) ar.get(15));
      
      DrFDAc_TransId=Integer.parseInt((String) ar.get(16));
      
      DrFDAc_VoucherNo=Integer.parseInt((String) ar.get(17));
      
      DrFDAc_TransType=(String) ar.get(18);
      
      DrFDAc_TrnAmount=(String) ar.get(19);
      
      DrFDAc_AmountType=(String) ar.get(20);
      
      DrFDAc_GlAcCode=Integer.parseInt((String) ar.get(21));
      
      DrFDAc_TrnMode=(String) ar.get(22);
      
      DrFDAc_OrgId=Integer.parseInt((String) ar.get(23));
      

      
   
      Properties prop=new Properties();
      
      FileOutputStream fos = new FileOutputStream("./DataFiles/DepositLoanOpening_TransferMode.properties");
      
      prop.setProperty("CrFDAc_ProductName",CrFDAc_ProductName);
      prop.setProperty("CrFDAc_AccountNumber", CrFDAc_AccountNumber);
      prop.setProperty("CrFDAc_DisplayName",CrFDAc_DisplayName);
      prop.setProperty("CrFDAc_BatchId",String.valueOf(CrFDAc_BatchId));
      prop.setProperty("CrFDAc_TransId", String.valueOf(CrFDAc_TransId));
      prop.setProperty("CrFDAc_VoucherNumber",String.valueOf(CrFDAc_VoucherNumber));
      prop.setProperty("CrFDAc_TranType", CrFDAc_TranType); 
      prop.setProperty("CrFDAc_TransAmount",CrFDAc_TransAmount);
      prop.setProperty("CrFDAc_AmountType",CrFDAc_AmountType);
      prop.setProperty("CrFDAc_GlAcCode",String.valueOf (CrFDAc_GlAcCode)); 
      prop.setProperty("CrFDAc_TransferMode", CrFDAc_TransferMode);
      prop.setProperty("CrFDAc_OrgId",String.valueOf (CrFDAc_OrgId));
      
      prop.setProperty("DrFDAc_ProductName", DrFDAc_ProductName);
      prop.setProperty("DrFDAc_AccountNumber", DrFDAc_AccountNumber);
      prop.setProperty("DrFDAc_AccountDisplayName", DrFDAc_AccountDisplayName);
      prop.setProperty("DrFDAc_BatchId", String.valueOf (DrFDAc_BatchId));
      prop.setProperty("DrFDAc_TransId",String.valueOf ( DrFDAc_TransId));
      prop.setProperty("DrFDAc_VoucherNo",String.valueOf ( DrFDAc_VoucherNo));
      prop.setProperty("DrFDAc_TransType", DrFDAc_TransType);
      prop.setProperty("DrFDAc_TrnAmount", DrFDAc_TrnAmount);
      prop.setProperty("DrFDAc_AmountType", DrFDAc_AmountType);
      prop.setProperty("DrFDAc_GlAcCode", String.valueOf (DrFDAc_GlAcCode));
      prop.setProperty("DrFDAc_TrnMode", DrFDAc_TrnMode);
      prop.setProperty("DrFDAc_OrgId",String.valueOf ( DrFDAc_OrgId));
      
      
      
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
  
 }
 
 

}