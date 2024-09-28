package com.encore.datapull.parser;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LTResultsPageParserTest {

	@Test
	public void parseTest() {
		LTResultsPageParser parser = new LTResultsPageParser();
		File file = new File("src\\test\\resources\\lt_results.html");
		List<String> resultUrls = parser.parse(file.getAbsolutePath());
		for(String url : resultUrls) {
			System.out.println(url);
		}
	}
}
