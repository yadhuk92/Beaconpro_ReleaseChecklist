package com.org.demoPackage;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class CreateFolder_Old {
	
	public static Date date = new Date();
	public static DateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy");
	public static File dateDir = null;
	public static String currentDate = null;
	public static String runDirName = "Run_01";
	
	
	
	

	public static void CreateResultsFolder() {
		
		
		currentDate  = getDate();
		dateDir = new File("./Results/" + currentDate);
		//String [] lastFolderName = null;
		LinkedHashMap <Integer, String> lastFolderName = new LinkedHashMap <Integer, String>();
		//int currentRunIndex = 0;
		
		if (dateDir.exists()){
		
			
			File [] runFolderList = new File("./Results/" + currentDate).listFiles(File::isDirectory);


			File tempRunDir = runFolderList[runFolderList.length-1];
			
			int value1 = Integer.valueOf((tempRunDir.getName().split("_"))[1]);
			String value2 = (tempRunDir.getName().split("_"))[0];
			
			lastFolderName.put(value1, value2 );
			
			//currentRunIndex = Integer.parseInt(lastFolderName[1].trim());
			//System.out.println(lastFolderName.size());
			String appender = "0";
			for (long key : lastFolderName.keySet()){
				key = key+1;
				if (String.valueOf(key).length() == 1) {
					runDirName = "Run_0" + key;
				}else{
					runDirName = "Run_" + key;
				}

				//System.out.println(key);
			}

			//currentRunIndex = currentRunIndex++;
			
			dateDir = new File ("./Results/" + currentDate + "/" + runDirName );
			dateDir.mkdir();
			dateDir = new File ("./Results/" + currentDate + "/" + runDirName + "/Screenshots");
			dateDir.mkdir();
			
			
			
			
			
			
			
		}else{
			dateDir.mkdir();
			File [] runFolderList = new File("./Results/" + currentDate).listFiles(File::isDirectory);
			//System.out.println(runFolderList.length);
			if (runFolderList.length == 0) {
				dateDir = new File(dateDir + "/" + runDirName);
				dateDir.mkdir();
				dateDir = new File("./Results/" + currentDate + "/" + runDirName + "/Screenshots");
				dateDir.mkdir();
			}
			
		}
		
		
	}
	
	public static String getDate(){
		return dateFormat.format(date);
	}
	
	
}
