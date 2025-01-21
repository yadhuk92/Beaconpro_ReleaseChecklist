package com.org.demoPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SummaryReport {

	public static void CreateReport() {
		
		try {
			String mainResultsPath = "/Results/" + CreateFolder.currentDate + "/" + CreateFolder.runDirName + "/main.html";
			String path = "/Results/" + CreateFolder.currentDate + "/" + CreateFolder.runDirName + "/SummaryReport.html";
			String reportPath = "/Results/" + CreateFolder.currentDate + "/" + CreateFolder.runDirName + "/";
			
			PrintWriter writer2 = new  PrintWriter("./Results/" + CreateFolder.currentDate + "/" + CreateFolder.runDirName + "/frame2.html");
			writer2.println("<html>");
			writer2.println("<head></head>");
			writer2.println("<body>");
			writer2.println("Please select a test case from the left to view it's results.");
			writer2.println("</body>");
			writer2.println("</html>");
			writer2.flush();
			
			PrintWriter writer3 = new  PrintWriter("./Results/" + CreateFolder.currentDate + "/" + CreateFolder.runDirName + "/frame3.html");
			writer3.println("<html>");
			writer3.println("<head></head>");
			writer3.println("<body>");
			writer3.println("Please click the image from above test case results to have enlarged view here.");
			writer3.println("</body>");
			writer3.println("</html>");
			writer3.flush();
			
			
			File mainResultsFile = new File(mainResultsPath);
			PrintWriter writer1 = new  PrintWriter("./Results/" + CreateFolder.currentDate + "/" + CreateFolder.runDirName + "/main.html");
			writer1.println("<!DOCTYPE html>");
			writer1.println("</html>");
			writer1.println("<frameset Cols=\"50%,50%\">");
			writer1.println("<frame name=\"upper\" src=\"SummaryReport.html\">");
			writer1.println("<frameset rows=\"70%,30%\">");
			writer1.println("<frame name=\"lower_left\" src=\"frame2.html\">");
			writer1.println("<frame name=\"lower_right\" src=\"frame3.html\">");
			writer1.println("</frameset>");
			writer1.println("<frame name=\"lower\">");
			writer1.println("</frameset>");
			writer1.println("</html>");
			writer1.flush();
			
			
			
			
			File summaryFilePath = new File(path);
			File individualPath = new File(reportPath);
			PrintWriter writer = new PrintWriter("./Results/" + CreateFolder.currentDate + "/" + CreateFolder.runDirName + "/SummaryReport.html");
			writer.println("<html>");
			writer.println("<head>");
			writer.println("<title>SummaryReport</title>");
			writer.println("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/0.2.0/Chart.min.js\" type=\"text/javascript\"></script>");
			//writer.println("<style>table.table { border-collapse: collapse;} table, td, th { border: 1px solid black;}</style>");
			writer.println("<style>#table1 td{ border: 1px solid black;} </style>");
			//writer.println("<style>table.table2 { border-collapse: collapse;} table, td, tr, th { border: none;}</style>");
			writer.println("<style>#table2 { border: none;} </style>");
			writer.println("<html><head><title>Summary Report</title></head><style>body { margin-left: 1cm; margin-right: 1cm;}</style><body>");
			
			writer.println("<style>");
			writer.println("#myBtn {display: none;  position: fixed;  bottom: 20px;  right: 30px;  z-index: 99;  border: none;  outline: none;  background-color: red;  color: white;  cursor: pointer;  padding: 15px;  border-radius: 10px;}");
			writer.println("#myBtn:hover {  background-color: #555;}");
			writer.println("</style>");
			
			writer.println("</head>");
			
			writer.println("<body>");
			//writer.println("<center>");
			writer.println("<image src=\"speridian_logo.png\" height=50 width=120></image>");
			writer.println("<hr size=10 color=#14C8FD>");
			writer.println("<h3 align=center>Summary Report</h3>");
			writer.println("<br>");
			
			
			writer.println("<button onclick=\"topFunction()\" id=\"myBtn\" title=\"Go to top\">Top</button>");
			
			writer.println("Legend:");
			writer.println("<table id=\"table2\">");
			writer.println("<tr><td>Pass Percentage</td><td bgcolor=Green width=40></td><td>" + Math.round(Driver.passPercentage*100.0)/100.0 + "%</td></tr>");
			writer.println("<tr><td>Fail Percentage</td><td bgcolor=Red width=40></td><td>" + Math.round(Driver.failPercentage * 100.0)/100.0  + "%</td></tr>");
			writer.println("</table> &nbsp;");
			writer.println("<canvas id=\"countries\" width=\"300\" height=\"200\"></canvas>");
			writer.println("<script>");
			writer.println("var pieData = [");
			writer.println("{");
			writer.println("value: " + (Driver.totalPassed/Driver.totalExecuted)*100 + ",");
			writer.println("color: \"Green\",");
			writer.println("label: \"Pass Percentage\",");
			writer.println("highlight: \"lightgreen\"");
			writer.println("},");
			writer.println("{");
			writer.println("value : " + (Driver.totalFailed/Driver.totalExecuted)* 100 + ",");
			writer.println("color : \"Red\",");
			writer.println("label: \"Fail Percentage\",");
			writer.println("highlight: \"lightred\"");
			writer.println("}");
			writer.println("];");
			writer.println("var countries= document.getElementById(\"countries\").getContext(\"2d\");");
			writer.println("new Chart(countries).Pie(pieData);");
			writer.println("</script>");
			
			writer.println("<table width=100% id=\"table2\">");
			writer.println("<tr>");
			writer.println("<td>Execution Date: </td>");
			writer.println("<td>" + CreateFolder.currentDate + "</td>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<td>Time taken for execution: </td>");
			writer.println("<td>" + (Driver.endTime - Driver.startTime) / 1000 +" second(s)</td></tr>");
			String browserUsed = null;
			
			if (InitiateSelenium.browserType.equalsIgnoreCase("FF")) {
				browserUsed = "Mozilla Firefox";
			}else if (InitiateSelenium.browserType.equalsIgnoreCase("CR")) {
				browserUsed = "Google Chrome";
			}else if (InitiateSelenium.browserType.equalsIgnoreCase("IE")) {
				browserUsed = "Microsoft Internet Explorer";
			}else if (InitiateSelenium.browserType.equalsIgnoreCase("NULL")) {
				browserUsed = "Test was not executed";
			}
			
			writer.println("<tr><td>Browser Used: </td>");
			writer.println("<td>"  + browserUsed + "</td></tr>");
			writer.println("<tr><td>URL used:</td>");
			if (InitiateSelenium.url == null) {
				InitiateSelenium.url = "Test was not executed";
			}
			writer.println("<td>"  + InitiateSelenium.url + "</td>");
			writer.println("</tr>");

			writer.println("</table>");
			writer.println("<br><br>");
			
			writer.println("<table width=100% id=\"table1\">");
			writer.println("<tr>");
			writer.println("<td bgcolor=#14C8FD>Total Executed</td>");
			writer.println("<td bgcolor=#14C8FD>Total Passed</td>");
			writer.println("<td bgcolor=#14C8FD>Total Failed</td>");
			writer.println("<td bgcolor=#14C8FD>Pass Percentage</td>");
			writer.println("<td bgcolor=#14C8FD>Fail Percentage</td>");
			writer.println("</tr>");
			
			writer.println("<tr>");
			writer.println("<td>" + Driver.totalExecuted + "</td>");
			writer.println("<td bgcolor=#ABEBC6>" + Driver.totalPassed + "</td>");
			writer.println("<td bgcolor=#FD6214>" + Driver.totalFailed + "</td>");
			writer.println("<td bgcolor=#ABEBC6>" + Math.round(Driver.passPercentage * 100.0)/100.0 + "%</td>");
			writer.println("<td bgcolor=#FD6214>" + Math.round(Driver.failPercentage  * 100.0)/100.0 + "%</td>");
			writer.println("</tr>");
			
			writer.println("</table>");
			
			
			writer.println("<br><br>");
			writer.println("<table width=100% id=\"table1\">");
			writer.println("<tr>");
			writer.println("<td bgcolor=#14C8FD width=75>#</td>");
			writer.println("<td bgcolor=#14C8FD>Test Case ID</td>");
			writer.println("<td bgcolor=#14C8FD>Test Case Description</td>");
			writer.println("<td bgcolor=#14C8FD>Status</td>");
			writer.println("<td bgcolor=#14C8FD>Execution Time</td>");
			writer.println("</tr>");
			int tcIndex = 1;
			//loop
			for(String j: Driver.testCaseStatusCollector.keySet()){
				//System.out.println(j + " " + Driver.testCaseStatusCollector.get(j));
				String [] tempStatus = Driver.testCaseStatusCollector.get(j).split(" # ");
				
				//String [] tempTcDetails = j.split(" @ ");
				
				writer.println("<tr>");
				writer.println("<td>" + tcIndex + "</td>");
				tcIndex = tcIndex + 1;
				writer.println("<td>" + j.split(" @ ")[0].trim() + "</td>");
				writer.println("<td>" + j.split(" @ ")[1].trim() + "</td>");

				
				if (tempStatus[0].trim().equalsIgnoreCase("FAIL")) {
					writer.println("<td bgcolor='#FD1414'><a href='" + j.split(" @ ")[0].trim() + ".html' target=\"lower_left\">" + tempStatus[0].trim() + "</a></td>");
				}else{
					writer.println("<td bgcolor='#14FD26'><a href='" + j.split(" @ ")[0].trim() + ".html' target=\"lower_left\">" + tempStatus[0].trim() + "</a></td>");
				}
				
				
				writer.println("<td>" + tempStatus[1].trim() + "</td>");
				writer.println("</tr>");
				
			}
			
			writer.println("</table>");
			writer.println("<br>");
			
			writer.println("<hr size=10 color=#14C8FD>");
			writer.println("<br>");
			/*writer.println("Legend:");
			writer.println("<table id=\"table2\">");
			writer.println("<tr><td>Pass Percentage</td><td bgcolor=Green width=40></td><td>" + Driver.passPercentage + "%</td></tr>");
			writer.println("<tr><td>Fail Percentage</td><td bgcolor=Red width=40></td><td>" + Driver.failPercentage  + "%</td></tr>");
			writer.println("</table>");
			*/
			//writer.println("<br>");


			
			/*writer.println("<canvas id=\"countries\" width=\"300\" height=\"200\"></canvas>");
			writer.println("<script>");
			writer.println("var pieData = [");
			writer.println("{");
			writer.println("value: " + (Driver.totalPassed/Driver.totalExecuted)*100 + ",");
			writer.println("color: \"Green\",");
			writer.println("label: \"Pass Percentage\",");
			writer.println("highlight: \"lightgreen\"");
			writer.println("},");
			writer.println("{");
			writer.println("value : " + (Driver.totalFailed/Driver.totalExecuted)* 100 + ",");
			writer.println("color : \"Red\",");
			writer.println("label: \"Fail Percentage\",");
			writer.println("highlight: \"lightred\"");
			writer.println("}");
			writer.println("];");
			writer.println("var countries= document.getElementById(\"countries\").getContext(\"2d\");");
			writer.println("new Chart(countries).Pie(pieData);");
			writer.println("</script>");
			*/
			
			
			//writer.println("</center>");
			
			
			writer.println("<script>");
			// When the user scrolls down 20px from the top of the document, show the button
			writer.println("window.onscroll = function() {scrollFunction()};");

			writer.println("function scrollFunction() {");
			writer.println("    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {");
			writer.println("        document.getElementById(\"myBtn\").style.display = \"block\";");
			writer.println("    } else {");
			writer.println("        document.getElementById(\"myBtn\").style.display = \"none\";");
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
		} catch (FileNotFoundException e) {
			System.out.println("Something went wrong with Summary Report creation. Stopping the test.");
			System.exit(0);
		}

	}

}
