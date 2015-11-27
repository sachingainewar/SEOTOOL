package com.SHandLeadFormVerification;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.SHandLeadFormVerification.LandingPage;



public class SideFilterVerification extends LandingPage{

	
	public  void RightFilterVerification() {
		
		WebElement fiter= driver.findElement(By.id("sidebar"));
		new Select(driver.findElement(By.id("ssc"))).selectByVisibleText("Kansas");
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='arm']")).click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='arm_rates']/label[3]/input")).click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='updateSubmit']")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
	}
	public void RightSideCoteForm(){
		driver.findElement(By.xpath("//*[@class='refine_quote']/div[2]/input")).click();
		Set<String> windID= driver.getWindowHandles();
		Iterator iter3 = windID.iterator();
		String windowAbondon= (String) iter3.next();
		String windowLead = (String) iter3.next();
		if (windowLead.isEmpty()){
			System.out.println("Get Quotes Button is not working from left rail just below the Filter section ");
		}
		System.out.println("Get Quotes Button is functional");
	}
}


