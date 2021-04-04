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
		hp.getincentivestab().click();
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
		System.out.println("Incentive Details added successfully.");
		
		//Navigate back to Incentive Details list
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
	@Test(priority=4)
	public void TS004_VerifyGridFiltersIncentiveDetailsTest() throws InterruptedException
	{
		//The purpose of this test case:-
		//CRM-T452- Verify filters on Incentive Details Grid

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		pl = new CRMPeoplePage(driver);
		cp = new CRMContactPage(driver);
		in = new CRMIncentivesPage(driver);
		ind = new CRMIncentiveDetailsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Incentives Tab at left menu 
		hp.getincentivedetailstab().click();
		Thread.sleep(3000);
		
		//Select Active Incentive Details option
		ind.getclickarrowforactiveincentive().click();
		Thread.sleep(3000);
		ind.getselectactivetype().click();

		//Click funnel for Account column
		in.getaccountcolumn().click();
		ap.getclickfunnelfilter().click();
		Thread.sleep(3000);
		
		//Select filter options
		ap.getclickoperatordd().click();
		ind.getfilterop().click();
		ind.getfiltervalue().sendKeys(prop.getProperty("incdetacc"));
		ap.getselectregionvalue().click();
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify Account value selected on grid
		WebElement Account = null;
		for (int i=0;i<1;i++)
		{
			Account = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-7']"));
			Assert.assertTrue(Account.getText().contains(prop.getProperty("incdetacc")));
		}
		System.out.println("Account matches expected criteria");

		//Clear Filter for Account
		in.getaccountcolumn().click();
		ap.getclearfiltergrid().click();

		//Click funnel for Contact column
		in.getcontactcolumn().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		ind.getfilterop().click();
		ind.getfiltervalue().sendKeys(prop.getProperty("incdetcon"));
		ap.getselectregionvalue().click();
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify Contact value selected on accounts grid
		WebElement Contact = null;
		for (int i=0;i<3;i++)
		{
			Contact = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']"));
			Assert.assertTrue(Contact.getText().contains(prop.getProperty("incdetcon")));
		}
		System.out.println("Contact matches expected criteria");

		//Clear Filter for Contact
		in.getcontactcolumn().click();
		ap.getclearfiltergrid().click();
		
		//Click funnel for Market column
		in.getmarketcolumn().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		ind.getfilterop().click();
		ind.getfiltervalue().sendKeys(prop.getProperty("searchmarketinc"));
		ap.getselectregionvalue().click();
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify Market value selected on accounts grid
		WebElement Market = null;
		for (int i=0;i<7;i++)
		{
			Market = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-3']"));
			Assert.assertTrue(Market.getText().contains(prop.getProperty("searchmarketinc")));
		}
		System.out.println("Market matches expected criteria");

		//Clear Filter for Market
		in.getmarketcolumn().click();
		ap.getclearfiltergrid().click();
		Thread.sleep(3000);
		
		//Click funnel for Incentive Category column
		ind.getinccat().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		ind.getfilterop().click();
		ind.getfiltervalue().sendKeys(prop.getProperty("incdetcat"));
		ap.getselectregionvalue().click();
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify Incentive Category value selected on grid
		WebElement IncCat = null;
		for (int i=0;i<7;i++)
		{
			IncCat = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-4']"));
			Assert.assertTrue(IncCat.getText().contains(prop.getProperty("incdetcat")));
		}
		System.out.println("Incentive Category matches expected criteria");
		Thread.sleep(3000);
		
		//Clear Filter for Incentive Category
		ind.getinccat().click();
		ap.getclearfiltergrid().click();
		Thread.sleep(3000);
				
		//Click funnel for Estimated Value column
		ind.getincestval().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		ind.getfilterop().click();
		Thread.sleep(2000);
		ind.getfiltervalue().click();
		Thread.sleep(2000);
		ind.getfiltervalue().sendKeys(prop.getProperty("incdetestval"));
		ap.getselectregionvalue().click();
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify Estimated Value value selected on accounts grid
		WebElement EstVal = null;
		for (int i=0;i<7;i++)
		{
			EstVal = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-5']"));
			Assert.assertTrue(EstVal.getText().contains(prop.getProperty("incdetestval")));
		}
		System.out.println("Estimated Value matches expected criteria");
		Thread.sleep(3000);
		
		//Clear Filter for Estimated Value
		ind.getincestval().click();
		ap.getclearfiltergrid().click();
		Thread.sleep(3000);
		
		//Click funnel for Status column
		ind.getincstatus().click();
		ap.getclickfunnelfilter().click();

		//Select filter options
		ap.getclickoperatordd().click();
		ind.getfilterop().click();
		ind.getfiltervalue().sendKeys(prop.getProperty("incdetstatus"));
		ap.getselectregionvalue().click();
		ap.getclickapplybutton().click();
		Thread.sleep(5000);

		//Verify Status value selected on grid
		WebElement Status = null;
		for (int i=0;i<7;i++)
		{
			Status = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-6']"));
			Assert.assertTrue(Status.getText().contains(prop.getProperty("incdetstatus")));
		}
		System.out.println("Status matches expected criteria");
		Thread.sleep(3000);
		
		//Clear Filter for Status
		ind.getincstatus().click();
		ap.getclearfiltergrid().click();

	}
	@Test(priority=5)
	public void TS005_VerifyUpdateIncentiveDetailsTest() throws InterruptedException
	{
		//The purpose of this test case:-
		//CRM-T452- Verify filters on Incentive Details Grid

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		pl = new CRMPeoplePage(driver);
		cp = new CRMContactPage(driver);
		in = new CRMIncentivesPage(driver);
		ind = new CRMIncentiveDetailsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Incentives Tab at left menu 
		hp.getincentivedetailstab().click();
		Thread.sleep(5000);
		
		//Select Active Incentive Details option
		ind.getclickarrowforactiveincentive().click();
		Thread.sleep(3000);
		ind.getselectactivetype().click();
		Thread.sleep(5000);
		
		//Open existing incentive
		Actions action = new Actions(driver);
		WebElement OpenIncentive = in.selectIncentiveRecord();
		action.doubleClick(OpenIncentive).perform();
		
		//Update already selected incentive
		Actions inc = new Actions(driver);
		inc.moveToElement(ind.getselectedincentive()).perform();
		ind.getdeleteinc().click();
		ind.getsearchinc().click();
		ind.getselectinc().click();
		Thread.sleep(3000);
		
		//Update already selected incentive category
		Actions inccat = new Actions(driver);
		inccat.moveToElement(ind.getselectedinccat()).build().perform();
		ind.getdeleteinccat().click();
		ind.getsearchinccat().click();
		ind.getselinccat().click();
		Thread.sleep(5000);
		
		//Save incentive details
		ap.getAccSaveBtn().click();;
		Thread.sleep(3000);
		
		//Refresh record and verify if incentive details are updated properly
		ap.getAccRefreshBtn().click();
		Assert.assertEquals(in.getIncentiveNameOnIncForm().getText(), ind.getselectedincentive().getText()+" - "+ind.getselectedinccat().getText());
		System.out.println("Incentive Details are updated successfully.");
		
		//Navigate back to Incentive Details list
		ap.getPageBackBtn().click();
		
	}
		

}
