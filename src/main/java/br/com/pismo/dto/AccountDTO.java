package br.com.pismo.dto;

import java.math.BigDecimal;

public class AccountDTO {
	private Long id;
	private String document_number;
	private BigDecimal limit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocument_number() {
		return document_number;
	}

	public void setDocument_number(String document_number) {
		this.document_number = document_number;
	}

	public BigDecimal getLimit() {
		return limit;
	}

	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
	
	

}
