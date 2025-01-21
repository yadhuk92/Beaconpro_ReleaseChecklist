package com.org.demoPackage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestCases {

	public static String tcFile = "./TestCases/";
	public static int tcColumns = 0;
	public static int tcRows = 0;
	public static String pageName = null;
	public static String objectName = null;
	public static String action = null;
	public static String testData = null;
	public static String testDescription = null;
	
	
	//public static LinkedHashMap<String, String> testCases = new LinkedHashMap<String, String>();
	public static List testCases = new ArrayList();
	
	
	public static void readTestCaseSheet(String fileName) throws BiffException, IOException {
		
		testCases.clear();
		
		Workbook tcwb = Workbook.getWorkbook(new File(tcFile + fileName + ".xls"));
		
		Sheet tcsh = tcwb.getSheet(0);
		tcColumns = tcsh.getColumns();
		tcRows = tcsh.getRows();
		
		
		for (int i=1; i<tcRows; i++){
			pageName = tcsh.getCell(0, i).getContents();
			objectName = tcsh.getCell(1, i).getContents();
			action = tcsh.getCell(2, i).getContents();
			testData = tcsh.getCell(3, i).getContents();
			testDescription = tcsh.getCell(4, i).getContents();
			testCases.add(pageName + " # " + objectName + " # " + action + " # " + testData + " # " + testDescription);	
		}
		
		/*for(int i=0; i<testCases.size(); i++){
			System.out.println(testCases.get(i));
		}*/
		
		
	} // End of Main method

} // End of class
