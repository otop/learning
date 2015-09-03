package dto;

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

public class JacksonUsage {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		InputStream input = new FileInputStream("src/drivers.json");
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper
				.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		TypeFactory typeFactory = TypeFactory.defaultInstance();
		List<DriverDTO> drivers = objectMapper.readValue(input,
				typeFactory.constructCollectionType(
						ArrayList.class, DriverDTO.class));

		System.out.println(drivers.get(0).getAge());
		System.out.println(drivers.get(1).getAge());

	}

}
