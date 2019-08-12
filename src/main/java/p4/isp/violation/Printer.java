package p4.isp.violation;

public class Printer implements IMachine {

	public void print() {
		System.out.println("Printing");
	}

	public void scan() {
		throw new UnsupportedOperationException();
	}

	public void photoCopy() {
		throw new UnsupportedOperationException();
	}
}