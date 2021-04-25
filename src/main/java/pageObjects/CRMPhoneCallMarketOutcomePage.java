package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMPhoneCallMarketOutcomePage {

	public WebDriver driver;
	public FluentWait<WebDriver> wait;

	By phonecallmarketoutcomelabel = By.xpath("//span[contains(text(),'Phone Call Market Outcomes')]"); //Locator for Phone Call Market Outcomes label 
	By marketcolmnfiltericon = By.xpath("//div[@data-id='xxc_marketid']/div[1]/div/div/div[3]/i"); //Locator for Filter icon of Market column
	By filterbyoption = By.xpath("//span[contains(text(),'Filter by')]"); //Locator for Filter by option
	By selectmarketfromlist = By.xpath("//div[@id='sug-1']/div/button/span/div"); //Locator to select Market name from suggestion list
	By filterbypopupapplybtn = By.xpath("//button[@type='submit']"); //Locator for Apply button in Filter by pop-up
	By clearfilterbtn = By.xpath("//span[contains(text(),'Clear filter')]"); //Locator for Clear filter button
	By showchartbtn = By.xpath("//button[@aria-label='Show Chart']"); //Locator for Show Chart button
	By allphonecallbyownerlabel = By.xpath("//span[contains(text(),'All Phone Call by Owner')]"); //Locator for All Phone Call by Owner label
	By noofphonecallsbyowner = By.xpath("//div[@aria-label='Data']"); //Locator for No of Phone Call records by Owner
	By allphonecallschartxaxislabel = By.xpath("//div[@data-id='MscrmControls.Chart.ChartControl_container']/div[2]/div[2]/div[1]/span"); //Locator for Y-axis label of All Phone Calls chart
	By allphonecallschartyaxislabel = By.xpath("//div[@data-id='MscrmControls.Chart.ChartControl_container']/div[2]/div[2]/div[2]/span"); //Locator for X-axis label of All Phone Calls chart
	By noofphonecallsinchart = By.xpath("//div[@data-id='MscrmControls.Chart.ChartControl_container']/div[2]/div[2]/*[name()='svg']/*[local-name() = 'g'][6]/*[local-name() = 'g'][1]//*[ text()]"); //Locator for No Of Phone Calls value in Chart
	By closechartbtn = By.xpath("//button[@aria-label='Close']"); //Locator for Close Chart button
	
	public CRMPhoneCallMarketOutcomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getPhoneCallMarketOutcomeLabel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(phonecallmarketoutcomelabel));
		return driver.findElement(phonecallmarketoutcomelabel);	
	}
	public WebElement getMarketColmnFilterIcon() throws InterruptedException {
		Thread.sleep(4000);
		return driver.findElement(marketcolmnfiltericon);	
	}
	public WebElement getFilterByOption() {
		wait = new WebDriverWait (driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(filterbyoption));
		return driver.findElement(filterbyoption);	
	}
	public WebElement selectMarketFromList() throws InterruptedException {
		Thread.sleep(4000);
		return driver.findElement(selectmarketfromlist);	
	}
	public WebElement getFilterByPopupApplyBtn() {
		return driver.findElement(filterbypopupapplybtn);	
	}
	public WebElement getClearFilterBtn() {
		wait = new WebDriverWait (driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clearfilterbtn));
		return driver.findElement(clearfilterbtn);	
	}
	public WebElement getShowwChartBtn() {
		return driver.findElement(showchartbtn);	
	}
	public WebElement getAllPhoneCallsByOwnerLabel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(allphonecallbyownerlabel));
		return driver.findElement(allphonecallbyownerlabel);	
	}
	public List<WebElement> getNoOfPhoneCallsByOwner() {
		return driver.findElements(noofphonecallsbyowner);	
	}
	public WebElement getAllPhoneCallsChartYAxisLabel() {
		return driver.findElement(allphonecallschartyaxislabel);	
	}
	public WebElement getAllPhoneCallsChartXAxisLabel() {
		return driver.findElement(allphonecallschartxaxislabel);	
	}
	public WebElement getNoOfPhoneCallsInChart() {
		return driver.findElement(noofphonecallsinchart);	
	}
	public WebElement getCloseChartBtn() {
		return driver.findElement(closechartbtn);	
	}
	
}

