package com.org.demoPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class IndividualReport {

	public static int individualReportStepCounter = 1;
	public static void CreateReport(String key, String description) {
		
		try {
			//String path = "../Results/" + CreateFol/Screenshots/" + key + ".png";
			//ile filePath = new File(path);
			
			
			PrintWriter writer = new PrintWriter("./Results/" + CreateFolder.currentDate + "/" + CreateFolder.runDirName + "/" + key + ".html");
			writer.println("<html>");
			writer.println("<head>");
			writer.println("<title>Report for " + key + "</title>");
			writer.println("<style>table { border-collapse: collapse;} table, td, th { border: 1px solid blue; }</style>");
			
			writer.println("<style>");
			writer.println("#myBtn {display: none;  position: fixed;  bottom: 20px;  right: 30px;  z-index: 99;  border: none;  outline: none;  background-color: red;  color: white;  cursor: pointer;  padding: 15px;  border-radius: 10px;}");
			writer.println("#myBtn:hover {  background-color: #555;}");
			writer.println("#myClrBtn {display: none;  position: fixed;  bottom: 20px;  right: 90px;  z-index: 99;  border: none;  outline: none;  background-color: red;  color: white;  cursor: pointer;  padding: 15px;  border-radius: 10px;}");
			writer.println("#myClrBtn:hover {  background-color: #555;}");
			writer.println("#myClrBtn1 {display: none;  position: fixed;  bottom: 20px;  right: 210px;  z-index: 99;  border: none;  outline: none;  background-color: red;  color: white;  cursor: pointer;  padding: 15px;  border-radius: 10px;}");
			writer.println("#myClrBtn1:hover {  background-color: #555;}");

			writer.println("</style>");
			
			writer.println("</head>");
			writer.println("<body>");
			writer.println("<image src=\"speridian_logo.png\" height=50 width=120></image>");
			
			
			writer.println("<a href=\"about:blank\" target=\"lower_left\"><button  id=\"myClrBtn\" title=\"Clear Page\">Clear Results</button></a>");
			writer.println("<a href=\"about:blank\" target=\"lower_right\"><button  id=\"myClrBtn1\" title=\"Clear Image\">Clear Image</button></a>");
			writer.println("<button onclick=\"topFunction()\" id=\"myBtn\" title=\"Go to top\">Top</button>");
			
			writer.println("<center>");
			writer.println("<h3>"+ key + " : " + description);
			writer.println("<br>");
			writer.println("<hr size=5 color=blue>");
			writer.println("<br>");
			//writer.println("<table width=100% border= 1 bordercolor=#1462FD>");
			writer.println("<table width=100%>");
			writer.println("<tr>");
			writer.println("<td bgcolor=#14C8FD width=60>");
			writer.println("#");
			writer.println("</td>");
			writer.println("<td bgcolor=#14C8FD width=300>");
			writer.println("Step Description");
			writer.println("</td>");
			writer.println("<td bgcolor=#14C8FD>");
			writer.println("Status");
			writer.println("</td>");
			writer.println("<td bgcolor=#14C8FD>");
			writer.println("Comment");
			writer.println("</td>");
			writer.println("</tr>");
			
			// loop through the collector to print the data
			
			for(String j: Driver.individualTestCaseStepCollector.keySet()){
				
				writer.println("<tr>");
				writer.println("<td>");
				writer.println("" + individualReportStepCounter);
				individualReportStepCounter = individualReportStepCounter + 1;
				
				writer.println("</td>");
				writer.println("<td>");
				writer.println(j.split("#")[1]);
				writer.println("</td>");
				
				if (Driver.individualTestCaseStepCollector.get(j).contains("Fail # ")) {

					String [] tempStep = Driver.individualTestCaseStepCollector.get(j).split(" # ");
					writer.println("<td bgcolor='#FD1414'>");
					writer.println(tempStep[0].trim());
					writer.println("</td>");
					writer.println("<td>");
					//writer.println("<a href='" + filePath.getAbsolutePath() + "' target=_new><img src='" + filePath.getAbsolutePath() +"' height='50' width='120'></img></a><br>" + tempStep[1].trim());
					writer.println("<a href='../" + CreateFolder.runDirName + "/Screenshots/" +  key +  ".png' target=\"lower_right\"><img src='../" + CreateFolder.runDirName + "/Screenshots/" + key +".png' height='50' width='120'></img></a><br>" + tempStep[1].trim());
					writer.println("</td>");
				}else if (Driver.individualTestCaseStepCollector.get(j).contains("Pass # ")) {
					String [] tempStep = Driver.individualTestCaseStepCollector.get(j).split(" # ");
					writer.println("<td>");
					writer.println(tempStep[0]);
					writer.println("</td>");
					writer.println("<td>");
					writer.println(tempStep[1]);
					writer.println("</td>");
				}else{
					writer.println("<td>");
					writer.println(Driver.individualTestCaseStepCollector.get(j));
					writer.println("</td>");
					writer.println("<td>");
					writer.println("--");
					writer.println("</td>");
				}
				writer.println("</tr>");
				
			}
			
			
			writer.println("</table>");
			writer.println("</center>");
			
			writer.println("<script>");
			// When the user scrolls down 20px from the top of the document, show the button
			writer.println("window.onscroll = function() {scrollFunction()};");

			writer.println("function scrollFunction() {");
			writer.println("    if (document.body.scrollTop > 2 || document.documentElement.scrollTop > 2) {");
			writer.println("        document.getElementById(\"myBtn\").style.display = \"block\";");
			writer.println("        document.getElementById(\"myClrBtn\").style.display = \"block\";");
			writer.println("        document.getElementById(\"myClrBtn1\").style.display = \"block\";");
			writer.println("    } else {");
			writer.println("        document.getElementById(\"myBtn\").style.display = \"none\";");
			writer.println("        document.getElementById(\"myClrBtn\").style.display = \"none\";");
			writer.println("        document.getElementById(\"myClrBtn1\").style.display = \"none\";");
			writer.println("    }");
			writer.println("}");

			// When the user clicks on the button, scroll to the top of the document
			writer.println("function topFunction() {");
			writer.println("    document.body.scrollTop = 0;");
			writer.println("    document.documentElement.scrollTop = 0;");
			writer.println("}");
			

			
			writer.println("</script>");
			
			writer.println("</body>");
			writer.println("</html>");
			writer.flush();
			individualReportStepCounter = 1;
			
		} catch (FileNotFoundException e) {
			System.out.println("Something went wrong while creating individual report. Stoping the test.");
			System.exit(0);
		}
		

	}

}
