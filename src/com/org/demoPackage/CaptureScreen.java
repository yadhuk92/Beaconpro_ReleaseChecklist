package com.org.demoPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreen {

	public static WebDriver captureScreenShot(WebDriver driver, String key) {
		
		
		try {
			File imgFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(imgFile, new File("./Results/" + CreateFolder.currentDate + "/" + CreateFolder.runDirName +  "/Screenshots/" + key + ".png" ));
		} catch (IOException e) {
			System.out.println("Something went wrong while capturing screenshot. Closing the test");
			System.exit(0);
		}
		return driver;

	}

}
