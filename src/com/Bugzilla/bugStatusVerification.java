package com.Bugzilla;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SHandLeadFormVerification.BaseMethod;
import com.utility.Util;
import com.utility.Xls_Reader;
//import test.MortgageLeanderSection;




	
	public class bugStatusVerification extends BaseMethod{
		
		@BeforeTest
		public void BrowserLaunch() throws Throwable{
			initialization();
			ProfilesIni profile = new ProfilesIni();
	        FirefoxProfile ffprofile = profile.getProfile("default");
	        driver = new FirefoxDriver(ffprofile);
			//driver = new FirefoxDriver();
	        String uname = "hqbugs";
	        String pwd = "L0t$oBU9S";
	        String TEST_ENVIRONMENT = "www.hqbugs.com/";
	        String url = "http://" + uname + ":" + pwd + "@" + TEST_ENVIRONMENT;
			driver.get(url);
			//driver.manage().window().maximize();
		//	driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	      //  Runtime.getRuntime().exec("C:\\Users\\sgainewar\\Desktop\\hqbugAuthentication.au3");

/*			try{
		        }catch(Exception e ){System.out.println("Auto It is not executed ");}
*/		}

		@Test(dataProvider = "getTestData")
		public void SEOAudit(String BugID) throws Throwable{
				
			
		String res= "Verified FIXED ";
	   	String[] bugNumber = BugID.split(".0");
	   	
	    driver.findElement(By.id("quicksearch_top")).sendKeys(bugNumber[0]);
	    driver.findElement(By.id("find_top")).click();
	    
	    String  status = driver.findElement(By.xpath("//*[@id='static_bug_status']")).getText();
	    String[] Status1 =status.split("\\(");
	    String bugStatus =Status1[0];
	    
	 	 System.out.println(bugStatus+"********for bug ID --->"+BugID);
	 
	 	 
	 	 new Select(driver.findElement(By.id("bug_status"))).selectByVisibleText("RESOLVED");
 		driver.findElement(By.id("commit")).click();
 		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
 		
 		driver.findElement(By.xpath("//*[@id='bugzilla-body']/dl/dt/a")).click();
 		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

 		 new Select(driver.findElement(By.xpath("//*[@id='resolution']"))).selectByVisibleText("INVALID");
  		 		
 		driver.findElement(By.xpath("//*[@id='comment']")).sendKeys("This bug is very old and no one is owner for it now hence closing this bug");
 		new Select(driver.findElement(By.id("bug_status"))).selectByVisibleText("Closed");
 		driver.findElement(By.id("commit")).click();
	
	 	 if(res.equals(bugStatus)){
	 		new Select(driver.findElement(By.id("bug_status"))).selectByVisibleText("Closed");
	 		driver.findElement(By.id("commit")).click();
	 		System.out.println("initially status "+status+"********for bug ID --->"+BugID+" Now it is closed");
	 		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 	 }
	 
	}



	@DataProvider
	public  Object[][] getTestData(){
		return Util.getData(suiteXls, this.getClass().getSimpleName());
	}
}
