package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import utilities.HTMLReporter;



public class WebDriverListener extends HTMLReporter implements WebDriverEventListener {

	public RemoteWebDriver webdriver;
	public EventFiringWebDriver driver;
	public int i = 1;

	public WebDriverListener() {

	}

	public void beforeAlertAccept(WebDriver driver) {
	}

	public void afterAlertAccept(WebDriver driver) {

	}

	public void afterAlertDismiss(WebDriver driver) {

	}

	public void beforeAlertDismiss(WebDriver driver) {		

	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");

	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}

	public void beforeNavigateRefresh(WebDriver driver) {


	}

	public void afterNavigateRefresh(WebDriver driver) {
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		pause(3000);
		System.out.println("Trying to click on: " + element.toString());
	}
	
	protected void pause(int j) {
		try {
			Thread.sleep(j);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {


	}

	public void beforeScript(String script, WebDriver driver) {

	}

	public void afterScript(String script, WebDriver driver) {

	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {

	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		

	}

	public void onException(Throwable throwable, WebDriver driver) {
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {

	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

	}

	public long takeSnap() {

		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".png"));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return number;
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}
 
}
