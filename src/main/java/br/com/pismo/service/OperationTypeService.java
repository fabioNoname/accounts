package br.com.pismo.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pismo.model.OperationType;

@Repository
public interface OperationTypeService extends CrudRepository<OperationType, Long>{

}
