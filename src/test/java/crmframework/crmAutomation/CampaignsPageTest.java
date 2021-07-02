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
import pageObjects.CRMCampaignsPage;
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
public class CampaignsPageTest extends base {
	
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
	CRMCampaignsPage camp;
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
	public void TS002_VerifySetupCampaignsInD365Test() throws IOException, InterruptedException, ParseException {

		//The purpose of this test case to:-
		//T557- Verify setup of Campaigns in D365
		
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		camp = new CRMCampaignsPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Click on Campaigns in the left menu
		hp.getCampaignsTab().click();
		
		//Click + New button to create new Campaign
		camp.getCreateNewCampaignBtn().click();
		
		//Verify that New Campaign page should be displayed
		Assert.assertTrue(camp.getNewCampaignPageTitle().isDisplayed());
		
		//Type in the name of your Campaign on form
		String campaignname = "CybCamp" + genData.generateRandomString(4);
		camp.getCampaignNameTextBox().sendKeys(campaignname);
		
		//Verify that Juniper Campaign field should be set to YES
		Assert.assertTrue(camp.getJuniperCampaignValue().getAttribute("title").contains("Yes"));
		
		//Click on Save button
		camp.getSaveBtnOnCampaignForm().click();
		
		//Verify that Campaign Code should be generated automatically
		Assert.assertTrue(camp.getCampaignCodeValue().getAttribute("value").contains("CMP"));
		
		//Click Save & Close button
		camp.getSavenCloseBtn().click();
		
		//Verify that Newly created Campaign should be displayed under the view ‘My Campaigns’
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(campaignname);
		ap.getclicksearchbutton().click();
		Thread.sleep(3000);
		Assert.assertTrue(ap.getValidateAccnameInSearchResults().getAttribute("title").contains(campaignname));				
	}
	
	@Test(priority=3)
	public void TS003_VerifyCampaignLinkingToTheIncentivesTest() throws IOException, InterruptedException, ParseException {

		//The purpose of this test case to:-
		//T559- Verify Campaign linking to the Incentives
		
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		in = new CRMIncentivesPage(driver);
		camp = new CRMCampaignsPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Click on Incentives tab from left menu
		hp.getincentivestab().click();
		
		//Click on New button
		in.getCreateNewIncentiveBtn().click();
		
		//Select Account at New Incentive form
		in.getAccountTextBox().click();
		in.getAccountSearchRecordsBtn().click();
		in.SelectAccountName().click();
		in.getAccountFieldLabel().click();
		Thread.sleep(5000);
		String accountname = in.getSelectedAccountNameField().getText();
				
		//Select Contact at New Incentive Form
		in.getContactTextBox().click();
		in.getContactSearchRecordsBtn().click();
		in.SelectContactName().click();
		in.getContactFieldLabel().click();
		Thread.sleep(5000);
		String contactname = in.getSelectedContactNameField().getText();

		// Select Market at New Incentive Form
		in.getMarketTextBox().click();
		//in.getMarketSearchRecordsBtn().click();
		in.SelectMarketName().click();
		in.getMarketFieldLabel().click();
		Thread.sleep(5000);
	
		//Verify that Campaign field should be displayed on Incentive form
		Assert.assertTrue(in.getCampaignFieldLabel().isDisplayed());
		
		//Enter Campaign name in the field
		in.getCampaignTextBox().click();
		in.getCampaignSearchRecordsBtn().click();
		in.SelectCampaignName().click();
		in.getCampaignFieldLabel().click();
		Thread.sleep(5000);
		String campaignname = in.getSelectedCampaignNameField().getText();
		
		//Click on Save & Close button
		in.getSavenCloseBtn().click();
		ap.getDuplicateRecordsPopupIgnorenSavebtn().click();
		
		//On Active Incentives grid, Search for that account and open that record
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(accountname);
		ap.getclicksearchbutton().click();
		Thread.sleep(3000);
		
		act = new Actions(driver);
		act.moveToElement(in.getAccountLinkInIncentivesTab()).perform();
		in.getAccountLinkInIncentivesTab().click();
		
		//On Account page, go to Incentive tab
		in.getIncentiveTab().click();
		
		//Observe that Campaign is linked to the Incentive
		Assert.assertTrue(in.getValidateCampaignName().getAttribute("title").contains(campaignname));
	
	}
}
