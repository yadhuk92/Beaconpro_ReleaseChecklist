package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ReadMDSNumber {
	public static String mdsNumber = null;
	public static void getMDSNumber(String propertyValue) throws IOException {
		
		Properties prop = new Properties();
		System.out.println("inside read mds method");
		InputStream input = new FileInputStream("./DataFiles/MDS_Number.properties");
		prop.load(input);
		mdsNumber = prop.getProperty("MDS Number");
		Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(mdsNumber);
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}

}
