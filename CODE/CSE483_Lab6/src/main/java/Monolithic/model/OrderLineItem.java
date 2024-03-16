package Monolithic.model;

public class OrderLineItem {
	private int orderLineId;
	private String orderLineSkuCode;
	private double productPrice;
	private int quantity;

	public OrderLineItem(String orderLineSkuCode, double productPrice, int quantity) {
		this.orderLineSkuCode = orderLineSkuCode;
		this.productPrice = productPrice;
		this.quantity = quantity;
	}

	public int getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(int orderLineId) {
		this.orderLineId = orderLineId;
	}

	public String getOrderLineSkuCode() {
		return orderLineSkuCode;
	}

	public void setOrderLineSkuCode(String orderLineSkuCode) {
		this.orderLineSkuCode = orderLineSkuCode;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
