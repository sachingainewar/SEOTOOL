package com.SEO;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.SHandLeadFormVerification.BaseMethod;

public class SEOgenaric extends SEOcommonFunction{
	String pagUrl;
	String htmlTag ;
	

	Map<Integer, Object[]> getData= new HashMap<Integer , Object[] > ();
	public static int counter = 0;
	WebDriver driver =null;
	static Map<Integer , Object[] > output= new HashMap<Integer , Object[] >();

	 @Factory(dataProvider = "getPageUrls")
	    public SEOgenaric(String pagUrl) {
	        this.pagUrl = pagUrl;
	    }
	    
// Test Urls 	
	@DataProvider 
	public Object[][] getPageUrls() throws Exception  { 
	return new Object[][]{ { "http://www.google.com" }, { "http://www.yahoo.com" }, { "http://www.refiy.com" } }; 
	}


	
	@BeforeClass
	public void testPagesOpen(Object[] pag)throws Exception{
		driver= new FirefoxDriver();
		driver.get( pagUrl);
		
	}
	

	@Test(groups = "testFactory", description = "Mutiple")
//Verify Mutuiple tag verificetions and Retrive H1, H2 ,H3 
	public  void Mutiple()throws Exception{
		String[] tagName={"H1","H2","H3" };
		
		for(String currTag : tagName)
		{		
			
			List <WebElement > tagNameObject = driver.findElements(By.tagName(currTag));
			try{
				
				if(!(tagNameObject.size()==1)){
					htmlTag="Mutiple "+ currTag+" tags found" ;
					System.out.println("Mutiple "+ currTag + " is present"+driver.getCurrentUrl());
				}
				else {
					for(WebElement tag: tagNameObject){
					htmlTag = currTag+ " Tag is -" +tag.getText();
					System.out.println("***"+currTag +" tag "+htmlTag+driver.getCurrentUrl());
					}
				}
			} catch(Exception e){
				System.out.println(e.getMessage() + currTag + " tag is Missing");
					htmlTag= "Missing "+currTag  ;
					continue;
			}
			output.put(counter++,new Object[] {htmlTag, driver.getCurrentUrl()});
		}	
	}
		
	@Test(groups = "testFactory", description = "MetaTags")
//Retrive the Meta Keyword and Meta Description 
	public void  MetaTags () throws Exception{
		
		String [] location = {"//meta[@name='keywords']","//meta[@name='description']"};
		String [] tags = {"Meta Keywords" , "Meta Descriptions"};
		int i=0;
		
		for(String MetaTag:location)
		{
			List <WebElement > Meta = driver.findElements(By.xpath(MetaTag));
			try{
				for(WebElement MetaObject: Meta){
					htmlTag = tags[i]+" --> "+MetaObject.getAttribute("content");
					System.out.println(tags[i]+" --> "+MetaObject.getAttribute("content")+driver.getCurrentUrl());
					}
				}
			catch (Exception e){
					htmlTag ="Missing "+tags[i];
					System.out.println(e.getMessage() +"***"+ tags[i]+" --> Missing");
					 continue;
				}		
			output.put(counter++,new Object[] {htmlTag, driver.getCurrentUrl()});

		}
	}


	@Test(groups = "testFactory", description = "AllMinorCondidates")
	public void AllMinorCondidates() throws Exception{
//Verify the Canonical tag is present 
			
		if((driver.getPageSource().contains("canonical"))==true)
		  {
			htmlTag="Canonical tag -" +(driver.getPageSource().contains("canonical"));
			System.out.println("Canonical tag is present on page " +(driver.getPageSource().contains("canonical"))+driver.getCurrentUrl());
		  }
		else{
			System.out.println("Canonical tag NOT present on page ***"+(driver.getPageSource().contains("canonical")));
			htmlTag="Canonical tag NOT Present -" +(driver.getPageSource().contains("canonical"));
		 }
		output.put(counter++,new Object[] {htmlTag, driver.getCurrentUrl()});

	
// Validate 404 Pages
			if (driver.getTitle().startsWith("404")){
				System.out.println("404");
				htmlTag= "404";
				output.put(counter++,new Object[] {htmlTag, driver.getCurrentUrl()});
			}
			else{
				System.out.println("200");
			}
		//	output.put(counter++,new Object[] {htmlTag, driver.getCurrentUrl()});

	
//Nofollow on duplicate links
		List <WebElement > NofollowObject = driver.findElements(By.tagName("a"));

			for(WebElement links: NofollowObject){
				if (!links.getAttribute("rel").equals(null))
				{
					try{
							if (links.getAttribute("rel").equals("nofollow")){
							htmlTag ="NoFollow is present on link -"+links.getText();	
							System.out.println("NoFollow is present on link --> "+links.getText()+" on URl "+driver.getCurrentUrl());
							output.put(counter++,new Object[] {htmlTag, driver.getCurrentUrl()});
							break;
							}
						}
					catch (Exception e){
						System.out.println(e.getMessage() + "Nofollow is NOT present on Duplicate link ");
					   }
					break;
				}	
			}
		//	output.put(counter++,new Object[] {htmlTag, driver.getCurrentUrl()});

		}
	
	
	
//Duplicate title, Missing title,
	@Test(groups = "testFactory", description = "DuplicateTitle")
	public void DuplicateTitle() throws Exception{
		
	//	String[] SEOCandidates = {"driver.getTitle()", "driver.findElement(By.tagName('H1'))" };
		
	//	for(int i=0;i<SEOCandidates.length;i++)
		{
			HashSet<String> title = new HashSet<String>();
	
			if (!title.add(driver.getTitle()))
				{
					htmlTag="Duplidate Title";
					System.out.println("Duplidate Title--> "+driver.getTitle()+"**on url "+driver.getCurrentUrl());
				}
			else{
				System.out.println("Successful ======"+title);
				}
		}
		output.put(counter++,new Object[] {htmlTag, driver.getCurrentUrl()});
	}
	
// Duplicate H1 and  	
	@Test(groups = "testFactory", description = "Duplicate")
	public void Duplicate() throws Exception{
				WebElement[] SEOCandidates = {driver.findElement(By.tagName("H1"))};
			
			for(WebElement H1Description : SEOCandidates)
			{
				HashSet<String> H1 = new HashSet<String>();
				
				if (!H1.add(H1Description.getText()))
					{
						htmlTag="Duplidate H1";	
						System.out.println("Duplidate H1--> "+H1Description.getText()+"**on url "+driver.getCurrentUrl());
					}
				else{
					System.out.println("Successful ======"+H1Description.getText());
					}
			}
			output.put(counter++,new Object[] {htmlTag, driver.getCurrentUrl()});

		}
//broken links and images from  pages 
	@Test(groups = "testFactory", description = "brokenlinks")
		public void brokenlinks() throws ClientProtocolException, IOException{
			 int j=0;
			String [] hyper = {"img", "a"};
			String [] tag = {"src", "href"};
			while(j<hyper.length)
			{
				List <WebElement> ancor = driver.findElements(By.tagName(hyper[j]));
				for(int i=0; i<ancor.size();i++)
				{
					try
					{
						if (!ancor.get(i).equals(null))
						{
							HttpResponse reponse= new DefaultHttpClient().execute(new HttpGet((ancor.get(i)).getAttribute(tag[j]))); 
								
							if((reponse.getStatusLine().getStatusCode())!=200)
							{
								htmlTag="Broken Links "+ancor.get(i).getAttribute(tag[j]) ;
								System.out.println(ancor.get(i).getAttribute(tag[j])+"--Image is broken on url "+ driver.getCurrentUrl());
							}		
						}
					}
					catch(Exception e){System.out.println("javas script is enconter on link ");continue;}
					
				}
				j++;
			}
			output.put(counter++,new Object[] {htmlTag, driver.getCurrentUrl()});

		}
			
// Suggestions : nofollow needs on perticular url 
		
	@Test (groups = "testFactory", description = "SuggestionsNoFollow")
		public void SuggestionsNoFollow()throws Exception
		{
			List <WebElement> ankor = driver.findElements(By.tagName("a"));
			
			for(int i=0 ; i<ankor.size();i++){
				
				String urls  =	ankor.get(i).getAttribute("href");
				try{
					if (!urls.equals(null))
					{
						HashSet<String> herf = new HashSet<String>();
								
							if (!herf.add(urls))
								{
									System.out.println("Duplidate urls--> "+ankor.get(i).getText()+"**on url "+driver.getCurrentUrl());
									
										try{
											if (ankor.get(i).getAttribute("rel").equals("nofollow")){
											System.out.println("NoFollow is present on link --> "+ankor.get(i).getText()+" on URl "+driver.getCurrentUrl());
											}
										}
									catch (Exception e){
										System.out.println(e.getMessage() + "Nofollow is present on link is NOT present"+ ankor.get(i).getText()+" on URl "+driver.getCurrentUrl());
										htmlTag="Suggested:- Add noFollow on "+ankor.get(i).getText();
										continue;
									   }
	
								}
					}
				 }	
				catch (Exception e){continue;}
				}
			output.put(counter++,new Object[] {htmlTag, driver.getCurrentUrl()});

		}
	
//Nofollow on external links 	
	@Test (groups = "testFactory", description = "NofollowOnExternalLinks")
	public void NofollowOnExternalLinks()throws Exception
	{
		List<WebElement> a= driver.findElements(By.tagName("a"));
		for(int i=0 ; i<a.size();i++)
		{
			String urls  =	a.get(i).getAttribute("href");
			try{
					if(!urls.equals(null))
						{
							String Domain[]= driver.getCurrentUrl().split(".com");
							String External[] = urls.split(".com");
							if (!Domain[0].equals(External[0]))
							{
								try{
									if (!((WebElement) a).getAttribute("rel").equals("nofollow")){
										htmlTag= "Suggested :- add OnFollow "+a.get(i).getText();
										System.out.println("Suggested :- add OnFollow "+a.get(i).getText());
									}
								  }
								  catch(Exception e){continue;}
							}
						 }
				
				}
			catch(Exception e){continue;}
		
		}
		output.put(counter++,new Object[] {htmlTag, driver.getCurrentUrl()});

	}
		
		
	@AfterMethod
	public Map<Integer, Object[]> Results(){
	//	getData.put(htmlTag , driver.getCurrentUrl());
		getData.putAll(output);
		return getData;
	}
	

	@AfterTest
	public void  WriteExcel(){
		//SEOgenaric dataToWrite = new SEOgenaric(htmlTag);
		Map writeList= new HashMap<Integer , Object[] >();
		Map temp = new HashMap ();
		temp =getData;
		temp.keySet().removeAll(writeList.keySet());
		writeList.putAll(temp); 
		SEOcommonFunction.writeListToExcel(writeList);
	
		
	}

}	
	
	
