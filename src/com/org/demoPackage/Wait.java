package com.org.demoPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Wait {

	public static void Wait(String testData) {

		try {
			//System.out.println("======== " + System.currentTimeMillis());
			Thread.sleep(Long.parseLong(testData));
			//System.out.println("======== " + System.currentTimeMillis());
			Driver.tcFlag = "PASS";
		} catch (InterruptedException e) {
			
			Driver.tcFlag = "FAIL";
			System.out.println("Something went wrong while executing wait statement");
		}

	}
	
	public static void WaitSync(WebDriver driver) throws InterruptedException
	{
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String flag1 = "FALSE";
			String flag2 = "FALSE";
			String s;
			
			for (int i=0; i<Driver.sinkWait; i++)
			{
				try{
					if (js.executeScript("return document.readyState").toString().equals("complete")){
						flag1 = "TRUE";
						break;
					}
				}catch(Exception e){
					Thread.sleep(500);
				}
			}
			
			for (int j=0; j<Driver.sinkWait; j++)
			{
				 s = js.executeScript("return jQuery.active")+ "TRUE";
				 System.out.println("Jquery: " + s);
				try{
					if (s.equals("0TRUE")){
						flag2 = "TRUE";
						break;
					}
					
				}catch(Exception e){
					Thread.sleep(500);
				}
			}
			
			if  ((flag1.equals("TRUE")) && (flag2.equals("TRUE")))
			{
				Driver.tcFlag = "PASS";
			}else{
				Driver.tcFlag = "FAIL";
				System.out.println("Method Name: WaitSync.  Synchronization did not happen in the given time.");
			}
			
			
			
		
	}

}
