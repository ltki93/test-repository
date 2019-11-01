package com.flower.util;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {
	public static final ObjectMapper MAPPER=new ObjectMapper();
	
	public static String toJESON(Object object) {
		String result=null;
		try {
			result=MAPPER.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}
	public static <T> T toObject(String JESON,Class<T> targetclass){
		T object =null;
		try {
			object=MAPPER.readValue(JESON, targetclass);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return object;
		
	}
}
