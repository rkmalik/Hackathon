package ch8;

import java.util.Date;
import java.util.Random;

class Test {

	static class Student {
		String name; // name has the default value null
		int age; // age has the default value 0
		boolean isScienceMajor; // isScienceMajor has default value false
		char gender; // gender has default value '\u0000'
	}

	public static void main(String[] args) {
		Student student = new Student();
		System.out.println("name? " + student.name);
		System.out.println("age? " + student.age);
		System.out.println("isScienceMajor? " + student.isScienceMajor);
		System.out.println("gender? " + student.gender);
		
		
		Random random1 = new Random(3);
		System.out.print("From random1: ");
		for (int i = 0; i < 10; i++)
		System.out.print(random1.nextInt(1000) + " ");
		Random random2 = new Random(3);
		System.out.print("\nFrom random2: ");
		for (int i = 0; i < 10; i++)
		System.out.print(random2.nextInt(1000) + " ");
		
		Date date = new Date ();
		
		System.out.println("\n\nTime : "+date.getTime());
		System.out.println(" : " + date);
		System.out.println("Date : "+date.getDate());
		System.out.println("Month : "+date.getMonth() + " Year: " + date.getYear() + " Day :" + date.getDay() + " Hours :" + date.getHours() + " Minutes:" + date.getMinutes() + " Seconds: " + date.getSeconds() + " TimeZone Offset :" + date.getTimezoneOffset());
		
	}
}
