package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ISelect;

import com.util.BasePage;
import com.util.Logger;

import junit.framework.Assert;

public class Guru99Register extends BasePage {

	@FindBy(id="user_title")
	WebElement titleList;
	
	@FindBy(id="user_surname")
	WebElement snameTxt;
	
	@FindBy(id="user_user_detail_attributes_password_confirmation")
	WebElement confrimPsw;
	
	@FindBy(name="submit")
	WebElement submitBtn;
	
	//@FindBy(className="btn btn-default") Not support
	@FindBy(className="btn-default")
	WebElement loginBtn;
	
	@FindBy(id="fourth")
	WebElement blockFrom;
	
	@FindBy(id="amt7")
	WebElement blockTo;
	
	public Guru99Register(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void SelectTitle(String selectValue) {
		this.Select(titleList, selectValue, 0);
	}
	
	public Boolean IsVisiable() {
		//this.Click(loginBtn);
		System.out.println(this.GetPageTitle());
		Logger.Output(Logger.LogTypeName.INFO, "Test 'get title' function finish.");
		System.out.println(this.GetPageUrl());
		Logger.Output(Logger.LogTypeName.INFO, "Test 'get url' function finish.");
		this.Type(confrimPsw, "text");
		//this.Click(submitBtn);
		return this.VerifyElementIsPresent(loginBtn);
	}
	
	public void DragTest() {
		this.Click(snameTxt);
		Logger.Output(Logger.LogTypeName.INFO, "Test 'mouse event' function finish.");
		this.ScrollToButtom();
		Logger.Output(Logger.LogTypeName.INFO, "Test 'scroll' function finish.");
	}
	
	public void ElementPresent() {
		Assert.assertTrue(VerifyElementIsPresent(titleList));
		Logger.Output(Logger.LogTypeName.INFO, "Test 'element present' function finish.");
	}
	
}
