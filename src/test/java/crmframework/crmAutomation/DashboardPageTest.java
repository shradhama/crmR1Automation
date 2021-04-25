package crmframework.crmAutomation;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import pageObjects.CRMDashboardPage;
import pageObjects.CRMHomePage;
import pageObjects.CRMIncentiveDetailsPage;
import pageObjects.CRMIncentiveTab;
import pageObjects.CRMIncentivesPage;
import pageObjects.CRMLandingPage;
import pageObjects.CRMListManagementPage;
import pageObjects.CRMLoginPage;
import pageObjects.CRMPeoplePage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class DashboardPageTest extends base {

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
	CRMListManagementPage lmp;
	CRMDashboardPage dp;
	public String listNameText;
	
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
	public void TS002_VerifyRetailRelationManagerDashboardView() throws IOException, InterruptedException {

		//The purpose of this test case to verify:-
		//TS156- To verify the Retail Relations Manager Dashboard view 
		
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		in = new CRMIncentivesPage(driver);
		ind = new CRMIncentiveDetailsPage(driver);
		cp = new CRMContactPage(driver);
		dp= new CRMDashboardPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Click on Dashboard Tab at left menu
		dp.getDashboard().click();
		Thread.sleep(10000);

		//Click on dashboard selector and select Retail Relations Manager Dashboard option
		dp.selectdashboardExpandButton().click();
		Thread.sleep(5000);
		dp.selectRetailRelationsManagerDashboard().click();
		System.out.println("Retail Relations Manager Dashboard get opened");
		
		//Verify presence of Completed Calls Last Week section
		Assert.assertTrue(dp.selectCompletedCallsLastWeekLabel().isDisplayed());
		System.out.println("Completed Calls Last Week section is getting displayed");

		//Verify presence of Registrations(3 months prior-3months next) section
		Assert.assertTrue(dp.selectRegistrationsLabel().isDisplayed());
		System.out.println("Registrations(3 months prior-3months next) section is getting displayed");
		
		//Verify presence of Declined Calls section
		Assert.assertTrue(dp.selectDeclineCallsLabel().isDisplayed());
		System.out.println("Declined Calls section is getting displayed");
		
		//Verify presence of Incentive Details Created Last Week section
		Assert.assertTrue(dp.selectIncentiveDetailsCcreatedLastWeekLabel().isDisplayed());
		System.out.println("Incentive Details Created Last Week section is getting displayed");
		
		//Verify presence of Active Incentive Details section
		Assert.assertTrue(dp.selectActiveIncentiveDetails().isDisplayed());
		System.out.println("Active Incentive Details section is getting displayed");
		
		//Verify presence of Hotel Incentive section
		Assert.assertTrue(dp.selectHotelincentives().isDisplayed());
		System.out.println("Hotel Incentive section is getting displayed");
				
		//Verify values of X and Y axis label for Completed calls last week
		String CClastweek_X= dp.getCompletedCallsXaxisLabel().getText();
		String actualCC_X= prop.getProperty("Completedcallslastweek_Xaxis");
		Assert.assertEquals(CClastweek_X,actualCC_X);
		String CClastweek_Y= dp.getCompletedCallsYaxisLabel().getText();
		String actualCC_Y= prop.getProperty("Completedcallslastweek_Yaxis");
		Assert.assertEquals(CClastweek_Y,actualCC_Y);
		System.out.println("Values of X and Y axis label for Completed calls last week are: " +actualCC_X + " & " + actualCC_Y);
		
		//Verify values of X and Y axis values for Completed calls last week
		Assert.assertEquals(true, dp.getCompletedCallsXaxisValue().isDisplayed());
		Assert.assertEquals(true, dp.getCompletedCallsYaxisValue().isDisplayed());
		System.out.println("Values of X and Y axis for Completed calls last week are displaying");
				
		//Verify values of X and Y axis label for Registrations(3 months prior-3months next)
		String Registration_X= dp.getRegistrationsXaxisLabel().getText();
		String actualReg_X= prop.getProperty("Registration_Xaxis");
		Assert.assertEquals(Registration_X,actualReg_X);
		String Registration_Y= dp.getRegistrationsYaxisLabel().getText();
		String actualReg_Y= prop.getProperty("Registration_Yaxis");
		Assert.assertEquals(Registration_Y,actualReg_Y);
		System.out.println("Values of X and Y axis label for Registrations(3 months prior-3months next) are: " +Registration_X + " & " + Registration_Y);
		
		//Verify values of X and Y axis values for Registrations(3 months prior-3months next)
		Assert.assertEquals(true, dp.getRegistrationsXaxisValue().isDisplayed());
		Assert.assertEquals(true, dp.getRegistrationsYaxisValue().isDisplayed());
		System.out.println("Values of X and Y axis for Registrations(3 months prior-3months next) are displaying");
				
		//Verify values of X and Y axis label for Declined calls
		String Declinecalls_X= dp.getDeclineCallsXaxisLabel().getText();
		String actualDec_X= prop.getProperty("Decline_Xaxis");
		Assert.assertEquals(Declinecalls_X,actualDec_X);
		String Declinecalls_Y= dp.getDeclineCallsYaxisLabel().getText();
		String actualDec_Y= prop.getProperty("Decline_Yaxis");
		Assert.assertEquals(Declinecalls_Y,actualDec_Y);
		System.out.println("Values of X and Y axis label for Declined calls are: " +Declinecalls_X + " & " + Declinecalls_Y);
		
		//Verify values of X and Y axis values for Declined calls
		Assert.assertEquals(true, dp.getDeclineCallsXaxisValue().isDisplayed());
		Assert.assertEquals(true, dp.getDeclineCallsYaxisValue().isDisplayed());
		System.out.println("Values of X and Y axis for Declined calls are displaying");
				
		//Scroll down on the page
		act = new Actions(driver);
		act.moveToElement(dp.getActiveIncentiveDetailsXaxisLabel()).perform();
		
		//Verify values of X and Y axis label for Incentive Details Created Last Week		
        if(dp.getIncentiveDetailsNoDataAvailableMsg().isDisplayed())
        {
        	System.out.println("Incentive Details Created Last Week: No data available to display");
        }
        else	
        {   
        	String Incentivedetails_X= dp.getIncentiveDetailsXaxislabel().getText();
        	String actualIncDec_X= prop.getProperty("Activeincentivedetails_Xaxis");
        	String Incentivedetails_Y= dp.getIncentiveDetailsYaxislabel().getText();
        	String actualIncDec_Y= prop.getProperty("Activeincentivedetails_Yaxis");
			Assert.assertEquals(Incentivedetails_X,actualIncDec_X);
			Assert.assertEquals(Incentivedetails_Y,actualIncDec_Y);
		    System.out.println("Values of X and Y axis label for Incentive Details Created Last Week are: " +Incentivedetails_X + " & " + Incentivedetails_Y);
		}
		
        //Verify values of X and Y axis values for Incentive Details Created Last Week
        if(dp.getIncentiveDetailsNoDataAvailableMsg().isDisplayed())
        {
        	System.out.println("Incentive Details Created Last Week: No data available to display");
        }
        else
        {
      		Assert.assertEquals(true, dp.getIncentiveDetailsXaxisValue().isDisplayed());
      		Assert.assertEquals(true, dp.getIncentiveDetailsYaxisValue().isDisplayed());
      		System.out.println("Values of X and Y axis for Incentive Details Created Last Week are displaying");
        }
        
        //Verify values of X and Y axis label for Active Incentive Details
		String ActiveiIncentivedetails_X= dp.getActiveIncentiveDetailsXaxisLabel().getText();
		String actualActInc_X= prop.getProperty("Activeincentivedetails_Xaxis");
		Assert.assertEquals(ActiveiIncentivedetails_X,actualActInc_X);
		String ActiveiIncentivedetails_Y= dp.getActiveIncentiveDetailsYaxisLabel().getText();
		String actualActInc_Y= prop.getProperty("Activeincentivedetails_Yaxis");
		Assert.assertEquals(ActiveiIncentivedetails_Y,actualActInc_Y);
		System.out.println("Values of X and Y axis label for Active Incentive Details are: " +ActiveiIncentivedetails_X + " & " + ActiveiIncentivedetails_Y);
		
		//Verify values of X and Y axis values for Active Incentive Details
		Assert.assertEquals(true, dp.getActiveIncentiveDetailsXaxisValue().isDisplayed());
		Assert.assertEquals(true, dp.getActiveIncentiveDetailsYaxisValue().isDisplayed());
		System.out.println("Values of X and Y axis for Active Incentive Details are displaying");

		//Verify the details getting displayed for Hotel Incentive Section
		String Hotelinsentive_account= dp.getHotelIncentiveAccount().getText();
		Assert.assertEquals(Hotelinsentive_account,prop.getProperty("HotelIncentive_Account"));
		String Hotelinsentive_contact= dp.getHotelIncentiveCount().getText();
		Assert.assertEquals(Hotelinsentive_contact,prop.getProperty("HotelIncentive_Contact"));
		String Hotelinsentive_market= dp.getHotelIncentiveMarket().getText();
		Assert.assertEquals(Hotelinsentive_market,prop.getProperty("HotelIncentive_Market"));
		System.out.println("Name of the columns for Hotel Incentive Section are getting displayed: Account, Contact, Market");		
	}

	@Test(priority=3)
	public void TS003_VerifyRetailRelationsMrktMngrIncnHotelBookedViewTest() throws IOException, InterruptedException {

		//The purpose of this test case:-
		//T155- To verify Retail Relations Manager can view daily report of hotel usage and 
		//total incentives offered

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		dp = new CRMDashboardPage(driver);
 		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 		
 		//Navigate to Dashboard under Home in left menu
 		dp.getDashboard().click();
 		
 		//Click on the dashboard selector to view system dashboard
 		dp.selectdashboardExpandButton().click();
		
 		//click on Retail Relations Manager Dashboard
		dp.selectRetailRelationsManagerDashboard().click();
 		
		//Verify that Retail ReLAtions Manager Dashboard should be displayed
		Assert.assertTrue(dp.getRetailRealtionManagerDashboardLabel().isDisplayed());
		
		//Scroll down on the page
		utl.scrollToElement(dp.getPhoneCallsOwnerLabel());
		utl.scrollToElement(dp.getIncByOwnerByCatgLabel());
				
		//Verify the 'Incentives Details created last week by Owner by Category' section(4th Section)
		List<WebElement> nodataavailtxt = dp.getNoDataAvailText();
		if (nodataavailtxt.size()!= 0) {
			System.out.println("Incentive Details are not available");
		}
		else {
			String Incentivedetails_X= dp.getIncentiveDetailsXaxislabel().getText();
        	String actualIncDec_X= prop.getProperty("Incentivedetails_Xaxis");
        	String Incentivedetails_Y= dp.getIncentiveDetailsYaxislabel().getText();
        	String actualIncDec_Y= prop.getProperty("Incentivedetails_Yaxis");
			Assert.assertEquals(Incentivedetails_X,actualIncDec_X);
			Assert.assertEquals(Incentivedetails_Y,actualIncDec_Y);
		    System.out.println("Values of X and Y axis label for Incentive Details Created Last Week are: " +Incentivedetails_X + " & " + Incentivedetails_Y);
		}
		
		//Verify the below in Active Incentive Details by Est. Value by Category section(5th Section)
		//Verify values of X and Y axis label for Active Incentive Details
		
		String ActiveiIncentivedetails_X= dp.getActiveIncentiveDetailsXaxisLabel().getText();
		String actualActInc_X= prop.getProperty("Activeincentivedetails_Xaxis");
		Assert.assertEquals(ActiveiIncentivedetails_X,actualActInc_X);
		String ActiveiIncentivedetails_Y= dp.getActiveIncentiveDetailsYaxisLabel().getText();
		String actualActInc_Y= prop.getProperty("Activeincentivedetails_Yaxis");
		Assert.assertEquals(ActiveiIncentivedetails_Y,actualActInc_Y);
		System.out.println("Values of X and Y axis label for Active Incentive Details are: " +ActiveiIncentivedetails_X + " & " + ActiveiIncentivedetails_Y);
		
		//Verify values of X and Y axis values for Active Incentive Details
		Assert.assertEquals(true, dp.getActiveIncentiveDetailsXaxisValue().isDisplayed());
		Assert.assertEquals(true, dp.getActiveIncentiveDetailsYaxisValue().isDisplayed());
		System.out.println("Values of X and Y axis for Active Incentive Details are displaying");
		
		//Verify the details getting displayed for Hotel Incentive Section
		String Hotelinsentive_account= dp.getHotelIncentiveAccount().getText();
		Assert.assertEquals(Hotelinsentive_account,prop.getProperty("HotelIncentive_Account"));
		String Hotelinsentive_contact= dp.getHotelIncentiveCount().getText();
		Assert.assertEquals(Hotelinsentive_contact,prop.getProperty("HotelIncentive_Contact"));
		String Hotelinsentive_market= dp.getHotelIncentiveMarket().getText();
		Assert.assertEquals(Hotelinsentive_market,prop.getProperty("HotelIncentive_Market"));
		System.out.println("Name of the columns for Hotel Incentive Section are getting displayed: Account, Contact, Market");	

	}
}
