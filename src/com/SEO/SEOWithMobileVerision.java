package com.SEO;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;SEOWithMobileVerision.java
import org.testng.annotations.DataProvider;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

import com.SHandLeadFormVerification.BaseMethod;

import com.SHandLeadFormVerification.LandingPage;
import com.utility.Util;

public class SEOWithMobileVerision extends BaseMethod{
//Created firefox profile and Open firefox browsers in mobile version.	
	@BeforeTest
	public void BrowserLaunch() throws Throwable{
		initialization();
	    ProfilesIni profile = new ProfilesIni();
        FirefoxProfile ffprofile = profile.getProfile("mobileSitesTesting");
        driver = new FirefoxDriver(ffprofile);
		//driver = new FirefoxDriver();
	}

	
	@Test(dataProvider = "getTestData")
	public void SEOAudit(String url) throws Throwable{
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		/// Get the H1 tag 
		System.out.println("H1 tag ---"+driver.findElement(By.tagName("H1")).getText()+"----on page------"+driver.getCurrentUrl());
		
		//Get title 
		System.out.println("Title -----"+driver.getTitle()+"----on page------"+url);
		
		// Get Discription 
		
		System.out.println(driver.findElement(By.xpath("//meta[@name='description']")).getAttribute("content"));
		
	}
	
	
	
	
	@AfterMethod
	public  void reportDataSetResult()
	{
	//report error in xlsx file 
	/*	if(skip)
			TestUtil.reportDataSetResult(suiteHSHxls, this.getClass().getSimpleName(), count+2, "SKIP");
		else if (fail){
			isTestPass=false;
			TestUtil.reportDataSetResult(suiteHSHxls, this.getClass().getSimpleName(), count+2, "FAIl");
		}else 
		 TestUtil.reportDataSetResult(suiteHSHxls, this.getClass().getSimpleName(), count+2, "PASS");
		skip= false;
		fail=false;*/
	}
// Get the testData from Excel file 	
	@DataProvider
	public  Object[][] getTestData(){
		return Util.getData(suiteXls, this.getClass().getSimpleName());
	}
}
