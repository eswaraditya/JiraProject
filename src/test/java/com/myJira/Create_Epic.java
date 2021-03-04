package com.myJira;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Jira.Utilities.BrowserOperations;
import com.Jira.Utilities.ExtendReport;
import com.Jira.Utilities.ReadConfig;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Create_Epic extends BrowserOperations{
	
	WebDriverWait wait;
	
	ExtentReports reports=ExtendReport.getReporter();
	ExtentTest et=reports.startTest("Epic Test Results");
	
	public void createEpic(String epicName) throws IOException
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		for(int i=0; i<=2;i++){
			  try{
				  driver.findElement(By.xpath("//span[text()='Backlog']")).click();
			    
			  }
			  catch(StaleElementReferenceException e){
				  driver.findElement(By.xpath("//span[text()='Backlog']")).click();
				  break;
			  }
			}
		
			driver.findElement(By.xpath("//span[text()='Epics']")).click();
			driver.findElement(By.xpath("//button[text()='Create epic']")).click();
			wait= new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='customfield_10011']"))).sendKeys(epicName);
			driver.findElement(By.id("summary")).sendKeys("Validating the checkout page");
			driver.findElement(By.xpath("//input[@value='Create']")).click();
			et.log(LogStatus.PASS,"Testcase is passed for createEpic");
			reports.endTest(et);
			reports.flush();
		
//		catch(Exception e)
//		{
//			//Take screenshot
//			File src=driver.getScreenshotAs(OutputType.FILE);
//			SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yy-hh-mm-ss");
//			Date dt=new Date();
//			String fname=sf.format(dt)+".png";
//			File dest=new File(fname);
//			FileHandler.copy(src, dest);
//			et.log(LogStatus.FAIL,et.addScreenCapture(fname)+" Testcase is failed for createEpic");
//		}
		
	}
	

}
