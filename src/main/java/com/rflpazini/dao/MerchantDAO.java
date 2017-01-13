package com.rflpazini.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rflpazini.model.Merchant;

@Repository
public class MerchantDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Merchant> getAllMerchant() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Merchant> mList = session.createQuery("from Merchant").list();
		return mList;
	}
	
	public Merchant getMerchant(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Merchant merchant = (Merchant) session.get(Merchant.class, new Integer(id));
		return merchant;
	}
	
	public void updateMerchant(Merchant merchant) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(merchant);
	}

	public void deleteMerchant(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Merchant merchant = (Merchant) session.load(Merchant.class, new Integer(id));
		if (merchant != null) {
			session.delete(merchant);
		}
	}
}
