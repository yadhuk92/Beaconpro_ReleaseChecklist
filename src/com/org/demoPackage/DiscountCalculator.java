package com.org.demoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DiscountCalculator {
	
	public static void getDiscountAmount( WebDriver driver,String propertyValue) {
		
		try {
	
		Float Chitty_Amount, Discount_Amount ;
		
		//System.out.println("inside calculate discount method");
		
		Chitty_Amount=Float.valueOf(driver.findElement(By.xpath(".//*[@id='ChittyInfoContainer']/tr/td[3]")).getText());
		//System.out.println("Chitty Amount "+Chitty_Amount);
		
		WebElement DiscPerc=driver.findElement(By.xpath(".//*[@id='ChittyInfoContainer']/tr/td[8]")) ;
		String str= DiscPerc.getText();
		String newStr= str.replaceAll("%", "");
		
		int Discount_Percentage= Integer.parseInt(newStr);
		
		//System.out.println("Discount rate "+Discount_Percentage);
		
		Discount_Amount=Float.valueOf((Chitty_Amount*Discount_Percentage)/100);
		//System.out.println("Discount rate "+Discount_Amount);
		
		driver.findElement(By.xpath(propertyValue)).sendKeys(""+Discount_Amount);
		
		Driver.tcFlag = "PASS";
		Driver.comment = "Pass";
		Driver.individualTestCaseStepCollector.put(Driver.testStepDescription,  Driver.comment);
	}
	catch (NumberFormatException e){
		System.out.println("*************  Error Occured *************");
		e.printStackTrace();
		System.exit(0);
	}

}
}
