package com.Synovus.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class inforLoginPage {
	WebDriver driver;
	
	
	

			 @FindBy(id="username")
			 WebElement Kochid;
			 
			 @FindBy(id="password")
			 WebElement PassWRD; 
			
			 @FindBy(xpath="/html/body/div/div[2]/div/form/div[6]/a")
			 WebElement SignOnBtn; 
			 
			 @FindBy(xpath="//*[@id='mhdrSite']")
			 WebElement HomePage;
			 
			 @FindBy(id="mhdrAppBtn")
			 WebElement AppMenu;
			
			 @FindBy(xpath=".//*[@id='icdeskSClk']")
			 WebElement inform3;
			
			@FindBy(xpath="//*[contains(@id, 'icdeskSClk')]//*[contains(@title, 'Infor M3')]")
			WebElement inform3ap;
			
	 

		 public inforLoginPage(WebDriver driver) {
			    this.driver=driver;
				PageFactory.initElements(driver, this);
			 }
			
	
		 
		 // ######################## Methods ###################################
		 
	 
	     public void EnterUserNameandPasswd(String Username,String Password) throws InterruptedException{
	    	     Thread.sleep(2000);
				 Kochid.sendKeys(Username);
				 Thread.sleep(2000);
				 PassWRD.sendKeys(Password);
				 Thread.sleep(2000);
		     }
	 
	     public void clickonSignIn() throws InterruptedException{
			 Thread.sleep(2000);
			 SignOnBtn.click();
			 Thread.sleep(5000);
		   }
		 
		 public void Verifytitle() throws InterruptedException{
			 Thread.sleep(5000);
			 String Expectedtitle="Homepages";
			 String actaulTitle=driver.getTitle();
			 Thread.sleep(5000);
			 System.out.println(actaulTitle);
			 if(actaulTitle.equalsIgnoreCase(Expectedtitle))
				 System.out.println("Verify Home Page : Title Matched");
			 else
				 System.out.println("Verify Home Page : Title did not Matched");
			 }
	 
	 
		  public void clickonAppMenu() throws InterruptedException{
				 Thread.sleep(2000);
				 AppMenu.click();
				 Thread.sleep(5000);
			   }
	 
		  public void clickoninform3() throws InterruptedException{
				 Thread.sleep(2000);
				 inform3.click();
				 Thread.sleep(5000);
			   }
	 
	 
		  
}
