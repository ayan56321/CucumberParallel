package com.xde.XRefresh.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OfficeLoginPage extends BasePage {
	
	@FindBy(xpath="//*[@name='loginfmt']")
	public WebElement userNameField ;
	
	@FindBy(xpath="//*[@id='idSIButton9']")
	public WebElement nextButton ;
	
	@FindBy(xpath="//*[@name='passwd']")
	public WebElement passwordField ;
	
	@FindBy(xpath="//*[@id='idSIButton9']")
	public WebElement logInButton ;

	public OfficeLoginPage doLoginAsInvalidUser(String username, String password) throws InterruptedException {
		type(userNameField, username, "UserName");		
		click(nextButton,"Next Button");		
		Thread.sleep(5000);		
		type(passwordField, password, "PassWord");
		click(logInButton,"LogIn Button");

		return this;

	}

	public OfcLandingPage doLoginAsValidUser(String username, String password) throws InterruptedException {
		type(userNameField, username, "UserName");		
		click(nextButton,"Next Button");		
		Thread.sleep(5000);		
		type(passwordField, password, "PassWord");
		click(logInButton,"LogIn Button");

		return (OfcLandingPage) openPage(OfcLandingPage.class);
	}
	
	public OfficeLoginPage userNameFunction(String username) throws InterruptedException{		
		Thread.sleep(2000);
		type(userNameField, username, "UserName");	
		click(nextButton,"Next Button");
		
		return this;
		//return (OfficeLoginPage) openPage(OfficeLoginPage.class);		
	}
	
	public OfcLandingPage passwordFunction(String password) throws InterruptedException{		
		Thread.sleep(2000);
		type(passwordField, password, "PassWord");
		click(logInButton,"LogIn Button");

		return (OfcLandingPage) openPage(OfcLandingPage.class);	
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(userNameField);
	}

}
