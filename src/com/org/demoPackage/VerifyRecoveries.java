package com.org.demoPackage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyRecoveries {
	
	public static String calculatedrecoveryTotal=null;
	
	public static String ActualRecoverytotal =null;
	
	public static void verifyRecoveryTotal(WebDriver driver, String propertyValue) throws IOException {
		
		System.out.println("Share Recovery Total:");
try {		
		ActualRecoverytotal=driver.findElement(By.xpath(propertyValue)).getAttribute("value");
		
		System.out.println("actual value recovery total "+ActualRecoverytotal);
		
		String AdmissionFee=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TBShare_tpAccInfo_lstShareInfo_ctrl0_ucProductAccountShareInfo_ucRecoveries_txt2']")).getAttribute("value");
		String serviceTax= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TBShare_tpAccInfo_lstShareInfo_ctrl0_ucProductAccountShareInfo_ucRecoveries_txt4']")).getAttribute("value");
		String processingFee=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TBShare_tpAccInfo_lstShareInfo_ctrl0_ucProductAccountShareInfo_ucRecoveries_txt3']")).getAttribute("value");
		String cGST= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TBShare_tpAccInfo_lstShareInfo_ctrl0_ucProductAccountShareInfo_ucRecoveries_txt1544']")).getAttribute("value");
		
		float Adm_fee_converted= Float.parseFloat(AdmissionFee); 
		float service_tax_converted= Float.parseFloat(serviceTax); 
		float processing_fee_converted= Float.parseFloat(processingFee); 
		float cgst_converted= Float.parseFloat(cGST); 
		
		float	recoveryTotal= (Adm_fee_converted+service_tax_converted+cgst_converted+processing_fee_converted);
		
		calculatedrecoveryTotal=String.valueOf(recoveryTotal);
		
		System.out.println("calculated recovery total "+ calculatedrecoveryTotal);
		
		Properties prop1=new Properties();
		FileOutputStream fos = new FileOutputStream("./DataFiles/Aclass_Share_Totals.properties");
		prop1.setProperty("Recovery_Total",calculatedrecoveryTotal);
		prop1.store(fos, "Done");
		fos.close();
		
		
		System.out.println("Written recovery totals");

		if(calculatedrecoveryTotal.equals(ActualRecoverytotal.substring(0, 4))) {
			Driver.comment = "Pass" + " # " + "Value From UI: " + ActualRecoverytotal + "<br>" + "Total value after calculation " + calculatedrecoveryTotal; 
		 	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		 	System.out.println("equal");
		}else{
			Driver.tcFlag = "FAIL";
			Driver.comment ="Actual value and database value are different";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = Driver.objectName + " is not displayed or not identified";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
		
	}

}
