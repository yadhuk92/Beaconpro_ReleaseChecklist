package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class Fetch_DL_CASH_Transid {
 
public static void getTransid(String propertyValue) throws IOException {
  
  Properties prop = new Properties();
  InputStream input = new FileInputStream("./DataFiles/DepositLoanOpening_CashMode.properties");
  prop.load(input);
  String transId = prop.getProperty("FDAc_TransId");
  Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId); 
  Driver.tcFlag = "PASS";
  Driver.comment = "Pass";
  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);  
 }

}