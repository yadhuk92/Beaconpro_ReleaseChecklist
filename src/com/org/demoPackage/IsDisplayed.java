package com.org.demoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IsDisplayed {

	public static WebElement element;

	public static WebDriver IsDisplayed(WebDriver driver, String locatorType) {
		

		switch(locatorType.toLowerCase()){
				
		case "xpath":
			
				try{
				//element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.xpath(propertyValue)));
				//element = (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue)));
				//element = (new WebDriverWait(driver, Driver.waitCounter)).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath(propertyValue))));
			
				WebElement element= driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_IN1_tp1_lstInvestDetails_ctrl0_INVF_txtROI_txt']\r\n"));
				//System.out.println(element.isDisplayed());
				element.click();
				//System.out.println(element.isDisplayed());
				Thread.sleep(4000);
				Driver.tcFlag = "PASS";
				Driver.comment = "Pass";
				Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);

				/*if (element.isDisplayed() == true) {
					//driver.findElement(By.xpath(propertyValue)).click();
					Driver.tcFlag = "PASS";
					Driver.comment = "Pass";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
				}else{
					Driver.tcFlag = "FAIL";
					//e.printStackTrace(new PrintWriter(Driver.errors));
					//Driver.comment = Driver.errors.toString();
					Driver.comment = Driver.objectName + " is not displayed or not identified";
					Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  "Fail" + " # " + Driver.comment);
				}*/
				
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

