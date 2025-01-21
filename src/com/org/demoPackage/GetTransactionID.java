package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class GetTransactionID {
	
	public static void readTransactionID(String propertyValue) throws IOException {
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/InvestmentOpeningTransferModeDetails.properties");
		prop.load(input);
		String transId = prop.getProperty("InvestmentTransId");
		Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
	}
	
public static void getDLCreditTransid(String propertyValue) throws IOException {
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/DLCredit_Autopost.properties");
		prop.load(input);
		String transId = prop.getProperty("FDAc_TransId");
		Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
	}

}
