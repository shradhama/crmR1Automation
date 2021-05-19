package crmframework.crmAutomation;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
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
import pageObjects.CRMActivitiesPage;
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
	CRMActivitiesPage actp;
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
		Thread.sleep(50000);
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
        if(dp.getIncentiveDetailsValueCheck().isDisplayed())
        {
        	String Incentivedetails_X= dp.getIncentiveDetailsXaxislabel().getText();
        	String actualIncDec_X= prop.getProperty("Incentivedetails_Xaxis");
        	String Incentivedetails_Y= dp.getIncentiveDetailsYaxislabel().getText();
        	String actualIncDec_Y= prop.getProperty("Incentivedetails_Yaxis");
			Assert.assertEquals(Incentivedetails_X,actualIncDec_X);
			Assert.assertEquals(Incentivedetails_Y,actualIncDec_Y);
		    System.out.println("Values of X and Y axis label for Incentive Details Created Last Week are: " +Incentivedetails_X + " & " + Incentivedetails_Y);
        }
        else	
        {   
        	Assert.assertTrue(dp.getIncentiveDetailsNoDataAvailableMsg().isDisplayed());
            System.out.println("Incentive Details Created Last Week: No data available to display");
        	
		}
		
        //Verify values of X and Y axis values for Incentive Details Created Last Week
        if(dp.getIncentiveDetailsValueCheck().isDisplayed())
        {
        	Assert.assertEquals(true, dp.getIncentiveDetailsXaxisValue().isDisplayed());
      		Assert.assertEquals(true, dp.getIncentiveDetailsYaxisValue().isDisplayed());
      		System.out.println("Values of X and Y axis for Incentive Details Created Last Week are displaying");
        }
        else
        {
        	Assert.assertTrue(dp.getIncentiveDetailsNoDataAvailableMsg().isDisplayed());
        	System.out.println("Incentive Details Created Last Week: No data available to display");
      		
        }		
		
/*		
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
 */       
        
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
	
	@Test(priority=4)
	public void TS004_VerifyCallCenterDashboardRepTest() throws IOException, InterruptedException {

		//The purpose of this test case to verify:-
		//TS140- Verify Call Center Dashboard Rep 

		dp = new CRMDashboardPage(driver);
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		actp = new CRMActivitiesPage(driver);
		
		//Navigate to Activities under Home in left menu
		hp.getActivitiesTab().click();
		Thread.sleep(10000);
				
		//Click on Phone Call available in the header section
		actp.getPhoneCallOptnInHeader().click();
		Thread.sleep(5000);
		
		//Enter the required details
		actp.getSubjectTextBox().click();
		actp.getSubjectTextBox().sendKeys("CybPhoneCall_" +genData.generateRandomString(3));
						
		actp.getCallToFieldTxtBox().click();
		actp.selectRecordInCallToField().click();
		actp.getCallToFieldLabel().click();
				
		actp.getRegardingFieldTxtBox().click();
		Thread.sleep(3000);
		actp.selectRecordInRegardingField().click();
		actp.getRegardingFieldLabel().click();
		ap.getclickphonecallduedatecalendor().click();
		ap.getphonecallduedatecurrent().click();
		Thread.sleep(3000);
				
		//Click on Save button
		ap.getAccSaveBtn().click();
		ap.getAccPageBackBtn();
		//actp.getSavenCloseBtnOnApptForm().click();
		
		//Save Subject and Regarding values in a string
		String phonecallname = actp.getSubjectTextBox().getAttribute("Value");
		System.out.println("Newly created Phone Call name: "+ phonecallname);
		String regardingvalue = actp.getregardingvalue().getText();
		System.out.println("Newly created Phone Call name: "+ regardingvalue);
		
		//Open Dashboards tab from left menu
		hp.getdashboardstab().click();
		Thread.sleep(5000);
		
		//Click arrow for System Dashboard and select Call Center Rep Dashboard
		dp.getselectdashbaord().click();
		Thread.sleep(3000);
		dp.getselectcallcenrepdashbaord().click();
		Thread.sleep(3000);
		dp.getclickdropdownfirstsection().click();
		Thread.sleep(3000);
		dp.getselectoption().click();
		Thread.sleep(5000);
		
		//Verify results in first section
		/*if (dp.getnodatasymbolfirstsection().isDisplayed()) {
			Assert.assertTrue(dp.getnodataavailable().isDisplayed());
			System.out.println("Data is not available.");
		}
		else {
			Assert.assertTrue(dp.getphcallsubject().equals(phonecallname));
			Assert.assertTrue(dp.getphcallregarding().equals(regardingvalue));
			System.out.println("Phone Call is displayed properly in first section.");
		}*/
		
		Assert.assertTrue(dp.getphcallsubject().getText().contains(phonecallname));
		//Assert.assertTrue(dp.getphcallsubject().getText().contains(regardingvalue));
		System.out.println("Phone Call is displayed properly in first section.");
		Thread.sleep(5000);
		
		//Open drop down for second section
		dp.getclickdropdownsecondection().click();
		Thread.sleep(5000);
		dp.getselectoption().click();
		Thread.sleep(5000);
		
		//Verify results in second section
		/*if (dp.getnodatasymbolsecondsection().isDisplayed()) {
			Assert.assertTrue(dp.getnodataavailable().isDisplayed());
			System.out.println("Data is not available.");
		}
		else {
			
			Assert.assertTrue(dp.getchartspace().isDisplayed());
			System.out.println("Phone Call is displayed properly in second section.");
		}*/
		
		Assert.assertTrue(dp.getchartspace().isDisplayed());
		System.out.println("Phone Call is displayed properly in second section.");
		Thread.sleep(3000);
		
		//Click More commands button
		ap.getclickoverflowbutton().click();
		
		//Click View Records button
		dp.getviewrecordsbtn().click();
		
		//Verify if phone call records are displayed on the page
		Assert.assertTrue(dp.getgrid().isDisplayed());
		System.out.println("Phone Call records are displayed in the grid.");
		
		//Verify sorting for each column in grid
		dp.getcalltocol().click();
		Assert.assertFalse(dp.getsortatozbtn().isEnabled());
		Assert.assertFalse(dp.getsortztoabtn().isEnabled());
		System.out.println("Sort option is disabled.");
		
		dp.getphnocol().click();
		dp.getsortatozbtn().click();
	}
	@Test(priority=5)
	public void TS005_VerifyMyActivitiesTest() throws IOException, InterruptedException {

		//The purpose of this test case to verify:-
		//TS140- Verify My Open Tasks in My Activity Dahboard 

		dp = new CRMDashboardPage(driver);
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		cp = new CRMContactPage(driver);
		actp = new CRMActivitiesPage(driver);
		in = new CRMIncentivesPage(driver);
		
		//Navigate to Activities under Home in left menu
		hp.getActivitiesTab().click();
		Thread.sleep(10000);
		
		//Click on Task in the header to create new Task
		actp.getTaskOptnInHeader().click();
		
		//Enter required data
		actp.getSubjectTextBox().click();
		actp.getSubjectTextBox().sendKeys("CybTask_" + genData.generateRandomString(3));
		String taskname = actp.getSubjectTextBox().getAttribute("Value");
		System.out.println("Newly created task name: "+ taskname);
				
		actp.getRegardingFieldTxtBox().click();
		dp.gettaskregardingsearch().click();
		dp.getselectregardingfortask().click();
		actp.getRegardingFieldLabel().click();
		dp.getheaderoverflow().click();
		//ap.getclickphonecallduedatecalendor().click();
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 7);
		Date duedate = cal.getTime();
		String newdate = dateFormat.format(duedate);
		System.out.println("Due Date = "+ newdate);
		
		actp.getDueDateTextBox().click();
		actp.getDueDateTextBox().click();
		actp.getDueDateTextBox().sendKeys(newdate.toString());
		Thread.sleep(3000);
		//dp.getselecttaskdudate().click();
		//dp.getheaderoverflow().click();
				
		//Click on Save & Close button
		ap.getAccSaveCloseBtn().click();
		
		//Open Dashboards tab from left menu
		hp.getdashboardstab().click();
		//Thread.sleep(5000);
				
		//Click arrow for System Dashboard and select My Activities Dashboard
		dp.getselectdashbaord().click();
		//Thread.sleep(3000);
		dp.getactivitydashboard().click();
		Thread.sleep(5000);
		
		//Scroll to My Tasks view
		utl.scrollToElement(dp.getnodataavailable());
		//utl.scrollToElement(dp.getmytaskview());
		Thread.sleep(3000);
		
		//Search subject for newly added task
		dp.getSearchFieldOpentTasks().click();
		dp.getSearchFieldOpentTasks().sendKeys(taskname);
		dp.getOpenTasksStartSearchBtn().click();
		Thread.sleep(4000);
		
		//Verify if task name is displayed in the grid
		Assert.assertTrue(dp.getValidateOpenTaskInSearchRslts().getAttribute("title").contains(taskname));
		System.out.println("Task added succefully.");
		Thread.sleep(3000);
		
		//Verify chart for My tasks is displayed properly
		Assert.assertTrue(dp.getmytasktitleforchart().isDisplayed());
		Assert.assertTrue(dp.getchartspace().isDisplayed());
		System.out.println("Chart is properly displayed for tasks.");
		
		//Open Task and verify details on dashboard		
		dp.getValidateOpenTaskInSearchRslts().click();
		Thread.sleep(4000);
		//Store Values for task details 
		String TaskSubject = actp.getSubjectTextBox().getAttribute("value");
		String TaskDescription = dp.gettaskdesc().getText();
		String TaskRegarding = actp.openRegardingFieldText().getText();
		String TaskDueDate = dp.gettaskduedate().getText();
		Thread.sleep(10000);
		
		ap.getPageBackBtn().click();
		//Verify task details with task in dashboard grid
		utl.scrollToElement(dp.getnodataavailable());
		Thread.sleep(3000);
		dp.getSearchFieldOpentTasks().click();
		dp.getSearchFieldOpentTasks().sendKeys(taskname);
		dp.getOpenTasksStartSearchBtn().click();
		Thread.sleep(3000);
		Assert.assertEquals(ap.getAccountNameSearchTable().getAttribute("title"), TaskDueDate);
		Assert.assertEquals(ap.getPhoneinSearchTable().getAttribute("title"), TaskRegarding);
		Assert.assertEquals(dp.getValidateOpenTaskInSearchRslts().getAttribute("title"), TaskSubject);
		Assert.assertEquals(ap.getContactsSectionMobilePhoneField().getAttribute("title"), TaskDescription);
		System.out.println("Task Details are properly displayed at Dashboard.");
		
		utl.scrollToElement(dp.getOpenTasksNext7DaysLabel());
		utl.scrollToElement(dp.getCountAllTaskLabel());
		
		//Verify Due Date in Charts section
		Assert.assertTrue(dp.getduedateinchartfortask().isDisplayed());
		System.out.println("Due Date is properly displayed in Charts section for My Tasks at Dashboard.");
	}
}
