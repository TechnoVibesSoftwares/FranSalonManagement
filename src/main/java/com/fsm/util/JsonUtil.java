package com.fsm.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static final Logger LOGGER = LogManager.getLogger(JsonUtil.class);	

	public static String convertJavaObjectToJson(Object object) {
		ObjectMapper objectMapper = new ObjectMapper(); 
		String jsonString = null;
		try {
			jsonString = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return jsonString;
	} 
	
	public static <T> T convertJsonToJavaObject(String content, Class<T> type) {
		ObjectMapper objectMapper = new ObjectMapper(); 
		try {
			return objectMapper.readValue(content, type);
		} catch (JsonProcessingException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	} 

}
