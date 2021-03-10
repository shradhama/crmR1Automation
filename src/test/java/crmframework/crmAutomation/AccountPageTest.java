package crmframework.crmAutomation;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
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
public class AccountPageTest extends base {

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

	@Test(priority=2)
	public void TS002_VerifyCreateNewAccountTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS343- Create New Account

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
		//Select Accounts menu from left navigation bar
		hp.getAccountTab().click();

		//Click on 'New' button
		ap.getAccountNewbtn().click();

		//Fill all the mandatory fields to create new account
		//Enter Account Name
		ap.getAccDBANametxbox().click();
		//to create random generated account name
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

		//Scroll down on the page
		act.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).perform();
		act.keyDown(Keys.CONTROL).sendKeys(Keys.DOWN).release().perform();

		//Enter Street1 address
		ap.getStreet1().sendKeys(prop.getProperty("street1"));

		//Enter City
		ap.getCity().click();
		ap.getCity().sendKeys(prop.getProperty("city"));

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

		//Click on Save and Close button
		ap.getAccSaveCloseBtn().click();

		//Verify the newly created account
		hp.getSearchAccountField().click();
		hp.getSearchAccountField().sendKeys(accnameText);
		hp.getstartsearch().click();

		String validateAccName = ap.getAccountNameSearchTable().getText();
		Assert.assertEquals(validateAccName, accnameText);
		System.out.println("Searched Account:"+ validateAccName);

		phoneno = ap.getPhoneinSearchTable().getText();
		System.out.println("New account's Phone: "+phoneno);
		System.out.println("New Account is created successfully");

		//Clear the search term to navigate to active accounts page
		hp.getClearSearch().click();
	}

	@Test(priority=3)
	public void TS003_VerifyAddTimelineToAccountTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS295- Select any account and add Timeline

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
		ap.getApptmntActivityOptn().click();

		ap.getTimelineSujecttxbx().click();
		String subtext = "Cyb_ApptJan";
		ap.getTimelineSujecttxbx().sendKeys(subtext);

		ap.getTimelineSavenClosebtn().click();

		//Verify that added Timeline is reflected correctly
		WebElement timeline = driver.findElement(By.xpath("//*[text()='"+subtext+"']"));
		Assert.assertEquals(timeline.getText(), subtext);

		//Verify that expected Success message displayed
		Assert.assertEquals("Your changes were saved.", ap.getSuccessMsg().getText());

		//Navigate back to Active accounts lis
		ap.getPageBackBtn().click();
	}



	@Test(priority=4)
	public void TS004_VerifyAddMarketingRelationshipOwnerToAccountTest() throws InterruptedException {

		//The purpose of this test case to verify:-
		//TS75- Add relationship manager to account

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);

		//Navigate to Accounts under Demand Driver in left menu
		hp.getAccountTab().click();

		//Select and open an active account on the Accounts grid view
		ap.getCLetterFilterLink().click();
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();

		amro = new CRMAddMarketingRelationshipOwner(driver);
		// Click arrow to open marketing relationship window
		amro.gethdbtn().click();

		//Click on Marketing Relationship Owner field search icon  to select a user from lookup
		amro.getmarlookupsearch().click();

		//Select a user entity from the Marketing Relationship Owner lookup
		WebElement marowner = amro.getOwner();
		String ownertxt =marowner.getText();
		System.out.println(ownertxt);
		marowner.click();

		// Save selected marketing relationship owner
		amro.getmarownersave().click();	

		//Scroll up the page till Address field
		act = new Actions(driver);
		act.moveToElement(ap.getAddress()).perform();

		//Verify Marketing Relationship Owner lookup value in Account Information section in the Summary tab
		WebElement verifyOwner = amro.getmarownerverify();
		Assert.assertTrue(verifyOwner.getText().contains(ownertxt));
		System.out.println("Marketing Relationship Owner get added successfully");
		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();
	}

	@Test(priority=5)
	public void TS005_VerifySearchAccountTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS46- Search any existing Account by Account DBA Name

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);

		hp.getAccountTab().click();	
		hp.getSearchAccountField().click();
		hp.getSearchAccountField().sendKeys(accnameText);
		hp.getstartsearch().click();
		//Thread.sleep(10000);
		WebElement validateAccName = driver.findElement(By.xpath("//label[contains(text(),'"+accnameText+"')]"));
		Boolean checkvalidateAccName = validateAccName.isDisplayed();

		Assert.assertTrue(checkvalidateAccName);
		System.out.println("New Account searched");
		//Clear the search term to navigate to active accounts page
		hp.getClearSearch().click();
	}

	@Test(priority=6)
	public void TS006_VerifyAuditHistoryTabOnAccountTest() throws InterruptedException {

		//The purpose of this test case to verify :-
		//T300: Select any existing account and click on Audit History Tab Functionality 

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
		ap.getAuditHistoryRelatedTab().click();
		//Thread.sleep(5000);
		Boolean displayAuditHistoryTab = ap.getAuditHistoryTab().isDisplayed();
		System.out.println("Activities Tab Opened successfully:"+displayAuditHistoryTab);

		String validateAuditHistoryTab = ap.getAuditHistoryTab().getText();
		Assert.assertEquals(validateAuditHistoryTab, "Audit History");

		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();

	}
	@Test(priority=7)
	public void TS007_VerifyParentAccountTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T43- A new field 'Parent Account ' is available on the Account Form under 
		//ACCOUNT INFORMATION section and data values available in it.

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Accounts Tab at left menu.
		hp.getAccountTab().click();

		//Select and open an active account on the Accounts grid view
		ap.getCLetterFilterLink().click();
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();

		//Verify new field 'Parent Account ' is available on the account form
		Assert.assertTrue(ap.getParentAccLabel().isDisplayed());

		//Click on 'Search' button
		ap.getParentAccSearchBtn().click();

		//Click on 'Recent Records' link
		//ap.getRecentRecordsLink().click();

		boolean staleElement = true;
		try {
			while(staleElement){
				//Select a parent account from lookup
				WebElement Parentaccfrmlist = ap.selectParentAccName();
				String selectedAccName = Parentaccfrmlist.getText();
				System.out.println("Expected Parent account name: " +selectedAccName);
				Parentaccfrmlist.click();

				//Verify that selected account is displayed as Parent Account value on account form
				WebElement Parentaccinform = ap.getParentAcctxbx();
				System.out.println("Actual Parent account name: " + Parentaccinform.getText());
				Assert.assertTrue(Parentaccinform.getText().contains(selectedAccName));

				//Click on Save & Close button
				ap.getAccSaveCloseBtn().click();
				staleElement = false;
			}
		}
		catch (StaleElementReferenceException exe) {
			staleElement = false;
			System.out.println(exe.getMessage());
		}
	}

	@Test(priority=8)
	public void TS008_VerifyAccountStatusToActivateAccountTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T39- Account Status and Account Status Reason functionality for account activation

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Accounts Tab at left menu.
		hp.getAccountTab().click();

		//Click on the select a view drop-down available below header
		ap.getActiveAccDropDownBtn().click();

		//Select 'Inactive Accounts' option
		ap.getInactiveAccOptn().click();

		boolean staleElement = true;
		try {
			while(staleElement){
				//Open any Inactive account from list
				ap.getCLetterFilterLink().click();
				ap.getAccountName().click();
				ap.getAccNaviagteBtn().click();

				//Click 'Activate' button available in the top panel
				ap.getActivateBtn().click();

				//Select 'Account Status: Buys at Corporate Level' in the confirm Account Activation pop-up
				ap.getActivatePopupStatusField().click();
				WebElement buysatcorplevelstatus = ap.getAccStatusBuysatCorpLevel();
				buysatCorplvl = ap.getAccStatusBuysatCorpLevel().getText();
				System.out.println("Account Status: " + buysatCorplvl);
				buysatcorplevelstatus.click();

				//Click on 'Activate' button
				ap.getActivatePopupActivatebtn();
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

		//Verify that Account is activated and selected account Status Reason is displayed at the right side of the header.
		WebElement accstatusreasoninheader = ap.getAccStatusReson();
		System.out.println("Account Status Reason: " + (accstatusreasoninheader.getText()));
		Assert.assertTrue(accstatusreasoninheader.getText().contains(buysatCorplvl));

		//Verify that Top ribbon 'Activate' option changes to 'Deactivate'
		Assert.assertTrue(ap.getDeactivateBtn().isDisplayed());

		//Click on Save & Close button
		ap.getAccSaveCloseBtn().click();
	}

	@Test(priority=9)
	public void TS009_VerifyAccountStatusToDeactivateAccountTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T40- Account Status and Account Status Reason functionality for account deactivation

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Accounts Tab at left menu.
		hp.getAccountTab().click();

		boolean staleElement = true;
		try {
			while(staleElement){
				//Open any Active account from list
				ap.getCLetterFilterLink().click();
				ap.getAccountName().click();
				ap.getAccNaviagteBtn().click();

				//Click 'Deactivate' button available in the top panel
				ap.getDeactivateBtn().click();

				//Select 'Account Status: Out of Business' in the confirm Account Deactivation pop-up
				ap.getActivatePopupStatusField().click();
				WebElement outofbusinessstatus = ap.getAccStatusOutofBusiness();
				outofbusiness = ap.getAccStatusOutofBusiness().getText();
				System.out.println("Account Status: " + outofbusiness);
				outofbusinessstatus.click();

				//Click on 'Deactivate' button
				ap.getDeactivatePopupDeactivatebtn();
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

		//Verify that Account is deactivated and selected account status reason is displayed at the right side of the header.
		WebElement statusreasonforinactiveaccinheader = ap.getAccStatusResonForInactiveAcc();
		System.out.println("Account Status Reason: " + (statusreasonforinactiveaccinheader.getText()));
		Assert.assertTrue(statusreasonforinactiveaccinheader.getText().contains(outofbusiness));

		//Verify that Top ribbon 'Deactivate' option changes to 'Activate'
		Assert.assertTrue(ap.getActivateBtn().isDisplayed());

		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();
	}

	@Test(priority=10)
	public void TS010_VerifyBusinessRuleForPhoneNumberTest() throws InterruptedException {

		//The purpose of this test case to verify :-
		//T307: Select any existing account and click on Details Tab Functionality 

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
		Thread.sleep(10000);

		ap.getPhone().click();
		ap.getPhone().sendKeys(genData.generateRandomNumber(10));
		ap.getPhone().sendKeys(Keys.TAB);
		ap.getAccSaveBtn().click();
		String typewarningmessage=ap.getTypeNotificationWrapperMsg().getText();
		Assert.assertEquals(typewarningmessage, "Type : Required fields must be filled in.");
		System.out.println("Displayed only Type warning message displayed.");
		ap.getPageBackBtn().click();
		Thread.sleep(5000);
		ap.getDiscardChangesBtn().click();
	}

	@Test(priority=11)
	public void TS011_VerifyAddNoteToAccountTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//T98- Select any account and add Note to account

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		hp.getAccountTab().click();

		ap = new CRMAccountsPage(driver);
		//Click on 'A' link to sort accounts starts with 'A'
		ap.getCLetterFilterLink().click();	

		//Select the account name in list
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();

		//Click on create a timeline button and select Note option
		ap.getAddTimelineBtn().click();
		ap.getNoteTimelineOptn().click();

		ap.getNoteTitleTextbox().click();
		String subjectnote = "Cyb_Note";
		ap.getNoteTitleTextbox().sendKeys(subjectnote);
		Thread.sleep(15000);
		/*ap.getNoteiframe().click();
		ap.getNoteiframe().sendKeys(genData.generateRandomString(25));
		driver.switchTo().frame(ap.getNoteiframe());
		ap.getNoteTextEnter().click();
		ap.getNoteTextEnter().sendKeys(genData.generateRandomString(25));*/
		ap.getAddNoteButton().click();

		//to scroll down
		act = new Actions(driver);
		act.moveToElement(ap.getViewCreatedNote()).perform();

		String validateNoteSubject = ap.getViewCreatedNote().getText();
		Assert.assertEquals(validateNoteSubject, subjectnote);
		System.out.println("Note title is: "+ validateNoteSubject);
		Thread.sleep(10000);
		ap.getTimelineDetails().click();
		ap.getDeleteNote().click();
		ap.getOkConfirmBtn().click();
		System.out.println("Note Deleted");
		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();
	}

	@Test(priority=12)
	public void TS012_VerifyAddNewPostToAccountTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//T299- Select any account and add Post to account

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		hp.getAccountTab().click();

		ap = new CRMAccountsPage(driver);
		//Click on 'A' link to sort accounts starts with 'A'
		ap.getCLetterFilterLink().click();	

		//Select the account name in list
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();

		//Click on create a timeline button and select Note option
		ap.getAddTimelineBtn().click();
		ap.getPostTimelineOptn().click();
		ap.getPostTextEnter().click();
		ap.getPostTextEnter().sendKeys(genData.generateRandomString(25));
		String postText= ap.getPostTextEnter().getAttribute("title");
		System.out.println("Created Post: "+postText);
		ap.getPostAddButton().click();
		String validatePostText = ap.getViewCreatedPost().getText();
		System.out.println("Viewed Post is: "+ validatePostText);
		Assert.assertEquals(validatePostText, postText);
		ap.getTimelineDetails().click();
		ap.getDeletePost().click();
		ap.getOkConfirmBtn().click();
		System.out.println("Post Deleted.");
		ap.getPageBackBtn().click();
	}

	@Test(priority=13)
	public void TS013_VerifyPhoneCallOnAccountTest() throws InterruptedException {

		//The purpose of this test case to verify :-
		//T85: Add Phone Call to an existing Account

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

		//Select Phone Call option under Timeline section
		ap.getAddTimelineBtn().click();
		ap.getphonecalloption().click();

		//Enter Phone Call details
		String phonesubject = "CybSubject";
		ap.getphonecallsubject().click();
		ap.getphonecallsubject().clear();
		ap.getphonecallsubject().sendKeys(phonesubject);
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

	@Test(priority=14)
	public void TS014_VerifyStateAndRegionInGridTest() throws InterruptedException {

		//The purpose of this test case to verify :-
		//T166: Filter State and Region in grid

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		hp.getAccountTab().click();

		ap = new CRMAccountsPage(driver);
		//Click on 'C' link to sort accounts starts with 'C'
		ap.getCLetterFilterLink().click();

		//Click funnel for Region column
		ap.getclickregiongridfunnel().click();
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
		WebElement regionvaluesongrid = null;
		for (int i=0;i<7;i++)
		{
			regionvaluesongrid = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-6']"));
			Assert.assertTrue(regionvaluesongrid.getText().contains(ExpectedRegion));
		}
		System.out.println("Region matches expected criteria");

		//Clear filter
		ap.getclickregiongridfunnel().click();
		ap.getclearfiltergrid().click();

		//Click funnel for state column
		ap.getclickaddressgridfunnel().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		ap.getselectoperator().click();
		ap.getclickaddressvaluefield().sendKeys(prop.getProperty("gridstatefilter"));
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify state value selected on accounts grid
		WebElement statevaluesongrid = null;
		for (int i=0;i<7;i++)
		{
			statevaluesongrid = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-5']"));
			Assert.assertTrue(statevaluesongrid.getText().contains(prop.getProperty("gridstatefilter")));
		}
		System.out.println("State matches expected criteria");	

		//Clear selected filter
		ap.getclickaddressgridfunnel().click();
		ap.getclearfiltergrid().click();

	}

	@Test(priority=15)
	public void TS015_VerifyNamePhoneCityInGridTest() throws InterruptedException {

		//The purpose of this test case to verify :-
		//T289: Filter Account DBA Name, Phone and City in grid

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		hp.getAccountTab().click();

		ap = new CRMAccountsPage(driver);
		//Click on 'C' link to sort accounts starts with 'C'
		ap.getCLetterFilterLink().click();

		//Click funnel for Account DBA Name column
		ap.getclickdbanamegridfunnel().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		ap.getselectoperatorone().click();
		ap.getclickaddressvaluefield().sendKeys(prop.getProperty("name"));
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify Account DBA Name value selected on accounts grid
		WebElement accnamevaluesongrid = null;
		for (int i=0;i<7;i++)
		{
			accnamevaluesongrid = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']"));
			Assert.assertTrue(accnamevaluesongrid.getText().contains(prop.getProperty("name")));
		}
		System.out.println("Account DBA Name matches expected criteria");

		//Clear Filter for Account DBA Name
		ap.getclickdbanamegridfunnel().click();
		ap.getclearfiltergrid().click();

		//Click funnel for Phone column
		ap.getclickdbaphonegridfunnel().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		ap.getselectoperatorone().click();
		ap.getclickaddressvaluefield().sendKeys(prop.getProperty("phone"));
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify phone value selected on accounts grid
		WebElement phonevaluesongrid = null;
		for (int i=0;i<7;i++)
		{
			phonevaluesongrid = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-3']"));
			Assert.assertTrue(phonevaluesongrid.getText().contains(prop.getProperty("phone")));
		}
		System.out.println("Phone matches expected criteria");

		//Clear Filter for Phone
		ap.getclickdbaphonegridfunnel().click();
		ap.getclearfiltergrid().click();

		//Click funnel for City column
		ap.getclickdbacitygridfunnel().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		ap.getselectoperatorone().click();
		ap.getclickaddressvaluefield().sendKeys(prop.getProperty("city"));
		ap.getclickapplybutton().click();
		Thread.sleep(5000);	

		//Verify city value selected on accounts grid
		WebElement cityvaluesongrid = null;
		for (int i=0;i<7;i++)
		{
			cityvaluesongrid = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-4']"));
			Assert.assertTrue(cityvaluesongrid.getText().contains(prop.getProperty("city")));
		}
		System.out.println("City matches expected criteria");

		//Clear Filter for Phone
		ap.getclickdbacitygridfunnel().click();
		ap.getclearfiltergrid().click();
	}

	@Test(priority=16)
	public void TS016_VerifySearchusingAccountNameandPhoneTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T46- CRM User is having ability to search Account entity using account name and phone

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Accounts Tab at left menu.
		hp.getAccountTab().click();

		//Click on 'Search' view and enter any account name
		String searchaccname = prop.getProperty("searchacc");
		hp.getSearchAccountField().click();
		hp.getSearchAccountField().sendKeys(searchaccname);
		hp.getstartsearch().click();
		Thread.sleep(5000);

		//Verify that all accounts that have a Account Legal Name  'K & D Fashions LLC' get appeared in the Search results page
		WebElement accinsearchresults = null;
		for (int i=0;i<1;i++)
		{
			accinsearchresults = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']"));
			Assert.assertTrue(accinsearchresults.getText().contains(searchaccname));
		}
		//Clear the search term to navigate to active accounts page
		hp.getClearSearch().click();

		//Click on 'Search' view and enter any search text
		String searchtext = prop.getProperty("searchterm");
		hp.getSearchAccountField().click();
		hp.getSearchAccountField().sendKeys(searchtext);
		hp.getstartsearch().click();
		Thread.sleep(5000);

		//Verify that all accounts that have a Account DBA Name 'Fashions' get appeared in the Search results page.
		WebElement searchresultacc = null;
		for (int j=0;j<8;j++)
		{
			searchresultacc = driver.findElement(By.xpath("//div[@data-id='cell-"+j+"-2']"));
			Assert.assertTrue(searchresultacc.getText().contains(searchtext));
		}
		hp.getClearSearch().click();

		//Click on 'Search' view and enter any search text
		String searchPhone = prop.getProperty("searchPhoneNo");
		hp.getSearchAccountField().click();
		hp.getSearchAccountField().sendKeys(searchPhone);
		hp.getstartsearch().click();
		Thread.sleep(5000);

		//Verify that all the account having 98765 in the phone field are displayed
		WebElement searchresultphone = null;
		for (int k=0;k<1;k++)
		{
			searchresultphone = driver.findElement(By.xpath("//div[@data-id='cell-"+k+"-3']"));
			Assert.assertTrue(searchresultphone.getText().contains(searchPhone));
		}
		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();
	}

	@Test(priority=24)
	public void TS017_VerifyDuplicateAccountTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T58- Verify notification for duplicate account creation when same Account DBA Name and Phone
		//are used for creating new Account or updating any other Account

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Accounts Tab at left menu.
		hp.getAccountTab().click();

		//Click on 'New' button
		ap.getAccountNewbtn().click();

		//Enter Account DBA name and Phone no. (From Create account test case)
		ap.getAccDBANametxbox().click();
		ap.getAccDBANametxbox().sendKeys(accnameText);

		ap.getPhone().click();
		ap.getPhone().sendKeys(phoneno);

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

		//Verify that 'Duplicate records found' pop-up is displayed
		Assert.assertTrue(ap.getDuplicateRecordsPopupTitle().isDisplayed());

		//Click on 'Cancel' button
		ap.getDuplicateRecordsPopupCancelbtn().click();
		ap.getPageBackBtn().click();

		//Verify that 'Unsaved Changes' pop-up is displayed
		Assert.assertTrue(ap.getUnsavedChangesPopupTitle().isDisplayed());

		//Click on 'Discard Changes' button on pop-up
		ap.getDiscardChangesBtn().click();

		//Verify that user redirects back to Active accounts list without creating new account
		Assert.assertTrue(ap.getActiveAccountsLabel().isDisplayed());

		//Now update any existing account name with Account DBA name and Phone no. (From Create account test case)
		ap.getHLetterFilterLink().click();
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();

		//Enter account Name
		ap.getAccDBANametxbox().click();
		ap.getAccDBANametxbox().sendKeys(Keys.CONTROL + "a");
		ap.getAccDBANametxbox().sendKeys(Keys.DELETE);
		ap.getAccDBANametxbox().sendKeys(accnameText);

		ap.getPhone().click();
		ap.getPhone().sendKeys(Keys.CONTROL + "a");
		ap.getPhone().sendKeys(Keys.DELETE);
		ap.getPhoneTxtbxLabel().click();
		ap.getPhone().click();
		ap.getPhone().sendKeys(phoneno);
		ap.getParentAccLabel().click();

		//Click on Save and Close button
		ap.getAccSaveCloseBtn().click();

		//Verify that 'Duplicate records found' pop-up is displayed
		Assert.assertTrue(ap.getDuplicateRecordsPopupTitle().isDisplayed());

		//Click on 'Cancel' button
		ap.getDuplicateRecordsPopupCancelbtn().click();
		ap.getPageBackBtn().click();
		ap.getDuplicateRecordsPopupCancelbtn().click();
		//Click on 'Discard Changes' button on pop-up
		ap.getDiscardChangesBtn().click();

		//Click on Accounts Tab at left menu.
		hp.getAccountTab().click();

		//Click on 'New' button
		ap.getAccountNewbtn().click();

		//Enter Account DBA name and Phone no. (From Create account test case)
		ap.getAccDBANametxbox().click();
		ap.getAccDBANametxbox().sendKeys(accnameText);

		ap.getPhone().click();
		ap.getPhone().sendKeys(phoneno);

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

		//Click on "Ignore and Save" button on the notification pop-up
		ap.getDuplicateRecordsPopupIgnorenSavebtn().click();

		//Verify that new account is created and displayed under Active accounts list
		hp.getSearchAccountField().click();
		hp.getSearchAccountField().sendKeys(accnameText);
		hp.getstartsearch().click();
		WebElement accnameinsearch = hp.getSearchResultAcc();
		Assert.assertTrue(accnameinsearch.getText().contains(accnameText));

		//Clear the search term to navigate to active accounts page
		hp.getClearSearch().click();
	}

	@Test(priority=25)
	public void TS018_VerifyDeactivateAccountTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS40- Select any existing Account and deactivate it

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);

		hp.getAccountTab().click();
		hp.getSearchAccountField().click();
		hp.getSearchAccountField().sendKeys(accnameText);
		hp.getstartsearch().click();
		//Thread.sleep(10000);

		WebElement validateAccName = driver.findElement(By.xpath("//label[contains(text(),'"+accnameText+"')]"));
		validateAccName.click();
		ap.getAccNaviagteBtn().click();
		//Thread.sleep(10000);
		//Click on Deactivate button
		ap.getDeactivateBtn().click();

		//Click on 'Deactivate button of confirmation pop-up
		ap.getDeactivateOkBtn().click();
		Assert.assertTrue(ap.getActivateBtn().isDisplayed());

		//Navigate back to Active accounts page
		ap.getPageBackBtn().click();

		//Click on 'Active Accounts' drop-down view button
		ap.getActiveAccDropDownBtn().click();

		//Select 'Inactive Accounts' option
		ap.getInactiveAccOptn().click();

		//Click on 'C' link to sort accounts starts with 'C'
		try {
			ap.getCLetterFilterLink().click();

			//Validate deactivated account
			hp.getSearchInactiveAccountField().click();
			hp.getSearchInactiveAccountField().sendKeys(accnameText);
			hp.getstartsearch().click();
			//Thread.sleep(10000);
			Assert.assertTrue(ap.getValidateInactiveAccName().isDisplayed());
		}
		catch (StaleElementReferenceException exe) {
			System.out.println(exe.getMessage());
		}
		catch (IllegalArgumentException ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	@Test(priority=19)
	public void TS019_VerifyUpdateAccountInformation() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T288- Verify that existing account information is updated properly

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Accounts Tab at left menu.
		hp.getAccountTab().click();

		//Open an existing account
		ap.getBLetterFilterLink().click();
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();

		//Update all the fields at Summary tab
		String accountdbanamebeforeupdate = ap.getupdateaccountname().getAttribute("value");
		System.out.println("AccountDBA name before update: "+accountdbanamebeforeupdate);
		ap.getupdateaccountname().sendKeys(Keys.CONTROL + "a");
		ap.getupdateaccountname().sendKeys(Keys.DELETE);
		String AccountNameNew = genData.generateRandomAlphaNumeric(10);
		ap.getupdateaccountname().sendKeys(AccountNameNew);
		String accountdbaname = ap.getupdateaccountname().getAttribute("value");
		System.out.println("AccountDBA name after update: "+accountdbaname);

		ap.getPhone().sendKeys(Keys.CONTROL + "a");
		ap.getPhone().sendKeys(Keys.DELETE);
		ap.getclickextensiontextbox().click();
		ap.getPhone().click();
		String phoneafterupdate = genData.generateRandomNumber(10);
		System.out.println("Phone after update: "+phoneafterupdate);
		ap.getPhone().sendKeys(phoneafterupdate);

		//Scroll up the page till Address field
		act = new Actions(driver);
		act.moveToElement(ap.getAddress()).perform();

		ap.getmovetotype().click();
		ap.getdeletetype().click();
		ap.getclicksearchddbutton().click();
		ap.getselecttype().click();
		ap.getclicksearchddbutton().click();

		//Save updated account information
		ap.getAccSaveCloseBtn().click();

		//Verification for updated account information
		hp.getAccountTab().click();
		hp.getSearchAccountField().click();
		hp.getSearchAccountField().sendKeys(AccountNameNew);
		hp.getstartsearch().click();
		WebElement accountdbanameafterupdate = ap.getAccountNameSearchTable();
		Assert.assertFalse(accountdbanameafterupdate.getText().contains(accountdbanamebeforeupdate));

		WebElement AccPhone = ap.getPhoneinSearchTable();
		Assert.assertTrue(AccPhone.getText().contains(phoneafterupdate));
		System.out.println("Account Information updated successfully");
		hp.getClearSearch().click();
	}	

	@Test(priority=20)
	public void TS020_VerifyAddContactTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T294- Verify new contact creation from existing account

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Accounts Tab at left menu.
		hp.getAccountTab().click();

		//Open an existing account
		ap.getAccountName().click();
		ap.getAccNaviagteBtn().click();

		//Scroll down to contacts section		
		act = new Actions(driver);
		act.moveToElement(ap.getAssociatedListsLabel()).perform();
		Thread.sleep(4000);
		cp.getContactSectionMenuBtn().click();

		//Add new contact
		cp.getclicknewcontactbutton().click();
		String ContactFirstName = "QA"+ genData.generateRandomString(3);
		cp.getfirstname().click();
		cp.getfirstname().sendKeys(ContactFirstName);

		String ContactLastName = genData.generateRandomString(5);
		cp.getlastname().click();
		cp.getlastname().sendKeys(ContactLastName);

		WebElement scrollText = cp.getScrollTextOnContactForm();	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",scrollText);
		Thread.sleep(3000);

		cp.getemail().sendKeys(genData.generateEmail(15));
		cp.getmobile().sendKeys(genData.generateRandomNumber(10));

		//Click on Save button in header
		cp.getsavecontact().click();

		String contactname = cp.getverifycontact().getText();
		System.out.println("Contact Name: "+contactname);
		String validateContactName = ContactFirstName +" "+ ContactLastName;
		System.out.println("Validate Contact Name: "+ validateContactName);
		Assert.assertTrue(contactname.contains(validateContactName));
		ap.getPageBackBtn().click();
		System.out.println("Contact added successfully to an account.");
	}

	@Test(priority=21)
	public void TS021_VerifyUpdateContactsFromAccountFormTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T78- Verify buyer services account manager has access to edit buyer profile 
		//information while viewing a list of buyers by account.

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Accounts Tab at left menu.
		hp.getAccountTab().click();

		boolean staleElement = true;
		try {
			while(staleElement){
				//Click on 'Search' view and enter an account name having associated Contacts (C & R Vintage)
				hp.getSearchAccountField().click();
				hp.getSearchAccountField().sendKeys(prop.getProperty("acchavingcontacts"));
				hp.getstartsearch().click();
				hp.getSearchResultAcc().click();
				ap.getAccNaviagteBtn().click();
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
		//Under Contacts section in summary tab, click on the below field and update data for a contact/buyer: Email, Business Phone
		ap.getContactsSectionContactName().click();
		ap.getContactsSectionBusinessPhoneField().click();
		ap.getContactsSectionBusinessPhoneField().sendKeys(Keys.BACK_SPACE);
		ap.getContactsSectionLabel().click();
		String contactphoneno = genData.generateRandomNumber(10);
		ap.getContactsSectionBusinessPhoneField().sendKeys(contactphoneno);
		ap.getContactsSectionLabel().click();

		//Scroll till the Email field
		act = new Actions(driver);
		act.moveToElement(ap.getAssociatedListsLabel()).perform();
		ap.getContactsSectionBusinessPhoneField().sendKeys(Keys.ARROW_RIGHT);
		ap.getContactsSectionMobilePhoneField().sendKeys(Keys.ARROW_RIGHT);

		//Update Email field
		ap.getContactsSectionEmailField().click();
		ap.getContactsSectionEmailField().sendKeys(Keys.BACK_SPACE);
		ap.getContactsSectionLabel().click();
		String contactemail = genData.generateEmail(15);
		ap.getContactsSectionEmailField().sendKeys(contactemail);
		ap.getContactsSectionLabel().click();

		//Click on 'Save' button and then Click 'Refresh' button
		ap.getAccSaveBtn().click();
		ap.getAccRefreshBtn().click();

		//Store contact name in a variable
		String contactname = ap.getContactsSectionContactName().getText();
		System.out.println("Contact name: " +contactname);

		//Click on Contact navigate button to open the contact details
		act = new Actions(driver);
		act.doubleClick(ap.getContactsSectionContactName()).perform();

		Thread.sleep(10000);
		//Scroll till email and business phone fields
		WebElement enteranotelabel = ap.getEnteraNoteLabel();	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",enteranotelabel);
		Thread.sleep(5000);

		//Verify that updated data is displayed on the contact form
		WebElement updatedContactEmail = cp.getContactFormEmailField();
		String contactemailtext = updatedContactEmail.getAttribute("Value");
		System.out.println("Updated Contact Email: " + contactemailtext);
		Assert.assertTrue(contactemailtext.contains(contactemail));

		//Click on 'Contacts' tab from left navigation bar
		hp.getContactsTab().click();
		hp.getSearchContactField().click();
		hp.getSearchContactField().sendKeys(contactname);
		hp.getstartsearch().click();

		String updatedContactBuisnessPhone = hp.getSearchResultContactBusinessPhone().getText();
		System.out.println("Updated contact Business Phone: " +updatedContactBuisnessPhone);
		Assert.assertTrue(updatedContactBuisnessPhone.contains(contactphoneno));

		//Clear the search term
		hp.getClearSearch().click();
	}
	@Test(priority=22)
	public void TS022_VerifyMediaSegmentationFieldTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T29- Media Segmentation drop-down field is visible on Account form only if Type equal to 'Media' is selected

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Accounts Tab at left menu.
		hp.getAccountTab().click();

		//Click on 'New' button to open new Account Form
		ap.getAccountNewbtn().click();

		//Scroll up the page till Address field
		act = new Actions(driver);
		act.moveToElement(ap.getAddress()).perform();

		//Select account Type as 'Media' in Account information section
		ap.getAccTypetxtbx().click();
		ap.getAcctypeExpandbtn().click();
		ap.getAccTypeMedia().click();
		ap.getAddress().click();

		//Verify that 'Media Segmentation' and 'Media Type' fields are displayed
		List<WebElement> mediasegmentnlabel = ap.getMediaSegmentationFieldLabel();
		Assert.assertTrue(mediasegmentnlabel.size()!= 0);

		List<WebElement> mediatypelabel = ap.getMediaTypeFieldLabel();
		Assert.assertTrue(mediatypelabel.size()!= 0);

		//Click on 'Media Segmentation' drop down
		ap.getMediaSegmentationDropdown().click();
		//Select a value in Media Segmentation (Las Vegas Local)
		ap.getMediaSegmentationName().click();

		//Click on Media Type drop down
		ap.getMediaTypeDropdown().click();
		//Select any value in Media Type field
		ap.getMediaTypeName().click();

		//Update the account Type as 'Buyer' 
		ap.getAccTypeSelectedValueTxtbx().click();
		ap.getRemoveAccTypeMediaBtn().click();
		ap.getAcctypeExpandbtn().click();
		ap.getAccTypeBuyer().click();
		ap.getNewAccountHeader().click();

		//Verify that Media Segmentation and Media Type fields should be disappeared from the new account form
		List<WebElement> mediasegmentnlabel1 = ap.getMediaSegmentationFieldLabel();
		Assert.assertFalse(mediasegmentnlabel1.size()!= 0);

		List<WebElement> mediatypelabel1 = ap.getMediaTypeFieldLabel();
		Assert.assertFalse(mediatypelabel1.size()!= 0);

		//Navigate back to Active accounts list

		ap.getPageBackBtn().click();
		ap.getDiscardChangesBtn().click();
	}




	//Manual Fail_Caught By Automation	
	@Test(priority=24)
	public void TS024_ManualFail_VerifyAssociatedContactsAccountStatusOfDeactivatedAccountTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T63- Verify if an account is deactivated with reason 'Out of Business', all 
		//related contacts will also be marked as Out of business.

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Accounts Tab at left menu.
		hp.getAccountTab().click();

		boolean staleElement = true;
		try {
			while(staleElement){
				//Open any Active account from list
				ap.getBLetterFilterLink().click();
				ap.getAccountName().click();
				ap.getAccNaviagteBtn().click();

				//Click 'Deactivate' button available in the top panel
				ap.getDeactivateBtn().click();

				//Select 'Account Status: Out of Business' in the confirm Account Deactivation pop-up
				ap.getActivatePopupStatusField().click();
				WebElement outofbusinessstatus = ap.getAccStatusOutofBusiness();
				outofbusiness = ap.getAccStatusOutofBusiness().getText();
				System.out.println("Account Status: " + outofbusiness);
				outofbusinessstatus.click();

				//Click on 'Deactivate' button
				ap.getDeactivatePopupDeactivatebtn();

				//Click on 'Refresh' button
				ap.getAccRefreshBtn().click();
				staleElement = false;
			}
		}
		catch (StaleElementReferenceException exe) {
			staleElement = false;
			System.out.println(exe.getMessage());
		}

		act = new Actions(driver);
		act.moveToElement(ap.getAssociatedListsLabel()).perform();

		//In Contacts section, verify that the deactivated contacts should no more be displayed in contacts section
		List<WebElement> activecontactslist = ap.getActiveContactsList();
		Assert.assertTrue(activecontactslist.size()!= 0);

		//Click on 'Related' tab and Select 'Contacts' item 
		ap.getRelatedTab().click();
		ap.getRelatedTabContactsItem().click();

		//Click on 'Select a View' drop-down icon next to 'Contact Associated View' label
		ap.getContactAssociatedViewDropDownIcon().click();

		//Select 'System Views- All Contacts' item
		ap.getSelectViewsAllContactsItem().click();
		Thread.sleep(6000);
		//Verify the Status should be 'Out of Business' for each contact in list
		WebElement contactstatus = null;
		for (int i=0;i<3;i++)
		{
			contactstatus = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-6']"));
			System.out.println(contactstatus.getText());
			Assert.assertTrue(contactstatus.getText().contains(outofbusiness));
		}

		ap.getPageBackBtn().click();
	}

	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
}
