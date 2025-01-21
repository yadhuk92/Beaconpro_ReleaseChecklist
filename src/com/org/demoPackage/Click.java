package com.org.demoPackage;

import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import java.io.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Click {

	public static WebElement element;

	public static WebDriver Click(WebDriver driver, String locatorType, String propertyValue, String testData) throws InterruptedException {
		
		
		switch(locatorType.toLowerCase()){
		
		case "id":
			
			try{
				
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.id(propertyValue)));
				if (element.isDisplayed() == true) {
					driver.findElement(By.id(propertyValue)).click();
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			//element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
			
			break;
			
		case "xpath":
			
			String exeflag = "TRUE";
			
			//===========================================
			/*if((Driver.objectName.equals("Beacon_Chitty_ManagerAuth_menu")) || (Driver.objectName.equals("InvestOpening_Cashier_TransID"))){
				Thread.sleep(5000);
			}
			if (Driver.objectName.equals("ManagerAuthorizationCloseButton")){
				Thread.sleep(5000);
			}*/
			
			if ((Driver.objectName.toUpperCase().equals("COLLAPSEALL")) || (Driver.objectName.equals("AccountOpening_DEPOSIT_LOAN_AcNotBelongsToMortgagerPopUP")) ){
				//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				try{
					if (driver.findElement(By.xpath(propertyValue)).isDisplayed()){
						driver.findElement(By.xpath(propertyValue)).click();
						Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
						
					}else{
						Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
					}
				}catch(Exception e){
					//Driver.tcFlag = "FAIL";
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}
				//driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
				
			}else{ // Code not related to CollapseALl

				String s = null;
				JavascriptExecutor js = (JavascriptExecutor)driver;
				
				for(int j=0; j<Driver.sinkWait; j++){
					//System.out.println("Click: Page Sync");
					try{
						s = js.executeScript("return document.readystate") + "True";
						if ((s.equals("completeTrue")) || (s.equals("nullTrue"))){
							break;
						}
					}catch(Exception e){
						Thread.sleep(500);
					}
				}
				for(int j=0; j<Driver.sinkWait; j++){
					//System.out.println("Click: JQuery Sync");
					try{
						s = js.executeScript("return jQuery.active") + "True";
						if (s.equals("0True")){
							break;
						}
					}catch(Exception e){
						Thread.sleep(500);
					}
				}
				

				
				try{
					if (Driver.objectName.equals("Share_AClassShare_Nominee_select")){System.out.println("Came here 1"); }
					new WebDriverWait(driver,60).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(propertyValue)))));
					if (Driver.objectName.equals("Share_AClassShare_Nominee_select")){System.out.println("Came here 2"); }
					element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.name(propertyValue)));
					if (Driver.objectName.equals("Share_AClassShare_Nominee_select")){System.out.println("Came here 3"); }
					if (element.isEnabled()){
						driver.findElement(By.xpath(propertyValue)).click();
						Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
					}else{
						Driver.tcFlag = "FAIL";
						Driver.comment = Driver.objectName + " object is not enabled";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					}
					
					
					//driver.findElement(By.xpath(propertyValue)).click();
					//flagStatus = "TRUE";

					
					
					//new WebDriverWait(driver,30).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(driver.findElement(By.id("progressdiv")))));
					
				}catch(Exception e){
					
					try{
						if (Driver.objectName.equals("Share_AClassShare_Nominee_select")){System.out.println("Came here 4"); }
						//new WebDriverWait(driver,60).until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(propertyValue))));
						
						for(int i=0;i<60; i++){
							try{
								//new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(propertyValue))));
								if(driver.findElement(By.xpath(propertyValue)).isEnabled()){
									break;
								}else{
									Thread.sleep(1000);
								}
								
							}catch(Exception e1){
								Thread.sleep(1000);
							}
						}
						
						new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(propertyValue))));

						
						String obj1 = "Others_DataSharing_SubMenu";
						String obj2 = "DataSharing_CollectionImporting_SubMenu";
						if (Driver.objectName.equals("Share_AClassShare_Nominee_select")){System.out.println("Came here 5"); }
						if ((Driver.objectName.equals(obj1)) || (Driver.objectName.equals(obj2))){
							Actions action = new Actions(driver);
							action.sendKeys(Keys.PAGE_DOWN).perform();
							action.sendKeys(Keys.PAGE_DOWN).perform();
							action.sendKeys(Keys.PAGE_DOWN).perform();
						}
						if (Driver.objectName.equals("Share_AClassShare_Nominee_select")){System.out.println("Came here 6"); }
						System.out.println(driver.findElement(By.xpath(propertyValue)).isDisplayed());
						if (driver.findElement(By.xpath(propertyValue)).isEnabled()){
							driver.findElement(By.xpath(propertyValue)).click();
							Driver.tcFlag = "PASS";
							Driver.comment = "Pass";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
						}else{
							Driver.tcFlag = "FAIL";
							Driver.comment = Driver.objectName + " object is not enabled";
							Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
						}
						
						
						/*driver.findElement(By.xpath(propertyValue)).click();
						//flagStatus = "TRUE";
						Driver.tcFlag = "PASS";
						Driver.comment = "Pass";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
						*/
						if((Driver.objectName.equals("Share_AClassShareBatch_Go")) || (Driver.objectName.equals("Share_AClassShareBatch_Go"))){
							try{
								driver.switchTo().alert().accept();
							}catch(Exception e2){
								
							}
						}
						//new WebDriverWait(driver,30).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(driver.findElement(By.id("progressdiv")))));
					}catch(Exception e1){
						Driver.tcFlag = "FAIL";
						Driver.comment = Driver.objectName + " is not displayed or not identified";
						Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					}
					
					
				}
				

			}
			
			
			break;
			
		case "name":
			
			try{
				//element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.name(propertyValue)));
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.name(propertyValue)));
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.name(propertyValue)));
				if (element.isDisplayed() == true) {
					driver.findElement(By.name(propertyValue)).click();
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
				break;
				
		case "linktext":
			
			//if (Driver.objectName.equals("Beacon_Chitty_logout_button")){
			//	Thread.sleep(5000);
			//}
			
			String s = null;
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			for(int j=0; j<Driver.sinkWait; j++){
				try{
					s = js.executeScript("return document.readystate") + "True";
					if ((s.equals("completeTrue")) || (s.equals("nullTrue"))){
						break;
					}
				}catch(Exception e){
					Thread.sleep(500);
				}
			}
			for(int j=0; j<Driver.sinkWait; j++){
				try{
					s = js.executeScript("return jQuery.active") + "True";
					if (s.equals("0True")){
						break;
					}
				}catch(Exception e){
					Thread.sleep(500);
				}
			}
			
			for(int i=0; i<60; i++){
				try{
					if (driver.findElement(By.linkText(propertyValue)).isEnabled()){
						break;
					}else{
						Thread.sleep(1000);
					}
				}catch(Exception e1){
					Thread.sleep(1000);
				}
			}
			
			try{
				driver.findElement(By.linkText(propertyValue)).click();
				//flagStatus = "TRUE";
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			}catch(Exception e){
				
				try{
					new WebDriverWait(driver,5).until(ExpectedConditions.stalenessOf(driver.findElement(By.linkText(propertyValue))));
					driver.findElement(By.linkText(propertyValue)).click();
					//flagStatus = "TRUE";
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
					
				}catch(Exception e1){
					Driver.tcFlag = "FAIL";
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
				
			}
			


			break;
			
		case "css":
			
			try{
				//element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.linkText(propertyValue)));

				//if (Driver.objectName.equalsIgnoreCase("Personal_Information_Nationality_India")) {

				//}
			element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(propertyValue)));
				if (element.isDisplayed() == true) {
					driver.findElement(By.cssSelector(propertyValue)).click();
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{

					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}

			break;
		
		}	
		return driver;
		
	}
	
	public static WebDriver DoubleClick(WebDriver driver, String locatorType, String propertyValue, String testData) throws InterruptedException 
	{
		switch(locatorType.toLowerCase())
		{
		case "id":
			try
			{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.id(propertyValue)));
				if (element.isDisplayed() == true) 
				{
					Actions act = new Actions(driver);
					WebElement ele = driver.findElement(By.id(propertyValue)); 
					act.doubleClick(ele).perform();
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}
				else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			//element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
			
			break;
			
		case "xpath":
			try
			{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				if (element.isDisplayed() == true) 
				{
					Actions act = new Actions(driver);
					WebElement ele = driver.findElement(By.xpath(propertyValue)); 
					act.doubleClick(ele).perform();
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}
				else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				Driver.comment = Driver.objectName + " is not displayed or not identified";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			
			break;

}
		return driver;
	}
}
