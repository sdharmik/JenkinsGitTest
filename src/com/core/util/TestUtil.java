package com.core.util;

public class TestUtil {

	
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
