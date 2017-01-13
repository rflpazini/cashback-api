package com.rflpazini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "merchants")
public class Merchant {
	@Id
	@Column(name = "merchant_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int merchant_id;

	@Column(name = "name")
	private String name;

	@Column(name = "sun")
	private int sun;

	@Column(name = "mon")
	private int mon;

	@Column(name = "tus")
	private int tus;

	@Column(name = "wed")
	private int wed;

	@Column(name = "thurs")
	private int thurs;

	@Column(name = "fri")
	private int fri;

	@Column(name = "sat")
	private int sat;

	public Merchant() {
		super();
	}

	public Merchant(int merchant_id, String name, int sun, int mon, int tus, int wed, int thurs, int fri, int sat) {
		super();
		this.merchant_id = merchant_id;
		this.name = name;
		this.sun = sun;
		this.mon = mon;
		this.tus = tus;
		this.wed = wed;
		this.thurs = thurs;
		this.fri = fri;
		this.sat = sat;
	}

	public int getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(int merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSun() {
		return sun;
	}

	public void setSun(int sun) {
		this.sun = sun;
	}

	public int getMon() {
		return mon;
	}

	public void setMon(int mon) {
		this.mon = mon;
	}

	public int getTus() {
		return tus;
	}

	public void setTus(int tus) {
		this.tus = tus;
	}

	public int getWed() {
		return wed;
	}

	public void setWed(int wed) {
		this.wed = wed;
	}

	public int getThurs() {
		return thurs;
	}

	public void setThurs(int thurs) {
		this.thurs = thurs;
	}

	public int getFri() {
		return fri;
	}

	public void setFri(int fri) {
		this.fri = fri;
	}

	public int getSat() {
		return sat;
	}

	public void setSat(int sat) {
		this.sat = sat;
	}
}
