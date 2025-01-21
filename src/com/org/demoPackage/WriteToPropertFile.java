package com.org.demoPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WriteToPropertFile {
	
	public static void WriteMdsNumber(WebDriver driver,String propertyValue) throws IOException {
		
		Properties prop=new Properties();
		
		try {
			System.out.println("inisde save mds method");
			 
			String AccountNumber =driver.findElement(By.xpath(propertyValue)).getAttribute("Value");
			 System.out.println("MDS number is  "+ AccountNumber);
			 
			 String accno= AccountNumber.substring(9);
			 
			 File file2 = new File("./DataFiles/InvestmentAccountNumber.properties");
			 FileOutputStream fos = new FileOutputStream(file2);
			 
			 prop.setProperty("InvestmentAcc Number ",accno);
			 prop.store(fos, "Done");
			 
			 fos.close();
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
	}
}
	