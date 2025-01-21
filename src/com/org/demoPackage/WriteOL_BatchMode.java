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

public class WriteOL_BatchMode {
 
 public static WebElement element;
 public static String Actual_Value;
 private static String FDAc_AccountNumber;
 private static int FDAc_TransId;
 private static int FDAc_VoucherNumber1;
 private static String FDAc_ProductName;
    private static String FDAc_DisplayName;
 private static int FDAc_BatchId;
 private static String FDAc_TranType1;
 private static String FDAc_TransAmount1;
 private static String FDAc_AmountType1;
 private static int FDAc_GlAcCode1;
 private static String FDAc_TransferMode;
 private static int FDAc_OrgId;
 private static int FDAc_VoucherNumber2;
 private static int FDAc_VoucherNumber3;
 private static int FDAc_VoucherNumber4;
 
 private static String FDAc_TransAmount2;
 private static String FDAc_TransAmount3;
 private static String FDAc_TransAmount4;
 
 private static String FDAc_TranType2;
 private static String FDAc_TranType3;
 private static String FDAc_TranType4;
 
 private static String FDAc_AmountType2;
 private static String FDAc_AmountType3;
 private static String FDAc_AmountType4;
 
 private static int FDAc_GlAcCode2;
 private static int FDAc_GlAcCode3;
 private static int FDAc_GlAcCode4;
 
 
 

 
 private static String ShareOpening_TransactionDate;
 private static String ShareOpening_ValueDate;
 private static int NoOfRows;
 private static int TransID;

 //public static void writeAccountOpeningRIDDetails_CashMode(WebDriver driver, String propertyValue) {
 
 public static void writeOLDetails_BatchMode(WebDriver driver, String propertyValue) {
  
  
  try {
   //NoOfRows=10;
   //TransID= 3613912;
	  System.out.println("inside write method");
          WebElement table = driver.findElement(By.id("tblCustList"));
                   List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
              NoOfRows=listOfRows.size()-1;
              System.out.println("Rows: "+NoOfRows);
              String TransID= driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[6]")).getText();
          System.out.println("Trans ID "+TransID);
          String ShareAcAmt=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[2]/td[9]")).getText();
          String FormFee=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[3]/td[9]")).getText();
          String RiskFund=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[4]/td[9]")).getText();
          String Insurance=driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr[5]/td[9]")).getText();
          
          
          float shareAmount= Float.parseFloat(ShareAcAmt);
          float FormAmt= Float.parseFloat(FormFee);
          float RiskAmt= Float.parseFloat(RiskFund);
          float InsuranceAmt= Float.parseFloat(Insurance);
     
     
           float ShareTotal=(shareAmount-(FormAmt+RiskAmt+InsuranceAmt));
     
         String share_total=String.valueOf(ShareTotal);
         System.out.println("Share total "+share_total);
     
     Connection con=(Connection) Common.DatabaseConnector();
		if(con !=null) {
          
           Statement stmt = con.createStatement();
           String Q_datefetch="select  TransDate,ValueDate from Transactions where TransID ='"+ TransID+"'"; 
           ResultSet rs2= stmt.executeQuery(Q_datefetch);
                    while(rs2.next()) {
            
            ShareOpening_TransactionDate=rs2.getString(1);
            ShareOpening_ValueDate=rs2.getString(2);
           }
                    
     String Data="select ProductName,AcNo,AcDisplayName,BatchID,TransID,TrnMode,OrgBranchID from QaFnGetSummaryDetails ("+TransID+")";

     ResultSet rs1= stmt.executeQuery(Data);
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
      
      FDAc_AccountNumber=(String) ar.get(1);

      FDAc_DisplayName=(String) ar.get(2);
 
      FDAc_BatchId=Integer.parseInt((String) ar.get(3));
 
      FDAc_TransId=Integer.parseInt((String) ar.get(4));
 
      FDAc_TransferMode=(String) ar.get(5);
 
      FDAc_OrgId=Integer.parseInt((String) ar.get(6));
      
      
      String Data1="select VoucherNo,CrorDr,TrnAmount,AmtTypeText,GLAcCode from QaFnGetSummaryDetails ("+TransID+")";

      ResultSet rs= stmt.executeQuery(Data1);
      int row1=rs.getRow();
      ArrayList ar1=new ArrayList<>();
      
       //System.out.println("created arraylist");
       ResultSetMetaData rsmd1;
       
       try {
                 rsmd1 = rs.getMetaData();

                 int NumOfCol1 = rsmd1.getColumnCount();
                 
               

                 while (rs.next()) {
                  

                     for (int i = 1; i <= NumOfCol1; i++) {
                        
                      ar1.add(rs.getString(i));
                      
                     }

                     row1++;
                 }
                 
                 
             } catch (SQLException e) {
                 throw e;
             }
       FDAc_VoucherNumber1=Integer.parseInt((String) ar1.get(0));
       
       FDAc_TranType1=(String) ar1.get(1);
  
       FDAc_TransAmount1=(String) ar1.get(2);

       FDAc_AmountType1=(String) ar1.get(3);

       FDAc_GlAcCode1=Integer.parseInt((String) ar1.get(4));
      
      FDAc_VoucherNumber2=Integer.parseInt((String) ar1.get(5));
      
      FDAc_TranType2=(String) ar1.get(6);
 
      FDAc_TransAmount2=(String) ar1.get(7);

      FDAc_AmountType2=(String) ar1.get(8);

      FDAc_GlAcCode2=Integer.parseInt((String) ar1.get(9));
      
      
     FDAc_VoucherNumber3=Integer.parseInt((String) ar1.get(10));
      
      FDAc_TranType3=(String) ar1.get(11);
 
      FDAc_TransAmount3=(String) ar1.get(12);

      FDAc_AmountType3=(String) ar1.get(13);

      FDAc_GlAcCode3=Integer.parseInt((String) ar1.get(14));
      
      
      FDAc_VoucherNumber4=Integer.parseInt((String) ar1.get(15));
      
      FDAc_TranType4=(String) ar1.get(16);
 
      FDAc_TransAmount4=(String) ar1.get(17);

      FDAc_AmountType4=(String) ar1.get(18);

      FDAc_GlAcCode4=Integer.parseInt((String) ar1.get(19));
      
      
    
     
      
     
   
     Properties prop=new Properties();
     
     FileOutputStream fos = new FileOutputStream("./DataFiles/OtherLoanOpenings_Batch.properties");
     
     prop.setProperty("FDAc_ProductName",FDAc_ProductName);
     prop.setProperty("FDAc_AccountNumber", FDAc_AccountNumber);
     prop.setProperty("FDAc_DisplayName",FDAc_DisplayName);
     prop.setProperty("FDAc_BatchId",String.valueOf(FDAc_BatchId));
     prop.setProperty("FDAc_TransId", String.valueOf(FDAc_TransId));
     prop.setProperty("FDAc_VoucherNumber1",String.valueOf(FDAc_VoucherNumber1));
     prop.setProperty("FDAc_TranType1", FDAc_TranType1); 
     prop.setProperty("FDAc_TransAmount1",FDAc_TransAmount1);
     prop.setProperty("FDAc_AmountType1",FDAc_AmountType1);
     prop.setProperty("FDAc_GlAcCode1",String.valueOf (FDAc_GlAcCode1)); 
     prop.setProperty("FDAc_TransferMode", FDAc_TransferMode);
     prop.setProperty("FDAc_OrgId",String.valueOf (FDAc_OrgId));
     prop.setProperty("FDAc_VoucherNumber2",String.valueOf(FDAc_VoucherNumber2));
     prop.setProperty("FDAc_TranType2", FDAc_TranType2); 
     prop.setProperty("FDAc_TransAmount2",FDAc_TransAmount2);
     prop.setProperty("FDAc_AmountType2",FDAc_AmountType2);
     prop.setProperty("FDAc_GlAcCode2",String.valueOf (FDAc_GlAcCode2)); 
     prop.setProperty("FDAc_VoucherNumber3",String.valueOf(FDAc_VoucherNumber3));
     prop.setProperty("FDAc_TranType3", FDAc_TranType3); 
     prop.setProperty("FDAc_TransAmount3",FDAc_TransAmount3);
     prop.setProperty("FDAc_AmountType3",FDAc_AmountType3);
     prop.setProperty("FDAc_GlAcCode3",String.valueOf (FDAc_GlAcCode3)); 
     prop.setProperty("FDAc_VoucherNumber4",String.valueOf(FDAc_VoucherNumber4));
     prop.setProperty("FDAc_TranType4", FDAc_TranType4); 
     prop.setProperty("FDAc_TransAmount4",FDAc_TransAmount4);
     prop.setProperty("FDAc_AmountType4",FDAc_AmountType4);
     prop.setProperty("FDAc_GlAcCode4",String.valueOf (FDAc_GlAcCode4)); 
     
     prop.setProperty("Share_Total", share_total);


     prop.setProperty("Share_TransactionDate", ShareOpening_TransactionDate.substring(0, 10));
     prop.setProperty("Share_ValueDate", ShareOpening_ValueDate.substring(0, 10));
      System.out.println("Written  details cash mode\n");
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

 
 