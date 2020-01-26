package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtilities {

	public static void waitFor(String title, int timer)
	{
		/*
		 * Wait method to get title
		 */
		WebDriver driver = CreateDriver.getInstance().getDriver();
		WebDriverWait exists = new WebDriverWait(driver, timer);
		
		exists.until(ExpectedConditions.refreshed(ExpectedConditions.titleContains(title)));
	}
	
	public static void waitForURL(String url, int timer)
	{
		WebDriver driver = CreateDriver.getInstance().getDriver();
		WebDriverWait exists = new WebDriverWait(driver, timer);
		
		exists.until(ExpectedConditions.refreshed(ExpectedConditions.urlContains(url)));
	}
	
	public static void waitForClickable(By by, int timer)
	{
		WebDriver driver = CreateDriver.getInstance().getDriver();
		WebDriverWait exists = new WebDriverWait(driver, timer);
		
		exists.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));
	}
	
	public static void availableFrame(WebElement frame, int timer)
	{
		WebDriver driver = CreateDriver.getInstance().getDriver();
		WebDriverWait exists = new WebDriverWait(driver, timer);
		
		exists.until(ExpectedConditions.refreshed(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame)));
	}
	
	public static void sendKeys(WebElement element, int timer, String value)
	{
		WebDriver driver = CreateDriver.getInstance().getDriver();
		WebDriverWait exists = new WebDriverWait(driver, timer);
		
		exists.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
		element.sendKeys(value);
	}
	
	public static void click(By by)
	{
		WebDriver driver = CreateDriver.getInstance().getDriver();
		WebElement element = driver.findElement(by);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].click()", element);
	}
}
