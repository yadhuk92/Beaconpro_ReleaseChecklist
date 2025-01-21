package com.org.demoPackage;

import java.io.File;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
	
public class Driver {
	public static WebDriver driver = null;
	public static double totalExecuted = 0.0; 
	public static double totalPassed = 0.0;
	public static double totalFailed = 0.0; 
	public static double passPercentage = 0.0;
	public static double failPercentage = 0.0;
	public static String tcFlag = null;
	public static LinkedHashMap<String, String> testCaseStatusCollector = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> individualTestCaseStepCollector = new LinkedHashMap<String, String>();
	public static String comment = null;
	public static StringWriter errors = new StringWriter();
	public static String testStepDescription = null;
	public static long tcStartTime= 0;
	public static long tcEndTime = 0; 
	public static long startTime = 0;
	public static long endTime = 0;
	public static String objectName = null; 
	public static String tcid;  
	public static String tcDescription;
	public static int  waitCounter=1;
	public static String timeStampValue; 
    public static int sinkWait=120;
    public static String jqueryflag = "TRUE"; // TRUE or FALSE
    public static String uniquenumber = "";
    public static int stepCounter = 1;
    
    
	public static void main(String[] args) {
		System.out.println("************** Started Execution *******************");
		
		//******** Read Object Repository from the excel  sheet *****************
		//**********************************************************************
		try{
			startTime = System.currentTimeMillis();		
			ObjectRepository.readObjectRepository();
		
		}catch (Exception e){
			System.exit(0);
		} // End of Catch
		
		//******** Read Test Scenarios Sheet ************************************
		//***********************************************************************

		try{
			CreateFolder.CreateResultsFolder();
			
			TestScenarios.readTestScenarios();
			for(String key: TestScenarios.testScenarios.keySet()){
				
			
				
				String [] tempData = key.split(" # ");
				tcid=tempData[0].trim();
				tcDescription = tempData[1].trim();
				
				if (TestScenarios.testScenarios.get(key).equalsIgnoreCase("Y")){
					
					stepCounter = 1;
					
					timeStampValue = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
					System.out.println("****** Test Case Description: " + tcDescription + " *****");
					totalExecuted = totalExecuted + 1;
					TestCases.testCases.clear();
					
					TestCases.readTestCaseSheet(tcid);
					
					driver = InitiateSelenium.OpenBrowser();
					
					
					//driver.manage().timeouts().implicitlyWait(waitCounter, TimeUnit.SECONDS);
					//System.out.println("Reading Credentials");
					//Credential.getCredential();
					
					
					
					String flag = "True";
					tcStartTime = System.currentTimeMillis();
					for(int k=0; k<TestCases.testCases.size(); k++){
						
						String tcrow = (String) TestCases.testCases.get(k);
						String [] tcTemp = tcrow.split("#");
						String pageName = tcTemp[0].trim();
						objectName = tcTemp[1].trim();
						//System.out.println(k +":"+objectName);
						String actionName = tcTemp[2].trim();
						String testData = tcTemp[3].trim();
						String tempTestData = InitiateSelenium.getLoginData(testData);
						
						if (tempTestData == null) {
							
						}else{ 
							testData = tempTestData;
						}
						if (testData.contains("TimeStamp")) {
							tempTestData = testData.split("TimeStamp")[0].trim();
							testData = tempTestData + timeStampValue;
							
						}
						testStepDescription = tcTemp[4].trim();
						testStepDescription = stepCounter + "#" + testStepDescription;
						stepCounter = stepCounter + 1;
						//System.out.println("row number : " + k + " Object Name: " + objectName);
						//System.out.println("row number : " + k + " Action  Name: " + actionName);
						//System.out.println("row number : " + k + " testdata : " + testData);
						
						//ActionSelector.performAction(driver, actionName, objectName, testData);
						
						if (actionName.equals("")){
							break;
						}else{
							int b = k+2;
							
							ActionSelector.performAction(driver, actionName, objectName, testData);
							System.out.println("K: " + b);

						}
						
						
						if (tcFlag.equalsIgnoreCase("FAIL")) {
							CaptureScreen.captureScreenShot(driver, tcid);
							flag = "False"; 
							driver.quit(); //uncomment - January 17th.
							break;
						}
						//driver.manage().timeouts().pageLoadTimeout(waitCounter, TimeUnit.SECONDS);
						
						
					} // End of for loop for test cases collection object iterator
					if (flag.equals("True")) {
						//driver.quit(); // No need to enable this.
					}
					driver.quit(); //uncomment - January 17th
					IndividualReport.CreateReport(tcid, tcDescription);
					individualTestCaseStepCollector.clear();
					tcEndTime = System.currentTimeMillis();
					/*System.out.println("==========");
					for(String j: individualTestCaseStepCollector.keySet()){
						System.out.println(j + " " + individualTestCaseStepCollector.get(j));
					}*/
					if (tcFlag.equalsIgnoreCase("PASS")) {
						totalPassed = totalPassed + 1;
						testCaseStatusCollector.put(tcid + " @ " + tcDescription, "Pass" + " # " + (tcEndTime-tcStartTime) /1000 + " second(s)");
						
					}else if (tcFlag.equalsIgnoreCase("FAIL")){
						totalFailed = totalFailed + 1;
						testCaseStatusCollector.put(tcid + " @ " + tcDescription, "Fail" + " # " +  (tcEndTime-tcStartTime) / 1000 + " second(s)");
					}
				} // End of If loop for comparing run flag status in test scenarios sheet


				
			} // End of for loop for iterating through testScenarios collection object
			System.out.println("Total Executed: " + totalExecuted);
			System.out.println("Total Passed: " + totalPassed);
			System.out.println("Total Failed: " + totalFailed);
			if (totalExecuted == 0) {
				passPercentage = 0; 
				failPercentage = 0;
			}else{
				passPercentage = (double)(totalPassed / totalExecuted)*100;
				failPercentage = (double)(totalFailed / totalExecuted)*100;
			}
			System.out.println("Pass Percentage: " + passPercentage);
			System.out.println("Fail Percentage: " + failPercentage);
			endTime = System.currentTimeMillis();
			if (InitiateSelenium.browserType == null) {
				InitiateSelenium.browserType = "NULL";
			}
			SummaryReport.CreateReport();
			/*for(String j: testCaseStatusCollector.keySet()){
				System.out.println(j + " " + testCaseStatusCollector.get(j));
			}*/
				
			
		}catch(Exception e){
			//e.printStackTrace();
			System.out.println("*************  Error Occured *************");
			e.printStackTrace();
			System.exit(0);
		} // End of Catch
		
	} // End of Main Method

	
}
