package com.rflpazini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_transactions")
public class UsersTransactions {
	@Id
	@Column(name = "transaction_id")
	@GeneratedValue
	private int id;
	
	@Column(name = "transaction_code")
	private String transaction_code;
	
	@Column(name = "user_cpf")
	private String user_cpf;
	
	@Column(name = "user_name")
	private String user_name;
	
	@Column(name = "user_balance")
	private Double user_balance;
	
	@Column(name = "transaction_date")
	private String transaction_date;
	
	@Column(name = "transaction_type")
	private String transaction_type;
	
	public UsersTransactions(){
		super();
	}
	
	public UsersTransactions(int id, String code, String cpf, String name, Double balance, String date, String type) {
		super();
		this.id = id;
		this.transaction_code = code;
		this.user_cpf = cpf;
		this.user_name = name;
		this.user_balance = balance;
		this.transaction_date = date;
		this.transaction_type = type;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTransaction_code() {
		return transaction_code;
	}
	public void setTransaction_code(String transaction_code) {
		this.transaction_code = transaction_code;
	}
	public String getUser_cpf() {
		return user_cpf;
	}
	public void setUser_cpf(String user_cpf) {
		this.user_cpf = user_cpf;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Double getUser_balance() {
		return user_balance;
	}
	public void setUser_balance(Double user_balance) {
		this.user_balance = user_balance;
	}
	public String getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
}
