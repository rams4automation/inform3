package com.Synovus.accelerators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import com.Synovus.fileutils.ConfigReader;

import UtilFiles.ReportStampSupport;



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
