package com.SHandLeadFormVerification;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.Util;
import com.utility.Xls_Reader;
import com.SHandLeadFormVerification.MortgageLeanderSection;

public class LandingPage extends BaseMethod {
	
	@BeforeTest
	public void BrowserLaunch() throws Throwable{
		initialization();
		driver = new FirefoxDriver();
	}

	@Test(dataProvider = "getTestData")
	
	public void controller (String col1) throws Throwable{
	 
	 SHListingISClickable run = new SHListingISClickable();
	SideFilterVerification excute = new SideFilterVerification();
	MinorWidgetVerification shiv = new MinorWidgetVerification();
	MortgageLeanderSection ShivShambho = new MortgageLeanderSection();
	// driver.manage().deleteAllCookies();
	driver.navigate().to(col1);
	driver.manage().window().maximize() ;
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
	
			// SH listing present in Midel of page
					if(driver.findElement(By.id("mortgage_rates")).isDisplayed()){
						run.SHListingClickable();
						
					}
					
			//Left side filter option 
					if (driver.findElement(By.id("sidebar")).isDisplayed()){
						
						excute.RightFilterVerification();
						run.SHListingClickable();
					}
				// Left side Lead form below filter option
					if (driver.findElement(By.className("refine_quote")).isDisplayed()){
						excute.RightSideCoteForm();
						
					}
					
				// bottom banner qsmrWidgetContainer"
					/*try{
						assertTrue(isElementPresent(By.id("qsmrWidgetContainer")));
						while(true){
				//	if (assertTrue(isElementPresent(By.cssSelector("div.footerquad")))){
						shiv.qsmrWidgetContainer();
						System.out.println("####"); ;
						}
					}catch(Exception e){System.out.println("not working");}
					
				
					}
					private static void assertTrue(Object elementPresent) {
						// TODO Auto-generated method stub
						
					}
					private static Object isElementPresent(By id) {
						// TODO Auto-generated method stub
						return null;
					}
					*/
	//Verification of click on /mortgage-lenders/ is working 
				if (driver.findElement(By.id("surehitsResults")).isDisplayed()){
					ShivShambho.surehitsResults();
				}
				else{
					throw new Throwable (driver.getCurrentUrl()+" on page NOT having Objects considered to Automation testing");
				}
				driver.close();
		}
		
	
	
	
	
//----------------------- Some calling functions to avoid duplication  of code 	
//	/mortgage-lenders	page Listing calling function
	public void ClikonLink(String hrfType) throws Throwable{
		Set<String> window= driver.getWindowHandles();
		System.out.println(window.size());
		Object[] windowID=  window.toArray();
	
		if(window.size()==2) {
		
				System.out.println(hrfType+"  is  funcational on " +driver.getCurrentUrl());
				driver.switchTo().window((String) windowID[1]);
				driver.close();
			}
		else{
			System.out.println(hrfType +" is NOT working on "+driver.getCurrentUrl());
				if(driver.getCurrentUrl().equals(col1)){
					throw new Throwable (hrfType + " is not working on "+driver.getCurrentUrl());
				}
				else{
					System.out.println(hrfType + " is opened in same instance at page  "+col1);
					driver.navigate().back();
				}
			}
		
		driver.switchTo().window((String) windowID[0]);
		
	}
	
	
	
	
	
	
	
	
	@DataProvider
	public  Object[][] getTestData(){
		return Util.getData(suiteXls, this.getClass().getSimpleName());
	}
}