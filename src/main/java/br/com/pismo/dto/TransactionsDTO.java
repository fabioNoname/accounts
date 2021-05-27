package br.com.pismo.dto;

import java.math.BigDecimal;

public class TransactionsDTO {

	private Long account_id;
	private Long operation_type_id;
	private BigDecimal amount;

	
	public TransactionsDTO() {
	}

	public TransactionsDTO(Long account_id, Long operation_type_id, BigDecimal amount) {
		this.account_id = account_id;
		this.operation_type_id = operation_type_id;
		this.amount = amount;
		
	}

	public Long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}

	public Long getOperation_type_id() {
		return operation_type_id;
	}

	public void setOperation_type_id(Long operation_type_id) {
		this.operation_type_id = operation_type_id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
