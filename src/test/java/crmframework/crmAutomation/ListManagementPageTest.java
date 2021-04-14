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
	@Test(priority=4)
	public void TS004_VerifyListMembersRemovedViewTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T317- Verify Buyer accounts that are no longer associated with a list with which they once were

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		ind = new CRMIncentiveDetailsPage(driver);
		cp = new CRMContactPage(driver);
		pl = new CRMPeoplePage(driver);
		lmp = new CRMListManagementPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on List Members Tab at left menu 
		hp.getlistmemberstab().click();
		
		//Select List Members Removed in Views
		ind.getclickarrowforactiveincentive().click();
		Thread.sleep(5000);
		lmp.getlistmembersremoved().click();
		Thread.sleep(10000);
		String DateRemovedGrid = ap.getContactsSectionMobilePhoneField().getText();
		
		//Open list and verify Date Removed in member grid
		ap.getsearchaccounttextbox().click();
		Thread.sleep(5000);
		lmp.getopenlist().click();
		Thread.sleep(5000);
		utl.scrollToElement(ap.getMembersLabel());
		Assert.assertEquals(ap.getContactsSectionEmailField().getText(), DateRemovedGrid);
		System.out.println("Report is displayed properly.");
			
			}
	
	@Test(priority=5)
	public void TS005_ManualFail_VerifyListMemberLastAddedRemovedUpdatedTest() throws IOException, InterruptedException {

		//The purpose of this test case to verify that:-
		//CRM-T206:- VP Buyer Services is able to identify list has been refreshed last time by reviewing below fields :
		//Last list member was added, Last list member was removed, List last updated
		//with respect to date Added and Date removed fields of list members 
		//associated with list which are available in members subgrid
			
		hp = new CRMHomePage(driver);
		lmp = new CRMListManagementPage(driver);
		cp = new CRMContactPage(driver);
		ap = new CRMAccountsPage(driver);
		ind = new CRMIncentiveDetailsPage(driver);

		//Open Lists tab
		hp.getliststab().click();
		Thread.sleep(3000);

		//Open exiting active list
		Actions action = new Actions(driver);
		WebElement OpenList = cp.getopencontact();
		action.doubleClick(OpenList).perform();
		Thread.sleep(5000);

		//Verify fields on General Tab
		utl.scrollToElement(lmp.getscrollexpdate());
		Assert.assertTrue(lmp.getlastmemadded().isDisplayed());
		Assert.assertTrue(lmp.getlastmemremoved().isDisplayed());
		Assert.assertTrue(lmp.getlistlastupdated().isDisplayed());
		System.out.println("Fields are available on List page at General tab.");

		//Verify added and removed date are equal to Last updated date
		Assert.assertEquals(lmp.getlastmemadded().getText(), lmp.getlastupdatedmemberadded().getText());
		System.out.println("List Member Added Date matches with the Updated Date.");
		Assert.assertEquals(lmp.getlastmemremoved().getText(), lmp.getlastupdatedmemberaremoved().getText());
		System.out.println("List Member Removed Date matches with the Updated Date.");

		//Verification for Date Added and Date Removed columns in list members section
		utl.scrollToElement(ap.getMembersLabel());
		Assert.assertTrue(lmp.getgriddateadded().isDisplayed());
		System.out.println("Date Added is properly displayed in Members Grid.");
		Assert.assertTrue(lmp.getgriddateremoved().isDisplayed());
		System.out.println("Date Removed is properly displayed in Members Grid.");

		//Click on filter button for Date Added column
		lmp.getListMemAddedFilterBtn().click();
		lmp.getNewToOldFilterOptn().click();
		String latestdateadded = ap.getContactsSectionMobilePhoneField().getText();
		System.out.println("Latest Date Added: " +latestdateadded);
		
		//Click on filter button for Date Removed column
		lmp.getListMemRemovedFilterBtn().click();
		lmp.getNewToOldFilterOptn().click();
		String latestdateremoved = ap.getContactsSectionEmailField().getText();
		System.out.println("Latest Date Removed: " +latestdateremoved);

		//Click on Refresh button
		lmp.getListRefreshBtn().click();
		Thread.sleep(5000);
		
		String lastmemadded = lmp.getlastmemadded().getAttribute("Value");
		System.out.println("Last Member added: "+lastmemadded);
		
		String lastmemremoved = lmp.getlastmemremoved().getAttribute("Value");
		System.out.println("Last Member removed: "+lastmemremoved);
		
		utl.scrollToElement(ap.getMembersLabel());
		
		//Verification for Date Added
		if(lmp.getlistmembersgrid().getText().equalsIgnoreCase("")) {
			Assert.assertTrue(lastmemadded.equalsIgnoreCase(""));
			System.out.println("Members are not available for List and Last List Member Added is blank.");
		}
		else {
			Assert.assertEquals(latestdateadded, lastmemadded);
			System.out.println("Date Added matches.");
		}

		//Verification for Date Removed
		if(lmp.getlistmembersgrid().getText().equalsIgnoreCase("")) {
			Assert.assertTrue(lastmemremoved.contains(""));
			System.out.println("Members are not available for List.");
		}
		else {
			Assert.assertEquals(latestdateremoved, lastmemremoved);
			System.out.println("Date Removed matches.");
		}

		/*//Verify Date Added matches with List Last Updated Date
		Thread.sleep(3000);
		li.getgriddateadded().click();
		li.getsortnewtooldmemgrid().click();
		Assert.assertEquals(li.getgriddateadded().getText(), li.getlastupdatedmemberadded().getText());
		System.out.println("Date Added in grid matches with Member added Last Updated date.");

		//Verify Date Removed matches with List Last Updated Date
		Thread.sleep(3000);
		li.getgriddateremoved().click();
		li.getsortnewtooldmemgrid().click();
		Assert.assertEquals(li.getgriddateadded().getText(), li.getlastupdatedmemberadded().getText());
		System.out.println("Date Added in grid matches with Member added Last Updated date.");*/

		//Open list member and add Date Removed for a list member
		//utl.scrollToElement(ap.getMembersLabel());
		Actions action1 = new Actions(driver);
		WebElement OpenListMember = lmp.getopenlistmenmber();
		action1.doubleClick(OpenListMember).perform();
		Thread.sleep(5000);
		lmp.getdatremovedonlistmember().click();
		Thread.sleep(3000);
		lmp.getselectdateremoved().click();
		Thread.sleep(3000);
		String DateRemoved = lmp.getdatremovedonlistmember().getAttribute("Value");
		Thread.sleep(3000);
		lmp.getcompanyid().click();
		ap.getAccSaveBtn().click();
		Thread.sleep(3000);
		
		//Verify Date Removed at members grid
		ap.getPageBackBtn().click();
		Thread.sleep(3000);
		utl.scrollToElement(ap.getMembersLabel());
		Assert.assertEquals(ap.getContactsSectionEmailField().getText(), DateRemoved);
		System.out.println("Date Removed is reflected properly in members grid.");
		Thread.sleep(3000);

		//Verify addition of new List Member and verification in member grid
		lmp.getnewlistmember().click();
		Thread.sleep(3000);
		lmp.getaccountlistmember().click();

		//Create a new account
		lmp.getNewAccountBtnOnListMemForm().click();
		ap.getDiscardChangesBtn().click();
		Thread.sleep(4000);
		ap.getAccDBANametxbox().click();
		ap.getAccDBANametxbox().sendKeys(genData.generateRandomAlphaNumeric(10));
		accnameText= ap.getAccDBANametxbox().getAttribute("Value");
		System.out.println("Created Account: "+accnameText);
		
		ap.getPhone().click();
		ap.getPhone().sendKeys(genData.generateRandomNumber(10));
		//Scroll up the page till Address field
		act = new Actions(driver);
		act.moveToElement(ap.getAddress()).perform();

		//Select account type
		ap.getAccTypetxtbx().click();
		ap.getAcctypeExpandbtn().click();
		ap.getAccTypeBuyer().click();
		ap.getAddress().click();
		//Click on Save and Close button
		ap.getAccSaveCloseBtn().click();
		
		lmp.getaccountlistmember().click();
		lmp.getaccountlistmember().sendKeys(accnameText);
		lmp.getselectaccountlistmember().click();
		ap.getAccSaveBtn();
		ap.getPageBackBtn().click();
		lmp.getUnsavedChngsSavenContBtn().click();
		utl.scrollToElement(ap.getMembersLabel());
		lmp.getgriddateadded().click();
		lmp.getNewToOldFilterOptn().click();
		String latestdateaddedingrid = lmp.getgriddateadded().getAttribute("title");
		
		//Click on Refresh button
		lmp.getListRefreshBtn().click();
		
		Assert.assertEquals(latestdateaddedingrid, lmp.getListLastUpdatedDate().getAttribute("Value"));
		System.out.println("Date Added in grid matches with Member added Last Updated date.");
	}
}
