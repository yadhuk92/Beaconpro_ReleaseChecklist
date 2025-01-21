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

public class WriteAccountOpeningFD_BatchMode {

 public static WebElement element;
 public static String Actual_Value;
 private static String FDAc_ProductName;
 private static String FDAc_AccountNumber;
 private static String FDAc_DisplayName;
 private static int FDAc_BatchId;
 private static int FDAc_TransId;
 private static int FDAc_VoucherNumber;
 private static String FDAc_TranType;
 private static String FDAc_TransAmount;
 private static String FDAc_AmountType;
 private static int FDAc_GlAcCode;
 private static String FDAc_TransferMode;
 private static int FDAc_OrgId;
 
 private static String ShareOpening_TransactionDate;
 private static String ShareOpening_ValueDate;

 public static void writeAccountOpeningFDDetails_BatchMode(WebDriver driver, String propertyValue) {
  
  
try {
   
   //System.out.println("inside write method");
   element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
    
     
     String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
     
     System.out.println("Trans ID "+TransID);
     
     
     String ShareAcAmt=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
     
     
     float shareAmount= Float.parseFloat(ShareAcAmt);
     
     
     float ShareTotal=(shareAmount);
     
     String share_total=String.valueOf(ShareTotal);
     System.out.println("Share total "+share_total);
     
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
           
        FDAc_ProductName=(String) ar.get(0);
           
           FDAc_AccountNumber=(String) ar.get(1);
     
           FDAc_DisplayName=(String) ar.get(2);
      
           FDAc_BatchId=Integer.parseInt((String) ar.get(3));
      
           FDAc_TransId=Integer.parseInt((String) ar.get(4));
      
           FDAc_VoucherNumber=Integer.parseInt((String) ar.get(5));
      
           FDAc_TranType=(String) ar.get(6);
      
           FDAc_TransAmount=(String) ar.get(7);
     
           FDAc_AmountType=(String) ar.get(8);
     
           FDAc_GlAcCode=Integer.parseInt((String) ar.get(9));
      
           FDAc_TransferMode=(String) ar.get(10);
      
           FDAc_OrgId=Integer.parseInt((String) ar.get(11));
     
           
   
      // System.out.println("Creating property file");
      Properties prop=new Properties();
      
      FileOutputStream fos = new FileOutputStream("./DataFiles/FixedDepositAccountOpening_BatchMode.properties");
      
      prop.setProperty("FDAc_ProductName",FDAc_ProductName);
      prop.setProperty("FDAc_AccountNumber", FDAc_AccountNumber);
      prop.setProperty("FDAc_DisplayName",FDAc_DisplayName);
      prop.setProperty("FDAc_BatchId",String.valueOf(FDAc_BatchId));
      prop.setProperty("FDAc_TransId", String.valueOf(FDAc_TransId));
      prop.setProperty("FDAc_VoucherNumber",String.valueOf(FDAc_VoucherNumber));
      prop.setProperty("FDAc_TranType", FDAc_TranType); 
      prop.setProperty("FDAc_TransAmount",FDAc_TransAmount);
      prop.setProperty("FDAc_AmountType",FDAc_AmountType);
      prop.setProperty("FDAc_GlAcCode",String.valueOf (FDAc_GlAcCode)); 
      prop.setProperty("FDAc_TransferMode", FDAc_TransferMode);
      prop.setProperty("FDAc_OrgId",String.valueOf (FDAc_OrgId));
      
      prop.setProperty("Share_Total", share_total);
      
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