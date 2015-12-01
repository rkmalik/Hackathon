package classesandobjects.iib;

public class BaseInstanceInitialization {
	
	private int baseData1;
	
	// Protected this can be accessed in the subclass of BaseInstanceInitialization
	int baseData;
	
	public BaseInstanceInitialization () {
		System.out.println("Base Class Constructor is called.");
		
	}
	
	public BaseInstanceInitialization (int baseData1) {
		System.out.println("Base Class Constructor is called.");
		this.baseData1 = baseData1;
	}
}
