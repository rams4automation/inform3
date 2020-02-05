package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Synovus.PageObjects.BasePage;
import com.Synovus.PageObjects.PlannedorderDistibutionPage;
import com.Synovus.PageObjects.SalesManagementPage;
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
        BasePage BPage;
        SalesManagementPage SMPage;
        PlannedorderDistibutionPage PDPage;
	

 	   ActionDriver ac=new ActionDriver();
 	   Logger logger = Logger.getLogger(SignInStep.class.getName());
 	   Logger log = Logger.getLogger(SignInStep.class.getName());
 	   HtmlReportSupport hs = new HtmlReportSupport();
 	   DecimalFormat df = new DecimalFormat("#.##");
 	   ExcelReader TD = new ExcelReader("Driver.xlsx");
 	   ConfigReader con=new ConfigReader();
 	   
        
  //############################# Start Test Data #####################################################
 	   
		String URL="https://mingle-portal.inforcloudsuite.com/GPACLLC_TRN";
		String path=con.getChromeDriverPath();
		
		
        String UserName = TD.getCellData("TestData", "UserName",2).trim();
		String Passwrd = TD.getCellData("TestData", "Password",2).trim();
		String towhsNumber= TD.getCellData("TestData", "ToWHSNumber",2).trim();
		String frmwhsNumber= TD.getCellData("TestData", "FrmWHSNumber",2).trim();
		String itemvalue= TD.getCellData("TestData", "ItemNumber",2).trim();
		String Ordertypeval=TD.getCellData("TestData", "OrderTypeValue",2).trim();
		String PlannedDelDate=TD.getCellData("TestData", "PlannedDelayDate",2).trim();
		String PlannedQty=TD.getCellData("TestData", "PlannedQtyval",2).trim();
		String Pickupval=TD.getCellData("TestData", "DeliveryPickupval",2).trim();
		
		//############################# End Test Data #####################################################	
		
		
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
		    inforPage.clickonAppMenu();
		    Thread.sleep(2000);
		    inforPage.clickoninform3();
		}
		
		@When("^Enter order details$")
		public void enter_order_details() throws Throwable {
			Thread.sleep(2000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_R);
			robot.delay(100);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(100);
			robot.keyRelease(KeyEvent.VK_R);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_D);
			robot.keyRelease(KeyEvent.VK_D);
			robot.keyPress(KeyEvent.VK_P);
			robot.keyRelease(KeyEvent.VK_P);
			robot.keyPress(KeyEvent.VK_S);
			robot.keyRelease(KeyEvent.VK_S);
			robot.keyPress(KeyEvent.VK_1);
			robot.keyRelease(KeyEvent.VK_1);
			robot.keyPress(KeyEvent.VK_7);
			robot.keyRelease(KeyEvent.VK_7);
			robot.keyPress(KeyEvent.VK_0);
			robot.keyRelease(KeyEvent.VK_0);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			PDPage = new PlannedorderDistibutionPage(driver);
			Thread.sleep(5000);
			PDPage.ClickonAction();
			Thread.sleep(2000);
		 }
			
			@When("^Enter towarehouse and frmwarehouse Details$")
			public void entertowarehouseandfrmwarehouseDetails() throws InterruptedException, AWTException {
				PDPage = new PlannedorderDistibutionPage(driver);
				PDPage.EntertowarehouseDetails(towhsNumber);
				Thread.sleep(2000);
				PDPage.EnterfrmwarehouseDetails(frmwhsNumber);
			}
			
			@When("^Enter itemNumber and OrderType Number Details$")
			public void enteritemNumberandOrderTypeNumberDetails() throws InterruptedException, AWTException   {
				PDPage = new PlannedorderDistibutionPage(driver);
				PDPage.EnteritemNumber(itemvalue);
				PDPage.OrderTypeNumber(Ordertypeval);
			}
			
			@When("^Enter Planned and Distribtion Details$")
			public void enterPlannedandDistribtion_Details() throws InterruptedException, AWTException  {
				PDPage = new PlannedorderDistibutionPage(driver);
				PDPage.PlannedDistribtionDetails(PlannedDelDate,PlannedQty,Pickupval);
				Thread.sleep(2000);
			}
			
			@Then("^Verify order is created$")
			public void verifyorderiscreated() throws InterruptedException, AWTException {
			   Thread.sleep(2000);
			   PDPage = new PlannedorderDistibutionPage(driver);
			   PDPage.ClickonSettings();
			}
			
		

}
