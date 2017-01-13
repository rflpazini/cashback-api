package com.rflpazini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@Column(name = "user_cpf")
	private String user_cpf;
	
	@Column(name = "user_name")
	private String name;
	
	@Column(name = "user_balance")
	private Double balance;
	
	public Users() {
		super();
	}
	
	public Users(int id, String cpf, String name, Double balance) {
		super();
		this.user_id = id;
		this.user_cpf = cpf;
		this.name = name;
		this.balance = balance;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_cpf() {
		return user_cpf;
	}
	public void setUser_cpf(String user_cpf) {
		this.user_cpf = user_cpf;
	}
	public String getUser_name() {
		return name;
	}
	public void setUser_name(String user_name) {
		this.name = user_name;
	}
	public Double getUser_balance() {
		return balance;
	}
	public void setUser_balance(Double user_balance) {
		this.balance = user_balance;
	}
}
