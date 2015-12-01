package learning1.inheritance1;

import learning1.inheritance2.FirstLevelClass;
import learning1.inheritance2.TopLevelClass;

public class PackageSecondLevelClass extends FirstLevelClass {

	public void displayData() {
		System.out.println(
				"Protected: " + b + "\n\n" + "Public: " + c + "\n\n***********************************************");

		TopLevelClass top = new TopLevelClass();
		System.out.println("Without inheritance protected is not accessible here " + "\n\n" + "Public: " + c
				+ "\n\n***********************************************");

		System.out.println(
				"Protected memeber can not be used outside the package but they can be inherited by any subclass."
						+ "This class can be outside the package as well. This is the way to use the protected memebrs outside the class.");
	}
}
