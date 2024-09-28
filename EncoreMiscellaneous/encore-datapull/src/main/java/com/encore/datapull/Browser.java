package com.encore.datapull;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public final class Browser implements AutoCloseable {


	private static Browser browser = new Browser();

	private final WebDriver driver;

	private Browser() {
		this.driver = createChromeDriver();
	}

	public static Browser getInstance() {
		return browser;
	}

	private WebDriver createChromeDriver() {
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		chromeDriver.manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);
//		chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return chromeDriver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void navigateOpen(final String url) {
		try {
			this.driver.get(url);
		} catch(TimeoutException e) {
		}
	}

	public void navigateClick(final WebElement element) {
		try {
			element.click();
		} catch(TimeoutException e) {
		}
	}

	public void navigateBack() {
		try {
			this.driver.navigate().back();
		} catch(TimeoutException e) {
		}
	}

	public List<WebElement> findElements(final By by) {
		return this.driver.findElements(by);
	}

	public WebElement findElement(final By by) {
		return this.driver.findElement(by);
	}

	public void close() {
		this.driver.close();
	}

	public void finalize() {
		this.close();
	}
}
