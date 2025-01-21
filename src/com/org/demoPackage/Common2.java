package com.org.demoPackage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import jxl.read.biff.BiffException;

public class Common2 

{
	public static void SwitchTabs (WebDriver driver,String locatorType, String propertyValue)
	{
//		String oldTab = driver.getWindowHandle();
//		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
//		newTab.remove(oldTab);
//		    // change focus to new tab
//		driver.switchTo().window(newTab.get(0));
		 // Do what you want here, you are in the new tab

		//driver.close();
		    // change focus back to old tab
		//driver.switchTo().window(oldTab);
		 // Do what you want here, you are in the old tab
		new Actions(driver).sendKeys(driver.findElement(By.tagName("html")), Keys.CONTROL).sendKeys(driver.findElement(By.tagName("html")),Keys.NUMPAD2).build().perform();
	}
	
	public static void CTRLTab (WebDriver driver, String locatorType,String propertyValue, String testData) throws ClassNotFoundException, BiffException, SQLException, IOException
	{
		int data = Integer.parseInt(testData);
		WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, data);
		System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
		System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
		//String RentFromInterface=driver.findElement(By.id(WriteIntoDataFiles.Property_Value)).getAttribute("value");
		//System.out.println("RentFromInterface="+ RentFromInterface + "\n");
		
		//actions = Action(driver);
		//WebElement find = driver.findElement(By.xpath(WriteIntoDataFiles.Property_Value));
		//new Actions(driver).keyDown(Keys.CONTROL).click(find).keyUp(Keys.CONTROL).perform();
		 String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL+"t"); 
		 driver.findElement(By.xpath(WriteIntoDataFiles.Property_Value)).sendKeys(selectLinkOpeninNewTab);
	}
	
	public static void IfElseCheckInterestTransfer (WebDriver driver,String locatorType, String propertyValue) throws Exception 
	{
		switch(locatorType.toLowerCase())
		{
		case "id":
			System.out.println("Started IfElseCheckInterestTransfer");
			int size1 = driver.findElements(By.id(propertyValue)).size();
		if(size1>0)
		//if(driver.findElement(By.id(propertyValue)).isDisplayed()) 
		{
			//System.out.println("1");
			DifferentTypesOfWaits.FluentWait(driver, locatorType, propertyValue);
			System.out.println("Submit standing instruction pop up appeared");
			driver.findElement(By.id(propertyValue)).click();
			//System.out.println("2");
			WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 1332);
			System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
			//System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
			
			String InterestTransferBtn=WriteIntoDataFiles.Property_Value;
			DifferentTypesOfWaits.FluentWait(driver, locatorType, InterestTransferBtn);
			driver.findElement(By.id(InterestTransferBtn)).click();
			
			WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 1333);
			System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
			String SubmitBtnInStandingPopup=WriteIntoDataFiles.Property_Value;
			
			SwitchToChildWindow.SwitchToChild(driver, SubmitBtnInStandingPopup);
			DifferentTypesOfWaits.FluentWait(driver, locatorType, SubmitBtnInStandingPopup);
			driver.findElement(By.id(SubmitBtnInStandingPopup)).click();
			SwitchToParentWindow.SwitchToParent(driver,InterestTransferBtn);
			
			DifferentTypesOfWaits.FluentWait(driver, locatorType, InterestTransferBtn);
			
			WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 90);
			System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
			String FDRenewalSubmitBtn=WriteIntoDataFiles.Property_Value;
			
			DifferentTypesOfWaits.FluentWait(driver, locatorType, FDRenewalSubmitBtn);
			
			driver.findElement(By.xpath(FDRenewalSubmitBtn)).click();
			
			Driver.tcFlag = "PASS";
			Driver.comment = "Submit standing instruction pop up appeared";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Pass" + " # " + Driver.comment);
		}
		else
		{
			System.out.println("Submit standing instruction pop up not appeared");
			
			Driver.tcFlag = "PASS";
			Driver.comment = "Submit standing instruction pop up not appeared";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Pass" + " # " + Driver.comment);
		}
		break;
	 }
	}
	
	public static void CTRLPlusDownArrow (WebDriver driver,String locatorType, String propertyValue) throws ClassNotFoundException, BiffException, SQLException, IOException
	{
		//Actions actionObject = new Actions(driver);
		///actionObject.sendKeys(Keys.CONTROL,Keys.ARROW_DOWN);
		//actionObject.perform();
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		
		Driver.tcFlag = "PASS";
		Driver.comment = "Key press Control + down arrow";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Pass" + " # " + Driver.comment);
	}
}
