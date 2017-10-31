package com.SEO;

import java.lang.reflect.Method;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;



public class SEOSuiteBase{
	
	@DataProvider
	public Object [][] getTestUrls(Method m)
			{
			return new Object[][]
				{
					 { 1,"http://www.hsh.com" },
			                {2, "http://www.google.com" }
				};
			}

	public void testPagesOpen(){
		
		
		
		
		
		
// check if the suite execution has to be skiped 
	@BeforeSuite(dataProvider = "getTestUrls")
			//APP_LOGS.debug("Runmode of HSH Suite set to no. So skiping all tests in Suite HSH");
			throw new SkipException ("Runmode of HSH Suite  set to no. So skiping all tests in Suite HSH");
			}

}
