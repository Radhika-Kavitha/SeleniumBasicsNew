package org.selenium.commands;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Commands extends BrowserLaunch
{
	@Test
	public void verifyCommunityPoll()
	{
		driver.get("https://demowebshop.tricentis.com/");
		List<WebElement> communityPoll = driver.findElements(By.xpath("//label[starts-with(@for,'pollans')]//parent::li"));
		for(int i=0;i<communityPoll.size();i++)
			{
				//System.out.println(communityPoll.get(i).getText());
				String pollOptionsText = communityPoll.get(i).getText();
				if(pollOptionsText.equals("Poor"))
				{
					communityPoll.get(i).click();
				}
			}
	}
	
	@Test
	public void verifyCurrentURL()
	{
		driver.get("https://demowebshop.tricentis.com/");
		String actualcurrentURL = driver.getCurrentUrl();
		String expectedCurrentURL = "https://demowebshop.tricentis.com/";
		Assert.assertEquals(actualcurrentURL, expectedCurrentURL, "Invalid CurrectURL");
		
		//System.out.println(currentURL);
		
	}
	
	@Test
	public void verifyTitle()
	{
		driver.get("https://demowebshop.tricentis.com/");
		String actualGettingTitle = driver.getTitle();
		String expectedTitle = "Demo Web Shop";
		Assert.assertEquals(actualGettingTitle, expectedTitle, "Invalid page title");
		//System.out.println(actualGettingTitle);
	}
	
	@Test
	public void verifyIsSelected()
	{	
		boolean isFemaleSelected;
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement radioButtonFemale =	driver.findElement(By.xpath("//input[@id='gender-female']"));
		isFemaleSelected= radioButtonFemale.isSelected();
		Assert.assertFalse(isFemaleSelected, "RadioButton is selected");
		System.out.println("female element before click: "+isFemaleSelected);
		radioButtonFemale.click();
		isFemaleSelected = radioButtonFemale.isSelected();
		Assert.assertTrue(isFemaleSelected, "RadioButton not selected");
		System.out.println("female element after click: "+isFemaleSelected);
	}
	
	@Test
	public void verifyIsDisplayed()
	{
		boolean isVoteDisplayed;
		driver.get("https://demowebshop.tricentis.com/");
		WebElement voteButton =	driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
		/*isVoteDisplayed= voteButton.isDisplayed();
		Assert.assertFalse(isVoteDisplayed, "Vote button is displayed");
		System.out.println("Vote element before click: "+isVoteDisplayed);
		voteButton.click();*/
		isVoteDisplayed= voteButton.isDisplayed();
		Assert.assertTrue(isVoteDisplayed, "Vote button not displayed");
		System.out.println("Vote element after click: "+isVoteDisplayed);
	}
	
	@Test
	public void verifyIsEnabled()
	{
		boolean isSubscribeEnabled;
		driver.get("https://demowebshop.tricentis.com/");
		WebElement subscribeButton =	driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
		/*isSubscribeEnabled= subscribeButton.isEnabled();
		Assert.assertFalse(isSubscribeEnabled, "Subscribe button is enabled");
		System.out.println("Subscribe element before click: "+isSubscribeEnabled);
		subscribeButton.click();*/
		isSubscribeEnabled= subscribeButton.isEnabled();
		Assert.assertTrue(isSubscribeEnabled, "Subscribe button not enabled");
		System.out.println("female element after click: "+isSubscribeEnabled);
	}
	
	@Test
	public void verifyEmail()
	{
		String value = "radhikaanilkumar1997@gmail.com";
		driver.get("https://demowebshop.tricentis.com/");
		WebElement loginLink = driver.findElement(By.xpath("//a[text()='Log in']"));
		loginLink.click();
		WebElement emailField = driver.findElement(By.xpath("//input[@id='Email']"));
		emailField.sendKeys(value);
		WebElement passwdField = driver.findElement(By.xpath("//input[@id='Password']"));
		passwdField.sendKeys("Ship@123");
		WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		loginButton.click();
		WebElement emailidLink = driver.findElement(By.xpath("//a[text()='radhikaanilkumar1997@gmail.com']"));
		System.out.println("Home emailid : "+emailidLink.getText());
		Assert.assertEquals(emailidLink.getText(), value,"Not valid emailId");
	}
	
	@Test
	public void verifyValuesFromDropDown()
	{
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement countryDropDown = driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(countryDropDown);
		//select.selectByVisibleText("INDIA");
		//select.selectByIndex(5); 
		select.selectByValue("AMERICAN SAMOA");
		WebElement getCountryName = select.getFirstSelectedOption();
		System.out.println(getCountryName.getText());
	}
	
	@Test
	public void verifyTotalNumberOfDropDownValues()
	{
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement countryDropDown = driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(countryDropDown);
		List<WebElement> dropDownElementList = select.getOptions();
		System.out.println(dropDownElementList.size());
	}
	
	@Test
	public void verifyMultiSelectDropDown()
	{
		driver.get("https://selenium.qabible.in/index.php");
		WebElement inputForm = driver.findElement(By.xpath("(//div[@id='collapsibleNavbar']//li[@class='nav-item'])[1]"));
		inputForm.click();
		WebElement selectInput = driver.findElement(By.xpath("//a[text()='Select Input']"));
		selectInput.click();
		WebElement multiSelect = driver.findElement(By.xpath("//select[@id='multi-select-field']"));
		Select select = new Select(multiSelect);
		boolean selectedValue = select.isMultiple();
		System.out.println("isMulti select : "+selectedValue);
		select.selectByVisibleText("Red");
		select.selectByVisibleText("Yellow");
		List<WebElement> listOfSelectedValues = select.getAllSelectedOptions();
		for(WebElement e : listOfSelectedValues )
			{
				System.out.println("getallselectedoption : "+e.getText());
			}
		select.deselectByValue("Yellow");
	}
	
	@Test
	public void verifyFileUpload()
	{
		driver.get("https://demo.guru99.com/test/upload/");	
		WebElement chooseFileField = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		chooseFileField.sendKeys("C:\\Users\\91756\\eclipse-workspace\\SeleniumBasicsNew\\src\\main\\resources");
		WebElement checkBoxField = driver.findElement(By.xpath("//input[@id='terms']"));
		checkBoxField.click();
		WebElement submitFileButton = driver.findElement(By.xpath("//button[@id='submitbutton']"));
		submitFileButton.click();
	}
	
	@Test
	public void verifyMultipleWindowHandle()
	{
		driver.get("https://demo.guru99.com/popup.php");
		String parentWindowHandleId = driver.getWindowHandle();
		System.out.println(parentWindowHandleId);
		WebElement clickHereLink = driver.findElement(By.xpath("//a[text()='Click Here']"));
		clickHereLink.click();
		Set<String> windowHandlesId= driver.getWindowHandles();
		System.out.println(windowHandlesId);
		Iterator<String> value= windowHandlesId.iterator();
			while(value.hasNext())
				{
					String handleId= value.next();
					if(!handleId.equals(parentWindowHandleId))
						{
							driver.switchTo().window(handleId);
							WebElement emailIdField = driver.findElement(By.xpath("//input[@name='emailid']"));
							emailIdField.sendKeys("radhikaanilkumar1997@gmail.com");
							WebElement submitField = driver.findElement(By.xpath("//input[@name='btnLogin']"));
							submitField.click();
							driver.close();
						}
				}
		driver.switchTo().window(parentWindowHandleId);
	}
	
	@Test
	public void validateSimpleAlert()
	{
		driver.get("https://demoqa.com/alerts");
		WebElement clickMeButton = driver.findElement(By.xpath("//button[@id='alertButton']"));
		clickMeButton.click();
		Alert alert = driver.switchTo().alert(); //interface import cheyanam
		String alertMessage = alert.getText();
		System.out.println(alertMessage);
		alert.accept();
	}
	
	@Test
	public void validateConfirmationAlert()
	{
		driver.get("https://demoqa.com/alerts");
		//sometimes scroll is necessary
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
		WebElement confirmationButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		confirmationButton.click();
		Alert alert = driver.switchTo().alert(); //interface import cheyanam
		alert.dismiss();
		WebElement confirmationResult = driver.findElement(By.xpath("//span[@id='confirmResult']"));
		String actualMssg = confirmationResult.getText();
		String expectedMssg = "You selected Cancel";
		Assert.assertEquals(actualMssg, expectedMssg, "Cancel is not selected");
	}
	
	@Test
	public void validatePromptAlert()
	{
		driver.get("https://demoqa.com/alerts");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
		WebElement propmptButton = driver.findElement(By.xpath("//button[@id='promtButton']"));
		propmptButton.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Tanu");
		alert.accept();
		WebElement promptResult = driver.findElement(By.xpath("//span[@id='promptResult']"));
		String actualMssg = promptResult.getText();
		String expectedMssg = "You entered Tanu";
		Assert.assertEquals(actualMssg, expectedMssg, "You selected Cancel");
	}
	
	@Test
	public void verifyRightClick()
	{
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightClickButton = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action = new Actions(driver);
		action.contextClick(rightClickButton).build().perform();
	}
	
	@Test
	public void verifyDoubleClick()
	{
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions action = new Actions(driver);
		action.doubleClick(doubleClickButton).build().perform();
		Alert alert = driver.switchTo().alert();
		String alertMssg = alert.getText();
		System.out.println(alertMssg);
		alert.accept();
	}
	
	@Test
	public void verifyDragAndDrop()
	{
		driver.get("https://demoqa.com/droppable");
		WebElement dragElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropElement = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
		Actions action = new Actions(driver);
		action.dragAndDrop(dragElement, dropElement).build().perform();
	}
	
	@Test
	public void verifyDragAndDropBy()
	{
		driver.get("https://demoqa.com/dragabble");
		WebElement dragElement = driver.findElement(By.xpath("//div[@id='dragBox']"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(dragElement, 150, 150).build().perform();
	}
	
	@Test
	public void verifyMouseHover()
	{
		driver.get("https://demoqa.com/menu/");
		WebElement mainItem = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
		Actions action = new Actions(driver);
		action.moveToElement(mainItem).build().perform();
		WebElement subItem = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
		action.doubleClick(subItem).build().perform();
	}
	
	@Test
	public void verifyJavaScriptClickAndSendkeys()
	{
		driver.get("https://demowebshop.tricentis.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('newsletter-email').value='radhikaanilkumar1219@gmail.com'");
		js.executeScript("document.getElementById('newsletter-subscribe-button').click()" );
	}
	
	@Test
	public void verifyVerticalScroll()
	{
		driver.get("https://demowebshop.tricentis.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	@Test
	public void verifyTakeScreenShot()
	{
		driver.get("https://demowebshop.tricentis.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "demowebshop";
		Assert.assertEquals(actualTitle, expectedTitle, "Invalid title");
	}
	
	@Test
	public void verifyFrames()
	{
		driver.get("https://demoqa.com/frames");
		List<WebElement> iframeTagCount = driver.findElements(By.tagName("iframe"));
		int size = iframeTagCount.size();
		System.out.println("Total no of iframe : "+size);
		WebElement iframe = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(iframe);
		WebElement iframeText = driver.findElement(By.id("sampleHeading"));
		String text = iframeText.getText();
		System.out.println("iframe text is : "+text);
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void verifyDifferenceBtwFindElementAndFindElements()
	{
		driver.get("https://demowebshop.tricentis.com/");
		//on match
		WebElement subscribeButton = driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
		System.out.println("WebElement on match : "+subscribeButton);
		List<WebElement> communityPoll = driver.findElements(By.xpath("//li[@class='answer']//label"));
		int communitypollSize = communityPoll.size();
		System.out.println("Communitypoll size : "+communitypollSize);
		
		//on zero match
		/*List<WebElement> communityPol = driver.findElements(By.xpath("//li[@class='answer12']//label"));
		int communitypolSize = communityPol.size();
		System.out.println("Communitypol size on zero match : "+communitypolSize);
		WebElement subscribeButon = driver.findElement(By.xpath("//input[@id='23newsletter-subscribe-button']"));
		System.out.println("WebElement on zero match : "+subscribeButon);
		*/
		//on 1 plus match
		WebElement communityPol2 = driver.findElement(By.xpath("//li[@class='answer']//label"));
		communityPol2.click();
	}
	
	@Test
	public void iFrameHW()
	{
		/*driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
    	WebElement textInput=driver.findElement(By.id("name"));
    	textInput.sendKeys("iframe");
    	WebElement iframe=driver.findElement(By.id("frm1"));
		driver.switchTo().frame(iframe);
		WebElement iframeDropdown=driver.findElement(By.xpath("//select[@id='selectnav1']"));
		Select select= new Select(iframeDropdown);
		select.selectByVisibleText("- Java");
		WebElement getSelectedValue=select.getFirstSelectedOption();
		System.out.println("DropDown1 selected value : "+getSelectedValue.getText());
		driver.switchTo().defaultContent();
		WebElement iframe2=driver.findElement(By.id("frm2"));
		driver.switchTo().frame(iframe2);
		WebElement iframe2Dropdown=driver.findElement(By.xpath("//select[@id='selectnav1']"));
		Select select2= new Select(iframe2Dropdown);
		select2.selectByVisibleText("-- Selenium Java");
		WebElement getSelected2Value=select2.getFirstSelectedOption();
		System.out.println("DropDown2 selected value : "+getSelected2Value.getText());*/
	}
	
	@Test
	public void iFrameError()
	{
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		WebElement searchField = driver.findElement(By.id("name"));
		searchField.sendKeys("iframe");
		WebElement iframe1 = driver.findElement(By.id("frm1"));
		driver.switchTo().frame(iframe1);
		WebElement iframeDropDown = driver.findElement(By.xpath("//select[@id='selectnav1']"));
		Select select = new Select(iframeDropDown);
		select.selectByVisibleText("- Dot Net");
		WebElement getSelectedValue = select.getFirstSelectedOption();
		System.out.println("Value of the selected option : "+getSelectedValue.getText());
		driver.switchTo().defaultContent();
		WebElement iframe2 = driver.findElement(By.id("frm2"));
		driver.switchTo().frame(iframe2);
		WebElement iframe2DropDown = driver.findElement(By.xpath("//select[@id='selectnav1']"));
		Select select2 = new Select(iframe2DropDown);
		select2.selectByVisibleText("- Java");
		WebElement getSelectedFrame2Value = select.getFirstSelectedOption();
		System.out.println("Value of the selected option from frame2 : "+getSelectedFrame2Value.getText());
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void verifyDynamicTable()
	{
		driver.get("https://money.rediff.com/indices");
		WebElement showMore = driver.findElement(By.id("showMoreLess"));
		showMore.click();
		WebElement webTable = driver.findElement(By.xpath("//table[@id='dataTable']//tbody"));
		List<WebElement> rows = webTable.findElements(By.tagName("tr"));
		int rowCount = rows.size();
		for(int i=0; i<rowCount; i++)
			{
				List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
				int colCount = columns.size();
				for(int j=0;j<colCount;j++)
					{
						String cellText = columns.get(j).getText();
						if(cellText.equals("S&P BSE 200"))
						{
							System.out.println("Previous close value : "+columns.get(1).getText());
						}
					}
			}
	}
	
	
	@Test
	public void verifyWaits()
	{
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement register = driver.findElement(By.className("ico-registers"));	
		register.click();
	}
	
	@Test
	public void verifyExplicitWaits()
	{
		driver.get("https://demoqa.com/alerts");
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timerAlertButton")));
		WebElement clickHere = driver.findElement(By.id("timerAlertButton"));	
		clickHere.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	@Test
	public void verifyFluentWait()
	{
		driver.get("https://demoqa.com/alerts");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
		FluentWait fluent = new FluentWait(driver);
		fluent.withTimeout(Duration.ofSeconds(20));
		fluent.pollingEvery(Duration.ofSeconds(2));
		fluent.ignoring(NoSuchElementException.class);
		fluent.until(ExpectedConditions.visibilityOfElementLocated(By.id("timerAlertButton")));
		WebElement clickHere = driver.findElement(By.id("timerAlertButton"));
		clickHere.click();
		fluent.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	@Test
	public void verifySoftAssert()
	{
		SoftAssert softAssert = new SoftAssert();
		System.out.println("********TestCase Started*********");
		softAssert.assertEquals("Hello", "Hello","1st softassert is failed");
		System.out.println("HardAssert success");
		//Assert.assertTrue("Hello".equals("hello"),"2nd soft assert is failed");
		softAssert.assertTrue("Hiii".equals("Hi"),"3rd softassert failed");
		System.out.println("********TestCase Completed Successfully************");
		softAssert.assertAll();
	}
}
