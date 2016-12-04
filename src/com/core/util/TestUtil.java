package com.core.util;

public class TestUtil {

	
	public static Object[][] getData(ReadExcel obj, String sheet){
		
		int totalRows=obj.getRowCount(sheet);
		int totalCols=obj.getColumnCount(sheet);
		
		Object[][] data= new Object[totalRows-1][totalCols];
		
		for(int i=1;i<totalRows;i++){
			for(int j=0;j<totalCols;j++){
				data[i-1][j]=obj.getCellData(sheet, j, i);
			}
		}
		
		return data;
	}
	
	public static boolean verifyTestCaseMode(ReadExcel excelObj, String sheetName){
		boolean testCaseMode=false;
		
		for(int i=1;i<excelObj.getRowCount("TestCases");i++){
			if(excelObj.getCellData("TestCases","ID",i).toLowerCase().matches(sheetName.toLowerCase())){
				if(excelObj.getCellData("TestCases","Mode",i).matches("Y"))
					testCaseMode=true;
				else
					testCaseMode=false;
			}
		}
		
		System.out.println("Test Case Mode of "+sheetName+"is"+testCaseMode);
		return testCaseMode;
	}
}
