package com.org.demoPackage;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyNomialShare_ProcessingFee {

	
	public static float  Process_fee = 0; 
	public static float ServiceTax=0;
	private static Object CalculatedServiceTax;
	
public static void Verify_NominalShare_ProcessFee(WebDriver driver, String propertyValue )	{
	
	System.out.println("Inside verify CGST method");
	
	new WebDriverWait(driver,40).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(By.id(propertyValue)))));
	String actualvalue_processingFee = driver.findElement(By.id(propertyValue)).getAttribute("value");
	//Added below code on January 2020 by Ravikiran
	if (actualvalue_processingFee.length() >= 5 ){
		String actualvalue_processingFee_Str = actualvalue_processingFee.substring(0, 5);
		System.out.println("Actual processing fee value= " + actualvalue_processingFee_Str);
	}else
	{
		
	}
	//String actualvalue_processingFee_Str = actualvalue_processingFee.substring(0, 5); //commented on January 14th, 2020 by Ravikiran
	//System.out.println("Actual processing fee value= " + actualvalue_processingFee_Str); //commented on January 14th, 2020 by Ravikiran
	
	String serviceTax= driver.findElement(By.id("ctl00_ctl00_CPH1_PRDCNT_TBShare_tpAccInfo_lstShareInfo_ctrl0_ucProductAccountShareInfo_ucRecoveries_txt17" + 
			"")).getAttribute("value");
	//String serviceTax_Str = serviceTax.substring(0, 4);
	String serviceTax_Str = String.format("%.2f", Float.parseFloat(serviceTax));
	System.out.println("Actual serviceTax= "+ serviceTax_Str);
	
	
	//Process_fee = Float.parseFloat(serviceTax);
	Process_fee = (Float.valueOf(actualvalue_processingFee)).floatValue();
	System.out.println("Processing fee after conversion to int= "+Process_fee);
	//Process_fee = Float.parseFloat(driver.findElement(By.id(propertyValue)).getAttribute("value"));

	
	ServiceTax=((Process_fee*10)/100);
	System.out.println("Service tax value after calculation= "+ServiceTax);
	
	//CalculatedServiceTax = String.valueOf(ServiceTax);
	CalculatedServiceTax = String.format("%.2f", ServiceTax);
	
	if(String.format("%.2f",Float.parseFloat(serviceTax_Str)).equals(CalculatedServiceTax)) {
		
		System.out.println("equal");
		
		//Driver.comment = "Pass" + " # " + "Value From UI: " + actualvalue_processingFee + "<br>" + "Total value after calculation " + CalculatedServiceTax;
		Driver.comment = "Pass" + " # " + "Value From UI: " + serviceTax_Str + "<br>" + "Total value after calculation " + CalculatedServiceTax;
	 	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	 	System.out.println("equal");
	}
	else {
		System.out.println("Service tax cannot be calculated with processing fee");
		Driver.tcFlag = "FAIL";
		Driver.comment = Driver.objectName + " is not displayed or not identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	}
	
	
	
}
	
}
