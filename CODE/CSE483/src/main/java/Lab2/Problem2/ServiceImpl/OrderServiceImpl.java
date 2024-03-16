package Lab2.Problem2.ServiceImpl;

import java.util.List;

import Lab2.Problem2.Entity.Product;
import Lab2.Problem2.Entity.User;
import Lab2.Problem2.Service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Override
	public void placeOrder(User user, List<Product> products) {
		for (Product product : products) {
			System.out.println(user.getUsername() + ", you place " + product.getName());
		}
	}

}
