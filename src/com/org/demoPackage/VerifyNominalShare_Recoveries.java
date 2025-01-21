package com.org.demoPackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyNominalShare_Recoveries {
	
public static String calculatedrecoveryTotal=null;
	
	public static String ActualRecoverytotal =null;
	
	public static void verifyRecoveryTotal(WebDriver driver, String propertyValue) throws IOException {
		
		ActualRecoverytotal=driver.findElement(By.xpath(propertyValue)).getAttribute("value");
		
		System.out.println("actual value recovery total "+ActualRecoverytotal);
		
		String AdmissionFee=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TBShare_tpAccInfo_lstShareInfo_ctrl0_ucProductAccountShareInfo_ucRecoveries_txt15']")).getAttribute("value");
		String serviceTax= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TBShare_tpAccInfo_lstShareInfo_ctrl0_ucProductAccountShareInfo_ucRecoveries_txt17']")).getAttribute("value");
		String processingFee=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TBShare_tpAccInfo_lstShareInfo_ctrl0_ucProductAccountShareInfo_ucRecoveries_txt16']")).getAttribute("value");
		//String cGST= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TBShare_tpAccInfo_lstShareInfo_ctrl0_ucProductAccountShareInfo_ucRecoveries_txt1544']")).getAttribute("value");
		
		float Adm_fee_converted= Float.parseFloat(AdmissionFee); 
		float service_tax_converted= Float.parseFloat(serviceTax); 
		float processing_fee_converted= Float.parseFloat(processingFee); 
		//float cgst_converted= Float.parseFloat(cGST); 
		
		float	recoveryTotal= (Adm_fee_converted+service_tax_converted+processing_fee_converted);
		
		//calculatedrecoveryTotal=String.valueOf(recoveryTotal);
		calculatedrecoveryTotal=String.format("%.2f",recoveryTotal);
		
		System.out.println("calculated recovery total "+ calculatedrecoveryTotal);
		
		
		//if(calculatedrecoveryTotal.equals(ActualRecoverytotal.substring(0, 5))) {
		if(calculatedrecoveryTotal.equals(String.format("%.2f",Float.parseFloat(ActualRecoverytotal)))) {
			Driver.comment = "Pass" + " # " + "Value From UI: " + ActualRecoverytotal + "<br>" + "Total value after calculation " + calculatedrecoveryTotal; 
		 	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		 	System.out.println("equal");
		}else{
			Driver.tcFlag = "FAIL";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		

}
}
