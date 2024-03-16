package Lab2.Problem1.FilterInterfaceImpl;

import java.util.List;

import Lab2.Problem1.Entity.Employee;
import Lab2.Problem1.FilterInterface.IFilter;

public class DepartmentFilter implements IFilter {
	private String department;

	public DepartmentFilter(String department) {
		super();
		this.department = department;
	}

	@Override
	public List<Employee> process(List<Employee> employees) {
		return employees.stream().filter(t -> t.getDepartment().equalsIgnoreCase(department)).toList();
	}

}
