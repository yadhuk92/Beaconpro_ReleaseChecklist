package com.org.demoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Verification {
	
public static void verify(WebDriver driver,String propertyValue) throws InterruptedException {
	System.out.println("Verification");
		
		for(int i=0; i< Driver.sinkWait / 2; i++)
		{
			try {
				
				String element1 = driver.findElement(By.xpath(propertyValue)).getAttribute("value");

				try {
					if (element1 == "") {
						
					}else {
						break;
					}
				}catch(Exception e) {

					Thread.sleep(500);
				}
				
			}catch(Exception e) {
				Thread.sleep(500);
			}
		}
		
		
		
	}

}
