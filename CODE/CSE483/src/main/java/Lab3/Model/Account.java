package Lab3.Model;

public class Account implements Cloneable {
	private String accountNumber;
	private double balance;
	private User owner;
	private AccountType accountType;

	public Account(String accountNumber, double balance, User owner, AccountType accountType) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.owner = owner;
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@Override
	public Account clone() throws CloneNotSupportedException {
		return (Account) super.clone();
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", owner=" + owner.getUsername()
				+ ", accountType=" + accountType + "]";
	}
}
