package br.com.pismo.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pismo.model.Transactions;

@Repository
public interface TransactionService extends CrudRepository<Transactions, Long> {

}
