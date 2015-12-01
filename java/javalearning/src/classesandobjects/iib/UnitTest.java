package classesandobjects.iib;

public class UnitTest {
	
	public static void main (String args []) {
		
		
		InstanceInitializationBlock iib = new InstanceInitializationBlock (100, 200, 300);
		System.out.println(iib.getData() + " BaseData " + iib.getBaseData());
	}

}
