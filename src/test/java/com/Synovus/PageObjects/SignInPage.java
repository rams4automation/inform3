package com.Synovus.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInPage  extends BasePage{
	
	WebDriver driver;

	
	
	 @FindBy(id="LoginDeskTopModePage-Login")
	 WebElement LoginButton;
	 
	 @FindBy(xpath="//*[@id='navigation']/ul/li[5]/a")
	 WebElement Settings; 
	 
	 @FindBy(xpath="//*[@id='siteNavbar']/li[3]/a")
	 WebElement PersonalMenu;
	 
	 @FindBy(xpath="//*[@id='siteNavbar']/li[4]/a")
	 WebElement BusinessMenu;
	 
 
	 @FindBy(id="LoginDeskTopModePage-UserName")
	 WebElement user_name;
	 
	 @FindBy(id="LoginDeskTopModePage-password")
	 WebElement Pass_WRD;
	 
	 @FindBy(xpath="//*[@id='mainNavbar']/div[1]/div[3]/div/ul/li[4]/div/div/a")
	 WebElement Loginlink;
	 
	 
	 
	 
	
	public SignInPage(WebDriver driver) {
	    super(driver);
		PageFactory.initElements(driver, this);
	 }
	
	
	
	
	
	////******************************* Methods ******************************************
	
	
	public void clickonPersonalSignInbutton() {
		  PersonalMenu.click();
       	}
	
	
	public void clickonBusinessSignInbutton() {
		BusinessMenu.click();
	   }
	
	public void clickonloginlink(){
		Loginlink.click();
		
	   }
	
	public void clickonBusinessMenu(){
		this.clickonBusinessSignInbutton();
	    }
	
	
	
	public void EnterPersonalUserNameandPasswd(String Username,String Password){
		user_name.sendKeys(Username);
		Pass_WRD.sendKeys(Password);
	   }
	
	public void EnterBusinessUserNameandPasswd(String Username,String Password){
		user_name.sendKeys(Username);
		Pass_WRD.sendKeys(Password);
	   }
	
	
	
	
	
	
	
	
}
