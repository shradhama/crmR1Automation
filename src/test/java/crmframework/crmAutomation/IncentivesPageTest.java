package crmframework.crmAutomation;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
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
		Thread.sleep(5000);
		String contactname = in.getSelectedContactNameField().getText();

		// Select Market at New Incentive Form
		in.getMarketTextBox().click();
		in.getMarketSearchRecordsBtn().click();
		in.SelectMarketName().click();
		in.getMarketFieldLabel().click();
		Thread.sleep(5000);
		String marketname = in.getSelectedMarketNameField().getText();

		// Select Referral Source at New Incentive Form
		in.getReferralSourceTxtBx().click();
		in.getReferralSourceSearchRecordsBtn().click();
		in.SelectReferralSourceName().click();
		in.getReferralSourceFieldLabel().click();
		Thread.sleep(3000);

		//Click on Save and Close button
		in.getSavenCloseBtn().click();
		Thread.sleep(10000);
		//ap.getDuplicateRecordsPopupIgnorenSavebtn().click();
		//Thread.sleep(10000);

		//Verify that Incentive should be created and should now be displayed in the incentives section 
		//under incentive tab on account form
		Assert.assertTrue(in.getAccNameInIncentivesTab().getText().contains(accountname));
		Assert.assertTrue(in.getContactNameInIncentivesTab().getText().contains(contactname));
		Assert.assertTrue(in.getMarketNameInIncentivesTab().getText().contains(marketname));
		System.out.println("Incentive is created from Account successfully");

		Thread.sleep(10000);
		in.selectIncentiveRecord().click();
		in.getIncDeactivateBtn().click();
		in.getDeactivationPopupDeactivateBtn().click();
		Thread.sleep(5000);
		System.out.println("Incentive deactivated from Account successfully");

		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();
	}
	@Test(priority=3)
	public void TS003_VerifyCreateIncentiveFromContactTest() throws InterruptedException 
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
		Thread.sleep(3000);
		String marketname = in.getSelectedMarketNameField().getText();

		// Select Referral Source at New Incentive Form
		in.getReferralSourceTxtBx().click();
		in.getReferralSourceSearchRecordsBtn().click();
		in.SelectReferralSourceName().click();
		in.getReferralSourceFieldLabel().click();

		//Click on Save and Close button
		in.getSavenCloseBtn().click();
		Thread.sleep(10000);
		//ap.getDuplicateRecordsPopupIgnorenSavebtn().click(); //newly added
		//Thread.sleep(5000);

		//Verify that Incentive should be created and should now be displayed in the incentives section 
		//under incentive tab on account form
		Assert.assertTrue(in.getAccNameInIncentivesTab().getText().contains(accountname));
		Assert.assertTrue(in.getMarketNameInIncentivesTabOfContact().getText().contains(marketname));
		System.out.println("Incentive added to contact succesfully.");
		in.selectIncentiveRecord().click();
		in.getIncDeactivateBtn().click();
		in.getDeactivationPopupDeactivateBtn().click();
		Thread.sleep(5000);
		System.out.println("Incentive deactivated from contact succesfully.");

		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();
	}
	@Test(priority=4)
	public void TS004_VerifyDeactivateIncentiveFromContactTest() throws InterruptedException 
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
		cp.getDLetterFilterLink().click();
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
		Thread.sleep(3000);

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
		Thread.sleep(5000);
		//Verify that Incentive should become Read Only
		Assert.assertTrue(in.getIncentiveReadOnlyText().isDisplayed());
		System.out.println("Incentive is disabled successfully.");
		ap.getPageBackBtn().click();

		//Verify that the Incentive should be deactivated and removed from the incentives section
		List<WebElement> validateIncentive1 = driver.findElements(By.xpath("//div[@title='"+accountname+"']"));
		Assert.assertTrue(validateIncentive1.size()== 0);

		//Click on Incentives tab from left menu
		hp.getincentivestab().click();

		//Click on 'Active Incentives' drop-down view button
		in.getActiveIncDropDownBtn().click();
		Thread.sleep(3000);

		//Select 'Inactive Incentives' option
		in.getInactiveIncOptn().click();
		Thread.sleep(3000);

		//Validate deactivated incentive
		hp.getSearchInactiveIncField().click();
		hp.getSearchInactiveIncField().sendKeys(accountname);
		hp.getstartsearch().click();
		Thread.sleep(5000);
		Assert.assertTrue(in.getValidateIncInSearchResults().getText().contains(accountname));
		System.out.println("Inactive Incentives are diplayed properly.");
		hp.getClearSearch().click();
	}
	@Test(priority=5)
	public void TS005_VerifyGridFiltersIncentivesTest() throws InterruptedException
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
		ap.getselectregionvalue().click();
		Thread.sleep(3000);
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
			Assert.assertTrue(Account.getText().toLowerCase().contains(prop.getProperty("name")));
		}
		System.out.println("Account matches expected criteria");

		//Clear Filter for Account
		in.getaccountcolumn().click();
		ap.getclearfiltergrid().click();

		//Click funnel for Contact column
		in.getcontactcolumn().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getselectregionvalue().click();
		Thread.sleep(3000);
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
			Assert.assertTrue(Contact.getText().toLowerCase().contains(prop.getProperty("contact")));
		}
		System.out.println("Contact matches expected criteria");

		//Clear Filter for Contact
		in.getcontactcolumn().click();
		ap.getclearfiltergrid().click();

		//Click funnel for Market column
		in.getmarketcolumn().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getselectregionvalue().click();
		Thread.sleep(3000);
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
			Assert.assertTrue(Market.getText().toLowerCase().contains(prop.getProperty("market")));
		}
		System.out.println("Market matches expected criteria");

		//Clear Filter for Market
		in.getmarketcolumn().click();
		ap.getclearfiltergrid().click();
	}

	@Test(priority=6)
	public void TS006_VerifyActivateInactiveIncentiveTest() throws InterruptedException 
	{
		//The purpose of this test case to:-
		//T53- Verify user is able to activate an incentive as per security access

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		in = new CRMIncentivesPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Incentives tab
		hp.getincentivestab().click();

		cp.getBLetterFilterLink().click();
		Thread.sleep(4000);
		//Select active incentive from grid
		act = new Actions(driver);
		act.doubleClick(in.selectIncentiveRecord()).perform();
		Thread.sleep(5000);

		//Get the incentive name from header
		String incentivenameonincform = in.getIncentiveNameOnIncForm().getText();
		System.out.println("Incentive name: "+incentivenameonincform);

		String accountname = in.getSelectedAccountNameField().getText();
		System.out.println("Account Name: "+accountname);

		String contactname = in.getSelectedContactNameField().getText();
		System.out.println("Contact Name: "+contactname);

		String marketname = in.getSelectedMarketNameField().getText();
		System.out.println("Market Name: "+marketname);

		//Click on Deactivate button in header
		in.getDeactivateBtnOnIncentiveForm().click();

		//Click on Deactivate button in the dialog box
		in.getDeactivationPopupDeactivateBtn().click();
		Thread.sleep(5000);

		//Verify that an Incentive should be deactivated
		Assert.assertTrue(in.getActivateBtnOnIncentiveForm().isDisplayed());
		Assert.assertTrue(in.getIncentiveReadOnlyText().isDisplayed());
		ap.getPageBackBtn().click();
		Thread.sleep(5000);

		//Verify that inactive should not be displayed under Active Incentives
		hp.getSearchActiveIncField().click();
		hp.getSearchActiveIncField().sendKeys(incentivenameonincform);
		hp.getstartsearch().click();
		Thread.sleep(5000);
		Assert.assertTrue(in.getNoDataAvailableText().isDisplayed());
		hp.getClearSearch().click();

		//Click on 'Active Incentives' drop-down view button
		in.getActiveIncDropDownBtn().click();

		//Select 'Inactive Incentives' option
		in.getInactiveIncOptn().click();
		Thread.sleep(3000);
		//Verify that deactivated incentive should be displayed under Inactive Incentives
		hp.getSearchInactiveIncField().click();
		hp.getSearchInactiveIncField().sendKeys(accountname);
		hp.getstartsearch().click();
		Thread.sleep(5000);
		Assert.assertTrue(in.getValidateIncInSearchResults().getText().contains(accountname));

		//Select that incentive
		act = new Actions(driver);
		act.doubleClick(in.selectIncentiveRecord()).perform();

		//Click on Activate button in header
		in.getActivateBtnOnIncentiveForm().click();
		in.getActivationPopupActivateBtn().click();

		//The Incentive should be activated
		Assert.assertTrue(in.getDeactivateBtnOnIncentiveForm().isDisplayed());
		ap.getPageBackBtn().click();

		//Verify that incentive should no more be displayed under Inactive Incentives
		hp.getClearSearch().click();
		hp.getSearchInactiveIncField().click();
		hp.getSearchInactiveIncField().sendKeys(incentivenameonincform);
		hp.getstartsearch().click();
		Thread.sleep(5000);
		Assert.assertTrue(in.getNoDataAvailableText().isDisplayed());
		hp.getClearSearch().click();

		//Click on 'Inactive Incentives' drop-down view button
		in.getActiveIncDropDownBtn().click();

		//Select 'Active Incentives' option
		in.getActiveIncOptn().click();
		Thread.sleep(3000);

		//Verify that inactive should be displayed under Active Incentives
		hp.getSearchActiveIncField().click();
		hp.getSearchActiveIncField().sendKeys(accountname);
		hp.getstartsearch().click();
		Thread.sleep(5000);
		Assert.assertTrue(in.getValidateIncInSearchResults().getText().contains(accountname));

		//Open the incentive
		act = new Actions(driver);
		act.doubleClick(in.selectIncentiveRecord()).perform();

		//Navigate to the Account form by click on the account link in account field
		in.getSelectedAccountNameField().click();
		Thread.sleep(5000);

		//Navigate to the Incentives tab
		in.getIncentiveTab().click();
		Thread.sleep(6000);
		//Verify that the activated incentive should be displayed in incentives section
		Assert.assertTrue(in.getAccNameInIncentivesTab().getText().contains(accountname));
		Assert.assertTrue(in.getContactNameInIncentivesTab().getText().contains(contactname));
		Assert.assertTrue(in.getMarketNameInIncentivesTab().getText().contains(marketname));

		ap.getPageBackBtn().click();

		//Navigate to the Contact form by click on the contact link in contact field
		in.getSelectedContactNameField().click();
		Thread.sleep(5000);

		//Navigate to the Incentives tab
		in.getIncentiveTab().click();
		Thread.sleep(6000);

		//Verify that the activated incentive should be displayed in incentives section
		Assert.assertTrue(in.getAccNameInIncentivesTab().getText().contains(accountname));
		Assert.assertTrue(in.getMarketNameInIncentivesTabOfContact().getText().contains(marketname));
		ap.getPageBackBtn().click();
		ap.getPageBackBtn().click();
		hp.getClearSearch().click();
	}
	@Test(priority=7)
	public void TS007_VerifyExportToExcelIncentivesTest() throws InterruptedException
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

	@Test(priority=8)
	public void TS008_VerifySearchFunctionalityIncentivesTest() throws InterruptedException
	{
		//The purpose of this test case:-
		//CRM-T84- Verify Search Incentives functionality

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		pl = new CRMPeoplePage(driver);
		cp = new CRMContactPage(driver);
		in = new CRMIncentivesPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Incentives Tab at left menu 
		hp.getincentivestab().click();
		Thread.sleep(5000);

		//Click search text box and search for account name
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("name"));
		ap.getclicksearchbutton().click();
		Thread.sleep(5000);

		//Verify Account value selected on accounts grid
		WebElement Account = null;
		for (int i=0;i<3;i++)
		{
			Account = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']"));
			Assert.assertTrue(Account.getText().toLowerCase().contains(prop.getProperty("name")));
		}
		System.out.println("Incentives exist for searched account name.");

		//Remove searched account name
		in.getclearsearch().click();

		//Click search text box and search for Contact name
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("searchcontactinc"));
		ap.getclicksearchbutton().click();
		Thread.sleep(5000);	

		//Verify Contact value selected on accounts grid
		WebElement Contact = null;
		for (int i=0;i<1;i++)
		{
			Contact = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-3']"));
			Assert.assertTrue(Contact.getText().contains(prop.getProperty("searchcontactinc")));
		}
		System.out.println("Incentives exist for searched contact name.");

		//Remove searched account name
		in.getclearsearch().click();

		//Click search text box and search for Market name
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("searchmarketinc"));
		ap.getclicksearchbutton().click();
		Thread.sleep(5000);		

		//Verify Contact value selected on accounts grid
		WebElement Market = null;
		for (int i=0;i<7;i++)
		{
			Market = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-4']"));
			Assert.assertTrue(Market.getText().contains(prop.getProperty("searchmarketinc")));
		}
		System.out.println("Incentives exist for searched market name.");

		//Remove searched account name
		in.getclearsearch().click();
	}

	@Test(priority=9)
	public void TS009_VerifyUpdateiIncentiveFromContactTest() throws InterruptedException 
	{
		//The purpose of this test case to:-
		//T36- Verify that user is able to update incentive from contact form

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		in = new CRMIncentivesPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Contacts tab
		hp.getContactsTab().click();

		//Click on New button in header to open new contact form
		cp.getCreateNewContactBtn().click();

		//Fill up the required details
		//Enter First Name & Last name
		cp.getfirstname().click();
		String ContactFirstName = "QA"+ genData.generateRandomString(3);
		cp.getfirstname().click();
		cp.getfirstname().sendKeys(ContactFirstName);
		cp.getlastname().click();
		cp.getlastname().sendKeys(genData.generateRandomString(5));

		//Select Contact type
		cp.getContactTypetxtbx().click();
		cp.getContactTypeExpandbtn().click();
		cp.getContactTypeBuyer().click();
		cp.getContactFirstNameLabel().click();

		WebElement scrollText = cp.getScrollTextOnContactForm();	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",scrollText);
		Thread.sleep(3000);

		//Enter Account Name
		cp.getContactAccountNameTxtbx().click();
		cp.getSearchRecordsBtn().click();
		cp.getAccountNameTitle().click();

		//Enter an Email
		cp.getemail().click();
		cp.getemail().sendKeys(genData.generateEmail(15));

		//Click on Save button in header
		cp.getsavecontact().click();

		//Save the contact name in string variable
		String newcontactname = cp.getContactNameinHeader().getText();
		System.out.println("Contact Name: "+newcontactname);
		//Navigate back to Active contacts page
		ap.getPageBackBtn().click();

		//On the contacts grid view page, search for the contact using contact name
		hp.getSearchContactField().click();
		hp.getSearchContactField().sendKeys(newcontactname);
		hp.getstartsearch().click();
		hp.getSearchResultContactFullName().click();
		
				//Open any active contact
		//cp.getDLetterFilterLink().click();
		//cp.selectContactName().click();
		ap.getAccNaviagteBtn().click();

		// Click Incentives tab of an existing contact
		in.getIncentiveTab().click();

		//Click on New Incentive button
		in.getNewIncentiveBtn().click();

		// Select Market at New Incentive Form
		in.getMarketTextBox().click();
		in.getMarketSearchRecordsBtn().click();
		in.SelectMarketName().click();
		Thread.sleep(3000);
		in.getMarketFieldLabel().click();

		//Click on Save and Close button
		in.getSavenCloseBtn().click();
		Thread.sleep(15000);

		ap.getDuplicateRecordsPopupIgnorenSavebtn().click(); //newly added

		//Select an incentive from incentives tab
		in.selectIncentiveRecord().click();

		//Click on Edit option
		in.getIncentiveEditButton().click();

		act= new Actions(driver);
		act.moveToElement(in.getSelectedMarketNameField()).perform();

		//Delete existing market name value and Update with new one
		in.getSelectedMarketNameDeleteBtn().click();

		in.getMarketSearchRecordsBtn().click();
		in.UpdateMarketName().click();
		in.getMarketFieldLabel().click();
		String updatedmarketname = in.getSelectedMarketNameField().getText();
		System.out.println("Updated Market name: "+updatedmarketname);

		//Click on Save and Close button
		in.getSavenCloseBtn().click();
		Thread.sleep(15000);

		ap.getDuplicateRecordsPopupIgnorenSavebtn().click(); //Newly added
		
		//Verify that the Market should be updated in the incentive section under incentive tab
		Assert.assertTrue(in.getMarketNameInIncentivesTabOfContact().getText().contains(updatedmarketname));

		//Click on the Account link in accounts column to navigate to the account form	
		act= new Actions(driver);
		act.moveToElement(in.getAccountLinkInIncentivesTab()).perform();

		in.getAccountLinkInIncentivesTab().click();

		// Click Incentives tab on account form
		in.getIncentiveTab().click();

		//Select the incentive
		in.selectIncentiveRecordonAccForm().click();

		//Click on Edit option
		in.getIncentiveEditButton().click();

		act= new Actions(driver);
		act.moveToElement(in.getSelectedAccountNameField()).perform();

		//Delete existing market name value and Update with new one
		in.getSelectedAccountNameDeleteBtn().click();

		//Update Account on the Incentive form
		in.getAccountSearchRecordsBtn().click();
		in.UpdateAccountName().click();
		in.getAccountFieldLabel().click();

		String updatedaccountname = in.getSelectedAccountNameField().getText();
		System.out.println("Updated Account Name: "+updatedaccountname);

		//Click on Save and Close button
		in.getSavenCloseBtn().click();
		Thread.sleep(15000);

		ap.getDuplicateRecordsPopupIgnorenSavebtn().click(); //Newly added
		Thread.sleep(5000);
		//Verify that Incentive should not be displayed in the incentives section as the account is changed
		List<WebElement> validateIncentive = driver.findElements(By.xpath("//div[@title='"+updatedaccountname+"']"));
		Assert.assertTrue(validateIncentive.size()== 0);

		//Navigate to the contacts under demand driver in left menu
		hp.getContactsTab().click();
		cp.getBLetterFilterLink().click();
		cp.selectContactName().click();
		ap.getAccNaviagteBtn().click();

		// Click Incentives tab of an existing contact
		in.getIncentiveTab().click();

		//Click on New Incentive button
		in.getNewIncentiveBtn().click();

		// Select Market at New Incentive Form
		in.getMarketTextBox().click();
		in.getMarketSearchRecordsBtn().click();
		in.SelectMarketName().click();
		in.getMarketFieldLabel().click();

		//Click on Save and Close button
		in.getSavenCloseBtn().click();
		Thread.sleep(15000);
		
		ap.getDuplicateRecordsPopupIgnorenSavebtn().click(); //Newly added
		Thread.sleep(4000);
		
		//Select the incentive
		in.selectIncentiveRecord().click();

		//Click on Edit option
		in.getIncentiveEditButton().click();

		//Update Contact on the Incentive form
		act= new Actions(driver);
		act.moveToElement(in.getSelectedContactNameField()).perform();

		in.getSelectedContactNameDeleteBtn().click();
		in.getContactSearchRecordsBtn().click();
		in.UpdateContactName().click();
		in.getContactFieldLabel().click();

		//Click on Save and Close button
		in.getSavenCloseBtn().click();
		Thread.sleep(15000);
		ap.getDuplicateRecordsPopupIgnorenSavebtn().click();
		Thread.sleep(4000);

		//Verify that Incentive should not be displayed in the incentives section as the contact is changed
		Assert.assertTrue(in.getNoDataAvailableText().isDisplayed());
	}

}

