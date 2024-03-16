package Lab2.Problem2.App;

import java.util.List;

import Lab2.Problem2.Entity.Product;
import Lab2.Problem2.Entity.User;
import Lab2.Problem2.Service.OrderService;
import Lab2.Problem2.Service.PaymentService;
import Lab2.Problem2.Service.UserService;

public class EcommerceForwarder {
	private final UserService userService;
	private final OrderService orderService;
	private final PaymentService paymentService;

	public EcommerceForwarder(UserService userService, OrderService orderService, PaymentService paymentService) {
		this.userService = userService;
		this.orderService = orderService;
		this.paymentService = paymentService;
	}

	public void completeOrder(String username, String password, List<Product> products) {

		boolean isAuthenticated = userService.authenticateUser(username, password);

		if (isAuthenticated) {
			User user = this.userService.getUser();
			orderService.placeOrder(user, products);
			paymentService.processPayment(user, products);
		} else {
			System.out.println("Authentication failed. Unable to complete the order.");
		}
	}
}
