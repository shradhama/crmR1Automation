
package resources;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.AppLandingPage;
import pageObjects.CRMHomePage;
import pageObjects.CRMLandingPage;
import pageObjects.CRMLoginPage;

public class Utility extends base{

	//public WebDriver driver;
	CRMLandingPage lap;
	CRMLoginPage lp;
	AppLandingPage alp;
	CRMHomePage hp;
	
	@SuppressWarnings("static-access")
	public Utility(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement scrollToElement(WebElement element) throws InterruptedException
	{
		WebElement scrollText = element;	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",scrollText);
		Thread.sleep(4000);
		return element;
	}
	
	public void verifyLoginFunctionality() throws IOException, InterruptedException {

		//The purpose of this test case to verify:-
		//TS1- Login to CRM Application and  Select published Apps (Demand Driver Management)

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		lap = new CRMLandingPage(driver);
		//lap.getLogin().sendKeys(System.getenv("username"));
		lap.getLogin().sendKeys(prop.getProperty("username")); //Using to run Maven project via Command line
		lap.getnext().click();

		lp= new CRMLoginPage(driver);
		lp.getpwd().click();

		//lp.getpwd().sendKeys(System.getenv("password"));
		lp.getpwd().sendKeys(prop.getProperty("password")); //Using to run Maven project via Command line
		lp.getsignin().click();
		
		//Wait to enter the verification code from Mobile
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
}
