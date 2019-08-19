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
import com.pageobject.FreshSearch;
import com.util.Logger;
import com.util.Screenshot;


public class FreshSearchTest {
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
		
		freshHome.SwitchTab();
		freshHome.SearchByKeywork();
		
		//SearchPage searchPage=new SearchPage(driver);
		FreshSearch searchPage=PageFactory.initElements(driver, FreshSearch.class);
		//String a=searchPage.GetSearchResult();
		Assert.assertTrue(searchPage.GetSearchResult().contains("sk"));
		searchPage.FileUpload();
		Logger.Output(Logger.LogTypeName.INFO, "Test 'file upload' function finish.");
		Screenshot screenshot=new Screenshot(driver);
		screenshot.ScreenCamera();
		Logger.Output(Logger.LogTypeName.INFO, "Test 'screenshort' function finish.");
	}
	
	@AfterClass
	public void classDown() throws Exception{
		//driver.quit();
	}

}
