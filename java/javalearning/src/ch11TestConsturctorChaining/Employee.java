package ch11TestConsturctorChaining;

public class Employee extends Person {
	public Employee() {
		this("2 Employee with String Parameter.");
		System.out.println("3 Employee Default");
	}

	public Employee(String s) {
		System.out.println(s);
	}
}