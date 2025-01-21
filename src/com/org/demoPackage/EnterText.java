package com.org.demoPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class EnterText {

	public static void enterText(WebDriver driver, String PropertyValue, String testData) {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		jse.executeScript("document.getElementById('PropertyValue').value='testData'");
	}
}
