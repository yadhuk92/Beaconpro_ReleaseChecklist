package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Credential {
	
	
	public static String userName = null;
	public static String passWord = null;
	//public static String userName1 = null;
	
	public static WebDriver getCredential() throws InterruptedException, IOException {
		try{
			
	Properties prop = new Properties();
	InputStream input = new FileInputStream("./DataFiles/login_credentials.properties");
	prop.load(input);
	
	userName = prop.getProperty("username");
	passWord = prop.getProperty("password");
	
	
	//Pro_password=prop.getProperty("profile_password");
	//userName1 = prop.getProperty("admin_user_name1");
	//password2 = prop.getProperty("admin_user_password1");
	Driver.driver.findElement(By.xpath(".//*[@id='txtUserName_txt']")).sendKeys(userName);
	Driver.driver.findElement(By.xpath(".//*[@id='txtPassword_txt']")).sendKeys(passWord);
	

		}
	catch(Exception e){
		Driver.tcFlag = "FAIL";
		Driver.comment = Driver.objectName + " is not displayed or not identified";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}

	return Driver.driver;
	}
	}
	


