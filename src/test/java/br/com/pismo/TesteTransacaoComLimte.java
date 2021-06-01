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

public class TesteTransacaoComLimte {

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
	public void transacaoDeDebitoAvista() {
		TransactionsDTO dto = new TransactionsDTO(1l,1l,BigDecimal.valueOf(30));
		String body = new Gson().toJson(dto);
		
		request = new HttpEntity<>(body, headers);

		ResponseEntity<Transactions> response =  client.exchange(URL, HttpMethod.POST,request, Transactions.class);
		
		assertEquals(response.getBody().getAccount().getLimite(), BigDecimal.valueOf(70));
	}
	
	
	@Test
	public void transacaoDePagamento() {
		TransactionsDTO dto = new TransactionsDTO(1l,4l,BigDecimal.valueOf(20));
		String body = new Gson().toJson(dto);
		
		request = new HttpEntity<>(body, headers);

		ResponseEntity<Transactions> response =  client.exchange(URL, HttpMethod.POST,request, Transactions.class);
		
		assertEquals(response.getBody().getAccount().getLimite(), BigDecimal.valueOf(70));
	}
	
}
