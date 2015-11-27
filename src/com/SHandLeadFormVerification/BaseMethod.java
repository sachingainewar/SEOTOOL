package com.SHandLeadFormVerification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.utility.Xls_Reader;

public class BaseMethod {

	//initialization of excel
		public static Xls_Reader suiteXls= null;
		public static  WebDriver driver = null;
	//	public static HtmlUnitDriver driver= null;
		public static boolean isInitalized= false;
		public static String col1;
		
		public void initialization()throws Throwable{
			if(!isInitalized){
			//	suiteXls = new Xls_Reader("C://Users//sgainewar//workspace//POM//src//xls//testData.xlsx");
			
			suiteXls = new Xls_Reader(System.getProperty("user.dir")+"//src//com//xls//testData.xlsx");
			isInitalized = true; 
			}
			
			
		}
		
}
