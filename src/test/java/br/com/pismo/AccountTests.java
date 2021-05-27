package br.com.pismo;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class AccountTests {

	private String body;
	
	@Test
	public void createAccountTest() {
		body = "{\r\n"+ "\"document_number\": \"12345678900\"\r\n"+ "}";
		
		RestTemplate client = new RestTemplate();
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		
		
		HttpEntity<String> request = new HttpEntity<>(body, headers);

		ResponseEntity<HttpStatus> response =  client.exchange("http://localhost:8080/accounts", HttpMethod.POST,request, HttpStatus.class);

	}
	
}
