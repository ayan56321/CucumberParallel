package com.xde.XRefresh.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.xde.XRefresh.PageObjects.ExcelPage;

public class OfcLandingPage extends BasePage{	
	
	@FindBy(xpath="//div[text()=' Excel ']")
	public WebElement Excel;
	
	@FindBy(xpath="//div[text()=' Word ']")
	public WebElement Word;
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(Excel);
	}

	public ExcelPage gotoExcel() throws InterruptedException {
		Thread.sleep(5000);
		click(Excel,"Excel Link");
		System.out.println("In the Excel page");
		return (ExcelPage) openPage(ExcelPage.class);
	}
	
}
