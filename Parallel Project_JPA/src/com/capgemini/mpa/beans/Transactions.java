package com.capgemini.mpa.beans;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="transactionsjpa")
public class Transactions
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mysgen")
	@SequenceGenerator(sequenceName="my_sequence",name="mysgen")
	private int id;
	private String mobileNo;
	private String transactionType;
	private BigDecimal amount;
	
	public Transactions() {
		super();
	}

	public Transactions(String mobileNo, String transactionType, BigDecimal amount) {
		super();
		this.mobileNo = mobileNo;
		this.transactionType = transactionType;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", mobileNo=" + mobileNo + ", transactionType=" + transactionType
				+ ", amount=" + amount + "]";
	}
}