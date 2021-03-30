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
import pageObjects.CRMIncentiveTab;
import pageObjects.CRMLandingPage;
import pageObjects.CRMLoginPage;
import pageObjects.CRMPeoplePage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class PeoplePageTest extends base {

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
	public void TS002_VerifyCreatePeopleRecordTest() throws InterruptedException
	{
		//The purpose of this test case:-
		//CRM-T150- Verify with creation of a new contact record, an associated person record 
		//is automatically created(associate)

		ap = new CRMAccountsPage(driver);
		hp = new CRMHomePage(driver);
		cp = new CRMContactPage(driver);
		pl = new CRMPeoplePage(driver);

		//Click on Contacts Tab at left menu
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

		//Thread.sleep(5000);
		WebElement scrollText = cp.getScrollTextOnContactForm();	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",scrollText);
		Thread.sleep(3000);

		//Enter Account Name
		cp.getContactAccountNameTxtbx().click();
		//cp.getSearchRecordsBtn().click();
		//cp.getAccountNameTitle().click();
		pl.getselectaccountnamedd().click();

		cp.getemail().click();
		cp.getemail().sendKeys(genData.generateEmail(15));

		cp.getmobile().click();
		cp.getmobile().sendKeys(genData.generateRandomNumber(10));
		cp.getMobilePhoneLabel().click();
		Thread.sleep(2000);
		WebElement scrollText1 = cp.getMobilePhoneLabel();	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",scrollText1);
		Thread.sleep(3000);

		cp.getstreet1().sendKeys(genData.generateStringWithAllobedSplChars(20, "@,!Q#@$%#%"));
		cp.getcity().click();
		cp.getcity().sendKeys(prop.getProperty("city"));
		//WebElement scrollText2 = cp.getCityLabel();	
		//JavascriptExecutor js1 = (JavascriptExecutor)driver;
		//js1.executeScript("arguments[0].scrollIntoView(true);",scrollText2);
		//Thread.sleep(3000);

		cp.getstateorprovince().sendKeys(prop.getProperty("state"));
		cp.getziporpostalcode().click();
		cp.getziporpostalcode().sendKeys(genData.generateRandomNumber(6));

		//Enter country
		cp.getCountrytxbx().click();
		cp.getCountrydrpbtn().click();
		cp.getCountryName().click();

		//Click on Save button in header
		cp.getsavecontact().click();
		//cp.getContactFormRefreshBtn().click();
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(5000);

		//Save the contact name in string variable
		String contactnameinheader = cp.getContactNameinHeader().getText();
		System.out.println("Contact Name: "+contactnameinheader);

		Thread.sleep(5000);
		//Click on the 'More Header fields' button in front of Status Reason field
		pl.getMoreHeaderFieldsBtn().click();
		Thread.sleep(5000);

		//Verify that Person field is displayed with the newly created contact name
		Assert.assertTrue(pl.getPersonFieldLabel().isDisplayed());
		String perosnname = pl.getPersonNameInHeader().getText();
		System.out.println("Person name in header:" +perosnname);
		Assert.assertTrue(perosnname.contains(contactnameinheader));

		//Click on Person hyperlink
		pl.getPersonNameInHeader().click();

		//Verify that Person details form should be displayed along with a Contacts section 
		//displaying the contact records associated with it.
		Assert.assertTrue(pl.getPersonFormTitle().getText().contains(perosnname));
		Assert.assertTrue(pl.getContactsSectionLabelOnPersonForm().isDisplayed());
		Assert.assertTrue(pl.getContactFullNameInContactsSection().getText().contains(contactnameinheader));
		System.out.println("Contact's Person record is created successfully");

		//Navigate back to Active contacts page
		ap.getPageBackBtn().click();
		ap.getPageBackBtn().click();
	}
	@Test(priority=3)
	public void TS003_VerifyExportToExcelPeopleTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T268- Verify Export To Excel functionality for People

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		pl = new CRMPeoplePage(driver);
		cp = new CRMContactPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on People Tab at left menu and search people containing Cyb
		hp.getPeopleTab().click();
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("name"));
		ap.getclicksearchbutton().click();

		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();

		//Click Export To Excel option under it
		pl.getexporttoexcel().click();

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
		Thread.sleep(30000);

		//Verify export to excel online
		//pl.getclickonlineexcel().click();
		//Assert.assertTrue(pl.getonlineexportverification().getText().contains("Completed"));
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
		pl.getexporttoexcel().click();

		//Export Excel to Static Worksheet
		ap.getexporttostaticworksheet().click();

		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();

		//Click Export To Excel option under it
		pl.getexporttoexcel().click();

		//Export Excel to Static Worksheet Page Only
		ap.getexporttostaticworksheetpageonly().click();

		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();

		//Click Export To Excel dropdown arrow option under it
		pl.getexporttoexcel().click();

		//Export to Dynamic Worksheet
		ap.getexporttodynamicworksheet().click();
		pl.getselectdynamicexportoptionschk1().click();
		pl.getselectdynamicexportoptionschk2().click();
		ap.getexportworksheetpopup().click();

		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();

		//Click Export To Excel option under it
		pl.getexporttoexcel().click();

		//Export to Dynamic Pivot Table
		ap.getexporttodynamicpivottable().click();
		pl.getselectdynamicexportoptionschk1().click();
		pl.getselectdynamicexportoptionschk2().click();
		ap.getexportworksheetpopup().click();
	}

	@Test(priority=4)
	public void TS004_VerifyRelatedContactsForPeopleRecordTest() throws InterruptedException
	{
		//The purpose of this test case:-
		//CRM-T231- Verify CRM User is able to open any person record available on Active 
		//people list grid view and see contacts associated to it.
		//Add existing contact or create new contact from person record.

		ap = new CRMAccountsPage(driver);
		hp = new CRMHomePage(driver);
		cp = new CRMContactPage(driver);
		pl = new CRMPeoplePage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on People Tab at left menu
		hp.getPeopleTab().click();

		//Select and open any Active person record
		pl.getALetterFilterLink().click();
		String expectedperosnname = pl.selectPersonName().getText();
		pl.selectPersonName().click();

		//Verify Contacts Sub section with grid columns on Person form
		Assert.assertTrue(pl.getContactsSectionLabelOnPersonForm().isDisplayed());
		Assert.assertTrue(pl.getFullNameColmnTextInContactsSectn().isDisplayed());
		Assert.assertTrue(pl.getEmailColmnTextInContactsSectn().isDisplayed());
		Assert.assertTrue(pl.getAccountNameColmnTextInContactsSectn().isDisplayed());
		Assert.assertTrue(pl.getBusinessPhoneColmnTextInContactsSectn().isDisplayed());
		Assert.assertTrue(pl.getStatusColmnTextInContactsSectn().isDisplayed());

		//In contacts section, Click on 'New Contact', to create a new contact for person
		pl.getNewContactBtnInContactsSectn().click();
		Assert.assertTrue(cp.getNewContactHeaderOnContactForm().isDisplayed());

		//Enter required details and click on Save and close in header
		//Enter First Name
		cp.getfirstname().click();
		String ContactFirstName = prop.getProperty("contactfirstname");
		cp.getfirstname().click();
		cp.getfirstname().sendKeys(ContactFirstName);

		//Select Contact type
		cp.getContactTypetxtbx().click();
		cp.getContactTypeExpandbtn().click();
		cp.getContactTypeBuyer().click();
		cp.getContactFirstNameLabel().click();

		//Thread.sleep(5000);
		WebElement scrollText = cp.getScrollTextOnContactForm();	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",scrollText);
		Thread.sleep(3000);

		//Enter Account Name
		cp.getContactAccountNameTxtbx().click();
		cp.getSearchRecordsBtn().click();
		cp.getAccountNameTitle().click();

		cp.getemail().click();
		cp.getemail().sendKeys(genData.generateEmail(15));

		//Click on Save button in header
		cp.getsavecontact().click();
		Thread.sleep(5000);
		//Save the contact name in string variable
		String contactnameinheader = cp.getContactNameinHeader().getText();
		System.out.println("Contact Name: "+contactnameinheader);
		//Click on Save & Close button in header
		cp.getContactSavenCloseBtn().click();

		//Scroll to Contacts section
		utl.scrollToElement(pl.getContactsSectionLabelOnPersonForm());		
		pl.getFullNameColmnTextInContactsSectn().click();
		pl.getFullNameSortZtoAFilter().click();
		Thread.sleep(3000);

		//Verify that newly created contact should be displayed in Contacts section on person record
		Assert.assertTrue(pl.getContactFullNameInContactsSection().getText().contains(contactnameinheader));

		//Select and open a contact available in contacts grid section
		pl.getContactFullNameInContactsSection().click();
		Thread.sleep(5000);

		//Click on the 'More Header fields' button in front of Status Reason field
		pl.getMoreHeaderFieldsBtn().click();

		//Verify that Person name of the person record should be displayed, from which we navigated to contact record
		String perosnname = pl.getPersonNameInHeader().getText();
		System.out.println("Person name in header:" +perosnname);
		Assert.assertTrue(perosnname.contains(expectedperosnname));

		//Navigate back to Active People list
		ap.getPageBackBtn().click();
		ap.getPageBackBtn().click();
	}
	@Test(priority=5)
	public void TS005_VerifyGridFiltersPeopleTest() throws InterruptedException
	{
		//The purpose of this test case:-
		//CRM-T269- Verify Full Name and EIH Match Key filters on People Grid
		
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		pl = new CRMPeoplePage(driver);
		cp = new CRMContactPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on People Tab at left menu and search people containing Cyb
		hp.getPeopleTab().click();
		
		//Click funnel for Full Name column
		pl.getfullname().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		ap.getselectoperatorone().click();
		ap.getclickaddressvaluefield().sendKeys(prop.getProperty("peoplename"));
		ap.getclickapplybutton().click();
		Thread.sleep(5000);
			
		//Verify Full Name value selected on accounts grid
		WebElement accnamevaluesongrid = null;
		for (int i=0;i<7;i++)
		{
			accnamevaluesongrid = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']"));
			Assert.assertTrue(accnamevaluesongrid.getText().contains(prop.getProperty("peoplename")));
		}
		System.out.println("Full Name matches expected criteria");

		//Clear Filter for Full Name
		pl.getfullname().click();
		ap.getclearfiltergrid().click();

		//Click funnel for EIH Match Key column
		pl.geteihmatchkey().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		ap.getselectoperatorone().click();
		ap.getclickaddressvaluefield().sendKeys(prop.getProperty("phone"));
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify EIH Match Key value selected on accounts grid
		WebElement phonevaluesongrid = null;
		for (int i=0;i<7;i++)
		{
			phonevaluesongrid = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-3']"));
			Assert.assertTrue(phonevaluesongrid.getText().contains(prop.getProperty("phone")));
		}
		System.out.println("EIH Match Key matches expected criteria");

		//Clear Filter for EIH Match Key
		pl.geteihmatchkey().click();
		ap.getclearfiltergrid().click();
			
	}
}



