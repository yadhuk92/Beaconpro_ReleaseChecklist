package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyRIDSummary {

 
 private static WebElement element;
    public static int NoOfRows;
 
 
public static void VerifyAccNos(WebDriver driver) throws IOException {
  
 
 System.out.println("inside verify account numbers");
try {
  Properties prop=new Properties();
  InputStream input = new FileInputStream("./DataFiles/RIDAccountOpening_CashMode.properties");
  prop.load(input);
  
  System.out.println("File opened");
  
  
  
    WebElement table = driver.findElement(By.id("tblCustList"));

    List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
   
    NoOfRows=listOfRows.size()-1;
   
    System.out.println("Rows: "+NoOfRows);

    for(int i=1,j=0; i<=NoOfRows && j < NoOfRows;i++,j++) {
   
   
    
    if(prop.getProperty("AccountNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl"+j+"_tdAcNo']")).getText())){
    
     System.out.println("Equal");
     Driver.tcFlag = "PASS";
     Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("AccountNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl"+j+"_tdAcNo']")).getText(); 
     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    
   }else {
	   
	     Driver.tcFlag = "FAIL";
	     Driver.comment = "Fail" + " # " + "Value From Database: " + prop.getProperty("AccountNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl"+j+"_tdAcNo']")).getText(); 
	     Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
   }
  }
}catch(Exception e) {
	    Driver.tcFlag = "FAIL";
		Driver.comment = "Summary report is not displayed or identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
	
}
 }  
 public static void VerifyTransIDs(WebDriver driver) throws IOException {
   
  System.out.println("inside VerifyTransIDs");
 try { 
   Properties prop=new Properties();
   InputStream input = new FileInputStream("./DataFiles/RIDAccountOpening_CashMode.properties");
   prop.load(input);
   
   System.out.println("File opened");
   

   WebElement table = driver.findElement(By.id("tblCustList"));

   List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
  
    NoOfRows=listOfRows.size()-1;
  
   System.out.println("Rows: "+NoOfRows);
 
   
   
   for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows ;j++,i++) {
     
     if(prop.getProperty("TransID"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[6]")).getText())){
     
      System.out.println("Equal");
      Driver.tcFlag = "PASS";
      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("TransID"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[6]")).getText(); 
      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
     }else {
    	 
    	 Driver.tcFlag = "FAIL";
         Driver.comment = "Fail" + " # " + "Value From Database: " +prop.getProperty("TransID"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[6]")).getText(); 
         Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    	 
     }
    }
 }catch(Exception e) {
	 
	    Driver.tcFlag = "FAIL";
		Driver.comment = "Summary report is not displayed or identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
	 
 }
   }
    
  
 
 

public static void VerifyVoucherNos(WebDriver driver) throws IOException {
   
   System.out.println("inside VerifyVoucherNos");
   
   
try {
   WebElement table = driver.findElement(By.id("tblCustList"));

   List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
  
   NoOfRows=listOfRows.size()-1;
  
   System.out.println("Rows: "+NoOfRows);
 
   Properties prop=new Properties();
   InputStream input = new FileInputStream("./DataFiles/RIDAccountOpening_CashMode.properties");
   prop.load(input);
   System.out.println("File opened");
   
  
    
    for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows ;j++,i++) {
     
     
     if(prop.getProperty("VoucherNo"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
      
      System.out.println("Equal");
      Driver.tcFlag = "PASS";
      Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("VoucherNo"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
      
     
    }else {
    	 Driver.tcFlag = "FAIL";
         Driver.comment = "Fail" + " # " + "Value From Database: " +prop.getProperty("VoucherNo"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
         Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
    }
   }
    
}catch(Exception e) {
	
	    Driver.tcFlag = "FAIL";
		Driver.comment = "Summary report is not displayed or identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
 
   }
 
 
 
 }