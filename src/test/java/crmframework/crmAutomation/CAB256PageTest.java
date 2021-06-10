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
	public void TS008_VerifyDeactiveAccInInactiveAccViewTest() throws InterruptedException
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




	
	
	//	@AfterTest
	//	public void closeDriver()
	//	{
	//		driver.close();
	//	}


}
