package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ReadAccountNumber {
	
	public static String accountNumber = null;
	
	public static void getAccountNumber(String propertyValue)throws IOException  {
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/InvestmentOpeningTransferModeDetails.properties");
		prop.load(input);
		accountNumber = prop.getProperty("InvestmentAccountNumber");
		String Acno= accountNumber.substring(9, 15);
	
		
		Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(Acno);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}

}
