package stepDefinition;


import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.Synovus.PageObjects.SignInPage;
import com.Synovus.accelerators.ActionDriver;
import com.Synovus.fileutils.ConfigReader;
import com.Synovus.fileutils.ExcelReader;
import UtilFiles.HtmlReportSupport;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SignInStep {
	 WebDriver driver;
	  
	   ActionDriver ac=new ActionDriver();
	   Logger logger = Logger.getLogger(SignInStep.class.getName());
	   Logger log = Logger.getLogger(SignInStep.class.getName());
	   HtmlReportSupport hs = new HtmlReportSupport();
	   DecimalFormat df = new DecimalFormat("#.##");
	   ExcelReader TD = new ExcelReader("Driver.xlsx");
	   ConfigReader con=new ConfigReader();
		
		
		//*********************  Start Input fields ***********************
		
		String UserName = TD.getCellData("TestData", "UserName",2).trim();
		String Passwrd = TD.getCellData("TestData", "Password",2).trim();
		String BUserName = TD.getCellData("TestData", "UserName",3).trim();
		String BPasswrd = TD.getCellData("TestData", "Password",3).trim();
		String URL=con.getQAEnvironment();
		String path=con.getChromeDriverPath();
		
		//*********************  End Input fields ***********************
		
		
		
		
		
	
		//*******************************  Start Main Test Case *******************************************
				
			@Given("^Launch Synovus Browser$")
			public void LaunchSynovusBrowser() throws InterruptedException  {
				System.setProperty("webdriver.chrome.driver",path);
				driver = new ChromeDriver(); 
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				Thread.sleep(2000);
				driver.get(URL);
			    }
				
		 
			@Given("^Click on Personal option in primary menu$")
			public void clickOnPersonalMenu() throws Throwable {
				SignInPage SPage = new SignInPage(driver);
				Thread.sleep(2000);
				SPage.clickonPersonalSignInbutton();
			    Thread.sleep(5000);
			      }
			
			
		
			@Given("^Click on Login link at top right of the screen$")
			public void clickonLoginlink() throws Throwable {
				SignInPage SPage = new SignInPage(driver);
				Thread.sleep(2000);
				SPage.clickonloginlink();
			    Thread.sleep(2000);
		       	}
		
			@When("^Enter Valid UserName and Password$")
			public void EnterUserNameandPassword() throws Throwable  {
				SignInPage SPage = new SignInPage(driver);
				Thread.sleep(2000);
				SPage.EnterPersonalUserNameandPasswd(UserName,Passwrd);
			    Thread.sleep(2000);
		        }
		
			@Then("^Verify user is able to login to the application from Personal page$")
			public void verifyHomePage() throws Throwable {
				Thread.sleep(2000);
			    driver.close();
			    Thread.sleep(5000);
		
			   	 }
			
			@Given("^Click on Buiness option in primary menu$")
			public void clickOnBusinessMenu() throws Throwable {
				Thread.sleep(2000);
				SignInPage  SPage=new SignInPage(driver);
				SPage.clickonBusinessMenu();
			    Thread.sleep(5000);
			      }
		
		
			@When("^Enter Valid Business UserName and Password$")
			public void EnterBusinessUserNameandPassword() throws InterruptedException  {
				SignInPage  SPage=new SignInPage(driver);
				Thread.sleep(2000);
				SPage.EnterBusinessUserNameandPasswd(BUserName,BPasswrd);
			    Thread.sleep(2000);
		        }
			
			
			@Then("^Verify user is able to login to the application from Business page$")
			public void verifyBusinessHomePage() throws Throwable {
				Thread.sleep(2000);
				driver.close();
			    Thread.sleep(5000);
			   
			   	 }
	
}
