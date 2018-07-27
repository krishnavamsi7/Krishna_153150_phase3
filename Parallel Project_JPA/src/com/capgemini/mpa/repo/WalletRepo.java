package com.capgemini.mpa.repo;

import java.util.List;

import com.capgemini.mpa.beans.Customer;
import com.capgemini.mpa.beans.Transactions;
import com.capgemini.mpa.beans.Wallet;

public interface WalletRepo 
{
	public boolean save(Customer customer);
	
	public Customer findOne(String mobileNo);
	
	public Customer Update(Customer customer, Transactions transaction);
	
	public List<Transactions> transactions(String mobileNo);
	
	public void startTransaction();
	
	public void commitTransaction();
}
