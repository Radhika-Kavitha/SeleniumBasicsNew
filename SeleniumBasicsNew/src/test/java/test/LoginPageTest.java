package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.constants.Constants;
import org.selenium.constants.Messages;
import org.selenium.utilities.ExcelUtility;
import org.selenium.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import dataprovider.DataProviders;
import pages.HomePage;
import pages.LoginPage;
import pages.UserAccountPage;

public class LoginPageTest extends Base
{
  @Test(priority=5,groups="Sanity")
  public void verifyLoginPageTitle() throws IOException 
  {
	  //WebElement loginLink = driver.findElement(By.xpath("//a[text()='Log in']"));
	  //loginLink.click();
	  HomePage home = new HomePage(driver);
	  LoginPage login = home.clickOnLoginMenu();
	  String actualTitle = driver.getTitle();
	  //System.out.println(actualTitle);//Demo Web Shop. Login
	  String data = ExcelUtility.stringDataRead(0, 0, Constants.LOGIN_PAGE_DATA)+"123";
	  Assert.assertEquals(actualTitle, data, Messages.TITLE_MESSAGES);
  }
  
  @Test(priority=6,enabled=false,groups={"Smoke" ,"Regression"})
  public void verifyUserLogin() throws IOException
  {
	  String email = ExcelUtility.stringDataRead(0, 1, Constants.LOGIN_PAGE_DATA);
	  String password = ExcelUtility.stringDataRead(2, 1, Constants.LOGIN_PAGE_DATA);
	  //WebElement loginLink = driver.findElement(By.xpath("//a[text()='Log in']"));
	  //loginLink.click();
	  HomePage home = new HomePage(driver);
	  LoginPage login = home.clickOnLoginMenu();
	  //WebElement emailField = driver.findElement(By.xpath("//input[@id='Email']"));
	  //emailField.sendKeys(email);
	  LoginPage login_page = new LoginPage(driver);
	  login_page.enterUserName(email);
	  //WebElement passwordField = driver.findElement(By.xpath("//input[@id='Password']"));
	  //passwordField.sendKeys(password);
	  login_page.enterPassword(password);
	  //WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
	  //loginButton.click();
	  UserAccountPage user_page = login_page.clickOnLoginButton();
	 // WebElement homeEmail = driver.findElement(By.xpath("(//a[@class='account'])[1]"));
	  //String actual_homeEmail = homeEmail.getText();
	  UserAccountPage user = new UserAccountPage(driver);
	  String userText = user.userGetText();
	  Assert.assertEquals(userText, email, Messages.USERLOGIN_MESSAGES);
  }
  
  @Test(priority=7,groups="Sanity",dataProvider = "InvalidUserCredentials",dataProviderClass = DataProviders.class)
  public void verifyUserLoginWithInvalidCredentials(String userName, String password) throws IOException
  {
	  //String email = ExcelUtility.stringDataRead(4, 0, Constants.LOGIN_PAGE_DATA);
	 // String password = ExcelUtility.stringDataRead(4, 1, Constants.LOGIN_PAGE_DATA);
	  String expectedErrorMssg = ExcelUtility.stringDataRead(4, 2, Constants.LOGIN_PAGE_DATA);
	 // WebElement loginLink = driver.findElement(By.xpath("//a[text()='Log in']"));
	  //loginLink.click();
	  HomePage home = new HomePage(driver);
	  LoginPage login = home.clickOnLoginMenu();
	  //WebElement emailField = driver.findElement(By.xpath("//input[@id='Email']"));
	  //emailField.sendKeys(userName);
	  LoginPage login_page = new LoginPage(driver);
	  login_page.enterUserName(userName);
	  //WebElement passwordField = driver.findElement(By.xpath("//input[@id='Password']"));
	  //passwordField.sendKeys(password);
	  login_page.enterPassword(password);
	  //WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
	  //loginButton.click();
	  UserAccountPage user_page = login_page.clickOnLoginButton();
	  //WebElement errorMssg = driver.findElement(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));
	  String actualErrorMssg = login_page.userGetText();
	  Assert.assertEquals(actualErrorMssg, expectedErrorMssg, Messages.LOGIN_FAILED_WARNINGMESSAGES_NOTFOUND);
  }
}
