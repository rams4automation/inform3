package com.Synovus.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlannedorderDistibutionPage {
              WebDriver driver;
	
	
	

 			 @FindBy(xpath="//*[@id='cmdText']")
 			 //@FindBy(xpath="//*[@id='2']/span")
 			 WebElement SearchandStart;
	
	
	
			public PlannedorderDistibutionPage(WebDriver driver) {
			    this.driver=driver;
				PageFactory.initElements(driver, this);
			 }
	
			
			public void Enteritem() throws InterruptedException{
				Thread.sleep(2000);
				System.out.println();
				String winHandleBefore = driver.getWindowHandle();

				// Perform the click operation that opens new window

				// Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
				}

				// Perform the actions on new window

				// Close the new window, if that window no more required
				//driver.close();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='cmdText']")).sendKeys("DPS170");
				//SearchandStart.sendKeys(itemNumber);
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore);
				//driver.switchTo().alert().sendKeys(itemNumber);
				
				Thread.sleep(2000);
			}
			
	
	
	
	
	
}
