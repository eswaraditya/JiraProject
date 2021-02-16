package com.myJira;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Jira.Utilities.BrowserOperations;
import com.Jira.Utilities.ExtendReport;
import com.Jira.Utilities.ReadConfig;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Jira extends BrowserOperations{
	
	
	WebDriverWait wait;
	
	ExtentReports reports=ExtendReport.getReporter();
	ExtentTest et=reports.startTest("Jira Test Results");
	
	BrowserOperations bo = new BrowserOperations();
	//PropertiesUtil prop = new PropertiesUtil();
	ReadConfig pro = new ReadConfig();
	String username = pro.getUsername();
	String password = pro.getPassword();
	
	@BeforeClass
	public void openbrowser()
	{
		bo.openBrowser();
	}
	
	@Test(priority=1)
	public void launchsite()
	{
		bo.launchSite();
	}
	
	@Test(priority=2)
	public void jiraLogin()
	{
		//String username = PropertiesUtil.getString("login.username", "kjghjkdlfh");
		//String password = PropertiesUtil.getString("login.password", "dsfgugfu");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='My account']")).click();
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		driver.findElement(By.xpath("//div[text()='Jira Software']")).click();
		et.log(LogStatus.PASS,"Testcase is passed for jiraLogin");
		reports.endTest(et);
		reports.flush();
		
	}
	
	@Test(priority=3)
	public void getProject()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		for(int i=0; i<=2;i++){
			  try{
				  driver.findElement(By.xpath("//span[text()='Testing']")).click();
			    
			  }
			  catch(StaleElementReferenceException e){
				  driver.findElement(By.xpath("//span[text()='Testing']")).click();
				  break;
			  }
			}
		driver.findElement(By.xpath("//span[text()='Testing']")).click();
		et.log(LogStatus.PASS,"Testcase is passed for getProject");
		reports.endTest(et);
		reports.flush();
		
	}
	
	@Test(priority=4)
	public void createEpic() throws IOException
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
		//driver.findElement(By.xpath("//span[text()='Backlog']")).click();
		try
		{
			driver.findElement(By.xpath("//span[text()='Epics']")).click();
			driver.findElement(By.xpath("//button[text()='Create epic']")).click();
			wait= new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='customfield_10011']"))).sendKeys("Epic_4");
			//driver.findElement(By.xpath("//input[@class='textfield text long-field']")).sendKeys("Epic_3");
			driver.findElement(By.id("summary")).sendKeys("Validating the checkout page");
			driver.findElement(By.xpath("//input[@value='Create']")).click();
			et.log(LogStatus.PASS,"Testcase is passed for createEpic");
			reports.endTest(et);
			reports.flush();
		}
		catch(Exception e)
		{
			//Take screenshot
			File src=driver.getScreenshotAs(OutputType.FILE);
			SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yy-hh-mm-ss");
			Date dt=new Date();
			String fname=sf.format(dt)+".png";
			File dest=new File(fname);
			FileHandler.copy(src, dest);
			et.log(LogStatus.FAIL,et.addScreenCapture(fname)+" Testcase is failed for createEpic");
		}
		
	}
	
	@Test(priority=5)
	public void createStory() throws InterruptedException
	{
		Thread.sleep(4000);
		WebElement e = driver.findElement(By.xpath("//button[text()='Create epic']"));
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();",e);
		//wait= new WebDriverWait(driver, 40);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='aui-button aui-button-link js-create-epic']"))).click();	
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
		//driver.close();
		
		}

		}
		//driver.findElement(By.xpath("//input[@id='issuetype-field']")).clear();
		//driver.findElement(By.xpath("//input[@id='issuetype-field']")).sendKeys("Story");
		Thread.sleep(4000);
		//driver.findElement(By.xpath("//a[text()='Story']")).click();
		//wait= new WebDriverWait(driver, 40);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='summary']"))).sendKeys("zsjkdfksgf");
		driver.findElement(By.xpath("//input[@name='summary']")).sendKeys("Testing the feature");
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
		//driver.close();
		
		}

		}
		driver.findElement(By.xpath("//input[@value='Create']")).click();
		et.log(LogStatus.PASS,"Testcase is passed for createStory");
		reports.endTest(et);
		reports.flush();
		
		
	}
	
	@AfterClass
	public void closesite()
	{
		bo.closeSite();
	}

}
