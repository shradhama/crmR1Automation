package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class CRMDashboardPage {
	
		public WebDriver driver;
		public FluentWait<WebDriver> wait;
		
		public CRMDashboardPage(WebDriver driver) {

			this.driver = driver;
		}


}
