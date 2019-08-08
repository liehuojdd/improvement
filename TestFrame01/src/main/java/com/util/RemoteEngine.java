package com.util;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteEngine {
	private String browserName;
	private WebDriver driver;
	private String remoteUrl;
	
	public RemoteEngine(String broserName) {
		this.browserName=broserName;
	}
	
	public WebDriver GetBrowser(String remoteUrl) {
		try {
			DesiredCapabilities capabilities;
			URL url = new URL(remoteUrl);
			if (browserName.equalsIgnoreCase("Firefox")) {
				capabilities = DesiredCapabilities.firefox();
				capabilities.setJavascriptEnabled(true);
				driver = new RemoteWebDriver(url, capabilities);

			} else if (browserName.equalsIgnoreCase("Chrome")) {
				capabilities=DesiredCapabilities.chrome();
				capabilities.setJavascriptEnabled(true);
				capabilities.setBrowserName("chrome");
				driver = new RemoteWebDriver(url, capabilities);

			} else if (browserName.equalsIgnoreCase("IE")) {
				//IE
			}
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return driver;
	}
}
