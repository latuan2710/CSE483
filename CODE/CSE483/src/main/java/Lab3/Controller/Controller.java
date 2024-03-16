package Lab3.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Lab3.Model.Account;
import Lab3.Model.AccountType;
import Lab3.Model.TransType;
import Lab3.Model.Transaction;
import Lab3.Model.User;
import Lab3.View.View;

public class Controller {
	private List<Account> accounts;
	private HashMap<Transaction, Account> transactions;
	private View view;
	private Account account;

	public Controller() {
		this.accounts = new ArrayList<>();
		this.transactions = new HashMap<>();
		this.view = new View();

		accounts.add(new Account("123456", 1000, new User("user1", "password1"), AccountType.CHECKING));
		accounts.add(new Account("789012", 5000, new User("user2", "password2"), AccountType.SAVINGS));
		accounts.add(new Account("345678", 200, new User("user3", "password3"), AccountType.LOAN));
		accounts.add(new Account("901234", 3000, new User("user4", "password4"), AccountType.CHECKING));
		accounts.add(new Account("567890", 1500, new User("user5", "password5"), AccountType.SAVINGS));
	}

	public void authenticateUser(String username, String password) {

		for (Account account : accounts) {
			boolean checkUsername = account.getOwner().getUsername().equals(username);
			boolean checkPassword = account.getOwner().getPassword().equals(password);

			if (checkUsername && checkPassword) {
				this.account = account;
				view.authenticateUser(account);
				return;
			}
		}

		view.authenticateUser(null);
	}

	public void deposit(double money) throws CloneNotSupportedException {
		Transaction transaction = new Transaction(TransType.DEPOSIT, money);

		if (account.getAccountType() == AccountType.LOAN) {
			view.printTransaction(transaction, account, false);
		} else {
			account.setBalance(account.getBalance() + money);

			transactions.put(transaction, account.clone());
			view.printTransaction(transaction, account, true);
		}

	}

	public void withdraw(double money) throws CloneNotSupportedException {
		Transaction transaction = new Transaction(TransType.WITHDRAW, money);

		if (account.getAccountType() == AccountType.CHECKING) {
			account.setBalance(account.getBalance() - money);

			transactions.put(transaction, account.clone());
			view.printTransaction(transaction, account, true);
		} else {
			view.printTransaction(transaction, account, false);
		}

	}

	public void transacitionLog() {
		for (Transaction transaction : transactions.keySet()) {
			view.printTransaction(transaction, transactions.get(transaction), true);
		}
	}

	public void showMenu() throws CloneNotSupportedException {

		while (account == null) {
			String username = view.inputUserUsername();
			String password = view.inputUserPassword();

			this.authenticateUser(username, password);
		}

		int choice = view.inputChoice();
		while (choice == 1 || choice == 2 || choice == 3) {
			if (choice == 1) {
				this.deposit(view.inputAmount());
			} else if (choice == 2) {
				this.withdraw(view.inputAmount());
			} else if (choice == 3) {
				this.transacitionLog();
			}
			choice = view.inputChoice();
		}
		view.logout();
	}
}
