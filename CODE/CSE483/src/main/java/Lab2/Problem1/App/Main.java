package Lab2.Problem1.App;

import java.util.ArrayList;
import java.util.List;

import Lab2.Problem1.Entity.Employee;
import Lab2.Problem1.FilterInterfaceImpl.DepartmentFilter;
import Lab2.Problem1.FilterInterfaceImpl.ExperienceFilter;
import Lab2.Problem1.FilterInterfaceImpl.RoleFilter;
import Lab2.Problem1.FilterInterfaceImpl.SalaryFilter;
import Lab2.Problem1.FilterInterfaceImpl.SkillFilter;

public class Main {

	public static void main(String[] args) {
		Target target = new Target();
		FilterManager filterManager = new FilterManager(target);

		DepartmentFilter departmentFilter = new DepartmentFilter("marketing");
		ExperienceFilter experienceFilter = new ExperienceFilter(2, 10);
		RoleFilter roleFilter = new RoleFilter(List.of("marketing specialist", "content writer"));
		SalaryFilter salaryFilter = new SalaryFilter(10000, 500000);
		SkillFilter skillFilter = new SkillFilter(List.of("writing", "marketing"));

		filterManager.setFilter(departmentFilter);
		filterManager.setFilter(experienceFilter);
		filterManager.setFilter(roleFilter);
		filterManager.setFilter(salaryFilter);
		filterManager.setFilter(skillFilter);

		Client client = new Client();
		client.setFilterManager(filterManager);

		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("john", "it", "developer", 5, 75000, List.of("java", "python")));
		employeeList.add(new Employee("alice", "hr", "manager", 8, 90000, List.of("communication", "leadership")));
		employeeList.add(new Employee("bob", "finance", "accountant", 3, 60000, List.of("accounting", "excel")));
		employeeList.add(new Employee("eva", "marketing", "marketing specialist", 6, 80000,
				List.of("marketing", "social media")));
		employeeList.add(new Employee("charlie", "it", "qa engineer", 4, 70000, List.of("testing", "automation")));
		employeeList.add(new Employee("sophia", "hr", "recruiter", 7, 85000, List.of("recruitment", "interviewing")));
		employeeList.add(new Employee("david", "finance", "financial analyst", 2, 55000, List.of("finance", "excel")));
		employeeList.add(new Employee("grace", "marketing", "content writer", 5, 75000, List.of("writing", "seo")));
		employeeList
				.add(new Employee("daniel", "it", "system administrator", 6, 78000, List.of("networking", "security")));
		employeeList
				.add(new Employee("olivia", "finance", "budget analyst", 4, 68000, List.of("budgeting", "analysis")));

		client.sendRequest(employeeList);

	}

}
