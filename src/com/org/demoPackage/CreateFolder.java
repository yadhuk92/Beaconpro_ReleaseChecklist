package com.org.demoPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class CreateFolder {
                
                public static Date date = new Date();
                public static DateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy");
                public static File dateDir = null;
                public static String currentDate = null;
                public static String runDirName = "Run_01";
                public static File sourceFile;
                public static File destFile;
                public static File resultsLink;
                
                
                
                

                public static void CreateResultsFolder() throws IOException {
                                
                                sourceFile = new File("./Misc/speridian_logo.png");

                                
                                currentDate  = getDate();
                                dateDir = new File("./Results/" + currentDate);
                                //String [] lastFolderName = null;
                                LinkedHashMap <Integer, String> lastFolderName = new LinkedHashMap <Integer, String>();
                                //int currentRunIndex = 0;
                                
                                if (dateDir.exists()){
                                
                                                
                                                File [] runFolderList = new File("./Results/" + currentDate).listFiles(File::isDirectory);
                                                
                                               //== ** == ** 
                                               if (runFolderList.length == 0) {
                                            	   
                                                   dateDir = new File(dateDir + "/" + runDirName);
                                                   dateDir.mkdir();
                                                   destFile = new File(dateDir + "/speridian_logo.png");
                                                   FileInputStream fileInputStream = new FileInputStream(sourceFile);
                                                   FileOutputStream fileOutputStream = new FileOutputStream(destFile);
                                                   int bufferSize;
                                                   byte[] bufffer = new byte[1024];
                                                      while ((bufferSize = fileInputStream.read(bufffer)) > 0) {
                                                      fileOutputStream.write(bufffer, 0, bufferSize);
                                                   }
                                                      
                                                   dateDir = new File("./Results/" + currentDate + "/" + runDirName + "/Screenshots");
                                                   dateDir.mkdir();
                                            	   
                                               }
                                               
                                               //== ** == **
                                               else {
                                                File tempRunDir = runFolderList[runFolderList.length-1];
                                                
                                                int value1 = Integer.valueOf((tempRunDir.getName().split("_"))[1]);
                                                String value2 = (tempRunDir.getName().split("_"))[0];
                                                
                                                lastFolderName.put(value1, value2 );
                                                
                                                //currentRunIndex = Integer.parseInt(lastFolderName[1].trim());
                                                //System.out.println(lastFolderName.size());
                                                String appender = "0";
                                                for (long key : lastFolderName.keySet()){
                                                				//System.out.println("Key number before: " + key);
                                                                key = key+1;
                                                                //System.out.println("Key number before: " + key);
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
                                }
                                                destFile = new File(dateDir + "/speridian_logo.png");
                                                FileInputStream fileInputStream = new FileInputStream(sourceFile);
                                                FileOutputStream fileOutputStream = new FileOutputStream(destFile);
                                                int bufferSize;
                                                byte[] bufffer = new byte[1024];
                                                   while ((bufferSize = fileInputStream.read(bufffer)) > 0) {
                                                   fileOutputStream.write(bufffer, 0, bufferSize);
                                                }
                                                
                                                dateDir = new File ("./Results/" + currentDate + "/" + runDirName + "/Screenshots");
                                                dateDir.mkdir();
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                }else{
                                                dateDir.mkdir();
                                                File [] runFolderList = new File("./Results/" + currentDate).listFiles(File::isDirectory);
                                                //System.out.println(runFolderList.length);
                                                if (runFolderList.length == 0) {
                                                                dateDir = new File(dateDir + "/" + runDirName);
                                                                dateDir.mkdir();
                                                                destFile = new File(dateDir + "/speridian_logo.png");
                                                                FileInputStream fileInputStream = new FileInputStream(sourceFile);
                                                                FileOutputStream fileOutputStream = new FileOutputStream(destFile);
                                                                int bufferSize;
                                                                byte[] bufffer = new byte[1024];
                                                                   while ((bufferSize = fileInputStream.read(bufffer)) > 0) {
                                                                   fileOutputStream.write(bufffer, 0, bufferSize);
                                                                }
                                                                   
                                                                dateDir = new File("./Results/" + currentDate + "/" + runDirName + "/Screenshots");
                                                                dateDir.mkdir();
                                                }
                                                
                                }
                                
                            PrintWriter writer2 = new PrintWriter("./Misc/currentResultsPath.txt");
                            writer2.write(currentDate + "\\" + runDirName);
                            writer2.flush();
                }
                
                public static String getDate(){
                                return dateFormat.format(date);
                }
                
                
}

