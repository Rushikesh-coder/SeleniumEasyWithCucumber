
package com.generic.com;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapperFunctions {

	private BaseTest objBaseTest;
	private WebDriverWait objWebDriverWait;

	public WrapperFunctions(BaseTest baseTest) {
		this.objBaseTest = baseTest;
	}

	public void webDriverWaitObject() {
		objWebDriverWait = new WebDriverWait(objBaseTest.getDriver(),
				Integer.parseInt(objBaseTest.objConfig.getProperty("setExplicitlyWait")));
	}

	public boolean checkElementIsDisplayed(By locator) {
		this.setExplicitlyWait(locator);
		boolean blnFlag = false;
		try {
			blnFlag = objBaseTest.getDriver().findElement(locator).isDisplayed();
			return blnFlag;

		} catch (Exception exception) {
			System.out.println("I got Exception " + exception.getMessage());
			exception.printStackTrace();
			return blnFlag;
		}

	}

	public void scrollPage(int intScrollBy) {
		JavascriptExecutor js = (JavascriptExecutor) objBaseTest.getDriver();
		js.executeScript("window.scrollBy(0," + intScrollBy + ")");
	}

	public void setImplicitlyWait(int intTimeInSecond) {
		objBaseTest.getDriver().manage().timeouts().implicitlyWait(intTimeInSecond, TimeUnit.SECONDS);
	}

	public void setExplicitlyWait(By locator) throws NotFoundException {
		this.webDriverWaitObject();
		objWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void checkElementpresenceInDom(By locator) throws NotFoundException {
		this.webDriverWaitObject();
		objWebDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitUntilElementSelect(By locator) {
		this.webDriverWaitObject();
		objWebDriverWait.until(ExpectedConditions.elementToBeSelected(locator));
	}

	public void waitUntilButtonIsClickable(By locator) {
		this.webDriverWaitObject();
		objWebDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void setFluentWait(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(objBaseTest.getDriver()).withTimeout(Duration.ofSeconds(90))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class, TimeoutException.class);

		WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver t) {
				return objBaseTest.getDriver().findElement(locator);
			}
		});
	}

	// Element to be clickable
	public boolean elementIsclickable(By locator) {
		try {

			this.webDriverWaitObject();
			objWebDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		} catch (Exception exception) {

			System.out.println("I got Exception " + exception.getMessage());
			exception.printStackTrace();
			return false;
		}

	}

	public void navigateToHomePage() {

		objBaseTest.getDriver().findElement(By.xpath("//a[text()='Demo Home']")).click();
	}

	

//	//ceck text is displayed
//	public boolean checkIsTextIsVisble(By locator)
//	{
//		try {
//		       
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return false;
//		
//	}

}
