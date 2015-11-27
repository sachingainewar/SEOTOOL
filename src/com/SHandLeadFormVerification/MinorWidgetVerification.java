package com.SHandLeadFormVerification;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MinorWidgetVerification extends LandingPage{
	
	public void qsmrWidgetContainer() throws Throwable{
// SH Banner from bottom of page 		
		WebElement a= driver.findElement(By.id("qsmrWidgetContainer"));
		a.findElement(By.className("logo")).click();
			
		ClikonLink("LogoSHBanner");
			
	
//SH banner from botoom of page click on Go button		
		a.findElement(By.className("goBtn")).click();
		ClikonLink("GoButtonSHBanner");
		
	}

}
