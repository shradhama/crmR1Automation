package crmframework.crmAutomation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AppLandingPage;
import pageObjects.CRMAccountsPage;
import pageObjects.CRMAddMarketingRelationshipOwner;
import pageObjects.CRMContactPage;
import pageObjects.CRMHomePage;
import pageObjects.CRMIncentivesPage;
import pageObjects.CRMLandingPage;
import pageObjects.CRMLoginPage;
import pageObjects.CRMPeoplePage;
import pageObjects.CRMReferenceDataPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class CAB250PageTest extends base{

	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	CRMHomePage hp;
	CRMAccountsPage ap;
	CRMReferenceDataPage refdp;

	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		genData=new GenerateData();
		utl = new Utility(driver);
		utl.verifyLoginFunctionality(); //requires for Parallel text execution
	}

	@Test(priority=1)
	public void TS001_VerifyPreseneOfNewFieldsToMarketEntity() throws InterruptedException
	{
		//The purpose of this test case to:-
		//CRM-T558_Verify the presence of 3 newly added fields (Registration Open, Registration Closed, CDSAuthKey
		//to CRM Market Entity

		hp = new CRMHomePage(driver);
		ap = new CRMAccountsPage(driver);
		refdp = new CRMReferenceDataPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Navigate to Markets under Reference Data in left menu
		utl.scrollToElement(hp.getTransactionalSectnLabel());
		hp.getMarketsTab().click();
		
		//Search and go for the Market
		ap.getsearchaccounttextbox().sendKeys(prop.getProperty("marketentity"));
		ap.getclicksearchbutton().click();
		refdp.selecChannelFromGrid().click();
		refdp.selectMarketName().click();
		Thread.sleep(5000);
		
		//Verify label of newly added field: Registration Open
		String actuallabel1= refdp.getRegistrationOpenLabel().getText();
		String expectedlabel1= "Registration Open";
		Assert.assertEquals(actuallabel1, expectedlabel1);
		System.out.println("Registration Open label is present");
		
		//Verify label of newly added field: Registration Close
		String actuallabel2= refdp.getRegistrationCloseLabel().getText();
		String expectedlabel2= "Registration Close";
		Assert.assertEquals(actuallabel2, expectedlabel2);
		System.out.println("Registration Close label is present");
				
		//Verify label of newly added field: CDSAuthKey
		String actuallabel3= refdp.getCDSAuthKeyLabel().getText();
		String expectedlabel3= "CDSAuthKey";
		Assert.assertEquals(actuallabel3, expectedlabel3);
		System.out.println("CDSAuthKey label is present");
	}

	
	//	@AfterTest
	//	public void closeDriver()
	//	{
	//		driver.close();
	//	}


}
