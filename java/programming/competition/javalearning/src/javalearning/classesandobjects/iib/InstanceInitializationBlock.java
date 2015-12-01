package javalearning.classesandobjects.iib;

public class InstanceInitializationBlock extends BaseInstanceInitialization {
	
	int data;
	
	{
		this.data = 15;
		System.out.println("IIB Block is called.");
	}
	
	public InstanceInitializationBlock (int data, int baseData, int baseData1) {
		super (baseData1);
		this.data = data;
		this.baseData = baseData;
		
	}

	public InstanceInitializationBlock (int data, int baseData) {
		this.data = data;
		this.baseData = baseData;
		System.out.println("Paramterised constructor is called.");
	}
	
	public int getData() {
		return data;
	}
	
	public int getBaseData() {
		return this.baseData;
	}

}
