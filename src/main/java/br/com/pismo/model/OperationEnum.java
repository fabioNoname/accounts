package br.com.pismo.model;

import java.math.BigDecimal;

import javax.transaction.SystemException;

public enum OperationEnum {
	COMPRAAVISTA(1l, -1), 
	COMPRAPARCELADA(2l, -1), 
	SAQUE(3l, -1),
	PAGAMENTO(4l, 1);

	private BigDecimal fator;
	private Long id;

	OperationEnum(Long id, int fator) {
		this.id = id;
		this.fator = BigDecimal.valueOf(fator);
	}

	public BigDecimal getFator() {
		return fator;
	}

	public Long getId() {
		return id;
	}

	public static OperationEnum findByDescription(Long id) throws SystemException {
		for (OperationEnum operationEnum : OperationEnum.values()) {
			if(operationEnum.getId() == id) {
				return operationEnum;
			}
		}
		throw new SystemException();
	}
}
