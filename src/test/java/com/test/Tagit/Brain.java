package com.test.Tagit;

import java.net.URL;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

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





public class Brain {
	
				private RemoteWebDriver driver;
			
				private WebDriverWait wait;
			
	@BeforeTest
			public void setup() throws Exception
			
				{
			
				DesiredCapabilities dc = DesiredCapabilities.chrome();
			
				URL url = new URL("http://172.12.20.99:4443/wd/hub");
			
				driver = new RemoteWebDriver(url, dc);
			
				wait = new WebDriverWait(driver, 30); 
			    }
   	    @Test(priority=1)
			
		public void login() throws InterruptedException
			
				{
			
				driver.get("https://apollo2.humanbrain.in/viewer/annotation/portal");
			
				driver.manage().window().maximize();
			
			 String currentURL = driver.getCurrentUrl();
			
			 System.out.println("Current URL: " + currentURL);
			
				WebDriverWait wait = new WebDriverWait(driver, 60);
			
				driver.switchTo().defaultContent(); // Switch back to default content
			
				WebElement viewerElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Viewer']")));
			
				if (viewerElement.isEnabled() && viewerElement.isDisplayed()) {
			
				viewerElement.click();
			
				System.out.println("Viewer icon is clicked");
			
				} else {
			
				System.out.println("Viewer icon is not clickable");
			
				}	
			 String parentWindow = driver.getWindowHandle();
			
			 WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
			
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
			
			 WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
			
			 if (emailInput != null && emailInput.isDisplayed()) {
			
			 emailInput.sendKeys("softwareteam45@gmail.com");
			
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
			 WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));
			
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
			 System.out.println("************************Login validation done***********************"); 
			
				}
			
		@Test(priority=2)
			
		public void brain_tag_it() throws InterruptedException {
			
				WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search tags']")));
			
			 if (searchBar != null && searchBar.isDisplayed()) {
			
			 searchBar.sendKeys("29", Keys.ENTER);
			
			 System.out.println("Biosample ID entered successfully");
			
			 } else {
			
			 System.out.println("Biosample ID was not entered.");
			
			 }
			
			 Thread.sleep(3000);
			 WebElement redirectIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//nb-card-footer[@class='p-2'])[1]/nb-icon")));
			
			 if (redirectIcon != null && redirectIcon.isDisplayed()) {
			
			 redirectIcon.click();
			
			 System.out.println("Brain was clicked successfully");
			
			 } else {
			
			 System.out.println("Brain was not clicked");
			
			 }
			
			 Thread.sleep(3000);
			 String parentWindow = driver.getWindowHandle();
			
			 wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			
				Set<String> allWindows = driver.getWindowHandles();
			
			 for (String window : allWindows) {
			
			 if (!window.equals(parentWindow)) {
			
			 driver.switchTo().window(window);
			
			 break;
			
			 }
			
			 }
			
			 WebElement brainSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='335'])[1]")));
			
			 if (brainSection != null && brainSection.isDisplayed()) {
			
			 brainSection.click();
			
			 System.out.println("Section clicked successfully");
			
			 } else {
			
			 System.out.println("Section is not clicked");
			
			 }
			
			 Thread.sleep(3000); 
			 //Tag_IT code is given below
			
			 WebElement TagIT = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Tag IT']")));
			
			 if (TagIT != null && TagIT.isDisplayed()) {
			
			 TagIT.click();
			
			 System.out.println("Tag IT button clicked successfully");
			
			 } else {
			
			 System.out.println("Tag IT button is not clickable");
			
			 }
			
			 Thread.sleep(3000);
			 WebElement organType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select")));
			
				if (organType != null && organType.isDisplayed()) {
			
				organType.click();
			
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[@value='brain']"))).click();
			
				System.out.println("Type as Brain was selected successfully");
			
				} else {
			
				System.out.println("Type was not selected");
			
				}
			
				Thread.sleep(3000);
			
				WebElement searchTag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input)[1]")));
			
				if (searchTag != null && searchTag.isDisplayed()) {
			
				searchTag.sendKeys("Goat_Brain4");
			
				System.out.println("Tag entered successfully");
			
				} else {
			
				System.out.println("Tag was not entered.");
			
				}
			
				Thread.sleep(3000);
				WebElement buttonAdd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='ADD']")));
			
				if (buttonAdd != null && buttonAdd.isDisplayed()) {
			
				buttonAdd.click();
			
				System.out.println("Add button clicked successfully");
			
				} else {
			
				System.out.println("Add button was not clickable");
			
				}
			
				Thread.sleep(3000);
			
			 driver.switchTo().window(parentWindow);
			
			 System.out.println("\n\n ************************Brain Tag IT done***********************"); 
			
				}
			
		@Test(priority=3)
			
	     public void tagIT_Search() throws InterruptedException {
			
			 WebElement listTags = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nb-accordion-item-header[text()='List Tags']")));
			
				if (listTags != null && listTags.isDisplayed()) {
			
				listTags.click();
			
				System.out.println("List Tags clicked successfully");
			
				} else {
			
				System.out.println("List Tags was not clickable");
			
				}
			
				Thread.sleep(3000);
			
				WebElement brain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nb-accordion-item-header[text()='Brain']")));
			
				if (brain != null && brain.isDisplayed()) {
			
				brain.click();
			
				System.out.println("Brain clicked successfully");
			
				} else {
			
				System.out.println("Brain was not clickable");
			
				}
			
				Thread.sleep(3000);
				WebElement brainTag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Goat_Brain4'])[1]")));
			
				if (brainTag != null && brainTag.isDisplayed()) {
			
				brainTag.click();
			
				System.out.println("Brain Tags selected successfully");
			
				} else {
			
				System.out.println("Brain Tags was not selected");
			
				Assert.fail("Element with text 'Goat_Brain4' not found");
			
			}
			
				Thread.sleep(3000);
			
				
			
				WebElement enterButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nb-icon[@class='custom-icon search-submit']")));
			
				if (enterButton != null && enterButton.isDisplayed()) {
			
				enterButton.click();
			
				System.out.println("Brain Tags entered successfully");
			
				} else {
			
				System.out.println("Brain Tags was not clickable");
			
				}
			
				Thread.sleep(3000);
			
			 System.out.println("\n\n ************************Tags search done***********************"); 
			
			 }
		@Test(priority=4)
			
				public void viewer() throws InterruptedException {
			
				WebElement redirectIcon2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//nb-card-footer[@class='p-2'])[1]/nb-icon")));
			
			 if (redirectIcon2 != null && redirectIcon2.isDisplayed()) {
			
			 redirectIcon2.click();
			
			 System.out.println("Brain was clicked successfully");
			
			 } else {
			
			 System.out.println("Brain was not clickable");
			
			 }
			
			 Thread.sleep(3000);
			
			 
			
			 String parentWindow = driver.getWindowHandle();
			
			 
			
			 wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			
				Set<String> allWindows = driver.getWindowHandles();
			
			 for (String window : allWindows) {
			
			 if (!window.equals(parentWindow)) {
			
			 driver.switchTo().window(window);
			
			 break;
			
			 }
			
			 }
			WebElement brainSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='335'])[1]")));
			
			 if (brainSection != null && brainSection.isDisplayed()) {
			
			 brainSection.click();
			
			 System.out.println("Section clicked successfully");
			
			 } else {
			
			 System.out.println("Section is not clicked"); }
			
			 Thread.sleep(3000); 
			 String[] expectedFileName = {"SS-14"}; 
			
				java.util.List<WebElement> locationElements = driver.findElements(By.xpath("(//div[@class='paragraph'])[1]"));
			
				String actualFileName = locationElements.get(0).getText();
			
			 Thread.sleep(2000);
			
				Assert.assertEquals(actualFileName, expectedFileName[0], "FileName not matching.");
			
				System.out.println("Brain loaded successfully.");
				System.out.println("\n\n ************************Brain viewer validation done***********************"); 
			}
			
	    @AfterTest
         public void afterTest() {
			
			 driver.quit();
			
			 }



}
