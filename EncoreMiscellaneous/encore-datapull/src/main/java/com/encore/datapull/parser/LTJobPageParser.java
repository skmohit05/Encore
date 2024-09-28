package com.encore.datapull.parser;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.encore.datapull.Browser;
import com.encore.datapull.model.LTJobDetail;

public class LTJobPageParser {

	public LTJobDetail parse(final String url) {
		Browser browser = Browser.getInstance();
		browser.navigateOpen(url);

		LTJobDetail job = new LTJobDetail();
		job.setHeader(browser.findElement(By.className("job-details-title")).getText());
		job.setDatePosted(browser.findElement(By.className("results-list-item-details-date")).getText().split("Date posted:")[1].trim());
		job.setLocation(browser.findElement(By.className("results-list-item-details-location")).getText().split("Location:")[1].trim());


		WebElement descElement = browser.findElement(By.className("job-details-description"));
		List<WebElement> paraElements = descElement.findElements(By.tagName("p"));
		String desc1 = "";
		for (WebElement paraElement : paraElements) {
			desc1 = desc1 + paraElement.getText() + "\n";
		}
		job.setDesc1(desc1);
		job.setDesc2(descElement.findElement(By.tagName("ul")).getText());


		List<WebElement> headerElements = browser.findElements(By.className("job-details-contact-header")).stream().filter(element -> {
			return element.getText().equalsIgnoreCase("Contact Information") || element.getText().equalsIgnoreCase("Job Details");
		}).collect(Collectors.toList());
		List<WebElement> detailsElements = browser.findElements(By.className("job-details-table"));
		for (int i = 0; i < headerElements.size(); i++) {
			Pair<String, Map<String, String>> detailsPair = processDetails(headerElements.get(i), detailsElements.get(i));
			String name = detailsPair.getLeft();
			if (name.equalsIgnoreCase("Contact Information")) {
				job.setContactDetails(detailsPair.getRight());
			} else if (name.equalsIgnoreCase("Job Details")) {
				job.setJobDetails(detailsPair.getRight());
			}
		}

		job.setCreateDtm(Instant.now());
		return job;
	}

	private Pair<String, Map<String, String>> processDetails(WebElement headerElement, WebElement detailsElement) {
		Map<String, String> details = new HashMap<>();
		List<WebElement> rowElements = detailsElement.findElements(By.tagName("tr"));
		for (WebElement rowElement : rowElements) {
			List<WebElement> dataElements = rowElement.findElements(By.tagName("td"));
			if (dataElements == null || dataElements.size() < 1 || dataElements.get(0) == null) {
				continue;
			}
			String name = dataElements.get(0).getText();
			String value = dataElements.get(1).getText();
			details.put(name, value);
		}

		return Pair.of(headerElement.getText(), details);
	}
}
