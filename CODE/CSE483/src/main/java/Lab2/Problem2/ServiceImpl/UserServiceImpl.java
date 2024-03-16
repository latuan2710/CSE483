package Lab2.Problem2.ServiceImpl;

import Lab2.Problem2.Entity.User;
import Lab2.Problem2.Service.UserService;

public class UserServiceImpl implements UserService {

	private User user;

	public UserServiceImpl() {
		this.user = new User("latuan2710", "tuan1234");
	}

	@Override
	public boolean authenticateUser(String username, String password) {
		return user.getUsername().equals(username) && user.getPassword().equals(password);
	}

	@Override
	public User getUser() {
		return user;
	}

}
