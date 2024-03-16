package Lab2.Problem1.App;

import java.util.List;

import Lab2.Problem1.Entity.Employee;
import Lab2.Problem1.FilterInterface.IFilter;

public class FilterManager {
	private FilterChain filterChain;

	public FilterManager(Target target) {
		filterChain = new FilterChain();
		filterChain.setTarget(target);
	}

	public void setFilter(IFilter filter) {
		filterChain.addFilter(filter);
	}

	public void filterRequest(List<Employee> employees) {
		filterChain.execute(employees);
	}

}
