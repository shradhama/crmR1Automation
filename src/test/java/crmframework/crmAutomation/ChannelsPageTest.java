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
import pageObjects.CRMChannelsPage;
import pageObjects.CRMContactPage;
import pageObjects.CRMHomePage;
import pageObjects.CRMIncentiveCategoriesPage;
import pageObjects.CRMIncentiveTab;
import pageObjects.CRMLandingPage;
import pageObjects.CRMLoginPage;
import pageObjects.CRMPeoplePage;
import pageObjects.CRMReferenceDataPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class ChannelsPageTest extends base {

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
	CRMIncentiveCategoriesPage incat;
	CRMChannelsPage chp;
	Actions act;
	CRMContactPage cp;
	CRMPeoplePage pl;
	Utility utl;


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
	public void TS002_VerifyChannelsTest() throws IOException, InterruptedException {

		//The purpose of this test case for:-
		//T462- Verification of Channels

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		chp = new CRMChannelsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Navigate to Channels menu
		utl.scrollToElement(hp.getTransactionalSectnLabel());
		chp.getChannelsTab().click();

		//Verify that Active Channels should be displayed by default
		Assert.assertTrue(chp.getActiveChannelsLabel().isDisplayed());
		System.out.println("By default Active Channels got displayed");

		//Verify that Active CHannels should be displayed with fields: Name, Campus
		Assert.assertTrue(chp.getNameColumnLabel().isDisplayed());
		Assert.assertTrue(chp.getCampusColumnLabel().isDisplayed());
		System.out.println("Active Channels got displayed with fields: Name, Campus");

		//Select and double click on any active Channel record
		String incchname = chp.selectChannel().getText();
		System.out.println("Channel: "+incchname);
		act = new Actions(driver);
		act.doubleClick(chp.selectChannel()).perform();
		
		//Verify that the Channel page should be read only
		Assert.assertTrue(chp.verifyDisableField().isDisplayed());
		System.out.println("The Channel page is read only");

		//Verify that Channels page with General, Contact CHannel Profiles and Related tabs should be displayed
		Assert.assertTrue(chp.getGeneralTabLabel().isDisplayed());
		Assert.assertTrue(chp.getContactChannelProfileLabel().isDisplayed());
		Assert.assertTrue(chp.getRelatedTabLabel().isDisplayed());
		System.out.println("Channels page with General, Contact Channel Profiles and Related tabs got displayed");

		//Verify the sections under General: Name, Campus, Owner
		Assert.assertTrue(chp.getNameTxtFieldLabel().isDisplayed());
		Assert.assertTrue(chp.getCampusTxtFieldLabel().isDisplayed());
		Assert.assertTrue(chp.getOwnerTxtFieldLabel().isDisplayed());
		System.out.println("General Tab: Name, Campus and Owner values got displayed in first section.");
		
		//Verify the sections under General: Markets section with below fields: Name, Channel
		Assert.assertTrue(chp.getMarketFieldLabel().isDisplayed());
		Assert.assertTrue(chp.getMarketFieldNameLabel().isDisplayed());
		Assert.assertTrue(chp.getMarketFieldChannelLabel().isDisplayed());
		System.out.println("General Tab: Name and Channel fields got display in Markets section.");
		
		//Click on Contact Channel Profile
		chp.getContactChannelProfileLabel().click();
				
		//Verify sections under Contact Channel Profile: Contact, Channel, Demand Driver Product Category
		Assert.assertTrue(chp.getContactFieldLabel().isDisplayed());
		Assert.assertTrue(chp.getChannelFieldLabel().isDisplayed());
		Assert.assertTrue(chp.getDemardDriverProductCategoryFieldLabel().isDisplayed());
		System.out.println("Contact Channel Profile: Contact, Channel, Demand Driver Product Category fields got display in the section ");
		
		//Click on the Related tab
		chp.getRelatedTabLabel().click();
		Thread.sleep(3000);
		
		//Verify sections under Related: Related-Common with below option- Audit History, Contact Channel profiles, Markets
		Assert.assertTrue(chp.getRelatedCommonLabel().isDisplayed());
		Assert.assertTrue(chp.getAudioHistoryLabel().isDisplayed());
		Assert.assertTrue(chp.getContactChannelProfilesLabel().isDisplayed());
		Assert.assertTrue(chp.getMarketsLabel().isDisplayed());
		System.out.println("Related: Related-Common with below option- Audit History, Contact Channel profiles, Markets fields got display in the section");
		
		//Click on Back button and verify active channels page should get displayed
		chp.getBackButton().click();;
		Thread.sleep(5000);
		Assert.assertTrue(chp.getActiveChannelsLabel().isDisplayed());
		System.out.println("After click on Back button, Active Channels got displayed");
		
		//Click on dropdown and select Inactive Channels
		chp.sletectActiveChannelDropdown().click();
		chp.selectInactiveChannelOption().click();
		
		//Verify No data available message as there is no inactive record present
		Assert.assertTrue(chp.getNoDataMsg().isDisplayed());
		System.out.println("No data available message as there is no inactive record present");
   }
	
	@Test(priority=3)
	public void TS003_VerifySearchChannelsTest() throws IOException, InterruptedException {

		//The purpose of this test case:-
		//T463- To verify that CRM user is having ability to search Channels using searchable fields

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		chp = new CRMChannelsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Navigate to Channels menu
		utl.scrollToElement(hp.getTransactionalSectnLabel());
		chp.getChannelsTab().click();

		//Go to search box on right top corner of page and enter channel to be searched
		chp.getSearchChannelField().click();
		chp.getSearchChannelField().sendKeys(prop.getProperty("searchchannel"));
		chp.getStartSearch().click();
		Thread.sleep(4000);

		//Verify that all Channels that are beginning with 'Las' should get displayed in the search results
		Assert.assertTrue(chp.getChannelSearchResult().getAttribute("title").contains(prop.getProperty("searchchannel")));

		//Clear Search results
		chp.getClearSearch().click();
		
		//Go to search box on right top corner of page and enter data to be searched
		chp.getSearchChannelField().click();
		String searchchannelrecords = "*" + prop.getProperty("searchchannelrecords");
		chp.getSearchChannelField().sendKeys(searchchannelrecords);
		chp.getStartSearch().click();
		Thread.sleep(4000);

		//Verify that all channels that contains 'A' should get displayed in the search results
		WebElement channelnameinsearchresults = null;
		for (int i=0;i<3;i++)
		{
			channelnameinsearchresults = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']"));
			String channelinsearchrslt = channelnameinsearchresults.getText().toLowerCase();
			Assert.assertTrue(channelinsearchrslt.contains(prop.getProperty("searchchannelrecords")));
		}
		
		//Clear Search results
		chp.getClearSearch().click();
	}
	
}