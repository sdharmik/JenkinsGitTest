package com.core.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel {
	
	public FileInputStream fis;
	public Workbook wb;
	public Sheet sh;
	boolean sheetFlag;
	
	public ReadExcel(String filePath) throws Exception{
		
		fis=new FileInputStream(filePath);
		wb=Workbook.getWorkbook(fis);
	}
	
	public int getRowCount(String sheetName){
		sh=wb.getSheet(sheetName);
		return sh.getRows();
	}
	
	public int getColumnCount(String sheetName){
		sh=wb.getSheet(sheetName);
		return sh.getColumns();
	}

	public String getCellData(String sheetName,int columnNumber, int rowNumber){
		sh=wb.getSheet(sheetName);
		return sh.getCell(columnNumber, rowNumber).getContents();
	}
	
	public String getCellData(String sheetName, String columnName, int rowNumber){
		sh=wb.getSheet(sheetName);
		int totalColumns=sh.getColumns();
		int colNum=0;
		for(int i=0;i<totalColumns;i++){
			if(sh.getCell(i,0).getContents().equals(columnName))
				colNum=i;
		}
		return sh.getCell(colNum,rowNumber).getContents();
	}
	
	public boolean isSheetExist(String sheetName){
		Sheet[] allSheets=wb.getSheets();
		
		for(int i=0;i<allSheets.length;i++){
			if(allSheets[i].getName().matches(sheetName))
				sheetFlag=true;
		}
		
		return sheetFlag;
	}
}
