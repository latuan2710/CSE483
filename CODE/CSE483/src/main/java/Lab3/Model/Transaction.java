package Lab3.Model;

public class Transaction {
	private TransType description;
	private double amount;

	public Transaction(TransType description, double amount) {
		this.description = description;
		this.amount = amount;
	}

	public TransType getDescription() {
		return description;
	}

	public void setDescription(TransType description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
