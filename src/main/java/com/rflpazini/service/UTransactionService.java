package com.rflpazini.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rflpazini.dao.UTransactionDAO;
import com.rflpazini.model.Merchant;
import com.rflpazini.model.TransactionIn;
import com.rflpazini.model.Users;
import com.rflpazini.model.UsersTransactions;
import com.rflpazini.utils.ConvertJson;

@Service("TransactionService")
public class UTransactionService {
	@Autowired
	UTransactionDAO tDao;

	@Autowired
	UserService userService;

	@Autowired
	MerchantService mService;

	@Transactional
	public List<UsersTransactions> getAllTransactions() {
		return tDao.getAllTransactions();
	}

	@Transactional
	public ResponseEntity<String> newTransaction(TransactionIn newTransaction) {
		// Retrieve user from db
		Users userRetrieved = userService.getUserByCpf(newTransaction.getUser_cpf());
		Merchant merchantRetrieved = mService.getMerchant(newTransaction.getMerchant_id());

		// Set values to userTransaction
		UsersTransactions userTransaction = new UsersTransactions();
		userTransaction.setUser_cpf(userRetrieved.getUser_cpf());
		userTransaction.setUser_name(userRetrieved.getUser_name());
		userTransaction.setTransaction_code(getTransactionCode());
		userTransaction.setTransaction_type(newTransaction.getTransaction_type());
		userTransaction.setTransaction_date(getTodayDate());

		// Calculate new balance for user, after the transaction
		double updatedBalance = updateBalance(newTransaction.getTransaction_type(), userRetrieved.getUser_balance(),
				newTransaction.getTransaction_value(), merchantRetrieved);
		double userBalance = userRetrieved.getUser_balance();

		int retval = Double.compare(updatedBalance, userBalance);

		// Verify if balance was changed
		if (retval > 0 || retval < 0) {
			// Set balance with new percent
			userTransaction.setUser_balance(updatedBalance);
			userRetrieved.setUser_balance(updatedBalance);

			// Update user balance and save new transaction
			userService.updateUser(userRetrieved);
			tDao.addNewTransaction(userTransaction);
			String json = ConvertJson.convertUserTransaction(userTransaction);
			return ResponseEntity.ok(json);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

	}

	// Generate a token that will be used as transaction_code
	private String getTransactionCode() {
		UUID token = UUID.randomUUID();
		return token.toString();
	}

	// Get date from transaction
	private String getTodayDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	// View what day is
	private String getWeekDay(Calendar cal) {
		return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
	}

	// Get the percentage of cashback that the user will receive from each day
	private double getPercentage(Merchant merchant, Double transactionValue, String day) {
		int cashbackPercent = 0;
		switch (day) {
		case "Sunday":
			cashbackPercent = merchant.getSun();
			break;
		case "Monday":
			cashbackPercent = merchant.getMon();
			break;
		case "Tuesday":
			cashbackPercent = merchant.getTus();
			break;
		case "Wednesday":
			cashbackPercent = merchant.getWed();
			break;
		case "Thursday":
			cashbackPercent = merchant.getThurs();
			break;
		case "Friday":
			cashbackPercent = merchant.getFri();
			break;
		case "Saturday":
			cashbackPercent = merchant.getSat();
			break;
		}
		return transactionValue * cashbackPercent / 100;
	}

	// Get transaction type and apply the cashback to balance
	private double updateBalance(String transactionType, double balance, double transactionValue, Merchant merchant) {
		double updatedBalance = 0.0;
		double percent = 0.0;
		switch (transactionType) {
		// CASHBACK
		case "TP_1":
			updatedBalance = amount(balance, transactionValue);
			break;
		// DEBITO
		case "TP_2":
			percent = getPercentage(merchant, transactionValue, getWeekDay(Calendar.getInstance()));
			updatedBalance = balance + percent;
			break;
		// CREDITO
		case "TP_3":
			percent = getPercentage(merchant, transactionValue, getWeekDay(Calendar.getInstance()));
			updatedBalance = balance + percent;
			break;
		}
		return updatedBalance;
	}

	private double amount(double balance, double transactionValue) {
		if (balance > transactionValue) {
			return balance - transactionValue;
		} else {
			return balance;
		}

	}
}
