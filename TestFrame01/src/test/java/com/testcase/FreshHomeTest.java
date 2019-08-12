package com.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pageobject.FreshHome;
import com.pageobject.FreshSearch;
import com.util.BrowserEngine;

public class FreshHomeTest {
	WebDriver driver;
	
	@BeforeClass
	public void Setup() {
		//driver = new ChromeDriver();
		//driver.manage().window().maximize();
		BrowserEngine browserEngine=new BrowserEngine("Firefox");
		driver=browserEngine.GetBrowser();
		
		
		driver.get("https://fresh.jd.com/");
		//Thread.sleep(2000);
	}
	
	@Test
	public void CategoryTest() {
		FreshHome freshHome=PageFactory.initElements(driver, FreshHome.class);
		freshHome.SelectCategory_Fruits();
	}
	
	
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	}
	
	
}
