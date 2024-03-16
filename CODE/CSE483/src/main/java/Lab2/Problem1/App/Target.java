package Lab2.Problem1.App;

import java.util.List;

import Lab2.Problem1.Entity.Employee;

public class Target {

	public void excute(List<Employee> employees) {
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		
	}

}
