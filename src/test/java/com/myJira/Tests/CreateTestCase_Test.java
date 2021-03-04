package com.myJira.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Jira.Utilities.BrowserOperations;
import com.myJira.Create_TestCase;
import com.myJira.Get_Project;
import com.myJira.Jira_Login;
import com.myJira.Jira_logout;

public class CreateTestCase_Test {
	
	BrowserOperations bo = new BrowserOperations();
	Jira_Login login = new Jira_Login(); 
	Get_Project jiraproject = new Get_Project();
	Jira_logout logout = new Jira_logout();
	Create_TestCase testcase = new Create_TestCase();
	
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
	public void Login()
	{
		login.jiraLogin();
	}
	
	@Test(priority=3)
	public void jiraProject()
	{
		jiraproject.getProject();
	}
	
	@Test(priority=4)
	public void TestCase() throws InterruptedException
	{
		testcase.createTestCase();
	}

}
