package com.org.demoPackage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestScenarios {
	
	public static String tsFile = "./TestScenarios/tssample.xls";
	public static int tsColumns = 0;
	public static int tsRows = 0;
	public static String tcid = null;
	public static String runFlag = null;
	public static String tcDescription = null;
	public static LinkedHashMap<String, String> testScenarios = new LinkedHashMap<String, String>();

	public static void readTestScenarios() throws BiffException, IOException {
		//LinkedHashMap<String, String> testScenarios = new LinkedHashMap<String, String>();
		
		Workbook tswb = Workbook.getWorkbook(new File(tsFile));
		Sheet tssh = tswb.getSheet(0);
		
		tsColumns = tssh.getColumns();
		tsRows = tssh.getRows();
		
		for (int i = 1; i< tsRows; i++){
			tcid = tssh.getCell(0, i).getContents();
			runFlag = tssh.getCell(1, i).getContents();
			tcDescription = tssh.getCell(2, i).getContents();
		
			testScenarios.put(tcid + " # " + tcDescription, runFlag);
			
		}
		
		tswb.close();
		
		/*
		for(Map.Entry tsindex:testScenarios.entrySet()){
			System.out.println("TC ID : " + tsindex.getKey() + " Run Flag: " + tsindex.getValue());
		}
		
		
		System.out.println("===============");
		
		for(String key: testScenarios.keySet()){
			System.out.println(key + " " + testScenarios.get(key));
		}*/
	} // End of Main Method

} // End of Class

