package com.org.demoPackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchChildWindow {
		
	
	public static WebDriver SwitchToChild(WebDriver driver,  String propertyValue) throws Exception {
		
		
		System.out.println("inside Switch to child Window   method");
		
		
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
	    String subWindowHandler = null;

	    Set<String> handles = driver.getWindowHandles(); // get all window handles
	    Iterator<String> iterator = handles.iterator();
	    while (iterator.hasNext()){
	        subWindowHandler = iterator.next();
	    }
	    driver.switchTo().window(subWindowHandler); // switch to child window
	    driver.findElement(By.xpath("html/body/form/div[3]/div/div/table/tbody/tr[2]/td[2]/input[1]\r\n")).sendKeys("380");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='txtsuspense_txt']\r\n")).sendKeys("381");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='txtPaymentHead_txt']\r\n")).sendKeys("382");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='txtDiscHead_txt']\r\n" )).sendKeys("383");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='txtForFeitedHead_txt']\r\n" )).sendKeys("383");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='txtFineHead_txt']\r\n")).sendKeys("384");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='txtReceivableHead_txt']\r\n" )).sendKeys("385");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='txtBankCommHead_txt']\r\n" )).sendKeys("386");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='txtChittyBankProfitHead_txt']" )).sendKeys("387");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='txtBonusHead_txt']" )).sendKeys("388");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("html/body/form/div[3]/div/div/table/tbody/tr[12]/td/center/input[1]\r\n")).click();
	    Thread.sleep(1000);
	    //SwitchParentWindow.SwitchToParent(driver);

	    driver.switchTo().window(parentWindowHandler); 
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_btnSave']\r\n" )).click();
	    Thread.sleep(1000);
	    Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
		 
		return driver;
}

	
	
	
}