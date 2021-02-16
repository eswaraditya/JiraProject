package com.Jira.Utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserOperations
{
	//Properties
	public static RemoteWebDriver driver;
	
	ReadConfig pro = new ReadConfig();
	String url = pro.getApplicationURL();
	
	//Operational methods
	
	public void openBrowser()
	{
		System.out.println("My Test script is started");
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();	
		Reporter.log("Chrome Browser Started");
		System.out.println("Test Exceution Starts,Browser Opened");
		
	}
	
	public void launchSite()
	{
		driver.get(url);
		System.out.println("Browser launched URL");
		
	}
	
	
	public void closeSite()
	{
		try {
			Thread.sleep(10000);
			System.out.println("Test Exceution Done,Browser Closed");
			Reporter.log("Test Exceution Done,Browser Closed");
			driver.close();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//CaptureError.captureAndPrintError();
			e.printStackTrace();
		}
	}
}