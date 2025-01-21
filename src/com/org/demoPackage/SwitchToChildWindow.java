package com.org.demoPackage;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwitchToChildWindow {


	
public static WebDriver SwitchToChild(WebDriver driver,  String propertyValue) throws Exception {
		
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
	    String subWindowHandler = null;

	    Set<String> handles = driver.getWindowHandles(); // get all window handles
	    Iterator<String> iterator = handles.iterator();
	    while (iterator.hasNext()){
	        subWindowHandler = iterator.next();
	    }
	    driver.switchTo().window(subWindowHandler);// switch to child window
	    
	    //String SBAcNOPartOne=driver.findElement(By.xpath(".//*[@id='txtChildBGPAcNo_txt']")).getText();
	   // String SBAcNOPartTwo=driver.findElement(By.xpath(".//*[@id='txtChildAcNo_txt']")).getText();
	    
	  //  System.out.println("AcNo  "+SBAcNOPartOne+SBAcNOPartTwo);
	    
	  //  Properties p=new Properties();
		//File file = new File("./DataFiles/InvestmentOpeningTransferModeDetails.properties");
		//FileOutputStream fos = new FileOutputStream(file);
		//p.setProperty("SBAccountNumber",SBAcNOPartOne.concat(SBAcNOPartTwo));
		//System.out.println("Written in to InvestmentOpeningTransferModeDetails ");
	   
		
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	    return driver;
}

}
