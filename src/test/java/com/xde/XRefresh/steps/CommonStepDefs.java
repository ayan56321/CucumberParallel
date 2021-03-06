package com.xde.XRefresh.steps;

import com.aventstack.extentreports.Status;
import com.xde.XRefresh.ExtentListeners.ExtentManager;
import com.xde.XRefresh.ExtentListeners.ExtentTestManager;
import com.xde.XRefresh.PageObjects.ExcelPage;
import com.xde.XRefresh.PageObjects.OfcLandingPage;
import com.xde.XRefresh.PageObjects.OfficeHomePage;
import com.xde.XRefresh.PageObjects.OfficeLoginPage;
import com.xde.XRefresh.PageObjects.XDE_AppPage;
import com.xde.XRefresh.utilities.DriverManager;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonStepDefs extends BaseSteps {

	public OfficeHomePage home;
	//public OfcLandingPage login;

	protected Scenario scenario;
	static String scenarioName;
	static int x = 0;

	@Before
	public synchronized void  before(Scenario scenario) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		x = x + 1;
		this.scenario = scenario;
		scenarioName = scenario.getName();
		ExtentTestManager.startTest("Scenario No : " + x + " : " + scenario.getName());
		ExtentTestManager.getTest().log(Status.INFO, "Scenario started : - " + scenario.getName());
		setUpFramework();
	}

	@After
	public void after(Scenario scenario) {

		if (scenario.isFailed()) {

			ExtentTestManager.logFail("Scenario Failed");
			ExtentTestManager.addScreenShotsOnFailure();
		} else {

			ExtentTestManager.scenarioPass();
		}

		ExtentManager.getReporter().flush();

		quit();

	}
	

	
	@Given("^launch browser \"([^\"]*)\"$")
	public void launch_browser(String browserName) throws Throwable {
		openBrowser(browserName);
		ExtentTestManager.logInfo("Browser Opened : "+browserName);
	}

	@When("^user navigates to the URL \"([^\"]*)\"$")
	public void user_navigates_to_the_URL(String URL) throws Throwable {
		ExtentTestManager.logInfo("URL Navigated : "+URL);
		home = new OfficeHomePage().open(URL);
	}
	
	public OfficeLoginPage login;
	
	@Then("^user click on login$")
	public void user_click_on_login() throws Throwable {		
		 login = home.gotoLogin();
	}
	
	@Then("^user provides UserName and clicks on Next Button$")
	public void user_provides_UserName_and_clicks_on_Next_Button() throws Throwable {		
	
	      login.userNameFunction(getDefaultUserName());			   	   
	}
	
	public OfcLandingPage excel;
	
	@Then("^user provides password and clicks on Login Button$")
	public void user_provides_password_and_clicks_on_Login_Button() throws Throwable {
	    excel = login.passwordFunction(getDefaultPassword());
	}
	
	public ExcelPage appStart ;
	
	@Given("^user clicks on Excel Icon$")
	public void user_clicks_on_Excel_Icon() throws Throwable {
		appStart = excel.gotoExcel();
	}
	
	public XDE_AppPage xde ;
	
	@Given("^user then navigates and clicks on New Blank Workbook$")
	public void user_then_navigates_and_clicks_on_New_Blank_Workbook() throws Throwable {
	    xde = appStart.gotoNewBlankWkBk();
	}
	
	@Given("^user switches to \"([^\"]*)\" Frame$")
	public void user_switches_to_Frame(String webFrameName) throws Throwable {
	    xde.switchtoWebAppFrame(webFrameName);
	}
	
	
	@Given("^user clicks on Insert Button on workbook created$")
	public void user_clicks_on_Insert_Button_on_workbook_created() throws Throwable {
	    xde.insertLink();
	}
	
	


}
