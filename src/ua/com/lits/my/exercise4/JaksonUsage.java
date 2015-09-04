package ua.com.lits.my.exercise4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class JaksonUsage {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		// path to file
		InputStream input = new FileInputStream("test.json");
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		TypeFactory typeFactory = TypeFactory.defaultInstance();
		// mapping of json file
		List<JSONFileMapping> fileValues = objectMapper.readValue(input,
				typeFactory.constructCollectionType(ArrayList.class, JSONFileMapping.class));
		System.out.println("Request status is " + fileValues.get(0).getStatus());
		System.out.println("Country is " + fileValues.get(0).getResult().getCountry());
		Codes code = fileValues.get(0).getResult().getCodes();
		System.out.println("Admin district is " + fileValues.get(0).getResult().getCodes().getAdmin_district());
		ArrayList<Object> codes = new ArrayList<Object>();
		codes.add(code.getAdmin_district());
		codes.add(code.getAdmin_county());
		codes.add(code.getAdmin_ward());
		codes.add(code.getParish());
		codes.add(code.getCcg());
		codes.add(code.getNuts());
		for (Object elem : codes) {
			System.out.println(elem);
		}
	}

}
