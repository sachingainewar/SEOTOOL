package com.SHandLeadFormVerification;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MortgageLeanderSection extends LandingPage {


	public void surehitsResults () throws Throwable{
			WebElement list= driver.findElement(By.id("surehitsResults"));
			List<WebElement> count = list.findElements(By.xpath("//*[contains(@class,'SH-listing')]"));
		//	System.out.println(count.size());
						
		//Verify Image logo is opened in new window		
			for(int i=1;i<1;i++){
				
				driver.findElement(By.xpath("//*[@class='company_logo']")).click();
				ClikonLink("Company_logo");
			  
	//"read more profile" Link is opened in new window 		
				driver.findElement(By.linkText("read more profile")).click();				
				ClikonLink("read more link");
				
	/// "Click on Go Button and verify it open in new window "
				driver.findElement(By.xpath("//*[@class='link']")).click();
				ClikonLink("Go button");
		}
	}
}


