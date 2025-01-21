package com.org.demoPackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchToParentWindow {
	
public static WebDriver SwitchToParent(WebDriver driver,  String propertyValue) throws Exception {
		
		Set<String> s2 = driver.getWindowHandles();

		String window1 = (String) s2.toArray()[0];

		//String window2 = (String) s2.toArray()[1];

		//String window3 = (String) s2.toArray()[2];
		//System.out.println(s2.size());
		
		driver.switchTo().window(window1);
		//System.out.println("Anushka");
		
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	return driver;
}

}
