package com.org.demoPackage;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jxl.*;
import jxl.read.biff.BiffException;

public class ObjectRepository {
	
	//public static String orFile = "C:/Users/ravikiran.vallepu/Desktop/orsample.xls";
	public static String orFile = "./ObjectRepository/orsample.xls";
	public static int orColumns = 0;
	public static int orRows = 0;
	public static String objectName = null;
	public static String locatorType = null;
	public static String propertyValue = null;
	public static Map<String, String> objectRepository = new HashMap<String, String>();

	public static void readObjectRepository() throws BiffException, IOException {
		//Map<String, String> objectRepository = new HashMap<String, String>();
		
		
	
		//code to read data from excel file
		
		Workbook orwb = Workbook.getWorkbook(new File(orFile));
		Sheet orsh = orwb.getSheet(0);
		orColumns = orsh.getColumns();
		orRows = orsh.getRows();
		
		for (int i= 1; i< orRows; i++){
			
				objectName = orsh.getCell(0,i).getContents();
				locatorType = orsh.getCell(1,i).getContents();
				propertyValue = orsh.getCell(2,i).getContents();
				objectRepository.put(objectName, locatorType + " # " + propertyValue);
			
		}
		
		
		
		
		orwb.close();
		
		/*System.out.println("Number of Records in Object Repository: " + objectRepository.size());
		
		String orTemp [] = objectRepository.get("Scheduling").split("#");
		
		System.out.println(orTemp[0].trim());
		System.out.println(orTemp[1].trim());
		
		*/
		
		
	}

}
