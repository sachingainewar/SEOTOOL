package com.ToHelpOther;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeywordHighLighter {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Throwable{
		 boolean LastUpdate = true ;
	//	BufferedReader BF = new BufferedReader(new FileInputStream(System.in));  Kety word and cridential 
		String keyword= null;
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.linkedin.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("login-email")).sendKeys("sachingainewar@gmail.com");
		driver.findElement(By.id("login-password")).sendKeys("vidhya12");
		driver.findElement(By.xpath("//*[@value='Sign in']")).click();
		
/// To scroll teh page at the bottom of page 
				while (LastUpdate)
				  {
				/*JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,6000)","");*/
					
					Actions actions = new Actions(driver);
					actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
						try{
							if (driver.findElement(By.xpath("//*[@id='ozfeed']/div[4]/p")).isDisplayed()){
								//.getText().equals("There are no more updates at this time.")){
								LastUpdate=false; 
								System.out.println("@@@@@@@");
								actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();

								}
							}
							catch(Exception e ){continue;}		

					}
				
				// Highlight the keywords 
				
					/*if (LastUpdate==false){
					//HighLighter (driver,"QA");
						try {
							for (int i=0; i<3;i++){
								JavascriptExecutor js = (JavascriptExecutor)driver;
								js.executeScript("arguments[0].setAttribute('style',arguments[1]); ", keyword, "color: red; border:5px soild red;" );
							//	js.executeScript("arguments[0].setAttribute('style', arguments[1]);",keyword, "");
							}
						}
					catch(Exception e ){}	
					}*/
		}

	/*private static void HighLighter(WebDriver driver, String keyword) {
			
	}
*/
}
