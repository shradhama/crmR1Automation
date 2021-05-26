package crmframework.crmAutomation;

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
import pageObjects.CRMPhoneCallMarketOutcomePage;
import pageObjects.CRMReferenceDataPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class PhoneCallMarketOutcomePageTest extends base {

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
	CRMReferenceDataPage refdp;
	CRMPhoneCallMarketOutcomePage pcmop;
	public String listNameText;

	@BeforeTest
	public void initialize() throws IOException
	{
		//driver = initializeDriver(); //requires for Parallel text execution
		genData=new GenerateData();
		utl=new Utility(driver);
		//utl.verifyLoginFunctionality(); //requires for Parallel text execution
	}

	/*@Test(priority=1)
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
	}*/

	@Test(priority=2)
	public void TS002_VerifyAllPhoneCallsByOwnerTest() throws IOException, InterruptedException {

		//The purpose of this test case:-
		//T214- To Verify Retail relations marketing manager is able to see a chart of phone 
		//calls per rep. for market

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		pcmop = new CRMPhoneCallMarketOutcomePage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on "Phone Call Market Outcome" under Home menu from left navigation pane
		hp.getPhoneCallMarketOutcomeTab().click();
		
		//Verify that List of Phone call Market outcome should be displayed in grid section
		Assert.assertTrue(pcmop.getPhoneCallMarketOutcomeLabel().isDisplayed());
		
		//Click on Filter icon of Market column
		pcmop.getMarketColmnFilterIcon().click();
		
		//Click on Filter By option and Equals filter
		pcmop.getFilterByOption().click();
		
		//Enter Name as e.g. 'LVMJul19' in second textbox
		String marketname = pcmop.selectMarketFromList().getText();
		System.out.println("Selected Market name in filter: "+marketname);
		pcmop.selectMarketFromList().click();
		
		//click on Apply button
		pcmop.getFilterByPopupApplyBtn().click();
		Thread.sleep(4000);
		
		List <WebElement> noofphonecallsbyowner = pcmop.getNoOfPhoneCallsByOwner();
		int noofphonecallsingrid = noofphonecallsbyowner.size();
		String callscountingrid = Integer.toString(noofphonecallsingrid);
		System.out.println("No. of Phone calls by Owner: "+callscountingrid);
		
		//Verify that List of phone call market outcome should be displayed only for applied market
		WebElement marketnameinfilterresults = null;
		for (int i=0;i<3;i++)
		{
			marketnameinfilterresults = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']"));
			Assert.assertTrue(marketnameinfilterresults.getText().contains(marketname));
		}
				
		//Click on 'Show Chart' button to enable and see the chart view.
		pcmop.getShowwChartBtn().click();
		
		//All Phone calls by owner should be selected by default
		Assert.assertTrue(pcmop.getAllPhoneCallsByOwnerLabel().isDisplayed());
		
		//Verify that Chart of All Phone calls for applied Market per rep or owner should get displayed
		Assert.assertTrue(pcmop.getAllPhoneCallsChartXAxisLabel().getText().contains(prop.getProperty("allphonecallschartxaxislabel")));
		Assert.assertTrue(pcmop.getAllPhoneCallsChartYAxisLabel().getText().contains(prop.getProperty("allphonecallschartyaxislabel")));
		Assert.assertEquals(pcmop.getNoOfPhoneCallsInChart().getText(), callscountingrid);

		//Close the chart
		pcmop.getCloseChartBtn().click();
		
		//Clear the applied filter
		pcmop.getMarketColmnFilterIcon().click();
		pcmop.getClearFilterBtn().click();
	}
}

