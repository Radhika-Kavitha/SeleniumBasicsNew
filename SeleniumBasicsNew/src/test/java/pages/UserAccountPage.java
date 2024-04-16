package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.utilities.WebElementUtility;

public class UserAccountPage 
{
	WebDriver driver;
	public UserAccountPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@class='account'])[1]")
	WebElement homeEmail;
	
	public String userGetText()
	{
		String text = WebElementUtility.getText(homeEmail);
		return text;
	}
	
}
