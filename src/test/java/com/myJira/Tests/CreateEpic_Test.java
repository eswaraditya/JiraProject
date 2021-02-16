package com.myJira.Tests;


import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.Jira.Utilities.BrowserOperations;
import com.myJira.Create_Epic;
import com.myJira.Epic_DataProvider;
import com.myJira.Get_Project;
import com.myJira.Jira_Login;
import com.myJira.Jira_logout;


public class CreateEpic_Test extends BrowserOperations{
	
	BrowserOperations bo = new BrowserOperations();
	Jira_Login login = new Jira_Login(); 
	Get_Project jiraproject = new Get_Project();
	Create_Epic Epic = new Create_Epic();
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
	public void jiraProject()
	{
		jiraproject.getProject();
	}
		
	@Test(dataProvider="epic", dataProviderClass=Epic_DataProvider.class, priority=4)
	public void jiraEpic(String epicName) throws IOException
	{
		System.out.println(epicName);
		Epic.createEpic(epicName);
		
	}
	
//	@Test(priority=5)
//	public void Logout()
//	{
//		logout.jiraLogout();
//	}

	@AfterClass
	public void closesite()
	{
		bo.closeSite();
	}

}
