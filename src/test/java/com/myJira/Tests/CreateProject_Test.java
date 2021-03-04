package com.myJira.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Jira.Utilities.BrowserOperations;
import com.myJira.Create_Project;
import com.myJira.Get_Project;
import com.myJira.Jira_Login;
import com.myJira.Jira_logout;

public class CreateProject_Test {

	BrowserOperations bo = new BrowserOperations();
	Jira_Login login = new Jira_Login(); 
	Get_Project jiraproject = new Get_Project();
	Jira_logout logout = new Jira_logout();
	Create_Project createproject = new Create_Project();
	
	
	@Test
	public void openbrowser()
	{
		bo.openBrowser();
	}
	
	@Test(dependsOnMethods = "openbrowser")
	public void launchsite()
	{
		bo.launchSite();
	}
	
	@Test(dependsOnMethods = "launchsite")
	public void Login()
	{
		login.jiraLogin();
	}
	
	@Test(dependsOnMethods = "Login")
	public void CreateProject()
	{
		createproject.createProject();
	}
	
	@Test(dependsOnMethods = "CreateProject")
	public void Logout()
	{
		logout.jiraLogout();
	}
	
	@Test(dependsOnMethods = "Logout")
	public void closesite()
	{
		bo.closeSite();
	}
}
