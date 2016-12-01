package com.core.mysuite;

import org.testng.annotations.BeforeSuite;

import com.core.common.GlobalFunctions;

public class MyInitializations extends GlobalFunctions{
	
	@BeforeSuite
	public void initializations() throws Exception{
		initialize();
	}

}
