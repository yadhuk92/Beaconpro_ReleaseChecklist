package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerifyTotal {
	
	public static void VerifyTotalFigures(WebDriver driver, String propertyValue) throws IOException {
		
		
		System.out.println("Inside verify total");
try {		
		String	ActualValue=driver.findElement(By.xpath(propertyValue)).getAttribute("value");
		
		System.out.println("actual value "+ActualValue);
		
		String share_total= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TBShare_tpAccInfo_lstShareInfo_ctrl0_ucProductAccountShareInfo_txtTotalShareValue_txt']")).getAttribute("value");
		String Reco_total=  driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TBShare_tpAccInfo_lstShareInfo_ctrl0_ucProductAccountShareInfo_ucRecoveries_txtRecoveryTotal_txt']")).getAttribute("value");
		
        System.out.println("recovery total "+Reco_total );
		System.out.println("share total total  "+share_total );
		
		float R_tot= Float.parseFloat(Reco_total);
		float S_tot=Float.parseFloat(share_total);
		
		System.out.println("recovery total after float conversion"+R_tot );
		System.out.println("share total total after float conversion"+S_tot );
		
		float Total=(R_tot+S_tot);
		
		System.out.println(" total in float "+Total );
		
		
		String Total_org= String.valueOf(Total);
		System.out.println(" total after to string conversion "+Total_org );
		
		if(ActualValue.substring(0, 4).equals(Total_org)) {
			
			Driver.comment = "Pass" + " # " + "Value From UI: " + ActualValue + "<br>" + "Total value after calculation " + Total_org; 
		 	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		 	System.out.println("equal");
		}
		
		else {
			Driver.tcFlag = "FAIL";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		
}catch(Exception e) {
	
	Driver.tcFlag = "FAIL";
	Driver.comment = Driver.objectName + " is not displayed or not identified";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
	}

}
