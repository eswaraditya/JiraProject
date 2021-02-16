package com.Jira.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtendReport {
		
	public static ExtentReports extent;
	 
    public static ExtentReports getReporter() {
    	
    	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
    	String repName="Test-Report-"+timeStamp+".html";
    	
    	extent = new ExtentReports(System.getProperty("user.dir")+ "/Extend Reports/"+repName,false);
	
    	return extent;
	}

}
