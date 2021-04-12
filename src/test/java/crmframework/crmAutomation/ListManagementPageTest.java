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
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class ListManagementPageTest extends base {

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
	public void TS002_VerifyExportToExcelListsTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T456- Verify Export To Excel functionality for Lists

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		ind = new CRMIncentiveDetailsPage(driver);
		cp = new CRMContactPage(driver);
		pl = new CRMPeoplePage(driver);
		lmp = new CRMListManagementPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Lists Tab at left menu and search lists containing LV
		hp.getliststab().click();
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("listssearch"));
		ap.getclicksearchbutton().click();

/*		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();
*/
	    Thread.sleep(8000);
		//Click Export To Excel option under it
		lmp.getlistsexportdropdown().click();

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
		
		Thread.sleep(50000);
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
		Thread.sleep(3000);
		//Click Export To Excel option under it
		lmp.getlistsexportdropdown().click();

		//Export Excel to Static Worksheet
		ap.getexporttostaticworksheet().click();

/*		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();
*/
		
		Thread.sleep(3000);
		//Click Export To Excel option under it
		lmp.getlistsexportdropdown().click();

		//Export Excel to Static Worksheet Page Only
		ap.getexporttostaticworksheetpageonly().click();

/*		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();
*/
		Thread.sleep(3000);
		//Click Export To Excel dropdown arrow option under it
		lmp.getlistsexportdropdown().click();

		//Export to Dynamic Worksheet
		ap.getexporttodynamicworksheet().click();
		Thread.sleep(3000);
		lmp.getselectcheckbox1().click();
		lmp.getselectcheckbox2().click();
		ap.getexportworksheetpopup().click();
		
		
/*		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();
*/
		Thread.sleep(3000);
		//Click Export To Excel option under it
		lmp.getlistsexportdropdown().click();

		//Export to Dynamic Pivot Table
		ap.getexporttodynamicpivottable().click();
		lmp.getselectcheckbox1().click();
		lmp.getselectcheckbox2().click();
		ap.getexportworksheetpopup().click();
	}
	@Test(priority=3)
	public void TS003_VerifyCooperativeListsAccountsViewTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T456- Verify Export To Excel functionality for Lists

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		ind = new CRMIncentiveDetailsPage(driver);
		cp = new CRMContactPage(driver);
		pl = new CRMPeoplePage(driver);
		lmp = new CRMListManagementPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Lists Tab at left menu 
		hp.getAccountTab().click();
		
		//Select Co-Op List Query for Uncontacted Accounts option in Views
		ind.getclickarrowforactiveincentive().click();
		Thread.sleep(5000);
		lmp.getpinuncontacted().click();
		Thread.sleep(15000);
				
		//Verification if report data is displayed properly
		Assert.assertTrue(lmp.getpagegrid().isDisplayed());
		System.out.println("Report is diplayed properly."); 
		ind.getclickarrowforactiveincentive().click();
		Thread.sleep(5000);
		lmp.getunpin().click();
	}
	
	@Test(priority=4)
	public void TS004_VerifyCreateNewListTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS235- Create Lists and List Members

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		pl = new CRMPeoplePage(driver);
		lmp = new CRMListManagementPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Click on Lists Tab at left menu
		hp.getliststab().click();

		//Click on 'New' button
		lmp.getlistnewbtn().click();
		
		Thread.sleep(3000);

		//Fill all the mandatory fields to create new List entry
		
		//Enter List Name
		lmp.getlistname().click();
		
		//to create random generated list name
		lmp.getlistname().sendKeys(genData.generateRandomAlphaNumeric(10));
		listNameText= lmp.getlistname().getAttribute("Value");
		System.out.println("Created List Name: "+listNameText);
		
		//select list name from dropdown
		lmp.getlisttype().click();
		lmp.getlisttypeoption().click();
		
		//Click on Save and Close button
		lmp.getlistsaveclosebtn().click();

		//Verify the newly created account
		lmp.getsearchlistrecord().click();
		lmp.getsearchlistrecord().sendKeys(listNameText);
		hp.getstartsearch().click();

		String validateListName = lmp.getlistnamesearchtable().getText();
		Assert.assertEquals(validateListName, listNameText);
		System.out.println("Searched Account:"+ validateListName);

		System.out.println("New List record is created successfully");

		//Clear the search term
		hp.getClearSearch().click();
	}
}
