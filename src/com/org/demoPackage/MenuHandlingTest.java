package com.org.demoPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class MenuHandlingTest {

	public static void main(String[] args) throws InterruptedException {
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffprofile = profile.getProfile("default");
		WebDriver driver = new FirefoxDriver(ffprofile); 
		
		driver.get("http://121.242.120.119:8086/BeaconProQC/Login.aspx?ReturnUrl=/BeaconProQC/default.aspx");
		driver.findElement(By.xpath(".//*[@id='txtUserName_txt']")).sendKeys("sesame");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='txtPassword_txt']")).sendKeys("ses@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='imgbtnSubmit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/div[1]/div[3]/div/button")).click();
		
		
		driver.findElement(By.xpath("html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[2]/ul/li[1]/ul/li[1]/ul/li[1]/a")).click();
		
		List<WebElement> MenusUnderCustomer = driver.findElements(By.xpath("//div[@id='scWrapper']/div[@id='scMenu']/div[@id='divGlossyMenuContent']/div[@class='submenu']/ul[@id='CreateMenu']/li[@class=' open']/ul/li/a"));
	     
		for (WebElement element: MenusUnderCustomer) {
			 
			 ///if(element.getText().equals(NewCustomer))
			 
				// element.click();
			 
	            System.out.println(element.getText());
	        }
		
		
		List<WebElement> Menus = driver.findElements(By.xpath("//div[@id='scWrapper']/div[@id='scMenu']/div[@id='divGlossyMenuContent']/div[@class='submenu']/ul[@id='CreateMenu']/li[2]/ul/li[1]/ul/li[1]/ul/li[@class='item']/a"));
		
		for (WebElement element1: Menus) {
			 
			 ///if(element.getText().equals(NewCustomer))
			 
				// element.click();
			 
	            System.out.println(element1.getText());
	        }
		
		String NewCustomer=driver.findElement(By.xpath(".//*[@id='CreateMenu']/li[1]/ul/li[1]/a")).getText();
		
		 
		
		
	}

}
