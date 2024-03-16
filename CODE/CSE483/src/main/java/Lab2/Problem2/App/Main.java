package Lab2.Problem2.App;

import java.util.ArrayList;
import java.util.List;

import Lab2.Problem2.Entity.Product;
import Lab2.Problem2.Service.OrderService;
import Lab2.Problem2.Service.PaymentService;
import Lab2.Problem2.Service.UserService;
import Lab2.Problem2.ServiceImpl.OrderServiceImpl;
import Lab2.Problem2.ServiceImpl.PaymentServiceImpl;
import Lab2.Problem2.ServiceImpl.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product("111", "Iphone", 1000));
		products.add(new Product("222", "SamSung", 2000));
		products.add(new Product("333", "Xiaomi", 3000));

		UserService userService = new UserServiceImpl();
		OrderService orderService = new OrderServiceImpl();
		PaymentService paymentService = new PaymentServiceImpl();

		EcommerceForwarder ecommerceForwarder = new EcommerceForwarder(userService, orderService, paymentService);

		ecommerceForwarder.completeOrder("latuan2710", "dasd", products);
		ecommerceForwarder.completeOrder("latuan2710", "tuan1234", products);
	}

}
