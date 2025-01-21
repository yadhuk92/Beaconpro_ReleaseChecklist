package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ReadCA_TRA_Transid {
public static void getCATransid(String propertyValue) throws IOException {
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/CAOpeningDetails_TRANSFER.properties");
		prop.load(input);
		String transId = prop.getProperty("CA_TransId");
		Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(transId);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
	}

}
