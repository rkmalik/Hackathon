package javalearning.learning1.inheritance1;

import javalearning.learning1.inheritance2.FirstLevelClass;
import javalearning.learning1.inheritance2.TopLevelClass;

public class UnitTest extends FirstLevelClass {

	public static void main(String args[]) {

		TopLevelClass obj = new TopLevelClass();
		System.out.println(obj);

		FirstLevelClass firstObj = new FirstLevelClass();
		firstObj.display();
		System.out.println(firstObj);

		UnitTest ut = new UnitTest();
		ut.displayData();

		PackageSecondLevelClass pkg = new PackageSecondLevelClass();
		pkg.displayData();

	}

	public void displayData() {
		System.out.println("************************************");
		System.out.println("Public this.c : " + c);
		System.out.println("Public this.c : " + b);

		TopLevelClass top = new TopLevelClass();
		System.out.println("TopLevelClass data : " + top.c);

	}

}
