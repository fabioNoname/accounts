package br.com.pismo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.pismo.dto.AccountDTO;
import br.com.pismo.model.Transactions;

public class TesteAccountLimite {


	private static RestTemplate client;
	private HttpEntity<String> request;
	private static MultiValueMap<String, String> headers;
	private static URI URL_LIMIT;

	@BeforeAll
	public static void init()  {
		client = new RestTemplate();
		headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		try {
			URL_LIMIT = new URI("http://localhost:8080/accounts/limit/");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	

	
	
	@Test
	public void updateAccountlimit() {
		 AccountDTO accountDTO = new AccountDTO();
		 accountDTO.setId(1l);
		 accountDTO.setLimit(BigDecimal.valueOf(100d));
		String body = new Gson().toJson(accountDTO);
		
		request = new HttpEntity<>(body, headers);

		ResponseEntity<Transactions> response =  client.exchange(URL_LIMIT, HttpMethod.POST,request, Transactions.class);
		
		assertEquals(response.getBody().getAccount().getLimite(), BigDecimal.valueOf(70));
	}
}
