package com.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.util.BasePage;

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
	
	public void SelectAllCategory() {
		
	}
	
	public void SearchByKeywork() {
		try {
			String keyword = "sk";
			this.Type(searchBox, keyword);
			this.Clean(searchBox);//Function:Clean Test
			
			this.Type(searchBox, keyword);
			System.out.println("Attrbute class:"+this.GetAttributeValue(searchBox, "class"));//Function: Get Attribute
			Click(searchBtnLocator);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
