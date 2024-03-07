package com.test.Tagit;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Set;



public class Access_History {
	
	private RemoteWebDriver driver;
	private WebDriverWait wait;

	@BeforeTest

	public void setup() throws Exception {
	DesiredCapabilities dc = DesiredCapabilities.chrome();
	URL url = new URL("http://172.20.23.7:5555/wd/hub");
	driver = new RemoteWebDriver(url, dc);
	wait = new WebDriverWait(driver, 30);

	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
	driver.get("https://apollo2.humanbrain.in/viewer/annotation/portal");
	driver.manage().window().maximize();
	String currentURL = driver.getCurrentUrl();
	System.out.println("Current URL: " + currentURL);
	WebDriverWait wait = new WebDriverWait(driver, 60);
	driver.switchTo().defaultContent(); // Switch back to default content
	WebElement viewerElement = wait
	.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Viewer']")));
	if (viewerElement.isEnabled() && viewerElement.isDisplayed()) {
	viewerElement.click();
	System.out.println("Viewer icon is clicked");
	} else {
	System.out.println("Viewer icon is not clickable");
	}

	String parentWindow = driver.getWindowHandle();
	WebElement loginButton = wait
	.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
	if (loginButton != null) {
	loginButton.click();
	System.out.println("Login button clicked successfully.");
	} else {
	System.out.println("Login button is not clicked.");
	}

	wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	Set<String> allWindows = driver.getWindowHandles();
	for (String window : allWindows) {
	if (!window.equals(parentWindow)) {
	driver.switchTo().window(window);
	break;
	}
	}
	WebElement emailInput = wait
	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
	if (emailInput != null && emailInput.isDisplayed()) {
	emailInput.sendKeys("teamsoftware457@gmail.com");
	System.out.println("Email was entered successfully.");
	} else {
	System.out.println("Email was not entered.");
	}

	WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	if (nextButton1 != null) {
	nextButton1.click();
	System.out.println("Next button 1 is clicked.");
	} else {
	System.out.println("Next button 1 is not clicked.");
	}

	WebElement passwordInput = wait.until(
	ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));
	passwordInput.sendKeys("Health#123");
	if (passwordInput.getAttribute("value").equals("Health#123")) {
	System.out.println("Password was entered successfully.");
	} else {
	System.out.println("Password was not entered.");
	}

	WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	if (nextButton2 != null) {
	nextButton2.click();
	System.out.println("Next button 2 is clicked.");
	} else {
	System.out.println("Next button 2 is not clicked.");
	}

	driver.switchTo().window(parentWindow);
	System.out.println("Login successfully");

	System.out.println("************************Login validation done***********************\n\n");
	}

	@Test(priority = 2)
	public void History_Test_brain() throws InterruptedException {
	Thread.sleep(5000);
	WebElement scrollableSection = wait.until(ExpectedConditions
	.visibilityOfElementLocated(By.xpath("(//div[@class='details history-details'])[2]")));
	Thread.sleep(300);
	WebElement elementToFind = wait.until(
	ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='  Biosample ID - 29  '])[2]")));

	// Scroll to the element in the scrollable section
	scrollUntilElementIsFound(scrollableSection, elementToFind);
	String parentWindow3 = driver.getWindowHandle();

	elementToFind.click();
	Set<String> allWindows = driver.getWindowHandles();
	for (String window : allWindows) {
	if (!window.equals(parentWindow3)) {
	driver.switchTo().window(window);
	break;
	}
	}

	WebElement brainSection = wait
	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='340'])[1]")));
	if (brainSection != null && brainSection.isDisplayed()) {
	brainSection.click();
	System.out.println("Section clicked successfully");
	} else {
	System.out.println("Section is not clicked");
	}
	Thread.sleep(3000);

	String[] expectedFileName = { "SS-14" };

	java.util.List<WebElement> locationElements = driver.findElements(By.xpath("(//div[@class='paragraph'])[1]"));
	String actualFileName = locationElements.get(0).getText();
	Thread.sleep(2000);

	Assert.assertEquals(actualFileName, expectedFileName[0], "FileName not matching.");
	System.out.println("Brain loaded successfully.");
	System.out.println("\n\n ************************Brain viewer validation done***********************\n\n");

	driver.close();
	driver.switchTo().window(parentWindow3);

	}

	@Test(priority = 3)
	public void History_Test_Section_cell() throws InterruptedException {
	Thread.sleep(3000);
	WebElement scrollableSection = driver.findElement(By.xpath("(//div[@class='details history-details'])[2]"));
	Thread.sleep(3000);
	WebElement elementToFind = driver.findElement(By.xpath("//li[text()='  SEC ID - 2375  ']"));

	// Scroll to the element in the scrollable section
	scrollUntilElementIsFound(scrollableSection, elementToFind);
	String parentWindow3 = driver.getWindowHandle();

	elementToFind.click();
	Thread.sleep(5000);

	Set<String> allWindows = driver.getWindowHandles();
	for (String window : allWindows) {
	if (!window.equals(parentWindow3)) {
	driver.switchTo().window(window);
	break;
	}
	}

	Thread.sleep(3000);
	String[] expectedFileName = { "16 | NISSL | 505 | 0" };

	java.util.List<WebElement> locationElements = driver.findElements(By.xpath("(//div[@class='paragraph'])[1]"));
	String actualFileName = locationElements.get(0).getText();
	Thread.sleep(2000);

	Assert.assertEquals(actualFileName, expectedFileName[0], "FileName not matching.");
	System.out.println("Brain loaded successfully.");
	System.out.println("\n\n ************************Cell Annotation validation done***********************\n\n");

	driver.close();
	driver.switchTo().window(parentWindow3);
	}

	@Test(priority = 4)
	public void History_Test_Section_Atlas() throws InterruptedException {
	Thread.sleep(9000);
	WebElement scrollableSection = driver.findElement(By.xpath("(//div[@class='details history-details'])[2]"));
	Thread.sleep(300);
	WebElement elementToFind = driver.findElement(By.xpath("//li[text()='  SEC ID - 2341  ']"));

	// Scroll to the element in the scrollable section
	scrollUntilElementIsFound(scrollableSection, elementToFind);
	String parentWindow5 = driver.getWindowHandle();

	elementToFind.click();
	Thread.sleep(5000);
	Set<String> allWindows = driver.getWindowHandles();
	for (String window3 : allWindows) {
	if (!window3.equals(parentWindow5)) {
	driver.switchTo().window(window3);
	break;
	}
	}

	Thread.sleep(3000);

	String[] expectedFileName = { "16 | NISSL | 364" };

	java.util.List<WebElement> locationElements = driver.findElements(By.xpath("(//div[@class='paragraph'])[1]"));
	String actualFileName = locationElements.get(0).getText();
	Thread.sleep(2000);

	Assert.assertEquals(actualFileName, expectedFileName[0], "FileName not matching.");
	System.out.println("Brain loaded successfully.");
	System.out.println("\n\n ************************Atlas Annotation validation done***********************\n\n");
	Thread.sleep(2000);
	driver.close();
	//   driver.switchTo().window(parentWindow5);

	}

	private void scrollUntilElementIsFound(WebElement scrollableSection, WebElement element) {
	boolean scrollingDown = true;
	while (!isElementInViewPort(scrollableSection, element)) {

	if (scrollingDown) {
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollBy(0, 50);", scrollableSection);
	} else {
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollBy(0, -50);", scrollableSection);
	}

	// Check if reached the end or beginning of the scrollable section
	boolean reachedEnd = (Boolean) ((JavascriptExecutor) driver).executeScript(
	"return arguments[0].scrollHeight <= (arguments[0].scrollTop + arguments[0].clientHeight);",
	scrollableSection);
	boolean reachedTop = (Boolean) ((JavascriptExecutor) driver)
	.executeScript("return arguments[0].scrollTop === 0;", scrollableSection);

	if (reachedEnd || reachedTop) {
	// Change direction
	scrollingDown = !scrollingDown;
	}
	}
	}

	private boolean isElementInViewPort(WebElement scrollableSection, WebElement element) {
	String script = "var elem = arguments[0], " + "    section = arguments[1], "
	+ "    box = elem.getBoundingClientRect(), " + "    sectionBox = section.getBoundingClientRect(); "
	+ "return (box.top >= sectionBox.top && " + "        box.left >= sectionBox.left && "
	+ "        box.bottom <= sectionBox.bottom && " + "        box.right <= sectionBox.right);";
	return (boolean) ((JavascriptExecutor) driver).executeScript(script, element, scrollableSection);
	}

	@AfterTest
	public void afterTest() {
	driver.quit();
	}

}
