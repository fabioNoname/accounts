package br.com.pismo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.SystemException;

@Entity
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account account;
	@OneToOne
	@JoinColumn(name = "operation_type_id", referencedColumnName = "id")
	private OperationType operationType;
	private BigDecimal amount;
	private LocalDateTime eventDate;

	public Transactions() {
		this.eventDate = LocalDateTime.now();
	}

	public Transactions(Account account2, OperationType operationType2, BigDecimal amount2) throws SystemException {
		OperationEnum opertion = OperationEnum.findByDescription(operationType2.getDescription());
		
		this.eventDate = LocalDateTime.now();
		this.account = account2;
		this.amount = amount2.multiply(opertion.getFator()) ;
		this.operationType = operationType2;
	}

	public Long getId() {
		return id;
	}


	public Account getAccount() {
		return account;
	}

	public OperationType getOperationType() {
		return operationType;
	}


	public BigDecimal getAmount() {
		return amount;
	}

	public LocalDateTime getEventDate() {
		return eventDate;
	}

}
