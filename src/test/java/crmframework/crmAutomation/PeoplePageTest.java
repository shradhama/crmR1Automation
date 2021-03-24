package crmframework.crmAutomation;

import java.io.IOException;
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
		cp.getSearchRecordsBtn().click();
		cp.getAccountNameTitle().click();

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
		WebElement scrollText2 = cp.getCityLabel();	
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].scrollIntoView(true);",scrollText2);
		Thread.sleep(3000);

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
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(5000);

		//Save the contact name in string variable
		String contactnameinheader = cp.getContactNameinHeader().getText();
		System.out.println("Contact Name: "+contactnameinheader);

		Thread.sleep(5000);
		//Click on the 'More Header fields' button in front of Status Reason field
		pl.getMoreHeaderFieldsBtn().click();

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

}



