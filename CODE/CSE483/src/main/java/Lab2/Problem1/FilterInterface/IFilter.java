package Lab2.Problem1.FilterInterface;

import java.util.List;

import Lab2.Problem1.Entity.Employee;

public interface IFilter {
	public List<Employee> process(List<Employee> employees);
}
