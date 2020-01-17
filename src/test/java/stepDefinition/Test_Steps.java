package stepDefinition;


import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import UtilFiles.DataHelper;
import UtilFiles.ExcelReaderNew;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//https://learn2seleniumwithvishwas.wordpress.com/2017/03/08/selenium-framework-data-driven-testing-with-cucumber/

public class Test_Steps{
	 WebDriver driver;
	 
	public List <HashMap<String,String>> dataSet;
	 
	
	@Given("^I have open the browser$")
	public void i_have_open_the_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //driver=new FirefoxDriver();
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
		 dataSet = DataHelper.readExcelDatafromFile("C://Users//E004373//Desktop//Selenium_Questions//Estimations_Selenium.xlsx", "Sheet1");
		// l.loginToSunView(dataSet.get(dataRow).get("customerID"), dataSet.get(dataRow).get("userID5x"), dataSet.get(dataRow).get("password5x_SunView"));		 
    	}
	
	
	@When("^I open Synovus website$")
	public void i_open_Synovus_website() throws Throwable {
		//driver.get("https://www.facebook.com/");
		driver.get("https://qa.synovus.com/");
	}
	
	@Then("^Login button should exits$")
	public void login_button_should_exits() throws Throwable {
		if(driver.findElement(By.xpath("//*[@id='siteNavbar']/li[3]/a")).isDisplayed()){ 
	         System.out.println("Personal Drop down is displayed"); 
	      } else { 
	         System.out.println("Personal Drop down is not displayed"); 
	      } 
		 Thread.sleep(2000);
	      driver.close(); 
	   } 
	
	
		@When("^Enter UserName and Password$")
		public void enter_UserName_and_Password() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		  
		}
		
		@When("^Click on Submit Button$")
		public void click_on_Submit_Button() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		  
		}
		
		@Then("^Verify the user can able to login$")
		public void verify_the_user_can_able_to_login() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		   
		}

	

	
	
}


