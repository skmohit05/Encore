package com.encore.datapull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonUtil {

	public static String toJson(final Object object) throws JsonProcessingException {
		return getObjectMapper().writeValueAsString(object);
	}

	public static <T> T fromJson(final String json, final Class<T> clazz) throws JsonMappingException, JsonProcessingException {
		return getObjectMapper().readValue(json, clazz);
	}

	private static ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		return mapper;
	}
}
