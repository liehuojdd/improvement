package com.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pageobject.FreshHome;
import com.pageobject.Guru99Register;
import com.util.BrowserEngine;

public class Guru99RegisterTest {
	WebDriver driver;
	
	@BeforeClass
	public void Setup() {
		BrowserEngine browserEngine=new BrowserEngine("Firefox");
		driver=browserEngine.GetBrowser();
		//http://demo.guru99.com/insurance/v1/register.php
		//http://localhost:8079/demo/Register.html
		driver.get("http://localhost:8079/demo/Register.html");
		//Thread.sleep(2000);
	}
	
	@Test
	public void Guru99Register() {
		Guru99Register guru99=PageFactory.initElements(driver, Guru99Register.class);
		guru99.SelectTitle("Miss");
		System.out.println("Login button visiable: "+guru99.IsVisiable());
		guru99.SwitchTest();
	}
	
	@Test
	public void DragTest() {
		Guru99Register guru99=PageFactory.initElements(driver, Guru99Register.class);
		//driver.get("http://demo.guru99.com/test/drag_drop.html");
		guru99.DragTest();
	}
	
	
	@AfterClass
	public void TearDown() {
		//driver.quit();
	}
}
