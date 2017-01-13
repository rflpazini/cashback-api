package com.rflpazini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rflpazini.model.TransactionIn;
import com.rflpazini.model.UsersTransactions;
import com.rflpazini.service.UTransactionService;

@RestController
public class UTransactionController {
	
	@Autowired
	UTransactionService transactionService;
	
	@RequestMapping(value = "/users-transactions", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<UsersTransactions> getUsers() {
		List<UsersTransactions> listOfTransactions = transactionService.getAllTransactions();
		return listOfTransactions;
	}
	
	@RequestMapping(value = "/register-transaction", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> registerTransaction(@RequestBody TransactionIn transaction) {
		return transactionService.newTransaction(transaction);
	}

}
