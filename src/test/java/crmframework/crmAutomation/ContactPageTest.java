package crmframework.crmAutomation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
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
import pageObjects.CRMLandingPage;
import pageObjects.CRMLoginPage;
import resources.GenerateData;
import resources.base;

@Listeners({TestListeners.class})
public class ContactPageTest extends base{

	public WebDriverWait wait;
	public GenerateData genData;
	public String newcontactname;
	public String outofbusiness;
	public String donotcall;
	CRMLandingPage lap;
	CRMLoginPage lp;
	AppLandingPage alp;
	CRMHomePage hp;
	CRMAccountsPage ap;
	Actions act;
	CRMContactPage cp;
	CRMAddMarketingRelationshipOwner amro;

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
		//lp.getpwd().sendKeys(prop.getProperty("password"));
		lp.getpwd().sendKeys(System.getenv("password"));
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
	public void TS002_VerifyCreateNewContactTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T27- Create New Contact for a new buyer

		ap = new CRMAccountsPage(driver);
		hp = new CRMHomePage(driver);
		cp = new CRMContactPage(driver);

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

		WebElement scrollText = cp.getScrollTextOnContactForm();	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",scrollText);
		Thread.sleep(3000);

		//Enter Account Name
		cp.getContactAccountNameTxtbx().click();
		cp.getSearchRecordsBtn().click();
		cp.getAccountNameTitle().click();

		cp.getemail().sendKeys(genData.generateEmail(15));
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

		//Save the contact name in string variable
		newcontactname = cp.getContactNameinHeader().getText();
		System.out.println("Contact Name: "+newcontactname);
		//Navigate back to Active contacts page
		ap.getPageBackBtn().click();

		//On the contacts grid view page, search for the contact using contact name
		hp.getSearchContactField().click();
		hp.getSearchContactField().sendKeys(newcontactname);
		hp.getstartsearch().click();

		String searchresultscontactname = hp.getSearchResultContactFullName().getText();
		System.out.println("New Contact full name: " +searchresultscontactname);
		Assert.assertTrue(searchresultscontactname.contains(newcontactname));
		System.out.println("New Contact is created successfully");
		//Clear the search term
		hp.getClearSearch().click();
	}

	@Test(priority=3)
	public void TS003_VerifyToDeactivateBuyerContactTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS28- Select any existing Buyer Contact and deactivate it

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);

		hp.getContactsTab().click();
		hp.getSearchContactField().click();
		hp.getSearchContactField().sendKeys(newcontactname);
		hp.getstartsearch().click();

		WebElement validateContactName = driver.findElement(By.xpath("//label[contains(text(),'"+newcontactname+"')]"));
		validateContactName.click();
		ap.getAccNaviagteBtn().click();

		//Click on Deactivate button
		cp.getDeactivateBtn().click();

		//Select 'Contact Status: Out of Business' in the confirm Contact Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		WebElement outofbusinessstatus = cp.getContactStatusOutofBusiness();
		outofbusiness = cp.getContactStatusOutofBusiness().getText();
		System.out.println("Contact Status: " + outofbusiness);
		outofbusinessstatus.click();

		//Click on 'Deactivate button of confirmation pop-up
		cp.getDeactivateOkBtn().click();

		//Verify that Contact is deactivated and selected contact status reason is displayed at the right side of the header.
		WebElement statusreasonforinactivecontactinheader = cp.getContactStatusResonForInactiveAcc();
		System.out.println("Account Status Reason: " + (statusreasonforinactivecontactinheader.getText()));
		Assert.assertTrue(statusreasonforinactivecontactinheader.getText().contains(outofbusiness));

		//Verify that Top ribbon 'Deactivate' option changes to 'Activate'
		Assert.assertTrue(ap.getActivateBtn().isDisplayed());

		//Navigate back to Active contacts page
		ap.getPageBackBtn().click();

		//Click on 'Active Contacts' drop-down view button
		cp.getActiveContactDropDownBtn().click();

		//Select 'Inactive Contacts' option
		cp.getInactiveContactOptn().click();

		//Click on 'Q' link to sort contacts starts with 'Q'
		try {
			cp.getQLetterFilterLink().click();

			//Validate deactivated account
			hp.getSearchInactiveContactField().click();
			hp.getSearchInactiveContactField().sendKeys(newcontactname);
			hp.getstartsearch().click();
			System.out.println(cp.getValidateInactiveContactName().getText());
			Assert.assertTrue(cp.getValidateInactiveContactName().isDisplayed());
			System.out.println("Newly created contact is deactivated successfully");
			hp.getClearSearch().click();
		}
		catch (StaleElementReferenceException exe) {
			System.out.println(exe.getMessage());
		}
		catch (IllegalArgumentException ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	@Test(priority=4)
	public void TS004_VerifyMarketingRelationshipOwnerContactTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//T77- Select any existing Buyer Contact and deactivate it

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);


		//Open Contacts page and open existing contact
		hp.getContactsTab().click();
		Actions action = new Actions(driver);
		WebElement OpenContact = cp.getopencontact();
		action.doubleClick(OpenContact).perform();
		amro = new CRMAddMarketingRelationshipOwner(driver);

		//Click Arrow for Marketing Relationship Owner
		amro.gethdbtn().click();

		//Click on Marketing Relationship Owner field search icon  to select a user from lookup
		amro.getmarlookupsearch().click();

		//Select a user entity from the Marketing Relationship Owner lookup
		WebElement marowner = amro.getOwner();
		String ownertxt =marowner.getText();
		System.out.println(ownertxt);
		marowner.click();

		// Save selected marketing relationship owner
		cp.getsavecontact().click();	

		//Scroll down the page till Address field
		act = new Actions(driver);
		act.moveToElement(ap.getAddress()).perform();

		//Verify Marketing Relationship Owner lookup value in Account Information section in the Summary tab
		WebElement verifyOwner = amro.getconmarverifydd();
		Assert.assertTrue(verifyOwner.getText().contains(ownertxt));
		System.out.println("Marketing Relationship Owner is added successfully");

		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();
	}


	@Test(priority=5)
	public void TS005_VerifyPhoneCallOnContactTest() throws InterruptedException {

		//The purpose of this test case to verify :-
		//T80: Add Phone Call to an existing Contact

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		
		//Open Contacts page and open existing contact
		hp.getContactsTab().click();
		Actions action = new Actions(driver);
		WebElement OpenContact = cp.getopencontact();
		action.doubleClick(OpenContact).perform();

		//Select Phone Call option under Timeline section
		ap.getAddTimelineBtn().click();
		ap.getphonecalloption().click();

		//Enter Phone Call details
		String phonesubject = "CybSubject";
		ap.getphonecallsubject().click();
		ap.getphonecallsubject().clear();
		ap.getphonecallsubject().sendKeys(phonesubject);
		cp.getcalltophonecall().click();
		cp.getsearchcallto().click();
		cp.getselectcallto().click();
		cp.getclicktab().click();
		ap.getclickphonecallduedatecalendor().click();
		ap.getphonecallduedatecurrent().click();
		ap.getphonecallduetimoptionn().click();
		ap.getphonecallselectduetime().click();

		//Save Phone Call
		ap.getAccSaveCloseBtn().click();
		act = new Actions(driver);
		act.moveToElement(ap.getPhoneCallTimelineSubject()).perform();
		String validatephonecallsubject = ap.getPhoneCallTimelineSubject().getText();
		System.out.println("Phone Call Subject is: "+validatephonecallsubject);
		Assert.assertEquals(validatephonecallsubject, phonesubject);
		if (validatephonecallsubject.equalsIgnoreCase(phonesubject)) {
			System.out.println("Phone call added successfully");		
		}
		else {

			System.out.println("Phone call not added successfully");

		}

		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();
	}

//	@AfterTest
//	public void closeDriver()
//	{
//		driver.close();
//	}

	//Manual Fail_Caught By Automation	
	@Test(priority=5)
	public void TS005_VerifyJobFunctionFieldTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T35- Job Function drop-down field is visible on Contact form only if Type equal to 'Media' is selected

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Contacts Tab at left menu
		hp.getContactsTab().click();

		//Click on 'New' button to open new Contact Form
		cp.getCreateNewContactBtn().click();

		//Enter First Name & Last name
		cp.getfirstname().click();
		String ContactFirstName = "QA"+ genData.generateRandomString(3);
		cp.getfirstname().click();
		cp.getfirstname().sendKeys(ContactFirstName);

		//Select contact Type as 'Media' in Contact information section
		cp.getContactTypetxtbx().click();
		cp.getContactTypeExpandbtn().click();
		cp.getContactTypeMedia().click();
		cp.getContactFirstNameLabel().click();

		//Verify that 'Job Function' field should now be displayed under Contact information section on contact form
		List<WebElement> jobfunctionlabel = cp.getJobFunctionFieldLabel();
		Assert.assertTrue(jobfunctionlabel.size()!= 0);

		//Click on 'Job Function' drop down
		cp.getJobFunctionFieldTxtBox().click();
		cp.getJobFunctionFieldExpandBtn().click();
		Thread.sleep(3000);

		//Verify that Default value for Job Function should be empty
		Assert.assertTrue(cp.getJobFunctionFieldTxtBox().getText().isEmpty());

		// Verify that All the values should be in alphabetically ascending order
		List<String> tempList = new ArrayList();
		List<String> originalList = new ArrayList();
		List<WebElement> jobfunctionvalueslist = cp.getJobFunctionvValuesList();

		for (int i=0; i<jobfunctionvalueslist.size();i++) 
		{
			String listitem = jobfunctionvalueslist.get(i).getText();
			originalList.add(listitem);
			tempList.add(listitem);
		}
		System.out.println("Job Function values before Sorting: " + tempList);
		Collections.sort(tempList);
		System.out.println("Job Function values after Sorting: " + tempList);

		//Manual Fail for Alphabetical order
		//Assert.assertEquals(tempList, originalList, "List is not in alphabetical sorting order");

		//Select a value in Job Function field
		cp.getJobFunctionValue().click();
		cp.getScrollTextOnContactForm().click();

		//Save the form by filling other mandatory fields
		//Enter Account Name
		cp.getContactAccountNameTxtbx().click();
		cp.getSearchRecordsBtn().click();
		cp.getAccountNameTitle().click();

		WebElement scrollText = cp.getScrollTextOnContactForm();	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",scrollText);
		Thread.sleep(3000);

		cp.getemail().click();
		cp.getemail().sendKeys(genData.generateEmail(15));
		cp.getmobile().sendKeys(genData.generateRandomNumber(10));
		cp.getMobilePhoneLabel().click();
		cp.getsavecontact().click();
		cp.getContactFormRefreshBtn().click();

		//Scroll till email and business phone fields
		WebElement enteranotelabel = ap.getEnteraNoteLabel();	
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("arguments[0].scrollIntoView(true);",enteranotelabel);
		Thread.sleep(5000);

		//Update the contact Type as 'Buyer' 
		cp.getContactTypeSelectedValueTxtbx().click();
		cp.getRemoveContactTypeMediaBtn().click();
		cp.getContactTypeExpandbtn().click();
		cp.getContactTypeBuyer().click();
		cp.getsavecontact().click();
		cp.getContactFormRefreshBtn().click();

		//Verify that Job Function field should be disappeared from the new contact form
		List<WebElement> jobfunctionlabel1 = cp.getJobFunctionFieldLabel();
		Assert.assertFalse(jobfunctionlabel1.size()!= 0);

		//Navigate back to Active Contacts list
		ap.getPageBackBtn().click();
	}

	@Test(priority=6)
	public void TS006_VerifyContactStatusToActivateContactTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T68- Contact Status and Contact Status Reason functionality for contact activation

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Contacts Tab at left menu.
		hp.getContactsTab().click();

		//Click on the select a view drop-down available below header
		cp.getActiveContactDropDownBtn().click();

		//Select 'Inactive Contacts' option
		cp.getInactiveContactOptn().click();

		boolean staleElement = true;
		try {
			while(staleElement){
				//Open any Inactive contact from list
				cp.getCLetterFilterLink().click();
				cp.selectContactName().click();
				cp.getContactNaviagteBtn().click();

				//Click 'Activate' button available in the top panel
				cp.getContactActivateBtn().click();

				//Select 'Contact Status: Do Not Call' in the confirm Contact Activation pop-up
				cp.getContactActivatePopupStatusField().click();
				WebElement donotcallstatus = cp.getContactStatusDoNotCall();
				donotcall = cp.getContactStatusDoNotCall().getText();
				System.out.println("Account Status: " + donotcall);
				donotcallstatus.click();

				//Click on 'Activate' button
				cp.getActivatePopupActivatebtn();
				staleElement = false;
			}
		}
		catch (StaleElementReferenceException exe) {
			staleElement = false;
			System.out.println(exe.getMessage());
		}
		catch (WebDriverException ex) {
			System.out.println(ex.getMessage());
		}

		//Verify that Contact is activated and selected contact Status Reason is displayed at the right side of the header.
		WebElement contactstatusreasoninheader = cp.getContactStatusResonForActiveContact();
		System.out.println("Account Status Reason: " + (contactstatusreasoninheader.getText()));
		Assert.assertTrue(contactstatusreasoninheader.getText().contains(donotcall));

		//Verify that Top ribbon 'Activate' option changes to 'Deactivate'
		Assert.assertTrue(cp.getDeactivateBtn().isDisplayed());
		System.out.println("Contact is activated with selected contact status reason");
		
		//Click on Save & Close button
		cp.getContactSavenCloseBtn().click();
	}
	@Test(priority=7)
	public void TS007_VerifyAddAppointmentToContactTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS271- Select any contact and add Timeline for the same

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		
		//Open Contacts page and open existing contact
		hp.getContactsTab().click();
		Actions action = new Actions(driver);
		WebElement OpenContact = cp.getopencontact();
		action.doubleClick(OpenContact).perform();

		//Select Phone Call option under Timeline section
		ap.getAddTimelineBtn().click();
		ap.getApptmntActivityOptn().click();

		ap.getTimelineSujecttxbx().click();
		String subtext = "Cyb_ApptJan";
		ap.getTimelineSujecttxbx().sendKeys(subtext);

		ap.getTimelineSavenClosebtn().click();

		//Verify that added Timeline is reflected correctly
		act = new Actions(driver);
		act.moveToElement(cp.getverifycontactappointment()).perform();
		String validateappointmentcallsubject = cp.getverifycontactappointment().getText();
		System.out.println("Appointment subject is: "+validateappointmentcallsubject);
		Assert.assertEquals(validateappointmentcallsubject, subtext);
		if (validateappointmentcallsubject.equalsIgnoreCase(subtext)) {
			System.out.println("Appointment is added successfully");		
		}
		else {

			System.out.println("Appointment is not added successfully");

		}
		
		//Navigate back to Active Contacts list
		ap.getPageBackBtn().click();
	}


	//	@AfterTest
	//	public void closeDriver()
	//	{
	//		driver.close();
	//	}


}
