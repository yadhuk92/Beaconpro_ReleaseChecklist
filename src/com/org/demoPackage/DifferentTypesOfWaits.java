package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.read.biff.BiffException;

public class DifferentTypesOfWaits 
	
{
	public static String LockerNumber = null;
	public static WebElement element;
	
	public static WebDriver FluentWait (WebDriver driver,String locatorType, String propertyValue)
	{
		switch(locatorType.toLowerCase()) 
		{
			case "id":
			try
			{
			System.out.println("Fluent wait started");
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
					.withTimeout(15, TimeUnit.MINUTES) 	
					 .ignoring(NullPointerException.class)
	                 .ignoring(StaleElementReferenceException.class)
	                 .ignoring(NoSuchElementException.class)
	                 .ignoring(ElementNotVisibleException.class)
	                 .ignoring(WebDriverException.class)
					.pollingEvery(5, TimeUnit.MILLISECONDS);			
			wait.until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
		
			Driver.tcFlag = "PASS";
			Driver.comment = "Pass";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			System.out.println("Fluent Wait Ended - Element found and to be in clickable state");
			}
			catch(Exception e)
			{
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			
			
			break;
			
			case "xpath":
			try
			{
				System.out.println("Fluent wait started");
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
						.withTimeout(15, TimeUnit.MINUTES) 	
						 .ignoring(NullPointerException.class)
		                 .ignoring(StaleElementReferenceException.class)
		                 .ignoring(NoSuchElementException.class)
		                 .ignoring(ElementNotVisibleException.class)
		                 .ignoring(WebDriverException.class)
						.pollingEvery(5, TimeUnit.MILLISECONDS);			
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue)));
				
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				System.out.println("Fluent Wait Ended - Element found and to be in clickable state");
			}
			catch(Exception e)
			{
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			
			break;
		}
		return driver;
	}
	
	public static void ForLoopWaitPlusSendKeysWithTestData (WebDriver driver, String locatorType,String propertyValue, String testData) throws InterruptedException
	{
		switch(locatorType.toLowerCase())
		{
		case "id":
		
		try
		{
			//System.out.println("Entered into for loop wait and send keys");
			for(int i=0; i<60; i++)
			{
				try
				{
					if (driver.findElement(By.id(propertyValue)).isEnabled())
					{
						//driver.findElement(By.id(propertyValue)).clear();
						driver.findElement(By.id(propertyValue)).sendKeys(testData);
						//System.out.println("For loop if = "+propertyValue);
						Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.comment = "Pass" + " # " + "Selected value= " + testData ; 		
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
						break;
					}
					else
					{
						System.out.println("For loop else");
					}
				}
				catch(Exception e1)
				{
					System.out.println("Catch exception");
				}
			}
		}
		catch(Exception e)
		{
			Driver.tcFlag = "FAIL";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		break;
		
		case "xpath":
			
			try
			{
				//System.out.println("Entered into for loop wait and send keys");
				for(int i=0; i<60; i++)
				{
					try
					{
						if (driver.findElement(By.xpath(propertyValue)).isEnabled())
						{
							//driver.findElement(By.id(propertyValue)).clear();
							driver.findElement(By.xpath(propertyValue)).sendKeys(testData);
							//System.out.println("For loop if = "+propertyValue);
							Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.comment = "Pass" + " # " + "Selected value= " + testData ; 		
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
							break;
						}
						else
						{
							System.out.println("For loop else");
						}
					}
					catch(Exception e1)
					{
						System.out.println("Catch exception");
					}
				}
			}
			catch(Exception e)
			{
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			break;
		}
		}
	
	public static void ForLoopWaitPlusSendKeysWithoutTestData (WebDriver driver,String propertyValue, String testData) throws InterruptedException, IOException
	{
			Properties prop = new Properties();
			InputStream input = new FileInputStream(testData);
			prop.load(input);
			LockerNumber = prop.getProperty("Locker_number");
			//Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(LockerNumber);
			System.out.println("Locker number = "+LockerNumber);
			
			driver.findElement(By.id(propertyValue)).sendKeys(LockerNumber);
			System.out.println("For loop if = "+propertyValue);
			
			Driver.tcFlag = "PASS";
			//Driver.comment = "Pass";
			Driver.comment = "Pass" + " # " + "Locker Number readed from file= " + LockerNumber; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);

	}
	
	public static void NewTabActions (WebDriver driver,String propertyValue, String testData) throws InterruptedException, IOException, ClassNotFoundException, BiffException, SQLException
	{
		// Store the current window handle
		String currentWindowHandle = driver.getWindowHandle();

		WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 1328);
		System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
		System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
		
		// Perform an action that opens a new tab
		element = driver.findElement(By.xpath(WriteIntoDataFiles.Property_Value));
		if (element.isDisplayed() == true)
		{
			//WriteIntoDataFiles.ReadPropertyValueFromObjectRepository(driver, 1328);
			//System.out.println("Object_Name from object repository file=" + WriteIntoDataFiles.Object_Name + "\t");
			//System.out.println("Property_Value from object repository file=" + WriteIntoDataFiles.Property_Value + "\t");
			//String UnAllotedOnly=driver.findElement(By.id(WriteIntoDataFiles.Property_Value)).getAttribute("value");
			driver.findElement(By.xpath(WriteIntoDataFiles.Property_Value)).click();
			//element.click();
			System.out.println("Report menu clicked");
			//System.out.println("For loop if = "+propertyValue);
			//Driver.tcFlag = "PASS";
			//Driver.comment = "Pass";
			//Driver.comment = "Pass" + " # " + "Element clicked"; 		
			//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		}
		else
		{
			System.out.println("Report menu button is not found");
		}

		// Wait for the new tab to load
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Get all the window handles
		Set<String> windowHandles = driver.getWindowHandles();

		// Switch to the new tab
		for (String windowHandle : windowHandles) {
		    if (!windowHandle.equals(currentWindowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}

		// Do some actions on the new tab
		element = driver.findElement(By.xpath(propertyValue));
		if (element.isDisplayed() == true)
		{
			element.click();
			//element.click();
			System.out.println("Clicked report");
			//System.out.println("For loop if = "+propertyValue);
			//Driver.tcFlag = "PASS";
			//Driver.comment = "Pass";
			//Driver.comment = "Pass" + " # " + "Element clicked"; 		
			//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			//break;
		}
		else
		{
			System.out.println("Report is not found");
		}

		// Switch back to the original tab
		//driver.switchTo().window(currentWindowHandle);

		// Do some actions on the original tab
		// ...
	}
	
	public static void ForLoopWaitPlusClick (WebDriver driver, String locatorType,String propertyValue) throws InterruptedException
	{
		switch(locatorType.toLowerCase())
		{
		case "id":
		
		try
		{
			//System.out.println("Entered into for loop wait and send keys");
			for(int i=0; i<60; i++)
			{
				try
				{
					element = driver.findElement(By.id(propertyValue));
					if (element.isDisplayed() == true)
					{
						element.click();
						element.click();
						System.out.println("ForLoopWaitPlusClick: Element clicked");
						//System.out.println("For loop if = "+propertyValue);
						Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.comment = "Pass" + " # " + "Element clicked"; 		
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
						break;
					}
					else
					{
						System.out.println("Element to be click is not found");
					}
				}
				catch(Exception e1)
				{
					System.out.println("Catch exception");
				}
			}
		}
		catch(Exception e)
		{
			Driver.tcFlag = "FAIL";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		break;
		
		case "xpath":
		try
			{
				//System.out.println("Entered into for loop wait and send keys");
				for(int i=0; i<60; i++)
				{
					try
					{
						element = driver.findElement(By.xpath(propertyValue));
						if (element.isDisplayed() == true)
						{
							element.click();
							System.out.println("ForLoopWaitPlusClick: Element clicked");
							//System.out.println("For loop if = "+propertyValue);
							Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.comment = "Pass" + " # " + "Element clicked"; 		
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
							break;
						}
						else
						{
							System.out.println("Element to be click is not found");
						}
					}
					catch(Exception e1)
					{
						System.out.println("Catch exception");
					}
				}
			}
			catch(Exception e)
			{
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
		break;

		}
		
		}

	public static void ForLoopWaitBasedOnGetText (WebDriver driver, String locatorType,String propertyValue) throws InterruptedException
	{
		switch(locatorType.toLowerCase())
		{
		case "id":
		
			try
			{
				for(int i=0; i<60; i++)
				{
					try
					{
						String element2 = driver.findElement(By.id(propertyValue)).getText();
						String ProgressValue="100";
						//System.out.print("Progress value = "+element2);
						if (element2.substring(0, 3).equals(ProgressValue))
						{
							System.out.println("Progress value equals " + element2 + " %");
							//System.out.println("For loop if = "+propertyValue);
							Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.comment = "Pass" + " # " + "Process completed"; 		
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
							break;
						}
						else
						{
							System.out.println("Progress value not equal to 100");
						}
					}
					catch(Exception e1)
					{
						System.out.println("Something is not right");
					}
				}
			}
			catch(Exception e)
			{
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			break;
		}	
	}
	
	public static void ForLoopWaitPlusSendKeysFor_TC_INTERESTPOST_OD (WebDriver driver,String propertyValue, String testData) throws InterruptedException, IOException
	{
			Properties prop = new Properties();
			InputStream input = new FileInputStream(testData);
			prop.load(input);
			System.out.println("ForLoopWaitPlusSendKeysFor_TC_INTERESTPOST_OD");
			LockerNumber = prop.getProperty("IntPostODTransID");
			//Driver.driver.findElement(By.xpath(propertyValue)).sendKeys(LockerNumber);
			System.out.println("Interest posting Transid = "+LockerNumber);
			
			driver.findElement(By.id(propertyValue)).sendKeys(LockerNumber);
			System.out.println("For loop if = "+propertyValue);
			
			Driver.tcFlag = "PASS";
			//Driver.comment = "Pass";
			Driver.comment = "Pass" + " # " + "Locker Number readed from file= " + LockerNumber; 
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);

	}
	
	public static WebDriver PressTabKeyWithoutWait(WebDriver driver, String locatorType, String propertyValue, String testData) throws InterruptedException 
	{
		switch(locatorType.toLowerCase())
		{
		case "id":
						
			try
			{
				driver.findElement(By.id(propertyValue)).sendKeys(Keys.TAB);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			}
			catch(Exception e)
			{
				Driver.tcFlag = "FAIL";
			}

			break;
						
		case "xpath":
			
			try
			{
				driver.findElement(By.xpath(propertyValue)).sendKeys(Keys.TAB);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			}
			catch(Exception e)
			{
				Driver.tcFlag = "FAIL";
			}

			break;
		}
		return driver;
	}
	
	public static void ForLoopWaitPlusSelectElementWithTestData (WebDriver driver, String locatorType,String propertyValue, String testData) throws InterruptedException
	{
		switch(locatorType.toLowerCase())
		{
		case "id":
		
		try
		{
			//System.out.println("Entered into for loop wait and send keys");
			for(int i=0; i<60; i++)
			{
				try
				{
					if (driver.findElement(By.id(propertyValue)).isEnabled())
					{
						//driver.findElement(By.id(propertyValue)).clear();
						//driver.findElement(By.id(propertyValue)).sendKeys(testData);
						//System.out.println("For loop if = "+propertyValue);
						Select dropdown = new Select(driver.findElement(By.id(propertyValue)));
						//dropdown.selectByVisibleText(testData);
						//driver.findElement(By.id(propertyValue)).click();
						//dropdown.selectByVisibleText(testData);
						dropdown.selectByVisibleText(testData);
						Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.comment = "Pass" + " # " + "Selected value= " + testData ; 		
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
						break;
					}
					else
					{
						System.out.println("For loop else");
					}
				}
				catch(Exception e1)
				{
					System.out.println("Catch exception");
				}
			}
		}
		catch(Exception e)
		{
			Driver.tcFlag = "FAIL";
			Driver.comment = Driver.objectName + " is not displayed or not identified";
			Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
		}
		break;
		
		case "xpath":
			
			try
			{
				//System.out.println("Entered into for loop wait and send keys");
				for(int i=0; i<60; i++)
				{
					try
					{
						if (driver.findElement(By.xpath(propertyValue)).isEnabled())
						{
							//driver.findElement(By.id(propertyValue)).clear();
							//driver.findElement(By.id(propertyValue)).sendKeys(testData);
							//System.out.println("For loop if = "+propertyValue);
							Select dropdown = new Select(driver.findElement(By.xpath(propertyValue)));
							//dropdown.selectByVisibleText(testData);
							//driver.findElement(By.id(propertyValue)).click();
							//dropdown.selectByVisibleText(testData);
							dropdown.selectByVisibleText(testData);
							Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.comment = "Pass" + " # " + "Selected value= " + testData ; 		
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
							break;
						}
						else
						{
							System.out.println("For loop else");
						}
					}
					catch(Exception e1)
					{
						System.out.println("Catch exception");
					}
				}
			}
			catch(Exception e)
			{
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			
		}
		}
	
}
						
	


