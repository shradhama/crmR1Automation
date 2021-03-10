package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CRMLandingPage {

	public WebDriver driver;
	public WebDriverWait wait;
	
		By signin = By.xpath("//input[@name='loginfmt']");
		By next = By.xpath("//input[@id='idSIButton9']");
			
		public CRMLandingPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver; 			
		} 
		public WebElement getLogin() {
			//Wait till Sign In page is displayed
			wait = new WebDriverWait (driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Sign in')]")));
			return driver.findElement(signin);		
		}
				
		public WebElement getnext() {
			return driver.findElement(next);		
		}
	
}
