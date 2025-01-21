package com.org.demoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyCGST {

	
	public static float  Process_fee = 0; 
	public static String CalculatedCGST=null;
	
	public static void VerifyCGSTvalue(WebDriver driver, String propertyValue) {
		
		
		
		System.out.println("Inside verify CGST method");
		
	String actualvalue_CGST = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
	
	System.out.println("Actual CGST value"+ actualvalue_CGST);
	

	
	String ProcessingFee= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TBShare_tpAccInfo_lstShareInfo_ctrl0_ucProductAccountShareInfo_ucRecoveries_txt3']" + 
			"")).getAttribute("value");
	
	System.out.println("Processing fee "+ ProcessingFee);
	
	Process_fee= Float.parseFloat(ProcessingFee);
	
	System.out.println("Processing fee after conversion to int "+Process_fee);
	
	float cgst_value= (Process_fee*10)/100;
	
	System.out.println("CGST value after calculation "+cgst_value);
	
	CalculatedCGST = String.valueOf(cgst_value);
	
	System.out.println("CGST value after string conversion "+CalculatedCGST);
	
	if(actualvalue_CGST.substring(0, 3).equals(CalculatedCGST)) {
		
		System.out.println("equal");
		
		Driver.comment = "Pass" + " # " + "Value From UI: " + actualvalue_CGST + "<br>" + "Total value after calculation " + CalculatedCGST; 
	 	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	 	System.out.println("equal");
	}
	else {
		
		Driver.tcFlag = "FAIL";
		Driver.comment = Driver.objectName + " is not displayed or not identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	}
	
	
	
	}

	public static void VerifyCGSTvalueShare(WebDriver driver, String propertyValue) {
		
		System.out.println("VERIFY CGST:");
try {		
		new WebDriverWait(driver,40).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(propertyValue)))));
		
		String actualvalue_CGST = driver.findElement(By.xpath(propertyValue)).getAttribute("value");
		
		System.out.println("Actual CGST value"+ actualvalue_CGST);
		

		
		String ProcessingFee= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TBShare_tpAccInfo_lstShareInfo_ctrl0_ucProductAccountShareInfo_ucRecoveries_txt3']")).getAttribute("value");
		
		System.out.println("Processing fee "+ ProcessingFee);
		
		Process_fee= Float.parseFloat(ProcessingFee);
		
		System.out.println("Processing fee after conversion to int "+Process_fee);
		
		float cgst_value= (Process_fee*10)/100;
		
		System.out.println("CGST value after calculation "+cgst_value);
		
		CalculatedCGST = String.valueOf(cgst_value);
		
		System.out.println("CGST value after string conversion "+CalculatedCGST);
		
		if(actualvalue_CGST.substring(0, 3).equals(CalculatedCGST)) {
			
			System.out.println("equal");
			 Driver.tcFlag = "PASS";
			Driver.comment = "Pass" + " # " + "Value From UI: " + actualvalue_CGST + "<br>" + "Total value after calculation " + CalculatedCGST; 
		 	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		 	
		}
		else {
			
			Driver.tcFlag = "FAIL";
			Driver.comment = "Fail" + " # " + "Value From UI: " + actualvalue_CGST + "<br>" + "Total value after calculation " + CalculatedCGST; 		//Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = Driver.objectName + " is not displayed or not identified";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
		
	}
	
}
