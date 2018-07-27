package com.capgemini.mpa.beans;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Embeddable
public class Wallet 
{
	/*@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="mysgen")
	@SequenceGenerator(sequenceName="my_sequence",name="mysgen")
	private int id; */
	private BigDecimal balance;

	public Wallet() 
	{
		super();
	}

	public Wallet(BigDecimal amount) 
	{
		super();
		this.balance = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return ", Balance=" + balance;
	}	
}