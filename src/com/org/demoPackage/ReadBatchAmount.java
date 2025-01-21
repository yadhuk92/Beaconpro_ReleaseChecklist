package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadBatchAmount {

		public static void getAmount(String propertyValue) throws IOException {
			
			Properties prop = new Properties();
			InputStream input = new FileInputStream("./DataFiles/NominalShareOpening_BatchMode_Details.properties");
			prop.load(input);
			String TotalAmount= prop.getProperty("TotalAmount");
			System.out.println("Total amount="+TotalAmount);
			(new WebDriverWait(Driver.driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(propertyValue)));
			Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(TotalAmount);	
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);		
		}
		
	}

