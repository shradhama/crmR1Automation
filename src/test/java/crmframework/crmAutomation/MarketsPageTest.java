package crmframework.crmAutomation;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AppLandingPage;
import pageObjects.CRMAccountsPage;
import pageObjects.CRMAddMarketingRelationshipOwner;
import pageObjects.CRMContactPage;
import pageObjects.CRMHomePage;
import pageObjects.CRMIncentiveDetailsPage;
import pageObjects.CRMIncentiveTab;
import pageObjects.CRMIncentivesPage;
import pageObjects.CRMLandingPage;
import pageObjects.CRMListManagementPage;
import pageObjects.CRMLoginPage;
import pageObjects.CRMMarketsPage;
import pageObjects.CRMPeoplePage;
import pageObjects.CRMRegistrationsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class MarketsPageTest extends base {
	
	public WebDriverWait wait;
	public String accnameText;
	public String phoneno;
	public GenerateData genData;
	public String buysatCorplvl, outofbusiness;
	public String ContactFirstName;
	public String ContactLastName;
	CRMLandingPage lap;
	CRMLoginPage lp;
	AppLandingPage alp;
	CRMHomePage hp;
	CRMAccountsPage ap;
	CRMIncentiveTab inc;
	CRMAddMarketingRelationshipOwner amro;
	CRMMarketsPage mp;
	Actions act;
	CRMContactPage cp;
	CRMPeoplePage pl;
	Utility utl;
	CRMIncentivesPage in;
	CRMIncentiveDetailsPage ind;
	CRMListManagementPage lmp;
	CRMRegistrationsPage reg;
	public String listNameText;
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		genData=new GenerateData();
		utl=new Utility(driver);
		utl.verifyLoginFunctionality(); //requires for Parallel text execution
	}
	
	/*@Test(priority=1)
	public void TS001_VerifyHomePageTest() throws IOException, InterruptedException {

		//The purpose of this test case to verify:-
		//TS1- Login to CRM Application and  Select published Apps (Demand Driver Management)

		driver.get(prop.getProperty("url")); //CRM App
		driver.manage().window().maximize();
		lap = new CRMLandingPage(driver);
		lap.getLogin().sendKeys(System.getenv("username"));
		lap.getnext().click();

		lp= new CRMLoginPage(driver);
		lp.getpwd().click();
		lp.getpwd().sendKeys(System.getenv("password"));
		Thread.sleep(15000);
		lp.getsignin().click();
		//Wait to enter the verification code from Mobile
		Thread.sleep(30000);
		lp.getVerify().click();
		lp.getdontshowcheckbox().click();
		lp.getsigninYes().click();
		//to wait on Published App Landing page
		Thread.sleep(15000);
		driver.switchTo().frame("AppLandingPage");
		alp = new AppLandingPage(driver);
		//select Demand Driver application on Landing Page
		alp.getddm().click();

		hp = new CRMHomePage(driver);
		hp.getHometitle().isDisplayed();
		System.out.println("Login to CRM successfully");
	}*/
	
	@Test(priority=2)
	public void TS002_VerifyJuniperMarketRecordTiedToJuniperMarketChannelTest() throws IOException, InterruptedException, ParseException {

		//The purpose of this test case to:-
		//T556- Verify the Juniper Market record in Market entity tied to the JuniperMarket Channel
		
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		mp = new CRMMarketsPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Click Markets tab from left menu
		hp.getMarketsTab().click();
		
		//Click on 'Search' entry field and Enter a search term 'Juniper' in the field
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys("Juniper");
		
		//Click on 'Start Search' icon
		ap.getclicksearchbutton().click();
		Thread.sleep(3000);
		Assert.assertTrue(ap.getValidateAccnameInSearchResults().getAttribute("title").contains("Juniper Pre-Launch"));
		System.out.println("The Juniper Marketplace Market is displayed under Active Markets");
		
		//Open that Juniper market record from search results
		ap.getValidateAccnameInSearchResults().click();
		
		//Verify that 'Juniper Pre-Launch' Market details page should be displayed
		Assert.assertTrue(mp.getMarketPageTitle().getText().contains("Juniper Pre-Launch"));
		
		//Verify the Channel name associated with Juniper Pre-Launch Market record
		Assert.assertTrue(mp.getSelectedChannelName().getText().contains("JuniperMarket"));
		
		//Get the Start Date
		String enddate = mp.getMarketEndDate().getAttribute("value");
		String startdate = mp.getMarketStartDate().getAttribute("value");
		DateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");
		
		Date Sdate = dateFormat.parse(startdate);
		Date Edate = dateFormat.parse(enddate);
		System.out.println("Start Date:"+Sdate);
		System.out.println("End Date:"+Edate);
		
		//Verify the End Date of 'Juniper Pre-Launch' Market should not be expired
		Assert.assertTrue(Edate.after(Sdate));
		
		//Click on Channel name (JuniperMarket) to open the Channel record
		mp.getSelectedChannelName().click();
		
		//Channel details page (JuniperMarket) page should be displayed
		Assert.assertTrue(mp.getChannelPageTitle().getText().contains("JuniperMarket"));
		
		//Verify Campus on 'JuniperMarket' Channel page
		Assert.assertTrue(mp.getSelectedCampusName().getText().contains("Digital"));
	}
	
}
