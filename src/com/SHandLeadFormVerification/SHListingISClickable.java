package com.SHandLeadFormVerification;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.SHandLeadFormVerification.LandingPage;

public class SHListingISClickable extends LandingPage {


	public void SHListingClickable() throws Throwable{
		System.out.println("*******Welcome on SHlising testing section************");
		String APRStart= "//*[@id='mortgage_rates']/div/div[";
		String APRlast = "]/div[1]/div[2]/div[1]/p[2]";
		
		WebElement ram= driver.findElement(By.id("mortgage_rates"));
		WebElement shreeRam= ram.findElement(By.className("box"));
		List<WebElement> countList= shreeRam.findElements(By.xpath("//*[contains(@class,'listing')]"));
		//System.out.println(countList.size());
		for(int i=2; i<3;i++){
			String start = "//*[@id='mortgage_rates']/div/div[";
			String last = "]/div[1]/div[1]/span/img";
			driver.findElement(By.xpath(start+i+last)).click();
			ClikonLink("LogoImage-SHListing");
			
	//Verified the Go button is clickable 	
			String Gostart = "//*[@id='mortgage_rates']/div/div[";
			String GoLast = "]/div[1]/div[3]/div/span/img";
			driver.findElement(By.xpath(Gostart+i+GoLast)).click();
			ClikonLink("GoButton-SHListing");
			
			
	// Verified the link in 30 years is clickable
			
			driver.findElement(By.xpath(APRStart+i+APRlast)).click();
			String a= "//*[@id='mortgage_rates']/div/div[2]/div[2]/table/tbody/tr[";
			String b= "]/td[1]/span";
			driver.findElement(By.xpath(a+i+b)).click();
			ClikonLink("30YearAPRLinks-SHListing");
		}
	}
}

