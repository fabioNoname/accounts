package br.com.pismo.controller;

import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

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
	public String creatTransaction(@RequestBody TransactionsDTO transaction) {
		Transactions transaction2;
		try {
			transaction2 = transactionService.createTransaction(transaction);
		} catch (SystemException e) {
			return e.getMessage();
		}
		return new Gson().toJson(transaction2).toString();
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Transactions> findAll() {
		return transactionService.getAllTransctions();
	}
}
