
package resources;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility extends base{

	public WebDriver driver;
	
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
}
