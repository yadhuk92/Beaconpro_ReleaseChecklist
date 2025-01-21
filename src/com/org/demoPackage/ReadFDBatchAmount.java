package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ReadFDBatchAmount {
 
public static void getAmount(String propertyValue) throws IOException {
  
  Properties prop = new Properties();
  System.out.println("Entered to read FD batch amount");
  InputStream input = new FileInputStream("./DataFiles/FixedDepositAccountOpening_BatchMode.properties");
  prop.load(input);
  String TotalAmount= prop.getProperty("Share_Total");
  Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount); 
  System.out.println("Passed the value");
  Driver.tcFlag = "PASS";
  Driver.comment = "Pass";
  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);  
 }

}