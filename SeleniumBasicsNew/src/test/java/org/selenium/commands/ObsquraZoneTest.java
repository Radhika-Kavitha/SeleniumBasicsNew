package org.selenium.commands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ObsquraZoneTest extends BrowserLaunch
{
	
	@Test
	public void verifySimpleInputField()
	{
		String s = "hii obsqura";
		driver.get("https://selenium.qabible.in/index.php");
		WebElement inputForm = driver.findElement(By.xpath("(//div[@id='collapsibleNavbar']//li[@class='nav-item'])[1]"));
		inputForm.click();
		WebElement enterMessageField = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		enterMessageField.sendKeys(s);
		WebElement showMessageButton = driver.findElement(By.xpath("//button[@id='button-one']"));
		showMessageButton.click();
		WebElement yourMessage = driver.findElement(By.xpath("//div[@id='message-one']"));
		Assert.assertEquals(yourMessage.getText(), "Your Message : "+s, "Invalid message");
		System.out.println(yourMessage.getText());
	}
	
	@Test
	public void verifyTwoInputFields()
	{
		int a=30;
		driver.get("https://selenium.qabible.in/index.php");
		WebElement inputForm = driver.findElement(By.xpath("(//div[@id='collapsibleNavbar']//li[@class='nav-item'])[1]"));
		inputForm.click();
		WebElement enterValueA = driver.findElement(By.xpath("//input[@id='value-a']"));
		enterValueA.sendKeys("10");
		WebElement enterValueB = driver.findElement(By.xpath("//input[@id='value-b']"));
		enterValueB.sendKeys("20");
		WebElement getTotal = driver.findElement(By.xpath("//button[@id='button-two']"));
		getTotal.click();
		WebElement getTotalResult = driver.findElement(By.xpath("//div[@id='message-two']"));
		System.out.println(getTotalResult.getText());
		Assert.assertEquals(getTotalResult.getText(), "Total A + B : "+a,"Invalid output");
	}
	
	@Test
	public void verifyCheckBoxDemo()
	{
		driver.get("https://selenium.qabible.in/index.php");
		WebElement inputForm = driver.findElement(By.xpath("(//div[@id='collapsibleNavbar']//li[@class='nav-item'])[1]"));
		inputForm.click();
		WebElement checkBoxDemo = driver.findElement(By.xpath("//a[text()='Checkbox Demo']"));
		checkBoxDemo.click();
		WebElement singleCheckBoxDemo = driver.findElement(By.xpath("//input[@id='gridCheck']"));
		singleCheckBoxDemo.click();
		boolean isCheckboxSelected = singleCheckBoxDemo.isSelected();
		Assert.assertTrue(isCheckboxSelected, "Not selected");
		WebElement singleCheckBoxDemoMssg = driver.findElement(By.xpath("//div[@id='message-one']"));
		System.out.println(singleCheckBoxDemoMssg.getText());
	}
	
	@Test
	public void verifyRadioButtonDemo()
	{
		driver.get("https://selenium.qabible.in/index.php");
		WebElement inputForm = driver.findElement(By.xpath("(//div[@id='collapsibleNavbar']//li[@class='nav-item'])[1]"));
		inputForm.click();
		WebElement radioButtonDemo = driver.findElement(By.xpath("//a[text()='Radio Buttons Demo']"));
		radioButtonDemo.click();
		WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		femaleRadioButton.click();
		boolean isfemaleRadioButtonSelected = femaleRadioButton.isSelected();
		Assert.assertTrue(isfemaleRadioButtonSelected, "Not selected");
		WebElement showSelectedValueButton = driver.findElement(By.xpath("//button[text()='Show Selected Value']"));
		showSelectedValueButton.click();
		
		WebElement showSelectedValueMssg = driver.findElement(By.xpath("//div[@id='message-one']"));
		System.out.println(showSelectedValueMssg.getText());
	}
	
	@Test
	public void verifyFormWithValidation()
	{
		driver.get("https://selenium.qabible.in/index.php");
		WebElement inputForm = driver.findElement(By.xpath("(//div[@id='collapsibleNavbar']//li[@class='nav-item'])[1]"));
		inputForm.click();
		WebElement formSubmit = driver.findElement(By.xpath("//a[text()='Form Submit']"));
		formSubmit.click();
		WebElement firstName = driver.findElement(By.xpath("//input[@id='validationCustom01']"));
		firstName.sendKeys("Shai");
		WebElement lastName = driver.findElement(By.xpath("//input[@id='validationCustom02']"));
		lastName.sendKeys("Niyas");
		WebElement userName = driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
		userName.sendKeys("shay");
		WebElement city = driver.findElement(By.xpath("//input[@id='validationCustom03']"));
		city.sendKeys("Trivandram");
		WebElement state = driver.findElement(By.xpath("//input[@id='validationCustom04']"));
		state.sendKeys("Kerala");
		WebElement zip = driver.findElement(By.xpath("//input[@id='validationCustom05']"));
		zip.sendKeys("456110");
		
		WebElement formSubmitRadioButton = driver.findElement(By.xpath("//input[@id='invalidCheck']"));
		formSubmitRadioButton.click();
		boolean isformSubmitRadioButtonSelected = formSubmitRadioButton.isSelected();
		Assert.assertTrue(isformSubmitRadioButtonSelected, "Not selected");
		WebElement submitFormButton = driver.findElement(By.xpath("//button[text()='Submit form']"));
		submitFormButton.click();
		String s = "Form has been submitted successfully!";
		WebElement submitFormMssg = driver.findElement(By.xpath("//div[@id='message-one']"));
		System.out.println(submitFormMssg.getText());
		Assert.assertEquals(submitFormMssg.getText(), s, "Invalid");
	}
	
	@Test
	public void verifyColourSelectFromDropDown()
	{
		driver.get("https://selenium.qabible.in/index.php");
		WebElement inputForm = driver.findElement(By.xpath("(//div[@id='collapsibleNavbar']//li[@class='nav-item'])[1]"));
		inputForm.click();
		WebElement selectInput = driver.findElement(By.xpath("//a[text()='Select Input']"));
		selectInput.click();
		WebElement selectColourDropDown = driver.findElement(By.xpath("//select[@id='single-input-field']"));
		Select select = new Select(selectColourDropDown);
		//select.selectByVisibleText("Red");
		//select.selectByVisibleText("Yellow");
		//select.selectByVisibleText("Green");
		//select.selectByValue("Red");
		//select.selectByValue("Yellow");
		//select.selectByValue("Yellow");
		select.selectByIndex(1);
		//select.selectByIndex(2);
		//select.selectByIndex(3);
		WebElement getColourName = select.getFirstSelectedOption();
		Assert.assertEquals(getColourName.getText(),"Red","colour doesn't match");
		System.out.println(getColourName.getText());
		
	}
	
	@Test
	public void verifyColourTotalNumberOfDropDown()
	{
		driver.get("https://selenium.qabible.in/index.php");
		WebElement inputForm = driver.findElement(By.xpath("(//div[@id='collapsibleNavbar']//li[@class='nav-item'])[1]"));
		inputForm.click();
		WebElement selectInput = driver.findElement(By.xpath("//a[text()='Select Input']"));
		selectInput.click();
		WebElement selectColourDropDown = driver.findElement(By.xpath("//select[@id='single-input-field']"));
		Select select = new Select(selectColourDropDown);
		List<WebElement> colourDropDown = select.getOptions();
		System.out.println(colourDropDown.size());
	}
}
