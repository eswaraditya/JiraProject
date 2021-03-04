package com.myJira;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.Jira.Utilities.BrowserOperations;
import com.Jira.Utilities.ExtendReport;
import com.Jira.Utilities.ReadConfig;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Create_Project extends BrowserOperations{
	
	ExtentReports reports=ExtendReport.getReporter();
	ExtentTest et=reports.startTest("Login Test Results");
	
	ReadConfig pro = new ReadConfig();
	
	String newProject = pro.getNewProjectName();
	
	public void createProject()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[text()='Jira Software']")).click();
		driver.findElement(By.xpath("//span[text()='Create project']")).click();
		driver.findElement(By.xpath("//span[text()='Select classic']")).click();
		driver.findElement(By.xpath("//input[@id='project-create.create-form.name-field.input']")).sendKeys(newProject);
		driver.findElement(By.xpath("(//span[text()='Create'])[2]")).click();
	}

}
