package learning1.inheritance2;

public class FirstLevelClass extends TopLevelClass {

	/**
	 * Note: If I don't override this method here, it will invoke the
	 * TopLevelClass will call the whole mehtod.
	 */
	public String toString() {
		return (this.getClass().getName() + "\nprotected : " + b + "\npublic : " + c + "\ndefault :" + d
				+ "\n\n***********************************************");
	}
}
