package com.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.util.BasePage;
import com.util.Logger;

import junit.framework.Assert;

public class FreshHome extends BasePage {
	
	public FreshHome(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (className="tab_head_item_inner")
	WebElement category1;
	
	@FindBy (className="element test")
	List<WebElement> category2;
	
	@FindBy (id="key")
	WebElement searchBox;
	
	@FindBy (xpath="//div[@id='search-2014']/div[@class='form']/button")
	WebElement searchButton;
	
	By searchBtnLocator=By.xpath("//div[@id='search-2014']/div[@class='form']/button");
	
	@FindBy(id="shelper")
	WebElement shelper;
	
	@FindBy(xpath="//a[@class='fresh_fs_menu_item'][1]")
	WebElement fsMenu;
	
	
	//Get element
	//element.getAttribute(attr);
	//Assert visiable
	//element.isDisplayed();
	
	
	public void ClickLogin() {
		
	}
	
	public void SelectCategory_Fruits(){
		//If click before search list loadded, it redirect to another search page.
		//shelper.isDisplayed() failed
		try {
			Thread.sleep(1000);
			this.Click(category1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void ClickFsMenu() {
		Click(fsMenu);
		Logger.Output(Logger.LogTypeName.INFO, "Test 'Click by Element' function finish.");
	}
	
	public void SearchByKeywork() {
		try {
			String keyword = "sk";
			
			this.Type(searchBox, keyword);
			this.Clean(searchBox);
			Logger.Output(Logger.LogTypeName.INFO, "Test 'Type' function finish.");
			Logger.Output(Logger.LogTypeName.INFO, "Test 'Clean' function finish.");
			
			this.Type(searchBox, keyword);
			String classValue=this.GetAttributeValue(searchBox, "class");
			Boolean a=this.GetAttributeValue(searchBox, "class").equalsIgnoreCase("text defcolor");
			Assert.assertTrue(classValue.equals("text defcolor"));
			Click(searchBtnLocator);
			Logger.Output(Logger.LogTypeName.INFO, "Test 'Get Attrbute' function finish.");
			Logger.Output(Logger.LogTypeName.INFO, "Test 'Click by selector' function finish.");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void SwitchTab() {
		Click(fsMenu);
		Logger.Output(Logger.LogTypeName.INFO, "Test 'Click by element' function finish.");
		SwitchToMain();
		Logger.Output(Logger.LogTypeName.INFO, "Test 'switch tab' function finish.");
		
	}
}
