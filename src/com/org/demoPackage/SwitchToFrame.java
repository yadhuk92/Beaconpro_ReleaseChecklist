package com.org.demoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchToFrame {
	
	public static void Switchtoframe(WebDriver driver) {
		
		System.out.println("inside switch to frame");
		int Size=driver.findElements(By.tagName("iframe")).size();
		System.out.println("Size:"+Size);
		driver.switchTo().frame(0);
		
	}
	
public static void Switchfromframe(WebDriver driver) {
		
		System.out.println("inside switch from frame");
		//int Size=driver.findElements(By.tagName("iframe")).size();
		//System.out.println("Size:"+Size);
		//driver.switchTo().frame(0);
		//driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		
	}

}
