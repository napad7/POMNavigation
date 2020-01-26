package pageFactory;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtilities;
import utilities.CreateDriver;
import utilities.Global_VARS;

public abstract class BasePO<M extends WebElement> {
	
	protected String pageTitle = "";
	
	public BasePO()
	{
		PageFactory.initElements(CreateDriver.getInstance().getDriver(), this);
	}
	
	//elements
	

	
	
	protected abstract void setTitle(String pageTitle);
	protected abstract String getTitle();
	
	public void verifyTitle(String title)
	{
		WebDriver driver = CreateDriver.getInstance().getDriver();
		
		assertEquals(driver.getTitle(), title, "Verify Page Title");
	}
	
	public void navigate(String page)
	/*
	 * Wait for link to show up
	 * Click that link
	 * Wait for page title to show up
	 */
	{
		WebDriver driver = CreateDriver.getInstance().getDriver();
		
		BrowserUtilities.waitForClickable(By.xpath("//span[contains(text(), '" + page +"')]"), Global_VARS.TIMEOUT_MINUTE);
		
		driver.findElement(By.xpath("//span[contains(text(), '" + page + "')]")).click();
		
		BrowserUtilities.waitFor(this.getTitle(), Global_VARS.TIMEOUT_ELEMENT);
	}
	
	public void loadPage(String url, int timeout)
	{
		WebDriver driver = CreateDriver.getInstance().getDriver();
		
		driver.navigate().to(url);
		
		BrowserUtilities.waitForURL(Global_VARS.TARGET_URL, timeout);
	}
	
	
}
