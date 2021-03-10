package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//this page created for to create web elements from Published App Page. 
public class AppLandingPage {

	public WebDriver driver;
	
	//defined demand driver management webelement 
	By ddmapp = By.xpath("//div[contains(text(),'Demand Driver Management')]");
	
	public AppLandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getddm () {
		//web element for the demand driver published app
		return driver.findElement(ddmapp);
		
	}
	
	
	
}
