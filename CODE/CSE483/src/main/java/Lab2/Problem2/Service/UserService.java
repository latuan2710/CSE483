package Lab2.Problem2.Service;

import Lab2.Problem2.Entity.User;

public interface UserService {
	public boolean authenticateUser(String username, String password);

	public User getUser();
}
