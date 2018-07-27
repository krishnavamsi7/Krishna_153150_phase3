package com.capgemini.mpa.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customerjpa")
public class Customer implements Serializable
{
	private String name;
	
	@Id
	private String mobileNo;
	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="wallet_id")*/
	private Wallet wallet;
	
	public Customer() 
	{
		super();
	}
	public Customer(String name, String mobileNo, Wallet wallet) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.wallet = wallet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	@Override
	public String toString() 
	{
		return "Customer name=" + name + ", Mobile Number=" + mobileNo
				 + wallet;
	}	
}