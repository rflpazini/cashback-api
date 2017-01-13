package com.rflpazini.model;

import javax.persistence.Entity;

@Entity
public class TransactionIn {
	private String user_cpf;
	private int merchant_id;
	private Double transaction_value;
	private String transaction_type;
	public String getUser_cpf() {
		return user_cpf;
	}
	public void setUser_cpf(String user_cpf) {
		this.user_cpf = user_cpf;
	}
	public int getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(int merchant_id) {
		this.merchant_id = merchant_id;
	}
	public Double getTransaction_value() {
		return transaction_value;
	}
	public void setTransaction_value(Double transaction_value) {
		this.transaction_value = transaction_value;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
}
