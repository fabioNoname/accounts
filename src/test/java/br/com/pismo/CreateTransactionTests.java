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

import br.com.pismo.dto.TransactionsDTO;
import br.com.pismo.model.Transactions;

public class CreateTransactionTests {

	private static RestTemplate client;
	private HttpEntity<String> request;
	private static MultiValueMap<String, String> headers;
	private static URI URL;

	@BeforeAll
	public static void init()  {
		client = new RestTemplate();
		headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		try {
			URL = new URI("http://localhost:8080/transactions");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void createTransactionPagamento()throws URISyntaxException {
		TransactionsDTO dto = new TransactionsDTO(1l,4l,BigDecimal.valueOf(25.45));
		String body = new Gson().toJson(dto);
		
		request = new HttpEntity<>(body, headers);

		ResponseEntity<Transactions> response =  client.exchange(URL, HttpMethod.POST,request, Transactions.class);
		
		assertEquals(response.getBody().getAmount(), BigDecimal.valueOf(25.45));

	}

	@Test
	public void createTransactionSaque() {

		TransactionsDTO dto = new TransactionsDTO(1l,3l,BigDecimal.valueOf(10.50));
		String body = new Gson().toJson(dto);
		
		request = new HttpEntity<>(body, headers);

		ResponseEntity<Transactions> response =  client.exchange(URL, HttpMethod.POST,request, Transactions.class);
		
		assertEquals(response.getBody().getAmount().doubleValue(), Double.valueOf(-10.50));

		
	}

	@Test
	public void createTransactionCompraAvista() {

		TransactionsDTO dto = new TransactionsDTO(1l,1l,BigDecimal.valueOf(15.50));
		String body = new Gson().toJson(dto);
		
		request = new HttpEntity<>(body, headers);

		ResponseEntity<Transactions> response =  client.exchange(URL, HttpMethod.POST,request, Transactions.class);
		
		assertEquals(response.getBody().getAmount().doubleValue(), Double.valueOf(-15.50));

		
	}

	@Test
	public void createTransactionCompraParcelada() {

		TransactionsDTO dto = new TransactionsDTO(1l,2l,BigDecimal.valueOf(30.50));
		String body = new Gson().toJson(dto);
		
		request = new HttpEntity<>(body, headers);

		ResponseEntity<Transactions> response =  client.exchange(URL, HttpMethod.POST,request, Transactions.class);
		
		assertEquals(response.getBody().getAmount().doubleValue(), Double.valueOf(-30.50));

	}
}
