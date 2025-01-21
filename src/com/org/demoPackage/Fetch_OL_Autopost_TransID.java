package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Fetch_OL_Autopost_TransID {

public static void getTransid(WebDriver driver, String trim) throws IOException {
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/OtherLoanOpenings_Autopost.properties");
		prop.load(input);
		String transId = prop.getProperty("FDAc_TransId");
		Driver.driver.findElement(By.xpath(trim)).sendKeys(transId);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
		
	}
}
