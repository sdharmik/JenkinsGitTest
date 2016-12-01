package com.core.mysuite;

import java.lang.reflect.Method;

import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.core.util.ReadExcel;
import com.core.util.TestUtil;

public class MyTestCase extends MyInitializations{
	
	public Method m;
	
	@BeforeMethod
	public void testCaseExecution(Method m){
		
		if(!TestUtil.verifyTestCaseMode(readExcel, m.getName())){
			AppLogs.debug(m.getName()+" ::execution skipped as test execution mode set to No");
			throw new SkipException("execution skipped as test execution mode set to No");
		}
		
	}
	
	@Test
	public void login() throws Exception{
		
		//ReadExcel read =new ReadExcel("D:\\Selenium\\WebDriver\\KeywordDrivenFramework\\src\\com\\core\\data\\TC_001.xls");
		
		int totalRows=loginExcel.getRowCount(m.getName());
		System.out.println("Total rows "+totalRows);
		//System.out.println("Method: "+m.getName());
		String keyword;
		String locatorType;
		String locatorValue;
		String data;
		for(int i=1; i<totalRows;i++){
			keyword=loginExcel.getCellData("login","Keywords", i);
			locatorType=loginExcel.getCellData("login","LocatorType", i);
			locatorValue=loginExcel.getCellData("login","LocatorValue", i);
			data=loginExcel.getCellData("login","Data", i);
			
			switch(keyword){
				
			case "launchBrowser":
				launchBrowser(data);
				break;
				
			case "enterText":
				enterText(locatorType, locatorValue, data);
				break;

			case "clickButton":
				clickButton(locatorType, locatorValue);
				break;
				
			case "verifyText":
				verifyText(locatorType, locatorValue, data);
				break;
			}
			
		}
	}

}
