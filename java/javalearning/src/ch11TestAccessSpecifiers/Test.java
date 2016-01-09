package ch11TestAccessSpecifiers;

public class Test {

	static class Person {
		public String getInfo() {
			return "Person";
		}

		public void printPerson() {
			System.out.println(getInfo());
		}
	}
	static class Student extends Person {
		@Override
		public String getInfo() {
			return "Student";
		}
	}

	

	public static void main(String[] args) {
		Person p = new Person();
		//p.printPerson();
		Student s = new Student();
		//s.printPerson();
		print(p);
		print (s);

	}
	
	public static void print(Object o) {
		
		if (o instanceof Person) {
			
			((Person) o).printPerson();
			
		}
		
		
	}
}