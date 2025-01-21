package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ReadOLBatchAmount {

	public static void getAmount(String propertyValue) throws IOException {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/OtherLoanOpenings_Batch.properties");
		prop.load(input);
		String TotalAmount= prop.getProperty("Share_Total");
		Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
		
		
	}
	
public static void getAmountOD(String propertyValue) throws IOException {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/OD_BATCH_Details.properties");
		prop.load(input);
		String TotalAmount= prop.getProperty("Share_Total");
		Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
		
		
	}

}
