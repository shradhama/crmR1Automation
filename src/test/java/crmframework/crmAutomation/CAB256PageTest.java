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
import pageObjects.CRMIncentivesPage;
import pageObjects.CRMLandingPage;
import pageObjects.CRMLoginPage;
import pageObjects.CRMPeoplePage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class CAB256PageTest extends base{

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
	public void TS001_VerifyInactiveContactStatusReasonNotAValidBuyingAccountTest() throws InterruptedException
	{
		//The purpose of this test case to:-
		//T535- Verify the newly added inactive reason code for Contacts: 'Not a Valid Buying Account' 
		//while deactivating any active Contacts

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		amro = new CRMAddMarketingRelationshipOwner(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		hp.getContactsTab().click();
		cp.getGLetterFilterLink().click();
		String contactname = cp.selectContactName().getText();

		WebElement validateContactName = driver.findElement(By.xpath("//label[contains(text(),'"+contactname+"')]"));
		validateContactName.click();
		ap.getAccNaviagteBtn().click();

		//Click on Deactivate button
		cp.getDeactivateBtn().click();

		//Select 'Contact Status: Not a Valid Buying Account' in the confirm Contact Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		WebElement notavalidbuyingaccstatus = cp.getContactStatusNotaValidBuyingAcc();
		notavalidbuyingacc = cp.getContactStatusNotaValidBuyingAcc().getText();
		System.out.println("Contact Status: " + notavalidbuyingacc);
		notavalidbuyingaccstatus.click();

		//Click on 'Deactivate button of confirmation pop-up
		cp.getDeactivateOkBtn().click();

		//Verify that Contact is deactivated and selected contact status reason is displayed at the right side of the header.
		amro.gethdbtn().click();
		WebElement statusreasonforinactivecontactinheader = cp.getInactiveContactStatusNotAValidBuyingAcc();
		System.out.println("Contact Status Reason: " + (statusreasonforinactivecontactinheader.getText()));
		Assert.assertTrue(statusreasonforinactivecontactinheader.getText().contains(notavalidbuyingacc));

		//Verify that Top ribbon 'Deactivate' option changes to 'Activate'
		Assert.assertTrue(ap.getActivateBtn().isDisplayed());

		//Navigate back to Active contacts page
		ap.getPageBackBtn().click();

		//Click on 'Active Contacts' drop-down view button
		cp.getActiveContactDropDownBtn().click();

		//Select 'Inactive Contacts' option
		cp.getInactiveContactOptn().click();

		//Click on 'G' link to sort contacts starts with 'G'
		try {
			cp.getGLetterFilterLink().click();
			Thread.sleep(5000);
			//Validate deactivated account
			hp.getSearchInactiveContactField().click();
			hp.getSearchInactiveContactField().sendKeys(contactname);
			hp.getstartsearch().click();
			System.out.println(cp.getValidateInactiveContactName().getText());
			Assert.assertTrue(cp.getValidateInactiveContactName().isDisplayed());
			System.out.println("Selected contact is deactivated successfully");
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

	@Test(priority=2)
	public void TS002_VerifyInactiveContactStatusReasonNoValidAccountInfoTest() throws InterruptedException
	{
		//The purpose of this test case to:-
		//T536- Verify the newly added inactive reason code for Contacts: 'No Valid Account Info' 
		//while deactivating any active Contacts

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		amro = new CRMAddMarketingRelationshipOwner(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		hp.getContactsTab().click();
		cp.getGLetterFilterLink().click();
		String contactname = cp.selectContactName().getText();

		WebElement validateContactName = driver.findElement(By.xpath("//label[contains(text(),'"+contactname+"')]"));
		validateContactName.click();
		ap.getAccNaviagteBtn().click();

		//Click on Deactivate button
		cp.getDeactivateBtn().click();

		//Select 'Contact Status: Not a Valid Buying Account' in the confirm Contact Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		Thread.sleep(5000);
		
		WebElement novalidaccinfostatus = cp.getContactStatusNoValidAccInfo();
		novalidaccinfo = cp.getContactStatusNoValidAccInfo().getText();
		System.out.println("Contact Status: " + novalidaccinfo);
		novalidaccinfostatus.click();

		//Click on 'Deactivate button of confirmation pop-up
		cp.getDeactivateOkBtn().click();

		//Verify that Contact is deactivated and selected contact status reason is displayed at the right side of the header.
		amro.gethdbtn().click();
		WebElement statusreasonforinactivecontactinheader = cp.getInactiveContactStatusNoValidAccInfo();
		System.out.println("Contact Status Reason: " + (statusreasonforinactivecontactinheader.getText()));
		Assert.assertTrue(statusreasonforinactivecontactinheader.getText().contains(novalidaccinfo));

		//Verify that Top ribbon 'Deactivate' option changes to 'Activate'
		Assert.assertTrue(ap.getActivateBtn().isDisplayed());

		//Navigate back to Active contacts page
		ap.getPageBackBtn().click();

		//Click on 'Active Contacts' drop-down view button
		cp.getActiveContactDropDownBtn().click();

		//Select 'Inactive Contacts' option
		cp.getInactiveContactOptn().click();

		//Click on 'G' link to sort contacts starts with 'G'
		try {
			cp.getGLetterFilterLink().click();
			Thread.sleep(5000);
			//Validate deactivated account
			hp.getSearchInactiveContactField().click();
			hp.getSearchInactiveContactField().sendKeys(contactname);
			hp.getstartsearch().click();
			System.out.println(cp.getValidateInactiveContactName().getText());
			Assert.assertTrue(cp.getValidateInactiveContactName().isDisplayed());
			System.out.println("Selected contact is deactivated successfully");
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
	
	@Test(priority=3)
	public void TS003_VerifySequenceOfInactiveContactStatusReasonCodesTest() throws InterruptedException
	{
		//The purpose of this test case to:-
		//T537- Verify the newly added inactive reason code for Contacts: 'No Valid Account Info' 
		//while deactivating any active Contacts

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		amro = new CRMAddMarketingRelationshipOwner(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		hp.getContactsTab().click();
		cp.getGLetterFilterLink().click();
		String contactname = cp.selectContactName().getText();

		WebElement validateContactName = driver.findElement(By.xpath("//label[contains(text(),'"+contactname+"')]"));
		validateContactName.click();
		ap.getAccNaviagteBtn().click();

		//Click on Deactivate button
		cp.getDeactivateBtn().click();

		//Select 'Contact Status: Not a Valid Buying Account' in the confirm Contact Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		Thread.sleep(5000);
		
		List<String> actualstatuscodes = new ArrayList();
		List<String> originalList = new ArrayList();
		
		for (int i=2; i<8;i++) 
		{
			WebElement contactstatuslist = driver.findElement(By.xpath("//div[@data-id='status_id.fieldControl-option-set-select-container']/select/option["+i+"]"));
			String listitem = contactstatuslist.getText();
			originalList.add(listitem);
			actualstatuscodes.add(listitem);
		}
		System.out.println("Actual Contact Status Reason Codes: " + actualstatuscodes);
		
		List<String> expectedstatuscodes = new ArrayList<String>();
		expectedstatuscodes.add("Bad Contact Info");
		expectedstatuscodes.add("Merged");
		expectedstatuscodes.add("No Longer with Account");
		expectedstatuscodes.add("Out of Business");
		expectedstatuscodes.add("No Valid Account Info");
		expectedstatuscodes.add("Not a Valid Buying Account");
        System.out.println("Expected Contact Status Reason Codes : " + expectedstatuscodes);
       	
        Assert.assertEquals(actualstatuscodes,expectedstatuscodes);
	}
	
	@Test(priority=4)
	public void TS004_VerifyInactiveAccountStatusReasonMergedTest() throws InterruptedException
	{
		//The purpose of this test case to:-
		//CRM_T528_ For deactivated Account with reason 'Merged', no associated Contacts(s) get deactivated 
		
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		amro = new CRMAddMarketingRelationshipOwner(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Click on Account tab from left and select/view any account record
		hp.getAccountTab().click();
		cp.getGLetterFilterLink().click();
		String accountname = ap.getAccountName().getText();
		WebElement validateAccountName = driver.findElement(By.xpath("//label[contains(text(),'"+accountname+"')]"));
		validateAccountName.click();
		ap.getAccNaviagteBtn().click();

		//Click on Deactivate button
		ap.getDeactivateBtn().click();

		//Select Reason Code: Merged in the confirm Account Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		WebElement mergedaccstatus = ap.getAccountStatusMerged();
		mergedacc = ap.getAccountStatusMerged().getText();
		mergedaccstatus.click();

		//Click on 'Deactivate button of confirmation pop-up
		ap.getDeactivateOkBtn().click();

		//Verify status reason of Account
		String verifyaccstatus= ap.getVerifyAccountStatusMerged().getText();
		System.out.println("Account Status Reason: "+ verifyaccstatus);
		Assert.assertEquals("Merged", verifyaccstatus);
		
		//Go to associate Contacts linked with Account
		ap.getRelatedTab().click();
		Thread.sleep(3000);
		ap.getRelatedTabContactsItem().click();
		Thread.sleep(5000);
		ap.getContactAssociatedViewDropDownIcon().click();
		ap.getSelectViewsAllContactsItem().click();
		Thread.sleep(5000);
		
		//Verify status of associate Contact (when status of respective Account is Merged)
		ap.getContactsSectionContactName().click();
		WebElement contactstatus= ap.getContactsSectionContactNameStatusAsActive();
		System.out.println("Contact Status: " + (contactstatus.getText()));
		Assert.assertEquals(contactstatus.getText(), "Active");
		
		ap.getAccNaviagteBtn().click();
		
		//Verify status reason of associate Contact (when status of respective Account is Merged)
		amro.gethdbtn().click();
		Thread.sleep(3000);
		WebElement statusforcontactasactive = ap.getContactStatusReasonActive();
		System.out.println("Contact Status Reason: " + (statusforcontactasactive.getText()));
		Assert.assertEquals(statusforcontactasactive.getText(), "Active");
	}

	
	@Test(priority=5)
	public void TS005_VerifyInactiveAccountStatusReasonNoValidInfoAvailableTest() throws InterruptedException
	{
		//The purpose of this test case to:-
		//CRM_T529_For deactivated Account with reason 'No Valid Info Available', all associated Contacts(s) get deactivated
		
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		amro = new CRMAddMarketingRelationshipOwner(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Click on Account tab from left and select/view any account record
		hp.getAccountTab().click();
		cp.getGLetterFilterLink().click();
		String accountname = ap.getAccountName().getText();
		WebElement validateAccountName = driver.findElement(By.xpath("//label[contains(text(),'"+accountname+"')]"));
		validateAccountName.click();
		ap.getAccNaviagteBtn().click();

		//Click on Deactivate button
		ap.getDeactivateBtn().click();

		//Select Reason Code: No Valid Info Available in the confirm Account Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		WebElement novalidaccinfoaccstatus = ap.getAccountStatusNoValidInfoAvailable();
		novalidaccinfoacc = ap.getAccountStatusNoValidInfoAvailable().getText();
		novalidaccinfoaccstatus.click();

		//Click on 'Deactivate button of confirmation pop-up
		ap.getDeactivateOkBtn().click();

		//Verify status reason of Account
		String verifyaccstatus= ap.getVerifyAccountStatusNoValidInfoAvailable().getText();
		System.out.println("Account Status Reason: "+ verifyaccstatus);
		Assert.assertEquals("No Valid Info Available", verifyaccstatus);
		
		//Go to associate Contacts linked with Account
		ap.getRelatedTab().click();
		Thread.sleep(3000);
		ap.getRelatedTabContactsItem().click();
		Thread.sleep(5000);
		ap.getContactAssociatedViewDropDownIcon().click();
		ap.getSelectViewsAllContactsItem().click();
		Thread.sleep(5000);
		
		//Verify status of associate Contact (when status of respective Account is No Valid Info Available)
		ap.getContactsSectionContactName().click();
		WebElement contactstatus= ap.getContactsSectionContactNameStatusAsInactive();
		System.out.println("Contact Status: " + (contactstatus.getText()));
		Assert.assertEquals(contactstatus.getText(), "Inactive");
				
		ap.getAccNaviagteBtn().click();
				
		//Verify status reason of associate Contact (when status of respective Account is No Valid Info Available)
		amro.gethdbtn().click();
		Thread.sleep(3000);
		WebElement statusforcontactasnovalidaccinfo = ap.getContactStatusReasonNoValidAccInfo();
		System.out.println("Contact Status Reason: " + (statusforcontactasnovalidaccinfo.getText()));
		Assert.assertEquals(statusforcontactasnovalidaccinfo.getText(), "No Valid Account Info");
	}
	
	@Test(priority=6)
	public void TS006_VerifyInactiveAccountStatusReasonOutOfBusinessTest() throws InterruptedException
	{
		//The purpose of this test case to:-
		//CRM_T530_For deactivated Account with reason 'Out of Business', all associated Contacts(s) get deactivated
				
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		amro = new CRMAddMarketingRelationshipOwner(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Click on Account tab from left and select/view any account record
		hp.getAccountTab().click();
		cp.getGLetterFilterLink().click();
		String accountname = ap.getAccountName().getText();
		WebElement validateAccountName = driver.findElement(By.xpath("//label[contains(text(),'"+accountname+"')]"));
		validateAccountName.click();
		ap.getAccNaviagteBtn().click();

		//Click on Deactivate button
		ap.getDeactivateBtn().click();

		//Select Reason Code: Out of Business in the confirm Account Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		WebElement outofbusinessaccstatus = ap.getAccountStatusOutOfBusiness();
		outofbusinessacc = ap.getAccountStatusOutOfBusiness().getText();
		outofbusinessaccstatus.click();

		//Click on 'Deactivate button of confirmation pop-up
		ap.getDeactivateOkBtn().click();

		//Verify status reason of Account
		String verifyaccstatus= ap.getVerifyAccountStatusOutOfBusiness().getText();
		System.out.println("Account Status Reason: "+ verifyaccstatus);
		Assert.assertEquals("Out of Business", verifyaccstatus);
		
		//Go to associate Contacts linked with Account
		ap.getRelatedTab().click();
		Thread.sleep(3000);
		ap.getRelatedTabContactsItem().click();
		Thread.sleep(5000);
		ap.getContactAssociatedViewDropDownIcon().click();
		ap.getSelectViewsAllContactsItem().click();
		Thread.sleep(5000);
		
		//Verify status of associate Contact (when status of respective Account is Out of Business)
		ap.getContactsSectionContactName().click();
		WebElement contactstatus= ap.getContactsSectionContactNameStatusAsInactive();
		System.out.println("Contact Status: " + (contactstatus.getText()));
		Assert.assertEquals(contactstatus.getText(), "Inactive");
				
		ap.getAccNaviagteBtn().click();
				
		//Verify status reason of associate Contact (when status of respective Account is Out of Business)
		amro.gethdbtn().click();
		Thread.sleep(3000);
		WebElement statusforcontactasoutofbusiness = ap.getContactStatusReasonOutOfBusiness();
		System.out.println("Contact Status Reason: " + (statusforcontactasoutofbusiness.getText()));
		Assert.assertEquals(statusforcontactasoutofbusiness.getText(), "Out of Business");
	}
	
	
	@Test(priority=7)
	public void TS007_VerifyInactiveAccountStatusNotValidBuyingAccountTest() throws InterruptedException
	{
		//The purpose of this test case to:-
		//CRM_T531_For deactivated Account with reason 'Not valid Buying Account', all associated Contacts(s) get deactivated
				
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		amro = new CRMAddMarketingRelationshipOwner(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Click on Account tab from left and select/view any account record
		hp.getAccountTab().click();
		cp.getGLetterFilterLink().click();
		String accountname = ap.getAccountName().getText();
		WebElement validateAccountName = driver.findElement(By.xpath("//label[contains(text(),'"+accountname+"')]"));
		validateAccountName.click();
		ap.getAccNaviagteBtn().click();

		//Click on Deactivate button
		ap.getDeactivateBtn().click();

		//Select Reason Code: Not valid Buying Account in the confirm Account Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		WebElement notvalidbuyingaccaccstatus = ap.getAccountStatusNotValidBuyingAcc();
		notvalidbuyingaccacc = ap.getAccountStatusNotValidBuyingAcc().getText();
		notvalidbuyingaccaccstatus.click();

		//Click on 'Deactivate button of confirmation pop-up
		ap.getDeactivateOkBtn().click();

		//Verify status reason of Account
		String verifyaccstatus= ap.getVerifyAccountStatusNotValidBuyingAccount().getText();
		System.out.println("Account Status Reason: "+ verifyaccstatus);
		Assert.assertEquals("Not valid Buying account", verifyaccstatus);
		
		//Go to associate Contacts linked with Account
		ap.getRelatedTab().click();
		Thread.sleep(3000);
		ap.getRelatedTabContactsItem().click();
		Thread.sleep(5000);
		ap.getContactAssociatedViewDropDownIcon().click();
		ap.getSelectViewsAllContactsItem().click();
		Thread.sleep(5000);
		
		//Verify status of associate Contact (when status of respective Account is Not valid Buying Account)
		ap.getContactsSectionContactName().click();
		WebElement contactstatus= ap.getContactsSectionContactNameStatusAsInactive();
		System.out.println("Contact Status: " + (contactstatus.getText()));
		Assert.assertEquals(contactstatus.getText(), "Inactive");
				
		ap.getAccNaviagteBtn().click();
				
		//Verify status reason of associate Contact (when status of respective Account is Not valid Buying Account)
		amro.gethdbtn().click();
		Thread.sleep(3000);
		WebElement statusforcontactasnotvalidbuyingacc = ap.getContactStatusReasonNotValidBuyingAccount();
		System.out.println("Contact Status Reason: " + (statusforcontactasnotvalidbuyingacc.getText()));
		Assert.assertEquals(statusforcontactasnotvalidbuyingacc.getText(), "Not a Valid Buying Account");
	}
	
	@Test(priority=8)
	public void TS008_VerifyInactiveAccountStatusReasonOnMainAccPageTest() throws InterruptedException
	{
		//The purpose of this test case to:-
		//CRM_T532_The inactive status reason gets displayed on the main Account page
		
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		amro = new CRMAddMarketingRelationshipOwner(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Click on Account tab from left and select/view any account record
		hp.getAccountTab().click();
		cp.getGLetterFilterLink().click();
		String accountname = ap.getAccountName().getText();
		WebElement validateAccountName = driver.findElement(By.xpath("//label[contains(text(),'"+accountname+"')]"));
		validateAccountName.click();
		ap.getAccNaviagteBtn().click();

		//Click on Deactivate button
		ap.getDeactivateBtn().click();

		//Select Reason Code: No Valid Info Available in the confirm Account Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		WebElement novalidaccinfoaccstatus = ap.getAccountStatusNoValidInfoAvailable();
		novalidaccinfoacc = ap.getAccountStatusNoValidInfoAvailable().getText();
		novalidaccinfoaccstatus.click();

		//Click on 'Deactivate button of confirmation pop-up
		ap.getDeactivateOkBtn().click();

		//Verify status reason of Account
		String verifyaccstatus= ap.getVerifyAccountStatusNoValidInfoAvailable().getText();
		System.out.println("Account Status Reason: "+ verifyaccstatus);
		Assert.assertEquals("No Valid Info Available", verifyaccstatus);
	}

	
	@Test(priority=10)
	public void TS010_VerifyDeactiveAccInInactiveAccViewTest() throws InterruptedException
	{
		//The purpose of this test case to:-
		//CRM_T534_Deactivated Account gets displayed in the Inactive Accounts view
				
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		amro = new CRMAddMarketingRelationshipOwner(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Click on Account tab from left and select/view any account record
		hp.getAccountTab().click();
		cp.getGLetterFilterLink().click();
		String accountname = ap.getAccountName().getText();
		System.out.println("Account name: "+accountname);
		WebElement validateAccountName = driver.findElement(By.xpath("//label[contains(text(),'"+accountname+"')]"));
		validateAccountName.click();
		ap.getAccNaviagteBtn().click();

		//Click on Deactivate button
		ap.getDeactivateBtn().click();

		//Select Reason Code: Not valid Buying Account in the confirm Account Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		WebElement notvalidbuyingaccaccstatus = ap.getAccountStatusNotValidBuyingAcc();
		notvalidbuyingaccacc = ap.getAccountStatusNotValidBuyingAcc().getText();
		notvalidbuyingaccaccstatus.click();

		//Click on 'Deactivate button of confirmation pop-up
		ap.getDeactivateOkBtn().click();

		//Verify status reason of Account
		String verifyaccstatus= ap.getVerifyAccountStatusNotValidBuyingAccount().getText();
		System.out.println("Account Status Reason: "+ verifyaccstatus);
		Assert.assertEquals("Not valid Buying account", verifyaccstatus);
		
		//Click on back button and go to inactive accounts
		ap.getPageBackBtn().click();
		Thread.sleep(3000);
		ap.getActiveAccDropDownBtn().click();
		ap.getInactiveAccOptn().click();
		Thread.sleep(5000);
		
		//Search by the account name
		cp.getGLetterFilterLink().click();
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(accountname);
		ap.getclicksearchbutton().click();
		Thread.sleep(5000);
		ap.getValidateInactiveAccName().click();
		ap.getAccNaviagteBtn().click();
		
		//Verify status reason of Account
		String verifydeactivatedaccstatus= ap.getVerifyAccountStatusNotValidBuyingAccount().getText();
		System.out.println("Status Reason of Deactivated Account: "+ verifydeactivatedaccstatus);
		Assert.assertEquals("Not valid Buying account", verifydeactivatedaccstatus);
	}
	@Test(priority=9)
	public void TS009_VerifyInactiveContactStatusReasonOnMainContactPageTest() throws InterruptedException
	{
		//The purpose of this test case to:-
		//CRM_T533_The inactive status reason get displayed on the main Contact page
				
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		amro = new CRMAddMarketingRelationshipOwner(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Click on Account tab from left and select/view any account record
		hp.getAccountTab().click();
		cp.getGLetterFilterLink().click();
		String accountname = ap.getAccountName().getText();
		WebElement validateAccountName = driver.findElement(By.xpath("//label[contains(text(),'"+accountname+"')]"));
		validateAccountName.click();
		ap.getAccNaviagteBtn().click();

		//Click on Deactivate button
		ap.getDeactivateBtn().click();

		//Select Reason Code: Out of Business in the confirm Account Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		WebElement outofbusinessaccstatus = ap.getAccountStatusOutOfBusiness();
		outofbusinessacc = ap.getAccountStatusOutOfBusiness().getText();
		outofbusinessaccstatus.click();

		//Click on 'Deactivate button of confirmation pop-up
		ap.getDeactivateOkBtn().click();

		//Verify status reason of Account
		String verifyaccstatus= ap.getVerifyAccountStatusOutOfBusiness().getText();
		System.out.println("Account Status Reason: "+ verifyaccstatus);
		Assert.assertEquals("Out of Business", verifyaccstatus);
		
		//Go to associate Contacts linked with Account
		ap.getRelatedTab().click();
		Thread.sleep(3000);
		ap.getRelatedTabContactsItem().click();
		Thread.sleep(5000);
		ap.getContactAssociatedViewDropDownIcon().click();
		ap.getSelectViewsAllContactsItem().click();
		Thread.sleep(5000);
		
		//Verify status of associate Contact (when status of respective Account is Out of Business)
		ap.getContactsSectionContactName().click();
		WebElement contactstatus= ap.getContactsSectionContactNameStatusAsInactive();
		System.out.println("Contact Status: " + (contactstatus.getText()));
		Assert.assertEquals(contactstatus.getText(), "Inactive");
				
		ap.getAccNaviagteBtn().click();
				
		//Verify status reason of associate Contact (when status of respective Account is Out of Business)
		amro.gethdbtn().click();
		Thread.sleep(3000);
		WebElement statusforcontactasoutofbusiness = ap.getContactStatusReasonOutOfBusiness();
		System.out.println("Contact Status Reason: " + (statusforcontactasoutofbusiness.getText()));
		Assert.assertEquals(statusforcontactasoutofbusiness.getText(), "Out of Business");
	}
	@Test(priority=11)
	public void TS011_VerifyMergedStatusReason() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS538- Verify that contact is deactivated successfully with status reason as Merged

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		amro = new CRMAddMarketingRelationshipOwner(driver);
		in = new CRMIncentivesPage(driver);

		hp.getContactsTab().click();
		Thread.sleep(15000);
		hp.getSearchContactField().click();
		hp.getSearchContactField().sendKeys(prop.getProperty("name"));
		hp.getstartsearch().click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement OpenContact = in.selectIncentiveRecord();
		action.doubleClick(OpenContact).perform();
		Thread.sleep(5000);
		
		//Click on Deactivate button
		cp.getDeactivateBtn().click();
		Thread.sleep(5000);
		
		//Select 'Contact Status: Merged' in the confirm Contact Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		Thread.sleep(5000);
		ap.getAccountStatusMerged().click();
		ap.getAccountStatusMerged().click();
		Thread.sleep(3000);
		
		//Click on 'Deactivate button of confirmation pop-up
		cp.getDeactivateOkBtn().click();
		Thread.sleep(5000);
		
		//Verify if contact is deactivated and Contact Status Reason is Merged
		Assert.assertTrue(cp.getreadonlynotification().isDisplayed());
		System.out.println("Contact is deactivated successfully.");
		Thread.sleep(5000);
		Assert.assertTrue(cp.getmergedstatusreason().getText().equals("Merged"));
		System.out.println("Contact Status Reason is updated successfully.");

	}
	@Test(priority=12)
	public void TS012_VerifyOutOfBusinessStatusReason() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS539- Verify that contact is deactivated successfully with status reason as Out Of Business

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		amro = new CRMAddMarketingRelationshipOwner(driver);
		in = new CRMIncentivesPage(driver);

		hp.getContactsTab().click();
		Thread.sleep(15000);
		hp.getSearchContactField().click();
		hp.getSearchContactField().sendKeys(prop.getProperty("name"));
		hp.getstartsearch().click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement OpenContact = in.selectIncentiveRecord();
		action.doubleClick(OpenContact).perform();
		Thread.sleep(5000);
		
		//Click on Deactivate button
		cp.getDeactivateBtn().click();
		Thread.sleep(5000);
		
		//Select 'Contact Status: Out of Business' in the confirm Contact Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		Thread.sleep(5000);
		ap.getAccountStatusOutOfBusiness().click();
		ap.getAccountStatusOutOfBusiness().click();
		Thread.sleep(3000);
		
		//Click on 'Deactivate button of confirmation pop-up
		cp.getDeactivateOkBtn().click();
		Thread.sleep(5000);
		
		//Verify if contact is deactivated and Contact Status Reason is Out of Business
		Assert.assertTrue(cp.getreadonlynotification().isDisplayed());
		System.out.println("Contact is deactivated successfully.");
		Thread.sleep(5000);
		Assert.assertTrue(cp.getmergedstatusreason().getText().equals("Out of Business"));
		System.out.println("Contact Status Reason is updated successfully.");

	}
	@Test(priority=13)
	public void TS013_VerifyNoValidAccountInfoStatusReason() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS540- Verify that contact is deactivated successfully with status reason as No Valid Account Info

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		amro = new CRMAddMarketingRelationshipOwner(driver);
		in = new CRMIncentivesPage(driver);

		hp.getContactsTab().click();
		Thread.sleep(15000);
		hp.getSearchContactField().click();
		hp.getSearchContactField().sendKeys(prop.getProperty("name"));
		hp.getstartsearch().click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement OpenContact = in.selectIncentiveRecord();
		action.doubleClick(OpenContact).perform();
		Thread.sleep(5000);
		
		//Click on Deactivate button
		cp.getDeactivateBtn().click();
		Thread.sleep(5000);
		
		//Select 'Contact Status: No Valid Account Info' in the confirm Contact Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		Thread.sleep(5000);
		cp.getContactStatusNoValidAccInfo().click();
		cp.getContactStatusNoValidAccInfo().click();
		Thread.sleep(3000);
		
		//Click on 'Deactivate button of confirmation pop-up
		cp.getDeactivateOkBtn().click();
		Thread.sleep(5000);
		
		//Verify if contact is deactivated and Contact Status Reason is Out of Business
		Assert.assertTrue(cp.getreadonlynotification().isDisplayed());
		System.out.println("Contact is deactivated successfully.");
		Thread.sleep(5000);
		Assert.assertTrue(cp.getmergedstatusreason().getText().equals("No Valid Account Info"));
		System.out.println("Contact Status Reason is updated successfully.");

	}
	@Test(priority=14)
	public void TS014_VerifyNotValidBuyingAccountStatusReason() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS541- Verify that contact is deactivated successfully with status reason as Not a Valid Buying Account 

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		amro = new CRMAddMarketingRelationshipOwner(driver);
		in = new CRMIncentivesPage(driver);

		hp.getContactsTab().click();
		Thread.sleep(15000);
		hp.getSearchContactField().click();
		hp.getSearchContactField().sendKeys(prop.getProperty("name"));
		hp.getstartsearch().click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement OpenContact = in.selectIncentiveRecord();
		action.doubleClick(OpenContact).perform();
		Thread.sleep(5000);
		
		//Click on Deactivate button
		cp.getDeactivateBtn().click();
		Thread.sleep(5000);
		
		//Select 'Contact Status: Not Valid Buying Account' in the confirm Contact Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		Thread.sleep(5000);
		cp.getContactStatusNotaValidBuyingAcc().click();
		cp.getContactStatusNotaValidBuyingAcc().click();
		Thread.sleep(3000);
		
		//Click on 'Deactivate button of confirmation pop-up
		cp.getDeactivateOkBtn().click();
		Thread.sleep(5000);
		
		//Verify if contact is deactivated and Contact Status Reason is Not Valid Buying Account
		Assert.assertTrue(cp.getreadonlynotification().isDisplayed());
		System.out.println("Contact is deactivated successfully.");
		Thread.sleep(5000);
		Assert.assertTrue(cp.getmergedstatusreason().getText().equals("Not a Valid Buying Account"));
		System.out.println("Contact Status Reason is updated successfully.");

	}
	@Test(priority=15)
	public void TS015_VerifyNoLongerWithAccountStatusReason() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS542- Verify that contact is deactivated successfully with status reason as No Longer with Valid

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		amro = new CRMAddMarketingRelationshipOwner(driver);
		in = new CRMIncentivesPage(driver);

		hp.getContactsTab().click();
		Thread.sleep(15000);
		hp.getSearchContactField().click();
		hp.getSearchContactField().sendKeys(prop.getProperty("name"));
		hp.getstartsearch().click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement OpenContact = in.selectIncentiveRecord();
		action.doubleClick(OpenContact).perform();
		Thread.sleep(5000);
		
		//Click on Deactivate button
		cp.getDeactivateBtn().click();
		Thread.sleep(5000);
		
		//Select 'Contact Status: No Longer With Account' in the confirm Contact Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		Thread.sleep(5000);
		cp.getnolongeracc().click();
		cp.getnolongeracc().click();
		Thread.sleep(3000);
		
		//Click on 'Deactivate button of confirmation pop-up
		cp.getDeactivateOkBtn().click();
		Thread.sleep(5000);
		
		//Verify if contact is deactivated and Contact Status Reason is No Longer With Account
		Assert.assertTrue(cp.getreadonlynotification().isDisplayed());
		System.out.println("Contact is deactivated successfully.");
		Thread.sleep(5000);
		Assert.assertTrue(cp.getmergedstatusreason().getText().equals("No Longer with Account"));
		System.out.println("Contact Status Reason is updated successfully.");

	}
	@Test(priority=16)
	public void TS016_VerifyBadContactInfoStatusReason() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS543- Verify that contact is deactivated successfully with status reason as Bad Contact Info

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		amro = new CRMAddMarketingRelationshipOwner(driver);
		in = new CRMIncentivesPage(driver);

		hp.getContactsTab().click();
		Thread.sleep(15000);
		hp.getSearchContactField().click();
		hp.getSearchContactField().sendKeys(prop.getProperty("name"));
		hp.getstartsearch().click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement OpenContact = in.selectIncentiveRecord();
		action.doubleClick(OpenContact).perform();
		Thread.sleep(5000);
		
		//Click on Deactivate button
		cp.getDeactivateBtn().click();
		Thread.sleep(5000);
		
		//Select 'Contact Status: Bad Contact Info' in the confirm Contact Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		Thread.sleep(5000);
		cp.getbadconinfo().click();
		cp.getbadconinfo().click();
		Thread.sleep(3000);
		
		//Click on 'Deactivate button of confirmation pop-up
		cp.getDeactivateOkBtn().click();
		Thread.sleep(5000);
		
		//Verify if contact is deactivated and Contact Status Reason is No Longer With Account
		Assert.assertTrue(cp.getreadonlynotification().isDisplayed());
		System.out.println("Contact is deactivated successfully.");
		Thread.sleep(5000);
		Assert.assertTrue(cp.getmergedstatusreason().getText().equals("Bad Contact Info"));
		System.out.println("Contact Status Reason is updated successfully.");

	}
	@Test(priority=17)
	public void TS017_VerifyStatusReasonAtContactAndAccount() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS544- Verify that Status Reason for deactivated contact is properly displayed at Account and Contact main page

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		in = new CRMIncentivesPage(driver);
		pl = new CRMPeoplePage(driver);

		hp.getContactsTab().click();
		Thread.sleep(15000);
		hp.getSearchContactField().click();
		hp.getSearchContactField().sendKeys(prop.getProperty("name"));
		Thread.sleep(2000);
		hp.getstartsearch().click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement OpenContact = in.selectIncentiveRecord();
		action.doubleClick(OpenContact).perform();
		Thread.sleep(10000);
		String alternativecontactid = cp.getcontactalternativeid().getText();
		
		//Click on Deactivate button
		cp.getDeactivateBtn().click();
		Thread.sleep(5000);
		
		//Select 'Contact Status: Out of Business' in the confirm Contact Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		Thread.sleep(5000);
		ap.getAccountStatusOutOfBusiness().click();
		ap.getAccountStatusOutOfBusiness().click();
		Thread.sleep(5000);
						
		//Click on 'Deactivate button of confirmation pop-up
		cp.getDeactivateOkBtn().click();
		Thread.sleep(5000);
		ap.getAccRefreshBtn().click();
		Thread.sleep(5000);
		
		//Search Contact and verify status reason
		hp.getContactsTab().click();
		Thread.sleep(15000);
		cp.getActiveContactsLabel().click();
		Thread.sleep(3000);
		cp.getInactiveContactOptn().click();
		Thread.sleep(5000);
		ap.getsearchaccounttextbox().click();
		Thread.sleep(3000);
		ap.getsearchaccounttextbox().sendKeys(alternativecontactid);
		ap.getclicksearchbutton().click();
		Thread.sleep(5000);
		Actions action1 = new Actions(driver);
		WebElement OpenContact1 = in.selectIncentiveRecord();
		action1.doubleClick(OpenContact1).perform();
		Thread.sleep(5000);
		utl.scrollToElement(cp.getjobtitle());
		Thread.sleep(3000);
		String AccountName = cp.getaccountatcontact().getText();
		String StatusReason = cp.getmergedstatusreason().getText();
		Thread.sleep(2000);
		System.out.println(AccountName);
		pl.getMoreHeaderFieldsBtn().click();
		Assert.assertEquals(cp.getstatusreasonmainpage().getText(), StatusReason);
		System.out.println("Status Reason is displayed properly at main Contact Page.");
		
		//Verify Status Reason at Account Main page
		hp.getAccountTab().click();
		Thread.sleep(15000);
		ap.getActiveAccountsLabel().click();
		Thread.sleep(2000);
		ap.getInactiveAccountsLabel().click();
		Thread.sleep(5000);
		ap.getsearchaccounttextbox().click();
		Thread.sleep(3000);
		ap.getsearchaccounttextbox().sendKeys(AccountName);
		Thread.sleep(3000);
		System.out.println(ap.getsearchaccounttextbox().getText());
		Thread.sleep(2000);
		ap.getclicksearchbutton().click();
		Thread.sleep(5000);
		Actions action2 = new Actions(driver);
		WebElement OpenAccount = in.selectIncentiveRecord();
		action2.doubleClick(OpenAccount).perform();
		Thread.sleep(5000);
		pl.getMoreHeaderFieldsBtn().click();
		Assert.assertEquals(cp.getstatusreasonmainpage().getText(), StatusReason);
		System.out.println("Status Reason is displayed properly at main Account Page.");
		
	}
	@Test(priority=18)
	public void TS018_VerifyDeactivatedContactAtAccountRelatedTab() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS545- Verify that deactivated contact is removed from Accounts Related Tab

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		in = new CRMIncentivesPage(driver);
		pl = new CRMPeoplePage(driver);

		hp.getContactsTab().click();
		Thread.sleep(15000);
		hp.getSearchContactField().click();
		hp.getSearchContactField().sendKeys(prop.getProperty("name"));
		Thread.sleep(2000);
		hp.getstartsearch().click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement OpenContact = in.selectIncentiveRecord();
		action.doubleClick(OpenContact).perform();
		Thread.sleep(10000);
		String alternativecontactid = cp.getcontactalternativeid().getText();
		utl.scrollToElement(cp.getjobtitle());
		Thread.sleep(3000);
		String AccountName = cp.getaccountatcontact().getText();
		
		//Click on Deactivate button
		cp.getDeactivateBtn().click();
		Thread.sleep(5000);
		
		//Select 'Contact Status: Out of Business' in the confirm Contact Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		Thread.sleep(5000);
		ap.getAccountStatusOutOfBusiness().click();
		ap.getAccountStatusOutOfBusiness().click();
		Thread.sleep(5000);
						
		//Click on 'Deactivate button of confirmation pop-up
		cp.getDeactivateOkBtn().click();
		Thread.sleep(5000);
				
		//Verify deactivated contact at Accounts Related tab
		hp.getAccountTab().click();
		Thread.sleep(15000);
		ap.getsearchaccounttextbox().click();
		Thread.sleep(3000);
		ap.getsearchaccounttextbox().sendKeys(AccountName);
		Thread.sleep(3000);
		ap.getclicksearchbutton().click();
		Thread.sleep(5000);
		Actions action2 = new Actions(driver);
		WebElement OpenAccount = in.selectIncentiveRecord();
		action2.doubleClick(OpenAccount).perform();
		Thread.sleep(5000);
		ap.getRelatedTab().click();
		ap.getRelatedTabContactsItem().click();
		Thread.sleep(5000);
		ap.getsearchaccounttextbox().click();
		Thread.sleep(3000);
		ap.getsearchaccounttextbox().sendKeys(alternativecontactid);
		Thread.sleep(3000);
		ap.getclicksearchbutton().click();
		Thread.sleep(3000);
		Assert.assertTrue(in.getNoDataAvailableText().isDisplayed());
		System.out.println("Contact Name is removed from Account successfully.");
	}
	@Test(priority=19)
	public void TS019_VerifyDeactivatedContactAtActiveInactiveContactGrid() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//TS546- Verify that deactivated contact is displayed under Inactive Contacts and not under Active Contacts

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		in = new CRMIncentivesPage(driver);
		pl = new CRMPeoplePage(driver);

		hp.getContactsTab().click();
		Thread.sleep(15000);
		hp.getSearchContactField().click();
		hp.getSearchContactField().sendKeys(prop.getProperty("name"));
		Thread.sleep(2000);
		hp.getstartsearch().click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement OpenContact = in.selectIncentiveRecord();
		action.doubleClick(OpenContact).perform();
		Thread.sleep(10000);
		String alternativecontactid = cp.getcontactalternativeid().getText();
				
		//Click on Deactivate button
		cp.getDeactivateBtn().click();
		Thread.sleep(5000);
		
		//Select 'Contact Status: Out of Business' in the confirm Contact Deactivation pop-up
		ap.getActivatePopupStatusField().click();
		Thread.sleep(5000);
		ap.getAccountStatusOutOfBusiness().click();
		ap.getAccountStatusOutOfBusiness().click();
		Thread.sleep(5000);
						
		//Click on 'Deactivate button of confirmation pop-up
		cp.getDeactivateOkBtn().click();
		Thread.sleep(5000);
				
		//Verify deactivated contact under Active Contacts
		ap.getAccPageBackBtn().click();
		Thread.sleep(5000);
		hp.getSearchContactField().click();
		hp.getSearchContactField().sendKeys(alternativecontactid);
		Thread.sleep(2000);
		hp.getstartsearch().click();
		Thread.sleep(5000);
		Assert.assertTrue(in.getNoDataAvailableText().isDisplayed());
		System.out.println("Deactivated Contact is not displayed under Active Contacts.");
		
		//Verify deactivated contact under Inactive Contacts
		cp.getActiveContactsLabel().click();
		Thread.sleep(2000);
		cp.getInactiveContactOptn().click();
		Thread.sleep(5000);
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(alternativecontactid);
		Thread.sleep(2000);
		ap.getclicksearchbutton().click();
		Thread.sleep(5000);
		Assert.assertTrue(ap.getValidateInactiveAccName().isDisplayed());
		System.out.println("Deactivated Contact is displayed under Inactive Contacts.");
		
	}
	
	//	@AfterTest
	//	public void closeDriver()
	//	{
	//		driver.close();
	//	}


}
