package com.xde.XRefresh.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExcelPage extends BasePage{
	
	@FindBy(xpath="//*[@title='New blank workbook']")
	public WebElement newBlankWkBk;
	
	public XDE_AppPage gotoNewBlankWkBk() {
		click(newBlankWkBk,"New blank WorkBook Link");
		System.out.println(" New Blank WorkBook Clicked");
		//switchToFrame("WebApplicationFrame");
		return (XDE_AppPage) openPage(XDE_AppPage.class);
	}
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(newBlankWkBk);
	}


}
