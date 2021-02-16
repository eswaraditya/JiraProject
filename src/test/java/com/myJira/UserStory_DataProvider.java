package com.myJira;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class UserStory_DataProvider {

	
	@DataProvider(name="userstory")
	public Object[][] getEmpData() throws Exception
	{
		//Read data from excel
		//String path = System.getProperty("user.dir")+"/src/test/java/com/Jira/Utilities/UserStories.xlsx";
		
		String path=System.getProperty("user.dir");
		File f=new File(path+"\\src\\test\\java\\com\\Jira\\Utilities\\UserStories.xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fi); //get my workbook 
		Sheet sh=wb.getSheetAt(0);  //Sheet1 in workbook  
		int nour=sh.getPhysicalNumberOfRows();   //number of used Rows in sheet1
		Row r=sh.getRow(0); //go to 1st Row 
		int nouc=r.getLastCellNum(); // get last Column Number 
		Object data[][]=new Object[nour-1][nouc]; // pass required count to create 2D-array
		for(int i=1; i<nour; i++) //Loop work for Rows(2nd row to last row)
		{  
	         Row row=sh.getRow(i);
	         for(int j=0; j<nouc; j++) //Loop work for columns(1st to last column)
	         {
	        	 Cell cell=row.getCell(j);
	        	 //formatter get any type of value as string from excel sheet by default
	        	 DataFormatter formatter=new DataFormatter();
	        	 String value=formatter.formatCellValue(cell);
	             data[i-1][j]=value; //1st in excel to 0th in data array........etc
	        }
		}
		fi.close();
		wb.close();
		return(data);
	}
}
