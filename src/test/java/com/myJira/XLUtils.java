package com.myJira;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static Workbook wb;
	public static Sheet ws;
	public static Row row;
	public static Cell cell;
	
	public static int getRowCount(String xlfile, String xlsheet) throws Exception
	{
		fi= new FileInputStream(xlfile);
		wb= WorkbookFactory.create(fi);
		ws= wb.getSheet(xlsheet);
		int rowcount= ws.getLastRowNum();
		wb.close();
		fi.close();
		return(rowcount);				
	}
	
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws Exception
	{
		fi= new FileInputStream(xlfile);
		wb= WorkbookFactory.create(fi);
		ws= wb.getSheet(xlsheet);
		row= ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return(cellcount);				
	}
	
	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws Exception
	{
		fi= new FileInputStream(xlfile);
		wb= WorkbookFactory.create(fi);
		ws= wb.getSheet(xlsheet);
		row= ws.getRow(rownum);
		cell= row.getCell(colnum);
		String data;
		try
		{
			
			DataFormatter formatter = new DataFormatter();
			String celldata = formatter.formatCellValue(cell);
			return(celldata);
		}
		catch(Exception e)
		{
			data="";
		}
		
		wb.close();
		fi.close();
		return(data);				
	}
	
}
