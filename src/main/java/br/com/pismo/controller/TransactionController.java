package br.com.pismo.controller;

import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pismo.dto.TransactionsDTO;
import br.com.pismo.model.Transactions;
import br.com.pismo.service.TransactionService;
import br.com.pismo.serviceImpl.TransactionServiceImpl;

@RestController
@RequestMapping(path = "/transactions")
public class TransactionController {

	@Autowired
	private TransactionServiceImpl transactionService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Transactions creatTransaction(@RequestBody TransactionsDTO transaction) throws SystemException {
		return transactionService.createTransaction(transaction);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Transactions> findAll() {
		return transactionService.getAllTransctions();
	}
}
