package br.com.pismo.model;

import java.math.BigDecimal;

import javax.transaction.SystemException;

public enum OperationEnum {
	COMPRAAVISTA("COMPRA A VISTA", -1), 
	COMPRAPARCELADA("COMPRA PARCELADA", -1), 
	SAQUE("SAQUE", -1),
	PAGAMENTO("PAGAMENTO", 1);

	private BigDecimal fator;
	private String description;

	OperationEnum(String description, int fator) {
		this.description = description;
		this.fator = BigDecimal.valueOf(fator);
	}

	public BigDecimal getFator() {
		return fator;
	}

	public String getDescription() {
		return description;
	}

	public static OperationEnum findByDescription(String description) throws SystemException {
		for (OperationEnum operationEnum : OperationEnum.values()) {
			if(operationEnum.getDescription().equalsIgnoreCase(description)) {
				return operationEnum;
			}
		}
		throw new SystemException();
	}
}
