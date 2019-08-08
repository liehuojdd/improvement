package com.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	private WebDriver driver;
	
	public Screenshot(WebDriver driver) {
		this.driver=driver;
	}
	/**
	 * Take a screen capture in screenshot folder
	 * Auto create an folder in project, named the screen capture by date
	 */
	public void ScreenCamera(){
		
		  String dir_name = "Screenshot";
		  if (!(new File(dir_name).isDirectory())) {
		     new File(dir_name).mkdir();
		  }
		 
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		  String time = sdf.format(new Date());
		 
		  try {
		     File source_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		     FileUtils.copyFile(source_file, new File(dir_name + File.separator + time + ".png")); 
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
	}
}
