package Lab2.Problem1.Entity;

import java.util.List;

public class Employee {
	private String name;
	private String department;
	private String role;
	private int experience;
	private double salary;
	private List<String> skills;

	public Employee(String name, String department, String role, int experience, double salary, List<String> skills) {
		super();
		this.name = name;
		this.department = department;
		this.role = role;
		this.experience = experience;
		this.salary = salary;
		this.skills = skills;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", role=" + role + ", experience=" + experience
				+ ", salary=" + salary + ", skills=" + skills + "]";
	}

}
