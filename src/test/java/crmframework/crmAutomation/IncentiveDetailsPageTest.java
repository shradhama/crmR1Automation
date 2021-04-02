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
import pageObjects.CRMIncentiveDetailsPage;
import pageObjects.CRMIncentiveTab;
import pageObjects.CRMIncentivesPage;
import pageObjects.CRMLandingPage;
import pageObjects.CRMLoginPage;
import pageObjects.CRMPeoplePage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class IncentiveDetailsPageTest extends base {

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
	CRMIncentivesPage in;
	CRMIncentiveDetailsPage ind;


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
	public void TS002_VerifyCreateIncentiveDetailsFromExistingIncentiveTest() throws InterruptedException 
	{
		//The purpose of this test case to:-
		//T105- Verify that user is able to create incentive detail in existing incentive

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		in = new CRMIncentivesPage(driver);
		ind = new CRMIncentiveDetailsPage(driver);
		cp = new CRMContactPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Incentives Tab at left menu and search incentives containing Cyb
		hp.getincentivedetailstab().click();
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("name"));
		ap.getclicksearchbutton().click();

		//Open existing incentive
		Actions action = new Actions(driver);
		WebElement OpenIncentive = cp.getopencontact();
		action.doubleClick(OpenIncentive).perform();
		
		//Open new Incentive Detail page
		ind.getopenincdetoptions().click();
		ind.getclicknewincdet().click();
		
		//Select Incentive Category
		Thread.sleep(5000);
		ind.getinccatdd().click();
		Thread.sleep(2000);
		ind.getinccatsearch().click();
		Thread.sleep(3000);
		ind.getselectinccat().click();
		Thread.sleep(2000);
		
		//Click on Save and Close button
		ind.getsaveincdet().click();
		Thread.sleep(15000);

		//Verify if Incentive Details are properly added
		Assert.assertTrue(ind.getverifyincdet().getText().contains(prop.getProperty("incentive")));
		
		//Navigate back to Active accounts list
		ap.getPageBackBtn().click();
	}
	@Test(priority=3)
	public void TS003_VerifyGroupByOptionsIncentiveDetailsTest() throws InterruptedException
	{
		//The purpose of this test case to verify:-
		//CRM-T453- Verify Group By options for Contact

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
		hp = new CRMHomePage(driver);
		cp = new CRMContactPage(driver);
		ap = new CRMAccountsPage(driver);
		ind = new CRMIncentiveDetailsPage(driver);

		//Click on Contacts tab from left menu and search contacts containing Cyb
		hp.getincentivedetailstab().click();

		//Open Group By drop down list options
		cp.getclickgroupbydd().click();

		//Select Name option from Group By drop down list
		cp.getfullnameddopt().click();

		//Verify if records are grouped by Full Name
		Assert.assertTrue(cp.getgroupbyverification().isDisplayed(), "Group by Name is not working.");
		System.out.println("Group by Name is working properly.");

		//Open Group By drop down list options
		cp.getclickgroupbydd().click();

		//Select Contact option from Group By drop down list
		ind.getcontactddopt().click();

		//Verify if records are grouped by Contact
		Assert.assertTrue(cp.getgroupbyverification().isDisplayed(), "Group by Contact is not successful.");
		System.out.println("Group by Contact is working properly.");
		
		//Open Group By drop down list options
		cp.getclickgroupbydd().click();

		//Select Market option from Group By drop down list
		ind.getmarketddopt().click();

		//Verify if records are grouped by Market 
		Assert.assertTrue(cp.getgroupbyverification().isDisplayed(), "Group by Market is not successful.");
		System.out.println("Group by Market is working properly.");
		
		//Open Group By drop down list options
		cp.getclickgroupbydd().click();

		//Select Account option from Group By drop down list
		ind.getaccountddopt().click();

		//Verify if records are grouped by Account
		Assert.assertTrue(cp.getgroupbyverification().isDisplayed(), "Group by Account is not successful.");
		System.out.println("Group by Account is working properly.");
				
		//Open Group By drop down list options
		cp.getclickgroupbydd().click();

		//Select Incentive Category option from Group By drop down list
		ind.getinccatddopt().click();

		//Verify if records are grouped by Incentive Category
		Assert.assertTrue(cp.getgroupbyverification().isDisplayed(), "Group by Incentive Category is not successful.");
		System.out.println("Group by Incentive Category is working properly.");
		
		//Open Group By drop down list options
		cp.getclickgroupbydd().click();

		//Select Estimated Value option from Group By drop down list
		ind.getestvalddopt().click();

		//Verify if records are grouped by Estimated Value
		Assert.assertTrue(cp.getgroupbyverification().isDisplayed(), "Group by Estimated Value is not successful.");
		System.out.println("Group by Estimated Value is working properly.");
		

		//Open Group By drop down list options
		cp.getclickgroupbydd().click();

		//Select Incentive Detail Status option from Group By drop down list
		ind.getstatusddopt().click();

		//Verify if records are grouped by Incentive Detail Status
		Assert.assertTrue(cp.getgroupbyverification().isDisplayed(), "Group by Incentive Detail Status is not successful.");
		System.out.println("Group by Incentive Detail Status is working properly.");
	}

}
