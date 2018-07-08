package ps.example.reactive;

import java.io.IOException;
import java.rmi.activation.ActivationSystem;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Understandingp {

	public static void main(String[] args) throws Exception {
		String jsondata = "{\r\n" + 
				"  \"type\":\"object\",\r\n" + 
				"  \"properties\": {\r\n" + 
				"    \"userid\": {\r\n" + 
				"      \"type\": \"string\"\r\n" + 
				"    },\r\n" + 
				"    \"firstname\": {\r\n" + 
				"      \"type\": \"string\"\r\n" + 
				"    },\r\n" + 
				"    \"lastname\": {\r\n" + 
				"      \"type\": \"string\"\r\n" + 
				"    },\r\n" + 
				"    \"gender\": {\r\n" + 
				"      \"type\": \"string\"\r\n" + 
				"    },\r\n" + 
				"    \"emailid\": {\r\n" + 
				"      \"type\": \"string\"\r\n" + 
				"    },\r\n" + 
				"    \"phoneNumber\": {\r\n" + 
				"      \"type\": \"string\"\r\n" + 
				"    },\r\n" + 
				"    \"skillsets\": {\r\n" + 
				"      \"type\": \"java.util.List\"\r\n" + 
				"    },\r\n" + 
				"    \"employer\": {\r\n" + 
				"      \"type\": \"string\"\r\n" + 
				"    },\r\n" + 
				"    \"alumniof\": {\r\n" + 
				"      \"type\": \"java.util.List\"\r\n" + 
				"    },\r\n" + 
				"    \"address\": {\r\n" + 
				"      \"type\": \"string\"\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonnode = mapper.readTree(jsondata);
			jsonnode.get("properties").fieldNames().forEachRemaining(action -> {
				System.out.println(jsonnode.get(action));
			});
	}

}
