package com.org.demoPackage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyShareTotal {
	
	public static String CalculatedTotal=null;
	
	public static String  Actual_Total=null;
	
	public static void verifyShareTotal(WebDriver driver, String propertyValue) throws IOException, InterruptedException {
		
		System.out.println("VERIFY SHARE TOTAL:");
		//Thread.sleep(20000);
	try {	
		
		WebElement ShareTotal=driver.findElement(By.xpath(propertyValue));
		
		if(ShareTotal.isEnabled()==true) {
			
			Actual_Total=driver.findElement(By.xpath(propertyValue)).getText();
		
		
		}else {
			
			Actual_Total=driver.findElement(By.xpath(propertyValue)).getAttribute("value");
		}
		
		System.out.println("Actual total share value "+ Actual_Total);
		
		
		String perSharevalue= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TBShare_tpAccInfo_lstShareInfo_ctrl0_ucProductAccountShareInfo_txtPerShareValue_txt']")).getAttribute("value");
		
		System.out.println("perSharevalue "+perSharevalue);
		
		String noOfShares=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_TBShare_tpAccInfo_lstShareInfo_ctrl0_ucProductAccountShareInfo_txtNoOfShares_txt']")).getAttribute("value");
		
		System.out.println("noOfShares "+noOfShares);
		
		float pershare_value= Float.parseFloat(perSharevalue);
		
		int no_of_shares= Integer.parseInt(noOfShares);
		
		Float total= (pershare_value*no_of_shares);
		
		System.out.println("Total in integer "+ total);
		
		CalculatedTotal=String.valueOf(total);
		
		System.out.println("After converting to string, calculated share total is   "+ CalculatedTotal);
		
		
		Properties prop1=new Properties();
		FileOutputStream fos = new FileOutputStream("./DataFiles/Aclass_Share_Totals.properties");
		prop1.setProperty("Share_Total",CalculatedTotal);
		prop1.store(fos, "Done");
		fos.close();
		
		System.out.println("Written Share total");
		
		
		if(Actual_Total.substring(0, 4).equals(CalculatedTotal)) {
			Driver.comment = "Pass" + " # " + "Value From UI: " + Actual_Total + "<br>" + "Total value after calculation " + CalculatedTotal; 
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
