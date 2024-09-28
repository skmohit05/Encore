package com.encore.datapull.parser;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.encore.datapull.Browser;

public class LTResultsPageParser  {
	public List<String>  parse(final String url) {
		Browser browser = Browser.getInstance();
		browser.navigateOpen(url);
		List<WebElement> headers = browser.findElements(By.className("results-list-item-title"));
		List<String> pageUrls = new ArrayList<>();

		for (WebElement header : headers) {
			WebElement link = header.findElement(By.tagName("a"));
			String linkUrl = link.getAttribute("href");
			pageUrls.add(linkUrl);
		}
		return pageUrls;
	}
}
