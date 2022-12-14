package utils;

import java.io.IOException;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import trees.Question;

public class JSONParser<T> {
	private ObjectMapper objMapper;
	private Class<T> classOfObject;
	
	public JSONParser(Class<T> classOfObject) {
		objMapper = new ObjectMapper();
		this.classOfObject = classOfObject;
	}
	
	public Optional<T> parseToObject(String json) {
		T out = null;
		try {
			out = objMapper.readValue(json, classOfObject);
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
		
		return Optional.ofNullable(out);
	}
	
	public Optional<String> parseToJSON(T object) {
		String json = null;
		try {
			json = objMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.ofNullable(json);
	}
}
