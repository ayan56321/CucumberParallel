package com.xde.XRefresh.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.xde.XRefresh.utilities.DriverManager;

public class OfficeHomePage extends BasePage {
		
	@FindBy(xpath="//*[@id='hero-banner-sign-in-to-office-365-link']")
	public WebElement logInBtn;
	
	public OfficeHomePage open(String url) {
	
		System.out.println("Page Opened");
		DriverManager.getDriver().navigate().to(url);
		return (OfficeHomePage) openPage(OfficeHomePage.class);
	}
	
	public OfficeLoginPage gotoLogin(){
		System.out.println("inside go to login");
		click(logInBtn , "Login Link");
		return (OfficeLoginPage) openPage(OfficeLoginPage.class);
	}


	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(logInBtn);
	}
	
	
	

}
