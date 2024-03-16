package Lab2.Problem1.FilterInterfaceImpl;

import java.util.ArrayList;
import java.util.List;

import Lab2.Problem1.Entity.Employee;
import Lab2.Problem1.FilterInterface.IFilter;

public class RoleFilter implements IFilter {
	private List<String> roles;

	public RoleFilter(List<String> roles) {
		super();
		this.roles = roles;
	}

	@Override
	public List<Employee> process(List<Employee> employees) {
		List<Employee> result = new ArrayList<>();

		for (Employee employee : employees) {
			if (this.roles.contains(employee.getRole())) {
				result.add(employee);
			}
		}
		return result;
	}

}
