package com.encore.datapull.parser;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.encore.datapull.JsonUtil;
import com.encore.datapull.model.LTJobDetail;
import com.fasterxml.jackson.core.JsonProcessingException;

public class LTJobPageParserTest {

	@Test
	public void parseTest() throws JsonProcessingException {
		File f1 = new File("src\\test\\resources\\job_1063032.html");
		File f2 = new File("src\\test\\resources\\job_1064328.html");

		List<String> resultUrls = Arrays.asList(f1.getAbsolutePath(), f2.getAbsolutePath());

		for (String url : resultUrls) {
			LTJobPageParser jobParser = new LTJobPageParser();
			LTJobDetail job = jobParser.parse(url);
			System.out.println(JsonUtil.toJson(job));
		}
	}
}
