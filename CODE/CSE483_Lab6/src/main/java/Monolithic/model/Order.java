package Monolithic.model;

import java.util.List;

public class Order {
	private int orderId;
	private String orderNumber;
	private List<OrderLineItem> orderLineItems;

	public Order(String orderNumber, List<OrderLineItem> orderLineItems) {
		this.orderNumber = orderNumber;
		this.orderLineItems = orderLineItems;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public List<OrderLineItem> getOrderLineItems() {
		return orderLineItems;
	}

	public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}
}
