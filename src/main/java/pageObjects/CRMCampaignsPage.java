package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMCampaignsPage {

	public WebDriver driver;
	public FluentWait<WebDriver> wait;

	By createnewcampaignbtn = By.xpath("//button[@aria-label='New']"); //Locator for New button on Campaigns grid
	By newcampaignpagetitle = By.xpath("//h1[@title='New Campaign']"); //Locator for New Campaign page title
	By campaignnametxtbx = By.xpath("//input[@aria-label='Name']"); //Locator for Campaign name text box
	By junipercampaignvalue = By.xpath("//select[@aria-label='Juniper Campaign?']"); //Locator for Juniper Campaign field value
	By savebtn = By.xpath("//button[@aria-label='Save']"); //Locator for Save button on Campaign form
	By campaigncodevalue = By.xpath("//input[@aria-label='Campaign Code']"); //Locator for Campaign Code value
	By savenclosebtn = By.xpath("//button[@aria-label='Save & Close']"); //Locator for Save & Close button
	
	public CRMCampaignsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getNewCampaignPageTitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newcampaignpagetitle));
		return driver.findElement(newcampaignpagetitle);
	}
	public WebElement getCreateNewCampaignBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(createnewcampaignbtn));
		return driver.findElement(createnewcampaignbtn);
	}
	public WebElement getCampaignNameTextBox() {
		return driver.findElement(campaignnametxtbx);
	}
	public WebElement getJuniperCampaignValue() {
		return driver.findElement(junipercampaignvalue);
	}
	public WebElement getSaveBtnOnCampaignForm() {
		return driver.findElement(savebtn);
	}
	public WebElement getCampaignCodeValue() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(campaigncodevalue);
	}
	public WebElement getSavenCloseBtn() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(savenclosebtn);
	}
	
	
}

