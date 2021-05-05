package crmframework.crmAutomation;

import java.io.IOException;
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
import pageObjects.CRMPeoplePage;
import pageObjects.CRMRegistrationsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class RegistrationsPageTest extends base {
	
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
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		genData=new GenerateData();
		utl=new Utility(driver);
	}
	@Test(priority=1)
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
	}
	@Test(priority=2)
	public void TS002_VerifySearchableFieldsPageTest() throws IOException, InterruptedException {

		//The purpose of this test case to verify:-
		//T218- Verify Search functionality at Registrations tab
		
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		in = new CRMIncentivesPage(driver);
		cp = new CRMContactPage(driver);
		pl = new CRMPeoplePage(driver);
		lmp = new CRMListManagementPage(driver);
		reg = new CRMRegistrationsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Open Registrations tab 
		hp.getregistrationstab().click();
		Thread.sleep(5000);
		
		//Search and Verify Contact Name
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("registrationcontact"));
		ap.getclicksearchbutton().click();
		Thread.sleep(3000);
		Assert.assertTrue(ap.getPhoneinSearchTable().getText().contains(prop.getProperty("registrationcontact")));
		System.out.println("Regitration Contact is searched properly.");
		in.getclearsearch().click();
		
		//Search and Verify Account Name
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("registrationaccount"));
		ap.getclicksearchbutton().click();
		Thread.sleep(3000);
		Assert.assertTrue(cp.getContactMarketProfileDeclinedReasonField().getText().contains(prop.getProperty("registrationaccount")));
		System.out.println("Regitration Account is searched properly.");
		in.getclearsearch().click();
		
		//Search and Verify Registration Name
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("registrationname"));
		ap.getclicksearchbutton().click();
		Thread.sleep(3000);
		Assert.assertTrue(ap.getAccountNameSearchTable().getText().contains(prop.getProperty("registrationname")));
		System.out.println("Regitration Name is searched properly.");
		Thread.sleep(3000);
		
		//Open Registration details and verify details
		ap.getAccountNameSearchTable().click();
		String RegistrationName = reg.getregistrationname().getAttribute("Value");
		String AccountName = in.getSelectedAccountNameField().getText();
		String ContactName = in.getSelectedContactNameField().getText();
		Thread.sleep(5000);
		System.out.println(RegistrationName+" , "+AccountName+" , "+ContactName);
		Thread.sleep(3000);
		ap.getAccPageBackBtn().click();
		Thread.sleep(5000);
		Assert.assertTrue(ap.getAccountNameSearchTable().getText().equals(RegistrationName));
		Assert.assertTrue(cp.getContactMarketProfileDeclinedReasonField().getText().equals(AccountName));
		Assert.assertTrue(ap.getPhoneinSearchTable().getText().equals(ContactName));
		System.out.println("Regitration details are matching with grid details.");
		
		//Verify Invalid data search
		in.getclearsearch().click();
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(genData.generateRandomString(8));
		ap.getclicksearchbutton().click();
		Assert.assertTrue(in.getNoDataAvailableText().isDisplayed());
		System.out.println("No Data available message is displayed.");
		Thread.sleep(3000);
	}
	@Test(priority=3)
	public void TS003_VerifyDisabledRegistrationsPageTest() throws IOException, InterruptedException {

		//The purpose of this test case to verify:-
		//T454- Verify Registration Details are disabled
		
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		in = new CRMIncentivesPage(driver);
		cp = new CRMContactPage(driver);
		pl = new CRMPeoplePage(driver);
		lmp = new CRMListManagementPage(driver);
		reg = new CRMRegistrationsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Open Registrations tab 
		hp.getregistrationstab().click();
		Thread.sleep(5000);
		
		//Open Registration detail and verify if details are disabled
		ap.getCLetterFilterLink().click();	
		ap.getAccountNameSearchTable().click();
		Assert.assertTrue(reg.getreadonlynotification().isDisplayed());
		System.out.println("Registration Details are disabled.");
	}
	@Test(priority=4)
	public void TS004_VerifyExportToExcelRegistrationsPageTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T130- Verify Export To Excel functionality for Incentive Details

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		ind = new CRMIncentiveDetailsPage(driver);
		cp = new CRMContactPage(driver);
		pl = new CRMPeoplePage(driver);
		reg = new CRMRegistrationsPage(driver);
		lmp = new CRMListManagementPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Incentives Tab at left menu and search incentives containing Cyb
		hp.getregistrationstab().click();
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("registrationexportsearch"));
		ap.getclicksearchbutton().click();

/*		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();
*/
	    Thread.sleep(10000);
	//Click Export To Excel option under it
		reg.getregexportexcel().click();

		//Export file to online excel
		ap.getopenexcelonline().click();
		Thread.sleep(15000);
		
		//ap.getsaveexcelonline().click();
		ap.getsaveexcelonline().click();
		Thread.sleep(10000);

		//Click Track Progress button
		cp.getexporttrackprogressbtn().click();
		
		//Switch to new My Imports tab
		Set<String> windows1 = driver.getWindowHandles();
		Iterator<String>it = windows1.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		
		Thread.sleep(15000);
		driver.navigate().refresh();
		//Verify export to excel online
		System.out.println(pl.getonlineexportverification().getText());
		Assert.assertTrue(pl.getonlineexportverification().getText().contains("Completed"));
		System.out.println("Excel exported online successfully.");
		Thread.sleep(10000);

		//Switch to previous browser tab
		Set<String> windows = driver.getWindowHandles();
		Iterator<String>it1 = windows.iterator();
		String parentId1 = it1.next();
		String childId1 = it1.next();
		driver.switchTo().window(parentId1);
		
/*
		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();
*/
		Thread.sleep(10000);
		//Click Export To Excel option under it
		reg.getregexportexcel().click();

		//Export Excel to Static Worksheet
		ap.getexporttostaticworksheet().click();

/*		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();
*/
		Thread.sleep(3000);
		//Click Export To Excel option under it
		reg.getregexportexcel().click();

		//Export Excel to Static Worksheet Page Only
		Thread.sleep(3000);
		ap.getexporttostaticworksheetpageonly().click();

/*		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();
*/
		Thread.sleep(3000);
		//Click Export To Excel dropdown arrow option under it
		reg.getregexportexcel().click();

		//Export to Dynamic Worksheet
		ap.getexporttodynamicworksheet().click();
		Thread.sleep(3000);
		lmp.getlistmembercreatedby().click();
		lmp.getlistmembercreatedon().click();
		ap.getexportworksheetpopup().click();
			
/*		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();
*/
		Thread.sleep(3000);
		//Click Export To Excel option under it
		reg.getregexportexcel().click();

		//Export to Dynamic Pivot Table
		ap.getexporttodynamicpivottable().click();
		lmp.getlistmembercreatedby().click();
		lmp.getlistmembercreatedon().click();
		ap.getexportworksheetpopup().click();
	}
}
