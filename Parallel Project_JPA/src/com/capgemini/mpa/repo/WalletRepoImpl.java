package com.capgemini.mpa.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.capgemini.mpa.beans.Customer;
import com.capgemini.mpa.beans.Transactions;
import com.capgemini.mpa.beans.Wallet;
import com.capgemini.mpa.exception.InvalidInputException;
import com.capgemini.mpa.util.DBUtil;
import com.capgemini.mpa.util.JPAUtil;

public class WalletRepoImpl implements WalletRepo 
{
	private EntityManager entityManager;
	
	private Map<String, Customer> data;
	
	List<Transactions> transactionsList = new ArrayList<Transactions>();
	
	public WalletRepoImpl(Map<String, Customer> data) 
	{
		super();
		this.data = data;
	}

	public WalletRepoImpl() 
	{
		entityManager=JPAUtil.getEntityManager();
	}
	
	@Override
	public boolean save(Customer customer) 
	{
		entityManager.persist(customer);
		return true;
	}

	@Override
	public Customer findOne(String mobileNo) 
	{
		Customer customer = entityManager.find(Customer.class, mobileNo);
		return customer;
	}

	@Override
	public Customer Update(Customer customer, Transactions transaction) 
	{
		entityManager.merge(customer);
		entityManager.persist(transaction);
		return customer;
	}

	@Override
	public List<Transactions> transactions(String mobileNo) 
	{
		String qstr="select trans from Transactions trans where trans.mobileNo=:m_no";
		TypedQuery<Transactions> query=entityManager.createQuery(qstr, Transactions.class);
		query.setParameter("m_no", mobileNo);
		transactionsList=query.getResultList();
		return transactionsList;
	}
	
	@Override
	public void startTransaction() {

		entityManager.getTransaction().begin();
	}
	@Override
	public void commitTransaction() {
		
			entityManager.getTransaction().commit();
		} 
}