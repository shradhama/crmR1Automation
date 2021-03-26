package crmframework.crmAutomation;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
	@Test(priority=5)
	public void TS005_VerifyDeactivateIncentiveFromContactTest() throws InterruptedException 
	{
		//The purpose of this test case to:-
		//T52- Verify the user is able to deactivate an active incentive as per the security access

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		in = new CRMIncentivesPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Contacts tab
		hp.getContactsTab().click();

		//Open any active contact
		cp.getQLetterFilterLink().click();
		cp.selectContactName().click();
		ap.getAccNaviagteBtn().click();

		// Click Incentives tab of an existing contact
		in.getIncentiveTab().click();

		//Click on New Incentive button to create new incentive
		in.getNewIncentiveBtn().click();

		String accountname = in.getSelectedAccountNameField().getText();
		System.out.println("Account Name: "+accountname);

		// Select Market at New Incentive Form
		in.getMarketTextBox().click();
		in.getMarketSearchRecordsBtn().click();
		in.SelectMarketName().click();
		in.getMarketFieldLabel().click();

		//Click on Save and Close button
		in.getSavenCloseBtn().click();
		Thread.sleep(15000);

		//Deactivate the incentive using Deactivate option
		in.selectIncentiveRecord().click();
		in.getIncDeactivateBtn().click();
		in.getDeactivationPopupDeactivateBtn().click();
		Thread.sleep(5000);

		//Verify that the Incentive should be deactivated and removed from the incentives section
		List<WebElement> validateIncentive = driver.findElements(By.xpath("//div[@title='"+accountname+"']"));
		Assert.assertTrue(validateIncentive.size()== 0);

		//Click on New Incentive button to create new incentive
		in.getNewIncentiveBtn().click();
		// Select Market at New Incentive Form
		in.getMarketTextBox().click();
		in.getMarketSearchRecordsBtn().click();
		in.SelectMarketName().click();
		in.getMarketFieldLabel().click();

		//Click on Save and Close button
		in.getSavenCloseBtn().click();
		Thread.sleep(15000);

		//Deactivate the incentive using Edit option
		in.selectIncentiveRecord().click();
		in.getIncentiveEditButton().click();
		in.getDeactivateBtnOnIncentiveForm().click();
		in.getDeactivationPopupDeactivateBtn().click();

		//Verify that Incentive should become Read Only
		Assert.assertTrue(in.getIncentiveReadOnlyText().isDisplayed());
		ap.getPageBackBtn().click();

		//Verify that the Incentive should be deactivated and removed from the incentives section
		List<WebElement> validateIncentive1 = driver.findElements(By.xpath("//div[@title='"+accountname+"']"));
		Assert.assertTrue(validateIncentive1.size()== 0);

		//Click on Incentives tab from left menu
		hp.getincentivestab().click();

		//Click on 'Active Incentives' drop-down view button
		in.getActiveIncDropDownBtn().click();

		//Select 'Inactive Incentives' option
		in.getInactiveIncOptn().click();

		//Validate deactivated incentive
		hp.getSearchInactiveIncField().click();
		hp.getSearchInactiveIncField().sendKeys(accountname);
		hp.getstartsearch().click();
		Thread.sleep(5000);
		Assert.assertTrue(in.getValidateInactiveIncName().getText().contains(accountname));

		hp.getClearSearch().click();
	}
	@Test(priority=6)
	public void TS006_VerifyGridFiltersIncentivesTest() throws InterruptedException
	{
		//The purpose of this test case:-
		//CRM-T87- Verify Account, Contact and Market filters on People Grid
		
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		pl = new CRMPeoplePage(driver);
		cp = new CRMContactPage(driver);
		in = new CRMIncentivesPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Incentives Tab at left menu 
		hp.getincentivestab().click();
		
		//Click funnel for Account column
		in.getaccountcolumn().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		in.getgridoperator().click();
		ap.getclickaddressvaluefield().sendKeys(prop.getProperty("name"));
		ap.getclickapplybutton().click();
		Thread.sleep(5000);
			
		//Verify Account value selected on accounts grid
		WebElement Account = null;
		for (int i=0;i<3;i++)
		{
			Account = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']"));
			Assert.assertTrue(Account.getText().contains(prop.getProperty("name")));
		}
		System.out.println("Account matches expected criteria");

		//Clear Filter for Account
		in.getaccountcolumn().click();
		ap.getclearfiltergrid().click();

		//Click funnel for Contact column
		in.getcontactcolumn().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		in.getgridoperator().click();
		ap.getclickaddressvaluefield().sendKeys(prop.getProperty("contact"));
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify Contact value selected on accounts grid
		WebElement Contact = null;
		for (int i=0;i<7;i++)
		{
			Contact = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-3']"));
			Assert.assertTrue(Contact.getText().contains(prop.getProperty("contact")));
		}
		System.out.println("Contact matches expected criteria");

		//Clear Filter for Contact
		in.getcontactcolumn().click();
		ap.getclearfiltergrid().click();
		
		//Click funnel for Market column
		in.getmarketcolumn().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		in.getgridoperator().click();
		ap.getclickaddressvaluefield().sendKeys(prop.getProperty("market"));
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify Market value selected on accounts grid
		WebElement Market = null;
		for (int i=0;i<7;i++)
		{
			Market = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-4']"));
			Assert.assertTrue(Market.getText().contains(prop.getProperty("market")));
		}
		System.out.println("Market matches expected criteria");

		//Clear Filter for Market
		in.getmarketcolumn().click();
		ap.getclearfiltergrid().click();
			
	}

}
