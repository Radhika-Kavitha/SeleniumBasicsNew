package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.utilities.WebElementUtility;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
		{
			this.driver=driver;		
			PageFactory.initElements(driver, this); 
		}
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailField;
	@FindBy(xpath = "//input[@id='Password']")
	WebElement passwordField;
	@FindBy(xpath = "//input[@class='button-1 login-button']")
	WebElement loginButton;
	@FindBy (xpath = "//span[text()='Login was unsuccessful. Please correct the errors and try again.']")
	WebElement errorMessage;
	public void enterUserName(String userName)
	{
		WebElementUtility.enterValue(emailField, userName);
	}
	public void enterPassword(String pass_word)
	{
		WebElementUtility.enterValue(passwordField, pass_word);
	}
	public UserAccountPage clickOnLoginButton()
	{
		WebElementUtility.clickOnElement(loginButton);
		return new UserAccountPage(driver);
	}
	public String userGetText()
	{
		String text = WebElementUtility.getText(errorMessage);
		return text;
	}
}
