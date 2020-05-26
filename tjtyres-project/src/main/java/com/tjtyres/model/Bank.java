package com.tjtyres.model;

import javax.persistence.Entity;

//@Entity
public class Bank {
	
	private Long bankId;
	private String bank_name;
	private String ifsc_code;
	private String account_number;
	
	
	public Bank() {
		
	}
	public Bank(String bank_name, String ifsc_code) {
		this.bank_name = bank_name;
		this.ifsc_code = ifsc_code;
	}
	
	public Long getBankId() {
		return bankId;
	}
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getIfsc_code() {
		return ifsc_code;
	}
	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}
	
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	@Override
	public String toString() {
		return "Bank [bank_name=" + bank_name + ", ifsc_code=" + ifsc_code + "]";
	}
	

}
