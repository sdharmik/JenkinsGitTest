package com.core.mysuite;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.core.util.TestUtil;

public class TestCaseExecutor extends MyInitializations{

	
	@Test(dataProvider="getData")
	public void testCases(String id, String summary, String mode){
		if(!mode.equalsIgnoreCase("Y")){
			AppLogs.debug("Test Case "+id+"execution skipped as test case mode set to No");
			throw new SkipException("Test case skipped as mode set to NO");
		}
		else{
			
			if(excel.isSheetExist(id)){
				
				Object[][] testCase=TestUtil.getData(excel, id);
				
				for(int i=0;i<testCase.length;i++){
					
					String keyword = testCase[i][2].toString();
					String locatorType = testCase[i][3].toString();
					String locatorValue=testCase[i][4].toString();
					String data=testCase[i][5].toString();
					
					getKeywordMethod(keyword, locatorType, locatorValue, data);
							
				}
			}
		}
	}
	
	@DataProvider
	public Object[][] getData(){
	Object[][] myData=TestUtil.getData(excel, this.getClass().getSimpleName());
	
	return myData;
		}
	}

