package com.myJira;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Jira.Utilities.BrowserOperations;
import com.Jira.Utilities.ExtendReport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Create_UserStory extends BrowserOperations{
	
	WebDriverWait wait;
	
	ExtentReports reports=ExtendReport.getReporter();
	ExtentTest et=reports.startTest("Epic Test Results");
	
	public void createStory(String storyName) throws InterruptedException
	{
		Thread.sleep(4000);
		WebElement e = driver.findElement(By.xpath("//button[text()='Create epic']"));
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();",e);
		driver.findElement(By.xpath("//input[@id='issuetype-field']")).click();
		driver.findElement(By.xpath("//input[@id='issuetype-field']")).sendKeys("Sto");
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='aui-last']/child::li"));
		System.out.println("Total no of suggestions in search box:::====> " + list.size());
		for (int i = 0; i < list.size(); i++) 
		{
		System.out.println(list.get(i).getText());
		if (list.get(i).getText().contains("Story")) 
		{
		list.get(i).click();
		break;
		
		}

		}
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@name='summary']")).sendKeys(storyName);
		driver.findElement(By.xpath("//button[@id='qf-field-picker-trigger']")).click();
		driver.findElement(By.xpath("//a[text()='Epic Link']")).click();
		driver.findElement(By.xpath("(//input[@aria-autocomplete='list'])[6]")).click();
		Thread.sleep(4000);
		List<WebElement> list1 = driver.findElements(By.xpath("(//ul[@class='aui-list-section aui-last'])[19]/child::li"));
		System.out.println("Total no of suggestions in search box:::====> " + list1.size());
		for (int i = 0; i < list1.size(); i++) 
		{
		System.out.println(list1.get(i).getText());
		if (list1.get(i).getText().contains("Epic_3")) 
		{
		list1.get(i).click();
		break;
		
		
		}

		}
		driver.findElement(By.xpath("//input[@value='Create']")).click();
		et.log(LogStatus.PASS,"Testcase is passed for createStory");
		reports.endTest(et);
		reports.flush();
		
		
	}

}
