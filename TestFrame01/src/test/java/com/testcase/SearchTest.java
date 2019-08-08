package com.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageobject.FreshHome;
import com.pageobject.SearchPage;
import com.util.Screenshot;


public class SearchTest {
	WebDriver driver;
	@BeforeClass
	public void Setup() {
		driver = new ChromeDriver();
		driver.get("https://fresh.jd.com/");
		//Thread.sleep(2000);
	}
	
	@Test(priority=0)
	public void SearchTest() throws Exception {
		FreshHome freshHome=PageFactory.initElements(driver, FreshHome.class);
		freshHome.SearchByKeywork();
		
		//SearchPage searchPage=new SearchPage(driver);
		SearchPage searchPage=PageFactory.initElements(driver, SearchPage.class);
		//String a=searchPage.GetSearchResult();
		Assert.assertTrue(searchPage.GetSearchResult().contains("sk"));
		//searchPage.FileUpload();
		Screenshot screenshot=new Screenshot(driver);
		screenshot.ScreenCamera();
		
	}
	
	@AfterClass
	public void classDown() throws Exception{
		driver.quit();
	}

}
