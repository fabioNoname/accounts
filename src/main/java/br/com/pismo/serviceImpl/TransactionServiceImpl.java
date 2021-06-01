package br.com.pismo.serviceImpl;

import java.util.Optional;

import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.pismo.dto.TransactionsDTO;
import br.com.pismo.model.Account;
import br.com.pismo.model.OperationType;
import br.com.pismo.model.Transactions;
import br.com.pismo.service.AccountService;
import br.com.pismo.service.OperationTypeService;
import br.com.pismo.service.TransactionService;

public class TransactionServiceImpl {
	
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private OperationTypeService operationTypeService;
	@Autowired
	private AccountService accountService;
	
	public Transactions createTransaction(TransactionsDTO transactionDto) throws SystemException {
		Optional<OperationType> operationType = operationTypeService.findById(transactionDto.getOperation_type_id());
		Optional<Account> account = accountService.findById(transactionDto.getAccount_id());
		
		Transactions transaction = new  Transactions(account.get(), operationType.get(),transactionDto.getAmount());
		
		if(transaction.getAccount().getLimite().doubleValue() < 0) {
			throw new SystemException("transação não autoriza!");
		}
		
		return transactionService.save(transaction);
	}

	public Iterable<Transactions> getAllTransctions() {
		return transactionService.findAll();
	}
	
	
}
