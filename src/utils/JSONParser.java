package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import trees.Question;

public class JSONParser {
	private ObjectMapper objMapper;
	public JSONParser() {
		objMapper = new ObjectMapper();
	}
	
	public Question parseToObject(String json) {
		
	}
}
