package Lab3.View;

import java.util.Scanner;

import Lab3.Model.Account;
import Lab3.Model.AccountType;
import Lab3.Model.TransType;
import Lab3.Model.Transaction;

public class View {

	public String inputUserUsername() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter username: ");
		return sc.next();
	}

	public String inputUserPassword() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter password: ");
		return sc.next();
	}

	public int inputChoice() {
		Scanner sc = new Scanner(System.in);

		System.out.println(
				"\n1. Deposit\n" + "2. Withdraw\n" + "3. Show history transaction\n" + "Other numbers. Logout");

		return sc.nextInt();
	}

	public double inputAmount() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter amount: ");

		return sc.nextDouble();
	}

	public void authenticateUser(Account account) {
		if (account != null) {
			System.out.println("Login successfully!");
			printAccountDetails(account);
		} else {
			System.out.println("Username or password was incorrect!\n");
		}
	}

	public void printTransaction(Transaction transaction, Account account, boolean isSuccessful) {
		System.out.println("\nTransaction Type: " + transaction.getDescription());

		if (isSuccessful) {
			System.out.println("Amount: " + transaction.getAmount());
		} else {
			TransType description = transaction.getDescription();
		    AccountType accountType = account.getAccountType();
		    
			if (description == TransType.DEPOSIT && accountType == AccountType.LOAN) {
				System.out.println("You can not deposit LOAN Account!\n");
			} else if (description == TransType.WITHDRAW && accountType != AccountType.CHECKING) {
				System.out.println("You can only withdraw for CHECKING Account!\n");
			}
		}
		printAccountDetails(account);
	}

	public void printAccountDetails(Account account) {
		System.out.println(account);
	}

	public void logout() {
		System.out.println("You logout successfully!");
	}
}
