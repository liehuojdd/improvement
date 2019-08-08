package com.TestFrame01;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.net.Urls;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteTest {

	public static void main(String[] args) throws Exception {
		WebDriver driver=getDefaultRemoteDriver("http://192.168.96.24:4444/wd/hub");
		//http://localhost:4444/grid/console
		//Selenium selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.google.com");
		//DesiredCapabilities capability = DesiredCapabilities.firefox();
		//WebDriver driver2 = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

	}
    public static WebDriver getDefaultRemoteDriver(String remoteUrl) throws Exception{
    	WebDriver driver=null;
        try {
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setJavascriptEnabled(true);
			//capabilities.setBrowserName("chrome");
			
			URL url = new URL(remoteUrl);
			driver = new RemoteWebDriver(url, capabilities);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://www.baidu.com");
			
			DesiredCapabilities capabilities2 = DesiredCapabilities.chrome();
			capabilities2.setJavascriptEnabled(true);
			capabilities2.setBrowserName("chrome");
			URL url2 = new URL(remoteUrl);
			driver = new RemoteWebDriver(url2, capabilities2);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://www.baidu.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
    }

}
