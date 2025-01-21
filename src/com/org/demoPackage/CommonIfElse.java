package com.org.demoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CommonIfElse 
{
	public static void PreviousOverdueIfElse (WebDriver driver,String locatorType, String propertyValue)
	{
		switch(locatorType.toLowerCase())
		{
		case "xpath":
		
		try
		{
			if(driver.findElement(By.xpath(propertyValue)).isEnabled())
			{
				driver.findElement(By.xpath(propertyValue)).click();
			}
			else
			{
				System.out.println("element not present -- so it entered the else loop");
			}
		}
		catch(Exception e1)
		{
			System.out.println("element not present -- so it entered the else loop");
		}
		break;
		
		case "id":
			try
			{
				if(driver.findElement(By.id(propertyValue)).isEnabled())
				{
					driver.findElement(By.id(propertyValue)).click();
				}
				else
				{
					System.out.println("element not present -- so it entered the else loop");
				}
			}
			catch(Exception e1)
			{
				System.out.println("element not present -- so it entered the else loop");
			}
		break;

		}
		
	}
	
	public static void IfElseSelect (WebDriver driver,String locatorType, String propertyValue, String testData)
	{
		switch(locatorType.toLowerCase())
		{
		case "xpath":
		//if(driver.findElement(By.xpath(propertyValue)).isEnabled())
		int size1 = driver.findElements(By.xpath(propertyValue)).size();
		if(size1>0)
			{
				Select dropdown = new Select(driver.findElement(By.xpath(propertyValue)));
				driver.findElement(By.xpath(propertyValue)).click();
				dropdown.selectByVisibleText(testData);
				
				Driver.tcFlag = "PASS";
				Driver.comment = "Element appeared and selected";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Pass" + " # " + Driver.comment);
			}
			else
			{
				System.out.println("element not present -- so it entered the else loop");
				Driver.tcFlag = "PASS";
				Driver.comment = "Element not appeared for selection";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Pass" + " # " + Driver.comment);
			}

		break;
		
		case "id":
		//if(driver.findElement(By.id(propertyValue)).isEnabled())
		int size2 = driver.findElements(By.id(propertyValue)).size();
		if(size2>0)
			{
				Select dropdown = new Select(driver.findElement(By.id(propertyValue)));
				driver.findElement(By.id(propertyValue)).click();
				dropdown.selectByVisibleText(testData);
				
				Driver.tcFlag = "PASS";
				Driver.comment = "Element appeared and selected";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Pass" + " # " + Driver.comment);
			}
			else
			{
				System.out.println("element not present -- so it entered the else loop");
				Driver.tcFlag = "PASS";
				Driver.comment = "Element not appeared for selection";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Pass" + " # " + Driver.comment);
			}

		break;

		}
		
	}
}
