package Monolithic.model;

public class Inventory {
	private int invId;
	private int productId;
	private int quantity;

	public Inventory(int productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	public Inventory() {
	}

	public int getInvId() {
		return invId;
	}

	public void setInvId(int invId) {
		this.invId = invId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Inventory [invId=" + invId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}

}
