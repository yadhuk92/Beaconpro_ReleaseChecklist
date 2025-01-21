package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyDLCreditSummary {
	
	private static WebElement element;
    public static int NoOfRows;
    
    
    
public static void VerifyProductName(WebDriver driver) throws IOException {
    	  
    	 
    	    System.out.println("VERIFY PRODUCT NAME:");
            Properties prop=new Properties();
    	    InputStream input = new FileInputStream("./DataFiles/DLCredit_Autopost.properties");
    	    prop.load(input);
    	    WebElement table = driver.findElement(By.id("tblCustList"));
            List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
    	    NoOfRows=listOfRows.size()-1;
    	    System.out.println("Rows: "+NoOfRows);
    	    
                       for(int i=1,j=0; i<=NoOfRows && j < NoOfRows;i++,j++) {
    	   
    	                   System.out.println("FDAc_ProductName"+i+"="+driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl"+j+"_tdPrdName']")).getText());
    	    
    	                     if(prop.getProperty("FDAc_ProductName"+i).equals(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl"+j+"_tdPrdName']")).getText())){
    	    
    	                        System.out.println("Equal");
    	                        Driver.tcFlag = "PASS";
    	                        Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAc_ProductName"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl"+j+"_tdPrdName']")).getText(); 
    	                        Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
    	    
    	                     }
    	                }
    	   
 }  
    
    public static void VerifyAccountNo(WebDriver driver) throws IOException {
    	  
    	 
    	     System.out.println("VERIFY ACCOUNT NO:");
             Properties prop=new Properties();
    	     InputStream input = new FileInputStream("./DataFiles/DLCredit_Autopost.properties");
    	     prop.load(input);
    	     WebElement table = driver.findElement(By.id("tblCustList"));
             List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
    	     NoOfRows=listOfRows.size()-1;
    	     System.out.println("Rows: "+NoOfRows);

    	                for(int i=1,j=0; i<=NoOfRows && j < NoOfRows;i++,j++) {
    	   
    	                    System.out.println("FDAc_AccountNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl"+j+"_tdAcNo']")).getText());
    	    
    	                           if(prop.getProperty("FDAc_AccountNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl"+j+"_tdAcNo']")).getText())){
    	    
    	                               System.out.println("Equal");
    	                               Driver.tcFlag = "PASS";
    	                               Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAc_AccountNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstSummary_ctrl"+j+"_tdAcNo']")).getText(); 
    	                               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
    	    
    	                           }
    	                }
    	   
  }  
    
    public static void VerifyDisplayName(WebDriver driver) throws IOException {
  	  
   	 
   	       System.out.println("VERIFY DISPLAY NAME:");
           Properties prop=new Properties();
   	       InputStream input = new FileInputStream("./DataFiles/DLCredit_Autopost.properties");
   	       prop.load(input);
   	       WebElement table = driver.findElement(By.id("tblCustList"));
           List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
   	       NoOfRows=listOfRows.size()-1;
   	       System.out.println("Rows: "+NoOfRows);

   	              for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
   	   
   	                  System.out.println("FDAc_DisplayName"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[4]")).getText());
   	    
   	                         if(prop.getProperty("FDAc_DisplayName"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[4]")).getText())){
   	    
   	                             System.out.println("Equal");
   	                             Driver.tcFlag = "PASS";
   	                             Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAc_DisplayName"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[4]")).getText(); 
   	                             Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
   	    
   	                         }
   	             }
   	   
   }  
    
 
       public static void VerifyVoucherNo(WebDriver driver) throws IOException {
  
 
               System.out.println("VERIFY VOUCHER NO:");
               Properties prop=new Properties();
               InputStream input = new FileInputStream("./DataFiles/DLCredit_Autopost.properties");
               prop.load(input);
               WebElement table = driver.findElement(By.id("tblCustList"));
               List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
               NoOfRows=listOfRows.size()-1;
               System.out.println("Rows: "+NoOfRows);

                      for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
   
                         System.out.println("FDAc_VoucherNumber"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText());
    
                                  if(prop.getProperty("FDAc_VoucherNumber"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText())){
    
                                    System.out.println("Equal");
                                    Driver.tcFlag = "PASS";
                                    Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAc_VoucherNumber"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[7]")).getText(); 
                                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
    
                                 }
                    }
   
        }  
       
        public static void VerifyTranscationType(WebDriver driver) throws IOException {
   
               System.out.println("VERIFY TRANSACTION TYPE:");
               Properties prop=new Properties();
               InputStream input = new FileInputStream("./DataFiles/DLCredit_Autopost.properties");
               prop.load(input);
               WebElement table = driver.findElement(By.id("tblCustList"));
               List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
               NoOfRows=listOfRows.size()-1;
               System.out.println("Rows: "+NoOfRows);
 
   
                      for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
	   
	                      System.out.println("FDAc_TranType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText());

                                 if(prop.getProperty("FDAc_TranType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText())){
     
                                    System.out.println("Equal");
                                    Driver.tcFlag = "PASS";
                                    Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDAc_TranType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[8]")).getText(); 
                                    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
                                 }
                       }
         }
    
  
 
     public static void VerifyAmountType(WebDriver driver) throws IOException {
	  
	 
	        System.out.println("VERIFY AMOUNT TYPE");
            Properties prop=new Properties();
	        InputStream input = new FileInputStream("./DataFiles/DLCredit_Autopost.properties");
	        prop.load(input);
	        WebElement table = driver.findElement(By.id("tblCustList"));
	        List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	        NoOfRows=listOfRows.size()-1;
	        System.out.println("Rows: "+NoOfRows);

	               for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	   
	                   System.out.println("FDAc_AmountType"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText());

	                          if(prop.getProperty("FDAc_AmountType"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText())){
	    
	                             System.out.println("Equal");
	                             Driver.tcFlag = "PASS";
	                             Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAc_AmountType"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[10]")).getText(); 
	                             Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                          }
	                }
	   
	   }  
     
     public static void VerifyGLCode(WebDriver driver) throws IOException {
   	  
    	 
	        System.out.println("VERIFY GLCODE");
         Properties prop=new Properties();
	        InputStream input = new FileInputStream("./DataFiles/DLCredit_Autopost.properties");
	        prop.load(input);
	        WebElement table = driver.findElement(By.id("tblCustList"));
	        List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
	        NoOfRows=listOfRows.size()-1;
	        System.out.println("Rows: "+NoOfRows);

	               for(int i=1,j=2; i<=NoOfRows && j < NoOfRows+2;i++,j++) {
	   
	   
	                   System.out.println("FDAc_GlAcCode"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText());

	                          if(prop.getProperty("FDAc_GlAcCode"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText())){
	    
	                             System.out.println("Equal");
	                             Driver.tcFlag = "PASS";
	                             Driver.comment = "Pass" + " # " + "Value From Database: " + prop.getProperty("FDAc_GlAcCode"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[11]")).getText(); 
	                             Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
	    
	                          }
	                }
	   
	   }  
  public static void VerifyBranchCode(WebDriver driver) throws IOException {
  	   
  	   System.out.println("VERIFY BRANCHCODES");
  	   WebElement table = driver.findElement(By.id("tblCustList"));
       List<WebElement> listOfRows = table.findElements(By.tagName("tr"));
  	   NoOfRows=listOfRows.size()-1;
  	   System.out.println("Rows: "+NoOfRows);
  	   Properties prop=new Properties();
  	   InputStream input = new FileInputStream("./DataFiles/DLCredit_Autopost.properties");
  	   prop.load(input);
  	   
  for( int i=1,j=2;j<=NoOfRows+1 && i<=NoOfRows+1 ;j++,i++) {
  	     
  	   	  System.out.println("FDAc_OrgId"+i+"="+driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText());

  	           if(prop.getProperty("FDAc_OrgId"+i).equals(driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText())){
  	      
  	               System.out.println("Equal");
  	               Driver.tcFlag = "PASS";
  	               Driver.comment = "Pass" + " # " + "Value From Database: " +prop.getProperty("FDAc_OrgId"+i) + "<br>" + "Actual Value: " + driver.findElement(By.xpath(".//*[@id='tblCustList']/tbody/tr["+j+"]/td[13]")).getText(); 
  	               Driver.individualTestCaseStepCollector.put(Driver.testStepDescription+i,  Driver.comment);
  	      
  	     
  	            }
  	  }
  	    
  }
      

  public static WebDriver VerifyDLCredit_Autopost(WebDriver driver, String locatorType, String propertyValue, String testData) {
	 
	        WebElement element=null;
	        String Actual_Value=null;
	 
	 switch(locatorType.toLowerCase()){
	 
	 case "id":
	  
	 break;
	  
	  
	 case "xpath":
	  
	  System.out.println("Inside verify summary method");
	  try{
	   element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
	   
	       if (element.isDisplayed() == true) {
	     
	           if(element.isEnabled()==true) { 
	      
	              Actual_Value = driver.findElement(By.xpath(propertyValue)).getText();
	     
	     }else {
	      
	      
	            Actual_Value = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
	      
	     }
	     
	     System.out.println("Actual value is "+Actual_Value);

	     
	     Properties prop=new Properties();
	     
	     InputStream input = new FileInputStream("./DataFiles/DLCredit_Autopost.properties");
	     prop.load(input);
	     
	     String TransDateFromFile=prop.getProperty("Share_TransactionDate");
	     SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
	     Date newTransdate=sdfrmt.parse(TransDateFromFile);
	     sdfrmt=new SimpleDateFormat("dd/MM/yyyy");
	     String TRANSDATE=sdfrmt.format(newTransdate);
	     
	     
	     String ValueDateFromFile=prop.getProperty("Share_ValueDate");
	     SimpleDateFormat sdfrmt1 = new SimpleDateFormat("yyyy-MM-dd");
	     Date newValdate=sdfrmt1.parse(ValueDateFromFile);
	     sdfrmt1=new SimpleDateFormat("dd/MM/yyyy");
	     String VALUEDATE=sdfrmt1.format(newValdate);
	     
	                       
	      
	      if(Actual_Value.equals(prop.getProperty("FDAc_BatchId"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_BatchId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_TransId"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_TransId"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_TransAmount"))) {
		      
		   print(Actual_Value,prop.getProperty("FDAc_TransAmount"));
	      
	     }else if(Actual_Value.equals(prop.getProperty("FDAc_TransferMode"))) {
	      
	      print(Actual_Value,prop.getProperty("FDAc_TransferMode"));
	      
	     }else if(Actual_Value.substring(0, 9).equals(TRANSDATE)){
	      
	      print(Actual_Value.substring(0, 9),TRANSDATE); 
	     
	     }else if(Actual_Value.substring(0, 9).equals(VALUEDATE)) {
	      
	      print(Actual_Value.substring(0, 9),VALUEDATE); 
	      
	       
	     }else {
	      Driver.tcFlag = "FAIL";
	      //e.printStackTrace(new PrintWriter(Driver.errors));
	      //Driver.comment = Driver.errors.toString();
	      Driver.comment = Driver.objectName + " and its Database value are (test)  not matching";
	      Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	     }
	    
	    }
	    
	   }catch(Exception e){
	    Driver.tcFlag = "FAIL";
	    Driver.comment = Driver.objectName + " (test2)is not displayed or not identified";
	    Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	    e.printStackTrace();
	   }
	   
	 

	 break;

	 
	  
	 case "name":
	  
	  break;
	  
	 case "css":
	  
	  break;
	 }
	 
	 
	 
	 
	 return driver;
	 
	}
public static void print(String ActualValue, String DbValue) {
	
	System.out.println("Actual value and DB value is "+ ActualValue +"  "+ DbValue);
	
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass" + " # " + "Value From Database: " + DbValue + "<br>" + "Actual Value: " + ActualValue; 
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}

 

}
