package stepDefinition;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Synovus.PageObjects.inforLoginPage;
import com.Synovus.accelerators.ActionDriver;
import com.Synovus.fileutils.ConfigReader;
import com.Synovus.fileutils.ExcelReader;

import UtilFiles.HtmlReportSupport;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class inform3 {
        WebDriver driver;
        inforLoginPage inforPage;
	

 	   ActionDriver ac=new ActionDriver();
 	   Logger logger = Logger.getLogger(SignInStep.class.getName());
 	   Logger log = Logger.getLogger(SignInStep.class.getName());
 	   HtmlReportSupport hs = new HtmlReportSupport();
 	   DecimalFormat df = new DecimalFormat("#.##");
 	   ExcelReader TD = new ExcelReader("Driver.xlsx");
 	   ConfigReader con=new ConfigReader();
 	   
        
        String UserName = TD.getCellData("TestData", "UserName",2).trim();
		String Passwrd = TD.getCellData("TestData", "Password",2).trim();
		String URL="https://mingle-portal.inforcloudsuite.com/GPACLLC_TRN";
		String path=con.getChromeDriverPath();
		
		
		@Given("^Launch infor Application$")
		public void launchinforApplication() throws Throwable {
			System.setProperty("webdriver.chrome.driver",path);
			driver = new ChromeDriver(); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.get(URL);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='from1']/div/div[3]/a")).click();
		}
		
		@When("^Enter valid UaserName and Password$")
		public void enterUserNameandPassword() throws Throwable {
			inforPage = new inforLoginPage(driver);
			inforPage.EnterUserNameandPasswd(UserName, Passwrd);
			inforPage.clickonSignIn();
		}
		
		@When("^Verify user is able to login to the application$")
		public void VerifyHomePage() throws Throwable {
			inforPage = new inforLoginPage(driver);
		    inforPage.Verifytitle();
		}
		
		@Then("^Enter order details$")
		public void enter_order_details() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		}

}
