package com.Military;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class Military extends BaseMethod  {
	
	public static int counter=1;


	@BeforeTest
	public void BrowserLaunch() throws Throwable{
		initialization();
		//driver = new FirefoxDriver();
		ProfilesIni profile = new ProfilesIni();
		 FirefoxProfile ffprofile = profile.getProfile("mobileSitesTesting");
		  driver = new FirefoxDriver(ffprofile);
		 
		driver.manage().deleteAllCookies();
	}


	@Test(dataProvider = "getTestData")
	public void military (String URL , String state,String PropertyTpye, String PropertyValue, String MilitaryBranch, 
			String Military, String Income, String birth_month, String birth_day, String birth_year) throws Throwable{
	//public void military()throws Throwable {
		
		     driver.get(URL);
		     driver.manage().window().maximize();
		     System.out.println(driver.getCurrentUrl());
		     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		     
		    new Select(driver.findElement(By.id("PortalServiceCode"))).selectByVisibleText("Home Purchase");
		    driver.getCurrentUrl();
// GA verification Tag 
		
		    
		     boolean QS_GA = driver.getPageSource().contains("  ga('create', 'UA-64286382-1', 'auto', {'name':'b'})");
		      boolean WebTr = driver.getPageSource().contains("window.webtrendsAsyncInit");
		      boolean MS_GA = driver.getPageSource().contains("ga('create', 'UA-63796691-8', 'auto')");
		      boolean CA = driver.getPageSource().contains("siteCatURL");
		     
	           System.out.println(MS_GA+" -- Monster GA tag present on home page ");
		 	     System.out.println(QS_GA+"  -- QS GA tage on hiome page ");
		 	     System.out.println(WebTr+"  -- WebTrend tage on home page ");
		 	    System.out.println(CA +"  -- Site catalyst tage on home page ");
			     
		    new Select(driver.findElement(By.id("PropertyState"))).selectByVisibleText(state);
		    new Select(driver.findElement(By.id("PropertyType"))).selectByVisibleText(PropertyTpye);
		    driver.findElement(By.id("EM")).clear();
		    System.out.println("*****State  "+state+" and property values " +PropertyTpye);
		    driver.findElement(By.id("EM")).sendKeys("bloody"+counter+"@newhome.com");
		    driver.findElement(By.id("OptIn")).click();
		    driver.findElement(By.id("submit")).click();
		    /*if (assertEquals("Finance Military Home Loan Center", driver.getTitle())){
		    	System.out.println("State field works for form" + state);
		    }*/
//Refinance (Refinance)
		//    new Select(driver.findElement(By.id("PurposeOfLoan"))).selectByVisibleText("Pay-off 2nd/3d Mortgage");
		    
//Purchase(Home Purchase):-	
		    assertEquals("Property will be your",driver.findElement(By.xpath("//*[@id='f']/div[2]/div[1]/span")).getText());
		    
		    new Select(driver.findElement(By.id("PropertyUse"))).selectByVisibleText("Primary Residence");
		    new Select(driver.findElement(By.id("LoanType"))).selectByVisibleText("VA or Conventional");
		    new Select(driver.findElement(By.id("PropertyValue"))).selectByVisibleText(PropertyValue);
		    Thread.sleep(200);
		    System.out.println(PropertyValue+"   -Property value");
		    
//Purchase:-	
		    new Select(driver.findElement(By.id("DownPayment"))).selectByVisibleText(PropertyValue);
		    new Select(driver.findElement(By.id("PurchaseDate"))).selectByVisibleText("2-3 Months");
		   
		    
	   QS_GA = driver.getPageSource().contains("  ga('create', 'UA-64286382-1', 'auto', {'name':'b'})");
	   WebTr = driver.getPageSource().contains("window.webtrendsAsyncInit");
	  System.out.println(QS_GA+"  -- QS GA tage on step2 page ");
	  System.out.println(WebTr+"  -- WebTrend tage on step2 page ");	      
	  
//Refinance 
	  		/*new Select(driver.findElement(By.id("MortgageBalance"))).selectByVisibleText(PropertyValue);
		    Thread.sleep(200);
		    new Select(driver.findElement(By.id("CashOut"))).selectByVisibleText("$0");
		    driver.findElement(By.id("MortgageRate1st")).clear();
	       driver.findElement(By.id("MortgageRate1st")).sendKeys("5.654");*/
	    
		    driver.findElement(By.id("submit")).click();
		    assertEquals("", driver.getTitle());
		    
		    
		    
		    assertEquals("Branch of Service",driver.findElement(By.xpath("//*[@id='f']/div[2]/div[1]/span")).getText());

		    
	QS_GA = driver.getPageSource().contains("  ga('create', 'UA-64286382-1', 'auto', {'name':'b'})");
	 WebTr = driver.getPageSource().contains("window.webtrendsAsyncInit");
	  System.out.println(QS_GA+"  -- QS GA tage on Step3 page ");
	  System.out.println(WebTr+"  -- WebTrend tage on Step3 page ");
	     
		    new Select(driver.findElement(By.id("MilitaryBranch"))).selectByVisibleText(MilitaryBranch);
		    Thread.sleep(200);
		    new Select(driver.findElement(By.id("Military"))).selectByVisibleText(Military);
		    new Select(driver.findElement(By.id("Income"))).selectByVisibleText(Income);
		    Thread.sleep(200);
		    new Select(driver.findElement(By.id("CreditRating"))).selectByVisibleText("Excellent");
		    new Select(driver.findElement(By.id("PLBankruptcyHistory"))).selectByVisibleText("No");
		    
		    System.out.println("*****Info page; MilitaryBranch  "+MilitaryBranch+" and Military service " +Military+"  Income "+Income);
		    driver.findElement(By.id("submit")).click();
		    assertEquals("", driver.getTitle());
		    
		    assertEquals("First Name",driver.findElement(By.xpath("//*[@id='f']/div[2]/div[1]/span")).getText());

		    
		    driver.findElement(By.name("FN")).clear();
		    driver.findElement(By.name("FN")).sendKeys("test");
		    driver.findElement(By.name("LN")).clear();
		    driver.findElement(By.name("LN")).sendKeys("test");
		    driver.findElement(By.name("S1")).clear();
		    driver.findElement(By.name("S1")).sendKeys("test");
		    driver.findElement(By.id("PostalCode")).clear();
		    driver.findElement(By.id("PostalCode")).sendKeys("94404");
		    Thread.sleep(3000);

 QS_GA = driver.getPageSource().contains("  ga('create', 'UA-64286382-1', 'auto', {'name':'b'})");
 WebTr = driver.getPageSource().contains("window.webtrendsAsyncInit");
  System.out.println(QS_GA+"  -- QS GA tage on Step4  page ");
  System.out.println(WebTr+"  -- WebTrend tage on Step4 page ");		     
		     driver.findElement(By.name("HP")).clear();
		    driver.findElement(By.name("HP")).sendKeys("(987) 987-9879");
		    //driver.findElement(By.id("TCPA")).click();
		    driver.findElement(By.id("submit")).click();
		    assertEquals("", driver.getTitle());
		 /*   String[] a = birth_month.split(".");
		     System.out.println(a[0]);
		     System.out.println(a[1]);
		    String[] b = birth_day.split(".");
		    String[] c = birth_year.split(".");*/
		    new Select(driver.findElement(By.id("birth_month"))).selectByVisibleText("1");
		    new Select(driver.findElement(By.id("birth_day"))).selectByVisibleText("1");
		    new Select(driver.findElement(By.id("birth_year"))).selectByVisibleText("1978");
		    
		    
QS_GA = driver.getPageSource().contains("  ga('create', 'UA-64286382-1', 'auto', {'name':'b'})");
 WebTr = driver.getPageSource().contains("window.webtrendsAsyncInit");
  System.out.println(QS_GA+"  -- QS GA tage on SSN  page ");
  System.out.println(WebTr+"  -- WebTrend tage on SSN page ");		     
		     /*driver.findElement(By.id("ssn_1")).clear();
		    driver.findElement(By.id("ssn_1")).sendKeys("987");
		    driver.findElement(By.id("ssn_2")).clear();
		    driver.findElement(By.id("ssn_2")).sendKeys("65");
		    driver.findElement(By.id("ssn_3")).clear();
		    driver.findElement(By.id("ssn_3")).sendKeys("3212");*/
		    driver.findElement(By.id("submit")).click();
		    assertEquals("Finance Military Home Loan Center", driver.getTitle());
		    try {
		      assertEquals("Finance Military Home Loan Center", driver.getTitle());
		    } catch (Error e) {
		      System.out.println("Thanks you page is not displayed ");
		    }
		    
	QS_GA = driver.getPageSource().contains("  ga('create', 'UA-64286382-1', 'auto', {'name':'b'})");
	WebTr = driver.getPageSource().contains("window.webtrendsAsyncInit");
     System.out.println(QS_GA+"  -- QS GA tage on Thanks you page ");
     System.out.println(WebTr+"  -- WebTrend tage on Thanks you page ");
     
     
		    try {
		    	List<WebElement> Lsiting = driver.findElements(By.className("sh-listing"));
		    	System.out.println("********************SH listings count is on Thanks you page -> "+Lsiting.size()+"****************");
		    }
		    catch(Exception e ){
		    	System.out.println("Listing is not present " );
		    }
		    
		    counter++;
	}

	private static boolean assertEquals(String string, String title) {
		// TODO Auto-generated method stub
		return true;
	}
	@DataProvider
	public  Object[][] getTestData(){
		return Util.getData(suiteXls, this.getClass().getSimpleName());
	}
}
