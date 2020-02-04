package com.Synovus.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
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
 			
 			@FindBy(xpath=".//div[#'appPageKey1']/iframe[@name='m3h5_ef5e4a05-31ba-4241-bf91-5da1f4774cf4']//span[#'menuBar']//a[@innertext>'Create Planned Distribution']")
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
 			
 			
	
 			public PlannedorderDistibutionPage(WebDriver driver) {
			    this.driver=driver;
				PageFactory.initElements(driver, this);
			 }
		
 			
 		// #########################################  Methods ##############################################
 			
		public void ClickEnter() throws InterruptedException, AWTException{
		    Thread.sleep(2000);
			Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
		}
 			
				 
			public void ClickonAction() throws InterruptedException, AWTException{
			  Thread.sleep(2000);
			  int size = driver.findElements(By.tagName("iframe")).size();
			  System.out.println("frames size is :- " + size);
				driver.switchTo().frame("m3h5_ef5e4a05-31ba-4241-bf91-5da1f4774cf4");
				ActionBtn.click();
				Thread.sleep(2000);
				 driver.switchTo().defaultContent();
				 Thread.sleep(5000);
				 driver.switchTo().frame("m3h5_ef5e4a05-31ba-4241-bf91-5da1f4774cf4");
				 Thread.sleep(2000);
				 towarehouse.click();
		       Thread.sleep(2000);
		       inputtowherehouse.sendKeys("190");
		       ClickEnter();
		       /*Thread.sleep(2000);
				Robot robot = new Robot();
		       robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				 Thread.sleep(2000);*/
		       Selecttowherehouse.click();
		       Thread.sleep(2000);
		       BtnSelect.click();
		       Thread.sleep(2000);
		       driver.switchTo().defaultContent();
			}
	
			public void EnterfrmwarehouseDetails() throws InterruptedException, AWTException{
					 driver.switchTo().frame("m3h5_ef5e4a05-31ba-4241-bf91-5da1f4774cf4");
					 Thread.sleep(2000);
					 frmwarehouse.click();
			       Thread.sleep(2000);
			       inputtowherehouse.sendKeys("192");
			       ClickEnter();
			      /* Thread.sleep(2000);
					Robot robot = new Robot();
			       robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					 Thread.sleep(2000);*/
			       Selecttowherehouse.click();
			       Thread.sleep(2000);
			       BtnSelect.click();
			       Thread.sleep(2000);
			       driver.switchTo().defaultContent();
				}
	
			public void EnteritemNumber() throws InterruptedException, AWTException{
				 driver.switchTo().frame("m3h5_ef5e4a05-31ba-4241-bf91-5da1f4774cf4");
				 Thread.sleep(2000);
				 itemNumber.click();
		       Thread.sleep(2000);
		       inputtowherehouse.sendKeys("F100000037");
		       ClickEnter();
		      /* Thread.sleep(2000);
				Robot robot = new Robot();
		       robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				 Thread.sleep(2000);*/
		       Selecttowherehouse.click();
		       Thread.sleep(2000);
		       BtnSelect.click();
		       Thread.sleep(2000);
		       driver.switchTo().defaultContent();
				
			}
	
			public void OrderTypeNumber() throws InterruptedException, AWTException{
				 driver.switchTo().frame("m3h5_ef5e4a05-31ba-4241-bf91-5da1f4774cf4");
				 Thread.sleep(2000);
				 OrderType.click();
		       Thread.sleep(2000);
		       inputtowherehouse.sendKeys("DI4");
		       ClickEnter();
		       /*Thread.sleep(2000);
				Robot robot = new Robot();
		       robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				 Thread.sleep(2000);*/
		       Selecttowherehouse.click();
		       Thread.sleep(2000);
		       BtnSelect.click();
		       Thread.sleep(2000);
		       BtnNext.click();
		       driver.switchTo().defaultContent();
		      
			}
	
	
}
