package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.util.BasePage;

public class FreshSearch extends BasePage {
	
	public FreshSearch(WebDriver driver) {
		super(driver);
	}


	@FindBy (className="ns-content")
	WebElement searchResult;
	
	@FindBy (xpath="//form[@id='search-img-upload']/input")
	WebElement uploadElement;
	
	By searchResultLocator=By.className("ns-content");
	
	
	public String GetSearchResult() {
		//Is that no wait?
		//return searchResult.getText();
		return this.GetText(searchResultLocator);
	}
	
	public void FileUpload() {
        this.FileUpload(uploadElement);
        
	}
}
