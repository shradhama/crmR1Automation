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
import pageObjects.CRMIncentiveCategoriesPage;
import pageObjects.CRMIncentiveDetailsPage;
import pageObjects.CRMIncentiveTab;
import pageObjects.CRMIncentivesPage;
import pageObjects.CRMLandingPage;
import pageObjects.CRMListManagementPage;
import pageObjects.CRMLoginPage;
import pageObjects.CRMPeoplePage;
import pageObjects.CRMReferenceDataPage;
import pageObjects.CRMRegistrationsPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class ReferenceDataPageTest extends base {

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
	CRMRegistrationsPage reg;
	public String listNameText;
	CRMIncentiveCategoriesPage incat;

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
	public void TS002_VerifyCampusesTest() throws IOException, InterruptedException {

		//The purpose of this test case:-
		//T458- To verify the Campuses

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		refdp = new CRMReferenceDataPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Navigate to Campuses under Reference Data in left menu.
		utl.scrollToElement(hp.getTransactionalSectnLabel());
		hp.getCampusesTab().click();

		//Verify that by default Active Campuses should be displayed
		Assert.assertTrue(refdp.getActiveCampusesLabel().isDisplayed());

		//Verify that Campuses names which should be displayed are: Atlanta, Digital, High Point, Las Vegas
		Assert.assertTrue(refdp.getAtlantaCampusCell().isDisplayed());
		Assert.assertTrue(refdp.getDigitalCampusCell().isDisplayed());
		Assert.assertTrue(refdp.getHighPointCampusCell().isDisplayed());
		Assert.assertTrue(refdp.getLasVegasCampusCell().isDisplayed());

		//Open any Active Campus
		String campusname = refdp.getAtlantaCampusCell().getAttribute("title");
		System.out.println("Selected Campus name: "+campusname);
		refdp.getAtlantaCampusCell().click();

		//Verify that selected Campus page should be displayed
		Assert.assertTrue(refdp.getCampusPageHeaderTitle().getText().contains(campusname));

		//Verify that it is Read Only page
		Assert.assertTrue(refdp.getReadOnlyTxtOnCampusPage().isDisplayed());

		//Verify that Name with selected campus should be displayed
		Assert.assertTrue(refdp.getNameTextBox().getAttribute("value").contains(campusname));

		//Verify that List with below fields should be displayed
		List<WebElement> nodataavailtxt = refdp.getNoDataAvailTxt();
		if(nodataavailtxt.size()==0) {
			System.out.println("List is available for Campus");
		}
		else {
			Assert.assertTrue(refdp.getListsSectnNameColmn().isDisplayed());
			Assert.assertTrue(refdp.getListsSectnTypeColmn().isDisplayed());
			Assert.assertTrue(refdp.getListsSectnBuyerGroupColmn().isDisplayed());
			Assert.assertTrue(refdp.getListsSectnExpirationDateColmn().isDisplayed());
		}

		Assert.assertTrue(refdp.getListsSectnRefreshBtn().isDisplayed());
		Assert.assertTrue(refdp.getListsSectnExistingListsBtn().isDisplayed());
		Assert.assertTrue(refdp.getMoreCmndsForListsBtn().isDisplayed());

		//Click on the Related tab besides General
		refdp.getRelatedTab().click();

		Assert.assertTrue(refdp.getAuditHistoryOptn().isDisplayed());
		Assert.assertTrue(refdp.getChannelsOptn().isDisplayed());
		Assert.assertTrue(refdp.getAccountCampusProfileOptn().isDisplayed());

		//Verify that owner name should be displayed
		Assert.assertTrue(refdp.getOwnerName().isDisplayed());
		refdp.getMoreHeaderFieldsBtn().click();
		Assert.assertTrue(refdp.getOwnerInHeader().getText().contains(refdp.getOwnerName().getText()));

		//Click on Back button
		ap.getPageBackBtn().click();

		//Click on the dropdown which is beside the Active Campuses
		refdp.getActiveCampusesDDBtn().click();
		refdp.getInactiveCampusesOptn().click();

		//Verify that Inactive Campuses page should be displayed
		Assert.assertTrue(refdp.getInactiveCampusesLabel().isDisplayed());

		//Verify that if no Campuses are inactive then No data available should be displayed.
		Assert.assertTrue(refdp.getNoDataAvailMsg().isDisplayed());
	}

	@Test(priority=3)
	public void TS003_VerifySearchCampusesTest() throws IOException, InterruptedException {

		//The purpose of this test case:-
		//T459- To verify that CRM user is having ability to search Campuses using 
		//searchable fields: Name

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		refdp = new CRMReferenceDataPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Navigate to Campuses under Reference Data in left menu.
		utl.scrollToElement(hp.getTransactionalSectnLabel());
		hp.getCampusesTab().click();

		//Go to search box on right top corner of page and enter Name
		hp.getSearchCampusField().click();
		hp.getSearchCampusField().sendKeys(prop.getProperty("searchcampus"));
		hp.getstartsearch().click();
		Thread.sleep(4000);

		//Verify that All Campuses that are beginning with 'At' should get displayed in the search results
		Assert.assertTrue(hp.getCampusInSearchResult().getAttribute("title").contains(prop.getProperty("searchcampus")));

		//Clear Search results
		hp.getClearSearch().click();

		//Go to search box on right top corner of page and enter Name
		hp.getSearchCampusField().click();
		String searchcampusrecords = "*" + prop.getProperty("searchcampusrecords");
		hp.getSearchCampusField().sendKeys(searchcampusrecords);
		hp.getstartsearch().click();
		Thread.sleep(4000);

		//Verify that All Campuses that contains 'A' should get displayed in the search results
		WebElement campusnameinsearchresults = null;
		for (int i=0;i<3;i++)
		{
			campusnameinsearchresults = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']"));
			String campusinsearchrslt = campusnameinsearchresults.getText().toLowerCase();
			Assert.assertTrue(campusinsearchrslt.contains(prop.getProperty("searchcampusrecords")));
		}
		//Clear Search results
		hp.getClearSearch().click();
	}

	@Test(priority=4)
	public void TS004_VerifyDemandDriverProductCategoriesTest() throws IOException, InterruptedException {

		//The purpose of this test case:-
		//T474- To verify the Demand Driver Product Categories

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		refdp = new CRMReferenceDataPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Navigate to Demad Driver Product Categories under Reference Data in left menu
		utl.scrollToElement(hp.getTransactionalSectnLabel());
		hp.getDDProductCatgTab().click();

		//Verify that by default Active Demand Driver Product Categories should be displayed
		Assert.assertTrue(refdp.getActiveDDProductCategLabel().isDisplayed());

		//Verify that Active Demand Driver Product Categories should be displayed with the below fields:
		//Name, Parent Demand Driver Category
		Assert.assertTrue(refdp.getNameColumn().isDisplayed());
		Assert.assertTrue(refdp.getParentDDCategoryColumn().isDisplayed());

		//Open any Active Demand Driver Product Category
		String ddproductcatgname = refdp.selectDDProductCatgName().getAttribute("title");
		System.out.println("Selected DD Product Category: "+ddproductcatgname);

		//Get Parent DD Product Categ name
		String parentprductcatgname = refdp.getParentDDProductCatgName().getAttribute("title");
		System.out.println("Selected Parent DD Product Category: "+parentprductcatgname);
		refdp.selectDDProductCatgName().click();

		//Verify that selected Demand Driver Product Categories page should be displayed
		Assert.assertTrue(refdp.getDDProductCatgPageHeaderTitle().getText().contains(ddproductcatgname));

		//Verify that it is Read Only page
		Assert.assertTrue(refdp.getReadOnlyTxtOnCampusPage().isDisplayed());

		//Verify the sections and their values under General tab
		Assert.assertTrue(refdp.getNameTextBox().getAttribute("value").contains(ddproductcatgname));
		Assert.assertTrue(refdp.getParentDDProductCatgTxtbx().getText().contains(parentprductcatgname));

		//Click on the Related tab
		refdp.getRelatedTab().click();

		//Verify that Related-Common with below options should be displayed
		Assert.assertTrue(refdp.getAuditHistoryOptn().isDisplayed());
		Assert.assertTrue(refdp.getLeadsOptn().isDisplayed());
		Assert.assertTrue(refdp.getContactChannelsProfileOptn().isDisplayed());
		Assert.assertTrue(refdp.getDDProductCatgOptn().isDisplayed());
		Assert.assertTrue(refdp.getRegistrationsOptn().isDisplayed());

		//Click on Back button
		ap.getPageBackBtn().click();

		//Click on the dropdown which is beside the Active Demand Driver Product Categories
		refdp.getActiveDDProdCatgDDBtn().click();

		//Click on Inactive Demand Driver Product Categories option from the dropdown
		refdp.getInactiveDDProdCatgOptn().click();

		//Verify that Demand Driver Product Categories page should be displayed
		Assert.assertTrue(refdp.getInactiveDDProdCatgLabel().isDisplayed());

		//Verify that if no Demand Driver Product Categories are inactive then No data available should be displayed
		Assert.assertTrue(refdp.getNoDataAvailMsg().isDisplayed());
	}

	@Test(priority=5)
	public void TS005_VerifySearchDDProductCategoriesTest() throws IOException, InterruptedException {

		//The purpose of this test case:-
		//T475- To To verify that CRM user is having ability to search Demand Driver Product 
		//Categories using searchable fields: Name and Parent Demand Driver Category

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		refdp = new CRMReferenceDataPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Navigate to Campuses under Reference Data in left menu.
		utl.scrollToElement(hp.getTransactionalSectnLabel());
		hp.getDDProductCatgTab().click();
		Thread.sleep(4000);

		//Go to search box on right top corner of page and enter Name
		hp.getSearchDDProdCatgField().click();
		hp.getSearchDDProdCatgField().sendKeys(prop.getProperty("searchddprodcatg"));
		hp.getstartsearch().click();
		Thread.sleep(4000);

		//Verify that All Demad Driver Product Categories that are beginning with Acc should get displayed in the search results.
		WebElement ddprodcatginsearchresults = null;
		for (int i=0;i<2;i++)
		{
			ddprodcatginsearchresults = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']"));
			String prodcatginsearchrslt = ddprodcatginsearchresults.getAttribute("title");
			Assert.assertTrue(prodcatginsearchrslt.contains(prop.getProperty("searchddprodcatg")));
		}
		//Clear Search results
		hp.getClearSearch().click();

		//Go to the search box on top right corner of the page and enter Parent category Driver Category
		hp.getSearchDDProdCatgField().click();
		hp.getSearchDDProdCatgField().sendKeys(prop.getProperty("searchparentcatg"));
		hp.getstartsearch().click();
		Thread.sleep(4000);

		//Verify that all the records that contains 'Ho' keyword should display 
		WebElement parentcatginsearchresults = null;
		for (int i=0;i<7;i++)
		{
			parentcatginsearchresults = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-3']"));
			String parentcatginsearchrslt = parentcatginsearchresults.getAttribute("title");
			Assert.assertTrue(parentcatginsearchrslt.contains(prop.getProperty("searchparentcatg")));
		}
		//Clear Search results
		hp.getClearSearch().click();

		//Go to search box on right top corner of page and enter Name
		hp.getSearchDDProdCatgField().click();
		String searchddprodcatg = "*" + prop.getProperty("searchprodcatgrecords");
		hp.getSearchDDProdCatgField().sendKeys(searchddprodcatg);
		hp.getstartsearch().click();
		Thread.sleep(4000);

		//Verify that All the records which have 'me' in the searchable fields will be displayed
		WebElement parentcatginsearchrslt = null;
		WebElement prodcatginsearchrslt = null;
		for (int i=0;i<8;i++)
		{
			parentcatginsearchrslt = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-3']"));
			if (parentcatginsearchrslt.getAttribute("title").contains(prop.getProperty("searchprodcatgrecords")))
			{
				System.out.println(parentcatginsearchrslt.getAttribute("title"));
			}
			else {
				prodcatginsearchrslt = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']"));
				Assert.assertTrue(prodcatginsearchrslt.getAttribute("title").contains(prop.getProperty("searchprodcatgrecords")));
				System.out.println(prodcatginsearchrslt.getAttribute("title"));
				continue;
			}
		}

		//Clear Search results
		hp.getClearSearch().click();
	}
	@Test(priority=6)
	public void TS006_VerifyMarketsTest() throws IOException, InterruptedException {

		//The purpose of this test case:-
		//T466- To verify the Markets

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		refdp = new CRMReferenceDataPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Navigate to Markets under Reference Data in left menu
		utl.scrollToElement(hp.getTransactionalSectnLabel());
		hp.getMarketsTab().click();

		//Verify that by default Active Markets should be displayed
		Assert.assertTrue(refdp.getActiveMarketsLabel().isDisplayed());
		Assert.assertTrue(refdp.getNameColumn().isDisplayed());
		Assert.assertTrue(refdp.getChannelColumn().isDisplayed());

		//Open any Active Market
		String marketname = refdp.selectMarketName().getAttribute("title");
		System.out.println("Selected Market Name: "+marketname);

		String channelname = refdp.getChannelName().getText();
		System.out.println("Selected Channel Name: "+channelname);

		refdp.selectMarketName().click();

		//Verify that selected market's page should be displayed
		Assert.assertTrue(refdp.getMarketPageHeaderTitle().getText().contains(marketname));

		//Verify that it is Read Only page
		Assert.assertTrue(refdp.getReadOnlyTxtOnCampusPage().isDisplayed());

		//Verify the sections under General
		Assert.assertTrue(refdp.getNameTextBox().getAttribute("value").contains(marketname));
		Assert.assertTrue(refdp.getChannelTxtBx().getText().contains(channelname));
		Assert.assertTrue(refdp.getStartDateColmn().isDisplayed());
		Assert.assertTrue(refdp.getEndDateColmn().isDisplayed());

		//Click on the Related tab
		refdp.getRelatedTab().click();

		//Related-Common tab with expected options should be displayed
		Assert.assertTrue(refdp.getAuditHistoryOptn().isDisplayed());
		Assert.assertTrue(refdp.getContactMarketProfilesOptn().isDisplayed());
		Assert.assertTrue(refdp.getIncentivesOptn().isDisplayed());
		Assert.assertTrue(refdp.getIncentiveDetailsOptn().isDisplayed());
		Assert.assertTrue(refdp.getPhoneCallMarketOutcomeOptn().isDisplayed());

		//Verify header displaying owner name
		Assert.assertTrue(refdp.getOwnerName().isDisplayed());
		refdp.getMoreHeaderFieldsBtn().click();
		Assert.assertTrue(refdp.getOwnerInHeader().getText().contains(refdp.getOwnerName().getText()));

		//Click on Back button
		ap.getPageBackBtn().click();

		//Click on the drop-down which is beside the Active Markets
		refdp.getActiveMarketsDDBtn().click();
		refdp.getInactiveMarketsOptn().click();
		Assert.assertTrue(refdp.getInactiveMarketsLabel().isDisplayed());
		if (refdp.getInactiveMarketsResults().isDisplayed()) {
			System.out.println("Inactive Markets Data is available");
		}
		else {
			//Verify that if no Markets are inactive then No data available should be displayed
			Assert.assertTrue(refdp.getNoDataAvailMsg().isDisplayed());
		}
	}

	@Test(priority=10)
	public void TS010_VerifySearchMarketsTest() throws IOException, InterruptedException {

		//The purpose of this test case:-
		//T467- To verify that CRM user is having ability to search Markets using 
		//searchable fields: Name and Channel

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		refdp = new CRMReferenceDataPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Navigate to Markets under Reference Data in left menu
		utl.scrollToElement(hp.getTransactionalSectnLabel());
		hp.getMarketsTab().click();

		//Go to the search box on top right corner of the page and enter market name keyword
		hp.getSearchMarketField().click();
		hp.getSearchMarketField().sendKeys(prop.getProperty("searchmarket"));
		hp.getstartsearch().click();
		Thread.sleep(4000);

		//Verify that all the records that contains '2011' keyword should display 
		WebElement marketsinsearchresults = null;
		for (int i=0;i<7;i++)
		{
			marketsinsearchresults = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']"));
			String mrktinsearchrslt = marketsinsearchresults.getAttribute("title");
			Assert.assertTrue(mrktinsearchrslt.contains(prop.getProperty("searchmarket")));
		}
		//Clear Search results
		hp.getClearSearch().click();

		//Go to the search box on top right corner of the page and enter channel name keyword
		hp.getSearchMarketField().click();
		hp.getSearchMarketField().sendKeys(prop.getProperty("searchchannelrecords"));
		hp.getstartsearch().click();
		Thread.sleep(4000);

		//Verify that all the records that contains 'Am' keyword should display 
		WebElement channelinsearchresults = null;
		for (int i=0;i<7;i++)
		{
			channelinsearchresults = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-3']"));
			String channelinsearchrslt = channelinsearchresults.getAttribute("title");
			Assert.assertTrue(channelinsearchrslt.contains(prop.getProperty("searchchannelrecords")));
		}
		//Clear Search results
		hp.getClearSearch().click();

		//Go to search box on right top corner of page and enter Name
		hp.getSearchMarketField().click();
		String searchmarketrecords = "*" + prop.getProperty("searchmarketrecords");
		hp.getSearchMarketField().sendKeys(searchmarketrecords);
		hp.getstartsearch().click();
		Thread.sleep(4000);

		//Verify that All records that contains 'ab' should get displayed in the search results
		WebElement mrktnameinsearchresults = null;
		for (int i=0;i<4;i++)
		{
			mrktnameinsearchresults = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']"));
			String marketinsearchrslt = mrktnameinsearchresults.getText().toLowerCase();
			Assert.assertTrue(marketinsearchrslt.contains(prop.getProperty("searchmarketrecords")));
		}
		//Clear Search results
		hp.getClearSearch().click();
	}
	@Test(priority=7)
	public void TS007_VerifyRegionsTest() throws IOException, InterruptedException {

		//The purpose of this test case:-
		//T471- To verify Regions

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		refdp = new CRMReferenceDataPage(driver);
		reg = new CRMRegistrationsPage(driver);
		in = new CRMIncentivesPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Navigate to Regions under Reference Data in left menu.
		utl.scrollToElement(hp.getTransactionalSectnLabel());
		hp.getregionstab().click();
		Thread.sleep(5000);
		
		//Open Region record and verify tabs and read only message
		ap.getAccountNameSearchTable().click();
		Assert.assertTrue(refdp.getgeneraltab().isDisplayed());
		Assert.assertTrue(refdp.getRelatedTab().isDisplayed());
		System.out.println("General and Related tabs are displayed properly.");
		Assert.assertTrue(reg.getreadonlynotification().isDisplayed());
		System.out.println("Region record is disabled.");
		Thread.sleep(5000);
		
		//Verify details on general tab
		Assert.assertTrue(refdp.getregionname().isDisplayed());
		Assert.assertTrue(refdp.getworldregion().isDisplayed());
		System.out.println("Region and World Region are displayed properly.");
		Thread.sleep(5000);
		
		//Verify Related Tab
		ap.getRelatedTab().click();
		Thread.sleep(5000);
		Assert.assertTrue(refdp.getcommonrelated().isDisplayed());
		Assert.assertTrue(refdp.getaudithistory().isDisplayed());
		Assert.assertTrue(refdp.getaccounts().isDisplayed());
		Assert.assertTrue(refdp.getcontacts().isDisplayed());
		Assert.assertTrue(refdp.getcountries().isDisplayed());
		Assert.assertTrue(refdp.getstates().isDisplayed());
		Assert.assertTrue(refdp.getregions().isDisplayed());
		System.out.println("Related tab options are displayed properly.");
		Thread.sleep(3000);
		
		//Verify Regions grid
		ap.getPageBackBtn().click();
		Thread.sleep(5000);
		refdp.getregiontypedd().click();
		Assert.assertTrue(refdp.getddoption1().isDisplayed());
		Assert.assertTrue(refdp.getddoption2().isDisplayed());
		Assert.assertTrue(refdp.getddoption3().isDisplayed());
		System.out.println("Region drop down options are displayed properly.");
		Thread.sleep(3000);
		refdp.getddoption3().click();
		Thread.sleep(3000);
		Assert.assertTrue(in.getNoDataAvailableText().isDisplayed());
		System.out.println("Inactive Regions are not available.");
		
	}
	@Test(priority=11)
	public void TS011_VerifySearchRegionsTest() throws IOException, InterruptedException {

		//The purpose of this test case:-
		//T471- To verify Search Regions functionality
		
		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		refdp = new CRMReferenceDataPage(driver);
		reg = new CRMRegistrationsPage(driver);
		in = new CRMIncentivesPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Navigate to Regions under Reference Data in left menu.
		utl.scrollToElement(hp.getTransactionalSectnLabel());
		hp.getregionstab().click();
		Thread.sleep(5000);
		
		//Search Region
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("regionsearch"));
		ap.getclicksearchbutton().click();
		Thread.sleep(3000);
		
		//Verify that All Campuses that contains 'M' should get displayed in the search results
		WebElement regionnameinsearchresults = null;
		for (int i=0;i<3;i++)
		{
			regionnameinsearchresults = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']"));
			String regioninsearchrslt = regionnameinsearchresults.getText().toLowerCase();
			Assert.assertTrue(regioninsearchrslt.contains(prop.getProperty("regionsearch")));
			
		}
		System.out.println("Regions searched successfully.");	
		
		//Verify for no data available
		in.getclearsearch().click();
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("regionnotavailable"));
		ap.getclicksearchbutton().click();
		Assert.assertTrue(in.getNoDataAvailableText().isDisplayed());
		System.out.println("No matching records are available.");
		
	}
	
	@Test(priority=8)
	public void TS008_VerifyChannelsTest() throws IOException, InterruptedException {

		//The purpose of this test case for:-
		//T462- Verification of Channels

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		refdp = new CRMReferenceDataPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Navigate to Channels menu
		utl.scrollToElement(hp.getTransactionalSectnLabel());
		refdp.getChannelsTab().click();

		//Verify that Active Channels should be displayed by default
		Assert.assertTrue(refdp.getActiveChannelsLabel().isDisplayed());
		System.out.println("By default Active Channels got displayed");

		//Verify that Active CHannels should be displayed with fields: Name, Campus
		Assert.assertTrue(refdp.getNameColumnLabel().isDisplayed());
		Assert.assertTrue(refdp.getCampusColumnLabel().isDisplayed());
		System.out.println("Active Channels got displayed with fields: Name, Campus");

		//Select and double click on any active Channel record
		String incchname = refdp.selectChannel().getText();
		System.out.println("Channel: "+incchname);
		act = new Actions(driver);
		act.doubleClick(refdp.selectChannel()).perform();
		
		//Verify that the Channel page should be read only
		Assert.assertTrue(refdp.verifyDisableField().isDisplayed());
		System.out.println("The Channel page is read only");

		//Verify that Channels page with General, Contact CHannel Profiles and Related tabs should be displayed
		Assert.assertTrue(refdp.getGeneralTabLabel().isDisplayed());
		Assert.assertTrue(refdp.getContactChannelProfileLabel().isDisplayed());
		Assert.assertTrue(refdp.getRelatedTabLabel().isDisplayed());
		System.out.println("Channels page with General, Contact Channel Profiles and Related tabs got displayed");

		//Verify the sections under General: Name, Campus, Owner
		Assert.assertTrue(refdp.getNameTxtFieldLabel().isDisplayed());
		Assert.assertTrue(refdp.getCampusTxtFieldLabel().isDisplayed());
		Assert.assertTrue(refdp.getOwnerTxtFieldLabel().isDisplayed());
		System.out.println("General Tab: Name, Campus and Owner values got displayed in first section.");
		
		//Verify the sections under General: Markets section with below fields: Name, Channel
		Assert.assertTrue(refdp.getMarketFieldLabel().isDisplayed());
		Assert.assertTrue(refdp.getMarketFieldNameLabel().isDisplayed());
		Assert.assertTrue(refdp.getMarketFieldChannelLabel().isDisplayed());
		System.out.println("General Tab: Name and Channel fields got display in Markets section.");
		
		//Click on Contact Channel Profile
		refdp.getContactChannelProfileLabel().click();
				
		//Verify sections under Contact Channel Profile: Contact, Channel, Demand Driver Product Category
		Assert.assertTrue(refdp.getContactFieldLabel().isDisplayed());
		Assert.assertTrue(refdp.getChannelFieldLabel().isDisplayed());
		Assert.assertTrue(refdp.getDemardDriverProductCategoryFieldLabel().isDisplayed());
		System.out.println("Contact Channel Profile: Contact, Channel, Demand Driver Product Category fields got display in the section ");
		
		//Click on the Related tab
		refdp.getRelatedTabLabel().click();
		Thread.sleep(3000);
		
		//Verify sections under Related: Related-Common with below option- Audit History, Contact Channel profiles, Markets
		Assert.assertTrue(refdp.getRelatedCommonLabel().isDisplayed());
		Assert.assertTrue(refdp.getAudioHistoryLabel().isDisplayed());
		Assert.assertTrue(refdp.getContactChannelProfilesLabel().isDisplayed());
		Assert.assertTrue(refdp.getMarketsLabel().isDisplayed());
		System.out.println("Related: Related-Common with below option- Audit History, Contact Channel profiles, Markets fields got display in the section");
		
		//Click on Back button and verify active channels page should get displayed
		refdp.getBackButton().click();;
		Thread.sleep(5000);
		Assert.assertTrue(refdp.getActiveChannelsLabel().isDisplayed());
		System.out.println("After click on Back button, Active Channels got displayed");
		
		//Click on dropdown and select Inactive Channels
		refdp.sletectActiveChannelDropdown().click();
		refdp.selectInactiveChannelOption().click();
		
		//Verify No data available message as there is no inactive record present
		Assert.assertTrue(refdp.getNoDataMsg().isDisplayed());
		System.out.println("No data available message as there is no inactive record present");
   }
	
	@Test(priority=9)
	public void TS009_VerifySearchChannelsTest() throws IOException, InterruptedException {

		//The purpose of this test case:-
		//T463- To verify that CRM user is having ability to search Channels using searchable fields

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Navigate to Channels menu
		utl.scrollToElement(hp.getTransactionalSectnLabel());
		hp.getChannelsTab().click();

		//Go to search box on right top corner of page and enter channel to be searched
		hp.getSearchChannelField().click();
		hp.getSearchChannelField().sendKeys(prop.getProperty("searchchannel"));
		hp.getstartsearchbutton().click();
		Thread.sleep(4000);

		//Verify that all Channels that are beginning with 'Las' should get displayed in the search results
		//Assert.assertTrue(hp.getChannelSearchResult().getAttribute("title").contains(prop.getProperty("searchchannel")));
		Assert.assertEquals(true, hp.getChannelSearchResult().getAttribute("title").contains(prop.getProperty("searchchannel")));

		//Clear Search results
		hp.getClearSearch().click();
		
		//Go to search box on right top corner of page and enter data to be searched
		hp.getSearchChannelField().click();
		String searchchannelrecords = "*" + prop.getProperty("searchchannelrecords");
		hp.getSearchChannelField().sendKeys(searchchannelrecords);
		hp.getstartsearchbutton().click();
		Thread.sleep(4000);

		//Verify that all channels that contains 'A' should get displayed in the search results
		WebElement channelnameinsearchresults = null;
		for (int i=0;i<3;i++)
		{
			channelnameinsearchresults = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']"));
			String channelinsearchrslt = channelnameinsearchresults.getText();
			//Assert.assertTrue(channelinsearchrslt.contains(prop.getProperty("searchchannelrecords")));
			Assert.assertEquals(true, channelinsearchrslt.contains(prop.getProperty("searchchannelrecords")));
		}
		
		//Clear Search results
		hp.getClearSearch().click();
	}
	
	@Test(priority=12)
	public void TS012_VerifyIncentiveCategoriesTest() throws IOException, InterruptedException {

		//The purpose of this test case for:-
		//T478- Verification of Incentive Categories

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		incat = new CRMIncentiveCategoriesPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Navigate to Incentive Categories menu
		utl.scrollToElement(hp.getTransactionalSectnLabel());
		hp.getIncCategoriesTab().click();

		//Verify that Active Incentive Categories should be displayed by default
		Assert.assertTrue(incat.getActiveIncCategoriesLabel().isDisplayed());
		System.out.println("Incentive Categories are displayed.");
		
		//Verify that Active Incentive Categories should be displayed with fields: Name, Estimated Value
		Assert.assertTrue(incat.getNameColumnLabel().isDisplayed());
		Assert.assertTrue(incat.getEstimatedValueColmnLabel().isDisplayed());
		System.out.println("Name and Estimated Value fields are displayed.");
		String inccatname = incat.selectIncCategory().getText();
		System.out.println("Incentive Category: "+inccatname);

		//Double click on any Active Incentive Category
		act = new Actions(driver);
		act.doubleClick(incat.selectIncCategory()).perform();

		//Verify that Incentive Categories page with General and Related tabs should be displayed
		Assert.assertTrue(incat.getGeneralTabLabel().isDisplayed());
		Assert.assertTrue(incat.getRelatedTabLabel().isDisplayed());
		System.out.println("General and Related tabs are displayed.");
		Thread.sleep(3000);
		
		//Verify the sections under General
		Assert.assertTrue(incat.getNameTxtFieldLabel().isDisplayed());
		Assert.assertTrue(incat.getTypefieldLabel().isDisplayed());
		Assert.assertTrue(incat.getEstimatedValueTxtFieldLabel().isDisplayed());
		Assert.assertTrue(incat.getCurrencyTxtFieldLabel().isDisplayed());
		System.out.println("General tab sections are displayed properly.");
		
		//Click on the Related tab
		incat.getRelatedTabLabel().click();
		Thread.sleep(5000);
		
		//Verify that Related-Common should be displayed with below options: Audit History, Incentive Details
		Assert.assertTrue(incat.getRelatedAuditHistoryItem().isDisplayed());
		Assert.assertTrue(incat.getRelatedIncDetailsItem().isDisplayed());
		System.out.println("Audit History and Incentive Details are displayed properly.");
		
		//Verify that Incentive Category name should be displayed and owner should be displayed as Demand Driver Ownership team
		Assert.assertTrue(incat.getIncCatFormHeaderTitle().getText().contains(inccatname));
		Assert.assertTrue(incat.getIncCategoryOwner().isDisplayed());
		System.out.println("Incetive Category Name and Owner are displayed properly.");
		
		//Click on the down arrow of Owner
		incat.getMoreHeaderFieldsBtn().click();

		//Verify that Owner name should be same as from the header (Demand Driver Ownership Team)
		Assert.assertTrue(incat.getdddownername().getText().contains(incat.getIncCatOwnerNameIndd().getText()));
		System.out.println("Owner is same as Demand Driver Ownership Team.");
		
		//Click back button to navigate back to Active Categories Menu
		ap.getPageBackBtn().click();

		//Click on the drop-down which is beside the Active Incentive Categories
		incat.getActiveIncCatDropDownBtn().click();

		//Click on Inactive Incentive Categories option from the drop-down
		incat.getInactiveIncCatOptn().click();
		Thread.sleep(5000);
		
		//Incentive Categories page should be displayed with Inactive Incentive Categories with fields: Name, Estimated value
		Assert.assertTrue(incat.getInactiveIncCatLabel().isDisplayed());
		Assert.assertTrue(incat.getNameColumnLabel().isDisplayed());
		Assert.assertTrue(incat.getEstimatedValueColmnLabel().isDisplayed());
		System.out.println("Inactive Incentive Categories are displayed properly along with Name and Estimated Value.");
	}

	@Test(priority=13)
	public void TS013_VerifySearchIncentiveCategoriesTest() throws IOException, InterruptedException {

		//The purpose of this test case to:-
		//T479- Verify that CRM user is having ability to search Incentive Categories 
		//using searchable fields: Name

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		incat = new CRMIncentiveCategoriesPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Navigate to Incentive Categories menu
		utl.scrollToElement(hp.getTransactionalSectnLabel());
		hp.getIncCategoriesTab().click();

		//Click on 'Search' view and enter any Inc Category
		String searchinccategory = prop.getProperty("searchinccat");
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(searchinccategory);
		ap.getclicksearchbutton().click();
		Thread.sleep(5000);

		//Verify that All Incentive Categories that are beginning with Airline should get displayed in the search results
		WebElement inccatinsearchresults = null;
		for (int i=0;i<1;i++)
		{
			inccatinsearchresults = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']"));
			Assert.assertTrue(inccatinsearchresults.getText().contains(searchinccategory));
		}
		System.out.println("Incentive Categories beggining with Airline are displayed properly.");
		
		//Clear the search term
		hp.getClearSearch().click();

		//Click on 'Search' view and enter any search text
		String searchinccattext = "*" + prop.getProperty("searchinccatterm");
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(searchinccattext);
		ap.getclicksearchbutton().click();
		Thread.sleep(5000);

		//Verify that All the records which have 'ar' in the searchable fields will be displayed
		WebElement inccatinsearchresults1 = null;
		for (int i=0;i<4;i++)
		{
			inccatinsearchresults1 = driver.findElement(By.xpath("//div[@data-id='cell-"+i+"-2']"));
			String inccat = inccatinsearchresults1.getText().toLowerCase();
			Assert.assertTrue(inccat.contains(prop.getProperty("searchinccatterm")));
		}
		System.out.println("Incentive Categories having ar are displayed properly.");
		
		//Clear the search term
		hp.getClearSearch().click();

		//Verify that Entered search text should get cleared
		Assert.assertTrue(ap.getsearchaccounttextbox().getAttribute("placeholder").contains("Search this view"));
		System.out.println("Search is cleared properly.");
	}

	@Test(priority=14)
	public void TS014_VerifyCreateNewIncentiveCategoryTest() throws IOException, InterruptedException {

		//The purpose of this test case to:-
		//T482- Verify user is able to create new Incentive Category with appropriate access

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		incat = new CRMIncentiveCategoriesPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;

		//Navigate to Incentive Categories menu
		utl.scrollToElement(hp.getTransactionalSectnLabel());
		hp.getIncCategoriesTab().click();

		//Click on New Button available in header to create new Incentive Category
		incat.getIncCategoryNewbtn().click();

		//Verify that New Incentive Category form should be displayed
		Assert.assertTrue(incat.getIncCatFormHeader().isDisplayed());
		System.out.println("New Incentive Category form is displayed properly.");
		
		String newinccatname = "CybQA"+ genData.generateRandomString(4);
		System.out.println("Newly created Incentive Category: "+newinccatname);
		incat.getNameTextBox().sendKeys(newinccatname);
		incat.getTypeTextBox().click();
		incat.getTypeNameFmdd().click();

		//Click on Save&Close in header
		incat.getIncCatSavenCloseBtn().click();

		//Search for the Incentive category under active Incentive category using Name
		ap.getsearchaccounttextbox().click();
		ap.getsearchaccounttextbox().sendKeys(newinccatname);
		ap.getclicksearchbutton().click();
		Thread.sleep(5000);

		Assert.assertTrue(hp.getSearchResultIncCatName().getText().contains(newinccatname));
		System.out.println("Incentive Category is searched properly.");
		
		//Select and open the Incentive category
		hp.getSearchResultIncCatName().click();

		//Verify that Entered details should be displayed properly
		Assert.assertTrue(incat.getIncCatFormHeaderTitle().getText().contains(newinccatname));
		System.out.println("Entered details are displayed properly.");
		ap.getPageBackBtn().click();
		hp.getClearSearch().click();
	}
}

