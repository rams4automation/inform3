package com.Synovus.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesManagementPage {
             WebDriver driver;
		
	
	
		
			 @FindBy(xpath=".//*[@id='navigatorXi']/fieldset[4]/legend/span")
			 //@FindBy(xpath="//*[@id='2']/span")
			 WebElement SalesManagement;
			
			@FindBy(xpath=".//*[@id='navigatorXi']/fieldset[4]/div[2]/fieldset[1]/legend/span")
			// @FindBy(xpath="//*[@id='2_1']/span")
			 WebElement COPPage; 
	 
			 @FindBy(xpath=" .//*[@id='navigatorXi']/fieldset[4]/div[2]/fieldset[1]/div[2]/a[1]")
			 //@FindBy(xpath="//*[@id='2_1_1']/span")
			 WebElement COOpen; 
			
	 
	 

	 public SalesManagementPage(WebDriver driver) {
		    this.driver=driver;
			PageFactory.initElements(driver, this);
		 }
	 
	 
	 
	 
	    public void clickSalesManagement() throws InterruptedException{
	    	Thread.sleep(2000);
	    	SalesManagement.click();
	    	Thread.sleep(2000);
	    }
		
	    public void clickOnCOPPage() throws InterruptedException{
	    	Thread.sleep(2000);
	    	COPPage.click();
	    	Thread.sleep(2000);
	    }
	    
	    public void clickOnCustomerOrderOpen() throws InterruptedException{
	    	Thread.sleep(2000);
	    	COOpen.click();
	    	Thread.sleep(2000);
	    }
	
}
