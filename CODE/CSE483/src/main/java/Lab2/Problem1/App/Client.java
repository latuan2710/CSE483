package Lab2.Problem1.App;

import java.util.List;

import Lab2.Problem1.Entity.Employee;

public class Client {
	private FilterManager filterManager;

	public Client() {

	}

	public void setFilterManager(FilterManager filterManager) {
		this.filterManager = filterManager;
	}

	public void sendRequest(List<Employee> employees) {
		this.filterManager.filterRequest(employees);
	}

}
