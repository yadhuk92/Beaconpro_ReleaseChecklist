package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Login {
	
public static void login(WebDriver driver,String locatorType, String propertyValue, String testData) throws Exception {
		
		System.out.println("TestData "+ testData);
		
		switch(testData) {
		
		
		case "By User":
		{
			
			System.out.println("in By User case");
			driver=EnterUserLoginData(driver, propertyValue);
			System.out.println("Returned from method");
			//Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			
			
			
			try {
				driver.findElement(By.xpath(".//*[@id='form1']/div[5]/div[3]/div/button[1]")).click();
				Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
				driver=OkButtonDisplayed(driver, propertyValue);
			}catch(Exception e) {
				System.out.println("Entered to else loop");
				Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
				driver=OkButtonNotDisplayed(driver, propertyValue);
			}
			
							
		}
		break;
		case "By Admin":
		{
			System.out.println("in By Admin case");
			driver=EnterAdminLoginData(driver, propertyValue);
			System.out.println("Returned from method");
			//Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);


			try {
				driver.findElement(By.xpath(".//*[@id='form1']/div[5]/div[3]/div/button[1]")).click();
				Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
				driver=AdminOkButtonDisplayed(driver, propertyValue);
			}catch(Exception e) {
				System.out.println("Entered to else loop");
				Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
				driver=OkButtonNotDisplayed(driver, propertyValue);
			}
			
			
		}
		break;
		case "By Manager":
		{
			System.out.println("in By Manager case");
			driver=EnterAuthorisationLoginData(driver, propertyValue);
			
			System.out.println("Returned from method");
			//Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

			try {
				driver.findElement(By.xpath(".//*[@id='form1']/div[5]/div[3]/div/button[1]")).click();
				Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
				driver=AuthorizeOkButtonDisplayed(driver, propertyValue);
			}catch(Exception e) {
				System.out.println("Entered to else loop");
				Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
				driver=OkButtonNotDisplayed(driver, propertyValue);
			}
			
			
		
			
		}	
		break;
		case "By Cashier":
		{
			System.out.println("in By Cashier case");
			driver=EnterAuthorisationLoginData(driver, propertyValue);
			
			System.out.println("Returned from method");
			//Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

			try {
				driver.findElement(By.xpath(".//*[@id='form1']/div[5]/div[3]/div/button[1]")).click();
				Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
				driver=AuthorizeOkButtonDisplayed(driver, propertyValue);
			}catch(Exception e) {
				System.out.println("Entered to else loop");
				Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
				driver=OkButtonNotDisplayed(driver, propertyValue);
			}
			
			}
		break;
		
		default:
		break;

	}
	
	}	
	
public static WebDriver EnterUserLoginData(WebDriver driver, String propertyValue) throws Exception {
		
		System.out.println("Method called");
try {		
		Properties p1=new Properties();
		InputStream inp=new FileInputStream("./DataFiles/login_credentials.properties");
		p1.load(inp);
		String userName=p1.getProperty("username");
		String passWord=p1.getProperty("password");
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='txtUserName_txt']")).sendKeys(""+userName);
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='txtPassword_txt']")).sendKeys(""+passWord);
		Thread.sleep(500);
		driver.findElement(By.xpath(propertyValue)).click();
		
}catch(Exception e) {
	
	  Driver.tcFlag = "FAIL";
	  Driver.comment = Driver.objectName + " is not displayed or not identified";
	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
       return (driver);
	}
	
public static WebDriver EnterAuthorisationLoginData(WebDriver driver, String propertyValue) throws Exception {
		
		System.out.println("Method called");
try {		
		Properties p1=new Properties();
		InputStream inp=new FileInputStream("./DataFiles/login_credentials.properties");
		p1.load(inp);
		String userName=p1.getProperty("Cashier_manager_username");
		String passWord=p1.getProperty("Cashier_manager_password");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='txtUserName_txt']")).sendKeys(""+userName);
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='txtPassword_txt']")).sendKeys(""+passWord);
		Thread.sleep(500);
		
		driver.findElement(By.xpath(propertyValue)).click();
}catch(Exception e) {
	
	  Driver.tcFlag = "FAIL";
	  Driver.comment = Driver.objectName + " is not displayed or not identified";
	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
		return (driver);
	}
public static WebDriver EnterAdminLoginData(WebDriver driver, String propertyValue) throws Exception {
	
	System.out.println("Method called");
try {	
	Properties p1=new Properties();
	InputStream inp=new FileInputStream("./DataFiles/login_credentials.properties");
	p1.load(inp);
	String userName=p1.getProperty("admin_username");
	String passWord=p1.getProperty("admin_password");
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@id='txtUserName_txt']")).sendKeys(""+userName);
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@id='txtPassword_txt']")).sendKeys(""+passWord);
	Thread.sleep(500);
	
	driver.findElement(By.xpath(propertyValue)).click();
}catch(Exception e) {
	
	  Driver.tcFlag = "FAIL";
	  Driver.comment = Driver.objectName + " is not displayed or not identified";
	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
	return (driver);
}

public static WebDriver OkButtonDisplayed(WebDriver driver,String propertyValue) throws Exception {
		
		System.out.println("Found Ok Button");
		//Thread.sleep(5000);
		//Thread.sleep(5000);
try {		
		driver=EnterUserLoginData(driver, propertyValue);
		SwitchToChildWindow.SwitchToChild(driver, propertyValue );
		driver.findElement(By.xpath("html/body/div[1]/div[3]/div/button")).click();
		SwitchToParentWindow.SwitchToParent(driver,  propertyValue);
}catch(Exception e) {
	
	  Driver.tcFlag = "FAIL";
	  Driver.comment = Driver.objectName + " is not displayed or not identified";
	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
	
}
		return (driver);
	}

public static WebDriver AuthorizeOkButtonDisplayed(WebDriver driver,String propertyValue) throws Exception {
	
	System.out.println("Found Ok Button");
	//Thread.sleep(5000);
	//Thread.sleep(5000);
try {	
	driver=EnterAuthorisationLoginData(driver, propertyValue);
	SwitchToChildWindow.SwitchToChild(driver, propertyValue );
	driver.findElement(By.xpath("html/body/div[1]/div[3]/div/button")).click();
	SwitchToParentWindow.SwitchToParent(driver,  propertyValue);
}catch(Exception e) {
	
	  Driver.tcFlag = "FAIL";
	  Driver.comment = Driver.objectName + " is not displayed or not identified";
	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
}
	return (driver);
}
public static WebDriver AdminOkButtonDisplayed(WebDriver driver,String propertyValue) throws Exception {
	
	System.out.println("Found Ok Button");
	//Thread.sleep(5000);
	//Thread.sleep(5000);
try {	
	driver=EnterAdminLoginData(driver, propertyValue);
	SwitchToChildWindow.SwitchToChild(driver, propertyValue );
	driver.findElement(By.xpath("html/body/div[1]/div[3]/div/button")).click();
	SwitchToParentWindow.SwitchToParent(driver,  propertyValue);
}catch(Exception e) {
	
	  Driver.tcFlag = "FAIL";
	  Driver.comment = Driver.objectName + " is not displayed or not identified";
	  Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
}
	return (driver);
}

public static WebDriver OkButtonNotDisplayed(WebDriver driver, String propertyValue) throws Exception {
	
	System.out.println("Did not Find Ok Button");
	SwitchToChildWindow.SwitchToChild(driver, propertyValue );
	try {
		for(int i=0;i<60;i++) {
		
			if(driver.findElement(By.xpath("html/body/div[1]/div[3]/div/button")).isDisplayed())
			{
				driver.findElement(By.xpath("html/body/div[1]/div[3]/div/button")).click();
				SwitchToParentWindow.SwitchToParent(driver,  propertyValue);
				break;
			}
		}
	
	
	}
	
	
	catch(Exception e) {
		e.printStackTrace();
	}
	return (driver);
}
}