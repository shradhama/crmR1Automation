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
import pageObjects.CRMReferenceDataPage;
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
}

