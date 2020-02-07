package com.Synovus.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlannedorderDistibutionPage {
              WebDriver driver;
	
              ////span[contains(text(),'Plan qty')]//following::div[text()='50.00']
              
              //(//div[@id='R1']//following::div[5])[1]
	
             /// (//div[contains(@class,'slick-viewport slick-viewport') and contains(@class,'list-view-open')])[1]
              
         //Row   //div[contains(@class,'headerrow-columns ')]//following::div[contains(@role,'row')]
              
        //all rows    //div[contains(@class,'headerrow-columns ')]//following::div[contains(@role,'row')]//div
              
              //Even --//div[contains(@class,'headerrow-columns ')]//following::div[contains(@role,'row')]//following::div[contains(@class,'slick-row  even')]

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
 			
 			@FindBy(xpath="//*[@id='DPA170BS_4ca766e6560462acc53da0b9c050a437']")
			 WebElement Applytable;
			
 			
 			//*[@id="contentBody"]
 			public PlannedorderDistibutionPage(WebDriver driver) {
			    this.driver=driver;
				PageFactory.initElements(driver, this);
			 }
		
 			
 			/*<outputDirectory>target/cucumber-reports/advanced-reports</outputDirectory>
			<cucumberOutput>target/cucumber-reports/CucumberTestReport.json</cucumberOutput>*/
 			
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
			    Thread.sleep(2000);
				driver.switchTo().frame("m3h5_ef5e4a05-31ba-4241-bf91-5da1f4774cf4");
				// WebElement mytable=driver.findElement(By.xpath("(//div[@id='R1']//following::div[5])[1]"));
				 WebElement mytable=driver.findElement(By.xpath("//span[contains(text(),'Plan qty')]//following::div[text()='50.00']"));
				 //
				//List<WebElement> myrows=mytable.findElements(By.tagName("tr"));
				// int rowcount=myrows.size();
				// System.out.println(rowcount);
				 mytable.click();
				/* for(int row=0;row<rowcount;row++){
					 List<WebElement> mycols=myrows.get(row).findElements(By.tagName("td"));
					 int colscount=mycols.size();
					 for(int col=0;col<colscount;col++){
						String celltext=mycols.get(col).getText();
						System.out.println(celltext);
					 }
				 }*/
				 
				 
				 
			    driver.switchTo().defaultContent();
			
			    
			
			}
	
}
