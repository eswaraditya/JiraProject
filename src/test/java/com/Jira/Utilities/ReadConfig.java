package com.Jira.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\Jira\\Utilities\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
		
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("URL");
		return url;
	}
	
	public String getUsername()
	{
	String username=pro.getProperty("login.username");
	return username;
	}
	
	public String getPassword()
	{
	String password=pro.getProperty("login.password");
	return password;
	}
	
	public String getNewProjectName()
	{
	String newProjectName=pro.getProperty("new.project.name");
	return newProjectName;
	}
}
