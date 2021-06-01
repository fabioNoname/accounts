package br.com.pismo.serviceImpl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.pismo.dto.AccountDTO;
import br.com.pismo.model.Account;
import br.com.pismo.service.AccountService;

public class AccountServiceImpl {
	
	@Autowired
	private AccountService accountService;
	
	public void createAccount(AccountDTO accountDto) {
		Account account = new Account(accountDto.getDocument_number());
		accountService.save(account);
	}

	public Optional<Account> findById(Long accountId) {
		return accountService.findById(accountId);
	}

	public void updateLimit(Long accountId, BigDecimal limit) {
		Optional<Account> accout = accountService.findById(accountId);
		Account account = accout.get();
		account.setLimite(limit);
		accountService.save(account);
	}

}
