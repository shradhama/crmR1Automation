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
import org.testng.annotations.AfterSuite;
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
import resources.SendEmail;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class CAB269PageTest extends base{

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
	SendEmail se;
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		genData=new GenerateData();
		utl = new Utility(driver);
		utl.verifyLoginFunctionality(); //requires for Parallel text execution
	}

	@Test(priority=1)
	public void TS001_VerifyAlternativeContactIDTest() throws InterruptedException
	{
		//The purpose of this test case to:-
		//T566- Verify Alternative Contact ID for Contact entity

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		hp.getContactsTab().click();
		cp.getGLetterFilterLink().click();
		cp.selectContactName().click();
		ap.getAccNaviagteBtn().click();

		//Verify that Contact Alternative ID should be displayed in the header of Contact form
		Assert.assertTrue(cp.getContactAlternativeIdField().isDisplayed());
		
		//Navigate back to Active Contacts page
		ap.getPageBackBtn().click();
		
		//Get any Alternative Contact ID from Active Contacts grid
		String contactaltid = cp.getContactAlternativeIdValue().getAttribute("title");
		
		//Search for that Alternative Contact ID
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(contactaltid);
		ap.getclicksearchbutton().click();
		Thread.sleep(3000);
		
		//Verify the respective contact record
		Assert.assertTrue(cp.getContactAlternativeIdValue().getAttribute("title").contains(contactaltid));
		
		//Clear the search term
		hp.getClearSearch().click();
		
		//Verify that Alternative Contact ID field should be visible on Active Contacts view
		Assert.assertTrue(cp.getContactAltIdField().isDisplayed());
		
		//Click on the select a view drop-down available below header
		cp.getActiveContactDropDownBtn().click();
				
		//Select 'Inactive Contacts' option
		cp.getInactiveContactOptn().click();
		
		//Verify that Alternative Contact ID field should be visible on Inactive Contacts view
		Assert.assertTrue(cp.getContactAltIdField().isDisplayed());
		
		//Click on the select a view drop-down available below header
		cp.getActiveContactDropDownBtn().click();
		
		//Select All Contacts view option
		cp.getAllContactsOptn().click();
		
		//Verify that Alternative Contact ID field should be visible on All Contacts view
		Assert.assertTrue(cp.getContactAltIdField().isDisplayed());
	}
	
	//	@AfterTest
	//	public void closeDriver()
	//	{
	//		driver.close();
	//	}

	@AfterSuite
	public void sendEmail() 
	{
		se = new SendEmail();
		se.sendEmailWithAttachment();
	}

}
