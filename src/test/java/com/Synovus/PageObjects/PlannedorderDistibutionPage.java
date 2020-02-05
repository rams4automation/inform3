package com.Synovus.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlannedorderDistibutionPage {
              WebDriver driver;
	
	
	

 			 @FindBy(xpath="//*[@id='cmdText']")
 			 WebElement SearchandStart;
 			 
 			@FindBy(xpath=".//*[@id='ActionsBtn']")
			 WebElement ActionBtn;
 			
 			@FindBy(xpath="//*[@id='host_0_ActionsMenumb_1580887125470']/li[8]/a")
			 WebElement CPDO;
 			
 			@FindBy(xpath="//*[@id='W1TWHLContainer']/button/span")
			 WebElement towarehouse;
 			
 			@FindBy(xpath="//*[@id='POS']")
			 WebElement inputtowherehouse;
 			
 			@FindBy(xpath="//*[@id='R1']/div[1]")
			 WebElement Selecttowherehouse;
 			
 			@FindBy(xpath="//*[@id='BTN_L52T24']")
			 WebElement BtnSelect;
 			
 			@FindBy(xpath="//*[@id='W1FWHLContainer']/button/span")
			 WebElement frmwarehouse;
	
 			@FindBy(xpath="//*[@id='W1ITNOContainer']/button/span")
			 WebElement itemNumber;
 			
 			@FindBy(xpath="//*[@id='W1ORTYContainer']/button/span")
			 WebElement OrderType;
 			
 			@FindBy(xpath="//*[@id='Next']")
			 WebElement BtnNext;
 			
 			@FindBy(xpath="//*[@id='WEDLDT']")
			 WebElement PlannedDelaydt;
			
 			@FindBy(xpath="//*[@id='WEPPQT']")
			 WebElement Planqty;
			
 			@FindBy(xpath="//*[@id='WEMODLContainer']/button/span")
			 WebElement DeliveryMethod;
			
 			
	
 			public PlannedorderDistibutionPage(WebDriver driver) {
			    this.driver=driver;
				PageFactory.initElements(driver, this);
			 }
		
 			
 		// #########################################  Methods ##############################################
 			
	 			
	 		public void EnterCtrlR() throws InterruptedException, AWTException{
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
	 		}
	 		
			public void ClickEnter() throws InterruptedException, AWTException{
			    Thread.sleep(2000);
				Robot robot = new Robot();
			    robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
			}
 			
				 
			public void ClickonAction() throws InterruptedException, AWTException{
				Thread.sleep(2000);
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_F17);
				robot.keyRelease(KeyEvent.VK_F17);
				 Thread.sleep(2000);
		  	}
			
			public void EntertowarehouseDetails(String towhsNumber) throws InterruptedException, AWTException{
					   Thread.sleep(2000);
					   driver.switchTo().frame("m3h5_ef5e4a05-31ba-4241-bf91-5da1f4774cf4");
					   Thread.sleep(2000);
					   towarehouse.click();
					   Thread.sleep(2000);
					   inputtowherehouse.sendKeys(towhsNumber);
					   ClickEnter();
					   Selecttowherehouse.click();
					   Thread.sleep(2000);
					   BtnSelect.click();
					   Thread.sleep(2000);
					   driver.switchTo().defaultContent();
			}
	
			public void EnterfrmwarehouseDetails(String frmwhsNumber) throws InterruptedException, AWTException{
				   driver.switchTo().frame("m3h5_ef5e4a05-31ba-4241-bf91-5da1f4774cf4");
				   Thread.sleep(2000);
				   frmwarehouse.click();
			       Thread.sleep(2000);
			       inputtowherehouse.sendKeys(frmwhsNumber);
			       ClickEnter();
			       Selecttowherehouse.click();
			       Thread.sleep(2000);
			       BtnSelect.click();
			       Thread.sleep(2000);
			       driver.switchTo().defaultContent();
				}
	
			public void EnteritemNumber(String itemvalue) throws InterruptedException, AWTException{
				 driver.switchTo().frame("m3h5_ef5e4a05-31ba-4241-bf91-5da1f4774cf4");
				 Thread.sleep(2000);
				 itemNumber.click();
		         Thread.sleep(2000);
		         inputtowherehouse.sendKeys(itemvalue);
		         ClickEnter();
		         Selecttowherehouse.click();
		         Thread.sleep(2000);
		         BtnSelect.click();
		         Thread.sleep(2000);
		         driver.switchTo().defaultContent();
			}
	
			public void OrderTypeNumber(String Ordertypeval) throws InterruptedException, AWTException{
			   driver.switchTo().frame("m3h5_ef5e4a05-31ba-4241-bf91-5da1f4774cf4");
			   Thread.sleep(2000);
			   OrderType.click();
		       Thread.sleep(2000);
		       inputtowherehouse.sendKeys(Ordertypeval);
		       ClickEnter();
		       Selecttowherehouse.click();
		       Thread.sleep(2000);
		       BtnSelect.click();
		       Thread.sleep(2000);
		       BtnNext.click();
		       driver.switchTo().defaultContent();
		      
			}
	
			public void PlannedDistribtionDetails(String PlannedDelDate,String PlannedQty,String Pickupval) throws InterruptedException, AWTException{
			   driver.switchTo().frame("m3h5_ef5e4a05-31ba-4241-bf91-5da1f4774cf4");
			   Thread.sleep(2000);
			   PlannedDelaydt.sendKeys(PlannedDelDate);
			   Planqty.sendKeys(PlannedQty);
		       Thread.sleep(2000);
		       DeliveryMethod.click();
		       Thread.sleep(2000);
		       inputtowherehouse.sendKeys(Pickupval);
		       ClickEnter();
		       Selecttowherehouse.click();
		       Thread.sleep(2000);
		       BtnSelect.click();
		       Thread.sleep(2000);
		       BtnNext.click();
		       driver.switchTo().defaultContent();
		      
			}
	
			public void ClickonSettings() throws InterruptedException, AWTException{
				Thread.sleep(2000);
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_F13);
				robot.keyRelease(KeyEvent.VK_F13);
				Thread.sleep(2000);
				driver.switchTo().frame("m3h5_ef5e4a05-31ba-4241-bf91-5da1f4774cf4");
				BtnNext.click();
			    driver.switchTo().defaultContent();
			}
	
}
