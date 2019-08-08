package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.util.BasePage;

public class Guru99Register extends BasePage {

	@FindBy(id="user_title")
	WebElement titleList;
	
	@FindBy(id="BaiDuLink")
	WebElement baiduLink;
	
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
		System.out.println(this.GetPageUrl());
		this.Type(confrimPsw, "text");
		//this.Click(submitBtn);
		return this.VerifyElementIsPresent(loginBtn);
	}
	
	public void SwitchTest() {
		this.Click(baiduLink);
		this.SwitchToMain();
	}
	
	public void DragTest() {
		this.Click(snameTxt);
		this.ScrollToButtom();
	}
	
}
