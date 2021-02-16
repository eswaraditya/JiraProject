package com.myJira;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Jira.Utilities.BrowserOperations;
import com.Jira.Utilities.ExtendReport;
import com.Jira.Utilities.ReadConfig;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Jira_Login extends BrowserOperations{
	
	//WebDriverWait wait;
	
	ExtentReports reports=ExtendReport.getReporter();
	ExtentTest et=reports.startTest("Login Test Results");
	
	ReadConfig pro = new ReadConfig();
	String username = pro.getUsername();
	String password = pro.getPassword();
	
	public void jiraLogin()
	{
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='My account']")).click();
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		et.log(LogStatus.PASS,"Testcase is passed for jiraLogin");
		reports.endTest(et);
		reports.flush();
		
	}

}
