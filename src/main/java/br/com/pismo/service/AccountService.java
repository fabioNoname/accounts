package br.com.pismo.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pismo.model.Account;

@Repository
public interface AccountService extends CrudRepository<Account, Long> {

}
