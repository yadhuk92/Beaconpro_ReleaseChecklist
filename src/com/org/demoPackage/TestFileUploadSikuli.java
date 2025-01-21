package com.org.demoPackage;

import java.io.File;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class TestFileUploadSikuli {
	
	
	public static void PhotoUpload(WebDriver driver) throws Exception {
		
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();

		
		/*Pattern browse=new Pattern("C:\\Users\\jaicy.george\\Desktop\\Training\\img\\browse.png");
		Pattern name=new Pattern("C:\\Users\\jaicy.george\\Desktop\\Training\\img\\name.png");
		Pattern open=new Pattern("C:\\Users\\jaicy.george\\Desktop\\Training\\img\\open.png");
		
		System.out.print("Readed Images path");
	       Screen src=new Screen();
	       
	       System.out.println("1");
	       src.setAutoWaitTimeout(60);
	       
	       src.click(browse);
	       System.out.println("2");
	       Thread.sleep(5000);
	       src.type(name,"D:\\FDRenewal_Autopost.png");
	       System.out.println("3");
	       src.click(open);
	       System.out.println("4");*/
		//driver.findElement(By.xpath(".//*[@id='ctl00_CPHFrame_docUpload']")).sendKeys("C:\\Users\\jaicy.george\\Desktop\\Training\\img\\DLClosureBatch.png");
		Thread.sleep(2000);
		//driver.findElement(By.xpath(".//*[@id='ctl00_CPHFrame_docUpload']")).sendKeys("E:\\BeaconProWorkSpace\\BeaconPro-AccOpening-Loans\\Image\\DLClosureBatch.png");
		

		driver.findElement(By.xpath(".//*[@id='ctl00_CPHFrame_docUpload']")).sendKeys(new File("./Image/DLClosureBatch.png").getCanonicalPath());
		
		//driver.findElement(By.xpath(".//*[@id='ctl00_CPHFrame_docUpload']")).click(); //click on browse button
		//Thread.sleep(2000);
		
		
		System.out.println("UPLOADED PHOTO");  
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
		
		}
public static void SignUpload(WebDriver driver) throws Exception {
		
	Thread.sleep(2000);
	//Actions action = new Actions(driver);
	//action.sendKeys(Keys.ESCAPE).perform();
		
		
		//driver.findElement(By.xpath(".//*[@id='ctl00_CPHFrame_docUpload']")).sendKeys("C:\\Users\\jaicy.george\\Desktop\\Training\\img\\OLClosureBatch.png");
		driver.findElement(By.id("ctl00_CPHFrame_docUpload")).sendKeys(new File("./Image/DLClosureBatch.png").getCanonicalPath());	
		System.out.println("UPLOADED SIGN");
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);	
		
	}

 
 

}
