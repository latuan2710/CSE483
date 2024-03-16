package Lab2.Problem2.ServiceImpl;

import java.util.List;

import Lab2.Problem2.Entity.Product;
import Lab2.Problem2.Entity.User;
import Lab2.Problem2.Service.PaymentService;

public class PaymentServiceImpl implements PaymentService {

	@Override
	public void processPayment(User user, List<Product> products) {
		double totalMoney = 0;
		for (Product product : products) {
			totalMoney += product.getPrice();
		}
		System.out.println(user.getUsername() + ", you have to pay: " + totalMoney);
	}

}
