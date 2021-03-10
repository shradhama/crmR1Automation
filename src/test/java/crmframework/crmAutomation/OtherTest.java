package crmframework.crmAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AppLandingPage;
import pageObjects.CRMAccountsPage;
import pageObjects.CRMAddMarketingRelationshipOwner;
import pageObjects.CRMContactPage;
import pageObjects.CRMHomePage;
import pageObjects.CRMIncentiveTab;
import pageObjects.CRMLandingPage;
import pageObjects.CRMLoginPage;
import resources.GenerateData;
import resources.base;

@Listeners({TestListeners.class})
public class OtherTest extends base{
	
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
	JavascriptExecutor jse;
	
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
		//lap.getLogin().sendKeys(prop.getProperty("username"));
		lap.getLogin().sendKeys(System.getenv("username"));
		lap.getnext().click();

		lp= new CRMLoginPage(driver);
		lp.getpwd().click();

		lp.getpwd().sendKeys(System.getenv("password"));
		//lp.getpwd().sendKeys(prop.getProperty("password"));
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
	
	@Test(priority=3)
	public void TS003_VerifyAddIncentiveToAccountTest() throws InterruptedException {

		//The purpose of this test case to verify:-
		//TS4-Select any existing Account and add Incentive

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		hp.getAccountTab().click();

		ap = new CRMAccountsPage(driver);
		ap.getAllFilterLink().click();
		//Thread.sleep(3000);

		// Search Account Name
		hp.getSearchAccountField().sendKeys("Cyb_QATest");
		hp.getstartsearch().click();
		//Thread.sleep(10000);

		inc = new CRMIncentiveTab(driver);
		// Open Account
		inc.accname().click();
		ap.getAccNaviagteBtn().click();
		//Thread.sleep(10000);

		// Click Incentives tab at existing account
		inc.getinctab().click();

		// Open New Incentive Form
		inc.getnewinc().click();

		// Select Contact at New Incentive Form
		inc.getconclick().click();
		inc.getconsearch().click();
		inc.getconselect().click();

		// Select Market at New Incentive Form
		inc.getmarclick().click();
		inc.getmarsearch().click();
		inc.getmarselect().click();

		// Select Referral Source at New Incentive Form
		inc.getrefclick().click();
		inc.getrefsearch().click();
		inc.getrefselect().click();

		// Enter Other Incentive Source at New Incentive Form
		inc.getosclick().click();
		inc.getosvalue().sendKeys("None");

		// Save and Close Incentive
		inc.getincsave().click();
		Thread.sleep(15000);
		// Incentive Verification
		if (inc.accname().getText().contains("Cyb") && inc.conname().getText().contains("Test") && inc.marname().getText().contains("Jan"))
		{
			System.out.println ("Incentive added successfully.");
		}
		else
		{
			System.out.println ("Incentive not added.");
		}

		//Navigate back to Active accounts list
		ap.getAccPageBackBtn().click();
		//Thread.sleep(3000);

		//Clear the search term
		hp.getClearSearch().click();
	}

	@Test(priority=2)
	public void TS002_VerifyAddIncentiveDetailsToAccountTest() throws InterruptedException
	{
		//The purpose of this test case to verify :-
		//TS36- Select any existing Account and add Incentive Details

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		hp.getAccountTab().click();

		ap = new CRMAccountsPage(driver);
		//Click on 'A' link to sort accounts starts with 'A'
		ap.getCLetterFilterLink().click();
		//Thread.sleep(4000);	

		//Select the account name in list
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();

		inc = new CRMIncentiveTab(driver);
		//Select 'Incentives' tab
		inc.getinctab().click();

		//Click on 'New Incentive Details' button
		inc.getIncDetaills().click();

		//Enter the data in Incentive field 
		inc.getInctxtbx().click();
		inc.getInctxtbx().sendKeys(Keys.ENTER); 

		inc.getIncChangeView().click();
		inc.getIncActiveIncs().click();
		//Thread.sleep(2000);
		inc.getIncName().click();

		//Enter the data in Incentive Category field
		inc.getIncCattxtbx().click();
		inc.getIncCattxtbx().sendKeys(prop.getProperty("incentivecategory"));
		inc.getIncCatSearch().click();
		String IncCatagtitle = inc.getIncCatName().getText();
		inc.getIncCatName().click();
		inc.getIncDetailsSavenClose().click();
		//Thread.sleep(5000);

		//Verify that added Incentive details are reflected correctly
		if ((inc.getValidateIncName().getText()).contains(IncCatagtitle)) {
			System.out.println("Incentive details get added successfully");
		}
		else {
			System.out.println("Fails to add Incentive Details");
		}

		//Verify that expected Success message displayed
		//Thread.sleep(3000);
		System.out.println(inc.getIncdtlsSuccessMsg().getText());
		Assert.assertEquals("Your changes were saved.", inc.getIncdtlsSuccessMsg().getText());

		ap = new CRMAccountsPage(driver);
		//Navigate back to Active accounts list
		ap.getAccPageBackBtn().click();
		//Thread.sleep(3000);
	}

	@Test(priority=4)
	public void TS004_VerifyRelatedTabOnAccountTest() throws InterruptedException {

		//The purpose of this test case to verify :-
		//Select any existing account and Verify Related Tab Functionality 

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		hp.getAccountTab().click();

		ap = new CRMAccountsPage(driver);
		//Click on 'A' link to sort accounts starts with 'A'
		ap.getCLetterFilterLink().click();
		//Thread.sleep(4000);	

		//Select the account name in list
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();
		//Thread.sleep(5000);
		//click on Related Tab and select Activities option from list. 
		ap.getRelatedTab().click();
		ap.getSelectActivitiesRelated().click();
		//Thread.sleep(5000);
		Boolean displayActivityTab = ap.getActivityTab().isDisplayed();
		System.out.println("Activities Tab Opened successfully:"+displayActivityTab);

		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();			
		//Thread.sleep(3000);
	}
	
	@Test(priority=28)
	public void TS023_VerifyExportToExcelTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T293- Verify Export To Excel functionality for Accounts

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Accounts Tab at left menu.
		hp.getAccountTab().click();
		
		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();
		
		//Click Export To Excel option under it
		ap.getclickexporttoexcelbutton().click();
		
		//Export file to online excel
		ap.getopenexcelonline().click();
		//ap.getsaveexcelonline().click();
		
		Thread.sleep(5000);
		ap.getclosepopupexcelonline().click();   
		Thread.sleep(10000);
		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();
				
		//Click Export To Excel option under it
		ap.getclickexporttoexcelbutton().click();
		
		//Export Excel to Static Worksheet
		ap.getexporttostaticworksheet().click();
		
		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();
				
		//Click Export To Excel option under it
		ap.getclickexporttoexcelbutton().click();
		
		//Export Excel to Static Worksheet Page Only
		ap.getexporttostaticworksheetpageonly().click();
		
		//Click three dots for Export option in header
		//ap.getclickoverflowbutton().click();
				
		//Click Export To Excel dropdown arrow option under it
		ap.getclickexporttoexcelbutton().click();
		
		//Export to Dynamic Worksheet
		ap.getexporttodynamicworksheet().click();
		ap.getselectcheckbox1().click();
		ap.getselectcheckbox2().click();
		ap.getexportworksheetpopup().click();
		
		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();
						
		//Click Export To Excel option under it
		ap.getclickexporttoexcelbutton().click();
		
		//Export to Dynamic Pivot Table
		ap.getexporttodynamicpivottable().click();
		ap.getselectcheckbox1().click();
		ap.getselectcheckbox2().click();
		ap.getexportworksheetpopup().click();
	}
	
	@Test(priority=26)
	public void TS025_VerifyBusinessRuleForAddressTest() throws InterruptedException {

		//The purpose of this test case to verify :-
		//T308: Select any existing account and click on Details Tab Functionality 

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		hp.getAccountTab().click();

		ap = new CRMAccountsPage(driver);
		Thread.sleep(10000);
		//Click on 'New' button
		ap.getAccountNewbtn().click();
		
		ap.getAccountnametxtbx().click();
		ap.getAccountnametxtbx().sendKeys(genData.generateRandomAlphaNumeric(10));
		ap.getAccSaveBtn().click();
		
		ap.getNotificationExpandIcon().click();
		ap.getNotificationExpandIcon().click();
		ap.getAccountnametxtbx().sendKeys(Keys.TAB);
		ap.getPhone().click();	
		String totalwarningmessage= ap.getNotificationWrapperMsg().getText();
		Assert.assertEquals(totalwarningmessage, "You have 7 notifications. Select to view.");
		System.out.println("Warning message displayed.");
		Thread.sleep(5000);
		ap.getAddress().click();

		//Scroll down on the page		
		WebElement acctypelabel = ap.getAccTypeLabel();
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",acctypelabel);

		//Enter Street1 address
		ap.getStreet1().sendKeys(prop.getProperty("street1"));
	
		//Enter City
		ap.getCity().click();
		ap.getCity().sendKeys(prop.getProperty("city"));
		
		//Scroll down on the page		
		WebElement accstreet3label = ap.getAccStreet3Label();
		jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",accstreet3label);

		//Enter state
		ap.getState().click();
		ap.getState().sendKeys(prop.getProperty("state"));

		//Enter zipcode
		ap.getZipcode().click();
		ap.getZipcode().sendKeys(prop.getProperty("zipcode"));

		//Enter country
		ap.getCountrytxbx().click();
		ap.getCountrydrpbtn().click();
		ap.getCountryName().click();
		ap.getAccSaveBtn().click();
		
		String typewarningmessage=ap.getTypeNotificationWrapperMsg().getText();
		Assert.assertEquals(typewarningmessage, "Type : Required fields must be filled in.");
		System.out.println("Displayed only Type warning message displayed.");
		ap.getPageBackBtn().click();
		ap.getDiscardChangesBtn().click();
	}
	
	@Test(priority=26)
	public void TS026_VerifyAssociatedListsSectionTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T288- Verify lists are available or not for an Account

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Accounts Tab at left menu.
		hp.getAccountTab().click();
		
		//Open an existing account
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("listaccount"));
		ap.getclicksearchbutton().click();
		hp.getSearchResultAcc().click();
		ap.getAccNaviagteBtn().click();
		
		//Scroll to Associated Lists section
		WebElement contacts = ap.getscrolltocontacts();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",contacts);
		
		WebElement associatedlists = ap.getscrolltoassociatedlists();
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("arguments[0].scrollIntoView(true);",associatedlists);
		
		// Verify if Lists are available in Lists section
		WebElement NoList = ap.getnolist();
		Assert.assertFalse(NoList.getText().equalsIgnoreCase(""));
		System.out.println("List is available for the account");
		
		// Verify for List Members
		WebElement List = ap.getlist();
		List.click();
		
		ap.getSelectedListName().click();
		
		//Scroll till Members section	
		WebElement listmemremovedlabel = ap.getListMemRemovedLabel();	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",listmemremovedlabel);
		Thread.sleep(3000);
		
		WebElement memberslabel = ap.getMembersLabel();	
		JavascriptExecutor jse3 = (JavascriptExecutor)driver;
		jse3.executeScript("arguments[0].scrollIntoView(true);",memberslabel);
		Thread.sleep(5000);
		
		WebElement ListMember = ap.getlistmember();
		Assert.assertFalse(ListMember.getText().equalsIgnoreCase(""));
		System.out.println("List memeber is available");
		ap.getPageBackBtn().click();
		ap.getPageBackBtn().click();
	}
	
	@Test(priority=27)
	public void TS027_VerifyAddNewTaskFromTimelineToAccountTest() throws InterruptedException
	{
		//The purpose of this test case to verify that:-
		//TS296- User is able to add a new Task from Timeline section on account form

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		hp.getAccountTab().click();

		ap = new CRMAccountsPage(driver);
		//Click on 'A' link to sort accounts starts with 'A'
		ap.getCLetterFilterLink().click();	

		//Select the account name in list
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();

		//Click on create a timeline button
		ap.getAddTimelineBtn().click();
		ap.getTaskBtnOnTimeline().click();

		ap.getTaskSujecttxbx().click();
		String subtext = "Cyb_TestTask";
		ap.getTaskSujecttxbx().sendKeys(subtext);

		ap.getTaskSavenClosebtn().click();

		//Verify that added Task is reflected correctly
		WebElement task = driver.findElement(By.xpath("//*[text()='"+subtext+"']"));
		Assert.assertEquals(task.getText(), subtext);

		//Verify that expected Success message displayed
		Assert.assertEquals("Your changes were saved.", ap.getSuccessMsg().getText());

		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();
	}
	
	/*@AfterTest
	public void closeDriver()
	{
		driver.close();
	}*/

}
