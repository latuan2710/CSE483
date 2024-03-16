package Lab2.Problem1.FilterInterfaceImpl;

import java.util.List;

import Lab2.Problem1.Entity.Employee;
import Lab2.Problem1.FilterInterface.IFilter;

public class SalaryFilter implements IFilter {
	private double min;
	private double max;

	public SalaryFilter(double min, double max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public List<Employee> process(List<Employee> employees) {
		return employees.stream().filter(t -> (t.getSalary() >= min && t.getSalary() <= max)).toList();
	}

}
