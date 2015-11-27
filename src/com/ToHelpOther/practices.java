package com.ToHelpOther;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class practices {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.co.in");
		List <WebElement> aa = driver.findElements(By.tagName("a"));
		for(int i=0 ; i<aa.size();i++)
		{
		System.out.println(aa.get(i).getAttribute("href"));

	}

	}}
