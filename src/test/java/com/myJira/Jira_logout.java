package com.myJira;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Jira.Utilities.BrowserOperations;
import com.Jira.Utilities.ExtendReport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Jira_logout extends BrowserOperations{
	
	WebDriverWait wait;
	
	ExtentReports reports=ExtendReport.getReporter();
	ExtentTest et=reports.startTest("Logout Test Results");
	
	public void jiraLogout()
	{
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait= new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='css-1sqfw5x']/span"))).click();
		
		//driver.findElement(By.xpath("(//span[@role='img'])[5]")).click();
		driver.findElement(By.xpath("//span[text()='Log out']")).click();
		System.out.println("Test Exceution Done,Browser Closed");
		et.log(LogStatus.PASS,"Testcase is passed for jiraLogout");
		reports.endTest(et);
		reports.flush();
		
	}


}
