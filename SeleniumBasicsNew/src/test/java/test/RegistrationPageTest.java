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
import pages.HomePage;
import pages.RegistrationConfirmationPage;
import pages.RegistrationPage;
import pages.UserAccountPage;

public class RegistrationPageTest extends Base
{
  @Test(priority=4,enabled=false,groups="Smoke")
  public void verifyRegisterPageTitle() throws IOException
  {
	 // WebElement registerLink = driver.findElement(By.xpath("//a[text()='Register']"));
	 // registerLink.click();
	  HomePage home = new HomePage(driver);
	  RegistrationPage register = home.clickOnRegisterMenu();	  
	  String actualTitle = driver.getTitle();
	  //System.out.println(actualTitle);
	  String data = ExcelUtility.stringDataRead(0, 0, Constants.REGISTER_PAGE_DATA);
	  Assert.assertEquals(actualTitle, data, Messages.TITLE_MESSAGES);
  }
  
  @Test(priority=3,groups="Regression")
  public void verifyUserRegister() throws IOException
  {
	  
	 /* String firstName = RandomDataUtility.getFirstName();
	  String lastName = RandomDataUtility.getLastName();
	  //String emailId_Field = ExcelUtility.stringDataRead(3, 0, Constants.REGISTER_PAGE_DATA);
	  String emailId_Field = firstName+"."+lastName+"7864@yahoo.com";
	  //String password_Field = ExcelUtility.stringDataRead(4, 0, Constants.REGISTER_PAGE_DATA);
	  String password_Field = firstName+"."+lastName;
	  //String confirmPassword_Field = ExcelUtility.stringDataRead(4, 0, Constants.REGISTER_PAGE_DATA);
	  //WebElement registerLink = driver.findElement(By.xpath("//a[text()='Register']"));
	  //registerLink.click();
	  HomePage home = new HomePage(driver);
	  RegistrationPage register = home.clickOnRegisterMenu();
	  RegistrationPage register_Page = new RegistrationPage(driver);
	  WebElement gender = driver.findElement(By.xpath("//input[@id='gender-male']"));
	  gender.click();
	  //WebElement firstName_Field = driver.findElement(By.xpath("//input[@id='FirstName']"));
	  //firstName_Field.sendKeys(firstName);
	  register_Page.enterFirstName(firstName);
	 // WebElement lastName_Field = driver.findElement(By.xpath("//input[@id='LastName']"));
	  //lastName_Field.sendKeys(lastName);
	  register_Page.enterLastName(lastName);
	  //WebElement emailId = driver.findElement(By.xpath("//input[@id='Email']"));
	  //emailId.sendKeys(emailId_Field);
	  register_Page.enterEmailField(emailId_Field);
	  //WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
	  //password.sendKeys(password_Field);
	  register_Page.enterPassword(password_Field);
	  //WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
	  //confirmPassword.sendKeys(password_Field);
	  register_Page.enterConfirmPassword(password_Field);
	  //WebElement RegisterButton = driver.findElement(By.xpath("//input[@id='register-button']"));
	  //RegisterButton.click();
	  UserAccountPage usersPage = register_Page.clickOnRegisterButton();
	  //WebElement userEmailField = driver.findElement(By.xpath("(//a[@class='account'])[1]"));
	  //String actualEmailID = userEmailField.getText();
	  UserAccountPage user = new UserAccountPage(driver);
	  String userText = user.userGetText();
	  Assert.assertEquals(userText, emailId_Field,Messages.REGISTRATION_MESSAGES);*/
	  
	  
	  String firstName = RandomDataUtility.getFirstName();
	  String lastName = RandomDataUtility.getLastName();
	  String emailId_Field = firstName+"."+lastName+"7864@yahoo.com";
	  String password_Field = firstName+"."+lastName;
	  
	  HomePage home = new HomePage(driver);
	  RegistrationPage register = home.clickOnRegisterMenu();
	  
	  
	  WebElement gender = driver.findElement(By.xpath("//input[@id='gender-male']"));
	  gender.click();
	  WebElement firstName_Field = driver.findElement(By.xpath("//input[@id='FirstName']"));
	  firstName_Field.sendKeys(firstName);
	  WebElement lastName_Field = driver.findElement(By.xpath("//input[@id='LastName']"));
	  lastName_Field.sendKeys(lastName);
	  WebElement emailId = driver.findElement(By.xpath("//input[@id='Email']"));
	  emailId.sendKeys(emailId_Field);
	  WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
	  password.sendKeys(password_Field);
	  WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
	  confirmPassword.sendKeys(password_Field);
	  RegistrationPage register_Page = new RegistrationPage(driver);
	 // WebElement RegisterButton = driver.findElement(By.xpath("//input[@id='register-button']"));
	 // RegisterButton.click();
	  RegistrationConfirmationPage usersPage = register_Page.clickOnRegisterButton();
	  RegistrationConfirmationPage user = new RegistrationConfirmationPage(driver);
	  WebElement userEmailField = driver.findElement(By.xpath("(//a[@class='account'])[1]"));
	  String userText = user.userGetText();
	  Assert.assertEquals(userText, emailId_Field,Messages.REGISTRATION_MESSAGES);
	  //String actualEmailID = userEmailField.getText();
	  //Assert.assertEquals(actualEmailID, emailId_Field,Messages.REGISTRATION_MESSAGES);
  }
}
