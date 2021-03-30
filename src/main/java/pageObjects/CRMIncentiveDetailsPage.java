package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class CRMIncentiveDetailsPage {
	
	public WebDriver driver;
	public FluentWait<WebDriver> wait;
	
	public CRMIncentiveDetailsPage(WebDriver driver) {

		this.driver = driver;
	}

}
