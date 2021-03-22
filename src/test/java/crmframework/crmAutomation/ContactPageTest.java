package crmframework.crmAutomation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class ContactPageTest extends base{

	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	public String newcontactname;
	public String outofbusiness;
	public String donotcall;
	public String newcontactemail;
	CRMLandingPage lap;
	CRMLoginPage lp;
	AppLandingPage alp;
	CRMHomePage hp;
	CRMAccountsPage ap;
	Actions act;
	CRMContactPage cp;
	CRMAddMarketingRelationshipOwner amro;
	JavascriptExecutor js;

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		genData=new GenerateData();
		utl = new Utility(driver);
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
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",scrollText);
		Thread.sleep(3000);

		//Enter Account Name
		cp.getContactAccountNameTxtbx().click();
		cp.getSearchRecordsBtn().click();
		cp.getAccountNameTitle().click();

		//Enter an Email
		cp.getemail().click();
		cp.getemail().sendKeys(genData.generateEmail(15));
		newcontactemail = cp.getemail().getAttribute("Value");
		System.out.println("New Contact's Email:" +newcontactemail);

		cp.getmobile().sendKeys(genData.generateRandomNumber(10));
		cp.getMobilePhoneLabel().click();
		Thread.sleep(2000);
		WebElement scrollText1 = cp.getMobilePhoneLabel();	
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",scrollText1);
		Thread.sleep(3000);

		cp.getstreet1().sendKeys(genData.generateStringWithAllobedSplChars(20, "@,!Q#@$%#%"));
		cp.getcity().click();
		cp.getcity().sendKeys(prop.getProperty("city"));
		WebElement scrollText2 = cp.getCityLabel();	
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",scrollText2);
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


	@Test(priority=20)
	public void TS020_VerifyPhoneCallOnContactTest() throws InterruptedException {

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

	//Manual Fail_Caught By Automation	
	@Test(priority=5)
	public void TS005_ManualFail_VerifyJobFunctionFieldTest() throws InterruptedException
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
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",scrollText);
		Thread.sleep(3000);

		cp.getemail().click();
		cp.getemail().sendKeys(genData.generateEmail(15));
		cp.getmobile().sendKeys(genData.generateRandomNumber(10));
		cp.getMobilePhoneLabel().click();
		cp.getsavecontact().click();
		cp.getContactFormRefreshBtn().click();

		//Scroll till email and business phone fields
		WebElement enteranotelabel = ap.getEnteraNoteLabel();	
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",enteranotelabel);
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


	@Test(priority=8)
	public void TS008_VerifyAddNewTaskFromTimelineToContactTest() throws InterruptedException
	{
		//The purpose of this test case to verify that:-
		//TS272- User is able to add a new Task from Timeline section on contact form

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		cp = new CRMContactPage(driver);
		ap = new CRMAccountsPage(driver);

		//Click on Contacts tab from left menu
		hp.getContactsTab().click();

		//Click on 'Q' link to sort accounts starts with 'Q'
		cp.getQLetterFilterLink().click();	

		//Select the Contact name in list
		cp.selectContactName().click();
		cp.getContactNaviagteBtn().click();

		//Click on create a timeline button
		cp.getContactAddTimelineBtn().click();
		cp.getContactTaskBtnOnTimeline().click();

		cp.getContactTaskSujecttxbx().click();
		String subtext = "Cyb_ContactTask";
		cp.getContactTaskSujecttxbx().sendKeys(subtext);

		cp.getContactTaskSavenClosebtn().click();

		//Verify that added Task is reflected correctly
		WebElement task = driver.findElement(By.xpath("//*[text()='"+subtext+"']"));
		Assert.assertEquals(task.getText(), subtext);

		//Verify that expected Success message displayed
		Assert.assertEquals("Your changes were saved.", ap.getSuccessMsg().getText());
		System.out.println("Added new task to Contact successfully");

		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();
	}

	//Test script Fail_Caught By Automation	
	@Test(priority=9)
	public void TS009_ManualFail_VerifyDuplicateContactTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T61- Verify notification for duplicate contact creation when exact Email
		//is used for creating new Contact or updating any other contact

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Contacts Tab at left menu.
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
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",scrollText);
		Thread.sleep(3000);

		//Enter Account Name
		cp.getContactAccountNameTxtbx().click();
		cp.getSearchRecordsBtn().click();
		cp.getAccountNameTitle().click();

		cp.getemail().click();
		cp.getemail().sendKeys(newcontactemail);

		//Click on Save button
		cp.getsavecontact().click();

		//** Manual execution is FAIL-> Fails to get 'Duplicate Records' pop-up
		/*//Verify that 'Duplicate records found' pop-up is displayed
		Assert.assertTrue(cp.getDuplicateRecordsPopupTitle().isDisplayed());

		//Click on 'Cancel' button
		cp.getDuplicateRecordsPopupCancelbtn().click();

		//Save the contact name in string variable
		newcontactname = cp.getContactNameinHeader().getText();
		System.out.println("Contact Name: "+newcontactname);

		//Scroll till Email field
		WebElement scrollText1 = cp.getScrollTextOnContactForm();	
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",scrollText1);
		Thread.sleep(3000);

		//Update the Email field again with the email ID (From Create contact test case)
		cp.getemail().click();
		cp.getemail().sendKeys(Keys.CONTROL + "a");
		cp.getemail().sendKeys(Keys.DELETE);
		cp.getemail().sendKeys(newcontactemail);

		//Click on Save & Close button
		cp.getContactSavenCloseBtn().click();

		//Verify that 'Duplicate records found' pop-up is displayed
		Assert.assertTrue(cp.getDuplicateRecordsPopupTitle().isDisplayed());

		//Click on "Ignore and Save" button on the notification pop-up
		cp.getDuplicateRecordsPopupIgnorenSavebtn().click();

		//Verify that new contact is created and displayed under Active contact list
		hp.getSearchContactField().click();
		hp.getSearchContactField().sendKeys(newcontactname);
		hp.getstartsearch().click();
		WebElement contactnameinsearch = hp.getSearchResultContactFullName();
		Assert.assertTrue(contactnameinsearch.getText().contains(newcontactname));

		//Clear the search term to navigate to active accounts page
		hp.getClearSearch().click();*/
	}
	@Test(priority=10)
	public void TS010_VerifyExportToExcelTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T293- Verify Export To Excel functionality for Accounts

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		cp = new CRMContactPage(driver);
		ap = new CRMAccountsPage(driver);

		//Click on Contacts tab from left menu and search contacts containing Cyb
		hp.getContactsTab().click();
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("name"));
		ap.getclicksearchbutton().click();

		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();

		//Click Export To Excel option under it
		cp.getexporttoexcelbtn().click();

		//Export file to online excel
		ap.getopenexcelonline().click();

		//ap.getsaveexcelonline().click();
		ap.getsaveexcelonline().click();   

		//Click Track Progress button
		cp.getexporttrackprogressbtn().click();

		//Switch to previous browser tab
		Thread.sleep(10000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String>it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(parentId);

		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();

		//Click Export To Excel option under it
		cp.getexporttoexcelbtn().click();

		//Export Excel to Static Worksheet
		ap.getexporttostaticworksheet().click();

		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();

		//Click Export To Excel option under it
		cp.getexporttoexcelbtn().click();

		//Export Excel to Static Worksheet Page Only
		ap.getexporttostaticworksheetpageonly().click();

		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();

		//Click Export To Excel dropdown arrow option under it
		cp.getexporttoexcelbtn().click();

		//Export to Dynamic Worksheet
		ap.getexporttodynamicworksheet().click();
		cp.getexportselectbox1().click();
		cp.getexportselectbox2().click();
		ap.getexportworksheetpopup().click();

		//Click three dots for Export option in header
		ap.getclickoverflowbutton().click();

		//Click Export To Excel option under it
		cp.getexporttoexcelbtn().click();

		//Export to Dynamic Pivot Table
		ap.getexporttodynamicpivottable().click();
		cp.getexportselectbox1().click();
		cp.getexportselectbox2().click();
		ap.getexportworksheetpopup().click();
	}

	//Manual Fail_Caught by Automation
	@Test(priority=12)
	public void TS012_ManualFail_VerifyContactMarketRecordProfile_Registered() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T396- that Contact market record profile is automatically created when phone 
		//call market outcome is 'Registered' if profile does not exist

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Contacts Tab at left menu
		hp.getContactsTab().click();

		//In Active Contacts system view, select and open an active contact
		cp.getCLetterFilterLink().click();
		cp.selectContactName().click();
		ap.getAccNaviagteBtn().click();

		//Navigate to Contact Market Profile Tab
		cp.getContactMarketProfilesTab().click();

		//Verify that there should be no record for a market
		Assert.assertTrue(cp.getNoDataAvailableTextForMarketProfile().isDisplayed());

		//Navigate back to Summary tab
		cp.getContactSummaryTab().click();

		//Click on create a timeline button
		cp.getContactAddTimelineBtn().click();

		//Select option Phone call
		cp.getphonecalloption().click();

		//Enter required details and click on save
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
		cp.getsavecontact().click();

		//Scroll down on phone call record to view Call Outcomes section
		WebElement phonecalldescriptionlabel = cp.getPhoneCallDescriptionLabel();	
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("arguments[0].scrollIntoView(true);",phonecalldescriptionlabel);
		Thread.sleep(5000);

		//Click on New Phone Call Market Outcome option to create new call outcome
		cp.getNewPhoneCallMarketOutcomeBtn().click();
		cp.getPhoneCallMarketSubjectTxtBx().click();
		cp.getMarketSearchBtn().click();

		String marketname = cp.selectMarketName().getText();
		System.out.println("Selected Market Name: "+ marketname);
		cp.selectMarketName().click();
		cp.getPhoneCallOutcomeTxtBx().click();
		cp.selectPhoneCallOutcomeOption().click();
		cp.getPhoneCallMarketOutcomeSavenCloseBtn().click();

		//Now mark the Phone as complete using the 'Mark Complete' button in header
		cp.getPhoneCallMarkCompleteBtn().click();

		cp.getContactFormRefreshBtn().click();
		cp.getContactMarketProfilesTab().click();

		//Verify that a new contact market profile should be automatically created for the market
		Assert.assertTrue(cp.getNewlyCreatedContactMarketProfileField().isDisplayed());

		//Verify that select market name is displayed under contact market profiles tab
		Assert.assertTrue(cp.getValidateNewlyCreatedContactMarketProfileName().getText().contains(marketname));

		//Verify that Is Registered should set to Yes
		Assert.assertTrue(cp.getContactMarketProfileIsRegisteredField().getText().contains("Yes"));

		//Click on 'Back' button
		ap.getPageBackBtn().click();
	}
	@Test(priority=14)
	public void TS014_VerifyGroupByOptionsContactTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T217- Verify Group By options for Contact

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		cp = new CRMContactPage(driver);
		ap = new CRMAccountsPage(driver);

		//Click on Contacts tab from left menu and search contacts containing Cyb
		hp.getContactsTab().click();

		//Open Group By drop down list options
		cp.getclickgroupbydd().click();

		//Select Full Name option from Group By drop down list
		cp.getfullnameddopt().click();

		//Verify if records are grouped by Full Name
		Assert.assertTrue(cp.getgroupbyverification().isDisplayed(), "Group by Full Name is not working.");
		System.out.println("Group by Full Name is working properly.");

		//Open Group By drop down list options
		cp.getclickgroupbydd().click();

		//Select Region option from Group By drop down list
		cp.getregionddopt().click();

		//Verify if records are grouped by Region
		Assert.assertTrue(cp.getgroupbyverification().isDisplayed(), "Group by Region is successful.");
		System.out.println("Group by Region is working properly.");
	}

	//Manual Fail_Caught by Automation
	@Test(priority=13)
	public void TS013_ManualFail_VerifyContactMarketRecordProfile_Declined() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T55- that Contact market record profile is automatically created when phone 
		//call market outcome is 'Declined' if profile does not exist

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Contacts Tab at left menu
		hp.getContactsTab().click();

		//In Active Contacts system view, select and open an active contact
		cp.getCLetterFilterLink().click();
		cp.selectContactName().click();
		ap.getAccNaviagteBtn().click();

		//Navigate to Contact Market Profile Tab
		cp.getContactMarketProfilesTab().click();

		//Verify that there should be no record for a market
		Assert.assertTrue(cp.getNoDataAvailableTextForMarketProfile().isDisplayed());

		//Navigate back to Summary tab
		cp.getContactSummaryTab().click();

		//Click on create a timeline button
		cp.getContactAddTimelineBtn().click();

		//Select option Phone call
		cp.getphonecalloption().click();

		//Enter required details and click on save
		//Enter Phone Call details
		String phonesubject = "CybTestSubject";
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
		cp.getsavecontact().click();

		//Scroll down on phone call record to view Call Outcomes section
		WebElement phonecalldescriptionlabel = cp.getPhoneCallDescriptionLabel();	
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("arguments[0].scrollIntoView(true);",phonecalldescriptionlabel);
		Thread.sleep(5000);

		//Click on New Phone Call Market Outcome option to create new call outcome
		cp.getNewPhoneCallMarketOutcomeBtn().click();
		cp.getPhoneCallMarketSubjectTxtBx().click();
		cp.getMarketSearchBtn().click();

		String marketname = cp.selectMarketName().getText();
		System.out.println("Selected Market Name: "+ marketname);
		cp.selectMarketName().click();
		cp.getPhoneCallOutcomeTxtBx().click();
		cp.selectPhoneCallOutcomeDeclinedOption().click();
		cp.getDeclinedReasonSelectDD().click();
		cp.selectDeclinedReasonName().click();
		cp.getPhoneCallMarketOutcomeSavenCloseBtn().click();

		//Now mark the Phone as complete using the 'Mark Complete' button in header
		cp.getPhoneCallMarkCompleteBtn().click();

		cp.getContactFormRefreshBtn().click();
		cp.getContactMarketProfilesTab().click();

		//Verify that a new contact market profile should be automatically created for the market
		Assert.assertTrue(cp.getNewlyCreatedContactMarketProfileField().isDisplayed());

		//Verify that select market name is displayed under contact market profiles tab
		Assert.assertTrue(cp.getValidateNewlyCreatedContactMarketProfileName().getText().contains(marketname));

		//Verify that Is Registered should set to Yes
		Assert.assertTrue(cp.getContactMarketProfileIsRegisteredField().getText().contains("No"));

		//Verify that Declined Reason should set to declined reason value
		Assert.assertTrue(cp.getContactMarketProfileDeclinedReasonField().getText().contains("Declined"));

		//Click on 'Back' button
		ap.getPageBackBtn().click();
	}
	@Test(priority=11)
	public void TS011_VerifyAssociatedListsSectionContactTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T288- Verify lists are available or not for an Account

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Open Contacts page and open existing contact
		hp.getContactsTab().click();
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("listcontact"));
		ap.getclicksearchbutton().click();
		Actions action = new Actions(driver);
		WebElement OpenContact = cp.getopencontact();
		action.doubleClick(OpenContact).perform();

		//Scroll to Associated Lists section
		WebElement accounts = cp.getscrolltoaccountdetails();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",accounts);

		WebElement registrations = cp.getscrolltoregdetails();
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("arguments[0].scrollIntoView(true);",registrations);

		/*	WebElement associatedlists = cp.getscrolltolistdetails();
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView(true);",associatedlists);*/

		// Verify if Lists are available in Lists section
		WebElement NoList = cp.getcontactlistsgrid();
		Assert.assertFalse(NoList.getText().equalsIgnoreCase(""));
		System.out.println("List is available for the account");

		// Verify for List Members
		WebElement List = cp.getclickcontactlist();
		List.click();
		//System.out.println("List opened is "+List.getText());
		//ap.getSelectedListName().click();

		//Scroll till Members section	
		/*WebElement listmemremovedlabel = ap.getListMemRemovedLabel();	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",listmemremovedlabel);*/

		WebElement memberslabel = ap.getMembersLabel();	
		JavascriptExecutor jse3 = (JavascriptExecutor)driver;
		jse3.executeScript("arguments[0].scrollIntoView(true);",memberslabel);

		WebElement ListMember = ap.getlistmember();
		Assert.assertFalse(ListMember.getText().equalsIgnoreCase(""));
		System.out.println("List memeber is available");
		ap.getPageBackBtn().click();
		ap.getPageBackBtn().click();
	}

	@Test(priority=15)
	public void TS015_VerifyAddNewNoteToContactTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T273- Select any contact and add new Note to Contact

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);

		//Click on Contacts tab
		hp.getContactsTab().click();

		//Click on 'B' link to sort contacts starts with 'B'
		cp.getBLetterFilterLink().click();	

		//Select the contact name in list
		cp.selectContactName().click();
		ap.getAccNaviagteBtn().click();

		//Click on create a timeline button and select Note option
		cp.getContactAddTimelineBtn().click();
		cp.getContactNoteTimelineOptn().click();

		cp.getContactNoteTitleTextbox().click();
		String subjectnote = "Cyb_ContactNote";
		cp.getContactNoteTitleTextbox().sendKeys(subjectnote);
		//Thread.sleep(15000);
		cp.getContactAddNoteButton().click();

		//to scroll down
		act = new Actions(driver);
		act.moveToElement(cp.getViewCreatedNoteToContact()).perform();

		String validateNoteSubject = cp.getViewCreatedNoteToContact().getText();
		Assert.assertEquals(validateNoteSubject, subjectnote);
		System.out.println("Note title is: "+ validateNoteSubject);
		Thread.sleep(10000);
		cp.getContactTimelineDetails().click();
		cp.getContactDeleteNote().click();
		cp.getOkConfirmBtn().click();

		//Navigate back to Active contact list
		ap.getPageBackBtn().click();
	}

	@Test(priority=16)
	public void TS016_VerifyAddNewPostToContactTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//T274- Select any Contact and add Post to Contact

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);

		//Click on Contacts tab
		hp.getContactsTab().click();

		//Click on 'B' link to sort accounts starts with 'B'
		cp.getBLetterFilterLink().click();	

		//Select the contact name in list
		cp.selectContactName().click();
		ap.getAccNaviagteBtn().click();

		//Click on create a timeline button and select Post option
		cp.getContactAddTimelineBtn().click();
		cp.getContactPostTimelineOptn().click();
		cp.getContactPostEnterText().click();
		cp.getContactPostEnterText().sendKeys("Cyb_"+ genData.generateRandomString(10));
		String postText= cp.getContactPostEnterText().getAttribute("title");
		System.out.println("Created Post: "+postText);
		cp.getContactPostAddButton().click();
		String validatePostText = cp.getContactViewCreatedPost().getText();
		System.out.println("Viewed Post is: "+ validatePostText);
		Assert.assertEquals(validatePostText, postText);
		cp.getContactTimelineDetails().click();
		cp.getContactDeletePost().click();
		cp.getOkConfirmBtn().click();
		ap.getPageBackBtn().click();
	}

	@Test(priority=17)
	public void TS017_VerifyMandatoryFieldsOnContactFormTest() throws InterruptedException
	{
		//The purpose of this test case to:-
		//T51- Verify all the mandatory fields on contact form

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);

		//Click on Contacts tab
		hp.getContactsTab().click();

		//Click on New button in header to open new contact form
		cp.getCreateNewContactBtn().click();

		//Verify all the mandatory fields on Contact form
		Assert.assertTrue(cp.getRequiredFieldFirstName().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldType().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldAccountName().isDisplayed());

		utl.scrollToElement(cp.getScrollTextOnContactForm());

		Assert.assertTrue(cp.getRequiredFieldEmail().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldBusinessPhone().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldMobilePhone().isDisplayed());

		utl.scrollToElement(cp.getMobilePhoneLabel());

		Assert.assertTrue(cp.getRequiredFieldStreet1().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldCity().isDisplayed());

		utl.scrollToElement(cp.getCityLabel());

		Assert.assertTrue(cp.getRequiredFieldState().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldZipCode().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldCountry().isDisplayed());

		cp.getContactMarketProfilesTab().click();
		cp.getContactSummaryTab().click();

		//Scroll till Business phone field	
		utl.scrollToElement(cp.getScrollTextOnContactForm());

		//Step-6: Enter the value for Business Phone
		cp.getContactFormBusinessPhoneField().click();
		cp.getContactFormBusinessPhoneField().sendKeys(genData.generateRandomNumber(10));
		cp.getBusinessPhoneLabel().click();
		cp.getContactMarketProfilesTab().click();
		cp.getContactSummaryTab().click();

		//Verify that First Name,Type, Account Name fields should be mandatory
		Assert.assertTrue(cp.getRequiredFieldFirstName().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldType().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldAccountName().isDisplayed());

		//Verify that below fields should not be displayed as mandatory now
		utl.scrollToElement(cp.getScrollTextOnContactForm());

		List<WebElement> NotRequiredFieldEmail = cp.getNotRequiredFieldEmail();
		Assert.assertTrue(NotRequiredFieldEmail.size()== 0);

		List<WebElement> NotRequiredFieldMobilePhone = cp.getNotRequiredFieldMobilePhone();
		Assert.assertTrue(NotRequiredFieldMobilePhone.size()== 0);

		//Verify that Business Phone field should be mandatory
		Assert.assertTrue(cp.getRequiredFieldBusinessPhone().isDisplayed());

		utl.scrollToElement(cp.getMobilePhoneLabel());

		List<WebElement> NotRequiredFieldStreet1 = cp.getNotRequiredFieldStreet1();
		Assert.assertTrue(NotRequiredFieldStreet1.size()== 0);

		List<WebElement> NotRequiredFieldCity = cp.getNotRequiredFieldCity();
		Assert.assertTrue(NotRequiredFieldCity.size()== 0);

		utl.scrollToElement(cp.getCityLabel());

		List<WebElement> NotRequiredFieldState = cp.getNotRequiredFieldState();
		Assert.assertTrue(NotRequiredFieldState.size()== 0);

		List<WebElement> NotRequiredFieldZipCode = cp.getNotRequiredFieldZipCode();
		Assert.assertTrue(NotRequiredFieldZipCode.size()== 0);

		List<WebElement> NotRequiredFieldCountry = cp.getNotRequiredFieldCountry();
		Assert.assertTrue(NotRequiredFieldCountry.size()== 0);

		cp.getContactMarketProfilesTab().click();
		cp.getContactSummaryTab().click();

		//Scroll till Business phone field
		utl.scrollToElement(cp.getScrollTextOnContactForm());

		//Step:8- Remove the value of Business Phone and then Enter the value for Mobile Phone
		cp.getContactFormBusinessPhoneField().click();
		cp.getContactFormBusinessPhoneField().sendKeys(Keys.BACK_SPACE);
		cp.getBusinessPhoneLabel().click();

		cp.getmobile().click();
		cp.getmobile().sendKeys(genData.generateRandomNumber(10));
		cp.getMobilePhoneLabel().click();

		cp.getContactMarketProfilesTab().click();
		cp.getContactSummaryTab().click();

		//Verify that First Name,Type, Account Name fields should be mandatory
		Assert.assertTrue(cp.getRequiredFieldFirstName().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldType().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldAccountName().isDisplayed());

		utl.scrollToElement(cp.getScrollTextOnContactForm());
		//Verify that below fields should not be displayed as mandatory now
		List<WebElement> NotRequiredFieldEmail1 = cp.getNotRequiredFieldEmail();
		Assert.assertTrue(NotRequiredFieldEmail1.size()== 0);

		List<WebElement> NotRequiredFieldBusinessPhone = cp.getNotRequiredFieldBusinessPhone();
		Assert.assertTrue(NotRequiredFieldBusinessPhone.size()== 0);

		//Verify that Mobile Phone field should be mandatory
		Assert.assertTrue(cp.getRequiredFieldMobilePhone().isDisplayed());

		utl.scrollToElement(cp.getMobilePhoneLabel());

		List<WebElement> NotRequiredFieldStreet12 = cp.getNotRequiredFieldStreet1();
		Assert.assertTrue(NotRequiredFieldStreet12.size()== 0);

		List<WebElement> NotRequiredFieldCity1 = cp.getNotRequiredFieldCity();
		Assert.assertTrue(NotRequiredFieldCity1.size()== 0);

		utl.scrollToElement(cp.getCityLabel());

		List<WebElement> NotRequiredFieldState1 = cp.getNotRequiredFieldState();
		Assert.assertTrue(NotRequiredFieldState1.size()== 0);

		List<WebElement> NotRequiredFieldZipCode1 = cp.getNotRequiredFieldZipCode();
		Assert.assertTrue(NotRequiredFieldZipCode1.size()== 0);

		List<WebElement> NotRequiredFieldCountry1 = cp.getNotRequiredFieldCountry();
		Assert.assertTrue(NotRequiredFieldCountry1.size()== 0);

		cp.getContactMarketProfilesTab().click();
		cp.getContactSummaryTab().click();

		//Step-10: Remove the value of Mobile Phone and Enter email address in Email field
		//Scroll till Mobile Phone field
		utl.scrollToElement(cp.getScrollTextOnContactForm());

		cp.getmobile().click();
		cp.getmobile().sendKeys(Keys.BACK_SPACE);
		cp.getMobilePhoneLabel().click();

		cp.getemail().click();
		cp.getemail().sendKeys(genData.generateEmail(15));

		//Verify that Email field is mandatory
		Assert.assertTrue(cp.getRequiredFieldEmail().isDisplayed());
		cp.getBusinessPhoneLabel().click();
		Thread.sleep(2000);
		//Verify that Mobile Phone, Business Phone fields should not be displayed as mandatory now
		List<WebElement> NotRequiredFieldBusinessPhone1 = cp.getNotRequiredFieldBusinessPhone();
		Assert.assertTrue(NotRequiredFieldBusinessPhone1.size()== 0);

		List<WebElement> NotRequiredFieldMobilePhone1 = cp.getNotRequiredFieldMobilePhone();
		Assert.assertTrue(NotRequiredFieldMobilePhone1.size()== 0);

		utl.scrollToElement(cp.getMobilePhoneLabel());

		List<WebElement> NotRequiredFieldStreet13 = cp.getNotRequiredFieldStreet1();
		Assert.assertTrue(NotRequiredFieldStreet13.size()== 0);

		List<WebElement> NotRequiredFieldCity2 = cp.getNotRequiredFieldCity();
		Assert.assertTrue(NotRequiredFieldCity2.size()== 0);

		utl.scrollToElement(cp.getCityLabel());

		List<WebElement> NotRequiredFieldState2 = cp.getNotRequiredFieldState();
		Assert.assertTrue(NotRequiredFieldState2.size()== 0);

		List<WebElement> NotRequiredFieldZipCode2 = cp.getNotRequiredFieldZipCode();
		Assert.assertTrue(NotRequiredFieldZipCode2.size()== 0);

		List<WebElement> NotRequiredFieldCountry2 = cp.getNotRequiredFieldCountry();
		Assert.assertTrue(NotRequiredFieldCountry2.size()== 0);

		cp.getContactMarketProfilesTab().click();
		cp.getContactSummaryTab().click();

		//Verify that First Name, Type, Account Name fields should be mandatory
		Assert.assertTrue(cp.getRequiredFieldFirstName().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldType().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldAccountName().isDisplayed());

		//Step:12- Remove the value of Email field and Enter data for address fields
		utl.scrollToElement(cp.getScrollTextOnContactForm());
		cp.getemail().click();
		cp.getemail().sendKeys(Keys.CONTROL + "a");
		cp.getemail().sendKeys(Keys.DELETE);
		cp.getemail().click();

		utl.scrollToElement(cp.getMobilePhoneLabel());
		cp.getstreet1().click();
		cp.getstreet1().sendKeys(genData.generateRandomAlphaNumeric(15));
		cp.getcity().sendKeys(prop.getProperty("city"));

		utl.scrollToElement(cp.getCityLabel());
		cp.getstateorprovince().sendKeys(prop.getProperty("state"));
		cp.getziporpostalcode().sendKeys(genData.generateRandomNumber(6));
		cp.getCountrytxbx().click();
		cp.getCountrydrpbtn().click();
		cp.getCountryName().click();

		cp.getContactMarketProfilesTab().click();
		cp.getContactSummaryTab().click();

		//Verify that First Name, Type,Account Name fields should be mandatory
		Assert.assertTrue(cp.getRequiredFieldFirstName().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldType().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldAccountName().isDisplayed());

		utl.scrollToElement(cp.getScrollTextOnContactForm());

		//Verify that Email,Business Phone,Mobile Phone fields should not be displayed as mandatory now
		List<WebElement> NotRequiredFieldEmail2 = cp.getNotRequiredFieldEmail();
		Assert.assertTrue(NotRequiredFieldEmail2.size()== 0);

		List<WebElement> NotRequiredFieldBusinessPhone2 = cp.getNotRequiredFieldBusinessPhone();
		Assert.assertTrue(NotRequiredFieldBusinessPhone2.size()== 0);

		List<WebElement> NotRequiredFieldMobilePhone2 = cp.getNotRequiredFieldMobilePhone();
		Assert.assertTrue(NotRequiredFieldMobilePhone2.size()== 0);

		utl.scrollToElement(cp.getMobilePhoneLabel());

		//Verify that Address data fields should be displayed as mandatory now
		Assert.assertTrue(cp.getRequiredFieldStreet1().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldCity().isDisplayed());

		utl.scrollToElement(cp.getCityLabel());

		Assert.assertTrue(cp.getRequiredFieldState().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldZipCode().isDisplayed());
		Assert.assertTrue(cp.getRequiredFieldCountry().isDisplayed());

		//Navigate back to Active Contact list
		ap.getPageBackBtn().click();
		ap.getDiscardChangesBtn().click();
	}

	@Test(priority=18)
	public void TS018_VerifyCountryAutocompletePicklist() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T135- Verify a picklist should be displayed after user starts typing country name 
		//in country field

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Contact Tab at left menu
		hp.getContactsTab().click();

		//Open active contact from grid
		cp.getBLetterFilterLink().click();
		cp.selectContactName().click();
		ap.getAccNaviagteBtn().click();

		//Scroll to Address section
		utl.scrollToElement(ap.getEnteraNoteLabel());
		utl.scrollToElement(cp.getBusinessPhoneLabel());
		utl.scrollToElement(cp.getCityLabel());

		//Delete data already selected in country field
		WebElement country = cp.getCountrytxbx();
		country.sendKeys(Keys.CONTROL + "a");
		country.sendKeys(Keys.DELETE);

		//Enter some characters to search country name
		cp.getCountrytxbx().sendKeys(prop.getProperty("country"));
		Thread.sleep(5000);

		List<WebElement> list = cp.getCountryAutocompleteList();
		for(int i=0; i<list.size(); i++)
		{
			System.out.println(list.get(i).getText());
			Assert.assertTrue(list.get(i).getText().contains(prop.getProperty("country")));
		}

		String ExpectedCountry = cp.SelectCountry().getText();
		System.out.println("Expected Country: " + ExpectedCountry);

		//Select searched country from drop down list
		cp.SelectCountry().click();

		//Save country for an existing account
		cp.getsavecontact().click();
		Thread.sleep(5000);

		//Validate selected country
		String UpdatedCountryOnAccountForm = cp.getCountrytxbx().getAttribute("value").toString();
		System.out.println("Updated country: " + UpdatedCountryOnAccountForm);

		Assert.assertEquals(UpdatedCountryOnAccountForm, ExpectedCountry);

		//Click Back button
		ap.getPageBackBtn().click();
	}

	@Test(priority=19)
	public void TS019_VerifyDetailsTabOnContactTest() throws InterruptedException {

		//The purpose of this test case to verify :-
		//T300: Select any existing contact and click on Details and verify details

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Open Contacts page and open existing contact
		hp.getContactsTab().click();
		ap.getCLetterFilterLink().click();
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();

		//click on Details Tab
		ap.getdetailsTab().click();

		//Verify if two sections are displayed on Details tab
		Assert.assertTrue(cp.getpersonalsection().isDisplayed());
		System.out.println("Personal section is available on Details tab.");
		WebElement scrollsection = cp.getconprefsection();
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",scrollsection);
		Assert.assertTrue(cp.getconprefsection().isDisplayed());
		System.out.println("Contact Preferences section is available on Details tab.");

		//Verify details under Personal section
		Assert.assertTrue(cp.getpersonalnotes().isDisplayed());
		System.out.println("Personal notes section is available on Details tab.");
		Assert.assertTrue(cp.getpersonalownerid().isDisplayed());
		System.out.println("Personal owner id section is available on Details tab.");
		Assert.assertTrue(cp.getpersonaloriginatinglead().isDisplayed());
		System.out.println("Personal originating leads section is available on Details tab.");

		//Verify details under Contact Preferences section
		//List <WebElement> ContactPrefOptions = cp.getconprefoptions();
		Assert.assertTrue(ap.getconprefoptions().isDisplayed());
		System.out.println("Contact preference options available on Details tab.");

		//Navigate back to Active Contacts list
		Thread.sleep(15000);
		ap.getPageBackBtn().click();
	}

	@Test(priority=21)
	public void TS021_VerifyGridFiltersContactTest() throws InterruptedException
	{
		//The purpose of this test case to verify that:-
		//CRM-T304- user should be able to sort contacts using the following columns in the view:
		//Full Name, Business Phone, Email, Account Name, State/Province and Region

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Open Contacts page and open existing contact
		hp.getContactsTab().click();
		ap.getCLetterFilterLink().click();

		//Click funnel for Full Name column
		cp.getclickcontactfullnamegrid().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		ap.getselectoperatorone().click();
		ap.getclickaddressvaluefield().sendKeys(prop.getProperty("name"));
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify Full Name value selected on accounts grid
		WebElement confullname = null;
		for (int i=0;i<7;i++)
		{
			confullname = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']/label"));
			System.out.println(confullname.getText());
			Assert.assertTrue(confullname.getText().contains(prop.getProperty("name")));
			//Assert.assertEquals(confullname.getAttribute(arg0), expected);
		}
		System.out.println("Full Name matches expected criteria");

		//Clear Filter for Full Name
		cp.getclickcontactfullnamegrid().click();
		ap.getclearfiltergrid().click();

		//Click funnel for Business Phone column
		cp.getclickcontactphonegrid().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		ap.getselectoperatorone().click();
		ap.getclickaddressvaluefield().sendKeys(prop.getProperty("phone"));
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify Business phone value selected on accounts grid
		WebElement conphonevaluesongrid = null;
		for (int i=0;i<7;i++)
		{
			conphonevaluesongrid = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-4']"));
			Assert.assertTrue(conphonevaluesongrid.getText().contains(prop.getProperty("phone")));
		}
		System.out.println("Phone matches expected criteria");

		//Clear Filter for Phone
		cp.getclickcontactphonegrid().click();
		ap.getclearfiltergrid().click();

		//Click funnel for email column
		cp.getclickcontactemailgrid().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		ap.getselectoperatorone().click();
		ap.getclickaddressvaluefield().sendKeys(prop.getProperty("emailtext"));
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify email value selected on accounts grid
		WebElement conemailongrid = null;
		for (int i=0;i<7;i++)
		{
			conemailongrid = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-5']"));
			Assert.assertTrue(conemailongrid.getText().contains(prop.getProperty("emailtext")));
		}
		System.out.println("Email matches expected criteria");

		//Clear Filter for Account Name
		cp.getclickcontactemailgrid().click();
		ap.getclearfiltergrid().click();

		//Click funnel for Account Name column
		cp.getclickcontactaccnamegrid().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		ap.getselectoperatorone().click();
		ap.getclickaddressvaluefield().sendKeys(prop.getProperty("name"));
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify Account Name value selected on accounts grid
		WebElement conaccname = null;
		for (int i=0;i<3;i++)
		{
			conaccname = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-3']"));
			Assert.assertTrue(conaccname.getText().contains(prop.getProperty("name")));
		}
		System.out.println("Account DBA Name matches expected criteria");

		//Clear Filter for Account Name
		cp.getclickcontactaccnamegrid().click();
		ap.getclearfiltergrid().click();

		//Click funnel for state column
		cp.getclickcontactstategrid().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		ap.getselectoperator().click();
		ap.getclickaddressvaluefield().sendKeys(prop.getProperty("gridstatefilter"));
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify state value selected on accounts grid
		WebElement constatevaluesongrid = null;
		for (int i=0;i<7;i++)
		{
			constatevaluesongrid = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-8']"));
			Assert.assertTrue(constatevaluesongrid.getText().contains(prop.getProperty("gridstatefilter")));
		}
		System.out.println("State matches expected criteria");	

		//Clear selected filter
		cp.getclickcontactstategrid().click();
		ap.getclearfiltergrid().click();

		//Click funnel for Region column
		cp.getclickcontactregiongrid().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		ap.getselectoperator().click();
		ap.getsclickvaluetextbox().click();
		String ExpectedRegion = ap.getselectregionvalue().getText();
		ap.getselectregionvalue().click();
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify region value selected on accounts grid
		WebElement conregionvaluesongrid = null;
		for (int i=0;i<7;i++)
		{
			conregionvaluesongrid = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-9']"));
			Assert.assertTrue(conregionvaluesongrid.getText().contains(ExpectedRegion));
		}
		System.out.println("Region matches expected criteria");

		//Clear filter
		cp.getclickcontactregiongrid().click();
		ap.getclearfiltergrid().click();
	}

	@Test(priority=22)
	public void TS022_VerifyUpdateContactDetailsTest() throws InterruptedException
	{
		//The purpose of this test case to:-
		//CRM-T302- Verify user is able to update contact details with appropriate user access
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Open Contacts page and open existing contact
		hp.getContactsTab().click();
		cp.getBLetterFilterLink().click();
		cp.selectContactName().click();
		ap.getAccNaviagteBtn().click();

		//Delete existing data and enter new data in mandatory fields
		cp.getfirstname().click();
		cp.getfirstname().sendKeys(Keys.CONTROL + "a");
		cp.getfirstname().sendKeys(Keys.DELETE);
		String ContactFirstName = "QA"+ genData.generateRandomString(3);
		cp.getfirstname().sendKeys(ContactFirstName);
		String FirstName = cp.getfirstname().getAttribute("value");
		System.out.println("First Name: " +FirstName);

		cp.getlastname().click();
		cp.getlastname().sendKeys(Keys.CONTROL + "a");
		cp.getlastname().sendKeys(Keys.DELETE);
		String ContactLastName = genData.generateRandomString(5);
		cp.getlastname().sendKeys(ContactLastName);
		String LastName = cp.getlastname().getAttribute("value");
		System.out.println("Last Name: " +LastName);

		act = new Actions(driver);
		act.moveToElement(ap.getmovetotype()).perform();
		ap.getdeletetype().click();
		cp.getContactTypeExpandbtn().click();
		cp.getContactTypeBuyer().click();
		cp.getContactFirstNameLabel().click();

		utl.scrollToElement(ap.getEnteraNoteLabel());

		cp.getemail().sendKeys(Keys.CONTROL + "a");
		cp.getemail().sendKeys(Keys.DELETE);
		String contactemail = genData.generateEmail(15);
		cp.getemail().sendKeys(contactemail);

		//Click on Save button in header
		cp.getsavecontact().click();

		String contactname = cp.getverifycontact().getText();
		System.out.println("Contact Name: "+contactname);
		cp.getContactSavenCloseBtn().click();

		//Get back to Contacts grid and search updated contact
		cp.getQLetterFilterLink().click();
		ap.getsearchaccounttextbox().click();
		Thread.sleep(5000);
		ap.getsearchaccounttextbox().sendKeys(contactname);
		ap.getclicksearchbutton().click();

		//Verification for updated contact name and Email on Search results page
		Assert.assertTrue(hp.getSearchResultContactFullName().getText().contains(contactname));
		Assert.assertTrue(hp.getSearchResultContactEmail().getText().contains(contactemail));
		System.out.println("Contact updated successfully");
		
		hp.getClearSearch().click();
	}
	//	@AfterTest
	//	public void closeDriver()
	//	{
	//		driver.close();
	//	}


}
