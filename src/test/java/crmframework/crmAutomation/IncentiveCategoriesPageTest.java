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
import pageObjects.CRMIncentiveCategoriesPage;
import pageObjects.CRMIncentiveTab;
import pageObjects.CRMLandingPage;
import pageObjects.CRMLoginPage;
import pageObjects.CRMPeoplePage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class IncentiveCategoriesPageTest extends base {

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
	public void TS002_VerifyIncentiveCategoriesTest() throws IOException, InterruptedException {

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

	@Test(priority=3)
	public void TS003_VerifySearchIncentiveCategoriesTest() throws IOException, InterruptedException {

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

	@Test(priority=4)
	public void TS004_VerifyCreateNewIncentiveCategoryTest() throws IOException, InterruptedException {

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