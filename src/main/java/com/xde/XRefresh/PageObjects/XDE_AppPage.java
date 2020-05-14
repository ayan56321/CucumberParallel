package com.xde.XRefresh.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class XDE_AppPage extends BasePage {	

	@FindBy(xpath="//iframe[@id='WebApplicationFrame']")
	public WebElement appFrame;
	
	@FindBy(xpath="//*[@id='ribbon-AppAndBrandContainer']/span[text()='Excel']")
	public WebElement excelRibbon;
	
	@FindBy(xpath="//li[@id='m_excelWebRenderer_ewaCtl_Ribbon.Insert-title']/a/span")
	public WebElement titleRibbon;
	
	
	public XDE_AppPage switchtoWebAppFrame(String webFrameName) throws InterruptedException {
		Thread.sleep(2000);
		switchToFrame(webFrameName);
		return this ;
	}
	
	public XDE_AppPage insertLink() throws InterruptedException{		
		Thread.sleep(5000);			
		click(titleRibbon,"Insert Link");
		System.out.println("Clicked on Insert Link");
		return this;
		//return (OfficeLoginPage) openPage(OfficeLoginPage.class);		
	}
	
	

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.frameToBeAvailableAndSwitchToIt(appFrame);
	}

}
