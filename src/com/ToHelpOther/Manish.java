package com.ToHelpOther;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class Manish {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		HtmlUnitDriver driver = new HtmlUnitDriver();
		//driver.setJavascriptEnabled(true);
		driver.get("http://www.estudenaanhanguera.com/2step/index.jsp?theme=anhangueraV2");
		Cookie Landing = driver.manage().getCookieNamed("JSESSIONID");

		System.out.println(driver.manage().getCookieNamed("JSESSIONID")+"  On Landing page");
		driver.findElement(By.id("CampusType")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.name("AreaOfInterest")).click();
		new Select(driver.findElement(By.xpath("//*[@id='html_AreaOfInterest']/select"))).selectByVisibleText("Comunicação e Mídia");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("EducationLevel_prompt")).click();
	    new Select(driver.findElement(By.id("EducationLevel"))).selectByVisibleText("Especialização");
		driver.findElement(By.id("PC")).clear();
		driver.findElement(By.id("PC")).sendKeys("04546");
		/*driver.findElement(By.name("AreaOfInterest")).click();
		new Select(driver.findElement(By.name("AreaOfInterest"))).selectByVisibleText("Ciências Sociais");
		new Select(driver.findElement(By.id("EducationLevel"))).selectByVisibleText("Ensino médio completo");*/
	//	driver.findElement(By.id("submitBtn")).click();
		new Select(driver.findElement(By.xpath("//*[@id='html_AreaOfInterest']/select"))).selectByVisibleText("Comunicação e Mídia");
		driver.findElement(By.id("submitBtn")).click();

		Cookie Step2 = driver.manage().getCookieNamed("JSESSIONID");

		System.out.println(driver.manage().getCookieNamed("JSESSIONID")+"   On Step2 Page");
		
		driver.findElement(By.id("FN")).clear();
		driver.findElement(By.id("FN")).sendKeys("test");
		driver.findElement(By.id("LN")).clear();
		driver.findElement(By.id("LN")).sendKeys("test");
		driver.findElement(By.id("EM")).clear();
		driver.findElement(By.id("EM")).sendKeys("test@test.com");
		driver.findElement(By.id("HP")).clear();
		driver.findElement(By.id("HomeCountryCode")).sendKeys("22");
		driver.findElement(By.id("HP")).sendKeys("55555555");
		new Select(driver.findElement(By.id("ProgramOfInterest"))).selectByVisibleText("Marketing (a distância)");
		driver.findElement(By.id("submitBtn")).click();
		assertEquals("Estude na Anhanguera", driver.getTitle());
		Cookie Thanks = driver.manage().getCookieNamed("JSESSIONID");

		System.out.println(driver.manage().getCookieNamed("JSESSIONID")+"   on Thanks page");
		
		if(Landing.equals(Step2)&&Step2.equals(Thanks)){
						System.out.println("*****Cookies on all page are same ");
		}
		else {
			System.out.println("*****Cookies NOT matched doesnt looks stiky ");

		}

	}

	private static void assertEquals(String string, String title) {
		// TODO Auto-generated method stub
		
	}

}
