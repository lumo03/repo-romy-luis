package utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import trees.Question;

public class JSONParser {
	private ObjectMapper objMapper;
	public JSONParser() {
		objMapper = new ObjectMapper();
	}
	
	public Optional parseToObject(String json) {
		Question out = null;
		try {
			return objMapper.readValue(json, Question.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
