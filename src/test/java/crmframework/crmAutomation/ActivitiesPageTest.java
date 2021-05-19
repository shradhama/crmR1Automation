package crmframework.crmAutomation;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
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
public class ActivitiesPageTest extends base {

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
	public void TS002_VerifyCreateAppointmentTest() throws InterruptedException
	{
		//The purpose of this test case to:-
		//CRM-T485- Verify Creation of Appointment under Activities

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		actp = new CRMActivitiesPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Navigate to Activities under Home in left menu
		hp.getActivitiesTab().click();
		Thread.sleep(5000);
		
		//Verify that be default My Activities page is displayed
		Assert.assertTrue(actp.getMyActivitiesLabel().isDisplayed());
				
		//Click on Appointment option from the header
		actp.getAppointmentOptnInHeader().click();
		
		//Verify that New Appointment form page should be displayed
		Assert.assertTrue(actp.getNewAppointmentFormTitle().isDisplayed());
		
		//Enter the required details
		actp.getRequiredFieldTxtBox().click();
		actp.selectRecordInRequiredfField().click();
		actp.getRequiredFieldLabel().click();
		
		actp.getSubjectTextBox().click();
		actp.getSubjectTextBox().sendKeys("CybAppt_" + genData.generateRandomString(3));
		String apptname = actp.getSubjectTextBox().getAttribute("Value");
		System.out.println("Newly created appointment name: "+ apptname);
		
		//Select/enter Start Date/End Date
		DateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,2);
		Date duedate = cal.getTime();
		String newdate = dateFormat.format(duedate);
		System.out.println("Due Date = "+ newdate);
		
		actp.selectStartTime().click();
		actp.selectStartTime().click();
		actp.selectStartTime().sendKeys(Keys.CONTROL + "a");
		actp.selectStartTime().sendKeys(Keys.DELETE);
		Thread.sleep(3000);
		actp.selectStartTime().sendKeys(newdate.toString());
		Thread.sleep(5000);
		
		//Click on Save&Close button from the header.
		actp.getSavenCloseBtnOnApptForm().click();
		
		//Click on Activity type drop-down btn
		actp.getActivityTypeDDBtn().click();
		actp.selectApptActivity().click();
		actp.getActivityTypeLabel().click();
		
		//Search and verify for newly created appointment name
		actp.getActivitySearchField().click();
		actp.getActivitySearchField().sendKeys(apptname);
		hp.getstartsearch().click();
		Thread.sleep(5000);
		
		Assert.assertTrue(actp.getValidateApptName().getAttribute("title").contains(apptname));
		//Assert.assertEquals(true, actp.getValidateApptName().getAttribute("title").contains(apptname));
		
		//Open the appointment and navigate to the regarding Account/Contact
		actp.getValidateApptName().click();
		actp.openRequiredFieldText().click();
		Thread.sleep(5000);
		
		//Verify that appointment name is displayed on Account/Contact page
		Assert.assertTrue(ap.getverifyaccountppointment().getText().contains(apptname));	
		ap.getPageBackBtn().click();
	
	}
	
	@Test(priority=3)
	public void TS003_VerifyCreateTaskTest() throws InterruptedException
	{
		//The purpose of this test case to:-
		//CRM-T483- Verify Creation of Task under Activities

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		actp = new CRMActivitiesPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Navigate to Activities under Home in left menu
		hp.getActivitiesTab().click();
		Thread.sleep(3000);
		
		//Click on Task in the header to create new Task
		actp.getTaskOptnInHeader().click();
		
		//Verify that New Task form should be displayed
		Assert.assertTrue(actp.getNewTaskFormTitle().isDisplayed());
				
		//Enter required data
		actp.getSubjectTextBox().click();
		actp.getSubjectTextBox().sendKeys("CybTask_" + genData.generateRandomString(3));
		String taskname = actp.getSubjectTextBox().getAttribute("Value");
		System.out.println("Newly created task name: "+ taskname);
		
		actp.getRegardingFieldTxtBox().click();
		actp.selectRecordInRegardingField().click();
		actp.getRegardingFieldLabel().click();
		
		//Click on Save & Close button
		actp.getSavenCloseBtnOnApptForm().click();
		
		//Click on Activity type drop-down btn
		actp.getActivityTypeDDBtn().click();
		actp.selectTaskActivity().click();
		actp.getActivityTypeLabel().click();

		//Search and verify for newly created task name
		actp.getActivitySearchField().click();
		actp.getActivitySearchField().sendKeys(taskname);
		hp.getstartsearch().click();
		Thread.sleep(3000);
		
		Assert.assertTrue(actp.getValidateTaskName().getAttribute("title").contains(taskname));
		//Assert.assertEquals(true, actp.getValidateTaskName().getAttribute("title").contains(taskname));
		
		//Open the appointment and navigate to the regarding Account/Contact
		actp.getValidateApptName().click();
		actp.openRegardingFieldText().click();
		Thread.sleep(5000);
		//utl.scrollToElement(ap.getDescriptionLabel());
		
		//Verify that task name is displayed on Account/Contact page
		Assert.assertTrue(ap.getverifyaccountppointment().getText().contains(taskname));	
		ap.getPageBackBtn().click();
	}
	
	@Test(priority=4)
	public void TS004_VerifyCreatePhoneCallTest() throws InterruptedException
	{
		//The purpose of this test case to:-
		//CRM-T486- Verify Creation of Phone Call under Activities

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		actp = new CRMActivitiesPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Navigate to Activities under Home in left menu
		hp.getActivitiesTab().click();
		
		//Click on Phone Call available in the header section
		actp.getPhoneCallOptnInHeader().click();
		
		//Verify that New Phone Call form should be displayed
		Assert.assertTrue(actp.getNewPhoneCallFormTitle().isDisplayed());
		
		//Enter the required details
		actp.getSubjectTextBox().click();
		actp.getSubjectTextBox().sendKeys("CybPhoneCall_" +genData.generateRandomString(3));
		String phonecallname = actp.getSubjectTextBox().getAttribute("Value");
		System.out.println("Newly created Phone Call name: "+ phonecallname);
		
		actp.getCallToFieldTxtBox().click();
		actp.selectRecordInCallToField().click();
		actp.getCallToFieldLabel().click();
		
		actp.getRegardingFieldTxtBox().click();
		actp.selectRecordInRegardingField().click();
		actp.getRegardingFieldLabel().click();
		
		//Click on Save & Close button
		actp.getSavenCloseBtnOnApptForm().click();

		//Click on Activity type drop-down btn
		actp.getActivityTypeDDBtn().click();
		actp.selectPhoneCallActivity().click();
		actp.getActivityTypeLabel().click();

		//Search and verify for newly created Phone Call name
		actp.getActivitySearchField().click();
		actp.getActivitySearchField().sendKeys(phonecallname);
		hp.getstartsearch().click();

		Assert.assertTrue(actp.getValidatePhoneCallName().getAttribute("title").contains(phonecallname));
		
		//Open the appointment and navigate to the regarding Account/Contact
		actp.getValidatePhoneCallName().click();
		actp.openRegardingFieldText().click();
		Thread.sleep(5000);

		//Verify that task name is displayed on Account/Contact page
		Assert.assertTrue(ap.getverifyaccountppointment().getText().contains(phonecallname));	
		ap.getPageBackBtn().click();
	}
	
	@Test(priority=5)
	public void TS005_VerifyCreateEmailTest() throws InterruptedException
	{
		//The purpose of this test case to:-
		//CRM-T484- Verify Creation of Email under Activities

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		actp = new CRMActivitiesPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Navigate to Activities under Home in left menu
		hp.getActivitiesTab().click();
		
		//Click on Email available in the header section
		actp.getEmailOptnInHeader().click();
		
		//Verify that New Email form should be displayed		
		Assert.assertTrue(actp.getNewEmailFormTitle().isDisplayed());
		
		//Enter the required details
		actp.getSubjectTextBox().click();
		actp.getSubjectTextBox().sendKeys("CybEmail_" +genData.generateRandomString(3));
		String emailname = actp.getSubjectTextBox().getAttribute("Value");
		System.out.println("Newly created Email name: "+ emailname);
			
		utl.scrollToElement(actp.getSubjectFieldLabel());
		Thread.sleep(4000);
		actp.getRegardingFieldTxtBox().click();
		actp.selectRecordInRegardingField().click();
		actp.getRegardingFieldLabel().click();

		//Click on Save & Close button
		actp.getSavenCloseBtnOnApptForm().click();
		
		//Click on Activity type drop-down btn
		actp.getActivityTypeDDBtn().click();
		actp.selectEmailActivity().click();
		actp.getActivityTypeLabel().click();

		//Search and verify for newly created Email name
		actp.getActivitySearchField().click();
		actp.getActivitySearchField().sendKeys(emailname);
		hp.getstartsearch().click();
		Thread.sleep(3000);
		
		Assert.assertTrue(actp.getValidateEmailName().getAttribute("title").contains(emailname));
		
		//Open the appointment and navigate to the regarding Account/Contact
		actp.getValidateEmailName().click();
		actp.getSubjectFieldLabel().click();
		
		/*act = new Actions(driver);
		act.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);
		
		actp.openRegardingFieldText().click();
		actp.getRegardingFieldLabel().click();
		act.click(actp.openRegardingFieldText()).perform();
		actp.openRegardingFieldText().click();
		//actp.openRegardingFieldText().click();
		Thread.sleep(5000);

		//Verify that task name is displayed on Account/Contact page
		Assert.assertTrue(ap.getverifyaccountppointment().getText().contains(emailname));	*/
		ap.getPageBackBtn().click();
	}

}
