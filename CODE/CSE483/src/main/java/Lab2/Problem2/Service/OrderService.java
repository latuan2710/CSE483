package Lab2.Problem2.Service;

import java.util.List;

import Lab2.Problem2.Entity.Product;
import Lab2.Problem2.Entity.User;

public interface OrderService {
	public void placeOrder(User user, List<Product> products);
}
