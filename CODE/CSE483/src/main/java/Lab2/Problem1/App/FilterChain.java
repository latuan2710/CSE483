package Lab2.Problem1.App;

import java.util.ArrayList;
import java.util.List;

import Lab2.Problem1.Entity.Employee;
import Lab2.Problem1.FilterInterface.IFilter;

public class FilterChain {
	private List<IFilter> filters = new ArrayList<>();
	private Target target;

	public FilterChain() {
	}

	public void setTarget(Target target) {
		this.target = target;

	}

	public void addFilter(IFilter filter) {
		filters.add(filter);

	}

	public void execute(List<Employee> employees) {
		for (IFilter f : filters) {
			employees = f.process(employees);
		}

		target.excute(employees);
	}
}
