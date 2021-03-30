package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMIncentiveCategoriesPage {

	public WebDriver driver;
	public FluentWait<WebDriver> wait;



public CRMIncentiveCategoriesPage(WebDriver driver) {

	this.driver = driver;
}
}