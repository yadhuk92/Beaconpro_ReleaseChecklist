package com.org.demoPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ReadLoanCustomerID {

	
	public static void getCustomerId(WebDriver driver, String propertyValue) throws ClassNotFoundException, SQLException {
		
		String CustID=null;
		 System.out.println("inside method");
		 Connection con=(Connection) Common.DatabaseConnector();
			if(con !=null) {
       
        Statement stmt = con.createStatement();	
        
        String Q_datefetch="SELECT top 10 m.Cust_ID \r\n" + 
        		"          FROM CustMaster m \r\n" + 
        		"          JOIN viAccMaster a ON m.Cust_ID = a.Cust_ID\r\n" + 
        		"          WHERE m.Cust_ID not in (select Cust_ID from viaccmaster where ProductID IN (   select ProductID     from Products where IsLoan=1)) \r\n" + 
        		"          AND m.IsKYCCompleted = 1 \r\n" + 
        		"          AND m.Branch_ID = 102 and m.CustType_ID=1"; 
        ResultSet rs1= stmt.executeQuery(Q_datefetch);
        
        while(rs1.next()) {
        	
        	CustID=rs1.getString(1);
        	
        }
		
        System.out.println("customer id "+CustID);
        
        driver.findElement(By.xpath(propertyValue)).sendKeys(""+CustID);
        
        //driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_CPH1_PRDCNT_lstProAccInfo_ctrl0_PAI_btnAddCustomer']")).click();
        
			
			//new Actions(driver).moveToElement(resolutionNo).click().perform();
			
			//JavascriptExecutor jse = (JavascriptExecutor) driver;
			
			//jse.executeScript("document.getElementById('.//*[@id='ctl00_ctl00_CPH1_PRDCNT_TBShare_tpAccInfo_lstShareInfo_ctrl0_ucProductAccountShareInfo_txtResolutionNo_txt']').focus();");
		
        
			}   
	}
}
