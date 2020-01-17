package com.Synovus.accelerators;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import UtilFiles.Accessories;
import UtilFiles.HTMLReport;
import UtilFiles.HtmlReportSupport;
import UtilFiles.MyListener;
import UtilFiles.ReportStampSupport;
import UtilFiles.configurator;



public class Configurations {
	public configurator config=new configurator("config.properties");	
	HtmlReportSupport hs = new HtmlReportSupport();
	HTMLReport HR = new HTMLReport();
	Logger logger = Logger.getLogger(Configurations.class.getName());
	public static WebDriver driver;
	public String currentSuite = "";
	public String method = "";
	//public static String timeStamp = ReportStampSupport.timeStamp().replace(" ", "_").replace(":", "_").replace(".", "_");
	public boolean flag = false;
	//public WebDriver webDriver = null;
	public EventFiringWebDriver webdriver=null;
	public DesiredCapabilities capabilities;
	public  int stepNum = 0;
	public  int PassNum =0;
	public  int FailNum =0;
	public String testName = "";
	public String testCaseExecutionTime = "";
	public StringBuffer x=new StringBuffer();
	public String finalTime = "";
	public boolean isSuiteRunning=false;
	public static Map<String, String> testDescription = new LinkedHashMap<String, String>();
	public static Map<String, String> testResults = new LinkedHashMap<String, String>();
	public String url=config.getProperty("URL");
	public int countcompare = 0;

	public static String browser = null;
	static int len = 0;
	static int i = 0;
	public static ITestContext itc;
	public static String groupNames =null;
	public int failCount=0;
	public int passCount=0;
	
	@BeforeSuite(alwaysRun=true)
	public void suiteFirst(ITestContext ctx) throws Throwable{
		
		itc=ctx;
		Configurations.cleanUP();
		createLog();
		PropertyConfigurator.configure("log4j.properties");
		ReportStampSupport.calculateSuiteStartTime();

	}
	@BeforeTest(alwaysRun=true)
	public void first(ITestContext ctx) throws Throwable{

		itc=ctx;

	}
	@Parameters({"browser"})
	@BeforeClass(alwaysRun=true)
	public void first(ITestContext ctx, String browser) throws Throwable{
		itc=ctx;
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\E004439\\eclipse\\current16\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			i=i+1;
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			//File file = new File("Drivers/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
		    driver = new InternetExplorerDriver(capabilities);
//			driver= new InternetExplorerDriver();
			i=i+1;
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");				
			driver=new ChromeDriver();
			i=i+1;

		}
		webdriver = new EventFiringWebDriver(driver);
		//System.out.println("url opened"+url);
		MyListener myListener = new MyListener();
		webdriver.register(myListener);

		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			if(browser.equalsIgnoreCase("Firefox") || browser.equalsIgnoreCase("IE") || browser.equalsIgnoreCase("Chrome"))
			{
				driver.manage().window().maximize();
			}

			hs.currentSuit = ctx.getCurrentXmlTest().getSuite().getName();
		} catch (Exception e1) {
			System.out.println(e1);
		}

	}
	@Parameters({"browser"})
	@AfterTest(alwaysRun=true)
	public void first1(ITestContext ctx, String browser) throws Throwable{
		itc=ctx;			

		HtmlReportSupport.createHtmlSummaryReport(browser, url);
		ReportStampSupport.calculateSuiteExecutionTime();
		closeSummaryReport(browser);
	}

	//rename tearDownFirefox to tearDownBrowser
	@Parameters({"browser"})
	@AfterSuite(alwaysRun = true)
	public void tearDownFirefox(ITestContext ctx, String browser) throws Throwable {
		copyLog();
	}
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun = true)
	public void reportHeader(Method method, ITestContext ctx, String browser) throws Throwable {
		itc = ctx;

		
		calculateTestCaseStartTime();

		flag = false;

		hs.tc_name = method.getName().toString() + "-" + browser;
		String[] ts_Name = this.getClass().getName().toString().split("\\.");
		hs.packageName = ts_Name[0] + "." + ts_Name[1] + "."+ ts_Name[2];


		hs.testHeader(hs.tc_name);

		stepNum = 0;
		PassNum = 0;
		FailNum = 0;
		testName = method.getName();
		String[] tmp=testName.split("_");
		
		String desc = testName.replaceAll("_", " ")+" Script";
		testDescription.put(testName+ "-" + browser, desc);

	}
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		calculateTestCaseExecutionTime();
		closeDetailedReport(browser);
		//System.out.println("browser :"+hs.strTestName);
		String[] test=hs.strTestName.split("-");
		int stringlength=test.length;
		String currentBrwoser=test[1];   
		
		if(FailNum!=0)
		{
			testResults.put(hs.tc_name, "FAIL");
			System.out.println("current Browser:"+currentBrwoser);
			this.failCount++;
		}

		else if(PassNum!=0)
		{
			testResults.put(hs.tc_name, "PASS");
			this.passCount++;
		}

	
	}


	@Parameters({"browser"})
	@AfterClass(alwaysRun=true)
	public void close(String browser){
		try{
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void calculateTestCaseStartTime(){			
		hs.iStartTime = System.currentTimeMillis();
	}


	/***
	 * 		This method is supposed to be used in the @AfterMethod to calculate the total test case execution time 
	 * to show in Reports by taking the start time from the calculateTestCaseStartTime method.
	 */
	public void calculateTestCaseExecutionTime(){	
		hs.iEndTime = System.currentTimeMillis();
		hs.iExecutionTime=(hs.iEndTime-hs.iStartTime);
		TimeUnit.MILLISECONDS.toSeconds(hs.iExecutionTime);
		HtmlReportSupport.executionTime.put(hs.tc_name,String.valueOf(TimeUnit.MILLISECONDS.toSeconds(hs.iExecutionTime)));
	}


	public void onSuccess(String strStepName, String strStepDes) {


		//String fileName= strTestName;
		hs.strTestName=hs.strTestName.replaceAll("_", " ");	
		File file = new File("Results/HTML/" + hs.strTestName+"_Results"
				+ ".html");// "SummaryReport.html"
		Writer writer = null;
		stepNum = stepNum + 1;

		try {
			//testdescrption.put(TestTitleDetails.x.toString(), TestEngine.testDescription.get(TestTitleDetails.x));
			if (!hs.map.get(hs.packageName + ":" + hs.tc_name).equals("FAIL")) {
				hs.map.put(hs.packageName + ":" + hs.tc_name, "PASS");
				//map.put(TestTitleDetails.x.toString(), TestEngine.testDescription.get(TestTitleDetails.x.toString()));
			}
			writer = new FileWriter(file, true);
			writer.write("<tr class='content2' >");
			writer.write("<td>" + stepNum + "</td> ");
			writer.write("<td class='justified'>" + strStepName + "</td>");
			writer.write("<td class='justified'>" + strStepDes + "</td> ");
			writer.write("<td class='Pass' align='center'><img  src='./Screenshots/passed.ico' width='18' height='18'/></td> ");
			PassNum  =PassNum + 1;
			String strPassTime = ReportStampSupport.getTime();
			writer.write("<td><small>" + strPassTime + "</small></td> ");
			writer.write("</tr> ");
			writer.close();

		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void onWarning(String strStepName, String strStepDes) {
		Writer writer = null;
		try {
			//String fileName= strTestName;
			hs.strTestName=hs.strTestName.replaceAll("_", " ");	

			File file = new File("Results/HTML/" + hs.strTestName+"_Results"
					+ ".html");// "SummaryReport.html"

			writer = new FileWriter(file, true);
			stepNum = stepNum + 1;

			writer.write("<tr class='content2' >");
			writer.write("<td>" + stepNum + "</td> ");
			writer.write("<td class='justified'>" + strStepName + "</td>");
			writer.write("<td class='justified'>" + strStepDes + "</td> ");
			FailNum = FailNum + 1;


			writer.write("<td class='Fail'  align='center'><a  href='"+"./Screenshots"+"/"
					+ strStepDes.replaceAll("[^\\w]", "_")
					+ ".jpeg'"+" alt= Screenshot  width= 15 height=15 style='text-decoration:none;'><img src='./Screenshots/warning.ico' width='18' height='18'/></a></td>");

			String strFailTime = ReportStampSupport.getTime();
			writer.write("<td><small>" + strFailTime + "</small></td> ");
			writer.write("</tr> ");
			writer.close();

		} catch (Exception e) {

		}

	}
	
	public static void cleanUP() throws IOException {		

		FileUtils.deleteDirectory(new File("Results/HTML"));
		new File("Results/HTML/Screenshots").mkdirs();		
		HtmlReportSupport.copyLogos();
		

	}
	/**
	 * Creates Log file with current time stamp
	 */
	public void copyLog(){
		File f = new File("Results/logging.log");
		File r = new File("LogFolder/logging_"+Accessories.getTimeStamp()+".log");
		try{
			if(r.exists()){	
				Files.copy(f, r);
			}else{
				r.createNewFile();
				Files.copy(f, r);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * Create log file
	 */

	public void createLog(){
		File f = new File("Results/logging.log");		
		try{
			if(f.exists()){	
				f.delete();				
				f.createNewFile();
			}else{				
				f.createNewFile();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/*
	 * 
	 * 
	 */
	public void onFailure(String strStepName, String strStepDes, String stepExecTime) {
		Writer writer = null;
		try {
			//String fileName= strTestName;
			hs.strTestName=hs.strTestName.replaceAll("_", " ");			
			File file = new File("Results/HTML/" + hs.strTestName+"_Results"
					+ ".html");// "SummaryReport.html"

			writer = new FileWriter(file, true);
			stepNum = stepNum + 1;

			writer.write("<tr class='content2' >");
			writer.write("<td>" + stepNum + "</td> ");
			writer.write("<td class='justified'>" + strStepName + "</td>");
			writer.write("<td class='justified'>" + strStepDes + "</td> ");
			FailNum = FailNum + 1;


			writer.write("<td class='Fail' align='center'><a  href='"+"./Screenshots"+"/"
			//writer.write("<td class='Fail' align='center'><a  href='Results/HTML/Screenshots"+"/"
					+ strStepDes.replaceAll("[^\\w]", "_")
					+ stepExecTime +".jpeg'"+" alt= Screenshot  width= 15 height=15 style='text-decoration:none;'><img  src='./Screenshots/failed.ico' width='18' height='18'/></a></td>");

			String strFailTime = ReportStampSupport.getTime();
			writer.write("<td><small>" + strFailTime + "</small></td> ");
			writer.write("</tr> ");
			writer.close();
			if (!hs.map.get(hs.packageName + ":" + hs.tc_name).equals("PASS")) {
				hs.map.put(hs.packageName + ":" + hs.tc_name+":", "FAIL");
				//map.put(TestTitleDetails.x.toString(), TestEngine.testDescription.get(TestTitleDetails.x.toString()));
			}
		} catch (Exception e) {

		}

	}

	public void closeDetailedReport(String browser) {

		//String fileName= strTestName;
		hs.strTestName=hs.strTestName.replaceAll("_", " ");	
		File file = new File("Results/HTML/" + hs.strTestName+"_Results"
				+ ".html");// "SummaryReport.html"
		Writer writer = null;

		try {
			writer = new FileWriter(file, true);
			writer.write("</table>");
			writer.write("<table id='footer'>");
			writer.write("<colgroup>");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("</colgroup>");
			writer.write("<tfoot>");
			writer.write("<tr class='heading'> ");
			writer.write("<th colspan='4'>Execution Time In Seconds (Includes Report Creation Time) : "
					+ hs.executionTime.get(hs.tc_name)+ "&nbsp;</th> ");
			writer.write("</tr> ");
			writer.write("<tr class='content'>");
			writer.write("<td class='pass'>&nbsp;Steps Passed&nbsp;:</td>");
			writer.write("<td class='pass'> " + PassNum	+ "</td>");
			writer.write("<td class='fail'>&nbsp;Steps Failed&nbsp;: </td>");
			writer.write("<td class='fail'>" + FailNum	+ "</td>");
			writer.write("</tr>");
			writer.close();			

		} catch (Exception e) {

		}
	}

	public void closeSummaryReport(String browser) {	
		File file = new File("Results/HTML/" + "SummaryResults_"+browser+".html");// "SummaryReport.html"
		Writer writer = null;
		try {
			writer = new FileWriter(file, true);

			writer.write("<table id='footer'>");
			writer.write("<colgroup>");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' /> ");
			writer.write("</colgroup> ");
			writer.write("<tfoot>");
			writer.write("<tr class='heading'>");
			writer.write("<th colspan='4'>Total Duration  In Minutes (Including Report Creation) : "
					+ (hs.iSuiteExecutionTime) + "</th>");
			writer.write("</tr>");
			writer.write("<tr class='content'>");
			writer.write("<td class='pass'>&nbsp;Tests Passed&nbsp;:</td>");
			writer.write("<td class='pass'> " + passCount
					+ "</td> ");
			writer.write("<td class='fail'>&nbsp;Tests Failed&nbsp;:</td>");
			writer.write("<td class='fail'> " + failCount
					+ "</td> ");
			writer.write("</tr>");
			writer.write("</tfoot>");
			writer.write("</table> ");

			writer.close();
		} catch (Exception e) {

		}
	}




}
