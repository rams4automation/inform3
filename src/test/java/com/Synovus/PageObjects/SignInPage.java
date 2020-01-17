package com.Synovus.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Synovus.accelerators.ActionDriver;

public class SignInPage {
	
	WebDriver driver;

	// By user_name = By.id("LoginDeskTopModePage-UserName");
	// By Pass_WRD = By.id("LoginDeskTopModePage-password");
	 //By Loginlink = By.xpath("//*[@id='mainNavbar']/div[1]/div[3]/div/ul/li[4]/div/div/a");
	 //By PersonalMenu = By.xpath("//*[@id='siteNavbar']/li[3]/a");
	// By BusinessMenu = By.xpath("//*[@id='siteNavbar']/li[4]/a");
	 By LoginButton = By.id("LoginDeskTopModePage-Login");
	 By Settings =By.xpath("//*[@id='navigation']/ul/li[5]/a");

	 
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
		this.driver=driver;
		PageFactory.initElements(driver, this);
	 }
	
	public void clickonPersonalSignInbutton() {
		  PersonalMenu.click();
        /* WebElement Signintab=driver.findElement(PersonalMenu);
         if(Signintab.isDisplayed()){
        	 Signintab.click();
         }*/
	}
	
	
	public void clickonBusinessSignInbutton() {
		BusinessMenu.click();
		//driver.findElement(BusinessMenu).click();
       /* WebElement Signintab=driver.findElement(BusinessMenu);
        if(Signintab.isDisplayed()){
       	 Signintab.click();
        }*/
	}
	
	public void clickonloginlink(){
		Loginlink.click();
	  }
	
	public void clickonBusinessMenu(){
		this.clickonBusinessSignInbutton();
	}
	
	
	public void EnterBusinessUserNameandPasswd(String Username,String Password){
		user_name.sendKeys(Username);
		Pass_WRD.sendKeys(Password);
	}
	
	
	
	
	
	
}
