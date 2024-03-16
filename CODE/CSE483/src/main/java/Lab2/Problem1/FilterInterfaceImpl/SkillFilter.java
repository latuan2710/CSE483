package Lab2.Problem1.FilterInterfaceImpl;

import java.util.ArrayList;
import java.util.List;

import Lab2.Problem1.Entity.Employee;
import Lab2.Problem1.FilterInterface.IFilter;

public class SkillFilter implements IFilter {
	private List<String> skills;

	public SkillFilter(List<String> skills) {
		this.skills = skills;
	}

	@Override
	public List<Employee> process(List<Employee> employees) {
		List<Employee> result = new ArrayList<>();

		for (Employee employee : employees) {
			for (String skill : employee.getSkills()) {
				if (this.skills.contains(skill)) {
					result.add(employee);
					break;
				}
			}
		}
		return result;
	}

}
