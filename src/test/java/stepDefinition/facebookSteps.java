package stepDefinition;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.Synovus.PageObjects.FBPage;
import com.Synovus.fileutils.ConfigReader;
import com.Synovus.fileutils.ExcelReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class facebookSteps {
         WebDriver driver;
         FBPage fPage;
         
       DecimalFormat df = new DecimalFormat("#.##");
  	   ExcelReader TD = new ExcelReader("Driver.xlsx");
  	   ConfigReader con=new ConfigReader();
  	   

		//*********************  Start Input fields ***********************
		
		String UserName = TD.getCellData("TestData", "UserName",2).trim();
		String Passwrd = TD.getCellData("TestData", "Password",2).trim();
		String URL="https://www.facebook.com/";
		String path=con.getChromeDriverPath();
		
		//*********************  End Input fields ***********************
		
		@Given("^Navigate to facebook url$")
		public void navigate_to_facebook_url() throws Throwable {
			System.setProperty("webdriver.chrome.driver",path);
			driver = new ChromeDriver(); 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.get(URL);
		    }
		
		
		@When("^Enter UserName and Password$")
		public void enter_UserName_and_Password() throws InterruptedException  {
			fPage=new FBPage(driver);
			Thread.sleep(2000);
			fPage.EnterValidUserNameandPWD(UserName, Passwrd);
			
		}
		
		@Then("^Verify the Home Page$")
		public void verify_the_Home_Page() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		}
		
		@When("^Enter invalid UserName and Password$")
		public void enter_invalid_UserName_and_Password() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		}
		
		@Then("^Verify the Error Message$")
		public void verify_the_Error_Message() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		}
	
		
		    
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
