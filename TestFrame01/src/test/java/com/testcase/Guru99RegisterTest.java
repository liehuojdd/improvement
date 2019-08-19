package com.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pageobject.FreshHome;
import com.pageobject.Guru99Register;
import com.util.BrowserEngine;
import com.util.Logger;

public class Guru99RegisterTest {
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	public void Setup(String bAliasName) {
		BrowserEngine browserEngine=new BrowserEngine(bAliasName);
		driver=browserEngine.GetBrowser();
		String url="http://demo.guru99.com/insurance/v1/register.php";
		//String url="http://localhost:8079/demo/Register.html";
		driver.get(url);
		//Thread.sleep(2000);
	}
	
	@Test
	public void Guru99Register() {
		Guru99Register guru99=PageFactory.initElements(driver, Guru99Register.class);
		guru99.SelectTitle("Miss");
		Logger.Output(Logger.LogTypeName.INFO, "Test 'Select list' function finish.");
		
		//System.out.println("Login button visiable: "+guru99.IsVisiable());
	}
	
	@Test
	public void DragTest() {
		Guru99Register guru99=PageFactory.initElements(driver, Guru99Register.class);
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		guru99.DragTest();
	}
	
	@Test
	public void ElementPresent() {
		Guru99Register guru99=PageFactory.initElements(driver, Guru99Register.class);
		driver.get("http://demo.guru99.com/insurance/v1/register.php");
		guru99.ElementPresent();
		
		//System.out.println("Login button visiable: "+guru99.IsVisiable());
	}
	
	
	@AfterClass
	public void TearDown() {
		//driver.quit();
	}
}
