package com.xde.XRefresh.runners;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features="src/test/resources/features/appLaunch.feature",
		glue="com.xde.XRefresh.steps"
			
		)

public class AppLaunchRunner {
	
	
	@Test
	public void runCukes() {
		
		new TestNGCucumberRunner(getClass()).runCukes();
		
	}

}
