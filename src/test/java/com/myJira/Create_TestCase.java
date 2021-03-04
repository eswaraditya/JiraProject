package com.myJira;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Jira.Utilities.BrowserOperations;
import com.Jira.Utilities.ExtendReport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Create_TestCase extends BrowserOperations{
	
	ExtentReports reports=ExtendReport.getReporter();
	ExtentTest et=reports.startTest("Project Test Results");
	
	public void createTestCase() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[text()='Zephyr']")).click();
		driver.findElement(By.xpath("//span[text()='Create a Test']")).click();
		driver.findElement(By.xpath("//input[@id='issuetype-field']")).click();
		driver.findElement(By.xpath("//input[@id='issuetype-field']")).sendKeys("Test",Keys.ENTER);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='summary']")).sendKeys("dscfcvcf");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)");
		
		driver.findElement(By.xpath("//div[@id='customfield_10014-single-select']")).click();
		driver.findElement(By.xpath("//div[@id='customfield_10014-single-select']")).sendKeys("Validating the login page ");
		
	}

}
