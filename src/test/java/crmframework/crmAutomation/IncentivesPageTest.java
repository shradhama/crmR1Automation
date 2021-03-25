package crmframework.crmAutomation;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import pageObjects.CRMIncentiveTab;
import pageObjects.CRMIncentivesPage;
import pageObjects.CRMLandingPage;
import pageObjects.CRMLoginPage;
import pageObjects.CRMPeoplePage;
import resources.GenerateData;
import resources.base;

@Listeners({TestListeners.class})
public class IncentivesPageTest extends base {

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
	CRMIncentivesPage in;


	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		genData=new GenerateData();
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
	public void TS002_VerifyCreateIncentiveFromAccountTest() throws InterruptedException 
	{
		//The purpose of this test case to:-
		//T104- Verify that user is able to create incentive from account form

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		in = new CRMIncentivesPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Accounts tab
		hp.getAccountTab().click();

		//Open any active account
		ap.getAllFilterLink().click();
		String accountname = ap.getAccountName().getText();
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();

		// Click Incentives tab of an existing account
		in.getIncentiveTab().click();

		//Click on New Incentive button
		in.getNewIncentiveBtn().click();

		//Select Contact at New Incentive Form
		in.getContactTextBox().click();
		in.getContactSearchRecordsBtn().click();
		in.SelectContactName().click();
		in.getContactFieldLabel().click();
		String contactname = in.getSelectedContactNameField().getText();

		// Select Market at New Incentive Form
		in.getMarketTextBox().click();
		in.getMarketSearchRecordsBtn().click();
		in.SelectMarketName().click();
		in.getMarketFieldLabel().click();
		String marketname = in.getSelectedMarketNameField().getText();

		// Select Referral Source at New Incentive Form
		in.getReferralSourceTxtBx().click();
		in.getReferralSourceSearchRecordsBtn().click();
		in.SelectReferralSourceName().click();
		in.getReferralSourceFieldLabel().click();

		//Click on Save and Close button
		in.getSavenCloseBtn().click();
		Thread.sleep(15000);

		//Verify that Incentive should be created and should now be displayed in the incentives section 
		//under incentive tab on account form
		Assert.assertTrue(in.getAccNameInIncentivesTab().getText().contains(accountname));
		Assert.assertTrue(in.getContactNameInIncentivesTab().getText().contains(contactname));
		Assert.assertTrue(in.getMarketNameInIncentivesTab().getText().contains(marketname));
		System.out.println("Incentive is created from Account successfully");

		in.selectIncentiveRecord().click();
		in.getIncDeactivateBtn().click();
		in.getDeactivationPopupDeactivateBtn().click();
		Thread.sleep(5000);

		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();
	}

	@Test(priority=3)
	public void TS003_VerifyExportToExcelIncentivesTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T54- Verify Export To Excel functionality for Incentives

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		in = new CRMIncentivesPage(driver);
		cp = new CRMContactPage(driver);
		pl = new CRMPeoplePage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Accounts Tab at left menu and search accounts containing Cyb
		hp.getincentivestab().click();
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("name"));
		ap.getclicksearchbutton().click();

		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();

		//Click Export To Excel option under it
		in.getclickexportoptionarrow().click();

		//Export file to online excel
		ap.getopenexcelonline().click();

		//ap.getsaveexcelonline().click();
		ap.getsaveexcelonline().click();   

		//Click Track Progress button
		cp.getexporttrackprogressbtn().click();

		//Switch to new My Imports tab
		Set<String> windows1 = driver.getWindowHandles();
		Iterator<String>it = windows1.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		Thread.sleep(15000);

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

		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();

		//Click Export To Excel option under it
		in.getclickexportoptionarrow().click();

		//Export Excel to Static Worksheet
		ap.getexporttostaticworksheet().click();

		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();

		//Click Export To Excel option under it
		in.getclickexportoptionarrow().click();

		//Export Excel to Static Worksheet Page Only
		ap.getexporttostaticworksheetpageonly().click();

		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();

		//Click Export To Excel dropdown arrow option under it
		in.getclickexportoptionarrow().click();

		//Export to Dynamic Worksheet
		ap.getexporttodynamicworksheet().click();
		in.getselectcheckbox1().click();
		in.getselectcheckbox2().click();
		ap.getexportworksheetpopup().click();

		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();

		//Click Export To Excel option under it
		in.getclickexportoptionarrow().click();

		//Export to Dynamic Pivot Table
		ap.getexporttodynamicpivottable().click();
		in.getselectcheckbox1().click();
		in.getselectcheckbox2().click();
		ap.getexportworksheetpopup().click();
	}

	@Test(priority=4)
	public void TS004_VerifyCreateIncentiveFromContactTest() throws InterruptedException 
	{
		//The purpose of this test case to:-
		//T36- Verify that user is able to create incentive from contact form

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		in = new CRMIncentivesPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Contacts tab
		hp.getContactsTab().click();

		//Open any active contact
		cp.getBLetterFilterLink().click();
		cp.selectContactName().click();
		ap.getAccNaviagteBtn().click();

		// Click Incentives tab of an existing contact
		in.getIncentiveTab().click();

		//Click on New Incentive button
		in.getNewIncentiveBtn().click();

		String accountname = in.getSelectedAccountNameField().getText();

		// Select Market at New Incentive Form
		in.getMarketTextBox().click();
		in.getMarketSearchRecordsBtn().click();
		in.SelectMarketName().click();
		in.getMarketFieldLabel().click();
		String marketname = in.getSelectedMarketNameField().getText();

		// Select Referral Source at New Incentive Form
		in.getReferralSourceTxtBx().click();
		in.getReferralSourceSearchRecordsBtn().click();
		in.SelectReferralSourceName().click();
		in.getReferralSourceFieldLabel().click();

		//Click on Save and Close button
		in.getSavenCloseBtn().click();
		Thread.sleep(15000);

		//Verify that Incentive should be created and should now be displayed in the incentives section 
		//under incentive tab on account form
		Assert.assertTrue(in.getAccNameInIncentivesTab().getText().contains(accountname));
		Assert.assertTrue(in.getMarketNameInIncentivesTabOfContact().getText().contains(marketname));

		in.selectIncentiveRecord().click();
		in.getIncDeactivateBtn().click();
		in.getDeactivationPopupDeactivateBtn().click();
		Thread.sleep(5000);

		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();
	}


}
