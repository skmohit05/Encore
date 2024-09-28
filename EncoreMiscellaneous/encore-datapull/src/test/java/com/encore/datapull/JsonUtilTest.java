package com.encore.datapull;

import java.time.Instant;

import org.junit.jupiter.api.Test;

import com.encore.datapull.model.LTJobDetail;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonUtilTest {

	@Test
	public void serializeTest() throws JsonProcessingException {
		LTJobDetail jobDetail = new LTJobDetail();
		jobDetail.setCreateDtm(Instant.now());
		String json = JsonUtil.toJson(jobDetail);
		System.out.println(json);
		jobDetail = JsonUtil.fromJson(json, LTJobDetail.class);
		System.out.println(jobDetail);
	}
}
