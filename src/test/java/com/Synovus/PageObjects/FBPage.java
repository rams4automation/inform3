package com.Synovus.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBPage {
  WebDriver driver;
	
	
	@FindBy(name="email")
	WebElement UserName;
	
	@FindBy(name="pass")
	WebElement PassWRD;
	
	@FindBy(xpath="//*[@id='u_0_b']")
	WebElement Login;
	
	
	
	public FBPage(WebDriver driver) {
	    this.driver=driver;
		PageFactory.initElements(driver, this);
	 }
	
	
	
	public void EnterValidUserNameandPWD(String Userid, String password) {
		UserName.clear();
		UserName.sendKeys(Userid);
		PassWRD.clear();
		PassWRD.sendKeys(password);
	  }
	
	public void EnterInvalidUserNameandPWD(String Userid, String password) {
		UserName.clear();
		UserName.sendKeys(Userid);
		PassWRD.clear();
		PassWRD.sendKeys(password);
	  }
	
	public void clickLogin(){
		Login.click();
	}
	
	
	
	
}
