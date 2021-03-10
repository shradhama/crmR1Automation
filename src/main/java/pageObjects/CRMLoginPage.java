package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMLoginPage {
	
	//  this page is created for to define all the webelements located on CRM Login page to till Published App page. 
	public WebDriver driver;
	public WebDriverWait wait;
	
	By password = By.id("passwordInput");
	//By password = By.xpath("//input[@class = 'form-control input ext-input text-box ext-text-box']");
	By signin = By.xpath("//span[@id='submitButton']");
	By verify = By.id("idSubmit_SAOTCC_Continue");
	By staysignin = By.xpath("//div[contains(text(),'Stay signed in?')]");
	By dontshowcheckbox = By.xpath("//input[@id='KmsiCheckboxField']");
	By signinYes = By.xpath("//input[@id='idSIButton9']");
	
	public CRMLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getpwd() {
		//web element for the password field
		return driver.findElement(password);
		
	}
	
	public WebElement getsignin() {
		//web element for the signin button
		return driver.findElement(signin);
	}

	public WebElement getVerify() {
		//web element for the mobile authenticate code verification button. 
		return driver.findElement(verify);
		
	}
	
	public WebElement getstaysignin() {
		// web element for the click on stay sign in option. 
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(staysignin));
		return driver.findElement(staysignin);		
	}
	
	public WebElement getdontshowcheckbox() {
		//web element for the to click on dont show this message again checkbox
		wait = new WebDriverWait (driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(dontshowcheckbox));
		return driver.findElement(dontshowcheckbox);
	}
	
	public WebElement getsigninYes() {
		//web element for the to select option Yes on dont show this again checkbox option.
		return driver.findElement(signinYes);
		
	}
}
