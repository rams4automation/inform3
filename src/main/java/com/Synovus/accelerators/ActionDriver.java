package com.Synovus.accelerators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import com.Synovus.fileutils.ConfigReader;



public class ActionDriver extends Configurations{
	
	ConfigReader con=new ConfigReader();
	
	
	
	String path=con.getChromeDriverPath();
	
	
	public void openURL(String URL) throws InterruptedException{
		
		//System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver",path);
				driver = new ChromeDriver(); 
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 //driver=new FirefoxDriver();
				 driver.manage().window().maximize();
				 Thread.sleep(2000);
				//driver.get("https://www.facebook.com/");
				driver.get(URL);
	}
	
	
	
	
}
