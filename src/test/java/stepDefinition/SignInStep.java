package stepDefinition;


import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

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
		//Logger log = Logger.getLogger(D3_Scripts.class.getName());
	//	ExcelReader TD = new ExcelReader("C://Users//E004373//Desktop//TestData//Driver.xlsx");
		ExcelReader TD = new ExcelReader("Driver.xlsx");
		ConfigReader con=new ConfigReader();
		
		
		//*********************  Input fields ***********************
		
		String UserName = TD.getCellData("TestData", "UserName",2).trim();
		String Passwrd = TD.getCellData("TestData", "Password",2).trim();
		String BUserName = TD.getCellData("TestData", "UserName",3).trim();
		String BPasswrd = TD.getCellData("TestData", "Password",3).trim();
	//	String Windowtitle= TD.getCellData("TestData", "title",3).trim();
		//String url=con.getApplicationUrl();
		String URL=con.getQAEnvironment();
		String path=con.getChromeDriverPath();
		
	
	//	SignInPage  SPage=new SignInPage(driver);
		
	
		
		
	@Given("^Launch Synovus Browser$")
	public void LaunchSynovusBrowser() throws InterruptedException  {
		//ac.openURL(URL);
		System.setProperty("webdriver.chrome.driver",path);
		driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //driver=new FirefoxDriver();
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
		//driver.get("https://www.facebook.com/");
		driver.get(URL);
	    }
		
 
	@Given("^Click on Personal option in primary menu$")
	public void clickOnPersonalMenu() throws Throwable {
		SignInPage SPage = new SignInPage(driver);
		Thread.sleep(2000);
		SPage.clickonPersonalSignInbutton();
	    //driver.findElement(PersonalMenu).click();
	//	ac.click(PersonalMenu,"Personal Menu Link");
	    Thread.sleep(5000);
	      }
	
	

	@Given("^Click on Login link at top right of the screen$")
	public void clickonLoginlink() throws Throwable {
		SignInPage SPage = new SignInPage(driver);
		Thread.sleep(2000);
		SPage.clickonloginlink();
		//driver.findElement(By.xpath("//*[@id='mainNavbar']/div[1]/div[3]/div/ul/li[4]/div/div/a")).click();
		//*[@id="mainNavbar"]/div[1]/div[3]/div/ul/li[4]/div/div/a
	    //driver.findElement(Loginlink).click();
		//ac.click(Loginlink,"Login link");
	    Thread.sleep(2000);
       	}

	@When("^Enter Valid UserName and Password$")
	public void EnterUserNameandPassword() throws Throwable  {
		Thread.sleep(2000);
       // driver.findElement(user_name).sendKeys(UserName);
	    Thread.sleep(2000);
	   // driver.findElement(Pass_WRD).sendKeys(Passwrd);
	    Thread.sleep(2000);
	   // driver.findElement(LoginButton).click();
	    Thread.sleep(2000);
        }

	@Then("^Verify user is able to login to the application from Personal page$")
	public void verifyHomePage() throws Throwable {
		Thread.sleep(2000);
	    driver.close();
	    //driver.findElement(Settings).isDisplayed();
	    Thread.sleep(5000);

	   	 }
	
	@Given("^Click on Buiness option in primary menu$")
	public void clickOnBusinessMenu() throws Throwable {
		Thread.sleep(2000);
	   // driver.findElement(BusinessMenu).click();
		//WebElement BusinessMenu1=driver.findElement(By.xpath("//*[@id='siteNavbar']/li[4]/a"));
		//ac.click(BusinessMenu,"Business Menu Link");
		SignInPage  SPage=new SignInPage(driver);
		SPage.clickonBusinessMenu();
	    Thread.sleep(5000);
	      }


	@When("^Enter Valid Business UserName and Password$")
	public void EnterBusinessUserNameandPassword() throws InterruptedException  {
		SignInPage  SPage=new SignInPage(driver);
		Thread.sleep(2000);
		SPage.EnterBusinessUserNameandPasswd(BUserName,BPasswrd);
       // driver.findElement(user_name).sendKeys(BUserName);
	    Thread.sleep(2000);
	   // driver.findElement(Pass_WRD).sendKeys(BPasswrd);
	   // driver.findElement(LoginButton).click();
	
        }
	
	
	
	@Then("^Verify user is able to login to the application from Business page$")
	public void verifyBusinessHomePage() throws Throwable {
		Thread.sleep(2000);
		 driver.close();
	   // driver.findElement(Settings).isDisplayed();
	    Thread.sleep(5000);
	   
	   	 }
	
}
