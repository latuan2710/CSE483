package Lab1.Problem1;

import java.util.ArrayList;
import java.util.List;

public class LazyCourseManager {
	private static LazyCourseManager instance;
	private List<Student> students;
	private List<Course> courses;
	private List<Registration> registrations;

	public LazyCourseManager() {
		this.students = new ArrayList<Student>();
		this.courses = new ArrayList<Course>();
		this.registrations = new ArrayList<Registration>();
	}

	public static LazyCourseManager getInstance() {
		if (instance == null) {
			instance = new LazyCourseManager();
		}
		return instance;
	}

	public void addStudent(Student student) {
		if (!students.contains(student)) {
			this.students.add(student);
		}
	}

	public void addCourse(Course course) {
		if (!courses.contains(course)) {
			this.courses.add(course);
		}
	}

	public void removeStudent(Student student) {
		this.students.remove(student);
		this.registrations.removeIf(registration -> registration.getStudent().equals(student));
	}

	public void removeCourse(Course course) {
		this.courses.remove(course);
		this.registrations.removeIf(registration -> registration.getCourse().equals(course));
	}

	public void registerCourse(Student student, Course course) {
		for (Registration registration : registrations) {
			if (registration.getCourse().equals(course) && registration.getStudent().equals(student))
				return;
		}

		this.registrations.add(new Registration(student, course));
	}

	public void unregisterCourse(Student student, Course course) {
		this.registrations.removeIf(r -> (r.getStudent().equals(student) && r.getCourse().equals(course)));
	}

	public List<Student> getStudents() {
		return students;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

}
