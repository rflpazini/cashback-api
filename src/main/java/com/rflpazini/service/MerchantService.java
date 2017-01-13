package com.rflpazini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rflpazini.dao.MerchantDAO;
import com.rflpazini.model.Merchant;

@Service("MerchantService")
public class MerchantService {
	@Autowired
	MerchantDAO mDao;
	
	@Transactional
	public List<Merchant> getAllMerchant() {
		return mDao.getAllMerchant();
	}
	
	@Transactional
	public Merchant getMerchant(int id) {
		return mDao.getMerchant(id);
	}
	
	@Transactional
	public void updateMerchant(Merchant merchant) {
		mDao.updateMerchant(merchant);
	}

	@Transactional
	public void deleteMerchant(int id) {
		mDao.deleteMerchant(id);
	}
}
