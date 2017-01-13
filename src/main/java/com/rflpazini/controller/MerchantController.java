package com.rflpazini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rflpazini.model.Merchant;
import com.rflpazini.model.UsersTransactions;
import com.rflpazini.service.MerchantService;

@RestController
public class MerchantController {
	@Autowired
	MerchantService mService;
	
	@RequestMapping(value = "/merchants", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Merchant> getUsers() {
		List<Merchant> listOfMerchant = mService.getAllMerchant();
		return listOfMerchant;
	}
	
	@RequestMapping(value = "/merchants/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Merchant getMerchantById(@PathVariable("id") int id) {
		return mService.getMerchant(id);
	}
	
	@RequestMapping(value = "/merchants", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateMerchant(@RequestBody Merchant merchant) {
		mService.updateMerchant(merchant);
	}
	
	@RequestMapping(value = "/merchants/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteMerchant(@PathVariable("id") int id) {
		mService.deleteMerchant(id);
	}
}
