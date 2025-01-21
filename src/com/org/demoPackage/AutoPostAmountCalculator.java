package com.org.demoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoPostAmountCalculator {

public static void PostAmountCalculator(WebDriver driver,String propertyValue) {
	
	
	String balanceAmount=driver.findElement(By.xpath(".//*[@id='txtBalAmount_txt']")).getAttribute("value");
	
	balanceAmount = "front"+balanceAmount+"back";
	if (balanceAmount.equals("frontback")){
		balanceAmount = "0";
	}
	System.out.println("Amount: " + balanceAmount);
	driver.findElement(By.xpath(propertyValue)).sendKeys(""+balanceAmount);
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	
	
}
public static void SBCreditAmountCalculator(WebDriver driver,String propertyValue) {
	
	System.out.println("Transfer Amount"+driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtTrnAmount_txt']")).getAttribute("value"));
	String balanceAmount=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstTransApprovingInfo_ctrl0_ucTransactionApprovingInfo_txtTrnAmount_txt']")).getAttribute("value");
	
	driver.findElement(By.xpath(propertyValue)).sendKeys(""+balanceAmount);
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	
}
public static void DDCreditInstallmentAmount(WebDriver driver,String propertyValue) {
	
    String balanceAmount=driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_AGV_txtInstAmount_txt']")).getAttribute("value");
    if (balanceAmount.contains("CR")){
		balanceAmount = balanceAmount.split("CR")[0];
	}
	if (balanceAmount.contains("DR")){
		balanceAmount = balanceAmount.split("DR")[0];
	}
	driver.findElement(By.xpath(propertyValue)).sendKeys(""+balanceAmount);
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	
	
}

public static void RDCreditAmountCalculator(WebDriver driver,String propertyValue) {
	
    String balanceAmount=driver.findElement(By.xpath(".//*[@id='txtBalAmount_txt']")).getAttribute("value");
	if (balanceAmount.contains("CR")){
		balanceAmount = balanceAmount.split("CR")[0];
	}
	if (balanceAmount.contains("DR")){
		balanceAmount = balanceAmount.split("DR")[0];
	}
	driver.findElement(By.xpath(propertyValue)).sendKeys(""+balanceAmount);
	Driver.tcFlag = "PASS";
	Driver.comment = "Pass";
	Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	
	
}
}
