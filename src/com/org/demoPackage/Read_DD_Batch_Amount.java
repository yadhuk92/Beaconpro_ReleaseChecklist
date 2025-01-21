package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class Read_DD_Batch_Amount {

	public static void getAmount(String trim) throws IOException {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./DataFiles/DD_BATCH_Details.properties");
		prop.load(input);
		String TotalAmount= prop.getProperty("DD_TransAmount");
		Driver.driver.findElement(By.xpath(trim)).sendKeys(TotalAmount);	
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
		
	}

}
