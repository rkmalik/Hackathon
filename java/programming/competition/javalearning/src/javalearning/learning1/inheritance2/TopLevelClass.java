package javalearning.learning1.inheritance2;

public class TopLevelClass {

	private int a;
	protected int b;
	public int c;

	int d;

	{
		a = 11;
		b = 23;
		c = 34;
		d = 45;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public void display() {
		System.out.println(this.getClass().getName() + "\nPrivate : " + a + "\nprotected : " + b + "\npublic : " + c
				+ "\ndefault :" + d + "\n\n***********************************************");
	}

	public String toString() {
		return (this.getClass().getName() + "\nPrivate : " + a + "\nprotected : " + b + "\npublic : " + c
				+ "\ndefault :" + d + "\n\n***********************************************");
	}
}
