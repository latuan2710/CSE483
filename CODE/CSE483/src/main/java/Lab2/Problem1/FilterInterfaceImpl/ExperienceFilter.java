package Lab2.Problem1.FilterInterfaceImpl;

import java.util.List;

import Lab2.Problem1.Entity.Employee;
import Lab2.Problem1.FilterInterface.IFilter;

public class ExperienceFilter implements IFilter {
	private int min;
	private int max;

	public ExperienceFilter(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public List<Employee> process(List<Employee> employees) {
		return employees.stream().filter(t -> (t.getExperience() >= min && t.getExperience() <= max)).toList();
	}

}
