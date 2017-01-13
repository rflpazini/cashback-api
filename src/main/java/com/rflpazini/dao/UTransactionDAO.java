package com.rflpazini.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rflpazini.model.UsersTransactions;

@Repository
public class UTransactionDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public List<UsersTransactions> getAllTransactions() {
		Session session = this.sessionFactory.getCurrentSession();
		List<UsersTransactions> transactionsList = session.createQuery("from UsersTransactions").list();
		return transactionsList;
	}
	
	public void addNewTransaction(UsersTransactions newTransaction) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(newTransaction);
	}
}
