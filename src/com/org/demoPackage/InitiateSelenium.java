package com.org.demoPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitiateSelenium {
	
	public static String browserType = null;
	public static String url = null;
	public static String username = null;
	public static String password = null;
	public static String Pro_password = null;
	

	public static WebDriver OpenBrowser() throws InterruptedException {
	
		
		try {
			Properties prop = new Properties();
			InputStream input = new FileInputStream("./DataFiles/Config.properties");
			prop.load(input);
			browserType = prop.getProperty("browser");
			url = prop.getProperty("url");
			
			
			switch(browserType.toUpperCase()){
				
			case "IE":
				System.setProperty("webdriver.ie.driver", "./Libs/IEDriverServer.exe");
				Driver.driver = new InternetExplorerDriver();
				//Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
				Driver.driver.manage().window().maximize();

				//Driver.driver.navigate().to(url);
				Driver.driver.get(url);
				Thread.sleep(5000);
				break;
			case "CR":
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				
				System.setProperty("webdriver.chrome.driver", "./Libs/chromedriver.exe");
				Driver.driver = new ChromeDriver(options);

				//Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);

				//Driver.driver.manage().window().maximize();

				Driver.driver.get(url);
				Thread.sleep(5000);
				break;
			case "FF":
				
				
				//Loading default profile
				
				ProfilesIni profile = new ProfilesIni();
				FirefoxProfile ffprofile = profile.getProfile("default");
				Driver.driver = new FirefoxDriver(ffprofile); 
				//System.setProperty("webdriver.firefox.marionette", "./Libs/geckodriver.exe");
				//Driver.driver = new FirefoxDriver();
				//Driver.driver.manage().timeouts().implicitlyWait(Driver.waitCounter, TimeUnit.SECONDS);
				Driver.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				Driver.driver.manage().window().maximize();
				//Driver.driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
				Driver.driver.get(url);
				Thread.sleep(5000);
				
				break;
			default:
				System.setProperty("webdriver.ie.driver", "./Libs/IEDriverServer.exe");
				Driver.driver = new InternetExplorerDriver();
				Driver.driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
				Driver.driver.manage().window().maximize();
				//Driver.driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
				//Driver.driver.navigate().to(url);
				Driver.driver.get(url);
				Thread.sleep(5000);
				break;
				
			}
			
		} catch (IOException e) {
			System.out.println("*****************  Error Occured *****************");
			e.printStackTrace();
			System.exit(0);
		}
		return Driver.driver;

	}
	
	
	public static String getLoginData(String testDataValue) throws IOException{
		
			Properties lProp = new Properties();
			InputStream lData = new FileInputStream("./DataFiles/login_credentials.properties");
			lProp.load(lData);
			String lDataValue = lProp.getProperty(testDataValue);
			return lDataValue;
		
	}
	
	

}

