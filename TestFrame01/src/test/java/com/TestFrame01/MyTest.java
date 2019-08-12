package com.TestFrame01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.pageobject.FreshHome;
import com.pageobject.FreshSearch;
import com.testcase.FreshHomeTest;
import com.util.BrowserEngine;
import com.util.DBConnection;
import java.security.Key;
import javax.crypto.Cipher;


public class MyTest {

	public static void main(String[] args) throws Exception {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://fresh.jd.com/");
		FreshHome freshHome=PageFactory.initElements(driver, FreshHome.class);
		freshHome.SearchByKeywork();
		
		//SearchPage searchPage=new SearchPage(driver);
		FreshSearch searchPage=PageFactory.initElements(driver, FreshSearch.class);
		String a=searchPage.GetSearchResult();
		searchPage.FileUpload();
		String b="";
	}

}
