package com.xde.XRefresh.PageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xde.XRefresh.ExtentListeners.ExtentTestManager;
import com.xde.XRefresh.utilities.DriverManager;

public abstract class BasePage<T> {
	
	protected WebDriver driver;
	
	  private long LOAD_TIMEOUT = 30;
     private int AJAX_ELEMENT_TIMEOUT = 10;

	    public BasePage() {
	        this.driver = DriverManager.getDriver();
	    }
	    
	    public T openPage(Class<T> absClass) {
	        T page = null;
	        try {
	            driver = DriverManager.getDriver();
	            AjaxElementLocatorFactory ajaxElemFactory = new AjaxElementLocatorFactory(driver, AJAX_ELEMENT_TIMEOUT);
	            page = PageFactory.initElements(driver, absClass);
	            PageFactory.initElements(ajaxElemFactory, page);
	            ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
	            waitForPageToLoad(pageLoadCondition);
	        } catch (NoSuchElementException e) {
	        /*    String error_screenshot = System.getProperty("user.dir") + "\\target\\screenshots\\" + clazz.getSimpleName() + "_error.png";
	            this.takeScreenShot(error_screenshot);
	     */       throw new IllegalStateException(String.format("This is not the %s page", absClass.getSimpleName()));
	        }
	        return page;
	    }

	    private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
	    	WebDriverWait wait = new WebDriverWait(driver,LOAD_TIMEOUT);
	        wait.until(pageLoadCondition);
	    }

	    protected abstract ExpectedCondition getPageLoadCondition();

		
		public void click(WebElement element, String elementName) {
			element.click();
			ExtentTestManager.testReport.get().info("Clicking on : "+elementName);
			
		}
		
		public void type(WebElement element, String value, String elementName) {
			
			element.sendKeys(value);
			ExtentTestManager.testReport.get().info("Typing in : "+elementName+" entered the value as : "+value);
		
		}
	
}
