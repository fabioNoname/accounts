package br.com.pismo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pismo.dto.AccountDTO;
import br.com.pismo.model.Account;
import br.com.pismo.serviceImpl.AccountServiceImpl;

@RestController
@RequestMapping(path = "/accounts")
public class AccountsController {
	
	@Autowired
	private AccountServiceImpl accountService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void acreateAccount(@RequestBody AccountDTO account) {
		accountService.createAccount(account);
	}
	
	@RequestMapping(path = "/{accountId}")
	public Optional<Account> findAccount(@PathVariable Long accountId) {
		return accountService.findById(accountId);
	}
	
	@RequestMapping(path = "/limit/", method = RequestMethod.POST)
	public void findAccount(@RequestBody AccountDTO account) {
		accountService.updateLimit(account.getId(),account.getLimit());
		
	}

}
