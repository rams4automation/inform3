package UtilFiles;


import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class HTMLReport {
	public static configurator config=new configurator("config.properties");	
	public static Map<String,String> sumMap = new HashMap<String,String>();
	//public static Map<String,String> detailMap = new HashMap<String,String>();
	public static  int pCount;
	public static  int fCount;
	public static String packageName = "";
	public static String tc_name = "";
	public static long startStepTime;
	public static long stepExecutionTime;
	public static long endStepTime;
	static String  reportfile = config.getProperty("ReportFile");
	public static File sfile = new File(reportfile+".html");//"Results.html"
	//public static File dfile = new File(Accessories.getFilePath() + "\\Detailed_Test_Results_" + Accessories.getTimeStamp() + ".html");//"Results.html"
	
	public void PrepareReport(){	
		try
		{             
			//sfile.createNewFile();
			if(sfile.exists()){
				sfile.delete();
				sfile.createNewFile();
			}
			FileWriter writer = new FileWriter(this.sfile,true);
			writer.write("<HTML>");
			writer.write("<HEAD>");
			writer.write("<BODY>");
			writer.write("<TABLE border=2 cellSpacing=1 cellPadding=1 width='100%'>");
			writer.write("<TR><TD>TestName</TD>");
			writer.write("<TD>TestDescrition</TD>");
			writer.write("<TD>Status</TD>");
			writer.write("<TD>Time</TD></TR>");
			writer.flush();
			writer.close();	

		}
		catch (Exception e)
		{
			e.getMessage();
		}
		
	}
	public static void OnTestSuccess(String strTestName, String strTestDes)
	{

		//Property configProps=new Property("config.properties");
		startStepTime = Accessories.currTimeStamp();

		//File f = new File(filePath);//"SummaryReport.html"
		try
		{
			FileWriter writer = new FileWriter(sfile,true);
			//PrintWriter w = new PrintW

			writer.write("<tr><TD width='300px'><FONT color=#153e7e size=1 face=Arial><B>" + strTestName
					+ " </b></td><TD width='600px'><FONT color=#153e7e size=1 face=Arial><B>" + strTestDes + "</B></td>"
					+ " </td><TD width='100px' bgcolor=green align=center><FONT color=white size=1 face=Arial><B>" + "Passed" + "</td></tr>");

			writer.flush();
			writer.close();			
			sumMap.put(strTestName + ":" + strTestDes, "PASS");
			endStepTime = System.currentTimeMillis(); //For Step End time			
			stepExecutionTime = (long) ((endStepTime - startStepTime) / 1000.000);	//For Step wise execution time	
			//writer.write("<TD align=center><FONT color=#153e7e size=1 face=Arial><B>" + stepExecutionTime + " secs" + "</B></FONT></TD>" + "</TR>");
		}
		catch (Exception e)
		{

		}
	}
	public static void OnTestFailure(String strTestName, String strTestDes)
	{
		startStepTime = Accessories.currTimeStamp();
		//		String filePath = Accessories.getFilePath()+"\\Results_"+Accessories.getTimeStamp()+".html";
		//		File f = new File(filePath);//"SummaryReport.html"
		try
		{
			FileWriter writer = new FileWriter(sfile,true);
			writer.write("<tr><TD width='300px'><FONT color=#153e7e size=1 face=Arial><B>" + strTestName
					+ " </b></td><TD width='600px'><FONT color=#153e7e size=1 face=Arial><B>" + strTestDes + "</B></td>"
					+ " </td><TD width='100px' bgcolor=red align=center><FONT color=white size=1 face=Arial><B><a href=" + strTestDes.replace(" ", "_").replace(":", "_") + "_" + Accessories.getTimeStamp() + ".jpeg>" + "Failed" + "</a></td></tr>");

			writer.flush();
			writer.close();
			sumMap.put(strTestName + ":" + strTestDes, "FAIL");
			endStepTime = System.currentTimeMillis();//.CurrentTimeMillis(); //For Step End time			
			stepExecutionTime = (long) ((endStepTime - startStepTime) / 1000.000);	//For Step wise execution time
			//writer.write("<TD align=center><FONT color=#153e7e size=1 face=Arial><B>" + stepExecutionTime + " secs" + "</B></FONT></TD>" + "</TR>");
		}
		catch (Exception e)
		{

		}
	}
	public static void endSummaryReport(){
		try{
			FileWriter writer=new FileWriter(sfile, true);
			writer.write("</TABLE>");
			writer.write("<TABLE border=2 cellSpacing=1 cellPadding=1 width='50%'>");						
			for(Map.Entry<String, String> entry : sumMap.entrySet()){            
				String value = entry.getValue();
				if (value.equals("PASS"))
				{
					pCount += 1;
				}
				else
				{
					fCount += 1;
				}                
			}
			writer.write("<TR><TD width='300px'><FONT color=#153e7e size=2 face=Arial>Passed Tests:</TD>");			
			writer.write("<TD bgcolor=green><B>"+pCount+"</B></TD></TR>");
			writer.write("<TR><TD width='300px'><FONT color=#153e7e size=2 face=Arial>Failed Tests:</TD>");			
			writer.write("<TD bgcolor=red><B>"+fCount+"</B></TD></TR>");
			writer.write("</TABLE></BODY></HEAD></HTML>");
			writer.flush();
			writer.close();
		}catch (Exception e){		

		}
	}


}
