package com.myJira.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Jira.Utilities.BrowserOperations;
import com.myJira.Jira_Login;
import com.myJira.Jira_logout;

public class Login_Test {
	
	BrowserOperations bo = new BrowserOperations();
	Jira_Login login = new Jira_Login();
	Jira_logout logout = new Jira_logout();
	
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
	public void Logout()
	{
		logout.jiraLogout();
	}

	@AfterClass
	public void closesite()
	{
		bo.closeSite();
	}
}
