package com.myJira;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Jira.Utilities.BrowserOperations;
import com.Jira.Utilities.ExtendReport;
import com.Jira.Utilities.ReadConfig;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Get_Project extends BrowserOperations{
	
	WebDriverWait wait;
	
	ExtentReports reports=ExtendReport.getReporter();
	ExtentTest et=reports.startTest("Project Test Results");
	
	public void getProject()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[text()='Jira Software']")).click();
		for(int i=0; i<=2;i++){
			  try{
				  driver.findElement(By.xpath("//span[text()='JiraProject']")).click();
			    
			  }
			  catch(StaleElementReferenceException e){
				  driver.findElement(By.xpath("//span[text()='JiraProject']")).click();
				  break;
			  }
			}
		//driver.findElement(By.xpath("//span[text()='Testing']")).click();
		
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		for(int i=0; i<=2;i++){
//			  try{
//				  driver.findElement(By.xpath("//span[text()='Backlog']")).click();
//			    
//			  }
//			  catch(StaleElementReferenceException e){
//				  driver.findElement(By.xpath("//span[text()='Backlog']")).click();
//				  break;
//			  }
//			}
//		
//		driver.findElement(By.xpath("//span[text()='Epics']")).click();
		et.log(LogStatus.PASS,"Testcase is passed for getProject");
		reports.endTest(et);
		reports.flush();
		
	}

}
