package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.BrowserUtilities;
import utilities.Global_VARS;

public class LaunchPO <M extends WebElement> extends BasePO<M> {
	
	private static final String LAUNCH_TITLE = "Free CRM #1 cloud software for any business large or small";
	private static final String SIGNUP_TITLE = "Cogmento CRM";
	
	public LaunchPO()
	{
		super();
		setTitle(LAUNCH_TITLE);
	}
	
	//elements
	@FindBy(xpath = "//span[contains(text(), 'Log In')]")
	protected M logIn;
	
	@FindBy(xpath = "//span[contains(text(), 'sign up')]")
	protected M signUp;
	
	
	public void navigateSignUp()
	{
		signUp.click();
		BrowserUtilities.waitFor(SIGNUP_TITLE, Global_VARS.TIMEOUT_ELEMENT);
	}
	
	
	
	@Override
	public void setTitle(String pageTitle)
	{
		this.pageTitle = pageTitle;
	}
	
	public String getTitle()
	{
		return this.pageTitle;
	}

}
