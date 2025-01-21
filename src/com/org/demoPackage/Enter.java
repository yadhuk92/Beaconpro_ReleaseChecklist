package com.org.demoPackage;

import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Enter {
	
	public static WebElement element;

	public static WebDriver Enter(WebDriver driver, String locatorType, String propertyValue, String testData) throws InterruptedException {
		

		switch(locatorType.toLowerCase()){
		
		case "id":
			
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.id(propertyValue)).click();
					//driver.findElement(By.id(propertyValue)).clear();
					driver.findElement(By.id(propertyValue)).sendKeys(testData);
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
			

			
			
			
		case "xpath":
			if ((Driver.objectName.toUpperCase().contains("AADHAARNO")) || (Driver.objectName.toUpperCase().contains("IDENTITYNO")) || (Driver.objectName.toUpperCase().contains("EMPCODE"))){
				testData = Driver.uniquenumber;
			}
			
			//============
			String s = null;
			JavascriptExecutor js = (JavascriptExecutor)driver;
			for(int j=0; j<Driver.sinkWait; j++){
				//System.out.println("Enter: Page Sync");
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
				//System.out.println("Enter: JQuery Sync");
				try{
					s = js.executeScript("return jQuery.active") + "True";
					if (s.equals("0True")){
						break;
					}
				}catch(Exception e){
					Thread.sleep(500);
				}
			}
			String flagStatus = "FALSE";
			
			for(int i=0; i<60; i++){
				try{
					if (driver.findElement(By.xpath(propertyValue)).isEnabled()){
						break;
					}else{
						Thread.sleep(1000);
					}
					
				}catch(Exception e1){
					Thread.sleep(1000);
				}
			}
			
			
			try{
				new WebDriverWait(driver,40).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(propertyValue)))));
				driver.findElement(By.xpath(propertyValue)).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(propertyValue)).clear();
				Thread.sleep(1000);
				driver.findElement(By.xpath(propertyValue)).sendKeys(testData);
				//flagStatus = "TRUE";
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
			}catch(Exception e){
				
				try{
					//new WebDriverWait(driver,1/2).until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(propertyValue))));
					driver.findElement(By.xpath(propertyValue)).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath(propertyValue)).clear();
					Thread.sleep(1000);
					driver.findElement(By.xpath(propertyValue)).sendKeys(testData);
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
			
		case "name":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.name(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.name(propertyValue)).click();
					//driver.findElement(By.name(propertyValue)).clear();
					driver.findElement(By.name(propertyValue)).sendKeys(testData);
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
			
		case "css":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.cssSelector(propertyValue)).click();
					driver.findElement(By.cssSelector(propertyValue)).clear();
					driver.findElement(By.cssSelector(propertyValue)).sendKeys(testData);
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
	
	public static WebDriver PressEnterKey(WebDriver driver, String locatorType, String propertyValue, String testData){
		
		switch(locatorType.toLowerCase()){
		case "id":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.id(propertyValue)).sendKeys(Keys.ENTER);
					Driver.tcFlag = "PASS";
					//Driver.comment = "Pass";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				//Driver.comment = Driver.objectName + " is not displayed or not identified";
				//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);		
				e.printStackTrace();
			}

			break;
		case "xpath":
		
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.xpath(propertyValue)).sendKeys(Keys.ENTER);
					Driver.tcFlag = "PASS";
					//Driver.comment = "Pass";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				//Driver.comment = Driver.objectName + " is not displayed or not identified";
				//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}

			break;
		case "name":
			try{
				
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.name(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.name(propertyValue)).sendKeys(Keys.ENTER);
					Driver.tcFlag = "PASS";
					//Driver.comment = "Pass";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
					
				}

				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				//Driver.comment = Driver.objectName + " is not displayed or not identified";
				//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				e.printStackTrace();
			}
			break;
		}
		return driver;
	}

	public static WebDriver PressDownArrow(WebDriver driver, String locatorType, String propertyValue, String testData){
		
		switch(locatorType.toLowerCase()){
		case "id":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.id(propertyValue)).sendKeys(Keys.ARROW_DOWN);
					Driver.tcFlag = "PASS";
					//Driver.comment = "Pass";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				//Driver.comment = Driver.objectName + " is not displayed or not identified";
				//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}

			break;
		case "xpath":
			
			
			
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.xpath(propertyValue)).sendKeys(Keys.ARROW_DOWN);
					Driver.tcFlag = "PASS";
					//Driver.comment = "Pass";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				//Driver.comment = Driver.objectName + " is not displayed or not identified";
				//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}

			break;
		case "name":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.name(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.name(propertyValue)).sendKeys(Keys.ARROW_DOWN);
					Driver.tcFlag = "PASS";
					//Driver.comment = "Pass";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				//Driver.comment = Driver.objectName + " is not displayed or not identified";
				//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);			
			}
			
			break;
		}
		return driver;
	}
	
	public static WebDriver PressTabKey(WebDriver driver, String locatorType, String propertyValue, String testData) throws InterruptedException {
		switch(locatorType.toLowerCase()){
		case "id":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.id(propertyValue)).sendKeys(Keys.TAB);
					Driver.tcFlag = "PASS";
					//Driver.comment = "Pass";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				//Driver.comment = Driver.objectName + " is not displayed or not identified";
				//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}

			break;
			
		case "xpath":
			try{
				Actions action1 = new Actions(driver);
				action1.sendKeys(Keys.TAB).perform();
				
				for(int i=0; i<180;  i++){
					try{
						WebElement element = driver.findElement(By.id("progressdiv"));
						if(element.isDisplayed()){
							//System.out.println("********* Spinner is displayed **********");
							Thread.sleep(1000);
						}else{
							//System.out.println("********* Spinner is not displayed **********");
							break;
						}
						
					}catch(Exception e){
						//System.out.println("********* Catch: Spinner is not displayed **********");
						break;
					}
				}
				
				Driver.tcFlag = "PASS";
				//double timer2;
				//timer2 = System.currentTimeMillis();
				//System.out.println("Duration: " + (timer2-timer1)/1000);
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
			}
			
			break;
			
		case "xpath_old":
			
			int Pcounter=0;
			int Ncounter=0;
			
			/*try{
				new WebDriverWait(driver,30).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(driver.findElement(By.id("progressdiv")))));
			}catch(Exception e1){
				
			}*/

			
			
			try{
				
				double timer1;
				timer1 = System.currentTimeMillis();
				String before = driver.findElement(By.tagName("html")).getAttribute("innerHTML");
				Actions action = new Actions(driver);
				action.sendKeys(Keys.TAB).perform();
				String after = "";
				String temp = "";
				
				//***************
				JavascriptExecutor js = (JavascriptExecutor)driver;
				String splitcontent = "<div style=\"float: right; font-weight: bold\" id=\"currentTime\">";
				if (before.contains(splitcontent)){
					before = before.split(splitcontent)[1];
					before = before.split("</div>")[1];
				}
				
				/*for(int i=0; i<30; i++){
					after = driver.findElement(By.tagName("html")).getAttribute("innerHTML");
					
					if (after.contains(splitcontent)){
						after = after.split(splitcontent)[1];
						after = after.split("</div>")[1];
					}
					
					
					if (before.equals(after)){
						//System.out.println("Equal");
						Ncounter = Ncounter + 1;
						before = after;
						Thread.sleep(500);
						if(Ncounter > 3){
							break;
						}
					}else{
						//System.out.println("Not Equal");
						before = after;
						Ncounter = 0;
						Thread.sleep(1000);
						
					}
				}*/
				//Code for checking spinning wheel

				for(int i=0; i<60;  i++){
					try{
						WebElement element = driver.findElement(By.id("progressdiv"));
						if(element.isDisplayed()){
							//System.out.println("********* Spinner is displayed **********");
							Thread.sleep(1000);
						}else{
							//System.out.println("********* Spinner is not displayed **********");
							break;
						}
						
					}catch(Exception e){
						//System.out.println("********* Catch: Spinner is not displayed **********");
						break;
					}
				}

				//***************
				
				
				/*for(int i=0; i<20; i++){
					//driver.findElement(By.xpath(propertyValue)).sendKeys(Keys.TAB);
					
					//Thread.sleep(500);
					 after = driver.findElement(By.tagName("html")).getAttribute("innerHTML");

					if (before.equals(after)){
						System.out.println("Equal");
						Ncounter = Ncounter + 1;
						//if(Ncounter > 1){
						//	break;
						//}
						Thread.sleep(1000);
					}else{
						System.out.println("Not Equal");
						Pcounter = Pcounter + 1;
						//if (Pcounter > 3){
						//	break;
						//}
						Thread.sleep(1000);
					}
				}*/
				
				
				
				Driver.tcFlag = "PASS";
				double timer2;
				timer2 = System.currentTimeMillis();
				System.out.println("Duration: " + (timer2-timer1)/1000);
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				//e.printStackTrace();
			}
			
			//===========================================
			/*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			try{
				element = new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					
					for(int i=0; i<Driver.sinkWait; i++)
					{
						try {
					driver.findElement(By.xpath(propertyValue)).sendKeys(Keys.TAB);
					System.out.println(System.currentTimeMillis());
					//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					System.out.println(System.currentTimeMillis());
					
					String s = null;
					JavascriptExecutor js = (JavascriptExecutor)driver;
					
					for(int j=0; j<Driver.sinkWait; j++){
						try{
							s = js.executeScript("return document.readystate") + "True";
							if ((s.equals("completeTrue")) || (s.equals("nullTrue"))){
								Thread.sleep(1000);
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
								Thread.sleep(1000);
								break;
							}
						}catch(Exception e){
							Thread.sleep(500);
						}
					}

					Driver.tcFlag = "PASS";
					break;
						}catch(Exception e)
						{
							Thread.sleep(500);
						}
						
					}
					
					//driver.findElement(By.xpath(propertyValue)).click();

					//Driver.tcFlag = "PASS";
					if (Driver.tcFlag == "PASS") {
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);

				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);

				}
				}
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				//Driver.comment = Driver.objectName + " is not displayed or not identified";
				//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			*/
			break;
		case "name":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.name(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.name(propertyValue)).sendKeys(Keys.TAB);
					Driver.tcFlag = "PASS";
					//Driver.comment = "Pass";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				//Driver.comment = Driver.objectName + " is not displayed or not identified";
				//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}

			break;
		}
		return driver;
	}

	
	public static WebDriver Type(WebDriver driver, String testData)  {
		Actions action = new Actions(driver);
		action.sendKeys(testData).perform();
		Driver.tcFlag = "PASS";
		return driver;
	}
	
	public static WebDriver PressUpArrow(WebDriver driver, String locatorType, String propertyValue, String testData) {
		switch(locatorType.toLowerCase()){
		case "id":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.id(propertyValue)).sendKeys(Keys.ARROW_UP);
					Driver.tcFlag = "PASS";
					//Driver.comment = "Pass";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				//Driver.comment = Driver.objectName + " is not displayed or not identified";
				//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}

			break;
		case "xpath":
			
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.xpath(propertyValue)).sendKeys(Keys.ARROW_UP);
					Driver.tcFlag = "PASS";
					//Driver.comment = "Pass";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);

				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);

				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				//Driver.comment = Driver.objectName + " is not displayed or not identified";
				//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}
			
			break;
		case "name":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.name(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.name(propertyValue)).sendKeys(Keys.ARROW_UP);
					Driver.tcFlag = "PASS";
					//Driver.comment = "Pass";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				//Driver.comment = Driver.objectName + " is not displayed or not identified";
				//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}

			break;
		}
		return driver;
	}
	
public static WebDriver PressDeleteKey(WebDriver driver, String locatorType, String propertyValue, String testData){
		
		switch(locatorType.toLowerCase()){
		case "id":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.id(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.id(propertyValue)).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
					Driver.tcFlag = "PASS";
					//Driver.comment = "Pass";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				//Driver.comment = Driver.objectName + " is not displayed or not identified";
				//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}

			break;
		case "xpath":
			
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.xpath(propertyValue)).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
					Driver.tcFlag = "PASS";
					//Driver.comment = "Pass";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				//Driver.comment = Driver.objectName + " is not displayed or not identified";
				//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
			}

			break;
		case "name":
			try{
				element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.elementToBeClickable(By.name(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue))));
				if (element.isDisplayed() == true) {
					driver.findElement(By.name(propertyValue)).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
					Driver.tcFlag = "PASS";
					//Driver.comment = "Pass";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					//Driver.comment = Driver.objectName + " is not displayed or not identified";
					//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}
				
			}catch(Exception e){
				Driver.tcFlag = "FAIL";
				//Driver.comment = Driver.objectName + " is not displayed or not identified";
				//Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);			
			}
			
			break;
		}
		return driver;
	}
	

}
