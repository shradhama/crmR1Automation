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
}

