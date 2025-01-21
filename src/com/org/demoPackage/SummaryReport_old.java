package com.org.demoPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SummaryReport_old {

	public static void CreateReport() {
		
		try {
			String path = "/Results/" + CreateFolder.currentDate + "/" + CreateFolder.runDirName + "/SummaryReport.html";
			String reportPath = "/Results/" + CreateFolder.currentDate + "/" + CreateFolder.runDirName + "/";
			File summaryFilePath = new File(path);
			File individualPath = new File(reportPath);
			PrintWriter writer = new PrintWriter("./Results/" + CreateFolder.currentDate + "/" + CreateFolder.runDirName + "/SummaryReport.html");
			writer.println("<html>");
			writer.println("<head>");
			writer.println("<title>SummaryReport</title>");
			//chart.js line
			writer.println("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/0.2.0/Chart.min.js\" type=\"text/javascript\"></script>");
			writer.println("<style>table { border-collapse: collapse;} table, td, th { border: 1px solid blue;}</style>");
			writer.println("</head>");
			writer.println("<body>");
			//writer.println("<center>");
			writer.println("<h2>Summary Report</h2>");
			writer.println("<hr size=5 color=blue>");
			writer.println("<br>");
			
			writer.println("<table >");
			writer.println("<tr>");
			writer.println("<td>Execution Date: </td>");
			writer.println("<td>" + CreateFolder.currentDate + "</td>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<td>Time taken for execution: </td>");
			writer.println("<td>" + (Driver.endTime - Driver.startTime) / 1000 +" second(s)</td>");
			writer.println("</tr>");

			writer.println("</table>");
			writer.println("<br><br>");
			
			writer.println("<table >");
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
			writer.println("<td bgcolor=#ABEBC6>" + Driver.passPercentage + "%</td>");
			writer.println("<td bgcolor=#FD6214>" + Driver.failPercentage + "%</td>");
			writer.println("</tr>");
			
			writer.println("</table>");
			
			
			writer.println("<br><br>");
			writer.println("<table>");
			writer.println("<tr>");
			writer.println("<td bgcolor=#14C8FD width=75>#</td>");
			writer.println("<td bgcolor=#14C8FD>Test Case ID</td>");
			writer.println("<td bgcolor=#14C8FD>Status</td>");
			writer.println("<td bgcolor=#14C8FD>Execution Time</td>");
			writer.println("</tr>");
			int tcIndex = 1;
			//loop
			for(String j: Driver.testCaseStatusCollector.keySet()){
				//System.out.println(j + " " + Driver.testCaseStatusCollector.get(j));
				String [] tempStatus = Driver.testCaseStatusCollector.get(j).split(" # ");
				
				writer.println("<tr>");
				writer.println("<td>" + tcIndex + "</td>");
				tcIndex = tcIndex + 1;
				writer.println("<td>" + j + "</td>");
				if (tempStatus[0].trim().equalsIgnoreCase("FAIL")) {
					writer.println("<td bgcolor='#FD1414'><a href='" + j + ".html' target=_new>" + tempStatus[0].trim() + "</a></td>");
				}else{
					writer.println("<td bgcolor='#14FD26'><a href='" + j + ".html' target=_new>" + tempStatus[0].trim() + "</a></td>");
				}
				
				writer.println("<td>" + tempStatus[1].trim() + "</td>");
				writer.println("</tr>");
				
			}
			
			writer.println("</table>");
			
			
			
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

			
			//writer.println("</center>");
			writer.println("</body>");
			writer.println("</html>");
			writer.flush();
		} catch (FileNotFoundException e) {
			System.out.println("Something went wrong with Summary Report creation. Stopping the test.");
			System.exit(0);
		}

	}

}
