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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AppLandingPage;
import pageObjects.CRMAccountsPage;
import pageObjects.CRMAddMarketingRelationshipOwner;
import pageObjects.CRMAdvanceFindPage;
import pageObjects.CRMContactPage;
import pageObjects.CRMHomePage;
import pageObjects.CRMIncentiveCategoriesPage;
import pageObjects.CRMIncentiveDetailsPage;
import pageObjects.CRMIncentivesPage;
import pageObjects.CRMLandingPage;
import pageObjects.CRMLoginPage;
import pageObjects.CRMPeoplePage;
import pageObjects.CRMReferenceDataPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class CAB231PageTest extends base{

	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	public String newcontactname;
	public String outofbusiness;
	public String donotcall;
	public String newcontactemail;
	public String notavalidbuyingacc;
	public String novalidaccinfo;
	public String mergedacc;
	public String novalidaccinfoacc;
	public String outofbusinessacc;
	public String notvalidbuyingaccacc;
	CRMLandingPage lap;
	CRMLoginPage lp;
	AppLandingPage alp;
	CRMHomePage hp;
	CRMAccountsPage ap;
	CRMReferenceDataPage refdp;
	CRMAdvanceFindPage afp;
	CRMIncentiveCategoriesPage incat;
	CRMIncentiveDetailsPage ind;
	Actions act;
	CRMContactPage cp;
	CRMAddMarketingRelationshipOwner amro;
	JavascriptExecutor js;
	CRMPeoplePage pl;
	CRMIncentivesPage in;

	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		genData=new GenerateData();
		utl = new Utility(driver);
		utl.verifyLoginFunctionality(); //requires for Parallel text execution
	}

	@Test(priority=1)
	public void TS001_VerifyContactChannelProfileforJuniper() throws InterruptedException
	{
		//The purpose of this test case to:-
		//T564- Verify that Contact Channel Profile is created for Juniper Market when Phone Call Market
		//Outcome is added for Juniper Market with Contact status as Interested

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		in = new CRMIncentivesPage(driver);

		//Open Contacts page and open existing contact
		hp.getContactsTab().click();
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("name"));
		ap.getclicksearchbutton().click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		WebElement OpenContact = ap.getValidateInactiveAccName();
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
		ap.getAccSaveBtn().click();
		
		//Create New Phone Call Market Outcome
		cp.getNewPhoneCallMarketOutcomeBtn().click();
		Thread.sleep(3000);
		cp.getPhoneCallMarketSubjectTxtBx().sendKeys(prop.getProperty("market"));
		Thread.sleep(3000);
		cp.getmarketoption().click();
		cp.getPhoneCallOutcomeTxtBx().click();
		cp.selectPhoneCallOutcomeOption().click();
		cp.getcontactstatus().click();
		cp.getcontactstatusoption().click();
		cp.getContactTaskSavenClosebtn().click();
		Thread.sleep(5000);
		ap.getAccPageBackBtn().click();
		Thread.sleep(5000);
		ap.getAccRefreshBtn().click();
		
		//Verify that Contact Channel is created at Contact Channel Profile tab
		cp.getcontactchannelprofilestab().click();
		Thread.sleep(3000);
		String Channel = ap.getValidateInactiveAccName().getText();
		Assert.assertEquals(Channel, "JuniperMarket");
		System.out.println("Contact Channel Profile is added successfully.");
		
		//Deactivate contact channel profile to make next run assert successful
		in.selectIncentiveRecord().click();
		Thread.sleep(3000);
		cp.getmorecommandsforccp().click();
		cp.getdeactivateinccpgrid().click();
		Thread.sleep(3000);
		cp.getdeactivateccp().click();
	}
	@Test(priority=2)
	public void TS002_VerifyContactChannelProfileInterestForJuniper() throws InterruptedException
	{
		//The purpose of this test case to:-
		//T565- Verify that Juniper Interest is properly collected at Contact Channel Profile page

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		in = new CRMIncentivesPage(driver);

		//Open Contacts page and open existing contact
		hp.getContactsTab().click();
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("name"));
		ap.getclicksearchbutton().click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		WebElement OpenContact = ap.getValidateInactiveAccName();
		action.doubleClick(OpenContact).perform();

		//Create Contact Channel with Juniper Interest
		cp.getcontactchannelprofilestab().click();
		Thread.sleep(3000);
		cp.getnewccp().click();
		Thread.sleep(5000);
		cp.getccpchannel().click();
		cp.getccpchannel().sendKeys(prop.getProperty("market"));
		Thread.sleep(2000);
		cp.getchannelid().click();
		cp.getcontactstatus().click();
		cp.getcontactstatusoption().click();
		ap.getAccSaveCloseBtn().click();
		Thread.sleep(5000);
		
		//Verify Juniper Interest in Contact Channel Profiles grid
		String Channel = ap.getValidateInactiveAccName().getText();
		Assert.assertEquals(Channel, "JuniperMarket");
		System.out.println("Contact Channel Profile Interest for Juniper Market is added successfully.");
	}
    
	
	@Test(priority = 3)
	public void TS003_VerifyPreseneOfJuniperSpecificIncentiveCategoryJuniperMarket() throws InterruptedException {
		// The purpose of this test case to:-
		// CRM-T563_Verify the presence of newly added juniper specific incentive
		// category Juniper Market

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		refdp = new CRMReferenceDataPage(driver);
		incat = new CRMIncentiveCategoriesPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Navigate to Incentive Categories menu
		utl.scrollToElement(hp.getTransactionalSectnLabel());
		hp.getIncCategoriesTab().click();

		// Click on Add New button to go to New Incentive Category section
		refdp.getAddNewIncetiveButton().click();
		WebElement newincentivelabel = refdp.getNewIncentiveCategoryLabel();
		Assert.assertEquals(newincentivelabel.isDisplayed(), true);
		System.out.println("New Incentive Categories page got opened");

		// Enter Incentive Category Name
		String incentivecategoryname = "Cyb" + genData.generateRandomString(5);
		refdp.getIncentiveCategoryName().click();
		refdp.getIncentiveCategoryName().sendKeys(incentivecategoryname);
		System.out.println("Incentive Category Name: " + incentivecategoryname);

		// Go to Incentive Category Type drop down and select Juniper Market option
		refdp.getIncentiveCategoryDropDown().click();
		String dropdownvalue = refdp.selectJuniperMarketOption().getText();
		Assert.assertEquals(dropdownvalue, "Juniper Market");
		System.out.println("Incentive Category Type drop down having Juniper Market option");
		refdp.selectJuniperMarketOption().click();

		// Enter Estimated Value and Save the record
		refdp.getEstimatedValue().sendKeys("1000");
		Thread.sleep(2000);
		refdp.selectSaveAndCloseIncCategory().click();

		// Verify presence of newly added Incentive Category record under Active
		// Incentive Categories
		WebElement incentivecategoryoption = refdp.verifyActiveIncentiveCategoryOption();
		Assert.assertTrue(incentivecategoryoption.isDisplayed());
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(incentivecategoryname);
		ap.getclicksearchbutton().click();
		Thread.sleep(5000);

		WebElement newlyadedrecord = driver.findElement(By.xpath("//div[@data-id='cell-0-2']"));
		String verifynewlyadedrecord = newlyadedrecord.getText();
		Assert.assertTrue(verifynewlyadedrecord.contains(incentivecategoryname));
		System.out.println("The newly added record " + incentivecategoryname
				+ " gets displayed under Active Incentive Categories");
	}

	@Test(priority = 4)
	public void TS004_VerifyIncentiveDetailAdjustmentJuniperMarket() throws InterruptedException {
		// The purpose of this test case to:-
		// CRM-T567_Verify Incentive Detail adjustment for Juniper Market

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		in = new CRMIncentivesPage(driver);
		refdp = new CRMReferenceDataPage(driver);
		cp = new CRMContactPage(driver);
		ind = new CRMIncentiveDetailsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Contacts tab
		hp.getContactsTab().click();

		// Open any active contact
		cp.getBLetterFilterLink().click();
		cp.selectContactName().click();
		// driver.findElement(By.xpath("//div[@data-id='cell-5-2']")).click();
		ap.getAccNaviagteBtn().click();

		// Click Incentives tab of an existing contact
		in.getIncentiveTab().click();

		// Click on New Incentive button
		in.getNewIncentiveBtn().click();

		String accountname = in.getSelectedAccountNameField().getText();

		// Select Market at New Incentive Form
		in.getMarketTextBox().click();
		in.getMarketTextBox().sendKeys("Juniper");
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

		// Click on Save and Close button
		in.getSavenCloseBtn().click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@data-id='ignore_save']")).click();
		Thread.sleep(5000);

		// Click New Incentive Detail
		ind.getclicknewincdet().click();

		// Search and select Incentive with market Juniper Market
		// Verify that Juniper Market got selected in the parent Incentive Category
		refdp.getCRMIncentiveLookup().click();
		String crmincentivelookupfield = "Wild Cat";
		refdp.getCRMIncentiveLookup().sendKeys(crmincentivelookupfield);
		refdp.getCRMIncentiveLookupSearchBtn().click();
		utl.scrollToElement(driver.findElement(By.xpath("//*[text()='" + crmincentivelookupfield + "']")));
		driver.findElement(By.xpath("//li[@aria-label=\"Wild Cat, B Coskun\"]/button")).click();
		String incentivecat = "Juniper Pre-Launch";
		String verifyincentivecat = driver
				.findElement(
						By.xpath("//li[@aria-label=\"Wild Cat, B Coskun" + ", " + incentivecat + "\"]/div[2]/span[3]"))
				.getText();
		System.out.println("The market got selected in the parent Incentive Category as : " + verifyincentivecat);
		Assert.assertEquals(verifyincentivecat, "Juniper Pre-Launch");

	}

	@Test(priority = 5)
	public void TS005_VerifyJuniperMktPhase1Test() throws InterruptedException {
		// The purpose of this test case to:-
		// CRM-T555_Juniper Mkt_Phase 1_ Display Data Source field in D365

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		refdp = new CRMReferenceDataPage(driver);
		afp = new CRMAdvanceFindPage(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Go to cCOntact tab and click on Advance Find label and switch to Advance Find
		// window
		hp.getContactsTab().click();
		afp.getAdvanceFilterBtn().click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentwindow = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		driver.manage().window().maximize();
		Thread.sleep(20000);

		// Select Contact Channel Profile option from Look For dropdown
		driver.switchTo().frame("contentIFrame0");
		afp.selectLookForDropDown().click();
		afp.selectContactChannelProfile().click();

		// Select Juniper Source as clickable option
		afp.getSelectClickbleOption().click();
		Thread.sleep(3000);
		afp.getJuniperSourceOption().click();
		Thread.sleep(3000);
		afp.selectMultiPickListButton().click();
		Actions actions = new Actions(driver);
		WebElement a = afp.selectMultiPickListButton1();
		actions.moveToElement(a).perform();
		afp.selectMultiPickListButton1().click();

		Thread.sleep(5000);

		// Select Registration as Juniper source value
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame("InlineDialog_Iframe");
		WebElement registrationvalue = afp.selectJuniperSourceRegistrationValue();
		String junipersourceregivalue = registrationvalue.getText();
		System.out.println("Value of Juniper Source selected: " + junipersourceregivalue);
		registrationvalue.click();
		afp.selectMoveRightBtn().click();
		afp.selectOKBtntoSelectValue().click();

		// Search the result/record(s)
		afp.selectResultsBtn().click();
		Thread.sleep(10000);
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame("contentIFrame0").switchTo().frame("resultFrame");
		WebElement contactfrmtable = afp.selectContactFromTable();
		String contactnamewithJM = contactfrmtable.getText();
		System.out.println("Name of the Contract having channel as Juniper Market: " + contactnamewithJM);
		driver.close();

		// Go to Contact tab and search for same Contact and check Juniper Source of
		// COntact Channel Profile for that Contact
		driver.switchTo().window(parentwindow);
		hp.getContactsTab().click();
		refdp.getSearchChannelField().click();
		refdp.getSearchChannelField().sendKeys(contactnamewithJM);
		refdp.getStartSearch().click();

		Thread.sleep(6000);

		refdp.selectRecordFromGrid().click();
		cp.getContactNaviagteBtn().click();
		Thread.sleep(5000);

		refdp.selectContactChannelProfile().click();
		refdp.selectJuniperMrkRecord().click();
		refdp.getEditRecord().click();

		Thread.sleep(3000);
		Select sel = new Select(refdp.getValueofJuniperSrc());
		WebElement junipersourcemkt = sel.getFirstSelectedOption();
		String valueofjunipersourcemkt = junipersourcemkt.getText();
		System.out.println("Value of Juniper Source Market: " + valueofjunipersourcemkt);

		Assert.assertEquals(junipersourceregivalue, valueofjunipersourcemkt);
		System.out.println("Value of selected juniper source and actual juniper source value are same");

	}

}








